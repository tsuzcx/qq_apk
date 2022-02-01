package com.tencent.mm.plugin.card.mgr;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class l
  implements com.tencent.mm.am.h, b.a
{
  private MMHandler handler;
  public Map<String, Set<a>> wss;
  public HashMap<String, String> wst;
  private String wsu;
  public v wsv;
  
  public l()
  {
    AppMethodBeat.i(112704);
    this.wss = new HashMap();
    this.wst = new HashMap();
    com.tencent.mm.kernel.h.baD().mCm.a(1058, this);
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(112704);
  }
  
  private void a(final String paramString, final boolean paramBoolean, final ArrayList<wl> paramArrayList)
  {
    AppMethodBeat.i(112706);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112703);
        synchronized (l.a(l.this))
        {
          Object localObject2 = (Set)l.a(l.this).get(paramString);
          if ((localObject2 != null) && (((Set)localObject2).size() > 0))
          {
            ??? = new HashSet();
            ((Set)???).addAll((Collection)localObject2);
            ??? = ((Set)???).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (l.a)((Iterator)???).next();
              if (localObject2 != null) {
                ((l.a)localObject2).a(paramBoolean, paramArrayList);
              }
            }
          }
        }
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
      synchronized (this.wss)
      {
        if (this.wss.get(paramString) != null) {
          ((Set)this.wss.get(paramString)).remove(???);
        }
      }
      synchronized (this.wst)
      {
        this.wst.remove(paramString);
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
    this.wsu = paramString1;
    synchronized (this.wss)
    {
      if (!this.wss.containsKey(paramString1)) {
        this.wss.put(paramString1, new HashSet());
      }
      if (!((Set)this.wss.get(paramString1)).contains(???)) {
        ((Set)this.wss.get(paramString1)).add(???);
      }
    }
    for (;;)
    {
      synchronized (this.wst)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.wst.put(paramString1, paramString2);
        }
        paramString1 = d.bJl();
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
      paramString1.a(this, true, false);
      com.tencent.mm.plugin.report.service.l.kK(22, 10);
      int i = 1;
    }
    if (this.wsv != null) {
      com.tencent.mm.kernel.h.baD().mCm.a(this.wsv);
    }
    AppMethodBeat.o(112707);
    return true;
  }
  
  public final boolean onGetLocation(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(293766);
    if (!paramBoolean)
    {
      AppMethodBeat.o(293766);
      return true;
    }
    ??? = d.bJl();
    if (??? != null) {
      ((b)???).a(this);
    }
    Log.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    synchronized (this.wss)
    {
      Set localSet = (Set)this.wss.get(this.wsu);
      if ((localSet == null) || (localSet.size() == 0))
      {
        Log.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
        AppMethodBeat.o(293766);
        return false;
      }
    }
    for (;;)
    {
      synchronized (this.wst)
      {
        String str = (String)this.wst.get(this.wsu);
        ??? = new v(this.wsu, paramFloat1, paramFloat2, str);
        if (com.tencent.mm.kernel.h.baD().mCm.a((p)???, 0))
        {
          this.wsv = ((v)???);
          AppMethodBeat.o(293766);
          return true;
        }
      }
      Log.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
      a(this.wsu, false, null);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(112708);
    this.wsv = null;
    paramString = ((v)paramp).wuF;
    Log.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
      a(paramString, false, null);
      AppMethodBeat.o(112708);
      return;
    }
    paramp = ((v)paramp).wuG;
    if (paramp == null) {}
    for (paramInt1 = 0;; paramInt1 = paramp.size())
    {
      Log.d("MicroMsg.CardShopLBSManager", "onSceneEnd, respShopList size = %d", new Object[] { Integer.valueOf(paramInt1) });
      a(paramString, true, paramp);
      AppMethodBeat.o(112708);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, ArrayList<wl> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.l
 * JD-Core Version:    0.7.0.1
 */