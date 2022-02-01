package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.widget.ImageView;
import com.tencent.c.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.e;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveConfettiView;
import com.tencent.mm.plugin.findersdk.a.ac;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.bbk;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderUtilApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi;", "()V", "TAG", "", "enterActivityProfileUI", "", "context", "Landroid/content/Context;", "encryptedTopicId", "eventName", "extra", "entryScene", "", "enterFeedForWxPay", "exportId", "nonceId", "getRelatedList", "", "enterCommentScene", "enterFriendLikeTimelineUI", "targetUsername", "targetNickname", "commentScene", "enterProfileForWxPay", "finderUserName", "getFinderLiveConfettView", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveConfettView;", "getFinderSnsHeader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader;", "Landroid/app/Activity;", "getLiveNoticeStateWithAnchorUserName", "username", "noticeId", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "getLiveStatusWithUserName", "liveId", "", "getLongVideoMaxDuration", "getLongVideoMaxRatio", "", "getLongVideoMinRatio", "getWxProfileInfo", "", "wxUsername", "openimUsername", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "isEnableFinderLiveEntry", "isEnableNearbyLiveFriends", "isEnableNearbyLivePullSimilar", "isEnableTeenModeCheckInShareScene", "jumpLiveUIAndDoAction", "action", "feedExportId", "contextId", "reportExtraInfo", "jumpLiveUIByFeedId", "feedNonceId", "Ljava/lang/Void;", "verifyInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLivePermissionVerifyInfo;", "loadCoverIntoImageView", "imageView", "Landroid/widget/ImageView;", "finderObj", "loadGalleryFeed", "cgiParams", "Lcom/tencent/mm/protocal/protobuf/FinderGalleryCgiParams;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$GalleryCgiCallback;", "openChannelsRewardedVideoAd", "extInfo", "Lorg/json/JSONObject;", "reserveLiveNoticeWithAnchorUsername", "reserveOperation", "resetRequestTime", "setBlurBitmap", "url", "radius", "showLiveRoomWithUserName", "", "tryGetFinderObject", "Landroid/util/Pair;", "objectId", "objectNonceId", "tryGetFinderObjectFromCache", "plugin-finder_release"})
public final class al
  implements com.tencent.mm.plugin.findersdk.a.ag
{
  private final String TAG = "Finder.FinderUtilApi";
  
  public final void F(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(269759);
    p.k(paramContext, "context");
    if (Util.isNullOrNil(paramString1))
    {
      Log.i(this.TAG, "enterProfileForWxPay exportId empty");
      AppMethodBeat.o(269759);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("from_user", z.bcZ());
    localIntent.putExtra("feed_encrypted_object_id", paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("feed_object_nonceId", paramString1);
    localIntent.putExtra("key_need_related_list", true);
    localIntent.putExtra("key_comment_scene", 16);
    localIntent.putExtra("key_reuqest_scene", 22);
    paramString1 = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    if (com.tencent.mm.plugin.findersdk.c.a.aGQ("entrance") != 0)
    {
      paramString1 = a.ACH;
      a.fI(paramContext);
      AppMethodBeat.o(269759);
      return;
    }
    ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(16, 2, 25, localIntent);
    paramString1 = a.ACH;
    a.E(paramContext, localIntent);
    AppMethodBeat.o(269759);
  }
  
  public final Object a(String paramString1, String paramString2, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, ag.a<Object> parama, ag.a<Integer> parama1)
  {
    AppMethodBeat.i(269741);
    p.k(paramb, "lifeCycle");
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = am.AGR;
      paramString1 = am.b(paramString2, paramb, parama, parama1);
      AppMethodBeat.o(269741);
      return paramString1;
    }
    paramString2 = am.AGR;
    paramString1 = am.a(paramString1, paramb, parama, parama1);
    AppMethodBeat.o(269741);
    return paramString1;
  }
  
  public final void a(long paramLong, ag.a<Boolean> parama)
  {
    AppMethodBeat.i(269747);
    ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getLiveInfo(paramLong, (b.d)new b(parama));
    AppMethodBeat.o(269747);
  }
  
  public final void a(Context paramContext, JSONObject paramJSONObject, ag.a<Object> parama, ag.a<Integer> parama1)
  {
    AppMethodBeat.i(269760);
    p.k(paramContext, "context");
    p.k(paramJSONObject, "extInfo");
    String str1 = paramJSONObject.optString("feedId");
    Object localObject1 = paramJSONObject.optString("nonceId");
    int k = paramJSONObject.optInt("shareScene", 0);
    String str3 = paramJSONObject.optString("sessionId", "");
    String str2 = paramJSONObject.optString("reportExtraInfo", "");
    int i = paramJSONObject.optInt("entryScene", 0);
    int m = paramJSONObject.optInt("adJSAPIType", 0);
    Object localObject2 = paramJSONObject.optString("userName", "");
    com.tencent.mm.plugin.finder.ui.sharerel.d locald = com.tencent.mm.plugin.finder.ui.sharerel.d.Azi;
    com.tencent.mm.plugin.finder.ui.sharerel.d.a(parama);
    parama = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    int j = com.tencent.mm.plugin.findersdk.c.a.aGQ("entrance");
    if (j != 0)
    {
      if (parama1 != null) {
        parama1.aH(Integer.valueOf(-1003));
      }
      Log.i(this.TAG, "[openChannelsRewardedVideoAd] spamAction:" + j + ' ');
      AppMethodBeat.o(269760);
      return;
    }
    parama = aj.AGc;
    j = aj.Re(k);
    if (j != -1)
    {
      i = j;
      parama = aj.AGc;
      if (!aj.aFU(str2)) {
        break label298;
      }
    }
    label298:
    for (j = 4;; j = 2)
    {
      if (m != 1) {
        break label304;
      }
      paramJSONObject = c.wkV;
      c.a.gF(str2, (String)localObject2);
      paramJSONObject = new Intent();
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(i, j, 104, paramJSONObject);
      com.tencent.mm.plugin.sns.ad.d.l.a(paramJSONObject, paramContext, (String)localObject2, (String)localObject1, str1, str2);
      AppMethodBeat.o(269760);
      return;
      if (i != 0) {
        break;
      }
      i = 15;
      break;
    }
    label304:
    localObject2 = new blp();
    ((blp)localObject2).feedId = str1;
    ((blp)localObject2).nonceId = ((String)localObject1);
    ((blp)localObject2).whH = paramJSONObject.optString("finderUserName");
    ((blp)localObject2).SWE = paramJSONObject.optString("expReportLink");
    ((blp)localObject2).SWF = paramJSONObject.optString("clkReportLink");
    parama = paramJSONObject.optJSONObject("reportInfo");
    if (parama != null)
    {
      parama1 = parama.toString();
      parama = parama1;
      if (parama1 != null) {}
    }
    else
    {
      parama = new JSONObject().toString();
    }
    ((blp)localObject2).jXW = parama;
    parama = paramJSONObject.optJSONObject("clickPosMap");
    if (parama != null)
    {
      parama1 = parama.toString();
      parama = parama1;
      if (parama1 != null) {}
    }
    else
    {
      parama = new JSONObject().toString();
    }
    ((blp)localObject2).SWG = parama;
    ((blp)localObject2).wwr = paramJSONObject.optString("feedbackUrl");
    Log.i(this.TAG, "adFlowInfo feedId:" + str1 + ", nonceId:" + ((blp)localObject2).nonceId + ", finderUserName:" + ((blp)localObject2).whH);
    Log.i(this.TAG, "adFlowInfo expReportLink:" + ((blp)localObject2).SWE + ", clkReportLink:" + ((blp)localObject2).SWF + ", reportInfo:" + ((blp)localObject2).jXW);
    Log.i(this.TAG, "adFlowInfo clickPosMap:" + ((blp)localObject2).SWG + ", feedbackUrl:" + ((blp)localObject2).wwr);
    paramJSONObject = c.wkV;
    c.a.gF(str2, ((blp)localObject2).whH);
    parama1 = new Intent();
    parama1.putExtra("KEY_MINI_APP_AD_FLOW_INFO", ((blp)localObject2).toByteArray());
    parama1.putExtra("from_user", z.bcZ());
    parama1.putExtra("feed_encrypted_object_id", str1);
    parama1.putExtra("feed_object_nonceId", (String)localObject1);
    parama1.putExtra("key_need_related_list", true);
    parama1.putExtra("key_comment_scene", 104);
    parama1.putExtra("key_reuqest_scene", 23);
    parama1.putExtra("key_session_id", str3);
    parama1.putExtra("key_extra_info", str2);
    parama1.putExtra("is_from_ad", true);
    parama = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(i, j, 104, parama1);
    if (!Util.isNullOrNil(""))
    {
      localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
      paramJSONObject = parama;
      if (parama == null) {
        paramJSONObject = "";
      }
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(21140, new Object[] { paramJSONObject, "", str1, "" });
    }
    parama1.putExtra("report_scene", k);
    parama1.putExtra("tab_type", 9);
    paramJSONObject = a.ACH;
    a.E(paramContext, parama1);
    paramContext = com.tencent.mm.plugin.secinforeport.a.d.Jcm;
    com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999685);
    AppMethodBeat.o(269760);
  }
  
  public final void a(String paramString1, long paramLong, String paramString2, String paramString3, ag.a<Void> parama, ag.a<Integer> parama1)
  {
    AppMethodBeat.i(269748);
    a(this, paramString1, paramString2, parama1, paramString3, paramLong, parama, ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).genContextId(4, 4, 105), null, 384);
    AppMethodBeat.o(269748);
  }
  
  public final void a(String paramString1, final String paramString2, final ag.a<Boolean> parama, final ag.a<Integer> parama1)
  {
    AppMethodBeat.i(269745);
    if ((paramString1 == null) || (paramString2 == null))
    {
      parama1.aH(Integer.valueOf(-1000));
      AppMethodBeat.o(269745);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.live.a.xUC;
    localObject = com.tencent.mm.plugin.finder.live.a.gY(paramString1, paramString2);
    if (localObject != null)
    {
      parama.aH(localObject);
      AppMethodBeat.o(269745);
      return;
    }
    new e(paramString1, paramString2).bhW().g((com.tencent.mm.vending.c.a)new a(paramString1, paramString2, parama, parama1));
    AppMethodBeat.o(269745);
  }
  
  public final void a(String paramString1, String paramString2, final ag.a<Integer> parama, String paramString3, final long paramLong, final ag.a<Void> parama1, final String paramString4, final String paramString5, bbk parambbk)
  {
    AppMethodBeat.i(269749);
    p.k(paramString4, "contextId");
    p.k(paramString5, "reportExtraInfo");
    if (paramString2 == null)
    {
      if (parama != null)
      {
        parama.aH(Integer.valueOf(-1000));
        AppMethodBeat.o(269749);
        return;
      }
      AppMethodBeat.o(269749);
      return;
    }
    new com.tencent.mm.plugin.finder.cgi.ag(0L, paramString3, 65, 2, "", true, null, null, 0L, null, false, false, paramString2, null, 0, parambbk, 20416).bhW().g((com.tencent.mm.vending.c.a)new d(this, paramLong, paramString1, paramString5, paramString4, parama1, parama));
    AppMethodBeat.o(269749);
  }
  
  public final void aFX(String paramString)
  {
    AppMethodBeat.i(269742);
    am localam = am.AGR;
    am.aFX(paramString);
    AppMethodBeat.o(269742);
  }
  
  public final void aM(Context paramContext, String paramString)
  {
    AppMethodBeat.i(269758);
    p.k(paramContext, "context");
    if (Util.isNullOrNil(paramString))
    {
      Log.i(this.TAG, "enterProfileForWxPay finderUserName empty");
      AppMethodBeat.o(269758);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString);
    ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(16, 2, 32, localIntent);
    paramString = a.ACH;
    a.enterFinderProfileUI(paramContext, localIntent);
    AppMethodBeat.o(269758);
  }
  
  public final ac au(Activity paramActivity)
  {
    AppMethodBeat.i(269740);
    p.k(paramActivity, "context");
    paramActivity = (ac)new com.tencent.mm.plugin.finder.view.l(paramActivity);
    AppMethodBeat.o(269740);
    return paramActivity;
  }
  
  public final void b(String paramString1, String paramString2, ag.a<Void> parama, final ag.a<Integer> parama1)
  {
    AppMethodBeat.i(269746);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramString1 == null) || (paramString2 == null))
    {
      parama1.aH(Integer.valueOf(-1000));
      AppMethodBeat.o(269746);
      return;
    }
    new com.tencent.mm.plugin.finder.live.cgi.a(paramString1, paramString2).bhW().g((com.tencent.mm.vending.c.a)new e(parama, parama1));
    AppMethodBeat.o(269746);
  }
  
  public final void c(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(269744);
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
      AppMethodBeat.o(269744);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("KEY_USERNAME", paramString1);
    ((Intent)localObject).putExtra("KEY_NICKNAME", paramString2);
    ((Intent)localObject).putExtra("KEY_COMMENT_SCENE", paramInt);
    ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(14, 2, paramInt, (Intent)localObject);
    paramString1 = a.ACH;
    a.T(paramContext, (Intent)localObject);
    AppMethodBeat.o(269744);
  }
  
  public final void d(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(269753);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    if (paramString1 == null) {}
    for (String str = "";; str = paramString1)
    {
      localIntent.putExtra("key_encrypted_topic_id", str);
      if (paramString2 == null) {}
      for (str = "";; str = paramString2)
      {
        localIntent.putExtra("key_activity_name", str);
        Log.i(this.TAG, "enterActivityProfileUI :" + paramString1 + " eventName:" + paramString2);
        if (6 == paramInt) {
          ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(6, 2, 59, localIntent);
        }
        for (;;)
        {
          paramString1 = a.ACH;
          a.aa(paramContext, localIntent);
          AppMethodBeat.o(269753);
          return;
          ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(4, 4, 59, localIntent);
        }
      }
    }
  }
  
  public final int eeE()
  {
    AppMethodBeat.i(269736);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWd().aSr()).intValue() != 1)
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      i = com.tencent.mm.plugin.finder.storage.d.dRK();
      AppMethodBeat.o(269736);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKm, 1801);
    localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKn, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(269736);
      return i;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      int j = ((JSONObject)localObject).getInt("apiLevel");
      double d = ((JSONObject)localObject).getDouble("durationMultiplier");
      int k = Build.VERSION.SDK_INT;
      if ((d >= 0.0D) && (k <= j))
      {
        j = (int)(d * i);
        AppMethodBeat.o(269736);
        return j;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(269736);
    }
    return i;
  }
  
  public final float eeF()
  {
    AppMethodBeat.i(269737);
    float f = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKo, 3.0F);
    Log.i(this.TAG, "getLongVideoMaxRatio ".concat(String.valueOf(f)));
    AppMethodBeat.o(269737);
    return f;
  }
  
  public final float eeG()
  {
    AppMethodBeat.i(269739);
    float f = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKo, 3.0F);
    if (f >= 1.0F) {}
    for (f = 1.0F / f;; f = 0.3333333F)
    {
      Log.i(this.TAG, "getLongVideoMinRatio ".concat(String.valueOf(f)));
      AppMethodBeat.o(269739);
      return f;
    }
  }
  
  public final boolean eeH()
  {
    AppMethodBeat.i(269754);
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    boolean bool = com.tencent.mm.plugin.finder.nearby.abtest.a.dLo();
    AppMethodBeat.o(269754);
    return bool;
  }
  
  public final boolean eeI()
  {
    AppMethodBeat.i(269755);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    int i;
    boolean bool1;
    label45:
    boolean bool3;
    if (((Number)com.tencent.c.a.a.a.a.a.ilM().aSr()).intValue() == 1)
    {
      i = 1;
      if (com.tencent.mm.n.h.axc().getInt("FinderNearbyLiveSwitch", 1) != 1) {
        break label158;
      }
      bool1 = true;
      bool3 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry();
      locala = com.tencent.c.a.a.a.a.a.Zlt;
      if (((Number)com.tencent.c.a.a.a.a.a.ilL().aSr()).intValue() != 1) {
        break label163;
      }
    }
    label158:
    label163:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i(this.TAG, "isEnableNearbyLiveFriends isValidUser:" + bool1 + " hasFinder:" + bool3 + " isEnableNearbyLiveFriends:" + bool2);
      if ((i == 0) && ((!bool1) || (!bool3) || (!bool2))) {
        break label168;
      }
      AppMethodBeat.o(269755);
      return true;
      i = 0;
      break;
      bool1 = false;
      break label45;
    }
    label168:
    AppMethodBeat.o(269755);
    return false;
  }
  
  public final boolean eeJ()
  {
    AppMethodBeat.i(269756);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilN().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(269756);
      return true;
    }
    AppMethodBeat.o(269756);
    return false;
  }
  
  public final boolean eeK()
  {
    boolean bool = false;
    AppMethodBeat.i(269757);
    if (com.tencent.mm.n.h.axc().getInt("FinderOpenShareListFeedsIgnoreLimitedSwitch", 0) == 0) {
      bool = true;
    }
    Log.i(this.TAG, "isEnableTeenModeCheckInShareScene:".concat(String.valueOf(bool)));
    AppMethodBeat.o(269757);
    return bool;
  }
  
  public final void f(final int paramInt, String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    AppMethodBeat.i(269752);
    p.k(paramString1, "feedExportId");
    p.k(paramString4, "reportExtraInfo");
    new com.tencent.mm.plugin.finder.cgi.ag(0L, "", 65, 2, "", true, null, null, 0L, null, false, false, paramString1, null, 0, null, 53184).bhW().g((com.tencent.mm.vending.c.a)new c(this, paramString2, paramInt, paramString3, paramString4));
    AppMethodBeat.o(269752);
  }
  
  public final void f(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(269743);
    Object localObject = aj.AGc;
    if ((paramImageView != null) && (paramString != null))
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.f(paramImageView, paramString);
    }
    AppMethodBeat.o(269743);
  }
  
  public final q fV(Context paramContext)
  {
    AppMethodBeat.i(269738);
    p.k(paramContext, "context");
    paramContext = (q)new FinderLiveConfettiView(paramContext);
    AppMethodBeat.o(269738);
    return paramContext;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(String paramString1, String paramString2, ag.a parama1, ag.a parama2) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderUtilApi$getLiveStatusWithUserName$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "liveStatus", "", "liveInfoResp", "", "plugin-finder_release"})
  public static final class b
    implements b.d
  {
    b(ag.a parama) {}
    
    public final void a(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(274930);
      paramObject = this.xXo;
      if (paramObject != null)
      {
        if (paramInt != 2) {}
        for (boolean bool = true;; bool = false)
        {
          paramObject.aH(Boolean.valueOf(bool));
          AppMethodBeat.o(274930);
          return;
        }
      }
      AppMethodBeat.o(274930);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(al paramal, String paramString1, int paramInt, String paramString2, String paramString3) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(al paramal, long paramLong, String paramString1, String paramString2, String paramString3, ag.a parama1, ag.a parama2) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(ag.a parama1, ag.a parama2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.al
 * JD-Core Version:    0.7.0.1
 */