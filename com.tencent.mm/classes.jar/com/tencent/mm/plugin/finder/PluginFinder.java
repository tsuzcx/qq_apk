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
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.aa.a;
import com.tencent.mm.model.aa.b;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.f.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.q.a;
import com.tencent.mm.plugin.finder.storage.p.a;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.storage.y;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.upload.g.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.wcdb.database.SQLiteException;
import d.g.b.y.a;
import d.g.b.y.f;
import d.z;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder;", "Lcom/tencent/mm/kernel/api/ICoreStorageCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "CURRENT_DB_VERSION", "", "kotlin.jvm.PlatformType", "CURRENT_DB_VERSION_DEFAULT", "actionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "appForegroundListener", "com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "closeFinderEntryForDebug", "", "contactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "conversationUpdater", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "getConversationUpdater", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "conversationUpdater$delegate", "Lkotlin/Lazy;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDataDB", "()Lcom/tencent/mm/storagebase/SqliteDB;", "setDataDB", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1;", "feedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "finderActivity", "", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "", "finderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "finderContactService", "Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "getFinderContactService", "()Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "finderContactService$delegate", "finderMentionDB", "getFinderMentionDB", "setFinderMentionDB", "finderMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "finderPrivateSysMsgConsumer", "Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "finderReInitSysMsgConsumer", "Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer;", "finderSyncEventListener", "com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1;", "followTlSingleExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getFollowTlSingleExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "followTlSingleExecutor$delegate", "getContactInterceptor", "Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "getContactInterceptor$delegate", "isDoSomethingCompleted", "isFriendCache", "Ljava/util/concurrent/ConcurrentHashMap;", "lastFinderInitTime", "", "localLikeFeedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage;", "lock", "", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "mediaPreloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getMediaPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "mediaPreloadModel$delegate", "messageDB", "getMessageDB", "setMessageDB", "messageStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage;", "modifyBlackListService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "modifyFeedSettingService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "modifyFinderFeedProduce", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "modifyFinderMessageService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "modifyFinderMessageSessionService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderMsgSessionMuteSetting;", "modifyFinderWxMessageSessionService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "modifyLikeRecommendService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "modifyUserService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "msgStrangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "needResetDb", "postManager", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "redDotCtrInfoStorage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "syncExtension", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "viewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "wxMentionDB", "getWxMentionDB", "setWxMentionDB", "wxMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "checkIfSameMsgTableName", "", "checkResetDb", "clearMentionDB", "clearReInit", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "collectFinderDatabaseFactory", "Lkotlin/collections/HashMap;", "collectMentionDatabaseFactory", "collectMessageDatabaseFactory", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "doFinderInit", "doPrepareUser", "doReInit", "reInitVersion", "reInitUsername", "doSomethingImportantOnStart", "dumpAndMarkFinderFolder", "enterFinderConversationUI", "context", "Landroid/content/Context;", "enterFinderPostRouterUI", "intent", "Landroid/content/Intent;", "enterFinderPostUI", "enterFinderProfileUI", "enterFinderSelfProfile", "enterFinderShareFeedUI", "json", "i", "enterFinderTimelineUI", "enterFinderTopicUI", "enterFinderUI", "execute", "fillContextIdToIntent", "enter", "enterType", "toCommentScene", "getContactStorage", "getConversationStorage", "getDB", "getFeedStorage", "getFinderActionStorage", "getFinderContactCache", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getLocalLikeFeedStorage", "getMediaCacheStorage", "getMentionStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "localFlag", "getMessageStorage", "getMsgStrangerContactStorage", "getRedDotCtrInfoStorage", "getRedDotManager", "getSessionInfoStorage", "getTimelineCommentScene", "getViewModelStore", "hasFinderPosted", "isFriend", "username", "isInFinder", "isNeedDoReInit", "loadImage", "url", "imageView", "Landroid/widget/ImageView;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onAppBackground", "activity", "onAppForeground", "onDataBaseClosed", "readOnlyDB", "onDataBaseOpened", "onEnterFinder", "finder", "onExitFinder", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportPostRedDot", "key", "requestAudioFocus", "requestFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectId", "objectNonceId", "commentScene", "resetConfig", "resetDb", "resetLastTimelineExitTime", "shareStatsReport", "feedIdList", "", "showFinderEntry", "showPostEntry", "snsToFinderPostReport", "sessionID", "wording", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "feedId", "timeStamp", "tryGetFinderObject", "force", "Companion", "plugin-finder_release"})
public final class PluginFinder
  extends com.tencent.mm.kernel.b.f
  implements ViewModelStoreOwner, com.tencent.mm.al.f, com.tencent.mm.app.n, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, t
{
  public static final a rGH;
  private final ViewModelStore Fu;
  private com.tencent.mm.storagebase.h gBq;
  private final com.tencent.mm.model.d haI;
  private final byte[] lock;
  private volatile boolean rFO;
  private com.tencent.mm.storagebase.h rFP;
  private com.tencent.mm.storagebase.h rFQ;
  private com.tencent.mm.storagebase.h rFR;
  private final com.tencent.mm.plugin.finder.upload.g rFS;
  private final com.tencent.mm.plugin.finder.extension.a rFT;
  private com.tencent.mm.plugin.finder.storage.c rFU;
  private com.tencent.mm.plugin.finder.storage.v rFV;
  private com.tencent.mm.plugin.finder.storage.d rFW;
  private w rFX;
  private s rFY;
  private com.tencent.mm.plugin.finder.storage.i rFZ;
  private final r rGA;
  private volatile boolean rGB;
  private final Set<MMFinderUI> rGC;
  private long rGD;
  private final b rGE;
  private boolean rGF;
  private final ConcurrentHashMap<String, Boolean> rGG;
  private com.tencent.mm.plugin.finder.storage.q rGa;
  private com.tencent.mm.plugin.finder.extension.reddot.c rGb;
  private y rGc;
  private com.tencent.mm.plugin.finder.storage.j rGd;
  private com.tencent.mm.plugin.finder.storage.a rGe;
  private com.tencent.mm.plugin.finder.storage.p rGf;
  private final com.tencent.mm.plugin.finder.cgi.oplog.f rGg;
  private final com.tencent.mm.plugin.finder.cgi.oplog.c rGh;
  private final com.tencent.mm.plugin.finder.cgi.oplog.b rGi;
  private final com.tencent.mm.plugin.finder.cgi.oplog.a rGj;
  private final com.tencent.mm.plugin.finder.cgi.oplog.g rGk;
  private final com.tencent.mm.plugin.finder.cgi.oplog.i rGl;
  private final com.tencent.mm.plugin.finder.cgi.oplog.e rGm;
  private final com.tencent.mm.plugin.finder.cgi.oplog.d rGn;
  private final com.tencent.mm.plugin.finder.conv.i rGo;
  private final com.tencent.mm.plugin.finder.newxml.a rGp;
  private final com.tencent.mm.plugin.finder.api.a rGq;
  private com.tencent.mm.plugin.finder.extension.reddot.e rGr;
  private final d.f rGs;
  private final String rGt;
  private final String rGu;
  private final d.f rGv;
  private final d.f rGw;
  private final t rGx;
  private final d.f rGy;
  private final d.f rGz;
  
  static
  {
    AppMethodBeat.i(162442);
    rGH = new a((byte)0);
    AppMethodBeat.o(162442);
  }
  
  public PluginFinder()
  {
    AppMethodBeat.i(165123);
    this.lock = new byte[0];
    g.a locala = com.tencent.mm.plugin.finder.upload.g.sJk;
    this.rFS = com.tencent.mm.plugin.finder.upload.g.cKK();
    this.rFT = new com.tencent.mm.plugin.finder.extension.a();
    this.rGg = new com.tencent.mm.plugin.finder.cgi.oplog.f();
    this.rGh = new com.tencent.mm.plugin.finder.cgi.oplog.c();
    this.rGi = new com.tencent.mm.plugin.finder.cgi.oplog.b();
    this.rGj = new com.tencent.mm.plugin.finder.cgi.oplog.a();
    this.rGk = new com.tencent.mm.plugin.finder.cgi.oplog.g();
    this.rGl = new com.tencent.mm.plugin.finder.cgi.oplog.i();
    this.rGm = new com.tencent.mm.plugin.finder.cgi.oplog.e();
    this.rGn = new com.tencent.mm.plugin.finder.cgi.oplog.d();
    this.rGo = new com.tencent.mm.plugin.finder.conv.i();
    this.rGp = new com.tencent.mm.plugin.finder.newxml.a();
    this.rGq = new com.tencent.mm.plugin.finder.api.a();
    this.rGs = d.g.O((d.g.a.a)u.rHc);
    this.rGt = com.tencent.mm.sdk.platformtools.ai.ee("FinderMM029.dbFinderMention001.db");
    this.rGu = com.tencent.mm.sdk.platformtools.ai.ee("FinderMM029.dbFinderMention001.db");
    this.rGv = d.g.O((d.g.a.a)w.rHe);
    this.rGw = d.g.O((d.g.a.a)v.rHd);
    this.rGx = new t(this);
    this.rGy = d.g.O((d.g.a.a)s.rHb);
    this.rGz = d.g.O((d.g.a.a)o.rGV);
    this.rGA = new r(this);
    this.rGC = Collections.synchronizedSet((Set)new HashSet());
    this.haI = com.tencent.mm.model.d.azW();
    this.rGE = new b(this);
    this.rGG = new ConcurrentHashMap();
    this.Fu = new ViewModelStore();
    AppMethodBeat.o(165123);
  }
  
  private final void checkIfSameMsgTableName()
  {
    AppMethodBeat.i(200974);
    Object localObject1 = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajl().get(al.a.IIu, "");
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(200974);
      throw ((Throwable)localObject1);
    }
    localObject1 = (String)localObject1;
    Object localObject2 = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajl().get(al.a.IIv, "");
    if (localObject2 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(200974);
      throw ((Throwable)localObject1);
    }
    localObject2 = (String)localObject2;
    if (((CharSequence)localObject1).length() > 0)
    {
      i = 1;
      if ((i != 0) && ((d.g.b.p.i(localObject1, ci.eZp) ^ true)))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        com.tencent.mm.plugin.finder.utils.p.cLE();
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label198;
      }
    }
    label198:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && ((d.g.b.p.i(localObject2, ci.eZq) ^ true)))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        com.tencent.mm.plugin.finder.utils.p.cLF();
      }
      AppMethodBeat.o(200974);
      return;
      i = 0;
      break;
    }
  }
  
  private final void checkResetDb()
  {
    AppMethodBeat.i(165077);
    ad.v("Finder.PluginFinder", "checkResetDb1 " + this.rFO);
    if (this.rFO)
    {
      ad.v("Finder.PluginFinder", "checkResetDb2 " + this.rFO);
      synchronized (this.lock)
      {
        Object localObject1 = new StringBuilder("checkResetDb  need reset DB now ");
        Thread localThread = Thread.currentThread();
        d.g.b.p.g(localThread, "Thread.currentThread()");
        localObject1 = ((StringBuilder)localObject1).append(localThread.getName()).append(" ");
        localThread = Thread.currentThread();
        d.g.b.p.g(localThread, "Thread.currentThread()");
        ad.i("Finder.PluginFinder", localThread.getId() + " " + hashCode());
        if (this.rFO)
        {
          resetDb();
          this.rFO = false;
          ad.i("Finder.PluginFinder", "resetDB done");
        }
        localObject1 = z.MKo;
        AppMethodBeat.o(165077);
        return;
      }
    }
    AppMethodBeat.o(165077);
  }
  
  private final void clearMentionDB()
  {
    AppMethodBeat.i(165079);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajh();
    com.tencent.mm.vfs.i.deleteFile((String)localObject + "FinderMention001.db");
    com.tencent.mm.vfs.i.deleteFile((String)localObject + "FinderMention002.db");
    this.rFP = null;
    this.rFQ = null;
    AppMethodBeat.o(165079);
  }
  
  private final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectFinderDatabaseFactory()
  {
    AppMethodBeat.i(200975);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_CONTACT_TABLE".hashCode()), d.rGK);
    ((Map)localHashMap).put(Integer.valueOf("FinderMsgContactStorage".hashCode()), e.rGL);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FEED_TABLE".hashCode()), f.rGM);
    ((Map)localHashMap).put(Integer.valueOf("FinderMediaCacheInfo".hashCode()), g.rGN);
    ((Map)localHashMap).put(Integer.valueOf("FinderRedDotInfo".hashCode()), h.rGO);
    ((Map)localHashMap).put(Integer.valueOf("FinderAction".hashCode()), i.rGP);
    Map localMap = (Map)localHashMap;
    p.a locala = com.tencent.mm.plugin.finder.storage.p.syB;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.finder.storage.p.cIA().hashCode()), PluginFinder.j.rGQ);
    AppMethodBeat.o(200975);
    return localHashMap;
  }
  
  private final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectMentionDatabaseFactory()
  {
    AppMethodBeat.i(165081);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FINDER_MENTION_TABLE".hashCode()), k.rGR);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_WX_MENTION_TABLE".hashCode()), l.rGS);
    AppMethodBeat.o(165081);
    return localHashMap;
  }
  
  private final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectMessageDatabaseFactory()
  {
    AppMethodBeat.i(200976);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FinderConversation".hashCode()), m.rGT);
    ((Map)localHashMap).put(Integer.valueOf("FinderSessionInfo".hashCode()), n.rGU);
    AppMethodBeat.o(200976);
    return localHashMap;
  }
  
  private final void doFinderInit()
  {
    AppMethodBeat.i(165088);
    ad.i("Finder.PluginFinder", "[doFinderInit] ...");
    this.rGD = SystemClock.uptimeMillis();
    com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)new as());
    AppMethodBeat.o(165088);
  }
  
  private final void doPrepareUser()
  {
    AppMethodBeat.i(165091);
    ad.i("Finder.PluginFinder", "[doPrepareUser]... ");
    ax localax = new ax(1);
    com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)localax);
    AppMethodBeat.o(165091);
  }
  
  private final void doReInit(int paramInt, String paramString)
  {
    AppMethodBeat.i(165090);
    try
    {
      com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 21L, 1L);
      Object localObject = com.tencent.mm.plugin.finder.storage.data.f.szO;
      f.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.k.sAe;
      k.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.b.szE;
      com.tencent.mm.plugin.finder.storage.data.b.a.clearAll();
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGY, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGZ, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIt, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIw, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIx, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIy, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIz, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIA, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGO, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGW, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIe, Integer.valueOf(paramInt));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGw, paramString);
      paramString = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramString.ajl().set(al.a.IIB, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramString.ajl().set(al.a.IIC, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramString.ajl().set(al.a.IIf, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramInt = paramString.ajl().getInt(al.a.IIg, 0);
      paramString = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramString.ajl().set(al.a.IIg, Integer.valueOf(paramInt + 1));
      clearReInit();
      ad.i("Finder.PluginFinder", "[doReInit] reInit done. incrementId=" + (paramInt + 1));
      AppMethodBeat.o(165090);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("Finder.PluginFinder", (Throwable)paramString, "do ReInit occur error!", new Object[0]);
      com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 22L, 1L);
      AppMethodBeat.o(165090);
    }
  }
  
  private final void doSomethingImportantOnStart()
  {
    AppMethodBeat.i(200983);
    this.rGA.alive();
    if (this.rGB)
    {
      AppMethodBeat.o(200983);
      return;
    }
    boolean bool = showFinderEntry();
    ad.i("Finder.PluginFinder", "[doSomethingImportantOnStart] " + com.tencent.mm.model.u.aAu() + " isDoSomethingCompleted=" + this.rGB + ", isShowFinderEntry=" + bool);
    if (!bool)
    {
      AppMethodBeat.o(200983);
      return;
    }
    this.rGB = true;
    bool = isNeedDoReInit();
    if (!bt.isNullOrNil(com.tencent.mm.model.u.aAu())) {
      com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 34L, 1L);
    }
    if (bool)
    {
      Object localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IIc, 0);
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.IId, "");
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(200983);
        throw ((Throwable)localObject);
      }
      doReInit(i, (String)localObject);
      doPrepareUser();
      this.rFT.fI(15357, 6);
    }
    for (;;)
    {
      getRedDotManager().prepare();
      AppMethodBeat.o(200983);
      return;
      if (bt.isNullOrNil(com.tencent.mm.model.u.aAu()))
      {
        com.tencent.mm.kernel.g.aiU().a(3930, (com.tencent.mm.al.f)this);
        com.tencent.mm.kernel.g.aiU().a(3930, (com.tencent.mm.al.f)getRedDotManager());
        doFinderInit();
        this.rFT.fI(14845, 6);
      }
    }
  }
  
  private final com.tencent.mm.plugin.finder.conv.h getConversationUpdater()
  {
    AppMethodBeat.i(200972);
    com.tencent.mm.plugin.finder.conv.h localh = (com.tencent.mm.plugin.finder.conv.h)this.rGz.getValue();
    AppMethodBeat.o(200972);
    return localh;
  }
  
  private final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(165080);
    checkResetDb();
    com.tencent.mm.storagebase.h localh = this.gBq;
    if (localh == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(165080);
    return localh;
  }
  
  private final com.tencent.mm.plugin.finder.service.a getFinderContactService()
  {
    AppMethodBeat.i(200971);
    com.tencent.mm.plugin.finder.service.a locala = (com.tencent.mm.plugin.finder.service.a)this.rGy.getValue();
    AppMethodBeat.o(200971);
    return locala;
  }
  
  private final com.tencent.mm.plugin.finder.service.c getGetContactInterceptor()
  {
    AppMethodBeat.i(200970);
    com.tencent.mm.plugin.finder.service.c localc = (com.tencent.mm.plugin.finder.service.c)this.rGw.getValue();
    AppMethodBeat.o(200970);
    return localc;
  }
  
  private final boolean isNeedDoReInit()
  {
    AppMethodBeat.i(200973);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IIf, -1);
    localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IIe, 0);
    localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    int m = ((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IIc, 0);
    localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.IId, "");
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(200973);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    int i = j;
    if (j == -1)
    {
      i = j;
      if (k != m)
      {
        i = j;
        if (m != 0)
        {
          com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
          d.g.b.p.g(locale, "MMKernel.storage()");
          locale.ajl().set(al.a.IIf, Integer.valueOf(1));
          i = 1;
        }
      }
    }
    localObject = new StringBuilder("[isNeedDoReInit] userVersion=").append(k).append(", reInitUserVersion=").append(m).append(", reInitUsername=").append((String)localObject).append(" isNeedDoReInit=");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("Finder.PluginFinder", bool);
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(200973);
      return true;
    }
    AppMethodBeat.o(200973);
    return false;
  }
  
  private final void requestAudioFocus()
  {
    AppMethodBeat.i(165098);
    this.haI.a((com.tencent.mm.model.d.a)new z());
    AppMethodBeat.o(165098);
  }
  
  private final void resetDb()
  {
    AppMethodBeat.i(165078);
    Object localObject1;
    Object localObject2;
    if (this.gBq == null)
    {
      this.gBq = new com.tencent.mm.storagebase.h();
      localObject1 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajh();
      localObject1 = (String)localObject1 + "FinderMM029.db";
      localObject2 = this.gBq;
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      if (!((com.tencent.mm.storagebase.h)localObject2).b((String)localObject1, collectFinderDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("finder db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
    }
    if (this.rFP == null)
    {
      this.rFP = new com.tencent.mm.storagebase.h();
      localObject1 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajh();
      localObject1 = (String)localObject1 + "FinderMention001.db";
      localObject2 = this.rFP;
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      if (!((com.tencent.mm.storagebase.h)localObject2).b((String)localObject1, collectMentionDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("finder finder mention db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
      checkIfSameMsgTableName();
      localObject1 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IIu, ci.eZp);
      localObject1 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IIv, ci.eZq);
    }
    if (this.rFR == null)
    {
      localObject1 = new com.tencent.mm.storagebase.h();
      localObject2 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajh();
      if (!((com.tencent.mm.storagebase.h)localObject1).b((String)localObject2 + "FinderMessage006.db", collectMessageDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("message db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
      this.rFR = ((com.tencent.mm.storagebase.h)localObject1);
    }
    if (this.rFQ == null)
    {
      this.rFQ = new com.tencent.mm.storagebase.h();
      localObject1 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajh();
      localObject1 = (String)localObject1 + "FinderMention002.db";
      localObject2 = this.rFQ;
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      if (!((com.tencent.mm.storagebase.h)localObject2).b((String)localObject1, collectMentionDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("finder wx mention db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
    }
    AppMethodBeat.o(165078);
  }
  
  public final void clearReInit()
  {
    AppMethodBeat.i(165094);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIc, Integer.valueOf(0));
    locale = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IId, "");
    AppMethodBeat.o(165094);
  }
  
  public final void closeFinderEntryForDebug()
  {
    this.rGF = true;
  }
  
  public final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(162433);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("findermessage006".hashCode()), c.rGJ);
    AppMethodBeat.o(162433);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(165092);
    com.tencent.mm.vfs.o.b("finder", "finder", 7776000000L, 19);
    AppMethodBeat.o(165092);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(200984);
    super.dependency();
    dependsOn(com.tencent.mm.plugin.byp.a.c.class);
    AppMethodBeat.o(200984);
  }
  
  public final void dumpAndMarkFinderFolder()
  {
    AppMethodBeat.i(165100);
    com.tencent.mm.ad.c.b(null, (d.g.a.a)p.rGW);
    AppMethodBeat.o(165100);
  }
  
  public final void enterFinderConversationUI(Context paramContext)
  {
    AppMethodBeat.i(200995);
    d.g.b.p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sKD;
    com.tencent.mm.plugin.finder.utils.a.eV(paramContext);
    AppMethodBeat.o(200995);
  }
  
  public final void enterFinderPostRouterUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(200988);
    d.g.b.p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sKD;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(paramContext, paramIntent);
    AppMethodBeat.o(200988);
  }
  
  public final void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162439);
    d.g.b.p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sKD;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, paramIntent);
    AppMethodBeat.o(162439);
  }
  
  public final void enterFinderProfileUI(final Context paramContext, final Intent paramIntent)
  {
    final int i = 25;
    AppMethodBeat.i(162440);
    d.g.b.p.h(paramContext, "context");
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getStringExtra("finder_username");
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    if (bt.isNullOrNil((String)localObject))
    {
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("key_finder_object_Id");
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "0";
      }
      final long l = com.tencent.mm.ad.c.xh((String)localObject);
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("key_finder_object_nonce_id_key");
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      if (paramIntent != null) {
        i = paramIntent.getIntExtra("share_enter_scene", 25);
      }
      if (l == 0L)
      {
        ad.e("Finder.PluginFinder", "enterFinderProfileUI username & objectId invalid");
        AppMethodBeat.o(162440);
        return;
      }
      com.tencent.mm.ad.c.b(null, (d.g.a.a)new q(this, l, (String)localObject, i, paramContext, paramIntent));
      AppMethodBeat.o(162440);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, paramIntent);
    com.tencent.mm.plugin.secinforeport.a.d.yBQ.asyncReportFinderSecurityInfoThroughCgi(540999686);
    AppMethodBeat.o(162440);
  }
  
  public final void enterFinderSelfProfile(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(200985);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramIntent, "intent");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sKD;
    com.tencent.mm.plugin.finder.utils.a.y(paramContext, paramIntent);
    AppMethodBeat.o(200985);
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162441);
    d.g.b.p.h(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.spam.a.suA;
    if (com.tencent.mm.plugin.finder.spam.a.ain("entrance") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.eS(paramContext);
      AppMethodBeat.o(162441);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
    com.tencent.mm.plugin.finder.utils.a.C(paramContext, paramIntent);
    com.tencent.mm.plugin.secinforeport.a.d.yBQ.asyncReportFinderSecurityInfoThroughCgi(540999685);
    AppMethodBeat.o(162441);
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(200987);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString, "json");
    try
    {
      Object localObject1 = new com.tencent.mm.ac.i(paramString);
      String str = ((com.tencent.mm.ac.i)localObject1).optString("feedId", "0");
      d.g.b.p.g(str, "jsonObject.optString(\"feedId\", \"0\")");
      long l = com.tencent.mm.ad.c.xh(str);
      Object localObject2 = ((com.tencent.mm.ac.i)localObject1).wO("extInfo");
      ad.i("Finder.PluginFinder", "json = ".concat(String.valueOf(paramString)));
      localObject1 = ((com.tencent.mm.ac.i)localObject2).getString("feedNonceId");
      int i = ((com.tencent.mm.ac.i)localObject2).optInt("reportScene", 13);
      str = ((com.tencent.mm.ac.i)localObject2).optString("encryptedObjectId", "");
      boolean bool = ((com.tencent.mm.ac.i)localObject2).optBoolean("getRelatedList", false);
      localObject2 = ((com.tencent.mm.ac.i)localObject2).optString("sessionId", "");
      paramString = paramIntent;
      if (paramIntent == null) {
        paramString = new Intent();
      }
      paramString.putExtra("report_scene", i);
      paramString.putExtra("from_user", com.tencent.mm.model.u.aAm());
      paramString.putExtra("feed_object_id", l);
      paramString.putExtra("feed_encrypted_object_id", str);
      paramString.putExtra("feed_object_nonceId", (String)localObject1);
      paramString.putExtra("key_need_related_list", bool);
      paramString.putExtra("key_session_id", (String)localObject2);
      paramString.putExtra("key_comment_scene", 39);
      paramIntent = com.tencent.mm.plugin.finder.spam.a.suA;
      if (com.tencent.mm.plugin.finder.spam.a.ain("entrance") != 0)
      {
        paramString = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.eS(paramContext);
        AppMethodBeat.o(200987);
        return;
      }
      paramIntent = com.tencent.mm.plugin.finder.utils.p.sMo;
      fillContextIdToIntent(com.tencent.mm.plugin.finder.utils.p.amg(i), 2, 39, paramString);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.C(paramContext, paramString);
      com.tencent.mm.plugin.secinforeport.a.d.yBQ.asyncReportFinderSecurityInfoThroughCgi(540999685);
      AppMethodBeat.o(200987);
      return;
    }
    catch (Throwable paramContext)
    {
      ad.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderProfileUI exception", new Object[0]);
      AppMethodBeat.o(200987);
    }
  }
  
  public final void enterFinderTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162438);
    d.g.b.p.h(paramContext, "context");
    Object localObject = com.tencent.mm.kernel.g.ad(t.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
    ((t)localObject).getRedDotManager().ahl("FinderEntrance");
    if ((paramIntent != null) && (!bt.isNullOrNil(paramIntent.getStringExtra("key_red_dot_id"))))
    {
      localObject = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.bSQ();
    }
    localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
    com.tencent.mm.plugin.finder.utils.a.v(paramContext, paramIntent);
    com.tencent.mm.plugin.secinforeport.a.d.yBQ.asyncReportFinderSecurityInfoThroughCgi(540999684);
    AppMethodBeat.o(162438);
  }
  
  public final void enterFinderTopicUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(165101);
    d.g.b.p.h(paramContext, "context");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.eS(paramContext);
      AppMethodBeat.o(165101);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sKD;
    com.tencent.mm.plugin.finder.utils.a.J(paramContext, paramIntent);
    AppMethodBeat.o(165101);
  }
  
  public final void enterFinderUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(200986);
    d.g.b.p.h(paramContext, "context");
    for (;;)
    {
      Object localObject;
      String str1;
      boolean bool;
      try
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (!com.tencent.mm.plugin.finder.storage.b.cFc())
        {
          ad.i("Finder.PluginFinder", "enterFinderUI clicfg_ultron_finder_mp_jsapi switch close");
          AppMethodBeat.o(200986);
          return;
        }
        localObject = new com.tencent.mm.ac.i(paramString).wO("extInfo");
        str1 = ((com.tencent.mm.ac.i)localObject).getString("action");
        ad.i("Finder.PluginFinder", "json = ".concat(String.valueOf(paramString)));
        if (str1 == null)
        {
          ad.i("Finder.PluginFinder", "unKnow action:".concat(String.valueOf(str1)));
          AppMethodBeat.o(200986);
          return;
        }
        switch (str1.hashCode())
        {
        case -412058418: 
          if (!str1.equals("openFinderFeed")) {
            continue;
          }
          str1 = ((com.tencent.mm.ac.i)localObject).optString("feedID");
          String str2 = ((com.tencent.mm.ac.i)localObject).optString("nonceID");
          if (((com.tencent.mm.ac.i)localObject).optInt("notGetReleatedList") != 0) {
            break label443;
          }
          bool = true;
          int i = ((com.tencent.mm.ac.i)localObject).optInt("shareScene", 0);
          paramString = new Intent();
          paramString.putExtra("from_user", com.tencent.mm.model.u.aAm());
          paramString.putExtra("feed_encrypted_object_id", str1);
          paramString.putExtra("feed_object_nonceId", str2);
          paramString.putExtra("key_need_related_list", bool);
          paramString.putExtra("key_comment_scene", 39);
          ((t)com.tencent.mm.kernel.g.ad(t.class)).fillContextIdToIntent(5, 2, 39, paramString);
          paramString.putExtra("report_scene", i);
          localObject = com.tencent.mm.plugin.finder.spam.a.suA;
          if (com.tencent.mm.plugin.finder.spam.a.ain("entrance") == 0) {
            break label414;
          }
          paramString = com.tencent.mm.plugin.finder.utils.a.sKD;
          com.tencent.mm.plugin.finder.utils.a.eS(paramContext);
          AppMethodBeat.o(200986);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        ad.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderUI exception", new Object[0]);
        AppMethodBeat.o(200986);
        return;
      }
      if (str1.equals("openFinderProfile"))
      {
        paramString = ((com.tencent.mm.ac.i)localObject).optString("feedID");
        str1 = ((com.tencent.mm.ac.i)localObject).optString("finderUserName");
        localObject = new Intent();
        ((Intent)localObject).putExtra("finder_username", str1);
        ((Intent)localObject).putExtra("finder_read_feed_id", paramString);
        paramString = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, (Intent)localObject);
        AppMethodBeat.o(200986);
        return;
        label414:
        localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.C(paramContext, paramString);
        com.tencent.mm.plugin.secinforeport.a.d.yBQ.asyncReportFinderSecurityInfoThroughCgi(540999685);
        AppMethodBeat.o(200986);
        return;
        continue;
        label443:
        bool = false;
      }
    }
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(162434);
    d.g.b.p.h(paramg, "profile");
    AppMethodBeat.o(162434);
  }
  
  public final String fillContextIdToIntent(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(200999);
    String str = UUID.randomUUID().toString();
    d.g.b.p.g(str, "UUID.randomUUID().toString()");
    str = d.n.n.h(str, "-", "", false);
    str = paramInt1 + '-' + paramInt2 + '-' + paramInt3 + '-' + str;
    if (paramIntent != null) {
      paramIntent.putExtra("key_context_id", str);
    }
    paramIntent = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(paramIntent, "MMKernel.storage()");
    paramIntent.ajl().set(al.a.IIV, str);
    AppMethodBeat.o(200999);
    return str;
  }
  
  public final com.tencent.mm.plugin.finder.storage.c getContactStorage()
  {
    AppMethodBeat.i(165082);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.finder.storage.c localc2 = this.rFU;
    com.tencent.mm.plugin.finder.storage.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.finder.storage.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rFU = localc1;
    localc1 = this.rFU;
    if (localc1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(165082);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.d getConversationStorage()
  {
    AppMethodBeat.i(200978);
    com.tencent.mm.plugin.finder.storage.d locald = this.rFW;
    Object localObject = locald;
    if (locald == null)
    {
      localObject = this.rFR;
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      localObject = new com.tencent.mm.plugin.finder.storage.d((com.tencent.mm.sdk.e.e)localObject);
    }
    this.rFW = ((com.tencent.mm.plugin.finder.storage.d)localObject);
    localObject = this.rFW;
    if (localObject == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(200978);
    return localObject;
  }
  
  public final com.tencent.mm.storagebase.h getDataDB()
  {
    return this.gBq;
  }
  
  public final com.tencent.mm.plugin.finder.storage.i getFeedStorage()
  {
    AppMethodBeat.i(165083);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.finder.storage.i locali2 = this.rFZ;
    com.tencent.mm.plugin.finder.storage.i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new com.tencent.mm.plugin.finder.storage.i((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rFZ = locali1;
    locali1 = this.rFZ;
    if (locali1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(165083);
    return locali1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.a getFinderActionStorage()
  {
    AppMethodBeat.i(165086);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.finder.storage.a locala2 = this.rGe;
    com.tencent.mm.plugin.finder.storage.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.tencent.mm.plugin.finder.storage.a((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rGe = locala1;
    locala1 = this.rGe;
    if (locala1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(165086);
    return locala1;
  }
  
  public final com.tencent.mm.plugin.finder.api.a getFinderContactCache()
  {
    return this.rGq;
  }
  
  public final com.tencent.mm.storagebase.h getFinderMentionDB()
  {
    return this.rFP;
  }
  
  public final com.tencent.mm.plugin.finder.api.e getFinderSyncExtension()
  {
    return (com.tencent.mm.plugin.finder.api.e)this.rFT;
  }
  
  public final com.tencent.mm.loader.g.i getFollowTlSingleExecutor()
  {
    AppMethodBeat.i(200968);
    com.tencent.mm.loader.g.i locali = (com.tencent.mm.loader.g.i)this.rGs.getValue();
    AppMethodBeat.o(200968);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.storage.p getLocalLikeFeedStorage()
  {
    AppMethodBeat.i(200982);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.finder.storage.p localp2 = this.rGf;
    com.tencent.mm.plugin.finder.storage.p localp1 = localp2;
    if (localp2 == null) {
      localp1 = new com.tencent.mm.plugin.finder.storage.p((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rGf = localp1;
    localp1 = this.rGf;
    if (localp1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(200982);
    return localp1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.q getMediaCacheStorage()
  {
    AppMethodBeat.i(165084);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.finder.storage.q localq2 = this.rGa;
    com.tencent.mm.plugin.finder.storage.q localq1 = localq2;
    if (localq2 == null) {
      localq1 = new com.tencent.mm.plugin.finder.storage.q((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rGa = localq1;
    localq1 = this.rGa;
    if (localq1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(165084);
    return localq1;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.a getMediaPreloadModel()
  {
    AppMethodBeat.i(200969);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.rGv.getValue();
    AppMethodBeat.o(200969);
    return locala;
  }
  
  public final com.tencent.mm.sdk.e.j<ci> getMentionStorage(int paramInt)
  {
    AppMethodBeat.i(200981);
    com.tencent.mm.kernel.g.ajA().aiF();
    checkResetDb();
    if (paramInt == 1)
    {
      localObject2 = this.rGc;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.rFQ;
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        localObject1 = new y((com.tencent.mm.sdk.e.e)localObject1);
      }
      this.rGc = ((y)localObject1);
      localObject1 = this.rGc;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      localObject1 = (com.tencent.mm.sdk.e.j)localObject1;
      AppMethodBeat.o(200981);
      return localObject1;
    }
    Object localObject2 = this.rGd;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.rFP;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      localObject1 = new com.tencent.mm.plugin.finder.storage.j((com.tencent.mm.sdk.e.e)localObject1);
    }
    this.rGd = ((com.tencent.mm.plugin.finder.storage.j)localObject1);
    localObject1 = this.rGd;
    if (localObject1 == null) {
      d.g.b.p.gfZ();
    }
    localObject1 = (com.tencent.mm.sdk.e.j)localObject1;
    AppMethodBeat.o(200981);
    return localObject1;
  }
  
  public final com.tencent.mm.storagebase.h getMessageDB()
  {
    return this.rFR;
  }
  
  public final s getMessageStorage()
  {
    AppMethodBeat.i(200980);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).dlK();
    s locals = this.rFY;
    localObject = locals;
    if (locals == null)
    {
      d.g.b.p.g(locali, "msgStg");
      localObject = new s(locali);
    }
    this.rFY = ((s)localObject);
    localObject = this.rFY;
    if (localObject == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(200980);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.storage.v getMsgStrangerContactStorage()
  {
    AppMethodBeat.i(200977);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.finder.storage.v localv2 = this.rFV;
    com.tencent.mm.plugin.finder.storage.v localv1 = localv2;
    if (localv2 == null) {
      localv1 = new com.tencent.mm.plugin.finder.storage.v((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rFV = localv1;
    localv1 = this.rFV;
    if (localv1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(200977);
    return localv1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.c getRedDotCtrInfoStorage()
  {
    AppMethodBeat.i(178074);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.finder.extension.reddot.c localc2 = this.rGb;
    com.tencent.mm.plugin.finder.extension.reddot.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.finder.extension.reddot.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rGb = localc1;
    localc1 = this.rGb;
    if (localc1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(178074);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.e getRedDotManager()
  {
    AppMethodBeat.i(178072);
    com.tencent.mm.plugin.finder.extension.reddot.e locale2 = this.rGr;
    com.tencent.mm.plugin.finder.extension.reddot.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new com.tencent.mm.plugin.finder.extension.reddot.e(getRedDotCtrInfoStorage());
    }
    this.rGr = locale1;
    locale1 = this.rGr;
    if (locale1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(178072);
    return locale1;
  }
  
  public final w getSessionInfoStorage()
  {
    AppMethodBeat.i(200979);
    com.tencent.mm.kernel.g.ajA().aiF();
    w localw = this.rFX;
    Object localObject = localw;
    if (localw == null)
    {
      localObject = this.rFR;
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      localObject = new w((com.tencent.mm.sdk.e.e)localObject);
    }
    this.rFX = ((w)localObject);
    localObject = this.rFX;
    if (localObject == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(200979);
    return localObject;
  }
  
  public final int getTimelineCommentScene()
  {
    AppMethodBeat.i(200996);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    switch (((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).fsM())
    {
    case 2: 
    default: 
      AppMethodBeat.o(200996);
      return 1;
    case 3: 
      AppMethodBeat.o(200996);
      return 17;
    case 1: 
      AppMethodBeat.o(200996);
      return 18;
    }
    AppMethodBeat.o(200996);
    return 20;
  }
  
  public final ViewModelStore getViewModelStore()
  {
    return this.Fu;
  }
  
  public final com.tencent.mm.storagebase.h getWxMentionDB()
  {
    return this.rFQ;
  }
  
  public final boolean hasFinderPosted()
  {
    AppMethodBeat.i(200997);
    String str = com.tencent.mm.model.u.aAu();
    if (bt.isNullOrNil(com.tencent.mm.model.u.aAu()))
    {
      AppMethodBeat.o(200997);
      return false;
    }
    k.a locala = com.tencent.mm.plugin.finder.storage.data.k.sAe;
    d.g.b.p.g(str, "username");
    if (!((Collection)k.a.ds(str, 1)).isEmpty())
    {
      AppMethodBeat.o(200997);
      return true;
    }
    AppMethodBeat.o(200997);
    return false;
  }
  
  public final boolean isFriend(String paramString)
  {
    AppMethodBeat.i(165116);
    if (paramString != null)
    {
      Boolean localBoolean = (Boolean)this.rGG.get(paramString);
      Object localObject = localBoolean;
      if (localBoolean == null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject = Boolean.valueOf(com.tencent.mm.plugin.finder.utils.p.isFriend(paramString));
        ((Map)this.rGG).put(paramString, localObject);
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
    if (this.rGC.size() > 0)
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
    d.g.b.p.h(paramString, "url");
    d.g.b.p.h(paramImageView, "imageView");
    Object localObject = new bvf();
    ((bvf)localObject).mediaId = com.tencent.mm.sdk.platformtools.ai.ee(paramString);
    ((bvf)localObject).url = paramString;
    ((bvf)localObject).thumbUrl = paramString;
    paramString = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject, com.tencent.mm.plugin.finder.storage.r.syE);
    localObject = com.tencent.mm.plugin.finder.loader.i.sja;
    com.tencent.mm.plugin.finder.loader.i.cCB().bI(paramString).c(paramImageView);
    AppMethodBeat.o(178075);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(162435);
    com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 40L, 1L);
    this.rFO = true;
    checkResetDb();
    paramc = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(paramc, "MMKernel.storage()");
    paramc = paramc.ajl().get(al.a.IGX, this.rGu);
    ad.i("Finder.PluginFinder", "onAccountInitialized " + this.rFO + ' ' + this.rGt + ' ' + paramc);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    if ((d.g.b.p.i(((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.IGX, this.rGt), this.rGt) ^ true))
    {
      ad.i("Finder.PluginFinder", "resetConfig oldVer:" + paramc + " CURRENT_DB_VERSION:" + this.rGt);
      resetConfig();
    }
    paramc = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(paramc, "MMKernel.storage()");
    paramc.ajl().set(al.a.IGX, this.rGt);
    paramc = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(paramc, "MMKernel.storage()");
    int i = paramc.ajl().getInt(al.a.IIg, -1);
    if (i == -1)
    {
      paramc = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramc, "MMKernel.storage()");
      int j = paramc.ajl().getInt(al.a.IIe, 0);
      paramc = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramc, "MMKernel.storage()");
      paramc.ajl().set(al.a.IIg, Integer.valueOf(j));
      ad.i("Finder.PluginFinder", "[onAccountInitialized] user auto increment id=" + i + " userVersion=" + j);
    }
    for (;;)
    {
      paramc = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      d.g.b.p.g(paramc, "MMKernel.service(IMessengerStorage::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.l)paramc).dlK().a((com.tencent.mm.storage.e)getMessageStorage());
      paramc = com.tencent.mm.plugin.finder.cgi.x.rIV;
      com.tencent.mm.plugin.finder.cgi.x.cxZ();
      doSomethingImportantOnStart();
      paramc = com.tencent.mm.plugin.finder.shell.a.suz;
      com.tencent.mm.plugin.finder.shell.a.setup();
      paramc = this.rFS;
      paramc.hfB.a((com.tencent.mm.loader.g.f)paramc.sJg);
      paramc.sJd.a((com.tencent.mm.loader.g.f)paramc.sJh);
      paramc = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramc, "MMKernel.storage()");
      paramc.ajl().set(al.a.IGC, "");
      com.tencent.mm.kernel.g.aiU().a(3565, (com.tencent.mm.al.f)this.rFT);
      com.tencent.mm.kernel.g.aiU().a(3512, (com.tencent.mm.al.f)this);
      com.tencent.mm.kernel.g.aiU().a(3870, (com.tencent.mm.al.f)this.rGg);
      com.tencent.mm.kernel.g.aiU().a(3870, (com.tencent.mm.al.f)this.rGh);
      com.tencent.mm.kernel.g.aiU().a(3870, (com.tencent.mm.al.f)this.rGi);
      com.tencent.mm.kernel.g.aiU().a(3870, (com.tencent.mm.al.f)this.rGj);
      com.tencent.mm.kernel.g.aiU().a(3870, (com.tencent.mm.al.f)this.rGk);
      com.tencent.mm.kernel.g.aiU().a(3870, (com.tencent.mm.al.f)this.rGl);
      com.tencent.mm.kernel.g.aiU().a(3870, (com.tencent.mm.al.f)this.rGm);
      com.tencent.mm.kernel.g.aiU().a(3870, (com.tencent.mm.al.f)this.rGn);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.n.class, (com.tencent.mm.kernel.c.a)this.rGg);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.m.class, (com.tencent.mm.kernel.c.a)this.rGh);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.h.class, (com.tencent.mm.kernel.c.a)this.rGi);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.k.class, (com.tencent.mm.kernel.c.a)this.rGj);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.i.class, (com.tencent.mm.kernel.c.a)this.rGk);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.q.class, (com.tencent.mm.kernel.c.a)this.rGl);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.l.class, (com.tencent.mm.kernel.c.a)this.rGm);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.j.class, (com.tencent.mm.kernel.c.a)this.rGn);
      paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class);
      d.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.r)paramc).getSysCmdMsgExtension().a("FinderPersonalMsgSysMsg", (com.tencent.mm.plugin.messenger.foundation.a.p)this.rGo);
      paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class);
      d.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.r)paramc).getSysCmdMsgExtension().a("finderuserreinit", (com.tencent.mm.plugin.messenger.foundation.a.p)this.rGp);
      boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().db.execSQL("FinderAction", "DELETE FROM FinderAction WHERE actionType = 1");
      ad.i(com.tencent.mm.plugin.finder.storage.a.TAG, "cleanCanRemoveFeed ret" + bool + ' ' + "DELETE FROM FinderAction WHERE actionType = 1");
      if (showFinderEntry()) {
        com.tencent.e.h.LTJ.aR((Runnable)x.rHf);
      }
      paramc = com.tencent.mm.plugin.finder.api.c.rHn;
      paramc = c.a.cxJ();
      paramc.rHt = true;
      c.a.d(paramc);
      this.rGx.alive();
      paramc = com.tencent.mm.plugin.finder.upload.action.g.sKi;
      com.tencent.mm.plugin.finder.upload.action.g.cKV();
      paramc = com.tencent.mm.plugin.finder.upload.g.sJk;
      paramc = com.tencent.mm.plugin.finder.upload.g.cKK();
      localObject = com.tencent.mm.plugin.finder.report.f.soC;
      paramc.a(com.tencent.mm.plugin.finder.report.f.cDw());
      AppForegroundDelegate.cSQ.a((com.tencent.mm.app.n)this.rGE);
      paramc = com.tencent.mm.plugin.finder.model.x.skz;
      com.tencent.mm.plugin.finder.model.x.sv();
      paramc = com.tencent.mm.plugin.finder.storage.data.q.sAn;
      paramc = (com.tencent.mm.bx.a)new aqs();
      localObject = com.tencent.mm.vfs.i.aY(com.tencent.mm.plugin.finder.storage.data.q.cJm(), 0, -1);
      try
      {
        paramc.parseFrom((byte[])localObject);
        localObject = (aqs)paramc;
        StringBuilder localStringBuilder = new StringBuilder("[setup] isExist=").append(com.tencent.mm.vfs.i.fv(com.tencent.mm.plugin.finder.storage.data.q.cJm())).append(" touchFile=").append(com.tencent.mm.plugin.finder.storage.data.q.cJm()).append(" info: ");
        if (localObject != null)
        {
          paramc = Integer.valueOf(((aqs)localObject).crashCount);
          localStringBuilder = localStringBuilder.append(paramc).append(' ');
          if (localObject == null) {
            break label1506;
          }
          paramc = Long.valueOf(((aqs)localObject).GoL);
          ad.i("Finder.PageRecovery", paramc);
          if (localObject != null)
          {
            if (((aqs)localObject).crashCount < 2) {
              break label1511;
            }
            i = 1;
            if (i == 0) {
              break label1516;
            }
            paramc = (e.c)localObject;
            if (paramc != null)
            {
              paramc = com.tencent.mm.plugin.finder.storage.data.k.sAe;
              k.a.clearAll();
              paramc = com.tencent.mm.plugin.finder.storage.data.q.sAn;
              com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.plugin.finder.storage.data.q.cJm());
            }
          }
          au.a((au.c)new q.a((aqs)localObject));
          com.tencent.mm.ad.c.b(null, (d.g.a.a)y.rHg);
          paramc = com.tencent.mm.ui.component.a.KiD;
          paramc = (FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class);
          bool = FinderStreamTabPreloadCore.isEnable();
          ad.i("Finder.StreamTabPreloadCore", "isEnable=".concat(String.valueOf(bool)));
          if (bool)
          {
            paramc.INk.alive();
            localObject = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
            localObject = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
            com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.czU(), (Observer)paramc);
            AppForegroundDelegate.cSQ.a((com.tencent.mm.app.n)paramc);
          }
          com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.p.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.service.d());
          com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.f.class, (com.tencent.mm.kernel.c.a)getFinderContactService());
          com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.g.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.service.b());
          ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.byp.a.c.class)).addBypSyncHandler(1, (com.tencent.mm.plugin.byp.a.b)new com.tencent.mm.plugin.finder.message.a());
          paramc = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          d.g.b.p.g(paramc, "MMKernel.service(IMessengerStorage::class.java)");
          ((com.tencent.mm.plugin.messenger.foundation.a.l)paramc).azv().a((com.tencent.mm.plugin.messenger.foundation.a.g)getConversationUpdater());
          paramc = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          d.g.b.p.g(paramc, "MMKernel.service(IMessengerStorage::class.java)");
          ((com.tencent.mm.plugin.messenger.foundation.a.l)paramc).azp().a(getFinderContactService().stV);
          com.tencent.mm.ad.c.b(null, (d.g.a.a)new com.tencent.mm.plugin.finder.conv.h.b(getConversationUpdater()));
          paramc = a.b.fbx();
          if ((paramc instanceof com.tencent.mm.pluginsdk.ui.b))
          {
            localObject = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.pluginsdk.ui.b)paramc).fby());
            ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@findermsg", (j.a)localObject);
            ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@finder", (j.a)localObject);
            ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@findermsgstranger", (j.a)localObject);
          }
          aa.a.a((aa.b)getGetContactInterceptor());
          com.tencent.mm.plugin.finder.report.u.cEv().Cx();
          AppMethodBeat.o(162435);
          return;
          ad.i("Finder.PluginFinder", "[onAccountInitialized] user auto increment id=".concat(String.valueOf(i)));
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
          label1506:
          paramc = null;
          continue;
          label1511:
          i = 0;
          continue;
          label1516:
          paramc = null;
        }
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(162436);
    ad.i("Finder.PluginFinder", "onAccountRelease");
    Object localObject = com.tencent.mm.plugin.finder.model.x.skz;
    com.tencent.mm.kernel.g.aiU().b(3520, (com.tencent.mm.al.f)localObject);
    localObject = this.rFS;
    ((com.tencent.mm.plugin.finder.upload.g)localObject).hfB.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.finder.upload.g)localObject).sJg);
    ((com.tencent.mm.plugin.finder.upload.g)localObject).sJd.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.finder.upload.g)localObject).sJh);
    localObject = com.tencent.mm.plugin.finder.upload.g.sJk;
    localObject = com.tencent.mm.plugin.finder.upload.g.cKK();
    com.tencent.mm.plugin.finder.report.f localf = com.tencent.mm.plugin.finder.report.f.soC;
    ((com.tencent.mm.plugin.finder.upload.g)localObject).b(com.tencent.mm.plugin.finder.report.f.cDw());
    com.tencent.mm.kernel.g.aiU().b(3565, (com.tencent.mm.al.f)this.rFT);
    com.tencent.mm.kernel.g.aiU().b(3512, (com.tencent.mm.al.f)this);
    com.tencent.mm.kernel.g.aiU().b(3870, (com.tencent.mm.al.f)this.rGg);
    com.tencent.mm.kernel.g.aiU().b(3870, (com.tencent.mm.al.f)this.rGh);
    com.tencent.mm.kernel.g.aiU().b(3870, (com.tencent.mm.al.f)this.rGi);
    com.tencent.mm.kernel.g.aiU().b(3870, (com.tencent.mm.al.f)this.rGj);
    com.tencent.mm.kernel.g.aiU().b(3870, (com.tencent.mm.al.f)this.rGk);
    com.tencent.mm.kernel.g.aiU().b(3870, (com.tencent.mm.al.f)this.rGl);
    com.tencent.mm.kernel.g.aiU().b(3870, (com.tencent.mm.al.f)this.rGm);
    com.tencent.mm.kernel.g.aiU().b(3870, (com.tencent.mm.al.f)this.rGn);
    com.tencent.mm.kernel.g.aiU().b(665, (com.tencent.mm.al.f)this);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.n.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.l.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.j.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.m.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.h.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.k.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.i.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.q.class);
    this.rGx.dead();
    AppForegroundDelegate.cSQ.b((com.tencent.mm.app.n)this.rGE);
    localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.r)localObject).getSysCmdMsgExtension().b("FinderPersonalMsgSysMsg", (com.tencent.mm.plugin.messenger.foundation.a.p)this.rGo);
    localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.r)localObject).getSysCmdMsgExtension().b("finderuserreinit", (com.tencent.mm.plugin.messenger.foundation.a.p)this.rGp);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(1);
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azv().b((com.tencent.mm.plugin.messenger.foundation.a.g)getConversationUpdater());
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().b(getFinderContactService().stV);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.f.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.p.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.g.class);
    aa.a.b((aa.b)getGetContactInterceptor());
    localObject = a.b.fbx();
    if ((localObject instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      ((com.tencent.mm.pluginsdk.ui.b)localObject).aMs("@findermsg");
      ((com.tencent.mm.pluginsdk.ui.b)localObject).aMs("@finder");
    }
    if (this.gBq != null)
    {
      localObject = this.gBq;
      if (localObject != null) {
        ((com.tencent.mm.storagebase.h)localObject).closeDB();
      }
      this.gBq = null;
    }
    this.Fu.clear();
    this.rGA.dead();
    com.tencent.mm.plugin.finder.report.u.cEv().unregister();
    AppMethodBeat.o(162436);
  }
  
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString) {}
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onEnterFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165095);
    d.g.b.p.h(paramMMFinderUI, "finder");
    if (!isInFinder())
    {
      Object localObject = com.tencent.mm.ui.component.a.KiD;
      localObject = ((Iterable)((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).INi).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.finder.preload.tabPreload.f localf = (com.tencent.mm.plugin.finder.preload.tabPreload.f)((Iterator)localObject).next();
        ad.i(localf.TAG, "[performEnterFinder]");
        localf.INr = true;
        localf.INs.axH("performEnterFinder");
      }
      requestAudioFocus();
    }
    if (!this.rGC.contains(paramMMFinderUI)) {
      this.rGC.add(paramMMFinderUI);
    }
    AppMethodBeat.o(165095);
  }
  
  public final void onExitFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165096);
    d.g.b.p.h(paramMMFinderUI, "finder");
    this.rGC.remove(paramMMFinderUI);
    if (!isInFinder())
    {
      paramMMFinderUI = com.tencent.mm.ui.component.a.KiD;
      paramMMFinderUI = ((Iterable)((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).INi).iterator();
      while (paramMMFinderUI.hasNext())
      {
        com.tencent.mm.plugin.finder.preload.tabPreload.f localf = (com.tencent.mm.plugin.finder.preload.tabPreload.f)paramMMFinderUI.next();
        ad.i(localf.TAG, "[performExitFinder]");
        localf.INr = false;
        localf.INs.a(localf.INw, localf.bEh(), "performExitFinder");
      }
      this.haI.abe();
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
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = ((com.tencent.mm.al.b)paramString).aEF();
      if (paramString == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetUserResponse");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = ((aoq)paramString).Gmj;
    } while (paramString == null);
    paramString = ((Iterable)paramString).iterator();
    while (paramString.hasNext())
    {
      paramn = (FinderContact)paramString.next();
      c.a locala = com.tencent.mm.plugin.finder.api.c.rHn;
      d.g.b.p.g(paramn, "it");
      c.a.b(paramn);
    }
    AppMethodBeat.o(165099);
  }
  
  public final void reportPostRedDot(int paramInt)
  {
    AppMethodBeat.i(165122);
    com.tencent.mm.plugin.report.service.g.yhR.n(1309L, paramInt, 1L);
    com.tencent.mm.plugin.report.service.g.yhR.f(19212, new Object[] { Integer.valueOf(paramInt), Long.valueOf(cf.aCK()) });
    AppMethodBeat.o(165122);
  }
  
  public final FinderObject requestFinderObject(final long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(200993);
    ad.i("Finder.PluginFinder", "requestFinderObject " + paramLong + ", enter");
    y.f localf = new y.f();
    final Object localObject = com.tencent.mm.plugin.finder.storage.data.d.szI;
    localf.MLV = com.tencent.mm.plugin.finder.storage.data.d.a.wT(paramLong);
    localObject = new Object();
    final y.a locala = new y.a();
    locala.MLQ = false;
    if ((FinderItem)localf.MLV == null)
    {
      ad.i("Finder.PluginFinder", "requestFinderObject " + paramLong + ", start");
      new com.tencent.mm.plugin.finder.cgi.q(paramLong, paramString, paramInt, 2, "", true, null, null, 0L, null, false, false, null, null, 0, 24512).aED().h((com.tencent.mm.vending.c.a)new aa(localf, localObject, locala, paramLong));
    }
    if ((FinderItem)localf.MLV == null) {}
    try
    {
      if (!locala.MLQ)
      {
        ad.i("Finder.PluginFinder", "requestFinderObject wait ".concat(String.valueOf(paramLong)));
        localObject.wait(2000L);
        ad.i("Finder.PluginFinder", "requestFinderObject notify ".concat(String.valueOf(paramLong)));
      }
      paramString = z.MKo;
      paramString = (FinderItem)localf.MLV;
      if (paramString != null)
      {
        paramString = paramString.getFeedObject();
        AppMethodBeat.o(200993);
        return paramString;
      }
    }
    finally
    {
      AppMethodBeat.o(200993);
    }
    AppMethodBeat.o(200993);
    return null;
  }
  
  public final void resetConfig()
  {
    AppMethodBeat.i(165093);
    try
    {
      Object localObject = com.tencent.mm.plugin.finder.storage.data.f.szO;
      f.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.k.sAe;
      k.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.b.szE;
      com.tencent.mm.plugin.finder.storage.data.b.a.clearAll();
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGY, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGZ, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIt, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIw, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIx, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIy, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIz, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIA, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGu, Long.valueOf(1L));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGw, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGx, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGy, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGz, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGA, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGB, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGC, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGE, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGO, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGW, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIe, Integer.valueOf(0));
      clearReInit();
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHp, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHx, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHy, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIB, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIC, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHC, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHD, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHE, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHF, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHG, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHI, Boolean.FALSE);
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHR, "");
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHU, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHV, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IHW, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IIa, Boolean.FALSE);
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
  
  public final void setDataDB(com.tencent.mm.storagebase.h paramh)
  {
    this.gBq = paramh;
  }
  
  public final void setFinderMentionDB(com.tencent.mm.storagebase.h paramh)
  {
    this.rFP = paramh;
  }
  
  public final void setMessageDB(com.tencent.mm.storagebase.h paramh)
  {
    this.rFR = paramh;
  }
  
  public final void setWxMentionDB(com.tencent.mm.storagebase.h paramh)
  {
    this.rFQ = paramh;
  }
  
  public final void shareStatsReport(List<String> paramList)
  {
    AppMethodBeat.i(200989);
    d.g.b.p.h(paramList, "feedIdList");
    y.f localf = new y.f();
    localf.MLV = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      dij localdij = new dij();
      localdij.rIZ = com.tencent.mm.ad.c.xh((String)localObject);
      localdij.Hxh = new cgq();
      localObject = localdij.Hxh;
      ((cgq)localObject).GZL += 1;
      localdij.Hxh.GZN = 1;
      ((LinkedList)localf.MLV).add(localdij);
    }
    new com.tencent.mm.plugin.finder.cgi.l((List)localf.MLV, null).aED().j((com.tencent.mm.vending.c.a)new ab(localf));
    AppMethodBeat.o(200989);
  }
  
  public final boolean showFinderEntry()
  {
    AppMethodBeat.i(165102);
    boolean bool1;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzG, 0) != 0)
    {
      bool1 = true;
      Object localObject = com.tencent.mm.plugin.finder.spam.a.suA;
      int i = com.tencent.mm.plugin.finder.spam.a.ain("entrance");
      if (i == 2)
      {
        ad.i("Finder.PluginFinder", "showFinderEntry ".concat(String.valueOf(i)));
        bool1 = false;
      }
      if (this.rGF)
      {
        ad.i("Finder.PluginFinder", "closeFinderEntryForDebug");
        bool1 = false;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cFI() == 0) {
        break label151;
      }
    }
    label151:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((!bool2) || (!bool1)) {
        ad.i("Finder.PluginFinder", "showFinder %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
      if ((!bool1) && (!bool2)) {
        break label156;
      }
      AppMethodBeat.o(165102);
      return true;
      bool1 = false;
      break;
    }
    label156:
    AppMethodBeat.o(165102);
    return false;
  }
  
  public final boolean showPostEntry()
  {
    AppMethodBeat.i(165103);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzH, 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("Finder.PluginFinder", "showPost %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(165103);
      return bool;
    }
  }
  
  public final void snsToFinderPostReport(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(200998);
    d.g.b.p.h(paramString1, "sessionID");
    d.g.b.p.h(paramString2, "wording");
    com.tencent.mm.plugin.finder.report.m localm = com.tencent.mm.plugin.finder.report.m.spK;
    com.tencent.mm.plugin.finder.report.m.a(paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(200998);
  }
  
  public final FinderObject tryGetFinderObject(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(200990);
    paramString = tryGetFinderObject(paramLong, paramString, paramInt, true);
    AppMethodBeat.o(200990);
    return paramString;
  }
  
  public final FinderObject tryGetFinderObject(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(200992);
    ad.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", enter");
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.finder.storage.data.d.szI;
      com.tencent.mm.plugin.finder.storage.data.d.a.tB(paramLong);
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.data.d.szI;
    localObject = com.tencent.mm.plugin.finder.storage.data.d.a.wT(paramLong);
    if (localObject == null)
    {
      ad.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", start");
      new com.tencent.mm.plugin.finder.cgi.q(paramLong, paramString, paramInt, 2, "", true, null, null, 0L, null, false, false, null, null, 0, 24512).aED().h((com.tencent.mm.vending.c.a)new ac(paramLong));
    }
    if (localObject != null)
    {
      paramString = ((FinderItem)localObject).getFeedObject();
      AppMethodBeat.o(200992);
      return paramString;
    }
    AppMethodBeat.o(200992);
    return null;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/PluginFinder$Companion;", "", "()V", "ID_KEY_POST_RED_DOT", "", "KV_ID_POST_RED_DOT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class aa<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    aa(y.f paramf, Object paramObject, y.a parama, long paramLong) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class ab<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    ab(y.f paramf) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class ac<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    ac(long paramLong) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.app.n
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(165054);
      PluginFinder.access$getAudioHelperTool$p(this.rGI).abe();
      AppMethodBeat.o(165054);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(165055);
      if (this.rGI.isInFinder()) {
        PluginFinder.access$requestAudioFocus(this.rGI);
      }
      if ((this.rGI.showFinderEntry()) && (SystemClock.uptimeMillis() - PluginFinder.access$getLastFinderInitTime$p(this.rGI) >= 86400000L)) {
        PluginFinder.access$doFinderInit(this.rGI);
      }
      AppMethodBeat.o(165055);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "getSQLs", "()[Ljava/lang/String;"})
  static final class c
    implements com.tencent.mm.storagebase.h.b
  {
    public static final c rGJ;
    
    static
    {
      AppMethodBeat.i(165057);
      rGJ = new c();
      AppMethodBeat.o(165057);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165056);
      Object localObject = s.syS;
      d.g.b.p.h("findermessage006", "table");
      localObject = com.tencent.mm.plugin.byp.b.ouL;
      localObject = com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.plugin.byp.b.access$getInfo$cp(), "findermessage006");
      d.g.b.p.g(localObject, "getCreateSQLs(BypMsgInfo.info, table)");
      String str1 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "SvrIdIndex ON " + "findermessage006" + " ( msgSvrId )";
      String str2 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerIndex ON " + "findermessage006" + " ( talker )";
      String str3 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerStatusIndex ON " + "findermessage006" + " ( talker,status )";
      String str4 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "CreateTimeIndex ON " + "findermessage006" + " ( createTime )";
      String str5 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "CreateTalkerTimeIndex ON " + "findermessage006" + " ( talker,createTime )";
      String str6 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "SendCreateTimeIndex ON " + "findermessage006" + " ( status,isSend,createTime )";
      String str7 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerTypeIndex ON " + "findermessage006" + " ( talker,type )";
      AppMethodBeat.o(165056);
      return new String[] { localObject, str1, str2, str3, str4, str5, str6, str7 };
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class d
    implements com.tencent.mm.storagebase.h.b
  {
    public static final d rGK;
    
    static
    {
      AppMethodBeat.i(200931);
      rGK = new d();
      AppMethodBeat.o(200931);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(200930);
      Object localObject = com.tencent.mm.plugin.finder.storage.c.sxC;
      localObject = com.tencent.mm.plugin.finder.storage.c.czG();
      AppMethodBeat.o(200930);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class e
    implements com.tencent.mm.storagebase.h.b
  {
    public static final e rGL;
    
    static
    {
      AppMethodBeat.i(200933);
      rGL = new e();
      AppMethodBeat.o(200933);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(200932);
      Object localObject = com.tencent.mm.plugin.finder.storage.v.szd;
      localObject = com.tencent.mm.plugin.finder.storage.v.czG();
      AppMethodBeat.o(200932);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class f
    implements com.tencent.mm.storagebase.h.b
  {
    public static final f rGM;
    
    static
    {
      AppMethodBeat.i(200935);
      rGM = new f();
      AppMethodBeat.o(200935);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(200934);
      Object localObject = com.tencent.mm.plugin.finder.storage.i.sxU;
      localObject = com.tencent.mm.plugin.finder.storage.i.czG();
      AppMethodBeat.o(200934);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class g
    implements com.tencent.mm.storagebase.h.b
  {
    public static final g rGN;
    
    static
    {
      AppMethodBeat.i(200937);
      rGN = new g();
      AppMethodBeat.o(200937);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(200936);
      Object localObject = com.tencent.mm.plugin.finder.storage.q.syC;
      localObject = com.tencent.mm.plugin.finder.storage.q.czG();
      AppMethodBeat.o(200936);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class h
    implements com.tencent.mm.storagebase.h.b
  {
    public static final h rGO;
    
    static
    {
      AppMethodBeat.i(200939);
      rGO = new h();
      AppMethodBeat.o(200939);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(200938);
      Object localObject = com.tencent.mm.plugin.finder.extension.reddot.c.rRO;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.c.czG();
      AppMethodBeat.o(200938);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class i
    implements com.tencent.mm.storagebase.h.b
  {
    public static final i rGP;
    
    static
    {
      AppMethodBeat.i(200941);
      rGP = new i();
      AppMethodBeat.o(200941);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(200940);
      Object localObject = com.tencent.mm.plugin.finder.storage.a.suG;
      localObject = com.tencent.mm.plugin.finder.storage.a.czG();
      AppMethodBeat.o(200940);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class k
    implements com.tencent.mm.storagebase.h.b
  {
    public static final k rGR;
    
    static
    {
      AppMethodBeat.i(165065);
      rGR = new k();
      AppMethodBeat.o(165065);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165064);
      Object localObject = com.tencent.mm.plugin.finder.storage.j.sxV;
      localObject = com.tencent.mm.plugin.finder.storage.j.czG();
      AppMethodBeat.o(165064);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class l
    implements com.tencent.mm.storagebase.h.b
  {
    public static final l rGS;
    
    static
    {
      AppMethodBeat.i(200945);
      rGS = new l();
      AppMethodBeat.o(200945);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(200944);
      Object localObject = y.szm;
      localObject = y.czG();
      AppMethodBeat.o(200944);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class m
    implements com.tencent.mm.storagebase.h.b
  {
    public static final m rGT;
    
    static
    {
      AppMethodBeat.i(200947);
      rGT = new m();
      AppMethodBeat.o(200947);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(200946);
      Object localObject = com.tencent.mm.plugin.finder.storage.d.sxD;
      localObject = com.tencent.mm.plugin.finder.storage.d.czG();
      AppMethodBeat.o(200946);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class n
    implements com.tencent.mm.storagebase.h.b
  {
    public static final n rGU;
    
    static
    {
      AppMethodBeat.i(200949);
      rGU = new n();
      AppMethodBeat.o(200949);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(200948);
      Object localObject = w.szg;
      localObject = w.czG();
      AppMethodBeat.o(200948);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "invoke"})
  static final class o
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.finder.conv.h>
  {
    public static final o rGV;
    
    static
    {
      AppMethodBeat.i(200951);
      rGV = new o();
      AppMethodBeat.o(200951);
    }
    
    o()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public static final p rGW;
    
    static
    {
      AppMethodBeat.i(165067);
      rGW = new p();
      AppMethodBeat.o(165067);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    q(PluginFinder paramPluginFinder, long paramLong, String paramString, int paramInt, Context paramContext, Intent paramIntent)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class r
    extends com.tencent.mm.sdk.b.c<fl>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "invoke"})
  static final class s
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.finder.service.a>
  {
    public static final s rHb;
    
    static
    {
      AppMethodBeat.i(200956);
      rHb = new s();
      AppMethodBeat.o(200956);
    }
    
    s()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderSyncEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class t
    extends com.tencent.mm.sdk.b.c<hp>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "invoke"})
  static final class u
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.loader.g.i>
  {
    public static final u rHc;
    
    static
    {
      AppMethodBeat.i(200958);
      rHc = new u();
      AppMethodBeat.o(200958);
    }
    
    u()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "invoke"})
  static final class v
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.finder.service.c>
  {
    public static final v rHd;
    
    static
    {
      AppMethodBeat.i(200960);
      rHd = new v();
      AppMethodBeat.o(200960);
    }
    
    v()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class w
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final w rHe;
    
    static
    {
      AppMethodBeat.i(200962);
      rHe = new w();
      AppMethodBeat.o(200962);
    }
    
    w()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    public static final x rHf;
    
    static
    {
      AppMethodBeat.i(165072);
      rHf = new x();
      AppMethodBeat.o(165072);
    }
    
    public final void run()
    {
      AppMethodBeat.i(165071);
      com.tencent.mm.plugin.finder.upload.b.a locala = com.tencent.mm.plugin.finder.upload.b.sID;
      com.tencent.mm.plugin.finder.upload.b.cKC().cKB();
      AppMethodBeat.o(165071);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class y
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public static final y rHg;
    
    static
    {
      AppMethodBeat.i(200964);
      rHg = new y();
      AppMethodBeat.o(200964);
    }
    
    y()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/PluginFinder$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
  public static final class z
    implements com.tencent.mm.model.d.a
  {
    public final void aAa()
    {
      AppMethodBeat.i(165074);
      ad.i("Finder.PluginFinder", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(165074);
    }
    
    public final void aAb()
    {
      AppMethodBeat.i(165076);
      ad.i("Finder.PluginFinder", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(165076);
    }
    
    public final void azY()
    {
      AppMethodBeat.i(165073);
      ad.i("Finder.PluginFinder", "[audioHelperTool] gain");
      AppMethodBeat.o(165073);
    }
    
    public final void azZ()
    {
      AppMethodBeat.i(165075);
      ad.i("Finder.PluginFinder", "[audioHelperTool] loss");
      AppMethodBeat.o(165075);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder
 * JD-Core Version:    0.7.0.1
 */