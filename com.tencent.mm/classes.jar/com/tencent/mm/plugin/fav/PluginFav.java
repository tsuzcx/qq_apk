package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.g.c.hv;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ai;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;
import java.util.Map;

public class PluginFav
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, af
{
  private o.a appForegroundListener;
  private com.tencent.mm.plugin.fav.b.e.e rAa;
  private com.tencent.mm.plugin.fav.b.e.d rAb;
  private com.tencent.mm.plugin.fav.b.e.a rAc;
  private com.tencent.mm.plugin.fav.b.e.b rAd;
  private com.tencent.mm.plugin.fav.b.e.c rAe;
  private com.tencent.mm.plugin.fav.b.b.a rAf;
  private com.tencent.mm.plugin.fav.b.b.b rAg;
  private com.tencent.mm.sdk.b.c rAh;
  private a rzR;
  private x rzS;
  private com.tencent.mm.plugin.fav.a.q rzT;
  private aa rzU;
  private t rzV;
  private com.tencent.mm.plugin.fav.a.s rzW;
  private l rzX;
  private final int rzY;
  private final int rzZ;
  
  public PluginFav()
  {
    AppMethodBeat.i(101539);
    this.rzY = 26214400;
    this.rzZ = 25;
    this.rAf = new com.tencent.mm.plugin.fav.b.b.a();
    this.rAg = new com.tencent.mm.plugin.fav.b.b.b();
    this.rAh = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new PluginFav.5(this);
    AppMethodBeat.o(101539);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(101552);
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(com.tencent.mm.plugin.fav.a.b.cwj());
    if ((!localk.exists()) || (!localk.isDirectory()))
    {
      ae.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
      localk.mkdirs();
    }
    localk = new com.tencent.mm.vfs.k(com.tencent.mm.plugin.fav.a.b.cwc());
    if ((!localk.exists()) || (!localk.isDirectory()))
    {
      ae.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
      localk.mkdirs();
    }
    localk = new com.tencent.mm.vfs.k(com.tencent.mm.plugin.fav.a.b.cwi());
    if ((!localk.exists()) || (!localk.isDirectory()))
    {
      ae.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
      localk.mkdirs();
    }
    localk = new com.tencent.mm.vfs.k(com.tencent.mm.plugin.fav.a.b.cwk());
    if ((!localk.exists()) || (!localk.isDirectory()))
    {
      ae.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
      localk.mkdirs();
    }
    AppMethodBeat.o(101552);
  }
  
  public void checkFavItem(akq paramakq)
  {
    AppMethodBeat.i(101543);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101535);
        com.tencent.mm.kernel.g.ajj().a(this.rAj, 0);
        AppMethodBeat.o(101535);
      }
    });
    AppMethodBeat.o(101543);
  }
  
  public void checkFavItem(List<akd> paramList)
  {
    AppMethodBeat.i(101542);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101534);
        com.tencent.mm.kernel.g.ajj().a(this.rAj, 0);
        AppMethodBeat.o(101534);
      }
    });
    AppMethodBeat.o(101542);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.plugin.fav.b.e.b getCheckCdnService()
  {
    return this.rAd;
  }
  
  public com.tencent.mm.plugin.fav.b.e.c getEditService()
  {
    return this.rAe;
  }
  
  public com.tencent.mm.plugin.fav.b.e.a getFavCdnService()
  {
    return this.rAc;
  }
  
  public com.tencent.mm.plugin.fav.a.q getFavCdnStorage()
  {
    return this.rzT;
  }
  
  public com.tencent.mm.plugin.fav.a.s getFavConfigStorage()
  {
    return this.rzW;
  }
  
  public t getFavEditInfoStorage()
  {
    return this.rzV;
  }
  
  public x getFavItemInfoStorage()
  {
    return this.rzS;
  }
  
  public aa getFavSearchStorage()
  {
    return this.rzU;
  }
  
  public int getFavSizeLimit(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(101550);
    if (paramInt == 2)
    {
      paramInt = getImageSizeLimit(paramBoolean);
      AppMethodBeat.o(101550);
      return paramInt;
    }
    if (paramInt == 4)
    {
      paramInt = getVideoSizeLimit(paramBoolean);
      AppMethodBeat.o(101550);
      return paramInt;
    }
    paramInt = getFileSizeLimit(paramBoolean);
    AppMethodBeat.o(101550);
    return paramInt;
  }
  
  public int getFavSizeLimitInMB(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(101551);
    if (paramInt == 2)
    {
      paramInt = getImageSizeLimitInMB(paramBoolean);
      AppMethodBeat.o(101551);
      return paramInt;
    }
    if (paramInt == 4)
    {
      paramInt = getVideoSizeLimitInMB(paramBoolean);
      AppMethodBeat.o(101551);
      return paramInt;
    }
    paramInt = getFileSizeLimitInMB(paramBoolean);
    AppMethodBeat.o(101551);
    return paramInt;
  }
  
  public l getFavTagSetMgr()
  {
    return this.rzX;
  }
  
  public int getFileSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101544);
    int i = com.tencent.mm.n.b.act();
    AppMethodBeat.o(101544);
    return i;
  }
  
  public int getFileSizeLimitInMB(boolean paramBoolean)
  {
    AppMethodBeat.i(101545);
    int i = getFileSizeLimit(paramBoolean) / 1024 / 1024;
    AppMethodBeat.o(101545);
    return i;
  }
  
  public int getImageSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101548);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("InputLimitFavImageSize");
        if (bu.isNullOrNil(str)) {
          ae.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bu.getInt(str, 26214400);
          AppMethodBeat.o(101548);
          return i;
          ae.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101548);
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getImageSizeLimit", new Object[0]);
      }
    }
    return 26214400;
  }
  
  public int getImageSizeLimitInMB(boolean paramBoolean)
  {
    AppMethodBeat.i(101549);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("InputLimitFavImageSize");
        if (bu.isNullOrNil(str)) {
          ae.i("MicroMsg.Fav.PluginFav", "getImageSizeLimitInMB nullOrNil");
        }
        for (;;)
        {
          int i = bu.getInt(str, 26214400) / 1024 / 1024;
          AppMethodBeat.o(101549);
          return i;
          ae.i("MicroMsg.Fav.PluginFav", "getImageSizeLimitInMB ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101549);
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getImageSizeLimitInMB", new Object[0]);
      }
    }
    return 25;
  }
  
  public com.tencent.mm.plugin.fav.b.e.d getModService()
  {
    return this.rAb;
  }
  
  public ac getSendService()
  {
    return this.rAa;
  }
  
  public int getVideoSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101546);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("InputLimitFavVideoSize");
        if (bu.isNullOrNil(str)) {
          ae.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bu.getInt(str, 26214400);
          AppMethodBeat.o(101546);
          return i;
          ae.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101546);
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getVideoSizeLimit", new Object[0]);
      }
    }
    return 26214400;
  }
  
  public int getVideoSizeLimitInMB(boolean paramBoolean)
  {
    AppMethodBeat.i(101547);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("InputLimitFavVideoSize");
        if (bu.isNullOrNil(str)) {
          ae.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bu.getInt(str, 26214400) / 1024 / 1024;
          AppMethodBeat.o(101547);
          return i;
          ae.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101547);
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getVideoSizeLimitInMB", new Object[0]);
      }
    }
    return 25;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(101540);
    this.rzR = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("uploadfavitem", this.rzR);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("resendfavitem", this.rzR);
    this.rzS = new com.tencent.mm.plugin.fav.b.f.d(hv.Wi());
    this.rzT = new com.tencent.mm.plugin.fav.b.f.a(hv.Wi());
    this.rzU = new com.tencent.mm.plugin.fav.b.f.e(hv.Wi());
    this.rzV = new com.tencent.mm.plugin.fav.b.f.c(hv.Wi());
    this.rzW = new com.tencent.mm.plugin.fav.b.f.b(hv.Wi());
    this.rAa = new com.tencent.mm.plugin.fav.b.e.e();
    this.rAb = new com.tencent.mm.plugin.fav.b.e.d();
    this.rAc = new com.tencent.mm.plugin.fav.b.e.a();
    this.rAd = new com.tencent.mm.plugin.fav.b.e.b();
    this.rAe = new com.tencent.mm.plugin.fav.b.e.c();
    this.rzX = new l();
    ae.i("MicroMsg.Fav.PluginFav", "init fav storage");
    ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a()
    {
      public final boolean execute()
      {
        AppMethodBeat.i(101533);
        Object localObject = new com.tencent.mm.plugin.fav.b.a.a();
        ((n)com.tencent.mm.kernel.g.ad(n.class)).registerIndexStorage((i)localObject);
        ((i)localObject).create();
        localObject = new com.tencent.mm.plugin.fav.b.a.b();
        ((n)com.tencent.mm.kernel.g.ad(n.class)).registerNativeLogic(6, (com.tencent.mm.plugin.fts.a.k)localObject);
        ((com.tencent.mm.plugin.fts.a.k)localObject).create();
        AppMethodBeat.o(101533);
        return true;
      }
      
      public final String getName()
      {
        return "InitFTSFavPluginTask";
      }
    });
    this.rAh.alive();
    this.rAf.alive();
    this.appForegroundListener.alive();
    this.rAg.alive();
    checkDir();
    AppMethodBeat.o(101540);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(101541);
    this.rAh.dead();
    this.rAf.dead();
    this.rAg.dead();
    this.appForegroundListener.dead();
    ai.cwX();
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterIndexStorage(256);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterNativeLogic(6);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("uploadfavitem", this.rzR);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("resendfavitem", this.rzR);
    this.rzR = null;
    Object localObject;
    if (this.rAa != null)
    {
      localObject = this.rAa;
      ae.i("MicroMsg.Fav.FavSendService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).Qd();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).djz.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).dju = 0;
      com.tencent.mm.kernel.g.ajj().b(401, (com.tencent.mm.ak.f)localObject);
      this.rAa = null;
    }
    if (this.rAb != null)
    {
      localObject = this.rAb;
      ae.i("MicroMsg.Fav.FavModService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).Qd();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).djz.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).dju = 0;
      com.tencent.mm.kernel.g.ajj().b(426, (com.tencent.mm.ak.f)localObject);
      this.rAb = null;
    }
    if (this.rAc != null)
    {
      localObject = this.rAc;
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).Qd();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).djz.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).dju = 0;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().b(((com.tencent.mm.plugin.fav.b.e.a)localObject).hWv);
      this.rAc = null;
    }
    if (this.rAd != null)
    {
      localObject = this.rAd;
      ae.i("MicroMsg.Fav.FavCheckCdnService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).Qd();
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).djz.stopTimer();
      com.tencent.mm.kernel.g.ajj().b(404, (com.tencent.mm.ak.f)localObject);
      com.tencent.mm.kernel.g.ajQ().b(((com.tencent.mm.plugin.fav.b.e.b)localObject).hWv);
      this.rAd = null;
    }
    if (this.rAe != null)
    {
      localObject = this.rAe;
      ae.i("MicroMsg.Fav.FavEditService", "stop");
      com.tencent.mm.kernel.g.ajj().b(426, (com.tencent.mm.ak.f)localObject);
      com.tencent.mm.kernel.g.ajj().b(401, (com.tencent.mm.ak.f)localObject);
      ((com.tencent.mm.plugin.fav.b.e.c)localObject).rCJ.clear();
      this.rAe = null;
    }
    this.rzS = null;
    this.rzT = null;
    this.rzU = null;
    this.rzV = null;
    this.rzW = null;
    this.rzX = null;
    ae.i("MicroMsg.Fav.PluginFav", "release fav storage");
    AppMethodBeat.o(101541);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav
 * JD-Core Version:    0.7.0.1
 */