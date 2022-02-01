package com.tencent.mm.plugin.fav;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.zq;
import com.tencent.mm.autogen.b.jo;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.model.listener.DelFavoriteItemListener;
import com.tencent.mm.plugin.fav.model.listener.FavNotifyListener;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.vfs.af;
import java.util.List;
import java.util.Map;
import kotlin.a.p;
import kotlin.j;

public class PluginFav
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, ah
{
  private a AbI;
  private y AbJ;
  private r AbK;
  private ac AbL;
  private com.tencent.mm.plugin.fav.a.u AbM;
  private t AbN;
  private l AbO;
  private final long AbP;
  private final int AbQ;
  private com.tencent.mm.plugin.fav.model.d.f AbR;
  private com.tencent.mm.plugin.fav.model.d.d AbS;
  private com.tencent.mm.plugin.fav.model.d.a AbT;
  private com.tencent.mm.plugin.fav.model.d.b AbU;
  private com.tencent.mm.plugin.fav.model.d.c AbV;
  private DelFavoriteItemListener AbW;
  private FavNotifyListener AbX;
  private IListener AbY;
  private q.a appForegroundListener;
  
  public PluginFav()
  {
    AppMethodBeat.i(101539);
    this.AbP = 26214400L;
    this.AbQ = 25;
    this.AbW = new DelFavoriteItemListener();
    this.AbX = new FavNotifyListener();
    this.AbY = new IListener(com.tencent.mm.app.f.hfK) {};
    this.appForegroundListener = new PluginFav.5(this);
    AppMethodBeat.o(101539);
  }
  
  private static void checkDir()
  {
    AppMethodBeat.i(101552);
    com.tencent.mm.vfs.u localu = new com.tencent.mm.vfs.u(com.tencent.mm.plugin.fav.a.b.dQd());
    if ((!localu.jKS()) || (!localu.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
      localu.jKY();
    }
    localu = new com.tencent.mm.vfs.u(com.tencent.mm.plugin.fav.a.b.dPW());
    if ((!localu.jKS()) || (!localu.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
      localu.jKY();
    }
    localu = new com.tencent.mm.vfs.u(com.tencent.mm.plugin.fav.a.b.dQc());
    if ((!localu.jKS()) || (!localu.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
      localu.jKY();
    }
    localu = new com.tencent.mm.vfs.u(com.tencent.mm.plugin.fav.a.b.dQe());
    if ((!localu.jKS()) || (!localu.isDirectory()))
    {
      Log.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
      localu.jKY();
    }
    AppMethodBeat.o(101552);
  }
  
  public void checkFavItem(ary paramary)
  {
    AppMethodBeat.i(101543);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101535);
        com.tencent.mm.kernel.h.aZW().a(this.Aca, 0);
        AppMethodBeat.o(101535);
      }
    });
    AppMethodBeat.o(101543);
  }
  
  public void checkFavItem(List<arl> paramList)
  {
    AppMethodBeat.i(101542);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(101534);
        com.tencent.mm.kernel.h.aZW().a(this.Aca, 0);
        AppMethodBeat.o(101534);
      }
    });
    AppMethodBeat.o(101542);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(274339);
    af.b("favorite", "favorite", 536870912L, 7776000000L, 131);
    AppMethodBeat.o(274339);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public List<com.tencent.mm.plugin.fav.a.g> getAllUploadFailItem()
  {
    AppMethodBeat.i(274348);
    Object localObject = (com.tencent.mm.plugin.fav.model.e.a.b)com.tencent.mm.plugin.ac.b.q(com.tencent.mm.plugin.fav.model.e.a.b.class);
    localObject = com.tencent.mm.plugin.fav.a.g.TABLE.selectAll().where((ISqlCondition)com.tencent.mm.plugin.fav.a.g.kiN.inNumber(p.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(11), Integer.valueOf(14), Integer.valueOf(16), Integer.valueOf(18) }))).log("MicroMsg.Fav.MvvmFavItemInfoStorage").build().multiQuery(((com.tencent.mm.plugin.fav.model.e.a.a)((com.tencent.mm.plugin.fav.model.e.a.b)localObject).AeU.getValue()).getDB(), com.tencent.mm.plugin.fav.a.g.class);
    AppMethodBeat.o(274348);
    return localObject;
  }
  
  public com.tencent.mm.plugin.fav.model.d.b getCheckCdnService()
  {
    return this.AbU;
  }
  
  public com.tencent.mm.plugin.fav.model.d.c getEditService()
  {
    return this.AbV;
  }
  
  public com.tencent.mm.plugin.fav.model.d.a getFavCdnService()
  {
    return this.AbT;
  }
  
  public r getFavCdnStorage()
  {
    return this.AbK;
  }
  
  public t getFavConfigStorage()
  {
    return this.AbN;
  }
  
  public com.tencent.mm.plugin.fav.a.u getFavEditInfoStorage()
  {
    return this.AbM;
  }
  
  public y getFavItemInfoStorage()
  {
    return this.AbJ;
  }
  
  public ac getFavSearchStorage()
  {
    return this.AbL;
  }
  
  public long getFavSizeLimit(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(274346);
    if (paramInt == 2)
    {
      l = getImageSizeLimit(paramBoolean);
      AppMethodBeat.o(274346);
      return l;
    }
    if (paramInt == 4)
    {
      l = getVideoSizeLimit(paramBoolean);
      AppMethodBeat.o(274346);
      return l;
    }
    long l = getFileSizeLimit(paramBoolean);
    AppMethodBeat.o(274346);
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
    return this.AbO;
  }
  
  public long getFileSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(274343);
    long l = com.tencent.mm.k.c.aRl();
    AppMethodBeat.o(274343);
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
    AppMethodBeat.i(274345);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("InputLimitFavImageSize");
        if (Util.isNullOrNil(str)) {
          Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit nullOrNil");
        }
        for (;;)
        {
          long l = Util.getLong(str, 26214400L);
          AppMethodBeat.o(274345);
          return l;
          Log.i("MicroMsg.Fav.PluginFav", "getImageSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(274345);
      }
      finally
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
  
  public com.tencent.mm.plugin.fav.model.d.d getModService()
  {
    return this.AbS;
  }
  
  public ae getSendService()
  {
    return this.AbR;
  }
  
  public long getVideoSizeLimit(boolean paramBoolean)
  {
    AppMethodBeat.i(274344);
    if (paramBoolean) {
      try
      {
        String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("InputLimitFavVideoSize");
        if (Util.isNullOrNil(str)) {
          Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit nullOrNil");
        }
        for (;;)
        {
          long l = Util.getLong(str, 26214400L);
          AppMethodBeat.o(274344);
          return l;
          Log.i("MicroMsg.Fav.PluginFav", "getVideoSizeLimit ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(274344);
      }
      finally
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
    this.AbI = new a();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("uploadfavitem", this.AbI);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("resendfavitem", this.AbI);
    this.AbJ = new com.tencent.mm.plugin.fav.model.e.d(jo.aJS());
    this.AbK = new com.tencent.mm.plugin.fav.model.e.a(jo.aJS());
    this.AbL = new com.tencent.mm.plugin.fav.model.e.e(jo.aJS());
    this.AbM = new com.tencent.mm.plugin.fav.model.e.c(jo.aJS());
    this.AbN = new com.tencent.mm.plugin.fav.model.e.b(jo.aJS());
    this.AbR = new com.tencent.mm.plugin.fav.model.d.f();
    this.AbS = new com.tencent.mm.plugin.fav.model.d.d();
    this.AbT = new com.tencent.mm.plugin.fav.model.d.a();
    this.AbU = new com.tencent.mm.plugin.fav.model.d.b();
    this.AbV = new com.tencent.mm.plugin.fav.model.d.c();
    this.AbO = new l();
    Log.i("MicroMsg.Fav.PluginFav", "init fav storage");
    ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.c()
    {
      public final boolean aXz()
      {
        AppMethodBeat.i(101533);
        Object localObject = new com.tencent.mm.plugin.fav.model.a.a();
        ((n)com.tencent.mm.kernel.h.az(n.class)).registerIndexStorage((i)localObject);
        ((i)localObject).create();
        localObject = new com.tencent.mm.plugin.fav.model.a.b();
        ((n)com.tencent.mm.kernel.h.az(n.class)).registerNativeLogic(6, (k)localObject);
        ((k)localObject).create();
        AppMethodBeat.o(101533);
        return true;
      }
      
      public final String getName()
      {
        return "InitFTSFavPluginTask";
      }
    });
    this.AbY.alive();
    this.AbW.alive();
    this.appForegroundListener.alive();
    this.AbX.alive();
    checkDir();
    com.tencent.mm.kernel.h.b(ab.class, com.tencent.mm.plugin.fav.model.d.e.AeM);
    AppMethodBeat.o(101540);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(101541);
    this.AbY.dead();
    this.AbW.dead();
    this.AbX.dead();
    this.appForegroundListener.dead();
    ak.dQS();
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterIndexStorage(256);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterNativeLogic(6);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("uploadfavitem", this.AbI);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("resendfavitem", this.AbI);
    this.AbI = null;
    Object localObject;
    if (this.AbR != null)
    {
      localObject = this.AbR;
      Log.i("MicroMsg.Fav.FavSendService", "stop");
      ((com.tencent.mm.plugin.fav.model.d.f)localObject).aHh();
      ((com.tencent.mm.plugin.fav.model.d.f)localObject).hxN.stopTimer();
      ((com.tencent.mm.plugin.fav.model.d.f)localObject).hxJ = 0;
      com.tencent.mm.kernel.h.aZW().b(401, (com.tencent.mm.am.h)localObject);
      this.AbR = null;
    }
    if (this.AbS != null)
    {
      localObject = this.AbS;
      Log.i("MicroMsg.Fav.FavModService", "stop");
      ((com.tencent.mm.plugin.fav.model.d.d)localObject).aHh();
      ((com.tencent.mm.plugin.fav.model.d.d)localObject).hxN.stopTimer();
      ((com.tencent.mm.plugin.fav.model.d.d)localObject).hxJ = 0;
      com.tencent.mm.kernel.h.aZW().b(426, (com.tencent.mm.am.h)localObject);
      this.AbS = null;
    }
    if (this.AbT != null)
    {
      localObject = this.AbT;
      ((com.tencent.mm.plugin.fav.model.d.a)localObject).aHh();
      ((com.tencent.mm.plugin.fav.model.d.a)localObject).hxN.stopTimer();
      ((com.tencent.mm.plugin.fav.model.d.a)localObject).hxJ = 0;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().b(((com.tencent.mm.plugin.fav.model.d.a)localObject).oAk);
      this.AbT = null;
    }
    if (this.AbU != null)
    {
      localObject = this.AbU;
      Log.i("MicroMsg.Fav.FavCheckCdnService", "stop");
      ((com.tencent.mm.plugin.fav.model.d.b)localObject).aHh();
      ((com.tencent.mm.plugin.fav.model.d.b)localObject).hxN.stopTimer();
      com.tencent.mm.kernel.h.aZW().b(404, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.baD().b(((com.tencent.mm.plugin.fav.model.d.b)localObject).oAk);
      this.AbU = null;
    }
    if (this.AbV != null)
    {
      localObject = this.AbV;
      Log.i("MicroMsg.Fav.FavEditService", "stop");
      com.tencent.mm.kernel.h.aZW().b(426, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(401, (com.tencent.mm.am.h)localObject);
      ((com.tencent.mm.plugin.fav.model.d.c)localObject).AeH.clear();
      this.AbV = null;
    }
    this.AbJ = null;
    this.AbK = null;
    this.AbL = null;
    this.AbM = null;
    this.AbN = null;
    this.AbO = null;
    Log.i("MicroMsg.Fav.PluginFav", "release fav storage");
    com.tencent.mm.kernel.h.ay(ab.class);
    AppMethodBeat.o(101541);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.PluginFav
 * JD-Core Version:    0.7.0.1
 */