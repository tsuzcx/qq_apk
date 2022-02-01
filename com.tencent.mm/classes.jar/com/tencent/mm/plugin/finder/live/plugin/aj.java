package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.e.i;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.core.core.e.s;
import com.tencent.mm.live.core.core.e.a.a;
import com.tencent.mm.live.model.r.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bm;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.cc;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "anchorMuteAnimator", "Landroid/animation/AnimatorSet;", "anchorMuteIn", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "anchorMuteOut", "anchorMuteTipIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "audioModeGroup", "audioModeIcon", "Lorg/libpag/PAGView;", "audioModeTip", "Landroid/widget/TextView;", "bannerPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBannerPlugin;", "getBannerPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBannerPlugin;", "setBannerPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBannerPlugin;)V", "breakAudioThreshold", "", "breakStateData", "Lcom/tencent/mm/plugin/finder/live/plugin/AudioStateData;", "canShowAudioGroup", "", "getCanShowAudioGroup", "()Z", "setCanShowAudioGroup", "(Z)V", "commonInfoEmptyTimesCheckIndex", "curNetStatus", "duration", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "errBarTip", "errBarTipTv", "errType", "filterVisitorResetOnlineValue", "getFilterVisitorResetOnlineValue", "setFilterVisitorResetOnlineValue", "likeGroup", "likeIcon", "likeTv", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "maxAudioStateData", "memberIcon", "membersGroup", "membersGroupVisitorClickListener", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$membersGroupVisitorClickListener$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$membersGroupVisitorClickListener$1;", "membersIcon", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "overflowAudioThreshold", "pkAudioModeGroup", "pkAudioModeIcon", "pkAudioModeTip", "silentAudioStateData", "silentAudioThreshold", "temperatureThreshold", "tipBarStatus", "tipGroup", "breakAudioCheckEnable", "calculateAudioErrState", "", "param", "Landroid/os/Bundle;", "canClearScreen", "canVisitorGotoMemberList", "checkBreakAudio", "checkDuration", "createTime", "checkErrBarNetwork", "checkErrBarOverflowAudio", "checkErrBarSilentAudio", "checkErrBarTemperature", "checkNetwork", "checkPkAnchorAudioTip", "checkPkAnchorAudioVolume", "getCurErrType", "getNetStatusIcon", "resId", "getPluginAreaBottomOnScreen", "initMembersGroupClick", "isAnchorOrAssistant", "isBreakAudio", "breakCount", "notifyAnchorVolumeChange", "isTalking", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "overflowAudioCheckEnable", "prepareMuteTipAnimator", "refreshByTipStatus", "refreshErrBarTip", "refreshViews", "refreshMembersConfig", "", "Lkotlin/Pair;", "isAnchorRole", "forceRefresh", "resetCommonInfoEmptyTimesCheckIndex", "setupConfig", "showExceptionTipPanel", "silentAudioCheckEnable", "start", "startMuteTipAnim", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "stop", "stopMuteTipAnim", "temperatureCheckEnable", "unMount", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  extends b
{
  private static int CYK;
  private static int CYL;
  private static int CYM;
  public static final aj.a CYi;
  private ValueAnimator CYA;
  private int CYB;
  public int CYC;
  private final int CYD;
  private final int CYE;
  private final int CYF;
  private final int CYG;
  public bq CYH;
  public boolean CYI;
  private final e CYJ;
  private boolean CYj;
  private final WeImageView CYk;
  private final View CYl;
  private final TextView CYm;
  private final ViewGroup CYn;
  private final TextView CYo;
  private final PAGView CYp;
  private final ViewGroup CYq;
  private final TextView CYr;
  private final PAGView CYs;
  private final ViewGroup CYt;
  private final WeImageView CYu;
  private final a CYv;
  private final a CYw;
  private final a CYx;
  private AnimatorSet CYy;
  private ValueAnimator CYz;
  private final String TAG;
  private long duration;
  private int errType;
  private final com.tencent.mm.live.b.b nfT;
  private String nhA;
  private final TextView nho;
  private final TextView nhp;
  private final TextView nhq;
  private final View nhr;
  private final View nhs;
  private final View nht;
  private final ImageView nhu;
  private final ImageView nhv;
  private final Drawable nhw;
  private final Drawable nhx;
  private final Drawable nhy;
  private int nhz;
  private final ImageView yEV;
  
  static
  {
    AppMethodBeat.i(356096);
    CYi = new aj.a((byte)0);
    CYK = 1;
    CYL = 2;
    CYM = 4;
    AppMethodBeat.o(356096);
  }
  
  public aj(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355835);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveCommonInfoPlugin";
    paramb = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jSA().bmg()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.CYj = bool;
      paramb = paramViewGroup.findViewById(p.e.live_common_info_members_tv);
      s.s(paramb, "root.findViewById(R.id.l…e_common_info_members_tv)");
      this.nho = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(p.e.live_common_info_duration_tv);
      s.s(paramb, "root.findViewById(R.id.l…_common_info_duration_tv)");
      this.nhp = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(p.e.live_common_info_like_tv);
      s.s(paramb, "root.findViewById(R.id.live_common_info_like_tv)");
      this.nhq = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(p.e.live_common_info_members_group);
      s.s(paramb, "root.findViewById(R.id.l…ommon_info_members_group)");
      this.nhr = paramb;
      paramb = paramViewGroup.findViewById(p.e.live_common_info_duration_group);
      s.s(paramb, "root.findViewById(R.id.l…mmon_info_duration_group)");
      this.nhs = paramb;
      paramb = paramViewGroup.findViewById(p.e.live_common_info_like_group);
      s.s(paramb, "root.findViewById(R.id.l…e_common_info_like_group)");
      this.nht = paramb;
      paramb = paramViewGroup.findViewById(p.e.live_common_info_duration_icon);
      s.s(paramb, "root.findViewById(R.id.l…ommon_info_duration_icon)");
      this.nhu = ((ImageView)paramb);
      paramb = paramViewGroup.findViewById(p.e.live_common_info_arrow_icon);
      s.s(paramb, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
      this.nhv = ((ImageView)paramb);
      paramb = paramViewGroup.findViewById(p.e.live_common_info_like_icon);
      s.s(paramb, "root.findViewById(R.id.live_common_info_like_icon)");
      this.yEV = ((ImageView)paramb);
      paramb = paramViewGroup.findViewById(p.e.live_common_info_members_icon);
      s.s(paramb, "root.findViewById(R.id.l…common_info_members_icon)");
      this.CYk = ((WeImageView)paramb);
      paramb = paramViewGroup.findViewById(p.e.BWB);
      s.s(paramb, "root.findViewById(R.id.l…mon_info_low_speed_group)");
      this.CYl = paramb;
      paramb = paramViewGroup.findViewById(p.e.BWC);
      s.s(paramb, "root.findViewById(R.id.l…common_info_low_speed_tv)");
      this.CYm = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(p.e.BJW);
      s.s(paramb, "root.findViewById(R.id.f…on_info_audio_mode_group)");
      this.CYn = ((ViewGroup)paramb);
      paramb = paramViewGroup.findViewById(p.e.BKb);
      s.s(paramb, "root.findViewById(R.id.f…ommon_info_audio_mode_tv)");
      this.CYo = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(p.e.BJX);
      s.s(paramb, "root.findViewById(R.id.f…mon_info_audio_mode_icon)");
      this.CYp = ((PAGView)paramb);
      paramb = paramViewGroup.findViewById(p.e.BJY);
      s.s(paramb, "root.findViewById(R.id.f…info_audio_mode_pk_group)");
      this.CYq = ((ViewGroup)paramb);
      paramb = paramViewGroup.findViewById(p.e.BKa);
      s.s(paramb, "root.findViewById(R.id.f…on_info_audio_mode_pk_tv)");
      this.CYr = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(p.e.BJZ);
      s.s(paramb, "root.findViewById(R.id.f…_info_audio_mode_pk_icon)");
      this.CYs = ((PAGView)paramb);
      paramb = paramViewGroup.findViewById(p.e.BGM);
      s.s(paramb, "root.findViewById(R.id.f…ive_audio_mode_tip_group)");
      this.CYt = ((ViewGroup)paramb);
      paramb = paramViewGroup.findViewById(p.e.BKc);
      s.s(paramb, "root.findViewById(R.id.f…ive_common_info_mute_tip)");
      this.CYu = ((WeImageView)paramb);
      this.CYv = new a();
      this.CYw = new a();
      this.CYx = new a();
      paramb = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.1F }).setDuration(800L);
      paramb.addUpdateListener(new aj..ExternalSyntheticLambda1(this));
      ah localah = ah.aiuX;
      this.CYz = paramb;
      paramb = ObjectAnimator.ofFloat(new float[] { 0.1F, 1.0F }).setDuration(800L);
      paramb.addUpdateListener(new aj..ExternalSyntheticLambda0(this));
      localah = ah.aiuX;
      this.CYA = paramb;
      this.nhw = tP(p.g.live_net_good_icon);
      this.nhx = tP(p.g.live_net_normal_icon);
      this.nhy = tP(p.g.live_net_bad_icon);
      paramb = e.o.mLz;
      this.nhz = e.o.bdC();
      this.nhA = "00:00:00";
      this.CYC = 1;
      paramb = com.tencent.d.a.a.a.a.a.ahiX;
      this.CYD = ((Number)com.tencent.d.a.a.a.a.a.jUJ().bmg()).intValue();
      paramb = com.tencent.d.a.a.a.a.a.ahiX;
      this.CYE = ((Number)com.tencent.d.a.a.a.a.a.jUK().bmg()).intValue();
      paramb = com.tencent.d.a.a.a.a.a.ahiX;
      this.CYF = ((Number)com.tencent.d.a.a.a.a.a.jUL().bmg()).intValue();
      paramb = com.tencent.d.a.a.a.a.a.ahiX;
      this.CYG = ((Number)com.tencent.d.a.a.a.a.a.jUM().bmg()).intValue();
      this.CYI = true;
      this.CYJ = new e(this);
      this.yEV.setImageDrawable(bb.m(paramViewGroup.getContext(), p.g.icons_outlined_cheer, -1));
      if (eqc())
      {
        epX();
        this.nhr.setTag(p.e.BED, Boolean.TRUE);
      }
      this.CYl.setOnClickListener(new aj..ExternalSyntheticLambda3(this));
      this.CYp.setFile(PAGFile.Load(paramViewGroup.getContext().getAssets(), "finder_live_link_mic_wave.pag"));
      this.CYp.setRepeatCount(-1);
      this.CYs.setFile(PAGFile.Load(paramViewGroup.getContext().getAssets(), "finder_live_link_mic_wave.pag"));
      this.CYs.setRepeatCount(-1);
      this.CYk.setVisibility(8);
      this.CYu.setOnClickListener(new aj..ExternalSyntheticLambda4(this));
      paramb = new AnimatorSet();
      paramb.playSequentially(new Animator[] { (Animator)this.CYz, (Animator)this.CYA });
      localah = ah.aiuX;
      this.CYy = paramb;
      paramb = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      paramb = paramViewGroup.getContext();
      s.s(paramb, "root.context");
      com.tencent.mm.plugin.finder.accessibility.a.a(paramb, this.nho, 14.0F);
      paramb = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      paramb = paramViewGroup.getContext();
      s.s(paramb, "root.context");
      com.tencent.mm.plugin.finder.accessibility.a.a(paramb, this.nhp, 14.0F);
      paramb = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      paramViewGroup = paramViewGroup.getContext();
      s.s(paramViewGroup, "root.context");
      com.tencent.mm.plugin.finder.accessibility.a.a(paramViewGroup, this.nhq, 14.0F);
      Log.i(this.TAG, s.X("filterVisitorResetValue:", Boolean.valueOf(this.CYj)));
      AppMethodBeat.o(355835);
      return;
    }
  }
  
  private static final void a(aj paramaj)
  {
    AppMethodBeat.i(371508);
    s.u(paramaj, "this$0");
    paramaj.nhr.setVisibility(0);
    AppMethodBeat.o(371508);
  }
  
  private static final void a(aj paramaj, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(355909);
    s.u(paramaj, "this$0");
    paramaj = paramaj.CYu;
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramaj = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(355909);
      throw paramaj;
    }
    paramaj.setAlpha(((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(355909);
  }
  
  private static final void a(aj paramaj, View paramView)
  {
    Object localObject1 = null;
    View localView2 = null;
    View localView1 = null;
    AppMethodBeat.i(371503);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramaj, "this$0");
    ((ce)com.tencent.mm.kernel.h.ax(ce.class)).a(q.c.DrL, "2");
    switch (paramaj.eqa())
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(371503);
      return;
    case 8: 
      paramView = new com.tencent.mm.ui.widget.a.j(paramaj.mJe.getContext(), 2, 0, true, (byte)0);
      paramView.au((CharSequence)paramaj.mJe.getContext().getResources().getString(p.h.app_i_know));
      paramView.aFe(6);
      paramView.agfR = new aj..ExternalSyntheticLambda6(paramView);
      localView2 = af.mU(paramaj.mJe.getContext()).inflate(p.f.CcS, null);
      if (localView2 == null)
      {
        paramaj = null;
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.CoI));
        }
        if (localView2 != null) {
          break label452;
        }
        paramaj = null;
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.CoG));
        }
        if (localView2 != null) {
          break label466;
        }
        paramaj = null;
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.CoH));
        }
        if (localView2 != null) {
          break label480;
        }
        paramaj = null;
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.CoE));
        }
        if (localView2 != null) {
          break label494;
        }
        paramaj = null;
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.CoF));
        }
        if (localView2 != null) {
          break label508;
        }
        paramaj = null;
        if (paramaj != null) {
          paramaj.setVisibility(0);
        }
        if (localView2 != null) {
          break label519;
        }
      }
      for (paramaj = localView1;; paramaj = localView2.findViewById(p.e.BZz))
      {
        if (paramaj != null) {
          paramaj.setVisibility(0);
        }
        paramView.setCustomView(localView2);
        paramView.dDn();
        break;
        paramaj = (TextView)localView2.findViewById(p.e.BZE);
        break label257;
        paramaj = (TextView)localView2.findViewById(p.e.BZD);
        break label286;
        paramaj = (TextView)localView2.findViewById(p.e.BZD);
        break label315;
        paramaj = (TextView)localView2.findViewById(p.e.BZB);
        break label344;
        paramaj = (TextView)localView2.findViewById(p.e.BZC);
        break label373;
        paramaj = localView2.findViewById(p.e.BZA);
        break label402;
      }
    case 1: 
      paramView = new com.tencent.mm.ui.widget.a.j(paramaj.mJe.getContext(), 2, 0, true, (byte)0);
      paramView.au((CharSequence)paramaj.mJe.getContext().getResources().getString(p.h.app_i_know));
      paramView.aFe(6);
      paramView.agfR = new aj..ExternalSyntheticLambda7(paramView);
      localView1 = af.mU(paramaj.mJe.getContext()).inflate(p.f.Cda, null);
      if (localView1 == null) {}
      for (paramaj = localObject1;; paramaj = (TextView)localView1.findViewById(p.e.BZF))
      {
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.Cni));
        }
        paramView.setCustomView(localView1);
        paramView.dDn();
        break;
      }
    case 2: 
      label257:
      label286:
      label315:
      label344:
      label373:
      label508:
      paramView = new com.tencent.mm.ui.widget.a.j(paramaj.mJe.getContext(), 2, 0, true, (byte)0);
      label402:
      label452:
      label466:
      label480:
      label494:
      paramView.au((CharSequence)paramaj.mJe.getContext().getResources().getString(p.h.app_i_know));
      label519:
      paramView.aFe(6);
      paramView.agfR = new aj..ExternalSyntheticLambda5(paramView);
      localView1 = af.mU(paramaj.mJe.getContext()).inflate(p.f.CcS, null);
      if (localView1 == null)
      {
        paramaj = null;
        label748:
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.CsZ));
        }
        if (localView1 != null) {
          break label943;
        }
        paramaj = null;
        label777:
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.CsX));
        }
        if (localView1 != null) {
          break label957;
        }
        paramaj = null;
        label806:
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.CsY));
        }
        if (localView1 != null) {
          break label971;
        }
        paramaj = null;
        label835:
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.CsV));
        }
        if (localView1 != null) {
          break label985;
        }
        paramaj = null;
        label864:
        if (paramaj != null) {
          paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.CsW));
        }
        if (localView1 != null) {
          break label999;
        }
        paramaj = null;
        label893:
        if (paramaj != null) {
          paramaj.setVisibility(0);
        }
        if (localView1 != null) {
          break label1010;
        }
      }
      label943:
      label957:
      label971:
      label985:
      label999:
      label1010:
      for (paramaj = localView2;; paramaj = localView1.findViewById(p.e.BZz))
      {
        if (paramaj != null) {
          paramaj.setVisibility(0);
        }
        paramView.setCustomView(localView1);
        paramView.dDn();
        break;
        paramaj = (TextView)localView1.findViewById(p.e.BZE);
        break label748;
        paramaj = (TextView)localView1.findViewById(p.e.BZD);
        break label777;
        paramaj = (TextView)localView1.findViewById(p.e.BZD);
        break label806;
        paramaj = (TextView)localView1.findViewById(p.e.BZB);
        break label835;
        paramaj = (TextView)localView1.findViewById(p.e.BZC);
        break label864;
        paramaj = localView1.findViewById(p.e.BZA);
        break label893;
      }
    }
    paramView = new com.tencent.mm.ui.widget.a.j(paramaj.mJe.getContext(), 2, 0, true, (byte)0);
    paramView.au((CharSequence)paramaj.mJe.getContext().getResources().getString(p.h.app_i_know));
    paramView.aFe(6);
    paramView.agfR = new aj..ExternalSyntheticLambda8(paramView);
    localView1 = af.mU(paramaj.mJe.getContext()).inflate(p.f.Cda, null);
    if (localView1 == null) {}
    for (paramaj = null;; paramaj = (TextView)localView1.findViewById(p.e.BZF))
    {
      if (paramaj != null) {
        paramaj.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.Ctf));
      }
      paramView.setCustomView(localView1);
      paramView.dDn();
      break;
    }
  }
  
  private static final void a(List paramList, boolean paramBoolean1, boolean paramBoolean2, aj paramaj)
  {
    AppMethodBeat.i(371509);
    s.u(paramList, "$refreshMembersConfig");
    s.u(paramaj, "this$0");
    int i = paramaj.nhz;
    Object localObject1 = e.o.mLz;
    Iterator localIterator;
    if (i == e.o.bdC())
    {
      paramaj.nhu.setImageDrawable(paramaj.nhw);
      localObject1 = new StringBuilder("");
      bool2 = false;
      localIterator = ((Iterable)paramList).iterator();
      bool1 = false;
    }
    label250:
    label508:
    long l;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject2 = (kotlin.r)localIterator.next();
        Object localObject3;
        switch (((Number)((kotlin.r)localObject2).bsC).intValue())
        {
        default: 
          continue;
          localObject1 = e.o.mLz;
          if (i == e.o.bdD())
          {
            paramaj.nhu.setImageDrawable(paramaj.nhx);
            break;
          }
          localObject1 = e.o.mLz;
          if (i == e.o.bdF()) {
            i = 1;
          }
          while (i != 0)
          {
            paramaj.nhu.setImageDrawable(paramaj.nhy);
            break;
            localObject1 = e.o.mLz;
            if (i == e.o.bdE()) {
              i = 1;
            } else {
              i = 0;
            }
          }
        case 1: 
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            if (i != 0) {
              ((StringBuilder)localObject1).append(" · ");
            }
            localObject3 = (CharSequence)((kotlin.r)localObject2).bsD;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label320;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label326;
            }
            ((StringBuilder)localObject1).append((String)((kotlin.r)localObject2).bsD);
            break;
            i = 0;
            break label250;
          }
          localObject2 = am.aixg;
          localObject2 = paramaj.mJe.getContext().getString(p.h.CrQ);
          s.s(localObject2, "root.context.getString(R…purchase_user_count_tips)");
          localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { com.tencent.mm.plugin.finder.live.utils.a.jp(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)paramaj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eym()) }, 1));
          s.s(localObject2, "java.lang.String.format(format, *args)");
          ((StringBuilder)localObject1).append(String.valueOf(localObject2));
          break;
        case 2: 
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            if (i != 0) {
              ((StringBuilder)localObject1).append(" · ");
            }
            localObject3 = (CharSequence)((kotlin.r)localObject2).bsD;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label502;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label508;
            }
            ((StringBuilder)localObject1).append((String)((kotlin.r)localObject2).bsD);
            break;
            i = 0;
            break label432;
          }
          localObject2 = am.aixg;
          localObject2 = paramaj.mJe.getContext().getString(p.h.finder_live_members_total_tip);
          s.s(localObject2, "root.context.getString(R…r_live_members_total_tip)");
          localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { com.tencent.mm.plugin.finder.live.utils.a.jp(((e)paramaj.business(e.class)).EcL) }, 1));
          s.s(localObject2, "java.lang.String.format(format, *args)");
          ((StringBuilder)localObject1).append(String.valueOf(localObject2));
          break;
        case 3: 
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            if (i != 0) {
              ((StringBuilder)localObject1).append(" · ");
            }
            localObject3 = (CharSequence)((kotlin.r)localObject2).bsD;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label687;
            }
            i = 1;
            if (i != 0) {
              break label693;
            }
            ((StringBuilder)localObject1).append((String)((kotlin.r)localObject2).bsD);
          }
          for (;;)
          {
            bool2 = true;
            break;
            i = 0;
            break label614;
            i = 0;
            break label656;
            localObject2 = am.aixg;
            localObject2 = paramaj.mJe.getContext().getString(p.h.Cnq);
            s.s(localObject2, "root.context.getString(R….finder_live_members_tip)");
            localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { com.tencent.mm.plugin.finder.live.utils.a.jp(((f)paramaj.business(f.class)).liveInfo.DSe) }, 1));
            s.s(localObject2, "java.lang.String.format(format, *args)");
            ((StringBuilder)localObject1).append(String.valueOf(localObject2));
          }
        case 4: 
          label320:
          label326:
          label502:
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            if (i != 0) {
              ((StringBuilder)localObject1).append(" · ");
            }
            localObject3 = (CharSequence)((kotlin.r)localObject2).bsD;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label875;
            }
          }
          label432:
          label614:
          label875:
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label881;
            }
            ((StringBuilder)localObject1).append((String)((kotlin.r)localObject2).bsD);
            bool1 = true;
            break;
            i = 0;
            break label802;
          }
          label656:
          label687:
          label693:
          label881:
          localObject2 = am.aixg;
          label802:
          localObject2 = paramaj.mJe.getContext().getString(p.h.CtR);
          s.s(localObject2, "root.context.getString(R…ive_wecoin_amount_in_hot)");
          localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          localObject3 = com.tencent.mm.plugin.finder.live.utils.a.a(((f)paramaj.business(f.class)).liveInfo);
          if (localObject3 == null) {}
          for (l = 0L;; l = ((Long)localObject3).longValue())
          {
            localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { com.tencent.mm.plugin.finder.live.utils.a.jp(l) }, 1));
            s.s(localObject2, "java.lang.String.format(format, *args)");
            ((StringBuilder)localObject1).append(String.valueOf(localObject2));
            break;
          }
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    s.s(localObject1, "membersTvSb.toString()");
    localObject1 = new kotlin.u(Boolean.valueOf(bool2), Boolean.valueOf(bool1), localObject1);
    boolean bool1 = ((Boolean)((kotlin.u)localObject1).bsC).booleanValue();
    boolean bool2 = ((Boolean)((kotlin.u)localObject1).bsD).booleanValue();
    if (!paramBoolean1)
    {
      if ((!paramaj.eqc()) && (paramaj.CYj) && (!bool1) && (((e)paramaj.business(e.class)).EcL == 0) && (paramaj.CYC < 5)) {
        paramaj.CYC += 1;
      }
      for (i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(371509);
        return;
      }
    }
    if ((!paramBoolean2) && (!bool2)) {
      localIterator = ((Iterable)paramList).iterator();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList = localIterator.next();
        if (((Number)((kotlin.r)paramList).bsC).intValue() == 5)
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          label1203:
          if ((paramList == null) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)paramaj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eiv) && (!((e)paramaj.business(e.class)).DUe)) {
            break label1734;
          }
          i = 1;
          label1242:
          paramList = paramaj;
          if (i == 0) {
            break label1740;
          }
          paramList.nhv.setVisibility(0);
          label1257:
          paramaj.nho.setText((CharSequence)((kotlin.u)localObject1).aiuN);
          if (paramaj.nhr.getVisibility() != 0) {
            paramaj.nhr.postDelayed(new aj..ExternalSyntheticLambda9(paramaj), 1000L);
          }
          paramaj.nhr.setTag(p.e.BEE, paramaj.nho.getText());
          if (!paramBoolean2) {
            break label2005;
          }
          i = paramaj.nhz;
          paramList = e.o.mLz;
          if (i != e.o.bdE())
          {
            i = paramaj.nhz;
            paramList = e.o.mLz;
            if (i != e.o.bdF()) {
              break label1752;
            }
          }
          paramaj.errType |= 0x8;
          label1369:
          paramList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          label1417:
          label1456:
          if (com.tencent.mm.plugin.finder.live.utils.a.bUC())
          {
            if (paramaj.CYD < 0) {
              break label1766;
            }
            i = 1;
            label1389:
            if (i != 0)
            {
              paramList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
              paramBoolean1 = com.tencent.mm.plugin.finder.live.utils.a.isCharging();
              paramList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
              paramList = com.tencent.mm.plugin.finder.live.utils.a.euQ();
              if (paramList != null) {
                break label1772;
              }
              i = 0;
              paramList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
              int j = com.tencent.mm.plugin.finder.live.utils.a.euR();
              if ((!paramBoolean1) || (i < 25) || (j < paramaj.CYD)) {
                break label1781;
              }
              paramaj.errType |= 0x4;
              Log.i(paramaj.TAG, "checkErrBarTemperature isCharging:" + paramBoolean1 + " curBattery:" + i + " temperature:" + j + " temperatureThreshold:" + paramaj.CYD);
            }
          }
          switch (paramaj.eqa())
          {
          case 3: 
          case 5: 
          case 6: 
          case 7: 
          default: 
            paramaj.nhs.setVisibility(0);
            paramaj.CYl.setVisibility(4);
          }
        }
      }
    }
    for (;;)
    {
      paramaj.nhp.setText((CharSequence)String.valueOf(paramaj.nhA));
      paramaj.nht.setVisibility(8);
      if (paramaj.nfT.getLiveRole() == 1)
      {
        paramList = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.Doc.Dqo = ((f)paramaj.business(f.class)).liveInfo.DSe;
        paramList = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.Doc.Dqp = (paramaj.duration * 1000L);
        paramList = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.Doc.Dqn = ((e)paramaj.business(e.class)).EcF;
      }
      if (((e)paramaj.business(e.class)).DUe)
      {
        paramaj.epX();
        paramaj.nhs.setVisibility(8);
      }
      AppMethodBeat.o(371509);
      return;
      i = 0;
      break;
      paramList = null;
      break label1203;
      label1734:
      i = 0;
      break label1242;
      label1740:
      paramList.nhv.setVisibility(8);
      break label1257;
      label1752:
      paramaj.errType &= 0xFFFFFFF7;
      break label1369;
      label1766:
      i = 0;
      break label1389;
      label1772:
      i = paramList.intValue();
      break label1417;
      label1781:
      paramaj.errType &= 0xFFFFFFFB;
      break label1456;
      paramaj.CYl.setVisibility(0);
      paramaj.CYm.setText((CharSequence)paramaj.mJe.getContext().getResources().getString(p.h.CiG));
      paramaj.nhs.setVisibility(4);
      continue;
      if (paramaj.CYl.getVisibility() != 0) {
        ((ce)com.tencent.mm.kernel.h.ax(ce.class)).a(q.c.DrL, "1");
      }
      paramaj.CYl.setVisibility(0);
      paramaj.CYm.setText((CharSequence)paramaj.mJe.getContext().getResources().getString(p.h.CoD));
      paramaj.nhs.setVisibility(4);
      continue;
      paramaj.CYl.setVisibility(0);
      paramaj.CYm.setText((CharSequence)paramaj.mJe.getContext().getResources().getString(p.h.Ctg));
      paramaj.nhs.setVisibility(4);
      continue;
      paramaj.CYl.setVisibility(0);
      paramaj.CYm.setText((CharSequence)paramaj.mJe.getContext().getResources().getString(p.h.CiF));
      paramaj.nhs.setVisibility(4);
    }
    label2005:
    paramaj.nht.setVisibility(8);
    paramaj.nhs.setVisibility(8);
    paramList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((!com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (((e)paramaj.business(e.class)).eyr()))
    {
      paramList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramList = com.tencent.mm.plugin.finder.live.utils.a.a(((f)paramaj.business(f.class)).liveInfo);
      if (paramList != null) {
        break label2166;
      }
      l = 0L;
      if (l > 0L) {}
    }
    else if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)paramaj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eiv)
    {
      paramList = bj.GlQ;
      if ((!bj.y(paramaj.getBuContext())) || (paramaj.nhv.getVisibility() != 0)) {
        break label2175;
      }
    }
    label2166:
    label2175:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label2181;
      }
      paramaj.nhr.setOnClickListener((View.OnClickListener)paramaj.CYJ);
      paramaj.nhr.setTag(p.e.BED, Boolean.TRUE);
      AppMethodBeat.o(371509);
      return;
      l = paramList.longValue();
      break;
    }
    label2181:
    if (((e)paramaj.business(e.class)).DUe)
    {
      paramaj.epX();
      AppMethodBeat.o(371509);
      return;
    }
    paramaj.nhr.setOnClickListener(null);
    paramaj.nhr.setTag(p.e.BED, Boolean.FALSE);
    AppMethodBeat.o(371509);
  }
  
  private static final void b(aj paramaj, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(355917);
    s.u(paramaj, "this$0");
    paramaj = paramaj.CYu;
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramaj = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(355917);
      throw paramaj;
    }
    paramaj.setAlpha(((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(355917);
  }
  
  private static final void b(aj paramaj, View paramView)
  {
    AppMethodBeat.i(355959);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramaj, "this$0");
    b.b.a(paramaj.nfT, b.c.neb);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355959);
  }
  
  private static final void b(com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(355975);
    s.u(paramj, "$dialog");
    paramj.cyW();
    AppMethodBeat.o(355975);
  }
  
  private static final void c(aj paramaj, View paramView)
  {
    AppMethodBeat.i(371507);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramaj, "this$0");
    com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drz, String.valueOf(q.bm.DBv.action));
    b.b.a(paramaj.nfT, b.c.ndz);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(371507);
  }
  
  private static final void c(com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(355983);
    s.u(paramj, "$dialog");
    paramj.cyW();
    AppMethodBeat.o(355983);
  }
  
  private static final void d(com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(355989);
    s.u(paramj, "$dialog");
    paramj.cyW();
    AppMethodBeat.o(355989);
  }
  
  private static final void e(com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(371504);
    s.u(paramj, "$dialog");
    paramj.cyW();
    AppMethodBeat.o(371504);
  }
  
  private final void epX()
  {
    AppMethodBeat.i(355844);
    this.nhr.setOnClickListener(new aj..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(355844);
  }
  
  private final void epY()
  {
    AppMethodBeat.i(355851);
    AnimatorSet localAnimatorSet = this.CYy;
    if (localAnimatorSet != null) {
      localAnimatorSet.removeAllListeners();
    }
    localAnimatorSet = this.CYy;
    if (localAnimatorSet != null) {
      localAnimatorSet.cancel();
    }
    AppMethodBeat.o(355851);
  }
  
  private final void epZ()
  {
    int j = 1;
    AppMethodBeat.i(355864);
    if (!this.CYI)
    {
      AppMethodBeat.o(355864);
      return;
    }
    int i;
    if ((com.tencent.mm.ae.d.ee(this.CYB, CYK)) || (com.tencent.mm.ae.d.ee(this.CYB, CYM)))
    {
      this.CYn.setVisibility(0);
      if (com.tencent.mm.ae.d.ee(this.CYB, CYK))
      {
        this.CYo.setVisibility(0);
        if (!com.tencent.mm.ae.d.ee(this.CYB, CYM)) {
          break label250;
        }
        this.CYu.setVisibility(0);
        AnimatorSet localAnimatorSet = this.CYy;
        if (localAnimatorSet != null) {
          localAnimatorSet.removeAllListeners();
        }
        localAnimatorSet = this.CYy;
        if (localAnimatorSet != null) {
          localAnimatorSet.addListener((Animator.AnimatorListener)new g(this));
        }
        localAnimatorSet = this.CYy;
        if (localAnimatorSet != null) {
          localAnimatorSet.start();
        }
        this.CYp.setVisibility(4);
        this.CYp.stop();
        i = 1;
        label165:
        if (!com.tencent.mm.ae.d.ee(this.CYB, CYL)) {
          break label281;
        }
        this.CYq.setVisibility(0);
        i = j;
        if (!isLandscape())
        {
          i = j;
          if (!eqc()) {}
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label308;
      }
      this.CYt.setVisibility(0);
      AppMethodBeat.o(355864);
      return;
      this.CYo.setVisibility(8);
      this.CYp.setVisibility(4);
      this.CYp.stop();
      break;
      label250:
      this.CYu.setVisibility(4);
      epY();
      i = 1;
      break label165;
      this.CYn.setVisibility(8);
      i = 0;
      break label165;
      label281:
      this.CYq.setVisibility(8);
      this.CYs.setVisibility(4);
      this.CYs.stop();
    }
    label308:
    this.CYt.setVisibility(8);
    AppMethodBeat.o(355864);
  }
  
  private final int eqa()
  {
    AppMethodBeat.i(355874);
    if (com.tencent.mm.ae.d.ee(this.errType, 2))
    {
      AppMethodBeat.o(355874);
      return 2;
    }
    if (com.tencent.mm.ae.d.ee(this.errType, 8))
    {
      AppMethodBeat.o(355874);
      return 8;
    }
    if (com.tencent.mm.ae.d.ee(this.errType, 4))
    {
      AppMethodBeat.o(355874);
      return 4;
    }
    if (com.tencent.mm.ae.d.ee(this.errType, 1))
    {
      AppMethodBeat.o(355874);
      return 1;
    }
    AppMethodBeat.o(355874);
    return 0;
  }
  
  private boolean eqc()
  {
    AppMethodBeat.i(355899);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (((e)business(e.class)).DUe))
    {
      AppMethodBeat.o(355899);
      return true;
    }
    AppMethodBeat.o(355899);
    return false;
  }
  
  private final Drawable tP(int paramInt)
  {
    AppMethodBeat.i(355890);
    Drawable localDrawable = this.mJe.getContext().getResources().getDrawable(paramInt);
    s.s(localDrawable, "root.context.resources.getDrawable(resId)");
    AppMethodBeat.o(355890);
    return localDrawable;
  }
  
  public final void OX(int paramInt)
  {
    AppMethodBeat.i(356191);
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      int i = cn.getSyncServerTimeSecond();
      r.a locala = com.tencent.mm.live.model.r.mZi;
      this.nhA = r.a.a(i - paramInt, ":", false, false, false, 28);
      paramInt = i - paramInt;
      if (paramInt <= 0) {
        break label65;
      }
    }
    label65:
    for (long l = paramInt;; l = 0L)
    {
      this.duration = l;
      AppMethodBeat.o(356191);
      return;
    }
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(356253);
    s.u(paramLinkedHashMap, "micUserMap");
    com.tencent.mm.plugin.finder.live.viewmodel.data.h localh = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    Log.i(this.TAG, "onMicUserChanged: curLinkMicUser:" + localh + ", micUserMap:" + paramLinkedHashMap);
    int i;
    if ((localh != null) && (localh.EbD == true))
    {
      i = 1;
      if ((i != 0) && (((Map)paramLinkedHashMap).containsKey(localh.mXL))) {
        break label130;
      }
      this.CYB &= (CYL ^ 0xFFFFFFFF);
    }
    for (;;)
    {
      epZ();
      AppMethodBeat.o(356253);
      return;
      i = 0;
      break;
      label130:
      if (localh.AWE) {
        this.CYB |= CYL;
      } else {
        this.CYB &= (CYL ^ 0xFFFFFFFF);
      }
    }
  }
  
  public final void ar(Bundle paramBundle)
  {
    int k = 1;
    AppMethodBeat.i(356175);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    int i;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUC())
    {
      if (paramBundle == null)
      {
        i = 0;
        if (this.CYE < 0) {
          break label211;
        }
        j = 1;
        label35:
        if (j != 0) {
          this.CYv.data.add(Integer.valueOf(i));
        }
        if (this.CYF < 0) {
          break label216;
        }
        j = 1;
        label63:
        if (j != 0) {
          this.CYw.data.add(Integer.valueOf(i));
        }
        if (this.CYG < 0) {
          break label221;
        }
      }
      boolean bool;
      label211:
      label216:
      label221:
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          this.CYx.data.add(Integer.valueOf(i));
        }
        if (this.CYv.data.size() != this.CYE) {
          break label279;
        }
        this.CYv.ewf = true;
        paramBundle = ((Iterable)this.CYv.data).iterator();
        bool = true;
        while (paramBundle.hasNext())
        {
          i = ((Number)paramBundle.next()).intValue();
          localObject = e.i.mLb;
          if (i != e.i.bdk()) {
            bool = false;
          }
        }
        localObject = e.s.mLT;
        i = paramBundle.getInt(e.s.bdX(), 0);
        break;
        j = 0;
        break label35;
        j = 0;
        break label63;
      }
      Log.i(this.TAG, s.X("checkErrBarSilentAudio silent:", Boolean.valueOf(bool)));
      if (bool) {}
      for (i = this.errType | 0x2;; i = this.errType & 0xFFFFFFFD)
      {
        this.errType = i;
        this.CYv.data.clear();
        this.CYv.ewf = false;
        label279:
        if (this.CYw.data.size() != this.CYF) {
          break label427;
        }
        this.CYw.ewf = true;
        paramBundle = ((Iterable)this.CYw.data).iterator();
        bool = false;
        while (paramBundle.hasNext())
        {
          i = ((Number)paramBundle.next()).intValue();
          localObject = e.i.mLb;
          if (i == e.i.bdl()) {
            bool = true;
          }
        }
      }
      Log.i(this.TAG, s.X("checkErrBarMaxAudio audioOverflow:", Boolean.valueOf(bool)));
      if (bool)
      {
        i = this.errType | 0x1;
        this.errType = i;
        this.CYw.data.clear();
        this.CYw.ewf = false;
        label427:
        if (this.CYx.data.size() != this.CYG) {
          break label637;
        }
        this.CYx.ewf = true;
        paramBundle = ((Iterable)this.CYx.data).iterator();
        i = 0;
        label470:
        if (!paramBundle.hasNext()) {
          break label522;
        }
        j = ((Number)paramBundle.next()).intValue();
        localObject = e.i.mLb;
        if (j != e.i.bdm()) {
          break label668;
        }
        i += 1;
      }
    }
    label522:
    label663:
    label668:
    for (;;)
    {
      break label470;
      i = this.errType & 0xFFFFFFFE;
      break;
      Log.i(this.TAG, s.X("checkBreakAudio breakCount:", Integer.valueOf(i)));
      paramBundle = com.tencent.d.a.a.a.a.a.ahiX;
      if (i >= ((Number)com.tencent.d.a.a.a.a.a.jUN().bmg()).intValue())
      {
        i = k;
        if (i != 0)
        {
          paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if (!com.tencent.mm.plugin.finder.live.utils.a.bUC()) {
            break label649;
          }
          paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
          paramBundle = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.plugin.finder.live.model.aj.elM();
          label587:
          if (!(paramBundle instanceof com.tencent.mm.live.core.core.a.b)) {
            break label663;
          }
        }
      }
      for (paramBundle = (com.tencent.mm.live.core.core.a.b)paramBundle;; paramBundle = null)
      {
        if (paramBundle != null)
        {
          Log.i("MicroMsg.LiveCoreAnchor", "restartAudioDevice");
          paramBundle.callLiveExperimentalAPI("");
        }
        this.CYx.data.clear();
        this.CYx.ewf = false;
        label637:
        AppMethodBeat.o(356175);
        return;
        i = 0;
        break;
        paramBundle = com.tencent.mm.plugin.finder.live.model.aj.CGT;
        paramBundle = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.plugin.finder.live.model.aj.elL();
        break label587;
      }
    }
  }
  
  public final void b(List<kotlin.r<Integer, String>> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(356182);
    s.u(paramList, "refreshMembersConfig");
    this.mJe.post(new aj..ExternalSyntheticLambda10(paramList, paramBoolean2, paramBoolean1, this));
    AppMethodBeat.o(356182);
  }
  
  public final void emx()
  {
    AppMethodBeat.i(356216);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(356216);
  }
  
  public final void emy()
  {
    AppMethodBeat.i(356222);
    Log.i(this.TAG, s.X("checkPkAnchorAudioVolume business(LiveLinkMicSlice::class.java).curLinkMicUser:", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv));
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(356222);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void eqb()
  {
    AppMethodBeat.i(356201);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.n(getBuContext()))
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.o(getBuContext())) {}
    }
    else
    {
      localObject = com.tencent.mm.live.core.core.e.a.mRf;
      this.nhz = a.a.beN().mRB.mNT;
      AppMethodBeat.o(356201);
      return;
    }
    localObject = com.tencent.mm.live.core.core.a.b.mMo;
    if (b.a.bek())
    {
      localObject = com.tencent.mm.live.core.core.a.b.mMo;
      this.nhz = b.a.bej().mRB.mNT;
    }
    AppMethodBeat.o(356201);
  }
  
  public final void qJ(final boolean paramBoolean)
  {
    AppMethodBeat.i(356207);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramBoolean));
    AppMethodBeat.o(356207);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(356273);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(356273);
      return;
      tO(8);
      AppMethodBeat.o(356273);
      return;
      if (paramBundle == null) {
        if (!bool) {
          break label129;
        }
      }
      label129:
      for (this.CYB |= CYK;; this.CYB &= (CYK ^ 0xFFFFFFFF))
      {
        epZ();
        AppMethodBeat.o(356273);
        return;
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", false);
        break;
      }
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUC())
      {
        if (paramBundle == null)
        {
          bool = false;
          ((e)business(e.class)).Eem = bool;
          if (!bool) {
            break label219;
          }
        }
        label219:
        for (this.CYB |= CYM;; this.CYB &= (CYM ^ 0xFFFFFFFF))
        {
          epZ();
          AppMethodBeat.o(356273);
          return;
          bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_IS_MUTE_MIC", false);
          break;
        }
        if (((e)business(e.class)).Eem) {}
        for (this.CYB |= CYM;; this.CYB &= (CYM ^ 0xFFFFFFFF))
        {
          epZ();
          paramc = bj.GlQ;
          if (!bj.y(getBuContext())) {
            break;
          }
          int i = ((Number)eoH().getScreenSize().bsC).intValue();
          this.nho.setMaxWidth(i - com.tencent.mm.cd.a.fromDPToPix(this.mJe.getContext(), 170));
          AppMethodBeat.o(356273);
          return;
        }
        this.nho.setMaxWidth(2147483647);
        AppMethodBeat.o(356273);
        return;
        if ((this.CYq.getVisibility() == 0) && (!isLandscape())) {
          eqc();
        }
      }
    }
  }
  
  public final void stop() {}
  
  public final void unMount()
  {
    AppMethodBeat.i(356240);
    super.unMount();
    epY();
    this.errType = 0;
    this.CYv.data.clear();
    this.CYw.data.clear();
    this.CYx.data.clear();
    AppMethodBeat.o(356240);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(aj paramaj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(aj paramaj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$membersGroupVisitorClickListener$1", "Landroid/view/View$OnClickListener;", "onClick", "", "view", "Landroid/view/View;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements View.OnClickListener
  {
    e(aj paramaj) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(354082);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$membersGroupVisitorClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      paramView = bj.GlQ;
      if (bj.y(this.CYN.getBuContext()))
      {
        paramView = (com.tencent.mm.plugin.finder.live.olympic.i)this.CYN.getPlugin(com.tencent.mm.plugin.finder.live.olympic.i.class);
        if (paramView != null) {
          paramView.ehV();
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$membersGroupVisitorClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(354082);
        return;
        if (aj.i(this.CYN).getLiveRole() == 0) {
          k.Doi.a(q.cc.DEy, "", 0);
        }
        b.b.a(aj.i(this.CYN), b.c.ndz);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(aj paramaj, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$startMuteTipAnim$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends AnimatorListenerAdapter
  {
    g(aj paramaj) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(354051);
      if (aj.b(this.CYN).getVisibility() == 0)
      {
        paramAnimator = aj.c(this.CYN);
        if (paramAnimator != null) {
          paramAnimator.start();
        }
      }
      AppMethodBeat.o(354051);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aj
 * JD-Core Version:    0.7.0.1
 */