package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.g.c.ht;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
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
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;
import java.util.Map;

public class PluginFav
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, af
{
  private n.a appForegroundListener;
  private a rrC;
  private x rrD;
  private com.tencent.mm.plugin.fav.a.q rrE;
  private aa rrF;
  private t rrG;
  private s rrH;
  private l rrI;
  private final int rrJ;
  private final int rrK;
  private final int rrL;
  private final int rrM;
  private com.tencent.mm.plugin.fav.b.e.e rrN;
  private com.tencent.mm.plugin.fav.b.e.d rrO;
  private com.tencent.mm.plugin.fav.b.e.a rrP;
  private com.tencent.mm.plugin.fav.b.e.b rrQ;
  private com.tencent.mm.plugin.fav.b.e.c rrR;
  private com.tencent.mm.plugin.fav.b.b.a rrS;
  private com.tencent.mm.plugin.fav.b.b.b rrT;
  private com.tencent.mm.sdk.b.c rrU;
  
  public PluginFav()
  {
    AppMethodBeat.i(101539);
    this.rrJ = 1073741824;
    this.rrK = 1024;
    this.rrL = 26214400;
    this.rrM = 25;
    this.rrS = new com.tencent.mm.plugin.fav.b.b.a();
    this.rrT = new com.tencent.mm.plugin.fav.b.b.b();
    this.rrU = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new PluginFav.5(this);
    AppMethodBeat.o(101539);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(101552);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.cuI());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      ad.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.cuB());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      ad.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.cuH());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      ad.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.cuJ());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      ad.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
      locale.mkdirs();
    }
    AppMethodBeat.o(101552);
  }
  
  public void checkFavItem(akg paramakg)
  {
    AppMethodBeat.i(101543);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101535);
        com.tencent.mm.kernel.g.aiU().a(this.rrW, 0);
        AppMethodBeat.o(101535);
      }
    });
    AppMethodBeat.o(101543);
  }
  
  public void checkFavItem(List<ajt> paramList)
  {
    AppMethodBeat.i(101542);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101534);
        com.tencent.mm.kernel.g.aiU().a(this.rrW, 0);
        AppMethodBeat.o(101534);
      }
    });
    AppMethodBeat.o(101542);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.plugin.fav.b.e.b getCheckCdnService()
  {
    return this.rrQ;
  }
  
  public com.tencent.mm.plugin.fav.b.e.c getEditService()
  {
    return this.rrR;
  }
  
  public com.tencent.mm.plugin.fav.b.e.a getFavCdnService()
  {
    return this.rrP;
  }
  
  public com.tencent.mm.plugin.fav.a.q getFavCdnStorage()
  {
    return this.rrE;
  }
  
  public s getFavConfigStorage()
  {
    return this.rrH;
  }
  
  public t getFavEditInfoStorage()
  {
    return this.rrG;
  }
  
  public x getFavItemInfoStorage()
  {
    return this.rrD;
  }
  
  public aa getFavSearchStorage()
  {
    return this.rrF;
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
    return this.rrI;
  }
  
  public int getFileSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101544);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("InputLimitFavFileSize");
        if (bt.isNullOrNil(str)) {
          ad.i("MicroMsg.Fav.PluginFav", "getFileSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bt.getInt(str, 1073741824);
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
    return 1073741824;
  }
  
  public int getFileSizeLimitInMB(boolean paramBoolean)
  {
    AppMethodBeat.i(101545);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("InputLimitFavFileSize");
        if (bt.isNullOrNil(str)) {
          ad.i("MicroMsg.Fav.PluginFav", "getFileSizeLimitInMB nullOrNil");
        }
        for (;;)
        {
          int i = bt.getInt(str, 1073741824) / 1024 / 1024;
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
    return 1024;
  }
  
  public int getImageSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101548);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("InputLimitFavImageSize");
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("InputLimitFavImageSize");
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
    return this.rrO;
  }
  
  public ac getSendService()
  {
    return this.rrN;
  }
  
  public int getVideoSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101546);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("InputLimitFavVideoSize");
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("InputLimitFavVideoSize");
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
    this.rrC = new a();
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("uploadfavitem", this.rrC);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("resendfavitem", this.rrC);
    this.rrD = new com.tencent.mm.plugin.fav.b.f.d(ht.Wa());
    this.rrE = new com.tencent.mm.plugin.fav.b.f.a(ht.Wa());
    this.rrF = new com.tencent.mm.plugin.fav.b.f.e(ht.Wa());
    this.rrG = new com.tencent.mm.plugin.fav.b.f.c(ht.Wa());
    this.rrH = new com.tencent.mm.plugin.fav.b.f.b(ht.Wa());
    this.rrN = new com.tencent.mm.plugin.fav.b.e.e();
    this.rrO = new com.tencent.mm.plugin.fav.b.e.d();
    this.rrP = new com.tencent.mm.plugin.fav.b.e.a();
    this.rrQ = new com.tencent.mm.plugin.fav.b.e.b();
    this.rrR = new com.tencent.mm.plugin.fav.b.e.c();
    this.rrI = new l();
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
    this.rrU.alive();
    this.rrS.alive();
    this.appForegroundListener.alive();
    this.rrT.alive();
    checkDir();
    AppMethodBeat.o(101540);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(101541);
    this.rrU.dead();
    this.rrS.dead();
    this.rrT.dead();
    this.appForegroundListener.dead();
    ai.cvw();
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterIndexStorage(256);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterNativeLogic(6);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("uploadfavitem", this.rrC);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("resendfavitem", this.rrC);
    this.rrC = null;
    Object localObject;
    if (this.rrN != null)
    {
      localObject = this.rrN;
      ad.i("MicroMsg.Fav.FavSendService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).Qe();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).dix.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).dis = 0;
      com.tencent.mm.kernel.g.aiU().b(401, (com.tencent.mm.al.f)localObject);
      this.rrN = null;
    }
    if (this.rrO != null)
    {
      localObject = this.rrO;
      ad.i("MicroMsg.Fav.FavModService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).Qe();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).dix.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).dis = 0;
      com.tencent.mm.kernel.g.aiU().b(426, (com.tencent.mm.al.f)localObject);
      this.rrO = null;
    }
    if (this.rrP != null)
    {
      localObject = this.rrP;
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).Qe();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).dix.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).dis = 0;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().b(((com.tencent.mm.plugin.fav.b.e.a)localObject).hTD);
      this.rrP = null;
    }
    if (this.rrQ != null)
    {
      localObject = this.rrQ;
      ad.i("MicroMsg.Fav.FavCheckCdnService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).Qe();
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).dix.stopTimer();
      com.tencent.mm.kernel.g.aiU().b(404, (com.tencent.mm.al.f)localObject);
      com.tencent.mm.kernel.g.ajB().b(((com.tencent.mm.plugin.fav.b.e.b)localObject).hTD);
      this.rrQ = null;
    }
    if (this.rrR != null)
    {
      localObject = this.rrR;
      ad.i("MicroMsg.Fav.FavEditService", "stop");
      com.tencent.mm.kernel.g.aiU().b(426, (com.tencent.mm.al.f)localObject);
      com.tencent.mm.kernel.g.aiU().b(401, (com.tencent.mm.al.f)localObject);
      ((com.tencent.mm.plugin.fav.b.e.c)localObject).rux.clear();
      this.rrR = null;
    }
    this.rrD = null;
    this.rrE = null;
    this.rrF = null;
    this.rrG = null;
    this.rrH = null;
    this.rrI = null;
    ad.i("MicroMsg.Fav.PluginFav", "release fav storage");
    AppMethodBeat.o(101541);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav
 * JD-Core Version:    0.7.0.1
 */