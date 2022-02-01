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
import com.tencent.mm.g.c.ci;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ab.a;
import com.tencent.mm.model.ab.b;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.f.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.q.a;
import com.tencent.mm.plugin.finder.storage.p.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.upload.g.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.u;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder;", "Lcom/tencent/mm/kernel/api/ICoreStorageCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "CURRENT_DB_VERSION", "", "kotlin.jvm.PlatformType", "CURRENT_DB_VERSION_DEFAULT", "actionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "appForegroundListener", "com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "closeFinderEntryForDebug", "", "contactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "conversationUpdater", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "getConversationUpdater", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "conversationUpdater$delegate", "Lkotlin/Lazy;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDataDB", "()Lcom/tencent/mm/storagebase/SqliteDB;", "setDataDB", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1;", "feedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "finderActivity", "", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "", "finderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "finderContactService", "Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "getFinderContactService", "()Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "finderContactService$delegate", "finderMentionDB", "getFinderMentionDB", "setFinderMentionDB", "finderMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "finderPrivateSysMsgConsumer", "Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "finderReInitSysMsgConsumer", "Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer;", "finderSyncEventListener", "com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1;", "followTlSingleExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getFollowTlSingleExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "followTlSingleExecutor$delegate", "getContactInterceptor", "Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "getContactInterceptor$delegate", "isDoSomethingCompleted", "isFriendCache", "Ljava/util/concurrent/ConcurrentHashMap;", "lastFinderInitTime", "", "localLikeFeedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage;", "lock", "", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "mediaPreloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getMediaPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "mediaPreloadModel$delegate", "messageDB", "getMessageDB", "setMessageDB", "messageStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage;", "modifyBlackListService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "modifyFeedSettingService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "modifyFinderFeedProduce", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "modifyFinderMessageService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "modifyFinderMessageSessionService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderMsgSessionMuteSetting;", "modifyFinderWxMessageSessionService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "modifyLikeRecommendService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "modifyUserService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "msgStrangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "needResetDb", "postManager", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "redDotCtrInfoStorage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "syncExtension", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "viewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "wxMentionDB", "getWxMentionDB", "setWxMentionDB", "wxMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "checkIfSameMsgTableName", "", "checkResetDb", "clearMentionDB", "clearReInit", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "collectFinderDatabaseFactory", "Lkotlin/collections/HashMap;", "collectMentionDatabaseFactory", "collectMessageDatabaseFactory", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "doFinderInit", "doPrepareUser", "doReInit", "reInitVersion", "reInitUsername", "doSomethingImportantOnStart", "dumpAndMarkFinderFolder", "enterFinderConversationUI", "context", "Landroid/content/Context;", "enterFinderPostRouterUI", "intent", "Landroid/content/Intent;", "enterFinderPostUI", "enterFinderProfileUI", "enterFinderSelfProfile", "enterFinderShareFeedUI", "json", "i", "enterFinderTimelineUI", "enterFinderTopicUI", "enterFinderUI", "execute", "fillContextIdToIntent", "enter", "enterType", "toCommentScene", "getContactStorage", "getConversationStorage", "getDB", "getFeedStorage", "getFinderActionStorage", "getFinderContactCache", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getLocalLikeFeedStorage", "getMediaCacheStorage", "getMentionStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "localFlag", "getMessageStorage", "getMsgStrangerContactStorage", "getRedDotCtrInfoStorage", "getRedDotManager", "getSessionInfoStorage", "getTimelineCommentScene", "getViewModelStore", "hasFinderPosted", "isFriend", "username", "isInFinder", "isNeedDoReInit", "loadImage", "url", "imageView", "Landroid/widget/ImageView;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onAppBackground", "activity", "onAppForeground", "onDataBaseClosed", "readOnlyDB", "onDataBaseOpened", "onEnterFinder", "finder", "onExitFinder", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportPostRedDot", "key", "requestAudioFocus", "requestFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectId", "objectNonceId", "commentScene", "resetConfig", "resetDb", "resetLastTimelineExitTime", "shareStatsReport", "feedIdList", "", "showFinderEntry", "showPostEntry", "snsToFinderPostReport", "sessionID", "wording", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "feedId", "timeStamp", "exposeType", "tryGetFinderObject", "force", "Companion", "plugin-finder_release"})
public final class PluginFinder
  extends com.tencent.mm.kernel.b.f
  implements ViewModelStoreOwner, com.tencent.mm.ak.f, com.tencent.mm.app.o, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, t
{
  public static final PluginFinder.a rOS;
  private final ViewModelStore Fu;
  private com.tencent.mm.storagebase.h gDX;
  private final com.tencent.mm.model.d hdv;
  private final byte[] lock;
  private volatile boolean rNZ;
  private final com.tencent.mm.plugin.finder.newxml.a rOA;
  private final com.tencent.mm.plugin.finder.api.a rOB;
  private com.tencent.mm.plugin.finder.extension.reddot.e rOC;
  private final d.f rOD;
  private final String rOE;
  private final String rOF;
  private final d.f rOG;
  private final d.f rOH;
  private final PluginFinder.t rOI;
  private final d.f rOJ;
  private final d.f rOK;
  private final PluginFinder.r rOL;
  private volatile boolean rOM;
  private final Set<MMFinderUI> rON;
  private long rOO;
  private final b rOP;
  private boolean rOQ;
  private final ConcurrentHashMap<String, Boolean> rOR;
  private com.tencent.mm.storagebase.h rOa;
  private com.tencent.mm.storagebase.h rOb;
  private com.tencent.mm.storagebase.h rOc;
  private final com.tencent.mm.plugin.finder.upload.g rOd;
  private final com.tencent.mm.plugin.finder.extension.a rOe;
  private com.tencent.mm.plugin.finder.storage.c rOf;
  private com.tencent.mm.plugin.finder.storage.v rOg;
  private com.tencent.mm.plugin.finder.storage.d rOh;
  private w rOi;
  private com.tencent.mm.plugin.finder.storage.s rOj;
  private com.tencent.mm.plugin.finder.storage.i rOk;
  private com.tencent.mm.plugin.finder.storage.q rOl;
  private com.tencent.mm.plugin.finder.extension.reddot.c rOm;
  private com.tencent.mm.plugin.finder.storage.y rOn;
  private com.tencent.mm.plugin.finder.storage.j rOo;
  private com.tencent.mm.plugin.finder.storage.a rOp;
  private com.tencent.mm.plugin.finder.storage.p rOq;
  private final com.tencent.mm.plugin.finder.cgi.oplog.f rOr;
  private final com.tencent.mm.plugin.finder.cgi.oplog.c rOs;
  private final com.tencent.mm.plugin.finder.cgi.oplog.b rOt;
  private final com.tencent.mm.plugin.finder.cgi.oplog.a rOu;
  private final com.tencent.mm.plugin.finder.cgi.oplog.g rOv;
  private final com.tencent.mm.plugin.finder.cgi.oplog.i rOw;
  private final com.tencent.mm.plugin.finder.cgi.oplog.e rOx;
  private final com.tencent.mm.plugin.finder.cgi.oplog.d rOy;
  private final com.tencent.mm.plugin.finder.conv.i rOz;
  
  static
  {
    AppMethodBeat.i(162442);
    rOS = new PluginFinder.a((byte)0);
    AppMethodBeat.o(162442);
  }
  
  public PluginFinder()
  {
    AppMethodBeat.i(165123);
    this.lock = new byte[0];
    g.a locala = com.tencent.mm.plugin.finder.upload.g.sUx;
    this.rOd = com.tencent.mm.plugin.finder.upload.g.cNo();
    this.rOe = new com.tencent.mm.plugin.finder.extension.a();
    this.rOr = new com.tencent.mm.plugin.finder.cgi.oplog.f();
    this.rOs = new com.tencent.mm.plugin.finder.cgi.oplog.c();
    this.rOt = new com.tencent.mm.plugin.finder.cgi.oplog.b();
    this.rOu = new com.tencent.mm.plugin.finder.cgi.oplog.a();
    this.rOv = new com.tencent.mm.plugin.finder.cgi.oplog.g();
    this.rOw = new com.tencent.mm.plugin.finder.cgi.oplog.i();
    this.rOx = new com.tencent.mm.plugin.finder.cgi.oplog.e();
    this.rOy = new com.tencent.mm.plugin.finder.cgi.oplog.d();
    this.rOz = new com.tencent.mm.plugin.finder.conv.i();
    this.rOA = new com.tencent.mm.plugin.finder.newxml.a();
    this.rOB = new com.tencent.mm.plugin.finder.api.a();
    this.rOD = d.g.O((d.g.a.a)PluginFinder.u.rPn);
    this.rOE = com.tencent.mm.sdk.platformtools.aj.ej("FinderMM029.dbFinderMention001.db");
    this.rOF = com.tencent.mm.sdk.platformtools.aj.ej("FinderMM029.dbFinderMention001.db");
    this.rOG = d.g.O((d.g.a.a)PluginFinder.w.rPp);
    this.rOH = d.g.O((d.g.a.a)PluginFinder.v.rPo);
    this.rOI = new PluginFinder.t(this);
    this.rOJ = d.g.O((d.g.a.a)PluginFinder.s.rPm);
    this.rOK = d.g.O((d.g.a.a)PluginFinder.o.rPg);
    this.rOL = new PluginFinder.r(this);
    this.rON = Collections.synchronizedSet((Set)new HashSet());
    this.hdv = com.tencent.mm.model.d.aAm();
    this.rOP = new b(this);
    this.rOR = new ConcurrentHashMap();
    this.Fu = new ViewModelStore();
    AppMethodBeat.o(165123);
  }
  
  private final void checkIfSameMsgTableName()
  {
    AppMethodBeat.i(201396);
    Object localObject1 = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajA().get(am.a.JcX, "");
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(201396);
      throw ((Throwable)localObject1);
    }
    localObject1 = (String)localObject1;
    Object localObject2 = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajA().get(am.a.JcY, "");
    if (localObject2 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(201396);
      throw ((Throwable)localObject1);
    }
    localObject2 = (String)localObject2;
    if (((CharSequence)localObject1).length() > 0)
    {
      i = 1;
      if ((i != 0) && ((d.g.b.p.i(localObject1, ci.fbc) ^ true)))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        com.tencent.mm.plugin.finder.utils.p.cOl();
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label198;
      }
    }
    label198:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && ((d.g.b.p.i(localObject2, ci.fbd) ^ true)))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        com.tencent.mm.plugin.finder.utils.p.cOm();
      }
      AppMethodBeat.o(201396);
      return;
      i = 0;
      break;
    }
  }
  
  private final void checkResetDb()
  {
    AppMethodBeat.i(165077);
    ae.v("Finder.PluginFinder", "checkResetDb1 " + this.rNZ);
    if (this.rNZ)
    {
      ae.v("Finder.PluginFinder", "checkResetDb2 " + this.rNZ);
      synchronized (this.lock)
      {
        Object localObject1 = new StringBuilder("checkResetDb  need reset DB now ");
        Thread localThread = Thread.currentThread();
        d.g.b.p.g(localThread, "Thread.currentThread()");
        localObject1 = ((StringBuilder)localObject1).append(localThread.getName()).append(" ");
        localThread = Thread.currentThread();
        d.g.b.p.g(localThread, "Thread.currentThread()");
        ae.i("Finder.PluginFinder", localThread.getId() + " " + hashCode());
        if (this.rNZ)
        {
          resetDb();
          this.rNZ = false;
          ae.i("Finder.PluginFinder", "resetDB done");
        }
        localObject1 = z.Nhr;
        AppMethodBeat.o(165077);
        return;
      }
    }
    AppMethodBeat.o(165077);
  }
  
  private final void clearMentionDB()
  {
    AppMethodBeat.i(165079);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajw();
    com.tencent.mm.vfs.o.deleteFile((String)localObject + "FinderMention001.db");
    com.tencent.mm.vfs.o.deleteFile((String)localObject + "FinderMention002.db");
    this.rOa = null;
    this.rOb = null;
    AppMethodBeat.o(165079);
  }
  
  private final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectFinderDatabaseFactory()
  {
    AppMethodBeat.i(201397);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_CONTACT_TABLE".hashCode()), PluginFinder.d.rOV);
    ((Map)localHashMap).put(Integer.valueOf("FinderMsgContactStorage".hashCode()), PluginFinder.e.rOW);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FEED_TABLE".hashCode()), PluginFinder.f.rOX);
    ((Map)localHashMap).put(Integer.valueOf("FinderMediaCacheInfoV2".hashCode()), g.rOY);
    ((Map)localHashMap).put(Integer.valueOf("FinderRedDotInfo".hashCode()), PluginFinder.h.rOZ);
    ((Map)localHashMap).put(Integer.valueOf("FinderAction".hashCode()), i.rPa);
    Map localMap = (Map)localHashMap;
    p.a locala = com.tencent.mm.plugin.finder.storage.p.sJs;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.finder.storage.p.cLf().hashCode()), PluginFinder.j.rPb);
    AppMethodBeat.o(201397);
    return localHashMap;
  }
  
  private final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectMentionDatabaseFactory()
  {
    AppMethodBeat.i(165081);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FINDER_MENTION_TABLE".hashCode()), k.rPc);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_WX_MENTION_TABLE".hashCode()), l.rPd);
    AppMethodBeat.o(165081);
    return localHashMap;
  }
  
  private final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectMessageDatabaseFactory()
  {
    AppMethodBeat.i(201398);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FinderConversation".hashCode()), PluginFinder.m.rPe);
    ((Map)localHashMap).put(Integer.valueOf("FinderSessionInfo".hashCode()), PluginFinder.n.rPf);
    AppMethodBeat.o(201398);
    return localHashMap;
  }
  
  private final void doFinderInit()
  {
    AppMethodBeat.i(165088);
    ae.i("Finder.PluginFinder", "[doFinderInit] ...");
    this.rOO = SystemClock.uptimeMillis();
    com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)new at());
    AppMethodBeat.o(165088);
  }
  
  private final void doPrepareUser()
  {
    AppMethodBeat.i(165091);
    ae.i("Finder.PluginFinder", "[doPrepareUser]... ");
    ay localay = new ay(1);
    com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)localay);
    AppMethodBeat.o(165091);
  }
  
  private final void doReInit(int paramInt, String paramString)
  {
    AppMethodBeat.i(165090);
    try
    {
      com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 21L, 1L);
      Object localObject = com.tencent.mm.plugin.finder.storage.data.f.sKL;
      f.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.k.sLb;
      k.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.b.sKy;
      com.tencent.mm.plugin.finder.storage.data.b.a.clearAll();
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbz, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JbA, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JcW, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JcZ, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jda, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jdb, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jdc, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jdd, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbp, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbx, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JcH, Integer.valueOf(paramInt));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JaW, paramString);
      paramString = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramString.ajA().set(am.a.Jde, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramString.ajA().set(am.a.Jdf, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramString.ajA().set(am.a.JcI, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramInt = paramString.ajA().getInt(am.a.JcJ, 0);
      paramString = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramString.ajA().set(am.a.JcJ, Integer.valueOf(paramInt + 1));
      clearReInit();
      ae.i("Finder.PluginFinder", "[doReInit] reInit done. incrementId=" + (paramInt + 1));
      AppMethodBeat.o(165090);
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("Finder.PluginFinder", (Throwable)paramString, "do ReInit occur error!", new Object[0]);
      com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 22L, 1L);
      AppMethodBeat.o(165090);
    }
  }
  
  private final void doSomethingImportantOnStart()
  {
    AppMethodBeat.i(201405);
    this.rOL.alive();
    if (this.rOM)
    {
      AppMethodBeat.o(201405);
      return;
    }
    boolean bool = showFinderEntry();
    ae.i("Finder.PluginFinder", "[doSomethingImportantOnStart] " + com.tencent.mm.model.v.aAK() + " isDoSomethingCompleted=" + this.rOM + ", isShowFinderEntry=" + bool);
    if (!bool)
    {
      AppMethodBeat.o(201405);
      return;
    }
    this.rOM = true;
    bool = isNeedDoReInit();
    if (!bu.isNullOrNil(com.tencent.mm.model.v.aAK())) {
      com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 34L, 1L);
    }
    if (bool)
    {
      Object localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.JcF, 0);
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).ajA().get(am.a.JcG, "");
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201405);
        throw ((Throwable)localObject);
      }
      doReInit(i, (String)localObject);
      doPrepareUser();
      this.rOe.fG(15357, 6);
    }
    for (;;)
    {
      getRedDotManager().prepare();
      AppMethodBeat.o(201405);
      return;
      if (bu.isNullOrNil(com.tencent.mm.model.v.aAK()))
      {
        com.tencent.mm.kernel.g.ajj().a(3930, (com.tencent.mm.ak.f)this);
        com.tencent.mm.kernel.g.ajj().a(3930, (com.tencent.mm.ak.f)getRedDotManager());
        doFinderInit();
        this.rOe.fG(14845, 6);
      }
    }
  }
  
  private final com.tencent.mm.plugin.finder.conv.h getConversationUpdater()
  {
    AppMethodBeat.i(201394);
    com.tencent.mm.plugin.finder.conv.h localh = (com.tencent.mm.plugin.finder.conv.h)this.rOK.getValue();
    AppMethodBeat.o(201394);
    return localh;
  }
  
  private final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(165080);
    checkResetDb();
    com.tencent.mm.storagebase.h localh = this.gDX;
    if (localh == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(165080);
    return localh;
  }
  
  private final com.tencent.mm.plugin.finder.service.a getFinderContactService()
  {
    AppMethodBeat.i(201393);
    com.tencent.mm.plugin.finder.service.a locala = (com.tencent.mm.plugin.finder.service.a)this.rOJ.getValue();
    AppMethodBeat.o(201393);
    return locala;
  }
  
  private final com.tencent.mm.plugin.finder.service.c getGetContactInterceptor()
  {
    AppMethodBeat.i(201392);
    com.tencent.mm.plugin.finder.service.c localc = (com.tencent.mm.plugin.finder.service.c)this.rOH.getValue();
    AppMethodBeat.o(201392);
    return localc;
  }
  
  private final boolean isNeedDoReInit()
  {
    AppMethodBeat.i(201395);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.JcI, -1);
    localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.JcH, 0);
    localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    int m = ((com.tencent.mm.kernel.e)localObject).ajA().getInt(am.a.JcF, 0);
    localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajA().get(am.a.JcG, "");
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(201395);
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
          com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
          d.g.b.p.g(locale, "MMKernel.storage()");
          locale.ajA().set(am.a.JcI, Integer.valueOf(1));
          i = 1;
        }
      }
    }
    localObject = new StringBuilder("[isNeedDoReInit] userVersion=").append(k).append(", reInitUserVersion=").append(m).append(", reInitUsername=").append((String)localObject).append(" isNeedDoReInit=");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("Finder.PluginFinder", bool);
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(201395);
      return true;
    }
    AppMethodBeat.o(201395);
    return false;
  }
  
  private final void requestAudioFocus()
  {
    AppMethodBeat.i(165098);
    this.hdv.a((com.tencent.mm.model.d.a)new z());
    AppMethodBeat.o(165098);
  }
  
  private final void resetDb()
  {
    AppMethodBeat.i(165078);
    Object localObject1;
    Object localObject2;
    if (this.gDX == null)
    {
      this.gDX = new com.tencent.mm.storagebase.h();
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajw();
      localObject1 = (String)localObject1 + "FinderMM029.db";
      localObject2 = this.gDX;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      if (!((com.tencent.mm.storagebase.h)localObject2).b((String)localObject1, collectFinderDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("finder db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
    }
    if (this.rOa == null)
    {
      this.rOa = new com.tencent.mm.storagebase.h();
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajw();
      localObject1 = (String)localObject1 + "FinderMention001.db";
      localObject2 = this.rOa;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      if (!((com.tencent.mm.storagebase.h)localObject2).b((String)localObject1, collectMentionDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("finder finder mention db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
      checkIfSameMsgTableName();
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).ajA().set(am.a.JcX, ci.fbc);
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).ajA().set(am.a.JcY, ci.fbd);
    }
    if (this.rOc == null)
    {
      localObject1 = new com.tencent.mm.storagebase.h();
      localObject2 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajw();
      if (!((com.tencent.mm.storagebase.h)localObject1).b((String)localObject2 + "FinderMessage006.db", collectMessageDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("message db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
      this.rOc = ((com.tencent.mm.storagebase.h)localObject1);
    }
    if (this.rOb == null)
    {
      this.rOb = new com.tencent.mm.storagebase.h();
      localObject1 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajw();
      localObject1 = (String)localObject1 + "FinderMention002.db";
      localObject2 = this.rOb;
      if (localObject2 == null) {
        d.g.b.p.gkB();
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
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JcF, Integer.valueOf(0));
    locale = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JcG, "");
    AppMethodBeat.o(165094);
  }
  
  public final void closeFinderEntryForDebug()
  {
    this.rOQ = true;
  }
  
  public final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(162433);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("findermessage006".hashCode()), PluginFinder.c.rOU);
    AppMethodBeat.o(162433);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(165092);
    u.b("finder", "finder", 7776000000L, 19);
    AppMethodBeat.o(165092);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(201406);
    super.dependency();
    dependsOn(com.tencent.mm.plugin.byp.a.c.class);
    AppMethodBeat.o(201406);
  }
  
  public final void dumpAndMarkFinderFolder()
  {
    AppMethodBeat.i(165100);
    com.tencent.mm.ac.c.b(null, (d.g.a.a)p.rPh);
    AppMethodBeat.o(165100);
  }
  
  public final void enterFinderConversationUI(Context paramContext)
  {
    AppMethodBeat.i(201417);
    d.g.b.p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sVQ;
    com.tencent.mm.plugin.finder.utils.a.eZ(paramContext);
    AppMethodBeat.o(201417);
  }
  
  public final void enterFinderPostRouterUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(201410);
    d.g.b.p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sVQ;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(paramContext, paramIntent);
    AppMethodBeat.o(201410);
  }
  
  public final void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162439);
    d.g.b.p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sVQ;
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
    if (bu.isNullOrNil((String)localObject))
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
      final long l = com.tencent.mm.ac.c.xQ((String)localObject);
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
        ae.e("Finder.PluginFinder", "enterFinderProfileUI username & objectId invalid");
        AppMethodBeat.o(162440);
        return;
      }
      com.tencent.mm.ac.c.b(null, (d.g.a.a)new q(this, l, (String)localObject, i, paramContext, paramIntent));
      AppMethodBeat.o(162440);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, paramIntent);
    com.tencent.mm.plugin.secinforeport.a.d.yRQ.asyncReportFinderSecurityInfoThroughCgi(540999686);
    AppMethodBeat.o(162440);
  }
  
  public final void enterFinderSelfProfile(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(201407);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramIntent, "intent");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sVQ;
    com.tencent.mm.plugin.finder.utils.a.y(paramContext, paramIntent);
    AppMethodBeat.o(201407);
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162441);
    d.g.b.p.h(paramContext, "context");
    Object localObject = com.tencent.mm.plugin.finder.spam.a.sEK;
    if (com.tencent.mm.plugin.finder.spam.a.ajk("entrance") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.eW(paramContext);
      AppMethodBeat.o(162441);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
    com.tencent.mm.plugin.finder.utils.a.C(paramContext, paramIntent);
    com.tencent.mm.plugin.secinforeport.a.d.yRQ.asyncReportFinderSecurityInfoThroughCgi(540999685);
    AppMethodBeat.o(162441);
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(201409);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString, "json");
    try
    {
      Object localObject = new com.tencent.mm.ab.i(paramString);
      String str1 = ((com.tencent.mm.ab.i)localObject).optString("feedId", "0");
      d.g.b.p.g(str1, "jsonObject.optString(\"feedId\", \"0\")");
      long l = com.tencent.mm.ac.c.xQ(str1);
      com.tencent.mm.ab.i locali = ((com.tencent.mm.ab.i)localObject).xx("extInfo");
      ae.i("Finder.PluginFinder", "json = ".concat(String.valueOf(paramString)));
      localObject = locali.getString("feedNonceId");
      int i = locali.optInt("reportScene", 11);
      str1 = locali.optString("encryptedObjectId", "");
      boolean bool = locali.optBoolean("getRelatedList", false);
      String str2 = locali.optString("sessionId", "");
      int j = locali.optInt("requestScene");
      paramString = paramIntent;
      if (paramIntent == null) {
        paramString = new Intent();
      }
      paramString.putExtra("report_scene", i);
      paramString.putExtra("from_user", com.tencent.mm.model.v.aAC());
      paramString.putExtra("feed_object_id", l);
      paramString.putExtra("feed_encrypted_object_id", str1);
      paramString.putExtra("feed_object_nonceId", (String)localObject);
      paramString.putExtra("key_need_related_list", bool);
      paramString.putExtra("key_session_id", str2);
      paramString.putExtra("key_comment_scene", 39);
      paramString.putExtra("key_reuqest_scene", j);
      paramIntent = com.tencent.mm.plugin.finder.spam.a.sEK;
      if (com.tencent.mm.plugin.finder.spam.a.ajk("entrance") != 0)
      {
        paramString = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.eW(paramContext);
        AppMethodBeat.o(201409);
        return;
      }
      paramIntent = com.tencent.mm.plugin.finder.utils.p.sXz;
      fillContextIdToIntent(com.tencent.mm.plugin.finder.utils.p.Gw(i), 2, 39, paramString);
      paramIntent = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.C(paramContext, paramString);
      com.tencent.mm.plugin.secinforeport.a.d.yRQ.asyncReportFinderSecurityInfoThroughCgi(540999685);
      AppMethodBeat.o(201409);
      return;
    }
    catch (Throwable paramContext)
    {
      ae.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderProfileUI exception", new Object[0]);
      AppMethodBeat.o(201409);
    }
  }
  
  public final void enterFinderTimelineUI(Context paramContext, Intent paramIntent)
  {
    int j = 1;
    AppMethodBeat.i(162438);
    d.g.b.p.h(paramContext, "context");
    Object localObject1;
    int i;
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("key_form_sns", false)) {
        break label138;
      }
      Object localObject2 = paramIntent.getStringExtra("key_context_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
      if (bu.isNullOrNil(com.tencent.mm.plugin.finder.extension.reddot.d.a.jdMethod_do((String)localObject1, 1))) {
        break label127;
      }
      i = 1;
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramIntent.getStringExtra("key_red_dot_id"))) {}
      for (;;)
      {
        if ((i | j) != 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.f.syc;
          com.tencent.mm.plugin.finder.report.f.cFm();
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.v(paramContext, paramIntent);
        com.tencent.mm.plugin.secinforeport.a.d.yRQ.asyncReportFinderSecurityInfoThroughCgi(540999684);
        AppMethodBeat.o(162438);
        return;
        label127:
        i = 0;
        break;
        j = 0;
      }
      label138:
      i = 0;
    }
  }
  
  public final void enterFinderTopicUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(165101);
    d.g.b.p.h(paramContext, "context");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.eW(paramContext);
      AppMethodBeat.o(165101);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sVQ;
    com.tencent.mm.plugin.finder.utils.a.J(paramContext, paramIntent);
    AppMethodBeat.o(165101);
  }
  
  public final void enterFinderUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(201408);
    d.g.b.p.h(paramContext, "context");
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      boolean bool;
      int i;
      try
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (!com.tencent.mm.plugin.finder.storage.b.cGY())
        {
          ae.i("Finder.PluginFinder", "enterFinderUI clicfg_ultron_finder_mp_jsapi switch close");
          AppMethodBeat.o(201408);
          return;
        }
        localObject1 = new com.tencent.mm.ab.i(paramString).xx("extInfo");
        localObject2 = ((com.tencent.mm.ab.i)localObject1).getString("action");
        ae.i("Finder.PluginFinder", "json = ".concat(String.valueOf(paramString)));
        if (localObject2 == null)
        {
          ae.i("Finder.PluginFinder", "unKnow action:".concat(String.valueOf(localObject2)));
          AppMethodBeat.o(201408);
          return;
        }
        switch (((String)localObject2).hashCode())
        {
        case -412058418: 
          if (!((String)localObject2).equals("openFinderFeed")) {
            continue;
          }
          localObject2 = ((com.tencent.mm.ab.i)localObject1).optString("feedID");
          String str1 = ((com.tencent.mm.ab.i)localObject1).optString("nonceID");
          if (((com.tencent.mm.ab.i)localObject1).optInt("notGetReleatedList") != 0) {
            break label544;
          }
          bool = true;
          i = ((com.tencent.mm.ab.i)localObject1).optInt("shareScene", 0);
          String str2 = ((com.tencent.mm.ab.i)localObject1).optString("sessionId", "");
          int j = ((com.tencent.mm.ab.i)localObject1).optInt("requestScene");
          paramString = new Intent();
          paramString.putExtra("from_user", com.tencent.mm.model.v.aAC());
          paramString.putExtra("feed_encrypted_object_id", (String)localObject2);
          paramString.putExtra("feed_object_nonceId", str1);
          paramString.putExtra("key_need_related_list", bool);
          paramString.putExtra("key_comment_scene", 39);
          paramString.putExtra("key_reuqest_scene", j);
          paramString.putExtra("key_session_id", str2);
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
          if (com.tencent.mm.plugin.finder.utils.p.Gw(i) != -1)
          {
            localObject1 = (t)com.tencent.mm.kernel.g.ad(t.class);
            localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
            ((t)localObject1).fillContextIdToIntent(com.tencent.mm.plugin.finder.utils.p.Gw(i), 2, 39, paramString);
          }
          paramString.putExtra("report_scene", i);
          localObject1 = com.tencent.mm.plugin.finder.spam.a.sEK;
          if (com.tencent.mm.plugin.finder.spam.a.ajk("entrance") == 0) {
            break label515;
          }
          paramString = com.tencent.mm.plugin.finder.utils.a.sVQ;
          com.tencent.mm.plugin.finder.utils.a.eW(paramContext);
          AppMethodBeat.o(201408);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        ae.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderUI exception", new Object[0]);
        AppMethodBeat.o(201408);
        return;
      }
      if (((String)localObject2).equals("openFinderProfile"))
      {
        paramString = ((com.tencent.mm.ab.i)localObject1).optString("feedID");
        localObject2 = ((com.tencent.mm.ab.i)localObject1).optString("finderUserName");
        i = ((com.tencent.mm.ab.i)localObject1).optInt("commentScene");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("finder_username", (String)localObject2);
        ((Intent)localObject1).putExtra("finder_read_feed_id", paramString);
        if (i > 0) {
          ((t)com.tencent.mm.kernel.g.ad(t.class)).fillContextIdToIntent(i, 2, 32, (Intent)localObject1);
        }
        paramString = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, (Intent)localObject1);
        AppMethodBeat.o(201408);
        return;
        label515:
        localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.C(paramContext, paramString);
        com.tencent.mm.plugin.secinforeport.a.d.yRQ.asyncReportFinderSecurityInfoThroughCgi(540999685);
        AppMethodBeat.o(201408);
        return;
        continue;
        label544:
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
    AppMethodBeat.i(201421);
    String str = UUID.randomUUID().toString();
    d.g.b.p.g(str, "UUID.randomUUID().toString()");
    str = d.n.n.h(str, "-", "", false);
    str = paramInt1 + '-' + paramInt2 + '-' + paramInt3 + '-' + str;
    if (paramIntent != null) {
      paramIntent.putExtra("key_context_id", str);
    }
    paramIntent = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(paramIntent, "MMKernel.storage()");
    paramIntent.ajA().set(am.a.JdB, str);
    AppMethodBeat.o(201421);
    return str;
  }
  
  public final com.tencent.mm.plugin.finder.storage.c getContactStorage()
  {
    AppMethodBeat.i(165082);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.finder.storage.c localc2 = this.rOf;
    com.tencent.mm.plugin.finder.storage.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.finder.storage.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rOf = localc1;
    localc1 = this.rOf;
    if (localc1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(165082);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.d getConversationStorage()
  {
    AppMethodBeat.i(201400);
    com.tencent.mm.plugin.finder.storage.d locald = this.rOh;
    Object localObject = locald;
    if (locald == null)
    {
      localObject = this.rOc;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      localObject = new com.tencent.mm.plugin.finder.storage.d((com.tencent.mm.sdk.e.e)localObject);
    }
    this.rOh = ((com.tencent.mm.plugin.finder.storage.d)localObject);
    localObject = this.rOh;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(201400);
    return localObject;
  }
  
  public final com.tencent.mm.storagebase.h getDataDB()
  {
    return this.gDX;
  }
  
  public final com.tencent.mm.plugin.finder.storage.i getFeedStorage()
  {
    AppMethodBeat.i(165083);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.finder.storage.i locali2 = this.rOk;
    com.tencent.mm.plugin.finder.storage.i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new com.tencent.mm.plugin.finder.storage.i((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rOk = locali1;
    locali1 = this.rOk;
    if (locali1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(165083);
    return locali1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.a getFinderActionStorage()
  {
    AppMethodBeat.i(165086);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.finder.storage.a locala2 = this.rOp;
    com.tencent.mm.plugin.finder.storage.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.tencent.mm.plugin.finder.storage.a((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rOp = locala1;
    locala1 = this.rOp;
    if (locala1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(165086);
    return locala1;
  }
  
  public final com.tencent.mm.plugin.finder.api.a getFinderContactCache()
  {
    return this.rOB;
  }
  
  public final com.tencent.mm.storagebase.h getFinderMentionDB()
  {
    return this.rOa;
  }
  
  public final com.tencent.mm.plugin.finder.api.e getFinderSyncExtension()
  {
    return (com.tencent.mm.plugin.finder.api.e)this.rOe;
  }
  
  public final com.tencent.mm.loader.g.i getFollowTlSingleExecutor()
  {
    AppMethodBeat.i(201390);
    com.tencent.mm.loader.g.i locali = (com.tencent.mm.loader.g.i)this.rOD.getValue();
    AppMethodBeat.o(201390);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.storage.p getLocalLikeFeedStorage()
  {
    AppMethodBeat.i(201404);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.finder.storage.p localp2 = this.rOq;
    com.tencent.mm.plugin.finder.storage.p localp1 = localp2;
    if (localp2 == null) {
      localp1 = new com.tencent.mm.plugin.finder.storage.p((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rOq = localp1;
    localp1 = this.rOq;
    if (localp1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(201404);
    return localp1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.q getMediaCacheStorage()
  {
    AppMethodBeat.i(165084);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.finder.storage.q localq2 = this.rOl;
    com.tencent.mm.plugin.finder.storage.q localq1 = localq2;
    if (localq2 == null) {
      localq1 = new com.tencent.mm.plugin.finder.storage.q((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rOl = localq1;
    localq1 = this.rOl;
    if (localq1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(165084);
    return localq1;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.a getMediaPreloadModel()
  {
    AppMethodBeat.i(201391);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.rOG.getValue();
    AppMethodBeat.o(201391);
    return locala;
  }
  
  public final com.tencent.mm.sdk.e.j<ci> getMentionStorage(int paramInt)
  {
    AppMethodBeat.i(201403);
    com.tencent.mm.kernel.g.ajP().aiU();
    checkResetDb();
    if (paramInt == 1)
    {
      localObject2 = this.rOn;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.rOb;
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        localObject1 = new com.tencent.mm.plugin.finder.storage.y((com.tencent.mm.sdk.e.e)localObject1);
      }
      this.rOn = ((com.tencent.mm.plugin.finder.storage.y)localObject1);
      localObject1 = this.rOn;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      localObject1 = (com.tencent.mm.sdk.e.j)localObject1;
      AppMethodBeat.o(201403);
      return localObject1;
    }
    Object localObject2 = this.rOo;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.rOa;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      localObject1 = new com.tencent.mm.plugin.finder.storage.j((com.tencent.mm.sdk.e.e)localObject1);
    }
    this.rOo = ((com.tencent.mm.plugin.finder.storage.j)localObject1);
    localObject1 = this.rOo;
    if (localObject1 == null) {
      d.g.b.p.gkB();
    }
    localObject1 = (com.tencent.mm.sdk.e.j)localObject1;
    AppMethodBeat.o(201403);
    return localObject1;
  }
  
  public final com.tencent.mm.storagebase.h getMessageDB()
  {
    return this.rOc;
  }
  
  public final com.tencent.mm.plugin.finder.storage.s getMessageStorage()
  {
    AppMethodBeat.i(201402);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).doJ();
    com.tencent.mm.plugin.finder.storage.s locals = this.rOj;
    localObject = locals;
    if (locals == null)
    {
      d.g.b.p.g(locali, "msgStg");
      localObject = new com.tencent.mm.plugin.finder.storage.s(locali);
    }
    this.rOj = ((com.tencent.mm.plugin.finder.storage.s)localObject);
    localObject = this.rOj;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(201402);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.storage.v getMsgStrangerContactStorage()
  {
    AppMethodBeat.i(201399);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.finder.storage.v localv2 = this.rOg;
    com.tencent.mm.plugin.finder.storage.v localv1 = localv2;
    if (localv2 == null) {
      localv1 = new com.tencent.mm.plugin.finder.storage.v((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rOg = localv1;
    localv1 = this.rOg;
    if (localv1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(201399);
    return localv1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.c getRedDotCtrInfoStorage()
  {
    AppMethodBeat.i(178074);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.finder.extension.reddot.c localc2 = this.rOm;
    com.tencent.mm.plugin.finder.extension.reddot.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.finder.extension.reddot.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.rOm = localc1;
    localc1 = this.rOm;
    if (localc1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(178074);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.e getRedDotManager()
  {
    AppMethodBeat.i(178072);
    com.tencent.mm.plugin.finder.extension.reddot.e locale2 = this.rOC;
    com.tencent.mm.plugin.finder.extension.reddot.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new com.tencent.mm.plugin.finder.extension.reddot.e(getRedDotCtrInfoStorage());
    }
    this.rOC = locale1;
    locale1 = this.rOC;
    if (locale1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(178072);
    return locale1;
  }
  
  public final w getSessionInfoStorage()
  {
    AppMethodBeat.i(201401);
    com.tencent.mm.kernel.g.ajP().aiU();
    w localw = this.rOi;
    Object localObject = localw;
    if (localw == null)
    {
      localObject = this.rOc;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      localObject = new w((com.tencent.mm.sdk.e.e)localObject);
    }
    this.rOi = ((w)localObject);
    localObject = this.rOi;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(201401);
    return localObject;
  }
  
  public final int getTimelineCommentScene()
  {
    AppMethodBeat.i(201418);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    switch (((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).cQO())
    {
    case 2: 
    default: 
      AppMethodBeat.o(201418);
      return 1;
    case 3: 
      AppMethodBeat.o(201418);
      return 17;
    case 1: 
      AppMethodBeat.o(201418);
      return 18;
    }
    AppMethodBeat.o(201418);
    return 20;
  }
  
  public final ViewModelStore getViewModelStore()
  {
    return this.Fu;
  }
  
  public final com.tencent.mm.storagebase.h getWxMentionDB()
  {
    return this.rOb;
  }
  
  public final boolean hasFinderPosted()
  {
    AppMethodBeat.i(201419);
    String str = com.tencent.mm.model.v.aAK();
    if (bu.isNullOrNil(com.tencent.mm.model.v.aAK()))
    {
      AppMethodBeat.o(201419);
      return false;
    }
    k.a locala = com.tencent.mm.plugin.finder.storage.data.k.sLb;
    d.g.b.p.g(str, "username");
    if (!((Collection)k.a.dx(str, 1)).isEmpty())
    {
      AppMethodBeat.o(201419);
      return true;
    }
    AppMethodBeat.o(201419);
    return false;
  }
  
  public final boolean isFriend(String paramString)
  {
    AppMethodBeat.i(165116);
    if (paramString != null)
    {
      Boolean localBoolean = (Boolean)this.rOR.get(paramString);
      Object localObject = localBoolean;
      if (localBoolean == null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject = Boolean.valueOf(com.tencent.mm.plugin.finder.utils.p.isFriend(paramString));
        ((Map)this.rOR).put(paramString, localObject);
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
    if (this.rON.size() > 0)
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
    Object localObject = new bvz();
    ((bvz)localObject).mediaId = com.tencent.mm.sdk.platformtools.aj.ej(paramString);
    ((bvz)localObject).url = paramString;
    ((bvz)localObject).thumbUrl = paramString;
    paramString = new com.tencent.mm.plugin.finder.loader.g((bvz)localObject, r.sJv);
    localObject = com.tencent.mm.plugin.finder.loader.i.srW;
    com.tencent.mm.plugin.finder.loader.i.cEn().bI(paramString).c(paramImageView);
    AppMethodBeat.o(178075);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(162435);
    com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 40L, 1L);
    this.rNZ = true;
    checkResetDb();
    paramc = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(paramc, "MMKernel.storage()");
    paramc = paramc.ajA().get(am.a.Jby, this.rOF);
    ae.i("Finder.PluginFinder", "onAccountInitialized " + this.rNZ + ' ' + this.rOE + ' ' + paramc);
    Object localObject1 = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject1, "MMKernel.storage()");
    if ((d.g.b.p.i(((com.tencent.mm.kernel.e)localObject1).ajA().get(am.a.Jby, this.rOE), this.rOE) ^ true))
    {
      ae.i("Finder.PluginFinder", "resetConfig oldVer:" + paramc + " CURRENT_DB_VERSION:" + this.rOE);
      resetConfig();
    }
    paramc = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(paramc, "MMKernel.storage()");
    paramc.ajA().set(am.a.Jby, this.rOE);
    paramc = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(paramc, "MMKernel.storage()");
    int i = paramc.ajA().getInt(am.a.JcJ, -1);
    if (i == -1)
    {
      paramc = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramc, "MMKernel.storage()");
      int j = paramc.ajA().getInt(am.a.JcH, 0);
      paramc = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramc, "MMKernel.storage()");
      paramc.ajA().set(am.a.JcJ, Integer.valueOf(j));
      ae.i("Finder.PluginFinder", "[onAccountInitialized] user auto increment id=" + i + " userVersion=" + j);
    }
    for (;;)
    {
      paramc = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      d.g.b.p.g(paramc, "MMKernel.service(IMessengerStorage::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.l)paramc).doJ().a((com.tencent.mm.storage.e)getMessageStorage());
      paramc = x.rRf;
      x.czA();
      doSomethingImportantOnStart();
      paramc = com.tencent.mm.plugin.finder.shell.a.sEJ;
      com.tencent.mm.plugin.finder.shell.a.setup();
      paramc = this.rOd;
      paramc.hip.a((com.tencent.mm.loader.g.f)paramc.sUt);
      paramc.sUq.a((com.tencent.mm.loader.g.f)paramc.sUu);
      paramc = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramc, "MMKernel.storage()");
      paramc.ajA().set(am.a.Jbc, "");
      com.tencent.mm.kernel.g.ajj().a(3565, (com.tencent.mm.ak.f)this.rOe);
      com.tencent.mm.kernel.g.ajj().a(3512, (com.tencent.mm.ak.f)this);
      com.tencent.mm.kernel.g.ajj().a(3870, (com.tencent.mm.ak.f)this.rOr);
      com.tencent.mm.kernel.g.ajj().a(3870, (com.tencent.mm.ak.f)this.rOs);
      com.tencent.mm.kernel.g.ajj().a(3870, (com.tencent.mm.ak.f)this.rOt);
      com.tencent.mm.kernel.g.ajj().a(3870, (com.tencent.mm.ak.f)this.rOu);
      com.tencent.mm.kernel.g.ajj().a(3870, (com.tencent.mm.ak.f)this.rOv);
      com.tencent.mm.kernel.g.ajj().a(3870, (com.tencent.mm.ak.f)this.rOw);
      com.tencent.mm.kernel.g.ajj().a(3870, (com.tencent.mm.ak.f)this.rOx);
      com.tencent.mm.kernel.g.ajj().a(3870, (com.tencent.mm.ak.f)this.rOy);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.n.class, (com.tencent.mm.kernel.c.a)this.rOr);
      com.tencent.mm.kernel.g.b(m.class, (com.tencent.mm.kernel.c.a)this.rOs);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.h.class, (com.tencent.mm.kernel.c.a)this.rOt);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.k.class, (com.tencent.mm.kernel.c.a)this.rOu);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.i.class, (com.tencent.mm.kernel.c.a)this.rOv);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.q.class, (com.tencent.mm.kernel.c.a)this.rOw);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.l.class, (com.tencent.mm.kernel.c.a)this.rOx);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.j.class, (com.tencent.mm.kernel.c.a)this.rOy);
      paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class);
      d.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.s)paramc).getSysCmdMsgExtension().a("FinderPersonalMsgSysMsg", (com.tencent.mm.plugin.messenger.foundation.a.p)this.rOz);
      paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class);
      d.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.s)paramc).getSysCmdMsgExtension().a("finderuserreinit", (com.tencent.mm.plugin.messenger.foundation.a.p)this.rOA);
      boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderActionStorage().db.execSQL("FinderAction", "DELETE FROM FinderAction WHERE actionType = 1");
      ae.i(com.tencent.mm.plugin.finder.storage.a.TAG, "cleanCanRemoveFeed ret" + bool + ' ' + "DELETE FROM FinderAction WHERE actionType = 1");
      if (showFinderEntry()) {
        com.tencent.e.h.MqF.aO((Runnable)x.rPq);
      }
      paramc = com.tencent.mm.plugin.finder.api.c.rPy;
      paramc = c.a.czk();
      paramc.rPE = true;
      c.a.d(paramc);
      this.rOI.alive();
      paramc = com.tencent.mm.plugin.finder.upload.action.g.sVv;
      com.tencent.mm.plugin.finder.upload.action.g.cNz();
      paramc = com.tencent.mm.plugin.finder.upload.g.sUx;
      paramc = com.tencent.mm.plugin.finder.upload.g.cNo();
      localObject1 = com.tencent.mm.plugin.finder.report.g.syJ;
      paramc.a(com.tencent.mm.plugin.finder.report.g.cFr());
      AppForegroundDelegate.cTA.a((com.tencent.mm.app.o)this.rOP);
      paramc = com.tencent.mm.plugin.finder.model.y.stw;
      com.tencent.mm.plugin.finder.model.y.sv();
      paramc = com.tencent.mm.plugin.finder.storage.data.q.sLl;
      paramc = (com.tencent.mm.bw.a)new arh();
      localObject1 = com.tencent.mm.vfs.o.bb(com.tencent.mm.plugin.finder.storage.data.q.cLP(), 0, -1);
      try
      {
        paramc.parseFrom((byte[])localObject1);
        localObject1 = (arh)paramc;
        Object localObject2 = new StringBuilder("[setup] isExist=").append(com.tencent.mm.vfs.o.fB(com.tencent.mm.plugin.finder.storage.data.q.cLP())).append(" touchFile=").append(com.tencent.mm.plugin.finder.storage.data.q.cLP()).append(" info: ");
        if (localObject1 != null)
        {
          paramc = Integer.valueOf(((arh)localObject1).crashCount);
          localObject2 = ((StringBuilder)localObject2).append(paramc).append(' ');
          if (localObject1 == null) {
            break label1491;
          }
          paramc = Long.valueOf(((arh)localObject1).GIb);
          ae.i("Finder.PageRecovery", paramc);
          if (localObject1 != null)
          {
            if (((arh)localObject1).crashCount < 2) {
              break label1496;
            }
            i = 1;
            if (i == 0) {
              break label1501;
            }
            paramc = (e.c)localObject1;
            if (paramc != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.storage.data.k.sLb;
              k.a.clearAll();
              localObject2 = com.tencent.mm.plugin.finder.storage.data.q.sLl;
              com.tencent.mm.vfs.o.deleteFile(com.tencent.mm.plugin.finder.storage.data.q.cLP());
              paramc.crashCount = 0;
              paramc.GIb = 0L;
            }
          }
          av.a((av.c)new q.a((arh)localObject1));
          com.tencent.mm.ac.c.b(null, (d.g.a.a)y.rPr);
          paramc = com.tencent.mm.ui.component.a.KEX;
          paramc = (FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class);
          paramc.suC.alive();
          localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
          localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
          com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBy(), (Observer)paramc);
          AppForegroundDelegate.cTA.a((com.tencent.mm.app.o)paramc);
          com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.p.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.service.d());
          com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.f.class, (com.tencent.mm.kernel.c.a)getFinderContactService());
          com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.i.a.g.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.service.b());
          ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.byp.a.c.class)).addBypSyncHandler(1, (com.tencent.mm.plugin.byp.a.b)new com.tencent.mm.plugin.finder.message.a());
          paramc = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          d.g.b.p.g(paramc, "MMKernel.service(IMessengerStorage::class.java)");
          ((com.tencent.mm.plugin.messenger.foundation.a.l)paramc).azL().a((com.tencent.mm.plugin.messenger.foundation.a.g)getConversationUpdater());
          paramc = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          d.g.b.p.g(paramc, "MMKernel.service(IMessengerStorage::class.java)");
          ((com.tencent.mm.plugin.messenger.foundation.a.l)paramc).azF().a(getFinderContactService().sEg);
          com.tencent.mm.ac.c.b(null, (d.g.a.a)new com.tencent.mm.plugin.finder.conv.h.b(getConversationUpdater()));
          paramc = a.b.ffl();
          if ((paramc instanceof com.tencent.mm.pluginsdk.ui.b))
          {
            localObject1 = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.pluginsdk.ui.b)paramc).ffm());
            ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@findermsg", (j.a)localObject1);
            ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@finder", (j.a)localObject1);
            ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@findermsgstranger", (j.a)localObject1);
          }
          ab.a.a((ab.b)getGetContactInterceptor());
          com.tencent.mm.plugin.finder.report.v.cGr().CA();
          AppMethodBeat.o(162435);
          return;
          ae.i("Finder.PluginFinder", "[onAccountInitialized] user auto increment id=".concat(String.valueOf(i)));
        }
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { paramc });
          paramc = null;
          continue;
          paramc = null;
          continue;
          label1491:
          paramc = null;
          continue;
          label1496:
          i = 0;
          continue;
          label1501:
          paramc = null;
        }
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(162436);
    ae.i("Finder.PluginFinder", "onAccountRelease");
    Object localObject = com.tencent.mm.plugin.finder.model.y.stw;
    com.tencent.mm.kernel.g.ajj().b(3520, (com.tencent.mm.ak.f)localObject);
    localObject = this.rOd;
    ((com.tencent.mm.plugin.finder.upload.g)localObject).hip.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.finder.upload.g)localObject).sUt);
    ((com.tencent.mm.plugin.finder.upload.g)localObject).sUq.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.finder.upload.g)localObject).sUu);
    localObject = com.tencent.mm.plugin.finder.upload.g.sUx;
    localObject = com.tencent.mm.plugin.finder.upload.g.cNo();
    com.tencent.mm.plugin.finder.report.g localg = com.tencent.mm.plugin.finder.report.g.syJ;
    ((com.tencent.mm.plugin.finder.upload.g)localObject).b(com.tencent.mm.plugin.finder.report.g.cFr());
    com.tencent.mm.kernel.g.ajj().b(3565, (com.tencent.mm.ak.f)this.rOe);
    com.tencent.mm.kernel.g.ajj().b(3512, (com.tencent.mm.ak.f)this);
    com.tencent.mm.kernel.g.ajj().b(3870, (com.tencent.mm.ak.f)this.rOr);
    com.tencent.mm.kernel.g.ajj().b(3870, (com.tencent.mm.ak.f)this.rOs);
    com.tencent.mm.kernel.g.ajj().b(3870, (com.tencent.mm.ak.f)this.rOt);
    com.tencent.mm.kernel.g.ajj().b(3870, (com.tencent.mm.ak.f)this.rOu);
    com.tencent.mm.kernel.g.ajj().b(3870, (com.tencent.mm.ak.f)this.rOv);
    com.tencent.mm.kernel.g.ajj().b(3870, (com.tencent.mm.ak.f)this.rOw);
    com.tencent.mm.kernel.g.ajj().b(3870, (com.tencent.mm.ak.f)this.rOx);
    com.tencent.mm.kernel.g.ajj().b(3870, (com.tencent.mm.ak.f)this.rOy);
    com.tencent.mm.kernel.g.ajj().b(665, (com.tencent.mm.ak.f)this);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.n.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.l.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.j.class);
    com.tencent.mm.kernel.g.ac(m.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.h.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.k.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.i.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.q.class);
    this.rOI.dead();
    AppForegroundDelegate.cTA.b((com.tencent.mm.app.o)this.rOP);
    localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.s)localObject).getSysCmdMsgExtension().b("FinderPersonalMsgSysMsg", (com.tencent.mm.plugin.messenger.foundation.a.p)this.rOz);
    localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class);
    d.g.b.p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.s)localObject).getSysCmdMsgExtension().b("finderuserreinit", (com.tencent.mm.plugin.messenger.foundation.a.p)this.rOA);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(1);
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azL().b((com.tencent.mm.plugin.messenger.foundation.a.g)getConversationUpdater());
    localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().b(getFinderContactService().sEg);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.f.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.p.class);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.i.a.g.class);
    ab.a.b((ab.b)getGetContactInterceptor());
    localObject = a.b.ffl();
    if ((localObject instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      ((com.tencent.mm.pluginsdk.ui.b)localObject).aNO("@findermsg");
      ((com.tencent.mm.pluginsdk.ui.b)localObject).aNO("@finder");
    }
    if (this.gDX != null)
    {
      localObject = this.gDX;
      if (localObject != null) {
        ((com.tencent.mm.storagebase.h)localObject).closeDB();
      }
      this.gDX = null;
    }
    this.Fu.clear();
    this.rOL.dead();
    com.tencent.mm.plugin.finder.report.v.cGr().unregister();
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
      Object localObject = com.tencent.mm.ui.component.a.KEX;
      localObject = ((Iterable)((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).suA).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.finder.preload.tabPreload.f localf = (com.tencent.mm.plugin.finder.preload.tabPreload.f)((Iterator)localObject).next();
        ae.i(localf.TAG, "[performEnterFinder]");
        localf.suN = true;
        localf.suO.aiE("performEnterFinder");
      }
      requestAudioFocus();
    }
    if (!this.rON.contains(paramMMFinderUI)) {
      this.rON.add(paramMMFinderUI);
    }
    AppMethodBeat.o(165095);
  }
  
  public final void onExitFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165096);
    d.g.b.p.h(paramMMFinderUI, "finder");
    this.rON.remove(paramMMFinderUI);
    if (!isInFinder())
    {
      paramMMFinderUI = com.tencent.mm.ui.component.a.KEX;
      paramMMFinderUI = ((Iterable)((FinderStreamTabPreloadCore)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).suA).iterator();
      while (paramMMFinderUI.hasNext())
      {
        com.tencent.mm.plugin.finder.preload.tabPreload.f localf = (com.tencent.mm.plugin.finder.preload.tabPreload.f)paramMMFinderUI.next();
        ae.i(localf.TAG, "[performExitFinder]");
        localf.suN = false;
        localf.suO.a(localf.suS, localf.cET(), "performExitFinder");
      }
      this.hdv.abn();
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
      paramString = ((com.tencent.mm.ak.b)paramString).aEV();
      if (paramString == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetUserResponse");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = ((apd)paramString).GFl;
    } while (paramString == null);
    paramString = ((Iterable)paramString).iterator();
    while (paramString.hasNext())
    {
      paramn = (FinderContact)paramString.next();
      c.a locala = com.tencent.mm.plugin.finder.api.c.rPy;
      c.a.b(paramn);
    }
    AppMethodBeat.o(165099);
  }
  
  public final void reportPostRedDot(int paramInt)
  {
    AppMethodBeat.i(165122);
    com.tencent.mm.plugin.report.service.g.yxI.n(1309L, paramInt, 1L);
    com.tencent.mm.plugin.report.service.g.yxI.f(19212, new Object[] { Integer.valueOf(paramInt), Long.valueOf(ch.aDa()) });
    AppMethodBeat.o(165122);
  }
  
  public final FinderObject requestFinderObject(final long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(201415);
    ae.i("Finder.PluginFinder", "requestFinderObject " + paramLong + ", enter");
    y.f localf = new y.f();
    final Object localObject = com.tencent.mm.plugin.finder.storage.data.d.sKD;
    localf.NiY = com.tencent.mm.plugin.finder.storage.data.d.a.xk(paramLong);
    localObject = new Object();
    final y.a locala = new y.a();
    locala.NiT = false;
    if ((FinderItem)localf.NiY == null)
    {
      ae.i("Finder.PluginFinder", "requestFinderObject " + paramLong + ", start");
      new com.tencent.mm.plugin.finder.cgi.q(paramLong, paramString, paramInt, 2, "", true, null, null, 0L, null, false, false, null, null, 0, 24512).aET().h((com.tencent.mm.vending.c.a)new aa(localf, localObject, locala, paramLong));
    }
    if ((FinderItem)localf.NiY == null) {}
    try
    {
      if (!locala.NiT)
      {
        ae.i("Finder.PluginFinder", "requestFinderObject wait ".concat(String.valueOf(paramLong)));
        localObject.wait(2000L);
        ae.i("Finder.PluginFinder", "requestFinderObject notify ".concat(String.valueOf(paramLong)));
      }
      paramString = z.Nhr;
      paramString = (FinderItem)localf.NiY;
      if (paramString != null)
      {
        paramString = paramString.getFeedObject();
        AppMethodBeat.o(201415);
        return paramString;
      }
    }
    finally
    {
      AppMethodBeat.o(201415);
    }
    AppMethodBeat.o(201415);
    return null;
  }
  
  public final void resetConfig()
  {
    AppMethodBeat.i(165093);
    try
    {
      Object localObject = com.tencent.mm.plugin.finder.storage.data.f.sKL;
      f.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.k.sLb;
      k.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.b.sKy;
      com.tencent.mm.plugin.finder.storage.data.b.a.clearAll();
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbz, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JbA, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JcW, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JcZ, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jda, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jdb, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jdc, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jdd, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JaU, Long.valueOf(1L));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JaW, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JaX, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JaY, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JaZ, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jba, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbb, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbc, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbe, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbj, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbp, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbx, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JcH, Integer.valueOf(0));
      clearReInit();
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JbS, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jca, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcb, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jde, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jdf, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcf, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcg, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jch, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jci, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcj, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcl, Boolean.FALSE);
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcu, "");
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcx, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcy, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jcz, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.JcD, Boolean.FALSE);
      AppMethodBeat.o(165093);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("Finder.PluginFinder", (Throwable)localException, "resetConfig error", new Object[0]);
      AppMethodBeat.o(165093);
    }
  }
  
  public final void resetLastTimelineExitTime()
  {
    AppMethodBeat.i(165110);
    ae.i("Finder.PluginFinder", "reset timeline auto refresh time");
    AppMethodBeat.o(165110);
  }
  
  public final void setDataDB(com.tencent.mm.storagebase.h paramh)
  {
    this.gDX = paramh;
  }
  
  public final void setFinderMentionDB(com.tencent.mm.storagebase.h paramh)
  {
    this.rOa = paramh;
  }
  
  public final void setMessageDB(com.tencent.mm.storagebase.h paramh)
  {
    this.rOc = paramh;
  }
  
  public final void setWxMentionDB(com.tencent.mm.storagebase.h paramh)
  {
    this.rOb = paramh;
  }
  
  public final void shareStatsReport(List<String> paramList)
  {
    AppMethodBeat.i(201411);
    d.g.b.p.h(paramList, "feedIdList");
    y.f localf = new y.f();
    localf.NiY = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      dje localdje = new dje();
      localdje.rRn = com.tencent.mm.ac.c.xQ((String)localObject);
      localObject = new chk();
      ((chk)localObject).Htm += 1;
      ((chk)localObject).Hto = 1;
      localdje.HQQ = ((chk)localObject);
      ((LinkedList)localf.NiY).add(localdje);
    }
    new com.tencent.mm.plugin.finder.cgi.l((List)localf.NiY, null).aET().j((com.tencent.mm.vending.c.a)new PluginFinder.ab(localf));
    AppMethodBeat.o(201411);
  }
  
  public final boolean showFinderEntry()
  {
    AppMethodBeat.i(165102);
    boolean bool1;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGN, 0) != 0)
    {
      bool1 = true;
      Object localObject = com.tencent.mm.plugin.finder.spam.a.sEK;
      int i = com.tencent.mm.plugin.finder.spam.a.ajk("entrance");
      if (i == 2)
      {
        ae.i("Finder.PluginFinder", "showFinderEntry ".concat(String.valueOf(i)));
        bool1 = false;
      }
      if (this.rOQ)
      {
        ae.i("Finder.PluginFinder", "closeFinderEntryForDebug");
        bool1 = false;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cHF() == 0) {
        break label151;
      }
    }
    label151:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((!bool2) || (!bool1)) {
        ae.i("Finder.PluginFinder", "showFinder %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGO, 0) != 0)
    {
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (!com.tencent.mm.plugin.finder.storage.b.cHH()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      ae.i("Finder.PluginFinder", "showPost %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(165103);
      return bool;
    }
  }
  
  public final void snsToFinderPostReport(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, int paramInt5)
  {
    AppMethodBeat.i(201420);
    d.g.b.p.h(paramString1, "sessionID");
    d.g.b.p.h(paramString2, "wording");
    com.tencent.mm.plugin.finder.report.n localn = com.tencent.mm.plugin.finder.report.n.szV;
    com.tencent.mm.plugin.finder.report.n.a(paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramLong3, paramInt5);
    AppMethodBeat.o(201420);
  }
  
  public final FinderObject tryGetFinderObject(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(201412);
    paramString = tryGetFinderObject(paramLong, paramString, paramInt, true);
    AppMethodBeat.o(201412);
    return paramString;
  }
  
  public final FinderObject tryGetFinderObject(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201414);
    ae.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", enter");
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.finder.storage.data.d.sKD;
      com.tencent.mm.plugin.finder.storage.data.d.a.tS(paramLong);
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.data.d.sKD;
    localObject = com.tencent.mm.plugin.finder.storage.data.d.a.xk(paramLong);
    if (localObject == null)
    {
      ae.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", start");
      new com.tencent.mm.plugin.finder.cgi.q(paramLong, paramString, paramInt, 2, "", true, null, null, 0L, null, false, false, null, null, 0, 24512).aET().h((com.tencent.mm.vending.c.a)new ac(paramLong));
    }
    if (localObject != null)
    {
      paramString = ((FinderItem)localObject).getFeedObject();
      AppMethodBeat.o(201414);
      return paramString;
    }
    AppMethodBeat.o(201414);
    return null;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class aa<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    aa(y.f paramf, Object paramObject, y.a parama, long paramLong) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class ac<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    ac(long paramLong) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.app.o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(165054);
      PluginFinder.access$getAudioHelperTool$p(this.rOT).abn();
      AppMethodBeat.o(165054);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(165055);
      if (this.rOT.isInFinder()) {
        PluginFinder.access$requestAudioFocus(this.rOT);
      }
      if ((this.rOT.showFinderEntry()) && (SystemClock.uptimeMillis() - PluginFinder.access$getLastFinderInitTime$p(this.rOT) >= 86400000L)) {
        PluginFinder.access$doFinderInit(this.rOT);
      }
      AppMethodBeat.o(165055);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class g
    implements com.tencent.mm.storagebase.h.b
  {
    public static final g rOY;
    
    static
    {
      AppMethodBeat.i(201359);
      rOY = new g();
      AppMethodBeat.o(201359);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(201358);
      Object localObject = com.tencent.mm.plugin.finder.storage.q.sJt;
      localObject = com.tencent.mm.plugin.finder.storage.q.cBk();
      AppMethodBeat.o(201358);
      return localObject;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class i
    implements com.tencent.mm.storagebase.h.b
  {
    public static final i rPa;
    
    static
    {
      AppMethodBeat.i(201363);
      rPa = new i();
      AppMethodBeat.o(201363);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(201362);
      Object localObject = com.tencent.mm.plugin.finder.storage.a.sEQ;
      localObject = com.tencent.mm.plugin.finder.storage.a.cBk();
      AppMethodBeat.o(201362);
      return localObject;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class k
    implements com.tencent.mm.storagebase.h.b
  {
    public static final k rPc;
    
    static
    {
      AppMethodBeat.i(165065);
      rPc = new k();
      AppMethodBeat.o(165065);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165064);
      Object localObject = com.tencent.mm.plugin.finder.storage.j.sIM;
      localObject = com.tencent.mm.plugin.finder.storage.j.cBk();
      AppMethodBeat.o(165064);
      return localObject;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class l
    implements com.tencent.mm.storagebase.h.b
  {
    public static final l rPd;
    
    static
    {
      AppMethodBeat.i(201367);
      rPd = new l();
      AppMethodBeat.o(201367);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(201366);
      Object localObject = com.tencent.mm.plugin.finder.storage.y.sKd;
      localObject = com.tencent.mm.plugin.finder.storage.y.cBk();
      AppMethodBeat.o(201366);
      return localObject;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public static final p rPh;
    
    static
    {
      AppMethodBeat.i(165067);
      rPh = new p();
      AppMethodBeat.o(165067);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    q(PluginFinder paramPluginFinder, long paramLong, String paramString, int paramInt, Context paramContext, Intent paramIntent)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    public static final x rPq;
    
    static
    {
      AppMethodBeat.i(165072);
      rPq = new x();
      AppMethodBeat.o(165072);
    }
    
    public final void run()
    {
      AppMethodBeat.i(165071);
      com.tencent.mm.plugin.finder.upload.b.a locala = com.tencent.mm.plugin.finder.upload.b.sTP;
      com.tencent.mm.plugin.finder.upload.b.cNg().cNf();
      AppMethodBeat.o(165071);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class y
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public static final y rPr;
    
    static
    {
      AppMethodBeat.i(201386);
      rPr = new y();
      AppMethodBeat.o(201386);
    }
    
    y()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/PluginFinder$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
  public static final class z
    implements com.tencent.mm.model.d.a
  {
    public final void aAo()
    {
      AppMethodBeat.i(165073);
      ae.i("Finder.PluginFinder", "[audioHelperTool] gain");
      AppMethodBeat.o(165073);
    }
    
    public final void aAp()
    {
      AppMethodBeat.i(165075);
      ae.i("Finder.PluginFinder", "[audioHelperTool] loss");
      AppMethodBeat.o(165075);
    }
    
    public final void aAq()
    {
      AppMethodBeat.i(165074);
      ae.i("Finder.PluginFinder", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(165074);
    }
    
    public final void aAr()
    {
      AppMethodBeat.i(165076);
      ae.i("Finder.PluginFinder", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(165076);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder
 * JD-Core Version:    0.7.0.1
 */