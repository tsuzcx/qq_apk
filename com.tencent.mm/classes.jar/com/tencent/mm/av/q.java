package com.tencent.mm.av;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.app.o.a;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class q
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private o.a appForegroundListener;
  private i ifm;
  private k ifn;
  private d ifo;
  private l ifp;
  private e ifq;
  private j ifr;
  private b ifs;
  private r ift;
  private c ifu;
  private com.tencent.mm.av.a.a ifv;
  private SFSContext ifw;
  private SFSContext ifx;
  
  static
  {
    AppMethodBeat.i(150759);
    baseDBFactories = new HashMap();
    Iterator localIterator = i.d.idw.iterator();
    while (localIterator.hasNext())
    {
      i.c localc = (i.c)localIterator.next();
      baseDBFactories.put(Integer.valueOf(localc.table.hashCode()), new h.b()
      {
        public final String[] getSQLs()
        {
          return this.ifA.idt;
        }
      });
    }
    AppMethodBeat.o(150759);
  }
  
  public q()
  {
    AppMethodBeat.i(150748);
    this.ifp = new l();
    this.ifq = null;
    this.ifr = new j();
    this.ifs = null;
    this.ift = null;
    this.ifu = new c() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(150747);
        if ((g.ajM()) && (g.ajP().gDk))
        {
          g.ajP();
          if (!com.tencent.mm.kernel.a.aiT()) {
            q.aIZ().eG(false);
          }
        }
        AppMethodBeat.o(150747);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(150746);
        if ((g.ajM()) && (g.ajP().gDk))
        {
          g.ajP();
          if (!com.tencent.mm.kernel.a.aiT())
          {
            com.tencent.mm.blink.b.Wq().u(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150745);
                q.aIV().run();
                AppMethodBeat.o(150745);
              }
            });
            q.aIZ().eG(true);
          }
        }
        AppMethodBeat.o(150746);
      }
    };
    this.ifv = null;
    this.ifw = null;
    this.ifx = null;
    AppMethodBeat.o(150748);
  }
  
  private static q aIU()
  {
    try
    {
      AppMethodBeat.i(150749);
      q localq = (q)u.ap(q.class);
      AppMethodBeat.o(150749);
      return localq;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static k aIV()
  {
    AppMethodBeat.i(150750);
    if (aIU().ifn == null) {
      aIU().ifn = new k();
    }
    k localk = aIU().ifn;
    AppMethodBeat.o(150750);
    return localk;
  }
  
  public static d aIW()
  {
    AppMethodBeat.i(150751);
    g.ajP().aiU();
    if (aIU().ifo == null) {
      aIU().ifo = new d();
    }
    d locald = aIU().ifo;
    AppMethodBeat.o(150751);
    return locald;
  }
  
  public static i aIX()
  {
    AppMethodBeat.i(150752);
    g.ajP().aiU();
    if (aIU().ifm == null) {
      aIU().ifm = new i(g.ajR().gDX);
    }
    i locali = aIU().ifm;
    AppMethodBeat.o(150752);
    return locali;
  }
  
  public static e aIY()
  {
    AppMethodBeat.i(150753);
    g.ajP().aiU();
    if (aIU().ifq == null) {
      aIU().ifq = new e();
    }
    e locale = aIU().ifq;
    AppMethodBeat.o(150753);
    return locale;
  }
  
  public static b aIZ()
  {
    AppMethodBeat.i(150754);
    g.ajP().aiU();
    if (aIU().ifs == null) {
      aIU().ifs = new b(Looper.getMainLooper());
    }
    b localb = aIU().ifs;
    AppMethodBeat.o(150754);
    return localb;
  }
  
  public static r aJa()
  {
    AppMethodBeat.i(150755);
    g.ajP().aiU();
    if (aIU().ift == null) {
      aIU().ift = new r();
    }
    r localr = aIU().ift;
    AppMethodBeat.o(150755);
    return localr;
  }
  
  public static com.tencent.mm.av.a.a aJb()
  {
    AppMethodBeat.i(150756);
    g.ajP().aiU();
    if (aIU().ifv == null) {
      aIU().ifv = com.tencent.mm.av.a.a.aJh();
    }
    com.tencent.mm.av.a.a locala = aIU().ifv;
    AppMethodBeat.o(150756);
    return locala;
  }
  
  public static SFSContext aJc()
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
    e.d.a(Integer.valueOf(3), this.ifr);
    e.d.a(Integer.valueOf(23), this.ifr);
    g.a.a("local_cdn_img_cache", this.ifp);
    com.tencent.mm.sdk.b.a.IvT.c(this.ifu);
    this.appForegroundListener.alive();
    AppMethodBeat.o(150758);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150757);
    q localq = aIU();
    this.appForegroundListener.dead();
    if (localq.ifn != null)
    {
      ??? = localq.ifn;
      ((k)???).dju = 0;
      g.ajQ().gDv.b(110, (com.tencent.mm.ak.f)???);
    }
    b localb;
    if (localq.ifs != null) {
      localb = localq.ifs;
    }
    synchronized (localb.ibK)
    {
      localb.ibK.clear();
      localb.ibL = 0L;
      aIY().a(localb);
      com.tencent.mm.sdk.b.a.IvT.d(localb.ibU);
      com.tencent.mm.sdk.b.a.IvT.d(localb.ibV);
      if (localq.ifq == null) {
        break label212;
      }
      ??? = localq.ifq;
      ae.i("ModelImage.DownloadImgService", "on detach");
      ae.i("ModelImage.DownloadImgService", "cancel all net scene");
      ((e)???).ich = true;
      ((e)???).b(((e)???).icf);
      if (((e)???).icd.size() > 0) {
        ((e)???).b((e.b)((e)???).icd.get(0));
      }
    }
    ((e)???).aIu();
    g.ajQ().gDv.b(109, (com.tencent.mm.ak.f)???);
    label212:
    if (localObject1.ift != null)
    {
      ??? = localObject1.ift;
      ae.i("MicroMsg.UrlImageCacheService", "detach");
      ((r)???).ifB.clear();
      ((r)???).ifD = true;
    }
    ??? = aIU().ifm;
    if (??? != null)
    {
      ae.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[] { bu.fpN() });
      ((i)???).icY.clear();
    }
    ??? = aIU().ifv;
    if (??? != null) {
      ((com.tencent.mm.av.a.a)???).detach();
    }
    e.d.b(Integer.valueOf(3), this.ifr);
    e.d.b(Integer.valueOf(23), this.ifr);
    g.a.a("local_cdn_img_cache", null);
    com.tencent.mm.sdk.b.a.IvT.d(this.ifu);
    if (localObject1.ifv != null)
    {
      localObject1.ifv.detach();
      localObject1.ifv = null;
    }
    if (localObject1.ifw != null)
    {
      localObject1.ifw.release();
      localObject1.ifw = null;
    }
    if (localObject1.ifx != null)
    {
      localObject1.ifx.release();
      localObject1.ifx = null;
    }
    AppMethodBeat.o(150757);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.q
 * JD-Core Version:    0.7.0.1
 */