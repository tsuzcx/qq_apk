package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.plugin.ba;
import com.tencent.mm.plugin.finder.live.plugin.ba.b;
import com.tencent.mm.plugin.finder.live.plugin.bc;
import com.tencent.mm.plugin.finder.live.plugin.bc.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBattleBarWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "END_PK_DRAW_PAG", "", "END_PK_DRAW_PAG_EN", "END_PK_WIN_PAG", "END_PK_WIN_PAG_EN", "START_PK_PAG", "STATUS_END_BATTLE", "", "STATUS_START_BATTLE", "TAG", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "battleEndCallback", "Lkotlin/Function0;", "", "getBattleEndCallback", "()Lkotlin/jvm/functions/Function0;", "setBattleEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "battleEndView", "Lorg/libpag/PAGView;", "battleStartOtherUserAvatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "battleStartOtherUserGroup", "Landroid/view/View;", "battleStartOtherUserNickname", "Landroid/widget/TextView;", "battleStartSelfUserAvatar", "battleStartSelfUserGroup", "battleStartSelfUserNickname", "battleStartUserGroup", "battleStartView", "cacheVisibility", "getCacheVisibility", "()I", "setCacheVisibility", "(I)V", "countingTipView", "localCountDownTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "lotteryBubbleShow", "", "luckyMoneyBubbleShow", "otherRewardGroup", "otherRewardTv", "pkUserAudioMode", "getPkUserAudioMode", "()Z", "setPkUserAudioMode", "(Z)V", "getRoot", "()Landroid/view/ViewGroup;", "selfRewardGroup", "selfRewardTv", "status", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "timeTvView", "timerView", "topInfoBarGroup", "topInfoIcon", "topInfoOtherBar", "topTipView", "adjustEndViewLayout", "battleEnd", "withAnim", "battleStart", "coundDown", "fillStartUserInfo", "genEndPagRes", "getTRTCCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "onLotteryBubbleLocationChange", "lotteryLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "onLuckyMoneyBubbleLocationChange", "luckyMoneyLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$ShowingLocation;", "postStartUserHideAnimation", "reset", "setVisible", "visible", "showCounting", "updateBattleBar", "selfBattleInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveBattlePlayerInfo;", "otherBattleInfo", "updateBattleInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public int CTl;
  final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private final String EmM;
  private final String EmN;
  private final String EmO;
  private final String EmP;
  private final String EmQ;
  final int EmR;
  private final int EmS;
  final PAGView EmT;
  private final PAGView EmU;
  final View EmV;
  private final View EmW;
  final View EmX;
  private final View EmY;
  private final ImageView EmZ;
  private final TextView Ena;
  private final View Enb;
  private final ImageView Enc;
  private final TextView End;
  private final ImageView Ene;
  final View Enf;
  private final TextView Eng;
  final View Enh;
  final View Eni;
  private final TextView Enj;
  private final TextView Enk;
  private final View Enl;
  private final View Enm;
  public boolean Enn;
  public boolean Eno;
  private final MTimerHandler Enp;
  public boolean Enq;
  public kotlin.g.a.a<ah> Enr;
  public final String TAG;
  public final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  int status;
  
  public r(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(362201);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "FinderLiveBattleTopInfoWidget";
    this.EmM = "finder_live_pk_start.pag";
    this.EmN = "finder_live_pk_result_win.pag";
    this.EmO = "finder_live_pk_result_win_en.pag";
    this.EmP = "finder_live_pk_result_draw.pag";
    this.EmQ = "finder_live_pk_result_draw_en.pag";
    this.EmS = 1;
    paramViewGroup = this.mJe.findViewById(p.e.BHl);
    s.s(paramViewGroup, "root.findViewById(R.id.f…er_live_battle_start_pag)");
    this.EmT = ((PAGView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BGZ);
    s.s(paramViewGroup, "root.findViewById(R.id.finder_live_battle_end_pag)");
    this.EmU = ((PAGView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BHy);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ve_battle_top_status_bar)");
    this.EmV = paramViewGroup;
    paramViewGroup = this.mJe.findViewById(p.e.BHA);
    s.s(paramViewGroup, "root.findViewById(R.id.f…tle_top_status_bar_other)");
    this.EmW = paramViewGroup;
    this.EmX = this.mJe.findViewById(p.e.BHp);
    this.EmY = this.mJe.findViewById(p.e.BHn);
    this.EmZ = ((ImageView)this.mJe.findViewById(p.e.BHm));
    this.Ena = ((TextView)this.mJe.findViewById(p.e.BHo));
    this.Enb = this.mJe.findViewById(p.e.BHj);
    this.Enc = ((ImageView)this.mJe.findViewById(p.e.BHi));
    this.End = ((TextView)this.mJe.findViewById(p.e.BHk));
    paramViewGroup = this.mJe.findViewById(p.e.BHz);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ttle_top_status_bar_icon)");
    this.Ene = ((ImageView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BHB);
    s.s(paramViewGroup, "root.findViewById(R.id.f…er_live_battle_top_timer)");
    this.Enf = paramViewGroup;
    paramViewGroup = this.mJe.findViewById(p.e.BHD);
    s.s(paramViewGroup, "root.findViewById(R.id.f…live_battle_top_timer_tv)");
    this.Eng = ((TextView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BHC);
    s.s(paramViewGroup, "root.findViewById(R.id.f…e_battle_top_timer_group)");
    this.Enh = paramViewGroup;
    paramViewGroup = this.mJe.findViewById(p.e.BHs);
    s.s(paramViewGroup, "root.findViewById(R.id.f…attle_top_counting_group)");
    this.Eni = paramViewGroup;
    paramViewGroup = this.mJe.findViewById(p.e.BHw);
    s.s(paramViewGroup, "root.findViewById(R.id.f…_battle_top_info_self_tv)");
    this.Enj = ((TextView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BHu);
    s.s(paramViewGroup, "root.findViewById(R.id.f…battle_top_info_other_tv)");
    this.Enk = ((TextView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BHt);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ve_battle_top_info_other)");
    this.Enl = paramViewGroup;
    paramViewGroup = this.mJe.findViewById(p.e.BHv);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ive_battle_top_info_self)");
    this.Enm = paramViewGroup;
    this.status = this.EmR;
    this.Enp = new MTimerHandler(new r..ExternalSyntheticLambda0(this), true);
    this.EmT.setFile(PAGFile.Load(this.mJe.getContext().getAssets(), this.EmM));
    this.EmT.addListener((PAGView.PAGViewListener)new PAGView.PAGViewListener()
    {
      public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
      
      public final void onAnimationEnd(PAGView paramAnonymousPAGView)
      {
        com.tencent.mm.plugin.finder.live.viewmodel.data.e locale = null;
        AppMethodBeat.i(362112);
        Log.i(this.Ens.TAG, s.X("onAnimationEnd status:", Integer.valueOf(this.Ens.status)));
        com.tencent.mm.plugin.finder.live.model.i locali;
        if (this.Ens.status == this.Ens.EmR)
        {
          this.Ens.EmT.setVisibility(8);
          this.Ens.EmV.setVisibility(0);
          this.Ens.Enf.setVisibility(0);
          this.Ens.Enh.setVisibility(0);
          this.Ens.Eni.setVisibility(8);
          paramAnonymousPAGView = ((j)this.Ens.CwG.business(j.class)).EfK;
          if (paramAnonymousPAGView != null) {
            break label169;
          }
          paramAnonymousPAGView = null;
          locali = ((j)this.Ens.CwG.business(j.class)).EfK;
          if (locali != null) {
            break label195;
          }
        }
        for (;;)
        {
          r.a(this.Ens, paramAnonymousPAGView, locale);
          AppMethodBeat.o(362112);
          return;
          label169:
          paramAnonymousPAGView = paramAnonymousPAGView.awu(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.Ens.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
          break;
          label195:
          locale = locali.awt(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.Ens.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
        }
      }
      
      public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
      
      public final void onAnimationStart(PAGView paramAnonymousPAGView)
      {
        AppMethodBeat.i(362120);
        Log.i(this.Ens.TAG, s.X("onAnimationStart status:", Integer.valueOf(this.Ens.status)));
        if (this.Ens.status == this.Ens.EmR)
        {
          this.Ens.EmX.setAlpha(0.0F);
          this.Ens.EmX.setVisibility(0);
          this.Ens.EmX.animate().alpha(1.0F).setListener(null).setDuration(500L).setInterpolator((TimeInterpolator)new AccelerateInterpolator()).start();
          r.d(this.Ens);
        }
        AppMethodBeat.o(362120);
      }
    });
    int i = bf.bf(this.mJe.getContext()).x / 2;
    paramViewGroup = this.EmY.getLayoutParams();
    if ((paramViewGroup instanceof ViewGroup.MarginLayoutParams))
    {
      paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
      if (paramViewGroup != null) {
        paramViewGroup.setMarginEnd(i * 7 / 25 + i);
      }
      paramViewGroup = this.Enb.getLayoutParams();
      if (!(paramViewGroup instanceof ViewGroup.MarginLayoutParams)) {
        break label771;
      }
    }
    label771:
    for (paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;; paramViewGroup = null)
    {
      if (paramViewGroup != null) {
        paramViewGroup.setMarginStart(i * 7 / 25 + i);
      }
      paramViewGroup = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      paramViewGroup = this.mJe.getContext();
      s.s(paramViewGroup, "root.context");
      float f = com.tencent.mm.plugin.finder.accessibility.a.g(paramViewGroup, 12.0F);
      this.Enj.setTextSize(1, f);
      this.Enk.setTextSize(1, f);
      paramViewGroup = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      paramViewGroup = this.mJe.getContext();
      s.s(paramViewGroup, "root.context");
      f = com.tencent.mm.plugin.finder.accessibility.a.g(paramViewGroup, 14.0F);
      this.Eng.setTextSize(1, f);
      AppMethodBeat.o(362201);
      return;
      paramViewGroup = null;
      break;
    }
  }
  
  private final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.e parame1, com.tencent.mm.plugin.finder.live.viewmodel.data.e parame2)
  {
    AppMethodBeat.i(362226);
    this.EmV.post(new r..ExternalSyntheticLambda1(parame1, parame2, this));
    AppMethodBeat.o(362226);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.e parame1, com.tencent.mm.plugin.finder.live.viewmodel.data.e parame2, r paramr)
  {
    AppMethodBeat.i(362270);
    s.u(paramr, "this$0");
    int j;
    int k;
    int m;
    int n;
    long l;
    int i;
    if ((parame1 != null) && (parame2 != null))
    {
      j = paramr.Enm.getRight();
      k = bd.fromDPToPix(paramr.mJe.getContext(), 16);
      m = paramr.Enl.getLeft();
      n = bd.fromDPToPix(paramr.mJe.getContext(), 16);
      l = parame1.Ebj;
      l = parame2.Ebj + l;
      if (paramr.Ene.getMeasuredWidth() <= 0) {
        i = com.tencent.mm.cd.a.fromDPToPix(paramr.mJe.getContext(), 9.6F);
      }
      while (l == 0L)
      {
        parame1 = paramr.Ene.getLayoutParams();
        if (parame1 == null)
        {
          parame1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(362270);
          throw parame1;
          i = paramr.Ene.getMeasuredWidth();
        }
        else
        {
          ((ViewGroup.MarginLayoutParams)parame1).setMarginStart(bf.bf(paramr.mJe.getContext()).x / 2 - i / 2);
          parame1 = paramr.EmW.getLayoutParams();
          if (parame1 == null)
          {
            parame1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(362270);
            throw parame1;
          }
          ((ViewGroup.MarginLayoutParams)parame1).setMarginStart(bf.bf(paramr.mJe.getContext()).x / 2);
        }
      }
    }
    for (;;)
    {
      paramr.EmV.requestLayout();
      AppMethodBeat.o(362270);
      return;
      float f = kotlin.k.k.bu(kotlin.k.k.bt((float)parame1.Ebj / (float)l * bf.bf(paramr.mJe.getContext()).x, j + k), m - n);
      parame1 = paramr.Ene.getLayoutParams();
      if (parame1 == null)
      {
        parame1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(362270);
        throw parame1;
      }
      ((ViewGroup.MarginLayoutParams)parame1).setMarginStart((int)f - i / 2);
      parame1 = paramr.EmW.getLayoutParams();
      if (parame1 == null)
      {
        parame1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(362270);
        throw parame1;
      }
      ((ViewGroup.MarginLayoutParams)parame1).setMarginStart((int)f);
    }
  }
  
  private static final boolean a(r paramr)
  {
    AppMethodBeat.i(362241);
    s.u(paramr, "this$0");
    Object localObject = ((j)paramr.CwG.business(j.class)).EfK;
    if (localObject == null) {}
    for (int i = 0; i == 0; i = ((com.tencent.mm.plugin.finder.live.model.i)localObject).CEU)
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUC())
      {
        Log.i(paramr.TAG, "showCounting");
        paramr.Eni.setVisibility(0);
        paramr.Enh.setVisibility(8);
      }
      AppMethodBeat.o(362241);
      return false;
    }
    localObject = ((j)paramr.CwG.business(j.class)).EfK;
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.model.i)localObject).CEW == 2))
    {
      i = 1;
      if (i == 0) {
        break label344;
      }
      localObject = ((j)paramr.CwG.business(j.class)).EfK;
      if (localObject != null) {
        break label279;
      }
      i = 0;
    }
    for (;;)
    {
      if (i > 0)
      {
        Log.i(paramr.TAG, "coundDown");
        localObject = ((j)paramr.CwG.business(j.class)).EfK;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.live.model.i)localObject).CEU -= 1;
          if (((com.tencent.mm.plugin.finder.live.model.i)localObject).CEU < 10)
          {
            paramr.Eng.setText((CharSequence)s.X("0", Integer.valueOf(((com.tencent.mm.plugin.finder.live.model.i)localObject).CEU)));
            paramr.Eng.setScaleX(1.5F);
            paramr.Eng.setScaleY(1.5F);
            paramr.Eng.animate().scaleX(1.0F).scaleY(1.0F).start();
          }
        }
        else
        {
          AppMethodBeat.o(362241);
          return true;
          i = 0;
          break;
          label279:
          i = ((com.tencent.mm.plugin.finder.live.model.i)localObject).CEU;
          continue;
        }
        localObject = paramr.Eng;
        com.tencent.mm.live.model.r.a locala = com.tencent.mm.live.model.r.mZi;
        paramr = ((j)paramr.CwG.business(j.class)).EfK;
        if (paramr == null) {}
        for (i = 0;; i = paramr.CEU)
        {
          ((TextView)localObject).setText((CharSequence)com.tencent.mm.live.model.r.a.I(i, ":"));
          break;
        }
      }
    }
    label344:
    AppMethodBeat.o(362241);
    return false;
  }
  
  private static final void b(r paramr)
  {
    AppMethodBeat.i(362248);
    s.u(paramr, "this$0");
    paramr.EmX.animate().alpha(0.0F).setDuration(500L).setListener((Animator.AnimatorListener)new a(paramr)).start();
    AppMethodBeat.o(362248);
  }
  
  private static final void c(r paramr)
  {
    AppMethodBeat.i(362258);
    s.u(paramr, "this$0");
    paramr.EmT.play();
    AppMethodBeat.o(362258);
  }
  
  private static com.tencent.mm.live.core.core.trtc.a eAc()
  {
    AppMethodBeat.i(362210);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject = aj.CGT;
      localObject = (com.tencent.mm.live.core.core.trtc.a)aj.elM();
      AppMethodBeat.o(362210);
      return localObject;
    }
    localObject = aj.CGT;
    localObject = (com.tencent.mm.live.core.core.trtc.a)aj.elL();
    AppMethodBeat.o(362210);
    return localObject;
  }
  
  private final String eAe()
  {
    AppMethodBeat.i(362219);
    Object localObject = ((j)this.CwG.business(j.class)).EfK;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label66;
      }
      label33:
      if (localObject != null) {
        break label106;
      }
      label37:
      if (localObject != null) {
        break label146;
      }
      label41:
      if (localObject != null) {
        break label186;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(362219);
      return "";
      localObject = Integer.valueOf(((com.tencent.mm.plugin.finder.live.model.i)localObject).CEV);
      break;
      label66:
      if (((Integer)localObject).intValue() != 2) {
        break label33;
      }
      if (LocaleUtil.isChineseAppLang())
      {
        localObject = this.EmN;
        AppMethodBeat.o(362219);
        return localObject;
      }
      localObject = this.EmO;
      AppMethodBeat.o(362219);
      return localObject;
      label106:
      if (((Integer)localObject).intValue() != 1) {
        break label37;
      }
      if (LocaleUtil.isChineseAppLang())
      {
        localObject = this.EmN;
        AppMethodBeat.o(362219);
        return localObject;
      }
      localObject = this.EmO;
      AppMethodBeat.o(362219);
      return localObject;
      label146:
      if (((Integer)localObject).intValue() != 3) {
        break label41;
      }
      if (LocaleUtil.isChineseAppLang())
      {
        localObject = this.EmP;
        AppMethodBeat.o(362219);
        return localObject;
      }
      localObject = this.EmQ;
      AppMethodBeat.o(362219);
      return localObject;
      label186:
      ((Integer)localObject).intValue();
    }
  }
  
  public final void eAd()
  {
    float f2 = 0.0F;
    int j = 0;
    AppMethodBeat.i(362362);
    Object localObject1 = ((j)this.CwG.business(j.class)).EfK;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label72;
      }
      label42:
      if (localObject1 != null) {
        break label288;
      }
    }
    label286:
    label670:
    for (;;)
    {
      label414:
      label799:
      if (localObject1 == null)
      {
        AppMethodBeat.o(362362);
        return;
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.finder.live.model.i)localObject1).CEV);
        break;
        label72:
        if (((Integer)localObject1).intValue() != 2) {
          break label42;
        }
        this.EmU.setVisibility(0);
        if (!(this.EmU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          break label1082;
        }
        localObject1 = this.EmU.getLayoutParams();
        if ((localObject1 instanceof RelativeLayout.LayoutParams))
        {
          localObject1 = (RelativeLayout.LayoutParams)localObject1;
          if (localObject1 != null) {
            ((RelativeLayout.LayoutParams)localObject1).setMarginStart(bf.bf(this.CwG.mJe.getContext()).x / 2);
          }
          if (!this.Enq) {
            break label233;
          }
          localObject1 = this.EmU.getLayoutParams();
          if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
            break label227;
          }
          localObject1 = (RelativeLayout.LayoutParams)localObject1;
          label185:
          if (localObject1 != null) {
            ((RelativeLayout.LayoutParams)localObject1).topMargin = bd.fromDPToPix(this.mJe.getContext(), 24);
          }
        }
        for (;;)
        {
          this.EmU.requestLayout();
          AppMethodBeat.o(362362);
          return;
          localObject1 = null;
          break;
          label227:
          localObject1 = null;
          break label185;
          label233:
          localObject1 = this.EmU.getLayoutParams();
          if ((localObject1 instanceof RelativeLayout.LayoutParams)) {}
          for (localObject1 = (RelativeLayout.LayoutParams)localObject1;; localObject1 = null)
          {
            if (localObject1 == null) {
              break label286;
            }
            ((RelativeLayout.LayoutParams)localObject1).topMargin = bd.fromDPToPix(this.mJe.getContext(), 8);
            break;
          }
        }
        label288:
        if (((Integer)localObject1).intValue() == 1)
        {
          this.EmU.setVisibility(0);
          if (!(this.EmU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            break label1082;
          }
          localObject1 = this.EmU.getLayoutParams();
          int i;
          label436:
          int k;
          int m;
          label495:
          Object localObject2;
          label552:
          float f1;
          if ((localObject1 instanceof RelativeLayout.LayoutParams))
          {
            localObject1 = (RelativeLayout.LayoutParams)localObject1;
            if (localObject1 != null) {
              ((RelativeLayout.LayoutParams)localObject1).setMarginStart(0);
            }
            localObject1 = eAc();
            if (localObject1 == null) {
              break label733;
            }
            localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
            if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).bex() != true)) {
              break label733;
            }
            i = 1;
            if (i == 0) {
              break label744;
            }
            localObject1 = this.EmU.getLayoutParams();
            if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
              break label738;
            }
            localObject1 = (RelativeLayout.LayoutParams)localObject1;
            if (localObject1 != null) {
              ((RelativeLayout.LayoutParams)localObject1).topMargin = bd.fromDPToPix(this.mJe.getContext(), 24);
            }
            if (this.Enn)
            {
              k = com.tencent.mm.ae.d.cZ((View)this.mJe)[1];
              m = bd.fromDPToPix(this.mJe.getContext(), 12);
              localObject1 = this.EmU.getLayoutParams();
              if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
                break label799;
              }
              localObject1 = (RelativeLayout.LayoutParams)localObject1;
              if (localObject1 != null)
              {
                localObject2 = this.EmU.getLayoutParams();
                if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
                  break label805;
                }
                localObject2 = (RelativeLayout.LayoutParams)localObject2;
                if (localObject2 != null) {
                  break label811;
                }
                i = 0;
                localObject2 = this.nfT;
                if (!(localObject2 instanceof com.tencent.mm.plugin.finder.live.view.a)) {
                  break label820;
                }
                localObject2 = (com.tencent.mm.plugin.finder.live.view.a)localObject2;
                if (localObject2 != null) {
                  break label826;
                }
                f1 = 0.0F;
                label559:
                ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)f1 + i - (k + m));
              }
            }
            label691:
            if (this.Eno)
            {
              k = com.tencent.mm.ae.d.cZ((View)this.mJe)[1];
              m = bd.fromDPToPix(this.mJe.getContext(), 12);
              localObject1 = this.EmU.getLayoutParams();
              if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
                break label858;
              }
              localObject1 = (RelativeLayout.LayoutParams)localObject1;
              label633:
              if (localObject1 != null)
              {
                localObject2 = this.EmU.getLayoutParams();
                if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
                  break label864;
                }
                localObject2 = (RelativeLayout.LayoutParams)localObject2;
                if (localObject2 != null) {
                  break label870;
                }
                i = j;
                localObject2 = this.nfT;
                if (!(localObject2 instanceof com.tencent.mm.plugin.finder.live.view.a)) {
                  break label879;
                }
                localObject2 = (com.tencent.mm.plugin.finder.live.view.a)localObject2;
                if (localObject2 != null) {
                  break label885;
                }
                f1 = f2;
              }
            }
          }
          for (;;)
          {
            ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)f1 + i - (k + m));
            this.EmU.requestLayout();
            AppMethodBeat.o(362362);
            return;
            localObject1 = null;
            break;
            label733:
            i = 0;
            break label386;
            label738:
            localObject1 = null;
            break label414;
            label744:
            localObject1 = this.EmU.getLayoutParams();
            if ((localObject1 instanceof RelativeLayout.LayoutParams)) {}
            for (localObject1 = (RelativeLayout.LayoutParams)localObject1;; localObject1 = null)
            {
              if (localObject1 == null) {
                break label797;
              }
              ((RelativeLayout.LayoutParams)localObject1).topMargin = bd.fromDPToPix(this.mJe.getContext(), 8);
              break;
            }
            break label436;
            localObject1 = null;
            break label495;
            label805:
            localObject2 = null;
            break label524;
            label811:
            i = ((RelativeLayout.LayoutParams)localObject2).topMargin;
            break label531;
            label820:
            localObject2 = null;
            break label552;
            label826:
            localObject2 = (bc)((com.tencent.mm.plugin.finder.live.view.a)localObject2).getPlugin(bc.class);
            if (localObject2 == null)
            {
              f1 = 0.0F;
              break label559;
            }
            f1 = ((bc)localObject2).eqY();
            break label559;
            label858:
            localObject1 = null;
            break label633;
            label864:
            localObject2 = null;
            break label662;
            label870:
            i = ((RelativeLayout.LayoutParams)localObject2).topMargin;
            break label670;
            label879:
            localObject2 = null;
            break label691;
            label885:
            localObject2 = (ba)((com.tencent.mm.plugin.finder.live.view.a)localObject2).getPlugin(ba.class);
            f1 = f2;
            if (localObject2 != null) {
              f1 = ((ba)localObject2).eiI();
            }
          }
        }
      }
    }
    label386:
    label524:
    label531:
    label662:
    label797:
    if (((Integer)localObject1).intValue() == 3)
    {
      this.EmU.setVisibility(0);
      if ((this.EmU.getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        localObject1 = this.EmU.getLayoutParams();
        if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
          break label1089;
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (localObject1 != null) {
          ((RelativeLayout.LayoutParams)localObject1).setMarginStart(bf.bf(this.CwG.mJe.getContext()).x / 2 - bd.fromDPToPix(this.CwG.mJe.getContext(), 104) / 2);
        }
        if (!this.Enq) {
          break label1101;
        }
        localObject1 = this.EmU.getLayoutParams();
        if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
          break label1095;
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (localObject1 != null) {
          ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.Enf.getMeasuredHeight() + bd.fromDPToPix(this.mJe.getContext(), 24));
        }
      }
    }
    label1162:
    for (;;)
    {
      label1045:
      this.EmU.requestLayout();
      label1082:
      AppMethodBeat.o(362362);
      return;
      label1089:
      localObject1 = null;
      break;
      label1095:
      localObject1 = null;
      break label1045;
      label1101:
      localObject1 = this.EmU.getLayoutParams();
      if ((localObject1 instanceof RelativeLayout.LayoutParams)) {}
      for (localObject1 = (RelativeLayout.LayoutParams)localObject1;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label1162;
        }
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.Enf.getMeasuredHeight() + bd.fromDPToPix(this.mJe.getContext(), 8));
        break;
      }
    }
  }
  
  public final void eAf()
  {
    long l2 = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(362373);
    Object localObject1 = ((j)this.CwG.business(j.class)).EfK;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = ((j)this.CwG.business(j.class)).EfK;
      if (localObject3 != null) {
        break label187;
      }
      label60:
      Log.i(this.TAG, "selfBattleInfo:" + localObject1 + " otherBattleInfo:" + localObject2);
      localObject3 = this.Enj;
      if (localObject1 != null) {
        break label213;
      }
      l1 = 0L;
      label109:
      ((TextView)localObject3).setText((CharSequence)String.valueOf(l1));
      localObject3 = this.Enk;
      if (localObject2 != null) {
        break label222;
      }
    }
    label187:
    label213:
    label222:
    for (long l1 = l2;; l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.e)localObject2).Ebj)
    {
      ((TextView)localObject3).setText((CharSequence)String.valueOf(l1));
      a((com.tencent.mm.plugin.finder.live.viewmodel.data.e)localObject1, (com.tencent.mm.plugin.finder.live.viewmodel.data.e)localObject2);
      AppMethodBeat.o(362373);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.live.model.i)localObject1).awu(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      break;
      localObject2 = ((com.tencent.mm.plugin.finder.live.model.i)localObject3).awt(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      break label60;
      l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.e)localObject1).Ebj;
      break label109;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(362318);
    this.status = this.EmR;
    this.EmT.stop();
    this.EmU.stop();
    tO(8);
    this.Enp.stopTimer();
    AppMethodBeat.o(362318);
  }
  
  public final void ri(boolean paramBoolean)
  {
    Object localObject4 = null;
    AppMethodBeat.i(362336);
    Log.i(this.TAG, s.X("battleStart withAnim:", Boolean.valueOf(paramBoolean)));
    this.status = this.EmR;
    this.EmU.setVisibility(8);
    this.EmV.setVisibility(8);
    this.Enf.setVisibility(8);
    this.Enp.stopTimer();
    this.Enp.startTimer(1000L, 1000L);
    Object localObject1 = this.Eng;
    Object localObject2 = com.tencent.mm.live.model.r.mZi;
    localObject2 = ((j)this.CwG.business(j.class)).EfK;
    int i;
    label164:
    label190:
    Object localObject3;
    label224:
    Object localObject5;
    if (localObject2 == null)
    {
      i = 0;
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.live.model.r.a.I(i, ":"));
      if (!paramBoolean) {
        break label515;
      }
      localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject1 = d.a.auT(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      if (localObject1 != null) {
        break label477;
      }
      localObject1 = null;
      localObject2 = ((j)this.CwG.business(j.class)).Efv;
      if (localObject2 != null) {
        break label485;
      }
      localObject2 = null;
      localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject3 = d.a.auT(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
      if (localObject3 != null) {
        break label495;
      }
      localObject3 = null;
      localObject5 = ((j)this.CwG.business(j.class)).Efv;
      if (localObject5 != null) {
        break label505;
      }
    }
    for (;;)
    {
      localObject5 = p.ExI;
      localObject5 = p.eCp();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
      ImageView localImageView = this.EmZ;
      s.s(localImageView, "battleStartSelfUserAvatar");
      p localp = p.ExI;
      ((com.tencent.mm.loader.d)localObject5).a(localb, localImageView, p.a(p.a.ExM));
      localObject5 = p.ExI;
      localObject5 = p.eCp();
      localb = new com.tencent.mm.plugin.finder.loader.b((String)localObject2);
      localImageView = this.Enc;
      s.s(localImageView, "battleStartOtherUserAvatar");
      localp = p.ExI;
      ((com.tencent.mm.loader.d)localObject5).a(localb, localImageView, p.a(p.a.ExM));
      this.Ena.setText((CharSequence)localObject3);
      this.End.setText((CharSequence)localObject4);
      Log.i(this.TAG, "selfAvatar:" + localObject1 + " otherAvatarUrl:" + localObject2 + " selfNickname:" + localObject3 + " otherNickname:" + localObject4);
      this.EmT.setVisibility(0);
      this.EmT.post(new r..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(362336);
      return;
      i = ((com.tencent.mm.plugin.finder.live.model.i)localObject2).CEU;
      break;
      label477:
      localObject1 = ((m)localObject1).amx();
      break label164;
      label485:
      localObject2 = ((h)localObject2).headUrl;
      break label190;
      label495:
      localObject3 = ((m)localObject3).getNickname();
      break label224;
      label505:
      localObject4 = ((h)localObject5).nickname;
    }
    label515:
    this.EmX.setVisibility(8);
    this.EmT.setVisibility(8);
    this.EmV.setVisibility(0);
    this.Enf.setVisibility(0);
    this.Enh.setVisibility(0);
    this.Eni.setVisibility(8);
    AppMethodBeat.o(362336);
  }
  
  public final void rj(boolean paramBoolean)
  {
    int j = 1;
    CharSequence localCharSequence = null;
    AppMethodBeat.i(362347);
    Log.i(this.TAG, s.X("battleEnd curBattle:", ((j)this.CwG.business(j.class)).EfK));
    Object localObject1 = this.Eng;
    Object localObject2 = com.tencent.mm.live.model.r.mZi;
    ((TextView)localObject1).setText((CharSequence)com.tencent.mm.live.model.r.a.I(0, ":"));
    this.Enp.stopTimer();
    label163:
    boolean bool;
    if (((j)this.CwG.business(j.class)).EfK != null)
    {
      this.Enf.setVisibility(8);
      this.status = this.EmS;
      localObject1 = (bc)this.CwG.getPlugin(bc.class);
      if (localObject1 != null) {
        break label363;
      }
      localObject1 = null;
      if (localObject1 != bc.b.DeJ)
      {
        localObject1 = (bc)this.CwG.getPlugin(bc.class);
        if (localObject1 != null) {
          break label394;
        }
        localObject1 = null;
        if (localObject1 != bc.b.DeK) {
          break label425;
        }
      }
      bool = true;
      label174:
      this.Enn = bool;
      localObject1 = (ba)this.CwG.getPlugin(ba.class);
      if (localObject1 != null) {
        break label431;
      }
      localObject1 = null;
      label203:
      if (localObject1 != ba.b.Deo)
      {
        localObject1 = (ba)this.CwG.getPlugin(ba.class);
        if (localObject1 != null) {
          break label462;
        }
        localObject1 = localCharSequence;
        label235:
        if (localObject1 != ba.b.Dep) {
          break label491;
        }
      }
      bool = true;
      label246:
      this.Eno = bool;
      if (!paramBoolean) {
        this.EmV.setVisibility(0);
      }
      eAd();
      localObject1 = eAe();
      Log.i(this.TAG, s.X("battleEnd pagRes:", localObject1));
      localCharSequence = (CharSequence)localObject1;
      i = j;
      if (localCharSequence != null) {
        if (localCharSequence.length() != 0) {
          break label497;
        }
      }
    }
    label363:
    label491:
    label497:
    for (int i = j;; i = 0)
    {
      if (i == 0)
      {
        this.EmU.setFile(PAGFile.Load(this.mJe.getContext().getAssets(), (String)localObject1));
        this.EmU.setVisibility(0);
        this.EmU.play();
      }
      AppMethodBeat.o(362347);
      return;
      localObject1 = ((bc)localObject1).DeG;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = (bc.b)((x)localObject1).getValue();
      break;
      localObject1 = ((bc)localObject1).DeG;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label163;
      }
      localObject1 = (bc.b)((x)localObject1).getValue();
      break label163;
      bool = false;
      break label174;
      localObject1 = ((ba)localObject1).Deh;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label203;
      }
      localObject1 = (ba.b)((x)localObject1).getValue();
      break label203;
      localObject2 = ((ba)localObject1).Deh;
      localObject1 = localCharSequence;
      if (localObject2 == null) {
        break label235;
      }
      localObject1 = (ba.b)((x)localObject2).getValue();
      break label235;
      bool = false;
      break label246;
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(362323);
    this.CTl = paramInt;
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = this.mJe.getContext();
    s.s(localObject, "root.context");
    if (((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD) {
      paramInt = 8;
    }
    this.mJe.setVisibility(paramInt);
    AppMethodBeat.o(362323);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveBattleBarWidget$postStartUserHideAnimation$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(r paramr) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(361832);
      this.Ens.EmX.setVisibility(8);
      AppMethodBeat.o(361832);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(361824);
      this.Ens.EmX.setVisibility(8);
      AppMethodBeat.o(361824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.r
 * JD-Core Version:    0.7.0.1
 */