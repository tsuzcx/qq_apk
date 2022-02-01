package com.tencent.mm.plugin.finder;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.ej;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.bp;
import com.tencent.mm.plugin.finder.feed.aa;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.d;
import com.tencent.mm.plugin.finder.live.d.a;
import com.tencent.mm.plugin.finder.live.f;
import com.tencent.mm.plugin.finder.live.l;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.cgi.ac;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.v.g;
import com.tencent.mm.plugin.finder.live.model.v.h;
import com.tencent.mm.plugin.finder.live.model.v.i;
import com.tencent.mm.plugin.finder.live.model.v.j;
import com.tencent.mm.plugin.finder.live.model.v.k;
import com.tencent.mm.plugin.finder.live.model.v.l;
import com.tencent.mm.plugin.finder.live.model.v.m;
import com.tencent.mm.plugin.finder.live.model.v.n;
import com.tencent.mm.plugin.finder.live.model.v.o;
import com.tencent.mm.plugin.finder.live.model.v.p;
import com.tencent.mm.plugin.finder.live.model.v.q;
import com.tencent.mm.plugin.finder.live.model.v.r;
import com.tencent.mm.plugin.finder.live.model.v.s;
import com.tencent.mm.plugin.finder.live.model.v.t;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveConfettiView;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.m;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bb;
import com.tencent.mm.plugin.finder.utils.bb.c;
import com.tencent.mm.plugin.finder.utils.bd;
import com.tencent.mm.plugin.finder.video.FinderLivePlayView;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.an;
import com.tencent.mm.plugin.findersdk.a.ao;
import com.tencent.mm.plugin.findersdk.a.u;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/FinderCommonLiveService;", "Lcom/tencent/mm/plugin/IFinderCommonLiveService;", "()V", "Audience21053ReportReportOnExposure", "", "liveFeed", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "addCreateNotice", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "addNotice", "userName", "", "liveNoticeInfo", "assignIsIgnorePreloadForFeedId", "isIgnorePreloadForFeedId", "", "assignLiveLoaderIsIgnorePreloadForFeedId", "assignLiveLoaderIsIgnorePreloadShopForFeedId", "isIgnorePreloadShopForFeedId", "autoPlayFinderLiveList", "", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "convertToLiveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "toWhere", "", "forceFetchObject", "convertToSimilarLive", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "clickFeed", "commentScene", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "convertToVisitorLiveData", "tabType", "createFinderLiveFeedDecorator", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveFeedDecorator;", "scene", "decorateView", "Landroid/view/ViewGroup;", "createFinderLivePlayView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "createFinderLivePlayViewClass", "createFinderUploadLiveCoverImageTask", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "createLiveCardAutoPlayMgr", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardAutoPlayManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "feedList", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "createLiveLogoAssistant", "Lcom/tencent/mm/plugin/findersdk/api/ILiveLogoAssistant;", "anchorUsername", "position", "isLiveFeed", "createNetSceneAudienceReserveLive", "Lcom/tencent/mm/modelbase/NetSceneBase;", "noticeId", "optype", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "promoToken", "doCgiFinderAudienceReserveLive", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "doCgiFinderAuthAppMsg", "Lcom/tencent/mm/protocal/protobuf/FinderSendInviteMsgResponse;", "toUserName", "msgContent", "callback", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderAuthAppMsg;", "doCgiFinderBatchGetObjectAsyncLoadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "units", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectUidUnit;", "liveReportScene", "finderUserName", "uxInfo", "objectIds", "Lkotlin/Pair;", "doCgiFinderCreateLiveNotice", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveNoticeResponse;", "opType", "doCgiFinderLiveGetLastObject", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "username", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;", "doCgiFinderLiveStream", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "lng", "", "lat", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveStreamCallback;", "enableMoclLiveList", "filterData", "Ljava/util/LinkedList;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "firstItemPos", "lastItemPos", "formatNumber", "number", "getFinderLiveConfettView", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveConfettView;", "getHalfMiniProgramHeight", "getHourList", "day", "formatStrRes", "isIgnoreMinute", "getMiniprogramType", "getNotice", "getNoticeSnapshot", "getNoticeStartTime", "getPerformanceLevel", "getPreloadMiniProgramBundleList", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "preloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveWxaPreloadInfo;", "goAnchorUIWithCheck", "config", "contextId", "clickTabContextId", "intent", "Landroid/content/Intent;", "goVisitorUIWithCheck", "i", "needAnim", "onBeforeStart", "Lkotlin/Function0;", "gotoReplayUI", "withCheck", "hasCreateNotice", "isAnchorLive", "isLibPagEnabled", "needCalculateWatchNumberOnFeedFlow", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "readLiveListDebugInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "releaseWithMiniWindow", "isTopApplication", "removeCreateNotice", "replaceNotify", "newMsgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "rewardGainEnableBySwitchFlag", "switchFlag", "saveAliasInfoList", "aliasInfoList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "saveLiveListDebugInfo", "info", "", "setBlurBitmap", "imageView", "Landroid/widget/ImageView;", "url", "radius", "setETInputConfig", "descTv", "Landroid/widget/EditText;", "textCountTv", "Landroid/widget/TextView;", "maxInputLength", "maxInputSize", "configCallback", "startPlayLiveOnFeedFlow", "finderObject", "stopPlayLiveOnFeedFlow", "str2NameList", "str", "tryToPreRender", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "bundle", "preloadIfFail", "updateCreateNoticeList", "list", "watchLiveVisitorCore", "closeLive", "outSideLive", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.g
{
  public final void B(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(329971);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.live.model.v localv = com.tencent.mm.plugin.finder.live.model.v.CGh;
    com.tencent.mm.plugin.finder.live.model.v.N(paramContext, paramIntent);
    AppMethodBeat.o(329971);
  }
  
  public final bkk Sv(String paramString)
  {
    AppMethodBeat.i(329891);
    kotlin.g.b.s.u(paramString, "userName");
    com.tencent.mm.plugin.finder.feed.model.j localj = com.tencent.mm.plugin.finder.feed.model.j.BfL;
    paramString = com.tencent.mm.plugin.finder.feed.model.j.Sv(paramString);
    AppMethodBeat.o(329891);
    return paramString;
  }
  
  public final void Sw(String paramString)
  {
    AppMethodBeat.i(329910);
    kotlin.g.b.s.u(paramString, "noticeId");
    com.tencent.mm.plugin.finder.feed.model.j localj = com.tencent.mm.plugin.finder.feed.model.j.BfL;
    com.tencent.mm.plugin.finder.feed.model.j.Sw(paramString);
    AppMethodBeat.o(329910);
  }
  
  public final List<String> Sx(String paramString)
  {
    AppMethodBeat.i(329923);
    kotlin.g.b.s.u(paramString, "str");
    com.tencent.mm.plugin.finder.feed.model.k.a locala = com.tencent.mm.plugin.finder.feed.model.k.Bho;
    kotlin.g.b.s.u(paramString, "str");
    paramString = n.a((CharSequence)paramString, new String[] { "," });
    AppMethodBeat.o(329923);
    return paramString;
  }
  
  public final int a(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent, boolean paramBoolean, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(329959);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFinderLiveBundle, "config");
    kotlin.g.b.s.u(paramString1, "contextId");
    kotlin.g.b.s.u(paramString2, "clickTabContextId");
    com.tencent.mm.plugin.finder.live.model.v localv = com.tencent.mm.plugin.finder.live.model.v.CGh;
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFinderLiveBundle, "config");
    kotlin.g.b.s.u(paramString1, "contextId");
    kotlin.g.b.s.u(paramString2, "clickTabContextId");
    Object localObject1 = paramFinderLiveBundle.ekC();
    long l;
    if (localObject1 != null)
    {
      l = ((LiveConfig)localObject1).liveId;
      if (l != 0L)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.Doi;
        Log.i("HABBYGE-MALI.HellLiveVisitorReoprter", kotlin.g.b.s.X("#markTapEnterLive ", Long.valueOf(l)));
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.or(l);
        ((ej)localObject1).iDB = l;
        ((ej)localObject1).iDM = cn.bDv();
      }
    }
    localObject1 = com.tencent.mm.plugin.findersdk.f.b.HeJ;
    com.tencent.mm.plugin.findersdk.f.b.iz("goVisitorUIWithCheck", "init goVisitorUIWithCheck contextId:" + paramString1 + ' ' + paramFinderLiveBundle + ' ');
    if (paramIntent == null) {
      localObject1 = "";
    }
    for (;;)
    {
      int i;
      label196:
      Object localObject2;
      label242:
      Object localObject3;
      if (paramIntent == null)
      {
        i = 0;
        localObject2 = paramFinderLiveBundle.ekC();
        if (localObject2 != null) {
          ((LiveConfig)localObject2).mIS = ((String)localObject1);
        }
        localObject1 = paramFinderLiveBundle.ekC();
        if (localObject1 != null) {
          ((LiveConfig)localObject1).mIT = i;
        }
        if (paramIntent != null) {
          break label825;
        }
        localObject1 = "";
        paramFinderLiveBundle.setEcSource((String)localObject1);
        paramFinderLiveBundle.av(paramIntent);
        if (paramIntent != null) {
          break label852;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject2 = new bmx();
          localObject3 = (com.tencent.mm.bx.a)localObject2;
        }
      }
      try
      {
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = ah.aiuX;
        paramFinderLiveBundle.CFm = ((bmx)localObject2);
        localObject1 = paramFinderLiveBundle.ekC();
        if (localObject1 != null)
        {
          l = ((LiveConfig)localObject1).liveId;
          localObject1 = bd.Gli;
          localObject2 = kotlin.g.b.s.X(bd.fhS(), Long.valueOf(l));
          kotlin.g.b.s.u(localObject2, "id");
          bd.Gln.clear();
          ((Map)bd.Gln).put(localObject2, new com.tencent.mm.plugin.finder.utils.bn(cn.bDu(), 0));
          localObject3 = bb.GjM;
          bd.a((bd)localObject1, (String)localObject2, bb.fho().name, null, true, false, false, 52);
        }
        com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.festival.a.a.class);
        localObject1 = com.tencent.mm.plugin.finder.replay.k.Fky;
        com.tencent.mm.plugin.finder.replay.k.a.eLG();
        localObject2 = new ah.d();
        localObject3 = new ah.f();
        ((ah.f)localObject3).aqH = paramString1;
        paramString1 = (CharSequence)((ah.f)localObject3).aqH;
        if ((paramString1 == null) || (paramString1.length() == 0))
        {
          i = 1;
          if (i != 0)
          {
            paramString1 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).el(paramContext);
            if (paramString1 != null) {
              break label894;
            }
            paramString1 = "";
            ((ah.f)localObject3).aqH = paramString1;
            Log.i("Finder.LiveJumpChecker", kotlin.g.b.s.X("goVisitorUIWithCheck locContextId:", ((ah.f)localObject3).aqH));
          }
          localObject1 = new ah.f();
          paramString1 = paramContext.getResources().getString(p.h.app_i_know);
          kotlin.g.b.s.s(paramString1, "context.resources.getString(R.string.app_i_know)");
          ((ah.f)localObject1).aqH = paramString1;
          paramString1 = (com.tencent.mm.plugin.finder.live.model.v)localv;
          if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(paramContext)) {
            break label917;
          }
          if (paramString1 != null)
          {
            paramString1 = paramString1.bb((kotlin.g.a.a)new v.o(paramContext, (ah.f)localObject1, (ah.d)localObject2));
            if (paramString1 != null)
            {
              paramString1 = paramString1.be((kotlin.g.a.a)new v.p(paramContext, (ah.d)localObject2));
              if (paramString1 != null)
              {
                paramString1 = paramString1.bc((kotlin.g.a.a)new v.q(paramContext, (ah.d)localObject2));
                if (paramString1 != null)
                {
                  paramString1 = paramString1.b(false, (kotlin.g.a.b)new v.r(paramFinderLiveBundle, paramContext, (ah.f)localObject3, paramIntent, paramBoolean, (ah.d)localObject2));
                  if (paramString1 != null)
                  {
                    paramString1 = paramString1.a(paramContext, (kotlin.g.a.a)new v.s(paramContext, (ah.d)localObject2));
                    if (paramString1 != null)
                    {
                      paramString1 = paramString1.bd((kotlin.g.a.a)new v.t(paramContext, (ah.d)localObject2));
                      if ((paramString1 != null) && (paramString1.c(false, (kotlin.g.a.a)v.n.CGq) != null))
                      {
                        parama.invoke();
                        ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUl();
                        com.tencent.mm.plugin.finder.live.model.v.b(paramContext, paramFinderLiveBundle, (String)((ah.f)localObject3).aqH, paramString2, paramIntent, paramBoolean);
                      }
                    }
                  }
                }
              }
            }
          }
          i = ((ah.d)localObject2).aixb;
          AppMethodBeat.o(329959);
          return i;
          localObject1 = paramIntent.getStringExtra("key_enter_live_param_share_username");
          if (localObject1 == null)
          {
            localObject1 = "";
            continue;
          }
          continue;
          i = paramIntent.getIntExtra("key_enter_live_param_from_share_scene", 0);
          break label196;
          label825:
          localObject2 = paramIntent.getStringExtra("key_enter_live_param_ecsource");
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label242;
          }
          localObject1 = "";
          break label242;
          label852:
          localObject1 = paramIntent.getByteArrayExtra("KEY_ENTER_LIVE_PARAM_SQUARE_EXTRA_INFO");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          continue;
          i = 0;
          continue;
          label894:
          String str = paramString1.fov();
          paramString1 = str;
          if (str == null)
          {
            paramString1 = "";
            continue;
            label917:
            paramString1 = null;
          }
        }
      }
    }
  }
  
  public final p a(String paramString1, String paramString2, int paramInt, bui parambui, String paramString3)
  {
    AppMethodBeat.i(329851);
    kotlin.g.b.s.u(paramString1, "userName");
    kotlin.g.b.s.u(paramString2, "noticeId");
    paramString1 = (p)new bp(paramString1, paramString2, paramInt, parambui, paramString3, null, 32);
    AppMethodBeat.o(329851);
    return paramString1;
  }
  
  public final FinderLiveBundle a(ArrayList<com.tencent.mm.plugin.finder.model.cc> paramArrayList, com.tencent.mm.plugin.finder.model.cc paramcc, int paramInt)
  {
    AppMethodBeat.i(330026);
    kotlin.g.b.s.u(paramArrayList, "data");
    kotlin.g.b.s.u(paramcc, "clickFeed");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    paramArrayList = com.tencent.mm.plugin.finder.live.utils.a.a(paramArrayList, paramcc, paramInt, false, null);
    AppMethodBeat.o(330026);
    return paramArrayList;
  }
  
  public final FinderLiveBundle a(ArrayList<com.tencent.mm.plugin.finder.model.cc> paramArrayList, com.tencent.mm.plugin.finder.model.cc paramcc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(330030);
    kotlin.g.b.s.u(paramArrayList, "data");
    kotlin.g.b.s.u(paramcc, "clickFeed");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    paramArrayList = com.tencent.mm.plugin.finder.live.utils.a.a(paramArrayList, paramcc, paramInt1, paramInt2);
    AppMethodBeat.o(330030);
    return paramArrayList;
  }
  
  public final ak a(Context paramContext, RecyclerView paramRecyclerView, ArrayList<com.tencent.mm.plugin.finder.model.cc> paramArrayList, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(329932);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramArrayList, "feedList");
    kotlin.g.b.s.u(paramWxRecyclerAdapter, "adapter");
    paramContext = (ak)new com.tencent.mm.plugin.finder.nearby.live.play.a(paramContext, paramRecyclerView, paramArrayList, paramWxRecyclerAdapter);
    AppMethodBeat.o(329932);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.c<bne> a(com.tencent.mm.bx.b paramb, int paramInt, float paramFloat1, float paramFloat2, u paramu)
  {
    AppMethodBeat.i(329885);
    kotlin.g.b.s.u(paramu, "callback");
    paramb = (com.tencent.mm.plugin.findersdk.b.c)new com.tencent.mm.plugin.finder.live.cgi.v(paramb, paramInt, paramFloat1, paramFloat2, paramu);
    AppMethodBeat.o(329885);
    return paramb;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.c<azf> a(String paramString, com.tencent.mm.plugin.findersdk.a.t paramt)
  {
    AppMethodBeat.i(329882);
    kotlin.g.b.s.u(paramString, "username");
    paramString = (com.tencent.mm.plugin.findersdk.b.c)new ac(paramString, paramt);
    AppMethodBeat.o(329882);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.c<avy> a(String paramString, bkk parambkk, bui parambui)
  {
    AppMethodBeat.i(329867);
    kotlin.g.b.s.u(paramString, "userName");
    kotlin.g.b.s.u(parambkk, "noticeInfo");
    paramString = (com.tencent.mm.plugin.findersdk.b.c)new com.tencent.mm.plugin.finder.cgi.j(paramString, parambkk, parambui);
    AppMethodBeat.o(329867);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.c<att> a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(329873);
    kotlin.g.b.s.u(paramString1, "userName");
    kotlin.g.b.s.u(paramString2, "noticeId");
    paramString1 = (com.tencent.mm.plugin.findersdk.b.c)new com.tencent.mm.plugin.finder.live.cgi.a(paramString1, paramString2, paramInt1, Integer.valueOf(paramInt2));
    AppMethodBeat.o(329873);
    return paramString1;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.c<Object> a(String paramString1, String paramString2, com.tencent.mm.plugin.findersdk.a.s params)
  {
    AppMethodBeat.i(329879);
    kotlin.g.b.s.u(paramString1, "toUserName");
    kotlin.g.b.s.u(paramString2, "msgContent");
    paramString1 = ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).a(paramString1, paramString2, params);
    AppMethodBeat.o(329879);
    return paramString1;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.c<aub> a(List<? extends brr> paramList, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(329857);
    kotlin.g.b.s.u(paramList, "units");
    kotlin.g.b.s.u(paramString1, "finderUserName");
    kotlin.g.b.s.u(paramString2, "uxInfo");
    paramList = (com.tencent.mm.plugin.findersdk.b.c)new com.tencent.mm.plugin.finder.cgi.g(paramList, paramInt1, 0, paramInt2, paramString1, paramString2);
    AppMethodBeat.o(329857);
    return paramList;
  }
  
  public final LinkedList<com.tencent.mm.plugin.finder.model.cc> a(BaseFeedLoader<com.tencent.mm.plugin.finder.model.cc> paramBaseFeedLoader, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(329918);
    com.tencent.mm.plugin.finder.feed.model.k.a locala = com.tencent.mm.plugin.finder.feed.model.k.Bho;
    paramBaseFeedLoader = com.tencent.mm.plugin.finder.feed.model.k.a.a(paramBaseFeedLoader, paramInt1, paramInt2);
    AppMethodBeat.o(329918);
    return paramBaseFeedLoader;
  }
  
  public final List<com.tencent.mm.plugin.appbrand.api.g> a(boh paramboh)
  {
    AppMethodBeat.i(330072);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    paramboh = com.tencent.mm.plugin.finder.live.utils.a.a(paramboh);
    AppMethodBeat.o(330072);
    return paramboh;
  }
  
  public final void a(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(329965);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFinderLiveBundle, "config");
    kotlin.g.b.s.u(paramString1, "contextId");
    kotlin.g.b.s.u(paramString2, "clickTabContextId");
    com.tencent.mm.plugin.finder.live.model.v localv = com.tencent.mm.plugin.finder.live.model.v.CGh;
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFinderLiveBundle, "config");
    kotlin.g.b.s.u(paramString1, "contextId");
    kotlin.g.b.s.u(paramString2, "clickTabContextId");
    com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.festival.a.a.class);
    Object localObject = com.tencent.mm.plugin.finder.replay.k.Fky;
    com.tencent.mm.plugin.finder.replay.k.a.eLG();
    ah.f localf = new ah.f();
    localf.aqH = paramString1;
    paramString1 = (CharSequence)localf.aqH;
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        paramString1 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).el(paramContext);
        if (paramString1 != null) {
          break label420;
        }
        paramString1 = "";
        label152:
        localf.aqH = paramString1;
        Log.i("Finder.LiveJumpChecker", kotlin.g.b.s.X("goAnchorUIWithCheck locContextId:", localf.aqH));
      }
      localObject = new ah.f();
      paramString1 = paramContext.getResources().getString(p.h.app_i_know);
      kotlin.g.b.s.s(paramString1, "context.resources.getString(R.string.app_i_know)");
      ((ah.f)localObject).aqH = paramString1;
      paramString1 = (com.tencent.mm.plugin.finder.live.model.v)localv;
      if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(paramContext)) {
        break label443;
      }
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString1 = paramString1.bb((kotlin.g.a.a)new v.g(paramContext, (ah.f)localObject));
        if (paramString1 != null)
        {
          paramString1 = paramString1.be((kotlin.g.a.a)new v.h(paramContext));
          if (paramString1 != null)
          {
            paramString1 = paramString1.bc((kotlin.g.a.a)new v.i(paramContext));
            if (paramString1 != null)
            {
              paramString1 = paramString1.b(true, (kotlin.g.a.b)new v.j(paramFinderLiveBundle, paramContext, localf, paramIntent));
              if (paramString1 != null)
              {
                paramString1 = paramString1.a(paramContext, (kotlin.g.a.a)new v.k(paramContext));
                if (paramString1 != null)
                {
                  paramString1 = paramString1.bd((kotlin.g.a.a)new v.l(paramContext));
                  if ((paramString1 != null) && (paramString1.c(true, (kotlin.g.a.a)new v.m(paramContext)) != null))
                  {
                    ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUl();
                    com.tencent.mm.plugin.finder.live.model.v.b(paramContext, paramFinderLiveBundle, (String)localf.aqH, paramString2, paramIntent);
                  }
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(329965);
      return;
      i = 0;
      break;
      label420:
      localObject = paramString1.fov();
      paramString1 = (String)localObject;
      if (localObject != null) {
        break label152;
      }
      paramString1 = "";
      break label152;
      label443:
      paramString1 = null;
    }
  }
  
  public final void a(EditText paramEditText, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(330113);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a(paramEditText, null, 80, 40, true, parama);
    AppMethodBeat.o(330113);
  }
  
  public final void a(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(329997);
    kotlin.g.b.s.u(paramImageView, "imageView");
    kotlin.g.b.s.u(paramString, "url");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a(paramImageView, paramString);
    AppMethodBeat.o(329997);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(330092);
    kotlin.g.b.s.u(paramg, "bundle");
    l.Bxv.b(null, paramg);
    AppMethodBeat.o(330092);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.report.g paramg)
  {
    AppMethodBeat.i(330042);
    kotlin.g.b.s.u(paramg, "liveFeed");
    new com.tencent.mm.plugin.finder.live.report.a().b(paramg);
    AppMethodBeat.o(330042);
  }
  
  public final void a(bkk parambkk)
  {
    AppMethodBeat.i(329905);
    com.tencent.mm.plugin.finder.feed.model.j localj = com.tencent.mm.plugin.finder.feed.model.j.BfL;
    com.tencent.mm.plugin.finder.feed.model.j.a(parambkk);
    AppMethodBeat.o(329905);
  }
  
  public final void a(String paramString, bkk parambkk)
  {
    AppMethodBeat.i(329896);
    kotlin.g.b.s.u(paramString, "userName");
    kotlin.g.b.s.u(parambkk, "liveNoticeInfo");
    com.tencent.mm.plugin.finder.feed.model.j localj = com.tencent.mm.plugin.finder.feed.model.j.BfL;
    com.tencent.mm.plugin.finder.feed.model.j.b(paramString, parambkk);
    AppMethodBeat.o(329896);
  }
  
  public final boolean a(int paramInt1, int paramInt2, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(329942);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    o localo = o.CFQ;
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    if (!o.j(paramBaseFinderFeed))
    {
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = null;
        paramBaseFinderFeed = (CharSequence)paramBaseFinderFeed;
        if ((paramBaseFinderFeed != null) && (paramBaseFinderFeed.length() != 0)) {
          break label108;
        }
      }
      label108:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || ((paramInt1 != 1) && (paramInt1 != 3) && (paramInt1 != 4) && (paramInt2 != 1))) {
          break label114;
        }
        AppMethodBeat.o(329942);
        return true;
        paramBaseFinderFeed = paramBaseFinderFeed.mIE;
        break;
      }
    }
    label114:
    AppMethodBeat.o(329942);
    return false;
  }
  
  public final void aA(com.tencent.mm.storage.cc paramcc)
  {
    AppMethodBeat.i(330108);
    kotlin.g.b.s.u(paramcc, "newMsgInfo");
    f localf = f.Bwh;
    f.aA(paramcc);
    AppMethodBeat.o(330108);
  }
  
  public final LiveConfig b(FinderObject paramFinderObject, int paramInt)
  {
    AppMethodBeat.i(330002);
    kotlin.g.b.s.u(paramFinderObject, "obj");
    aw localaw = aw.Gjk;
    paramFinderObject = aw.a(paramFinderObject, paramInt, false);
    AppMethodBeat.o(330002);
    return paramFinderObject;
  }
  
  public final com.tencent.mm.plugin.findersdk.b.c<aub> b(List<r<Long, String>> paramList, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(329862);
    kotlin.g.b.s.u(paramList, "objectIds");
    kotlin.g.b.s.u(paramString1, "finderUserName");
    kotlin.g.b.s.u(paramString2, "uxInfo");
    paramList = (com.tencent.mm.plugin.findersdk.b.c)new com.tencent.mm.plugin.finder.cgi.g(paramList, paramInt1, paramInt2, paramString1, paramString2);
    AppMethodBeat.o(329862);
    return paramList;
  }
  
  public final void b(FinderObject paramFinderObject, bui parambui)
  {
    AppMethodBeat.i(329947);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    o localo = o.CFQ;
    o.b(paramFinderObject, parambui);
    AppMethodBeat.o(329947);
  }
  
  public final boolean bUb()
  {
    AppMethodBeat.i(330015);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool = com.tencent.mm.plugin.finder.live.utils.a.bUb();
    AppMethodBeat.o(330015);
    return bool;
  }
  
  public final boolean bUo()
  {
    AppMethodBeat.i(329914);
    com.tencent.mm.plugin.finder.feed.model.j localj = com.tencent.mm.plugin.finder.feed.model.j.BfL;
    boolean bool = com.tencent.mm.plugin.finder.feed.model.j.bUo();
    AppMethodBeat.o(329914);
    return bool;
  }
  
  public final void bUp()
  {
    AppMethodBeat.i(329951);
    o localo = o.CFQ;
    o.bUp();
    AppMethodBeat.o(329951);
  }
  
  public final int bUq()
  {
    AppMethodBeat.i(329978);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    int i = com.tencent.mm.plugin.finder.live.utils.a.bUq();
    AppMethodBeat.o(329978);
    return i;
  }
  
  public final void bUr()
  {
    AppMethodBeat.i(329984);
    aj localaj = aj.CGT;
    aj.qE(true);
    AppMethodBeat.o(329984);
  }
  
  public final void bUs()
  {
    AppMethodBeat.i(330011);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.ad(true, true);
    AppMethodBeat.o(330011);
  }
  
  public final Class<? extends com.tencent.mm.plugin.finder.video.t> bUt()
  {
    return FinderLivePlayView.class;
  }
  
  public final long bUu()
  {
    AppMethodBeat.i(330063);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    long l = com.tencent.mm.plugin.finder.live.utils.a.bUu();
    AppMethodBeat.o(330063);
    return l;
  }
  
  public final boolean bUv()
  {
    AppMethodBeat.i(330075);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool = com.tencent.mm.plugin.finder.live.utils.a.bUv();
    AppMethodBeat.o(330075);
    return bool;
  }
  
  public final int bUw()
  {
    AppMethodBeat.i(330099);
    com.tencent.mm.plugin.finder.live.k localk = com.tencent.mm.plugin.finder.live.k.Bxu;
    int i = com.tencent.mm.plugin.finder.live.k.bUw();
    AppMethodBeat.o(330099);
    return i;
  }
  
  public final boolean bUx()
  {
    AppMethodBeat.i(330125);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool = com.tencent.mm.plugin.finder.live.utils.a.bUx();
    AppMethodBeat.o(330125);
    return bool;
  }
  
  public final String chX()
  {
    AppMethodBeat.i(370033);
    Object localObject = com.tencent.mm.plugin.finder.feed.model.j.BfL;
    localObject = com.tencent.mm.plugin.finder.feed.model.j.chX();
    AppMethodBeat.o(370033);
    return localObject;
  }
  
  public final com.tencent.mm.loader.f.c co(String paramString1, String paramString2)
  {
    AppMethodBeat.i(330120);
    kotlin.g.b.s.u(paramString1, "path");
    kotlin.g.b.s.u(paramString2, "userName");
    paramString1 = (com.tencent.mm.loader.f.c)new m(paramString1, paramString2);
    AppMethodBeat.o(330120);
    return paramString1;
  }
  
  public final ArrayList<List<String>> eZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(330056);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject = com.tencent.mm.plugin.finder.live.utils.a.z(paramInt1, paramInt2, true);
    AppMethodBeat.o(330056);
    return localObject;
  }
  
  public final an en(Context paramContext)
  {
    AppMethodBeat.i(330019);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = (an)new FinderLiveConfettiView(paramContext);
    AppMethodBeat.o(330019);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.finder.video.t eo(Context paramContext)
  {
    AppMethodBeat.i(330037);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = (com.tencent.mm.plugin.finder.video.t)new FinderLivePlayView(paramContext);
    AppMethodBeat.o(330037);
    return paramContext;
  }
  
  public final ao i(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(329937);
    paramViewGroup = (ao)new aa(0, paramViewGroup);
    AppMethodBeat.o(329937);
    return paramViewGroup;
  }
  
  public final void jo(long paramLong)
  {
    AppMethodBeat.i(329928);
    com.tencent.mm.plugin.finder.feed.model.k.a locala = com.tencent.mm.plugin.finder.feed.model.k.Bho;
    com.tencent.mm.plugin.finder.feed.model.k.nG(paramLong);
    AppMethodBeat.o(329928);
  }
  
  public final String jp(long paramLong)
  {
    AppMethodBeat.i(330006);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject = com.tencent.mm.plugin.finder.live.utils.a.jp(paramLong);
    AppMethodBeat.o(330006);
    return localObject;
  }
  
  public final boolean jq(long paramLong)
  {
    AppMethodBeat.i(330049);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool = com.tencent.mm.plugin.finder.live.utils.a.jq(paramLong);
    AppMethodBeat.o(330049);
    return bool;
  }
  
  public final void jr(long paramLong)
  {
    AppMethodBeat.i(330080);
    d.a locala = d.BvP;
    d.nG(paramLong);
    AppMethodBeat.o(330080);
  }
  
  public final void js(long paramLong)
  {
    AppMethodBeat.i(330087);
    d.a locala = d.BvP;
    d.nT(paramLong);
    AppMethodBeat.o(330087);
  }
  
  public final void t(LinkedList<bkk> paramLinkedList)
  {
    AppMethodBeat.i(329901);
    com.tencent.mm.plugin.finder.feed.model.j localj = com.tencent.mm.plugin.finder.feed.model.j.BfL;
    com.tencent.mm.plugin.finder.feed.model.j.t(paramLinkedList);
    AppMethodBeat.o(329901);
  }
  
  public final void u(LinkedList<bcz> paramLinkedList)
  {
    AppMethodBeat.i(329992);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.u(paramLinkedList);
    AppMethodBeat.o(329992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.b
 * JD-Core Version:    0.7.0.1
 */