package com.tencent.mm.plugin.finder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.is;
import com.tencent.mm.f.a.xv;
import com.tencent.mm.f.c.cr;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.af.a;
import com.tencent.mm.model.af.b;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.e;
import com.tencent.mm.plugin.finder.cgi.ap;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.conv.j.b;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.live.report.s.bj;
import com.tencent.mm.plugin.finder.live.report.s.bk;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.megavideo.floatball.b.a.a;
import com.tencent.mm.plugin.finder.model.bk;
import com.tencent.mm.plugin.finder.preload.tabPreload.c.c;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.c;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ah.a;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.u.a;
import com.tencent.mm.plugin.finder.storage.s.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ae.a;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.ak.a;
import com.tencent.mm.plugin.messenger.foundation.a.z.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.wcdb.database.SQLiteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder;", "Lcom/tencent/mm/kernel/api/ICoreStorageCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "CURRENT_DB_VERSION", "", "kotlin.jvm.PlatformType", "CURRENT_DB_VERSION_DEFAULT", "FINDER_FOLDER_LRU_EXPIRE", "", "getFINDER_FOLDER_LRU_EXPIRE", "()J", "FINDER_FOLDER_MAX_SIZE", "getFINDER_FOLDER_MAX_SIZE", "actionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "appForegroundListener", "com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1;", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "closeFinderEntryForDebug", "", "contactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "conversationUpdater", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "getConversationUpdater", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "conversationUpdater$delegate", "Lkotlin/Lazy;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDataDB", "()Lcom/tencent/mm/storagebase/SqliteDB;", "setDataDB", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "draftStorage", "Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorage;", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1;", "feedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "findDelFansService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderDelFansService;", "finderActivity", "", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "", "finderAgreeSavePhone", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderAgreeSavePhone;", "finderCommonService", "Lcom/tencent/mm/plugin/FinderCommonService;", "finderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "finderContactService", "Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "getFinderContactService", "()Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "finderContactService$delegate", "finderEnterPersonalMsgService", "Lcom/tencent/mm/plugin/finder/service/FinderEnterPersonalMsgService;", "finderLiveService", "Lcom/tencent/mm/plugin/MMLiveService;", "finderMentionDB", "getFinderMentionDB", "setFinderMentionDB", "finderMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "finderModBlockPosterSetting", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModBlockPosterService;", "finderModOverSeaAgree", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModOverSeaAgree;", "finderOrAliasDeletingStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderOrAliasDeletingInfoStorage;", "finderPrivateSysMsgConsumer", "Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "finderPromotionConsumer", "Lcom/tencent/mm/plugin/finder/newxml/FinderPromotionConsumer;", "finderReInitSysMsgConsumer", "Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer;", "finderSyncEventListener", "com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1;", "finderTeenModeConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "getFinderTeenModeConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "finderTeenModeConfig$delegate", "finderUtilApi", "Lcom/tencent/mm/plugin/finder/utils/FinderUtilApi;", "followTlSingleExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getFollowTlSingleExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "followTlSingleExecutor$delegate", "getContactInterceptor", "Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "getContactInterceptor$delegate", "isDoSomethingCompleted", "isFriendCache", "Ljava/util/concurrent/ConcurrentHashMap;", "lastFinderInitTime", "lastReportTime", "localLikeFeedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage;", "lock", "", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "mediaPreloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getMediaPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "mediaPreloadModel$delegate", "messageDB", "getMessageDB", "setMessageDB", "messageStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage;", "modifyBlackListService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "modifyFeedSettingService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "modifyFinderFeedProduce", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "modifyFinderMessageService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "modifyFinderMessageSessionService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderMsgSessionMuteSetting;", "modifyFinderWxMessageSessionService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "modifyLikeRecommendService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "modifyProfileStickyService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModProfileSticky;", "modifyUserService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "msgAliasContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "msgStrangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "needResetDb", "postManager", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "redDotCtrInfoStorage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "startActivityEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StartActivityEvent;", "syncExtension", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "teenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "wxMentionDB", "getWxMentionDB", "setWxMentionDB", "wxMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "canEnterMvAndShowToast", "checkAccountDeletingTask", "", "checkIfSameMsgTableName", "checkResetDb", "clearMentionDB", "clearReInit", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "collectFinderDatabaseFactory", "Lkotlin/collections/HashMap;", "collectMentionDatabaseFactory", "collectMessageDatabaseFactory", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "doFinderInit", "doPrepareUser", "doReInit", "reInitVersion", "reInitUsername", "doSomethingImportantOnStart", "dumpAndMarkFinderFolder", "enterAlbumRelatedTimelineUI", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "enterFinderActivityProfileUI", "enterFinderConversationUI", "enterFinderFollowListUI", "enterFinderGallery", "activity", "requestCode", "enterFinderPoiFeedUI", "enterFinderPostRouterUI", "enterFinderPostUI", "enterFinderProfileUI", "enterFinderSelfProfile", "enter", "enterType", "enterFinderSelfUI", "enterFinderShareFeedUI", "json", "i", "enterFinderTimelineUI", "needPreFectch", "enterFinderTopicTimelineUI", "enterFinderTopicUI", "jsObj", "enterFinderUI", "enterFinderUIFromMiniApp", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "failedCallback", "execute", "fillContextIdToIntent", "toCommentScene", "newContextId", "genContextId", "getContactStorage", "getConversationStorage", "getDB", "getDraftStorage", "getFeedStorage", "getFinderActionStorage", "getFinderContactCache", "getFinderOpenSdkApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderOpenSdkApi;", "getFinderOrAliasDeletingInfoStorage", "getFinderSwitchApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSwitchApi;", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getFinderUIApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUIApi;", "getFinderUtilApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi;", "getLocalLikeFeedStorage", "getMediaCacheStorage", "getMentionStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "localFlag", "getMessageStorage", "getMsgAliasContactStorage", "getMsgStrangerContactStorage", "getRedDotCtrInfoStorage", "getRedDotManager", "getSessionInfoStorage", "getTimelineCommentScene", "getViewModelStore", "hasFinderPosted", "isAllEnableFullScreenEnjoy", "isAllHomeTabEnableFullScreenEnjoy", "isAllowEditFillingFullScreen", "isAnyEnableFullScreenEnjoy", "isAnyHomeTabEnableFullScreenEnjoy", "isDisablePostHalfScreen", "isFriend", "username", "isGlobalEnableFullScreenEnjoy", "isInFinder", "isNeedDoReInit", "isOtherEnableFullScreenEnjoy", "isPagEnable", "loadAvatar", "url", "avatarIv", "Landroid/widget/ImageView;", "loadImage", "imageView", "urlToken", "decodeKey", "call", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "loadImageForSns", "qImageView", "Landroid/view/View;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onAppBackground", "onAppForeground", "onDataBaseClosed", "readOnlyDB", "onDataBaseOpened", "onEnterFinder", "finder", "onExitFinder", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "openChannelsCreateContact", "Landroid/app/Activity;", "didOpenCallback", "openChannelsPostPage", "openFinderFeed", "extInfo", "Lcom/tencent/mm/json/JSONObject;", "appid", "openFinderLiveOperationUI", "openFinderLiveOperationUIFromJSAPI", "openFinderLiveOperationUIInternal", "requestScene", "useDarkStyle", "selectTabId", "selectSecondTabId", "byPass", "entryScene", "feedExportId", "feedNonceId", "pageTitle", "openFinderProfile", "refreshXLabConfigToMMKV", "report21053", "recyclerView", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "firstVisibleItem", "visibleItemCount", "actionType", "commentscene", "event", "headerShow", "report21053OnClick", "feedId", "liveId", "userName", "index", "onlineNum", "enterStatus", "shareType", "shareUserName", "snsFeedid", "enterTime", "report21053OnClickOnSnsAd", "pos", "reportFinderPrivateMsgTableSize", "reportGiftOnReturn", "reportPostRedDot", "key", "requestAudioFocus", "requestFinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectId", "objectNonceId", "commentScene", "resetConfig", "resetDb", "resetLastFinderInitTime", "resetLastTimelineExitTime", "sdkShare", "businessType", "set21084CommentScene", "shareStatsReport", "feedIdList", "", "Landroid/util/Pair;", "isMegaVideo", "showFinderEntry", "showPostEntry", "snsToFinderPostReport", "sessionID", "wording", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "timeStamp", "exposeType", "tryGetFinderObject", "force", "needLoading", "callBack", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder$GetFinderObjectCallback;", "Companion", "plugin-finder_release"})
public final class PluginFinder
  extends com.tencent.mm.kernel.b.f
  implements androidx.lifecycle.ab, com.tencent.mm.an.i, com.tencent.mm.app.o, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, ak
{
  public static final a wVR;
  private final androidx.lifecycle.aa VK;
  private final com.tencent.mm.model.d kKI;
  private com.tencent.mm.storagebase.h kcF;
  private long lastReportTime;
  private final byte[] lock;
  private com.tencent.mm.plugin.teenmode.a.c nCC;
  private volatile boolean wUJ;
  private com.tencent.mm.storagebase.h wUK;
  private com.tencent.mm.storagebase.h wUL;
  private com.tencent.mm.storagebase.h wUM;
  private final com.tencent.mm.plugin.finder.upload.g wUN;
  private final com.tencent.mm.plugin.finder.extension.c wUO;
  private com.tencent.mm.plugin.finder.storage.e wUP;
  private com.tencent.mm.plugin.finder.storage.z wUQ;
  private com.tencent.mm.plugin.finder.storage.y wUR;
  private com.tencent.mm.plugin.finder.storage.f wUS;
  private com.tencent.mm.plugin.finder.storage.af wUT;
  private com.tencent.mm.plugin.finder.storage.v wUU;
  private com.tencent.mm.plugin.finder.storage.ad wUV;
  private com.tencent.mm.plugin.finder.storage.m wUW;
  private com.tencent.mm.plugin.finder.storage.logic.b wUX;
  private com.tencent.mm.plugin.finder.storage.t wUY;
  private com.tencent.mm.plugin.finder.extension.reddot.c wUZ;
  private final kotlin.f wVA;
  private final kotlin.f wVB;
  private final z wVC;
  private final kotlin.f wVD;
  private final kotlin.f wVE;
  private final kotlin.f wVF;
  private final com.tencent.mm.plugin.a wVG;
  private final com.tencent.mm.plugin.e wVH;
  private final IListener<xv> wVI;
  private final x wVJ;
  private volatile boolean wVK;
  private final Set<MMFinderUI> wVL;
  private long wVM;
  private final b wVN;
  private boolean wVO;
  private final ConcurrentHashMap<String, Boolean> wVP;
  private final al wVQ;
  private com.tencent.mm.plugin.finder.storage.ai wVa;
  private com.tencent.mm.plugin.finder.storage.n wVb;
  private com.tencent.mm.plugin.finder.storage.a wVc;
  private com.tencent.mm.plugin.finder.storage.s wVd;
  private final com.tencent.mm.plugin.finder.cgi.oplog.k wVe;
  private final com.tencent.mm.plugin.finder.cgi.oplog.h wVf;
  private final com.tencent.mm.plugin.finder.cgi.oplog.f wVg;
  private final com.tencent.mm.plugin.finder.cgi.oplog.a wVh;
  private final com.tencent.mm.plugin.finder.cgi.oplog.e wVi;
  private final com.tencent.mm.plugin.finder.cgi.oplog.d wVj;
  private final com.tencent.mm.plugin.finder.cgi.oplog.l wVk;
  private final com.tencent.mm.plugin.finder.cgi.oplog.n wVl;
  private final com.tencent.mm.plugin.finder.cgi.oplog.j wVm;
  private final com.tencent.mm.plugin.finder.cgi.oplog.i wVn;
  private final com.tencent.mm.plugin.finder.conv.k wVo;
  private final com.tencent.mm.plugin.finder.newxml.c wVp;
  private final com.tencent.mm.plugin.finder.newxml.b wVq;
  private final com.tencent.mm.plugin.finder.cgi.oplog.g wVr;
  private final com.tencent.mm.plugin.finder.cgi.oplog.c wVs;
  private final com.tencent.mm.plugin.finder.cgi.oplog.b wVt;
  private final com.tencent.mm.plugin.finder.service.c wVu;
  private final com.tencent.mm.plugin.finder.api.b wVv;
  private com.tencent.mm.plugin.finder.extension.reddot.f wVw;
  private final kotlin.f wVx;
  private final String wVy;
  private final String wVz;
  
  static
  {
    AppMethodBeat.i(162442);
    wVR = new a((byte)0);
    AppMethodBeat.o(162442);
  }
  
  public PluginFinder()
  {
    AppMethodBeat.i(165123);
    this.lock = new byte[0];
    com.tencent.mm.plugin.finder.upload.g.a locala = com.tencent.mm.plugin.finder.upload.g.AAk;
    this.wUN = com.tencent.mm.plugin.finder.upload.g.ecj();
    this.wUO = new com.tencent.mm.plugin.finder.extension.c();
    this.wVe = new com.tencent.mm.plugin.finder.cgi.oplog.k();
    this.wVf = new com.tencent.mm.plugin.finder.cgi.oplog.h();
    this.wVg = new com.tencent.mm.plugin.finder.cgi.oplog.f();
    this.wVh = new com.tencent.mm.plugin.finder.cgi.oplog.a();
    this.wVi = new com.tencent.mm.plugin.finder.cgi.oplog.e();
    this.wVj = new com.tencent.mm.plugin.finder.cgi.oplog.d();
    this.wVk = new com.tencent.mm.plugin.finder.cgi.oplog.l();
    this.wVl = new com.tencent.mm.plugin.finder.cgi.oplog.n();
    this.wVm = new com.tencent.mm.plugin.finder.cgi.oplog.j();
    this.wVn = new com.tencent.mm.plugin.finder.cgi.oplog.i();
    this.wVo = new com.tencent.mm.plugin.finder.conv.k();
    this.wVp = new com.tencent.mm.plugin.finder.newxml.c();
    this.wVq = new com.tencent.mm.plugin.finder.newxml.b();
    this.wVr = new com.tencent.mm.plugin.finder.cgi.oplog.g();
    this.wVs = new com.tencent.mm.plugin.finder.cgi.oplog.c();
    this.wVt = new com.tencent.mm.plugin.finder.cgi.oplog.b();
    this.wVu = new com.tencent.mm.plugin.finder.service.c();
    this.wVv = new com.tencent.mm.plugin.finder.api.b();
    this.wVx = kotlin.g.ar((kotlin.g.a.a)ab.wWs);
    this.wVy = MD5Util.getMD5String("FinderMM029.dbFinderMention001.db");
    this.wVz = MD5Util.getMD5String("FinderMM029.dbFinderMention001.db");
    this.wVA = kotlin.g.ar((kotlin.g.a.a)af.wWy);
    this.wVB = kotlin.g.ar((kotlin.g.a.a)ac.wWt);
    this.wVC = new z(this);
    this.wVD = kotlin.g.ar((kotlin.g.a.a)y.wWq);
    this.wVE = kotlin.g.ar((kotlin.g.a.a)s.wWi);
    this.wVF = kotlin.g.ar((kotlin.g.a.a)aa.wWr);
    this.nCC = ((com.tencent.mm.plugin.teenmode.a.c)ao.wWG);
    this.wVG = new com.tencent.mm.plugin.a();
    this.wVH = new com.tencent.mm.plugin.e();
    this.wVI = ((IListener)new an());
    this.wVJ = new x(this);
    this.wVL = Collections.synchronizedSet((Set)new HashSet());
    this.kKI = com.tencent.mm.model.d.bcs();
    this.wVN = new b(this);
    this.wVP = new ConcurrentHashMap();
    this.VK = new androidx.lifecycle.aa();
    this.wVQ = new al();
    AppMethodBeat.o(165123);
  }
  
  private final void checkAccountDeletingTask()
  {
    AppMethodBeat.i(275656);
    com.tencent.e.h.ZvG.bg((Runnable)new c(this));
    AppMethodBeat.o(275656);
  }
  
  private final void checkIfSameMsgTableName()
  {
    AppMethodBeat.i(275635);
    Object localObject1 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
    localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.VBb, "");
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(275635);
      throw ((Throwable)localObject1);
    }
    localObject1 = (String)localObject1;
    Object localObject2 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.VBc, "");
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(275635);
      throw ((Throwable)localObject1);
    }
    localObject2 = (String)localObject2;
    if (((CharSequence)localObject1).length() > 0)
    {
      i = 1;
      if ((i != 0) && ((kotlin.g.b.p.h(localObject1, cr.hUn) ^ true)))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.eeg();
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label198;
      }
    }
    label198:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && ((kotlin.g.b.p.h(localObject2, cr.hUo) ^ true)))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.eeh();
      }
      AppMethodBeat.o(275635);
      return;
      i = 0;
      break;
    }
  }
  
  private final void checkResetDb()
  {
    AppMethodBeat.i(165077);
    Log.v("Finder.PluginFinder", "checkResetDb1 " + this.wUJ);
    if (this.wUJ)
    {
      Log.v("Finder.PluginFinder", "checkResetDb2 " + this.wUJ);
      synchronized (this.lock)
      {
        Object localObject1 = new StringBuilder("checkResetDb  need reset DB now ");
        Thread localThread = Thread.currentThread();
        kotlin.g.b.p.j(localThread, "Thread.currentThread()");
        localObject1 = ((StringBuilder)localObject1).append(localThread.getName()).append(" ");
        localThread = Thread.currentThread();
        kotlin.g.b.p.j(localThread, "Thread.currentThread()");
        Log.i("Finder.PluginFinder", localThread.getId() + " " + hashCode());
        if (this.wUJ)
        {
          resetDb();
          this.wUJ = false;
          Log.i("Finder.PluginFinder", "resetDB done");
        }
        localObject1 = kotlin.x.aazN;
        AppMethodBeat.o(165077);
        return;
      }
    }
    AppMethodBeat.o(165077);
  }
  
  private final void clearMentionDB()
  {
    AppMethodBeat.i(165079);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHl();
    com.tencent.mm.vfs.u.deleteFile((String)localObject + "FinderMention001.db");
    com.tencent.mm.vfs.u.deleteFile((String)localObject + "FinderMention002.db");
    this.wUK = null;
    this.wUL = null;
    AppMethodBeat.o(165079);
  }
  
  private final void clearReInit()
  {
    AppMethodBeat.i(165094);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VAE, Integer.valueOf(0));
    localf = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VAF, "");
    AppMethodBeat.o(165094);
  }
  
  private final HashMap<Integer, h.b> collectFinderDatabaseFactory()
  {
    AppMethodBeat.i(275637);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_CONTACT_TABLE".hashCode()), e.wVU);
    ((Map)localHashMap).put(Integer.valueOf("FinderMsgContactStorage".hashCode()), f.wVV);
    ((Map)localHashMap).put(Integer.valueOf("FinderMsgAliasContactStorage".hashCode()), g.wVW);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FEED_TABLE".hashCode()), h.wVX);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_DRAFT_TABLE".hashCode()), i.wVY);
    ((Map)localHashMap).put(Integer.valueOf("FinderMediaCacheInfoV2".hashCode()), j.wVZ);
    ((Map)localHashMap).put(Integer.valueOf("FinderRedDotInfo".hashCode()), k.wWa);
    ((Map)localHashMap).put(Integer.valueOf("FinderAction".hashCode()), l.wWb);
    Object localObject = (Map)localHashMap;
    s.a locala = com.tencent.mm.plugin.finder.storage.s.Alw;
    ((Map)localObject).put(Integer.valueOf(com.tencent.mm.plugin.finder.storage.s.dYM().hashCode()), m.wWc);
    localObject = com.tencent.c.a.a.a.b.Zjl;
    localHashMap.putAll((Map)com.tencent.c.a.a.a.b.a.ilg());
    AppMethodBeat.o(275637);
    return localHashMap;
  }
  
  private final HashMap<Integer, h.b> collectMentionDatabaseFactory()
  {
    AppMethodBeat.i(165081);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FINDER_MENTION_TABLE".hashCode()), n.wWd);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_WX_MENTION_TABLE".hashCode()), o.wWe);
    AppMethodBeat.o(165081);
    return localHashMap;
  }
  
  private final HashMap<Integer, h.b> collectMessageDatabaseFactory()
  {
    AppMethodBeat.i(275639);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FinderConversation".hashCode()), p.wWf);
    ((Map)localHashMap).put(Integer.valueOf("FinderSessionInfo".hashCode()), q.wWg);
    ((Map)localHashMap).put(Integer.valueOf("FinderOrAliasDeletingInfo".hashCode()), PluginFinder.r.wWh);
    AppMethodBeat.o(275639);
    return localHashMap;
  }
  
  private final void doFinderInit()
  {
    AppMethodBeat.i(165088);
    Log.i("Finder.PluginFinder", "[doFinderInit] ...");
    this.wVM = System.currentTimeMillis();
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new bx());
    AppMethodBeat.o(165088);
  }
  
  private final void doPrepareUser()
  {
    AppMethodBeat.i(165091);
    Log.i("Finder.PluginFinder", "[doPrepareUser]... ");
    ch localch = new ch(1);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localch);
    AppMethodBeat.o(165091);
  }
  
  private final void doReInit(int paramInt, String paramString)
  {
    AppMethodBeat.i(165090);
    try
    {
      com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 21L, 1L);
      Object localObject = com.tencent.mm.plugin.finder.storage.data.g.Anf;
      com.tencent.mm.plugin.finder.storage.data.g.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.k.Anu;
      k.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.b.AmP;
      com.tencent.mm.plugin.finder.storage.data.b.a.clearAll();
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vzp, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vzq, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBa, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBd, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBe, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBf, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBg, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBh, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBi, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBj, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBk, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBl, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBm, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBn, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VyF, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vzn, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAG, Integer.valueOf(paramInt));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VxX, paramString);
      paramString = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(paramString, "MMKernel.storage()");
      paramString.aHp().set(ar.a.VBo, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(paramString, "MMKernel.storage()");
      paramString.aHp().set(ar.a.VBp, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(paramString, "MMKernel.storage()");
      paramString.aHp().set(ar.a.VAH, Integer.valueOf(0));
      paramString = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(paramString, "MMKernel.storage()");
      paramInt = paramString.aHp().getInt(ar.a.VAI, 0);
      paramString = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(paramString, "MMKernel.storage()");
      paramString.aHp().set(ar.a.VAI, Integer.valueOf(paramInt + 1));
      clearReInit();
      Log.i("Finder.PluginFinder", "[doReInit] reInit done. incrementId=" + (paramInt + 1));
      AppMethodBeat.o(165090);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("Finder.PluginFinder", (Throwable)paramString, "do ReInit occur error!", new Object[0]);
      com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 22L, 1L);
      AppMethodBeat.o(165090);
    }
  }
  
  private final void doSomethingImportantOnStart()
  {
    AppMethodBeat.i(275650);
    this.wVJ.alive();
    if (this.wVK)
    {
      AppMethodBeat.o(275650);
      return;
    }
    boolean bool2 = showFinderEntry();
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWt().aSr()).intValue() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("Finder.PluginFinder", "[doSomethingImportantOnStart] " + com.tencent.mm.model.z.bdh() + " isDoSomethingCompleted=" + this.wVK + ", isShowFinderEntry=" + bool2 + " FIX_REINIT_SELECTOR_ENABLE_VALUE=" + bool1);
      if (bool2) {
        break;
      }
      AppMethodBeat.o(275650);
      return;
    }
    this.wVK = true;
    bool2 = isNeedDoReInit();
    if (!Util.isNullOrNil(com.tencent.mm.model.z.bdh())) {
      com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 34L, 1L);
    }
    if (bool2)
    {
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VAE, 0);
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VAF, "");
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(275650);
        throw ((Throwable)localObject);
      }
      doReInit(i, (String)localObject);
      doPrepareUser();
      if (!bool1) {
        this.wUO.gu(113661, 6);
      }
    }
    for (;;)
    {
      if (bool1) {
        this.wUO.gu(113661, 6);
      }
      getRedDotManager().prepare();
      AppMethodBeat.o(275650);
      return;
      if (Util.isNullOrNil(com.tencent.mm.model.z.bdh()))
      {
        com.tencent.mm.kernel.h.aGY().a(3930, (com.tencent.mm.an.i)this);
        com.tencent.mm.kernel.h.aGY().a(3930, (com.tencent.mm.an.i)getRedDotManager());
        doFinderInit();
        if (!bool1) {
          this.wUO.gu(113149, 6);
        }
      }
    }
  }
  
  private final com.tencent.mm.plugin.finder.conv.j getConversationUpdater()
  {
    AppMethodBeat.i(275630);
    com.tencent.mm.plugin.finder.conv.j localj = (com.tencent.mm.plugin.finder.conv.j)this.wVE.getValue();
    AppMethodBeat.o(275630);
    return localj;
  }
  
  private final com.tencent.mm.plugin.finder.service.a getFinderContactService()
  {
    AppMethodBeat.i(275629);
    com.tencent.mm.plugin.finder.service.a locala = (com.tencent.mm.plugin.finder.service.a)this.wVD.getValue();
    AppMethodBeat.o(275629);
    return locala;
  }
  
  private final com.tencent.mm.plugin.finder.storage.ah getFinderTeenModeConfig()
  {
    AppMethodBeat.i(275631);
    com.tencent.mm.plugin.finder.storage.ah localah = (com.tencent.mm.plugin.finder.storage.ah)this.wVF.getValue();
    AppMethodBeat.o(275631);
    return localah;
  }
  
  private final com.tencent.mm.plugin.finder.service.d getGetContactInterceptor()
  {
    AppMethodBeat.i(275628);
    com.tencent.mm.plugin.finder.service.d locald = (com.tencent.mm.plugin.finder.service.d)this.wVB.getValue();
    AppMethodBeat.o(275628);
    return locald;
  }
  
  private final boolean isNeedDoReInit()
  {
    AppMethodBeat.i(275633);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    int j = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VAH, -1);
    localObject = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    int k = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VAG, 0);
    localObject = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    int m = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VAE, 0);
    localObject = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VAF, "");
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(275633);
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
          com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
          kotlin.g.b.p.j(localf, "MMKernel.storage()");
          localf.aHp().set(ar.a.VAH, Integer.valueOf(1));
          i = 1;
        }
      }
    }
    localObject = new StringBuilder("[isNeedDoReInit] userVersion=").append(k).append(", reInitUserVersion=").append(m).append(", reInitUsername=").append((String)localObject).append(" isNeedDoReInit=");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.PluginFinder", bool);
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(275633);
      return true;
    }
    AppMethodBeat.o(275633);
    return false;
  }
  
  private final void openFinderFeed(com.tencent.mm.ad.i parami, Context paramContext, ag.a<Object> parama, String paramString)
  {
    AppMethodBeat.i(275686);
    String str2 = parami.optString("feedID");
    String str1 = parami.optString("nonceID");
    boolean bool;
    int m;
    String str3;
    int n;
    Object localObject1;
    int i;
    if (parami.optInt("notGetReleatedList") == 0)
    {
      bool = true;
      m = parami.optInt("shareScene", 0);
      str3 = parami.optString("sessionId", "");
      n = parami.optInt("requestScene", 3);
      localObject1 = parami.optString("reportExtraInfo", "");
      i = parami.optInt("commentScene", 0);
      localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.aFU((String)localObject1)) {
        break label185;
      }
    }
    int i1;
    int k;
    label185:
    for (int j = 42;; j = 39)
    {
      i1 = parami.optInt("adJSAPIType", 0);
      parami = parami.optString("userName", "");
      localObject2 = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      k = com.tencent.mm.plugin.findersdk.c.a.aGQ("entrance");
      if (k == 0) {
        break label192;
      }
      parami = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.fI(paramContext);
      Log.i("Finder.PluginFinder", "[openFinderFeed] spamAction:".concat(String.valueOf(k)));
      AppMethodBeat.o(275686);
      return;
      bool = false;
      break;
    }
    label192:
    Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.aFU((String)localObject1))
    {
      k = 4;
      if (i == 0)
      {
        localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.Re(m) == -1) {
          break label316;
        }
      }
      if (i == 0) {
        break label301;
      }
      label232:
      if (i1 != 1) {
        break label322;
      }
      paramString = new Intent();
      fillContextIdToIntent(i, k, j, paramString);
      com.tencent.mm.plugin.sns.ad.d.l.a(paramString, paramContext, parami, str1, str2, (String)localObject1);
    }
    for (;;)
    {
      if (parama == null) {
        break label545;
      }
      parama.aH(Integer.valueOf(0));
      AppMethodBeat.o(275686);
      return;
      k = 2;
      break;
      label301:
      localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      i = com.tencent.mm.plugin.finder.utils.aj.Re(m);
      break label232;
      label316:
      i = 0;
      break label232;
      label322:
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("from_user", com.tencent.mm.model.z.bcZ());
      ((Intent)localObject2).putExtra("feed_encrypted_object_id", str2);
      ((Intent)localObject2).putExtra("feed_object_nonceId", str1);
      ((Intent)localObject2).putExtra("key_need_related_list", bool);
      ((Intent)localObject2).putExtra("key_comment_scene", j);
      ((Intent)localObject2).putExtra("key_reuqest_scene", n);
      ((Intent)localObject2).putExtra("key_session_id", str3);
      ((Intent)localObject2).putExtra("key_extra_info", (String)localObject1);
      str1 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(i, k, j, (Intent)localObject2);
      if (!Util.isNullOrNil(paramString))
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
        parami = str1;
        if (str1 == null) {
          parami = "";
        }
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(21140, new Object[] { parami, paramString, str2, "" });
      }
      ((Intent)localObject2).putExtra("report_scene", m);
      ((Intent)localObject2).putExtra("tab_type", 9);
      parami = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.E(paramContext, (Intent)localObject2);
      parami = com.tencent.mm.plugin.secinforeport.a.d.Jcm;
      com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999685);
    }
    label545:
    AppMethodBeat.o(275686);
  }
  
  private final void openFinderLiveOperationUIFromJSAPI(com.tencent.mm.ad.i parami, Context paramContext, ag.a<Object> parama, String paramString)
  {
    AppMethodBeat.i(275671);
    int i = parami.optInt("requestScene");
    boolean bool = parami.optBoolean("useDarkStyle");
    int j = parami.optInt("selectTabId");
    int k = parami.optInt("selectSecondTabId");
    parama = parami.optString("byPass");
    int m = parami.optInt("entryScene");
    paramString = parami.optString("feedID");
    String str = parami.optString("nonceID");
    parami = parami.optString("pageTitle");
    kotlin.g.b.p.j(parama, "byPass");
    kotlin.g.b.p.j(paramString, "feedExportId");
    kotlin.g.b.p.j(str, "feedNonceId");
    kotlin.g.b.p.j(parami, "pageTitle");
    openFinderLiveOperationUIInternal(paramContext, i, bool, j, k, parama, m, paramString, str, parami);
    AppMethodBeat.o(275671);
  }
  
  private final void openFinderLiveOperationUIInternal(Context paramContext, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(275677);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_request_scene", paramInt1);
    int i;
    if (paramBoolean)
    {
      i = 1;
      localIntent.putExtra("key_use_dark_style", i);
      localIntent.putExtra("key_select_tab_id", paramInt2);
      localIntent.putExtra("key_select_second_tab_id", paramInt3);
      localIntent.putExtra("key_by_pass", paramString1);
      localIntent.putExtra("key_feed_export_id", paramString2);
      localIntent.putExtra("key_feed_nonce_id", paramString3);
      localIntent.putExtra("key_page_title", paramString4);
      localIntent.putExtra("nearby_live_target_auto_refresh_params_key", true);
      localIntent.putExtra("nearby_live_all_auto_refresh_params_key", true);
      switch (paramInt1)
      {
      default: 
        paramInt2 = 9500002;
        switch (paramInt1)
        {
        default: 
          label161:
          paramString1 = "9002";
        }
        break;
      }
    }
    for (;;)
    {
      localIntent.putExtra("key_comment_scene", paramInt2);
      localIntent.putExtra("key_click_tab_id", paramString1);
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(paramInt4, 2, paramInt2, localIntent);
      ((com.tencent.c.a.b.a.d)com.tencent.mm.kernel.h.ag(com.tencent.c.a.b.a.d.class)).enterFinderLiveOperationUI(paramContext, localIntent);
      AppMethodBeat.o(275677);
      return;
      i = 0;
      break;
      paramInt2 = 9500001;
      break label161;
      paramInt2 = 9500002;
      break label161;
      paramString1 = "9001";
      continue;
      paramString1 = "9002";
    }
  }
  
  private final void openFinderProfile(com.tencent.mm.ad.i parami, Context paramContext, ag.a<Object> parama, String paramString)
  {
    AppMethodBeat.i(275690);
    String str1 = parami.optString("feedID");
    String str2 = parami.optString("finderUserName");
    int j = parami.optInt("commentScene");
    parami = parami.optString("reportExtraInfo", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", str2);
    localIntent.putExtra("finder_read_feed_id", str1);
    localIntent.putExtra("key_extra_info", parami);
    localIntent.putExtra("key_from_profile_share_scene", 18);
    localIntent.putExtra("key_comment_scene", 39);
    Object localObject = com.tencent.mm.plugin.finder.live.report.m.yCt;
    kotlin.g.b.p.j(parami, "extraInfo");
    com.tencent.mm.plugin.finder.live.report.m.aCA(parami);
    localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    c.a.gF(parami, str2);
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    if (j > 0)
    {
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.aFU(parami)) {
        break label266;
      }
      i = 4;
      localObject = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(j, i, 32, localIntent);
      if (!Util.isNullOrNil(paramString))
      {
        localh = com.tencent.mm.plugin.report.service.h.IzE;
        if (localObject != null) {
          break label279;
        }
      }
    }
    label266:
    label279:
    for (parami = "";; parami = (com.tencent.mm.ad.i)localObject)
    {
      localh.a(21140, new Object[] { parami, paramString, str1, str2 });
      com.tencent.mm.plugin.expt.hellhound.core.b.awV((String)localObject);
      parami = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, localIntent);
      if (parama != null)
      {
        parama.aH(Integer.valueOf(0));
        AppMethodBeat.o(275690);
        return;
        i = 2;
        break;
      }
      AppMethodBeat.o(275690);
      return;
    }
  }
  
  private final void reportFinderPrivateMsgTableSize()
  {
    AppMethodBeat.i(275655);
    com.tencent.e.h.ZvG.bf((Runnable)new aj(this));
    AppMethodBeat.o(275655);
  }
  
  private final void requestAudioFocus()
  {
    AppMethodBeat.i(165098);
    this.kKI.a((com.tencent.mm.model.d.a)new ak());
    AppMethodBeat.o(165098);
  }
  
  private final void resetDb()
  {
    AppMethodBeat.i(165078);
    Object localObject1;
    Object localObject2;
    if (this.kcF == null)
    {
      this.kcF = new com.tencent.mm.storagebase.h();
      localObject1 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHl();
      localObject1 = (String)localObject1 + "FinderMM029.db";
      localObject2 = this.kcF;
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      if (!((com.tencent.mm.storagebase.h)localObject2).a((String)localObject1, collectFinderDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("finder db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
    }
    if (this.wUK == null)
    {
      this.wUK = new com.tencent.mm.storagebase.h();
      localObject1 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHl();
      localObject1 = (String)localObject1 + "FinderMention001.db";
      localObject2 = this.wUK;
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      if (!((com.tencent.mm.storagebase.h)localObject2).a((String)localObject1, collectMentionDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("finder finder mention db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
      checkIfSameMsgTableName();
      localObject1 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VBb, cr.hUn);
      localObject1 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VBc, cr.hUo);
    }
    if (this.wUM == null)
    {
      localObject1 = new com.tencent.mm.storagebase.h();
      localObject2 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHl();
      if (!((com.tencent.mm.storagebase.h)localObject1).a((String)localObject2 + "FinderMessage006.db", collectMessageDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("message db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
      this.wUM = ((com.tencent.mm.storagebase.h)localObject1);
    }
    if (this.wUL == null)
    {
      this.wUL = new com.tencent.mm.storagebase.h();
      localObject1 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHl();
      localObject1 = (String)localObject1 + "FinderMention002.db";
      localObject2 = this.wUL;
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      if (!((com.tencent.mm.storagebase.h)localObject2).a((String)localObject1, collectMentionDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("finder wx mention db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
    }
    AppMethodBeat.o(165078);
  }
  
  public final boolean canEnterMvAndShowToast()
  {
    AppMethodBeat.i(275746);
    if ((((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).isAnchorLiving()) || (((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).isVisitorLiving()))
    {
      Toast.makeText(MMApplicationContext.getContext(), b.j.finder_can_not_enter_mv_because_living, 0).show();
      AppMethodBeat.o(275746);
      return false;
    }
    AppMethodBeat.o(275746);
    return true;
  }
  
  public final void closeFinderEntryForDebug()
  {
    this.wVO = true;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(162433);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("findermessage006".hashCode()), d.wVT);
    AppMethodBeat.o(162433);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(165092);
    com.tencent.mm.vfs.ab.a("finder", "finder", getFINDER_FOLDER_MAX_SIZE(), getFINDER_FOLDER_LRU_EXPIRE(), 17);
    com.tencent.mm.vfs.ab.aE("finderposting", "finderposting", 2);
    AppMethodBeat.o(165092);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(275654);
    super.dependency();
    dependsOn(com.tencent.mm.plugin.byp.a.c.class);
    dependsOn(com.tencent.mm.plugin.teenmode.a.a.class);
    AppMethodBeat.o(275654);
  }
  
  public final void dumpAndMarkFinderFolder()
  {
    AppMethodBeat.i(165100);
    com.tencent.mm.ae.d.h((kotlin.g.a.a)t.wWj);
    AppMethodBeat.o(165100);
  }
  
  public final void enterAlbumRelatedTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(275701);
    kotlin.g.b.p.k(paramContext, "context");
    Log.i("Finder.PluginFinder", "[enterRelatedTimelineUI] " + paramContext.getClass().getName());
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.enterAlbumRelatedTimelineUI(paramContext, paramIntent);
    AppMethodBeat.o(275701);
  }
  
  public final void enterFinderActivityProfileUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(275700);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramIntent, "intent");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.fI(paramContext);
      AppMethodBeat.o(275700);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.aa(paramContext, paramIntent);
    AppMethodBeat.o(275700);
  }
  
  public final void enterFinderConversationUI(Context paramContext)
  {
    AppMethodBeat.i(275713);
    kotlin.g.b.p.k(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.fM(paramContext);
    AppMethodBeat.o(275713);
  }
  
  public final void enterFinderFollowListUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(275704);
    kotlin.g.b.p.k(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.enterFinderFollowListUI(paramContext, paramIntent);
    AppMethodBeat.o(275704);
  }
  
  public final void enterFinderGallery(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(275749);
    kotlin.g.b.p.k(paramContext, "activity");
    kotlin.g.b.p.k(paramIntent, "intent");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.b(paramContext, paramIntent, paramInt);
    AppMethodBeat.o(275749);
  }
  
  public final void enterFinderPoiFeedUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(275728);
    kotlin.g.b.p.k(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.aq(paramContext, paramIntent);
    AppMethodBeat.o(275728);
  }
  
  public final void enterFinderPostRouterUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(275703);
    kotlin.g.b.p.k(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(paramContext, paramIntent);
    AppMethodBeat.o(275703);
  }
  
  public final void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162439);
    kotlin.g.b.p.k(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, paramIntent);
    AppMethodBeat.o(162439);
  }
  
  public final void enterFinderProfileUI(final Context paramContext, final Intent paramIntent)
  {
    Object localObject2 = null;
    final int i = 25;
    AppMethodBeat.i(162440);
    kotlin.g.b.p.k(paramContext, "context");
    if (paramIntent != null) {}
    for (Object localObject1 = Boolean.valueOf(paramIntent.getBooleanExtra("key_finder_teen_mode_check", false)); (localObject1 != null) && (((Boolean)localObject1).booleanValue()); localObject1 = null)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.ah.AmB;
      ah.a.b(paramContext, paramIntent, (ae.a)new u(this, paramIntent, paramContext));
      AppMethodBeat.o(162440);
      return;
    }
    localObject1 = localObject2;
    if (paramIntent != null) {
      localObject1 = paramIntent.getStringExtra("key_extra_info");
    }
    localObject2 = com.tencent.mm.plugin.finder.live.report.m.yCt;
    if (localObject1 == null) {}
    for (localObject2 = "";; localObject2 = localObject1)
    {
      com.tencent.mm.plugin.finder.live.report.m.aCA((String)localObject2);
      Object localObject3;
      if (paramIntent != null)
      {
        localObject3 = paramIntent.getStringExtra("finder_username");
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      if (Util.isNullOrNil((String)localObject2))
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        c.a.gF((String)localObject1, (String)localObject2);
        if (paramIntent != null)
        {
          localObject2 = paramIntent.getStringExtra("key_finder_object_Id");
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "0";
        }
        final long l = com.tencent.mm.ae.d.Nb((String)localObject1);
        if (paramIntent != null)
        {
          localObject2 = paramIntent.getStringExtra("key_finder_object_nonce_id_key");
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        if (paramIntent != null) {
          i = paramIntent.getIntExtra("share_enter_scene", 25);
        }
        if (l == 0L)
        {
          Log.e("Finder.PluginFinder", "enterFinderProfileUI username & objectId invalid");
          AppMethodBeat.o(162440);
          return;
        }
        com.tencent.mm.ae.d.h((kotlin.g.a.a)new v(this, l, (String)localObject1, i, paramContext, paramIntent));
        AppMethodBeat.o(162440);
        return;
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, paramIntent);
      paramContext = com.tencent.mm.plugin.secinforeport.a.d.Jcm;
      com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999686);
      AppMethodBeat.o(162440);
      return;
    }
  }
  
  public final void enterFinderSelfProfile(Context paramContext, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275666);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramIntent, "intent");
    Object localObject = com.tencent.mm.model.z.bdh();
    if (!Util.isNullOrNil((String)localObject))
    {
      paramIntent.putExtra("finder_username", (String)localObject);
      paramIntent.putExtra("KEY_FINDER_SELF_FLAG", true);
      fillContextIdToIntent(paramInt1, paramInt2, 33, paramIntent);
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramContext, paramIntent);
      AppMethodBeat.o(275666);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("key_create_scene", 6);
      paramIntent.putExtra("key_router_to_profile", false);
      localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.w(paramContext, paramIntent);
    }
    AppMethodBeat.o(275666);
  }
  
  public final void enterFinderSelfUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(275658);
    if (paramContext != null)
    {
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI(paramContext, paramIntent);
      AppMethodBeat.o(275658);
      return;
    }
    AppMethodBeat.o(275658);
  }
  
  public final void enterFinderShareFeedUI(final Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162441);
    kotlin.g.b.p.k(paramContext, "context");
    final Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (localIntent != null) {}
    for (paramIntent = Boolean.valueOf(localIntent.getBooleanExtra("key_finder_teen_mode_check", false)); paramIntent.booleanValue(); paramIntent = null)
    {
      paramIntent = com.tencent.mm.plugin.finder.storage.ah.AmB;
      ah.a.b(paramContext, localIntent, (ae.a)new w(this, localIntent, paramContext));
      AppMethodBeat.o(162441);
      return;
    }
    paramIntent = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGQ("entrance") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.fI(paramContext);
      AppMethodBeat.o(162441);
      return;
    }
    paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.E(paramContext, localIntent);
    paramContext = com.tencent.mm.plugin.secinforeport.a.d.Jcm;
    com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999685);
    AppMethodBeat.o(162441);
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(275694);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramString, "json");
    int i;
    try
    {
      com.tencent.mm.ad.i locali1 = new com.tencent.mm.ad.i(paramString);
      long l = com.tencent.mm.ae.d.Nb(locali1.optString("feedId", "0"));
      com.tencent.mm.ad.i locali2 = locali1.MJ("extInfo");
      Log.i("Finder.PluginFinder", "json = ".concat(String.valueOf(paramString)));
      String str2 = locali2.getString("feedNonceId");
      i = locali2.optInt("reportScene", 11);
      String str3 = locali2.optString("encryptedObjectId", "");
      boolean bool = locali2.optBoolean("getRelatedList", false);
      String str4 = locali2.optString("sessionId", "");
      String str1 = locali2.optString("reportExtraInfo", "");
      int j = locali2.optInt("requestScene", 3);
      paramString = paramIntent;
      if (paramIntent == null) {
        paramString = new Intent();
      }
      paramString.putExtra("report_scene", i);
      paramString.putExtra("from_user", com.tencent.mm.model.z.bcZ());
      paramString.putExtra("feed_object_id", l);
      paramString.putExtra("feed_encrypted_object_id", str3);
      paramString.putExtra("feed_object_nonceId", str2);
      paramString.putExtra("key_need_related_list", bool);
      paramString.putExtra("key_session_id", str4);
      paramString.putExtra("key_comment_scene", 39);
      paramString.putExtra("key_reuqest_scene", j);
      paramIntent = locali1.optString("extraInfo", "");
      kotlin.g.b.p.j(paramIntent, "jsonObject.optString(\"extraInfo\", \"\")");
      if (!Util.isNullOrNil(str1)) {
        kotlin.g.b.p.j(paramString.putExtra("key_extra_info", str1), "intent.putExtra(Constant…A_INFO, extraInfoFromExt)");
      }
      for (;;)
      {
        paramIntent = com.tencent.mm.plugin.findersdk.c.a.Bwg;
        if (com.tencent.mm.plugin.findersdk.c.a.aGQ("entrance") == 0) {
          break;
        }
        paramString = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.fI(paramContext);
        AppMethodBeat.o(275694);
        return;
        if (!TextUtils.isEmpty((CharSequence)paramIntent)) {
          paramString.putExtra("key_extra_info", paramIntent);
        }
      }
      paramIntent = com.tencent.mm.plugin.finder.utils.aj.AGc;
    }
    catch (Throwable paramContext)
    {
      Log.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderProfileUI exception", new Object[0]);
      AppMethodBeat.o(275694);
      return;
    }
    fillContextIdToIntent(com.tencent.mm.plugin.finder.utils.aj.Re(i), 2, 39, paramString);
    paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.E(paramContext, paramString);
    paramContext = com.tencent.mm.plugin.secinforeport.a.d.Jcm;
    com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999685);
    AppMethodBeat.o(275694);
  }
  
  public final void enterFinderTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162438);
    kotlin.g.b.p.k(paramContext, "context");
    enterFinderTimelineUI(paramContext, paramIntent, false);
    AppMethodBeat.o(162438);
  }
  
  public final void enterFinderTimelineUI(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(275659);
    kotlin.g.b.p.k(paramContext, "context");
    Object localObject1 = com.tencent.mm.plugin.finder.report.j.zVy;
    com.tencent.mm.plugin.finder.report.j.dPt();
    Object localObject2;
    int i;
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("key_form_sns", false)) {
        break label353;
      }
      localObject2 = paramIntent.getStringExtra("key_context_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
      if (Util.isNullOrNil(i.a.dQ((String)localObject1, 1))) {
        break label309;
      }
      i = 1;
    }
    for (;;)
    {
      int j;
      label95:
      com.tencent.mm.plugin.finder.preload.tabPreload.g localg;
      label162:
      String str;
      StringBuilder localStringBuilder;
      if (!Util.isNullOrNil(paramIntent.getStringExtra("key_red_dot_id")))
      {
        j = 1;
        if ((i | j) != 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.j.zVy;
          com.tencent.mm.plugin.finder.report.j.dPs();
        }
        if (!paramBoolean) {
          break label326;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (!com.tencent.mm.plugin.finder.storage.d.dXc()) {
          break label326;
        }
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        localObject1 = (com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.preload.tabPreload.c.class);
        localObject2 = ((Iterable)((com.tencent.mm.plugin.finder.preload.tabPreload.c)localObject1).zLf).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label326;
        }
        localg = (com.tencent.mm.plugin.finder.preload.tabPreload.g)((Iterator)localObject2).next();
        i = ((com.tencent.mm.plugin.finder.preload.tabPreload.c)localObject1).dMI().ekb();
        str = localg.TAG;
        localStringBuilder = new StringBuilder("[performEnterFinderLoad] targetTab=").append(i).append(", cache.resp is null = ");
        if (localg.zLy.zLA != null) {
          break label321;
        }
      }
      label309:
      label321:
      for (paramBoolean = true;; paramBoolean = false)
      {
        Log.i(str, paramBoolean);
        if ((localg.fEH != i) || (localg.zLy.zLA != null) || (!localg.zLz.OO(i))) {
          break label162;
        }
        localg.a(g.c.zLL, paramIntent, (kotlin.g.a.b)new g.f(localg));
        break label162;
        i = 0;
        break;
        j = 0;
        break label95;
      }
      label326:
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.v(paramContext, paramIntent);
      paramContext = com.tencent.mm.plugin.secinforeport.a.d.Jcm;
      com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999684);
      AppMethodBeat.o(275659);
      return;
      label353:
      i = 0;
    }
  }
  
  public final void enterFinderTopicTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(275698);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramIntent, "intent");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.fI(paramContext);
      AppMethodBeat.o(275698);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.P(paramContext, paramIntent);
    AppMethodBeat.o(275698);
  }
  
  public final void enterFinderTopicUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(165101);
    kotlin.g.b.p.k(paramContext, "context");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.fI(paramContext);
      AppMethodBeat.o(165101);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.O(paramContext, paramIntent);
    AppMethodBeat.o(165101);
  }
  
  public final void enterFinderTopicUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(275680);
    kotlin.g.b.p.k(paramContext, "context");
    Object localObject2 = new com.tencent.mm.ad.i(paramString).MJ("extInfo");
    Object localObject1 = ((com.tencent.mm.ad.i)localObject2).optString("title");
    int i = ((com.tencent.mm.ad.i)localObject2).optInt("topicType");
    paramString = ((com.tencent.mm.ad.i)localObject2).optString("poiClassifyId");
    double d1 = ((com.tencent.mm.ad.i)localObject2).optDouble("longitude");
    double d2 = ((com.tencent.mm.ad.i)localObject2).optDouble("latitude");
    String str = ((com.tencent.mm.ad.i)localObject2).optString("eventEncryptedTopicId");
    int j = ((com.tencent.mm.ad.i)localObject2).optInt("entryScene");
    if (i == 7)
    {
      com.tencent.mm.plugin.sns.ad.b.c.a(paramContext, str, (String)localObject1, null, j);
      AppMethodBeat.o(275680);
      return;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("key_topic_title", (String)localObject1);
    ((Intent)localObject2).putExtra("key_topic_type", i);
    localObject1 = new bdm();
    ((bdm)localObject1).SOz = paramString;
    ((bdm)localObject1).longitude = ((float)d1);
    ((bdm)localObject1).latitude = ((float)d2);
    try
    {
      ((Intent)localObject2).putExtra("key_topic_poi_location", ((bdm)localObject1).toByteArray());
      enterFinderTopicUI(paramContext, (Intent)localObject2);
      AppMethodBeat.o(275680);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("Finder.PluginFinder", "location toByteArray exception");
      }
    }
  }
  
  public final void enterFinderUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(275669);
    kotlin.g.b.p.k(paramContext, "context");
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (!com.tencent.mm.plugin.finder.storage.d.dRN())
        {
          Log.i("Finder.PluginFinder", "enterFinderUI clicfg_ultron_finder_mp_jsapi switch close");
          AppMethodBeat.o(275669);
          return;
        }
        localObject = new com.tencent.mm.ad.i(paramString).MJ("extInfo");
        str = ((com.tencent.mm.ad.i)localObject).getString("action");
        Log.i("Finder.PluginFinder", "json = ".concat(String.valueOf(paramString)));
        if (str == null)
        {
          Log.i("Finder.PluginFinder", "unKnow action:".concat(String.valueOf(str)));
          AppMethodBeat.o(275669);
          return;
        }
        switch (str.hashCode())
        {
        case -1852273586: 
          if (!str.equals("createFinderLive")) {
            continue;
          }
          paramString = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
          localObject = ((com.tencent.mm.ad.i)localObject).toString();
          kotlin.g.b.p.j(localObject, "extInfo.toString()");
          paramString.createFinderLive(paramContext, (String)localObject);
          AppMethodBeat.o(275669);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        Log.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderUI exception", new Object[0]);
        AppMethodBeat.o(275669);
        return;
      }
      if (str.equals("openFinderProfile"))
      {
        kotlin.g.b.p.j(localObject, "extInfo");
        openFinderProfile$default(this, (com.tencent.mm.ad.i)localObject, paramContext, null, null, 8, null);
        AppMethodBeat.o(275669);
        return;
        if (str.equals("autoOpenFinderLive"))
        {
          paramString = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
          kotlin.g.b.p.j(localObject, "extInfo");
          paramString.autoOpenFinderLive((JSONObject)localObject, paramContext, null, null);
          AppMethodBeat.o(275669);
          return;
          if (str.equals("createLuckyLive"))
          {
            paramString = ((com.tencent.mm.ad.i)localObject).optString("groupId");
            if (paramString == null) {
              paramString = "";
            }
            for (;;)
            {
              ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).createLuckyMoneyLive(paramContext, paramString);
              com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()) });
              AppMethodBeat.o(275669);
              return;
              if (!str.equals("openFinderMultiMoreLive")) {
                break;
              }
              kotlin.g.b.p.j(localObject, "extInfo");
              openFinderLiveOperationUIFromJSAPI$default(this, (com.tencent.mm.ad.i)localObject, paramContext, null, null, 8, null);
              AppMethodBeat.o(275669);
              return;
              if (!str.equals("openFinderFeed")) {
                break;
              }
              kotlin.g.b.p.j(localObject, "extInfo");
              openFinderFeed$default(this, (com.tencent.mm.ad.i)localObject, paramContext, null, null, 8, null);
              AppMethodBeat.o(275669);
              return;
            }
          }
        }
      }
    }
  }
  
  public final void enterFinderUIFromMiniApp(Context paramContext, String paramString, ag.a<Object> parama, ag.a<Integer> parama1)
  {
    AppMethodBeat.i(275683);
    kotlin.g.b.p.k(paramContext, "context");
    try
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (com.tencent.mm.plugin.finder.storage.d.dRN()) {
        break label105;
      }
      Log.i("Finder.PluginFinder", "enterFinderUI clicfg_ultron_finder_mp_jsapi switch close");
      if (parama1 != null)
      {
        parama1.aH(Integer.valueOf(-1001));
        AppMethodBeat.o(275683);
        return;
      }
      AppMethodBeat.o(275683);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderUI exception", new Object[0]);
      if (parama1 == null) {
        break label532;
      }
    }
    parama1.aH(Integer.valueOf(-1002));
    AppMethodBeat.o(275683);
    return;
    label105:
    Object localObject = new com.tencent.mm.ad.i(paramString).MJ("extInfo");
    String str2 = ((com.tencent.mm.ad.i)localObject).getString("action");
    String str1 = ((com.tencent.mm.ad.i)localObject).optString("sourceId", "");
    Log.i("Finder.PluginFinder", "enterFinderUIFromMiniApp json = " + paramString + ", appid:" + str1);
    if (str2 == null) {}
    for (;;)
    {
      Log.i("Finder.PluginFinder", "unKnow action:".concat(String.valueOf(str2)));
      if (parama1 != null)
      {
        parama1.aH(Integer.valueOf(-1000));
        AppMethodBeat.o(275683);
        return;
      }
      switch (str2.hashCode())
      {
      case -1167465866: 
        if (str2.equals("openChannelsRewardedVideoAd"))
        {
          paramString = this.wVQ;
          kotlin.g.b.p.j(localObject, "extInfo");
          paramString.a(paramContext, (JSONObject)localObject, parama, parama1);
          AppMethodBeat.o(275683);
          return;
        }
        break;
      case 50881657: 
        if (str2.equals("openFinderProfile"))
        {
          kotlin.g.b.p.j(localObject, "extInfo");
          kotlin.g.b.p.j(str1, "appid");
          openFinderProfile((com.tencent.mm.ad.i)localObject, paramContext, parama, str1);
          AppMethodBeat.o(275683);
          return;
        }
        break;
      case 819909547: 
        if (str2.equals("autoOpenFinderLive"))
        {
          paramString = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
          kotlin.g.b.p.j(localObject, "extInfo");
          paramString.autoOpenFinderLive((JSONObject)localObject, paramContext, parama, parama1);
          AppMethodBeat.o(275683);
          return;
        }
        break;
      case -412058418: 
        if (str2.equals("openFinderFeed"))
        {
          kotlin.g.b.p.j(localObject, "extInfo");
          kotlin.g.b.p.j(str1, "appid");
          openFinderFeed((com.tencent.mm.ad.i)localObject, paramContext, parama, str1);
          AppMethodBeat.o(275683);
          return;
        }
        break;
      case -411875300: 
        if (str2.equals("openFinderLive"))
        {
          paramContext = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
          kotlin.g.b.p.j(localObject, "extInfo");
          paramString = (JSONObject)localObject;
          kotlin.g.b.p.j(str1, "appid");
          paramContext.openFinderLive(paramString, parama1, parama, str1);
          AppMethodBeat.o(275683);
          return;
          AppMethodBeat.o(275683);
          return;
          label532:
          AppMethodBeat.o(275683);
          return;
        }
        break;
      }
    }
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(162434);
    kotlin.g.b.p.k(paramg, "profile");
    AppMethodBeat.o(162434);
  }
  
  public final String fillContextIdToIntent(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(275718);
    paramIntent = fillContextIdToIntent(genContextId(paramInt1, paramInt2, paramInt3), paramIntent);
    AppMethodBeat.o(275718);
    return paramIntent;
  }
  
  public final String fillContextIdToIntent(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(275720);
    if (paramIntent != null) {
      paramIntent.putExtra("key_context_id", paramString);
    }
    Log.i("Finder.PluginFinder", "fillContextIdToIntent USERINFO_FINDER_CONTEXT_ID_STRING:".concat(String.valueOf(paramString)));
    paramIntent = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(paramIntent, "MMKernel.storage()");
    paramIntent.aHp().set(ar.a.VCk, paramString);
    paramIntent = paramString;
    if (paramString == null) {
      paramIntent = "";
    }
    AppMethodBeat.o(275720);
    return paramIntent;
  }
  
  public final String genContextId(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(275721);
    String str = UUID.randomUUID().toString();
    kotlin.g.b.p.j(str, "UUID.randomUUID().toString()");
    str = kotlin.n.n.l(str, "-", "", false);
    str = paramInt1 + '-' + paramInt2 + '-' + paramInt3 + '-' + str;
    AppMethodBeat.o(275721);
    return str;
  }
  
  public final com.tencent.mm.plugin.finder.storage.e getContactStorage()
  {
    AppMethodBeat.i(165082);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.storage.e locale2 = this.wUP;
    com.tencent.mm.plugin.finder.storage.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new com.tencent.mm.plugin.finder.storage.e((ISQLiteDatabase)getDB());
    }
    this.wUP = locale1;
    locale1 = this.wUP;
    if (locale1 == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(165082);
    return locale1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.f getConversationStorage()
  {
    AppMethodBeat.i(275642);
    com.tencent.mm.plugin.finder.storage.f localf = this.wUS;
    Object localObject = localf;
    if (localf == null)
    {
      localObject = this.wUM;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = new com.tencent.mm.plugin.finder.storage.f((ISQLiteDatabase)localObject);
    }
    this.wUS = ((com.tencent.mm.plugin.finder.storage.f)localObject);
    localObject = this.wUS;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(275642);
    return localObject;
  }
  
  public final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(165080);
    checkResetDb();
    com.tencent.mm.storagebase.h localh = this.kcF;
    if (localh == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(165080);
    return localh;
  }
  
  public final com.tencent.mm.storagebase.h getDataDB()
  {
    return this.kcF;
  }
  
  public final com.tencent.mm.plugin.finder.storage.logic.b getDraftStorage()
  {
    AppMethodBeat.i(275646);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.storage.logic.b localb2 = this.wUX;
    com.tencent.mm.plugin.finder.storage.logic.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = new com.tencent.mm.plugin.finder.storage.logic.b((ISQLiteDatabase)getDB());
    }
    this.wUX = localb1;
    localb1 = this.wUX;
    if (localb1 == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(275646);
    return localb1;
  }
  
  public final long getFINDER_FOLDER_LRU_EXPIRE()
  {
    AppMethodBeat.i(275652);
    long l = MultiProcessMMKV.getDefault().getInt("FINDER_FOLDER_LRU_EXPIRE_DAY", 2) * 86400000L;
    Log.i("Finder.PluginFinder", "FINDER_FOLDER_MAX_SIZE ".concat(String.valueOf(l)));
    AppMethodBeat.o(275652);
    return l;
  }
  
  public final long getFINDER_FOLDER_MAX_SIZE()
  {
    AppMethodBeat.i(275651);
    long l = MultiProcessMMKV.getDefault().getInt("FINDER_FOLDER_MAX_SIZE_MB", 512) * 1048576L;
    Log.i("Finder.PluginFinder", "FINDER_FOLDER_MAX_SIZE ".concat(String.valueOf(l)));
    AppMethodBeat.o(275651);
    return l;
  }
  
  public final com.tencent.mm.plugin.finder.storage.m getFeedStorage()
  {
    AppMethodBeat.i(165083);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.storage.m localm2 = this.wUW;
    com.tencent.mm.plugin.finder.storage.m localm1 = localm2;
    if (localm2 == null) {
      localm1 = new com.tencent.mm.plugin.finder.storage.m((ISQLiteDatabase)getDB());
    }
    this.wUW = localm1;
    localm1 = this.wUW;
    if (localm1 == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(165083);
    return localm1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.a getFinderActionStorage()
  {
    AppMethodBeat.i(165086);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.storage.a locala2 = this.wVc;
    com.tencent.mm.plugin.finder.storage.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.tencent.mm.plugin.finder.storage.a((ISQLiteDatabase)getDB());
    }
    this.wVc = locala1;
    locala1 = this.wVc;
    if (locala1 == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(165086);
    return locala1;
  }
  
  public final com.tencent.mm.plugin.finder.api.b getFinderContactCache()
  {
    return this.wVv;
  }
  
  public final com.tencent.mm.storagebase.h getFinderMentionDB()
  {
    return this.wUK;
  }
  
  public final com.tencent.mm.plugin.findersdk.a.x getFinderOpenSdkApi()
  {
    return (com.tencent.mm.plugin.findersdk.a.x)com.tencent.mm.plugin.finder.utils.u.ADR;
  }
  
  public final com.tencent.mm.plugin.finder.storage.ad getFinderOrAliasDeletingInfoStorage()
  {
    AppMethodBeat.i(275644);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.storage.ad localad = this.wUV;
    Object localObject = localad;
    if (localad == null)
    {
      localObject = this.wUM;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = new com.tencent.mm.plugin.finder.storage.ad((ISQLiteDatabase)localObject);
    }
    this.wUV = ((com.tencent.mm.plugin.finder.storage.ad)localObject);
    localObject = this.wUV;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(275644);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.findersdk.a.ad getFinderSwitchApi()
  {
    return (com.tencent.mm.plugin.findersdk.a.ad)com.tencent.mm.plugin.finder.utils.af.AFF;
  }
  
  public final com.tencent.mm.plugin.finder.api.g getFinderSyncExtension()
  {
    return (com.tencent.mm.plugin.finder.api.g)this.wUO;
  }
  
  public final com.tencent.mm.plugin.findersdk.a.af getFinderUIApi()
  {
    return (com.tencent.mm.plugin.findersdk.a.af)com.tencent.mm.plugin.finder.utils.ai.AFJ;
  }
  
  public final com.tencent.mm.plugin.findersdk.a.ag getFinderUtilApi()
  {
    return (com.tencent.mm.plugin.findersdk.a.ag)this.wVQ;
  }
  
  public final com.tencent.mm.loader.g.i getFollowTlSingleExecutor()
  {
    AppMethodBeat.i(275625);
    com.tencent.mm.loader.g.i locali = (com.tencent.mm.loader.g.i)this.wVx.getValue();
    AppMethodBeat.o(275625);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.storage.s getLocalLikeFeedStorage()
  {
    AppMethodBeat.i(275649);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.storage.s locals2 = this.wVd;
    com.tencent.mm.plugin.finder.storage.s locals1 = locals2;
    if (locals2 == null) {
      locals1 = new com.tencent.mm.plugin.finder.storage.s((ISQLiteDatabase)getDB());
    }
    this.wVd = locals1;
    locals1 = this.wVd;
    if (locals1 == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(275649);
    return locals1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.t getMediaCacheStorage()
  {
    AppMethodBeat.i(165084);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.storage.t localt2 = this.wUY;
    com.tencent.mm.plugin.finder.storage.t localt1 = localt2;
    if (localt2 == null) {
      localt1 = new com.tencent.mm.plugin.finder.storage.t((ISQLiteDatabase)getDB());
    }
    this.wUY = localt1;
    localt1 = this.wUY;
    if (localt1 == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(165084);
    return localt1;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.a getMediaPreloadModel()
  {
    AppMethodBeat.i(275626);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.wVA.getValue();
    AppMethodBeat.o(275626);
    return locala;
  }
  
  public final MAutoStorage<cr> getMentionStorage(int paramInt)
  {
    AppMethodBeat.i(275648);
    com.tencent.mm.kernel.h.aHE().aGH();
    checkResetDb();
    if (paramInt == 1)
    {
      localObject2 = this.wVa;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.wUL;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        localObject1 = new com.tencent.mm.plugin.finder.storage.ai((ISQLiteDatabase)localObject1);
      }
      this.wVa = ((com.tencent.mm.plugin.finder.storage.ai)localObject1);
      localObject1 = this.wVa;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = (MAutoStorage)localObject1;
      AppMethodBeat.o(275648);
      return localObject1;
    }
    Object localObject2 = this.wVb;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.wUK;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = new com.tencent.mm.plugin.finder.storage.n((ISQLiteDatabase)localObject1);
    }
    this.wVb = ((com.tencent.mm.plugin.finder.storage.n)localObject1);
    localObject1 = this.wVb;
    if (localObject1 == null) {
      kotlin.g.b.p.iCn();
    }
    localObject1 = (MAutoStorage)localObject1;
    AppMethodBeat.o(275648);
    return localObject1;
  }
  
  public final com.tencent.mm.storagebase.h getMessageDB()
  {
    return this.wUM;
  }
  
  public final com.tencent.mm.plugin.finder.storage.v getMessageStorage()
  {
    AppMethodBeat.i(275645);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    kotlin.g.b.p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).eSe();
    com.tencent.mm.plugin.finder.storage.v localv = this.wUU;
    localObject = localv;
    if (localv == null)
    {
      kotlin.g.b.p.j(locali, "msgStg");
      localObject = new com.tencent.mm.plugin.finder.storage.v(locali);
    }
    this.wUU = ((com.tencent.mm.plugin.finder.storage.v)localObject);
    localObject = this.wUU;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(275645);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.storage.y getMsgAliasContactStorage()
  {
    AppMethodBeat.i(275641);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.storage.y localy2 = this.wUR;
    com.tencent.mm.plugin.finder.storage.y localy1 = localy2;
    if (localy2 == null) {
      localy1 = new com.tencent.mm.plugin.finder.storage.y((ISQLiteDatabase)getDB());
    }
    this.wUR = localy1;
    localy1 = this.wUR;
    if (localy1 == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(275641);
    return localy1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.z getMsgStrangerContactStorage()
  {
    AppMethodBeat.i(275640);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.storage.z localz2 = this.wUQ;
    com.tencent.mm.plugin.finder.storage.z localz1 = localz2;
    if (localz2 == null) {
      localz1 = new com.tencent.mm.plugin.finder.storage.z((ISQLiteDatabase)getDB());
    }
    this.wUQ = localz1;
    localz1 = this.wUQ;
    if (localz1 == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(275640);
    return localz1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.c getRedDotCtrInfoStorage()
  {
    AppMethodBeat.i(178074);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.extension.reddot.c localc2 = this.wUZ;
    com.tencent.mm.plugin.finder.extension.reddot.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.finder.extension.reddot.c((ISQLiteDatabase)getDB());
    }
    this.wUZ = localc1;
    localc1 = this.wUZ;
    if (localc1 == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(178074);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.f getRedDotManager()
  {
    AppMethodBeat.i(178072);
    com.tencent.mm.plugin.finder.extension.reddot.f localf2 = this.wVw;
    com.tencent.mm.plugin.finder.extension.reddot.f localf1 = localf2;
    if (localf2 == null) {
      localf1 = new com.tencent.mm.plugin.finder.extension.reddot.f(getRedDotCtrInfoStorage());
    }
    this.wVw = localf1;
    localf1 = this.wVw;
    if (localf1 == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(178072);
    return localf1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.af getSessionInfoStorage()
  {
    AppMethodBeat.i(275643);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.finder.storage.af localaf = this.wUT;
    Object localObject = localaf;
    if (localaf == null)
    {
      localObject = this.wUM;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = new com.tencent.mm.plugin.finder.storage.af((ISQLiteDatabase)localObject);
    }
    this.wUT = ((com.tencent.mm.plugin.finder.storage.af)localObject);
    localObject = this.wUT;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    AppMethodBeat.o(275643);
    return localObject;
  }
  
  public final int getTimelineCommentScene()
  {
    AppMethodBeat.i(275714);
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    int i = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).ekb();
    localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    i = com.tencent.mm.plugin.finder.utils.aj.QP(i);
    if (-1 == i)
    {
      AppMethodBeat.o(275714);
      return 1;
    }
    AppMethodBeat.o(275714);
    return i;
  }
  
  public final androidx.lifecycle.aa getViewModelStore()
  {
    return this.VK;
  }
  
  public final com.tencent.mm.storagebase.h getWxMentionDB()
  {
    return this.wUL;
  }
  
  public final boolean hasFinderPosted()
  {
    AppMethodBeat.i(275715);
    String str = com.tencent.mm.model.z.bdh();
    if (Util.isNullOrNil(com.tencent.mm.model.z.bdh()))
    {
      AppMethodBeat.o(275715);
      return false;
    }
    k.a locala = com.tencent.mm.plugin.finder.storage.data.k.Anu;
    kotlin.g.b.p.j(str, "username");
    if (!((Collection)locala.ed(str, 1)).isEmpty())
    {
      AppMethodBeat.o(275715);
      return true;
    }
    AppMethodBeat.o(275715);
    return false;
  }
  
  public final boolean isAllEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(275735);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.isAllEnableFullScreenEnjoy();
    AppMethodBeat.o(275735);
    return bool;
  }
  
  public final boolean isAllHomeTabEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(275731);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.isAllHomeTabEnableFullScreenEnjoy();
    AppMethodBeat.o(275731);
    return bool;
  }
  
  public final boolean isAllowEditFillingFullScreen()
  {
    AppMethodBeat.i(275744);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    com.tencent.mm.plugin.finder.utils.aj.eep();
    if (com.tencent.mm.plugin.finder.utils.aj.AGb == 1)
    {
      AppMethodBeat.o(275744);
      return true;
    }
    AppMethodBeat.o(275744);
    return false;
  }
  
  public final boolean isAnyEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(275732);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.isAnyEnableFullScreenEnjoy();
    AppMethodBeat.o(275732);
    return bool;
  }
  
  public final boolean isAnyHomeTabEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(275729);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.isAnyHomeTabEnableFullScreenEnjoy();
    AppMethodBeat.o(275729);
    return bool;
  }
  
  public final boolean isDisablePostHalfScreen()
  {
    AppMethodBeat.i(275742);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.isDisablePostHalfScreen();
    AppMethodBeat.o(275742);
    return bool;
  }
  
  public final boolean isFriend(String paramString)
  {
    AppMethodBeat.i(165116);
    if (paramString != null)
    {
      Boolean localBoolean = (Boolean)this.wVP.get(paramString);
      Object localObject = localBoolean;
      if (localBoolean == null)
      {
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject = Boolean.valueOf(com.tencent.mm.plugin.finder.utils.aj.isFriend(paramString));
        ((Map)this.wVP).put(paramString, localObject);
      }
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(165116);
      return bool;
    }
    AppMethodBeat.o(165116);
    return false;
  }
  
  public final boolean isGlobalEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(275737);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    com.tencent.mm.plugin.finder.utils.aj.eep();
    if (com.tencent.mm.plugin.finder.utils.aj.AFU == 1)
    {
      AppMethodBeat.o(275737);
      return true;
    }
    AppMethodBeat.o(275737);
    return false;
  }
  
  public final boolean isInFinder()
  {
    AppMethodBeat.i(165097);
    if (this.wVL.size() > 0)
    {
      AppMethodBeat.o(165097);
      return true;
    }
    AppMethodBeat.o(165097);
    return false;
  }
  
  public final boolean isOtherEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(275740);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    boolean bool = com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy();
    AppMethodBeat.o(275740);
    return bool;
  }
  
  public final boolean isPagEnable()
  {
    AppMethodBeat.i(275722);
    com.tencent.mm.plugin.expansions.d locald = com.tencent.mm.plugin.expansions.d.vtq;
    boolean bool = com.tencent.mm.plugin.expansions.d.awa("xlab");
    AppMethodBeat.o(275722);
    return bool;
  }
  
  public final void loadAvatar(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(275663);
    kotlin.g.b.p.k(paramString, "url");
    kotlin.g.b.p.k(paramImageView, "avatarIv");
    Object localObject = new csg();
    ((csg)localObject).mediaId = MD5Util.getMD5String(paramString);
    ((csg)localObject).url = paramString;
    ((csg)localObject).thumbUrl = paramString;
    paramString = new com.tencent.mm.plugin.finder.loader.r((csg)localObject, com.tencent.mm.plugin.finder.storage.u.Alz, null, null, 12);
    localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
    localObject = com.tencent.mm.plugin.finder.loader.t.dJh();
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    ((com.tencent.mm.loader.d)localObject).a(paramString, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX)).c(paramImageView);
    AppMethodBeat.o(275663);
  }
  
  public final void loadImage(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(178075);
    kotlin.g.b.p.k(paramString, "url");
    Object localObject = new csg();
    ((csg)localObject).mediaId = MD5Util.getMD5String(paramString);
    ((csg)localObject).url = paramString;
    ((csg)localObject).thumbUrl = paramString;
    paramString = new com.tencent.mm.plugin.finder.loader.r((csg)localObject, com.tencent.mm.plugin.finder.storage.u.Alz, null, null, 12);
    if (paramImageView == null)
    {
      paramImageView = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramImageView = com.tencent.mm.plugin.finder.loader.t.dJe();
      localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramImageView.a(paramString, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU)).aRr();
      AppMethodBeat.o(178075);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
    localObject = com.tencent.mm.plugin.finder.loader.t.dJe();
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    ((com.tencent.mm.loader.d)localObject).a(paramString, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU)).c(paramImageView);
    AppMethodBeat.o(178075);
  }
  
  public final void loadImage(String paramString1, String paramString2, String paramString3, ImageView paramImageView, kotlin.g.a.b<? super Bitmap, kotlin.x> paramb)
  {
    AppMethodBeat.i(275661);
    kotlin.g.b.p.k(paramString1, "url");
    kotlin.g.b.p.k(paramString2, "urlToken");
    kotlin.g.b.p.k(paramString3, "decodeKey");
    kotlin.g.b.p.k(paramImageView, "imageView");
    kotlin.g.b.p.k(paramb, "call");
    paramImageView = new csg();
    paramImageView.mediaId = MD5Util.getMD5String(paramString1);
    paramImageView.url = paramString1;
    paramImageView.url_token = paramString2;
    paramImageView.decodeKey = paramString3;
    paramString1 = new com.tencent.mm.plugin.finder.loader.r(paramImageView, com.tencent.mm.plugin.finder.storage.u.Aly, null, null, 12);
    paramString2 = com.tencent.mm.plugin.finder.loader.t.ztT;
    paramString2 = com.tencent.mm.plugin.finder.loader.t.dJe();
    paramString3 = com.tencent.mm.plugin.finder.loader.t.ztT;
    paramString2.a(paramString1, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU)).a((com.tencent.mm.loader.f.e)new ad(paramb)).aRr();
    AppMethodBeat.o(275661);
  }
  
  public final void loadImageForSns(String paramString, View paramView)
  {
    AppMethodBeat.i(275634);
    kotlin.g.b.p.k(paramView, "qImageView");
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    com.tencent.mm.plugin.finder.loader.t.dJe().bQ(new com.tencent.mm.plugin.finder.loader.x(paramString, com.tencent.mm.plugin.finder.storage.u.Aly)).a((com.tencent.mm.loader.f.e)new PluginFinder.ae(paramView)).tA();
    AppMethodBeat.o(275634);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    Object localObject1 = null;
    AppMethodBeat.i(162435);
    new c();
    com.tencent.mm.ui.component.h.h(com.tencent.mm.plugin.finder.viewmodel.component.aj.class, com.tencent.mm.plugin.findersdk.a.aa.class);
    com.tencent.mm.ui.component.h.h(com.tencent.mm.plugin.finder.viewmodel.a.class, com.tencent.mm.plugin.finder.api.f.class);
    com.tencent.mm.ui.component.h.h(com.tencent.mm.plugin.finder.loader.u.class, com.tencent.mm.plugin.finder.loader.ab.class);
    com.tencent.mm.ui.component.h.h(as.class, com.tencent.mm.plugin.finder.viewmodel.component.au.class);
    com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 40L, 1L);
    this.wUJ = true;
    checkResetDb();
    paramc = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(paramc, "MMKernel.storage()");
    paramc = paramc.aHp().get(ar.a.Vzo, this.wVz);
    Log.i("Finder.PluginFinder", "[onAccountInitialized] Log appendIsSync=" + XLogSetup.appendIsSync + ' ' + this.wUJ + ' ' + this.wVy + ' ' + paramc);
    Object localObject2 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject2, "MMKernel.storage()");
    if ((kotlin.g.b.p.h(((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.Vzo, this.wVy), this.wVy) ^ true))
    {
      Log.i("Finder.PluginFinder", "resetConfig oldVer:" + paramc + " CURRENT_DB_VERSION:" + this.wVy);
      resetConfig();
    }
    paramc = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(paramc, "MMKernel.storage()");
    paramc.aHp().set(ar.a.Vzo, this.wVy);
    paramc = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(paramc, "MMKernel.storage()");
    int i = paramc.aHp().getInt(ar.a.VAI, -1);
    if (i == -1)
    {
      paramc = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(paramc, "MMKernel.storage()");
      int j = paramc.aHp().getInt(ar.a.VAG, 0);
      paramc = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(paramc, "MMKernel.storage()");
      paramc.aHp().set(ar.a.VAI, Integer.valueOf(j));
      Log.i("Finder.PluginFinder", "[onAccountInitialized] user auto increment id=" + i + " userVersion=" + j);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.b.class, (com.tencent.mm.kernel.c.a)this.wVG);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.c.class, (com.tencent.mm.kernel.c.a)this.wVG);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.d.class, (com.tencent.mm.kernel.c.a)this.wVH);
      paramc = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      kotlin.g.b.p.j(paramc, "MMKernel.service(IMessengerStorage::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.n)paramc).eSe().a((com.tencent.mm.storage.e)getMessageStorage());
      com.tencent.mm.kernel.h.b(ae.class, (com.tencent.mm.kernel.c.a)getFinderTeenModeConfig());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.o.class, (com.tencent.mm.kernel.c.a)this.wVu);
      ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.nCC);
      paramc = ap.xcn;
      ap.dnQ();
      doSomethingImportantOnStart();
      paramc = com.tencent.mm.plugin.finder.shell.b.AdK;
      com.tencent.mm.plugin.finder.shell.b.setup();
      paramc = this.wUN;
      paramc.kPU.a((com.tencent.mm.loader.g.f)paramc.AAf);
      paramc.AAa.a((com.tencent.mm.loader.g.f)paramc.AAg);
      paramc = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(paramc, "MMKernel.storage()");
      paramc.aHp().set(ar.a.Vyg, "");
      com.tencent.mm.kernel.h.aGY().a(3565, (com.tencent.mm.an.i)this.wUO);
      com.tencent.mm.kernel.h.aGY().a(3512, (com.tencent.mm.an.i)this);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVe);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVf);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVg);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVh);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVi);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVj);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVk);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVl);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVm);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVn);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVr);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVs);
      com.tencent.mm.kernel.h.aGY().a(3870, (com.tencent.mm.an.i)this.wVt);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.m.class, (com.tencent.mm.kernel.c.a)this.wVe);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.w.class, (com.tencent.mm.kernel.c.a)this.wVf);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.u.class, (com.tencent.mm.kernel.c.a)this.wVg);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.l.class, (com.tencent.mm.kernel.c.a)this.wVh);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.s.class, (com.tencent.mm.kernel.c.a)this.wVi);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.v.class, (com.tencent.mm.kernel.c.a)this.wVj);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.t.class, (com.tencent.mm.kernel.c.a)this.wVk);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.ah.class, (com.tencent.mm.kernel.c.a)this.wVl);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.l.class, (com.tencent.mm.kernel.c.a)this.wVm);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.k.class, (com.tencent.mm.kernel.c.a)this.wVn);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.j.class, (com.tencent.mm.kernel.c.a)this.wVr);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.i.class, (com.tencent.mm.kernel.c.a)this.wVs);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.h.class, (com.tencent.mm.kernel.c.a)this.wVt);
      paramc = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class);
      kotlin.g.b.p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.v)paramc).getSysCmdMsgExtension().a("FinderPersonalMsgSysMsg", (com.tencent.mm.plugin.messenger.foundation.a.s)this.wVo);
      paramc = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class);
      kotlin.g.b.p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.v)paramc).getSysCmdMsgExtension().a("finderuserreinit", (com.tencent.mm.plugin.messenger.foundation.a.s)this.wVp);
      paramc = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class);
      kotlin.g.b.p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
      ((com.tencent.mm.plugin.messenger.foundation.a.v)paramc).getSysCmdMsgExtension().a("FinderPromotion", (com.tencent.mm.plugin.messenger.foundation.a.s)this.wVq);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.r.class)).a((com.tencent.mm.plugin.messenger.foundation.a.z)new ag());
      boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderActionStorage().db.execSQL("FinderAction", "DELETE FROM FinderAction WHERE actionType = 1");
      Log.i(com.tencent.mm.plugin.finder.storage.a.TAG, "cleanCanRemoveFeed ret" + bool + ' ' + "DELETE FROM FinderAction WHERE actionType = 1");
      if (showFinderEntry()) {
        com.tencent.e.h.ZvG.be((Runnable)ah.wWA);
      }
      paramc = com.tencent.mm.plugin.finder.api.d.wZQ;
      paramc = com.tencent.mm.plugin.finder.api.d.a.dni();
      paramc.xaa = true;
      com.tencent.mm.plugin.finder.api.d.a.e(paramc);
      this.wVC.alive();
      paramc = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      com.tencent.mm.plugin.finder.upload.action.l.ecG();
      paramc = com.tencent.mm.plugin.finder.upload.g.AAk;
      paramc = com.tencent.mm.plugin.finder.upload.g.ecj();
      localObject2 = com.tencent.mm.plugin.finder.report.k.zWs;
      paramc.a(com.tencent.mm.plugin.finder.report.k.dPA());
      AppForegroundDelegate.fby.a((com.tencent.mm.app.o)this.wVN);
      paramc = com.tencent.mm.plugin.finder.model.au.zBf;
      com.tencent.mm.plugin.finder.model.au.qm();
      paramc = com.tencent.mm.plugin.finder.storage.data.u.AnE;
      paramc = (com.tencent.mm.cd.a)new bhu();
      localObject2 = com.tencent.mm.vfs.u.aY(com.tencent.mm.plugin.finder.storage.data.u.dZC(), 0, -1);
      try
      {
        paramc.parseFrom((byte[])localObject2);
        localObject2 = (bhu)paramc;
        localObject3 = new StringBuilder("[setup] isExist=").append(com.tencent.mm.vfs.u.agG(com.tencent.mm.plugin.finder.storage.data.u.dZC())).append(" touchFile=").append(com.tencent.mm.plugin.finder.storage.data.u.dZC()).append(" info: ");
        if (localObject2 != null)
        {
          paramc = Integer.valueOf(((bhu)localObject2).SSh);
          localObject3 = ((StringBuilder)localObject3).append(paramc).append(' ');
          if (localObject2 == null) {
            break label2305;
          }
          paramc = Long.valueOf(((bhu)localObject2).SSg);
          Log.i("Finder.PageRecovery", paramc);
          if (localObject2 != null)
          {
            if (((bhu)localObject2).SSh < 2) {
              break label2310;
            }
            i = 1;
            paramc = (f.c)localObject1;
            if (i != 0) {
              paramc = (f.c)localObject2;
            }
            if (paramc != null)
            {
              localObject1 = com.tencent.mm.plugin.finder.storage.data.k.Anu;
              k.a.clearAll();
              localObject1 = com.tencent.mm.plugin.finder.storage.data.u.AnE;
              com.tencent.mm.vfs.u.deleteFile(com.tencent.mm.plugin.finder.storage.data.u.dZC());
              paramc.SSh = 0;
              paramc.SSg = 0L;
            }
          }
          MMUncaughtExceptionHandler.addOnUncaughtExceptionListener((MMUncaughtExceptionHandler.IOnUncaughtExceptionListener)new u.a((bhu)localObject2));
          com.tencent.mm.ae.d.h((kotlin.g.a.a)ai.wWB);
          paramc = com.tencent.mm.ui.component.g.Xox;
          paramc = (com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.preload.tabPreload.c.class);
          paramc.zLh.alive();
          localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
          localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
          com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqO(), (androidx.lifecycle.s)paramc);
          AppForegroundDelegate.fby.a((com.tencent.mm.app.o)paramc);
          com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.ab.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.service.f());
          com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.m.class, (com.tencent.mm.kernel.c.a)getFinderContactService());
          com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.n.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.service.b());
          com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.y.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.service.e());
          com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.p.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.finder.report.f.zUP);
          ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.byp.a.c.class)).addBypSyncHandler(1, (com.tencent.mm.plugin.byp.a.b)new com.tencent.mm.plugin.finder.message.a());
          ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.byp.a.c.class)).addBypSyncHandler(5, (com.tencent.mm.plugin.byp.a.b)new com.tencent.mm.plugin.finder.message.a());
          paramc = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          kotlin.g.b.p.j(paramc, "MMKernel.service(IMessengerStorage::class.java)");
          ((com.tencent.mm.plugin.messenger.foundation.a.n)paramc).bbR().a((com.tencent.mm.plugin.messenger.foundation.a.i)getConversationUpdater());
          paramc = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          kotlin.g.b.p.j(paramc, "MMKernel.service(IMessengerStorage::class.java)");
          ((com.tencent.mm.plugin.messenger.foundation.a.n)paramc).bbL().a(getFinderContactService().AcW);
          com.tencent.mm.ae.d.h((kotlin.g.a.a)new j.b(getConversationUpdater()));
          paramc = a.b.hjf();
          if ((paramc instanceof com.tencent.mm.pluginsdk.ui.b))
          {
            localObject1 = new com.tencent.mm.plugin.finder.loader.g(((com.tencent.mm.pluginsdk.ui.b)paramc).hjg());
            ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@findermsg", (j.a)localObject1);
            ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@finder", (j.a)localObject1);
            ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@findermsgstranger", (j.a)localObject1);
            ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@findermsgalias", (j.a)localObject1);
          }
          af.a.a((af.b)getGetContactInterceptor());
          paramc = com.tencent.mm.plugin.vlog.model.n.NlN;
          com.tencent.mm.plugin.vlog.model.n.setup();
          paramc = com.tencent.mm.plugin.finder.megavideo.floatball.b.zwu;
          paramc = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class);
          if (paramc != null)
          {
            com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new b.a.a(paramc));
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(22, com.tencent.mm.plugin.finder.megavideo.floatball.b.dJI());
          }
          paramc = com.tencent.mm.plugin.finder.feed.d.xwm;
          paramc = com.tencent.mm.kernel.h.aHG();
          kotlin.g.b.p.j(paramc, "MMKernel.storage()");
          if (!paramc.aHp().getBoolean(ar.a.VBJ, false))
          {
            paramc = com.tencent.mm.plugin.finder.storage.d.AjH;
            i = ((Number)com.tencent.mm.plugin.finder.storage.d.dVV().aSr()).intValue();
            Log.i("Finder.FinderBulletSubtitlePresenter", "initSwitch: exptValue = ".concat(String.valueOf(i)));
            if (i != 0)
            {
              paramc = com.tencent.mm.kernel.h.aHG();
              kotlin.g.b.p.j(paramc, "MMKernel.storage()");
              paramc.aHp().set(ar.a.VBJ, Boolean.TRUE);
              paramc = com.tencent.mm.kernel.h.aHG();
              kotlin.g.b.p.j(paramc, "MMKernel.storage()");
              paramc = paramc.aHp();
              localObject1 = ar.a.VBI;
              if (i == 1) {
                break label2315;
              }
              bool = true;
              paramc.set((ar.a)localObject1, Boolean.valueOf(bool));
            }
          }
          paramc = com.tencent.mm.plugin.finder.megavideo.multitask.a.zwX;
          ((com.tencent.mm.plugin.taskbar.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.taskbar.api.b.class)).a(22, (com.tencent.mm.plugin.taskbar.api.b.a)com.tencent.mm.plugin.finder.megavideo.multitask.a.dJQ());
          ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(22, com.tencent.mm.plugin.finder.megavideo.uic.d.class);
          ((com.tencent.mm.plugin.textstatus.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).a("5", (com.tencent.mm.plugin.textstatus.a.m)new com.tencent.mm.plugin.finder.provider.a());
          paramc = com.tencent.mm.plugin.finder.utils.aj.AGc;
          com.tencent.mm.plugin.finder.utils.aj.eez();
          refreshXLabConfigToMMKV();
          paramc = com.tencent.mm.plugin.finder.upload.action.f.ABS;
          Log.i("Finder.FeedCleaner", "onAccountInit");
          paramc = com.tencent.mm.model.z.bdh();
          kotlin.g.b.p.j(paramc, "ConfigStorageLogic.getMyFinderUsername()");
          com.tencent.mm.plugin.finder.upload.action.f.whH = paramc;
          if (com.tencent.mm.plugin.finder.upload.action.f.ABR.containsKey(com.tencent.mm.plugin.finder.upload.action.f.whH))
          {
            paramc = com.tencent.mm.plugin.finder.upload.action.f.ABR.get(com.tencent.mm.plugin.finder.upload.action.f.whH);
            if (paramc == null) {
              kotlin.g.b.p.iCn();
            }
            com.tencent.mm.plugin.finder.upload.action.f.ABQ = (com.tencent.mm.plugin.finder.upload.action.f.a)paramc;
          }
          paramc = com.tencent.mm.plugin.finder.upload.action.f.ABQ;
          if (paramc == null) {
            break label2321;
          }
          com.tencent.mm.plugin.finder.upload.action.f.ABN = paramc.ABN;
          com.tencent.mm.plugin.finder.upload.action.f.ABO = paramc.ABO;
          com.tencent.mm.plugin.finder.upload.action.f.ABP = paramc.ABT;
          this.wVI.alive();
          paramc = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.dYc().aSr()).intValue() == 1)
          {
            paramc = com.tencent.mm.plugin.findersdk.f.b.Bxg;
            com.tencent.mm.plugin.findersdk.f.b.enX();
          }
          AppMethodBeat.o(162435);
          return;
          Log.i("Finder.PluginFinder", "[onAccountInitialized] user auto increment id=".concat(String.valueOf(i)));
        }
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramc });
          paramc = null;
          continue;
          paramc = null;
          continue;
          label2305:
          paramc = null;
          continue;
          label2310:
          i = 0;
          continue;
          label2315:
          bool = false;
          continue;
          label2321:
          com.tencent.mm.plugin.finder.upload.action.f.ABN = new com.tencent.mm.plugin.finder.upload.action.g();
          com.tencent.mm.plugin.finder.upload.action.f.ABO = new com.tencent.mm.plugin.finder.upload.action.g();
          com.tencent.mm.plugin.finder.upload.action.f.ABP = new com.tencent.mm.plugin.finder.upload.action.g();
          paramc = com.tencent.mm.plugin.finder.upload.action.f.whH;
          localObject1 = com.tencent.mm.plugin.finder.upload.action.f.ABN;
          if (localObject1 == null) {
            kotlin.g.b.p.bGy("followRecorder");
          }
          localObject2 = com.tencent.mm.plugin.finder.upload.action.f.ABO;
          if (localObject2 == null) {
            kotlin.g.b.p.bGy("noSeeAuthorRecorder");
          }
          Object localObject3 = com.tencent.mm.plugin.finder.upload.action.f.ABP;
          if (localObject3 == null) {
            kotlin.g.b.p.bGy("noSeeFriend");
          }
          paramc = new com.tencent.mm.plugin.finder.upload.action.f.a(paramc, (com.tencent.mm.plugin.finder.upload.action.g)localObject1, (com.tencent.mm.plugin.finder.upload.action.g)localObject2, (com.tencent.mm.plugin.finder.upload.action.g)localObject3);
          ((Map)com.tencent.mm.plugin.finder.upload.action.f.ABR).put(com.tencent.mm.plugin.finder.upload.action.f.whH, paramc);
          com.tencent.mm.plugin.finder.upload.action.f.ABQ = paramc;
        }
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(162436);
    Log.i("Finder.PluginFinder", "onAccountRelease");
    Object localObject = com.tencent.mm.plugin.finder.model.au.zBf;
    com.tencent.mm.kernel.h.aGY().b(3520, (com.tencent.mm.an.i)localObject);
    localObject = this.wUN;
    ((com.tencent.mm.plugin.finder.upload.g)localObject).kPU.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.finder.upload.g)localObject).AAf);
    ((com.tencent.mm.plugin.finder.upload.g)localObject).AAa.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.finder.upload.g)localObject).AAg);
    localObject = com.tencent.mm.plugin.finder.upload.g.AAk;
    localObject = com.tencent.mm.plugin.finder.upload.g.ecj();
    com.tencent.mm.plugin.finder.report.k localk = com.tencent.mm.plugin.finder.report.k.zWs;
    ((com.tencent.mm.plugin.finder.upload.g)localObject).b(com.tencent.mm.plugin.finder.report.k.dPA());
    com.tencent.mm.kernel.h.aGY().b(3565, (com.tencent.mm.an.i)this.wUO);
    com.tencent.mm.kernel.h.aGY().b(3512, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVe);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVf);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVg);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVh);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVi);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVj);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVk);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVl);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVm);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVn);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVr);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVs);
    com.tencent.mm.kernel.h.aGY().b(3870, (com.tencent.mm.an.i)this.wVt);
    com.tencent.mm.kernel.h.aGY().b(665, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.b.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.c.class);
    com.tencent.mm.kernel.h.af(this.wVH.getClass());
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.finder.service.m.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.o.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.finder.service.l.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.finder.service.k.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.w.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.s.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.u.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.l.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.v.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.t.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.ah.class);
    this.wVC.dead();
    AppForegroundDelegate.fby.b((com.tencent.mm.app.o)this.wVN);
    localObject = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.v)localObject).getSysCmdMsgExtension().b("FinderPersonalMsgSysMsg", (com.tencent.mm.plugin.messenger.foundation.a.s)this.wVo);
    localObject = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.v)localObject).getSysCmdMsgExtension().b("finderuserreinit", (com.tencent.mm.plugin.messenger.foundation.a.s)this.wVp);
    localObject = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.v)localObject).getSysCmdMsgExtension().b("FinderPromotion", (com.tencent.mm.plugin.messenger.foundation.a.s)this.wVq);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(1);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(5);
    localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    kotlin.g.b.p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbR().b((com.tencent.mm.plugin.messenger.foundation.a.i)getConversationUpdater());
    localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    kotlin.g.b.p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL().b(getFinderContactService().AcW);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.m.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.ab.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.n.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.finder.service.i.class);
    com.tencent.mm.kernel.h.af(ae.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.finder.service.h.class);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.findersdk.a.p.class);
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).b(this.nCC);
    af.a.b((af.b)getGetContactInterceptor());
    localObject = a.b.hjf();
    if ((localObject instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      ((com.tencent.mm.pluginsdk.ui.b)localObject).bqM("@findermsg");
      ((com.tencent.mm.pluginsdk.ui.b)localObject).bqM("@finder");
    }
    ((com.tencent.mm.plugin.textstatus.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).beb("5");
    if (this.kcF != null)
    {
      localObject = this.kcF;
      if (localObject != null) {
        ((com.tencent.mm.storagebase.h)localObject).closeDB();
      }
      this.kcF = null;
    }
    localObject = com.tencent.mm.plugin.finder.feed.model.g.xGi;
    com.tencent.mm.plugin.finder.feed.model.g.clear();
    this.VK.clear();
    this.wVJ.dead();
    localObject = com.tencent.mm.plugin.vlog.model.n.NlN;
    com.tencent.mm.plugin.vlog.model.n.destroy();
    localObject = com.tencent.mm.plugin.finder.megavideo.floatball.b.zwu;
    if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(22, com.tencent.mm.plugin.finder.megavideo.floatball.b.dJI());
    }
    localObject = com.tencent.mm.plugin.finder.megavideo.multitask.a.zwX;
    ((com.tencent.mm.plugin.taskbar.api.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.taskbar.api.b.class)).b(22, (com.tencent.mm.plugin.taskbar.api.b.a)com.tencent.mm.plugin.finder.megavideo.multitask.a.dJQ());
    localObject = com.tencent.mm.plugin.finder.upload.action.f.ABS;
    com.tencent.mm.plugin.finder.upload.action.f.onAccountRelease();
    this.wVI.dead();
    AppMethodBeat.o(162436);
  }
  
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString) {}
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onEnterFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165095);
    kotlin.g.b.p.k(paramMMFinderUI, "finder");
    Object localObject = com.tencent.mm.plugin.finder.storage.data.u.AnE;
    com.tencent.mm.plugin.finder.storage.data.u.dZD();
    int i = Process.myPid();
    localObject = com.tencent.mm.plugin.finder.upload.g.AAk;
    if (com.tencent.mm.plugin.finder.upload.g.eck() != i)
    {
      localObject = com.tencent.mm.plugin.finder.upload.g.AAk;
      com.tencent.mm.plugin.finder.upload.g.ecj().eci();
      localObject = com.tencent.mm.plugin.finder.upload.g.AAk;
      com.tencent.mm.plugin.finder.upload.g.QB(i);
    }
    localObject = com.tencent.mm.plugin.finder.utils.l.ADu;
    com.tencent.mm.plugin.finder.utils.l.ecT();
    if (!paramMMFinderUI.getIntent().getBooleanExtra("key_not_request_focus", false))
    {
      if (!isInFinder())
      {
        localObject = com.tencent.mm.ui.component.g.Xox;
        localObject = ((Iterable)((com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).zLf).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.finder.preload.tabPreload.g localg = (com.tencent.mm.plugin.finder.preload.tabPreload.g)((Iterator)localObject).next();
          Log.i(localg.TAG, "[performEnterFinder]");
          localg.zLs = true;
          localg.zLt.aDJ("performEnterFinder");
        }
        requestAudioFocus();
      }
      if ((!((com.tencent.c.a.b.a.e)com.tencent.mm.kernel.h.ag(com.tencent.c.a.b.a.e.class)).onEnterFinder((MMActivity)paramMMFinderUI)) && (!this.wVL.contains(paramMMFinderUI))) {
        this.wVL.add(paramMMFinderUI);
      }
      if (this.wVL.size() == 1)
      {
        paramMMFinderUI = com.tencent.mm.plugin.findersdk.b.a.a.BvR;
        if (SystemClock.elapsedRealtime() - com.tencent.mm.plugin.findersdk.b.a.a.BvQ <= 300000L) {
          break label298;
        }
      }
    }
    label298:
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.CgiStrategy", "tryMoreInit tryInit:".concat(String.valueOf(bool)));
      if (bool)
      {
        com.tencent.mm.plugin.findersdk.b.a.a.init();
        com.tencent.mm.plugin.findersdk.b.a.a.BvQ = SystemClock.elapsedRealtime();
      }
      checkAccountDeletingTask();
      reportFinderPrivateMsgTableSize();
      AppMethodBeat.o(165095);
      return;
    }
  }
  
  public final void onExitFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165096);
    kotlin.g.b.p.k(paramMMFinderUI, "finder");
    this.wVL.remove(paramMMFinderUI);
    Object localObject = com.tencent.mm.plugin.finder.utils.l.ADu;
    com.tencent.mm.plugin.finder.utils.l.ecU();
    ((com.tencent.c.a.b.a.e)com.tencent.mm.kernel.h.ag(com.tencent.c.a.b.a.e.class)).onExitFinder((MMActivity)paramMMFinderUI);
    if (!isInFinder())
    {
      paramMMFinderUI = com.tencent.mm.ui.component.g.Xox;
      paramMMFinderUI = ((Iterable)((com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).zLf).iterator();
      while (paramMMFinderUI.hasNext())
      {
        localObject = (com.tencent.mm.plugin.finder.preload.tabPreload.g)paramMMFinderUI.next();
        Log.i(((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject).TAG, "[performExitFinder]");
        ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject).zLs = false;
        if (((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject).zLv.get()) {
          ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject).zLt.a(((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject).zLx, ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject).dMN(), "performExitFinder");
        }
      }
      this.kKI.avz();
      paramMMFinderUI = com.tencent.mm.plugin.finder.utils.aj.AGc;
      com.tencent.mm.plugin.finder.utils.aj.een();
      paramMMFinderUI = com.tencent.mm.ui.component.g.Xox;
      paramMMFinderUI = (com.tencent.mm.plugin.finder.viewmodel.j)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.j.class);
      Log.i("Finder.VideoStateCacheVM", "[clearProgress]");
      paramMMFinderUI.Bhy.clear();
    }
    paramMMFinderUI = getMediaPreloadModel();
    if (paramMMFinderUI.zKV.size() >= 3000) {
      paramMMFinderUI.zKV.clear();
    }
    AppMethodBeat.o(165096);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(165099);
    if (paramq != null) {
      switch (paramq.getType())
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
      paramString = paramq.getReqResp();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = ((com.tencent.mm.an.d)paramString).bhY();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetUserResponse");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = ((awa)paramString).SFU;
    } while (paramString == null);
    paramString = ((Iterable)paramString).iterator();
    while (paramString.hasNext())
    {
      paramq = (FinderContact)paramString.next();
      com.tencent.mm.plugin.finder.api.d.a locala = com.tencent.mm.plugin.finder.api.d.wZQ;
      com.tencent.mm.plugin.finder.api.d.a.b(paramq);
    }
    AppMethodBeat.o(165099);
  }
  
  public final void openChannelsCreateContact(Activity paramActivity, ag.a<Boolean> parama)
  {
    AppMethodBeat.i(275748);
    kotlin.g.b.p.k(paramActivity, "activity");
    kotlin.g.b.p.k(parama, "didOpenCallback");
    Object localObject = com.tencent.mm.model.z.bdh();
    Log.i("Finder.PluginFinder", "[openChannelsCreateContact] myFinderUsername".concat(String.valueOf(localObject)));
    localObject = (CharSequence)localObject;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_create_scene", 8);
      locala = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.w((Context)paramActivity, (Intent)localObject);
      parama.aH(Boolean.TRUE);
      AppMethodBeat.o(275748);
      return;
    }
    localObject = new Intent();
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI((Context)paramActivity, (Intent)localObject);
    parama.aH(Boolean.TRUE);
    AppMethodBeat.o(275748);
  }
  
  public final void openChannelsPostPage(Activity paramActivity)
  {
    AppMethodBeat.i(275747);
    kotlin.g.b.p.k(paramActivity, "activity");
    Log.i("Finder.PluginFinder", "[openChannelsPostPage]");
    Object localObject = com.tencent.mm.plugin.finder.report.k.zWs;
    com.tencent.mm.plugin.finder.report.k.av(11, false);
    localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)paramActivity, null);
    AppMethodBeat.o(275747);
  }
  
  public final void openFinderLiveOperationUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(275675);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramIntent, "intent");
    int i = paramIntent.getIntExtra("key_request_scene", 0);
    boolean bool = paramIntent.getBooleanExtra("key_use_dark_style", true);
    int j = paramIntent.getIntExtra("key_select_tab_id", 0);
    int k = paramIntent.getIntExtra("key_select_second_tab_id", 0);
    Object localObject2 = paramIntent.getStringExtra("key_by_pass");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int m = paramIntent.getIntExtra("key_entry_scene", 0);
    Object localObject3 = paramIntent.getStringExtra("key_feed_export_id");
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    String str = paramIntent.getStringExtra("key_feed_nonce_id");
    localObject3 = str;
    if (str == null) {
      localObject3 = "";
    }
    str = paramIntent.getStringExtra("key_page_title");
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    openFinderLiveOperationUIInternal(paramContext, i, bool, j, k, (String)localObject1, m, (String)localObject2, (String)localObject3, paramIntent);
    AppMethodBeat.o(275675);
  }
  
  public final void refreshXLabConfigToMMKV()
  {
    AppMethodBeat.i(275653);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vHA, 512);
    int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vHB, 2);
    MultiProcessMMKV.getDefault().putInt("FINDER_FOLDER_MAX_SIZE_MB", i);
    MultiProcessMMKV.getDefault().putInt("FINDER_FOLDER_LRU_EXPIRE_DAY", j);
    Log.i("Finder.PluginFinder", "refreshXLabConfigToMMKV size:" + i + ", time:" + j);
    AppMethodBeat.o(275653);
  }
  
  public final void report21053(View paramView, BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(275724);
    s.t localt;
    com.tencent.mm.plugin.finder.live.report.c localc;
    if (paramLong != s.t.yGM.fwf) {
      if (paramLong == s.t.yGN.fwf)
      {
        localt = s.t.yGN;
        if (paramInt4 == com.tencent.mm.plugin.finder.live.report.c.yAh.ordinal()) {
          break label379;
        }
        if (paramInt4 != com.tencent.mm.plugin.finder.live.report.c.yAi.ordinal()) {
          break label303;
        }
        localc = com.tencent.mm.plugin.finder.live.report.c.yAi;
      }
    }
    label303:
    label379:
    c.e locale;
    for (;;)
    {
      if ((paramView == null) || ((paramView instanceof AbsListView))) {
        switch (paramInt1)
        {
        default: 
          AppMethodBeat.o(275724);
          return;
          if (paramLong == s.t.yGO.fwf)
          {
            localt = s.t.yGO;
            break;
          }
          if (paramLong == s.t.yGP.fwf)
          {
            localt = s.t.yGP;
            break;
          }
          if (paramLong == s.t.yGQ.fwf)
          {
            localt = s.t.yGQ;
            break;
          }
          if (paramLong == s.t.yGR.fwf)
          {
            localt = s.t.yGR;
            break;
          }
          if (paramLong == s.t.yGS.fwf)
          {
            localt = s.t.yGS;
            break;
          }
          if (paramLong == s.t.yGT.fwf)
          {
            localt = s.t.yGT;
            break;
          }
          if (paramLong == s.t.yGU.fwf)
          {
            localt = s.t.yGU;
            break;
          }
          if (paramLong == s.t.yGV.fwf)
          {
            localt = s.t.yGV;
            break;
          }
          if (paramLong == s.t.yGW.fwf)
          {
            localt = s.t.yGW;
            break;
          }
          localt = s.t.yGM;
          break;
          if (paramInt4 == com.tencent.mm.plugin.finder.live.report.c.yAj.ordinal()) {
            localc = com.tencent.mm.plugin.finder.live.report.c.yAj;
          } else if (paramInt4 == com.tencent.mm.plugin.finder.live.report.c.yAk.ordinal()) {
            localc = com.tencent.mm.plugin.finder.live.report.c.yAk;
          } else if (paramInt4 == com.tencent.mm.plugin.finder.live.report.c.yAn.ordinal()) {
            localc = com.tencent.mm.plugin.finder.live.report.c.yAn;
          } else if (paramInt4 == com.tencent.mm.plugin.finder.live.report.c.yAo.ordinal()) {
            localc = com.tencent.mm.plugin.finder.live.report.c.yAo;
          } else {
            localc = com.tencent.mm.plugin.finder.live.report.c.yAh;
          }
          break;
        case 0: 
          locale = c.e.wli;
          com.tencent.mm.plugin.finder.live.report.k localk = com.tencent.mm.plugin.finder.live.report.k.yBj;
          if ((paramView instanceof AbsListView)) {
            break label523;
          }
          paramView = null;
        }
      }
    }
    label523:
    for (;;)
    {
      paramView = (AbsListView)paramView;
      if (paramString == null) {
        kotlin.g.b.p.iCn();
      }
      com.tencent.mm.plugin.finder.live.report.k.a(paramView, paramBaseAdapter, locale, paramInt2, paramInt3, localt, paramString, localc, paramBoolean);
      AppMethodBeat.o(275724);
      return;
      locale = c.e.wlj;
      break;
      locale = c.e.wlk;
      break;
      locale = c.e.wll;
      break;
      locale = c.e.wlm;
      break;
      paramBaseAdapter = com.tencent.mm.plugin.finder.live.report.k.yBj;
      if (!(paramView instanceof RecyclerView)) {
        paramView = null;
      }
      for (;;)
      {
        paramView = (RecyclerView)paramView;
        if (paramString == null) {
          kotlin.g.b.p.iCn();
        }
        com.tencent.mm.plugin.finder.live.report.k.b(paramView, localt, paramString, localc);
        AppMethodBeat.o(275724);
        return;
      }
    }
  }
  
  public final void report21053OnClick(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, long paramLong3, String paramString2, int paramInt3, int paramInt4, String paramString3, String paramString4, long paramLong4, int paramInt5)
  {
    AppMethodBeat.i(275725);
    s.t localt;
    s.bj localbj;
    if (paramLong3 == s.t.yGP.fwf)
    {
      localt = s.t.yGP;
      if (paramInt5 != s.bj.yMa.type) {
        break label201;
      }
      localbj = s.bj.yMa;
    }
    for (;;)
    {
      if (!kotlin.g.b.p.h(s.l.yGe.scene, paramString2)) {
        break label271;
      }
      com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.yBj, paramLong1, paramLong2, paramString1, paramInt1, paramInt2, s.t.yGS, paramString2);
      AppMethodBeat.o(275725);
      return;
      if (paramLong3 == s.t.yGQ.fwf)
      {
        localt = s.t.yGQ;
        break;
      }
      if (paramLong3 == s.t.yGR.fwf)
      {
        localt = s.t.yGR;
        break;
      }
      if (paramLong3 != s.t.yGS.fwf)
      {
        if (paramLong3 == s.t.yGU.fwf)
        {
          localt = s.t.yGU;
          break;
        }
        if (paramLong3 == s.t.yGV.fwf)
        {
          localt = s.t.yGV;
          break;
        }
        if (paramLong3 == s.t.yGW.fwf)
        {
          localt = s.t.yGW;
          break;
        }
      }
      localt = s.t.yGS;
      break;
      label201:
      if (paramInt5 == s.bj.yMb.type)
      {
        localbj = s.bj.yMb;
      }
      else if (paramInt5 == s.bj.yMc.type)
      {
        localbj = s.bj.yMc;
      }
      else if (paramInt5 == s.bj.yMd.type)
      {
        localbj = s.bj.yMd;
      }
      else
      {
        localbj = s.bj.yMe;
        localbj = s.bj.yMe;
      }
    }
    label271:
    com.tencent.mm.plugin.finder.live.report.k localk = com.tencent.mm.plugin.finder.live.report.k.yBj;
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      paramLong3 = paramInt1;
      long l1 = paramInt2;
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        long l2 = paramInt3;
        long l3 = paramInt4;
        if (paramString3 == null) {
          paramString3 = "";
        }
        for (;;)
        {
          if (paramString4 == null) {
            paramString4 = "";
          }
          for (;;)
          {
            com.tencent.mm.plugin.finder.live.report.k.b(new com.tencent.mm.plugin.finder.live.report.q(paramLong1, paramLong2, paramString1, paramLong3, l1, localt, paramString2, l2, l3, paramString3, paramString4, paramLong4, localbj, null, null, null, null, 122880));
            AppMethodBeat.o(275725);
            return;
          }
        }
      }
    }
  }
  
  public final void report21053OnClickOnSnsAd(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(275727);
    com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.yBj, paramLong1, paramLong2, paramString, paramLong3, 0L, s.t.yGS, "37");
    AppMethodBeat.o(275727);
  }
  
  public final void reportGiftOnReturn()
  {
    AppMethodBeat.i(275726);
    com.tencent.mm.plugin.finder.live.report.m localm = com.tencent.mm.plugin.finder.live.report.m.yCt;
    com.tencent.mm.plugin.finder.live.report.m.a(s.bk.yMo, "", 0);
    AppMethodBeat.o(275726);
  }
  
  public final void reportPostRedDot(int paramInt)
  {
    AppMethodBeat.i(165122);
    com.tencent.mm.plugin.report.service.h.IzE.p(1309L, paramInt, 1L);
    com.tencent.mm.plugin.report.service.h.IzE.a(19212, new Object[] { Integer.valueOf(paramInt), Long.valueOf(cm.bfC()) });
    AppMethodBeat.o(165122);
  }
  
  public final FinderObject requestFinderObject(final long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(275710);
    Log.i("Finder.PluginFinder", "requestFinderObject " + paramLong + ", enter");
    aa.f localf = new aa.f();
    final Object localObject = com.tencent.mm.plugin.finder.storage.data.e.AmW;
    localf.aaBC = e.a.MH(paramLong);
    localObject = new Object();
    final aa.a locala = new aa.a();
    locala.aaBx = false;
    if ((FinderItem)localf.aaBC == null)
    {
      Log.i("Finder.PluginFinder", "requestFinderObject " + paramLong + ", start");
      new com.tencent.mm.plugin.finder.cgi.ag(paramLong, paramString, paramInt, 2, "", true, null, null, 0L, null, false, false, null, null, 0, null, 57280).bhW().h((com.tencent.mm.vending.c.a)new al(localf, localObject, locala, paramLong));
    }
    if ((FinderItem)localf.aaBC == null) {}
    try
    {
      if (!locala.aaBx)
      {
        Log.i("Finder.PluginFinder", "requestFinderObject wait ".concat(String.valueOf(paramLong)));
        localObject.wait(2000L);
        Log.i("Finder.PluginFinder", "requestFinderObject notify ".concat(String.valueOf(paramLong)));
      }
      paramString = kotlin.x.aazN;
      paramString = (FinderItem)localf.aaBC;
      if (paramString != null)
      {
        paramString = paramString.getFeedObject();
        AppMethodBeat.o(275710);
        return paramString;
      }
    }
    finally
    {
      AppMethodBeat.o(275710);
    }
    AppMethodBeat.o(275710);
    return null;
  }
  
  public final void resetConfig()
  {
    AppMethodBeat.i(165093);
    try
    {
      Object localObject = com.tencent.mm.plugin.finder.storage.data.g.Anf;
      com.tencent.mm.plugin.finder.storage.data.g.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.k.Anu;
      k.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.b.AmP;
      com.tencent.mm.plugin.finder.storage.data.b.a.clearAll();
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vzp, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vzq, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBa, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBd, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBe, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBi, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBj, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBk, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VxV, Long.valueOf(1L));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VxX, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VxY, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VxZ, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vya, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vyb, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vyc, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vyg, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vyl, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vyq, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VyF, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vzn, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAG, Integer.valueOf(0));
      clearReInit();
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VzN, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VzW, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VzX, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBo, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBp, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAb, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAc, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAd, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAe, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAf, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAh, Boolean.FALSE);
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAs, "");
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAv, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAx, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAy, Integer.valueOf(0));
      localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VAC, Boolean.FALSE);
      AppMethodBeat.o(165093);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Finder.PluginFinder", (Throwable)localException, "resetConfig error", new Object[0]);
      AppMethodBeat.o(165093);
    }
  }
  
  public final void resetLastFinderInitTime()
  {
    this.wVM = 0L;
  }
  
  public final void resetLastTimelineExitTime()
  {
    AppMethodBeat.i(165110);
    Log.i("Finder.PluginFinder", "reset timeline auto refresh time");
    AppMethodBeat.o(165110);
  }
  
  public final void sdkShare(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(275712);
    Object localObject = com.tencent.mm.plugin.finder.utils.ab.AEA;
    Log.i(com.tencent.mm.plugin.finder.utils.ab.TAG, "LogPost, dealShare, businessType:" + paramString1 + ", appid:" + paramString2 + ", extInfo:" + paramString3);
    if ((paramString3 == null) || (Util.isNullOrNil(paramString3)) || (paramString1 == null) || (Util.isNullOrNil(paramString1)) || (paramString2 == null) || (Util.isNullOrNil(paramString2)))
    {
      com.tencent.mm.plugin.finder.utils.ab.e(-1, "appid or extInfo empty", paramString1, paramString2);
      AppMethodBeat.o(275712);
      return;
    }
    localObject = new Intent();
    ehy localehy = new ehy();
    localehy.yAT = 1;
    ead localead = new ead();
    localead.businessType = paramString1;
    localead.appid = paramString2;
    localead.extInfo = paramString3;
    localehy.UjV = localead;
    ((Intent)localObject).putExtra("KEY_POST_FROM_SHARE", localehy.toByteArray());
    paramString1 = com.tencent.mm.plugin.finder.utils.a.ACH;
    paramString1 = MMApplicationContext.getContext();
    kotlin.g.b.p.j(paramString1, "MMApplicationContext.getContext()");
    com.tencent.mm.plugin.finder.utils.a.x(paramString1, (Intent)localObject);
    AppMethodBeat.o(275712);
  }
  
  public final void set21084CommentScene(String paramString)
  {
    AppMethodBeat.i(275750);
    kotlin.g.b.p.k(paramString, "commentScene");
    com.tencent.mm.plugin.expt.hellhound.a.aww(paramString);
    AppMethodBeat.o(275750);
  }
  
  public final void setDataDB(com.tencent.mm.storagebase.h paramh)
  {
    this.kcF = paramh;
  }
  
  public final void setFinderMentionDB(com.tencent.mm.storagebase.h paramh)
  {
    this.wUK = paramh;
  }
  
  public final void setMessageDB(com.tencent.mm.storagebase.h paramh)
  {
    this.wUM = paramh;
  }
  
  public final void setWxMentionDB(com.tencent.mm.storagebase.h paramh)
  {
    this.wUL = paramh;
  }
  
  public final void shareStatsReport(List<? extends Pair<String, String>> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(275705);
    kotlin.g.b.p.k(paramList, "feedIdList");
    aa.f localf = new aa.f();
    localf.aaBC = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    if (paramList.hasNext())
    {
      Object localObject = (Pair)paramList.next();
      emr localemr = new emr();
      if (paramBoolean)
      {
        localemr.Upr = com.tencent.mm.ae.d.Nb((String)((Pair)localObject).first);
        localemr.Ups = ((String)((Pair)localObject).second);
      }
      for (;;)
      {
        localObject = new dhb();
        ((dhb)localObject).TNO += 1;
        ((dhb)localObject).TNQ = 1;
        localemr.Upl = ((dhb)localObject);
        ((LinkedList)localf.aaBC).add(localemr);
        break;
        localemr.xbk = com.tencent.mm.ae.d.Nb((String)((Pair)localObject).first);
        localemr.objectNonceId = ((String)((Pair)localObject).second);
      }
    }
    new com.tencent.mm.plugin.finder.cgi.z((List)localf.aaBC, null).bhW().j((com.tencent.mm.vending.c.a)new PluginFinder.am(localf));
    AppMethodBeat.o(275705);
  }
  
  public final boolean showFinderEntry()
  {
    AppMethodBeat.i(165102);
    boolean bool1;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vHv, 0) != 0)
    {
      bool1 = true;
      Object localObject = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      int i = com.tencent.mm.plugin.findersdk.c.a.aGQ("entrance");
      if (i == 2)
      {
        Log.i("Finder.PluginFinder", "showFinderEntry ".concat(String.valueOf(i)));
        bool1 = false;
      }
      if (this.wVO)
      {
        Log.i("Finder.PluginFinder", "closeFinderEntryForDebug");
        bool1 = false;
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (com.tencent.mm.plugin.finder.storage.d.dSF() == 0) {
        break label151;
      }
    }
    label151:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((!bool2) || (!bool1)) {
        Log.i("Finder.PluginFinder", "showFinder %s %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vHw, 0) != 0)
    {
      AppMethodBeat.o(165103);
      return true;
    }
    AppMethodBeat.o(165103);
    return false;
  }
  
  public final void snsToFinderPostReport(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, int paramInt5)
  {
    AppMethodBeat.i(275717);
    kotlin.g.b.p.k(paramString1, "sessionID");
    kotlin.g.b.p.k(paramString2, "wording");
    com.tencent.mm.plugin.finder.report.u localu = com.tencent.mm.plugin.finder.report.u.zXM;
    com.tencent.mm.plugin.finder.report.u.a(paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramLong3, paramInt5);
    AppMethodBeat.o(275717);
  }
  
  public final FinderObject tryGetFinderObject(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(275706);
    paramString = tryGetFinderObject(paramLong, paramString, paramInt, true, false, null);
    AppMethodBeat.o(275706);
    return paramString;
  }
  
  public final FinderObject tryGetFinderObject(final long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ak.a parama)
  {
    AppMethodBeat.i(275708);
    Log.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", enter");
    if (paramBoolean1)
    {
      localObject = com.tencent.mm.plugin.finder.storage.data.e.AmW;
      e.a.Ig(paramLong);
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.data.e.AmW;
    localObject = e.a.MH(paramLong);
    if (localObject == null)
    {
      Log.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", start");
      paramString = new com.tencent.mm.plugin.finder.cgi.ag(paramLong, paramString, paramInt, 2, "", true, null, null, 0L, null, false, false, null, null, 0, null, 57280);
      if (paramBoolean2)
      {
        Context localContext1 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localContext1, "MMApplicationContext.getContext()");
        Context localContext2 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localContext2, "MMApplicationContext.getContext()");
        paramString.e(localContext1, localContext2.getResources().getString(b.j.finder_get_detail_wait), 1000L);
      }
      paramString.bhW().h((com.tencent.mm.vending.c.a)new ap(parama, paramLong));
    }
    if (localObject != null)
    {
      paramString = ((FinderItem)localObject).getFeedObject();
      AppMethodBeat.o(275708);
      return paramString;
    }
    AppMethodBeat.o(275708);
    return null;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/PluginFinder$Companion;", "", "()V", "ID_KEY_POST_RED_DOT", "", "KV_ID_POST_RED_DOT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "invoke"})
  static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.storage.ah>
  {
    public static final aa wWr;
    
    static
    {
      AppMethodBeat.i(290335);
      wWr = new aa();
      AppMethodBeat.o(290335);
    }
    
    aa()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "invoke"})
  static final class ab
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.loader.g.i>
  {
    public static final ab wWs;
    
    static
    {
      AppMethodBeat.i(267735);
      wWs = new ab();
      AppMethodBeat.o(267735);
    }
    
    ab()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "invoke"})
  static final class ac
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.service.d>
  {
    public static final ac wWt;
    
    static
    {
      AppMethodBeat.i(275285);
      wWt = new ac();
      AppMethodBeat.o(275285);
    }
    
    ac()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class ad<T, R>
    implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.w, Bitmap>
  {
    ad(kotlin.g.a.b paramb) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class af
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final af wWy;
    
    static
    {
      AppMethodBeat.i(274384);
      wWy = new af();
      AppMethodBeat.o(274384);
    }
    
    af()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/PluginFinder$onAccountInitialized$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISendAppMsgSceneGenerator;", "transmit", "", "activity", "Landroid/app/Activity;", "toUserName", "", "msgContent", "callback", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISendAppMsgSceneGenerator$Callback;", "plugin-finder_release"})
  public static final class ag
    implements com.tencent.mm.plugin.messenger.foundation.a.z
  {
    public final void a(Activity paramActivity, String paramString1, String paramString2, z.a parama)
    {
      AppMethodBeat.i(279733);
      kotlin.g.b.p.k(paramActivity, "activity");
      kotlin.g.b.p.k(paramString1, "toUserName");
      kotlin.g.b.p.k(paramString2, "msgContent");
      new com.tencent.mm.plugin.finder.cgi.f(paramString1, paramString2, (com.tencent.mm.plugin.finder.cgi.f.a)new a(parama)).bhW();
      AppMethodBeat.o(279733);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/PluginFinder$onAccountInitialized$1$transmit$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAuthAppMsg$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderSendInviteMsgResponse;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.finder.cgi.f.a
    {
      a(z.a parama) {}
      
      public final void a(int paramInt, bix parambix)
      {
        AppMethodBeat.i(288838);
        kotlin.g.b.p.k(parambix, "resp");
        parambix = this.wWz;
        if (parambix != null)
        {
          if (paramInt == 0) {}
          for (boolean bool = true;; bool = false)
          {
            parambix.ub(bool);
            AppMethodBeat.o(288838);
            return;
          }
        }
        AppMethodBeat.o(288838);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class ah
    implements Runnable
  {
    public static final ah wWA;
    
    static
    {
      AppMethodBeat.i(282044);
      wWA = new ah();
      AppMethodBeat.o(282044);
    }
    
    public final void run()
    {
      AppMethodBeat.i(282043);
      com.tencent.mm.plugin.finder.upload.b.a locala = com.tencent.mm.plugin.finder.upload.b.Azp;
      com.tencent.mm.plugin.finder.upload.b.ebZ().ebY();
      AppMethodBeat.o(282043);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ai
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    public static final ai wWB;
    
    static
    {
      AppMethodBeat.i(272036);
      wWB = new ai();
      AppMethodBeat.o(272036);
    }
    
    ai()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class aj
    implements Runnable
  {
    aj(PluginFinder paramPluginFinder) {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 7
      //   3: aconst_null
      //   4: astore 6
      //   6: aconst_null
      //   7: astore 5
      //   9: aconst_null
      //   10: astore 4
      //   12: aconst_null
      //   13: astore 8
      //   15: ldc 33
      //   17: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   20: invokestatic 45	java/lang/System:currentTimeMillis	()J
      //   23: aload_0
      //   24: getfield 27	com/tencent/mm/plugin/finder/PluginFinder$aj:wVS	Lcom/tencent/mm/plugin/finder/PluginFinder;
      //   27: invokestatic 49	com/tencent/mm/plugin/finder/PluginFinder:access$getLastReportTime$p	(Lcom/tencent/mm/plugin/finder/PluginFinder;)J
      //   30: lsub
      //   31: ldc2_w 50
      //   34: lcmp
      //   35: ifle +729 -> 764
      //   38: aload_0
      //   39: getfield 27	com/tencent/mm/plugin/finder/PluginFinder$aj:wVS	Lcom/tencent/mm/plugin/finder/PluginFinder;
      //   42: invokestatic 45	java/lang/System:currentTimeMillis	()J
      //   45: invokestatic 55	com/tencent/mm/plugin/finder/PluginFinder:access$setLastReportTime$p	(Lcom/tencent/mm/plugin/finder/PluginFinder;J)V
      //   48: aload_0
      //   49: getfield 27	com/tencent/mm/plugin/finder/PluginFinder$aj:wVS	Lcom/tencent/mm/plugin/finder/PluginFinder;
      //   52: invokevirtual 59	com/tencent/mm/plugin/finder/PluginFinder:getContactStorage	()Lcom/tencent/mm/plugin/finder/storage/e;
      //   55: getfield 65	com/tencent/mm/plugin/finder/storage/e:AkA	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
      //   58: ldc 67
      //   60: aconst_null
      //   61: invokeinterface 73 3 0
      //   66: checkcast 75	java/io/Closeable
      //   69: astore 9
      //   71: aload 9
      //   73: checkcast 77	android/database/Cursor
      //   76: astore_3
      //   77: aload_3
      //   78: invokeinterface 81 1 0
      //   83: pop
      //   84: aload_3
      //   85: iconst_0
      //   86: invokeinterface 85 2 0
      //   91: lstore_1
      //   92: new 87	com/tencent/mm/plugin/finder/conv/c$a
      //   95: dup
      //   96: invokespecial 88	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
      //   99: astore_3
      //   100: invokestatic 94	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   103: astore 10
      //   105: aload 10
      //   107: ldc 96
      //   109: invokestatic 102	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   112: aload 10
      //   114: invokevirtual 106	java/lang/Thread:getName	()Ljava/lang/String;
      //   117: astore 10
      //   119: aload 10
      //   121: ldc 108
      //   123: invokestatic 102	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   126: aload_3
      //   127: aload 10
      //   129: invokevirtual 112	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   132: ldc 67
      //   134: invokevirtual 115	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   137: astore_3
      //   138: aload_3
      //   139: lload_1
      //   140: putfield 119	com/tencent/mm/plugin/finder/conv/c$a:xga	J
      //   143: aload_3
      //   144: ldc 121
      //   146: invokevirtual 124	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   149: invokevirtual 128	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
      //   152: invokevirtual 133	com/tencent/mm/plugin/finder/conv/c$b:report	()V
      //   155: getstatic 139	kotlin/x:aazN	Lkotlin/x;
      //   158: astore_3
      //   159: aload 9
      //   161: aconst_null
      //   162: invokestatic 145	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   165: aload_0
      //   166: getfield 27	com/tencent/mm/plugin/finder/PluginFinder$aj:wVS	Lcom/tencent/mm/plugin/finder/PluginFinder;
      //   169: invokevirtual 149	com/tencent/mm/plugin/finder/PluginFinder:getMsgAliasContactStorage	()Lcom/tencent/mm/plugin/finder/storage/y;
      //   172: getfield 152	com/tencent/mm/plugin/finder/storage/y:AkA	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
      //   175: ldc 154
      //   177: aconst_null
      //   178: invokeinterface 73 3 0
      //   183: checkcast 75	java/io/Closeable
      //   186: astore 8
      //   188: aload 8
      //   190: checkcast 77	android/database/Cursor
      //   193: astore_3
      //   194: aload_3
      //   195: invokeinterface 81 1 0
      //   200: pop
      //   201: aload_3
      //   202: iconst_0
      //   203: invokeinterface 85 2 0
      //   208: lstore_1
      //   209: new 87	com/tencent/mm/plugin/finder/conv/c$a
      //   212: dup
      //   213: invokespecial 88	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
      //   216: astore_3
      //   217: invokestatic 94	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   220: astore 9
      //   222: aload 9
      //   224: ldc 96
      //   226: invokestatic 102	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   229: aload 9
      //   231: invokevirtual 106	java/lang/Thread:getName	()Ljava/lang/String;
      //   234: astore 9
      //   236: aload 9
      //   238: ldc 108
      //   240: invokestatic 102	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   243: aload_3
      //   244: aload 9
      //   246: invokevirtual 112	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   249: ldc 154
      //   251: invokevirtual 115	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   254: astore_3
      //   255: aload_3
      //   256: lload_1
      //   257: putfield 119	com/tencent/mm/plugin/finder/conv/c$a:xga	J
      //   260: aload_3
      //   261: ldc 156
      //   263: invokevirtual 124	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   266: invokevirtual 128	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
      //   269: invokevirtual 133	com/tencent/mm/plugin/finder/conv/c$b:report	()V
      //   272: getstatic 139	kotlin/x:aazN	Lkotlin/x;
      //   275: astore_3
      //   276: aload 8
      //   278: aconst_null
      //   279: invokestatic 145	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   282: aload_0
      //   283: getfield 27	com/tencent/mm/plugin/finder/PluginFinder$aj:wVS	Lcom/tencent/mm/plugin/finder/PluginFinder;
      //   286: invokevirtual 160	com/tencent/mm/plugin/finder/PluginFinder:getSessionInfoStorage	()Lcom/tencent/mm/plugin/finder/storage/af;
      //   289: getfield 165	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
      //   292: ldc 167
      //   294: aconst_null
      //   295: invokeinterface 73 3 0
      //   300: checkcast 75	java/io/Closeable
      //   303: astore 7
      //   305: aload 7
      //   307: checkcast 77	android/database/Cursor
      //   310: astore_3
      //   311: aload_3
      //   312: invokeinterface 81 1 0
      //   317: pop
      //   318: aload_3
      //   319: iconst_0
      //   320: invokeinterface 85 2 0
      //   325: lstore_1
      //   326: new 87	com/tencent/mm/plugin/finder/conv/c$a
      //   329: dup
      //   330: invokespecial 88	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
      //   333: astore_3
      //   334: invokestatic 94	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   337: astore 8
      //   339: aload 8
      //   341: ldc 96
      //   343: invokestatic 102	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   346: aload 8
      //   348: invokevirtual 106	java/lang/Thread:getName	()Ljava/lang/String;
      //   351: astore 8
      //   353: aload 8
      //   355: ldc 108
      //   357: invokestatic 102	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   360: aload_3
      //   361: aload 8
      //   363: invokevirtual 112	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   366: ldc 167
      //   368: invokevirtual 115	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   371: astore_3
      //   372: aload_3
      //   373: lload_1
      //   374: putfield 119	com/tencent/mm/plugin/finder/conv/c$a:xga	J
      //   377: aload_3
      //   378: ldc 169
      //   380: invokevirtual 124	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   383: invokevirtual 128	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
      //   386: invokevirtual 133	com/tencent/mm/plugin/finder/conv/c$b:report	()V
      //   389: getstatic 139	kotlin/x:aazN	Lkotlin/x;
      //   392: astore_3
      //   393: aload 7
      //   395: aconst_null
      //   396: invokestatic 145	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   399: aload_0
      //   400: getfield 27	com/tencent/mm/plugin/finder/PluginFinder$aj:wVS	Lcom/tencent/mm/plugin/finder/PluginFinder;
      //   403: invokevirtual 173	com/tencent/mm/plugin/finder/PluginFinder:getMsgStrangerContactStorage	()Lcom/tencent/mm/plugin/finder/storage/z;
      //   406: getfield 176	com/tencent/mm/plugin/finder/storage/z:AkA	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
      //   409: ldc 178
      //   411: aconst_null
      //   412: invokeinterface 73 3 0
      //   417: checkcast 75	java/io/Closeable
      //   420: astore 6
      //   422: aload 6
      //   424: checkcast 77	android/database/Cursor
      //   427: astore_3
      //   428: aload_3
      //   429: invokeinterface 81 1 0
      //   434: pop
      //   435: aload_3
      //   436: iconst_0
      //   437: invokeinterface 85 2 0
      //   442: lstore_1
      //   443: new 87	com/tencent/mm/plugin/finder/conv/c$a
      //   446: dup
      //   447: invokespecial 88	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
      //   450: astore_3
      //   451: invokestatic 94	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   454: astore 7
      //   456: aload 7
      //   458: ldc 96
      //   460: invokestatic 102	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   463: aload 7
      //   465: invokevirtual 106	java/lang/Thread:getName	()Ljava/lang/String;
      //   468: astore 7
      //   470: aload 7
      //   472: ldc 108
      //   474: invokestatic 102	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   477: aload_3
      //   478: aload 7
      //   480: invokevirtual 112	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   483: ldc 178
      //   485: invokevirtual 115	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   488: astore_3
      //   489: aload_3
      //   490: lload_1
      //   491: putfield 119	com/tencent/mm/plugin/finder/conv/c$a:xga	J
      //   494: aload_3
      //   495: ldc 180
      //   497: invokevirtual 124	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   500: invokevirtual 128	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
      //   503: invokevirtual 133	com/tencent/mm/plugin/finder/conv/c$b:report	()V
      //   506: getstatic 139	kotlin/x:aazN	Lkotlin/x;
      //   509: astore_3
      //   510: aload 6
      //   512: aconst_null
      //   513: invokestatic 145	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   516: aload_0
      //   517: getfield 27	com/tencent/mm/plugin/finder/PluginFinder$aj:wVS	Lcom/tencent/mm/plugin/finder/PluginFinder;
      //   520: invokevirtual 184	com/tencent/mm/plugin/finder/PluginFinder:getConversationStorage	()Lcom/tencent/mm/plugin/finder/storage/f;
      //   523: getfield 187	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
      //   526: ldc 189
      //   528: aconst_null
      //   529: invokeinterface 73 3 0
      //   534: checkcast 75	java/io/Closeable
      //   537: astore 5
      //   539: aload 5
      //   541: checkcast 77	android/database/Cursor
      //   544: astore_3
      //   545: aload_3
      //   546: invokeinterface 81 1 0
      //   551: pop
      //   552: aload_3
      //   553: iconst_0
      //   554: invokeinterface 85 2 0
      //   559: lstore_1
      //   560: new 87	com/tencent/mm/plugin/finder/conv/c$a
      //   563: dup
      //   564: invokespecial 88	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
      //   567: astore_3
      //   568: invokestatic 94	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   571: astore 6
      //   573: aload 6
      //   575: ldc 96
      //   577: invokestatic 102	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   580: aload 6
      //   582: invokevirtual 106	java/lang/Thread:getName	()Ljava/lang/String;
      //   585: astore 6
      //   587: aload 6
      //   589: ldc 108
      //   591: invokestatic 102	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   594: aload_3
      //   595: aload 6
      //   597: invokevirtual 112	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   600: ldc 189
      //   602: invokevirtual 115	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   605: astore_3
      //   606: aload_3
      //   607: lload_1
      //   608: putfield 119	com/tencent/mm/plugin/finder/conv/c$a:xga	J
      //   611: aload_3
      //   612: ldc 191
      //   614: invokevirtual 124	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
      //   617: invokevirtual 128	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
      //   620: invokevirtual 133	com/tencent/mm/plugin/finder/conv/c$b:report	()V
      //   623: getstatic 139	kotlin/x:aazN	Lkotlin/x;
      //   626: astore_3
      //   627: aload 5
      //   629: aconst_null
      //   630: invokestatic 145	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   633: ldc 33
      //   635: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   638: return
      //   639: astore 4
      //   641: ldc 33
      //   643: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   646: aload 4
      //   648: athrow
      //   649: astore_3
      //   650: aload 9
      //   652: aload 4
      //   654: invokestatic 145	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   657: ldc 33
      //   659: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   662: aload_3
      //   663: athrow
      //   664: astore 4
      //   666: ldc 33
      //   668: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   671: aload 4
      //   673: athrow
      //   674: astore_3
      //   675: aload 8
      //   677: aload 4
      //   679: invokestatic 145	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   682: ldc 33
      //   684: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   687: aload_3
      //   688: athrow
      //   689: astore 4
      //   691: ldc 33
      //   693: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   696: aload 4
      //   698: athrow
      //   699: astore_3
      //   700: aload 7
      //   702: aload 4
      //   704: invokestatic 145	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   707: ldc 33
      //   709: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   712: aload_3
      //   713: athrow
      //   714: astore 4
      //   716: ldc 33
      //   718: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   721: aload 4
      //   723: athrow
      //   724: astore_3
      //   725: aload 6
      //   727: aload 4
      //   729: invokestatic 145	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   732: ldc 33
      //   734: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   737: aload_3
      //   738: athrow
      //   739: astore 4
      //   741: ldc 33
      //   743: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   746: aload 4
      //   748: athrow
      //   749: astore_3
      //   750: aload 5
      //   752: aload 4
      //   754: invokestatic 145	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   757: ldc 33
      //   759: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   762: aload_3
      //   763: athrow
      //   764: ldc 33
      //   766: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   769: return
      //   770: astore_3
      //   771: goto -21 -> 750
      //   774: astore_3
      //   775: aload 5
      //   777: astore 4
      //   779: goto -54 -> 725
      //   782: astore_3
      //   783: aload 6
      //   785: astore 4
      //   787: goto -87 -> 700
      //   790: astore_3
      //   791: aload 7
      //   793: astore 4
      //   795: goto -120 -> 675
      //   798: astore_3
      //   799: aload 8
      //   801: astore 4
      //   803: goto -153 -> 650
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	806	0	this	aj
      //   91	517	1	l	long
      //   76	551	3	localObject1	Object
      //   649	14	3	localObject2	Object
      //   674	14	3	localObject3	Object
      //   699	14	3	localObject4	Object
      //   724	14	3	localObject5	Object
      //   749	14	3	localObject6	Object
      //   770	1	3	localObject7	Object
      //   774	1	3	localObject8	Object
      //   782	1	3	localObject9	Object
      //   790	1	3	localObject10	Object
      //   798	1	3	localObject11	Object
      //   10	1	4	localObject12	Object
      //   639	14	4	localThrowable1	Throwable
      //   664	14	4	localThrowable2	Throwable
      //   689	14	4	localThrowable3	Throwable
      //   714	14	4	localThrowable4	Throwable
      //   739	14	4	localThrowable5	Throwable
      //   777	25	4	localObject13	Object
      //   7	769	5	localCloseable	java.io.Closeable
      //   4	780	6	localObject14	Object
      //   1	791	7	localObject15	Object
      //   13	787	8	localObject16	Object
      //   69	582	9	localObject17	Object
      //   103	25	10	localObject18	Object
      // Exception table:
      //   from	to	target	type
      //   71	159	639	java/lang/Throwable
      //   641	649	649	finally
      //   188	276	664	java/lang/Throwable
      //   666	674	674	finally
      //   305	393	689	java/lang/Throwable
      //   691	699	699	finally
      //   422	510	714	java/lang/Throwable
      //   716	724	724	finally
      //   539	627	739	java/lang/Throwable
      //   741	749	749	finally
      //   539	627	770	finally
      //   422	510	774	finally
      //   305	393	782	finally
      //   188	276	790	finally
      //   71	159	798	finally
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/PluginFinder$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
  public static final class ak
    implements com.tencent.mm.model.d.a
  {
    public final void bcu()
    {
      AppMethodBeat.i(165073);
      Log.i("Finder.PluginFinder", "[audioHelperTool] gain");
      AppMethodBeat.o(165073);
    }
    
    public final void bcv()
    {
      AppMethodBeat.i(165075);
      Log.i("Finder.PluginFinder", "[audioHelperTool] loss");
      AppMethodBeat.o(165075);
    }
    
    public final void bcw()
    {
      AppMethodBeat.i(165074);
      Log.i("Finder.PluginFinder", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(165074);
    }
    
    public final void bcx()
    {
      AppMethodBeat.i(165076);
      Log.i("Finder.PluginFinder", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(165076);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class al<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    al(aa.f paramf, Object paramObject, aa.a parama, long paramLong) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/PluginFinder$startActivityEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StartActivityEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class an
    extends IListener<xv>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDataChanged"})
  static final class ao
    implements com.tencent.mm.plugin.teenmode.a.c
  {
    public static final ao wWG;
    
    static
    {
      AppMethodBeat.i(273687);
      wWG = new ao();
      AppMethodBeat.o(273687);
    }
    
    public final void onDataChanged()
    {
      AppMethodBeat.i(273686);
      Object localObject1 = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).resetCache();
      localObject1 = com.tencent.mm.kernel.h.ag(ak.class);
      kotlin.g.b.p.j(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      localObject1 = ((ak)localObject1).getRedDotManager();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotManager");
        AppMethodBeat.o(273686);
        throw ((Throwable)localObject1);
      }
      com.tencent.mm.plugin.finder.extension.reddot.f localf = (com.tencent.mm.plugin.finder.extension.reddot.f)localObject1;
      if (localf != null)
      {
        localObject1 = localf.xsV.keys();
        kotlin.g.b.p.j(localObject1, "pathToCtrInfoMap.keys()");
        localObject1 = Collections.list((Enumeration)localObject1);
        kotlin.g.b.p.j(localObject1, "java.util.Collections.list(this)");
        localObject1 = (List)localObject1;
        Log.i("Finder.RedDotManager", "resetNotifyAllPathWithCrlInfo#reset, list:".concat(String.valueOf(localObject1)));
        Object localObject3 = ((Iterable)localObject1).iterator();
        Object localObject4;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject1 = (List)localf.xsV.get(localObject4);
          label256:
          label260:
          label267:
          if (localObject1 != null)
          {
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            label211:
            if (((ListIterator)localObject2).hasPrevious())
            {
              localObject1 = ((ListIterator)localObject2).previous();
              com.tencent.mm.plugin.finder.extension.reddot.l locall = (com.tencent.mm.plugin.finder.extension.reddot.l)localObject1;
              kotlin.g.b.p.j(localObject4, "path");
              if (locall.aBy((String)localObject4) != null)
              {
                i = 1;
                if (i == 0) {
                  break label309;
                }
                localObject1 = (com.tencent.mm.plugin.finder.extension.reddot.l)localObject1;
                localObject2 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
                kotlin.g.b.p.j(localObject4, "path");
                if (localObject1 == null) {
                  break label323;
                }
              }
            }
          }
          label309:
          label323:
          for (localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject1).aBy((String)localObject4);; localObject2 = null)
          {
            com.tencent.mm.plugin.finder.extension.reddot.h.a(false, (String)localObject4, (bkn)localObject2, (com.tencent.mm.plugin.finder.extension.reddot.l)localObject1);
            break;
            i = 0;
            break label256;
            break label211;
            localObject1 = null;
            break label260;
            localObject1 = null;
            break label267;
          }
        }
        localf.xsV.clear();
        localObject1 = localf.xtb.dqx();
        int i = ((LinkedList)localObject1).size();
        Object localObject2 = com.tencent.mm.plugin.finder.extension.reddot.d.xsB;
        boolean bool = com.tencent.mm.plugin.finder.extension.reddot.d.a((LinkedList)localObject1, localf.xtb);
        int j = ((LinkedList)localObject1).size();
        Log.i("Finder.RedDotManager", "resetNotifyAllPathWithCrlInfo#build checkRet=" + bool + " beforeCheckCount=" + i + " afterCheckCount=" + j);
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.finder.extension.reddot.l)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).drI())
          {
            Log.w("Finder.RedDotManager", "[resetNotifyAllPathWithCrlInfo] showInfo is empty! ".concat(String.valueOf(localObject2)));
            ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).b(localf.xtb, false);
          }
          else
          {
            localObject3 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).field_ctrInfo;
            kotlin.g.b.p.j(localObject3, "it.field_ctrInfo");
            localf.a(((com.tencent.mm.plugin.finder.extension.reddot.l)localObject2).e((bhw)localObject3), "resetNotifyAllPathWithCrlInfo");
          }
        }
        localObject1 = localf.xsV.keys();
        kotlin.g.b.p.j(localObject1, "pathToCtrInfoMap.keys()");
        localObject1 = Collections.list((Enumeration)localObject1);
        kotlin.g.b.p.j(localObject1, "java.util.Collections.list(this)");
        localObject1 = (List)localObject1;
        Log.i("Finder.RedDotManager", "resetNotifyAllPathWithCrlInfo#notify, list:".concat(String.valueOf(localObject1)));
        localObject2 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          kotlin.g.b.p.j(localObject3, "it");
          localObject4 = localf.aBf((String)localObject3);
          localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
          if (localObject4 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject4).aBy((String)localObject3);
            label643:
            if (localObject1 == null) {
              break label683;
            }
            bool = true;
            label650:
            if (localObject4 == null) {
              break label688;
            }
          }
          label683:
          label688:
          for (localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject4).aBy((String)localObject3);; localObject1 = null)
          {
            com.tencent.mm.plugin.finder.extension.reddot.h.a(bool, (String)localObject3, (bkn)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.l)localObject4);
            break;
            localObject1 = null;
            break label643;
            bool = false;
            break label650;
          }
        }
      }
      ((com.tencent.mm.plugin.findersdk.a.m)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.m.class)).dRq();
      AppMethodBeat.o(273686);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class ap<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    ap(ak.a parama, long paramLong) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.app.o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(165054);
      PluginFinder.access$getAudioHelperTool$p(this.wVS).avz();
      paramString = com.tencent.mm.plugin.finder.report.j.zVy;
      com.tencent.mm.plugin.finder.report.j.dPw();
      AppMethodBeat.o(165054);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(165055);
      if (this.wVS.isInFinder()) {
        PluginFinder.access$requestAudioFocus(this.wVS);
      }
      if ((this.wVS.showFinderEntry()) && (System.currentTimeMillis() - PluginFinder.access$getLastFinderInitTime$p(this.wVS) >= 86400000L)) {
        PluginFinder.access$doFinderInit(this.wVS);
      }
      AppMethodBeat.o(165055);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(PluginFinder paramPluginFinder) {}
    
    public final void run()
    {
      AppMethodBeat.i(288171);
      Object localObject3;
      Object localObject4;
      for (;;)
      {
        try
        {
          Object localObject1 = this.wVS.getFinderOrAliasDeletingInfoStorage().dYR();
          Log.i("Finder.PluginFinder", "checkAccountDeletingTask size:" + ((LinkedList)localObject1).size());
          localObject3 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject3 = ((Iterable)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = ((Iterator)localObject3).next();
          if (((bk)localObject4).systemRowid == -1L) {
            break label160;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          ((Collection)localObject1).add(localObject4);
          continue;
          localObject2 = (Throwable)localException;
        }
        catch (Exception localException)
        {
          Log.i("Finder.PluginFinder", "checkAccountDeletingTask Exception:" + localException.getMessage());
          localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (!com.tencent.mm.plugin.finder.utils.aj.eej()) {
            break label321;
          }
        }
        AppMethodBeat.o(288171);
        throw ((Throwable)localObject2);
        label160:
        int i = 0;
      }
      Object localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bk)((Iterator)localObject2).next();
        Log.i("Finder.PluginFinder", "checkAccountDeletingTask del username = " + ((bk)localObject3).field_username + ", type:" + ((bk)localObject3).field_type);
        switch (((bk)localObject3).field_type)
        {
        }
      }
      for (;;)
      {
        Log.i("Finder.PluginFinder", "checkAccountDeletingTask unknown type:" + ((bk)localObject3).field_type);
        break;
        localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.a("checkAccountDeletingTask", (bk)localObject3);
        break;
        localObject4 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.b("checkAccountDeletingTask", (bk)localObject3);
        break;
        AppMethodBeat.o(288171);
        return;
        label321:
        AppMethodBeat.o(288171);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "getSQLs", "()[Ljava/lang/String;"})
  static final class d
    implements h.b
  {
    public static final d wVT;
    
    static
    {
      AppMethodBeat.i(165057);
      wVT = new d();
      AppMethodBeat.o(165057);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165056);
      Object localObject = com.tencent.mm.plugin.finder.storage.v.AlS;
      kotlin.g.b.p.k("findermessage006", "table");
      localObject = com.tencent.mm.plugin.byp.b.sVU;
      localObject = MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.byp.b.access$getInfo$cp(), "findermessage006");
      kotlin.g.b.p.j(localObject, "getCreateSQLs(BypMsgInfo.info, table)");
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class e
    implements h.b
  {
    public static final e wVU;
    
    static
    {
      AppMethodBeat.i(275123);
      wVU = new e();
      AppMethodBeat.o(275123);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(275122);
      Object localObject = com.tencent.mm.plugin.finder.storage.e.AkB;
      localObject = com.tencent.mm.plugin.finder.storage.e.dqy();
      AppMethodBeat.o(275122);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class f
    implements h.b
  {
    public static final f wVV;
    
    static
    {
      AppMethodBeat.i(273682);
      wVV = new f();
      AppMethodBeat.o(273682);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(273681);
      Object localObject = com.tencent.mm.plugin.finder.storage.z.Ame;
      localObject = com.tencent.mm.plugin.finder.storage.z.dqy();
      AppMethodBeat.o(273681);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class g
    implements h.b
  {
    public static final g wVW;
    
    static
    {
      AppMethodBeat.i(288397);
      wVW = new g();
      AppMethodBeat.o(288397);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(288396);
      Object localObject = com.tencent.mm.plugin.finder.storage.y.Amd;
      localObject = com.tencent.mm.plugin.finder.storage.y.dqy();
      AppMethodBeat.o(288396);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class h
    implements h.b
  {
    public static final h wVX;
    
    static
    {
      AppMethodBeat.i(245991);
      wVX = new h();
      AppMethodBeat.o(245991);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(245990);
      Object localObject = com.tencent.mm.plugin.finder.storage.m.Alj;
      localObject = com.tencent.mm.plugin.finder.storage.m.dqy();
      AppMethodBeat.o(245990);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class i
    implements h.b
  {
    public static final i wVY;
    
    static
    {
      AppMethodBeat.i(221233);
      wVY = new i();
      AppMethodBeat.o(221233);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(221228);
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.b.AnJ;
      localObject = com.tencent.mm.plugin.finder.storage.logic.b.dqy();
      AppMethodBeat.o(221228);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class j
    implements h.b
  {
    public static final j wVZ;
    
    static
    {
      AppMethodBeat.i(249139);
      wVZ = new j();
      AppMethodBeat.o(249139);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(249138);
      Object localObject = com.tencent.mm.plugin.finder.storage.t.Alx;
      localObject = com.tencent.mm.plugin.finder.storage.t.dqy();
      AppMethodBeat.o(249138);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class k
    implements h.b
  {
    public static final k wWa;
    
    static
    {
      AppMethodBeat.i(289330);
      wWa = new k();
      AppMethodBeat.o(289330);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(289329);
      Object localObject = com.tencent.mm.plugin.finder.extension.reddot.c.xsA;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.c.dqy();
      AppMethodBeat.o(289329);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class l
    implements h.b
  {
    public static final l wWb;
    
    static
    {
      AppMethodBeat.i(289488);
      wWb = new l();
      AppMethodBeat.o(289488);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(289487);
      Object localObject = com.tencent.mm.plugin.finder.storage.a.AdP;
      localObject = com.tencent.mm.plugin.finder.storage.a.dqy();
      AppMethodBeat.o(289487);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class m
    implements h.b
  {
    public static final m wWc;
    
    static
    {
      AppMethodBeat.i(282176);
      wWc = new m();
      AppMethodBeat.o(282176);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(282175);
      Object localObject = com.tencent.mm.plugin.finder.storage.s.Alw;
      localObject = com.tencent.mm.plugin.finder.storage.s.dqy();
      AppMethodBeat.o(282175);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class n
    implements h.b
  {
    public static final n wWd;
    
    static
    {
      AppMethodBeat.i(165065);
      wWd = new n();
      AppMethodBeat.o(165065);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(165064);
      Object localObject = com.tencent.mm.plugin.finder.storage.n.Alk;
      localObject = com.tencent.mm.plugin.finder.storage.n.dqy();
      AppMethodBeat.o(165064);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class o
    implements h.b
  {
    public static final o wWe;
    
    static
    {
      AppMethodBeat.i(283733);
      wWe = new o();
      AppMethodBeat.o(283733);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(283732);
      Object localObject = com.tencent.mm.plugin.finder.storage.ai.AmH;
      localObject = com.tencent.mm.plugin.finder.storage.ai.dqy();
      AppMethodBeat.o(283732);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class p
    implements h.b
  {
    public static final p wWf;
    
    static
    {
      AppMethodBeat.i(287209);
      wWf = new p();
      AppMethodBeat.o(287209);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(287208);
      Object localObject = com.tencent.mm.plugin.finder.storage.f.AkC;
      localObject = com.tencent.mm.plugin.finder.storage.f.dqy();
      AppMethodBeat.o(287208);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class q
    implements h.b
  {
    public static final q wWg;
    
    static
    {
      AppMethodBeat.i(254235);
      wWg = new q();
      AppMethodBeat.o(254235);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(254229);
      Object localObject = com.tencent.mm.plugin.finder.storage.af.Amt;
      localObject = com.tencent.mm.plugin.finder.storage.af.dqy();
      AppMethodBeat.o(254229);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.conv.j>
  {
    public static final s wWi;
    
    static
    {
      AppMethodBeat.i(282223);
      wWi = new s();
      AppMethodBeat.o(282223);
    }
    
    s()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    public static final t wWj;
    
    static
    {
      AppMethodBeat.i(165067);
      wWj = new t();
      AppMethodBeat.o(165067);
    }
    
    t()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "canGotoFinderPage", "", "onDone"})
  static final class u
    implements ae.a
  {
    u(PluginFinder paramPluginFinder, Intent paramIntent, Context paramContext) {}
    
    public final void oa(boolean paramBoolean)
    {
      AppMethodBeat.i(280502);
      if (paramBoolean)
      {
        Intent localIntent = paramIntent;
        if (localIntent == null) {
          kotlin.g.b.p.iCn();
        }
        localIntent.putExtra("key_finder_teen_mode_check", false);
        this.wVS.enterFinderProfileUI(paramContext, paramIntent);
      }
      AppMethodBeat.o(280502);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    v(PluginFinder paramPluginFinder, long paramLong, String paramString, int paramInt, Context paramContext, Intent paramIntent)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "canGotoFinderPage", "", "onDone"})
  static final class w
    implements ae.a
  {
    w(PluginFinder paramPluginFinder, Intent paramIntent, Context paramContext) {}
    
    public final void oa(boolean paramBoolean)
    {
      AppMethodBeat.i(290400);
      if (paramBoolean)
      {
        Intent localIntent = localIntent;
        if (localIntent == null) {
          kotlin.g.b.p.iCn();
        }
        localIntent.putExtra("key_finder_teen_mode_check", false);
        this.wVS.enterFinderShareFeedUI(paramContext, localIntent);
      }
      AppMethodBeat.o(290400);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class x
    extends IListener<fw>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.service.a>
  {
    public static final y wWq;
    
    static
    {
      AppMethodBeat.i(288509);
      wWq = new y();
      AppMethodBeat.o(288509);
    }
    
    y()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderSyncEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class z
    extends IListener<is>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder
 * JD-Core Version:    0.7.0.1
 */