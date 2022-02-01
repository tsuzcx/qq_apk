package com.tencent.mm.plugin.card.b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class m
  implements com.tencent.mm.ak.g, b.a
{
  private ao handler;
  public Map<String, Set<a>> nUl;
  public HashMap<String, String> nUm;
  private String nUn;
  public v nUo;
  
  public m()
  {
    AppMethodBeat.i(112704);
    this.nUl = new HashMap();
    this.nUm = new HashMap();
    com.tencent.mm.kernel.g.agQ().ghe.a(1058, this);
    this.handler = new ao(Looper.getMainLooper());
    AppMethodBeat.o(112704);
  }
  
  private void a(final String paramString, final boolean paramBoolean, final ArrayList<rr> paramArrayList)
  {
    AppMethodBeat.i(112706);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112703);
        synchronized (m.this.nUl)
        {
          Object localObject2 = (Set)m.this.nUl.get(paramString);
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
      synchronized (this.nUl)
      {
        if (this.nUl.get(paramString) != null) {
          ((Set)this.nUl.get(paramString)).remove(???);
        }
      }
      synchronized (this.nUm)
      {
        this.nUm.remove(paramString);
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
    ac.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", new Object[] { paramString1, paramString2 });
    this.nUn = paramString1;
    synchronized (this.nUl)
    {
      if (!this.nUl.containsKey(paramString1)) {
        this.nUl.put(paramString1, new HashSet());
      }
      if (!((Set)this.nUl.get(paramString1)).contains(???)) {
        ((Set)this.nUl.get(paramString1)).add(???);
      }
    }
    for (;;)
    {
      synchronized (this.nUm)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.nUm.put(paramString1, paramString2);
        }
        paramString1 = d.aEL();
        if (paramString1 == null)
        {
          ac.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
          i = 0;
          if (i != 0) {
            break;
          }
          ac.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
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
    if (this.nUo != null) {
      com.tencent.mm.kernel.g.agQ().ghe.a(this.nUo);
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
    ??? = d.aEL();
    if (??? != null) {
      ((com.tencent.mm.modelgeo.b)???).c(this);
    }
    ac.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    synchronized (this.nUl)
    {
      Set localSet = (Set)this.nUl.get(this.nUn);
      if ((localSet == null) || (localSet.size() == 0))
      {
        ac.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
        AppMethodBeat.o(112709);
        return false;
      }
    }
    for (;;)
    {
      synchronized (this.nUm)
      {
        String str = (String)this.nUm.get(this.nUn);
        ??? = new v(this.nUn, paramFloat1, paramFloat2, str);
        if (com.tencent.mm.kernel.g.agQ().ghe.a((n)???, 0))
        {
          this.nUo = ((v)???);
          AppMethodBeat.o(112709);
          return true;
        }
      }
      ac.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
      a(this.nUn, false, null);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112708);
    this.nUo = null;
    paramString = ((v)paramn).nWD;
    ac.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
      a(paramString, false, null);
      AppMethodBeat.o(112708);
      return;
    }
    paramn = ((v)paramn).nWE;
    if (paramn == null) {}
    for (paramInt1 = 0;; paramInt1 = paramn.size())
    {
      ac.d("MicroMsg.CardShopLBSManager", "onSceneEnd, respShopList size = %d", new Object[] { Integer.valueOf(paramInt1) });
      a(paramString, true, paramn);
      AppMethodBeat.o(112708);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, ArrayList<rr> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.m
 * JD-Core Version:    0.7.0.1
 */