package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.finder.live.MiniProgramHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.finder.live.model.cgi.af;
import com.tencent.mm.plugin.finder.live.model.cgi.af.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ar;
import com.tencent.mm.plugin.finder.live.model.cgi.ar.a;
import com.tencent.mm.plugin.finder.live.model.cgi.w;
import com.tencent.mm.plugin.finder.live.model.cgi.w.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.ax.a;
import com.tencent.mm.plugin.finder.live.plugin.ax.a.a;
import com.tencent.mm.plugin.finder.live.plugin.ax.a.b;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.ca;
import com.tencent.mm.plugin.finder.live.report.q.cf;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bd;
import com.tencent.mm.plugin.findersdk.a.b;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ci;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.plugin.wallet.wecoin.a.i;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAssistant2;", "", "()V", "TAG", "", "BatchGetObjectAsyncInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "units", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectUidUnit;", "scene", "", "liveReportScene", "commentScene", "finderUserName", "uxInfo", "(Ljava/util/List;IIILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CheckPurchaseLiveInvalid", "", "objectId", "", "nonceId", "liveId", "(JLjava/lang/String;JIIILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "announceGotoShopping", "", "context", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "productId", "closeMiniProgram", "purpose", "doConsume", "rewardGiftId", "rewardGiftCnt", "wecoin", "comboId", "sendGiftTargetUserName", "rewardType", "rewardExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "businessId", "callback", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftSendPlugin$ISendGiftCallback;", "doPostComment", "commentContent", "liveMsgType", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "genLiveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "getJsonField", "jsonVal", "field", "getShopShelf", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "liveBuContext", "isAnchor", "anchorHasInit", "anchorUsername", "liveCookies", "", "requestId", "stockId", "pullScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;ZZJJLjava/lang/String;[BLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWeCoinBalance", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "balance", "goToFinderProfileImpl", "gotoAnchor", "finderUsername", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "launchMiniProgram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "openFullScreenMiniProgram", "luanchFromApp", "valueCallback", "Landroid/webkit/ValueCallback;", "openHalfScreenMiniProgram", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "openMiniProgram", "showRechargeFoodsDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "Landroidx/fragment/app/FragmentActivity;", "sessionId", "Lkotlin/Function1;", "confirm", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g CEN;
  
  static
  {
    AppMethodBeat.i(359472);
    CEN = new g();
    AppMethodBeat.o(359472);
  }
  
  public static com.tencent.mm.plugin.wallet.wecoin.a.e a(FragmentActivity paramFragmentActivity, String paramString, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(359361);
    s.u(paramFragmentActivity, "context");
    s.u(paramString, "sessionId");
    s.u(paramb, "callback");
    Log.i("FinderLiveAssistant2", s.X("showRechargeFoodsDialog sessionId:", paramString));
    com.tencent.mm.plugin.wallet.wecoin.a.h localh = new com.tencent.mm.plugin.wallet.wecoin.a.h();
    localh.mScene = 16;
    localh.Vua = paramString;
    localh.VtR = ((i)new f(paramFragmentActivity, paramb));
    paramFragmentActivity = ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).a(paramFragmentActivity, localh);
    AppMethodBeat.o(359361);
    return paramFragmentActivity;
  }
  
  public static Object a(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.live.model.context.a parama, long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, kotlin.d.d<? super bih> paramd)
  {
    AppMethodBeat.i(359421);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    final kotlin.d.d locald = (kotlin.d.d)localh;
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMMActivity).cq(bn.class)).fou();
    String str = z.bAW();
    s.s(str, "getMyFinderUsername()");
    new af(paramLong1, paramLong2, paramString1, paramArrayOfByte, 1, str, paramString2, null, 3, (bui)localObject, paramString3, (af.a)new d(parama, locald), (byte)0).bFJ().a((com.tencent.mm.vending.e.b)paramMMActivity);
    paramMMActivity = localh.kli();
    if (paramMMActivity == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(359421);
    return paramMMActivity;
  }
  
  private static final ah a(w.a parama, Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama1, com.tencent.mm.am.b.a parama2)
  {
    AppMethodBeat.i(359449);
    s.u(paramContext, "$context");
    s.u(parama1, "$buContext");
    int i = parama2.errType;
    int j = parama2.errCode;
    String str = parama2.errMsg;
    parama2 = (bst)parama2.ott;
    if (parama != null)
    {
      s.s(parama2, "resp");
      parama.a(i, j, parama2);
    }
    if ((i == 0) && (j == 0)) {
      if (com.tencent.mm.ae.d.ee(parama2.ZND, 1))
      {
        aa.a(paramContext, paramContext.getResources().getString(p.h.Cmh), g..ExternalSyntheticLambda0.INSTANCE);
        parama = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)parama1.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
        if (parama != null) {
          break label171;
        }
        parama = null;
        Log.i("FinderLiveAssistant2", s.X("doPostComment attended lottery success,lotteryId:", parama));
        parama = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
          com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFi, "");
        }
      }
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(359449);
      return parama;
      label171:
      parama = parama.Bhm;
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = parama.id;
      break;
      parama = aw.Gjk;
      if (aw.bgV()) {
        aa.makeText(paramContext, (CharSequence)(j + ':' + str), 0).show();
      }
    }
  }
  
  public static void a(long paramLong, kotlin.g.a.m<? super Long, ? super Long, ah> paramm)
  {
    AppMethodBeat.i(359351);
    Log.i("FinderLiveAssistant2", s.X("[WeCoin] getWeCoinBalance: requestId:", Long.valueOf(paramLong)));
    ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).a((i)new g.e(paramLong, paramm));
    AppMethodBeat.o(359351);
  }
  
  public static void a(final Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, int paramInt, final String paramString1, String paramString2, final ax.a parama1)
  {
    AppMethodBeat.i(359372);
    s.u(paramContext, "context");
    s.u(parama, "buContext");
    s.u(paramString2, "sendGiftTargetUserName");
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyr();
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 70);
    String str = z.bAW();
    Object localObject1 = aw.Gjk;
    localObject1 = aw.fgw();
    com.tencent.mm.plugin.report.service.h.OAn.b(22129, new Object[] { Integer.valueOf(1), localObject1, "", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), "" });
    Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject2 = ((bn)com.tencent.mm.ui.component.k.nq(paramContext).cq(bn.class)).fou();
    parama = new ar(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, null, 1, str, paramInt, (String)localObject1, paramString1, paramString2, (bui)localObject2, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).sessionBuffer, 1, null, (ar.a)new c(paramInt, parama1, (String)localObject1, paramContext, null, 1, paramString1)).bFJ();
    if ((paramContext instanceof MMActivity)) {
      parama.a((com.tencent.mm.vending.e.b)paramContext);
    }
    AppMethodBeat.o(359372);
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, long paramLong)
  {
    AppMethodBeat.i(359410);
    s.u(paramContext, "context");
    s.u(parama, "buContext");
    boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eig.contains(Long.valueOf(paramLong));
    Log.i("FinderLiveAssistant2", "announceGotoShopping productId:" + paramLong + ", haveBug:" + bool);
    bui localbui;
    String str1;
    byte[] arrayOfByte;
    long l;
    String str2;
    String str3;
    if ((paramLong != 0L) && (!bool))
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eig.add(Long.valueOf(paramLong));
      s.u(paramContext, "context");
      s.u(parama, "buContext");
      s.u("", "commentContent");
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localbui = ((bn)com.tencent.mm.ui.component.k.nq(paramContext).cq(bn.class)).fou();
      localObject = aw.Gjk;
      str1 = aw.fgw();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eea.add(str1);
      paramLong = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
      l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      str2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
      str3 = z.bAW();
      s.s(str3, "getMyFinderUsername()");
      localObject = com.tencent.mm.live.core.core.f.mMm.bee();
      if (localObject != null) {
        break label344;
      }
    }
    label344:
    for (Object localObject = null;; localObject = ((com.tencent.mm.live.core.core.model.e)localObject).mNe)
    {
      parama = new w(paramLong, "", 10012, arrayOfByte, l, str2, str3, localbui, str1, (String)localObject, gv(paramContext), (byte)0).bFJ().g(new g..ExternalSyntheticLambda1(null, paramContext, parama));
      if ((paramContext instanceof MMActivity)) {
        parama.a((com.tencent.mm.vending.e.b)paramContext);
      }
      AppMethodBeat.o(359410);
      return;
    }
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.appbrand.api.g paramg, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(359400);
    Object localObject = com.tencent.mm.plugin.finder.live.n.BxF;
    com.tencent.mm.plugin.finder.live.n.a(parama, paramg, true);
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    paramg.euz = com.tencent.mm.plugin.finder.live.utils.a.bUq();
    paramg.idh = paramValueCallback;
    paramg.qAL = 1000;
    s.u(paramContext, "context");
    s.u(parama, "buContext");
    s.u(paramg, "bundle");
    int i = paramg.hashCode();
    paramg.qAV = true;
    localObject = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    paramValueCallback = paramg.qAT.qZQ;
    if ((paramValueCallback instanceof MiniProgramHalfScreenStatusChangeListener)) {}
    for (paramValueCallback = (MiniProgramHalfScreenStatusChangeListener)paramValueCallback;; paramValueCallback = null)
    {
      paramg.qAU = ((com.tencent.mm.plugin.h)localObject).a(parama, (ci)paramValueCallback);
      parama = com.tencent.mm.plugin.finder.live.viewmodel.data.g.Ebv;
      ((Map)com.tencent.mm.plugin.finder.live.viewmodel.data.g.exX()).put(Integer.valueOf(i), paramg);
      Log.i("FinderLiveAssistant2", "launchMiniProgram,key:" + i + ",bundle is null:false");
      parama = new Intent();
      paramg = a.b.Hbz;
      paramg = a.b.fqZ();
      paramValueCallback = a.b.Hbz;
      parama.putExtra(paramg, a.b.frc());
      paramg = a.b.Hbz;
      parama.putExtra(a.b.fra(), i);
      parama.putExtra("MMActivity.OverrideEnterAnimation", -1);
      parama.putExtra("MMActivity.OverrideExitAnimation", -1);
      parama.addFlags(335544320);
      paramg = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      parama.setClass(paramContext, com.tencent.mm.plugin.finder.live.utils.a.gE(paramContext));
      parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, parama.aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant2", "launchMiniProgram", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)parama.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant2", "launchMiniProgram", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(359400);
      return;
    }
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, boolean paramBoolean, String paramString, bui parambui)
  {
    AppMethodBeat.i(359386);
    s.u(parama, "buContext");
    s.u(paramString, "finderUsername");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_profile_share_scene", 0);
    if (paramBoolean) {
      if (Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC))
      {
        localIntent.putExtra("finder_username", "");
        localIntent.putExtra("key_finder_object_Id", String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN));
        localIntent.putExtra("key_finder_object_nonce_id_key", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId);
        localIntent.putExtra("finder_read_feed_id", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN);
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdI.ZNI == 3) {
          localIntent.putExtra("follow_participant_finder_username", z.bAW());
        }
      }
    }
    for (;;)
    {
      localIntent.putExtra("key_enter_profile_type", 11);
      if (parambui != null)
      {
        parama = parambui.zIO;
        paramString = parambui.zIB;
        if (!TextUtils.isEmpty((CharSequence)parama)) {
          localIntent.putExtra("key_context_id", parama);
        }
        if (!TextUtils.isEmpty((CharSequence)paramString)) {
          localIntent.putExtra("key_click_tab_context_id", paramString);
        }
      }
      if (paramContext != null)
      {
        parama = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        s.s(parama, "service(IFinderCommonService::class.java)");
        h.a.a((com.tencent.mm.plugin.h)parama, paramContext, localIntent, 0, 124);
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(paramContext, localIntent);
      }
      AppMethodBeat.o(359386);
      return;
      localIntent.putExtra("finder_username", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      break;
      localIntent.putExtra("finder_username", paramString);
    }
  }
  
  private static final void fR(View paramView)
  {
    AppMethodBeat.i(359435);
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
      if (paramView != null) {
        paramView.setImageResource(p.g.icons_outlined_done);
      }
    }
    AppMethodBeat.o(359435);
  }
  
  private static bma gv(Context paramContext)
  {
    AppMethodBeat.i(359334);
    bma localbma = new bma();
    Object localObject;
    String str;
    int i;
    if ((paramContext instanceof AppCompatActivity))
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localbma.ZUK = ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramContext).cq(bn.class)).foz();
      str = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localbma.session_id = ((String)localObject);
      localObject = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localbma.ZUL = com.tencent.mm.plugin.finder.live.report.k.etq();
      localObject = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localObject = com.tencent.mm.plugin.finder.live.report.k.etu();
      if (localObject != null) {
        break label385;
      }
      localObject = "";
      localbma.ZUN = ((String)localObject);
      localbma.ZUM = System.currentTimeMillis();
      localObject = com.tencent.mm.ui.component.k.aeZF;
      paramContext = ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramContext).cq(bn.class)).foA();
      localObject = (CharSequence)paramContext;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label415;
      }
      i = 1;
      label176:
      if (i == 0) {
        break label420;
      }
      paramContext = com.tencent.mm.plugin.finder.live.report.k.Doi;
      paramContext = hK(com.tencent.mm.plugin.finder.live.report.k.ets(), "exposeType");
      label194:
      localbma.ZUO = paramContext;
      paramContext = com.tencent.mm.plugin.finder.live.report.k.Doi;
      if (!s.p(com.tencent.mm.plugin.finder.live.report.k.eto(), q.n.Dty.scene)) {
        break label431;
      }
      paramContext = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
      if (!s.p(com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a.dLz(), "111")) {
        break label431;
      }
      paramContext = q.n.Dtz.scene;
      label242:
      localObject = j.Dob;
      localObject = j.Dob;
      localbma.ZUR = com.tencent.mm.plugin.finder.live.report.q.aB(paramContext, j.Doc.Dqh.type);
      localObject = com.tencent.mm.plugin.finder.live.report.k.Doi;
      localbma.ZUQ = hK(com.tencent.mm.plugin.finder.live.report.k.ets(), "enter_immerse_type");
      localbma.ZUS = paramContext;
    }
    for (;;)
    {
      try
      {
        if (kotlin.n.n.a((CharSequence)paramContext, "temp_", 0, false, 6) != -1) {
          continue;
        }
        l = 0L;
        localbma.ZUP = l;
      }
      catch (Exception paramContext)
      {
        long l;
        label385:
        label415:
        label420:
        label431:
        Log.e("FinderLiveAssistant2", s.X("genLiveReportObj err:", paramContext.getMessage()));
        continue;
      }
      Log.i("FinderLiveAssistant2", "enter_icon_type :" + localbma.ZUR + " chnl_enter_immerse_type: " + localbma.ZUQ + " chnl_expose_type: " + localbma.ZUO);
      AppMethodBeat.o(359334);
      return localbma;
      str = kotlin.n.n.m((String)localObject, ",", ";", false);
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      i = 0;
      break label176;
      paramContext = hK(paramContext, "exposeType");
      break label194;
      paramContext = com.tencent.mm.plugin.finder.live.report.k.Doi;
      paramContext = com.tencent.mm.plugin.finder.live.report.k.eto();
      break label242;
      l = Long.parseLong(kotlin.n.n.m(paramContext, "temp_", "", false));
    }
  }
  
  private static String hK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(359343);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)paramString2).length() != 0) {
          break label62;
        }
      }
    }
    label62:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label67;
      }
      AppMethodBeat.o(359343);
      return "";
      i = 0;
      break;
    }
    label67:
    localObject = "";
    try
    {
      paramString1 = new JSONObject(kotlin.n.n.m(paramString1, ";", ",", false)).get(paramString2).toString();
      AppMethodBeat.o(359343);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.i("FinderLiveAssistant2", String.valueOf(paramString1.getMessage()));
        paramString1 = (String)localObject;
      }
    }
  }
  
  public final Object a(long paramLong1, String paramString1, long paramLong2, int paramInt, String paramString2, String paramString3, kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(359502);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject1;; paramd = new b(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString1 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(359502);
        throw paramString1;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = new LinkedList();
    Object localObject2 = new brr();
    ((brr)localObject2).object_id = paramLong1;
    ((brr)localObject2).object_nonce_id = paramString1;
    ((brr)localObject2).mMJ = paramLong2;
    paramString1 = ah.aiuX;
    ((LinkedList)localObject1).add(localObject2);
    paramString1 = ah.aiuX;
    localObject2 = (List)localObject1;
    paramd.Yx = paramLong1;
    paramd.label = 1;
    paramString1 = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    localObject1 = (kotlin.d.d)paramString1;
    paramString2 = new com.tencent.mm.plugin.finder.cgi.g((List)localObject2, paramInt, 0, 0, paramString2, paramString3);
    paramString2.HcI = false;
    paramString2.bFJ().g((com.tencent.mm.vending.c.a)new g.a((kotlin.d.d)localObject1));
    paramString2 = paramString1.kli();
    if (paramString2 == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    paramString1 = paramString2;
    if (paramString2 == locala)
    {
      AppMethodBeat.o(359502);
      return locala;
      paramLong1 = paramd.Yx;
      ResultKt.throwOnFailure(localObject1);
      paramString1 = (String)localObject1;
    }
    paramString1 = (aub)paramString1;
    if (paramString1 == null)
    {
      paramString1 = null;
      paramString3 = new StringBuilder();
      if (paramString1 == null) {
        break label488;
      }
      paramString2 = (Iterable)paramString1;
      paramInt = 0;
      paramd = paramString2.iterator();
      label365:
      if (!paramd.hasNext()) {
        break label488;
      }
      paramString2 = paramd.next();
      if (paramInt < 0) {
        p.kkW();
      }
      paramString2 = (bqy)paramString2;
      localObject1 = new StringBuilder("[index:").append(paramInt).append(",purchaseLiveValid:");
      paramString2 = paramString2.ZYZ;
      if (paramString2 != null) {
        break label475;
      }
    }
    label475:
    for (paramString2 = null;; paramString2 = Boolean.valueOf(paramString2.aabq))
    {
      paramString3.append(paramString2 + ']');
      paramInt += 1;
      break label365;
      paramString1 = paramString1.ZEz;
      break;
    }
    label488:
    Log.i("FinderLiveAssistant2", s.X("purchaseLiveValid list:", paramString3));
    boolean bool;
    if (paramString1 == null) {
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(359502);
      return Boolean.valueOf(bool);
      paramString2 = ((Iterable)paramString1).iterator();
      label531:
      if (paramString2.hasNext())
      {
        paramString1 = paramString2.next();
        if (((bqy)paramString1).object_id == paramLong1)
        {
          paramInt = 1;
          label564:
          if (paramInt == 0) {
            break label588;
          }
        }
      }
      for (;;)
      {
        paramString1 = (bqy)paramString1;
        if (paramString1 != null) {
          break label595;
        }
        bool = false;
        break;
        paramInt = 0;
        break label564;
        label588:
        break label531;
        paramString1 = null;
      }
      label595:
      paramString1 = paramString1.ZYZ;
      if (paramString1 == null) {
        bool = false;
      } else {
        bool = paramString1.aabq;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    long Yx;
    int label;
    
    b(g paramg, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(360035);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.CEO.a(0L, null, 0L, 0, null, null, (kotlin.d.d)this);
      AppMethodBeat.o(360035);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant2$doConsume$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ar.a
  {
    c(int paramInt1, ax.a parama, String paramString1, Context paramContext, String paramString2, int paramInt2, String paramString3) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bmf parambmf)
    {
      AppMethodBeat.i(360043);
      s.u(parambmf, "resp");
      Log.i("FinderLiveAssistant2", "doPostGift errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString + ", bill_no:" + parambmf.YzL);
      Object localObject = bd.Gli;
      bd.Ux(this.CEt);
      if ((paramInt2 != 0) && (paramInt2 != -200042))
      {
        parambmf = parama1;
        if (parambmf != null) {
          ax.a.a.a(parambmf, false, paramInt2, ax.a.b.DcD, null, null, 0, null, paramString, 16);
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(22129, new Object[] { Integer.valueOf(1), this.CEv, "", Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(paramInt2), paramString });
        paramString = bd.Gli;
        bd.fic();
        AppMethodBeat.o(360043);
        return;
      }
      localObject = paramContext;
      paramInt1 = this.CEP;
      String str = this.CEv;
      paramString = parambmf.ZUX;
      if (paramString == null) {}
      for (paramString = null;; paramString = paramString.toByteArray())
      {
        g.a((Context)localObject, paramInt1, str, paramString, (i)new a(parama1, this.CEx, this.CEy, paramString1));
        AppMethodBeat.o(360043);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant2$doConsume$1$onCgiBack$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "msg", "", "onSuccess", "data", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements i<Long>
    {
      a(ax.a parama, String paramString1, int paramInt, String paramString2) {}
      
      public final void s(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(359744);
        Log.i("FinderLiveAssistant2", "[WeCoin] consumeImpl onFailed errorType:" + paramInt1 + ",errorCode:" + paramInt2 + ",msg:" + paramString);
        paramString = this.CEu;
        if (paramString != null) {
          ax.a.a.a(paramString, false, paramInt2, ax.a.b.DcE, this.CEx, null, this.CEy, this.Cwa, null, 144);
        }
        paramString = bd.Gli;
        bd.fid();
        AppMethodBeat.o(359744);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant2$getShopShelf$2$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements af.a
  {
    d(com.tencent.mm.plugin.finder.live.model.context.a parama, kotlin.d.d<? super bih> paramd) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, bih parambih)
    {
      boolean bool = true;
      AppMethodBeat.i(360040);
      s.u(parambih, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject = this.CEQ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
        paramString = this.xFy;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).aNm();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).EhX = true;
        if (parambih.ZRy > 0)
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eik = bool;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eil = parambih.ZRx;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eid = parambih.ZRt;
          if (paramString != null) {
            break label235;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).c(parambih);
          label103:
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).a(parambih.ZRv);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eio = parambih.ZRw;
          localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CEQ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          paramString = parambih.YJa;
          if (paramString != null) {
            break label251;
          }
        }
        label235:
        label251:
        for (paramString = null;; paramString = paramString.Op)
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).mZp = paramString;
          Log.i("FinderLiveAssistant2", s.X("mergeProducts, resp list size:", Integer.valueOf(parambih.ZgM.size())));
          paramString = parambih.ZRn;
          if (paramString != null) {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CEQ.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).ayl(paramString);
          }
          paramString = locald;
          localObject = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(parambih));
          AppMethodBeat.o(360040);
          return;
          bool = false;
          break;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).d(parambih);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eim = paramString;
          break label103;
        }
      }
      paramString = locald;
      parambih = Result.Companion;
      paramString.resumeWith(Result.constructor-impl(null));
      AppMethodBeat.o(360040);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant2$showRechargeFoodsDialog$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Ljava/lang/Void;", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements i<Void>
  {
    f(FragmentActivity paramFragmentActivity, kotlin.g.a.b<? super Boolean, ah> paramb) {}
    
    private static final void a(kotlin.g.a.b paramb, com.tencent.mm.plugin.wallet.wecoin.a.c paramc)
    {
      AppMethodBeat.i(360087);
      s.u(paramb, "$callback");
      paramb.invoke(Boolean.TRUE);
      AppMethodBeat.o(360087);
    }
    
    public final void s(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(360104);
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(360104);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.g
 * JD-Core Version:    0.7.0.1
 */