package com.tencent.mm.plugin.finder;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.cgi.s;
import com.tencent.mm.plugin.finder.storage.data.i.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamRefreshPreload;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamRefreshPreload.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamRefreshPreload.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import com.tencent.wcdb.database.SQLiteException;
import d.g.b.v.f;
import d.g.b.w;
import d.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder;", "Lcom/tencent/mm/kernel/api/ICoreStorageCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "CURRENT_DB_VERSION", "", "kotlin.jvm.PlatformType", "CURRENT_DB_VERSION_DEFAULT", "actionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "appForegroundListener", "com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "closeFinderEntryForDebug", "", "contactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1;", "feedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "finderActivity", "", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "", "finderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "finderMentionDB", "finderMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "finderSyncEventListener", "com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1;", "followTlSingleExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "getFollowTlSingleExecutor", "()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "followTlSingleExecutor$delegate", "Lkotlin/Lazy;", "isDoSomethingCompleted", "isFriendCache", "Ljava/util/concurrent/ConcurrentHashMap;", "lastFinderInitTime", "", "lock", "", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "mediaPreloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getMediaPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "mediaPreloadModel$delegate", "modifyBlackListService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "modifyFeedSettingService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "modifyLikeRecommendService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "modifyUserService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "needResetDb", "postManager", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "redDotCtrInfoStorage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "syncExtension", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "viewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "wxMentionDB", "wxMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "checkResetDb", "", "clearMentionDB", "clearReInit", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "Lkotlin/collections/HashMap;", "collectMentionDatabaseFactory", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "doFinderInit", "doPrepareUser", "doReInit", "reInitVersion", "reInitUsername", "doSomethingOnStart", "dumpAndMarkFinderFolder", "enterFinderPostUI", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "enterFinderProfileUI", "enterFinderShareFeedUI", "json", "enterFinderTimelineUI", "i", "enterFinderTopicUI", "execute", "getContactStorage", "getDB", "getFeedStorage", "getFinderActionStorage", "getFinderContactCache", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getMediaCacheStorage", "getMentionStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "localFlag", "getRedDotCtrInfoStorage", "getRedDotManager", "getViewModelStore", "isFriend", "username", "isInFinder", "loadImage", "url", "imageView", "Landroid/widget/ImageView;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onAppBackground", "activity", "onAppForeground", "onDataBaseClosed", "readOnlyDB", "onDataBaseOpened", "onEnterFinder", "finder", "onExitFinder", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportPostRedDot", "key", "requestAudioFocus", "resetConfig", "resetDb", "resetLastTimelineExitTime", "shareStatsReport", "feedIdList", "", "showFinderEntry", "showPostEntry", "Companion", "plugin-finder_release"})
public final class PluginFinder
  extends com.tencent.mm.kernel.b.f
  implements ViewModelStoreOwner, com.tencent.mm.ak.g, com.tencent.mm.app.n, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.plugin.i.a.l
{
  public static final PluginFinder.a qWb;
  private final ViewModelStore DD;
  private final com.tencent.mm.model.d gGY;
  private com.tencent.mm.storagebase.h ghG;
  private final byte[] lock;
  private final com.tencent.mm.plugin.finder.upload.f qVA;
  private final com.tencent.mm.plugin.finder.extension.a qVB;
  private com.tencent.mm.plugin.finder.storage.c qVC;
  private com.tencent.mm.plugin.finder.storage.f qVD;
  private com.tencent.mm.plugin.finder.storage.l qVE;
  private com.tencent.mm.plugin.finder.extension.reddot.b qVF;
  private com.tencent.mm.plugin.finder.storage.q qVG;
  private com.tencent.mm.plugin.finder.storage.g qVH;
  private com.tencent.mm.plugin.finder.storage.a qVI;
  private final com.tencent.mm.plugin.finder.cgi.oplog.d qVJ;
  private final com.tencent.mm.plugin.finder.cgi.oplog.a qVK;
  private final com.tencent.mm.plugin.finder.cgi.oplog.c qVL;
  private final com.tencent.mm.plugin.finder.cgi.oplog.b qVM;
  private final com.tencent.mm.plugin.finder.api.a qVN;
  private com.tencent.mm.plugin.finder.extension.reddot.d qVO;
  private final d.f qVP;
  private final String qVQ;
  private final String qVR;
  private final d.f qVS;
  private final l qVT;
  private final k qVU;
  private volatile boolean qVV;
  private final Set<MMFinderUI> qVW;
  private long qVX;
  private final b qVY;
  private boolean qVZ;
  private volatile boolean qVx;
  private com.tencent.mm.storagebase.h qVy;
  private com.tencent.mm.storagebase.h qVz;
  private final ConcurrentHashMap<String, Boolean> qWa;
  
  static
  {
    AppMethodBeat.i(162442);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(PluginFinder.class), "followTlSingleExecutor", "getFollowTlSingleExecutor()Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;")), (d.l.k)w.a(new d.g.b.u(w.bn(PluginFinder.class), "mediaPreloadModel", "getMediaPreloadModel()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;")) };
    qWb = new PluginFinder.a((byte)0);
    AppMethodBeat.o(162442);
  }
  
  public PluginFinder()
  {
    AppMethodBeat.i(165123);
    this.lock = new byte[0];
    com.tencent.mm.plugin.finder.upload.f.a locala = com.tencent.mm.plugin.finder.upload.f.rNg;
    this.qVA = com.tencent.mm.plugin.finder.upload.f.cCv();
    this.qVB = new com.tencent.mm.plugin.finder.extension.a();
    this.qVJ = new com.tencent.mm.plugin.finder.cgi.oplog.d();
    this.qVK = new com.tencent.mm.plugin.finder.cgi.oplog.a();
    this.qVL = new com.tencent.mm.plugin.finder.cgi.oplog.c();
    this.qVM = new com.tencent.mm.plugin.finder.cgi.oplog.b();
    this.qVN = new com.tencent.mm.plugin.finder.api.a();
    this.qVP = d.g.K((d.g.a.a)m.qWl);
    this.qVQ = ah.dg("FinderMM029.dbFinderMention001.db");
    this.qVR = ah.dg("FinderMM029.dbFinderMention001.db");
    this.qVS = d.g.K((d.g.a.a)n.qWm);
    this.qVT = new l(this);
    this.qVU = new k(this);
    this.qVW = Collections.synchronizedSet((Set)new HashSet());
    this.gGY = com.tencent.mm.model.d.axh();
    this.qVY = new b(this);
    this.qWa = new ConcurrentHashMap();
    this.DD = new ViewModelStore();
    AppMethodBeat.o(165123);
  }
  
  private final void checkResetDb()
  {
    AppMethodBeat.i(165077);
    ac.v("Finder.PluginFinder", "checkResetDb1 " + this.qVx);
    if (this.qVx)
    {
      ac.v("Finder.PluginFinder", "checkResetDb2 " + this.qVx);
      synchronized (this.lock)
      {
        Object localObject1 = new StringBuilder("checkResetDb  need reset DB now ");
        Thread localThread = Thread.currentThread();
        d.g.b.k.g(localThread, "Thread.currentThread()");
        localObject1 = ((StringBuilder)localObject1).append(localThread.getName()).append(" ");
        localThread = Thread.currentThread();
        d.g.b.k.g(localThread, "Thread.currentThread()");
        ac.i("Finder.PluginFinder", localThread.getId() + " " + hashCode());
        if (this.qVx)
        {
          resetDb();
          this.qVx = false;
          ac.i("Finder.PluginFinder", "resetDB done");
        }
        localObject1 = y.KTp;
        AppMethodBeat.o(165077);
        return;
      }
    }
    AppMethodBeat.o(165077);
  }
  
  private final void clearMentionDB()
  {
    AppMethodBeat.i(165079);
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).agv();
    com.tencent.mm.vfs.i.deleteFile((String)localObject + "FinderMention001.db");
    com.tencent.mm.vfs.i.deleteFile((String)localObject + "FinderMention002.db");
    this.qVy = null;
    this.qVz = null;
    AppMethodBeat.o(165079);
  }
  
  private final HashMap<Integer, h.b> collectMentionDatabaseFactory()
  {
    AppMethodBeat.i(165081);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FINDER_MENTION_TABLE".hashCode()), h.qWi);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_WX_MENTION_TABLE".hashCode()), i.qWj);
    AppMethodBeat.o(165081);
    return localHashMap;
  }
  
  private final void doFinderInit()
  {
    AppMethodBeat.i(165088);
    ac.i("Finder.PluginFinder", "[doFinderInit] ...");
    this.qVX = SystemClock.uptimeMillis();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).clearReInit();
    com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)new al());
    AppMethodBeat.o(165088);
  }
  
  private final void doPrepareUser()
  {
    AppMethodBeat.i(165091);
    aq localaq = new aq(1);
    com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)localaq);
    AppMethodBeat.o(165091);
  }
  
  private final void doReInit(int paramInt, String paramString)
  {
    AppMethodBeat.i(165090);
    try
    {
      com.tencent.mm.plugin.report.service.h.wUl.n(1279L, 21L, 1L);
      Object localObject = com.tencent.mm.plugin.finder.storage.data.f.rEK;
      com.tencent.mm.plugin.finder.storage.data.f.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.i.rEV;
      i.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.b.rEB;
      com.tencent.mm.plugin.finder.storage.data.b.a.clearAll();
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUs, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUt, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVF, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVG, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVH, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVI, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVJ, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVK, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUi, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUq, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVw, Integer.valueOf(paramInt));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTQ, paramString);
      paramString = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramString, "MMKernel.storage()");
      paramString.agA().set(ah.a.GVL, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramString, "MMKernel.storage()");
      paramString.agA().set(ah.a.GVM, Integer.valueOf(0));
      AppMethodBeat.o(165090);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("Finder.PluginFinder", (Throwable)paramString, "do ReInit occur error!", new Object[0]);
      com.tencent.mm.plugin.report.service.h.wUl.n(1279L, 22L, 1L);
      AppMethodBeat.o(165090);
    }
  }
  
  private final void doSomethingOnStart()
  {
    AppMethodBeat.i(165089);
    if (this.qVV)
    {
      AppMethodBeat.o(165089);
      return;
    }
    boolean bool = showFinderEntry();
    ac.i("Finder.PluginFinder", "[doSomethingOnStart] " + com.tencent.mm.model.u.axE() + " isDoSomethingCompleted=" + this.qVV + ", isShowFinderEntry=" + bool);
    if (!bool)
    {
      AppMethodBeat.o(165089);
      return;
    }
    this.qVV = true;
    if (bs.isNullOrNil(com.tencent.mm.model.u.axE()))
    {
      com.tencent.mm.kernel.g.agi().a(3930, (com.tencent.mm.ak.g)this);
      com.tencent.mm.kernel.g.agi().a(3930, (com.tencent.mm.ak.g)getRedDotManager());
      doFinderInit();
      this.qVB.fx(14845, 6);
    }
    for (;;)
    {
      getRedDotManager().prepare();
      AppMethodBeat.o(165089);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.n(1279L, 34L, 1L);
      Object localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.e)localObject).agA().getInt(ah.a.GVw, 0);
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      int j = ((com.tencent.mm.kernel.e)localObject).agA().getInt(ah.a.GVu, 0);
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).agA().get(ah.a.GVv, "");
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165089);
        throw ((Throwable)localObject);
      }
      localObject = (String)localObject;
      ac.i("Finder.PluginFinder", "doSomethingOnStart userVersion " + i + ", reInitUserVersion " + j + ", reInitUsername " + (String)localObject);
      if ((i != j) && (j != 0)) {
        doReInit(j, (String)localObject);
      }
      doPrepareUser();
      this.qVB.fx(15357, 6);
    }
  }
  
  private final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(165080);
    checkResetDb();
    com.tencent.mm.storagebase.h localh = this.ghG;
    if (localh == null) {
      d.g.b.k.fOy();
    }
    AppMethodBeat.o(165080);
    return localh;
  }
  
  private final void requestAudioFocus()
  {
    AppMethodBeat.i(165098);
    this.gGY.a((d.a)new q());
    AppMethodBeat.o(165098);
  }
  
  private final void resetDb()
  {
    AppMethodBeat.i(165078);
    Object localObject;
    com.tencent.mm.storagebase.h localh;
    if (this.ghG == null)
    {
      this.ghG = new com.tencent.mm.storagebase.h();
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).agv();
      localObject = (String)localObject + "FinderMM029.db";
      localh = this.ghG;
      if (localh == null) {
        d.g.b.k.fOy();
      }
      if (!localh.b((String)localObject, collectDatabaseFactory(), true))
      {
        localObject = (Throwable)new SQLiteException("finder db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject);
      }
    }
    if (this.qVy == null)
    {
      this.qVy = new com.tencent.mm.storagebase.h();
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).agv();
      localObject = (String)localObject + "FinderMention001.db";
      localh = this.qVy;
      if (localh == null) {
        d.g.b.k.fOy();
      }
      if (!localh.b((String)localObject, collectMentionDatabaseFactory(), true))
      {
        localObject = (Throwable)new SQLiteException("finder finder mention db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject);
      }
    }
    if (this.qVz == null)
    {
      this.qVz = new com.tencent.mm.storagebase.h();
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).agv();
      localObject = (String)localObject + "FinderMention002.db";
      localh = this.qVz;
      if (localh == null) {
        d.g.b.k.fOy();
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
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GVu, Integer.valueOf(0));
    locale = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GVv, "");
    AppMethodBeat.o(165094);
  }
  
  public final void closeFinderEntryForDebug()
  {
    this.qVZ = true;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(162433);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_CONTACT_TABLE".hashCode()), c.qWd);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FEED_TABLE".hashCode()), d.qWe);
    ((Map)localHashMap).put(Integer.valueOf("FinderMediaCacheInfo".hashCode()), e.qWf);
    ((Map)localHashMap).put(Integer.valueOf("FinderRedDotInfo".hashCode()), PluginFinder.f.qWg);
    ((Map)localHashMap).put(Integer.valueOf("FinderAction".hashCode()), g.qWh);
    AppMethodBeat.o(162433);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(165092);
    o.b("finder", "finder", 7776000000L, 19);
    AppMethodBeat.o(165092);
  }
  
  public final void dumpAndMarkFinderFolder()
  {
    AppMethodBeat.i(165100);
    com.tencent.mm.ac.c.b(null, (d.g.a.a)j.qWk);
    AppMethodBeat.o(165100);
  }
  
  public final void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162439);
    d.g.b.k.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.rOv;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, paramIntent);
    AppMethodBeat.o(162439);
  }
  
  public final void enterFinderProfileUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162440);
    d.g.b.k.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.rOv;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, paramIntent);
    com.tencent.mm.plugin.secinforeport.a.d.xnP.asyncReportFinderSecurityInfoThroughCgi(540999686);
    AppMethodBeat.o(162440);
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162441);
    d.g.b.k.h(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.spam.a.rBD;
    if (com.tencent.mm.plugin.finder.spam.a.aeb("entrance") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.eS(paramContext);
      AppMethodBeat.o(162441);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
    com.tencent.mm.plugin.finder.utils.a.B(paramContext, paramIntent);
    com.tencent.mm.plugin.secinforeport.a.d.xnP.asyncReportFinderSecurityInfoThroughCgi(540999685);
    AppMethodBeat.o(162441);
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(201093);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramString, "json");
    try
    {
      paramString = new com.tencent.mm.ab.i(paramString);
      Object localObject = paramString.optString("feedId", "0");
      d.g.b.k.g(localObject, "jsonObject.optString(\"feedId\", \"0\")");
      long l = com.tencent.mm.ac.c.ur((String)localObject);
      paramString = paramString.tY("extInfo");
      localObject = paramString.getString("feedNonceId");
      int i = paramString.optInt("reportScene", 13);
      String str = paramString.optString("encryptedObjectId", "");
      paramString = new Intent();
      paramString.putExtra("report_scene", i);
      paramString.putExtra("from_user", com.tencent.mm.model.u.axw());
      paramString.putExtra("feed_object_id", l);
      paramString.putExtra("feed_encrypted_object_id", str);
      paramString.putExtra("feed_object_nonceId", (String)localObject);
      localObject = com.tencent.mm.plugin.finder.spam.a.rBD;
      if (com.tencent.mm.plugin.finder.spam.a.aeb("entrance") != 0)
      {
        paramString = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.eS(paramContext);
        AppMethodBeat.o(201093);
        return;
      }
      localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.C(paramContext, paramString);
      com.tencent.mm.plugin.secinforeport.a.d.xnP.asyncReportFinderSecurityInfoThroughCgi(540999685);
      AppMethodBeat.o(201093);
      return;
    }
    catch (Throwable paramContext)
    {
      ac.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderProfileUI exception", new Object[0]);
      AppMethodBeat.o(201093);
    }
  }
  
  public final void enterFinderTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162438);
    d.g.b.k.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.rOv;
    com.tencent.mm.plugin.finder.utils.a.t(paramContext, paramIntent);
    com.tencent.mm.plugin.secinforeport.a.d.xnP.asyncReportFinderSecurityInfoThroughCgi(540999684);
    AppMethodBeat.o(162438);
  }
  
  public final void enterFinderTopicUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(165101);
    d.g.b.k.h(paramContext, "context");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.eS(paramContext);
      AppMethodBeat.o(165101);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.rOv;
    com.tencent.mm.plugin.finder.utils.a.I(paramContext, paramIntent);
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
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.plugin.finder.storage.c localc2 = this.qVC;
    com.tencent.mm.plugin.finder.storage.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.finder.storage.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.qVC = localc1;
    localc1 = this.qVC;
    if (localc1 == null) {
      d.g.b.k.fOy();
    }
    AppMethodBeat.o(165082);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.f getFeedStorage()
  {
    AppMethodBeat.i(165083);
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.plugin.finder.storage.f localf2 = this.qVD;
    com.tencent.mm.plugin.finder.storage.f localf1 = localf2;
    if (localf2 == null) {
      localf1 = new com.tencent.mm.plugin.finder.storage.f((com.tencent.mm.sdk.e.e)getDB());
    }
    this.qVD = localf1;
    localf1 = this.qVD;
    if (localf1 == null) {
      d.g.b.k.fOy();
    }
    AppMethodBeat.o(165083);
    return localf1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.a getFinderActionStorage()
  {
    AppMethodBeat.i(165086);
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.plugin.finder.storage.a locala2 = this.qVI;
    com.tencent.mm.plugin.finder.storage.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.tencent.mm.plugin.finder.storage.a((com.tencent.mm.sdk.e.e)getDB());
    }
    this.qVI = locala1;
    locala1 = this.qVI;
    if (locala1 == null) {
      d.g.b.k.fOy();
    }
    AppMethodBeat.o(165086);
    return locala1;
  }
  
  public final com.tencent.mm.plugin.finder.api.a getFinderContactCache()
  {
    return this.qVN;
  }
  
  public final com.tencent.mm.plugin.finder.api.d getFinderSyncExtension()
  {
    return (com.tencent.mm.plugin.finder.api.d)this.qVB;
  }
  
  public final r getFollowTlSingleExecutor()
  {
    AppMethodBeat.i(201090);
    r localr = (r)this.qVP.getValue();
    AppMethodBeat.o(201090);
    return localr;
  }
  
  public final com.tencent.mm.plugin.finder.storage.l getMediaCacheStorage()
  {
    AppMethodBeat.i(165084);
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.plugin.finder.storage.l locall2 = this.qVE;
    com.tencent.mm.plugin.finder.storage.l locall1 = locall2;
    if (locall2 == null) {
      locall1 = new com.tencent.mm.plugin.finder.storage.l((com.tencent.mm.sdk.e.e)getDB());
    }
    this.qVE = locall1;
    locall1 = this.qVE;
    if (locall1 == null) {
      d.g.b.k.fOy();
    }
    AppMethodBeat.o(165084);
    return locall1;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.a getMediaPreloadModel()
  {
    AppMethodBeat.i(201091);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.qVS.getValue();
    AppMethodBeat.o(201091);
    return locala;
  }
  
  public final com.tencent.mm.sdk.e.j<cf> getMentionStorage(int paramInt)
  {
    AppMethodBeat.i(201092);
    com.tencent.mm.kernel.g.agP().afT();
    checkResetDb();
    if (paramInt == 1)
    {
      localObject2 = this.qVG;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.qVz;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = new com.tencent.mm.plugin.finder.storage.q((com.tencent.mm.sdk.e.e)localObject1);
      }
      this.qVG = ((com.tencent.mm.plugin.finder.storage.q)localObject1);
      localObject1 = this.qVG;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      localObject1 = (com.tencent.mm.sdk.e.j)localObject1;
      AppMethodBeat.o(201092);
      return localObject1;
    }
    Object localObject2 = this.qVH;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.qVy;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      localObject1 = new com.tencent.mm.plugin.finder.storage.g((com.tencent.mm.sdk.e.e)localObject1);
    }
    this.qVH = ((com.tencent.mm.plugin.finder.storage.g)localObject1);
    localObject1 = this.qVH;
    if (localObject1 == null) {
      d.g.b.k.fOy();
    }
    localObject1 = (com.tencent.mm.sdk.e.j)localObject1;
    AppMethodBeat.o(201092);
    return localObject1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.b getRedDotCtrInfoStorage()
  {
    AppMethodBeat.i(178074);
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.plugin.finder.extension.reddot.b localb2 = this.qVF;
    com.tencent.mm.plugin.finder.extension.reddot.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = new com.tencent.mm.plugin.finder.extension.reddot.b((com.tencent.mm.sdk.e.e)getDB());
    }
    this.qVF = localb1;
    localb1 = this.qVF;
    if (localb1 == null) {
      d.g.b.k.fOy();
    }
    AppMethodBeat.o(178074);
    return localb1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.d getRedDotManager()
  {
    AppMethodBeat.i(178072);
    com.tencent.mm.plugin.finder.extension.reddot.d locald2 = this.qVO;
    com.tencent.mm.plugin.finder.extension.reddot.d locald1 = locald2;
    if (locald2 == null) {
      locald1 = new com.tencent.mm.plugin.finder.extension.reddot.d(getRedDotCtrInfoStorage());
    }
    this.qVO = locald1;
    locald1 = this.qVO;
    if (locald1 == null) {
      d.g.b.k.fOy();
    }
    AppMethodBeat.o(178072);
    return locald1;
  }
  
  public final ViewModelStore getViewModelStore()
  {
    return this.DD;
  }
  
  public final boolean isFriend(String paramString)
  {
    AppMethodBeat.i(165116);
    if (paramString != null)
    {
      Boolean localBoolean = (Boolean)this.qWa.get(paramString);
      Object localObject = localBoolean;
      if (localBoolean == null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.n.rPN;
        localObject = Boolean.valueOf(com.tencent.mm.plugin.finder.utils.n.isFriend(paramString));
        ((Map)this.qWa).put(paramString, localObject);
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
    if (this.qVW.size() > 0)
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
    Object localObject = new bqs();
    ((bqs)localObject).mediaId = ah.dg(paramString);
    ((bqs)localObject).url = paramString;
    ((bqs)localObject).thumbUrl = paramString;
    paramString = new com.tencent.mm.plugin.finder.loader.f((bqs)localObject, m.rDR);
    localObject = com.tencent.mm.plugin.finder.loader.h.rtK;
    com.tencent.mm.plugin.finder.loader.h.cwn().bG(paramString).c(paramImageView);
    AppMethodBeat.o(178075);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(162435);
    this.qVx = true;
    checkResetDb();
    paramc = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(paramc, "MMKernel.storage()");
    paramc = paramc.agA().get(ah.a.GUr, this.qVR);
    ac.i("Finder.PluginFinder", "onAccountInitialized " + this.qVx + ' ' + this.qVQ + ' ' + paramc);
    Object localObject1 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject1, "MMKernel.storage()");
    if ((d.g.b.k.g(((com.tencent.mm.kernel.e)localObject1).agA().get(ah.a.GUr, this.qVQ), this.qVQ) ^ true))
    {
      ac.i("Finder.PluginFinder", "resetConfig oldVer:" + paramc + " CURRENT_DB_VERSION:" + this.qVQ);
      resetConfig();
    }
    paramc = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(paramc, "MMKernel.storage()");
    paramc.agA().set(ah.a.GUr, this.qVQ);
    paramc = s.qXL;
    s.csj();
    this.qVU.alive();
    doSomethingOnStart();
    paramc = this.qVA;
    paramc.rMY.a((com.tencent.mm.loader.g.f)paramc.rNc);
    paramc.rMZ.a((com.tencent.mm.loader.g.f)paramc.rNd);
    paramc = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(paramc, "MMKernel.storage()");
    paramc.agA().set(ah.a.GTW, "");
    com.tencent.mm.kernel.g.agi().a(3565, (com.tencent.mm.ak.g)this.qVB);
    com.tencent.mm.kernel.g.agi().a(3512, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().a(3870, (com.tencent.mm.ak.g)this.qVJ);
    com.tencent.mm.kernel.g.agi().a(3870, (com.tencent.mm.ak.g)this.qVK);
    com.tencent.mm.kernel.g.agi().a(3870, (com.tencent.mm.ak.g)this.qVL);
    com.tencent.mm.kernel.g.agi().a(3870, (com.tencent.mm.ak.g)this.qVM);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.i.class, (com.tencent.mm.kernel.c.a)this.qVJ);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.h.class, (com.tencent.mm.kernel.c.a)this.qVK);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.g.class, (com.tencent.mm.kernel.c.a)this.qVL);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.f.class, (com.tencent.mm.kernel.c.a)this.qVM);
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().db.execSQL("FinderAction", "DELETE FROM FinderAction WHERE actionType = 1");
    ac.i(com.tencent.mm.plugin.finder.storage.a.TAG, "cleanCanRemoveFeed ret" + bool + ' ' + "DELETE FROM FinderAction WHERE actionType = 1");
    if (showFinderEntry()) {
      com.tencent.e.h.JZN.aS((Runnable)o.qWn);
    }
    paramc = com.tencent.mm.plugin.finder.api.b.qWt;
    paramc = com.tencent.mm.plugin.finder.api.b.a.crX();
    paramc.qWz = true;
    com.tencent.mm.plugin.finder.api.b.a.c(paramc);
    this.qVT.alive();
    paramc = com.tencent.mm.plugin.finder.upload.f.rNg;
    paramc = com.tencent.mm.plugin.finder.upload.f.cCv();
    localObject1 = com.tencent.mm.plugin.finder.report.c.rxi;
    paramc.a(com.tencent.mm.plugin.finder.report.c.cwR());
    AppForegroundDelegate.cHM.a((com.tencent.mm.app.n)this.qVY);
    paramc = com.tencent.mm.plugin.finder.model.v.rve;
    com.tencent.mm.plugin.finder.model.v.qX();
    paramc = com.tencent.mm.plugin.finder.storage.data.k.rFg;
    paramc = (com.tencent.mm.bw.a)new ang();
    localObject1 = com.tencent.mm.vfs.i.aU(com.tencent.mm.plugin.finder.storage.data.k.cBl(), 0, -1);
    try
    {
      paramc.parseFrom((byte[])localObject1);
      localObject1 = (ang)paramc;
      Object localObject2 = new StringBuilder("[setup] isExist=").append(com.tencent.mm.vfs.i.eA(com.tencent.mm.plugin.finder.storage.data.k.cBl())).append(" touchFile=").append(com.tencent.mm.plugin.finder.storage.data.k.cBl()).append(" info: ");
      if (localObject1 != null)
      {
        paramc = Integer.valueOf(((ang)localObject1).crashCount);
        localObject2 = ((StringBuilder)localObject2).append(paramc).append(' ');
        if (localObject1 == null) {
          break label953;
        }
        paramc = Long.valueOf(((ang)localObject1).EGo);
        ac.i("Finder.PageRecovery", paramc);
        if (localObject1 != null)
        {
          if (((ang)localObject1).crashCount < 2) {
            break label958;
          }
          i = 1;
          if (i == 0) {
            break label963;
          }
          paramc = (e.c)localObject1;
          if (paramc != null)
          {
            paramc = com.tencent.mm.plugin.finder.storage.data.i.rEV;
            i.a.clearAll();
            paramc = com.tencent.mm.plugin.finder.storage.data.k.rFg;
            com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.plugin.finder.storage.data.k.cBl());
          }
        }
        at.a((at.c)new k.a((ang)localObject1));
        com.tencent.mm.ac.c.b(null, (d.g.a.a)p.qWo);
        paramc = com.tencent.mm.ui.component.a.IrY;
        paramc = (FinderStreamRefreshPreload)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderStreamRefreshPreload.class);
        bool = FinderStreamRefreshPreload.isEnable();
        localObject1 = new StringBuilder("[setup] isEnable=").append(bool).append(" fakeWaitForRefresh=");
        localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
        ac.i("Finder.StreamRefreshPreload", com.tencent.mm.plugin.finder.storage.b.cAs() + "ms");
        if (bool)
        {
          paramc.scu.alive();
          localObject1 = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
          localObject1 = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
          com.tencent.mm.plugin.finder.extension.reddot.f.a(com.tencent.mm.plugin.finder.extension.reddot.f.ctM(), (Observer)paramc);
          paramc.rvb.postDelayed((Runnable)paramc, 1000L);
          AppForegroundDelegate.cHM.a((com.tencent.mm.app.n)paramc);
          paramc.EY(3);
          paramc.EY(1);
          paramc.EY(4);
          paramc.EY(2);
        }
        AppMethodBeat.o(162435);
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        ac.l("safeParser", "", new Object[] { paramc });
        paramc = null;
        continue;
        paramc = null;
        continue;
        label953:
        paramc = null;
        continue;
        label958:
        int i = 0;
        continue;
        label963:
        paramc = null;
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(162436);
    ac.i("Finder.PluginFinder", "onAccountRelease");
    Object localObject = com.tencent.mm.plugin.finder.model.v.rve;
    com.tencent.mm.kernel.g.agi().b(3520, (com.tencent.mm.ak.g)localObject);
    localObject = this.qVA;
    ((com.tencent.mm.plugin.finder.upload.f)localObject).rMY.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.finder.upload.f)localObject).rNc);
    ((com.tencent.mm.plugin.finder.upload.f)localObject).rMZ.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.finder.upload.f)localObject).rNd);
    localObject = com.tencent.mm.plugin.finder.upload.f.rNg;
    localObject = com.tencent.mm.plugin.finder.upload.f.cCv();
    com.tencent.mm.plugin.finder.report.c localc = com.tencent.mm.plugin.finder.report.c.rxi;
    ((com.tencent.mm.plugin.finder.upload.f)localObject).b(com.tencent.mm.plugin.finder.report.c.cwR());
    com.tencent.mm.kernel.g.agi().b(3565, (com.tencent.mm.ak.g)this.qVB);
    com.tencent.mm.kernel.g.agi().b(3512, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().b(3870, (com.tencent.mm.ak.g)this.qVJ);
    com.tencent.mm.kernel.g.agi().b(3870, (com.tencent.mm.ak.g)this.qVK);
    com.tencent.mm.kernel.g.agi().b(3870, (com.tencent.mm.ak.g)this.qVL);
    com.tencent.mm.kernel.g.agi().b(3870, (com.tencent.mm.ak.g)this.qVM);
    com.tencent.mm.kernel.g.agi().b(665, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.i.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.g.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.f.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.h.class);
    this.qVT.dead();
    AppForegroundDelegate.cHM.b((com.tencent.mm.app.n)this.qVY);
    if (this.ghG != null)
    {
      localObject = this.ghG;
      if (localObject != null) {
        ((com.tencent.mm.storagebase.h)localObject).closeDB();
      }
      this.ghG = null;
    }
    this.DD.clear();
    this.qVU.dead();
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
    if (!isInFinder())
    {
      Object localObject = com.tencent.mm.ui.component.a.IrY;
      localObject = (FinderStreamRefreshPreload)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderStreamRefreshPreload.class);
      ((FinderStreamRefreshPreload)localObject).rvb.removeCallbacksAndMessages(null);
      int i = ((FinderStreamRefreshPreload)localObject).cFM().cFJ();
      boolean bool = ((FinderStreamRefreshPreload)localObject).cFM().ES(i);
      ac.i("Finder.StreamRefreshPreload", "[onEnterFinder] lastTabType=" + i + " isAutoRefresh=" + bool);
      if (!((FinderStreamRefreshPreload)localObject).cFM().ES(i)) {
        ((FinderStreamRefreshPreload)localObject).EY(i).clear(true);
      }
      requestAudioFocus();
    }
    if (!this.qVW.contains(paramMMFinderUI)) {
      this.qVW.add(paramMMFinderUI);
    }
    AppMethodBeat.o(165095);
  }
  
  public final void onExitFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165096);
    d.g.b.k.h(paramMMFinderUI, "finder");
    this.qVW.remove(paramMMFinderUI);
    if (!isInFinder())
    {
      paramMMFinderUI = com.tencent.mm.ui.component.a.IrY;
      Object localObject = (FinderStreamRefreshPreload)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderStreamRefreshPreload.class);
      ac.i("Finder.StreamRefreshPreload", "[onExitFinder]");
      paramMMFinderUI = ((FinderStreamRefreshPreload)localObject).rvb;
      localObject = (Runnable)localObject;
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramMMFinderUI.postDelayed((Runnable)localObject, com.tencent.mm.plugin.finder.storage.b.cAr());
      this.gGY.YC();
    }
    AppMethodBeat.o(165096);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
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
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = ((com.tencent.mm.ak.b)paramString).aBD();
      if (paramString == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetUserResponse");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = ((all)paramString).rHC;
    } while (paramString == null);
    paramString = ((Iterable)paramString).iterator();
    while (paramString.hasNext())
    {
      paramn = (FinderContact)paramString.next();
      com.tencent.mm.plugin.finder.api.b.a locala = com.tencent.mm.plugin.finder.api.b.qWt;
      d.g.b.k.g(paramn, "it");
      com.tencent.mm.plugin.finder.api.b.a.b(paramn);
    }
    AppMethodBeat.o(165099);
  }
  
  public final void reportPostRedDot(int paramInt)
  {
    AppMethodBeat.i(165122);
    com.tencent.mm.plugin.report.service.h.wUl.n(1309L, paramInt, 1L);
    com.tencent.mm.plugin.report.service.h.wUl.f(19212, new Object[] { Integer.valueOf(paramInt), Long.valueOf(ce.azH()) });
    AppMethodBeat.o(165122);
  }
  
  public final void resetConfig()
  {
    AppMethodBeat.i(165093);
    try
    {
      Object localObject = com.tencent.mm.plugin.finder.storage.data.f.rEK;
      com.tencent.mm.plugin.finder.storage.data.f.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.i.rEV;
      i.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.b.rEB;
      com.tencent.mm.plugin.finder.storage.data.b.a.clearAll();
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUs, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUt, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVF, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVG, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVH, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVI, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVJ, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVK, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTO, Long.valueOf(1L));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTQ, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTR, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTS, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTT, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTU, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTV, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTW, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTY, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUi, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUq, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVw, Integer.valueOf(0));
      clearReInit();
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUJ, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUQ, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUR, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVL, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVM, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUV, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUW, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUX, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GUY, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVa, Boolean.FALSE);
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVj, "");
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVm, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVn, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVo, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GVs, Boolean.FALSE);
      AppMethodBeat.o(165093);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("Finder.PluginFinder", (Throwable)localException, "resetConfig error", new Object[0]);
      AppMethodBeat.o(165093);
    }
  }
  
  public final void resetLastTimelineExitTime()
  {
    AppMethodBeat.i(165110);
    ac.i("Finder.PluginFinder", "reset timeline auto refresh time");
    AppMethodBeat.o(165110);
  }
  
  public final void shareStatsReport(List<String> paramList)
  {
    AppMethodBeat.i(201094);
    d.g.b.k.h(paramList, "feedIdList");
    v.f localf = new v.f();
    localf.KUQ = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      dcw localdcw = new dcw();
      localdcw.qXP = com.tencent.mm.ac.c.ur((String)localObject);
      localdcw.FMz = new cbz();
      localObject = localdcw.FMz;
      ((cbz)localObject).Fqb += 1;
      localdcw.FMz.Fqd = 1;
      ((LinkedList)localf.KUQ).add(localdcw);
    }
    new com.tencent.mm.plugin.finder.cgi.j((List)localf.KUQ, null).aBB().j((com.tencent.mm.vending.c.a)new PluginFinder.r(localf));
    AppMethodBeat.o(201094);
  }
  
  public final boolean showFinderEntry()
  {
    AppMethodBeat.i(165102);
    boolean bool1;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUX, 0) != 0)
    {
      bool1 = true;
      Object localObject = com.tencent.mm.plugin.finder.spam.a.rBD;
      int i = com.tencent.mm.plugin.finder.spam.a.aeb("entrance");
      if (i == 2)
      {
        ac.i("Finder.PluginFinder", "showFinderEntry ".concat(String.valueOf(i)));
        bool1 = false;
      }
      if (this.qVZ)
      {
        ac.i("Finder.PluginFinder", "closeFinderEntryForDebug");
        bool1 = false;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.cyN() == 0) {
        break label143;
      }
    }
    label143:
    for (boolean bool2 = true;; bool2 = false)
    {
      ac.i("Finder.PluginFinder", "showFinder %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUY, 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("Finder.PluginFinder", "showPost %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(165103);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.app.n
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(165054);
      PluginFinder.access$getAudioHelperTool$p(this.qWc).YC();
      AppMethodBeat.o(165054);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(165055);
      if (this.qWc.isInFinder()) {
        PluginFinder.access$requestAudioFocus(this.qWc);
      }
      if ((this.qWc.showFinderEntry()) && (SystemClock.uptimeMillis() - PluginFinder.access$getLastFinderInitTime$p(this.qWc) >= 86400000L)) {
        PluginFinder.access$doFinderInit(this.qWc);
      }
      AppMethodBeat.o(165055);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class c
    implements h.b
  {
    public static final c qWd;
    
    static
    {
      AppMethodBeat.i(165057);
      qWd = new c();
      AppMethodBeat.o(165057);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165056);
      Object localObject = com.tencent.mm.plugin.finder.storage.c.rCZ;
      localObject = com.tencent.mm.plugin.finder.storage.c.cty();
      AppMethodBeat.o(165056);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class d
    implements h.b
  {
    public static final d qWe;
    
    static
    {
      AppMethodBeat.i(165059);
      qWe = new d();
      AppMethodBeat.o(165059);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165058);
      Object localObject = com.tencent.mm.plugin.finder.storage.f.rDl;
      localObject = com.tencent.mm.plugin.finder.storage.f.cty();
      AppMethodBeat.o(165058);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class e
    implements h.b
  {
    public static final e qWf;
    
    static
    {
      AppMethodBeat.i(165061);
      qWf = new e();
      AppMethodBeat.o(165061);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165060);
      Object localObject = com.tencent.mm.plugin.finder.storage.l.rDP;
      localObject = com.tencent.mm.plugin.finder.storage.l.cty();
      AppMethodBeat.o(165060);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class g
    implements h.b
  {
    public static final g qWh;
    
    static
    {
      AppMethodBeat.i(178067);
      qWh = new g();
      AppMethodBeat.o(178067);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(178066);
      Object localObject = com.tencent.mm.plugin.finder.storage.a.rBJ;
      localObject = com.tencent.mm.plugin.finder.storage.a.cty();
      AppMethodBeat.o(178066);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class h
    implements h.b
  {
    public static final h qWi;
    
    static
    {
      AppMethodBeat.i(165065);
      qWi = new h();
      AppMethodBeat.o(165065);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165064);
      Object localObject = com.tencent.mm.plugin.finder.storage.g.rDm;
      localObject = com.tencent.mm.plugin.finder.storage.g.cty();
      AppMethodBeat.o(165064);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class i
    implements h.b
  {
    public static final i qWj;
    
    static
    {
      AppMethodBeat.i(201082);
      qWj = new i();
      AppMethodBeat.o(201082);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(201081);
      Object localObject = com.tencent.mm.plugin.finder.storage.q.rEs;
      localObject = com.tencent.mm.plugin.finder.storage.q.cty();
      AppMethodBeat.o(201081);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final j qWk;
    
    static
    {
      AppMethodBeat.i(165067);
      qWk = new j();
      AppMethodBeat.o(165067);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class k
    extends com.tencent.mm.sdk.b.c<fi>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderSyncEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class l
    extends com.tencent.mm.sdk.b.c<hi>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<r>
  {
    public static final m qWl;
    
    static
    {
      AppMethodBeat.i(201084);
      qWl = new m();
      AppMethodBeat.o(201084);
    }
    
    m()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final n qWm;
    
    static
    {
      AppMethodBeat.i(201086);
      qWm = new n();
      AppMethodBeat.o(201086);
    }
    
    n()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    public static final o qWn;
    
    static
    {
      AppMethodBeat.i(165072);
      qWn = new o();
      AppMethodBeat.o(165072);
    }
    
    public final void run()
    {
      AppMethodBeat.i(165071);
      com.tencent.mm.plugin.finder.upload.b.a locala = com.tencent.mm.plugin.finder.upload.b.rMB;
      com.tencent.mm.plugin.finder.upload.b.cCr().cCq();
      AppMethodBeat.o(165071);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final p qWo;
    
    static
    {
      AppMethodBeat.i(201088);
      qWo = new p();
      AppMethodBeat.o(201088);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/PluginFinder$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
  public static final class q
    implements d.a
  {
    public final void axj()
    {
      AppMethodBeat.i(165073);
      ac.i("Finder.PluginFinder", "[audioHelperTool] gain");
      AppMethodBeat.o(165073);
    }
    
    public final void axk()
    {
      AppMethodBeat.i(165075);
      ac.i("Finder.PluginFinder", "[audioHelperTool] loss");
      AppMethodBeat.o(165075);
    }
    
    public final void axl()
    {
      AppMethodBeat.i(165074);
      ac.i("Finder.PluginFinder", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(165074);
    }
    
    public final void axm()
    {
      AppMethodBeat.i(165076);
      ac.i("Finder.PluginFinder", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(165076);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder
 * JD-Core Version:    0.7.0.1
 */