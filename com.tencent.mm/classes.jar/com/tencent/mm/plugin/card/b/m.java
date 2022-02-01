package com.tencent.mm.plugin.card.b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class m
  implements com.tencent.mm.al.g, b.a
{
  private ap handler;
  public Map<String, Set<a>> nrl;
  public HashMap<String, String> nrm;
  private String nrn;
  public v nro;
  
  public m()
  {
    AppMethodBeat.i(112704);
    this.nrl = new HashMap();
    this.nrm = new HashMap();
    com.tencent.mm.kernel.g.afA().gcy.a(1058, this);
    this.handler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(112704);
  }
  
  private void a(final String paramString, final boolean paramBoolean, final ArrayList<rh> paramArrayList)
  {
    AppMethodBeat.i(112706);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112703);
        synchronized (m.this.nrl)
        {
          Object localObject2 = (Set)m.this.nrl.get(paramString);
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
      synchronized (this.nrl)
      {
        if (this.nrl.get(paramString) != null) {
          ((Set)this.nrl.get(paramString)).remove(???);
        }
      }
      synchronized (this.nrm)
      {
        this.nrm.remove(paramString);
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
    ad.d("MicroMsg.CardShopLBSManager", "getShopList, cardTpId = %s, card_id = %s", new Object[] { paramString1, paramString2 });
    this.nrn = paramString1;
    synchronized (this.nrl)
    {
      if (!this.nrl.containsKey(paramString1)) {
        this.nrl.put(paramString1, new HashSet());
      }
      if (!((Set)this.nrl.get(paramString1)).contains(???)) {
        ((Set)this.nrl.get(paramString1)).add(???);
      }
    }
    for (;;)
    {
      synchronized (this.nrm)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.nrm.put(paramString1, paramString2);
        }
        paramString1 = d.axT();
        if (paramString1 == null)
        {
          ad.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
          i = 0;
          if (i != 0) {
            break;
          }
          ad.e("MicroMsg.CardShopLBSManager", "getShopList fail, get IGetLocation fail, plugin no loaded?");
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
    if (this.nro != null) {
      com.tencent.mm.kernel.g.afA().gcy.a(this.nro);
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
    ??? = d.axT();
    if (??? != null) {
      ((com.tencent.mm.modelgeo.b)???).c(this);
    }
    ad.d("MicroMsg.CardShopLBSManager", "onGetLocation, fLongitude = %f, fLatitude = %f, locType = %d, speed = %f, accuracy = %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    synchronized (this.nrl)
    {
      Set localSet = (Set)this.nrl.get(this.nrn);
      if ((localSet == null) || (localSet.size() == 0))
      {
        ad.e("MicroMsg.CardShopLBSManager", "onGetLocation, already cancelled, no need to doScene");
        AppMethodBeat.o(112709);
        return false;
      }
    }
    for (;;)
    {
      synchronized (this.nrm)
      {
        String str = (String)this.nrm.get(this.nrn);
        ??? = new v(this.nrn, paramFloat1, paramFloat2, str);
        if (com.tencent.mm.kernel.g.afA().gcy.a((n)???, 0))
        {
          this.nro = ((v)???);
          AppMethodBeat.o(112709);
          return true;
        }
      }
      ad.e("MicroMsg.CardShopLBSManager", "doScene fail, callback immediate");
      a(this.nrn, false, null);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112708);
    this.nro = null;
    paramString = ((v)paramn).ntD;
    ad.i("MicroMsg.CardShopLBSManager", "onSceneEnd, reqCardTpId = %s, errType = %d, errCode = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.CardShopLBSManager", "onSceneEnd, cardshoplbs fail");
      a(paramString, false, null);
      AppMethodBeat.o(112708);
      return;
    }
    paramn = ((v)paramn).ntE;
    if (paramn == null) {}
    for (paramInt1 = 0;; paramInt1 = paramn.size())
    {
      ad.d("MicroMsg.CardShopLBSManager", "onSceneEnd, respShopList size = %d", new Object[] { Integer.valueOf(paramInt1) });
      a(paramString, true, paramn);
      AppMethodBeat.o(112708);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, ArrayList<rh> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.m
 * JD-Core Version:    0.7.0.1
 */