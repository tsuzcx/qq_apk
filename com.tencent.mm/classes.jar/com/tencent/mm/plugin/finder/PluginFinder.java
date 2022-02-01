package com.tencent.mm.plugin.finder;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.lifecycle.aj;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.ac.b;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.a.jo;
import com.tencent.mm.autogen.a.jt;
import com.tencent.mm.autogen.a.zo;
import com.tencent.mm.autogen.b.cz;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.e;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.cgi.cv;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.extension.reddot.m.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderCreateAccountStarterActivity;
import com.tencent.mm.plugin.finder.live.report.q.ca;
import com.tencent.mm.plugin.finder.live.report.q.cc;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.megavideo.floatball.b.a.a;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.g;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.m;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.service.g.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.t.a;
import com.tencent.mm.plugin.finder.trim.b.c;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.FinderCreateAccountStarter.createResultEvent.1;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.au;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.ax;
import com.tencent.mm.plugin.finder.video.f.d;
import com.tencent.mm.plugin.finder.video.f.f;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ba;
import com.tencent.mm.plugin.findersdk.a.bb;
import com.tencent.mm.plugin.findersdk.a.bc;
import com.tencent.mm.plugin.findersdk.a.bd;
import com.tencent.mm.plugin.findersdk.a.be;
import com.tencent.mm.plugin.findersdk.a.bf;
import com.tencent.mm.plugin.findersdk.a.bg;
import com.tencent.mm.plugin.findersdk.a.bi;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.bm;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.bq;
import com.tencent.mm.plugin.findersdk.a.br;
import com.tencent.mm.plugin.findersdk.a.bt;
import com.tencent.mm.plugin.findersdk.a.bv;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.bz;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.cb;
import com.tencent.mm.plugin.findersdk.a.cd;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cn.a;
import com.tencent.mm.plugin.findersdk.a.co;
import com.tencent.mm.plugin.messenger.foundation.a.z.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.protocal.protobuf.fby;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.PluginSupportUIC;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.af;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.wcdb.database.SQLiteException;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/ui/component/PluginSupportUIC;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder;", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinderImage;", "Lcom/tencent/mm/kernel/api/ICoreStorageCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/app/IAppForegroundListener;", "()V", "CURRENT_DB_VERSION", "", "kotlin.jvm.PlatformType", "CURRENT_DB_VERSION_DEFAULT", "FINDER_FOLDER_LRU_EXPIRE", "", "getFINDER_FOLDER_LRU_EXPIRE", "()J", "FINDER_FOLDER_MAX_SIZE", "getFINDER_FOLDER_MAX_SIZE", "accountStarter", "Lcom/tencent/mm/plugin/finder/utils/FinderCreateAccountStarter;", "actionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "appForegroundListener", "com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1;", "closeFinderEntryForDebug", "", "contactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getDataDB", "()Lcom/tencent/mm/storagebase/SqliteDB;", "setDataDB", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "draftStorage", "Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorage;", "entryConfigChangeListener", "com/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$entryConfigChangeListener$1;", "feedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "findDelFansService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderDelFansService;", "finderAgreeSavePhone", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderAgreeSavePhone;", "finderCommonService", "Lcom/tencent/mm/plugin/FinderCommonService;", "finderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "finderContactService", "Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "getFinderContactService", "()Lcom/tencent/mm/plugin/finder/service/FinderContactService;", "finderContactService$delegate", "Lkotlin/Lazy;", "finderEnterPersonalMsgService", "Lcom/tencent/mm/plugin/finder/service/FinderEnterPersonalMsgService;", "finderExternalMultiTaskService", "Lcom/tencent/mm/plugin/finder/service/FinderExternalMultiTaskService;", "finderFeedDetailService", "Lcom/tencent/mm/plugin/finder/service/FinderFeedDetailService;", "finderGlobalPushNewXmlConsumer", "Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer;", "getFinderGlobalPushNewXmlConsumer", "()Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer;", "finderGlobalPushNewXmlConsumer$delegate", "finderMentionDB", "getFinderMentionDB", "setFinderMentionDB", "finderMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "finderModBlockPosterSetting", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModBlockPosterService;", "finderModOverSeaAgree", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModOverSeaAgree;", "finderMultiTaskService", "Lcom/tencent/mm/plugin/finder/service/FinderMultiTaskService;", "finderOrAliasDeletingStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderOrAliasDeletingInfoStorage;", "finderPrivateSysMsgConsumer", "Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "finderPromotionConsumer", "Lcom/tencent/mm/plugin/finder/newxml/FinderPromotionConsumer;", "finderReInitSysMsgConsumer", "Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer;", "finderSharePreloadService", "Lcom/tencent/mm/plugin/finder/preload/FinderShareInfoService;", "finderShowInBizService", "Lcom/tencent/mm/plugin/finder/service/FinderShowInBizService;", "finderSnsKeyWordService", "Lcom/tencent/mm/plugin/finder/service/FinderSnsKeyWordsService;", "getFinderSnsKeyWordService", "()Lcom/tencent/mm/plugin/finder/service/FinderSnsKeyWordsService;", "finderSnsKeyWordService$delegate", "finderSnsKeyWordsJumpConsumer", "Lcom/tencent/mm/plugin/finder/newxml/FinderSnsKeyWordsJumpConsumer;", "finderSyncEventListener", "com/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$finderSyncEventListener$1;", "finderTeenModeConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "getFinderTeenModeConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;", "finderTeenModeConfig$delegate", "finderTeenModeEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTeenModeChangeEvent;", "finderUtilApi", "Lcom/tencent/mm/plugin/finder/utils/FinderUtilApi;", "finderWebSearchService", "Lcom/tencent/mm/plugin/finder/webview/search/FinderWebSearchService;", "followTlSingleExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "getFollowTlSingleExecutor", "()Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "followTlSingleExecutor$delegate", "isDoSomethingCompleted", "isFriendCache", "Ljava/util/concurrent/ConcurrentHashMap;", "lastFinderInitTime", "lastReportTime", "localLikeFeedStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperationStorage;", "lock", "", "mainProcForegroundListener", "com/tencent/mm/plugin/finder/PluginFinder$mainProcForegroundListener$1", "Lcom/tencent/mm/plugin/finder/PluginFinder$mainProcForegroundListener$1;", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "mediaPreloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getMediaPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "mediaPreloadModel$delegate", "messageDB", "getMessageDB", "setMessageDB", "messageStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMessageStorage;", "modifyBlackListService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyBlackListService;", "modifyFeedSettingService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "modifyFinderFeedProduce", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModFeedReproduce;", "modifyFinderMessageService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModMessageSetting;", "modifyFinderMessageSessionService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderMsgSessionMuteSetting;", "modifyFinderWxMessageSessionService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderWxMsgSessionMuteSetting;", "modifyLikeRecommendService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModRecommendSetting;", "modifyPersonalizedService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModPersonalizedSetting;", "modifyProfileStickyService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModProfileSticky;", "modifyUserService", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyUserService;", "msgAliasContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "msgStrangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "needResetDb", "newXmlStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderNewXmlDataStorage;", "privateMsgConfig", "Lcom/tencent/mm/plugin/finder/conv/FinderPrivateMsgConfig;", "getPrivateMsgConfig", "()Lcom/tencent/mm/plugin/finder/conv/FinderPrivateMsgConfig;", "privateMsgConfig$delegate", "redDotCtrInfoStorage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "shareInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderShareInfoStorage;", "snsKeyWordsStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSnsKeyWordsStorage;", "startActivityEvent", "Lcom/tencent/mm/autogen/events/StartActivityEvent;", "syncExtension", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncExtension;", "wxMentionDB", "getWxMentionDB", "setWxMentionDB", "wxMentionStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "canEnterMvAndShowToast", "checkAccountDeletingTask", "", "checkIfSameMsgTableName", "checkResetDb", "clearFinderCacheOnTeenModeEnter", "clearFinderRedDot", "redDotStr", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "clearMentionDB", "clearReInit", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "collectFinderDatabaseFactory", "Lkotlin/collections/HashMap;", "collectMentionDatabaseFactory", "collectMessageDatabaseFactory", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "createAccount", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "json", "createMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "finderMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "finderFeedId", "findBest", "dependency", "doFinderInit", "doPrepareUser", "doReInit", "reInitVersion", "reInitUsername", "doSomethingImportantOnStart", "dumpAndMarkFinderFolder", "enterAlbumRelatedTimelineUI", "enterFinderActivityProfileUI", "enterFinderConversationUI", "enterFinderFollowListUI", "enterFinderGallery", "activity", "requestCode", "enterFinderHotWordUI", "enterFinderLiveIncome", "enterFinderLiveLottery", "enterFinderPoiFeedUI", "enterFinderPostRouterUI", "enterFinderPostUI", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPostCallbackApi;", "enterFinderProfileUI", "enterFinderSelfProfile", "enter", "enterType", "enterFinderSelfUI", "enterFinderShareFeedUI", "i", "enterFinderShop", "enterFinderTimelineUI", "needPreFectch", "enterFinderTopicTimelineUI", "enterFinderTopicUI", "jsObj", "enterFinderUI", "enterFinderUIFromMiniApp", "succCallback", "", "failedCallback", "execute", "fillContextIdToIntent", "toCommentScene", "newContextId", "genContextId", "getContactStorage", "getConversationStorage", "getDB", "getDraftStorage", "getFeedStorage", "getFinderActionStorage", "getFinderContactCache", "getFinderContext", "getFinderOpenSdkApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderOpenSdkApi;", "getFinderOrAliasDeletingInfoStorage", "getFinderRedDot", "getFinderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isShareSns", "getFinderSwitchApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSwitchApi;", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getFinderUIApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUIApi;", "getFinderUtilApi", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi;", "getIncomePageInfoAndEnterIncome", "getLocalLikeFeedStorage", "getMediaCacheStorage", "getMentionStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "localFlag", "getMessageStorage", "getMsgAliasContactStorage", "getMsgStrangerContactStorage", "getNewXmlStorage", "getRedDotCtrInfoStorage", "getRedDotManager", "getSessionInfoStorage", "getShareInfoStorage", "getSnsKeyWordsStorage", "getTimelineCommentScene", "handleCommentDetailResult", "errorCode", "errorMsg", "hasFinderPosted", "isAllowEditFillingFullScreen", "isDisablePostHalfScreen", "isFriend", "username", "isInFinder", "isNeedDoReInit", "isPagEnable", "()Ljava/lang/Boolean;", "loadAvatar", "url", "avatarIv", "Landroid/widget/ImageView;", "loadImage", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlToken", "decodeKey", "imageView", "call", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "loadImageForSns", "qImageView", "Landroid/view/View;", "loadNotWxUrlImage", "imageview", "loadRingtoneBgImage", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onAppBackground", "onAppForeground", "onDataBaseClosed", "readOnlyDB", "onDataBaseOpened", "onEnterFinder", "finder", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "onExitFinder", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "openChannelsPostPage", "Landroid/app/Activity;", "openFinderFeed", "extInfo", "Lcom/tencent/mm/json/JSONObject;", "appid", "isFromWeApp", "openFinderLiveOperationUI", "openFinderLiveOperationUIFromJSAPI", "openFinderLiveOperationUIInternal", "requestScene", "useDarkStyle", "selectTabId", "selectSecondTabId", "byPass", "entryScene", "feedExportId", "feedNonceId", "pageTitle", "openFinderProfile", "refreshXLabConfigToMMKV", "registerTeenModeGuardian", "report21053", "recyclerView", "adapter", "Landroid/widget/BaseAdapter;", "visibleState", "firstVisibleItem", "visibleItemCount", "actionType", "commentscene", "event", "headerShow", "report21053OnClick", "feedId", "liveId", "userName", "index", "onlineNum", "enterStatus", "shareType", "shareUserName", "snsFeedid", "enterTime", "report21053OnClickOnSnsAd", "pos", "reportFinderPrivateMsgTableSize", "reportGiftOnReturn", "reportPostRedDot", "key", "requestFinderObject", "objectId", "objectNonceId", "commentScene", "reserveChannelsLive", "jsonStr", "didOpenCallback", "failCallback", "resetConfig", "resetDb", "resetLastFinderInitTime", "resetLastTimelineExitTime", "sdkShare", "businessType", "set21084CommentScene", "shareStatsReport", "feedIdList", "", "Landroid/util/Pair;", "isMegaVideo", "showFinderEntranceDebugSheet", "showFinderEntry", "showPostEntry", "snsToFinderPostReport", "sessionID", "wording", "shootEntranceEndType", "entranceExposeMaxTimes", "entranceExposedTimes", "snsId", "timeStamp", "exposeType", "tryGetFinderContext", "tryGetFinderObject", "force", "needLoading", "callBack", "Lcom/tencent/mm/plugin/findersdk/api/IPluginFinder$GetFinderObjectCallback;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinder
  extends PluginSupportUIC
  implements androidx.lifecycle.ak, com.tencent.mm.am.h, com.tencent.mm.app.q, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.plugin.findersdk.a.cn, co
{
  public static final a Aro;
  private com.tencent.mm.plugin.finder.storage.x ArA;
  private com.tencent.mm.plugin.finder.storage.ag ArB;
  private com.tencent.mm.plugin.finder.storage.n ArC;
  private com.tencent.mm.plugin.finder.storage.logic.b ArD;
  private com.tencent.mm.plugin.finder.storage.u ArE;
  private com.tencent.mm.plugin.finder.extension.reddot.f ArF;
  private com.tencent.mm.plugin.finder.storage.aq ArG;
  private com.tencent.mm.plugin.finder.storage.o ArH;
  private com.tencent.mm.plugin.finder.storage.a ArI;
  private com.tencent.mm.plugin.finder.storage.t ArJ;
  private com.tencent.mm.plugin.finder.storage.an ArK;
  private com.tencent.mm.plugin.finder.storage.ad ArL;
  private final com.tencent.mm.plugin.finder.cgi.oplog.l ArM;
  private final com.tencent.mm.plugin.finder.service.e ArN;
  private final com.tencent.mm.plugin.finder.webview.search.a ArO;
  private final com.tencent.mm.plugin.finder.cgi.oplog.i ArP;
  private final com.tencent.mm.plugin.finder.cgi.oplog.f ArQ;
  private final com.tencent.mm.plugin.finder.cgi.oplog.a ArR;
  private final com.tencent.mm.plugin.finder.cgi.oplog.e ArS;
  private final com.tencent.mm.plugin.finder.cgi.oplog.d ArT;
  private final com.tencent.mm.plugin.finder.cgi.oplog.m ArU;
  private final com.tencent.mm.plugin.finder.cgi.oplog.o ArV;
  private final com.tencent.mm.plugin.finder.cgi.oplog.k ArW;
  private final com.tencent.mm.plugin.finder.cgi.oplog.j ArX;
  private final com.tencent.mm.plugin.finder.cgi.oplog.g ArY;
  private final com.tencent.mm.plugin.finder.conv.n ArZ;
  private volatile boolean Arp;
  private com.tencent.mm.storagebase.h Arq;
  private com.tencent.mm.storagebase.h Arr;
  private com.tencent.mm.storagebase.h Ars;
  private final com.tencent.mm.plugin.finder.extension.c Art;
  private com.tencent.mm.plugin.finder.storage.f Aru;
  private com.tencent.mm.plugin.finder.storage.ab Arv;
  private com.tencent.mm.plugin.finder.storage.aa Arw;
  private com.tencent.mm.plugin.finder.storage.g Arx;
  private al Ary;
  private com.tencent.mm.plugin.finder.storage.ak Arz;
  private final IListener<jt> AsA;
  private final entryConfigChangeListener.1 AsB;
  private volatile boolean AsC;
  private long AsD;
  private final b AsE;
  private final q AsF;
  private boolean AsG;
  private final ConcurrentHashMap<String, Boolean> AsH;
  private final ax AsI;
  private final kotlin.j Asa;
  private final com.tencent.mm.plugin.finder.newxml.c Asb;
  private final com.tencent.mm.plugin.finder.newxml.b Asc;
  private final com.tencent.mm.plugin.finder.newxml.d Asd;
  private final com.tencent.mm.plugin.finder.cgi.oplog.h Ase;
  private final com.tencent.mm.plugin.finder.cgi.oplog.c Asf;
  private final com.tencent.mm.plugin.finder.cgi.oplog.b Asg;
  private final com.tencent.mm.plugin.finder.service.c Ash;
  private final com.tencent.mm.plugin.finder.service.k Asi;
  private final com.tencent.mm.plugin.finder.api.b Asj;
  private final com.tencent.mm.plugin.finder.utils.l Ask;
  private com.tencent.mm.plugin.finder.extension.reddot.i Asl;
  private final kotlin.j Asm;
  private final String Asn;
  private final String Aso;
  private final kotlin.j Asp;
  private final kotlin.j Asq;
  private final finderSyncEventListener.1 Asr;
  private final kotlin.j Ass;
  private final kotlin.j Ast;
  private final kotlin.j Asu;
  private final com.tencent.mm.plugin.a Asv;
  private final com.tencent.mm.plugin.finder.service.g Asw;
  private final com.tencent.mm.plugin.finder.preload.b Asx;
  private final com.tencent.mm.plugin.finder.service.d Asy;
  private final IListener<zo> Asz;
  private long lastReportTime;
  private final byte[] lock;
  private com.tencent.mm.storagebase.h mCN;
  
  static
  {
    AppMethodBeat.i(162442);
    Aro = new a((byte)0);
    AppMethodBeat.o(162442);
  }
  
  public PluginFinder()
  {
    AppMethodBeat.i(165123);
    this.lock = new byte[0];
    this.Art = new com.tencent.mm.plugin.finder.extension.c();
    this.ArM = new com.tencent.mm.plugin.finder.cgi.oplog.l();
    this.ArN = new com.tencent.mm.plugin.finder.service.e();
    this.ArO = new com.tencent.mm.plugin.finder.webview.search.a();
    this.ArP = new com.tencent.mm.plugin.finder.cgi.oplog.i();
    this.ArQ = new com.tencent.mm.plugin.finder.cgi.oplog.f();
    this.ArR = new com.tencent.mm.plugin.finder.cgi.oplog.a();
    this.ArS = new com.tencent.mm.plugin.finder.cgi.oplog.e();
    this.ArT = new com.tencent.mm.plugin.finder.cgi.oplog.d();
    this.ArU = new com.tencent.mm.plugin.finder.cgi.oplog.m();
    this.ArV = new com.tencent.mm.plugin.finder.cgi.oplog.o();
    this.ArW = new com.tencent.mm.plugin.finder.cgi.oplog.k();
    this.ArX = new com.tencent.mm.plugin.finder.cgi.oplog.j();
    this.ArY = new com.tencent.mm.plugin.finder.cgi.oplog.g();
    this.ArZ = new com.tencent.mm.plugin.finder.conv.n();
    this.Asa = kotlin.k.cm((kotlin.g.a.a)j.AsT);
    this.Asb = new com.tencent.mm.plugin.finder.newxml.c();
    this.Asc = new com.tencent.mm.plugin.finder.newxml.b();
    this.Asd = new com.tencent.mm.plugin.finder.newxml.d();
    this.Ase = new com.tencent.mm.plugin.finder.cgi.oplog.h();
    this.Asf = new com.tencent.mm.plugin.finder.cgi.oplog.c();
    this.Asg = new com.tencent.mm.plugin.finder.cgi.oplog.b();
    this.Ash = new com.tencent.mm.plugin.finder.service.c();
    this.Asi = new com.tencent.mm.plugin.finder.service.k();
    this.Asj = new com.tencent.mm.plugin.finder.api.b();
    this.Ask = new com.tencent.mm.plugin.finder.utils.l();
    this.Asm = kotlin.k.cm((kotlin.g.a.a)m.AsW);
    this.Asn = MD5Util.getMD5String("FinderMM029.dbFinderMention001.db");
    this.Aso = MD5Util.getMD5String("FinderMM029.dbFinderMention001.db");
    this.Asp = kotlin.k.cm((kotlin.g.a.a)r.Ata);
    this.Asq = kotlin.k.cm((kotlin.g.a.a)w.Atd);
    this.Asr = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Ass = kotlin.k.cm((kotlin.g.a.a)i.AsS);
    this.Ast = kotlin.k.cm((kotlin.g.a.a)l.AsV);
    this.Asu = kotlin.k.cm((kotlin.g.a.a)k.AsU);
    this.Asv = new com.tencent.mm.plugin.a();
    this.Asw = new com.tencent.mm.plugin.finder.service.g();
    this.Asx = new com.tencent.mm.plugin.finder.preload.b();
    this.Asy = new com.tencent.mm.plugin.finder.service.d();
    this.Asz = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    this.AsA = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    this.AsB = new IListener(com.tencent.mm.app.f.hfK) {};
    this.AsE = new b(this);
    this.AsF = new q(this);
    this.AsH = new ConcurrentHashMap();
    this.AsI = new ax();
    AppMethodBeat.o(165123);
  }
  
  private final void checkAccountDeletingTask()
  {
    AppMethodBeat.i(330900);
    com.tencent.threadpool.h.ahAA.bo(new PluginFinder..ExternalSyntheticLambda28(this));
    AppMethodBeat.o(330900);
  }
  
  private static final void checkAccountDeletingTask$lambda-28(PluginFinder paramPluginFinder)
  {
    AppMethodBeat.i(331123);
    kotlin.g.b.s.u(paramPluginFinder, "this$0");
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      try
      {
        paramPluginFinder = paramPluginFinder.getFinderOrAliasDeletingInfoStorage().eZA();
        Log.i("Finder.PluginFinder", kotlin.g.b.s.X("checkAccountDeletingTask size:", Integer.valueOf(paramPluginFinder.size())));
        localObject1 = (Iterable)paramPluginFinder;
        paramPluginFinder = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
        if (((bo)localObject2).systemRowid == -1L) {
          break label145;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramPluginFinder.add(localObject2);
        continue;
        AppMethodBeat.o(331123);
      }
      catch (Exception paramPluginFinder)
      {
        Log.i("Finder.PluginFinder", kotlin.g.b.s.X("checkAccountDeletingTask Exception:", paramPluginFinder.getMessage()));
        localObject1 = av.GiL;
        if (!av.bgV()) {
          break label305;
        }
      }
      throw paramPluginFinder;
      label145:
      int i = 0;
    }
    paramPluginFinder = ((Iterable)paramPluginFinder).iterator();
    if (paramPluginFinder.hasNext())
    {
      localObject1 = (bo)paramPluginFinder.next();
      Log.i("Finder.PluginFinder", "checkAccountDeletingTask del username = " + ((bo)localObject1).field_username + ", type:" + ((bo)localObject1).field_type);
      switch (((bo)localObject1).field_type)
      {
      }
    }
    for (;;)
    {
      Log.i("Finder.PluginFinder", kotlin.g.b.s.X("checkAccountDeletingTask unknown type:", Integer.valueOf(((bo)localObject1).field_type)));
      break;
      localObject2 = av.GiL;
      av.a("checkAccountDeletingTask", (bo)localObject1);
      break;
      localObject2 = av.GiL;
      av.b("checkAccountDeletingTask", (bo)localObject1);
      break;
      AppMethodBeat.o(331123);
      return;
      label305:
      AppMethodBeat.o(331123);
      return;
    }
  }
  
  private final void checkIfSameMsgTableName()
  {
    AppMethodBeat.i(330827);
    Object localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.addv, "");
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(330827);
      throw ((Throwable)localObject1);
    }
    localObject1 = (String)localObject1;
    Object localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.addw, "");
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(330827);
      throw ((Throwable)localObject1);
    }
    localObject2 = (String)localObject2;
    if (((CharSequence)localObject1).length() > 0)
    {
      i = 1;
      if ((i != 0) && (!kotlin.g.b.s.p(localObject1, cz.ktM)))
      {
        localObject1 = av.GiL;
        av.fge();
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label176;
      }
    }
    label176:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!kotlin.g.b.s.p(localObject2, cz.ktN)))
      {
        localObject1 = av.GiL;
        av.fgf();
      }
      AppMethodBeat.o(330827);
      return;
      i = 0;
      break;
    }
  }
  
  private final void checkResetDb()
  {
    AppMethodBeat.i(165077);
    Log.v("Finder.PluginFinder", kotlin.g.b.s.X("checkResetDb1 ", Boolean.valueOf(this.Arp)));
    if (this.Arp)
    {
      Log.v("Finder.PluginFinder", kotlin.g.b.s.X("checkResetDb2 ", Boolean.valueOf(this.Arp)));
      synchronized (this.lock)
      {
        Log.i("Finder.PluginFinder", "checkResetDb  need reset DB now " + Thread.currentThread().getName() + ' ' + Thread.currentThread().getId() + ' ' + hashCode());
        if (this.Arp)
        {
          resetDb();
          this.Arp = false;
          Log.i("Finder.PluginFinder", "resetDB done");
        }
        ah localah = ah.aiuX;
        AppMethodBeat.o(165077);
        return;
      }
    }
    AppMethodBeat.o(165077);
  }
  
  private final void clearFinderCacheOnTeenModeEnter()
  {
    AppMethodBeat.i(330785);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = ((Iterable)((com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).EVR).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.finder.preload.tabPreload.g)((Iterator)localObject).next()).ta(true);
      }
      localObject = com.tencent.mm.plugin.finder.storage.data.k.FNg;
      k.a.clearAll();
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).resetCache();
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.n)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.n.class)).resetCache();
      localObject = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotManager");
        AppMethodBeat.o(330785);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).dZp();
      ((com.tencent.mm.plugin.findersdk.a.y)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.y.class)).ePr();
    }
    AppMethodBeat.o(330785);
  }
  
  private final void clearMentionDB()
  {
    AppMethodBeat.i(165079);
    String str = com.tencent.mm.kernel.h.baE().cachePath;
    com.tencent.mm.vfs.y.deleteFile(kotlin.g.b.s.X(str, "FinderMention001.db"));
    com.tencent.mm.vfs.y.deleteFile(kotlin.g.b.s.X(str, "FinderMention002.db"));
    this.Arq = null;
    this.Arr = null;
    AppMethodBeat.o(165079);
  }
  
  private final void clearReInit()
  {
    AppMethodBeat.i(165094);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adcW, Integer.valueOf(0));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adcX, "");
    AppMethodBeat.o(165094);
  }
  
  private static final String[] collectDatabaseFactory$lambda-6()
  {
    AppMethodBeat.i(331018);
    Object localObject = com.tencent.mm.plugin.finder.storage.x.FLI;
    kotlin.g.b.s.u("findermessage006", "table");
    localObject = com.tencent.mm.plugin.byp.b.wag;
    localObject = MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.byp.b.access$getInfo$cp(), "findermessage006");
    kotlin.g.b.s.s(localObject, "getCreateSQLs(BypMsgInfo.info, table)");
    String str1 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "SvrIdIndex ON " + "findermessage006" + " ( msgSvrId )";
    String str2 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerIndex ON " + "findermessage006" + " ( talker )";
    String str3 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerStatusIndex ON " + "findermessage006" + " ( talker,status )";
    String str4 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "CreateTimeIndex ON " + "findermessage006" + " ( createTime )";
    String str5 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "CreateTalkerTimeIndex ON " + "findermessage006" + " ( talker,createTime )";
    String str6 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "SendCreateTimeIndex ON " + "findermessage006" + " ( status,isSend,createTime )";
    String str7 = "CREATE INDEX IF NOT EXISTS  " + "findermessage006" + "TalkerTypeIndex ON " + "findermessage006" + " ( talker,type )";
    AppMethodBeat.o(331018);
    return new String[] { localObject, str1, str2, str3, str4, str5, str6, str7 };
  }
  
  private final HashMap<Integer, h.b> collectFinderDatabaseFactory()
  {
    AppMethodBeat.i(330839);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_CONTACT_TABLE".hashCode()), PluginFinder..ExternalSyntheticLambda2.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FinderMsgContactStorage".hashCode()), PluginFinder..ExternalSyntheticLambda16.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FinderMsgAliasContactStorage".hashCode()), PluginFinder..ExternalSyntheticLambda9.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FEED_TABLE".hashCode()), PluginFinder..ExternalSyntheticLambda19.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_DRAFT_TABLE".hashCode()), PluginFinder..ExternalSyntheticLambda15.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FinderMediaCacheInfoV2".hashCode()), PluginFinder..ExternalSyntheticLambda18.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FinderRedDotInfo".hashCode()), PluginFinder..ExternalSyntheticLambda13.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FinderShareInfo".hashCode()), PluginFinder..ExternalSyntheticLambda3.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FinderAction".hashCode()), PluginFinder..ExternalSyntheticLambda7.INSTANCE);
    Object localObject = (Map)localHashMap;
    t.a locala = com.tencent.mm.plugin.finder.storage.t.FKW;
    ((Map)localObject).put(Integer.valueOf(com.tencent.mm.plugin.finder.storage.t.eZu().hashCode()), PluginFinder..ExternalSyntheticLambda14.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FinderSnsKeyWordsJumpConfig".hashCode()), PluginFinder..ExternalSyntheticLambda10.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FinderConsumeNewXmlData".hashCode()), PluginFinder..ExternalSyntheticLambda11.INSTANCE);
    localObject = com.tencent.d.a.a.a.b.ahiV;
    localHashMap.putAll((Map)com.tencent.d.a.a.a.b.a.jRx());
    AppMethodBeat.o(330839);
    return localHashMap;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-10()
  {
    AppMethodBeat.i(331033);
    Object localObject = com.tencent.mm.plugin.finder.storage.n.FKF;
    localObject = com.tencent.mm.plugin.finder.storage.n.dZh();
    AppMethodBeat.o(331033);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-11()
  {
    AppMethodBeat.i(331039);
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.b.FNy;
    localObject = com.tencent.mm.plugin.finder.storage.logic.b.dZh();
    AppMethodBeat.o(331039);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-12()
  {
    AppMethodBeat.i(331043);
    Object localObject = com.tencent.mm.plugin.finder.storage.u.FKX;
    localObject = com.tencent.mm.plugin.finder.storage.u.dZh();
    AppMethodBeat.o(331043);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-13()
  {
    AppMethodBeat.i(331047);
    Object localObject = com.tencent.mm.plugin.finder.extension.reddot.f.AQh;
    localObject = com.tencent.mm.plugin.finder.extension.reddot.f.dZh();
    AppMethodBeat.o(331047);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-14()
  {
    AppMethodBeat.i(331052);
    Object localObject = al.FMu;
    localObject = al.dZh();
    AppMethodBeat.o(331052);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-15()
  {
    AppMethodBeat.i(331059);
    Object localObject = com.tencent.mm.plugin.finder.storage.a.FAm;
    localObject = com.tencent.mm.plugin.finder.storage.a.dZh();
    AppMethodBeat.o(331059);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-16()
  {
    AppMethodBeat.i(331062);
    Object localObject = com.tencent.mm.plugin.finder.storage.t.FKW;
    localObject = com.tencent.mm.plugin.finder.storage.t.dZh();
    AppMethodBeat.o(331062);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-17()
  {
    AppMethodBeat.i(331066);
    Object localObject = com.tencent.mm.plugin.finder.storage.an.FMw;
    localObject = com.tencent.mm.plugin.finder.storage.an.dZh();
    AppMethodBeat.o(331066);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-18()
  {
    AppMethodBeat.i(331070);
    Object localObject = com.tencent.mm.plugin.finder.storage.ad.FLZ;
    localObject = com.tencent.mm.plugin.finder.storage.ad.dZh();
    AppMethodBeat.o(331070);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-7()
  {
    AppMethodBeat.i(331021);
    Object localObject = com.tencent.mm.plugin.finder.storage.f.FJW;
    localObject = com.tencent.mm.plugin.finder.storage.f.dZh();
    AppMethodBeat.o(331021);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-8()
  {
    AppMethodBeat.i(331025);
    Object localObject = com.tencent.mm.plugin.finder.storage.ab.FLW;
    localObject = com.tencent.mm.plugin.finder.storage.ab.dZh();
    AppMethodBeat.o(331025);
    return localObject;
  }
  
  private static final String[] collectFinderDatabaseFactory$lambda-9()
  {
    AppMethodBeat.i(331029);
    Object localObject = com.tencent.mm.plugin.finder.storage.aa.FLV;
    localObject = com.tencent.mm.plugin.finder.storage.aa.dZh();
    AppMethodBeat.o(331029);
    return localObject;
  }
  
  private final HashMap<Integer, h.b> collectMentionDatabaseFactory()
  {
    AppMethodBeat.i(165081);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FINDER_FINDER_MENTION_TABLE".hashCode()), PluginFinder..ExternalSyntheticLambda17.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FINDER_WX_MENTION_TABLE".hashCode()), PluginFinder..ExternalSyntheticLambda12.INSTANCE);
    AppMethodBeat.o(165081);
    return localHashMap;
  }
  
  private static final String[] collectMentionDatabaseFactory$lambda-19()
  {
    AppMethodBeat.i(331076);
    Object localObject = com.tencent.mm.plugin.finder.storage.o.FKK;
    localObject = com.tencent.mm.plugin.finder.storage.o.dZh();
    AppMethodBeat.o(331076);
    return localObject;
  }
  
  private static final String[] collectMentionDatabaseFactory$lambda-20()
  {
    AppMethodBeat.i(331079);
    Object localObject = com.tencent.mm.plugin.finder.storage.aq.FMz;
    localObject = com.tencent.mm.plugin.finder.storage.aq.dZh();
    AppMethodBeat.o(331079);
    return localObject;
  }
  
  private final HashMap<Integer, h.b> collectMessageDatabaseFactory()
  {
    AppMethodBeat.i(330851);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("FinderConversation".hashCode()), PluginFinder..ExternalSyntheticLambda6.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FinderSessionInfo".hashCode()), PluginFinder..ExternalSyntheticLambda4.INSTANCE);
    ((Map)localHashMap).put(Integer.valueOf("FinderOrAliasDeletingInfo".hashCode()), PluginFinder..ExternalSyntheticLambda5.INSTANCE);
    AppMethodBeat.o(330851);
    return localHashMap;
  }
  
  private static final String[] collectMessageDatabaseFactory$lambda-21()
  {
    AppMethodBeat.i(331085);
    Object localObject = com.tencent.mm.plugin.finder.storage.g.FJX;
    localObject = com.tencent.mm.plugin.finder.storage.g.dZh();
    AppMethodBeat.o(331085);
    return localObject;
  }
  
  private static final String[] collectMessageDatabaseFactory$lambda-22()
  {
    AppMethodBeat.i(331089);
    Object localObject = com.tencent.mm.plugin.finder.storage.ak.FMl;
    localObject = com.tencent.mm.plugin.finder.storage.ak.dZh();
    AppMethodBeat.o(331089);
    return localObject;
  }
  
  private static final String[] collectMessageDatabaseFactory$lambda-23()
  {
    AppMethodBeat.i(331095);
    Object localObject = com.tencent.mm.plugin.finder.storage.ag.FMg;
    localObject = com.tencent.mm.plugin.finder.storage.ag.dZh();
    AppMethodBeat.o(331095);
    return localObject;
  }
  
  private final void doFinderInit()
  {
    AppMethodBeat.i(165088);
    Log.i("Finder.PluginFinder", "[doFinderInit] ...");
    this.AsD = System.currentTimeMillis();
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new cv(), 0);
    AppMethodBeat.o(165088);
  }
  
  private final void doPrepareUser()
  {
    AppMethodBeat.i(165091);
    Log.i("Finder.PluginFinder", "[doPrepareUser]... ");
    di localdi = new di(1);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localdi, 0);
    AppMethodBeat.o(165091);
  }
  
  private final void doReInit(int paramInt, String paramString)
  {
    AppMethodBeat.i(165090);
    try
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 21L, 1L);
      Object localObject = com.tencent.mm.plugin.finder.storage.data.g.FMY;
      com.tencent.mm.plugin.finder.storage.data.g.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.k.FNg;
      k.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.b.FMJ;
      com.tencent.mm.plugin.finder.storage.data.b.a.clearAll();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbu, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbv, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adds, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addx, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addy, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addz, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addA, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addB, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addC, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addF, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addG, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addH, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addI, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addJ, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adaB, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbs, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcY, Integer.valueOf(paramInt));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZR, paramString);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addK, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addL, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcK, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcZ, Integer.valueOf(0));
      paramInt = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adda, 0);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adda, Integer.valueOf(paramInt + 1));
      clearReInit();
      Log.i("Finder.PluginFinder", kotlin.g.b.s.X("[doReInit] reInit done. incrementId=", Integer.valueOf(paramInt + 1)));
      AppMethodBeat.o(165090);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("Finder.PluginFinder", (Throwable)paramString, "do ReInit occur error!", new Object[0]);
      com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 22L, 1L);
      AppMethodBeat.o(165090);
    }
  }
  
  private final void doSomethingImportantOnStart()
  {
    AppMethodBeat.i(330868);
    this.AsB.alive();
    if (this.AsC)
    {
      AppMethodBeat.o(330868);
      return;
    }
    boolean bool2 = showFinderEntry();
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVe().bmg()).intValue() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("Finder.PluginFinder", "[doSomethingImportantOnStart] " + com.tencent.mm.model.z.bAW() + " isDoSomethingCompleted=" + this.AsC + ", isShowFinderEntry=" + bool2 + " FIX_REINIT_SELECTOR_ENABLE_VALUE=" + bool1);
      if (bool2) {
        break;
      }
      AppMethodBeat.o(330868);
      return;
    }
    this.AsC = true;
    bool2 = isNeedDoReInit();
    if (!Util.isNullOrNil(com.tencent.mm.model.z.bAW())) {
      com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 34L, 1L);
    }
    if (bool2)
    {
      int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcW, 0);
      localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adcX, "");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(330868);
        throw ((Throwable)localObject);
      }
      doReInit(i, (String)localObject);
      doPrepareUser();
      if (!bool1) {
        this.Art.a(113661, 6, null);
      }
    }
    for (;;)
    {
      if (bool1) {
        this.Art.a(113661, 6, null);
      }
      try
      {
        getRedDotManager().prepare();
        AppMethodBeat.o(330868);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("Finder.PluginFinder", (Throwable)localException, "reddot prepare", new Object[0]);
        AppMethodBeat.o(330868);
      }
      if (Util.isNullOrNil(com.tencent.mm.model.z.bAW()))
      {
        com.tencent.mm.kernel.h.aZW().a(3930, (com.tencent.mm.am.h)this);
        com.tencent.mm.kernel.h.aZW().a(3930, (com.tencent.mm.am.h)getRedDotManager());
        doFinderInit();
        if (!bool1) {
          this.Art.a(113149, 6, null);
        }
      }
    }
  }
  
  private final com.tencent.mm.plugin.finder.service.a getFinderContactService()
  {
    AppMethodBeat.i(330762);
    com.tencent.mm.plugin.finder.service.a locala = (com.tencent.mm.plugin.finder.service.a)this.Ass.getValue();
    AppMethodBeat.o(330762);
    return locala;
  }
  
  private final com.tencent.mm.plugin.finder.service.l getFinderSnsKeyWordService()
  {
    AppMethodBeat.i(330774);
    com.tencent.mm.plugin.finder.service.l locall = (com.tencent.mm.plugin.finder.service.l)this.Asu.getValue();
    AppMethodBeat.o(330774);
    return locall;
  }
  
  private final com.tencent.mm.plugin.finder.storage.ap getFinderTeenModeConfig()
  {
    AppMethodBeat.i(330767);
    com.tencent.mm.plugin.finder.storage.ap localap = (com.tencent.mm.plugin.finder.storage.ap)this.Ast.getValue();
    AppMethodBeat.o(330767);
    return localap;
  }
  
  private final com.tencent.mm.plugin.finder.conv.m getPrivateMsgConfig()
  {
    AppMethodBeat.i(330753);
    com.tencent.mm.plugin.finder.conv.m localm = (com.tencent.mm.plugin.finder.conv.m)this.Asq.getValue();
    AppMethodBeat.o(330753);
    return localm;
  }
  
  private final void handleCommentDetailResult(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(330977);
    String str = "";
    switch (paramInt)
    {
    default: 
      paramString = str;
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        paramString = paramContext.getResources().getString(e.h.finder_create_contact_failed_tip);
        kotlin.g.b.s.s(paramString, "context.resources.getStr…reate_contact_failed_tip)");
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.ui.base.aa.makeText(paramContext, (CharSequence)paramString, 0).show();
      AppMethodBeat.o(330977);
      return;
      str = paramString;
      if (paramString == null)
      {
        str = paramContext.getResources().getString(e.h.finder_feed_deleted_tip);
        kotlin.g.b.s.s(str, "context.resources.getStr….finder_feed_deleted_tip)");
      }
      paramString = str;
      break;
      str = paramString;
      if (paramString == null)
      {
        str = paramContext.getResources().getString(e.h.finder_feed_self_see_tip);
        kotlin.g.b.s.s(str, "context.resources.getStr…finder_feed_self_see_tip)");
      }
      paramString = str;
      break;
      str = paramString;
      if (paramString == null)
      {
        str = paramContext.getResources().getString(e.h.finder_set_privacy_tips);
        kotlin.g.b.s.s(str, "context.resources.getStr….finder_set_privacy_tips)");
      }
      paramString = str;
      break;
    }
  }
  
  private final boolean isNeedDoReInit()
  {
    AppMethodBeat.i(330808);
    int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcZ, -1);
    int k = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcY, 0);
    int m = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcW, 0);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adcX, "");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(330808);
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
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adcZ, Integer.valueOf(1));
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
      AppMethodBeat.o(330808);
      return true;
    }
    AppMethodBeat.o(330808);
    return false;
  }
  
  private static final void loadImage$lambda-38(kotlin.g.a.b paramb, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(331139);
    kotlin.g.b.s.u(paramb, "$call");
    if (paramBitmap != null) {
      paramb.invoke(paramBitmap);
    }
    AppMethodBeat.o(331139);
  }
  
  private static final void loadImageForSns$lambda-2(View paramView, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(330999);
    kotlin.g.b.s.u(paramView, "$qImageView");
    if (paramBitmap != null)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new p(paramView, paramBitmap.copy(paramBitmap.getConfig(), true)));
      AppMethodBeat.o(330999);
      return;
    }
    Log.i("Finder.PluginFinder", "setBlurBitmap error, result is null!");
    AppMethodBeat.o(330999);
  }
  
  private static final void onAccountInitialized$lambda-24()
  {
    AppMethodBeat.i(331099);
    com.tencent.mm.plugin.finder.upload.b.a locala = com.tencent.mm.plugin.finder.upload.b.Gbu;
    com.tencent.mm.plugin.finder.upload.b.fdT().fdz();
    AppMethodBeat.o(331099);
  }
  
  private static final void onExitFinder$lambda-29()
  {
    AppMethodBeat.i(331132);
    ((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).hG(true);
    AppMethodBeat.o(331132);
  }
  
  private final void openFinderFeed(com.tencent.mm.ad.i parami, Context paramContext, ca.a<Object> parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(330955);
    String str1 = parami.optString("feedID");
    String str2 = parami.optString("nonceID");
    boolean bool;
    int i1;
    Object localObject3;
    int i2;
    Object localObject1;
    int n;
    Object localObject2;
    int i;
    label108:
    int i3;
    int j;
    if (parami.optInt("notGetReleatedList") == 0)
    {
      bool = true;
      i1 = parami.optInt("shareScene", 0);
      localObject3 = parami.optString("sessionId", "");
      i2 = parami.optInt("requestScene", 3);
      localObject1 = parami.optString("reportExtraInfo", "");
      n = parami.optInt("commentScene", 0);
      localObject2 = av.GiL;
      if (!av.aBT((String)localObject1)) {
        break label232;
      }
      i = 42;
      i3 = parami.optInt("adJSAPIType", 0);
      localObject2 = parami.optString("userName", "");
      parami = (bq)com.tencent.mm.kernel.h.ax(bq.class);
      if ((!parami.eHE()) || (!parami.bZX()) || (n != 26)) {
        break label239;
      }
      j = 1;
      label168:
      if (j == 0) {
        break label1066;
      }
    }
    label287:
    label297:
    label1066:
    for (int k = 20;; k = i)
    {
      parami = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      i = com.tencent.mm.plugin.findersdk.d.a.aDh("entrance");
      if (i != 0)
      {
        parami = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.hc(paramContext);
        Log.i("Finder.PluginFinder", kotlin.g.b.s.X("[openFinderFeed] spamAction:", Integer.valueOf(i)));
        AppMethodBeat.o(330955);
        return;
        bool = false;
        break;
        label232:
        i = 39;
        break label108;
        label239:
        j = 0;
        break label168;
      }
      parami = av.GiL;
      int m;
      if (av.aBT((String)localObject1))
      {
        m = 4;
        if (n == 0)
        {
          parami = av.GiL;
          if (av.Uo(i1) == -1) {
            break label420;
          }
        }
        if (n == 0) {
          break label406;
        }
        i = n;
        if (36 != n) {
          break label426;
        }
        n = 1;
        parami = com.tencent.mm.plugin.finder.report.n.FpH;
        parami = com.tencent.mm.plugin.finder.report.n.eMA();
        if (i3 != 1) {
          break label454;
        }
        paramString = new Intent();
        if (n == 0) {
          break label438;
        }
        localObject3 = (CharSequence)parami;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label432;
        }
        j = 1;
        label349:
        if (j != 0) {
          break label438;
        }
        paramString.putExtra("key_context_id", parami);
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.ad.d.n.a(paramString, paramContext, (String)localObject2, str2, str1, (String)localObject1);
        if (parama != null) {
          parama.onCallback(Integer.valueOf(0));
        }
        AppMethodBeat.o(330955);
        return;
        m = 2;
        break;
        parami = av.GiL;
        i = av.Uo(i1);
        break label287;
        i = 0;
        break label287;
        label426:
        n = 0;
        break label297;
        label432:
        j = 0;
        break label349;
        label438:
        fillContextIdToIntent(i, m, k, paramString);
      }
      label454:
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("from_user", com.tencent.mm.model.z.bAM());
      ((Intent)localObject2).putExtra("feed_encrypted_object_id", str1);
      ((Intent)localObject2).putExtra("feed_object_nonceId", str2);
      ((Intent)localObject2).putExtra("key_need_related_list", bool);
      ((Intent)localObject2).putExtra("key_comment_scene", k);
      ((Intent)localObject2).putExtra("key_reuqest_scene", i2);
      ((Intent)localObject2).putExtra("key_session_id", (String)localObject3);
      ((Intent)localObject2).putExtra("key_extra_info", (String)localObject1);
      if (paramBoolean) {
        ((Intent)localObject2).putExtra("KEY_FROM_SOURCE", "WeApp");
      }
      if (n != 0)
      {
        localObject1 = (CharSequence)parami;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          n = 1;
          label598:
          if (n != 0) {
            break label885;
          }
          ((Intent)localObject2).putExtra("key_context_id", parami);
          label613:
          if (!Util.isNullOrNil(paramString))
          {
            localObject3 = com.tencent.mm.plugin.report.service.h.OAn;
            localObject1 = parami;
            if (parami == null) {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.report.service.h)localObject3).b(21140, new Object[] { localObject1, paramString, str1, "" });
          }
          ((Intent)localObject2).putExtra("report_scene", i1);
          ((Intent)localObject2).putExtra("tab_type", 9);
          if (j == 0) {
            break label1047;
          }
          ((Intent)localObject2).putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", true);
          ((Intent)localObject2).putExtra("KEY_OBJECT_NONCE_ID", str2);
          ((Intent)localObject2).putExtra("FROM_SCENE_KEY", 6);
          paramString = AppForegroundDelegate.aCe();
          if (paramString != null) {
            break label910;
          }
          parami = null;
          label742:
          if (parami != null) {
            break label1060;
          }
        }
      }
      for (parami = AppForegroundDelegate.heY.aCb();; parami = paramString)
      {
        label815:
        if (parami == null)
        {
          parami = null;
          label759:
          if (parami == null)
          {
            paramString = (PluginFinder)this;
            com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "bizBoxActivityFail", false, null, false, (kotlin.g.a.a)PluginFinder.v.Atc, 28);
            kotlin.g.b.s.s(str1, "feedId");
            parami = as.GSQ;
            parami = as.a.hu(paramContext);
            if (parami != null) {
              break label1039;
            }
            parami = null;
            new az(0L, str2, k, i2, "", true, null, null, 0L, null, false, false, str1, parami, 0, null, 53184).bFJ().b(new PluginFinder..ExternalSyntheticLambda23((Intent)localObject2, paramContext, paramString));
          }
        }
        for (;;)
        {
          parami = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
          com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999685);
          break;
          n = 0;
          break label598;
          label885:
          parami = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(i, m, k, (Intent)localObject2);
          break label613;
          parami = (Activity)paramString.get();
          break label742;
          paramString = (Activity)parami.get();
          if (paramString == null)
          {
            parami = null;
            break label759;
          }
          kotlin.g.b.s.s(str1, "feedId");
          parami = as.GSQ;
          parami = as.a.hu(paramContext);
          if (parami == null) {}
          for (parami = null;; parami = parami.fou())
          {
            parami = com.tencent.mm.plugin.findersdk.b.c.a((com.tencent.mm.plugin.findersdk.b.c)new az(0L, str2, k, i2, "", true, null, null, 0L, null, false, false, str1, parami, 0, null, 53184), (Context)paramString, 0L, 6).bFJ().b(new PluginFinder..ExternalSyntheticLambda22((Intent)localObject2, paramContext, this));
            break;
          }
          parami = parami.fou();
          break label815;
          parami = com.tencent.mm.plugin.finder.utils.a.GfO;
          com.tencent.mm.plugin.finder.utils.a.Y(paramContext, (Intent)localObject2);
        }
      }
    }
  }
  
  private static final ah openFinderFeed$lambda-43$lambda-42(Intent paramIntent, Context paramContext, PluginFinder paramPluginFinder, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(331151);
    kotlin.g.b.s.u(paramIntent, "$intent");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramPluginFinder, "this$0");
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      aw localaw = aw.Gjk;
      if (!aw.iv(parama.errType, parama.errCode)) {}
    }
    else
    {
      paramPluginFinder = ((ayl)parama.ott).feedObject;
      if (paramPluginFinder == null)
      {
        paramPluginFinder = null;
        paramIntent.putExtra("KEY_OBJECT_ID", (Serializable)paramPluginFinder);
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderTimelineUI(paramContext, paramIntent);
      }
    }
    for (;;)
    {
      paramIntent = ah.aiuX;
      AppMethodBeat.o(331151);
      return paramIntent;
      paramPluginFinder = Long.valueOf(paramPluginFinder.id);
      break;
      paramPluginFinder.handleCommentDetailResult(paramContext, parama.errCode, parama.errMsg);
    }
  }
  
  private static final ah openFinderFeed$lambda-45$lambda-44(Intent paramIntent, Context paramContext, PluginFinder paramPluginFinder, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(331158);
    kotlin.g.b.s.u(paramIntent, "$intent");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramPluginFinder, "$this_run");
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      aw localaw = aw.Gjk;
      if (!aw.iv(parama.errType, parama.errCode)) {}
    }
    else
    {
      paramPluginFinder = ((ayl)parama.ott).feedObject;
      if (paramPluginFinder == null)
      {
        paramPluginFinder = null;
        paramIntent.putExtra("KEY_OBJECT_ID", (Serializable)paramPluginFinder);
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderTimelineUI(paramContext, paramIntent);
      }
    }
    for (;;)
    {
      paramIntent = ah.aiuX;
      AppMethodBeat.o(331158);
      return paramIntent;
      paramPluginFinder = Long.valueOf(paramPluginFinder.id);
      break;
      paramPluginFinder.handleCommentDetailResult(paramContext, parama.errCode, parama.errMsg);
    }
  }
  
  private final void openFinderLiveOperationUIFromJSAPI(com.tencent.mm.ad.i parami, Context paramContext, ca.a<Object> parama, String paramString)
  {
    AppMethodBeat.i(330909);
    int i = parami.optInt("requestScene");
    boolean bool = parami.optBoolean("useDarkStyle");
    int j = parami.optInt("selectTabId");
    int k = parami.optInt("selectSecondTabId");
    paramString = parami.optString("byPass");
    int m = parami.optInt("entryScene");
    String str1 = parami.optString("feedID");
    String str2 = parami.optString("nonceID");
    parami = parami.optString("pageTitle");
    kotlin.g.b.s.s(paramString, "byPass");
    kotlin.g.b.s.s(str1, "feedExportId");
    kotlin.g.b.s.s(str2, "feedNonceId");
    kotlin.g.b.s.s(parami, "pageTitle");
    openFinderLiveOperationUIInternal(paramContext, i, bool, j, k, paramString, m, str1, str2, parami);
    if (parama != null) {
      parama.onCallback(Boolean.TRUE);
    }
    AppMethodBeat.o(330909);
  }
  
  private final void openFinderLiveOperationUIInternal(Context paramContext, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(330928);
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
          label169:
          paramString1 = "9002";
        }
        break;
      }
    }
    for (;;)
    {
      localIntent.putExtra("key_from_comment_scene", paramInt2);
      localIntent.putExtra("key_click_tab_id", paramString1);
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(paramInt4, 2, paramInt2, localIntent);
      ((com.tencent.d.a.b.a.d)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.d.class)).enterFinderLiveOperationUI(paramContext, localIntent);
      AppMethodBeat.o(330928);
      return;
      i = 0;
      break;
      paramInt2 = 9500001;
      break label169;
      paramInt2 = 9500002;
      break label169;
      paramInt2 = 9500004;
      break label169;
      paramInt2 = 9500003;
      break label169;
      paramString1 = "9001";
      continue;
      paramString1 = "9002";
      continue;
      paramString1 = "9004";
      continue;
      paramString1 = "9003";
    }
  }
  
  private final void openFinderProfile(com.tencent.mm.ad.i parami, Context paramContext, ca.a<Object> parama, String paramString)
  {
    AppMethodBeat.i(330987);
    String str1 = parami.optString("feedID");
    String str2 = parami.optString("finderUserName");
    int j = parami.optInt("commentScene");
    parami = parami.optString("reportExtraInfo", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", str2);
    localIntent.putExtra("finder_read_feed_id", str1);
    localIntent.putExtra("key_extra_info", parami);
    localIntent.putExtra("key_from_profile_share_scene", 18);
    localIntent.putExtra("key_from_comment_scene", 39);
    Object localObject1 = (cf)com.tencent.mm.kernel.h.ax(cf.class);
    kotlin.g.b.s.s(parami, "extraInfo");
    ((cf)localObject1).axt(parami);
    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
    com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.hm(parami, str2);
    Object localObject2;
    if (j > 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.report.n.FpH;
      localObject1 = com.tencent.mm.plugin.finder.report.n.eMA();
      if (36 != j) {
        break label243;
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label237;
      }
    }
    label237:
    for (int i = 1; i == 0; i = 0)
    {
      localIntent.putExtra("key_context_id", (String)localObject1);
      com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(paramContext, localIntent);
      if (parama != null) {
        parama.onCallback(Integer.valueOf(0));
      }
      AppMethodBeat.o(330987);
      return;
    }
    label243:
    localObject1 = av.GiL;
    if (av.aBT(parami))
    {
      i = 4;
      label258:
      localObject1 = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(j, i, 32, localIntent);
      if (!Util.isNullOrNil(paramString))
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
        if (localObject1 != null) {
          break label348;
        }
      }
    }
    label348:
    for (parami = "";; parami = (com.tencent.mm.ad.i)localObject1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).b(21140, new Object[] { parami, paramString, str1, str2 });
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ((String)localObject1);
      break;
      i = 2;
      break label258;
    }
  }
  
  private final void registerTeenModeGuardian()
  {
    AppMethodBeat.i(330890);
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(4, (com.tencent.mm.plugin.teenmode.a.a)new com.tencent.mm.plugin.finder.ui.teenmode.a());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(6, (com.tencent.mm.plugin.teenmode.a.a)new com.tencent.mm.plugin.finder.ui.teenmode.b());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(5, (com.tencent.mm.plugin.teenmode.a.a)new com.tencent.mm.plugin.finder.ui.teenmode.b());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(4, (com.tencent.mm.plugin.teenmode.a.b)new com.tencent.mm.plugin.finder.viewmodel.teenmode.a());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(6, (com.tencent.mm.plugin.teenmode.a.b)new com.tencent.mm.plugin.finder.viewmodel.teenmode.a());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(5, (com.tencent.mm.plugin.teenmode.a.b)new com.tencent.mm.plugin.finder.viewmodel.teenmode.a());
    com.tencent.mm.plugin.finder.video.f localf = com.tencent.mm.plugin.finder.video.f.Gog;
    com.tencent.mm.plugin.finder.video.f.ygN = com.tencent.mm.modelcontrol.e.wb(4);
    Log.i("Finder.FinderNetworkStatusStatistic", kotlin.g.b.s.X("setup isSupportHevc:", Boolean.valueOf(com.tencent.mm.plugin.finder.video.f.ygN)));
    com.tencent.mm.ae.d.B((kotlin.g.a.a)f.f.Got);
    AppForegroundDelegate.heY.a((com.tencent.mm.app.q)com.tencent.mm.plugin.finder.video.f.Goo);
    com.tencent.mm.plugin.finder.video.f.fiX();
    AppMethodBeat.o(330890);
  }
  
  private final void reportFinderPrivateMsgTableSize()
  {
    AppMethodBeat.i(330896);
    com.tencent.threadpool.h.ahAA.bn(new PluginFinder..ExternalSyntheticLambda27(this));
    AppMethodBeat.o(330896);
  }
  
  private static final void reportFinderPrivateMsgTableSize$lambda-25(PluginFinder paramPluginFinder)
  {
    AppMethodBeat.i(331114);
    kotlin.g.b.s.u(paramPluginFinder, "this$0");
    Object localObject1;
    if (System.currentTimeMillis() - paramPluginFinder.lastReportTime > 86400000L)
    {
      paramPluginFinder.lastReportTime = System.currentTimeMillis();
      localObject1 = (Closeable)paramPluginFinder.getContactStorage().psb.rawQuery("select count(*) from FinderContact", null);
      try
      {
        Object localObject2 = (Cursor)localObject1;
        ((Cursor)localObject2).moveToFirst();
        long l = ((Cursor)localObject2).getLong(0);
        localObject2 = new com.tencent.mm.plugin.finder.conv.a.a();
        String str = Thread.currentThread().getName();
        kotlin.g.b.s.s(str, "currentThread().name");
        localObject2 = ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).avh(str).avg("select count(*) from FinderContact");
        ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).AFw = l;
        ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).avf("FinderContactStorage.reportSize").dWL().report();
        localObject2 = ah.aiuX;
        kotlin.f.b.a((Closeable)localObject1, null);
        localObject1 = (Closeable)paramPluginFinder.getMsgAliasContactStorage().psb.rawQuery("select count(*) from FinderMsgAliasContactStorage", null);
        AppMethodBeat.o(331114);
      }
      finally
      {
        try
        {
          localObject2 = (Cursor)localObject1;
          ((Cursor)localObject2).moveToFirst();
          l = ((Cursor)localObject2).getLong(0);
          localObject2 = new com.tencent.mm.plugin.finder.conv.a.a();
          str = Thread.currentThread().getName();
          kotlin.g.b.s.s(str, "currentThread().name");
          localObject2 = ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).avh(str).avg("select count(*) from FinderMsgAliasContactStorage");
          ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).AFw = l;
          ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).avf("FinderMsgAliasContactStorage.reportSize").dWL().report();
          localObject2 = ah.aiuX;
          kotlin.f.b.a((Closeable)localObject1, null);
          localObject1 = (Closeable)paramPluginFinder.getSessionInfoStorage().db.rawQuery("select count(*) from FinderSessionInfo", null);
        }
        finally {}
        try
        {
          localObject2 = (Cursor)localObject1;
          ((Cursor)localObject2).moveToFirst();
          l = ((Cursor)localObject2).getLong(0);
          localObject2 = new com.tencent.mm.plugin.finder.conv.a.a();
          str = Thread.currentThread().getName();
          kotlin.g.b.s.s(str, "currentThread().name");
          localObject2 = ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).avh(str).avg("select count(*) from FinderSessionInfo");
          ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).AFw = l;
          ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).avf("FinderSessionInfoStorage.reportSize").dWL().report();
          localObject2 = ah.aiuX;
          kotlin.f.b.a((Closeable)localObject1, null);
          localObject1 = (Closeable)paramPluginFinder.getMsgStrangerContactStorage().psb.rawQuery("select count(*) from FinderMsgContactStorage", null);
        }
        finally {}
        try
        {
          localObject2 = (Cursor)localObject1;
          ((Cursor)localObject2).moveToFirst();
          l = ((Cursor)localObject2).getLong(0);
          localObject2 = new com.tencent.mm.plugin.finder.conv.a.a();
          str = Thread.currentThread().getName();
          kotlin.g.b.s.s(str, "currentThread().name");
          localObject2 = ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).avh(str).avg("select count(*) from FinderMsgContactStorage");
          ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).AFw = l;
          ((com.tencent.mm.plugin.finder.conv.a.a)localObject2).avf("FinderMsgStrangerContactStorage.reportSize").dWL().report();
          localObject2 = ah.aiuX;
          kotlin.f.b.a((Closeable)localObject1, null);
          paramPluginFinder = (Closeable)paramPluginFinder.getConversationStorage().db.rawQuery("select count(*) from FinderConversation", null);
        }
        finally {}
        try
        {
          localObject1 = (Cursor)paramPluginFinder;
          ((Cursor)localObject1).moveToFirst();
          l = ((Cursor)localObject1).getLong(0);
          localObject1 = new com.tencent.mm.plugin.finder.conv.a.a();
          localObject2 = Thread.currentThread().getName();
          kotlin.g.b.s.s(localObject2, "currentThread().name");
          localObject1 = ((com.tencent.mm.plugin.finder.conv.a.a)localObject1).avh((String)localObject2).avg("select count(*) from FinderConversation");
          ((com.tencent.mm.plugin.finder.conv.a.a)localObject1).AFw = l;
          ((com.tencent.mm.plugin.finder.conv.a.a)localObject1).avf("FinderConversationStorage.reportSize").dWL().report();
          localObject1 = ah.aiuX;
          kotlin.f.b.a(paramPluginFinder, null);
          AppMethodBeat.o(331114);
          return;
        }
        finally {}
        paramPluginFinder = finally;
        try
        {
          AppMethodBeat.o(331114);
          throw paramPluginFinder;
        }
        finally
        {
          kotlin.f.b.a((Closeable)localObject1, paramPluginFinder);
          AppMethodBeat.o(331114);
        }
      }
    }
  }
  
  private static final ah requestFinderObject$lambda-54(Object paramObject, long paramLong, ah.f paramf, ah.a parama, com.tencent.mm.am.b.a parama1)
  {
    AppMethodBeat.i(331188);
    kotlin.g.b.s.u(paramObject, "$lock");
    kotlin.g.b.s.u(paramf, "$ret");
    kotlin.g.b.s.u(parama, "$isNotify");
    Object localObject;
    if ((parama1.errType != 0) || (parama1.errCode != 0))
    {
      localObject = aw.Gjk;
      if (!aw.iv(parama1.errType, parama1.errCode)) {}
    }
    else
    {
      parama1 = ((ayl)parama1.ott).feedObject;
      if (parama1 != null)
      {
        localObject = FinderItem.Companion;
        parama1 = FinderItem.a.e(parama1, 1);
        localObject = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        com.tencent.mm.plugin.finder.storage.data.e.a.s(parama1);
        paramf.aqH = parama1;
      }
    }
    try
    {
      parama.aiwY = true;
      paramObject.notify();
      paramf = ah.aiuX;
      Log.i("Finder.PluginFinder", "requestFinderObject " + paramLong + ", finish");
      paramObject = ah.aiuX;
      AppMethodBeat.o(331188);
      return paramObject;
    }
    finally
    {
      AppMethodBeat.o(331188);
    }
  }
  
  private final void resetDb()
  {
    AppMethodBeat.i(165078);
    Object localObject1;
    Object localObject2;
    if (this.mCN == null)
    {
      this.mCN = new com.tencent.mm.storagebase.h();
      localObject1 = kotlin.g.b.s.X(com.tencent.mm.kernel.h.baE().cachePath, "FinderMM029.db");
      localObject2 = this.mCN;
      kotlin.g.b.s.checkNotNull(localObject2);
      if (!((com.tencent.mm.storagebase.h)localObject2).a((String)localObject1, collectFinderDatabaseFactory(), true))
      {
        localObject1 = new SQLiteException("finder db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
    }
    if (this.Arq == null)
    {
      this.Arq = new com.tencent.mm.storagebase.h();
      localObject1 = kotlin.g.b.s.X(com.tencent.mm.kernel.h.baE().cachePath, "FinderMention001.db");
      localObject2 = this.Arq;
      kotlin.g.b.s.checkNotNull(localObject2);
      if (!((com.tencent.mm.storagebase.h)localObject2).a((String)localObject1, collectMentionDatabaseFactory(), true))
      {
        localObject1 = new SQLiteException("finder finder mention db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
      checkIfSameMsgTableName();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addv, cz.ktM);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addw, cz.ktN);
    }
    if (this.Ars == null)
    {
      localObject1 = new com.tencent.mm.storagebase.h();
      if (!((com.tencent.mm.storagebase.h)localObject1).a(kotlin.g.b.s.X(com.tencent.mm.kernel.h.baE().cachePath, "FinderMessage006.db"), collectMessageDatabaseFactory(), true))
      {
        localObject1 = new SQLiteException("message db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
      localObject2 = ah.aiuX;
      this.Ars = ((com.tencent.mm.storagebase.h)localObject1);
    }
    if (this.Arr == null)
    {
      this.Arr = new com.tencent.mm.storagebase.h();
      localObject1 = kotlin.g.b.s.X(com.tencent.mm.kernel.h.baE().cachePath, "FinderMention002.db");
      localObject2 = this.Arr;
      kotlin.g.b.s.checkNotNull(localObject2);
      if (!((com.tencent.mm.storagebase.h)localObject2).a((String)localObject1, collectMentionDatabaseFactory(), true))
      {
        localObject1 = new SQLiteException("finder wx mention db init failed");
        AppMethodBeat.o(165078);
        throw ((Throwable)localObject1);
      }
    }
    AppMethodBeat.o(165078);
  }
  
  private static final ah shareStatsReport$lambda-49(ah.f paramf, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(331167);
    kotlin.g.b.s.u(paramf, "$stats");
    if ((parama.errCode == 0) && (parama.errType == 0)) {
      Log.i("Finder.PluginFinder", kotlin.g.b.s.X("successfully! size=", Integer.valueOf(((LinkedList)paramf.aqH).size())));
    }
    for (;;)
    {
      paramf = ah.aiuX;
      AppMethodBeat.o(331167);
      return paramf;
      Log.w("Finder.PluginFinder", kotlin.g.b.s.X("fail to report! size=", Integer.valueOf(((LinkedList)paramf.aqH).size())));
    }
  }
  
  private static final void showFinderEntranceDebugSheet$lambda-4(Activity paramActivity, String paramString, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(331005);
    kotlin.g.b.s.u(paramActivity, "$activity");
    kotlin.g.b.s.u(paramString, "$url");
    params.c(0, (CharSequence)paramActivity.getString(e.h.finder_debug_title));
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        params.c(1, (CharSequence)paramActivity.getString(e.h.finder_debug_title_2));
      }
      AppMethodBeat.o(331005);
      return;
    }
  }
  
  private static final void showFinderEntranceDebugSheet$lambda-5(Activity paramActivity, String paramString, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(331013);
    kotlin.g.b.s.u(paramActivity, "$activity");
    kotlin.g.b.s.u(paramString, "$url");
    if (paramMenuItem.getItemId() == 0)
    {
      paramString = new Intent((Context)paramActivity, Class.forName("com.tencent.mm.plugin.finder.ui.FinderSettingsUI"));
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString.aYi(), "com/tencent/mm/plugin/finder/PluginFinder", "showFinderEntranceDebugSheet$lambda-5", "(Landroid/app/Activity;Ljava/lang/String;Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/finder/PluginFinder", "showFinderEntranceDebugSheet$lambda-5", "(Landroid/app/Activity;Ljava/lang/String;Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(331013);
      return;
    }
    if (paramMenuItem.getItemId() == 1)
    {
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("rawUrl", paramString);
      com.tencent.mm.br.c.b((Context)paramActivity, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    }
    AppMethodBeat.o(331013);
  }
  
  private static final ah tryGetFinderObject$lambda-51(cn.a parama, long paramLong, com.tencent.mm.am.b.a parama1)
  {
    AppMethodBeat.i(331180);
    Object localObject1;
    if ((parama1.errType != 0) || (parama1.errCode != 0))
    {
      localObject1 = aw.Gjk;
      if (!aw.iv(parama1.errType, parama1.errCode)) {}
    }
    else
    {
      localObject1 = ((ayl)parama1.ott).feedObject;
      if (localObject1 != null)
      {
        Object localObject2 = FinderItem.Companion;
        localObject2 = FinderItem.a.e((FinderObject)localObject1, 1);
        com.tencent.mm.plugin.finder.storage.data.e.a locala = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        com.tencent.mm.plugin.finder.storage.data.e.a.s((FinderItem)localObject2);
        if (parama != null) {
          parama.get(localObject1, parama1.errType, parama1.errCode);
        }
      }
    }
    for (;;)
    {
      Log.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", finish");
      parama = ah.aiuX;
      AppMethodBeat.o(331180);
      return parama;
      if (parama != null) {
        parama.get(null, parama1.errType, parama1.errCode);
      }
    }
  }
  
  public final boolean canEnterMvAndShowToast()
  {
    boolean bool = true;
    AppMethodBeat.i(332232);
    if ((((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isAnchorLiving()) || (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isVisitorLiving())) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)PluginFinder.c.AsK);
    }
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!com.tencent.mm.n.a.v(MMApplicationContext.getContext(), true))) {}
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)d.AsL);
        AppMethodBeat.o(332232);
        return bool;
        bool = false;
      }
    }
  }
  
  public final void clearFinderRedDot(String paramString, ca.a<Integer> parama)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(331863);
    if (paramString == null) {
      paramString = (String)localObject2;
    }
    for (;;)
    {
      if ((paramString == null) && (parama != null)) {
        parama.onCallback(Integer.valueOf(0));
      }
      AppMethodBeat.o(331863);
      return;
      for (;;)
      {
        try
        {
          localObject2 = new com.tencent.mm.ad.i(paramString);
          String str = ((com.tencent.mm.ad.i)localObject2).optString("businessType");
          Log.i("Finder.PluginFinder", "clearFinderRedDot json: " + paramString + " businessType:" + str);
          paramString = ((com.tencent.mm.ad.i)localObject2).get("redDotPath");
          if (!(paramString instanceof String)) {
            continue;
          }
          paramString = new com.tencent.mm.ad.f((String)paramString);
          k = paramString.length();
          if (k <= 0) {
            continue;
          }
          i = 0;
        }
        catch (Exception paramString)
        {
          int k;
          int j;
          Log.printErrStackTrace("Finder.PluginFinder", (Throwable)paramString, "clearFinderRedDot exception", new Object[0]);
          if (parama != null) {
            continue;
          }
          paramString = localObject1;
          break;
          parama.onCallback(Integer.valueOf(0));
          paramString = ah.aiuX;
          continue;
          int i = j;
          continue;
          if (parama != null) {
            continue;
          }
          paramString = null;
        }
        j = i + 1;
        localObject2 = paramString.get(i).toString();
        Log.i("Finder.PluginFinder", kotlin.g.b.s.X("clearFinderRedDot path:", localObject2));
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().TL((String)localObject2);
        if (j >= k)
        {
          continue;
          if ((paramString instanceof com.tencent.mm.ad.f))
          {
            paramString = (com.tencent.mm.ad.f)paramString;
            continue;
          }
          paramString = new com.tencent.mm.ad.f("");
          continue;
          parama.onCallback(Integer.valueOf(1));
          paramString = ah.aiuX;
          break;
        }
      }
    }
  }
  
  public final void closeFinderEntryForDebug()
  {
    this.AsG = true;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(162433);
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("findermessage006".hashCode()), PluginFinder..ExternalSyntheticLambda8.INSTANCE);
    AppMethodBeat.o(162433);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(165092);
    af.b("finder", "finder", getFINDER_FOLDER_MAX_SIZE(), getFINDER_FOLDER_LRU_EXPIRE(), 49);
    af.aR("finderposting", "finderposting", 2);
    AppMethodBeat.o(165092);
  }
  
  public final void createAccount(Context paramContext, Intent paramIntent, String paramString, ca.a<Integer> parama)
  {
    AppMethodBeat.i(331851);
    kotlin.g.b.s.u(paramContext, "context");
    if ((!showFinderEntry()) || (!showPostEntry()) || (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()))
    {
      Log.i("Finder.PluginFinder", "[createAccount] no finder entry or in teen mode");
      if (parama != null) {
        parama.onCallback(Integer.valueOf(2));
      }
      AppMethodBeat.o(331851);
      return;
    }
    if (paramString != null) {
      Log.i("Finder.PluginFinder", kotlin.g.b.s.X("json: ", paramString));
    }
    for (;;)
    {
      int i;
      try
      {
        if (((CharSequence)paramString).length() > 0)
        {
          i = 1;
          break label296;
          paramIntent = new com.tencent.mm.ad.i(paramString);
          paramString = this.Ask;
          kotlin.g.b.s.u(paramContext, "context");
          paramString.Ggn = parama;
          parama = new Intent(paramContext, FinderCreateAccountStarterActivity.class);
          paramString = paramIntent.toString();
          paramIntent = paramString;
          if (paramString == null) {
            paramIntent = "";
          }
          parama.putExtra("param_extra_info", paramIntent);
          parama.addFlags(268435456);
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/utils/FinderCreateAccountStarter", "showDialog", "(Landroid/content/Context;Lcom/tencent/mm/json/JSONObject;Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramIntent.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/utils/FinderCreateAccountStarter", "showDialog", "(Landroid/content/Context;Lcom/tencent/mm/json/JSONObject;Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(331851);
        }
        else
        {
          i = 0;
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("Finder.PluginFinder", (Throwable)paramContext, "createAccount exception", new Object[0]);
      }
      AppMethodBeat.o(331851);
      return;
      label296:
      if (i == 0) {
        paramString = "{}";
      }
    }
  }
  
  public final com.tencent.mm.plugin.thumbplayer.a.b createMediaInfo(FinderMedia paramFinderMedia, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(332312);
    kotlin.g.b.s.u(paramFinderMedia, "finderMedia");
    com.tencent.mm.plugin.finder.storage.logic.e locale = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
    paramFinderMedia = com.tencent.mm.plugin.finder.storage.logic.e.a(paramFinderMedia, paramLong, paramBoolean);
    AppMethodBeat.o(332312);
    return paramFinderMedia;
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(331680);
    super.dependency();
    dependsOn(com.tencent.mm.plugin.byp.a.c.class);
    dependsOn(com.tencent.mm.plugin.teenmode.a.c.class);
    AppMethodBeat.o(331680);
  }
  
  public final void dumpAndMarkFinderFolder()
  {
    AppMethodBeat.i(165100);
    com.tencent.mm.ae.d.B((kotlin.g.a.a)e.AsM);
    AppMethodBeat.o(165100);
  }
  
  public final void enterAlbumRelatedTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(331986);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("Finder.PluginFinder", kotlin.g.b.s.X("[enterRelatedTimelineUI] ", paramContext.getClass().getName()));
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.enterAlbumRelatedTimelineUI(paramContext, paramIntent);
    AppMethodBeat.o(331986);
  }
  
  public final void enterFinderActivityProfileUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(331980);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "intent");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.hc(paramContext);
      AppMethodBeat.o(331980);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.aq(paramContext, paramIntent);
    AppMethodBeat.o(331980);
  }
  
  public final void enterFinderConversationUI(Context paramContext)
  {
    AppMethodBeat.i(332099);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.hg(paramContext);
    AppMethodBeat.o(332099);
  }
  
  public final void enterFinderFollowListUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(332000);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.enterFinderFollowListUI(paramContext, paramIntent);
    AppMethodBeat.o(332000);
  }
  
  public final void enterFinderGallery(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(332253);
    kotlin.g.b.s.u(paramContext, "activity");
    kotlin.g.b.s.u(paramIntent, "intent");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.b(paramContext, paramIntent, paramInt);
    AppMethodBeat.o(332253);
  }
  
  public final void enterFinderHotWordUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(331974);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "intent");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.hc(paramContext);
      AppMethodBeat.o(331974);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.ah(paramContext, paramIntent);
    AppMethodBeat.o(331974);
  }
  
  public final void enterFinderLiveIncome(Context paramContext, String paramString)
  {
    AppMethodBeat.i(332261);
    kotlin.g.b.s.u(paramContext, "context");
    paramString = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).Asl;
    Object localObject1;
    label49:
    Object localObject2;
    if (paramString == null)
    {
      paramString = null;
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).Asl;
      if (localObject1 != null) {
        break label169;
      }
      localObject1 = null;
      if ((paramString != null) && (localObject1 != null))
      {
        w localw = w.FrV;
        localObject2 = as.GSQ;
        localObject2 = as.a.hu(paramContext);
        if (localObject2 != null) {
          break label180;
        }
        localObject2 = null;
        label81:
        w.a(localw, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, paramString, 2, (bui)localObject2, 0, null, 0, 480);
      }
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getRedDotManager().TL("FinderLiveIncomeEntrance");
      if (!(paramContext instanceof Activity)) {
        break label190;
      }
    }
    for (;;)
    {
      paramString = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.a(paramContext, 0L, false, 2L, 9L, false, 0L);
      getIncomePageInfoAndEnterIncome(paramContext);
      AppMethodBeat.o(332261);
      return;
      paramString = paramString.avp("FinderLiveIncomeEntrance");
      break;
      label169:
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).Su("FinderLiveIncomeEntrance");
      break label49;
      label180:
      localObject2 = ((as)localObject2).fou();
      break label81;
      label190:
      paramString = ((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).bUR();
      if (paramString != null) {
        paramContext = (Context)paramString;
      }
    }
  }
  
  public final void enterFinderLiveLottery(Context paramContext, String paramString)
  {
    AppMethodBeat.i(332278);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a.GfO.a(paramContext, null, true);
    AppMethodBeat.o(332278);
  }
  
  public final void enterFinderPoiFeedUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(332217);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a.GfO.w(paramContext, paramIntent);
    AppMethodBeat.o(332217);
  }
  
  public final void enterFinderPostRouterUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(331992);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI(paramContext, paramIntent);
    AppMethodBeat.o(331992);
  }
  
  public final void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162439);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(paramContext, paramIntent);
    AppMethodBeat.o(162439);
  }
  
  public final void enterFinderPostUI(Context paramContext, String paramString, int paramInt, com.tencent.mm.plugin.findersdk.a.bj parambj)
  {
    AppMethodBeat.i(331893);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "json");
    kotlin.g.b.s.u(parambj, "callback");
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi().a(paramContext, paramString, paramInt, parambj);
    AppMethodBeat.o(331893);
  }
  
  public final void enterFinderProfileUI(final Context paramContext, final Intent paramIntent)
  {
    Object localObject3 = null;
    final int i = 25;
    AppMethodBeat.i(162440);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject1;
    if (paramIntent == null)
    {
      localObject1 = null;
      cf localcf = (cf)com.tencent.mm.kernel.h.ax(cf.class);
      if (localObject1 != null) {
        break label178;
      }
      localObject2 = "";
      label47:
      localcf.axt((String)localObject2);
      if (paramIntent != null) {
        break label185;
      }
    }
    label178:
    label185:
    for (Object localObject2 = localObject3;; localObject2 = paramIntent.getStringExtra("key_biz_username"))
    {
      if ((Util.isNullOrNil((String)localObject2)) || (kotlin.g.b.s.p("null", localObject2))) {
        break label197;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("Contact_User", (String)localObject2);
      paramIntent.putExtra("Contact_Scene", 213);
      paramIntent.putExtra("biz_profile_enter_from_finder", true);
      paramIntent.putExtra("force_get_contact", true);
      paramIntent.putExtra("key_use_new_contact_profile", true);
      paramIntent.putExtra("biz_profile_tab_type", 1);
      com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", paramIntent);
      AppMethodBeat.o(162440);
      return;
      localObject1 = paramIntent.getStringExtra("key_extra_info");
      break;
      localObject2 = localObject1;
      break label47;
    }
    label197:
    label235:
    final long l;
    if (paramIntent == null)
    {
      localObject2 = "";
      if (!Util.isNullOrNil((String)localObject2)) {
        break label397;
      }
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.hm((String)localObject1, (String)localObject2);
      if (paramIntent != null) {
        break label304;
      }
      localObject1 = "0";
      l = com.tencent.mm.ae.d.FK((String)localObject1);
      if (paramIntent != null) {
        break label330;
      }
      localObject1 = "";
      label251:
      if (paramIntent != null) {
        break label356;
      }
    }
    for (;;)
    {
      if (l != 0L) {
        break label369;
      }
      Log.e("Finder.PluginFinder", "enterFinderProfileUI username & objectId invalid");
      AppMethodBeat.o(162440);
      return;
      localObject3 = paramIntent.getStringExtra("finder_username");
      localObject2 = localObject3;
      if (localObject3 != null) {
        break;
      }
      localObject2 = "";
      break;
      label304:
      localObject2 = paramIntent.getStringExtra("key_finder_object_Id");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label235;
      }
      localObject1 = "0";
      break label235;
      label330:
      localObject2 = paramIntent.getStringExtra("key_finder_object_nonce_id_key");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label251;
      }
      localObject1 = "";
      break label251;
      label356:
      i = paramIntent.getIntExtra("share_enter_scene", 25);
    }
    label369:
    com.tencent.mm.ae.d.B((kotlin.g.a.a)new f(this, l, (String)localObject1, i, paramIntent, paramContext));
    AppMethodBeat.o(162440);
    return;
    label397:
    com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(paramContext, paramIntent);
    paramContext = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
    com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999686);
    AppMethodBeat.o(162440);
  }
  
  public final void enterFinderSelfProfile(Context paramContext, Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331841);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "intent");
    String str = paramIntent.getStringExtra("key_biz_username");
    if ((!Util.isNullOrNil(str)) && (!kotlin.g.b.s.p("null", str)))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("Contact_User", str);
      paramIntent.putExtra("Contact_Scene", 213);
      paramIntent.putExtra("biz_profile_enter_from_finder", true);
      paramIntent.putExtra("force_get_contact", true);
      paramIntent.putExtra("key_use_new_contact_profile", true);
      paramIntent.putExtra("biz_profile_tab_type", 1);
      com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", paramIntent);
      AppMethodBeat.o(331841);
      return;
    }
    str = com.tencent.mm.model.z.bAW();
    if (!Util.isNullOrNil(str))
    {
      paramIntent.putExtra("finder_username", str);
      paramIntent.putExtra("KEY_FINDER_SELF_FLAG", true);
      fillContextIdToIntent(paramInt1, paramInt2, 33, paramIntent);
      com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(paramContext, paramIntent);
      AppMethodBeat.o(331841);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("key_create_scene", 6);
      paramIntent.putExtra("key_router_to_profile", false);
      com.tencent.mm.plugin.finder.utils.a.GfO.x(paramContext, paramIntent);
    }
    AppMethodBeat.o(331841);
  }
  
  public final void enterFinderSelfUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(331772);
    if (paramContext != null)
    {
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI(paramContext, paramIntent);
    }
    AppMethodBeat.o(331772);
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, Intent paramIntent)
  {
    boolean bool3 = true;
    AppMethodBeat.i(162441);
    kotlin.g.b.s.u(paramContext, "context");
    final Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDh("entrance") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.hc(paramContext);
      AppMethodBeat.o(162441);
      return;
    }
    long l = com.tencent.mm.model.z.bAR();
    boolean bool1 = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry();
    Log.i("Finder.PluginFinder", "showFinder %s", new Object[] { Boolean.valueOf(bool1) });
    if ((((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) && (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD() == 2))
    {
      i = 1;
      if ((bool1) && (i == 0) && (WeChatBrands.Business.Entries.MeSetDiscoveryChannels.checkAvailable(paramContext))) {
        break label356;
      }
    }
    label181:
    label195:
    label329:
    label356:
    for (int i = 1;; i = 0)
    {
      boolean bool4 = com.tencent.mm.model.ab.bBX();
      boolean bool2;
      if (com.tencent.mm.k.i.aRC().getInt("ExtFunctionSwitchEntry", 0) == 1)
      {
        bool1 = true;
        if ((l & 0x0) == 0L) {
          break label317;
        }
        bool2 = true;
        paramIntent = new StringBuilder("isShowWechatUserDialog = ").append(bool1).append(", isWeChatUser = ").append(bool4).append(", close = ").append(bool2).append(", !hideEnter = ");
        if (i != 0) {
          break label323;
        }
      }
      for (;;)
      {
        Log.i("Finder.PluginFinder", bool3);
        if ((!bool1) || (!bool4) || (!bool2) || (i != 0)) {
          break label329;
        }
        com.tencent.mm.plugin.setting.ui.b.a.a(paramContext, 34359738368L, null, (com.tencent.mm.plugin.setting.ui.b.a.a)new g(paramContext, localIntent), 3);
        AppMethodBeat.o(162441);
        return;
        i = 0;
        break;
        bool1 = false;
        break label181;
        bool2 = false;
        break label195;
        bool3 = false;
      }
      paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.Y(paramContext, localIntent);
      paramContext = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
      com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999685);
      AppMethodBeat.o(162441);
      return;
    }
  }
  
  public final void enterFinderShareFeedUI(Context paramContext, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(331947);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "json");
    int i;
    try
    {
      com.tencent.mm.ad.i locali1 = new com.tencent.mm.ad.i(paramString);
      long l = com.tencent.mm.ae.d.FK(locali1.optString("feedId", "0"));
      com.tencent.mm.ad.i locali2 = locali1.Fs("extInfo");
      Log.i("Finder.PluginFinder", kotlin.g.b.s.X("json = ", paramString));
      String str2 = locali2.getString("feedNonceId");
      i = locali2.optInt("reportScene", 11);
      String str3 = locali2.optString("encryptedObjectId", "");
      boolean bool = locali2.optBoolean("getRelatedList", false);
      String str4 = locali2.optString("sessionId", "");
      String str1 = locali2.optString("reportExtraInfo", "");
      String str5 = locali2.optString("commonExtraInfo", "");
      int j = locali2.optInt("requestScene", 3);
      paramString = paramIntent;
      if (paramIntent == null) {
        paramString = new Intent();
      }
      paramString.putExtra("report_scene", i);
      paramString.putExtra("from_user", com.tencent.mm.model.z.bAM());
      paramString.putExtra("feed_object_id", l);
      paramString.putExtra("feed_encrypted_object_id", str3);
      paramString.putExtra("feed_object_nonceId", str2);
      paramString.putExtra("key_need_related_list", bool);
      paramString.putExtra("key_session_id", str4);
      paramString.putExtra("key_comment_scene", 39);
      paramString.putExtra("key_reuqest_scene", j);
      if (!Util.isNullOrNil(str5)) {
        paramString.putExtra("key_common_extra_info", str5);
      }
      paramIntent = locali1.optString("extraInfo", "");
      kotlin.g.b.s.s(paramIntent, "jsonObject.optString(\"extraInfo\", \"\")");
      if (!Util.isNullOrNil(str1)) {
        paramString.putExtra("key_extra_info", str1);
      }
      for (;;)
      {
        paramIntent = com.tencent.mm.plugin.findersdk.d.a.Hdr;
        if (com.tencent.mm.plugin.findersdk.d.a.aDh("entrance") == 0) {
          break;
        }
        paramString = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.hc(paramContext);
        AppMethodBeat.o(331947);
        return;
        if (!TextUtils.isEmpty((CharSequence)paramIntent)) {
          paramString.putExtra("key_extra_info", paramIntent);
        }
      }
      paramIntent = av.GiL;
    }
    finally
    {
      Log.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderProfileUI exception", new Object[0]);
      AppMethodBeat.o(331947);
      return;
    }
    fillContextIdToIntent(av.Uo(i), 2, 39, paramString);
    paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.Y(paramContext, paramString);
    paramContext = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
    com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999685);
    AppMethodBeat.o(331947);
  }
  
  public final void enterFinderShop(Context paramContext, String paramString)
  {
    AppMethodBeat.i(332288);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject1;
    String str;
    Object localObject3;
    Object localObject2;
    if (!Util.isNullOrNil(paramString))
    {
      localObject1 = new com.tencent.mm.ad.i(paramString);
      paramString = ((com.tencent.mm.ad.i)localObject1).optString("targetAppId");
      str = ((com.tencent.mm.ad.i)localObject1).optString("path");
      int i = ((com.tencent.mm.ad.i)localObject1).optInt("referrerAppId");
      localObject3 = ((com.tencent.mm.ad.i)localObject1).optString("envVersion");
      localObject2 = new StringBuilder();
      if (paramString != null) {
        break label222;
      }
      localObject1 = "";
      localObject2 = (String)localObject1 + ':' + Util.getUuidRandom();
      Log.i("Finder.PluginFinder", "enter shop:" + paramString + ',' + str + "  referrerAppId:" + i + ", envVersion:" + localObject3 + ", sceneNote:" + (String)localObject2);
      localObject3 = com.tencent.mm.plugin.finder.utils.a.GfO;
      if (paramString != null) {
        break label228;
      }
      paramString = "";
    }
    label222:
    label228:
    for (;;)
    {
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.finder.utils.a)localObject3).a(paramContext, paramString, (String)localObject1, 1176, (String)localObject2);
      AppMethodBeat.o(332288);
      return;
      localObject1 = paramString;
      break;
    }
  }
  
  public final void enterFinderTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(162438);
    kotlin.g.b.s.u(paramContext, "context");
    enterFinderTimelineUI(paramContext, paramIntent, false);
    AppMethodBeat.o(162438);
  }
  
  public final void enterFinderTimelineUI(Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(331784);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.eMN();
    localObject1 = com.tencent.mm.plugin.finder.report.r.Fqi;
    com.tencent.mm.plugin.finder.report.r.pC(2L);
    Object localObject2;
    int i;
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("key_form_sns", false)) {
        break label503;
      }
      localObject2 = paramIntent.getStringExtra("key_context_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
      if (Util.isNullOrNil(m.a.ai((String)localObject1, 1, 0))) {
        break label369;
      }
      i = 1;
    }
    for (;;)
    {
      int j;
      label107:
      com.tencent.mm.plugin.finder.preload.tabPreload.g localg;
      label204:
      boolean bool;
      String str;
      StringBuilder localStringBuilder;
      if (!Util.isNullOrNil(paramIntent.getStringExtra("key_red_dot_id")))
      {
        j = 1;
        if ((i | j) != 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
          com.tencent.mm.plugin.finder.report.s.eMM();
        }
        if (!paramBoolean) {
          break label386;
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (!com.tencent.mm.plugin.finder.storage.d.eVQ()) {
          break label386;
        }
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_ROUTE_TO_TOPIC", false)))
        {
          localObject1 = com.tencent.mm.plugin.finder.feed.jumper.r.Bej;
          com.tencent.mm.plugin.finder.feed.jumper.r.a(paramIntent, (kotlin.g.a.b)h.AsR);
        }
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = (com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class);
        localObject2 = ((Iterable)((com.tencent.mm.plugin.finder.preload.tabPreload.c)localObject1).EVR).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label386;
        }
        localg = (com.tencent.mm.plugin.finder.preload.tabPreload.g)((Iterator)localObject2).next();
        i = ((com.tencent.mm.plugin.finder.preload.tabPreload.c)localObject1).eHM().fmM();
        bool = localg.EWb.Rp(localg.hJx);
        str = localg.TAG;
        localStringBuilder = new StringBuilder("[performEnterFinderLoad] targetTab=").append(i).append(", cache.resp is null = ");
        if (localg.EWk.BeG != null) {
          break label381;
        }
      }
      label369:
      label381:
      for (paramBoolean = true;; paramBoolean = false)
      {
        Log.i(str, paramBoolean + ", isAutoRefresh = " + bool);
        if ((localg.hJx != i) || (localg.EWk.BeG != null) || (!bool)) {
          break label204;
        }
        localg.a(g.g.EWE, paramIntent, (kotlin.g.a.b)new g.m(localg));
        break label204;
        i = 0;
        break;
        j = 0;
        break label107;
      }
      label386:
      if (paramIntent == null)
      {
        i = 2;
        if (i != 6) {
          break label486;
        }
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(4);
        ((com.tencent.mm.plugin.finder.viewmodel.d.a)localObject1).a(d.d.GKM);
        ((com.tencent.mm.plugin.finder.viewmodel.d.a)localObject1).GKA = System.currentTimeMillis();
        localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.a(paramContext, paramIntent, i, false, 8);
      }
      for (;;)
      {
        paramContext = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
        com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999684);
        AppMethodBeat.o(331784);
        return;
        i = paramIntent.getIntExtra("FROM_SCENE_KEY", 2);
        break;
        label486:
        localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.a(paramContext, paramIntent, 0, false, 12);
      }
      label503:
      i = 0;
    }
  }
  
  public final void enterFinderTopicTimelineUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(331967);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "intent");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.hc(paramContext);
      AppMethodBeat.o(331967);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a.GfO.n(paramContext, paramIntent);
    AppMethodBeat.o(331967);
  }
  
  public final void enterFinderTopicUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(165101);
    kotlin.g.b.s.u(paramContext, "context");
    if (!showFinderEntry())
    {
      paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.hc(paramContext);
      AppMethodBeat.o(165101);
      return;
    }
    com.tencent.mm.plugin.finder.utils.a.GfO.A(paramContext, paramIntent);
    AppMethodBeat.o(165101);
  }
  
  public final void enterFinderTopicUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(331907);
    kotlin.g.b.s.u(paramContext, "context");
    enterFinderTopicUI(paramContext, paramString, null);
    AppMethodBeat.o(331907);
  }
  
  public final void enterFinderTopicUI(Context paramContext, String paramString, ca.a<Integer> parama)
  {
    AppMethodBeat.i(331921);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject2 = new com.tencent.mm.ad.i(paramString).Fs("extInfo");
    Object localObject1 = ((com.tencent.mm.ad.i)localObject2).optString("title");
    int i = ((com.tencent.mm.ad.i)localObject2).optInt("topicType");
    paramString = ((com.tencent.mm.ad.i)localObject2).optString("poiClassifyId");
    double d1 = ((com.tencent.mm.ad.i)localObject2).optDouble("longitude");
    double d2 = ((com.tencent.mm.ad.i)localObject2).optDouble("latitude");
    String str = ((com.tencent.mm.ad.i)localObject2).optString("eventEncryptedTopicId");
    int j = ((com.tencent.mm.ad.i)localObject2).optInt("entryScene");
    localObject2 = ((com.tencent.mm.ad.i)localObject2).optString("extraInfo");
    if (i == 7)
    {
      if ((!TextUtils.isEmpty((CharSequence)str)) && (parama != null))
      {
        com.tencent.mm.plugin.finder.utils.c localc = com.tencent.mm.plugin.finder.utils.c.GfS;
        if (parama != null)
        {
          paramString = UUID.randomUUID().toString();
          kotlin.g.b.s.s(paramString, "randomUUID().toString()");
          ((Map)localc.GfR).put(paramString, parama);
          if (!(paramContext instanceof Activity)) {
            break label205;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.ad.b.c.a(paramContext, str, (String)localObject1, null, j, (String)localObject2, paramString);
        AppMethodBeat.o(331921);
        return;
        paramString = "";
        break;
        label205:
        parama = ((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).bUR();
        if (parama != null) {
          paramContext = (Context)parama;
        }
      }
    }
    parama = new Intent();
    parama.putExtra("key_topic_title", (String)localObject1);
    parama.putExtra("key_topic_type", i);
    localObject1 = new boi();
    ((boi)localObject1).ZWG = paramString;
    ((boi)localObject1).longitude = ((float)d1);
    ((boi)localObject1).latitude = ((float)d2);
    try
    {
      parama.putExtra("key_topic_poi_location", ((boi)localObject1).toByteArray());
      if (36 == j)
      {
        paramString = com.tencent.mm.plugin.finder.report.n.FpH;
        paramString = com.tencent.mm.plugin.finder.report.n.eMA();
        localObject1 = (CharSequence)paramString;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label395;
        }
        i = 1;
        if (i == 0)
        {
          parama.putExtra("key_context_id", paramString);
          parama.putExtra("KEY_IGNORE_REPORT_INIT", true);
        }
      }
      enterFinderTopicUI(paramContext, parama);
      AppMethodBeat.o(331921);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("Finder.PluginFinder", "location toByteArray exception");
        continue;
        label395:
        i = 0;
      }
    }
  }
  
  public final void enterFinderUI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(331886);
    kotlin.g.b.s.u(paramContext, "context");
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (!com.tencent.mm.plugin.finder.storage.d.ePZ())
        {
          Log.i("Finder.PluginFinder", "enterFinderUI clicfg_ultron_finder_mp_jsapi switch close");
          AppMethodBeat.o(331886);
          return;
        }
        localObject = new com.tencent.mm.ad.i(paramString).Fs("extInfo");
        str = ((com.tencent.mm.ad.i)localObject).getString("action");
        Log.i("Finder.PluginFinder", kotlin.g.b.s.X("json = ", paramString));
        if (str != null) {}
        switch (str.hashCode())
        {
        case 50881657: 
          Log.i("Finder.PluginFinder", kotlin.g.b.s.X("unKnow action:", str));
          AppMethodBeat.o(331886);
          return;
        }
      }
      finally
      {
        Log.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderUI exception", new Object[0]);
        AppMethodBeat.o(331886);
        return;
      }
      if (str.equals("openFinderProfile"))
      {
        kotlin.g.b.s.s(localObject, "extInfo");
        openFinderProfile$default(this, (com.tencent.mm.ad.i)localObject, paramContext, null, null, 8, null);
        AppMethodBeat.o(331886);
        return;
        if (str.equals("autoOpenFinderLive"))
        {
          paramString = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
          kotlin.g.b.s.s(localObject, "extInfo");
          paramString.autoOpenFinderLive((JSONObject)localObject, paramContext, null, null);
          AppMethodBeat.o(331886);
          return;
          if (str.equals("createFinderLive"))
          {
            paramString = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
            localObject = ((com.tencent.mm.ad.i)localObject).toString();
            kotlin.g.b.s.s(localObject, "extInfo.toString()");
            paramString.createFinderLive(paramContext, (String)localObject);
            AppMethodBeat.o(331886);
            return;
            if (str.equals("createLuckyLive"))
            {
              paramString = ((com.tencent.mm.ad.i)localObject).optString("groupId");
              if (paramString == null) {
                paramString = "";
              }
              for (;;)
              {
                ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).createLuckyMoneyLive(paramContext, paramString);
                com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()) });
                AppMethodBeat.o(331886);
                return;
                if (!str.equals("openFinderMultiMoreLive")) {
                  break;
                }
                kotlin.g.b.s.s(localObject, "extInfo");
                openFinderLiveOperationUIFromJSAPI$default(this, (com.tencent.mm.ad.i)localObject, paramContext, null, null, 8, null);
                AppMethodBeat.o(331886);
                return;
                if (!str.equals("openFinderFeed")) {
                  break;
                }
                if ((paramContext instanceof Activity)) {}
                for (;;)
                {
                  kotlin.g.b.s.s(localObject, "extInfo");
                  openFinderFeed$default(this, (com.tencent.mm.ad.i)localObject, paramContext, null, null, false, 24, null);
                  AppMethodBeat.o(331886);
                  return;
                  paramString = ((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).bUR();
                  if (paramString != null) {
                    paramContext = (Context)paramString;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void enterFinderUIFromMiniApp(Context paramContext, String paramString, ca.a<Object> parama, ca.a<Integer> parama1)
  {
    AppMethodBeat.i(331933);
    kotlin.g.b.s.u(paramContext, "context");
    for (;;)
    {
      Object localObject;
      String str2;
      String str1;
      try
      {
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (!com.tencent.mm.plugin.finder.storage.d.ePZ())
        {
          Log.i("Finder.PluginFinder", "enterFinderUI clicfg_ultron_finder_mp_jsapi switch close");
          if (parama1 != null) {
            parama1.onCallback(Integer.valueOf(-1001));
          }
          AppMethodBeat.o(331933);
          return;
        }
        localObject = new com.tencent.mm.ad.i(paramString).Fs("extInfo");
        str2 = ((com.tencent.mm.ad.i)localObject).getString("action");
        str1 = ((com.tencent.mm.ad.i)localObject).optString("sourceId", "");
        Log.i("Finder.PluginFinder", "enterFinderUIFromMiniApp json = " + paramString + ", appid:" + str1);
        if (str2 != null) {}
        switch (str2.hashCode())
        {
        case 50881657: 
          Log.i("Finder.PluginFinder", kotlin.g.b.s.X("unKnow action:", str2));
          if (parama1 == null) {
            continue;
          }
          parama1.onCallback(Integer.valueOf(-1000));
          AppMethodBeat.o(331933);
          return;
        }
      }
      finally
      {
        Log.printErrStackTrace("Finder.PluginFinder", paramContext, "enterFinderUI exception", new Object[0]);
        if (parama1 == null) {
          continue;
        }
        parama1.onCallback(Integer.valueOf(-1002));
        AppMethodBeat.o(331933);
        return;
      }
      if (str2.equals("openFinderProfile"))
      {
        kotlin.g.b.s.s(localObject, "extInfo");
        kotlin.g.b.s.s(str1, "appid");
        openFinderProfile((com.tencent.mm.ad.i)localObject, paramContext, parama, str1);
        AppMethodBeat.o(331933);
        return;
        if (str2.equals("autoOpenFinderLive"))
        {
          paramString = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
          kotlin.g.b.s.s(localObject, "extInfo");
          paramString.autoOpenFinderLive((JSONObject)localObject, paramContext, parama, parama1);
          AppMethodBeat.o(331933);
          return;
          if (str2.equals("openFinderMultiMoreLive"))
          {
            kotlin.g.b.s.s(localObject, "extInfo");
            openFinderLiveOperationUIFromJSAPI$default(this, (com.tencent.mm.ad.i)localObject, paramContext, parama, null, 8, null);
            AppMethodBeat.o(331933);
            return;
            if (str2.equals("openFinderFeed"))
            {
              kotlin.g.b.s.s(localObject, "extInfo");
              kotlin.g.b.s.s(str1, "appid");
              openFinderFeed((com.tencent.mm.ad.i)localObject, paramContext, parama, str1, true);
              AppMethodBeat.o(331933);
              return;
              if (str2.equals("openFinderLive"))
              {
                paramContext = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
                kotlin.g.b.s.s(localObject, "extInfo");
                paramString = (JSONObject)localObject;
                kotlin.g.b.s.s(str1, "appid");
                paramContext.openFinderLive(paramString, parama1, parama, str1);
                AppMethodBeat.o(331933);
                return;
                if (str2.equals("openChannelsRewardedVideoAd"))
                {
                  paramString = this.AsI;
                  kotlin.g.b.s.s(localObject, "extInfo");
                  paramString.a(paramContext, (JSONObject)localObject, parama, parama1);
                  AppMethodBeat.o(331933);
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(162434);
    kotlin.g.b.s.u(paramg, "profile");
    paramg = com.tencent.mm.plugin.finder.trim.b.FNT;
    Log.i("MicroMsg.FinderLifecycleCallback", "init");
    Context localContext = MMApplicationContext.getContext();
    if (localContext == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type android.app.Application");
      AppMethodBeat.o(162434);
      throw paramg;
    }
    ((Application)localContext).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)paramg);
    com.tencent.mm.plugin.finder.trim.b.a((com.tencent.mm.plugin.finder.trim.a)new b.c());
    AppMethodBeat.o(162434);
  }
  
  public final String fillContextIdToIntent(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(332126);
    paramIntent = fillContextIdToIntent(genContextId(paramInt1, paramInt2, paramInt3), paramIntent);
    AppMethodBeat.o(332126);
    return paramIntent;
  }
  
  public final String fillContextIdToIntent(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(332134);
    if (paramIntent != null) {
      paramIntent.putExtra("key_context_id", paramString);
    }
    Log.i("Finder.PluginFinder", kotlin.g.b.s.X("fillContextIdToIntent USERINFO_FINDER_CONTEXT_ID_STRING:", paramString));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adeY, paramString);
    paramIntent = com.tencent.mm.plugin.finder.report.n.FpH;
    com.tencent.mm.plugin.finder.report.n.azI(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(332134);
      return "";
    }
    AppMethodBeat.o(332134);
    return paramString;
  }
  
  public final String genContextId(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(332141);
    String str = UUID.randomUUID().toString();
    kotlin.g.b.s.s(str, "randomUUID().toString()");
    str = kotlin.n.n.m(str, "-", "", false);
    str = paramInt1 + '-' + paramInt2 + '-' + paramInt3 + '-' + str;
    AppMethodBeat.o(332141);
    return str;
  }
  
  public final com.tencent.mm.plugin.finder.storage.f getContactStorage()
  {
    AppMethodBeat.i(165082);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.f localf2 = this.Aru;
    com.tencent.mm.plugin.finder.storage.f localf1 = localf2;
    if (localf2 == null) {
      localf1 = new com.tencent.mm.plugin.finder.storage.f((ISQLiteDatabase)getDB());
    }
    this.Aru = localf1;
    localf1 = this.Aru;
    kotlin.g.b.s.checkNotNull(localf1);
    AppMethodBeat.o(165082);
    return localf1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.g getConversationStorage()
  {
    AppMethodBeat.i(331527);
    com.tencent.mm.plugin.finder.storage.g localg = this.Arx;
    Object localObject = localg;
    if (localg == null)
    {
      localObject = this.Ars;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = new com.tencent.mm.plugin.finder.storage.g((ISQLiteDatabase)localObject);
    }
    this.Arx = ((com.tencent.mm.plugin.finder.storage.g)localObject);
    localObject = this.Arx;
    kotlin.g.b.s.checkNotNull(localObject);
    AppMethodBeat.o(331527);
    return localObject;
  }
  
  public final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(165080);
    checkResetDb();
    com.tencent.mm.storagebase.h localh = this.mCN;
    kotlin.g.b.s.checkNotNull(localh);
    AppMethodBeat.o(165080);
    return localh;
  }
  
  public final com.tencent.mm.storagebase.h getDataDB()
  {
    return this.mCN;
  }
  
  public final com.tencent.mm.plugin.finder.storage.logic.b getDraftStorage()
  {
    AppMethodBeat.i(331571);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.logic.b localb2 = this.ArD;
    com.tencent.mm.plugin.finder.storage.logic.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = new com.tencent.mm.plugin.finder.storage.logic.b((ISQLiteDatabase)getDB());
    }
    this.ArD = localb1;
    localb1 = this.ArD;
    kotlin.g.b.s.checkNotNull(localb1);
    AppMethodBeat.o(331571);
    return localb1;
  }
  
  public final long getFINDER_FOLDER_LRU_EXPIRE()
  {
    AppMethodBeat.i(331659);
    long l = MultiProcessMMKV.getDefault().getInt("FINDER_FOLDER_LRU_EXPIRE_DAY", 2) * 86400000L;
    Log.i("Finder.PluginFinder", kotlin.g.b.s.X("FINDER_FOLDER_MAX_SIZE ", Long.valueOf(l)));
    AppMethodBeat.o(331659);
    return l;
  }
  
  public final long getFINDER_FOLDER_MAX_SIZE()
  {
    AppMethodBeat.i(331654);
    long l = MultiProcessMMKV.getDefault().getInt("FINDER_FOLDER_MAX_SIZE_MB", 512) * 1048576L;
    Log.i("Finder.PluginFinder", kotlin.g.b.s.X("FINDER_FOLDER_MAX_SIZE ", Long.valueOf(l)));
    AppMethodBeat.o(331654);
    return l;
  }
  
  public final com.tencent.mm.plugin.finder.storage.n getFeedStorage()
  {
    AppMethodBeat.i(165083);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.n localn2 = this.ArC;
    com.tencent.mm.plugin.finder.storage.n localn1 = localn2;
    if (localn2 == null) {
      localn1 = new com.tencent.mm.plugin.finder.storage.n((ISQLiteDatabase)getDB());
    }
    this.ArC = localn1;
    localn1 = this.ArC;
    kotlin.g.b.s.checkNotNull(localn1);
    AppMethodBeat.o(165083);
    return localn1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.a getFinderActionStorage()
  {
    AppMethodBeat.i(165086);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.a locala2 = this.ArI;
    com.tencent.mm.plugin.finder.storage.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new com.tencent.mm.plugin.finder.storage.a((ISQLiteDatabase)getDB());
    }
    this.ArI = locala1;
    locala1 = this.ArI;
    kotlin.g.b.s.checkNotNull(locala1);
    AppMethodBeat.o(165086);
    return locala1;
  }
  
  public final com.tencent.mm.plugin.finder.api.b getFinderContactCache()
  {
    return this.Asj;
  }
  
  public final Context getFinderContext()
  {
    AppMethodBeat.i(332328);
    Object localObject = com.tencent.mm.plugin.finder.utils.j.Gge;
    localObject = (Context)com.tencent.mm.plugin.finder.utils.j.feL();
    AppMethodBeat.o(332328);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.finder.conv.i getFinderGlobalPushNewXmlConsumer()
  {
    AppMethodBeat.i(331441);
    com.tencent.mm.plugin.finder.conv.i locali = (com.tencent.mm.plugin.finder.conv.i)this.Asa.getValue();
    AppMethodBeat.o(331441);
    return locali;
  }
  
  public final com.tencent.mm.storagebase.h getFinderMentionDB()
  {
    return this.Arq;
  }
  
  public final bg getFinderOpenSdkApi()
  {
    return (bg)com.tencent.mm.plugin.finder.utils.ab.Ghc;
  }
  
  public final com.tencent.mm.plugin.finder.storage.ag getFinderOrAliasDeletingInfoStorage()
  {
    AppMethodBeat.i(331546);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.ag localag = this.ArB;
    Object localObject = localag;
    if (localag == null)
    {
      localObject = this.Ars;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = new com.tencent.mm.plugin.finder.storage.ag((ISQLiteDatabase)localObject);
    }
    this.ArB = ((com.tencent.mm.plugin.finder.storage.ag)localObject);
    localObject = this.ArB;
    kotlin.g.b.s.checkNotNull(localObject);
    AppMethodBeat.o(331546);
    return localObject;
  }
  
  public final void getFinderRedDot(String paramString, ca.a<String> parama)
  {
    AppMethodBeat.i(331874);
    if (paramString != null) {}
    for (;;)
    {
      int j;
      try
      {
        Object localObject2 = new com.tencent.mm.ad.i(paramString);
        Object localObject1 = ((com.tencent.mm.ad.i)localObject2).optString("businessType");
        Log.i("Finder.PluginFinder", "getFinderRedDot json: " + paramString + " businessType:" + localObject1);
        localObject1 = new HashSet();
        paramString = ((com.tencent.mm.ad.i)localObject2).opt("redDotPath");
        Log.i("Finder.PluginFinder", kotlin.g.b.s.X("redDotPath :", paramString));
        if ((paramString instanceof String))
        {
          paramString = new com.tencent.mm.ad.f((String)paramString);
          int k = paramString.length();
          if (k > 0)
          {
            i = 0;
            j = i + 1;
            localObject2 = paramString.get(i).toString();
            Log.i("Finder.PluginFinder", kotlin.g.b.s.X("getFinderRedDot path:", localObject2));
            ((HashSet)localObject1).add(localObject2);
            if (j < k) {
              break label281;
            }
          }
          paramString = com.tencent.mm.plugin.finder.extension.reddot.e.AQg;
          paramString = com.tencent.mm.plugin.finder.extension.reddot.e.b((HashSet)localObject1);
          Log.i("Finder.PluginFinder", kotlin.g.b.s.X("redDots :", paramString));
          if (parama != null)
          {
            parama.onCallback(paramString);
            paramString = ah.aiuX;
          }
          AppMethodBeat.o(331874);
          return;
        }
        if ((paramString instanceof com.tencent.mm.ad.f))
        {
          kotlin.g.b.s.s(paramString, "{\n                      …ath\n                    }");
          paramString = (com.tencent.mm.ad.f)paramString;
          continue;
        }
        paramString = new com.tencent.mm.ad.f("");
        continue;
        AppMethodBeat.o(331874);
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("Finder.PluginFinder", (Throwable)paramString, "getFinderRedDot exception", new Object[0]);
        paramString = ah.aiuX;
      }
      return;
      label281:
      int i = j;
    }
  }
  
  public final bvl getFinderShareObject(FinderObject paramFinderObject, boolean paramBoolean)
  {
    AppMethodBeat.i(332303);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    Object localObject = com.tencent.mm.plugin.finder.utils.an.GhR;
    localObject = FinderItem.Companion;
    paramFinderObject = an.a.d(FinderItem.a.e(paramFinderObject, paramFinderObject.objectType), paramBoolean);
    AppMethodBeat.o(332303);
    return paramFinderObject;
  }
  
  public final bv getFinderSwitchApi()
  {
    return (bv)com.tencent.mm.plugin.finder.utils.aq.Giv;
  }
  
  public final com.tencent.mm.plugin.finder.api.j getFinderSyncExtension()
  {
    return (com.tencent.mm.plugin.finder.api.j)this.Art;
  }
  
  public final bz getFinderUIApi()
  {
    return (bz)au.GiJ;
  }
  
  public final ca getFinderUtilApi()
  {
    return (ca)this.AsI;
  }
  
  public final com.tencent.mm.loader.f.h getFollowTlSingleExecutor()
  {
    AppMethodBeat.i(331445);
    com.tencent.mm.loader.f.h localh = (com.tencent.mm.loader.f.h)this.Asm.getValue();
    AppMethodBeat.o(331445);
    return localh;
  }
  
  public final void getIncomePageInfoAndEnterIncome(Context paramContext)
  {
    AppMethodBeat.i(332271);
    kotlin.g.b.s.u(paramContext, "context");
    String str = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str, "getMyFinderUsername()");
    com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)com.tencent.mm.plugin.findersdk.b.c.a((com.tencent.mm.plugin.findersdk.b.c)new com.tencent.mm.plugin.finder.cgi.s(str), paramContext, 0L, 6).bFJ(), (kotlin.g.a.b)new n(paramContext));
    AppMethodBeat.o(332271);
  }
  
  public final com.tencent.mm.plugin.finder.storage.t getLocalLikeFeedStorage()
  {
    AppMethodBeat.i(331609);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.t localt2 = this.ArJ;
    com.tencent.mm.plugin.finder.storage.t localt1 = localt2;
    if (localt2 == null) {
      localt1 = new com.tencent.mm.plugin.finder.storage.t((ISQLiteDatabase)getDB());
    }
    this.ArJ = localt1;
    localt1 = this.ArJ;
    kotlin.g.b.s.checkNotNull(localt1);
    AppMethodBeat.o(331609);
    return localt1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.u getMediaCacheStorage()
  {
    AppMethodBeat.i(165084);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.u localu2 = this.ArE;
    com.tencent.mm.plugin.finder.storage.u localu1 = localu2;
    if (localu2 == null) {
      localu1 = new com.tencent.mm.plugin.finder.storage.u((ISQLiteDatabase)getDB());
    }
    this.ArE = localu1;
    localu1 = this.ArE;
    kotlin.g.b.s.checkNotNull(localu1);
    AppMethodBeat.o(165084);
    return localu1;
  }
  
  public final com.tencent.mm.plugin.finder.preload.model.b getMediaPreloadModel()
  {
    AppMethodBeat.i(331453);
    com.tencent.mm.plugin.finder.preload.model.b localb = (com.tencent.mm.plugin.finder.preload.model.b)this.Asp.getValue();
    AppMethodBeat.o(331453);
    return localb;
  }
  
  public final MAutoStorage<cz> getMentionStorage(int paramInt)
  {
    AppMethodBeat.i(331592);
    com.tencent.mm.kernel.h.baC().aZJ();
    checkResetDb();
    if (paramInt == 1)
    {
      localObject2 = this.ArG;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.Arr;
        kotlin.g.b.s.checkNotNull(localObject1);
        localObject1 = new com.tencent.mm.plugin.finder.storage.aq((ISQLiteDatabase)localObject1);
      }
      this.ArG = ((com.tencent.mm.plugin.finder.storage.aq)localObject1);
      localObject1 = this.ArG;
      kotlin.g.b.s.checkNotNull(localObject1);
      localObject1 = (MAutoStorage)localObject1;
      AppMethodBeat.o(331592);
      return localObject1;
    }
    Object localObject2 = this.ArH;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.Arq;
      kotlin.g.b.s.checkNotNull(localObject1);
      localObject1 = new com.tencent.mm.plugin.finder.storage.o((ISQLiteDatabase)localObject1);
    }
    this.ArH = ((com.tencent.mm.plugin.finder.storage.o)localObject1);
    localObject1 = this.ArH;
    kotlin.g.b.s.checkNotNull(localObject1);
    localObject1 = (MAutoStorage)localObject1;
    AppMethodBeat.o(331592);
    return localObject1;
  }
  
  public final com.tencent.mm.storagebase.h getMessageDB()
  {
    return this.Ars;
  }
  
  public final com.tencent.mm.plugin.finder.storage.x getMessageStorage()
  {
    AppMethodBeat.i(331555);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ();
    com.tencent.mm.plugin.finder.storage.x localx2 = this.ArA;
    com.tencent.mm.plugin.finder.storage.x localx1 = localx2;
    if (localx2 == null)
    {
      kotlin.g.b.s.s(locali, "msgStg");
      localx1 = new com.tencent.mm.plugin.finder.storage.x(locali);
    }
    this.ArA = localx1;
    localx1 = this.ArA;
    kotlin.g.b.s.checkNotNull(localx1);
    AppMethodBeat.o(331555);
    return localx1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.aa getMsgAliasContactStorage()
  {
    AppMethodBeat.i(331520);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.aa localaa2 = this.Arw;
    com.tencent.mm.plugin.finder.storage.aa localaa1 = localaa2;
    if (localaa2 == null) {
      localaa1 = new com.tencent.mm.plugin.finder.storage.aa((ISQLiteDatabase)getDB());
    }
    this.Arw = localaa1;
    localaa1 = this.Arw;
    kotlin.g.b.s.checkNotNull(localaa1);
    AppMethodBeat.o(331520);
    return localaa1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.ab getMsgStrangerContactStorage()
  {
    AppMethodBeat.i(331514);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.ab localab2 = this.Arv;
    com.tencent.mm.plugin.finder.storage.ab localab1 = localab2;
    if (localab2 == null) {
      localab1 = new com.tencent.mm.plugin.finder.storage.ab((ISQLiteDatabase)getDB());
    }
    this.Arv = localab1;
    localab1 = this.Arv;
    kotlin.g.b.s.checkNotNull(localab1);
    AppMethodBeat.o(331514);
    return localab1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.ad getNewXmlStorage()
  {
    AppMethodBeat.i(331624);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.ad localad2 = this.ArL;
    com.tencent.mm.plugin.finder.storage.ad localad1 = localad2;
    if (localad2 == null) {
      localad1 = new com.tencent.mm.plugin.finder.storage.ad((ISQLiteDatabase)getDB());
    }
    this.ArL = localad1;
    localad1 = this.ArL;
    kotlin.g.b.s.checkNotNull(localad1);
    AppMethodBeat.o(331624);
    return localad1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.f getRedDotCtrInfoStorage()
  {
    AppMethodBeat.i(178074);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.extension.reddot.f localf2 = this.ArF;
    com.tencent.mm.plugin.finder.extension.reddot.f localf1 = localf2;
    if (localf2 == null) {
      localf1 = new com.tencent.mm.plugin.finder.extension.reddot.f((ISQLiteDatabase)getDB());
    }
    this.ArF = localf1;
    localf1 = this.ArF;
    kotlin.g.b.s.checkNotNull(localf1);
    AppMethodBeat.o(178074);
    return localf1;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.i getRedDotManager()
  {
    AppMethodBeat.i(178072);
    if (this.Asl == null) {}
    try
    {
      if (this.Asl == null) {
        this.Asl = new com.tencent.mm.plugin.finder.extension.reddot.i(getRedDotCtrInfoStorage());
      }
      Object localObject1 = ah.aiuX;
      localObject1 = this.Asl;
      kotlin.g.b.s.checkNotNull(localObject1);
      AppMethodBeat.o(178072);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(178072);
    }
  }
  
  public final com.tencent.mm.plugin.finder.storage.ak getSessionInfoStorage()
  {
    AppMethodBeat.i(331539);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.ak localak = this.Arz;
    Object localObject = localak;
    if (localak == null)
    {
      localObject = this.Ars;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = new com.tencent.mm.plugin.finder.storage.ak((ISQLiteDatabase)localObject);
    }
    this.Arz = ((com.tencent.mm.plugin.finder.storage.ak)localObject);
    localObject = this.Arz;
    kotlin.g.b.s.checkNotNull(localObject);
    AppMethodBeat.o(331539);
    return localObject;
  }
  
  public final al getShareInfoStorage()
  {
    AppMethodBeat.i(331533);
    al localal2 = this.Ary;
    al localal1 = localal2;
    if (localal2 == null) {
      localal1 = new al((ISQLiteDatabase)getDB());
    }
    this.Ary = localal1;
    localal1 = this.Ary;
    kotlin.g.b.s.checkNotNull(localal1);
    AppMethodBeat.o(331533);
    return localal1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.an getSnsKeyWordsStorage()
  {
    AppMethodBeat.i(331617);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.finder.storage.an localan2 = this.ArK;
    com.tencent.mm.plugin.finder.storage.an localan1 = localan2;
    if (localan2 == null) {
      localan1 = new com.tencent.mm.plugin.finder.storage.an((ISQLiteDatabase)getDB());
    }
    this.ArK = localan1;
    localan1 = this.ArK;
    kotlin.g.b.s.checkNotNull(localan1);
    AppMethodBeat.o(331617);
    return localan1;
  }
  
  public final int getTimelineCommentScene()
  {
    AppMethodBeat.i(332107);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    int i = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).fmM();
    localObject = av.GiL;
    i = av.Uc(i);
    if (-1 == i)
    {
      AppMethodBeat.o(332107);
      return 1;
    }
    AppMethodBeat.o(332107);
    return i;
  }
  
  public final com.tencent.mm.storagebase.h getWxMentionDB()
  {
    return this.Arr;
  }
  
  public final boolean hasFinderPosted()
  {
    AppMethodBeat.i(332113);
    String str = com.tencent.mm.model.z.bAW();
    if (Util.isNullOrNil(com.tencent.mm.model.z.bAW()))
    {
      AppMethodBeat.o(332113);
      return false;
    }
    k.a locala = com.tencent.mm.plugin.finder.storage.data.k.FNg;
    kotlin.g.b.s.s(str, "username");
    if (!((Collection)locala.eO(str, 1)).isEmpty())
    {
      AppMethodBeat.o(332113);
      return true;
    }
    AppMethodBeat.o(332113);
    return false;
  }
  
  public final boolean isAllowEditFillingFullScreen()
  {
    AppMethodBeat.i(332226);
    av localav = av.GiL;
    av.fgi();
    if (av.GiV == 1)
    {
      AppMethodBeat.o(332226);
      return true;
    }
    AppMethodBeat.o(332226);
    return false;
  }
  
  public final boolean isDisablePostHalfScreen()
  {
    AppMethodBeat.i(332221);
    av localav = av.GiL;
    boolean bool = av.isDisablePostHalfScreen();
    AppMethodBeat.o(332221);
    return bool;
  }
  
  public final boolean isFriend(String paramString)
  {
    AppMethodBeat.i(165116);
    if (paramString != null)
    {
      Boolean localBoolean = (Boolean)this.AsH.get(paramString);
      Object localObject = localBoolean;
      if (localBoolean == null)
      {
        localObject = av.GiL;
        localObject = Boolean.valueOf(av.isFriend(paramString));
        ((Map)this.AsH).put(paramString, localObject);
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
    if (this.Asv.pFd.size() > 0)
    {
      AppMethodBeat.o(165097);
      return true;
    }
    AppMethodBeat.o(165097);
    return false;
  }
  
  public final Boolean isPagEnable()
  {
    AppMethodBeat.i(332173);
    com.tencent.mm.plugin.expansions.b localb = com.tencent.mm.plugin.expansions.b.yFu;
    boolean bool = com.tencent.mm.plugin.expansions.b.isInstalled("xlab");
    AppMethodBeat.o(332173);
    return Boolean.valueOf(bool);
  }
  
  public final void loadAvatar(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(331823);
    kotlin.g.b.s.u(paramString, "url");
    kotlin.g.b.s.u(paramImageView, "avatarIv");
    Object localObject = new dji();
    ((dji)localObject).mediaId = MD5Util.getMD5String(paramString);
    ((dji)localObject).url = paramString;
    ((dji)localObject).thumbUrl = paramString;
    paramString = new com.tencent.mm.plugin.finder.loader.n((dji)localObject, com.tencent.mm.plugin.finder.storage.v.FKZ, null, null, 12);
    localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject).a(paramString, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM)).d(paramImageView);
    AppMethodBeat.o(331823);
  }
  
  public final Object loadImage(String paramString, kotlin.d.d<? super Bitmap> paramd)
  {
    AppMethodBeat.i(331813);
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(331813);
      return null;
    }
    Object localObject1 = new dji();
    ((dji)localObject1).mediaId = MD5Util.getMD5String(paramString);
    ((dji)localObject1).url = paramString;
    ((dji)localObject1).thumbUrl = paramString;
    paramString = new com.tencent.mm.plugin.finder.loader.n((dji)localObject1, com.tencent.mm.plugin.finder.storage.v.FKZ, null, null, 12);
    localObject1 = new kotlinx.coroutines.q(kotlin.d.a.b.au(paramd), 1);
    ((kotlinx.coroutines.q)localObject1).kBA();
    kotlinx.coroutines.p localp = (kotlinx.coroutines.p)localObject1;
    Object localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
    com.tencent.mm.plugin.finder.loader.p localp1 = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject2).a(paramString, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ)).a((com.tencent.mm.loader.e.e)new o(localp)).blg();
    paramString = ((kotlinx.coroutines.q)localObject1).getResult();
    if (paramString == kotlin.d.a.a.aiwj) {
      kotlin.g.b.s.u(paramd, "frame");
    }
    AppMethodBeat.o(331813);
    return paramString;
  }
  
  public final void loadImage(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(178075);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; (i != 0) || (paramImageView == null); i = 0)
    {
      AppMethodBeat.o(178075);
      return;
    }
    localObject = new dji();
    ((dji)localObject).mediaId = MD5Util.getMD5String(paramString);
    ((dji)localObject).url = paramString;
    ((dji)localObject).thumbUrl = paramString;
    paramString = new com.tencent.mm.plugin.finder.loader.n((dji)localObject, com.tencent.mm.plugin.finder.storage.v.FKZ, null, null, 12);
    localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject = com.tencent.mm.plugin.finder.loader.p.eCl();
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject).a(paramString, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ)).d(paramImageView);
    AppMethodBeat.o(178075);
  }
  
  public final void loadImage(String paramString1, String paramString2, String paramString3, ImageView paramImageView, kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(331817);
    kotlin.g.b.s.u(paramString1, "url");
    kotlin.g.b.s.u(paramString2, "urlToken");
    kotlin.g.b.s.u(paramString3, "decodeKey");
    kotlin.g.b.s.u(paramImageView, "imageView");
    kotlin.g.b.s.u(paramb, "call");
    paramImageView = new dji();
    paramImageView.mediaId = MD5Util.getMD5String(paramString1);
    paramImageView.url = paramString1;
    paramImageView.url_token = paramString2;
    paramImageView.decodeKey = paramString3;
    paramString1 = new com.tencent.mm.plugin.finder.loader.n(paramImageView, com.tencent.mm.plugin.finder.storage.v.FKY, null, null, 12);
    paramString2 = com.tencent.mm.plugin.finder.loader.p.ExI;
    paramString2 = com.tencent.mm.plugin.finder.loader.p.eCl();
    paramString3 = com.tencent.mm.plugin.finder.loader.p.ExI;
    paramString2.a(paramString1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ)).a(new PluginFinder..ExternalSyntheticLambda1(paramb)).blg();
    AppMethodBeat.o(331817);
  }
  
  public final void loadImageForSns(String paramString, View paramView)
  {
    AppMethodBeat.i(331467);
    kotlin.g.b.s.u(paramView, "qImageView");
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    com.tencent.mm.plugin.finder.loader.p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s(paramString, com.tencent.mm.plugin.finder.storage.v.FKY)).a(new PluginFinder..ExternalSyntheticLambda0(paramView)).Td();
    AppMethodBeat.o(331467);
  }
  
  public final void loadNotWxUrlImage(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(331807);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(331807);
      return;
    }
    if (paramImageView != null)
    {
      localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject = com.tencent.mm.plugin.finder.loader.p.eCn();
      paramString = new com.tencent.mm.plugin.finder.loader.s(paramString, com.tencent.mm.plugin.finder.storage.v.FKZ);
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
    }
    AppMethodBeat.o(331807);
  }
  
  public final void loadRingtoneBgImage(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(331799);
    kotlin.g.b.s.u(paramString, "url");
    Object localObject = new dji();
    ((dji)localObject).mediaId = MD5Util.getMD5String(paramString);
    ((dji)localObject).url = paramString;
    ((dji)localObject).thumbUrl = paramString;
    paramString = new com.tencent.mm.plugin.finder.loader.n((dji)localObject, com.tencent.mm.plugin.finder.storage.v.FKZ, null, null, 12);
    if (paramImageView == null)
    {
      paramImageView = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramImageView = com.tencent.mm.plugin.finder.loader.p.eCm();
      localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramImageView.a(paramString, com.tencent.mm.plugin.finder.loader.p.a(p.a.Eya)).blg();
      AppMethodBeat.o(331799);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject = com.tencent.mm.plugin.finder.loader.p.eCm();
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject).a(paramString, com.tencent.mm.plugin.finder.loader.p.a(p.a.Eya)).d(paramImageView);
    AppMethodBeat.o(331799);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(162435);
    com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 40L, 1L);
    this.Arp = true;
    checkResetDb();
    paramc = com.tencent.mm.kernel.h.baE().ban().get(at.a.adbt, this.Aso);
    Log.i("Finder.PluginFinder", "[onAccountInitialized] Log appendIsSync=" + XLogSetup.appendIsSync + ' ' + this.Arp + ' ' + this.Asn + ' ' + paramc);
    if (!kotlin.g.b.s.p(com.tencent.mm.kernel.h.baE().ban().get(at.a.adbt, this.Asn), this.Asn))
    {
      Log.i("Finder.PluginFinder", "resetConfig oldVer:" + paramc + " CURRENT_DB_VERSION:" + this.Asn);
      resetConfig();
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adbt, this.Asn);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adda, -1);
    boolean bool;
    Object localObject1;
    label1534:
    String str;
    label1638:
    label1775:
    com.tencent.mm.plugin.finder.upload.action.g localg;
    if (i == -1)
    {
      int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcY, 0);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adda, Integer.valueOf(j));
      Log.i("Finder.PluginFinder", "[onAccountInitialized] user auto increment id=" + i + " userVersion=" + j);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.h.class, (com.tencent.mm.kernel.c.a)this.Asv);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.l.class, (com.tencent.mm.kernel.c.a)this.Asw);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.f.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.finder.utils.a.GfO);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.i.class, (com.tencent.mm.kernel.c.a)this.Asv);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a((com.tencent.mm.storage.e)getMessageStorage());
      com.tencent.mm.kernel.h.b(bw.class, (com.tencent.mm.kernel.c.a)getFinderTeenModeConfig());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.ac.class, (com.tencent.mm.kernel.c.a)this.Ash);
      com.tencent.mm.kernel.h.b(bt.class, (com.tencent.mm.kernel.c.a)getFinderSnsKeyWordService());
      com.tencent.mm.kernel.h.b(bq.class, (com.tencent.mm.kernel.c.a)this.Asx);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.ad.class, (com.tencent.mm.kernel.c.a)this.Asy);
      paramc = com.tencent.mm.plugin.finder.cgi.bj.ABo;
      com.tencent.mm.plugin.finder.cgi.bj.dVw();
      doSomethingImportantOnStart();
      paramc = com.tencent.mm.plugin.finder.shell.b.FAb;
      com.tencent.mm.plugin.finder.shell.b.setup();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adab, "");
      com.tencent.mm.kernel.h.aZW().a(3565, (com.tencent.mm.am.h)this.Art);
      com.tencent.mm.kernel.h.aZW().a(3512, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArM);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArP);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArQ);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArR);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArS);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArT);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArU);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArV);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArW);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArX);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.Ase);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.Asf);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.Asg);
      com.tencent.mm.kernel.h.aZW().a(3870, (com.tencent.mm.am.h)this.ArY);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.r.class, (com.tencent.mm.kernel.c.a)this.ArM);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.ag.class, (com.tencent.mm.kernel.c.a)this.ArN);
      com.tencent.mm.kernel.h.b(cb.class, (com.tencent.mm.kernel.c.a)this.ArO);
      com.tencent.mm.kernel.h.b(bf.class, (com.tencent.mm.kernel.c.a)this.ArP);
      com.tencent.mm.kernel.h.b(bc.class, (com.tencent.mm.kernel.c.a)this.ArQ);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.x.class, (com.tencent.mm.kernel.c.a)this.ArR);
      com.tencent.mm.kernel.h.b(ba.class, (com.tencent.mm.kernel.c.a)this.ArS);
      com.tencent.mm.kernel.h.b(be.class, (com.tencent.mm.kernel.c.a)this.ArT);
      com.tencent.mm.kernel.h.b(bb.class, (com.tencent.mm.kernel.c.a)this.ArU);
      com.tencent.mm.kernel.h.b(cd.class, (com.tencent.mm.kernel.c.a)this.ArV);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.q.class, (com.tencent.mm.kernel.c.a)this.ArW);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.p.class, (com.tencent.mm.kernel.c.a)this.ArX);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.o.class, (com.tencent.mm.kernel.c.a)this.Ase);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.n.class, (com.tencent.mm.kernel.c.a)this.Asf);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.finder.service.m.class, (com.tencent.mm.kernel.c.a)this.Asg);
      com.tencent.mm.kernel.h.b(br.class, (com.tencent.mm.kernel.c.a)this.Asi);
      com.tencent.mm.kernel.h.b(bd.class, (com.tencent.mm.kernel.c.a)this.ArY);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("mmfinder_globalpush_newxml", (com.tencent.mm.plugin.messenger.foundation.a.s)getFinderGlobalPushNewXmlConsumer());
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("FinderPersonalMsgSysMsg", (com.tencent.mm.plugin.messenger.foundation.a.s)this.ArZ);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("finderuserreinit", (com.tencent.mm.plugin.messenger.foundation.a.s)this.Asb);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("FinderPromotion", (com.tencent.mm.plugin.messenger.foundation.a.s)this.Asc);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("FinderHotWordsJumpMsg", (com.tencent.mm.plugin.messenger.foundation.a.s)this.Asd);
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.r.class)).a((com.tencent.mm.plugin.messenger.foundation.a.z)new s());
      bool = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderActionStorage().db.execSQL("FinderAction", "DELETE FROM FinderAction WHERE actionType = 1");
      Log.i(com.tencent.mm.plugin.finder.storage.a.TAG, "cleanCanRemoveFeed ret" + bool + ' ' + "DELETE FROM FinderAction WHERE actionType = 1");
      if (showFinderEntry()) {
        com.tencent.threadpool.h.ahAA.bm(PluginFinder..ExternalSyntheticLambda30.INSTANCE);
      }
      paramc = com.tencent.mm.plugin.finder.api.d.AwY;
      paramc = com.tencent.mm.plugin.finder.api.d.a.dUc();
      paramc.Axl = true;
      com.tencent.mm.plugin.finder.api.d.a.f(paramc);
      this.Asr.alive();
      this.Ask.Ggo.alive();
      paramc = com.tencent.mm.plugin.finder.upload.action.l.Gdj;
      com.tencent.mm.plugin.finder.upload.action.l.fek();
      AppForegroundDelegate.heY.a((com.tencent.mm.app.q)this.AsE);
      com.tencent.mm.app.ac.aCN().a((ac.b)this.AsF);
      paramc = ay.EDk;
      ay.Px();
      paramc = com.tencent.mm.plugin.finder.storage.data.v.FNs;
      com.tencent.mm.plugin.finder.storage.data.v.setup();
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new PluginFinder.t(this));
      paramc = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).setup();
      com.tencent.mm.kernel.h.b(bp.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.service.i());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.y.class, (com.tencent.mm.kernel.c.a)getFinderContactService());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.findersdk.a.z.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.service.b());
      com.tencent.mm.kernel.h.b(bi.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.service.h());
      com.tencent.mm.kernel.h.b(ae.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.finder.report.l.Fpv);
      com.tencent.mm.kernel.h.b(bm.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.finder.report.z.FrZ);
      paramc = com.tencent.mm.plugin.finder.megavideo.floatball.b.EzA;
      paramc = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class);
      if (paramc != null)
      {
        com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new b.a.a(paramc));
        ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).a(22, com.tencent.mm.plugin.finder.megavideo.floatball.b.egs());
      }
      paramc = com.tencent.mm.plugin.finder.floatball.b.BtK;
      paramc = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class);
      if (paramc != null) {
        paramc.a(32, com.tencent.mm.plugin.finder.floatball.b.egs());
      }
      paramc = com.tencent.mm.plugin.finder.feed.d.ATN;
      if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adef, false))
      {
        paramc = com.tencent.mm.plugin.finder.storage.d.FAy;
        i = ((Number)com.tencent.mm.plugin.finder.storage.d.eUF().bmg()).intValue();
        Log.i("Finder.FinderBulletSubtitlePresenter", kotlin.g.b.s.X("initSwitch: exptValue = ", Integer.valueOf(i)));
        if (i != 0)
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adef, Boolean.TRUE);
          paramc = com.tencent.mm.kernel.h.baE().ban();
          localObject1 = at.a.adee;
          if (i == 1) {
            break label2059;
          }
          bool = true;
          paramc.set((at.a)localObject1, Boolean.valueOf(bool));
        }
      }
      paramc = com.tencent.mm.plugin.finder.megavideo.multitask.a.EzW;
      ((com.tencent.mm.plugin.taskbar.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.taskbar.api.b.class)).a(22, (com.tencent.mm.plugin.taskbar.api.b.a)com.tencent.mm.plugin.finder.megavideo.multitask.a.eCM());
      ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(22, com.tencent.mm.plugin.finder.megavideo.uic.d.class);
      paramc = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = (com.tencent.mm.plugin.finder.viewmodel.teenmode.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.teenmode.d.class);
      Log.i("FinderTeenModeLimitVM", "FinderTeenModeLimitVM init");
      paramc = MMApplicationContext.getContext().getApplicationContext();
      if (!(paramc instanceof Application)) {
        break label2065;
      }
      paramc = (Application)paramc;
      if (paramc != null) {
        paramc.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)((com.tencent.mm.plugin.finder.viewmodel.teenmode.d)localObject1).GWP);
      }
      ((com.tencent.mm.plugin.finder.viewmodel.teenmode.d)localObject1).GWQ.alive();
      registerTeenModeGuardian();
      ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a("5", (com.tencent.mm.plugin.textstatus.a.o)new com.tencent.mm.plugin.finder.provider.a());
      paramc = av.GiL;
      av.fgp();
      refreshXLabConfigToMMKV();
      paramc = com.tencent.mm.plugin.finder.upload.action.f.GcR;
      Log.i("Finder.FeedCleaner", "onAccountInit");
      paramc = com.tencent.mm.model.z.bAW();
      kotlin.g.b.s.s(paramc, "getMyFinderUsername()");
      com.tencent.mm.plugin.finder.upload.action.f.zDJ = paramc;
      if (com.tencent.mm.plugin.finder.upload.action.f.GcW.containsKey(com.tencent.mm.plugin.finder.upload.action.f.zDJ))
      {
        paramc = com.tencent.mm.plugin.finder.upload.action.f.GcW.get(com.tencent.mm.plugin.finder.upload.action.f.zDJ);
        kotlin.g.b.s.checkNotNull(paramc);
        com.tencent.mm.plugin.finder.upload.action.f.GcV = (com.tencent.mm.plugin.finder.upload.action.f.a)paramc;
      }
      paramc = com.tencent.mm.plugin.finder.upload.action.f.GcV;
      if (paramc != null) {
        break label2070;
      }
      paramc = null;
      if (paramc == null)
      {
        com.tencent.mm.plugin.finder.upload.action.f.GcS = new com.tencent.mm.plugin.finder.upload.action.g();
        com.tencent.mm.plugin.finder.upload.action.f.GcT = new com.tencent.mm.plugin.finder.upload.action.g();
        com.tencent.mm.plugin.finder.upload.action.f.GcU = new com.tencent.mm.plugin.finder.upload.action.g();
        str = com.tencent.mm.plugin.finder.upload.action.f.zDJ;
        localObject1 = com.tencent.mm.plugin.finder.upload.action.f.GcS;
        paramc = (f.c)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("followRecorder");
          paramc = null;
        }
        localg = com.tencent.mm.plugin.finder.upload.action.f.GcT;
        localObject1 = localg;
        if (localg == null)
        {
          kotlin.g.b.s.bIx("noSeeAuthorRecorder");
          localObject1 = null;
        }
        localg = com.tencent.mm.plugin.finder.upload.action.f.GcU;
        if (localg != null) {
          break label2098;
        }
        kotlin.g.b.s.bIx("noSeeFriend");
      }
    }
    for (;;)
    {
      paramc = new com.tencent.mm.plugin.finder.upload.action.f.a(str, paramc, (com.tencent.mm.plugin.finder.upload.action.g)localObject1, (com.tencent.mm.plugin.finder.upload.action.g)localObject2);
      ((Map)com.tencent.mm.plugin.finder.upload.action.f.GcW).put(com.tencent.mm.plugin.finder.upload.action.f.zDJ, paramc);
      com.tencent.mm.plugin.finder.upload.action.f.GcV = paramc;
      this.Asz.alive();
      this.AsA.alive();
      com.tencent.mm.plugin.byp.c.f.waY.a((com.tencent.mm.plugin.byp.c.e)getPrivateMsgConfig());
      paramc = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eWW().bmg()).intValue() == 1)
      {
        paramc = com.tencent.mm.plugin.findersdk.f.b.HeJ;
        com.tencent.mm.plugin.findersdk.f.b.enableDebug();
      }
      com.tencent.mm.plugin.sns.cover.a.f.her().QkR = ((com.tencent.mm.plugin.sns.cover.a.f.a)new PluginFinder.u());
      ((com.tencent.mm.plugin.recordvideo.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.recordvideo.a.class)).registerAccessibilityConfig(com.tencent.mm.plugin.finder.accessibility.t.class);
      com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)com.tencent.mm.plugin.finder.debugconfig.a.ANf, new String[] { "//fdc" });
      paramc = com.tencent.mm.plugin.finder.report.jump.b.FuP;
      com.tencent.mm.plugin.finder.report.jump.b.eOa();
      com.tencent.mm.plugin.finder.report.jump.b.aoW();
      getFinderGlobalPushNewXmlConsumer().dWT();
      AppMethodBeat.o(162435);
      return;
      Log.i("Finder.PluginFinder", kotlin.g.b.s.X("[onAccountInitialized] user auto increment id=", Integer.valueOf(i)));
      break;
      label2059:
      bool = false;
      break label1534;
      label2065:
      paramc = null;
      break label1638;
      label2070:
      com.tencent.mm.plugin.finder.upload.action.f.GcS = paramc.GcS;
      com.tencent.mm.plugin.finder.upload.action.f.GcT = paramc.GcT;
      com.tencent.mm.plugin.finder.upload.action.f.GcU = paramc.GcX;
      paramc = ah.aiuX;
      break label1775;
      label2098:
      localObject2 = localg;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(162436);
    Log.i("Finder.PluginFinder", "onAccountRelease");
    super.onAccountRelease();
    Object localObject = ay.EDk;
    com.tencent.mm.kernel.h.aZW().b(3520, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.aZW().b(3565, (com.tencent.mm.am.h)this.Art);
    com.tencent.mm.kernel.h.aZW().b(3512, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArM);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArP);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArQ);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArR);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArS);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArT);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArU);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArV);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArW);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArX);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.Ase);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.Asf);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.Asg);
    com.tencent.mm.kernel.h.aZW().b(3870, (com.tencent.mm.am.h)this.ArY);
    com.tencent.mm.kernel.h.aZW().b(665, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.h.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.f.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.i.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.findersdk.a.ag.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.l.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.finder.service.r.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.findersdk.a.ac.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.finder.service.q.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.finder.service.p.class);
    com.tencent.mm.kernel.h.ay(bf.class);
    com.tencent.mm.kernel.h.ay(ba.class);
    com.tencent.mm.kernel.h.ay(bc.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.findersdk.a.x.class);
    com.tencent.mm.kernel.h.ay(be.class);
    com.tencent.mm.kernel.h.ay(bb.class);
    com.tencent.mm.kernel.h.ay(cd.class);
    com.tencent.mm.kernel.h.ay(bq.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.findersdk.a.ad.class);
    this.Asr.dead();
    this.Ask.Ggo.dead();
    localObject = this.Asl;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject).DJe;
      if (localObject != null) {
        AppForegroundDelegate.heY.b((com.tencent.mm.app.q)localObject);
      }
    }
    AppForegroundDelegate.heY.b((com.tencent.mm.app.q)this.AsE);
    com.tencent.mm.app.ac.aCN().b((ac.b)this.AsF);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("mmfinder_globalpush_newxml", (com.tencent.mm.plugin.messenger.foundation.a.s)getFinderGlobalPushNewXmlConsumer());
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("FinderPersonalMsgSysMsg", (com.tencent.mm.plugin.messenger.foundation.a.s)this.ArZ);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("finderuserreinit", (com.tencent.mm.plugin.messenger.foundation.a.s)this.Asb);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("FinderPromotion", (com.tencent.mm.plugin.messenger.foundation.a.s)this.Asc);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("FinderHotWordsJumpMsg", (com.tencent.mm.plugin.messenger.foundation.a.s)this.Asd);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(1);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(5);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.findersdk.a.y.class);
    com.tencent.mm.kernel.h.ay(bp.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.findersdk.a.z.class);
    com.tencent.mm.kernel.h.ay(cb.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.finder.service.n.class);
    com.tencent.mm.kernel.h.ay(bw.class);
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.finder.service.m.class);
    com.tencent.mm.kernel.h.ay(ae.class);
    com.tencent.mm.kernel.h.ay(bm.class);
    com.tencent.mm.kernel.h.ay(bt.class);
    com.tencent.mm.kernel.h.ay(br.class);
    localObject = com.tencent.mm.pluginsdk.ui.a.b.iKa();
    if ((localObject instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      ((com.tencent.mm.pluginsdk.ui.b)localObject).bqB("@findermsg");
      ((com.tencent.mm.pluginsdk.ui.b)localObject).bqB("@finder");
    }
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).bdp("5");
    localObject = com.tencent.mm.ui.component.k.aeZF;
    com.tencent.mm.plugin.finder.viewmodel.teenmode.d locald = (com.tencent.mm.plugin.finder.viewmodel.teenmode.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.teenmode.d.class);
    Log.i("FinderTeenModeLimitVM", "FinderTeenModeLimitVM release");
    localObject = MMApplicationContext.getContext().getApplicationContext();
    if ((localObject instanceof Application)) {}
    for (localObject = (Application)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((Application)localObject).unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)locald.GWP);
      }
      locald.GWQ.dead();
      localObject = com.tencent.mm.plugin.finder.video.f.Gog;
      Log.i("Finder.FinderNetworkStatusStatistic", "release");
      com.tencent.mm.ae.d.B((kotlin.g.a.a)f.d.Gor);
      com.tencent.mm.plugin.finder.video.f.fiY();
      AppForegroundDelegate.heY.b((com.tencent.mm.app.q)com.tencent.mm.plugin.finder.video.f.Goo);
      if (this.mCN != null)
      {
        localObject = this.mCN;
        if (localObject != null) {
          ((com.tencent.mm.storagebase.h)localObject).closeDB();
        }
        this.mCN = null;
      }
      localObject = com.tencent.mm.plugin.finder.feed.model.g.BeY;
      com.tencent.mm.plugin.finder.feed.model.g.clear();
      getViewModelStore().clear();
      this.AsB.dead();
      localObject = com.tencent.mm.plugin.finder.megavideo.floatball.b.EzA;
      if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
        ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class)).b(22, com.tencent.mm.plugin.finder.megavideo.floatball.b.egs());
      }
      localObject = com.tencent.mm.plugin.finder.floatball.b.BtK;
      localObject = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.ball.c.b)localObject).b(32, com.tencent.mm.plugin.finder.floatball.b.egs());
      }
      localObject = com.tencent.mm.plugin.finder.megavideo.multitask.a.EzW;
      ((com.tencent.mm.plugin.taskbar.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.taskbar.api.b.class)).b(22, (com.tencent.mm.plugin.taskbar.api.b.a)com.tencent.mm.plugin.finder.megavideo.multitask.a.eCM());
      localObject = com.tencent.mm.plugin.finder.upload.action.f.GcR;
      com.tencent.mm.plugin.finder.upload.action.f.onAccountRelease();
      this.Asz.dead();
      this.AsA.dead();
      this.Asw.hG(true);
      AppMethodBeat.o(162436);
      return;
    }
  }
  
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString) {}
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onEnterFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(165095);
    kotlin.g.b.s.u(paramMMFinderUI, "finder");
    Log.i("Finder.PluginFinder", kotlin.g.b.s.X("onEnterFinder finder:", paramMMFinderUI));
    Object localObject = com.tencent.mm.plugin.finder.storage.data.v.FNs;
    com.tencent.mm.plugin.finder.storage.data.v.fal();
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().eKY();
    localObject = com.tencent.mm.plugin.finder.utils.q.GgD;
    com.tencent.mm.plugin.finder.utils.q.GgF += 1;
    if (!paramMMFinderUI.getIntent().getBooleanExtra("key_not_request_focus", false))
    {
      if (!isInFinder()) {
        this.Asv.bUf();
      }
      if (!((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).onEnterFinder((MMActivity)paramMMFinderUI))
      {
        localObject = this.Asv;
        kotlin.g.b.s.u(paramMMFinderUI, "finder");
        if (!((com.tencent.mm.plugin.a)localObject).pFd.contains(paramMMFinderUI)) {
          ((com.tencent.mm.plugin.a)localObject).pFd.add(paramMMFinderUI);
        }
        if (com.tencent.mm.kernel.h.baz()) {
          ((com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class)).onEnterFinder(paramMMFinderUI);
        }
      }
      if (this.Asv.pFd.size() == 1)
      {
        paramMMFinderUI = com.tencent.mm.plugin.findersdk.b.a.a.HcR;
        if (SystemClock.elapsedRealtime() - com.tencent.mm.plugin.findersdk.b.a.a.Hdb <= 300000L) {
          break label250;
        }
      }
    }
    label250:
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.CgiStrategy", kotlin.g.b.s.X("tryMoreInit tryInit:", Boolean.valueOf(bool)));
      if (bool)
      {
        com.tencent.mm.plugin.findersdk.b.a.a.init();
        com.tencent.mm.plugin.findersdk.b.a.a.Hdb = SystemClock.elapsedRealtime();
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
    kotlin.g.b.s.u(paramMMFinderUI, "finder");
    Log.i("Finder.PluginFinder", kotlin.g.b.s.X("onExitFinder finder:", paramMMFinderUI));
    com.tencent.mm.plugin.finder.utils.q localq = com.tencent.mm.plugin.finder.utils.q.GgD;
    int i = com.tencent.mm.plugin.finder.utils.q.GgF - 1;
    com.tencent.mm.plugin.finder.utils.q.GgF = i;
    if (i < 0) {
      com.tencent.mm.plugin.finder.utils.q.GgF = 0;
    }
    ((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).onExitFinder((MMActivity)paramMMFinderUI);
    if (!isInFinder())
    {
      this.Asv.abandonAudioFocus();
      paramMMFinderUI = av.GiL;
      av.fgh();
      paramMMFinderUI = com.tencent.mm.plugin.finder.report.n.FpH;
      com.tencent.mm.plugin.finder.report.n.azI("");
      paramMMFinderUI = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.a)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.a.class)).fmK();
      paramMMFinderUI = com.tencent.mm.plugin.finder.permission.a.ESS;
      if (!com.tencent.mm.plugin.finder.permission.a.eGX()) {
        com.tencent.threadpool.h.ahAA.bk(PluginFinder..ExternalSyntheticLambda29.INSTANCE);
      }
    }
    paramMMFinderUI = getMediaPreloadModel();
    if (paramMMFinderUI.EVH.size() >= 3000) {
      paramMMFinderUI.EVH.clear();
    }
    AppMethodBeat.o(165096);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(165099);
    if ((paramp != null) && (paramp.getType() == 3512) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = paramp.getReqResp();
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = c.c.b(((com.tencent.mm.am.c)paramString).otC);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetUserResponse");
        AppMethodBeat.o(165099);
        throw paramString;
      }
      paramString = ((bbi)paramString).ZIt;
      if (paramString != null)
      {
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext())
        {
          paramp = (FinderContact)paramString.next();
          com.tencent.mm.plugin.finder.api.d.a.a(com.tencent.mm.plugin.finder.api.d.AwY, paramp);
        }
      }
    }
    AppMethodBeat.o(165099);
  }
  
  public final void openChannelsPostPage(Activity paramActivity)
  {
    AppMethodBeat.i(332241);
    kotlin.g.b.s.u(paramActivity, "activity");
    Log.i("Finder.PluginFinder", "[openChannelsPostPage]");
    Object localObject = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.aP(11, false);
    localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)paramActivity, null);
    AppMethodBeat.o(332241);
  }
  
  public final void openFinderLiveOperationUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(331899);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "intent");
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
    AppMethodBeat.o(331899);
  }
  
  public final void refreshXLabConfigToMMKV()
  {
    AppMethodBeat.i(331665);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yXE, 512);
    int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yXF, 2);
    MultiProcessMMKV.getDefault().putInt("FINDER_FOLDER_MAX_SIZE_MB", i);
    MultiProcessMMKV.getDefault().putInt("FINDER_FOLDER_LRU_EXPIRE_DAY", j);
    Log.i("Finder.PluginFinder", "refreshXLabConfigToMMKV size:" + i + ", time:" + j);
    AppMethodBeat.o(331665);
  }
  
  public final void report21053(View paramView, BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(332184);
    q.w localw;
    com.tencent.mm.plugin.finder.live.report.d locald;
    if (paramLong != q.w.DwO.beV) {
      if (paramLong == q.w.DwP.beV)
      {
        localw = q.w.DwP;
        if (paramInt4 == com.tencent.mm.plugin.finder.live.report.d.Dne.ordinal()) {
          break label379;
        }
        if (paramInt4 != com.tencent.mm.plugin.finder.live.report.d.Dnf.ordinal()) {
          break label303;
        }
        locald = com.tencent.mm.plugin.finder.live.report.d.Dnf;
      }
    }
    for (;;)
    {
      if ((paramView == null) || ((paramView instanceof AbsListView)))
      {
        label303:
        label379:
        c.e locale;
        ce localce;
        switch (paramInt1)
        {
        default: 
          AppMethodBeat.o(332184);
          return;
          if (paramLong == q.w.DwQ.beV)
          {
            localw = q.w.DwQ;
            break;
          }
          if (paramLong == q.w.DwR.beV)
          {
            localw = q.w.DwR;
            break;
          }
          if (paramLong == q.w.DwS.beV)
          {
            localw = q.w.DwS;
            break;
          }
          if (paramLong == q.w.DwT.beV)
          {
            localw = q.w.DwT;
            break;
          }
          if (paramLong == q.w.DwU.beV)
          {
            localw = q.w.DwU;
            break;
          }
          if (paramLong == q.w.DwV.beV)
          {
            localw = q.w.DwV;
            break;
          }
          if (paramLong == q.w.DwW.beV)
          {
            localw = q.w.DwW;
            break;
          }
          if (paramLong == q.w.DwX.beV)
          {
            localw = q.w.DwX;
            break;
          }
          if (paramLong == q.w.DwY.beV)
          {
            localw = q.w.DwY;
            break;
          }
          localw = q.w.DwO;
          break;
          if (paramInt4 == com.tencent.mm.plugin.finder.live.report.d.Dng.ordinal()) {
            locald = com.tencent.mm.plugin.finder.live.report.d.Dng;
          } else if (paramInt4 == com.tencent.mm.plugin.finder.live.report.d.Dnh.ordinal()) {
            locald = com.tencent.mm.plugin.finder.live.report.d.Dnh;
          } else if (paramInt4 == com.tencent.mm.plugin.finder.live.report.d.Dnk.ordinal()) {
            locald = com.tencent.mm.plugin.finder.live.report.d.Dnk;
          } else if (paramInt4 == com.tencent.mm.plugin.finder.live.report.d.Dnl.ordinal()) {
            locald = com.tencent.mm.plugin.finder.live.report.d.Dnl;
          } else {
            locald = com.tencent.mm.plugin.finder.live.report.d.Dne;
          }
          break;
        case 0: 
          locale = c.e.zHn;
          localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
          if (!(paramView instanceof AbsListView)) {}
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          for (paramView = (AbsListView)paramView;; paramView = null)
          {
            kotlin.g.b.s.checkNotNull(paramString);
            localce.a(paramView, paramBaseAdapter, locale, paramInt2, paramInt3, localw, paramString, locald, paramBoolean);
            AppMethodBeat.o(332184);
            return;
            locale = c.e.zHo;
            break;
            locale = c.e.zHp;
            break;
            locale = c.e.zHq;
            break;
            locale = c.e.zHr;
            break;
          }
        }
      }
    }
    paramBaseAdapter = (ce)com.tencent.mm.kernel.h.ax(ce.class);
    if ((paramView instanceof RecyclerView)) {}
    for (paramView = (RecyclerView)paramView;; paramView = null)
    {
      kotlin.g.b.s.checkNotNull(paramString);
      paramBaseAdapter.b(paramView, localw, paramString, locald);
      AppMethodBeat.o(332184);
      return;
    }
  }
  
  public final void report21053OnClick(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, long paramLong3, String paramString2, int paramInt3, int paramInt4, String paramString3, String paramString4, long paramLong4, int paramInt5)
  {
    AppMethodBeat.i(332195);
    q.w localw;
    q.ca localca;
    if (paramLong3 == q.w.DwR.beV)
    {
      localw = q.w.DwR;
      if (paramInt5 != q.ca.DDZ.type) {
        break label219;
      }
      localca = q.ca.DDZ;
    }
    for (;;)
    {
      if (!kotlin.g.b.s.p(q.n.DtI.scene, paramString2)) {
        break label289;
      }
      paramString3 = com.tencent.mm.kernel.h.ax(ce.class);
      kotlin.g.b.s.s(paramString3, "service(IHellLiveReport::class.java)");
      ce.a.a((ce)paramString3, paramLong1, paramLong2, paramString1, paramInt1, paramInt2, q.w.DwU, paramString2);
      AppMethodBeat.o(332195);
      return;
      if (paramLong3 == q.w.DwS.beV)
      {
        localw = q.w.DwS;
        break;
      }
      if (paramLong3 == q.w.DwT.beV)
      {
        localw = q.w.DwT;
        break;
      }
      if (paramLong3 != q.w.DwU.beV)
      {
        if (paramLong3 == q.w.DwW.beV)
        {
          localw = q.w.DwW;
          break;
        }
        if (paramLong3 == q.w.DwX.beV)
        {
          localw = q.w.DwX;
          break;
        }
        if (paramLong3 == q.w.DwY.beV)
        {
          localw = q.w.DwY;
          break;
        }
      }
      localw = q.w.DwU;
      break;
      label219:
      if (paramInt5 == q.ca.DEa.type)
      {
        localca = q.ca.DEa;
      }
      else if (paramInt5 == q.ca.DEb.type)
      {
        localca = q.ca.DEb;
      }
      else if (paramInt5 == q.ca.DEc.type)
      {
        localca = q.ca.DEc;
      }
      else
      {
        localca = q.ca.DEd;
        localca = q.ca.DEd;
      }
    }
    label289:
    ce localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
    long l1;
    label330:
    long l2;
    long l3;
    if (paramString1 == null)
    {
      paramString1 = "";
      paramLong3 = paramInt1;
      l1 = paramInt2;
      if (paramString2 != null) {
        break label415;
      }
      paramString2 = "";
      l2 = paramInt3;
      l3 = paramInt4;
      if (paramString3 != null) {
        break label418;
      }
      paramString3 = "";
      label350:
      if (paramString4 != null) {
        break label421;
      }
      paramString4 = "";
    }
    label415:
    label418:
    label421:
    for (;;)
    {
      localce.b(new com.tencent.mm.plugin.finder.live.report.o(paramLong1, paramLong2, paramString1, paramLong3, l1, localw, paramString2, l2, l3, paramString3, paramString4, paramLong4, localca, null, null, null, null, 122880));
      AppMethodBeat.o(332195);
      return;
      break;
      break label330;
      break label350;
    }
  }
  
  public final void report21053OnClickOnSnsAd(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(332211);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ax(ce.class);
    kotlin.g.b.s.s(locala, "service(IHellLiveReport::class.java)");
    ce.a.a((ce)locala, paramLong1, paramLong2, paramString, paramLong3, 0L, q.w.DwU, "37");
    AppMethodBeat.o(332211);
  }
  
  public final void reportGiftOnReturn()
  {
    AppMethodBeat.i(332204);
    ((cf)com.tencent.mm.kernel.h.ax(cf.class)).a(q.cc.DEz, "", 0);
    AppMethodBeat.o(332204);
  }
  
  public final void reportPostRedDot(int paramInt)
  {
    AppMethodBeat.i(165122);
    com.tencent.mm.plugin.report.service.h.OAn.p(1309L, paramInt, 1L);
    com.tencent.mm.plugin.report.service.h.OAn.b(19212, new Object[] { Integer.valueOf(paramInt), Long.valueOf(com.tencent.mm.model.cn.bDu()) });
    AppMethodBeat.o(165122);
  }
  
  public final FinderObject requestFinderObject(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(332079);
    Log.i("Finder.PluginFinder", "requestFinderObject " + paramLong + ", enter");
    ah.f localf = new ah.f();
    Object localObject = com.tencent.mm.plugin.finder.storage.data.e.FMN;
    localf.aqH = com.tencent.mm.plugin.finder.storage.data.e.a.jn(paramLong);
    localObject = new Object();
    ah.a locala = new ah.a();
    if (localf.aqH == null)
    {
      Log.i("Finder.PluginFinder", "requestFinderObject " + paramLong + ", start");
      new az(paramLong, paramString, paramInt, 2, "", true, null, null, 0L, null, false, false, null, null, 0, null, 57280).bFJ().h(new PluginFinder..ExternalSyntheticLambda25(localObject, paramLong, localf, locala));
    }
    if (localf.aqH == null) {}
    try
    {
      if (!locala.aiwY)
      {
        Log.i("Finder.PluginFinder", kotlin.g.b.s.X("requestFinderObject wait ", Long.valueOf(paramLong)));
        localObject.wait(2000L);
        Log.i("Finder.PluginFinder", kotlin.g.b.s.X("requestFinderObject notify ", Long.valueOf(paramLong)));
      }
      paramString = ah.aiuX;
      paramString = (FinderItem)localf.aqH;
      if (paramString == null)
      {
        AppMethodBeat.o(332079);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(332079);
    }
    paramString = paramString.getFeedObject();
    AppMethodBeat.o(332079);
    return paramString;
  }
  
  public final void reserveChannelsLive(Activity paramActivity, String paramString, ca.a<Integer> parama1, ca.a<Integer> parama2)
  {
    AppMethodBeat.i(332247);
    kotlin.g.b.s.u(paramActivity, "activity");
    kotlin.g.b.s.u(paramString, "jsonStr");
    kotlin.g.b.s.u(parama1, "didOpenCallback");
    kotlin.g.b.s.u(parama2, "failCallback");
    try
    {
      com.tencent.mm.plugin.finder.feed.ac localac = com.tencent.mm.plugin.finder.feed.ac.AWK;
      com.tencent.mm.plugin.finder.feed.ac.a((MMActivity)paramActivity, paramString, parama1, parama2);
      AppMethodBeat.o(332247);
      return;
    }
    catch (Exception paramActivity)
    {
      Log.printErrStackTrace("Finder.PluginFinder", (Throwable)paramActivity, "reserveChannelsLive exception", new Object[0]);
      parama2.onCallback(Integer.valueOf(-1));
      AppMethodBeat.o(332247);
    }
  }
  
  public final void resetConfig()
  {
    AppMethodBeat.i(165093);
    try
    {
      Object localObject = com.tencent.mm.plugin.finder.storage.data.g.FMY;
      com.tencent.mm.plugin.finder.storage.data.g.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.k.FNg;
      k.a.clearAll();
      localObject = com.tencent.mm.plugin.finder.storage.data.b.FMJ;
      com.tencent.mm.plugin.finder.storage.data.b.a.clearAll();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbu, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbv, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adds, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addx, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addy, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addC, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addF, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addG, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZO, Long.valueOf(1L));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZR, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZS, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZT, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZU, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZV, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZW, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adab, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adag, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adal, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adaB, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbs, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcY, Integer.valueOf(0));
      clearReInit();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcc, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcl, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcm, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcK, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addK, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addL, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcq, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcs, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adct, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcu, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcv, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcw, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcy, Boolean.FALSE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcJ, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcN, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcP, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcQ, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcU, Boolean.FALSE);
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
    this.AsD = 0L;
  }
  
  public final void resetLastTimelineExitTime()
  {
    AppMethodBeat.i(165110);
    Log.i("Finder.PluginFinder", "reset timeline auto refresh time");
    AppMethodBeat.o(165110);
  }
  
  public final void sdkShare(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(332090);
    Object localObject = am.GhD;
    Log.i(am.TAG, "LogPost, dealShare, businessType:" + paramString1 + ", appid:" + paramString2 + ", extInfo:" + paramString3);
    if ((paramString3 == null) || (Util.isNullOrNil(paramString3)) || (paramString1 == null) || (Util.isNullOrNil(paramString1)) || (paramString2 == null) || (Util.isNullOrNil(paramString2)))
    {
      am.e(-1, "appid or extInfo empty", paramString1, paramString2);
      AppMethodBeat.o(332090);
      return;
    }
    localObject = new Intent();
    fby localfby = new fby();
    localfby.DnR = 1;
    etj localetj = new etj();
    localetj.businessType = paramString1;
    localetj.appid = paramString2;
    localetj.extInfo = paramString3;
    paramString1 = ah.aiuX;
    localfby.abBz = localetj;
    ((Intent)localObject).putExtra("KEY_POST_FROM_SHARE", localfby.toByteArray());
    paramString1 = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramString1 = MMApplicationContext.getContext();
    kotlin.g.b.s.s(paramString1, "getContext()");
    com.tencent.mm.plugin.finder.utils.a.R(paramString1, (Intent)localObject);
    AppMethodBeat.o(332090);
  }
  
  public final void set21084CommentScene(String paramString)
  {
    AppMethodBeat.i(332294);
    kotlin.g.b.s.u(paramString, "commentScene");
    com.tencent.mm.plugin.expt.hellhound.a.aqz(paramString);
    AppMethodBeat.o(332294);
  }
  
  public final void setDataDB(com.tencent.mm.storagebase.h paramh)
  {
    this.mCN = paramh;
  }
  
  public final void setFinderMentionDB(com.tencent.mm.storagebase.h paramh)
  {
    this.Arq = paramh;
  }
  
  public final void setMessageDB(com.tencent.mm.storagebase.h paramh)
  {
    this.Ars = paramh;
  }
  
  public final void setWxMentionDB(com.tencent.mm.storagebase.h paramh)
  {
    this.Arr = paramh;
  }
  
  public final void shareStatsReport(List<? extends Pair<String, String>> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(332048);
    kotlin.g.b.s.u(paramList, "feedIdList");
    ah.f localf = new ah.f();
    localf.aqH = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    if (paramList.hasNext())
    {
      Object localObject = (Pair)paramList.next();
      fhp localfhp = new fhp();
      if (paramBoolean)
      {
        localfhp.abIp = com.tencent.mm.ae.d.FK((String)((Pair)localObject).first);
        localfhp.abIq = ((String)((Pair)localObject).second);
      }
      for (;;)
      {
        localObject = new dzj();
        ((dzj)localObject).abej += 1;
        ((dzj)localObject).share = 1;
        ah localah = ah.aiuX;
        localfhp.abIj = ((dzj)localObject);
        ((LinkedList)localf.aqH).add(localfhp);
        break;
        localfhp.hKN = com.tencent.mm.ae.d.FK((String)((Pair)localObject).first);
        localfhp.objectNonceId = ((String)((Pair)localObject).second);
      }
    }
    new com.tencent.mm.plugin.finder.cgi.ap((List)localf.aqH, null).bFJ().j(new PluginFinder..ExternalSyntheticLambda26(localf));
    AppMethodBeat.o(332048);
  }
  
  public final void showFinderEntranceDebugSheet(Activity paramActivity)
  {
    AppMethodBeat.i(331471);
    kotlin.g.b.s.u(paramActivity, "activity");
    Object localObject = getRedDotManager().Su("FinderEntrance");
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)paramActivity, 1, false);
      localf.Vtg = new PluginFinder..ExternalSyntheticLambda20(paramActivity, (String)localObject);
      localf.GAC = new PluginFinder..ExternalSyntheticLambda21(paramActivity, (String)localObject);
      localf.dDn();
      AppMethodBeat.o(331471);
      return;
      localObject = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject).field_ctrInfo;
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        localObject = ((btw)localObject).internal_feedback_url;
        if (localObject == null) {
          localObject = "";
        }
      }
    }
  }
  
  public final boolean showFinderEntry()
  {
    AppMethodBeat.i(165102);
    com.tencent.mm.plugin.finder.permission.a locala = com.tencent.mm.plugin.finder.permission.a.ESS;
    boolean bool = com.tencent.mm.plugin.finder.permission.a.eGX();
    AppMethodBeat.o(165102);
    return bool;
  }
  
  public final boolean showPostEntry()
  {
    AppMethodBeat.i(165103);
    com.tencent.mm.plugin.finder.permission.a locala = com.tencent.mm.plugin.finder.permission.a.ESS;
    boolean bool = com.tencent.mm.plugin.finder.permission.a.eGX();
    AppMethodBeat.o(165103);
    return bool;
  }
  
  public final void snsToFinderPostReport(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, long paramLong3, int paramInt5)
  {
    AppMethodBeat.i(332120);
    kotlin.g.b.s.u(paramString1, "sessionID");
    kotlin.g.b.s.u(paramString2, "wording");
    com.tencent.mm.plugin.finder.report.ag localag = com.tencent.mm.plugin.finder.report.ag.Ftp;
    com.tencent.mm.plugin.finder.report.ag.a(paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, paramLong3, paramInt5);
    AppMethodBeat.o(332120);
  }
  
  public final Context tryGetFinderContext()
  {
    AppMethodBeat.i(332321);
    Object localObject = com.tencent.mm.plugin.finder.utils.j.Gge;
    localObject = com.tencent.mm.plugin.finder.utils.j.tryGetFinderContext();
    AppMethodBeat.o(332321);
    return localObject;
  }
  
  public final FinderObject tryGetFinderObject(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(332055);
    paramString = tryGetFinderObject(paramLong, paramString, paramInt, true, false, null);
    AppMethodBeat.o(332055);
    return paramString;
  }
  
  public final FinderObject tryGetFinderObject(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, cn.a parama)
  {
    AppMethodBeat.i(332068);
    Log.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", enter");
    if (paramBoolean1)
    {
      localObject = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      com.tencent.mm.plugin.finder.storage.data.e.a.ky(paramLong);
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.data.e.FMN;
    localObject = com.tencent.mm.plugin.finder.storage.data.e.a.jn(paramLong);
    if (localObject == null)
    {
      Log.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", start");
      paramString = new az(paramLong, paramString, paramInt, 2, "", true, null, null, 0L, null, false, false, null, null, 0, null, 57280);
      if (paramBoolean2)
      {
        Context localContext = MMApplicationContext.getContext();
        kotlin.g.b.s.s(localContext, "getContext()");
        paramString.e(localContext, MMApplicationContext.getContext().getResources().getString(e.h.finder_get_detail_wait), 1000L);
      }
      paramString.bFJ().h(new PluginFinder..ExternalSyntheticLambda24(parama, paramLong));
    }
    if (localObject == null)
    {
      AppMethodBeat.o(332068);
      return null;
    }
    paramString = ((FinderItem)localObject).getFeedObject();
    AppMethodBeat.o(332068);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/PluginFinder$Companion;", "", "()V", "ID_KEY_POST_RED_DOT", "", "KV_ID_POST_RED_DOT", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/PluginFinder$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.app.q
  {
    b(PluginFinder paramPluginFinder) {}
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(165054);
      PluginFinder.access$getFinderCommonService$p(this.AsJ).abandonAudioFocus();
      paramString = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.eMQ();
      AppMethodBeat.o(165054);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(165055);
      if ((PluginFinder.access$getFinderCommonService$p(this.AsJ).bUe()) || (((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).isInFinderLiveSquareFindPageUI()) || (((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).isInNearby())) {
        PluginFinder.access$getFinderCommonService$p(this.AsJ).bUf();
      }
      if ((this.AsJ.showFinderEntry()) && (System.currentTimeMillis() - PluginFinder.access$getLastFinderInitTime$p(this.AsJ) >= 86400000L)) {
        PluginFinder.access$doFinderInit(this.AsJ);
      }
      AppMethodBeat.o(165055);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final d AsL;
    
    static
    {
      AppMethodBeat.i(329746);
      AsL = new d();
      AppMethodBeat.o(329746);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final e AsM;
    
    static
    {
      AppMethodBeat.i(165067);
      AsM = new e();
      AppMethodBeat.o(165067);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(PluginFinder paramPluginFinder, long paramLong, String paramString, int paramInt, Intent paramIntent, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/PluginFinder$enterFinderShareFeedUI$1", "Lcom/tencent/mm/plugin/setting/ui/utils/SafeSwitchTipDialog$DialogFinderSwitchCallback;", "onFail", "", "onSuccess", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.plugin.setting.ui.b.a.a
  {
    g(Context paramContext, Intent paramIntent) {}
    
    public final void cjC() {}
    
    public final void onSuccess()
    {
      AppMethodBeat.i(329749);
      Object localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.Y(this.$context, localIntent);
      localObject = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
      com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999685);
      AppMethodBeat.o(329749);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.b<FinderJumpInfo, ah>
  {
    public static final h AsR;
    
    static
    {
      AppMethodBeat.i(329764);
      AsR = new h();
      AppMethodBeat.o(329764);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/service/FinderContactService;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.service.a>
  {
    public static final i AsS;
    
    static
    {
      AppMethodBeat.i(329755);
      AsS = new i();
      AppMethodBeat.o(329755);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.conv.i>
  {
    public static final j AsT;
    
    static
    {
      AppMethodBeat.i(329750);
      AsT = new j();
      AppMethodBeat.o(329750);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/service/FinderSnsKeyWordsService;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.service.l>
  {
    public static final k AsU;
    
    static
    {
      AppMethodBeat.i(329752);
      AsU = new k();
      AppMethodBeat.o(329752);
    }
    
    k()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderTeenModeConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.storage.ap>
  {
    public static final l AsV;
    
    static
    {
      AppMethodBeat.i(329760);
      AsV = new l();
      AppMethodBeat.o(329760);
    }
    
    l()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.loader.f.h>
  {
    public static final m AsW;
    
    static
    {
      AppMethodBeat.i(329762);
      AsW = new m();
      AppMethodBeat.o(329762);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveIncomePageResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.am.b.a<azj>, ah>
  {
    n(Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o<T, R>
    implements com.tencent.mm.loader.e.e
  {
    o(kotlinx.coroutines.p<? super Bitmap> paramp) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    p(View paramView, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/PluginFinder$mainProcForegroundListener$1", "Lcom/tencent/mm/app/ProcForegroundDelegate$Listener;", "onProcessBackground", "", "activityName", "", "onProcessForeground", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class q
    implements ac.b
  {
    q(PluginFinder paramPluginFinder) {}
    
    public final void onProcessBackground(String paramString)
    {
      AppMethodBeat.i(329777);
      paramString = PluginFinder.access$getFinderMultiTaskService$p(this.AsJ);
      paramString.Fzh = true;
      Set localSet = paramString.pFe;
      kotlin.g.b.s.s(localSet, "foregroundFinderActivity");
      com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new g.c(paramString, (MMFinderUI)kotlin.a.p.h((Iterable)localSet)));
      AppMethodBeat.o(329777);
    }
    
    public final void onProcessForeground(String paramString)
    {
      AppMethodBeat.i(329769);
      paramString = PluginFinder.access$getFinderMultiTaskService$p(this.AsJ);
      paramString.Fzf = false;
      paramString.Fzh = false;
      AppMethodBeat.o(329769);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.b>
  {
    public static final r Ata;
    
    static
    {
      AppMethodBeat.i(329767);
      Ata = new r();
      AppMethodBeat.o(329767);
    }
    
    r()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/PluginFinder$onAccountInitialized$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISendAppMsgSceneGenerator;", "transmit", "", "activity", "Landroid/app/Activity;", "toUserName", "", "msgContent", "callback", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISendAppMsgSceneGenerator$Callback;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    implements com.tencent.mm.plugin.messenger.foundation.a.z
  {
    public final void a(Activity paramActivity, String paramString1, String paramString2, z.a parama)
    {
      AppMethodBeat.i(329771);
      kotlin.g.b.s.u(paramActivity, "activity");
      kotlin.g.b.s.u(paramString1, "toUserName");
      kotlin.g.b.s.u(paramString2, "msgContent");
      ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).a(paramString1, paramString2, (com.tencent.mm.plugin.findersdk.a.s)new a(parama)).bFJ();
      AppMethodBeat.o(329771);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/PluginFinder$onAccountInitialized$1$transmit$1", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderAuthAppMsg;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderSendInviteMsgResponse;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.findersdk.a.s
    {
      a(z.a parama) {}
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/conv/FinderPrivateMsgConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.conv.m>
  {
    public static final w Atd;
    
    static
    {
      AppMethodBeat.i(329770);
      Atd = new w();
      AppMethodBeat.o(329770);
    }
    
    w()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder
 * JD-Core Version:    0.7.0.1
 */