package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.c.hj;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ai;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;
import java.util.Map;

public class PluginFav
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, af
{
  private n.a appForegroundListener;
  private a qHD;
  private x qHE;
  private com.tencent.mm.plugin.fav.a.q qHF;
  private aa qHG;
  private t qHH;
  private s qHI;
  private l qHJ;
  private final int qHK;
  private final int qHL;
  private com.tencent.mm.plugin.fav.b.e.e qHM;
  private com.tencent.mm.plugin.fav.b.e.d qHN;
  private com.tencent.mm.plugin.fav.b.e.a qHO;
  private com.tencent.mm.plugin.fav.b.e.b qHP;
  private com.tencent.mm.plugin.fav.b.e.c qHQ;
  private com.tencent.mm.plugin.fav.b.b.a qHR;
  private com.tencent.mm.plugin.fav.b.b.b qHS;
  private com.tencent.mm.sdk.b.c qHT;
  
  public PluginFav()
  {
    AppMethodBeat.i(101539);
    this.qHK = 26214400;
    this.qHL = 25;
    this.qHR = new com.tencent.mm.plugin.fav.b.b.a();
    this.qHS = new com.tencent.mm.plugin.fav.b.b.b();
    this.qHT = new PluginFav.4(this);
    this.appForegroundListener = new PluginFav.5(this);
    AppMethodBeat.o(101539);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(101552);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.cpd());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.coW());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.cpc());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
      locale.mkdirs();
    }
    locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.cpe());
    if ((!locale.exists()) || (!locale.isDirectory()))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
      locale.mkdirs();
    }
    AppMethodBeat.o(101552);
  }
  
  public void checkFavItem(ahq paramahq)
  {
    AppMethodBeat.i(101543);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101535);
        com.tencent.mm.kernel.g.agi().a(this.qHV, 0);
        AppMethodBeat.o(101535);
      }
    });
    AppMethodBeat.o(101543);
  }
  
  public void checkFavItem(List<ahd> paramList)
  {
    AppMethodBeat.i(101542);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101534);
        com.tencent.mm.kernel.g.agi().a(this.qHV, 0);
        AppMethodBeat.o(101534);
      }
    });
    AppMethodBeat.o(101542);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.plugin.fav.b.e.b getCheckCdnService()
  {
    return this.qHP;
  }
  
  public com.tencent.mm.plugin.fav.b.e.c getEditService()
  {
    return this.qHQ;
  }
  
  public com.tencent.mm.plugin.fav.b.e.a getFavCdnService()
  {
    return this.qHO;
  }
  
  public com.tencent.mm.plugin.fav.a.q getFavCdnStorage()
  {
    return this.qHF;
  }
  
  public s getFavConfigStorage()
  {
    return this.qHI;
  }
  
  public t getFavEditInfoStorage()
  {
    return this.qHH;
  }
  
  public x getFavItemInfoStorage()
  {
    return this.qHE;
  }
  
  public aa getFavSearchStorage()
  {
    return this.qHG;
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
    return this.qHJ;
  }
  
  public int getFileSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101544);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("InputLimitFavFileSize");
        if (bs.isNullOrNil(str)) {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getFileSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bs.getInt(str, 26214400);
          AppMethodBeat.o(101544);
          return i;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getFileSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101544);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getFileSizeLimit", new Object[0]);
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("InputLimitFavFileSize");
        if (bs.isNullOrNil(str)) {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getFileSizeLimitInMB nullOrNil");
        }
        for (;;)
        {
          int i = bs.getInt(str, 26214400) / 1024 / 1024;
          AppMethodBeat.o(101545);
          return i;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getFileSizeLimitInMB  ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101545);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getFileSizeLimitInMB", new Object[0]);
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("InputLimitFavImageSize");
        if (bs.isNullOrNil(str)) {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bs.getInt(str, 26214400);
          AppMethodBeat.o(101548);
          return i;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101548);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getImageSizeLimit", new Object[0]);
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("InputLimitFavImageSize");
        if (bs.isNullOrNil(str)) {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getImageSizeLimitInMB nullOrNil");
        }
        for (;;)
        {
          int i = bs.getInt(str, 26214400) / 1024 / 1024;
          AppMethodBeat.o(101549);
          return i;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getImageSizeLimitInMB ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101549);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getImageSizeLimitInMB", new Object[0]);
      }
    }
    return 25;
  }
  
  public com.tencent.mm.plugin.fav.b.e.d getModService()
  {
    return this.qHN;
  }
  
  public com.tencent.mm.plugin.fav.a.ac getSendService()
  {
    return this.qHM;
  }
  
  public int getVideoSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101546);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("InputLimitFavVideoSize");
        if (bs.isNullOrNil(str)) {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bs.getInt(str, 26214400);
          AppMethodBeat.o(101546);
          return i;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101546);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getVideoSizeLimit", new Object[0]);
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("InputLimitFavVideoSize");
        if (bs.isNullOrNil(str)) {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = bs.getInt(str, 26214400) / 1024 / 1024;
          AppMethodBeat.o(101547);
          return i;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101547);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getVideoSizeLimitInMB", new Object[0]);
      }
    }
    return 25;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(101540);
    this.qHD = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("uploadfavitem", this.qHD);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("resendfavitem", this.qHD);
    this.qHE = new com.tencent.mm.plugin.fav.b.f.d(hj.TJ());
    this.qHF = new com.tencent.mm.plugin.fav.b.f.a(hj.TJ());
    this.qHG = new com.tencent.mm.plugin.fav.b.f.e(hj.TJ());
    this.qHH = new com.tencent.mm.plugin.fav.b.f.c(hj.TJ());
    this.qHI = new com.tencent.mm.plugin.fav.b.f.b(hj.TJ());
    this.qHM = new com.tencent.mm.plugin.fav.b.e.e();
    this.qHN = new com.tencent.mm.plugin.fav.b.e.d();
    this.qHO = new com.tencent.mm.plugin.fav.b.e.a();
    this.qHP = new com.tencent.mm.plugin.fav.b.e.b();
    this.qHQ = new com.tencent.mm.plugin.fav.b.e.c();
    this.qHJ = new l();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "init fav storage");
    ((n)com.tencent.mm.kernel.g.ad(n.class)).getFTSTaskDaemon().a(-86016, new PluginFav.1(this));
    this.qHT.alive();
    this.qHR.alive();
    this.appForegroundListener.alive();
    this.qHS.alive();
    checkDir();
    AppMethodBeat.o(101540);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(101541);
    this.qHT.dead();
    this.qHR.dead();
    this.qHS.dead();
    this.appForegroundListener.dead();
    ai.cpR();
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterIndexStorage(256);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterNativeLogic(6);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("uploadfavitem", this.qHD);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("resendfavitem", this.qHD);
    this.qHD = null;
    Object localObject;
    if (this.qHM != null)
    {
      localObject = this.qHM;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavSendService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).Ou();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).cXg.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).cXb = 0;
      com.tencent.mm.kernel.g.agi().b(401, (com.tencent.mm.ak.g)localObject);
      this.qHM = null;
    }
    if (this.qHN != null)
    {
      localObject = this.qHN;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavModService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).Ou();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).cXg.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).cXb = 0;
      com.tencent.mm.kernel.g.agi().b(426, (com.tencent.mm.ak.g)localObject);
      this.qHN = null;
    }
    if (this.qHO != null)
    {
      localObject = this.qHO;
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).Ou();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).cXg.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).cXb = 0;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().b(((com.tencent.mm.plugin.fav.b.e.a)localObject).hBi);
      this.qHO = null;
    }
    if (this.qHP != null)
    {
      localObject = this.qHP;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavCheckCdnService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).Ou();
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).cXg.stopTimer();
      com.tencent.mm.kernel.g.agi().b(404, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agQ().b(((com.tencent.mm.plugin.fav.b.e.b)localObject).hBi);
      this.qHP = null;
    }
    if (this.qHQ != null)
    {
      localObject = this.qHQ;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.FavEditService", "stop");
      com.tencent.mm.kernel.g.agi().b(426, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(401, (com.tencent.mm.ak.g)localObject);
      ((com.tencent.mm.plugin.fav.b.e.c)localObject).qKv.clear();
      this.qHQ = null;
    }
    this.qHE = null;
    this.qHF = null;
    this.qHG = null;
    this.qHH = null;
    this.qHI = null;
    this.qHJ = null;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Fav.PluginFav", "release fav storage");
    AppMethodBeat.o(101541);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav
 * JD-Core Version:    0.7.0.1
 */