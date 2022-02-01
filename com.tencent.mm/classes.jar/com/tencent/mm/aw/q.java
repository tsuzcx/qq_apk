package com.tencent.mm.aw;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.app.n.a;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class q
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private n.a appForegroundListener;
  private r icA;
  private c icB;
  private com.tencent.mm.aw.a.a icC;
  private SFSContext icD;
  private SFSContext icE;
  private i ict;
  private k icu;
  private d icv;
  private l icw;
  private e icx;
  private j icy;
  private b icz;
  
  static
  {
    AppMethodBeat.i(150759);
    baseDBFactories = new HashMap();
    Iterator localIterator = i.d.iaE.iterator();
    while (localIterator.hasNext())
    {
      i.c localc = (i.c)localIterator.next();
      baseDBFactories.put(Integer.valueOf(localc.table.hashCode()), new h.b()
      {
        public final String[] getSQLs()
        {
          return this.icH.iaB;
        }
      });
    }
    AppMethodBeat.o(150759);
  }
  
  public q()
  {
    AppMethodBeat.i(150748);
    this.icw = new l();
    this.icx = null;
    this.icy = new j();
    this.icz = null;
    this.icA = null;
    this.icB = new c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(150747);
        if ((g.ajx()) && (g.ajA().gAD))
        {
          g.ajA();
          if (!com.tencent.mm.kernel.a.aiE()) {
            q.aIH().eE(false);
          }
        }
        AppMethodBeat.o(150747);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(150746);
        if ((g.ajx()) && (g.ajA().gAD))
        {
          g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            com.tencent.mm.blink.b.Wi().w(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150745);
                q.aID().run();
                AppMethodBeat.o(150745);
              }
            });
            q.aIH().eE(true);
          }
        }
        AppMethodBeat.o(150746);
      }
    };
    this.icC = null;
    this.icD = null;
    this.icE = null;
    AppMethodBeat.o(150748);
  }
  
  private static q aIC()
  {
    try
    {
      AppMethodBeat.i(150749);
      q localq = (q)t.ap(q.class);
      AppMethodBeat.o(150749);
      return localq;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static k aID()
  {
    AppMethodBeat.i(150750);
    if (aIC().icu == null) {
      aIC().icu = new k();
    }
    k localk = aIC().icu;
    AppMethodBeat.o(150750);
    return localk;
  }
  
  public static d aIE()
  {
    AppMethodBeat.i(150751);
    g.ajA().aiF();
    if (aIC().icv == null) {
      aIC().icv = new d();
    }
    d locald = aIC().icv;
    AppMethodBeat.o(150751);
    return locald;
  }
  
  public static i aIF()
  {
    AppMethodBeat.i(150752);
    g.ajA().aiF();
    if (aIC().ict == null) {
      aIC().ict = new i(g.ajC().gBq);
    }
    i locali = aIC().ict;
    AppMethodBeat.o(150752);
    return locali;
  }
  
  public static e aIG()
  {
    AppMethodBeat.i(150753);
    g.ajA().aiF();
    if (aIC().icx == null) {
      aIC().icx = new e();
    }
    e locale = aIC().icx;
    AppMethodBeat.o(150753);
    return locale;
  }
  
  public static b aIH()
  {
    AppMethodBeat.i(150754);
    g.ajA().aiF();
    if (aIC().icz == null) {
      aIC().icz = new b(Looper.getMainLooper());
    }
    b localb = aIC().icz;
    AppMethodBeat.o(150754);
    return localb;
  }
  
  public static r aII()
  {
    AppMethodBeat.i(150755);
    g.ajA().aiF();
    if (aIC().icA == null) {
      aIC().icA = new r();
    }
    r localr = aIC().icA;
    AppMethodBeat.o(150755);
    return localr;
  }
  
  public static com.tencent.mm.aw.a.a aIJ()
  {
    AppMethodBeat.i(150756);
    g.ajA().aiF();
    if (aIC().icC == null) {
      aIC().icC = com.tencent.mm.aw.a.a.aIP();
    }
    com.tencent.mm.aw.a.a locala = aIC().icC;
    AppMethodBeat.o(150756);
    return locala;
  }
  
  public static SFSContext aIK()
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
    e.d.a(Integer.valueOf(3), this.icy);
    e.d.a(Integer.valueOf(23), this.icy);
    g.a.a("local_cdn_img_cache", this.icw);
    com.tencent.mm.sdk.b.a.IbL.c(this.icB);
    this.appForegroundListener.alive();
    AppMethodBeat.o(150758);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150757);
    q localq = aIC();
    this.appForegroundListener.dead();
    if (localq.icu != null)
    {
      ??? = localq.icu;
      ((k)???).dis = 0;
      g.ajB().gAO.b(110, (com.tencent.mm.al.f)???);
    }
    b localb;
    if (localq.icz != null) {
      localb = localq.icz;
    }
    synchronized (localb.hYS)
    {
      localb.hYS.clear();
      localb.hYT = 0L;
      aIG().a(localb);
      com.tencent.mm.sdk.b.a.IbL.d(localb.hZc);
      com.tencent.mm.sdk.b.a.IbL.d(localb.hZd);
      if (localq.icx == null) {
        break label212;
      }
      ??? = localq.icx;
      ad.i("ModelImage.DownloadImgService", "on detach");
      ad.i("ModelImage.DownloadImgService", "cancel all net scene");
      ((e)???).hZp = true;
      ((e)???).b(((e)???).hZn);
      if (((e)???).hZl.size() > 0) {
        ((e)???).b((e.b)((e)???).hZl.get(0));
      }
    }
    ((e)???).aId();
    g.ajB().gAO.b(109, (com.tencent.mm.al.f)???);
    label212:
    if (localObject1.icA != null)
    {
      ??? = localObject1.icA;
      ad.i("MicroMsg.UrlImageCacheService", "detach");
      ((r)???).icI.clear();
      ((r)???).icK = true;
    }
    ??? = aIC().ict;
    if (??? != null)
    {
      ad.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[] { bt.flS() });
      ((i)???).iag.clear();
    }
    ??? = aIC().icC;
    if (??? != null) {
      ((com.tencent.mm.aw.a.a)???).detach();
    }
    e.d.b(Integer.valueOf(3), this.icy);
    e.d.b(Integer.valueOf(23), this.icy);
    g.a.a("local_cdn_img_cache", null);
    com.tencent.mm.sdk.b.a.IbL.d(this.icB);
    if (localObject1.icC != null)
    {
      localObject1.icC.detach();
      localObject1.icC = null;
    }
    if (localObject1.icD != null)
    {
      localObject1.icD.release();
      localObject1.icD = null;
    }
    if (localObject1.icE != null)
    {
      localObject1.icE.release();
      localObject1.icE = null;
    }
    AppMethodBeat.o(150757);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.q
 * JD-Core Version:    0.7.0.1
 */