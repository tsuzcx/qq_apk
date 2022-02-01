package com.tencent.mm.plugin.card.b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class m
  implements i, b.a
{
  private MMHandler handler;
  public Map<String, Set<a>> pRR;
  public HashMap<String, String> pRS;
  private String pRT;
  public v pRU;
  
  public m()
  {
    AppMethodBeat.i(112704);
    this.pRR = new HashMap();
    this.pRS = new HashMap();
    g.aAg().hqi.a(1058, this);
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(112704);
  }
  
  private void a(final String paramString, final boolean paramBoolean, final ArrayList<us> paramArrayList)
  {
    AppMethodBeat.i(112706);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112703);
        synchronized (m.this.pRR)
        {
          Object localObject2 = (Set)m.this.pRR.get(paramString);
          if ((localObject2 != null) && (((Set)localObject2).size() > 0))
          {
            ??? = new HashSet();
            ((Set)???).addAll((Collection)localObject2);
            ??? = ((Set)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (m.a)((Iterator)???).next();
              if (localObject2 != null) {
                ((m.a)localObject2).a(paramBoolean, paramArrayList);
              }
            }
          }
        }
        AppMethodBeat.o(112703);
      }
    });
    AppMethodBeat.o(112706);
  }
  
  public final void a(String paramString, a arg2)
  {
    AppMethodBeat.i(112705);
    try
    {
      label45:
      synchronized (this.pRR)
      {
        if (this.pRR.get(paramString) != null) {
          ((Set)this.pRR.get(paramString)).remove(???);
        }
      }
      synchronized (this.pRS)
      {
        this.pRS.remove(paramString);
        AppMethodBeat.o(112705);
        return;
        paramString = finally;
        AppMethodBeat.o(112705);
        throw paramString;
      }
    }
    catch (Exception ???)
    {
      break label45;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, a arg3)
  {
    AppMethodBeat.i(112707);
    Log.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", new Object[] { paramString1, paramString2 });
    this.pRT = paramString1;
    synchronized (this.pRR)
    {
      if (!this.pRR.containsKey(paramString1)) {
        this.pRR.put(paramString1, new HashSet());
      }
      if (!((Set)this.pRR.get(paramString1)).contains(???)) {
        ((Set)this.pRR.get(paramString1)).add(???);
      }
    }
    for (;;)
    {
      synchronized (this.pRS)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.pRS.put(paramString1, paramString2);
        }
        paramString1 = d.bca();
        if (paramString1 == null)
        {
          Log.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
          i = 0;
          if (i != 0) {
            break;
          }
          Log.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
          AppMethodBeat.o(112707);
          return false;
          paramString1 = finally;
          AppMethodBeat.o(112707);
          throw paramString1;
        }
      }
      paramString1.b(this);
      int i = 1;
    }
    if (this.pRU != null) {
      g.aAg().hqi.a(this.pRU);
    }
    AppMethodBeat.o(112707);
    return true;
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(112709);
    if (!paramBoolean)
    {
      AppMethodBeat.o(112709);
      return true;
    }
    ??? = d.bca();
    if (??? != null) {
      ((com.tencent.mm.modelgeo.b)???).c(this);
    }
    Log.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    synchronized (this.pRR)
    {
      Set localSet = (Set)this.pRR.get(this.pRT);
      if ((localSet == null) || (localSet.size() == 0))
      {
        Log.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
        AppMethodBeat.o(112709);
        return false;
      }
    }
    for (;;)
    {
      synchronized (this.pRS)
      {
        String str = (String)this.pRS.get(this.pRT);
        ??? = new v(this.pRT, paramFloat1, paramFloat2, str);
        if (g.aAg().hqi.a((q)???, 0))
        {
          this.pRU = ((v)???);
          AppMethodBeat.o(112709);
          return true;
        }
      }
      Log.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
      a(this.pRT, false, null);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112708);
    this.pRU = null;
    paramString = ((v)paramq).pUf;
    Log.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
      a(paramString, false, null);
      AppMethodBeat.o(112708);
      return;
    }
    paramq = ((v)paramq).pUg;
    if (paramq == null) {}
    for (paramInt1 = 0;; paramInt1 = paramq.size())
    {
      Log.d("MicroMsg.CardShopLBSManager", "onSceneEnd, respShopList size = %d", new Object[] { Integer.valueOf(paramInt1) });
      a(paramString, true, paramq);
      AppMethodBeat.o(112708);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, ArrayList<us> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.m
 * JD-Core Version:    0.7.0.1
 */