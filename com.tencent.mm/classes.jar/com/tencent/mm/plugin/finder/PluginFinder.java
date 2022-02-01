package com.tencent.mm.plugin.finder;

import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.storage.data.a.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import com.tencent.wcdb.database.SQLiteException;
import d.g.b.v.e;
import d.g.b.w;
import d.v;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder;", "Lcom/tencent/mm/kernel/api/ICoreStorageCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "CURRENT_DB_VERSION", "", "kotlin.jvm.PlatformType", "CURRENT_DB_VERSION_DEFAULT", "actionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "appForegroundListener", "com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "closeFinderEntryForDebug", "", "contactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1;", "feedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "finderActivity", "", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "", "finderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "finderMentionDB", "finderMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "finderSyncEventListener", "com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1;", "followTlSingleExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "getFollowTlSingleExecutor", "()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "followTlSingleExecutor$delegate", "Lkotlin/Lazy;", "isDoSomethingCompleted", "isFriendCache", "Ljava/util/concurrent/ConcurrentHashMap;", "lastFinderInitTime", "", "lock", "", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "mediaPreloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getMediaPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "mediaPreloadModel$delegate", "modifyBlackListService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "modifyFeedSettingService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "modifyLikeRecommendService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "modifyUserService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "needResetDb", "postManager", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "redDotCtrInfoStorage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "syncExtension", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "viewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "wxMentionDB", "wxMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "checkResetDb", "", "clearMentionDB", "clearReInit", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "Lkotlin/collections/HashMap;", "collectMentionDatabaseFactory", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "doFinderInit", "doPrepareUser", "doReInit", "reInitVersion", "reInitUsername", "doSomethingOnStart", "dumpAndMarkFinderFolder", "enterFinderPostUI", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "enterFinderProfileUI", "enterFinderShareFeedUI", "json", "enterFinderTimelineUI", "i", "enterFinderTopicUI", "execute", "getContactStorage", "getDB", "getFeedStorage", "getFinderActionStorage", "getFinderContactCache", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getMediaCacheStorage", "getMentionStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "localFlag", "getRedDotCtrInfoStorage", "getRedDotManager", "getViewModelStore", "isFriend", "username", "isInFinder", "loadImage", "url", "imageView", "Landroid/widget/ImageView;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onAppBackground", "activity", "onAppForeground", "onDataBaseClosed", "readOnlyDB", "onDataBaseOpened", "onEnterFinder", "finder", "onExitFinder", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportPostRedDot", "key", "requestAudioFocus", "resetConfig", "resetDb", "resetLastTimelineExitTime", "shareStatsReport", "feedIdList", "", "showFinderEntry", "showPostEntry", "Companion", "plugin-finder_release"})
public final class PluginFinder
  extends com.tencent.mm.kernel.b.f
  implements ViewModelStoreOwner, com.tencent.mm.al.g, com.tencent.mm.app.n, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.plugin.i.a.j
{
  public static final a qnF;
  private final ViewModelStore CE;
  private com.tencent.mm.storagebase.h KIV;
  private com.tencent.mm.storagebase.h KIW;
  private com.tencent.mm.plugin.finder.storage.u KIX;
  private com.tencent.mm.plugin.finder.storage.i KIY;
  private final com.tencent.mm.plugin.finder.cgi.oplog.e KIZ;
  private final d.f KJa;
  private final d.f KJb;
  private volatile boolean KJc;
  private long KJd;
  private com.tencent.mm.storagebase.h gda;
  private final byte[] lock;
  private volatile boolean qmV;
  private final com.tencent.mm.plugin.finder.upload.f qmX;
  private final com.tencent.mm.plugin.finder.extension.a qmY;
  private com.tencent.mm.plugin.finder.storage.c qmZ;
  private final ConcurrentHashMap<String, Boolean> qnE;
  private com.tencent.mm.plugin.finder.storage.e qna;
  private com.tencent.mm.plugin.finder.storage.g qnb;
  private com.tencent.mm.plugin.finder.extension.reddot.a qnc;
  private com.tencent.mm.plugin.finder.storage.a qne;
  private final com.tencent.mm.plugin.finder.cgi.oplog.c qnf;
  private final com.tencent.mm.plugin.finder.cgi.oplog.b qng;
  private final com.tencent.mm.plugin.finder.cgi.oplog.a qnh;
  private final com.tencent.mm.plugin.finder.api.a qni;
  private com.tencent.mm.plugin.finder.extension.reddot.c qnj;
  private final String qnl;
  private final String qnm;
  private final k qnn;
  private final j qnp;
  private final Set<MMFinderUI> qnq;
  private final com.tencent.mm.model.d qnr;
  private final b qns;
  private boolean qnt;
  
  static
  {
    AppMethodBeat.i(162442);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(PluginFinder.class), "followTlSingleExecutor", "getFollowTlSingleExecutor()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;")), (d.l.k)w.a(new d.g.b.u(w.bk(PluginFinder.class), "mediaPreloadModel", "getMediaPreloadModel()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;")) };
    qnF = new a((byte)0);
    AppMethodBeat.o(162442);
  }
  
  public PluginFinder()
  {
    AppMethodBeat.i(165123);
    this.lock = new byte[0];
    com.tencent.mm.plugin.finder.upload.f.a locala = com.tencent.mm.plugin.finder.upload.f.qRf;
    this.qmX = com.tencent.mm.plugin.finder.upload.f.crB();
    this.qmY = new com.tencent.mm.plugin.finder.extension.a();
    this.qnf = new com.tencent.mm.plugin.finder.cgi.oplog.c();
    this.KIZ = new com.tencent.mm.plugin.finder.cgi.oplog.e();
    this.qng = new com.tencent.mm.plugin.finder.cgi.oplog.b();
    this.qnh = new com.tencent.mm.plugin.finder.cgi.oplog.a();
    this.qni = new com.tencent.mm.plugin.finder.api.a();
    this.KJa = d.g.E((d.g.a.a)PluginFinder.m.KJf);
    this.qnl = ai.du("FinderMM029.dbFinderMention001.db");
    this.qnm = ai.du("FinderMM029.dbFinderMention001.db");
    this.KJb = d.g.E((d.g.a.a)p.KJg);
    this.qnn = new k(this);
    this.qnp = new j(this);
    this.qnq = Collections.synchronizedSet((Set)new HashSet());
    this.qnr = com.tencent.mm.model.d.aqs();
    this.qns = new b(this);
    this.qnE = new ConcurrentHashMap();
    this.CE = new ViewModelStore();
    AppMethodBeat.o(165123);
  }
  
  private final void checkResetDb()
  {
    AppMethodBeat.i(165077);
    ad.v("Finder.PluginFinder", "checkResetDb1 " + this.qmV);
    if (this.qmV)
    {
      ad.v("Finder.PluginFinder", "checkResetDb2 " + this.qmV);
      synchronized (this.lock)
      {
        Object localObject1 = new StringBuilder("checkResetDb  need reset DB now ");
        Thread localThread = Thread.currentThread();
        d.g.b.k.g(localThread, "Thread.currentThread()");
        localObject1 = ((StringBuilder)localObject1).append(localThread.getName()).append(" ");
        localThread = Thread.currentThread();
        d.g.b.k.g(localThread, "Thread.currentThread()");
        ad.i("Finder.PluginFinder", localThread.getId() + " " + hashCode());
        if (this.qmV)
        {
          resetDb();
          this.qmV = false;
          ad.i("Finder.PluginFinder", "resetDB done");
        }
        localObject1 = d.y.JfV;
        AppMethodBeat.o(165077);
        return;
      }
    }
    AppMethodBeat.o(165077);
  }
  
  private final void clearMentionDB()
  {
    AppMethodBeat.i(165079);
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).aff();
    com.tencent.mm.vfs.i.deleteFile((String)localObject + "FinderMention001.db");
    com.tencent.mm.vfs.i.deleteFile((String)localObject + "FinderMention002.db");
    this.KIV = null;
    this.KIW = null;
    AppMethodBeat.o(165079);
  }
  
  private final HashMap<Integer, h.b> collectMentionDatabaseFactory()
  {
    AppMethodBeat.i(165081);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FINDER_MENTION_TABLE".hashCode()), PluginFinder.h.qnM);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_WX_MENTION_TABLE".hashCode()), PluginFinder.l.KJe);
    AppMethodBeat.o(165081);
    return localHashMap;
  }
  
  private final void doFinderInit()
  {
    AppMethodBeat.i(165088);
    ad.i("Finder.PluginFinder", "[doFinderInit] ...");
    this.KJd = SystemClock.uptimeMillis();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).clearReInit();
    com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)new com.tencent.mm.plugin.finder.cgi.u());
    AppMethodBeat.o(165088);
  }
  
  private final void doPrepareUser()
  {
    AppMethodBeat.i(165091);
    com.tencent.mm.plugin.finder.cgi.y localy = new com.tencent.mm.plugin.finder.cgi.y(1);
    com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)localy);
    AppMethodBeat.o(165091);
  }
  
  private final void doReInit(int paramInt, String paramString)
  {
    AppMethodBeat.i(165090);
    try
    {
      com.tencent.mm.plugin.report.service.h.vKh.m(1279L, 21L, 1L);
      Object localObject = com.tencent.mm.plugin.finder.storage.data.d.qKq;
      com.tencent.mm.plugin.finder.storage.data.d.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.f.qKv;
      com.tencent.mm.plugin.finder.storage.data.f.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.a.qKk;
      a.a.clearAll();
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwq, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwr, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBk, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBl, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBm, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwn, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwo, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fxg, Integer.valueOf(paramInt));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FvW, paramString);
      paramString = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramString, "MMKernel.storage()");
      paramString.afk().set(ae.a.LBn, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramString, "MMKernel.storage()");
      paramString.afk().set(ae.a.LBo, Integer.valueOf(0));
      AppMethodBeat.o(165090);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("Finder.PluginFinder", (Throwable)paramString, "do ReInit occur error!", new Object[0]);
      com.tencent.mm.plugin.report.service.h.vKh.m(1279L, 22L, 1L);
      AppMethodBeat.o(165090);
    }
  }
  
  private final void doSomethingOnStart()
  {
    AppMethodBeat.i(165089);
    if (this.KJc)
    {
      AppMethodBeat.o(165089);
      return;
    }
    boolean bool = showFinderEntry();
    ad.i("Finder.PluginFinder", "[doSomethingOnStart] " + com.tencent.mm.model.u.aqO() + " isDoSomethingCompleted=" + this.KJc + ", isShowFinderEntry=" + bool);
    if (!bool)
    {
      AppMethodBeat.o(165089);
      return;
    }
    this.KJc = true;
    if (bt.isNullOrNil(com.tencent.mm.model.u.aqO()))
    {
      com.tencent.mm.kernel.g.aeS().a(3930, (com.tencent.mm.al.g)this);
      com.tencent.mm.kernel.g.aeS().a(3930, (com.tencent.mm.al.g)getRedDotManager());
      doFinderInit();
      this.qmY.fu(6653, 6);
    }
    for (;;)
    {
      getRedDotManager().prepare();
      AppMethodBeat.o(165089);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.m(1279L, 34L, 1L);
      Object localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.e)localObject).afk().getInt(ae.a.Fxg, 0);
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      int j = ((com.tencent.mm.kernel.e)localObject).afk().getInt(ae.a.Fxe, 0);
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.Fxf, "");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165089);
        throw ((Throwable)localObject);
      }
      localObject = (String)localObject;
      ad.i("Finder.PluginFinder", "doSomethingOnStart userVersion " + i + ", reInitUserVersion " + j + ", reInitUsername " + (String)localObject);
      if ((i != j) && (j != 0)) {
        doReInit(j, (String)localObject);
      }
      doPrepareUser();
      this.qmY.fu(7165, 6);
    }
  }
  
  private final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(165080);
    checkResetDb();
    com.tencent.mm.storagebase.h localh = this.gda;
    if (localh == null) {
      d.g.b.k.fvU();
    }
    AppMethodBeat.o(165080);
    return localh;
  }
  
  private final void requestAudioFocus()
  {
    AppMethodBeat.i(165098);
    this.qnr.a((com.tencent.mm.model.d.a)new o());
    AppMethodBeat.o(165098);
  }
  
  private final void resetDb()
  {
    AppMethodBeat.i(165078);
    Object localObject;
    com.tencent.mm.storagebase.h localh;
    if (this.gda == null)
    {
      this.gda = new com.tencent.mm.storagebase.h();
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).aff();
      localObject = (String)localObject + "FinderMM029.db";
      localh = this.gda;
      if (localh == null) {
        d.g.b.k.fvU();
      }
      if (!localh.b((String)localObject, collectDatabaseFactory(), true))
      {
        localObject = (Throwable)new SQLiteException("finder db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject);
      }
    }
    if (this.KIV == null)
    {
      this.KIV = new com.tencent.mm.storagebase.h();
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).aff();
      localObject = (String)localObject + "FinderMention001.db";
      localh = this.KIV;
      if (localh == null) {
        d.g.b.k.fvU();
      }
      if (!localh.b((String)localObject, collectMentionDatabaseFactory(), true))
      {
        localObject = (Throwable)new SQLiteException("finder finder mention db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject);
      }
    }
    if (this.KIW == null)
    {
      this.KIW = new com.tencent.mm.storagebase.h();
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).aff();
      localObject = (String)localObject + "FinderMention002.db";
      localh = this.KIW;
      if (localh == null) {
        d.g.b.k.fvU();
      }
      if (!localh.b((String)localObject, collectMentionDatabaseFactory(), true))
      {
        localObject = (Throwable)new SQLiteException("finder wx mention db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(165078);
  }
  
  public final void clearReInit()
  {
    AppMethodBeat.i(165094);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.afk().set(ae.a.Fxe, Integer.valueOf(0));
    locale = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.afk().set(ae.a.Fxf, "");
    AppMethodBeat.o(165094);
  }
  
  public final void closeFinderEntryForDebug()
  {
    this.qnt = true;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(162433);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_CONTACT_TABLE".hashCode()), c.qnH);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FEED_TABLE".hashCode()), d.qnI);
    ((Map)localHashMap).put(Integer.valueOf("FinderMediaCacheInfo".hashCode()), e.qnJ);
    ((Map)localHashMap).put(Integer.valueOf("FinderRedDotInfo".hashCode()), f.qnK);
    ((Map)localHashMap).put(Integer.valueOf("FinderAction".hashCode()), g.qnL);
    AppMethodBeat.o(162433);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(165092);
    o.b("finder", "finder", 7776000000L, 19, false);
    AppMethodBeat.o(165092);
  }
  
  public final void dumpAndMarkFinderFolder()
  {
    AppMethodBeat.i(165100);
    com.tencent.mm.ad.c.b(null, (d.g.a.a)i.qnN);
    AppMethodBeat.o(165100);
  }
  
  public final void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162439);
    d.g.b.k.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.qSb;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, paramIntent);
    AppMethodBeat.o(162439);
  }
  
  public final void enterFinderProfileUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162440);
    d.g.b.k.h(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    int i = com.tencent.mm.plugin.finder.storage.b.cpq();
    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prk, 0) == 1) || (i == 1)) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        ad.i("Finder.PluginFinder", "enterFinderShareFeedUI mustReturn true");
        AppMethodBeat.o(162440);
        return;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prM, 0) == 1) {
          i = 1;
        }
      }
      else
      {
        localObject = com.tencent.mm.plugin.finder.spam.a.qIC;
        if (com.tencent.mm.plugin.finder.spam.a.Zt("entrance") != 0)
        {
          paramIntent = com.tencent.mm.plugin.finder.utils.a.qSb;
          com.tencent.mm.plugin.finder.utils.a.eK(paramContext);
          AppMethodBeat.o(162440);
          return;
        }
        localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, paramIntent);
        com.tencent.mm.plugin.secinforeport.a.d.wcE.asyncReportFinderSecurityInfoThroughCgi(540999686);
        AppMethodBeat.o(162440);
        return;
      }
      i = 1;
    }
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162441);
    d.g.b.k.h(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.spam.a.qIC;
    if (com.tencent.mm.plugin.finder.spam.a.Zt("entrance") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.eK(paramContext);
      AppMethodBeat.o(162441);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
    com.tencent.mm.plugin.finder.utils.a.z(paramContext, paramIntent);
    com.tencent.mm.plugin.secinforeport.a.d.wcE.asyncReportFinderSecurityInfoThroughCgi(540999685);
    AppMethodBeat.o(162441);
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(197240);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramString, "json");
    try
    {
      paramString = new com.tencent.mm.ac.i(paramString);
      Object localObject = paramString.optString("feedId", "0");
      d.g.b.k.g(localObject, "jsonObject.optString(\"feedId\", \"0\")");
      long l = com.tencent.mm.ad.c.rc((String)localObject);
      paramString = paramString.qJ("extInfo");
      localObject = paramString.getString("feedNonceId");
      int i = paramString.optInt("reportScene", 13);
      String str = paramString.optString("encryptedObjectId", "");
      paramString = new Intent();
      paramString.putExtra("report_scene", i);
      paramString.putExtra("from_user", com.tencent.mm.model.u.aqG());
      paramString.putExtra("feed_object_id", l);
      paramString.putExtra("feed_encrypted_object_id", str);
      paramString.putExtra("feed_object_nonceId", (String)localObject);
      localObject = com.tencent.mm.plugin.finder.spam.a.qIC;
      if (com.tencent.mm.plugin.finder.spam.a.Zt("entrance") != 0)
      {
        paramString = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.eK(paramContext);
        AppMethodBeat.o(197240);
        return;
      }
      localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.aa(paramContext, paramString);
      com.tencent.mm.plugin.secinforeport.a.d.wcE.asyncReportFinderSecurityInfoThroughCgi(540999685);
      AppMethodBeat.o(197240);
      return;
    }
    catch (Throwable paramContext)
    {
      ad.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderProfileUI exception", new Object[0]);
      AppMethodBeat.o(197240);
    }
  }
  
  public final void enterFinderTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162438);
    d.g.b.k.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.qSb;
    com.tencent.mm.plugin.finder.utils.a.t(paramContext, paramIntent);
    com.tencent.mm.plugin.secinforeport.a.d.wcE.asyncReportFinderSecurityInfoThroughCgi(540999684);
    AppMethodBeat.o(162438);
  }
  
  public final void enterFinderTopicUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(165101);
    d.g.b.k.h(paramContext, "context");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.eK(paramContext);
      AppMethodBeat.o(165101);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.qSb;
    com.tencent.mm.plugin.finder.utils.a.F(paramContext, paramIntent);
    AppMethodBeat.o(165101);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(162434);
    d.g.b.k.h(paramg, "profile");
    AppMethodBeat.o(162434);
  }
  
  public final com.tencent.mm.plugin.finder.storage.c getContactStorage()
  {
    AppMethodBeat.i(165082);
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.plugin.finder.storage.c localc2 = this.qmZ;
    com.tencent.mm.plugin.finder.storage.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.finder.storage.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.qmZ = localc1;
    localc1 = this.qmZ;
    if (localc1 == null) {
      d.g.b.k.fvU();
    }
    AppMethodBeat.o(165082);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.e getFeedStorage()
  {
    AppMethodBeat.i(165083);
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.plugin.finder.storage.e locale2 = this.qna;
    com.tencent.mm.plugin.finder.storage.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new com.tencent.mm.plugin.finder.storage.e((com.tencent.mm.sdk.e.e)getDB());
    }
    this.qna = locale1;
    locale1 = this.qna;
    if (locale1 == null) {
      d.g.b.k.fvU();
    }
    AppMethodBeat.o(165083);
    return locale1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.a getFinderActionStorage()
  {
    AppMethodBeat.i(165086);
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.plugin.finder.storage.a locala2 = this.qne;
    com.tencent.mm.plugin.finder.storage.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.tencent.mm.plugin.finder.storage.a((com.tencent.mm.sdk.e.e)getDB());
    }
    this.qne = locala1;
    locala1 = this.qne;
    if (locala1 == null) {
      d.g.b.k.fvU();
    }
    AppMethodBeat.o(165086);
    return locala1;
  }
  
  public final com.tencent.mm.plugin.finder.api.a getFinderContactCache()
  {
    return this.qni;
  }
  
  public final com.tencent.mm.plugin.finder.api.d getFinderSyncExtension()
  {
    return (com.tencent.mm.plugin.finder.api.d)this.qmY;
  }
  
  public final com.tencent.mm.plugin.finder.utils.m getFollowTlSingleExecutor()
  {
    AppMethodBeat.i(197237);
    com.tencent.mm.plugin.finder.utils.m localm = (com.tencent.mm.plugin.finder.utils.m)this.KJa.getValue();
    AppMethodBeat.o(197237);
    return localm;
  }
  
  public final com.tencent.mm.plugin.finder.storage.g getMediaCacheStorage()
  {
    AppMethodBeat.i(165084);
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.plugin.finder.storage.g localg2 = this.qnb;
    com.tencent.mm.plugin.finder.storage.g localg1 = localg2;
    if (localg2 == null) {
      localg1 = new com.tencent.mm.plugin.finder.storage.g((com.tencent.mm.sdk.e.e)getDB());
    }
    this.qnb = localg1;
    localg1 = this.qnb;
    if (localg1 == null) {
      d.g.b.k.fvU();
    }
    AppMethodBeat.o(165084);
    return localg1;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.a getMediaPreloadModel()
  {
    AppMethodBeat.i(197238);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.KJb.getValue();
    AppMethodBeat.o(197238);
    return locala;
  }
  
  public final com.tencent.mm.sdk.e.j<cd> getMentionStorage(int paramInt)
  {
    AppMethodBeat.i(197239);
    com.tencent.mm.kernel.g.afz().aeD();
    checkResetDb();
    if (paramInt == 1)
    {
      localObject2 = this.KIX;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.KIW;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        localObject1 = new com.tencent.mm.plugin.finder.storage.u((com.tencent.mm.sdk.e.e)localObject1);
      }
      this.KIX = ((com.tencent.mm.plugin.finder.storage.u)localObject1);
      localObject1 = this.KIX;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      localObject1 = (com.tencent.mm.sdk.e.j)localObject1;
      AppMethodBeat.o(197239);
      return localObject1;
    }
    Object localObject2 = this.KIY;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.KIV;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      localObject1 = new com.tencent.mm.plugin.finder.storage.i((com.tencent.mm.sdk.e.e)localObject1);
    }
    this.KIY = ((com.tencent.mm.plugin.finder.storage.i)localObject1);
    localObject1 = this.KIY;
    if (localObject1 == null) {
      d.g.b.k.fvU();
    }
    localObject1 = (com.tencent.mm.sdk.e.j)localObject1;
    AppMethodBeat.o(197239);
    return localObject1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.a getRedDotCtrInfoStorage()
  {
    AppMethodBeat.i(178074);
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.plugin.finder.extension.reddot.a locala2 = this.qnc;
    com.tencent.mm.plugin.finder.extension.reddot.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.tencent.mm.plugin.finder.extension.reddot.a((com.tencent.mm.sdk.e.e)getDB());
    }
    this.qnc = locala1;
    locala1 = this.qnc;
    if (locala1 == null) {
      d.g.b.k.fvU();
    }
    AppMethodBeat.o(178074);
    return locala1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.c getRedDotManager()
  {
    AppMethodBeat.i(178072);
    com.tencent.mm.plugin.finder.extension.reddot.c localc2 = this.qnj;
    com.tencent.mm.plugin.finder.extension.reddot.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.finder.extension.reddot.c(getRedDotCtrInfoStorage());
    }
    this.qnj = localc1;
    localc1 = this.qnj;
    if (localc1 == null) {
      d.g.b.k.fvU();
    }
    AppMethodBeat.o(178072);
    return localc1;
  }
  
  public final ViewModelStore getViewModelStore()
  {
    return this.CE;
  }
  
  public final boolean isFriend(String paramString)
  {
    AppMethodBeat.i(165116);
    if (paramString != null)
    {
      Boolean localBoolean = (Boolean)this.qnE.get(paramString);
      Object localObject = localBoolean;
      if (localBoolean == null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
        localObject = Boolean.valueOf(com.tencent.mm.plugin.finder.utils.i.isFriend(paramString));
        ((Map)this.qnE).put(paramString, localObject);
      }
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(165116);
      return bool;
    }
    AppMethodBeat.o(165116);
    return false;
  }
  
  public final boolean isInFinder()
  {
    AppMethodBeat.i(165097);
    if (this.qnq.size() > 0)
    {
      AppMethodBeat.o(165097);
      return true;
    }
    AppMethodBeat.o(165097);
    return false;
  }
  
  public final void loadImage(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(178075);
    d.g.b.k.h(paramString, "url");
    d.g.b.k.h(paramImageView, "imageView");
    Object localObject = new bmd();
    ((bmd)localObject).mediaId = ai.du(paramString);
    ((bmd)localObject).url = paramString;
    ((bmd)localObject).thumbUrl = paramString;
    paramString = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject, com.tencent.mm.plugin.finder.storage.h.qJZ);
    localObject = com.tencent.mm.plugin.finder.loader.h.qCF;
    com.tencent.mm.plugin.finder.loader.h.cmU().bI(paramString).c(paramImageView);
    AppMethodBeat.o(178075);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(162435);
    this.qmV = true;
    checkResetDb();
    paramc = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(paramc, "MMKernel.storage()");
    paramc = paramc.afk().get(ae.a.Fwp, this.qnm);
    ad.i("Finder.PluginFinder", "onAccountInitialized " + this.qmV + ' ' + this.qnl + ' ' + paramc);
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    if ((d.g.b.k.g(((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.Fwp, this.qnl), this.qnl) ^ true))
    {
      ad.i("Finder.PluginFinder", "resetConfig oldVer:" + paramc + " CURRENT_DB_VERSION:" + this.qnl);
      resetConfig();
    }
    paramc = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(paramc, "MMKernel.storage()");
    paramc.afk().set(ae.a.Fwp, this.qnl);
    paramc = com.tencent.mm.plugin.finder.cgi.j.qoO;
    com.tencent.mm.plugin.finder.cgi.j.cky();
    this.qnp.alive();
    doSomethingOnStart();
    paramc = this.qmX;
    paramc.qQX.a((com.tencent.mm.loader.g.f)paramc.qRb);
    paramc.qQY.a((com.tencent.mm.loader.g.f)paramc.qRc);
    paramc = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(paramc, "MMKernel.storage()");
    paramc.afk().set(ae.a.Fwc, "");
    com.tencent.mm.kernel.g.aeS().a(3565, (com.tencent.mm.al.g)this.qmY);
    com.tencent.mm.kernel.g.aeS().a(3512, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().a(3870, (com.tencent.mm.al.g)this.qnf);
    com.tencent.mm.kernel.g.aeS().a(3870, (com.tencent.mm.al.g)this.KIZ);
    com.tencent.mm.kernel.g.aeS().a(3870, (com.tencent.mm.al.g)this.qng);
    com.tencent.mm.kernel.g.aeS().a(3870, (com.tencent.mm.al.g)this.qnh);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.g.class, (com.tencent.mm.kernel.c.a)this.qnf);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.m.class, (com.tencent.mm.kernel.c.a)this.KIZ);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.f.class, (com.tencent.mm.kernel.c.a)this.qng);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.e.class, (com.tencent.mm.kernel.c.a)this.qnh);
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().db.execSQL("FinderAction", "DELETE FROM FinderAction WHERE actionType = 1");
    ad.i(com.tencent.mm.plugin.finder.storage.a.TAG, "cleanCanRemoveFeed ret" + bool + ' ' + "DELETE FROM FinderAction WHERE actionType = 1");
    if (showFinderEntry()) {
      com.tencent.e.h.Iye.aP((Runnable)n.qnS);
    }
    paramc = com.tencent.mm.plugin.finder.api.b.qnX;
    paramc = com.tencent.mm.plugin.finder.api.b.a.ckq();
    paramc.qoe = true;
    com.tencent.mm.plugin.finder.api.b.a.c(paramc);
    this.qnn.alive();
    paramc = com.tencent.mm.plugin.finder.upload.f.qRf;
    paramc = com.tencent.mm.plugin.finder.upload.f.crB();
    localObject = com.tencent.mm.plugin.finder.report.a.qFo;
    paramc.a(com.tencent.mm.plugin.finder.report.a.cnA());
    AppForegroundDelegate.cKE.a((com.tencent.mm.app.n)this.qns);
    paramc = com.tencent.mm.plugin.finder.model.q.qDO;
    com.tencent.mm.plugin.finder.model.q.qN();
    paramc = com.tencent.mm.plugin.finder.storage.data.k.KXB;
    paramc = (com.tencent.mm.bx.a)new dzo();
    localObject = com.tencent.mm.vfs.i.aR(com.tencent.mm.plugin.finder.storage.data.k.fVi(), 0, -1);
    try
    {
      paramc.parseFrom((byte[])localObject);
      localObject = (dzo)paramc;
      StringBuilder localStringBuilder = new StringBuilder("[setup] isExist=").append(com.tencent.mm.vfs.i.eK(com.tencent.mm.plugin.finder.storage.data.k.fVi())).append(" touchFile=").append(com.tencent.mm.plugin.finder.storage.data.k.fVi()).append(" info: ");
      if (localObject != null)
      {
        paramc = Integer.valueOf(((dzo)localObject).crashCount);
        localStringBuilder = localStringBuilder.append(paramc).append(' ');
        if (localObject == null) {
          break label799;
        }
        paramc = Long.valueOf(((dzo)localObject).Lyb);
        ad.i("Finder.PageRecovery", paramc);
        if (localObject != null)
        {
          if (((dzo)localObject).crashCount < 2) {
            break label804;
          }
          i = 1;
          if (i == 0) {
            break label809;
          }
          paramc = (e.c)localObject;
          if (paramc != null)
          {
            paramc = com.tencent.mm.plugin.finder.storage.data.f.qKv;
            com.tencent.mm.plugin.finder.storage.data.f.a.clearAll();
            paramc = com.tencent.mm.plugin.finder.storage.data.k.KXB;
            com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.plugin.finder.storage.data.k.fVi());
          }
        }
        au.a((au.c)new k.a((dzo)localObject));
        com.tencent.mm.ad.c.b(null, (d.g.a.a)PluginFinder.q.KJh);
        AppMethodBeat.o(162435);
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { paramc });
        paramc = null;
        continue;
        paramc = null;
        continue;
        label799:
        paramc = null;
        continue;
        label804:
        int i = 0;
        continue;
        label809:
        paramc = null;
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(162436);
    ad.i("Finder.PluginFinder", "onAccountRelease");
    Object localObject = com.tencent.mm.plugin.finder.model.q.qDO;
    com.tencent.mm.kernel.g.aeS().b(3520, (com.tencent.mm.al.g)localObject);
    localObject = this.qmX;
    ((com.tencent.mm.plugin.finder.upload.f)localObject).qQX.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.finder.upload.f)localObject).qRb);
    ((com.tencent.mm.plugin.finder.upload.f)localObject).qQY.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.finder.upload.f)localObject).qRc);
    localObject = com.tencent.mm.plugin.finder.upload.f.qRf;
    localObject = com.tencent.mm.plugin.finder.upload.f.crB();
    com.tencent.mm.plugin.finder.report.a locala = com.tencent.mm.plugin.finder.report.a.qFo;
    ((com.tencent.mm.plugin.finder.upload.f)localObject).b(com.tencent.mm.plugin.finder.report.a.cnA());
    com.tencent.mm.kernel.g.aeS().b(3565, (com.tencent.mm.al.g)this.qmY);
    com.tencent.mm.kernel.g.aeS().b(3512, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().b(3870, (com.tencent.mm.al.g)this.qnf);
    com.tencent.mm.kernel.g.aeS().b(3870, (com.tencent.mm.al.g)this.KIZ);
    com.tencent.mm.kernel.g.aeS().b(3870, (com.tencent.mm.al.g)this.qng);
    com.tencent.mm.kernel.g.aeS().b(3870, (com.tencent.mm.al.g)this.qnh);
    com.tencent.mm.kernel.g.aeS().b(665, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.g.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.f.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.e.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.m.class);
    this.qnn.dead();
    AppForegroundDelegate.cKE.b((com.tencent.mm.app.n)this.qns);
    if (this.gda != null)
    {
      localObject = this.gda;
      if (localObject != null) {
        ((com.tencent.mm.storagebase.h)localObject).closeDB();
      }
      this.gda = null;
    }
    this.CE.clear();
    this.qnp.dead();
    AppMethodBeat.o(162436);
  }
  
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString) {}
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onEnterFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165095);
    d.g.b.k.h(paramMMFinderUI, "finder");
    if (!isInFinder()) {
      requestAudioFocus();
    }
    if (!this.qnq.contains(paramMMFinderUI)) {
      this.qnq.add(paramMMFinderUI);
    }
    AppMethodBeat.o(165095);
  }
  
  public final void onExitFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165096);
    d.g.b.k.h(paramMMFinderUI, "finder");
    this.qnq.remove(paramMMFinderUI);
    if (!isInFinder()) {
      this.qnr.XF();
    }
    AppMethodBeat.o(165096);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(165099);
    if (paramn != null) {
      switch (paramn.getType())
      {
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(165099);
        return;
      } while ((paramInt1 != 0) || (paramInt2 != 0));
      paramString = paramn.getReqResp();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = ((com.tencent.mm.al.b)paramString).auM();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetUserResponse");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = ((ajk)paramString).qMq;
    } while (paramString == null);
    paramString = ((Iterable)paramString).iterator();
    while (paramString.hasNext())
    {
      paramn = (FinderContact)paramString.next();
      com.tencent.mm.plugin.finder.api.b.a locala = com.tencent.mm.plugin.finder.api.b.qnX;
      d.g.b.k.g(paramn, "it");
      com.tencent.mm.plugin.finder.api.b.a.b(paramn);
    }
    AppMethodBeat.o(165099);
  }
  
  public final void reportPostRedDot(int paramInt)
  {
    AppMethodBeat.i(165122);
    com.tencent.mm.plugin.report.service.h.vKh.m(1309L, paramInt, 1L);
    com.tencent.mm.plugin.report.service.h.vKh.f(19212, new Object[] { Integer.valueOf(paramInt), Long.valueOf(ce.asQ()) });
    AppMethodBeat.o(165122);
  }
  
  public final void resetConfig()
  {
    AppMethodBeat.i(165093);
    try
    {
      Object localObject = com.tencent.mm.plugin.finder.storage.data.d.qKq;
      com.tencent.mm.plugin.finder.storage.data.d.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.f.qKv;
      com.tencent.mm.plugin.finder.storage.data.f.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.a.qKk;
      a.a.clearAll();
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwq, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwr, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBk, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBl, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBm, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FvU, Long.valueOf(1L));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FvW, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FvX, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FvY, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FvZ, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwa, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwb, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwc, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwe, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwn, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fwo, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fxg, Integer.valueOf(0));
      clearReInit();
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LAY, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwD, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwE, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBn, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBo, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwJ, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwK, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBe, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBf, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwM, Boolean.FALSE);
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwT, "");
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwW, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwX, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FwY, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fxc, Boolean.FALSE);
      AppMethodBeat.o(165093);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("Finder.PluginFinder", (Throwable)localException, "resetConfig error", new Object[0]);
      AppMethodBeat.o(165093);
    }
  }
  
  public final void resetLastTimelineExitTime()
  {
    AppMethodBeat.i(165110);
    ad.i("Finder.PluginFinder", "reset timeline auto refresh time");
    AppMethodBeat.o(165110);
  }
  
  public final void shareStatsReport(List<String> paramList)
  {
    AppMethodBeat.i(197241);
    d.g.b.k.h(paramList, "feedIdList");
    v.e locale = new v.e();
    locale.Jhw = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      cxk localcxk = new cxk();
      localcxk.objectId = com.tencent.mm.ad.c.rc((String)localObject);
      localcxk.orgVal = new bxf();
      localObject = localcxk.orgVal;
      ((bxf)localObject).DTF += 1;
      localcxk.orgVal.DTH = 1;
      ((LinkedList)locale.Jhw).add(localcxk);
    }
    new com.tencent.mm.plugin.finder.cgi.f((List)locale.Jhw, null).auK().j((com.tencent.mm.vending.c.a)new PluginFinder.r(locale));
    AppMethodBeat.o(197241);
  }
  
  public final boolean showFinderEntry()
  {
    AppMethodBeat.i(165102);
    boolean bool1;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prk, 0) != 0)
    {
      bool1 = true;
      Object localObject = com.tencent.mm.plugin.finder.spam.a.qIC;
      int i = com.tencent.mm.plugin.finder.spam.a.Zt("entrance");
      if (i == 2)
      {
        ad.i("Finder.PluginFinder", "showFinderEntry ".concat(String.valueOf(i)));
        bool1 = false;
      }
      if (this.qnt)
      {
        ad.i("Finder.PluginFinder", "closeFinderEntryForDebug");
        bool1 = false;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.cpq() == 0) {
        break label143;
      }
    }
    label143:
    for (boolean bool2 = true;; bool2 = false)
    {
      ad.i("Finder.PluginFinder", "showFinder %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (!bool2)) {
        break label148;
      }
      AppMethodBeat.o(165102);
      return true;
      bool1 = false;
      break;
    }
    label148:
    AppMethodBeat.o(165102);
    return false;
  }
  
  public final boolean showPostEntry()
  {
    AppMethodBeat.i(165103);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prl, 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("Finder.PluginFinder", "showPost %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(165103);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/PluginFinder$Companion;", "", "()V", "ID_KEY_POST_RED_DOT", "", "KV_ID_POST_RED_DOT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.app.n
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(165054);
      PluginFinder.access$getAudioHelperTool$p(this.qnG).XF();
      AppMethodBeat.o(165054);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(165055);
      if (this.qnG.isInFinder()) {
        PluginFinder.access$requestAudioFocus(this.qnG);
      }
      if ((this.qnG.showFinderEntry()) && (SystemClock.uptimeMillis() - PluginFinder.access$getLastFinderInitTime$p(this.qnG) >= 86400000L)) {
        PluginFinder.access$doFinderInit(this.qnG);
      }
      AppMethodBeat.o(165055);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class c
    implements h.b
  {
    public static final c qnH;
    
    static
    {
      AppMethodBeat.i(165057);
      qnH = new c();
      AppMethodBeat.o(165057);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165056);
      Object localObject = com.tencent.mm.plugin.finder.storage.c.qJF;
      localObject = com.tencent.mm.plugin.finder.storage.c.clk();
      AppMethodBeat.o(165056);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class d
    implements h.b
  {
    public static final d qnI;
    
    static
    {
      AppMethodBeat.i(165059);
      qnI = new d();
      AppMethodBeat.o(165059);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165058);
      Object localObject = com.tencent.mm.plugin.finder.storage.e.qJO;
      localObject = com.tencent.mm.plugin.finder.storage.e.clk();
      AppMethodBeat.o(165058);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class e
    implements h.b
  {
    public static final e qnJ;
    
    static
    {
      AppMethodBeat.i(165061);
      qnJ = new e();
      AppMethodBeat.o(165061);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165060);
      Object localObject = com.tencent.mm.plugin.finder.storage.g.qJX;
      localObject = com.tencent.mm.plugin.finder.storage.g.clk();
      AppMethodBeat.o(165060);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class f
    implements h.b
  {
    public static final f qnK;
    
    static
    {
      AppMethodBeat.i(165063);
      qnK = new f();
      AppMethodBeat.o(165063);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165062);
      Object localObject = com.tencent.mm.plugin.finder.extension.reddot.a.qta;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.a.clk();
      AppMethodBeat.o(165062);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class g
    implements h.b
  {
    public static final g qnL;
    
    static
    {
      AppMethodBeat.i(178067);
      qnL = new g();
      AppMethodBeat.o(178067);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(178066);
      Object localObject = com.tencent.mm.plugin.finder.storage.a.qII;
      localObject = com.tencent.mm.plugin.finder.storage.a.clk();
      AppMethodBeat.o(178066);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    public static final i qnN;
    
    static
    {
      AppMethodBeat.i(165067);
      qnN = new i();
      AppMethodBeat.o(165067);
    }
    
    i()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class j
    extends com.tencent.mm.sdk.b.c<fh>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderSyncEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class k
    extends com.tencent.mm.sdk.b.c<he>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    public static final n qnS;
    
    static
    {
      AppMethodBeat.i(165072);
      qnS = new n();
      AppMethodBeat.o(165072);
    }
    
    public final void run()
    {
      AppMethodBeat.i(165071);
      com.tencent.mm.plugin.finder.upload.b.a locala = com.tencent.mm.plugin.finder.upload.b.qQD;
      com.tencent.mm.plugin.finder.upload.b.crx().crw();
      AppMethodBeat.o(165071);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/PluginFinder$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
  public static final class o
    implements com.tencent.mm.model.d.a
  {
    public final void aqt()
    {
      AppMethodBeat.i(165073);
      ad.i("Finder.PluginFinder", "[audioHelperTool] gain");
      AppMethodBeat.o(165073);
    }
    
    public final void aqu()
    {
      AppMethodBeat.i(165075);
      ad.i("Finder.PluginFinder", "[audioHelperTool] loss");
      AppMethodBeat.o(165075);
    }
    
    public final void aqv()
    {
      AppMethodBeat.i(165074);
      ad.i("Finder.PluginFinder", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(165074);
    }
    
    public final void aqw()
    {
      AppMethodBeat.i(165076);
      ad.i("Finder.PluginFinder", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(165076);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final p KJg;
    
    static
    {
      AppMethodBeat.i(197233);
      KJg = new p();
      AppMethodBeat.o(197233);
    }
    
    p()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder
 * JD-Core Version:    0.7.0.1
 */