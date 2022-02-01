package com.tencent.mm.plugin.fav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.wr;
import com.tencent.mm.g.c.ih;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ai;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.y;
import java.util.List;
import java.util.Map;

public class PluginFav
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, af
{
  private o.a appForegroundListener;
  private com.tencent.mm.plugin.fav.a.s sZA;
  private l sZB;
  private final int sZC;
  private final int sZD;
  private com.tencent.mm.plugin.fav.b.e.e sZE;
  private com.tencent.mm.plugin.fav.b.e.d sZF;
  private com.tencent.mm.plugin.fav.b.e.a sZG;
  private com.tencent.mm.plugin.fav.b.e.b sZH;
  private com.tencent.mm.plugin.fav.b.e.c sZI;
  private com.tencent.mm.plugin.fav.b.b.a sZJ;
  private com.tencent.mm.plugin.fav.b.b.b sZK;
  private IListener sZL;
  private a sZv;
  private x sZw;
  private q sZx;
  private aa sZy;
  private com.tencent.mm.plugin.fav.a.t sZz;
  
  public PluginFav()
  {
    AppMethodBeat.i(101539);
    this.sZC = 26214400;
    this.sZD = 25;
    this.sZJ = new com.tencent.mm.plugin.fav.b.b.a();
    this.sZK = new com.tencent.mm.plugin.fav.b.b.b();
    this.sZL = new IListener() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(101538);
        if ((com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
        {
          com.tencent.mm.kernel.g.aAf();
          com.tencent.mm.kernel.a.azj();
        }
        AppMethodBeat.o(101538);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(101537);
        if ((com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
        {
          com.tencent.mm.kernel.g.aAf();
          if (!com.tencent.mm.kernel.a.azj()) {
            EventCenter.instance.publish(new wr());
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
    o localo = new o(com.tencent.mm.plugin.fav.a.b.cUm());
    if ((!localo.exists()) || (!localo.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
      localo.mkdirs();
    }
    localo = new o(com.tencent.mm.plugin.fav.a.b.cUf());
    if ((!localo.exists()) || (!localo.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
      localo.mkdirs();
    }
    localo = new o(com.tencent.mm.plugin.fav.a.b.cUl());
    if ((!localo.exists()) || (!localo.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
      localo.mkdirs();
    }
    localo = new o(com.tencent.mm.plugin.fav.a.b.cUn());
    if ((!localo.exists()) || (!localo.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
      localo.mkdirs();
    }
    AppMethodBeat.o(101552);
  }
  
  public void checkFavItem(ane paramane)
  {
    AppMethodBeat.i(101543);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101535);
        com.tencent.mm.kernel.g.azz().a(this.sZN, 0);
        AppMethodBeat.o(101535);
      }
    });
    AppMethodBeat.o(101543);
  }
  
  public void checkFavItem(List<amr> paramList)
  {
    AppMethodBeat.i(101542);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101534);
        com.tencent.mm.kernel.g.azz().a(this.sZN, 0);
        AppMethodBeat.o(101534);
      }
    });
    AppMethodBeat.o(101542);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(198780);
    y.a("favorite", "favorite", 536870912L, 3);
    AppMethodBeat.o(198780);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.plugin.fav.b.e.b getCheckCdnService()
  {
    return this.sZH;
  }
  
  public com.tencent.mm.plugin.fav.b.e.c getEditService()
  {
    return this.sZI;
  }
  
  public com.tencent.mm.plugin.fav.b.e.a getFavCdnService()
  {
    return this.sZG;
  }
  
  public q getFavCdnStorage()
  {
    return this.sZx;
  }
  
  public com.tencent.mm.plugin.fav.a.s getFavConfigStorage()
  {
    return this.sZA;
  }
  
  public com.tencent.mm.plugin.fav.a.t getFavEditInfoStorage()
  {
    return this.sZz;
  }
  
  public x getFavItemInfoStorage()
  {
    return this.sZw;
  }
  
  public aa getFavSearchStorage()
  {
    return this.sZy;
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
    return this.sZB;
  }
  
  public int getFileSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101544);
    int i = com.tencent.mm.n.c.aqs();
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("InputLimitFavImageSize");
        if (Util.isNullOrNil(str)) {
          Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = Util.getInt(str, 26214400);
          AppMethodBeat.o(101548);
          return i;
          Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101548);
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getImageSizeLimit", new Object[0]);
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("InputLimitFavImageSize");
        if (Util.isNullOrNil(str)) {
          Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimitInMB nullOrNil");
        }
        for (;;)
        {
          int i = Util.getInt(str, 26214400) / 1024 / 1024;
          AppMethodBeat.o(101549);
          return i;
          Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimitInMB ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101549);
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getImageSizeLimitInMB", new Object[0]);
      }
    }
    return 25;
  }
  
  public com.tencent.mm.plugin.fav.b.e.d getModService()
  {
    return this.sZF;
  }
  
  public ac getSendService()
  {
    return this.sZE;
  }
  
  public int getVideoSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(101546);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("InputLimitFavVideoSize");
        if (Util.isNullOrNil(str)) {
          Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = Util.getInt(str, 26214400);
          AppMethodBeat.o(101546);
          return i;
          Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101546);
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getVideoSizeLimit", new Object[0]);
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
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("InputLimitFavVideoSize");
        if (Util.isNullOrNil(str)) {
          Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
        }
        for (;;)
        {
          int i = Util.getInt(str, 26214400) / 1024 / 1024;
          AppMethodBeat.o(101547);
          return i;
          Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(101547);
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.Fav.PluginFav", localThrowable, "getVideoSizeLimitInMB", new Object[0]);
      }
    }
    return 25;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(101540);
    this.sZv = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("uploadfavitem", this.sZv);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("resendfavitem", this.sZv);
    this.sZw = new com.tencent.mm.plugin.fav.b.f.d(ih.ajW());
    this.sZx = new com.tencent.mm.plugin.fav.b.f.a(ih.ajW());
    this.sZy = new com.tencent.mm.plugin.fav.b.f.e(ih.ajW());
    this.sZz = new com.tencent.mm.plugin.fav.b.f.c(ih.ajW());
    this.sZA = new com.tencent.mm.plugin.fav.b.f.b(ih.ajW());
    this.sZE = new com.tencent.mm.plugin.fav.b.e.e();
    this.sZF = new com.tencent.mm.plugin.fav.b.e.d();
    this.sZG = new com.tencent.mm.plugin.fav.b.e.a();
    this.sZH = new com.tencent.mm.plugin.fav.b.e.b();
    this.sZI = new com.tencent.mm.plugin.fav.b.e.c();
    this.sZB = new l();
    Log.i("MicroMsg.Fav.PluginFav", "init fav storage");
    ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a()
    {
      public final boolean execute()
      {
        AppMethodBeat.i(101533);
        Object localObject = new com.tencent.mm.plugin.fav.b.a.a();
        ((n)com.tencent.mm.kernel.g.ah(n.class)).registerIndexStorage((com.tencent.mm.plugin.fts.a.i)localObject);
        ((com.tencent.mm.plugin.fts.a.i)localObject).create();
        localObject = new com.tencent.mm.plugin.fav.b.a.b();
        ((n)com.tencent.mm.kernel.g.ah(n.class)).registerNativeLogic(6, (k)localObject);
        ((k)localObject).create();
        AppMethodBeat.o(101533);
        return true;
      }
      
      public final String getName()
      {
        return "InitFTSFavPluginTask";
      }
    });
    this.sZL.alive();
    this.sZJ.alive();
    this.appForegroundListener.alive();
    this.sZK.alive();
    checkDir();
    AppMethodBeat.o(101540);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(101541);
    this.sZL.dead();
    this.sZJ.dead();
    this.sZK.dead();
    this.appForegroundListener.dead();
    ai.cVb();
    ((n)com.tencent.mm.kernel.g.ah(n.class)).unregisterIndexStorage(256);
    ((n)com.tencent.mm.kernel.g.ah(n.class)).unregisterNativeLogic(6);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("uploadfavitem", this.sZv);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("resendfavitem", this.sZv);
    this.sZv = null;
    Object localObject;
    if (this.sZE != null)
    {
      localObject = this.sZE;
      Log.i("MicroMsg.Fav.FavSendService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).aax();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).dAJ.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.e)localObject).dAF = 0;
      com.tencent.mm.kernel.g.azz().b(401, (com.tencent.mm.ak.i)localObject);
      this.sZE = null;
    }
    if (this.sZF != null)
    {
      localObject = this.sZF;
      Log.i("MicroMsg.Fav.FavModService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).aax();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).dAJ.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.d)localObject).dAF = 0;
      com.tencent.mm.kernel.g.azz().b(426, (com.tencent.mm.ak.i)localObject);
      this.sZF = null;
    }
    if (this.sZG != null)
    {
      localObject = this.sZG;
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).aax();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).dAJ.stopTimer();
      ((com.tencent.mm.plugin.fav.b.e.a)localObject).dAF = 0;
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().b(((com.tencent.mm.plugin.fav.b.e.a)localObject).iRt);
      this.sZG = null;
    }
    if (this.sZH != null)
    {
      localObject = this.sZH;
      Log.i("MicroMsg.Fav.FavCheckCdnService", "stop");
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).aax();
      ((com.tencent.mm.plugin.fav.b.e.b)localObject).dAJ.stopTimer();
      com.tencent.mm.kernel.g.azz().b(404, (com.tencent.mm.ak.i)localObject);
      com.tencent.mm.kernel.g.aAg().b(((com.tencent.mm.plugin.fav.b.e.b)localObject).iRt);
      this.sZH = null;
    }
    if (this.sZI != null)
    {
      localObject = this.sZI;
      Log.i("MicroMsg.Fav.FavEditService", "stop");
      com.tencent.mm.kernel.g.azz().b(426, (com.tencent.mm.ak.i)localObject);
      com.tencent.mm.kernel.g.azz().b(401, (com.tencent.mm.ak.i)localObject);
      ((com.tencent.mm.plugin.fav.b.e.c)localObject).tco.clear();
      this.sZI = null;
    }
    this.sZw = null;
    this.sZx = null;
    this.sZy = null;
    this.sZz = null;
    this.sZA = null;
    this.sZB = null;
    Log.i("MicroMsg.Fav.PluginFav", "release fav storage");
    AppMethodBeat.o(101541);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav
 * JD-Core Version:    0.7.0.1
 */