package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.d.a.a.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.u;
import com.tencent.mm.plugin.finder.cgi.u.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cf.a;
import com.tencent.mm.plugin.g;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import kotlin.Metadata;
import kotlin.g.b.ah.f;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLiveForMiniAppLauncher;", "", "()V", "FINDER_LIVE_NOTICE_UNRESERVE", "", "getFINDER_LIVE_NOTICE_UNRESERVE", "()I", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getDialog", "()Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "setDialog", "(Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;)V", "stateCode", "getStateCode", "setStateCode", "(I)V", "launchDialog", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "jsonStr", "", "successCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failCallback", "refreshContentView", "rootViewContainer", "Landroid/view/View;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveNoticeResponse;", "wxData", "report21158", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorNoticeAction;", "anchorUserName", "liveId", "", "sceneNote", "showHalfDialog", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac AWK;
  private static com.tencent.mm.ui.widget.a.f AWL;
  private static final int AWM;
  private static int AWN;
  
  static
  {
    AppMethodBeat.i(363308);
    AWK = new ac();
    AWM = 1;
    AppMethodBeat.o(363308);
  }
  
  private static final void a(final int paramInt, final ac paramac, azt paramazt, String paramString, final MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(363277);
    kotlin.g.b.s.u(paramac, "$this_run");
    kotlin.g.b.s.u(paramazt, "$resp");
    kotlin.g.b.s.u(paramString, "$wxData");
    kotlin.g.b.s.u(paramMMActivity, "$activity");
    paramView = new ah.f();
    b localb = new b(paramView, paramInt, paramMMActivity, paramac);
    if (paramInt == 1)
    {
      a(paramView, paramMMActivity, localb, paramazt, paramInt);
      paramView = q.cg.DFs;
      paramac = paramazt.ZKt;
      if (paramac == null)
      {
        paramac = "";
        paramazt = paramazt.ZKs;
        if (paramazt != null) {
          break label139;
        }
      }
      label139:
      for (long l = 0L;; l = paramazt.mMJ)
      {
        a(paramView, paramac, l, paramString);
        AWN = 6;
        AppMethodBeat.o(363277);
        return;
        paramMMActivity = paramac.username;
        paramac = paramMMActivity;
        if (paramMMActivity != null) {
          break;
        }
        paramac = "";
        break;
      }
    }
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)paramMMActivity.getContext(), 1, true);
    localf.Vtg = new ac..ExternalSyntheticLambda4(paramac, paramMMActivity);
    localf.GAC = new ac..ExternalSyntheticLambda6(paramac, paramazt, paramString, paramView, paramMMActivity, localb, paramInt);
    localf.dDn();
    AppMethodBeat.o(363277);
  }
  
  private static final void a(View paramView1, View paramView2, TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(363247);
    if (paramBoolean)
    {
      paramView1.setBackground(paramView2.getContext().getResources().getDrawable(e.d.btn_solid_gold_red));
      paramTextView.setTextColor(paramView2.getContext().getResources().getColor(e.b.White));
      AppMethodBeat.o(363247);
      return;
    }
    paramView1.setBackground(paramView2.getContext().getResources().getDrawable(e.d.finder_live_notice_unable_btn_shape));
    paramTextView.setTextColor(paramView2.getContext().getResources().getColor(e.b.BW_0_Alpha_0_3));
    AppMethodBeat.o(363247);
  }
  
  private static final void a(ac paramac, azt paramazt, String paramString, ah.f paramf, MMActivity paramMMActivity, b paramb, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(363270);
    kotlin.g.b.s.u(paramac, "$this_run");
    kotlin.g.b.s.u(paramazt, "$resp");
    kotlin.g.b.s.u(paramString, "$wxData");
    kotlin.g.b.s.u(paramf, "$progressDialog");
    kotlin.g.b.s.u(paramMMActivity, "$activity");
    kotlin.g.b.s.u(paramb, "$onSceneEnd");
    if (paramMenuItem.getItemId() == AWM)
    {
      a(paramf, paramMMActivity, paramb, paramazt, paramInt1);
      AWN = 7;
      paramMMActivity = q.cg.DFt;
      paramac = paramazt.ZKt;
      if (paramac != null) {
        break label120;
      }
      paramac = "";
      paramazt = paramazt.ZKs;
      if (paramazt != null) {
        break label137;
      }
    }
    label137:
    for (long l = 0L;; l = paramazt.mMJ)
    {
      a(paramMMActivity, paramac, l, paramString);
      AppMethodBeat.o(363270);
      return;
      label120:
      paramf = paramac.username;
      paramac = paramf;
      if (paramf != null) {
        break;
      }
      paramac = "";
      break;
    }
  }
  
  private static final void a(ac paramac, MMActivity paramMMActivity, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(363261);
    kotlin.g.b.s.u(paramac, "$this_run");
    kotlin.g.b.s.u(paramMMActivity, "$activity");
    if (params.jmw()) {
      params.a(AWM, paramMMActivity.getContext().getResources().getColor(e.b.Red), (CharSequence)paramMMActivity.getContext().getResources().getString(e.h.finder_live_notice_unreserve));
    }
    AppMethodBeat.o(363261);
  }
  
  private static void a(q.cg paramcg, String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(363199);
    String str = q.n.DtE.scene;
    com.tencent.mm.plugin.expt.hellhound.a.aqz(str);
    com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).genContextId(15, 2, 65));
    ((cf)com.tencent.mm.kernel.h.ax(cf.class)).axt(paramString2);
    paramString2 = com.tencent.mm.kernel.h.ax(cf.class);
    kotlin.g.b.s.s(paramString2, "service(IHellLiveVisitorReoprter::class.java)");
    cf.a.a((cf)paramString2, paramcg, paramString1, paramLong, str, "", Long.valueOf(0L), "", "", null, null, 1536);
    AppMethodBeat.o(363199);
  }
  
  private static final void a(ca.a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(363205);
    kotlin.g.b.s.u(parama, "$successCallback");
    parama.onCallback(Integer.valueOf(9));
    AppMethodBeat.o(363205);
  }
  
  private static final void a(ca.a parama1, ca.a parama2)
  {
    AppMethodBeat.i(363226);
    kotlin.g.b.s.u(parama1, "$failCallback");
    kotlin.g.b.s.u(parama2, "$successCallback");
    if (AWN == 0) {
      parama1.onCallback(Integer.valueOf(AWN));
    }
    for (;;)
    {
      AWL = null;
      AppMethodBeat.o(363226);
      return;
      parama2.onCallback(Integer.valueOf(AWN));
    }
  }
  
  private static final void a(azt paramazt, String paramString)
  {
    AppMethodBeat.i(363241);
    kotlin.g.b.s.u(paramazt, "$resp");
    kotlin.g.b.s.u(paramString, "$wxData");
    q.cg localcg = q.cg.DFr;
    paramazt = paramazt.ZKt;
    if (paramazt == null) {
      paramazt = "";
    }
    for (;;)
    {
      a(localcg, paramazt, 0L, paramString);
      AppMethodBeat.o(363241);
      return;
      String str = paramazt.username;
      paramazt = str;
      if (str == null) {
        paramazt = "";
      }
    }
  }
  
  public static void a(final MMActivity paramMMActivity, String paramString, final ca.a<Integer> parama1, final ca.a<Integer> parama2)
  {
    AppMethodBeat.i(363187);
    kotlin.g.b.s.u(paramMMActivity, "activity");
    kotlin.g.b.s.u(paramString, "jsonStr");
    kotlin.g.b.s.u(parama1, "successCallback");
    kotlin.g.b.s.u(parama2, "failCallback");
    Object localObject = new i(paramString);
    paramString = ((i)localObject).optString("appId");
    String str = ((i)localObject).optString("noticeId");
    localObject = ((i)localObject).optString("wxData");
    w localw = w.a((Context)paramMMActivity.getContext(), (CharSequence)paramMMActivity.getContext().getString(e.h.app_waiting), true, 3, new ac..ExternalSyntheticLambda0(parama1));
    kotlin.g.b.s.s(str, "noticeId");
    kotlin.g.b.s.s(paramString, "appId");
    new u(str, paramString, null, 0, (u.a)new a(localw, paramMMActivity, (String)localObject, parama1, parama2), 0, 108).bFJ().a((com.tencent.mm.vending.e.b)paramMMActivity);
    AppMethodBeat.o(363187);
  }
  
  private static final void a(RoundedCornerFrameLayout paramRoundedCornerFrameLayout, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(363232);
    kotlin.g.b.s.u(paramRoundedCornerFrameLayout, "$rootViewContainer");
    params.clear();
    params = AWL;
    if (params != null) {
      params.setFooterView(null);
    }
    params = AWL;
    if (params != null) {
      params.setFooterView((View)paramRoundedCornerFrameLayout);
    }
    AppMethodBeat.o(363232);
  }
  
  private static final void a(ah.f<w> paramf, MMActivity paramMMActivity, b paramb, azt paramazt, int paramInt)
  {
    AppMethodBeat.i(363257);
    paramf.aqH = w.a((Context)paramMMActivity.getContext(), (CharSequence)paramMMActivity.getContext().getString(e.h.app_waiting), true, 3, null);
    com.tencent.mm.kernel.h.aZW().a(6276, (com.tencent.mm.am.h)paramb);
    paramf = com.tencent.mm.kernel.h.ax(g.class);
    kotlin.g.b.s.s(paramf, "service(IFinderCommonLiveService::class.java)");
    paramb = (g)paramf;
    paramf = paramazt.ZKt;
    if (paramf == null)
    {
      paramf = "";
      paramMMActivity = paramazt.live_notice_info;
      if (paramMMActivity != null) {
        break label145;
      }
    }
    label145:
    for (paramMMActivity = null;; paramMMActivity = paramMMActivity.hAR)
    {
      kotlin.g.b.s.checkNotNull(paramMMActivity);
      kotlin.g.b.s.s(paramMMActivity, "resp.live_notice_info?.noticeId!!");
      paramf = com.tencent.mm.plugin.g.a.a(paramb, paramf, paramMMActivity, paramInt, null);
      com.tencent.mm.kernel.h.aZW().a(paramf, 0);
      AppMethodBeat.o(363257);
      return;
      paramMMActivity = paramf.username;
      paramf = paramMMActivity;
      if (paramMMActivity != null) {
        break;
      }
      paramf = "";
      break;
    }
  }
  
  public static com.tencent.mm.ui.widget.a.f ecr()
  {
    return AWL;
  }
  
  public static void ecs()
  {
    AWN = 0;
  }
  
  private static final void fy(View paramView)
  {
    AppMethodBeat.i(363213);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderLiveForMiniAppLauncher", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramView = AWL;
    if (paramView != null) {
      paramView.cyW();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderLiveForMiniAppLauncher", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(363213);
  }
  
  private static final void fz(View paramView)
  {
    AppMethodBeat.i(363219);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderLiveForMiniAppLauncher", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramView = AWL;
    if (paramView != null) {
      paramView.cyW();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderLiveForMiniAppLauncher", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(363219);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderLiveForMiniAppLauncher$launchDialog$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetLiveNotice$Callback;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveNoticeResponse;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements u.a
  {
    a(w paramw, MMActivity paramMMActivity, String paramString, ca.a<Integer> parama1, ca.a<Integer> parama2) {}
    
    private static final void a(azt paramazt, ca.a parama, MMActivity paramMMActivity, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(362503);
      kotlin.g.b.s.u(paramazt, "$resp");
      kotlin.g.b.s.u(parama, "$successCallback");
      kotlin.g.b.s.u(paramMMActivity, "$activity");
      if (paramBoolean)
      {
        paramString = new Intent();
        ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().axz("temp_13");
        String str = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).genContextId(15, 2, 65);
        paramazt = paramazt.ZKs;
        if (paramazt != null)
        {
          Object localObject = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
          kotlin.g.b.s.s(localObject, "plugin(IPluginFinderLive::class.java)");
          localObject = (com.tencent.d.a.a.a.b)localObject;
          Context localContext = (Context)paramMMActivity.getContext();
          long l1 = paramazt.object_id;
          long l2 = paramazt.mMJ;
          paramMMActivity = paramazt.object_nonce_id;
          paramazt = paramMMActivity;
          if (paramMMActivity == null) {
            paramazt = "";
          }
          b.b.a((com.tencent.d.a.a.a.b)localObject, paramString, localContext, l1, Long.valueOf(l2), "", paramazt, "", str, "", "", "", 0);
        }
        parama.onCallback(Integer.valueOf(2));
        AppMethodBeat.o(362503);
        return;
      }
      parama.onCallback(Integer.valueOf(1));
      AppMethodBeat.o(362503);
    }
    
    public final void a(int paramInt1, int paramInt2, azt paramazt)
    {
      AppMethodBeat.i(362518);
      kotlin.g.b.s.u(paramazt, "resp");
      if (this.yjx.isShowing()) {
        this.yjx.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject1 = paramazt.ZKs;
        Context localContext;
        if ((localObject1 != null) && (((bmy)localObject1).ZVE == 1))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label191;
          }
          localObject2 = new com.tencent.mm.ui.widget.a.g.a((Context)paramMMActivity);
          localObject3 = paramMMActivity.getContext();
          paramInt1 = e.h.finder_live_reserve_dialog_content;
          localContext = (Context)paramMMActivity.getContext();
          localObject1 = paramazt.ZKt;
          if (localObject1 != null) {
            break label181;
          }
        }
        label181:
        for (localObject1 = null;; localObject1 = ((FinderContact)localObject1).nickname)
        {
          ((com.tencent.mm.ui.widget.a.g.a)localObject2).bDE(((AppCompatActivity)localObject3).getString(paramInt1, new Object[] { com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)localObject1) }));
          ((com.tencent.mm.ui.widget.a.g.a)localObject2).c(new ac.a..ExternalSyntheticLambda0(paramazt, parama1, paramMMActivity)).show();
          AppMethodBeat.o(362518);
          return;
          paramInt1 = 0;
          break;
        }
        label191:
        localObject1 = ac.AWK;
        Object localObject2 = paramMMActivity;
        Object localObject3 = this.AWO;
        kotlin.g.b.s.s(localObject3, "wxData");
        ac.a((ac)localObject1, (MMActivity)localObject2, (String)localObject3, paramazt, parama1, parama2);
        AppMethodBeat.o(362518);
        return;
      }
      parama2.onCallback(Integer.valueOf(paramInt2));
      AppMethodBeat.o(362518);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderLiveForMiniAppLauncher$refreshContentView$6$refreshReserveBtn$1$onSceneEnd$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.am.h
  {
    b(ah.f<w> paramf, int paramInt, MMActivity paramMMActivity, ac paramac) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(362501);
      com.tencent.mm.kernel.h.aZW().b(6276, (com.tencent.mm.am.h)this);
      paramString = (w)this.AWR.aqH;
      int i;
      if ((paramString != null) && (paramString.isShowing() == true))
      {
        i = 1;
        if (i != 0)
        {
          paramString = (w)this.AWR.aqH;
          if (paramString != null) {
            paramString.dismiss();
          }
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label159;
        }
        if (paramInt != 1) {
          break label142;
        }
        paramString = paramMMActivity.getContext().getString(e.h.finder_live_reserved_toast);
        label98:
        kotlin.g.b.s.s(paramString, "if(op == ConstantsFinder…                        }");
        aa.showTextToast((Context)paramMMActivity.getContext(), paramString);
      }
      for (;;)
      {
        paramString = ac.ecr();
        if (paramString != null) {
          paramString.cyW();
        }
        AppMethodBeat.o(362501);
        return;
        i = 0;
        break;
        label142:
        paramString = paramMMActivity.getContext().getString(e.h.finder_live_reserve_cancel_toast);
        break label98;
        label159:
        ac.ecs();
        aa.showTextToast((Context)paramMMActivity.getContext(), paramMMActivity.getContext().getString(e.h.finder_live_miniapp_reserve_fail_toast));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ac
 * JD-Core Version:    0.7.0.1
 */