package com.tencent.mm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a.a;
import com.tencent.mm.plugin.finder.api.j;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.plugin.finder.cgi.cg;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.cgi.dk;
import com.tencent.mm.plugin.finder.cgi.dt;
import com.tencent.mm.plugin.finder.feed.ad;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.profile.uic.h.c;
import com.tencent.mm.plugin.finder.report.bd;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.upload.action.i.a;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.ax;
import com.tencent.mm.plugin.finder.utils.ay;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.utils.bo;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.ci;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/FinderCommonService;", "Lcom/tencent/mm/plugin/IFinderCommonService;", "Lcom/tencent/mm/plugin/IFinderCommonService2;", "()V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "enterFinderActivity", "", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "", "getEnterFinderActivity", "()Ljava/util/Set;", "foregroundFinderActivity", "abandonAudioFocus", "", "addNewRedDotCtrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "info", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "source", "", "changePathSet", "Ljava/util/HashSet;", "isClearOldSameType", "", "clearedEntrancePair", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "extraWork", "Lkotlin/Function1;", "cgiFinderSearch", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "query", "offset", "", "requestId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hotWordSessionBuffer", "topicBuffer", "hotWordInfo", "cgiGetFinderFeedComment", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "objectNonceId", "enterScene", "feedUsername", "needObject", "lastBuffer", "rootComment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "refCommentId", "username", "down", "justUpdateObjectStatus", "encryptedObjectId", "pullScene", "callback", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "cgiGetFinderPrepareUser", "Lkotlin/ParameterName;", "name", "cgi", "cgiNetSceneFinderUserPage", "req_username", "maxId", "pullType", "tabType", "topicId", "isOnlyFetchUserInfo", "refObjectId", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IJZLjava/lang/Integer;Ljava/lang/Long;)Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "checkActivityIsFinderHome", "Landroid/content/Context;", "checkFinderNotifyControlFlag", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveNotifyExposureInfo;", "flag", "checkFriendFollowCount", "checkOldConv", "checkOldSessionInfo", "createEmptyConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "createFinderSingleFeedReportHandler", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler;", "createIQuickShareMenuHelper", "Lcom/tencent/mm/plugin/findersdk/api/IQuickShareMenuHelper;", "Landroidx/appcompat/app/AppCompatActivity;", "shareType", "createMiniProgramUICallback", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "halfScreenChangeListener", "Lcom/tencent/mm/plugin/findersdk/api/IMiniProgramHalfScreenStatusChangeListener;", "createRefreshItemAnimation", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "createSceneNetSceneFinderGetFansList", "liveId", "createSceneNetSceneFinderPrepareUser", "ctrlInfoAtPath", "path", "delAliasInfo", "downloadInfoList", "", "Lcom/tencent/mm/protocal/protobuf/FinderDownloadInfo;", "findCenterFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "firstPosition", "lastPosition", "otherCareType", "finderClickMoreReport", "finderObjToJumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "followAsync", "finderUser", "opType", "isPrivate", "participantFinderUsername", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "generateClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderClientStatus;", "getById", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "id", "getContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "getDisplayName", "nickname", "printLog", "getFinderContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getFinderContactCache", "Lcom/tencent/mm/plugin/finder/api/FinderContactCache;", "getFinderItem", "getFinderItemSessionBuffer", "getFinderItemSessionBufferEx", "Lcom/tencent/mm/plugin/finder/report/SessionBufferEx;", "getFinderSetStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "nickName", "iconUrl", "itemId", "getFinderSyncExtension", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "getLiveDecorationPagPath", "pagFile", "Lcom/tencent/mm/plugin/finder/loader/FinderLivePag;", "getLiveGiftPagPath", "getNickName", "", "paint", "Landroid/text/TextPaint;", "spanText", "maxNameCount", "tv", "Landroid/widget/TextView;", "getNormalJpegTmpPath", "getPoiText", "city", "poiName", "getReportNetTypeInt", "getWxDisplayName", "getWxProfileInfo2", "wxUsername", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "onSuccess", "Lcom/tencent/mm/protocal/protobuf/UserPreviewInfo;", "onError", "forceRequest", "contactType", "initIntentParams", "intent", "Landroid/content/Intent;", "clickFeedContextId", "fromProfileShareScene", "enterProfileType", "enterLbsUI", "isFinderForeground", "isFinderScene", "isFollow", "isFriend", "isInFinder", "isLibPagEnabled", "isWaiting", "jumpAtProfileUI", "feedObject", "jumpLiveUIByFeedId", "feedExportId", "failedCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "feedNonceId", "succCallback", "Ljava/lang/Void;", "contextId", "reportExtraInfo", "verifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLivePermissionVerifyInfo;", "extra", "", "", "jumpTopicUI", "topic", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/plugin/finder/utils/ClickExtra;)V", "liveExpose", "commentSeq", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "liveListIsFirstVisible", "liveRepalyExpose", "exposeUrl", "(Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Long;I)V", "newUUID", "onAddFinderActivity", "finder", "onEnterFinder", "onExitFinder", "onFinderBackground", "onFinderForeground", "parseXml", "Landroid/text/SpannableString;", "xml", "defaultDesc", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "atFinderContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "onTopicClick", "Lkotlin/Function2;", "onAtClick", "pathRouterfinderTmpPath", "preloadInfoList", "processHighLight", "Landroid/text/Spanned;", "origin", "highLightFontColor", "putFinderItemSessionBuffer", "recentFinderNetworkInfoList", "Lcom/tencent/mm/protocal/protobuf/DownloadSpeed;", "recentWechatNetworkInfoList", "refreshObjectStatus", "Lkotlin/Triple;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "cgiBack", "result", "removeHighLightTag", "removeMegaVideoMiniView", "requestAudioFocus", "runCgiNetSceneExtStatsReport", "actionType", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "saveCacheToIntent", "position", "feedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "setAuthIcon", "view", "Landroid/widget/ImageView;", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "style", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;", "showCreateFinderUserDialog", "showCreateFinderUserDialogOnLiveWithCallback", "Landroid/app/Activity;", "requestCode", "lok", "Landroid/content/DialogInterface$OnClickListener;", "lcancel", "ldismiss", "Landroid/content/DialogInterface$OnDismissListener;", "showFinderForwardConfirmDialog", "userName", "menu", "Lcom/tencent/mm/ui/base/MMMenuItem;", "toUsers", "showLiveForwardConfirmDialog", "showRealNameCertificationDialog", "showUserInfoConfirmDialog", "finderUserName", "dismiss", "alwaysDarkMode", "transformFinderObjectToTimeLineData", "uicReport", "Lcom/tencent/mm/plugin/findersdk/api/IFinderReporterUIC;", "updateFeedSessionBuffer", "updateUserExtInfoCache", "logOutInfo", "Lcom/tencent/mm/plugin/finder/api/FinderContactLogic$Companion$FinderUserLogOutInfo;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements h, i
{
  public static final a pFc;
  private final com.tencent.mm.model.d nmW;
  public final Set<MMFinderUI> pFd;
  private final Set<MMFinderUI> pFe;
  
  static
  {
    AppMethodBeat.i(260361);
    pFc = new a((byte)0);
    AppMethodBeat.o(260361);
  }
  
  public a()
  {
    AppMethodBeat.i(260350);
    this.pFd = Collections.synchronizedSet((Set)new HashSet());
    this.pFe = Collections.synchronizedSet((Set)new HashSet());
    this.nmW = new com.tencent.mm.model.d();
    AppMethodBeat.o(260350);
  }
  
  private static final ah a(kotlin.g.a.b paramb, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(260356);
    if (paramb == null)
    {
      AppMethodBeat.o(260356);
      return null;
    }
    kotlin.g.b.s.s(parama, "result");
    paramb.invoke(parama);
    paramb = ah.aiuX;
    AppMethodBeat.o(260356);
    return paramb;
  }
  
  public final com.tencent.mm.plugin.finder.api.m So(String paramString)
  {
    AppMethodBeat.i(260383);
    kotlin.g.b.s.u(paramString, "username");
    paramString = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getContactStorage().auT(paramString);
    AppMethodBeat.o(260383);
    return paramString;
  }
  
  public final String Sp(String paramString)
  {
    AppMethodBeat.i(260420);
    kotlin.g.b.s.u(paramString, "origin");
    com.tencent.mm.plugin.finder.search.k localk = com.tencent.mm.plugin.finder.search.k.FxZ;
    paramString = com.tencent.mm.plugin.finder.search.k.Sp(paramString);
    AppMethodBeat.o(260420);
    return paramString;
  }
  
  public final int Sq(String paramString)
  {
    AppMethodBeat.i(260538);
    kotlin.g.b.s.u(paramString, "username");
    com.tencent.mm.plugin.finder.profile.uic.h.a locala = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
    paramString = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString);
    if (paramString != null)
    {
      int i = paramString.friendFollowCount;
      AppMethodBeat.o(260538);
      return i;
    }
    AppMethodBeat.o(260538);
    return 0;
  }
  
  public final void Sr(String paramString)
  {
    AppMethodBeat.i(260748);
    kotlin.g.b.s.u(paramString, "source");
    av localav = av.GiL;
    av.aBS(paramString);
    AppMethodBeat.o(260748);
  }
  
  public final boolean Ss(String paramString)
  {
    AppMethodBeat.i(260770);
    i.a locala = com.tencent.mm.plugin.finder.upload.action.i.Gde;
    boolean bool = com.tencent.mm.plugin.finder.upload.action.i.a(com.tencent.mm.plugin.finder.upload.action.i.fej(), paramString, false, false, 6);
    AppMethodBeat.o(260770);
    return bool;
  }
  
  public final boolean St(String paramString)
  {
    AppMethodBeat.i(260779);
    i.a locala = com.tencent.mm.plugin.finder.upload.action.i.Gde;
    boolean bool = com.tencent.mm.plugin.finder.upload.action.i.fej().St(paramString);
    AppMethodBeat.o(260779);
    return bool;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.p Su(String paramString)
  {
    AppMethodBeat.i(260847);
    kotlin.g.b.s.u(paramString, "path");
    paramString = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su(paramString);
    AppMethodBeat.o(260847);
    return paramString;
  }
  
  public final SpannableString a(String paramString, SpannableString paramSpannableString, long paramLong, List<bo> paramList, LinkedList<FinderContact> paramLinkedList, LinkedList<bpj> paramLinkedList1, kotlin.g.a.m<? super String, ? super com.tencent.mm.plugin.finder.utils.f, ah> paramm, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(260408);
    kotlin.g.b.s.u(paramSpannableString, "defaultDesc");
    kotlin.g.b.s.u(paramList, "topicInfoList");
    kotlin.g.b.s.u(paramLinkedList, "atFinderContactList");
    kotlin.g.b.s.u(paramLinkedList1, "mentionedUserList");
    kotlin.g.b.s.u(paramm, "onTopicClick");
    kotlin.g.b.s.u(paramb, "onAtClick");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.ao.GhZ;
    kotlin.g.b.s.u(paramSpannableString, "defaultDesc");
    kotlin.g.b.s.u(paramList, "topicInfoList");
    kotlin.g.b.s.u(paramLinkedList, "atFinderContactList");
    kotlin.g.b.s.u(paramLinkedList1, "mentionedUserList");
    kotlin.g.b.s.u(paramm, "onTopicClick");
    kotlin.g.b.s.u(paramb, "onAtClick");
    paramList.clear();
    if (!Util.isNullOrNil(paramString))
    {
      paramLinkedList1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eRs())
      {
        paramLinkedList1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (com.tencent.mm.plugin.finder.storage.d.eRt()) {}
      }
    }
    else
    {
      paramString = com.tencent.mm.plugin.finder.utils.ao.a(paramString, paramSpannableString, paramList, paramm, paramLong);
      AppMethodBeat.o(260408);
      return paramString;
    }
    localObject1 = XmlParser.parseXml(paramString, "finder", null);
    if (localObject1 == null)
    {
      paramString = com.tencent.mm.plugin.finder.utils.ao.a(paramString, paramSpannableString, paramList, paramm, paramLong);
      AppMethodBeat.o(260408);
      return paramString;
    }
    int m = Util.getInt((String)((Map)localObject1).get("." + com.tencent.mm.plugin.finder.utils.ao.Gia + '.' + com.tencent.mm.plugin.finder.utils.ao.Gic), -1);
    if (m < 0)
    {
      paramString = com.tencent.mm.plugin.finder.utils.ao.a(paramString, paramSpannableString, paramList, paramm, paramLong);
      AppMethodBeat.o(260408);
      return paramString;
    }
    int n = Util.getInt((String)((Map)localObject1).get("." + com.tencent.mm.plugin.finder.utils.ao.Gia + '.' + com.tencent.mm.plugin.finder.utils.ao.VERSION), 0);
    paramString = Util.nullAs((String)((Map)localObject1).get("." + com.tencent.mm.plugin.finder.utils.ao.Gia + '.' + com.tencent.mm.plugin.finder.utils.ao.Gib + '.' + com.tencent.mm.plugin.finder.utils.ao.Gie), "");
    kotlin.g.b.s.s(paramString, "atIndexs");
    List localList = kotlin.n.n.b((CharSequence)paramString, new String[] { "," });
    paramLinkedList1 = new HashMap();
    Object localObject2 = paramLinkedList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderContact)((Iterator)localObject2).next();
      if (!((Map)paramLinkedList1).containsKey(((FinderContact)localObject3).username))
      {
        paramLinkedList = ((FinderContact)localObject3).username;
        paramString = paramLinkedList;
        if (paramLinkedList == null) {
          paramString = "";
        }
        paramLinkedList1.put(paramString, localObject3);
      }
    }
    Object localObject3 = new StringBuilder("");
    localObject2 = new ArrayList();
    if (m > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      paramString = (String)((Map)localObject1).get("." + com.tencent.mm.plugin.finder.utils.ao.Gia + '.' + com.tencent.mm.plugin.finder.utils.ao.VALUE + i + '.' + com.tencent.mm.plugin.finder.utils.ao.Gid);
      int k;
      if (paramString == null)
      {
        k = ((StringBuilder)localObject3).toString().length();
        paramString = (String)((Map)localObject1).get("." + com.tencent.mm.plugin.finder.utils.ao.Gia + '.' + com.tencent.mm.plugin.finder.utils.ao.VALUE + i);
        if (paramString == null) {
          paramString = "";
        }
        while ((localList.contains(String.valueOf(i))) && (!Util.isNullOrNil(paramString)))
        {
          paramLinkedList = kotlin.n.n.bV(paramString, " ", "_");
          if (paramLinkedList.length() > 2)
          {
            i = paramLinkedList.length();
            if (paramLinkedList == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(260408);
              throw paramString;
            }
            else
            {
              paramString = paramLinkedList.substring(1, i - 1);
              kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
          }
          else
          {
            for (;;)
            {
              paramLinkedList1 = paramString;
              if (paramLinkedList.length() <= 1) {
                break label843;
              }
              if ((!kotlin.n.n.a((CharSequence)paramLinkedList, ' ')) && (!kotlin.n.n.a((CharSequence)paramLinkedList, ' '))) {
                break label970;
              }
              i = paramLinkedList.length();
              if (paramLinkedList != null) {
                break;
              }
              paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(260408);
              throw paramString;
              paramString = paramLinkedList;
            }
            paramLinkedList = paramLinkedList.substring(0, i - 1);
            kotlin.g.b.s.s(paramLinkedList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            ((StringBuilder)localObject3).append(paramLinkedList);
            paramLinkedList1 = paramString;
            label843:
            if (n <= 0) {
              ((StringBuilder)localObject3).append(" ");
            }
            ((ArrayList)localObject2).add(new com.tencent.mm.plugin.finder.utils.h.a(k, ((StringBuilder)localObject3).toString().length(), paramLinkedList1, new FinderContact()));
          }
        }
      }
      for (;;)
      {
        if (j >= m)
        {
          Log.i(com.tencent.mm.plugin.finder.utils.ao.TAG, "parseXml, version:" + n + ", result:" + localObject3);
          if ((Util.isNullOrNil(((StringBuilder)localObject3).toString())) || ((paramList.isEmpty()) && (localList.isEmpty())))
          {
            AppMethodBeat.o(260408);
            return paramSpannableString;
            label970:
            ((StringBuilder)localObject3).append(paramLinkedList);
            paramString = paramLinkedList;
            if (paramLinkedList.length() > 2)
            {
              if (paramLinkedList == null)
              {
                paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(260408);
                throw paramString;
              }
              paramString = paramLinkedList.substring(1);
              kotlin.g.b.s.s(paramString, "(this as java.lang.String).substring(startIndex)");
            }
            paramLinkedList1 = paramString;
            break;
            paramLinkedList = com.tencent.mm.plugin.finder.utils.as.GiG;
            paramLinkedList = com.tencent.mm.plugin.finder.utils.as.a(paramString, new ArrayList(), null);
            int i1 = ((StringBuilder)localObject3).toString().length();
            paramLinkedList = ((Iterable)paramLinkedList).iterator();
            while (paramLinkedList.hasNext())
            {
              paramLinkedList1 = (bo)paramLinkedList.next();
              k = paramLinkedList1.start + i1 - 1;
              i = k;
              if (k < 0) {
                i = 0;
              }
              paramList.add(new bo(i, paramLinkedList1.count + 1, kotlin.g.b.s.X("#", paramLinkedList1.topic)));
            }
            ((StringBuilder)localObject3).append(paramString);
            continue;
            if (((CharSequence)kotlin.n.n.bq((CharSequence)paramString).toString()).length() > 0) {
              i = 1;
            }
            for (;;)
            {
              if (i != 0)
              {
                paramLinkedList = kotlin.n.n.bV(paramString, " ", "");
                paramString = paramLinkedList;
                if (paramLinkedList.length() > 1)
                {
                  i = paramLinkedList.length();
                  if (paramLinkedList == null)
                  {
                    paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(260408);
                    throw paramString;
                    i = 0;
                  }
                  else
                  {
                    paramString = paramLinkedList.substring(0, i - 1);
                    kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                  }
                }
                else
                {
                  paramList.add(new bo(((StringBuilder)localObject3).toString().length(), paramString.length(), paramString));
                  ((StringBuilder)localObject3).append(paramString);
                  if (n > 0) {
                    break;
                  }
                  ((StringBuilder)localObject3).append(" ");
                  break;
                }
              }
            }
            ((StringBuilder)localObject3).append(paramString);
            continue;
          }
          paramString = SpannableString.valueOf((CharSequence)new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)((StringBuilder)localObject3).toString())));
          kotlin.g.b.s.s(paramString, "desc");
          com.tencent.mm.plugin.finder.utils.ao.a(paramLong, paramString, paramList, paramm);
          com.tencent.mm.plugin.finder.utils.ao.a(paramString, (ArrayList)localObject2, paramb);
          AppMethodBeat.o(260408);
          return paramString;
        }
      }
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.api.i a(com.tencent.mm.plugin.finder.live.model.context.a parama, ci paramci)
  {
    AppMethodBeat.i(260918);
    parama = (com.tencent.mm.plugin.appbrand.api.i)new com.tencent.mm.plugin.finder.live.o(parama, paramci);
    AppMethodBeat.o(260918);
    return parama;
  }
  
  public final com.tencent.mm.plugin.finder.extension.reddot.p a(btw parambtw, String paramString, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(260855);
    kotlin.g.b.s.u(paramString, "source");
    kotlin.g.b.s.u(paramHashSet, "changePathSet");
    parambtw = com.tencent.mm.plugin.finder.extension.reddot.i.a(((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager(), parambtw, paramString, paramHashSet, true, null, null, 0L, 64);
    AppMethodBeat.o(260855);
    return parambtw;
  }
  
  public final BaseFinderFeed a(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(260431);
    kotlin.g.b.s.u(paramFinderItem, "finderObject");
    com.tencent.mm.plugin.finder.storage.logic.d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    paramFinderItem = com.tencent.mm.plugin.finder.storage.logic.d.a.a(paramFinderItem);
    AppMethodBeat.o(260431);
    return paramFinderItem;
  }
  
  public final com.tencent.mm.plugin.finder.utils.d a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Set<Integer> paramSet)
  {
    AppMethodBeat.i(260592);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramSet, "otherCareType");
    av localav = av.GiL;
    paramRecyclerView = av.a(paramRecyclerView, paramInt1, paramInt2, paramSet);
    AppMethodBeat.o(260592);
    return paramRecyclerView;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.c<ayl> a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(260598);
    kotlin.g.b.s.u(paramString2, "feedUsername");
    kotlin.g.b.s.u(paramString3, "username");
    kotlin.g.b.s.u(paramString4, "encryptedObjectId");
    paramString1 = (com.tencent.mm.plugin.findersdk.b.c)new az(0L, paramString1, paramInt, 2, paramString2, true, null, null, 0L, paramString3, true, false, paramString4, null, 1, null, 32768);
    AppMethodBeat.o(260598);
    return paramString1;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.h a(com.tencent.mm.bx.b paramb, long paramLong)
  {
    AppMethodBeat.i(260922);
    paramb = (com.tencent.mm.plugin.findersdk.b.h)new cg(paramb, paramLong, 1);
    AppMethodBeat.o(260922);
    return paramb;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.h a(String paramString1, int paramInt, String paramString2, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(260578);
    kotlin.g.b.s.u(paramString1, "query");
    kotlin.g.b.s.u(paramString2, "requestId");
    paramString1 = new dk(paramString1, paramInt, paramString2, paramb, 11, null, null, null, null);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString1, 0);
    paramString1 = (com.tencent.mm.plugin.findersdk.b.h)paramString1;
    AppMethodBeat.o(260578);
    return paramString1;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.h a(String paramString, boolean paramBoolean, Integer paramInteger, Long paramLong)
  {
    AppMethodBeat.i(260585);
    kotlin.g.b.s.u(paramString, "req_username");
    paramString = new dt(paramString, 0L, null, 0, null, 0, 0L, paramBoolean, null, 0L, paramInteger, paramLong, null, 4864);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString, 0);
    paramString = (com.tencent.mm.plugin.findersdk.b.h)paramString;
    AppMethodBeat.o(260585);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.w a(String paramString1, String paramString2, long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(260737);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    an.a locala = an.GhR;
    paramString1 = an.a.a(paramString1, paramString2, paramLong, paramFinderObject);
    AppMethodBeat.o(260737);
    return paramString1;
  }
  
  public final CharSequence a(Context paramContext, TextPaint paramTextPaint, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(260639);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramTextPaint, "paint");
    kotlin.g.b.s.u(paramCharSequence, "spanText");
    Object localObject = com.tencent.mm.plugin.finder.convert.d.AHD;
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramTextPaint, "paint");
    kotlin.g.b.s.u(paramCharSequence, "spanText");
    int i = com.tencent.mm.plugin.finder.convert.d.ao(paramContext, paramInt);
    paramInt = com.tencent.mm.plugin.finder.convert.d.ao(paramContext, paramInt + 1);
    localObject = new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    if (new StaticLayout(paramCharSequence, 0, paramCharSequence.length(), paramTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
    {
      AppMethodBeat.o(260639);
      return paramCharSequence;
    }
    paramInt = ((StaticLayout)localObject).getLineEnd(0);
    paramTextPaint = paramCharSequence.toString();
    if (paramTextPaint == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(260639);
      throw paramContext;
    }
    paramTextPaint = paramTextPaint.substring(0, paramInt);
    kotlin.g.b.s.s(paramTextPaint, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramContext = com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)kotlin.g.b.s.X(paramTextPaint, "..."));
    kotlin.g.b.s.s(paramContext, "{\n            val ellips…Start) + \"...\")\n        }");
    paramContext = (CharSequence)paramContext;
    AppMethodBeat.o(260639);
    return paramContext;
  }
  
  public final CharSequence a(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(260634);
    kotlin.g.b.s.u(paramTextView, "tv");
    kotlin.g.b.s.u(paramCharSequence, "spanText");
    com.tencent.mm.plugin.finder.convert.d locald = com.tencent.mm.plugin.finder.convert.d.AHD;
    paramTextView = com.tencent.mm.plugin.finder.convert.d.a(paramTextView, paramCharSequence, paramInt);
    AppMethodBeat.o(260634);
    return paramTextView;
  }
  
  public final String a(com.tencent.mm.plugin.finder.loader.o paramo)
  {
    AppMethodBeat.i(260644);
    kotlin.g.b.s.u(paramo, "pagFile");
    bm localbm = bm.GlZ;
    paramo = bm.a(paramo);
    AppMethodBeat.o(260644);
    return paramo;
  }
  
  public final void a(int paramInt, kotlin.g.a.b<? super com.tencent.mm.plugin.findersdk.b.h, ah> paramb)
  {
    AppMethodBeat.i(260571);
    kotlin.g.b.s.u(paramb, "callback");
    di localdi = new di(paramInt);
    paramb.invoke(localdi);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localdi, 0);
    AppMethodBeat.o(260571);
  }
  
  public final void a(Activity paramActivity, int paramInt, Intent paramIntent, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(260685);
    kotlin.g.b.s.u(paramActivity, "context");
    FinderBottomCustomDialogHelper.Companion.showCreateFinderUserDialogOnLiveWithCallback(paramActivity, paramInt, paramIntent, 10002, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener);
    AppMethodBeat.o(260685);
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, Long paramLong1, int paramInt)
  {
    AppMethodBeat.i(260832);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "username");
    com.tencent.mm.plugin.finder.feed.logic.a locala = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
    com.tencent.mm.plugin.finder.feed.logic.a.a(paramContext, paramLong, paramString, paramLong1, 62);
    AppMethodBeat.o(260832);
  }
  
  public final void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(260649);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramIntent, "intent");
    as.a locala = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    as.a.a(paramContext, paramIntent, 0L, null, 0, paramInt, false);
    AppMethodBeat.o(260649);
  }
  
  public final void a(Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(260838);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "exposeUrl");
    kotlin.g.b.s.u(paramString2, "username");
    com.tencent.mm.plugin.finder.feed.logic.a locala = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
    com.tencent.mm.plugin.finder.feed.logic.a.a(paramContext, paramString1, paramLong, paramString2);
    AppMethodBeat.o(260838);
  }
  
  public final void a(Context paramContext, String paramString, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(260411);
    kotlin.g.b.s.u(paramString, "nickname");
    kotlin.g.b.s.u(paramFinderItem, "feedObject");
    com.tencent.mm.plugin.finder.utils.h localh = com.tencent.mm.plugin.finder.utils.h.Gga;
    com.tencent.mm.plugin.finder.utils.h.a(paramContext, paramString, paramFinderItem);
    AppMethodBeat.o(260411);
  }
  
  public final void a(ImageView paramImageView, FinderAuthInfo paramFinderAuthInfo, int paramInt, pu parampu)
  {
    AppMethodBeat.i(260722);
    kotlin.g.b.s.u(paramImageView, "view");
    av localav = av.GiL;
    av.a(paramImageView, paramFinderAuthInfo, paramInt, parampu);
    AppMethodBeat.o(260722);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, String paramString, t paramt, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(369698);
    kotlin.g.b.s.u(paramAppCompatActivity, "context");
    kotlin.g.b.s.u(paramString, "userName");
    kotlin.g.b.s.u(paramt, "menu");
    kotlin.g.b.s.u(paramFinderItem, "feedObject");
    com.tencent.mm.plugin.finder.feed.ao localao = com.tencent.mm.plugin.finder.feed.ao.AYv;
    com.tencent.mm.plugin.finder.feed.ao.b(paramAppCompatActivity, paramString, paramt, paramFinderItem);
    AppMethodBeat.o(369698);
  }
  
  public final void a(AppCompatActivity paramAppCompatActivity, String paramString, t paramt, FinderItem paramFinderItem, kotlin.g.a.b<? super List<String>, ah> paramb)
  {
    AppMethodBeat.i(369699);
    kotlin.g.b.s.u(paramAppCompatActivity, "context");
    kotlin.g.b.s.u(paramString, "userName");
    kotlin.g.b.s.u(paramt, "menu");
    kotlin.g.b.s.u(paramFinderItem, "feedObject");
    ad localad = ad.AWU;
    ad.b(paramAppCompatActivity, paramString, paramt, paramFinderItem, paramb);
    AppMethodBeat.o(369699);
  }
  
  public final void a(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(260496);
    kotlin.g.b.s.u(paramMMFinderUI, "finder");
    ((l)com.tencent.mm.kernel.h.ax(l.class)).a(paramMMFinderUI);
    if (this.pFe.contains(paramMMFinderUI))
    {
      AppMethodBeat.o(260496);
      return;
    }
    if (((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).isNearbyActivity((MMActivity)paramMMFinderUI))
    {
      Log.i("FinderCommonService", kotlin.g.b.s.X("onFinderForeground: ui is from nearby, ui = ", paramMMFinderUI));
      AppMethodBeat.o(260496);
      return;
    }
    if (this.pFe.size() == 0)
    {
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = ((Iterable)((com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).EVR).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.finder.preload.tabPreload.g localg = (com.tencent.mm.plugin.finder.preload.tabPreload.g)((Iterator)localObject).next();
        Log.i(localg.TAG, "[performEnterFinder]");
        localg.EWd = true;
        localg.EWe.azn("performEnterFinder");
      }
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
    }
    this.pFe.add(paramMMFinderUI);
    AppMethodBeat.o(260496);
  }
  
  public final void a(FinderObject paramFinderObject, int paramInt)
  {
    AppMethodBeat.i(260892);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    z localz = z.FrZ;
    z.a(paramFinderObject, paramInt);
    AppMethodBeat.o(260892);
  }
  
  public final void a(FinderObject paramFinderObject, bui parambui)
  {
    AppMethodBeat.i(260867);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    z localz = z.FrZ;
    z.a(paramFinderObject, parambui);
    AppMethodBeat.o(260867);
  }
  
  public final void a(bui parambui, aps paramaps)
  {
    AppMethodBeat.i(260623);
    kotlin.g.b.s.u(paramaps, "extStats");
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new bu(parambui, 18054, paramaps), 0);
    AppMethodBeat.o(260623);
  }
  
  public final void a(bui parambui, String paramString1, int paramInt, long paramLong, boolean paramBoolean, String paramString2, bma parambma)
  {
    AppMethodBeat.i(260806);
    kotlin.g.b.s.u(parambui, "contextObj");
    kotlin.g.b.s.u(paramString1, "finderUser");
    kotlin.g.b.s.u(paramString2, "participantFinderUsername");
    com.tencent.mm.plugin.finder.model.ak localak = com.tencent.mm.plugin.finder.model.ak.ECS;
    com.tencent.mm.plugin.finder.model.ak.a(parambui, paramString1, paramInt, paramLong, paramBoolean, paramString2, parambma);
    AppMethodBeat.o(260806);
  }
  
  public final void a(MMActivity paramMMActivity, long paramLong, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, String paramString4, bui parambui, int paramInt, kotlin.g.a.b<? super com.tencent.mm.am.b.a<ayl>, ah> paramb)
  {
    AppMethodBeat.i(369697);
    kotlin.g.b.s.u(paramMMActivity, "context");
    kotlin.g.b.s.u(paramString2, "feedUsername");
    kotlin.g.b.s.u(paramString3, "username");
    kotlin.g.b.s.u(paramString4, "encryptedObjectId");
    new az(paramLong, paramString1, 0, 2, paramString2, paramBoolean1, null, null, 0L, paramString3, paramBoolean2, false, paramString4, parambui, paramInt, null, 32768).bFJ().b(new a..ExternalSyntheticLambda0(paramb)).a((com.tencent.mm.vending.e.b)paramMMActivity);
    AppMethodBeat.o(369697);
  }
  
  public final void a(String paramString, d.a.a parama)
  {
    AppMethodBeat.i(260548);
    kotlin.g.b.s.u(paramString, "username");
    kotlin.g.b.s.u(parama, "logOutInfo");
    Object localObject = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
    localObject = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString);
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
        localObject = com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp();
        h.c localc = new h.c();
        localc.FeH = parama;
        parama = ah.aiuX;
        ((com.tencent.mm.b.h)localObject).put(paramString, localc);
      }
      AppMethodBeat.o(260548);
      return;
      ((h.c)localObject).FeH = parama;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, kotlin.g.a.b<? super fvk, ah> paramb1, kotlin.g.a.b<? super Integer, ah> paramb2)
  {
    AppMethodBeat.i(260912);
    kotlin.g.b.s.u(paramb, "lifeCycle");
    kotlin.g.b.s.u(paramb1, "onSuccess");
    kotlin.g.b.s.u(paramb2, "onError");
    ay localay = ay.Gjp;
    ay.a(paramString, paramb, paramb1, paramb2, false, 0);
    AppMethodBeat.o(260912);
  }
  
  public final void a(String paramString, Long paramLong, com.tencent.mm.plugin.finder.utils.f paramf)
  {
    AppMethodBeat.i(260394);
    kotlin.g.b.s.u(paramString, "topic");
    kotlin.g.b.s.u(paramf, "clickExtra");
    com.tencent.mm.plugin.finder.utils.as localas = com.tencent.mm.plugin.finder.utils.as.GiG;
    com.tencent.mm.plugin.finder.utils.as.a(paramString, paramLong, paramf);
    AppMethodBeat.o(260394);
  }
  
  public final void a(String paramString1, String paramString2, ca.a<Integer> parama, String paramString3, ca.a<Void> parama1, String paramString4, String paramString5, bkr parambkr, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(260931);
    kotlin.g.b.s.u(paramString4, "contextId");
    kotlin.g.b.s.u(paramString5, "reportExtraInfo");
    ax.a(new ax(), paramString1, paramString2, parama, paramString3, 0L, parama1, paramString4, paramString5, parambkr, 0L, null, paramMap, 1024);
    AppMethodBeat.o(260931);
  }
  
  public final void a(List<? extends cc> paramList, Intent paramIntent)
  {
    AppMethodBeat.i(260760);
    kotlin.g.b.s.u(paramList, "feedList");
    kotlin.g.b.s.u(paramIntent, "intent");
    av localav = av.GiL;
    av.a(0, paramList, null, paramIntent, null);
    AppMethodBeat.o(260760);
  }
  
  public final boolean a(com.tencent.d.a.a.a.d.a.g paramg)
  {
    Object localObject = null;
    AppMethodBeat.i(260934);
    kotlin.g.b.s.u(paramg, "info");
    av localav = av.GiL;
    kotlin.g.b.s.u(paramg, "info");
    int i;
    if (paramg.systemRowid != -1L)
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
      label45:
      if (paramg != null) {
        break label74;
      }
    }
    label69:
    label74:
    for (paramg = localObject;; paramg = Boolean.valueOf(com.tencent.mm.ae.d.ee(paramg.field_controlFlag, 2)))
    {
      if (paramg != null) {
        break label89;
      }
      AppMethodBeat.o(260934);
      return false;
      i = 0;
      break;
      paramg = null;
      break label45;
    }
    label89:
    boolean bool = paramg.booleanValue();
    AppMethodBeat.o(260934);
    return bool;
  }
  
  public final void abandonAudioFocus()
  {
    AppMethodBeat.i(260505);
    this.nmW.gR(false);
    AppMethodBeat.o(260505);
  }
  
  public final TextStatusJumpInfo b(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(260731);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    an.a locala = an.GhR;
    paramFinderObject = an.a.b(paramFinderObject);
    AppMethodBeat.o(260731);
    return paramFinderObject;
  }
  
  public final String b(com.tencent.mm.plugin.finder.loader.o paramo)
  {
    AppMethodBeat.i(260646);
    kotlin.g.b.s.u(paramo, "pagFile");
    bm localbm = bm.GlZ;
    paramo = bm.b(paramo);
    AppMethodBeat.o(260646);
    return paramo;
  }
  
  public final void b(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(260497);
    kotlin.g.b.s.u(paramMMFinderUI, "finder");
    this.pFe.remove(paramMMFinderUI);
    ((l)com.tencent.mm.kernel.h.ax(l.class)).b(paramMMFinderUI);
    if (this.pFe.size() == 0)
    {
      paramMMFinderUI = com.tencent.mm.ui.component.k.aeZF;
      paramMMFinderUI = ((Iterable)((com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).EVR).iterator();
      while (paramMMFinderUI.hasNext())
      {
        com.tencent.mm.plugin.finder.preload.tabPreload.g localg = (com.tencent.mm.plugin.finder.preload.tabPreload.g)paramMMFinderUI.next();
        Log.i(localg.TAG, "[performExitFinder]");
        localg.EWd = false;
        if ((localg.EWg.get()) && (!localg.EWf.get()))
        {
          int i = localg.EWb.eHM().fmM();
          if (localg.hJx == i) {
            localg.EWe.a(localg.EWj, localg.eHQ(), "performExitFinder");
          }
        }
      }
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
      com.tencent.mm.plugin.finder.extension.reddot.i.dZk();
    }
    AppMethodBeat.o(260497);
  }
  
  public final aur bTZ()
  {
    AppMethodBeat.i(260367);
    Object localObject = com.tencent.mm.plugin.finder.video.f.Gog;
    localObject = com.tencent.mm.plugin.finder.video.f.bTZ();
    AppMethodBeat.o(260367);
    return localObject;
  }
  
  public final List<awn> bUa()
  {
    AppMethodBeat.i(260371);
    Object localObject = com.tencent.mm.plugin.finder.video.f.Gog;
    localObject = (List)com.tencent.mm.plugin.finder.video.f.fiS();
    AppMethodBeat.o(260371);
    return localObject;
  }
  
  public final boolean bUb()
  {
    AppMethodBeat.i(260372);
    boolean bool = ((g)com.tencent.mm.kernel.h.ax(g.class)).bUb();
    AppMethodBeat.o(260372);
    return bool;
  }
  
  public final boolean bUc()
  {
    AppMethodBeat.i(260387);
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage().bUc();
    AppMethodBeat.o(260387);
    return bool;
  }
  
  public final boolean bUd()
  {
    AppMethodBeat.i(260388);
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage().bUd();
    AppMethodBeat.o(260388);
    return bool;
  }
  
  public final boolean bUe()
  {
    AppMethodBeat.i(260498);
    if (this.pFe.size() > 0)
    {
      AppMethodBeat.o(260498);
      return true;
    }
    AppMethodBeat.o(260498);
    return false;
  }
  
  public final void bUf()
  {
    AppMethodBeat.i(260502);
    this.nmW.a((com.tencent.mm.model.d.a)new b());
    AppMethodBeat.o(260502);
  }
  
  public final int bUg()
  {
    AppMethodBeat.i(260529);
    z localz = z.FrZ;
    int i = z.bUg();
    AppMethodBeat.o(260529);
    return i;
  }
  
  public final String bUh()
  {
    AppMethodBeat.i(260614);
    Object localObject = bm.GlZ;
    localObject = bm.fil();
    AppMethodBeat.o(260614);
    return localObject;
  }
  
  public final com.tencent.mm.view.recyclerview.f<com.tencent.mm.view.recyclerview.a> bUi()
  {
    AppMethodBeat.i(260630);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
    AppMethodBeat.o(260630);
    return localf;
  }
  
  public final androidx.recyclerview.widget.w bUj()
  {
    AppMethodBeat.i(260657);
    androidx.recyclerview.widget.w localw = (androidx.recyclerview.widget.w)new com.tencent.mm.plugin.finder.view.animation.e();
    AppMethodBeat.o(260657);
    return localw;
  }
  
  public final String bUk()
  {
    AppMethodBeat.i(260701);
    Object localObject = bm.GlZ;
    localObject = bm.bUk();
    AppMethodBeat.o(260701);
    return localObject;
  }
  
  public final void bUl()
  {
    AppMethodBeat.i(260820);
    Object localObject = com.tencent.mm.plugin.finder.megavideo.floatball.a.Ezy;
    com.tencent.mm.plugin.finder.megavideo.floatball.a.a.eCH().ego();
    localObject = com.tencent.mm.plugin.finder.floatball.b.BtK;
    com.tencent.mm.plugin.finder.floatball.b.a.egt().ego();
    AppMethodBeat.o(260820);
  }
  
  public final String bUm()
  {
    AppMethodBeat.i(260877);
    Object localObject = z.FrZ;
    localObject = z.bUm();
    AppMethodBeat.o(260877);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.h bUn()
  {
    AppMethodBeat.i(260925);
    com.tencent.mm.plugin.findersdk.b.h localh = (com.tencent.mm.plugin.findersdk.b.h)new di(8);
    AppMethodBeat.o(260925);
    return localh;
  }
  
  public final com.tencent.mm.plugin.finder.feed.n c(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(260642);
    kotlin.g.b.s.u(paramMMActivity, "context");
    paramMMActivity = (com.tencent.mm.plugin.finder.feed.n)new com.tencent.mm.plugin.finder.feed.as(paramMMActivity);
    AppMethodBeat.o(260642);
    return paramMMActivity;
  }
  
  public final String cV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(369702);
    av localav = av.GiL;
    paramString1 = av.V(paramString1, paramString2, false);
    AppMethodBeat.o(369702);
    return paramString1;
  }
  
  public final Spanned cm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(260415);
    kotlin.g.b.s.u(paramString1, "origin");
    kotlin.g.b.s.u(paramString2, "highLightFontColor");
    com.tencent.mm.plugin.finder.search.k localk = com.tencent.mm.plugin.finder.search.k.FxZ;
    paramString1 = com.tencent.mm.plugin.finder.search.k.cm(paramString1, paramString2);
    AppMethodBeat.o(260415);
    return paramString1;
  }
  
  public final String cn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(260902);
    av localav = av.GiL;
    paramString1 = av.cn(paramString1, paramString2);
    AppMethodBeat.o(260902);
    return paramString1;
  }
  
  public final boolean ek(Context paramContext)
  {
    AppMethodBeat.i(260443);
    kotlin.g.b.s.u(paramContext, "context");
    boolean bool = paramContext instanceof FinderHomeUI;
    AppMethodBeat.o(260443);
    return bool;
  }
  
  public final bn el(Context paramContext)
  {
    AppMethodBeat.i(260648);
    kotlin.g.b.s.u(paramContext, "context");
    as.a locala = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramContext = (bn)as.a.hu(paramContext);
    AppMethodBeat.o(260648);
    return paramContext;
  }
  
  public final void em(Context paramContext)
  {
    AppMethodBeat.i(260672);
    kotlin.g.b.s.u(paramContext, "context");
    FinderBottomCustomDialogHelper.Companion.showCreateFinderUserDialog(paramContext, 3, null);
    AppMethodBeat.o(260672);
  }
  
  public final com.tencent.mm.plugin.finder.storage.f getContactStorage()
  {
    AppMethodBeat.i(260472);
    com.tencent.mm.plugin.finder.storage.f localf = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getContactStorage();
    AppMethodBeat.o(260472);
    return localf;
  }
  
  public final com.tencent.mm.plugin.finder.api.b getFinderContactCache()
  {
    AppMethodBeat.i(260377);
    com.tencent.mm.plugin.finder.api.b localb = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderContactCache();
    AppMethodBeat.o(260377);
    return localb;
  }
  
  public final j getFinderSyncExtension()
  {
    AppMethodBeat.i(260510);
    j localj = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension();
    AppMethodBeat.o(260510);
    return localj;
  }
  
  public final boolean h(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(260791);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    av localav = av.GiL;
    boolean bool = av.h(paramRecyclerView);
    AppMethodBeat.o(260791);
    return bool;
  }
  
  public final boolean isFriend(String paramString)
  {
    AppMethodBeat.i(260475);
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).isFriend(paramString);
    AppMethodBeat.o(260475);
    return bool;
  }
  
  public final FinderItem jm(long paramLong)
  {
    AppMethodBeat.i(260554);
    Object localObject = z.FrZ;
    localObject = z.jm(paramLong);
    AppMethodBeat.o(260554);
    return localObject;
  }
  
  public final FinderItem jn(long paramLong)
  {
    AppMethodBeat.i(260562);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFeedStorage().jn(paramLong);
    AppMethodBeat.o(260562);
    return localFinderItem;
  }
  
  public final String k(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(260712);
    av localav = av.GiL;
    paramString1 = av.k(paramString1, paramString2, false);
    AppMethodBeat.o(260712);
    return paramString1;
  }
  
  public final void onEnterFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(260493);
    kotlin.g.b.s.u(paramMMFinderUI, "finder");
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).onEnterFinder(paramMMFinderUI);
    AppMethodBeat.o(260493);
  }
  
  public final void onExitFinder(MMFinderUI paramMMFinderUI)
  {
    AppMethodBeat.i(260482);
    kotlin.g.b.s.u(paramMMFinderUI, "finder");
    this.pFd.remove(paramMMFinderUI);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).onExitFinder(paramMMFinderUI);
    if (com.tencent.mm.kernel.h.baz()) {
      ((l)com.tencent.mm.kernel.h.ax(l.class)).onExitFinder(paramMMFinderUI);
    }
    AppMethodBeat.o(260482);
  }
  
  public final String p(long paramLong, int paramInt)
  {
    AppMethodBeat.i(260456);
    Object localObject = z.FrZ;
    localObject = z.p(paramLong, paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(260456);
      return "";
    }
    AppMethodBeat.o(260456);
    return localObject;
  }
  
  public final bd q(long paramLong, int paramInt)
  {
    AppMethodBeat.i(260519);
    Object localObject = z.FrZ;
    localObject = z.q(paramLong, paramInt);
    AppMethodBeat.o(260519);
    return localObject;
  }
  
  public final void showRealNameCertificationDialog(Activity paramActivity)
  {
    AppMethodBeat.i(260675);
    kotlin.g.b.s.u(paramActivity, "context");
    FinderBottomCustomDialogHelper.Companion.showRealNameCertificationDialog(paramActivity);
    AppMethodBeat.o(260675);
  }
  
  public final void showUserInfoConfirmDialog(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    AppMethodBeat.i(369701);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "finderUserName");
    FinderBottomCustomDialogHelper.Companion.showUserInfoConfirmDialog(paramContext, paramString, paramOnClickListener1, paramOnClickListener2, paramOnDismissListener, paramBoolean);
    AppMethodBeat.o(369701);
  }
  
  public final boolean yi(int paramInt)
  {
    AppMethodBeat.i(260619);
    av localav = av.GiL;
    boolean bool = av.yi(paramInt);
    AppMethodBeat.o(260619);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/FinderCommonService$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/FinderCommonService$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.model.d.a
  {
    public final void bAi()
    {
      AppMethodBeat.i(260266);
      Log.i("FinderCommonService", "[audioHelperTool] gain");
      AppMethodBeat.o(260266);
    }
    
    public final void bAj()
    {
      AppMethodBeat.i(260270);
      Log.i("FinderCommonService", "[audioHelperTool] loss");
      AppMethodBeat.o(260270);
    }
    
    public final void bAk()
    {
      AppMethodBeat.i(260268);
      Log.i("FinderCommonService", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(260268);
    }
    
    public final void bAl()
    {
      AppMethodBeat.i(260272);
      Log.i("FinderCommonService", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(260272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.a
 * JD-Core Version:    0.7.0.1
 */