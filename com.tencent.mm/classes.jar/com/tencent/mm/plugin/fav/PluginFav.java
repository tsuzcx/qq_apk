package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.xx;
import com.tencent.mm.f.c.ir;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.aof;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.List;
import java.util.Map;

public class PluginFav
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, ag
{
  private o.a appForegroundListener;
  private y wFA;
  private r wFB;
  private com.tencent.mm.plugin.fav.a.ab wFC;
  private u wFD;
  private com.tencent.mm.plugin.fav.a.t wFE;
  private l wFF;
  private final long wFG;
  private final int wFH;
  private com.tencent.mm.plugin.fav.b.e.e wFI;
  private com.tencent.mm.plugin.fav.b.e.d wFJ;
  private com.tencent.mm.plugin.fav.b.e.a wFK;
  private com.tencent.mm.plugin.fav.b.e.b wFL;
  private com.tencent.mm.plugin.fav.b.e.c wFM;
  private com.tencent.mm.plugin.fav.b.b.a wFN;
  private com.tencent.mm.plugin.fav.b.b.b wFO;
  private IListener wFP;
  private a wFz;
  
  public PluginFav()
  {
    AppMethodBeat.i(101539);
    this.wFG = 26214400L;
    this.wFH = 25;
    this.wFN = new com.tencent.mm.plugin.fav.b.b.a();
    this.wFO = new com.tencent.mm.plugin.fav.b.b.b();
    this.wFP = new IListener() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(101538);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          com.tencent.mm.kernel.b.aGE();
        }
        AppMethodBeat.o(101538);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(101537);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          if (!com.tencent.mm.kernel.b.aGE()) {
            EventCenter.instance.publish(new xx());
          }
        }
        AppMethodBeat.o(101537);
      }
    };
    AppMethodBeat.o(101539);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(101552);
    q localq = new q(com.tencent.mm.plugin.fav.a.b.djs());
    if ((!localq.ifE()) || (!localq.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
      localq.ifL();
    }
    localq = new q(com.tencent.mm.plugin.fav.a.b.djl());
    if ((!localq.ifE()) || (!localq.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
      localq.ifL();
    }
    localq = new q(com.tencent.mm.plugin.fav.a.b.djr());
    if ((!localq.ifE()) || (!localq.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
      localq.ifL();
    }
    localq = new q(com.tencent.mm.plugin.fav.a.b.djt());
    if ((!localq.ifE()) || (!localq.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
      localq.ifL();
    }
    AppMethodBeat.o(101552);
  }
  
  public void checkFavItem(aof paramaof)
  {
    AppMethodBeat.i(101543);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101535);
        h.aGY().a(this.wFR, 0);
        AppMethodBeat.o(101535);
      }
    });
    AppMethodBeat.o(101543);
  }
  
  public void checkFavItem(List<ans> paramList)
  {
    AppMethodBeat.i(101542);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101534);
        h.aGY().a(this.wFR, 0);
        AppMethodBeat.o(101534);
      }
    });
    AppMethodBeat.o(101542);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(217208);
    com.tencent.mm.vfs.ab.a("favorite", "favorite", 536870912L, 7776000000L, 131);
    AppMethodBeat.o(217208);
  }
  
  public void execute(g paramg) {}
  
  public com.tencent.mm.plugin.fav.b.e.b getCheckCdnService()
  {
    return this.wFL;
  }
  
  public com.tencent.mm.plugin.fav.b.e.c getEditService()
  {
    return this.wFM;
  }
  
  public com.tencent.mm.plugin.fav.b.e.a getFavCdnService()
  {
    return this.wFK;
  }
  
  public r getFavCdnStorage()
  {
    return this.wFB;
  }
  
  public com.tencent.mm.plugin.fav.a.t getFavConfigStorage()
  {
    return this.wFE;
  }
  
  public u getFavEditInfoStorage()
  {
    return this.wFD;
  }
  
  public y getFavItemInfoStorage()
  {
    return this.wFA;
  }
  
  public com.tencent.mm.plugin.fav.a.ab getFavSearchStorage()
  {
    return this.wFC;
  }
  
  public long getFavSizeLimit(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(217221);
    if (paramInt == 2)
    {
      l = getImageSizeLimit(paramBoolean);
      AppMethodBeat.o(217221);
      return l;
    }
    if (paramInt == 4)
    {
      l = getVideoSizeLimit(paramBoolean);
      AppMethodBeat.o(217221);
      return l;
    }
    long l = getFileSizeLimit(paramBoolean);
    AppMethodBeat.o(217221);
    return l;
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
    return this.wFF;
  }
  
  public long getFileSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(217216);
    long l = com.tencent.mm.n.c.awL();
    AppMethodBeat.o(217216);
    return l;
  }
  
  public int getFileSizeLimitInMB(boolean paramBoolean)
  {
    AppMethodBeat.i(101545);
    int i = (int)(getFileSizeLimit(paramBoolean) / 1024L / 1024L);
    AppMethodBeat.o(101545);
    return i;
  }
  
  public long getImageSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(217220);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("InputLimitFavImageSize");
        if (Util.isNullOrNil(str)) {
          Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit nullOrNil");
        }
        for (;;)
        {
          long l = Util.getLong(str, 26214400L);
          AppMethodBeat.o(217220);
          return l;
          Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(217220);
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getImageSizeLimit", new Object[0]);
      }
    }
    return 26214400L;
  }
  
  public int getImageSizeLimitInMB(boolean paramBoolean)
  {
    AppMethodBeat.i(101549);
    int i = (int)(getImageSizeLimit(paramBoolean) / 1024L / 1024L);
    AppMethodBeat.o(101549);
    return i;
  }
  
  public com.tencent.mm.plugin.fav.b.e.d getModService()
  {
    return this.wFJ;
  }
  
  public ad getSendService()
  {
    return this.wFI;
  }
  
  public long getVideoSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(217219);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("InputLimitFavVideoSize");
        if (Util.isNullOrNil(str)) {
          Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
        }
        for (;;)
        {
          long l = Util.getLong(str, 26214400L);
          AppMethodBeat.o(217219);
          return l;
          Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(217219);
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getVideoSizeLimit", new Object[0]);
      }
    }
    return 26214400L;
  }
  
  public int getVideoSizeLimitInMB(boolean paramBoolean)
  {
    AppMethodBeat.i(101547);
    int i = (int)(getVideoSizeLimit(paramBoolean) / 1024L / 1024L);
    AppMethodBeat.o(101547);
    return i;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(101540);
    this.wFz = new a();
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("uploadfavitem", this.wFz);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("resendfavitem", this.wFz);
    this.wFA = new com.tencent.mm.plugin.fav.b.f.d(ir.apU());
    this.wFB = new com.tencent.mm.plugin.fav.b.f.a(ir.apU());
    this.wFC = new com.tencent.mm.plugin.fav.b.f.e(ir.apU());
    this.wFD = new com.tencent.mm.plugin.fav.b.f.c(ir.apU());
    this.wFE = new com.tencent.mm.plugin.fav.b.f.b(ir.apU());
    this.wFI = new com.tencent.mm.plugin.fav.b.e.e();
    this.wFJ = new com.tencent.mm.plugin.fav.b.e.d();
    this.wFK = new com.tencent.mm.plugin.fav.b.e.a();
    this.wFL = new com.tencent.mm.plugin.fav.b.e.b();
    this.wFM = new com.tencent.mm.plugin.fav.b.e.c();
    this.wFF = new l();
    Log.i("MicroMsg.Fav.PluginFav", "init fav storage");
    ((n)h.ag(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a()
    {
      public final boolean aEv()
      {
        AppMethodBeat.i(101533);
        Object localObject = new com.tencent.mm.plugin.fav.b.a.a();
        ((n)h.ag(n.class)).registerIndexStorage((com.tencent.mm.plugin.fts.a.i)localObject);
        ((com.tencent.mm.plugin.fts.a.i)localObject).create();
        localObject = new com.tencent.mm.plugin.fav.b.a.b();
        ((n)h.ag(n.class)).registerNativeLogic(6, (k)localObject);
        ((k)localObject).create();
        AppMethodBeat.o(101533);
        return true;
      }
      
      public final String getName()
      {
        return "InitFTSFavPluginTask";
      }
    });
    this.wFP.alive();
    this.wFN.alive();
    this.appForegroundListener.alive();
    this.wFO.alive();
    checkDir();
    AppMethodBeat.o(101540);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(101541);
    this.wFP.dead();
    this.wFN.dead();
    this.wFO.dead();
    this.appForegroundListener.dead();
    aj.dkh();
    ((n)h.ag(n.class)).unregisterIndexStorage(256);
    ((n)h.ag(n.class)).unregisterNativeLogic(6);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("uploadfavitem", this.wFz);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("resendfavitem", this.wFz);
    this.wFz = null;
    Object localObject;
    if (this.wFI != null)
    {
      localObject = this.wFI;
      Log.i("MicroMsg.Fav.FavSendService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).afk();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).fty.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).ftu = 0;
      h.aGY().b(401, (com.tencent.mm.an.i)localObject);
      this.wFI = null;
    }
    if (this.wFJ != null)
    {
      localObject = this.wFJ;
      Log.i("MicroMsg.Fav.FavModService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).afk();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).fty.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).ftu = 0;
      h.aGY().b(426, (com.tencent.mm.an.i)localObject);
      this.wFJ = null;
    }
    if (this.wFK != null)
    {
      localObject = this.wFK;
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).afk();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).fty.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).ftu = 0;
      h.aHH();
      h.aHF().b(((com.tencent.mm.plugin.fav.b.e.a)localObject).lHL);
      this.wFK = null;
    }
    if (this.wFL != null)
    {
      localObject = this.wFL;
      Log.i("MicroMsg.Fav.FavCheckCdnService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).afk();
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).fty.stopTimer();
      h.aGY().b(404, (com.tencent.mm.an.i)localObject);
      h.aHF().b(((com.tencent.mm.plugin.fav.b.e.b)localObject).lHL);
      this.wFL = null;
    }
    if (this.wFM != null)
    {
      localObject = this.wFM;
      Log.i("MicroMsg.Fav.FavEditService", "stop");
      h.aGY().b(426, (com.tencent.mm.an.i)localObject);
      h.aGY().b(401, (com.tencent.mm.an.i)localObject);
      ((com.tencent.mm.plugin.fav.b.e.c)localObject).wIt.clear();
      this.wFM = null;
    }
    this.wFA = null;
    this.wFB = null;
    this.wFC = null;
    this.wFD = null;
    this.wFE = null;
    this.wFF = null;
    Log.i("MicroMsg.Fav.PluginFav", "release fav storage");
    AppMethodBeat.o(101541);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav
 * JD-Core Version:    0.7.0.1
 */