package com.tencent.mm.aw;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.al.q;
import com.tencent.mm.app.n.a;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class o
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private n.a appForegroundListener;
  private g hja;
  private i hjb;
  private c hjc;
  private j hjd;
  private d hje;
  private h hjf;
  private b hjg;
  private p hjh;
  private com.tencent.mm.sdk.b.c hji;
  private com.tencent.mm.aw.a.a hjj;
  private SFSContext hjk;
  private SFSContext hjl;
  
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
    this.hjd = new j();
    this.hje = null;
    this.hjf = new h();
    this.hjg = null;
    this.hjh = null;
    this.hji = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(150747);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC()) {
            o.ayH().eh(false);
          }
        }
        AppMethodBeat.o(150747);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(150746);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            com.tencent.mm.blink.b.SX().v(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150745);
                o.ayD().run();
                AppMethodBeat.o(150745);
              }
            });
            o.ayH().eh(true);
          }
        }
        AppMethodBeat.o(150746);
      }
    };
    this.hjj = null;
    this.hjk = null;
    this.hjl = null;
    AppMethodBeat.o(150748);
  }
  
  private static o ayC()
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
  
  public static i ayD()
  {
    AppMethodBeat.i(150750);
    if (ayC().hjb == null) {
      ayC().hjb = new i();
    }
    i locali = ayC().hjb;
    AppMethodBeat.o(150750);
    return locali;
  }
  
  public static c ayE()
  {
    AppMethodBeat.i(150751);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ayC().hjc == null) {
      ayC().hjc = new c();
    }
    c localc = ayC().hjc;
    AppMethodBeat.o(150751);
    return localc;
  }
  
  public static g ayF()
  {
    AppMethodBeat.i(150752);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ayC().hja == null) {
      ayC().hja = new g(com.tencent.mm.kernel.g.afB().gda);
    }
    g localg = ayC().hja;
    AppMethodBeat.o(150752);
    return localg;
  }
  
  public static d ayG()
  {
    AppMethodBeat.i(150753);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ayC().hje == null) {
      ayC().hje = new d();
    }
    d locald = ayC().hje;
    AppMethodBeat.o(150753);
    return locald;
  }
  
  public static b ayH()
  {
    AppMethodBeat.i(150754);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ayC().hjg == null) {
      ayC().hjg = new b(Looper.getMainLooper());
    }
    b localb = ayC().hjg;
    AppMethodBeat.o(150754);
    return localb;
  }
  
  public static p ayI()
  {
    AppMethodBeat.i(150755);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ayC().hjh == null) {
      ayC().hjh = new p();
    }
    p localp = ayC().hjh;
    AppMethodBeat.o(150755);
    return localp;
  }
  
  public static com.tencent.mm.aw.a.a ayJ()
  {
    AppMethodBeat.i(150756);
    com.tencent.mm.kernel.g.afz().aeD();
    if (ayC().hjj == null) {
      ayC().hjj = com.tencent.mm.aw.a.a.ayO();
    }
    com.tencent.mm.aw.a.a locala = ayC().hjj;
    AppMethodBeat.o(150756);
    return locala;
  }
  
  public static SFSContext ayK()
  {
    return null;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150758);
    f.d.a(Integer.valueOf(3), this.hjf);
    f.d.a(Integer.valueOf(23), this.hjf);
    g.a.a("local_cdn_img_cache", this.hjd);
    com.tencent.mm.sdk.b.a.ESL.c(this.hji);
    this.appForegroundListener.alive();
    AppMethodBeat.o(150758);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150757);
    o localo = ayC();
    this.appForegroundListener.dead();
    if (localo.hjb != null)
    {
      ??? = localo.hjb;
      ((i)???).cZF = 0;
      com.tencent.mm.kernel.g.afA().gcy.b(110, (com.tencent.mm.al.g)???);
    }
    b localb;
    if (localo.hjg != null) {
      localb = localo.hjg;
    }
    synchronized (localb.hfI)
    {
      localb.hfI.clear();
      localb.hfJ = 0L;
      ayG().a(localb);
      com.tencent.mm.sdk.b.a.ESL.d(localb.hfS);
      com.tencent.mm.sdk.b.a.ESL.d(localb.hfT);
      if (localo.hje == null) {
        break label210;
      }
      ??? = localo.hje;
      ad.i("ModelImage.DownloadImgService", "on detach");
      ad.i("ModelImage.DownloadImgService", "cancel all net scene");
      ((d)???).hgc = true;
      ((d)???).b(((d)???).hga);
      if (((d)???).hfY.size() > 0) {
        ((d)???).b((d.b)((d)???).hfY.get(0));
      }
    }
    ((d)???).ayf();
    com.tencent.mm.kernel.g.afA().gcy.b(109, (com.tencent.mm.al.g)???);
    label210:
    if (localObject1.hjh != null)
    {
      ??? = localObject1.hjh;
      ad.i("MicroMsg.UrlImageCacheService", "detach");
      ((p)???).hjo.clear();
      ((p)???).hjq = true;
    }
    ??? = ayC().hja;
    if (??? != null)
    {
      ad.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[] { bt.eGN() });
      ((g)???).hgT.clear();
    }
    ??? = ayC().hjj;
    if (??? != null) {
      ((com.tencent.mm.aw.a.a)???).detach();
    }
    f.d.b(Integer.valueOf(3), this.hjf);
    f.d.b(Integer.valueOf(23), this.hjf);
    g.a.a("local_cdn_img_cache", null);
    com.tencent.mm.sdk.b.a.ESL.d(this.hji);
    if (localObject1.hjj != null)
    {
      localObject1.hjj.detach();
      localObject1.hjj = null;
    }
    if (localObject1.hjk != null)
    {
      localObject1.hjk.release();
      localObject1.hjk = null;
    }
    if (localObject1.hjl != null)
    {
      localObject1.hjl.release();
      localObject1.hjl = null;
    }
    AppMethodBeat.o(150757);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.o
 * JD-Core Version:    0.7.0.1
 */