package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.d.a.a.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.cgi.bp;
import com.tencent.mm.plugin.finder.feed.model.j;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.sidebar.c;
import com.tencent.mm.plugin.finder.live.util.g;
import com.tencent.mm.plugin.finder.live.view.FinderLiveFoldTextView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.i;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cf.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.bg;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "anchorAuthIcon", "Landroid/widget/ImageView;", "anchorExtAuthTv", "Landroid/widget/TextView;", "anchorExtFriendFollowCountTv", "anchorExtInfoLayout", "Landroid/widget/LinearLayout;", "anchorName", "anchorProfile", "avatar", "backBtn", "bgView", "desc", "hasUpdateNextLiveInfo", "", "loadingProgressBar", "Landroid/widget/ProgressBar;", "needAnimation", "getNeedAnimation", "()Z", "setNeedAnimation", "(Z)V", "nextLiveView", "Landroid/view/View;", "okBtn", "Landroid/widget/Button;", "rootContent", "Landroid/widget/RelativeLayout;", "title", "canClearScreenWhenSideBarShow", "checkNextLiveInfo", "", "fillAnchorInfo", "authProfession", "", "friendFollowCount", "", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "resume", "setVisible", "visible", "show", "stop", "updateBg", "bgUrl", "contactUsername", "updateDesc", "updateFinishInfo", "updateNextLiveInfo", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "nextLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ch
  extends b
{
  private static final ch.a Dlh;
  private final TextView Dli;
  private final TextView Dlj;
  private final LinearLayout Dlk;
  private final TextView Dll;
  private final TextView Dlm;
  private final ImageView Dln;
  private final View Dlo;
  public final ProgressBar Dlp;
  private boolean Dlq;
  public boolean Dlr;
  private final ImageView Esh;
  private final ImageView avatar;
  private final TextView mll;
  private final ImageView nfU;
  public final RelativeLayout ngh;
  private final com.tencent.mm.live.b.b ngl;
  private final Button nhC;
  private final TextView pmf;
  
  static
  {
    AppMethodBeat.i(354427);
    Dlh = new ch.a((byte)0);
    AppMethodBeat.o(354427);
  }
  
  public ch(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354256);
    this.ngl = paramb;
    paramb = paramViewGroup.findViewById(p.e.title);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.title)");
    this.mll = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.desc);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.desc)");
    this.pmf = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.AqO);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.anchor_avatar)");
    this.avatar = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BBz);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.anchor_name)");
    this.Dli = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.AqX);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.visit_anchor_profile)");
    this.Dlj = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BWm);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_finish_btn)");
    this.nhC = ((Button)paramb);
    paramb = paramViewGroup.findViewById(p.e.live_after_ui_root_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.ngh = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(p.e.AqR);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.anchor_ext_info_layout)");
    this.Dlk = ((LinearLayout)paramb);
    paramb = paramViewGroup.findViewById(p.e.AqP);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.anchor_ext_info_auth)");
    this.Dll = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.AqQ);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.a…_info_friend_floow_count)");
    this.Dlm = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BBy);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.anchor_auth_icon)");
    this.Dln = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BBL);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.back_icon)");
    this.nfU = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(p.e.finder_live_notice_info_layout);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…_live_notice_info_layout)");
    this.Dlo = paramb;
    paramb = paramViewGroup.findViewById(p.e.VIt);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_ui_bg_view)");
    this.Esh = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(p.e.loading_bar);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.loading_bar)");
    this.Dlp = ((ProgressBar)paramb);
    this.Dlr = true;
    this.nhC.setOnClickListener(new ch..ExternalSyntheticLambda2(this));
    this.Dlj.setOnClickListener(new ch..ExternalSyntheticLambda4(this, paramViewGroup));
    paramb = this.mll;
    if (paramb == null) {}
    for (paramb = null; paramb == null; paramb = paramb.getLayoutParams())
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(354256);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.topMargin += bf.getStatusBarHeight(MMApplicationContext.getContext());
    paramb = this.nhC;
    if (paramb == null) {}
    for (paramb = null; paramb == null; paramb = paramb.getLayoutParams())
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(354256);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.bottomMargin += bf.bk(MMApplicationContext.getContext());
    com.tencent.mm.ui.aw.a((Paint)this.mll.getPaint(), 0.8F);
    com.tencent.mm.ui.aw.a((Paint)this.Dli.getPaint(), 0.8F);
    com.tencent.mm.ui.aw.a((Paint)this.nhC.getPaint(), 0.8F);
    this.ngh.setVisibility(8);
    this.Dlp.setVisibility(8);
    this.nfU.setImageDrawable(bb.m(paramViewGroup.getContext(), p.g.icons_filled_back, -1));
    this.nfU.setOnClickListener(new ch..ExternalSyntheticLambda1(this));
    paramViewGroup.setTranslationX(bf.bf(paramViewGroup.getContext()).x);
    AppMethodBeat.o(354256);
  }
  
  private static final void a(ch paramch)
  {
    AppMethodBeat.i(354401);
    kotlin.g.b.s.u(paramch, "this$0");
    paramch.tO(0);
    AppMethodBeat.o(354401);
  }
  
  private static final void a(ch paramch, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(354385);
    kotlin.g.b.s.u(paramch, "this$0");
    paramch = paramch.Dlo;
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramch = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(354385);
      throw paramch;
    }
    paramch.setAlpha(((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(354385);
  }
  
  private static final void a(ch paramch, View paramView)
  {
    AppMethodBeat.i(354274);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramch);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramch, "this$0");
    paramch.ngl.statusChange(b.c.ncl, null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354274);
  }
  
  private static final void a(ch paramch, View paramView1, View paramView2)
  {
    AppMethodBeat.i(354411);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramch);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramch, "this$0");
    kotlin.g.b.s.u(paramView1, "$maskView");
    paramView2 = com.tencent.mm.ui.component.k.aeZF;
    paramView2 = paramch.mJe.getContext();
    kotlin.g.b.s.s(paramView2, "root.context");
    paramView2 = ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramView2).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE;
    if (paramView2 != null) {
      paramView2.hide();
    }
    paramView2 = com.tencent.mm.ui.component.k.aeZF;
    paramch = paramch.mJe.getContext();
    kotlin.g.b.s.s(paramch, "root.context");
    ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq(paramch).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGH.DGN = 3;
    paramView1.setVisibility(8);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354411);
  }
  
  private static final void a(ch paramch, ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(354286);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramch);
    localb.cH(paramViewGroup);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramch, "this$0");
    kotlin.g.b.s.u(paramViewGroup, "$root");
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramch.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).Ecg)
    {
      paramView = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramch.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).hUQ;
      paramViewGroup = paramViewGroup.getContext();
      kotlin.g.b.s.s(paramViewGroup, "root.context");
      com.tencent.mm.plugin.finder.utils.aw.a(paramView, paramViewGroup, ((e)paramch.business(e.class)).sessionId, String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramch.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), 3);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354286);
      return;
      paramch = ((e)paramch.business(e.class)).mIC;
      paramView = new Intent();
      paramView.putExtra("finder_username", paramch);
      paramView.putExtra("key_enter_profile_type", 11);
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(paramViewGroup.getContext(), paramView);
    }
  }
  
  private static final void a(ch paramch, bkk parambkk, FinderObject paramFinderObject, ah.f paramf, View paramView)
  {
    AppMethodBeat.i(354377);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramch);
    localb.cH(parambkk);
    localb.cH(paramFinderObject);
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramch, "this$0");
    kotlin.g.b.s.u(parambkk, "$liveNoticeInfo");
    kotlin.g.b.s.u(paramf, "$confirmBtn");
    paramView = ((e)paramch.business(e.class)).mIC;
    long l;
    if (parambkk.status == 1)
    {
      parambkk.status = 0;
      localObject = aa.makeText(paramch.mJe.getContext(), (CharSequence)paramch.mJe.getContext().getString(p.h.finder_live_notice_edu_toast_tips), 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
      a(paramView, paramch, parambkk, paramf, parambkk, 1);
      paramf = (cf)com.tencent.mm.plugin.finder.live.report.k.Doi;
      localObject = q.cg.DFs;
      if (paramFinderObject == null)
      {
        l = 0L;
        paramFinderObject = q.n.DtL.scene;
        parambkk = parambkk.YSR;
        paramch = parambkk;
        if (parambkk == null) {
          paramch = "";
        }
        cf.a.a(paramf, (q.cg)localObject, paramView, l, paramFinderObject, null, null, null, null, paramch, null, 1504);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354377);
      return;
      paramch = paramFinderObject.liveInfo;
      if (paramch == null)
      {
        l = 0L;
        break;
      }
      l = paramch.liveId;
      break;
      localObject = new com.tencent.mm.ui.widget.a.f(paramch.mJe.getContext(), 1, true);
      ((com.tencent.mm.ui.widget.a.f)localObject).NE(true);
      ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new ch..ExternalSyntheticLambda8(paramch);
      ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new ch..ExternalSyntheticLambda9(parambkk, paramView, paramFinderObject, paramch, paramf);
      ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
    }
  }
  
  private static final void a(ch paramch, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(354341);
    kotlin.g.b.s.u(paramch, "this$0");
    if (params.jmw()) {
      params.a(4, paramch.mJe.getContext().getResources().getColor(p.b.Red), (CharSequence)paramch.mJe.getContext().getResources().getString(p.h.finder_live_notice_unreserve));
    }
    AppMethodBeat.o(354341);
  }
  
  private static final void a(FinderObject paramFinderObject, ch paramch, View paramView)
  {
    AppMethodBeat.i(354308);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderObject);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramch);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderObject, "$feed");
    kotlin.g.b.s.u(paramch, "this$0");
    Intent localIntent = new Intent();
    paramView = paramFinderObject.liveInfo;
    int i;
    label120:
    Context localContext;
    label136:
    long l;
    if (paramView == null)
    {
      i = 0;
      if (com.tencent.mm.ae.d.ee(i, 64))
      {
        paramView = paramFinderObject.liveInfo;
        if (paramView != null) {
          break label343;
        }
        paramView = "";
        localObject1 = paramFinderObject.liveInfo;
        if (localObject1 != null) {
          break label380;
        }
        localObject1 = "";
        localIntent.putExtra("key_enter_live_param_bind_type", 4);
        localIntent.putExtra("key_enter_live_param_by_biz_username", paramView);
        localIntent.putExtra("key_enter_live_param_by_biz_nickname", (String)localObject1);
      }
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(com.tencent.mm.plugin.expt.hellhound.core.b.bys());
      com.tencent.mm.plugin.expt.hellhound.a.aqz(q.n.DtL.scene);
      paramView = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
      kotlin.g.b.s.s(paramView, "plugin(IPluginFinderLive::class.java)");
      localObject2 = (com.tencent.d.a.a.a.b)paramView;
      localContext = paramch.mJe.getContext();
      l = paramFinderObject.id;
      paramch = paramFinderObject.liveInfo;
      if (paramch != null) {
        break label424;
      }
    }
    label424:
    for (paramch = null;; paramch = Long.valueOf(paramch.liveId))
    {
      localObject1 = paramFinderObject.username;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      localObject1 = paramFinderObject.objectNonceId;
      paramFinderObject = (FinderObject)localObject1;
      if (localObject1 == null) {
        paramFinderObject = "";
      }
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      kotlin.g.b.s.s(localObject1, "getFinderContextId()");
      b.b.a((com.tencent.d.a.a.a.b)localObject2, localIntent, localContext, l, paramch, paramView, paramFinderObject, "", (String)localObject1, "", "", "", 0);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354308);
      return;
      i = paramView.live_flag;
      break;
      label343:
      paramView = paramView.ZSj;
      if (paramView == null)
      {
        paramView = "";
        break label120;
      }
      localObject1 = paramView.ADE;
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break label120;
      }
      paramView = "";
      break label120;
      label380:
      localObject1 = ((bip)localObject1).ZSj;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label136;
      }
      localObject2 = ((aui)localObject1).YTl;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label136;
      }
      localObject1 = "";
      break label136;
    }
  }
  
  private static final void a(bkk parambkk, String paramString, FinderObject paramFinderObject, ch paramch, ah.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(354360);
    kotlin.g.b.s.u(parambkk, "$liveNoticeInfo");
    kotlin.g.b.s.u(paramString, "$anchorUserNameStr");
    kotlin.g.b.s.u(paramch, "this$0");
    kotlin.g.b.s.u(paramf, "$confirmBtn");
    cf localcf;
    q.cg localcg;
    long l;
    if (paramMenuItem.getItemId() == 4)
    {
      parambkk.status = 1;
      localcf = (cf)com.tencent.mm.plugin.finder.live.report.k.Doi;
      localcg = q.cg.DFt;
      if (paramFinderObject != null) {
        break label161;
      }
      l = 0L;
    }
    for (;;)
    {
      String str = q.n.DtL.scene;
      paramMenuItem = parambkk.YSR;
      paramFinderObject = paramMenuItem;
      if (paramMenuItem == null) {
        paramFinderObject = "";
      }
      cf.a.a(localcf, localcg, paramString, l, str, null, null, null, null, paramFinderObject, null, 1504);
      a(paramString, paramch, parambkk, paramf, parambkk, 2);
      aa.y(paramch.mJe.getContext(), paramch.mJe.getContext().getString(p.h.finder_cancel_succ), p.g.icons_filled_done);
      AppMethodBeat.o(354360);
      return;
      label161:
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject == null) {
        l = 0L;
      } else {
        l = paramFinderObject.liveId;
      }
    }
  }
  
  private static final void a(bkk parambkk, ah.f<TextView> paramf, ch paramch)
  {
    AppMethodBeat.i(354320);
    if (parambkk.status == 1)
    {
      ((TextView)paramf.aqH).setText((CharSequence)paramch.mJe.getContext().getResources().getString(p.h.finder_create_live_notice_btn_book));
      ((TextView)paramf.aqH).setTextColor(paramch.mJe.getContext().getResources().getColor(p.b.White));
      ((TextView)paramf.aqH).setBackground(paramch.mJe.getContext().getResources().getDrawable(p.d.BzN));
      AppMethodBeat.o(354320);
      return;
    }
    ((TextView)paramf.aqH).setText((CharSequence)paramch.mJe.getContext().getResources().getString(p.h.finder_create_live_notice_btn_book_cancel));
    ((TextView)paramf.aqH).setTextColor(paramch.mJe.getContext().getResources().getColor(p.b.BW_100_Alpha_0_3));
    ((TextView)paramf.aqH).setBackground(paramch.mJe.getContext().getResources().getDrawable(p.d.BzJ));
    AppMethodBeat.o(354320);
  }
  
  private static final void a(String paramString, ch paramch, bkk parambkk1, ah.f<TextView> paramf, bkk parambkk2, int paramInt)
  {
    AppMethodBeat.i(354331);
    Object localObject = j.BfL;
    localObject = j.Sv(paramString);
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = j.BfL;
        j.b(paramString, parambkk2);
      }
      localObject = parambkk2.hAR;
      kotlin.g.b.s.checkNotNull(localObject);
      kotlin.g.b.s.s(localObject, "liveNoticeInfo.noticeId!!");
      paramString = new bp(paramString, (String)localObject, paramInt, null, null, null, 48);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString, 0);
      parambkk2.status = parambkk2.status;
      a(parambkk1, paramf, paramch);
      AppMethodBeat.o(354331);
      return;
      ((bkk)localObject).status = parambkk2.status;
    }
  }
  
  private static final boolean a(ah.f paramf, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(354392);
    kotlin.g.b.s.u(paramf, "$descText");
    if (!((FinderLiveFoldTextView)paramf.aqH).DNc)
    {
      if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) {
        paramView.getParent().requestDisallowInterceptTouchEvent(true);
      }
      if (paramMotionEvent.getAction() == 1) {
        paramView.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    AppMethodBeat.o(354392);
    return false;
  }
  
  private final void ahV(final String paramString)
  {
    AppMethodBeat.i(354266);
    final ah.f localf = new ah.f();
    localf.aqH = this.Dlo.findViewById(p.e.BKl);
    View localView1 = this.Dlo.findViewById(p.e.BEY);
    kotlin.g.b.s.s(localView1, "nextLiveView.findViewByI…er_live_after_ui_desc_ll)");
    View localView2 = this.Dlo.findViewById(p.e.BKm);
    kotlin.g.b.s.s(localView2, "nextLiveView.findViewByI…finder_live_desc_text_sv)");
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localView1.setVisibility(8);
      ((FinderLiveFoldTextView)localf.aqH).setOnTouchListener(null);
      AppMethodBeat.o(354266);
      return;
    }
    localView1.setVisibility(0);
    localObject = this.Dlo.getLayoutParams();
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(354266);
      throw paramString;
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (bg.bk(this.mJe.getContext()) + this.mJe.getContext().getResources().getDimensionPixelSize(p.c.Edge_A));
    localView1.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new b(localView1, localf, this, paramString));
    localView2.setOnTouchListener(new ch..ExternalSyntheticLambda7(localf));
    AppMethodBeat.o(354266);
  }
  
  private static final void b(ch paramch, View paramView)
  {
    AppMethodBeat.i(354294);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramch);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramch, "this$0");
    paramch.ngl.statusChange(b.c.ncl, null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354294);
  }
  
  public final void a(bkk parambkk, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(354530);
    if (this.Dlq)
    {
      AppMethodBeat.o(354530);
      return;
    }
    if ((parambkk == null) && (paramFinderObject == null))
    {
      this.Dlo.setVisibility(8);
      AppMethodBeat.o(354530);
      return;
    }
    long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    Object localObject1;
    if (paramFinderObject != null)
    {
      localObject1 = paramFinderObject.liveInfo;
      if ((localObject1 == null) || (l != ((bip)localObject1).liveId)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("Finder.LiveVisitorAfterPlugin", "[updateNextLiveInfo] next live id is same to cureent id. return");
      this.Dlo.setVisibility(8);
      AppMethodBeat.o(354530);
      return;
    }
    Object localObject4 = this.Dlo.findViewById(p.e.BPq);
    View localView = this.Dlo.findViewById(p.e.BPB);
    Object localObject3 = new ah.f();
    ((ah.f)localObject3).aqH = this.Dlo.findViewById(p.e.finder_live_notice_btn);
    com.tencent.mm.ui.aw.a((Paint)((TextView)((ah.f)localObject3).aqH).getPaint(), 0.8F);
    Object localObject2;
    if (paramFinderObject == null)
    {
      localObject1 = null;
      if ((localObject1 == null) && (parambkk != null))
      {
        ((TextView)localObject4).setText((CharSequence)this.mJe.getContext().getString(p.h.CoO));
        ((TextView)localView).setVisibility(0);
        l = parambkk.startTime;
        localObject1 = (TextView)localView;
        localObject2 = this.mJe.getContext().getResources();
        i = p.h.finder_create_live_notice_time_info;
        localObject4 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        ((TextView)localObject1).setText((CharSequence)((Resources)localObject2).getString(i, new Object[] { com.tencent.mm.plugin.finder.utils.aw.a(l * 1000L, null, false, 6) }));
        localObject2 = parambkk.YSR;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ahV((String)localObject1);
        a(parambkk, (ah.f)localObject3, this);
        ((TextView)((ah.f)localObject3).aqH).setOnClickListener(new ch..ExternalSyntheticLambda5(this, parambkk, paramFinderObject, (ah.f)localObject3));
        com.tencent.mm.plugin.expt.hellhound.a.aqz(q.n.DtL.scene);
        localObject1 = (cf)com.tencent.mm.plugin.finder.live.report.k.Doi;
        localObject2 = q.cg.DFr;
        localObject3 = ((e)business(e.class)).mIC;
        if (paramFinderObject != null) {
          break label661;
        }
        l = 0L;
      }
    }
    for (;;)
    {
      localObject4 = q.n.DtL.scene;
      paramFinderObject = parambkk.YSR;
      parambkk = paramFinderObject;
      if (paramFinderObject == null) {
        parambkk = "";
      }
      cf.a.a((cf)localObject1, (q.cg)localObject2, (String)localObject3, l, (String)localObject4, null, null, null, null, parambkk, null, 1504);
      if (this.Dlo.getVisibility() == 8)
      {
        parambkk = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
        parambkk.addListener((Animator.AnimatorListener)new c(this));
        parambkk.addUpdateListener(new ch..ExternalSyntheticLambda0(this));
        parambkk.start();
      }
      AppMethodBeat.o(354530);
      return;
      ((TextView)localObject4).setText((CharSequence)this.mJe.getContext().getString(p.h.CoP));
      ((TextView)localView).setVisibility(8);
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        ahV((String)localObject1);
        ((TextView)((ah.f)localObject3).aqH).setText((CharSequence)this.mJe.getContext().getString(p.h.CoN));
        ((TextView)((ah.f)localObject3).aqH).setOnClickListener(new ch..ExternalSyntheticLambda6(paramFinderObject, this));
        localObject1 = ah.aiuX;
        break;
        localObject2 = ((FinderObjectDesc)localObject1).description;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      label661:
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject == null) {
        l = 0L;
      } else {
        l = paramFinderObject.liveId;
      }
    }
  }
  
  public final void a(String paramString, int paramInt, FinderAuthInfo paramFinderAuthInfo)
  {
    AppMethodBeat.i(354589);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).Ecg)
    {
      this.Dlj.setText((CharSequence)this.mJe.getContext().getString(p.h.Cph, new Object[] { ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).mIK }));
      if (((!Util.isNullOrNil(paramString)) || (paramInt > 0)) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).Ecg)) {
        break label168;
      }
      this.Dlk.setVisibility(8);
    }
    for (;;)
    {
      if (paramFinderAuthInfo != null)
      {
        paramString = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        kotlin.g.b.s.s(paramString, "service(IFinderCommonService::class.java)");
        h.a.a((com.tencent.mm.plugin.h)paramString, this.Dln, paramFinderAuthInfo, 0, null, 8);
      }
      AppMethodBeat.o(354589);
      return;
      this.Dlj.setText((CharSequence)this.mJe.getContext().getString(p.h.finder_live_visit_profile));
      break;
      label168:
      Log.i("Finder.LiveVisitorAfterPlugin", "authProfession:" + paramString + ", friendFollowCount:" + paramInt);
      this.Dlk.setVisibility(0);
      label267:
      String str;
      if (!Util.isNullOrNil(paramString))
      {
        paramString = this.mJe.getContext().getResources().getString(p.h.finder_contact_auth, new Object[] { paramString });
        kotlin.g.b.s.s(paramString, "root.context.resources.g…act_auth, authProfession)");
        this.Dll.setText((CharSequence)paramString);
        this.Dll.setVisibility(0);
        str = "";
        if (paramInt <= 0) {
          break label460;
        }
        str = this.mJe.getContext().getResources().getString(p.h.finder_friend_follow, new Object[] { r.TP(paramInt) });
        kotlin.g.b.s.s(str, "root.context.resources.g…umber(friendFollowCount))");
        this.Dlm.setText((CharSequence)str);
        this.Dlm.setVisibility(0);
      }
      for (;;)
      {
        paramInt = this.mJe.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = this.mJe.getContext().getResources().getDimensionPixelOffset(p.c.Edge_1_5_A);
        TextPaint localTextPaint = this.Dll.getPaint();
        if (localTextPaint.measureText(str) + localTextPaint.measureText(paramString) + i + this.mJe.getContext().getResources().getDimensionPixelOffset(p.c.Edge_3A) * 2 >= paramInt) {
          break label472;
        }
        this.Dlm.setPadding(i, 0, 0, 0);
        this.Dlk.setOrientation(0);
        break;
        this.Dll.setVisibility(8);
        paramString = "";
        break label267;
        label460:
        this.Dlm.setVisibility(8);
      }
      label472:
      this.Dlm.setPadding(0, 0, 0, 0);
      this.Dlk.setOrientation(1);
    }
  }
  
  public final boolean enH()
  {
    return false;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void esF()
  {
    AppMethodBeat.i(354555);
    Object localObject = j.BfL;
    String str = ((e)business(e.class)).mIC;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localObject = j.Sv((String)localObject);
    if (localObject != null) {
      a((bkk)localObject, null);
    }
    localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    kotlin.g.b.s.s(localObject, "service(IFinderCommonService::class.java)");
    com.tencent.mm.plugin.h localh = (com.tencent.mm.plugin.h)localObject;
    str = ((e)business(e.class)).mIC;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    h.a.a(localh, (String)localObject, true, Integer.valueOf(1), Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN), 104);
    AppMethodBeat.o(354555);
  }
  
  public final void hO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(354569);
    kotlin.g.b.s.u(paramString1, "bgUrl");
    kotlin.g.b.s.u(paramString2, "contactUsername");
    Object localObject = g.DIp;
    g.a(paramString2, ((e)business(e.class)).eyo(), (View)this.Esh);
    localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
    paramString1 = new com.tencent.mm.plugin.finder.loader.b(paramString1);
    ImageView localImageView = this.avatar;
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject).a(paramString1, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
    paramString1 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    paramString1 = ((e)business(e.class)).Eco;
    if (paramString1 == null)
    {
      localObject = paramString2;
      paramString1 = ((e)business(e.class)).Eco;
      if (paramString1 != null) {
        break label310;
      }
      paramString1 = null;
      label134:
      paramString1 = com.tencent.mm.plugin.finder.utils.aw.is((String)localObject, paramString1);
      this.Dli.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.mJe.getContext(), (CharSequence)paramString1));
      this.ngh.setVisibility(0);
      this.Dlp.setVisibility(8);
      paramString2 = this.mll;
      paramString1 = ((i)business(i.class)).Efl;
      if (paramString1 != null) {
        break label332;
      }
    }
    label310:
    label332:
    for (paramString1 = (CharSequence)this.mJe.getContext().getString(p.h.live_after_over);; paramString1 = (CharSequence)paramString1)
    {
      paramString2.setText(paramString1);
      if (Util.isNullOrNil(((i)business(i.class)).Efm)) {
        break label340;
      }
      this.pmf.setVisibility(0);
      this.pmf.setText((CharSequence)((i)business(i.class)).Efm);
      AppMethodBeat.o(354569);
      return;
      paramString1 = paramString1.contact;
      localObject = paramString2;
      if (paramString1 == null) {
        break;
      }
      paramString1 = paramString1.username;
      localObject = paramString2;
      if (paramString1 == null) {
        break;
      }
      localObject = paramString1;
      break;
      paramString1 = paramString1.contact;
      if (paramString1 == null)
      {
        paramString1 = null;
        break label134;
      }
      paramString1 = paramString1.nickname;
      break label134;
    }
    label340:
    this.pmf.setVisibility(8);
    AppMethodBeat.o(354569);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(354536);
    super.resume();
    esF();
    AppMethodBeat.o(354536);
  }
  
  public final void show()
  {
    AppMethodBeat.i(354600);
    if (this.Dlr)
    {
      this.mJe.animate().translationX(0.0F).setDuration(200L).withStartAction(new ch..ExternalSyntheticLambda10(this));
      AppMethodBeat.o(354600);
      return;
    }
    this.mJe.setTranslationX(0.0F);
    tO(0);
    AppMethodBeat.o(354600);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(354544);
    super.stop();
    this.Dlq = false;
    AppMethodBeat.o(354544);
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354617);
    super.tO(paramInt);
    Object localObject = this.mJe.findViewById(p.e.Cbh);
    if (localObject != null)
    {
      ((View)localObject).setOnClickListener(null);
      ((View)localObject).setClickable(false);
      ((View)localObject).setVisibility(8);
    }
    if (this.mJe.getVisibility() == 0)
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = this.mJe.getContext();
      kotlin.g.b.s.s(localObject, "root.context");
      if (((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD)
      {
        Log.i("Finder.LiveVisitorAfterPlugin", "show after maskview");
        localObject = this.mJe.findViewById(p.e.Cbh);
        if (localObject == null) {
          break label148;
        }
        ((View)localObject).setVisibility(0);
        ((View)localObject).setOnClickListener(new ch..ExternalSyntheticLambda3(this, (View)localObject));
        AppMethodBeat.o(354617);
        return;
      }
    }
    Log.i("Finder.LiveVisitorAfterPlugin", "hide after maskview");
    label148:
    AppMethodBeat.o(354617);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$updateDesc$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b(View paramView, ah.f<FinderLiveFoldTextView> paramf, ch paramch, String paramString) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(355788);
      this.Dls.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      FinderLiveFoldTextView localFinderLiveFoldTextView = (FinderLiveFoldTextView)localf.aqH;
      String str = com.tencent.mm.pluginsdk.ui.span.p.d(jdField_this.mJe.getContext(), (CharSequence)paramString, 0.0F).toString();
      kotlin.g.b.s.s(str, "spanForSmileyWithoutCach…ext, desc, 0f).toString()");
      localFinderLiveFoldTextView.a((CharSequence)str, this.Dls.getWidth(), true, null);
      AppMethodBeat.o(355788);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorAfterPlugin$updateNextLiveInfo$anim$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(ch paramch) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(355810);
      ch.b(this.Dlu).setAlpha(1.0F);
      ch.b(this.Dlu).setVisibility(0);
      AppMethodBeat.o(355810);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(355802);
      ch.b(this.Dlu).setAlpha(0.0F);
      ch.b(this.Dlu).setVisibility(0);
      AppMethodBeat.o(355802);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ch
 * JD-Core Version:    0.7.0.1
 */