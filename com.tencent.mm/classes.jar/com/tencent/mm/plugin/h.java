package com.tencent.mm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.d.a.a.a.d.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.finder.api.d.a.a;
import com.tencent.mm.plugin.finder.api.j;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.feed.n;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.bd;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.bo;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.ci;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.fvk;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/IFinderCommonService;", "Lcom/tencent/mm/kernel/service/IService;", "abandonAudioFocus", "", "addNewRedDotCtrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "info", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "source", "", "changePathSet", "Ljava/util/HashSet;", "isClearOldSameType", "", "clearedEntrancePair", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "extraWork", "Lkotlin/Function1;", "cgiFinderSearch", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "query", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hotWordSessionBuffer", "topicBuffer", "hotWordInfo", "cgiGetFinderFeedComment", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "objectNonceId", "enterScene", "feedUsername", "needObject", "lastBuffer", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "pullScene", "callback", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "cgiGetFinderPrepareUser", "Lkotlin/ParameterName;", "name", "cgi", "cgiNetSceneFinderUserPage", "req_username", "maxId", "pullType", "tabType", "topicId", "isOnlyFetchUserInfo", "refObjectId", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IJZLjava/lang/Integer;Ljava/lang/Long;)Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "checkActivityIsFinderHome", "Landroid/content/Context;", "checkFinderNotifyControlFlag", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveNotifyExposureInfo;", "flag", "checkFriendFollowCount", "checkOldConv", "checkOldSessionInfo", "createEmptyConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "createFinderSingleFeedReportHandler", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler;", "createIQuickShareMenuHelper", "Lcom/tencent/mm/plugin/findersdk/api/IQuickShareMenuHelper;", "Landroidx/appcompat/app/AppCompatActivity;", "shareType", "createMiniProgramUICallback", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "halfScreenChangeListener", "Lcom/tencent/mm/plugin/findersdk/api/IMiniProgramHalfScreenStatusChangeListener;", "createRefreshItemAnimation", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "createSceneNetSceneFinderGetFansList", "liveId", "createSceneNetSceneFinderPrepareUser", "ctrlInfoAtPath", "path", "delAliasInfo", "downloadInfoList", "", "Lcom/tencent/mm/protocal/protobuf/FinderDownloadInfo;", "findCenterFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "firstPosition", "lastPosition", "otherCareType", "", "finderClickMoreReport", "finderObjToJumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "followAsync", "finderUser", "opType", "isPrivate", "participantFinderUsername", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "generateClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderClientStatus;", "getById", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "id", "getContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "getDisplayName", "nickname", "printLog", "getFinderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getFinderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "getFinderItem", "getFinderItemSessionBuffer", "getFinderItemSessionBufferEx", "Lcom/tencent/mm/plugin/finder/report/SessionBufferEx;", "getFinderSetStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "nickName", "iconUrl", "itemId", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getLiveDecorationPagPath", "pagFile", "Lcom/tencent/mm/plugin/finder/loader/FinderLivePag;", "getLiveGiftPagPath", "getNickName", "", "paint", "Landroid/text/TextPaint;", "spanText", "maxNameCount", "tv", "Landroid/widget/TextView;", "getNormalJpegTmpPath", "getPoiText", "city", "poiName", "getReportNetTypeInt", "getWxDisplayName", "getWxProfileInfo2", "wxUsername", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "onSuccess", "Lcom/tencent/mm/protocal/protobuf/UserPreviewInfo;", "onError", "forceRequest", "contactType", "initIntentParams", "intent", "Landroid/content/Intent;", "clickFeedContextId", "fromProfileShareScene", "enterProfileType", "enterLbsUI", "isFinderForeground", "isFinderScene", "isFollow", "isFriend", "isLibPagEnabled", "isWaiting", "jumpAtProfileUI", "feedObject", "jumpLiveUIByFeedId", "feedExportId", "failedCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "feedNonceId", "succCallback", "Ljava/lang/Void;", "contextId", "reportExtraInfo", "verifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLivePermissionVerifyInfo;", "extra", "", "", "jumpTopicUI", "topic", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/plugin/finder/utils/ClickExtra;)V", "liveExpose", "commentSeq", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "liveListIsFirstVisible", "liveRepalyExpose", "exposeUrl", "(Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Long;I)V", "newUUID", "onEnterFinder", "finder", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "onExitFinder", "onFinderBackground", "onFinderForeground", "parseXml", "Landroid/text/SpannableString;", "xml", "defaultDesc", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "atFinderContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "onTopicClick", "Lkotlin/Function2;", "onAtClick", "pathRouterfinderTmpPath", "preloadInfoList", "processHighLight", "Landroid/text/Spanned;", "origin", "highLightFontColor", "putFinderItemSessionBuffer", "recentFinderNetworkInfoList", "Lcom/tencent/mm/protocal/protobuf/DownloadSpeed;", "recentWechatNetworkInfoList", "refreshObjectStatus", "Lkotlin/Triple;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "cgiBack", "result", "removeHighLightTag", "removeMegaVideoMiniView", "requestAudioFocus", "runCgiNetSceneExtStatsReport", "actionType", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "saveCacheToIntent", "position", "feedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "setAuthIcon", "view", "Landroid/widget/ImageView;", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "style", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;", "showCreateFinderUserDialog", "showCreateFinderUserDialogOnLiveWithCallback", "Landroid/app/Activity;", "requestCode", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "showFinderForwardConfirmDialog", "userName", "menu", "Lcom/tencent/mm/ui/base/MMMenuItem;", "toUsers", "showLiveForwardConfirmDialog", "showRealNameCertificationDialog", "showUserInfoConfirmDialog", "finderUserName", "dismiss", "alwaysDarkMode", "transformFinderObjectToTimeLineData", "uicReport", "Lcom/tencent/mm/plugin/findersdk/api/IFinderReporterUIC;", "updateFeedSessionBuffer", "updateUserExtInfoCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h
  extends com.tencent.mm.kernel.c.a
{
  public abstract com.tencent.mm.plugin.finder.api.m So(String paramString);
  
  public abstract String Sp(String paramString);
  
  public abstract int Sq(String paramString);
  
  public abstract void Sr(String paramString);
  
  public abstract boolean Ss(String paramString);
  
  public abstract boolean St(String paramString);
  
  public abstract p Su(String paramString);
  
  public abstract SpannableString a(String paramString, SpannableString paramSpannableString, long paramLong, List<bo> paramList, LinkedList<FinderContact> paramLinkedList, LinkedList<bpj> paramLinkedList1, kotlin.g.a.m<? super String, ? super com.tencent.mm.plugin.finder.utils.f, ah> paramm, kotlin.g.a.b<? super String, ah> paramb);
  
  public abstract i a(com.tencent.mm.plugin.finder.live.model.context.a parama, ci paramci);
  
  public abstract p a(btw parambtw, String paramString, HashSet<String> paramHashSet);
  
  public abstract BaseFinderFeed a(FinderItem paramFinderItem);
  
  public abstract d a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Set<Integer> paramSet);
  
  public abstract c<ayl> a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4);
  
  public abstract com.tencent.mm.plugin.findersdk.b.h a(com.tencent.mm.bx.b paramb, long paramLong);
  
  public abstract com.tencent.mm.plugin.findersdk.b.h a(String paramString1, int paramInt, String paramString2, com.tencent.mm.bx.b paramb);
  
  public abstract com.tencent.mm.plugin.findersdk.b.h a(String paramString, boolean paramBoolean, Integer paramInteger, Long paramLong);
  
  public abstract com.tencent.mm.plugin.textstatus.a.w a(String paramString1, String paramString2, long paramLong, FinderObject paramFinderObject);
  
  public abstract CharSequence a(Context paramContext, TextPaint paramTextPaint, CharSequence paramCharSequence, int paramInt);
  
  public abstract CharSequence a(TextView paramTextView, CharSequence paramCharSequence, int paramInt);
  
  public abstract String a(o paramo);
  
  public abstract void a(int paramInt, kotlin.g.a.b<? super com.tencent.mm.plugin.findersdk.b.h, ah> paramb);
  
  public abstract void a(Activity paramActivity, int paramInt, Intent paramIntent, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener);
  
  public abstract void a(Context paramContext, long paramLong, String paramString, Long paramLong1, int paramInt);
  
  public abstract void a(Context paramContext, Intent paramIntent, int paramInt);
  
  public abstract void a(Context paramContext, String paramString1, long paramLong, String paramString2);
  
  public abstract void a(Context paramContext, String paramString, FinderItem paramFinderItem);
  
  public abstract void a(ImageView paramImageView, FinderAuthInfo paramFinderAuthInfo, int paramInt, pu parampu);
  
  public abstract void a(AppCompatActivity paramAppCompatActivity, String paramString, t paramt, FinderItem paramFinderItem);
  
  public abstract void a(AppCompatActivity paramAppCompatActivity, String paramString, t paramt, FinderItem paramFinderItem, kotlin.g.a.b<? super List<String>, ah> paramb);
  
  public abstract void a(MMFinderUI paramMMFinderUI);
  
  public abstract void a(FinderObject paramFinderObject, int paramInt);
  
  public abstract void a(FinderObject paramFinderObject, bui parambui);
  
  public abstract void a(bui parambui, aps paramaps);
  
  public abstract void a(bui parambui, String paramString1, int paramInt, long paramLong, boolean paramBoolean, String paramString2, bma parambma);
  
  public abstract void a(MMActivity paramMMActivity, long paramLong, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, String paramString4, bui parambui, int paramInt, kotlin.g.a.b<? super b.a<ayl>, ah> paramb);
  
  public abstract void a(String paramString, d.a.a parama);
  
  public abstract void a(String paramString, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, kotlin.g.a.b<? super fvk, ah> paramb1, kotlin.g.a.b<? super Integer, ah> paramb2);
  
  public abstract void a(String paramString, Long paramLong, com.tencent.mm.plugin.finder.utils.f paramf);
  
  public abstract void a(String paramString1, String paramString2, ca.a<Integer> parama, String paramString3, ca.a<Void> parama1, String paramString4, String paramString5, bkr parambkr, Map<String, Object> paramMap);
  
  public abstract void a(List<? extends cc> paramList, Intent paramIntent);
  
  public abstract boolean a(g paramg);
  
  public abstract TextStatusJumpInfo b(FinderObject paramFinderObject);
  
  public abstract String b(o paramo);
  
  public abstract void b(MMFinderUI paramMMFinderUI);
  
  public abstract aur bTZ();
  
  public abstract List<awn> bUa();
  
  public abstract boolean bUb();
  
  public abstract boolean bUc();
  
  public abstract boolean bUd();
  
  public abstract boolean bUe();
  
  public abstract int bUg();
  
  public abstract String bUh();
  
  public abstract com.tencent.mm.view.recyclerview.f<com.tencent.mm.view.recyclerview.a> bUi();
  
  public abstract androidx.recyclerview.widget.w bUj();
  
  public abstract String bUk();
  
  public abstract void bUl();
  
  public abstract String bUm();
  
  public abstract com.tencent.mm.plugin.findersdk.b.h bUn();
  
  public abstract n c(MMActivity paramMMActivity);
  
  public abstract String cV(String paramString1, String paramString2);
  
  public abstract Spanned cm(String paramString1, String paramString2);
  
  public abstract String cn(String paramString1, String paramString2);
  
  public abstract boolean ek(Context paramContext);
  
  public abstract bn el(Context paramContext);
  
  public abstract void em(Context paramContext);
  
  public abstract com.tencent.mm.plugin.finder.storage.f getContactStorage();
  
  public abstract com.tencent.mm.plugin.finder.api.b getFinderContactCache();
  
  public abstract j getFinderSyncExtension();
  
  public abstract boolean h(RecyclerView paramRecyclerView);
  
  public abstract boolean isFriend(String paramString);
  
  public abstract FinderItem jm(long paramLong);
  
  public abstract FinderItem jn(long paramLong);
  
  public abstract String k(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void onEnterFinder(MMFinderUI paramMMFinderUI);
  
  public abstract void onExitFinder(MMFinderUI paramMMFinderUI);
  
  public abstract String p(long paramLong, int paramInt);
  
  public abstract bd q(long paramLong, int paramInt);
  
  public abstract void showRealNameCertificationDialog(Activity paramActivity);
  
  public abstract void showUserInfoConfirmDialog(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean);
  
  public abstract boolean yi(int paramInt);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<com.tencent.mm.plugin.findersdk.b.h, ah>
    {
      public static final a pFk;
      
      static
      {
        AppMethodBeat.i(260320);
        pFk = new a();
        AppMethodBeat.o(260320);
      }
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.h
 * JD-Core Version:    0.7.0.1
 */