package com.tencent.mm.modelimage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.app.q.a;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class r
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static byte[] oJx;
  private q.a appForegroundListener;
  private j oJl;
  private l oJm;
  private e oJn;
  private m oJo;
  private f oJp;
  private k oJq;
  private b oJr;
  private s oJs;
  private IListener oJt;
  private a oJu;
  private SFSContext oJv;
  private SFSContext oJw;
  
  static
  {
    AppMethodBeat.i(150759);
    oJx = new byte[0];
    baseDBFactories = new HashMap();
    Iterator localIterator = j.d.oHy.iterator();
    while (localIterator.hasNext())
    {
      j.c localc = (j.c)localIterator.next();
      baseDBFactories.put(Integer.valueOf(localc.table.hashCode()), new h.b()
      {
        public final String[] getSQLs()
        {
          return r.this.oHv;
        }
      });
    }
    AppMethodBeat.o(150759);
  }
  
  public r()
  {
    AppMethodBeat.i(150748);
    this.oJo = new m();
    this.oJp = null;
    this.oJq = new k();
    this.oJr = null;
    this.oJs = null;
    this.oJt = new SubCoreImage.1(this, com.tencent.mm.app.f.hfK);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(150747);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG()) {
            r.bKc().setForeground(false);
          }
        }
        AppMethodBeat.o(150747);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(150746);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            com.tencent.mm.blink.b.aJY().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(150745);
                r.bJY().run();
                AppMethodBeat.o(150745);
              }
            });
            r.bKc().setForeground(true);
          }
        }
        AppMethodBeat.o(150746);
      }
    };
    this.oJu = null;
    this.oJv = null;
    this.oJw = null;
    AppMethodBeat.o(150748);
  }
  
  private static r bJX()
  {
    AppMethodBeat.i(150749);
    synchronized (oJx)
    {
      r localr = (r)y.aL(r.class);
      AppMethodBeat.o(150749);
      return localr;
    }
  }
  
  public static l bJY()
  {
    AppMethodBeat.i(150750);
    if (bJX().oJm == null) {
      bJX().oJm = new l();
    }
    l locall = bJX().oJm;
    AppMethodBeat.o(150750);
    return locall;
  }
  
  public static e bJZ()
  {
    AppMethodBeat.i(150751);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bJX().oJn == null) {
      bJX().oJn = new e();
    }
    e locale = bJX().oJn;
    AppMethodBeat.o(150751);
    return locale;
  }
  
  public static j bKa()
  {
    AppMethodBeat.i(150752);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bJX().oJl == null) {
      bJX().oJl = new j(com.tencent.mm.kernel.h.baE().mCN);
    }
    j localj = bJX().oJl;
    AppMethodBeat.o(150752);
    return localj;
  }
  
  public static f bKb()
  {
    AppMethodBeat.i(150753);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bJX().oJp == null) {
      bJX().oJp = new f();
    }
    f localf = bJX().oJp;
    AppMethodBeat.o(150753);
    return localf;
  }
  
  public static b bKc()
  {
    AppMethodBeat.i(150754);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bJX().oJr == null) {
      bJX().oJr = new b(Looper.getMainLooper());
    }
    b localb = bJX().oJr;
    AppMethodBeat.o(150754);
    return localb;
  }
  
  public static s bKd()
  {
    AppMethodBeat.i(150755);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bJX().oJs == null) {
      bJX().oJs = new s();
    }
    s locals = bJX().oJs;
    AppMethodBeat.o(150755);
    return locals;
  }
  
  public static a bKe()
  {
    AppMethodBeat.i(150756);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bJX().oJu == null) {
      bJX().oJu = a.bKl();
    }
    a locala = bJX().oJu;
    AppMethodBeat.o(150756);
    return locala;
  }
  
  public static SFSContext bKf()
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
    g.d.a(Integer.valueOf(3), this.oJq);
    g.d.a(Integer.valueOf(23), this.oJq);
    g.a.a("local_cdn_img_cache", this.oJo);
    this.oJt.alive();
    this.appForegroundListener.alive();
    AppMethodBeat.o(150758);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150757);
    r localr = bJX();
    this.appForegroundListener.dead();
    if (localr.oJm != null)
    {
      ??? = localr.oJm;
      ((l)???).hxJ = 0;
      com.tencent.mm.kernel.h.baD().mCm.b(110, (com.tencent.mm.am.h)???);
    }
    b localb;
    if (localr.oJr != null) {
      localb = localr.oJr;
    }
    synchronized (localb.oFK)
    {
      localb.oFK.clear();
      localb.oFL = 0L;
      bKb().a(localb);
      localb.oFU.dead();
      localb.oFV.dead();
      if (localr.oJp != null)
      {
        ??? = localr.oJp;
        Log.i("ModelImage.DownloadImgService", "on detach");
        Log.i("ModelImage.DownloadImgService", "cancel all net scene");
        ((f)???).oGk = true;
        ((f)???).b(((f)???).oGi);
        if (((f)???).oGg.size() > 0) {
          ((f)???).b((f.b)((f)???).oGg.get(0));
        }
      }
    }
    if (localObject1.oJs != null)
    {
      ??? = localObject1.oJs;
      Log.i("MicroMsg.UrlImageCacheService", "detach");
      if (!MMHandlerThread.isMainThread()) {
        break label390;
      }
      ((s)???).bKg();
    }
    for (;;)
    {
      ??? = bJX().oJl;
      if (??? != null)
      {
        Log.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[] { Util.getStack() });
        ((j)???).oHa.clear();
      }
      ??? = bJX().oJu;
      if (??? != null) {
        ((a)???).detach();
      }
      g.d.b(Integer.valueOf(3), this.oJq);
      g.d.b(Integer.valueOf(23), this.oJq);
      g.a.a("local_cdn_img_cache", null);
      this.oJt.dead();
      if (localObject1.oJu != null)
      {
        localObject1.oJu.detach();
        localObject1.oJu = null;
      }
      if (localObject1.oJv != null)
      {
        localObject1.oJv.release();
        localObject1.oJv = null;
      }
      if (localObject1.oJw != null)
      {
        localObject1.oJw.release();
        localObject1.oJw = null;
      }
      AppMethodBeat.o(150757);
      return;
      label390:
      com.tencent.threadpool.h.ahAA.bk(new s.3((s)???));
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.r
 * JD-Core Version:    0.7.0.1
 */