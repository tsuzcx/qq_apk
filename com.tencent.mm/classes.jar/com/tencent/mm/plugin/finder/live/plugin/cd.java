package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ak;
import com.tencent.mm.plugin.finder.live.model.ak.b;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.g;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.aa;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.report.q.cb;
import com.tencent.mm.plugin.finder.live.sidebar.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveFansClubTagWidget;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import org.json.JSONObject;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "DIMISS_FOLLOWED_BTN", "", "PORTRAIT_ACTION_GOTO_PROFILE", "", "getPORTRAIT_ACTION_GOTO_PROFILE", "()Ljava/lang/String;", "SHOW_FOLLOW_BTN", "SHOW_FOLLOW_BTN_DELAY", "", "WATCH_TIME_OVER", "anchorAvatarUrl", "anchorNickname", "authIv", "Landroid/widget/ImageView;", "avatarDecorView", "Lorg/libpag/PAGView;", "avatarIcon", "bigAnim", "bigAnimationFile", "bizNameTv", "Landroid/widget/TextView;", "cacheFollowVisible", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "fansClubTag", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubTagWidget;", "getFansClubTag", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubTagWidget;", "fansClubTag$delegate", "Lkotlin/Lazy;", "followBtn", "followBtnBg", "Landroid/view/View;", "followBtnIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "followBtnLayout", "Landroid/widget/FrameLayout;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "highLightAnimatorSet", "", "Landroid/animation/Animator;", "isBizHighLightNow", "", "isFromMessageCallbackExecuted", "value", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "oplogCallback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "titleMainLayout", "Landroid/widget/LinearLayout;", "activateFollowLogic", "", "animatorBizHighLight", "isBizHigh", "autoSetNamePaddingRight", "canClearScreen", "canClearScreenWhenSideBarShow", "checkAvatarDecoration", "item", "Lcom/tencent/mm/protocal/protobuf/LiveElementMedia;", "checkFansClubState", "doBlockOpLog", "username", "followAnchor", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getBizNickname", "getBizUsername", "goToAnchorProfile", "ifNeedShowFansClubEntry", "initFollowBtn", "isFromMessageCallback", "isAnchorFollowed", "isBizMode", "onClearForSideBar", "clear", "onFollowChanged", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFollow", "onHeadClick", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "delayMs", "preGoToAnchorProfile", "reset", "resume", "setFollowBtnState", "source", "needAnim", "afterFansClub", "(ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "setFollowLayoutVisible", "visible", "setVisible", "shakeFollowLayout", "shakeIt", "view", "withAlphaChange", "showFansClubTag", "isAnchor", "tag", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "switchUiStyle", "unMount", "updateAvatarDecoration", "updateLiveTitle", "anchorUsername", "showContent", "visibleInCurrentLiveMode", "Companion", "SampleAnimatorListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cd
  extends b
{
  public static final cd.a Dko;
  private ck<bpq> CYX;
  private final String DeM;
  private PAGView Dex;
  private final Set<Animator> DkA;
  private boolean DkB;
  private final int DkC;
  private final int DkD;
  private final int DkE;
  private final long DkF;
  private String DkG;
  private int DkH;
  private final LinearLayout Dkp;
  private final PAGView Dkq;
  private final TextView Dkr;
  private final ImageView Dks;
  private final TextView Dkt;
  private final WeImageView Dku;
  private final FrameLayout Dkv;
  private final View Dkw;
  private final j Dkx;
  private String Dky;
  private String Dkz;
  private Context context;
  private final TextView lDF;
  private final com.tencent.mm.live.b.b nfT;
  private int ngo;
  private final ImageView nnV;
  private final j rdm;
  
  static
  {
    AppMethodBeat.i(354666);
    Dko = new cd.a((byte)0);
    AppMethodBeat.o(354666);
  }
  
  public cd(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, bui parambui)
  {
    super(paramViewGroup, paramb, parambui);
    AppMethodBeat.i(354212);
    this.nfT = paramb;
    this.DeM = "PORTRAIT_ACTION_GOTO_PROFILE_TITLE";
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(p.e.Cau);
    s.s(paramb, "root.findViewById(R.id.rl_title_main_layout)");
    this.Dkp = ((LinearLayout)paramb);
    paramb = paramViewGroup.findViewById(p.e.live_title_info_avatar_icon);
    s.s(paramb, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
    this.nnV = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BXb);
    s.s(paramb, "root.findViewById(R.id.l…e_info_avatar_decor_view)");
    this.Dkq = ((PAGView)paramb);
    paramb = paramViewGroup.findViewById(p.e.Cat);
    s.s(paramb, "root.findViewById(R.id.rl_title_biz_txv)");
    this.Dkr = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.live_title_info_name_tv);
    s.s(paramb, "root.findViewById(R.id.live_title_info_name_tv)");
    this.lDF = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BXc);
    s.s(paramb, "root.findViewById(R.id.live_title_info_tag_iv)");
    this.Dks = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BWJ);
    s.s(paramb, "root.findViewById(R.id.live_follow_btn)");
    this.Dkt = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BWL);
    s.s(paramb, "root.findViewById(R.id.live_follow_btn_icon)");
    this.Dku = ((WeImageView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BWM);
    s.s(paramb, "root.findViewById(R.id.live_follow_btn_layout)");
    this.Dkv = ((FrameLayout)paramb);
    paramb = paramViewGroup.findViewById(p.e.BWK);
    s.s(paramb, "root.findViewById(R.id.live_follow_btn_bg)");
    this.Dkw = paramb;
    this.Dkx = kotlin.k.cm((kotlin.g.a.a)new f(paramViewGroup));
    this.ngo = bf.bk(paramViewGroup.getContext());
    this.DkA = ((Set)new LinkedHashSet());
    this.DkC = 1;
    this.DkD = 2;
    this.DkE = 3;
    this.DkF = 500L;
    this.DkG = "finder_live_follow_anim.pag";
    this.rdm = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.nnV.setOnClickListener(new cd..ExternalSyntheticLambda2(this));
    this.lDF.setOnClickListener(new cd..ExternalSyntheticLambda1(this));
    this.Dkr.setOnClickListener(new cd..ExternalSyntheticLambda3(this));
    this.nnV.setImageDrawable(this.context.getResources().getDrawable(p.d.default_round_avatar));
    paramb = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramb = paramViewGroup.getContext();
    s.s(paramb, "root.context");
    com.tencent.mm.plugin.finder.accessibility.a.a(paramb, this.lDF, 15.0F);
    paramb = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramViewGroup = paramViewGroup.getContext();
    s.s(paramViewGroup, "root.context");
    com.tencent.mm.plugin.finder.accessibility.a.a(paramViewGroup, this.Dkt, 10.0F);
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((b)this, true);
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
    a(this, null, false, 1);
    esx();
    this.DkH = 8;
    AppMethodBeat.o(354212);
  }
  
  private final void Pd(int paramInt)
  {
    AppMethodBeat.i(354304);
    Log.i("FinderLiveTitlePlugin", s.X("setFollowLayoutVisible ", Integer.valueOf(paramInt)));
    this.DkH = paramInt;
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = this.mJe.getContext();
    s.s(localObject, "root.context");
    int i = paramInt;
    if (((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD)
    {
      i = paramInt;
      if (paramInt != 8) {
        i = 4;
      }
    }
    this.Dkv.setVisibility(i);
    AppMethodBeat.o(354304);
  }
  
  private final void S(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(354330);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (paramBoolean != com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      AppMethodBeat.o(354330);
      return;
    }
    if (esv().getVisibility() != 0)
    {
      esv().setVisibility(0);
      esv().f(paramBoolean, paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efi);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).so(true);
      esv().setClickListener((kotlin.g.a.b)new k(this));
      if (!paramBoolean)
      {
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cb.DEf, null, null, 6);
        AppMethodBeat.o(354330);
      }
    }
    else
    {
      esv().ayz(paramString);
    }
    AppMethodBeat.o(354330);
  }
  
  private static final Animator a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, TextView paramTextView)
  {
    AppMethodBeat.i(354535);
    paramFloat1 = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), paramFloat1);
    paramTextView = new cd.c(paramTextView, com.tencent.mm.view.d.e(MMApplicationContext.getContext(), paramFloat2), paramFloat4, paramFloat1, paramFloat3);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    s.s(localValueAnimator, "ofFloat(0f, 1f)");
    localValueAnimator.setDuration(300L);
    localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    localValueAnimator.addListener((Animator.AnimatorListener)paramTextView);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)paramTextView);
    localValueAnimator.start();
    paramTextView = (Animator)localValueAnimator;
    AppMethodBeat.o(354535);
    return paramTextView;
  }
  
  private static final void a(cd paramcd, long paramLong)
  {
    AppMethodBeat.i(354528);
    s.u(paramcd, "this$0");
    if (!paramcd.isFinished())
    {
      paramcd.esy();
      AppMethodBeat.o(354528);
      return;
    }
    Log.i("FinderLiveTitlePlugin", "goToFinderProfileImpl delayMs:" + paramLong + ",isFinished!");
    AppMethodBeat.o(354528);
  }
  
  private static final void a(cd paramcd, View paramView)
  {
    AppMethodBeat.i(354436);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcd, "this$0");
    paramcd.esw();
    paramView = com.tencent.mm.plugin.finder.live.report.k.Doi;
    boolean bool = paramcd.esB();
    paramView = new JSONObject();
    if (bool) {}
    for (paramcd = "mmbiz_profile";; paramcd = "findervideo_profile")
    {
      paramView.put("jump_type", paramcd);
      com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DCV, paramView.toString(), 0L, null, null, null, 60);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354436);
      return;
    }
  }
  
  private static final void a(cd paramcd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(354506);
    s.u(paramcd, "this$0");
    s.u(paramString, "$source");
    Log.i("FinderLiveTitlePlugin", "[showOrDismissAnimView] call true");
    a(paramcd, paramString, paramBoolean, true);
    AppMethodBeat.o(354506);
  }
  
  private static final void a(cd paramcd, String paramString, final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(354479);
    Log.i("FinderLiveTitlePlugin", s.X("[showOrDismissAnimView] in ", Boolean.valueOf(paramBoolean2)));
    if (paramcd.Dex == null) {
      paramcd.Dex = new PAGView(paramcd.mJe.getContext());
    }
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (!s.p(paramString, "#4")) && (paramcd.esA()) && (!paramcd.esv().eAI()))
    {
      Log.i("FinderLiveTitlePlugin", "fansClubTag has not folded, wait a seconds,#2");
      paramcd.esv().postDelayed(new cd..ExternalSyntheticLambda9(paramBoolean2, paramcd, paramString, paramBoolean1), 1000L);
      AppMethodBeat.o(354479);
      return;
    }
    paramString = paramcd.Dex;
    if (paramString != null) {
      if (paramBoolean2)
      {
        if (paramcd.Dkv.indexOfChild((View)paramcd.Dex) == -1)
        {
          paramString = new FrameLayout.LayoutParams(paramcd.Dkw.getWidth(), paramcd.Dkw.getHeight());
          paramString.gravity = 17;
          localObject = paramcd.Dex;
          if (localObject != null) {
            ((PAGView)localObject).setLayoutParams((ViewGroup.LayoutParams)paramString);
          }
          paramcd.Dkv.addView((View)paramcd.Dex);
        }
        paramString = paramcd.Dex;
        if (paramString != null) {
          paramString.setFile(PAGFile.Load(MMApplicationContext.getContext().getResources().getAssets(), paramcd.DkG));
        }
        paramString = paramcd.Dex;
        if (paramString != null) {
          paramString.addListener((PAGView.PAGViewListener)new i(paramcd, paramBoolean1));
        }
        paramString = paramcd.Dex;
        if (paramString != null) {
          paramString.setProgress(0.0D);
        }
        paramString = paramcd.Dex;
        if (paramString != null) {
          paramString.flush();
        }
        paramcd = paramcd.Dex;
        if (paramcd != null)
        {
          paramcd.play();
          AppMethodBeat.o(354479);
        }
      }
      else if (paramcd.Dkv.indexOfChild((View)paramString) != -1)
      {
        paramString.stop();
        paramcd.Dkv.removeView((View)paramString);
      }
    }
    AppMethodBeat.o(354479);
  }
  
  private static final void a(cd paramcd, boolean paramBoolean, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(354459);
    s.u(paramcd, "this$0");
    paramcd.a(paramBoolean, "#7", paramBoolean1, paramBoolean2);
    AppMethodBeat.o(354459);
  }
  
  private static final void a(boolean paramBoolean1, cd paramcd, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(354468);
    s.u(paramcd, "this$0");
    s.u(paramString, "$source");
    a(paramcd, paramString, paramBoolean2, paramBoolean1);
    AppMethodBeat.o(354468);
  }
  
  private final void a(boolean paramBoolean, String paramString, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(354278);
    Log.i("FinderLiveTitlePlugin", "[setFollowBtnState] source:" + paramString + ", isFollow:" + paramBoolean);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (s.p(paramBoolean2, Boolean.TRUE)) && (esA()) && (!esv().eAI()))
    {
      Log.i("FinderLiveTitlePlugin", "fansClubTag has not folded, wait a seconds,#1");
      esv().postDelayed(new cd..ExternalSyntheticLambda8(this, paramBoolean, paramBoolean1, paramBoolean2), 1000L);
      AppMethodBeat.o(354278);
      return;
    }
    Pd(0);
    rG(true);
    esC();
    this.Dkt.setVisibility(0);
    if (this.nfT.getLiveRole() == 0) {
      com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.aa.DxF, esB());
    }
    Log.i("FinderLiveTitlePlugin", "[showOrDismissAnimView] call false");
    a(this, paramString, paramBoolean, false);
    if (!paramBoolean)
    {
      getHandler().removeMessages(this.DkD);
      this.Dku.setVisibility(0);
      rF(esB());
      this.Dkt.setPadding(0, 0, this.mJe.getContext().getResources().getDimensionPixelSize(p.c.OneDPPadding), 0);
      this.Dkt.setText((CharSequence)this.context.getString(p.h.Ckq));
      this.Dkt.setTextSize(0, this.mJe.getContext().getResources().getDimensionPixelSize(p.c.Bzj));
      this.Dkt.setOnClickListener(new cd..ExternalSyntheticLambda0(this));
      if (!s.p(paramString, "#1"))
      {
        paramString = this.Dkv;
        paramBoolean1 = new AlphaAnimation(0.0F, 1.0F);
        paramBoolean1.setDuration(200L);
        paramBoolean2 = ah.aiuX;
        paramString.startAnimation((Animation)paramBoolean1);
        AppMethodBeat.o(354278);
      }
    }
    else
    {
      this.Dku.setVisibility(4);
      this.Dkt.setOnClickListener(null);
      if (s.p(paramBoolean1, Boolean.TRUE))
      {
        Pd(0);
        rG(true);
        esC();
        this.Dkt.post(new cd..ExternalSyntheticLambda7(this, paramString, paramBoolean));
        AppMethodBeat.o(354278);
        return;
      }
      paramString = this.Dex;
      if ((paramString != null) && (this.Dkv.indexOfChild((View)paramString) != -1))
      {
        paramString.stop();
        this.Dkv.removeView((View)paramString);
      }
      if (this.Dkv.getWidth() > 0) {
        this.Dkv.getLayoutParams().width = this.Dkv.getWidth();
      }
      this.Dku.setVisibility(8);
      this.Dkw.setBackground(this.mJe.getContext().getDrawable(p.d.BAc));
      this.Dkt.setText((CharSequence)this.context.getString(p.h.has_follow_tip));
      this.Dkt.setTextColor(this.context.getResources().getColor(p.b.hot_tab_BW_100_Alpha_0_3));
      this.Dkt.setTextSize(0, this.mJe.getContext().getResources().getDimensionPixelSize(p.c.Bzk));
      this.Dkt.setPadding(0, 0, 0, 0);
      this.Dkt.setOnClickListener(cd..ExternalSyntheticLambda4.INSTANCE);
    }
    AppMethodBeat.o(354278);
  }
  
  private static final void b(cd paramcd)
  {
    AppMethodBeat.i(354522);
    s.u(paramcd, "this$0");
    paramcd.esx();
    AppMethodBeat.o(354522);
  }
  
  private static final void b(cd paramcd, View paramView)
  {
    AppMethodBeat.i(354446);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcd, "this$0");
    paramcd.esw();
    com.tencent.mm.plugin.finder.live.report.k.Doi.rR(paramcd.esB());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354446);
  }
  
  private final void b(dik paramdik)
  {
    AppMethodBeat.i(354421);
    final com.tencent.mm.plugin.finder.viewmodel.business.a locala = (com.tencent.mm.plugin.finder.viewmodel.business.a)business(com.tencent.mm.plugin.finder.viewmodel.business.a.class);
    Object localObject;
    if (paramdik == null)
    {
      localObject = null;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label94;
      }
    }
    label94:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label99;
      }
      Log.i("FinderLiveTitlePlugin", "updateAvatarDecoration url is null or empty.");
      locala.GLT = paramdik;
      this.Dkq.stop();
      this.Dkq.setVisibility(8);
      AppMethodBeat.o(354421);
      return;
      localObject = paramdik.url;
      break;
    }
    label99:
    if (y.ZC(com.tencent.mm.plugin.finder.viewmodel.business.a.d(paramdik)))
    {
      Log.i("FinderLiveTitlePlugin", "updateAvatarDecoration local decorations exist.");
      this.Dkq.setPath(com.tencent.mm.plugin.finder.viewmodel.business.a.d(paramdik));
      this.Dkq.setRepeatCount(-1);
      this.Dkq.play();
      locala.GLT = paramdik;
      AppMethodBeat.o(354421);
      return;
    }
    Log.i("FinderLiveTitlePlugin", "updateAvatarDecoration download decorations.");
    locala.a(paramdik, (kotlin.g.a.b)new l(paramdik, this, locala));
    AppMethodBeat.o(354421);
  }
  
  private final String bQk()
  {
    AppMethodBeat.i(354367);
    String str2 = getData().Ebr.hUQ;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if (((CharSequence)str1).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        str1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).hUQ;
      }
      AppMethodBeat.o(354367);
      return str1;
    }
  }
  
  private static final void c(cd paramcd, View paramView)
  {
    AppMethodBeat.i(354451);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcd, "this$0");
    paramcd.esw();
    com.tencent.mm.plugin.finder.live.report.k.Doi.rR(paramcd.esB());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354451);
  }
  
  private static final void d(cd paramcd, View paramView)
  {
    bma localbma = null;
    com.tencent.mm.plugin.h localh = null;
    AppMethodBeat.i(354502);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramcd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramcd, "this$0");
    paramView = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject1 = d.a.auT(((e)paramcd.business(e.class)).mIC);
    if (localObject1 == null)
    {
      paramView = localh;
      if (paramView == null)
      {
        paramcd.Dkt.setVisibility(8);
        Log.i("FinderLiveTitlePlugin", "no anchor finder contact ");
      }
      paramView = ak.CHI;
      ak.oi(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramcd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354502);
      return;
    }
    paramView = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramcd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).hUQ);
    int i;
    if ((paramView != null) && (com.tencent.mm.contact.d.rs(paramView.field_type) == true))
    {
      i = 1;
      label225:
      bool = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Ss(((m)localObject1).getNickname());
      if (!paramcd.esB()) {
        break label469;
      }
      if (i == 0)
      {
        paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramView = paramcd.context;
        s.s(paramView, "context");
        com.tencent.mm.plugin.finder.live.utils.a.a(paramView, paramcd.getBuContext(), (kotlin.g.a.b)new cd.g(paramcd));
      }
    }
    label469:
    while (bool)
    {
      paramView = aw.Gjk;
      bool = aw.o((m)localObject1);
      Log.i("FinderLiveTitlePlugin", "followBtn click, nickName:" + ((m)localObject1).getNickname() + ", isBlock" + bool);
      if (bool)
      {
        paramView = ((m)localObject1).getUsername();
        Log.i("FinderLiveTitlePlugin", "[doBlockOpLog] ");
        paramcd.CYX = ((ck)new cd.e());
        ((com.tencent.mm.plugin.finder.service.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.n.class)).a(paramView, false, paramcd.CYX);
      }
      paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.ge((View)paramcd.Dkt);
      paramcd.a(true, "#4", Boolean.TRUE, Boolean.FALSE);
      b.b.a(paramcd.nfT, b.c.ncK);
      paramcd.getHandler().sendEmptyMessageDelayed(paramcd.DkD, 5000L);
      com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.aa.DxG, paramcd.esB());
      paramView = ah.aiuX;
      break;
      i = 0;
      break label225;
    }
    paramView = aw.Gjk;
    boolean bool = aw.n((m)localObject1);
    label507:
    String str;
    Object localObject3;
    long l;
    if (((e)paramcd.business(e.class)).EdI.ZNI == 3)
    {
      paramView = z.bAW();
      Log.i("FinderLiveTitlePlugin", "#followAnchor nickName:" + ((m)localObject1).getNickname() + ", isPrivate:" + bool);
      localh = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = paramcd.mJe.getContext();
      s.s(localObject2, "root.context");
      localObject2 = ((bn)com.tencent.mm.ui.component.k.nq((Context)localObject2).cq(bn.class)).fou();
      str = ((m)localObject1).getUsername();
      localObject3 = bh.ABm;
      i = bh.dVr();
      l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramcd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      s.s(paramView, "participantFinderUsername");
      localObject3 = aj.CGT;
      localObject3 = aj.getFinderLiveAssistant();
      if (localObject3 != null) {
        break label679;
      }
    }
    for (;;)
    {
      localh.a((bui)localObject2, str, i, l, bool, paramView, localbma);
      break;
      paramView = "";
      break label507;
      label679:
      localbma = ((ap)localObject3).ekj();
    }
  }
  
  private final boolean esA()
  {
    AppMethodBeat.i(354322);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.q(getBuContext()))
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
      if ((localObject != null) && (((bgw)localObject).ZQq == true))
      {
        i = 1;
        if (i == 0) {
          break label152;
        }
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
        if ((localObject == null) || (((bgw)localObject).ZQo != true)) {
          break label147;
        }
      }
      label147:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Eff) || (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((e)business(e.class)).EcR == 1)) {
          break label152;
        }
        AppMethodBeat.o(354322);
        return true;
        i = 0;
        break;
      }
    }
    label152:
    AppMethodBeat.o(354322);
    return false;
  }
  
  private final boolean esB()
  {
    AppMethodBeat.i(354355);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).Ecg)
    {
      AppMethodBeat.o(354355);
      return true;
    }
    if (getData().Ebr.mIJ == 4)
    {
      AppMethodBeat.o(354355);
      return true;
    }
    AppMethodBeat.o(354355);
    return false;
  }
  
  private final void esC()
  {
    AppMethodBeat.i(354390);
    boolean bool = this.Dkv.isShown();
    Log.i("FinderLiveTitlePlugin", s.X("#autoSetNamePaddingRight btnLayoutShown=", Boolean.valueOf(bool)));
    if (bool)
    {
      Log.i("FinderLiveTitlePlugin", "#autoSetNamePaddingRight followBtnLayout shown=true");
      this.Dkp.setPadding(0, 0, bd.fromDPToPix(this.mJe.getContext(), 60), 0);
      AppMethodBeat.o(354390);
      return;
    }
    Log.i("FinderLiveTitlePlugin", "#autoSetNamePaddingRight followBtnLayout shown=false");
    this.Dkp.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(354390);
  }
  
  private final boolean esD()
  {
    AppMethodBeat.i(354410);
    boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).esD();
    AppMethodBeat.o(354410);
    return bool;
  }
  
  private final FinderLiveFansClubTagWidget esv()
  {
    AppMethodBeat.i(354225);
    FinderLiveFansClubTagWidget localFinderLiveFansClubTagWidget = (FinderLiveFansClubTagWidget)this.Dkx.getValue();
    AppMethodBeat.o(354225);
    return localFinderLiveFansClubTagWidget;
  }
  
  private final void esw()
  {
    AppMethodBeat.i(354241);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = this.mJe.getContext();
    s.s(localObject, "root.context");
    if (((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD)
    {
      Log.i("FinderLiveTitlePlugin", "onHeadClick inSideBarStatus");
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = this.mJe.getContext();
      s.s(localObject, "root.context");
      localObject = ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE;
      if (localObject != null) {
        ((c)localObject).hide();
      }
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = this.mJe.getContext();
      s.s(localObject, "root.context");
      ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGH.DGN = 3;
      AppMethodBeat.o(354241);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      boolean bool = isLandscape();
      Log.i("FinderLiveTitlePlugin", s.X("goToAnchorFinderProfile isLandscape:", Boolean.valueOf(bool)));
      if (bool) {
        b.a((b)this, this.DeM, null, 0, 6);
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.finder.live.report.k.Doi;
        com.tencent.mm.plugin.finder.live.report.k.DoO = true;
        com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DCp, null, 0L, null, null, null, 60);
        com.tencent.mm.plugin.finder.live.report.k.Doy += 1;
        AppMethodBeat.o(354241);
        return;
        esy();
      }
    }
    localObject = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Boolean)com.tencent.d.a.a.a.a.a.jUx().bmg()).booleanValue()) {
      b.b.a(this.nfT, b.c.neu);
    }
    AppMethodBeat.o(354241);
  }
  
  private void esx()
  {
    AppMethodBeat.i(354255);
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject = d.a.auT(((e)business(e.class)).mIC);
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      boolean bool1 = esD();
      ak localak = ak.CHI;
      boolean bool2 = ak.oh(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
      Log.i("FinderLiveTitlePlugin", (String)localObject + "  followStatus = " + bool1 + ", hadTriggerShow:" + bool2);
      if (bool1) {
        break label208;
      }
      if (!bool2) {
        break;
      }
      localObject = ak.CHI;
      ak.oj(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
      a(this, false, "#1");
      AppMethodBeat.o(354255);
      return;
      localObject = ((m)localObject).getNickname();
      if (localObject == null) {
        localObject = "";
      }
    }
    Pd(8);
    rG(false);
    esC();
    getHandler().sendEmptyMessageDelayed(this.DkE, this.DkF);
    AppMethodBeat.o(354255);
    return;
    label208:
    getHandler().removeMessages(this.DkC);
    Pd(8);
    rG(false);
    esC();
    AppMethodBeat.o(354255);
  }
  
  private final void esy()
  {
    AppMethodBeat.i(354296);
    if (esB())
    {
      localObject1 = aw.Gjk;
      localObject1 = bQk();
      localObject2 = this.mJe.getContext();
      s.s(localObject2, "root.context");
      aw.a((String)localObject1, (Context)localObject2, ((e)business(e.class)).sessionId, String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), 2);
      AppMethodBeat.o(354296);
      return;
    }
    Object localObject1 = g.CEN;
    localObject1 = this.context;
    Object localObject2 = getBuContext();
    String str = ((e)business(e.class)).mIC;
    Object localObject3 = com.tencent.mm.ui.component.k.aeZF;
    localObject3 = this.context;
    s.s(localObject3, "context");
    g.a((Context)localObject1, (com.tencent.mm.plugin.finder.live.model.context.a)localObject2, true, str, ((bn)com.tencent.mm.ui.component.k.nq((Context)localObject3).cq(bn.class)).fou());
    AppMethodBeat.o(354296);
  }
  
  private static final void gb(View paramView)
  {
    AppMethodBeat.i(354514);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354514);
  }
  
  private final MMHandler getHandler()
  {
    AppMethodBeat.i(354230);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(354230);
    return localMMHandler;
  }
  
  private final void rF(boolean paramBoolean)
  {
    AppMethodBeat.i(354382);
    Log.i("FinderLiveTitlePlugin", s.X("#switchUiStyle isBizMode=", Boolean.valueOf(paramBoolean)));
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      this.DkG = "finder_live_follow_anim_biz.pag";
      this.Dku.setIconColor(this.context.getResources().getColor(p.b.black));
      localObject1 = this.Dkt;
      localObject2 = this.context.getResources();
      if (esD())
      {
        i = p.b.hot_tab_BW_100_Alpha_0_3;
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
        this.Dkr.setVisibility(0);
        localObject1 = this.Dkv.getLayoutParams();
        if (localObject1 != null)
        {
          localObject1 = (LinearLayout.LayoutParams)localObject1;
          ((LinearLayout.LayoutParams)localObject1).setMarginStart(-com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 62.0F));
          this.Dkv.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (!esD())
        {
          Log.i("FinderLiveTitlePlugin", s.X("#switchUiStyle change bg, isAnchorFollowed:", Boolean.valueOf(esD())));
          localObject1 = this.Dkw;
          localObject2 = this.mJe.getContext();
          if (!esB()) {
            break label336;
          }
        }
      }
    }
    label336:
    for (int i = p.d.finder_live_follow_btn_shape_biz;; i = p.d.finder_live_follow_btn_shape)
    {
      ((View)localObject1).setBackground(((Context)localObject2).getDrawable(i));
      AppMethodBeat.o(354382);
      return;
      i = p.b.black;
      break;
      this.DkG = "finder_live_follow_anim.pag";
      this.Dku.setIconColor(this.context.getResources().getColor(p.b.White));
      localObject1 = this.Dkt;
      localObject2 = this.context.getResources();
      if (esD()) {}
      for (i = p.b.hot_tab_BW_100_Alpha_0_3;; i = p.b.White)
      {
        ((TextView)localObject1).setTextColor(((Resources)localObject2).getColor(i));
        this.Dkr.setVisibility(8);
        localObject1 = this.Dkv.getLayoutParams();
        if (localObject1 == null) {
          break;
        }
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        ((LinearLayout.LayoutParams)localObject1).setMarginStart(-com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 62.0F));
        this.Dkv.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
      }
    }
  }
  
  private final void rG(boolean paramBoolean)
  {
    AppMethodBeat.i(354404);
    Log.i("FinderLiveTitlePlugin", s.X("#animatorBizHighLight isBizHigh=", Boolean.valueOf(paramBoolean)));
    if (!esB())
    {
      AppMethodBeat.o(354404);
      return;
    }
    if (this.DkB == paramBoolean)
    {
      AppMethodBeat.o(354404);
      return;
    }
    this.DkB = paramBoolean;
    Iterator localIterator = ((Iterable)this.DkA).iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).cancel();
    }
    this.DkA.clear();
    if (paramBoolean)
    {
      this.DkA.add(a(15.0F, 12.0F, 1.0F, 0.6F, this.lDF));
      this.DkA.add(a(12.0F, 15.0F, 0.6F, 1.0F, this.Dkr));
      AppMethodBeat.o(354404);
      return;
    }
    this.DkA.add(a(12.0F, 15.0F, 0.6F, 1.0F, this.lDF));
    this.DkA.add(a(15.0F, 12.0F, 1.0F, 0.6F, this.Dkr));
    AppMethodBeat.o(354404);
  }
  
  private final void t(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(354345);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(AnimationUtils.loadAnimation(this.mJe.getContext(), com.tencent.mm.plugin.finder.live.p.a.ByJ));
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(200L);
      ah localah = ah.aiuX;
      localAnimationSet.addAnimation((Animation)localAlphaAnimation);
    }
    paramView.startAnimation((Animation)localAnimationSet);
    Log.i("FinderLiveTitlePlugin", "shakeIt view:" + paramView + ",withAlphaChange:" + paramBoolean);
    AppMethodBeat.o(354345);
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(354777);
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      if (s.p(paramBundle, this.DeM)) {
        com.tencent.mm.ae.d.a(paramLong, new cd..ExternalSyntheticLambda6(this, paramLong));
      }
      AppMethodBeat.o(354777);
      return;
      paramObject = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = paramObject;
      if (paramObject == null) {
        paramBundle = "";
      }
    }
  }
  
  public final void bA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(354822);
    s.u(paramString, "anchorUsername");
    Object localObject1;
    Object localObject2;
    label72:
    boolean bool;
    label80:
    int i;
    if (((e)business(e.class)).Eet)
    {
      localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject1 = d.a.auT(((e)business(e.class)).mIC);
      Object localObject3 = new StringBuilder("updateLiveTitle contact avatarUrl is null:");
      if (localObject1 != null) {
        break label596;
      }
      localObject2 = null;
      if (localObject2 != null) {
        break label606;
      }
      bool = true;
      Log.i("FinderLiveTitlePlugin", bool + ' ' + paramString + ",liveData username:" + ((e)business(e.class)).mIC + ",showContent:" + paramBoolean);
      if (localObject1 != null)
      {
        localObject2 = getData().Ebr.mIK;
        paramString = (String)localObject2;
        if (localObject2 == null) {
          paramString = "";
        }
        if (((CharSequence)paramString).length() != 0) {
          break label612;
        }
        i = 1;
        label180:
        if (i != 0) {
          paramString = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).mIK;
        }
        if (((CharSequence)paramString).length() != 0) {
          break label617;
        }
        i = 1;
        label212:
        if (i == 0) {
          break label622;
        }
        this.Dkr.setText((CharSequence)this.context.getString(p.h.Cpg));
        label236:
        this.Dky = ((m)localObject1).dUr();
        this.Dkz = ((m)localObject1).dUs();
        paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramString = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject2 = new com.tencent.mm.plugin.finder.loader.b(this.Dkz);
        localObject3 = this.nnV;
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        paramString.a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(com.tencent.mm.plugin.finder.loader.p.a.ExM));
        paramString = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveTitlePlugin", "updateLiveTitle load avatar " + this.Dky + ' ' + this.Dkz + " uniqueId:" + MD5Util.getMD5String(this.Dkz));
        this.lDF.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.context, (CharSequence)this.Dky, this.lDF.getTextSize()));
        if (((m)localObject1).field_authInfo == null) {
          break label694;
        }
        if (((m)localObject1).field_authInfo.authIconType <= 0) {
          break label653;
        }
        this.lDF.setPadding(this.lDF.getPaddingLeft(), this.lDF.getPaddingTop(), bd.fromDPToPix(this.mJe.getContext(), 20), this.lDF.getPaddingBottom());
        this.Dks.setVisibility(0);
        paramString = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        s.s(paramString, "service(IFinderCommonService::class.java)");
        h.a.a((com.tencent.mm.plugin.h)paramString, this.Dks, ((m)localObject1).field_authInfo, 0, null, 8);
        label490:
        this.lDF.setTag(p.e.BEi, Integer.valueOf(((m)localObject1).field_authInfo.authIconType));
        label511:
        if ((paramBoolean) && (this.mJe.getVisibility() != 0)) {
          tO(0);
        }
        rF(esB());
        if ((!esB()) || (!this.Dkv.isShown())) {
          break label735;
        }
        rG(true);
      }
    }
    for (;;)
    {
      esC();
      this.lDF.requestLayout();
      esz();
      AppMethodBeat.o(354822);
      return;
      localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject1 = d.a.auT(paramString);
      break;
      label596:
      localObject2 = ((m)localObject1).amx();
      break label72;
      label606:
      bool = false;
      break label80;
      label612:
      i = 0;
      break label180;
      label617:
      i = 0;
      break label212;
      label622:
      this.Dkr.setText((CharSequence)this.context.getString(p.h.Cph, new Object[] { paramString }));
      break label236;
      label653:
      this.lDF.setPadding(this.lDF.getPaddingLeft(), this.lDF.getPaddingTop(), 0, this.lDF.getPaddingBottom());
      this.Dks.setVisibility(8);
      break label490;
      label694:
      this.lDF.setPadding(this.lDF.getPaddingLeft(), this.lDF.getPaddingTop(), 0, this.lDF.getPaddingBottom());
      this.Dks.setVisibility(8);
      break label511;
      label735:
      rG(false);
    }
  }
  
  public final void c(final dik paramdik)
  {
    AppMethodBeat.i(354871);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramdik));
    AppMethodBeat.o(354871);
  }
  
  public final boolean enH()
  {
    return false;
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void esz()
  {
    AppMethodBeat.i(354836);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
      int i;
      if ((localObject1 != null) && (((bgw)localObject1).ZQq == true))
      {
        i = 1;
        if (i == 0) {
          break label196;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
        if ((localObject1 == null) || (((bgw)localObject1).ZQo != true)) {
          break label176;
        }
        i = 1;
        label76:
        if (i == 0) {
          break label196;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Efg;
        if (localObject1 == null) {
          break label191;
        }
        localObject1 = ((bgw)localObject1).ZQn;
        if (localObject1 == null) {
          break label191;
        }
        if (((CharSequence)localObject1).length() != 0) {
          break label181;
        }
        i = 1;
        label121:
        if (i != 0) {
          break label186;
        }
        i = 1;
        label127:
        if (i == 0) {
          break label191;
        }
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.context.getResources().getString(p.h.CjS);
        }
        s.s(localObject2, "business(LiveFansClubSli…ng.finder_live_fans_club)");
        S(true, (String)localObject2);
        AppMethodBeat.o(354836);
        return;
        i = 0;
        break;
        label176:
        i = 0;
        break label76;
        label181:
        i = 0;
        break label121;
        label186:
        i = 0;
        break label127;
        label191:
        localObject1 = null;
      }
      label196:
      esv().setVisibility(8);
      AppMethodBeat.o(354836);
      return;
    }
    if (esA())
    {
      localObject1 = this.context.getString(p.h.Cla);
      s.s(localObject1, "context.getString(R.stri…nder_live_join_fans_club)");
      S(false, (String)localObject1);
      AppMethodBeat.o(354836);
      return;
    }
    esv().setVisibility(8);
    AppMethodBeat.o(354836);
  }
  
  public final void qU(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(354788);
    super.qU(paramBoolean);
    if (paramBoolean)
    {
      this.CTm = 65535;
      tO(0);
      if (this.Dkv.getVisibility() != 8)
      {
        this.Dkv.setVisibility(4);
        AppMethodBeat.o(354788);
      }
    }
    else
    {
      Pd(this.DkH);
      if (esB())
      {
        paramBoolean = bool;
        if (this.DkH == 0) {
          paramBoolean = true;
        }
        rG(paramBoolean);
      }
      esC();
    }
    AppMethodBeat.o(354788);
  }
  
  public final void qX(boolean paramBoolean)
  {
    AppMethodBeat.i(354795);
    esz();
    AppMethodBeat.o(354795);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(354860);
    super.reset();
    getHandler().removeMessages(this.DkE);
    getHandler().removeMessages(this.DkC);
    AppMethodBeat.o(354860);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(354749);
    super.resume();
    int j = bf.bk(this.mJe.getContext());
    int i = j;
    if (j == 0) {
      i = bd.fromDPToPix(this.mJe.getContext(), 16);
    }
    this.ngo = i;
    this.Dkt.post(new cd..ExternalSyntheticLambda5(this));
    AppMethodBeat.o(354749);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354846);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label315:
    for (;;)
    {
      AppMethodBeat.o(354846);
      return;
      tO(4);
      AppMethodBeat.o(354846);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, true);
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
      AppMethodBeat.o(354846);
      return;
      getHandler().removeMessages(this.DkC);
      AppMethodBeat.o(354846);
      return;
      getHandler().removeMessages(this.DkC);
      int i;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_FINDER_LIVE_SHAKE_VIEW", false) == true)) {
        i = 1;
      }
      while (i != 0)
      {
        if (this.Dkv.getVisibility() != 0) {
          getHandler().sendEmptyMessageDelayed(this.DkC, 0L);
        }
        if (this.Dkv.getVisibility() == 0)
        {
          t((View)this.Dkv, false);
          AppMethodBeat.o(354846);
          return;
          i = 0;
        }
        else
        {
          this.Dkv.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new j(this));
          AppMethodBeat.o(354846);
          return;
        }
      }
      getHandler().sendEmptyMessageDelayed(this.DkC, 0L);
      AppMethodBeat.o(354846);
      return;
      if (paramBundle == null) {}
      for (boolean bool = false;; bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW"))
      {
        if (!bool) {
          break label315;
        }
        b(((com.tencent.mm.plugin.finder.viewmodel.business.a)business(com.tencent.mm.plugin.finder.viewmodel.business.a.class)).GLT);
        break;
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354759);
    super.tO(paramInt);
    if (esB()) {
      if (this.DkH != 0) {
        break label43;
      }
    }
    label43:
    for (boolean bool = true;; bool = false)
    {
      rG(bool);
      esC();
      AppMethodBeat.o(354759);
      return;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354853);
    super.unMount();
    getHandler().removeMessages(this.DkE);
    getHandler().removeMessages(this.DkC);
    getHandler().removeCallbacksAndMessages(null);
    AppMethodBeat.o(354853);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(cd paramcd, dik paramdik)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansClubTagWidget;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<FinderLiveFansClubTagWidget>
  {
    f(ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    h(cd paramcd)
    {
      super();
    }
    
    private static final boolean a(cd paramcd, Message paramMessage)
    {
      AppMethodBeat.i(355513);
      s.u(paramcd, "this$0");
      s.u(paramMessage, "it");
      int i = paramMessage.what;
      if (i == cd.h(paramcd))
      {
        cd.i(paramcd);
        cd.j(paramcd);
        cd.k(paramcd);
        paramcd.esz();
      }
      label131:
      label172:
      label175:
      for (;;)
      {
        AppMethodBeat.o(355513);
        return true;
        if (i == cd.l(paramcd))
        {
          boolean bool = cd.m(paramcd);
          Log.i("FinderLiveTitlePlugin", s.X("has been look for one min ,isFollow", Boolean.valueOf(bool)));
          cd.a(paramcd, bool, "#3");
        }
        else if (i == cd.n(paramcd))
        {
          paramMessage = Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramcd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
          if (((Number)paramMessage).longValue() != 0L)
          {
            i = 1;
            if (i == 0) {
              break label172;
            }
          }
          for (;;)
          {
            if (paramMessage == null) {
              break label175;
            }
            long l = ((Number)paramMessage).longValue();
            paramMessage = ak.CHI;
            ak.a(cd.c(paramcd), l, ak.b.CHP);
            break;
            i = 0;
            break label131;
            paramMessage = null;
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$showOrDismissAnimView$2$1", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "view", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements PAGView.PAGViewListener
  {
    i(cd paramcd, boolean paramBoolean) {}
    
    public final void onAnimationCancel(PAGView paramPAGView)
    {
      AppMethodBeat.i(355631);
      Log.i("FinderLiveTitlePlugin", "[showOrDismissAnimView] onAnimationCancel");
      AppMethodBeat.o(355631);
    }
    
    public final void onAnimationEnd(PAGView paramPAGView)
    {
      AppMethodBeat.i(355623);
      Log.i("FinderLiveTitlePlugin", "[showOrDismissAnimView] onAnimationEnd");
      paramPAGView = this.DkM;
      boolean bool = paramBoolean1;
      Boolean localBoolean = Boolean.FALSE;
      cd.a(paramPAGView, bool, "#5", localBoolean, localBoolean);
      AppMethodBeat.o(355623);
    }
    
    public final void onAnimationRepeat(PAGView paramPAGView) {}
    
    public final void onAnimationStart(PAGView paramPAGView)
    {
      AppMethodBeat.i(355640);
      cd.e(this.DkM).setVisibility(4);
      cd.f(this.DkM).setVisibility(4);
      AppMethodBeat.o(355640);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$shakeFollowLayout$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    j(cd paramcd) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(355607);
      if (cd.d(this.DkM).getVisibility() == 0)
      {
        cd.d(this.DkM).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        cd.e(this.DkM, (View)cd.d(this.DkM));
      }
      AppMethodBeat.o(355607);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    k(cd paramcd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    l(dik paramdik, cd paramcd, com.tencent.mm.plugin.finder.viewmodel.business.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cd
 * JD-Core Version:    0.7.0.1
 */