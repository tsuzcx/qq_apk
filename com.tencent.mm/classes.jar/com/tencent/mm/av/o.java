package com.tencent.mm.av;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.app.n.a;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class o
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private n.a appForegroundListener;
  private g hJD;
  private i hJE;
  private c hJF;
  private j hJG;
  private d hJH;
  private h hJI;
  private b hJJ;
  private p hJK;
  private com.tencent.mm.sdk.b.c hJL;
  private com.tencent.mm.av.a.a hJM;
  private SFSContext hJN;
  private SFSContext hJO;
  
  static
  {
    AppMethodBeat.i(150759);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return g.SQL_CREATE;
      }
    });
    AppMethodBeat.o(150759);
  }
  
  public o()
  {
    AppMethodBeat.i(150748);
    this.hJG = new j();
    this.hJH = null;
    this.hJI = new h();
    this.hJJ = null;
    this.hJK = null;
    this.hJL = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(150747);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS()) {
            o.aFz().eC(false);
          }
        }
        AppMethodBeat.o(150747);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(150746);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS())
          {
            com.tencent.mm.blink.b.TR().w(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150745);
                o.aFv().run();
                AppMethodBeat.o(150745);
              }
            });
            o.aFz().eC(true);
          }
        }
        AppMethodBeat.o(150746);
      }
    };
    this.hJM = null;
    this.hJN = null;
    this.hJO = null;
    AppMethodBeat.o(150748);
  }
  
  public static p aFA()
  {
    AppMethodBeat.i(150755);
    com.tencent.mm.kernel.g.agP().afT();
    if (aFu().hJK == null) {
      aFu().hJK = new p();
    }
    p localp = aFu().hJK;
    AppMethodBeat.o(150755);
    return localp;
  }
  
  public static com.tencent.mm.av.a.a aFB()
  {
    AppMethodBeat.i(150756);
    com.tencent.mm.kernel.g.agP().afT();
    if (aFu().hJM == null) {
      aFu().hJM = com.tencent.mm.av.a.a.aFG();
    }
    com.tencent.mm.av.a.a locala = aFu().hJM;
    AppMethodBeat.o(150756);
    return locala;
  }
  
  public static SFSContext aFC()
  {
    return null;
  }
  
  private static o aFu()
  {
    try
    {
      AppMethodBeat.i(150749);
      o localo = (o)t.ap(o.class);
      AppMethodBeat.o(150749);
      return localo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static i aFv()
  {
    AppMethodBeat.i(150750);
    if (aFu().hJE == null) {
      aFu().hJE = new i();
    }
    i locali = aFu().hJE;
    AppMethodBeat.o(150750);
    return locali;
  }
  
  public static c aFw()
  {
    AppMethodBeat.i(150751);
    com.tencent.mm.kernel.g.agP().afT();
    if (aFu().hJF == null) {
      aFu().hJF = new c();
    }
    c localc = aFu().hJF;
    AppMethodBeat.o(150751);
    return localc;
  }
  
  public static g aFx()
  {
    AppMethodBeat.i(150752);
    com.tencent.mm.kernel.g.agP().afT();
    if (aFu().hJD == null) {
      aFu().hJD = new g(com.tencent.mm.kernel.g.agR().ghG);
    }
    g localg = aFu().hJD;
    AppMethodBeat.o(150752);
    return localg;
  }
  
  public static d aFy()
  {
    AppMethodBeat.i(150753);
    com.tencent.mm.kernel.g.agP().afT();
    if (aFu().hJH == null) {
      aFu().hJH = new d();
    }
    d locald = aFu().hJH;
    AppMethodBeat.o(150753);
    return locald;
  }
  
  public static b aFz()
  {
    AppMethodBeat.i(150754);
    com.tencent.mm.kernel.g.agP().afT();
    if (aFu().hJJ == null) {
      aFu().hJJ = new b(Looper.getMainLooper());
    }
    b localb = aFu().hJJ;
    AppMethodBeat.o(150754);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150758);
    f.d.a(Integer.valueOf(3), this.hJI);
    f.d.a(Integer.valueOf(23), this.hJI);
    g.a.a("local_cdn_img_cache", this.hJG);
    com.tencent.mm.sdk.b.a.GpY.c(this.hJL);
    this.appForegroundListener.alive();
    AppMethodBeat.o(150758);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150757);
    o localo = aFu();
    this.appForegroundListener.dead();
    if (localo.hJE != null)
    {
      ??? = localo.hJE;
      ((i)???).cXb = 0;
      com.tencent.mm.kernel.g.agQ().ghe.b(110, (com.tencent.mm.ak.g)???);
    }
    b localb;
    if (localo.hJJ != null) {
      localb = localo.hJJ;
    }
    synchronized (localb.hGl)
    {
      localb.hGl.clear();
      localb.hGm = 0L;
      aFy().a(localb);
      com.tencent.mm.sdk.b.a.GpY.d(localb.hGv);
      com.tencent.mm.sdk.b.a.GpY.d(localb.hGw);
      if (localo.hJH == null) {
        break label210;
      }
      ??? = localo.hJH;
      ac.i("ModelImage.DownloadImgService", "on detach");
      ac.i("ModelImage.DownloadImgService", "cancel all net scene");
      ((d)???).hGF = true;
      ((d)???).b(((d)???).hGD);
      if (((d)???).hGB.size() > 0) {
        ((d)???).b((d.b)((d)???).hGB.get(0));
      }
    }
    ((d)???).aEX();
    com.tencent.mm.kernel.g.agQ().ghe.b(109, (com.tencent.mm.ak.g)???);
    label210:
    if (localObject1.hJK != null)
    {
      ??? = localObject1.hJK;
      ac.i("MicroMsg.UrlImageCacheService", "detach");
      ((p)???).hJR.clear();
      ((p)???).hJT = true;
    }
    ??? = aFu().hJD;
    if (??? != null)
    {
      ac.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[] { bs.eWi() });
      ((g)???).hHw.clear();
    }
    ??? = aFu().hJM;
    if (??? != null) {
      ((com.tencent.mm.av.a.a)???).detach();
    }
    f.d.b(Integer.valueOf(3), this.hJI);
    f.d.b(Integer.valueOf(23), this.hJI);
    g.a.a("local_cdn_img_cache", null);
    com.tencent.mm.sdk.b.a.GpY.d(this.hJL);
    if (localObject1.hJM != null)
    {
      localObject1.hJM.detach();
      localObject1.hJM = null;
    }
    if (localObject1.hJN != null)
    {
      localObject1.hJN.release();
      localObject1.hJN = null;
    }
    if (localObject1.hJO != null)
    {
      localObject1.hJO.release();
      localObject1.hJO = null;
    }
    AppMethodBeat.o(150757);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.o
 * JD-Core Version:    0.7.0.1
 */