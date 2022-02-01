package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.g.c.hf;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ai;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.age;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;
import java.util.Map;

public class PluginFav
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, af
{
  private n.a appForegroundListener;
  private a pYW;
  private x pYX;
  private com.tencent.mm.plugin.fav.a.q pYY;
  private aa pYZ;
  private t pZa;
  private s pZb;
  private l pZc;
  private final int pZd;
  private final int pZe;
  private com.tencent.mm.plugin.fav.b.e.e pZf;
  private com.tencent.mm.plugin.fav.b.e.d pZg;
  private com.tencent.mm.plugin.fav.b.e.a pZh;
  private com.tencent.mm.plugin.fav.b.e.b pZi;
  private com.tencent.mm.plugin.fav.b.e.c pZj;
  private com.tencent.mm.plugin.fav.b.b.a pZk;
  private com.tencent.mm.plugin.fav.b.b.b pZl;
  private com.tencent.mm.sdk.b.c pZm;
  
  public PluginFav()
  {
    AppMethodBeat.i(101539);
    this.pZd = 26214400;
    this.pZe = 25;
    this.pZk = new com.tencent.mm.plugin.fav.b.b.a();
    this.pZl = new com.tencent.mm.plugin.fav.b.b.b();
    this.pZm = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new PluginFav.5(this);
    AppMethodBeat.o(101539);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(101552);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.chw());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      ad.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.chp());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      ad.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.chv());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      ad.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.chx());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      ad.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
      locale.mkdirs();
    }
    AppMethodBeat.o(101552);
  }
  
  public void checkFavItem(agr paramagr)
  {
    AppMethodBeat.i(101543);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101535);
        com.tencent.mm.kernel.g.aeS().a(this.pZo, 0);
        AppMethodBeat.o(101535);
      }
    });
    AppMethodBeat.o(101543);
  }
  
  public void checkFavItem(List<age> paramList)
  {
    AppMethodBeat.i(101542);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101534);
        com.tencent.mm.kernel.g.aeS().a(this.pZo, 0);
        AppMethodBeat.o(101534);
      }
    });
    AppMethodBeat.o(101542);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.plugin.fav.b.e.b getCheckCdnService()
  {
    return this.pZi;
  }
  
  public com.tencent.mm.plugin.fav.b.e.c getEditService()
  {
    return this.pZj;
  }
  
  public com.tencent.mm.plugin.fav.b.e.a getFavCdnService()
  {
    return this.pZh;
  }
  
  public com.tencent.mm.plugin.fav.a.q getFavCdnStorage()
  {
    return this.pYY;
  }
  
  public s getFavConfigStorage()
  {
    return this.pZb;
  }
  
  public t getFavEditInfoStorage()
  {
    return this.pZa;
  }
  
  public x getFavItemInfoStorage()
  {
    return this.pYX;
  }
  
  public aa getFavSearchStorage()
  {
    return this.pYZ;
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
    return this.pZc;
  }
  
  public int getFileSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101544);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("InputLimitFavFileSize");
        if (bt.isNullOrNil(str)) {
          ad.i("MicroMsg.Fav.PluginFav", "getFileSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bt.getInt(str, 26214400);
          AppMethodBeat.o(101544);
          return i;
          ad.i("MicroMsg.Fav.PluginFav", "getFileSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101544);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getFileSizeLimit", new Object[0]);
      }
    }
    return 26214400;
  }
  
  public int getFileSizeLimitInMB(boolean paramBoolean)
  {
    AppMethodBeat.i(101545);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("InputLimitFavFileSize");
        if (bt.isNullOrNil(str)) {
          ad.i("MicroMsg.Fav.PluginFav", "getFileSizeLimitInMB nullOrNil");
        }
        for (;;)
        {
          int i = bt.getInt(str, 26214400) / 1024 / 1024;
          AppMethodBeat.o(101545);
          return i;
          ad.i("MicroMsg.Fav.PluginFav", "getFileSizeLimitInMB  ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101545);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getFileSizeLimitInMB", new Object[0]);
      }
    }
    return 25;
  }
  
  public int getImageSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101548);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("InputLimitFavImageSize");
        if (bt.isNullOrNil(str)) {
          ad.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bt.getInt(str, 26214400);
          AppMethodBeat.o(101548);
          return i;
          ad.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101548);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getImageSizeLimit", new Object[0]);
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("InputLimitFavImageSize");
        if (bt.isNullOrNil(str)) {
          ad.i("MicroMsg.Fav.PluginFav", "getImageSizeLimitInMB nullOrNil");
        }
        for (;;)
        {
          int i = bt.getInt(str, 26214400) / 1024 / 1024;
          AppMethodBeat.o(101549);
          return i;
          ad.i("MicroMsg.Fav.PluginFav", "getImageSizeLimitInMB ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101549);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getImageSizeLimitInMB", new Object[0]);
      }
    }
    return 25;
  }
  
  public com.tencent.mm.plugin.fav.b.e.d getModService()
  {
    return this.pZg;
  }
  
  public ac getSendService()
  {
    return this.pZf;
  }
  
  public int getVideoSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101546);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("InputLimitFavVideoSize");
        if (bt.isNullOrNil(str)) {
          ad.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bt.getInt(str, 26214400);
          AppMethodBeat.o(101546);
          return i;
          ad.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101546);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getVideoSizeLimit", new Object[0]);
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("InputLimitFavVideoSize");
        if (bt.isNullOrNil(str)) {
          ad.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bt.getInt(str, 26214400) / 1024 / 1024;
          AppMethodBeat.o(101547);
          return i;
          ad.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101547);
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getVideoSizeLimitInMB", new Object[0]);
      }
    }
    return 25;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(101540);
    this.pYW = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("uploadfavitem", this.pYW);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("resendfavitem", this.pYW);
    this.pYX = new com.tencent.mm.plugin.fav.b.f.d(hf.SP());
    this.pYY = new com.tencent.mm.plugin.fav.b.f.a(hf.SP());
    this.pYZ = new com.tencent.mm.plugin.fav.b.f.e(hf.SP());
    this.pZa = new com.tencent.mm.plugin.fav.b.f.c(hf.SP());
    this.pZb = new com.tencent.mm.plugin.fav.b.f.b(hf.SP());
    this.pZf = new com.tencent.mm.plugin.fav.b.e.e();
    this.pZg = new com.tencent.mm.plugin.fav.b.e.d();
    this.pZh = new com.tencent.mm.plugin.fav.b.e.a();
    this.pZi = new com.tencent.mm.plugin.fav.b.e.b();
    this.pZj = new com.tencent.mm.plugin.fav.b.e.c();
    this.pZc = new l();
    ad.i("MicroMsg.Fav.PluginFav", "init fav storage");
    ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a()
    {
      public final boolean execute()
      {
        AppMethodBeat.i(101533);
        Object localObject = new com.tencent.mm.plugin.fav.b.a.a();
        ((n)com.tencent.mm.kernel.g.ad(n.class)).registerIndexStorage((i)localObject);
        ((i)localObject).create();
        localObject = new com.tencent.mm.plugin.fav.b.a.b();
        ((n)com.tencent.mm.kernel.g.ad(n.class)).registerNativeLogic(6, (k)localObject);
        ((k)localObject).create();
        AppMethodBeat.o(101533);
        return true;
      }
      
      public final String getName()
      {
        return "InitFTSFavPluginTask";
      }
    });
    this.pZm.alive();
    this.pZk.alive();
    this.appForegroundListener.alive();
    this.pZl.alive();
    checkDir();
    AppMethodBeat.o(101540);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(101541);
    this.pZm.dead();
    this.pZk.dead();
    this.pZl.dead();
    this.appForegroundListener.dead();
    ai.cik();
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterIndexStorage(256);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterNativeLogic(6);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("uploadfavitem", this.pYW);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("resendfavitem", this.pYW);
    this.pYW = null;
    Object localObject;
    if (this.pZf != null)
    {
      localObject = this.pZf;
      ad.i("MicroMsg.Fav.FavSendService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).Oy();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).cZK.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).cZF = 0;
      com.tencent.mm.kernel.g.aeS().b(401, (com.tencent.mm.al.g)localObject);
      this.pZf = null;
    }
    if (this.pZg != null)
    {
      localObject = this.pZg;
      ad.i("MicroMsg.Fav.FavModService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).Oy();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).cZK.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).cZF = 0;
      com.tencent.mm.kernel.g.aeS().b(426, (com.tencent.mm.al.g)localObject);
      this.pZg = null;
    }
    if (this.pZh != null)
    {
      localObject = this.pZh;
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).Oy();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).cZK.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).cZF = 0;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().b(((com.tencent.mm.plugin.fav.b.e.a)localObject).haH);
      this.pZh = null;
    }
    if (this.pZi != null)
    {
      localObject = this.pZi;
      ad.i("MicroMsg.Fav.FavCheckCdnService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).Oy();
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).cZK.stopTimer();
      com.tencent.mm.kernel.g.aeS().b(404, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.afA().b(((com.tencent.mm.plugin.fav.b.e.b)localObject).haH);
      this.pZi = null;
    }
    if (this.pZj != null)
    {
      localObject = this.pZj;
      ad.i("MicroMsg.Fav.FavEditService", "stop");
      com.tencent.mm.kernel.g.aeS().b(426, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(401, (com.tencent.mm.al.g)localObject);
      ((com.tencent.mm.plugin.fav.b.e.c)localObject).qbP.clear();
      this.pZj = null;
    }
    this.pYX = null;
    this.pYY = null;
    this.pYZ = null;
    this.pZa = null;
    this.pZb = null;
    this.pZc = null;
    ad.i("MicroMsg.Fav.PluginFav", "release fav storage");
    AppMethodBeat.o(101541);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav
 * JD-Core Version:    0.7.0.1
 */