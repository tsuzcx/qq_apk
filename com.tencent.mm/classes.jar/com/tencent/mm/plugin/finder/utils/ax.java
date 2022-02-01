package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.d.a.a.a.b.b;
import com.tencent.d.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.k.i;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.view.o;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.plugin.findersdk.a.an;
import com.tencent.mm.plugin.findersdk.a.bs;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.g;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderUtilApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi;", "()V", "TAG", "", "feedEnterCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedEnterCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "preLoadReportId", "enterActivityProfileUI", "", "context", "Landroid/content/Context;", "encryptedTopicId", "eventName", "extra", "entryScene", "", "extraInfo", "identity", "enterFeedForWxPay", "exportId", "nonceId", "getRelatedList", "", "enterCommentScene", "enterFriendLikeTimelineUI", "targetUsername", "targetNickname", "commentScene", "enterProfileForWxPay", "finderUserName", "getFinderHomeClassName", "getFinderHomeSimpleClassName", "getFinderLiveConfettView", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveConfettView;", "getFinderSnsHeader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader;", "Landroid/app/Activity;", "getLiveNoticeStateWithAnchorUserName", "username", "noticeId", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "getLiveRoomMsg", "feedExportId", "feedNonceId", "liveId", "Ljava/lang/Void;", "reportExtraInfo", "verifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLivePermissionVerifyInfo;", "feedId", "", "", "getLiveRoomMsgInAdvance", "getLiveStatusWithUserName", "getLongVideoMaxDuration", "getLongVideoMaxRatio", "", "getLongVideoMinRatio", "getMiaojianCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMiaoJianVideoMetaResp;", "md5", "getTopFinderActivity", "getWxProfileInfo", "wxUsername", "openimUsername", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "isEnableFinderLiveEntry", "isEnableNearbyLiveFriends", "isEnableNearbyLivePullSimilar", "isEnableSetProfileCover", "isEnableTeenModeCheckInShareScene", "isLiveFeedNeedRefresh", "jumpLiveUIAndDoAction", "action", "contextId", "jumpLiveUIByFeedId", "intent", "Landroid/content/Intent;", "loadCoverIntoImageView", "imageView", "Landroid/widget/ImageView;", "finderObj", "loadGalleryFeed", "cgiParams", "Lcom/tencent/mm/protocal/protobuf/FinderGalleryCgiParams;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$GalleryCgiCallback;", "openChannelsRewardedVideoAd", "extInfo", "Lorg/json/JSONObject;", "refreshShareCardBottomMask", "mask", "Landroid/view/ViewGroup;", "maskBgOnEmpty", "maskBg", "report21875", "eid", "eventCode", "udfKv", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reserveLiveNoticeWithAnchorUsername", "reserveOperation", "resetRequestTime", "setBlurBitmap", "url", "radius", "showLiveRoomWithUserName", "tryGetFinderObject", "objectId", "objectNonceId", "tryGetFinderObjectFromCache", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  implements ca
{
  private final long Gjn;
  private final ConcurrentHashMap<Long, r<Long, FinderObject>> Gjo;
  private final String TAG;
  
  public ax()
  {
    AppMethodBeat.i(333069);
    this.TAG = "Finder.FinderUtilApi";
    this.Gjn = 1837L;
    this.Gjo = new ConcurrentHashMap();
    AppMethodBeat.o(333069);
  }
  
  private static final ah a(ax paramax, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3, b.a parama)
  {
    AppMethodBeat.i(333169);
    s.u(paramax, "this$0");
    s.u(paramString3, "$reportExtraInfo");
    FinderObject localFinderObject = ((ayl)parama.ott).feedObject;
    if ((parama.errType == 0) && (parama.errCode == 0) && (localFinderObject != null))
    {
      parama = paramax.TAG;
      paramax = new StringBuilder("jumpLiveUIAndDoAction liveId: ");
      Object localObject = localFinderObject.liveInfo;
      long l;
      label115:
      Intent localIntent;
      com.tencent.d.a.a.a.b localb;
      Context localContext;
      label218:
      label244:
      String str;
      if (localObject == null)
      {
        l = paramLong;
        localObject = paramax.append(l).append(", username:");
        paramax = localFinderObject.username;
        if (paramax != null) {
          break label399;
        }
        paramax = paramString1;
        if (paramString1 == null) {
          paramax = "";
        }
        Log.i(parama, paramax);
        paramax = e.FMN;
        l = localFinderObject.id;
        paramax = FinderItem.Companion;
        e.a.b(l, FinderItem.a.e(localFinderObject, 0));
        localIntent = new Intent();
        localIntent.putExtra("KEY_PARAMS_DO_ACTION", paramInt);
        paramax = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
        s.s(paramax, "plugin(IPluginFinderLive::class.java)");
        localb = (com.tencent.d.a.a.a.b)paramax;
        localContext = MMApplicationContext.getContext();
        l = localFinderObject.id;
        paramax = localFinderObject.liveInfo;
        if (paramax != null) {
          break label402;
        }
        paramax = localFinderObject.objectNonceId;
        parama = paramax;
        if (paramax == null) {
          parama = "";
        }
        if (paramString2 != null) {
          break label410;
        }
        localObject = "";
        str = localFinderObject.sessionBuffer;
        paramax = localFinderObject.liveInfo;
        if (paramax != null) {
          break label417;
        }
        paramax = "";
        label264:
        paramString1 = localFinderObject.liveInfo;
        if (paramString1 != null) {
          break label434;
        }
        paramString1 = null;
        label276:
        if (paramString1 != null) {
          break label459;
        }
        paramString1 = e.b.mKf;
      }
      label399:
      label402:
      label410:
      label417:
      label434:
      label459:
      for (paramInt = e.b.bcu();; paramInt = paramString1.intValue())
      {
        b.b.a(localb, localIntent, localContext, l, Long.valueOf(paramLong), "", parama, "", (String)localObject, str, "", paramax, paramInt);
        if (!Util.isNullOrNil(paramString3))
        {
          paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
          paramax = paramString2;
          if (paramString2 == null) {
            paramax = "";
          }
          paramString1.b(21140, new Object[] { paramax, paramString3, Long.valueOf(localFinderObject.id), "" });
        }
        paramax = ah.aiuX;
        AppMethodBeat.o(333169);
        return paramax;
        l = ((bip)localObject).liveId;
        break;
        break label115;
        paramLong = paramax.liveId;
        break label218;
        localObject = paramString2;
        break label244;
        paramString1 = paramax.mIE;
        paramax = paramString1;
        if (paramString1 != null) {
          break label264;
        }
        paramax = "";
        break label264;
        paramString1 = paramString1.ZRQ;
        if (paramString1 == null)
        {
          paramString1 = null;
          break label276;
        }
        paramString1 = Integer.valueOf(paramString1.mNn);
        break label276;
      }
    }
    paramax = paramax.TAG;
    paramString1 = new StringBuilder("jumpLiveUIAndDoAction failed. ").append(parama.errType).append(", ").append(parama.errCode).append(", ");
    if (localFinderObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.w(paramax, bool);
      paramax = MMApplicationContext.getContext().getResources().getString(e.h.finder_live_permission_title);
      s.s(paramax, "getContext().resources.g…er_live_permission_title)");
      if (parama.errCode == -4036)
      {
        paramax = MMApplicationContext.getContext().getResources().getString(e.h.finder_private_feed_can_not_see_live);
        s.s(paramax, "getContext().resources.g…te_feed_can_not_see_live)");
      }
      aa.makeText(MMApplicationContext.getContext(), (CharSequence)paramax, 0).show();
      break;
    }
  }
  
  private static final ah a(ax paramax, long paramLong, String paramString1, Intent paramIntent, String paramString2, boolean paramBoolean, String paramString3, ca.a parama1, ca.a parama2, b.a parama)
  {
    AppMethodBeat.i(333151);
    s.u(paramax, "this$0");
    s.u(paramString2, "$reportExtraInfo");
    s.u(paramString3, "$contextId");
    FinderObject localFinderObject = ((ayl)parama.ott).feedObject;
    if ((parama.errType == 0) && (parama.errCode == 0) && (localFinderObject != null))
    {
      parama = paramax.TAG;
      paramax = new StringBuilder("jumpLiveUI liveId: ");
      parama2 = localFinderObject.liveInfo;
      if (parama2 == null)
      {
        l = paramLong;
        localObject = paramax.append(l).append(", username:");
        parama2 = localFinderObject.username;
        paramax = parama2;
        if (parama2 == null)
        {
          if (paramString1 != null) {
            break label463;
          }
          paramax = "";
        }
        label128:
        Log.i(parama, paramax);
        if (paramIntent != null) {
          break label468;
        }
        parama2 = new Intent();
        label156:
        parama2.putExtra("key_extra_info", paramString2);
        paramax = localFinderObject.liveInfo;
        if (paramax != null) {
          break label475;
        }
        paramax = null;
        label179:
        parama2.putExtra("KEY_ENTER_LIVE_PARAM_VR_LIVE_TYPE", (Serializable)paramax);
        paramax = localFinderObject.liveInfo;
        if (paramax != null)
        {
          paramax = paramax.ZSn;
          if (paramax != null) {
            parama2.putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO", paramax.toByteArray());
          }
        }
        if (paramBoolean) {
          parama2.putExtra("key_enter_live_param_pull_more_type", 1);
        }
        if (((CharSequence)paramString2).length() <= 0) {
          break label486;
        }
        i = 1;
        label255:
        if (i == 0) {
          break label492;
        }
        paramIntent = paramString2;
        label264:
        if (paramIntent != null)
        {
          parama = localFinderObject.username;
          paramax = parama;
          if (parama == null)
          {
            if (paramString1 != null) {
              break label498;
            }
            paramax = "";
          }
          label291:
          parama = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.hm(paramIntent, paramax);
        }
        if (!Util.isEqual(z.bAW(), localFinderObject.username)) {
          break label511;
        }
        paramIntent = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
        parama = MMApplicationContext.getContext();
        l = localFinderObject.id;
        paramax = localFinderObject.liveInfo;
        if (paramax != null) {
          break label503;
        }
      }
      for (;;)
      {
        paramString1 = localFinderObject.objectNonceId;
        paramax = paramString1;
        if (paramString1 == null) {
          paramax = "";
        }
        paramIntent.enterFinderLiveAnchorUI(parama2, parama, l, Long.valueOf(paramLong), paramax, "", paramString3, localFinderObject.sessionBuffer, "");
        if (!Util.isNullOrNil(paramString2)) {
          com.tencent.mm.plugin.report.service.h.OAn.b(21140, new Object[] { paramString3, paramString2, Long.valueOf(localFinderObject.id), "" });
        }
        if (parama1 != null) {
          break label748;
        }
        AppMethodBeat.o(333151);
        return null;
        l = parama2.liveId;
        break;
        label463:
        paramax = paramString1;
        break label128;
        label468:
        parama2 = paramIntent;
        break label156;
        label475:
        paramax = Integer.valueOf(paramax.ZSl);
        break label179;
        label486:
        i = 0;
        break label255;
        label492:
        paramIntent = null;
        break label264;
        label498:
        paramax = paramString1;
        break label291;
        label503:
        paramLong = paramax.liveId;
      }
      label511:
      paramax = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
      s.s(paramax, "plugin(IPluginFinderLive::class.java)");
      Object localObject = (com.tencent.d.a.a.a.b)paramax;
      Context localContext = MMApplicationContext.getContext();
      long l = localFinderObject.id;
      paramax = localFinderObject.liveInfo;
      label553:
      label575:
      String str;
      if (paramax == null)
      {
        paramIntent = localFinderObject.username;
        paramax = paramIntent;
        if (paramIntent == null)
        {
          if (paramString1 != null) {
            break label682;
          }
          paramax = "";
        }
        paramString1 = localFinderObject.objectNonceId;
        parama = paramString1;
        if (paramString1 == null) {
          parama = "";
        }
        str = localFinderObject.sessionBuffer;
        paramString1 = localFinderObject.liveInfo;
        if (paramString1 != null) {
          break label687;
        }
        paramString1 = "";
        label612:
        paramIntent = localFinderObject.liveInfo;
        if (paramIntent != null) {
          break label707;
        }
        paramIntent = null;
        label627:
        if (paramIntent != null) {
          break label738;
        }
        paramIntent = e.b.mKf;
      }
      label682:
      label687:
      label707:
      label738:
      for (int i = e.b.bcu();; i = paramIntent.intValue())
      {
        b.b.a((com.tencent.d.a.a.a.b)localObject, parama2, localContext, l, Long.valueOf(paramLong), paramax, parama, "", paramString3, str, "", paramString1, i);
        break;
        paramLong = paramax.liveId;
        break label553;
        paramax = paramString1;
        break label575;
        paramIntent = paramString1.mIE;
        paramString1 = paramIntent;
        if (paramIntent != null) {
          break label612;
        }
        paramString1 = "";
        break label612;
        paramIntent = paramIntent.ZRQ;
        if (paramIntent == null)
        {
          paramIntent = null;
          break label627;
        }
        paramIntent = Integer.valueOf(paramIntent.mNn);
        break label627;
      }
      label748:
      parama1.onCallback(null);
      paramax = ah.aiuX;
      AppMethodBeat.o(333151);
      return paramax;
    }
    if (parama2 == null)
    {
      AppMethodBeat.o(333151);
      return null;
    }
    parama2.onCallback(Integer.valueOf(parama.errCode));
    paramax = ah.aiuX;
    AppMethodBeat.o(333151);
    return paramax;
  }
  
  private static final ah a(ax paramax, long paramLong, ah.a parama, String paramString1, String paramString2, ca.a parama1, ca.a parama2, b.a parama3)
  {
    AppMethodBeat.i(333134);
    s.u(paramax, "this$0");
    s.u(parama, "$isFromAd");
    s.u(paramString2, "$reportExtraInfo");
    FinderObject localFinderObject = ((ayl)parama3.ott).feedObject;
    if (localFinderObject == null)
    {
      AppMethodBeat.o(333134);
      return null;
    }
    ((Map)paramax.Gjo).put(Long.valueOf(paramLong), new r(Long.valueOf(System.currentTimeMillis()), localFinderObject));
    if ((parama3.errType == 0) && (parama3.errCode == 0))
    {
      if (parama.aiwY) {
        com.tencent.mm.plugin.report.service.h.OAn.p(paramax.Gjn, 2L, 1L);
      }
      parama2 = paramax.TAG;
      paramax = new StringBuilder("jumpLiveUI liveId: ");
      parama = localFinderObject.liveInfo;
      label180:
      int i;
      if (parama == null)
      {
        parama3 = paramax.append(paramLong).append(", username:");
        parama = localFinderObject.username;
        paramax = parama;
        if (parama == null)
        {
          if (paramString1 != null) {
            break label272;
          }
          paramax = "";
        }
        Log.i(parama2, paramax);
        if (((CharSequence)paramString2).length() <= 0) {
          break label278;
        }
        i = 1;
        label210:
        if (i == 0) {
          break label284;
        }
        label215:
        if (paramString2 != null)
        {
          paramax = localFinderObject.username;
          if (paramax != null) {
            break label290;
          }
          paramax = paramString1;
          if (paramString1 == null) {
            paramax = "";
          }
        }
      }
      label272:
      label278:
      label284:
      label290:
      for (;;)
      {
        parama = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.hm(paramString2, paramax);
        if (parama1 != null) {
          break label293;
        }
        AppMethodBeat.o(333134);
        return null;
        paramLong = parama.liveId;
        break;
        paramax = paramString1;
        break label180;
        i = 0;
        break label210;
        paramString2 = null;
        break label215;
      }
      label293:
      parama1.onCallback(null);
      paramax = ah.aiuX;
      AppMethodBeat.o(333134);
      return paramax;
    }
    if (parama2 == null)
    {
      AppMethodBeat.o(333134);
      return null;
    }
    parama2.onCallback(Integer.valueOf(parama3.errCode));
    paramax = ah.aiuX;
    AppMethodBeat.o(333134);
    return paramax;
  }
  
  private static final ah a(ca.a parama1, ca.a parama2, b.a parama)
  {
    AppMethodBeat.i(333123);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      if (parama1 == null)
      {
        AppMethodBeat.o(333123);
        return null;
      }
      parama1.onCallback(null);
      parama1 = ah.aiuX;
      AppMethodBeat.o(333123);
      return parama1;
    }
    if (parama2 == null)
    {
      AppMethodBeat.o(333123);
      return null;
    }
    parama2.onCallback(Integer.valueOf(parama.errCode));
    parama1 = ah.aiuX;
    AppMethodBeat.o(333123);
    return parama1;
  }
  
  private static final ah a(String paramString1, String paramString2, ca.a parama1, ca.a parama2, b.a parama)
  {
    AppMethodBeat.i(333116);
    bkk localbkk = ((atj)parama.ott).liveNoticeInfo;
    if ((parama.errType == 0) && (parama.errCode == 0) && (localbkk != null))
    {
      ((aj)com.tencent.mm.kernel.h.ax(aj.class)).a(paramString1, paramString2, localbkk);
      if (parama1 == null)
      {
        AppMethodBeat.o(333116);
        return null;
      }
      if (localbkk.status == 0) {}
      for (boolean bool = true;; bool = false)
      {
        parama1.onCallback(Boolean.valueOf(bool));
        paramString1 = ah.aiuX;
        AppMethodBeat.o(333116);
        return paramString1;
      }
    }
    if (parama2 == null)
    {
      AppMethodBeat.o(333116);
      return null;
    }
    parama2.onCallback(Integer.valueOf(parama.errCode));
    paramString1 = ah.aiuX;
    AppMethodBeat.o(333116);
    return paramString1;
  }
  
  private static final ah a(ah.a parama1, Object paramObject, long paramLong, ah.f paramf, ah.a parama2, b.a parama)
  {
    AppMethodBeat.i(333178);
    s.u(parama1, "$isInvalid");
    s.u(paramObject, "$lock");
    s.u(paramf, "$ret");
    s.u(parama2, "$isNotify");
    Object localObject;
    if ((parama.errType != 0) || (parama.errCode != 0))
    {
      localObject = aw.Gjk;
      if (!aw.iv(parama.errType, parama.errCode)) {}
    }
    else
    {
      parama1 = ((ayl)parama.ott).feedObject;
      if (parama1 != null)
      {
        parama = FinderItem.Companion;
        parama = FinderItem.a.e(parama1, 1);
        localObject = e.FMN;
        e.a.s(parama);
        paramf.aqH = parama1;
      }
    }
    for (;;)
    {
      try
      {
        parama2.aiwY = true;
        paramObject.notify();
        parama1 = ah.aiuX;
        Log.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", finish");
        return parama1;
      }
      finally
      {
        AppMethodBeat.o(333178);
      }
      if ((parama.errCode == -4011) || (parama.errCode == -4033) || (parama.errCode == -4036)) {
        parama1.aiwY = true;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, ca.a<Integer> parama, String paramString3, long paramLong1, ca.a<Void> parama1, String paramString4, String paramString5, bkr parambkr, long paramLong2, Intent paramIntent, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(333094);
    s.u(paramString4, "contextId");
    s.u(paramString5, "reportExtraInfo");
    if ((paramString2 == null) && (paramLong2 == 0L))
    {
      if (parama != null) {
        parama.onCallback(Integer.valueOf(-1000));
      }
      AppMethodBeat.o(333094);
      return;
    }
    if ((paramMap != null) && (paramMap.containsKey("is_from_ad") == true))
    {
      i = 1;
      if ((i == 0) || (!s.p(paramMap.get("is_from_ad"), Boolean.TRUE))) {
        break label801;
      }
    }
    label128:
    label136:
    label265:
    label275:
    label278:
    label539:
    label801:
    for (int i = 1;; i = 0)
    {
      label113:
      boolean bool;
      if (paramMap == null)
      {
        paramMap = null;
        if (!(paramMap instanceof Boolean)) {
          break label259;
        }
        paramMap = (Boolean)paramMap;
        if (paramMap != null) {
          break label265;
        }
        bool = false;
        if (i != 0) {
          com.tencent.mm.plugin.report.service.h.OAn.p(this.Gjn, 3L, 1L);
        }
        if (!qO(paramLong1)) {
          break label278;
        }
        if (paramString2 != null) {
          break label275;
        }
        paramString2 = "";
      }
      for (;;)
      {
        new az(paramLong2, paramString3, 65, 2, "", true, null, null, 0L, null, false, false, paramString2, null, 0, parambkr, 20416).bFJ().g(new ax..ExternalSyntheticLambda1(this, paramLong1, paramString1, paramIntent, paramString5, bool, paramString4, parama1, parama));
        AppMethodBeat.o(333094);
        return;
        i = 0;
        break;
        paramMap = paramMap.get("key_finder_show_recommend");
        break label113;
        paramMap = null;
        break label128;
        bool = paramMap.booleanValue();
        break label136;
      }
      if (i != 0) {
        com.tencent.mm.plugin.report.service.h.OAn.p(this.Gjn, 4L, 1L);
      }
      paramString2 = (r)this.Gjo.get(Long.valueOf(paramLong1));
      if (paramString2 == null)
      {
        parama = null;
        if (paramIntent != null) {
          break label532;
        }
        paramString3 = new Intent();
        label333:
        paramString3.putExtra("key_extra_info", paramString5);
        if (parama != null) {
          break label539;
        }
        paramString2 = null;
        label350:
        paramString3.putExtra("KEY_ENTER_LIVE_PARAM_VR_LIVE_TYPE", (Serializable)paramString2);
        if (parama != null)
        {
          paramString2 = parama.liveInfo;
          if (paramString2 != null)
          {
            paramString2 = paramString2.ZSn;
            if (paramString2 != null) {
              paramString3.putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO", paramString2.toByteArray());
            }
          }
        }
        if (bool) {
          paramString3.putExtra("key_enter_live_param_pull_more_type", 1);
        }
        if (parama != null)
        {
          if (!Util.isEqual(z.bAW(), parama.username)) {
            break label581;
          }
          parama1 = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
          paramString5 = MMApplicationContext.getContext();
          paramLong2 = parama.id;
          paramString1 = parama.liveInfo;
          if (paramString1 != null) {
            break label564;
          }
          label461:
          paramString2 = parama.objectNonceId;
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = "";
          }
          if (parama != null) {
            break label573;
          }
        }
      }
      label564:
      label573:
      for (paramString2 = null;; paramString2 = parama.sessionBuffer)
      {
        parama1.enterFinderLiveAnchorUI(paramString3, paramString5, paramLong2, Long.valueOf(paramLong1), paramString1, "", paramString4, paramString2, "");
        this.Gjo.clear();
        AppMethodBeat.o(333094);
        return;
        parama = (FinderObject)paramString2.bsD;
        break;
        paramString3 = paramIntent;
        break label333;
        paramString2 = parama.liveInfo;
        if (paramString2 == null)
        {
          paramString2 = null;
          break label350;
        }
        paramString2 = Integer.valueOf(paramString2.ZSl);
        break label350;
        paramLong1 = paramString1.liveId;
        break label461;
      }
      label581:
      paramString2 = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
      s.s(paramString2, "plugin(IPluginFinderLive::class.java)");
      parambkr = (com.tencent.d.a.a.a.b)paramString2;
      paramIntent = MMApplicationContext.getContext();
      paramLong2 = parama.id;
      paramString2 = parama.liveInfo;
      if (paramString2 == null)
      {
        label621:
        parama1 = parama.username;
        paramString2 = parama1;
        if (parama1 == null)
        {
          if (paramString1 != null) {
            break label742;
          }
          paramString2 = "";
        }
        paramString1 = parama.objectNonceId;
        parama1 = paramString1;
        if (paramString1 == null) {
          parama1 = "";
        }
        paramMap = parama.sessionBuffer;
        paramString1 = parama.liveInfo;
        if (paramString1 != null) {
          break label747;
        }
        paramString1 = "";
        label676:
        parama = parama.liveInfo;
        if (parama != null) {
          break label767;
        }
        parama = null;
        label687:
        if (parama != null) {
          break label792;
        }
        parama = e.b.mKf;
      }
      for (i = e.b.bcu();; i = parama.intValue())
      {
        b.b.a(parambkr, paramString3, paramIntent, paramLong2, Long.valueOf(paramLong1), paramString2, parama1, "", paramString4, paramMap, "", paramString1, i);
        break;
        paramLong1 = paramString2.liveId;
        break label621;
        label742:
        paramString2 = paramString1;
        break label642;
        label747:
        paramString5 = paramString1.mIE;
        paramString1 = paramString5;
        if (paramString5 != null) {
          break label676;
        }
        paramString1 = "";
        break label676;
        label767:
        parama = parama.ZRQ;
        if (parama == null)
        {
          parama = null;
          break label687;
        }
        parama = Integer.valueOf(parama.mNn);
        break label687;
      }
    }
  }
  
  private final boolean qO(long paramLong)
  {
    AppMethodBeat.i(333110);
    if (!this.Gjo.containsKey(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(333110);
      return true;
    }
    Object localObject = (r)this.Gjo.get(Long.valueOf(paramLong));
    if (localObject == null) {
      paramLong = 0L;
    }
    for (;;)
    {
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
      long l = com.tencent.d.a.a.a.a.a.jTz() * 1000;
      if (System.currentTimeMillis() - paramLong <= l) {
        break;
      }
      AppMethodBeat.o(333110);
      return true;
      localObject = (Long)((r)localObject).bsC;
      if (localObject == null) {
        paramLong = 0L;
      } else {
        paramLong = ((Long)localObject).longValue();
      }
    }
    AppMethodBeat.o(333110);
    return false;
  }
  
  public final void G(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(333408);
    s.u(paramContext, "context");
    if (Util.isNullOrNil(paramString1))
    {
      Log.i(this.TAG, "enterProfileForWxPay finderUserName empty");
      AppMethodBeat.o(333408);
      return;
    }
    Log.i(this.TAG, "enterProfileForWxPay finderUserName:" + paramString1 + ", enterCommentScene:16, extraInfo:" + paramString2);
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("key_extra_info", paramString1);
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(16, 2, 32, localIntent);
    a.GfO.enterFinderProfileUI(paramContext, localIntent);
    AppMethodBeat.o(333408);
  }
  
  public final r<Boolean, Object> J(long paramLong, String paramString)
  {
    AppMethodBeat.i(333438);
    Log.i("Finder.PluginFinder", "tryGetFinderObject " + paramLong + ", start");
    ah.f localf = new ah.f();
    ah.a locala1 = new ah.a();
    Object localObject = new Object();
    ah.a locala2 = new ah.a();
    new az(paramLong, paramString, 2, 2, "", true, null, null, 0L, null, false, false, null, null, 0, null, 57280).bFJ().h(new ax..ExternalSyntheticLambda5(locala1, localObject, paramLong, localf, locala2));
    try
    {
      if (!locala2.aiwY)
      {
        Log.i("Finder.PluginFinder", s.X("requestFinderObject wait ", Long.valueOf(paramLong)));
        localObject.wait(2000L);
        Log.i("Finder.PluginFinder", s.X("requestFinderObject notify ", Long.valueOf(paramLong)));
      }
      paramString = ah.aiuX;
      paramString = new r(Boolean.valueOf(locala1.aiwY), localf.aqH);
      AppMethodBeat.o(333438);
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(333438);
    }
  }
  
  public final Object a(String paramString1, String paramString2, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, ca.a<Object> parama, ca.a<Integer> parama1)
  {
    AppMethodBeat.i(333283);
    s.u(paramb, "lifeCycle");
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = ay.Gjp;
      paramString1 = ay.b(paramString2, paramb, parama, parama1);
      AppMethodBeat.o(333283);
      return paramString1;
    }
    paramString2 = ay.Gjp;
    paramString1 = ay.a(paramString1, paramb, parama, parama1);
    AppMethodBeat.o(333283);
    return paramString1;
  }
  
  public final void a(long paramLong, ca.a<Boolean> parama)
  {
    AppMethodBeat.i(333337);
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
    s.s(locala, "plugin(IPluginFinderLive::class.java)");
    b.b.a((com.tencent.d.a.a.a.b)locala, paramLong, false, (b.d)new a(parama), 6);
    AppMethodBeat.o(333337);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(333375);
    s.u(paramContext, "context");
    Intent localIntent = new Intent();
    String str;
    label49:
    label69:
    int i;
    if (paramString1 == null)
    {
      str = "";
      localIntent.putExtra("key_encrypted_topic_id", str);
      if (paramString2 != null) {
        break label233;
      }
      str = "";
      localIntent.putExtra("key_activity_name", str);
      if (paramString3 != null) {
        break label239;
      }
      str = "";
      localIntent.putExtra("key_extra_report_info", str);
      localIntent.putExtra("key_enter_scene", paramInt);
      c.GfS.f(localIntent, paramString4);
      Log.i(this.TAG, "enterActivityProfileUI :" + paramString1 + " eventName:" + paramString2 + " entryScene:" + paramInt);
      paramString1 = com.tencent.mm.plugin.finder.report.n.FpH;
      paramString1 = com.tencent.mm.plugin.finder.report.n.eMA();
      if (36 != paramInt) {
        break label252;
      }
      paramString2 = (CharSequence)paramString1;
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label246;
      }
      i = 1;
      label182:
      if (i != 0) {
        break label252;
      }
      localIntent.putExtra("key_context_id", paramString1);
    }
    for (;;)
    {
      localIntent.putExtra("key_activity_profile_src_type", "4");
      paramString1 = a.GfO;
      a.f(paramContext, localIntent, true);
      AppMethodBeat.o(333375);
      return;
      str = paramString1;
      break;
      label233:
      str = paramString2;
      break label49;
      label239:
      str = paramString3;
      break label69;
      label246:
      i = 0;
      break label182;
      label252:
      if (6 == paramInt)
      {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(6, 2, 59, localIntent);
      }
      else if (15 == paramInt)
      {
        localIntent.putExtra("key_extra_info", paramString3);
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(15, 2, 59, localIntent);
      }
      else
      {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 4, 59, localIntent);
      }
    }
  }
  
  public final void a(Context paramContext, JSONObject paramJSONObject, ca.a<Object> parama, ca.a<Integer> parama1)
  {
    AppMethodBeat.i(333433);
    s.u(paramContext, "context");
    s.u(paramJSONObject, "extInfo");
    String str1 = paramJSONObject.optString("feedId");
    Object localObject1 = paramJSONObject.optString("nonceId");
    int k = paramJSONObject.optInt("shareScene", 0);
    String str3 = paramJSONObject.optString("sessionId", "");
    String str2 = paramJSONObject.optString("reportExtraInfo", "");
    int i = paramJSONObject.optInt("entryScene", 0);
    int m = paramJSONObject.optInt("adJSAPIType", 0);
    Object localObject2 = paramJSONObject.optString("userName", "");
    com.tencent.mm.plugin.finder.ui.sharerel.d locald = com.tencent.mm.plugin.finder.ui.sharerel.d.FYu;
    com.tencent.mm.plugin.finder.ui.sharerel.d.a(parama);
    parama = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    int j = com.tencent.mm.plugin.findersdk.d.a.aDh("entrance");
    if (j != 0)
    {
      if (parama1 != null) {
        parama1.onCallback(Integer.valueOf(-1003));
      }
      Log.i(this.TAG, "[openChannelsRewardedVideoAd] spamAction:" + j + ' ');
      AppMethodBeat.o(333433);
      return;
    }
    parama = av.GiL;
    j = av.Uo(k);
    if (j != -1)
    {
      i = j;
      parama = av.GiL;
      if (!av.aBT(str2)) {
        break label301;
      }
    }
    label301:
    for (j = 4;; j = 2)
    {
      if (m != 1) {
        break label307;
      }
      paramJSONObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.hm(str2, (String)localObject2);
      paramJSONObject = new Intent();
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(i, j, 104, paramJSONObject);
      com.tencent.mm.plugin.sns.ad.d.n.a(paramJSONObject, paramContext, (String)localObject2, (String)localObject1, str1, str2);
      AppMethodBeat.o(333433);
      return;
      if (i != 0) {
        break;
      }
      i = 15;
      break;
    }
    label307:
    localObject2 = new bzg();
    ((bzg)localObject2).feedId = str1;
    ((bzg)localObject2).nonceId = ((String)localObject1);
    ((bzg)localObject2).zDJ = paramJSONObject.optString("finderUserName");
    ((bzg)localObject2).aaiu = paramJSONObject.optString("expReportLink");
    ((bzg)localObject2).aaiv = paramJSONObject.optString("clkReportLink");
    parama = paramJSONObject.optJSONObject("reportInfo");
    if (parama == null)
    {
      parama = null;
      parama1 = parama;
      if (parama == null) {
        parama1 = new JSONObject().toString();
      }
      ((bzg)localObject2).mxQ = parama1;
      parama = paramJSONObject.optJSONObject("clickPosMap");
      if (parama != null) {
        break label877;
      }
    }
    label877:
    for (parama = null;; parama = parama.toString())
    {
      parama1 = parama;
      if (parama == null) {
        parama1 = new JSONObject().toString();
      }
      ((bzg)localObject2).aaiw = parama1;
      ((bzg)localObject2).zSx = paramJSONObject.optString("feedbackUrl");
      Log.i(this.TAG, "adFlowInfo feedId:" + str1 + ", nonceId:" + ((bzg)localObject2).nonceId + ", finderUserName:" + ((bzg)localObject2).zDJ);
      Log.i(this.TAG, "adFlowInfo expReportLink:" + ((bzg)localObject2).aaiu + ", clkReportLink:" + ((bzg)localObject2).aaiv + ", reportInfo:" + ((bzg)localObject2).mxQ);
      Log.i(this.TAG, "adFlowInfo clickPosMap:" + ((bzg)localObject2).aaiw + ", feedbackUrl:" + ((bzg)localObject2).zSx);
      paramJSONObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.hm(str2, ((bzg)localObject2).zDJ);
      parama1 = new Intent();
      parama1.putExtra("KEY_MINI_APP_AD_FLOW_INFO", ((bzg)localObject2).toByteArray());
      parama1.putExtra("from_user", z.bAM());
      parama1.putExtra("feed_encrypted_object_id", str1);
      parama1.putExtra("feed_object_nonceId", (String)localObject1);
      parama1.putExtra("key_need_related_list", true);
      parama1.putExtra("key_comment_scene", 104);
      parama1.putExtra("key_reuqest_scene", 23);
      parama1.putExtra("key_session_id", str3);
      parama1.putExtra("key_extra_info", str2);
      parama1.putExtra("is_from_ad", true);
      parama = ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(i, j, 104, parama1);
      if (!Util.isNullOrNil(""))
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
        paramJSONObject = parama;
        if (parama == null) {
          paramJSONObject = "";
        }
        ((com.tencent.mm.plugin.report.service.h)localObject1).b(21140, new Object[] { paramJSONObject, "", str1, "" });
      }
      parama1.putExtra("report_scene", k);
      parama1.putExtra("tab_type", 9);
      paramJSONObject = a.GfO;
      a.Y(paramContext, parama1);
      paramContext = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
      com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999685);
      AppMethodBeat.o(333433);
      return;
      parama = parama.toString();
      break;
    }
  }
  
  public final void a(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(333302);
    Object localObject = av.GiL;
    localObject = aw.Gjk;
    if ((paramImageView != null) && (paramString != null)) {
      ((g)com.tencent.mm.kernel.h.ax(g.class)).a(paramImageView, paramString);
    }
    AppMethodBeat.o(333302);
  }
  
  public final void a(String paramString1, long paramLong, String paramString2, String paramString3, Map<String, Object> paramMap, ca.a<Void> parama, ca.a<Integer> parama1)
  {
    AppMethodBeat.i(333349);
    s.u("", "reportExtraInfo");
    if ((paramString2 == null) && (0L == 0L))
    {
      parama1.onCallback(Integer.valueOf(-1000));
      AppMethodBeat.o(333349);
      return;
    }
    ah.a locala = new ah.a();
    int i;
    if ((paramMap != null) && (paramMap.containsKey("is_from_ad") == true))
    {
      i = 1;
      if ((i != 0) && (s.p(paramMap.get("is_from_ad"), Boolean.TRUE))) {
        locala.aiwY = true;
      }
      if (!qO(paramLong)) {
        break label214;
      }
      if (locala.aiwY) {
        com.tencent.mm.plugin.report.service.h.OAn.p(this.Gjn, 1L, 1L);
      }
      if (paramString2 != null) {
        break label211;
      }
      paramString2 = "";
    }
    label211:
    for (;;)
    {
      new az(0L, paramString3, 65, 2, "", true, null, null, 0L, null, false, false, paramString2, null, 0, null, 20416).bFJ().g(new ax..ExternalSyntheticLambda2(this, paramLong, locala, paramString1, "", parama, parama1));
      AppMethodBeat.o(333349);
      return;
      i = 0;
      break;
    }
    label214:
    parama.onCallback(null);
    AppMethodBeat.o(333349);
  }
  
  public final void a(String paramString1, String paramString2, ca.a<Boolean> parama, ca.a<Integer> parama1)
  {
    AppMethodBeat.i(333319);
    if ((paramString1 == null) || (paramString2 == null))
    {
      parama1.onCallback(Integer.valueOf(-1000));
      AppMethodBeat.o(333319);
      return;
    }
    Boolean localBoolean = ((aj)com.tencent.mm.kernel.h.ax(aj.class)).hJ(paramString1, paramString2);
    if (localBoolean != null)
    {
      parama.onCallback(localBoolean);
      AppMethodBeat.o(333319);
      return;
    }
    new com.tencent.mm.plugin.finder.cgi.f(paramString1, paramString2).bFJ().g(new ax..ExternalSyntheticLambda4(paramString1, paramString2, parama, parama1));
    AppMethodBeat.o(333319);
  }
  
  public final void aBY(String paramString)
  {
    AppMethodBeat.i(333290);
    ay localay = ay.Gjp;
    ay.aBY(paramString);
    AppMethodBeat.o(333290);
  }
  
  public final bs aP(Activity paramActivity)
  {
    AppMethodBeat.i(333271);
    s.u(paramActivity, "context");
    paramActivity = (bs)new o(paramActivity);
    AppMethodBeat.o(333271);
    return paramActivity;
  }
  
  public final com.tencent.mm.am.b<baj> azA(String paramString)
  {
    AppMethodBeat.i(333444);
    s.u(paramString, "md5");
    paramString = ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishPostApi().azA(paramString);
    AppMethodBeat.o(333444);
    return paramString;
  }
  
  public final void b(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(333465);
    s.u(paramString, "eid");
    bb localbb = bb.FuK;
    bb.a(null, paramString, paramInt, paramJSONObject);
    AppMethodBeat.o(333465);
  }
  
  public final void b(String paramString1, long paramLong, String paramString2, String paramString3, Map<String, Object> paramMap, ca.a<Void> parama, ca.a<Integer> parama1)
  {
    AppMethodBeat.i(333357);
    a(this, paramString1, paramString2, parama1, paramString3, paramLong, parama, ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).genContextId(4, 4, 105), null, null, 0L, null, paramMap, 1920);
    AppMethodBeat.o(333357);
  }
  
  public final void b(String paramString1, String paramString2, ca.a<Void> parama, ca.a<Integer> parama1)
  {
    AppMethodBeat.i(333331);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramString1 == null) || (paramString2 == null))
    {
      parama1.onCallback(Integer.valueOf(-1000));
      AppMethodBeat.o(333331);
      return;
    }
    ((g)com.tencent.mm.kernel.h.ax(g.class)).a(paramString1, paramString2, 1, 1).bFJ().g(new ax..ExternalSyntheticLambda3(parama, parama1));
    AppMethodBeat.o(333331);
  }
  
  public final void e(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(333309);
    if (paramContext != null)
    {
      localObject = (CharSequence)paramString1;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label46;
      }
    }
    label46:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(333309);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("KEY_USERNAME", paramString1);
    ((Intent)localObject).putExtra("KEY_NICKNAME", paramString2);
    ((Intent)localObject).putExtra("KEY_COMMENT_SCENE", paramInt);
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(14, 2, paramInt, (Intent)localObject);
    paramString1 = a.GfO;
    a.al(paramContext, (Intent)localObject);
    AppMethodBeat.o(333309);
  }
  
  public final void e(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(333470);
    s.u(paramViewGroup, "mask");
    int m = paramViewGroup.getChildCount();
    if (m > 0) {}
    int k;
    label93:
    label125:
    for (int i = 0;; i = k)
    {
      k = i + 1;
      View localView = paramViewGroup.getChildAt(i);
      i = j;
      if (localView.getVisibility() != 0) {
        if (localView.getVisibility() != 4) {
          break label93;
        }
      }
      for (i = j; i != 0; i = 1)
      {
        paramViewGroup.setBackground(paramViewGroup.getContext().getDrawable(paramInt1));
        AppMethodBeat.o(333470);
        return;
        if (k < m) {
          break label125;
        }
      }
      paramViewGroup.setBackground(paramViewGroup.getContext().getDrawable(paramInt2));
      AppMethodBeat.o(333470);
      return;
    }
  }
  
  public final an en(Context paramContext)
  {
    AppMethodBeat.i(333253);
    s.u(paramContext, "context");
    paramContext = ((g)com.tencent.mm.kernel.h.ax(g.class)).en(paramContext);
    AppMethodBeat.o(333253);
    return paramContext;
  }
  
  public final void f(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(333367);
    s.u(paramString1, "feedExportId");
    s.u(paramString4, "reportExtraInfo");
    new az(0L, "", 65, 2, "", true, null, null, 0L, null, false, false, paramString1, null, 0, null, 53184).bFJ().g(new ax..ExternalSyntheticLambda0(this, 0L, paramString2, paramInt, paramString3, paramString4));
    AppMethodBeat.o(333367);
  }
  
  public final int fgA()
  {
    AppMethodBeat.i(333236);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eUN().bmg()).intValue() != 1)
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      i = com.tencent.mm.plugin.finder.storage.d.ePW();
      AppMethodBeat.o(333236);
      return i;
    }
    localObject = com.tencent.mm.k.a.lZC;
    int i = com.tencent.mm.k.a.aQA();
    AppMethodBeat.o(333236);
    return i;
  }
  
  public final float fgB()
  {
    AppMethodBeat.i(333244);
    float f = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zaI, 3.0F);
    Log.i(this.TAG, s.X("getLongVideoMaxRatio ", Float.valueOf(f)));
    AppMethodBeat.o(333244);
    return f;
  }
  
  public final float fgC()
  {
    AppMethodBeat.i(333265);
    float f = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zaI, 3.0F);
    if (f >= 1.0F) {}
    for (f = 1.0F / f;; f = 0.3333333F)
    {
      Log.i(this.TAG, s.X("getLongVideoMinRatio ", Float.valueOf(f)));
      AppMethodBeat.o(333265);
      return f;
    }
  }
  
  public final boolean fgD()
  {
    boolean bool = true;
    AppMethodBeat.i(333312);
    if (i.aRC().getInt("FinderProfileCoverSettingShowEntrance", 1) == 1) {}
    for (;;)
    {
      Log.i(this.TAG, s.X("isEnableSetProfileCover:", Boolean.valueOf(bool)));
      AppMethodBeat.o(333312);
      return bool;
      bool = false;
    }
  }
  
  public final boolean fgE()
  {
    AppMethodBeat.i(333380);
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    boolean bool = com.tencent.mm.plugin.finder.nearby.abtest.a.eEi();
    AppMethodBeat.o(333380);
    return bool;
  }
  
  public final boolean fgF()
  {
    AppMethodBeat.i(333391);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    int i;
    boolean bool1;
    label45:
    boolean bool3;
    if (((Number)com.tencent.d.a.a.a.a.a.jSo().bmg()).intValue() == 1)
    {
      i = 1;
      if (i.aRC().getInt("FinderNearbyLiveSwitch", 1) != 1) {
        break label159;
      }
      bool1 = true;
      bool3 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry();
      locala = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jSn().bmg()).intValue() != 1) {
        break label164;
      }
    }
    label159:
    label164:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i(this.TAG, "isEnableNearbyLiveFriends isValidUser:" + bool1 + " hasFinder:" + bool3 + " isEnableNearbyLiveFriends:" + bool2);
      if ((i == 0) && ((!bool1) || (!bool3) || (!bool2))) {
        break label169;
      }
      AppMethodBeat.o(333391);
      return true;
      i = 0;
      break;
      bool1 = false;
      break label45;
    }
    label169:
    AppMethodBeat.o(333391);
    return false;
  }
  
  public final boolean fgG()
  {
    AppMethodBeat.i(333398);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jSp().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(333398);
      return true;
    }
    AppMethodBeat.o(333398);
    return false;
  }
  
  public final boolean fgH()
  {
    boolean bool = false;
    AppMethodBeat.i(333403);
    if (i.aRC().getInt("FinderOpenShareListFeedsIgnoreLimitedSwitch", 0) == 0) {
      bool = true;
    }
    Log.i(this.TAG, s.X("isEnableTeenModeCheckInShareScene:", Boolean.valueOf(bool)));
    AppMethodBeat.o(333403);
    return bool;
  }
  
  public final String fgI()
  {
    AppMethodBeat.i(333452);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eXD())
    {
      AppMethodBeat.o(333452);
      return "com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI";
    }
    AppMethodBeat.o(333452);
    return "com.tencent.mm.plugin.finder.ui.FinderHomeUI";
  }
  
  public final String fgJ()
  {
    AppMethodBeat.i(333460);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eXD())
    {
      AppMethodBeat.o(333460);
      return ".ui.FinderHomeAffinityUI";
    }
    AppMethodBeat.o(333460);
    return ".ui.FinderHomeUI";
  }
  
  public final void h(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(333421);
    s.u(paramContext, "context");
    if (Util.isNullOrNil(paramString1))
    {
      Log.i(this.TAG, "enterProfileForWxPay exportId empty");
      AppMethodBeat.o(333421);
      return;
    }
    Log.i(this.TAG, "enterFeedForWxPay exportId:" + paramString1 + ", enterCommentScene:16, extraInfo:" + paramString3);
    Intent localIntent = new Intent();
    localIntent.putExtra("from_user", z.bAM());
    localIntent.putExtra("feed_encrypted_object_id", paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("feed_object_nonceId", paramString1);
    localIntent.putExtra("key_need_related_list", true);
    localIntent.putExtra("key_comment_scene", 16);
    localIntent.putExtra("key_reuqest_scene", 22);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("key_extra_info", paramString1);
    paramString1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDh("entrance") != 0)
    {
      paramString1 = a.GfO;
      a.hc(paramContext);
      AppMethodBeat.o(333421);
      return;
    }
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(16, 2, 25, localIntent);
    paramString1 = a.GfO;
    a.Y(paramContext, localIntent);
    AppMethodBeat.o(333421);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderUtilApi$getLiveStatusWithUserName$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "liveStatus", "", "liveInfoResp", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b.d
  {
    a(ca.a<Boolean> parama) {}
    
    public final void onLiveStatusCallback(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(333392);
      paramObject = this.Byj;
      if (paramObject != null) {
        if (paramInt == 2) {
          break label42;
        }
      }
      label42:
      for (boolean bool = true;; bool = false)
      {
        paramObject.onCallback(Boolean.valueOf(bool));
        AppMethodBeat.o(333392);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ax
 * JD-Core Version:    0.7.0.1
 */