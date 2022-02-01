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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.r.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.bk.b;
import com.tencent.mm.plugin.finder.live.plugin.bo;
import com.tencent.mm.plugin.finder.live.plugin.bo.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBattleBarWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "END_PK_DRAW_PAG", "", "END_PK_DRAW_PAG_EN", "END_PK_WIN_PAG", "END_PK_WIN_PAG_EN", "START_PK_PAG", "STATUS_END_BATTLE", "", "STATUS_START_BATTLE", "TAG", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "battleEndCallback", "Lkotlin/Function0;", "", "getBattleEndCallback", "()Lkotlin/jvm/functions/Function0;", "setBattleEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "battleEndView", "Lorg/libpag/PAGView;", "battleStartOtherUserAvatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "battleStartOtherUserGroup", "Landroid/view/View;", "battleStartOtherUserNickname", "Landroid/widget/TextView;", "battleStartSelfUserAvatar", "battleStartSelfUserGroup", "battleStartSelfUserNickname", "battleStartUserGroup", "battleStartView", "localCountDownTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "lotteryBubbleShow", "", "luckyMoneyBubbleShow", "otherRewardGroup", "otherRewardTv", "pkUserAudioMode", "getPkUserAudioMode", "()Z", "setPkUserAudioMode", "(Z)V", "getRoot", "()Landroid/view/ViewGroup;", "selfRewardGroup", "selfRewardTv", "status", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "timeTipView", "timeTvView", "topInfoBarGroup", "topInfoIcon", "topInfoOtherBar", "adjustEndViewLayout", "battleEnd", "withAnim", "battleStart", "coundDown", "fillStartUserInfo", "genEndPagRes", "getTRTCCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "onLotteryBubbleLocationChange", "lotteryLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "onLuckyMoneyBubbleLocationChange", "luckyMoneyLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$ShowingLocation;", "postStartUserHideAnimation", "reset", "setVisible", "visibility", "updateBattleBar", "selfBattleInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveBattlePlayerInfo;", "otherBattleInfo", "updateBattleInfo", "plugin-finder_release"})
public final class l
{
  public final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  final ViewGroup kiF;
  int status;
  final com.tencent.mm.plugin.finder.live.plugin.d xYq;
  private final View zmA;
  private final ImageView zmB;
  private final TextView zmC;
  final ImageView zmD;
  final View zmE;
  final TextView zmF;
  private final TextView zmG;
  private final TextView zmH;
  final View zmI;
  final View zmJ;
  public boolean zmK;
  public boolean zmL;
  private final MTimerHandler zmM;
  public boolean zmN;
  public kotlin.g.a.a<x> zmO;
  private final String zml;
  private final String zmm;
  private final String zmn;
  private final String zmo;
  private final String zmp;
  final int zmq;
  private final int zmr;
  final PAGView zms;
  private final PAGView zmt;
  final View zmu;
  final View zmv;
  final View zmw;
  private final View zmx;
  private final ImageView zmy;
  private final TextView zmz;
  
  public l(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, com.tencent.mm.plugin.finder.live.plugin.d paramd)
  {
    AppMethodBeat.i(271572);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "FinderLiveBattleTopInfoWidget";
    this.zml = "finder_live_pk_start.pag";
    this.zmm = "finder_live_pk_result_win.pag";
    this.zmn = "finder_live_pk_result_win_en.pag";
    this.zmo = "finder_live_pk_result_draw.pag";
    this.zmp = "finder_live_pk_result_draw_en.pag";
    this.zmr = 1;
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_start_pag);
    p.j(paramViewGroup, "root.findViewById(R.id.f…er_live_battle_start_pag)");
    this.zms = ((PAGView)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_end_pag);
    p.j(paramViewGroup, "root.findViewById(R.id.finder_live_battle_end_pag)");
    this.zmt = ((PAGView)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_top_status_bar);
    p.j(paramViewGroup, "root.findViewById(R.id.f…ve_battle_top_status_bar)");
    this.zmu = paramViewGroup;
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_top_status_bar_other);
    p.j(paramViewGroup, "root.findViewById(R.id.f…tle_top_status_bar_other)");
    this.zmv = paramViewGroup;
    this.zmw = this.kiF.findViewById(b.f.finder_live_battle_start_view_group);
    this.zmx = this.kiF.findViewById(b.f.finder_live_battle_start_self_info);
    this.zmy = ((ImageView)this.kiF.findViewById(b.f.finder_live_battle_start_self_avatar));
    this.zmz = ((TextView)this.kiF.findViewById(b.f.finder_live_battle_start_self_nickname));
    this.zmA = this.kiF.findViewById(b.f.finder_live_battle_start_other_info);
    this.zmB = ((ImageView)this.kiF.findViewById(b.f.finder_live_battle_start_other_avatar));
    this.zmC = ((TextView)this.kiF.findViewById(b.f.finder_live_battle_start_other_nickname));
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_top_status_bar_icon);
    p.j(paramViewGroup, "root.findViewById(R.id.f…ttle_top_status_bar_icon)");
    this.zmD = ((ImageView)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_top_timer);
    p.j(paramViewGroup, "root.findViewById(R.id.f…er_live_battle_top_timer)");
    this.zmE = paramViewGroup;
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_top_timer_tv);
    p.j(paramViewGroup, "root.findViewById(R.id.f…live_battle_top_timer_tv)");
    this.zmF = ((TextView)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_top_info_self_tv);
    p.j(paramViewGroup, "root.findViewById(R.id.f…_battle_top_info_self_tv)");
    this.zmG = ((TextView)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_top_info_other_tv);
    p.j(paramViewGroup, "root.findViewById(R.id.f…battle_top_info_other_tv)");
    this.zmH = ((TextView)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_top_info_other);
    p.j(paramViewGroup, "root.findViewById(R.id.f…ve_battle_top_info_other)");
    this.zmI = paramViewGroup;
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_battle_top_info_self);
    p.j(paramViewGroup, "root.findViewById(R.id.f…ive_battle_top_info_self)");
    this.zmJ = paramViewGroup;
    this.status = this.zmq;
    this.zmM = new MTimerHandler((MTimerHandler.CallBack)new a(this), true);
    paramViewGroup = this.zms;
    paramb = this.kiF.getContext();
    p.j(paramb, "root.context");
    paramViewGroup.setFile(PAGFile.Load(paramb.getAssets(), this.zml));
    this.zms.addListener((PAGView.PAGViewListener)new PAGView.PAGViewListener()
    {
      public final void onAnimationCancel(PAGView paramAnonymousPAGView) {}
      
      public final void onAnimationEnd(PAGView paramAnonymousPAGView)
      {
        com.tencent.mm.plugin.finder.live.viewmodel.data.e locale = null;
        AppMethodBeat.i(287317);
        Log.i(this.zmP.TAG, "onAnimationEnd status:" + this.zmP.status);
        if (this.zmP.status == this.zmP.zmq)
        {
          this.zmP.zms.setVisibility(8);
          this.zmP.zmu.setVisibility(0);
          this.zmP.zmE.setVisibility(0);
          paramAnonymousPAGView = ((f)this.zmP.xYq.business(f.class)).zhz;
          if (paramAnonymousPAGView == null) {
            break label197;
          }
        }
        label197:
        for (paramAnonymousPAGView = paramAnonymousPAGView.aBZ(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.zmP.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);; paramAnonymousPAGView = null)
        {
          com.tencent.mm.plugin.finder.live.model.h localh = ((f)this.zmP.xYq.business(f.class)).zhz;
          if (localh != null) {
            locale = localh.aBY(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.zmP.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
          }
          this.zmP.a(paramAnonymousPAGView, locale);
          AppMethodBeat.o(287317);
          return;
        }
      }
      
      public final void onAnimationRepeat(PAGView paramAnonymousPAGView) {}
      
      public final void onAnimationStart(PAGView paramAnonymousPAGView)
      {
        AppMethodBeat.i(287318);
        if (this.zmP.status == this.zmP.zmq)
        {
          paramAnonymousPAGView = this.zmP.zmw;
          p.j(paramAnonymousPAGView, "battleStartUserGroup");
          paramAnonymousPAGView.setAlpha(0.0F);
          paramAnonymousPAGView = this.zmP.zmw;
          p.j(paramAnonymousPAGView, "battleStartUserGroup");
          paramAnonymousPAGView.setVisibility(0);
          this.zmP.zmw.animate().alpha(1.0F).setListener(null).setDuration(500L).setInterpolator((TimeInterpolator)new AccelerateInterpolator()).start();
          paramAnonymousPAGView = this.zmP;
          paramAnonymousPAGView.kiF.postDelayed((Runnable)new l.b(paramAnonymousPAGView), 1800L);
        }
        AppMethodBeat.o(287318);
      }
    });
    int i = ax.au(this.kiF.getContext()).x / 2;
    paramViewGroup = this.zmx;
    p.j(paramViewGroup, "battleStartSelfUserGroup");
    paramb = paramViewGroup.getLayoutParams();
    paramViewGroup = paramb;
    if (!(paramb instanceof ViewGroup.MarginLayoutParams)) {
      paramViewGroup = null;
    }
    paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
    if (paramViewGroup != null) {
      paramViewGroup.setMarginEnd(i * 7 / 25 + i);
    }
    paramViewGroup = this.zmA;
    p.j(paramViewGroup, "battleStartOtherUserGroup");
    paramb = paramViewGroup.getLayoutParams();
    paramViewGroup = paramb;
    if (!(paramb instanceof ViewGroup.MarginLayoutParams)) {
      paramViewGroup = null;
    }
    paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
    if (paramViewGroup != null)
    {
      paramViewGroup.setMarginStart(i * 7 / 25 + i);
      AppMethodBeat.o(271572);
      return;
    }
    AppMethodBeat.o(271572);
  }
  
  private final void dHP()
  {
    String str = null;
    AppMethodBeat.i(271560);
    Object localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject1 = d.a.aAK(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.api.i)localObject1).Mm();
      localObject2 = ((f)this.xYq.business(f.class)).zhl;
      if (localObject2 == null) {
        break label353;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject2).headUrl;
      label68:
      localObject3 = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject3 = d.a.aAK(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
      if (localObject3 == null) {
        break label358;
      }
    }
    label353:
    label358:
    for (Object localObject3 = ((com.tencent.mm.plugin.finder.api.i)localObject3).getNickname();; localObject3 = null)
    {
      Object localObject4 = ((f)this.xYq.business(f.class)).zhl;
      if (localObject4 != null) {
        str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).nickname;
      }
      localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject4 = com.tencent.mm.plugin.finder.loader.t.dJh();
      com.tencent.mm.plugin.finder.loader.e locale = new com.tencent.mm.plugin.finder.loader.e((String)localObject1);
      ImageView localImageView = this.zmy;
      p.j(localImageView, "battleStartSelfUserAvatar");
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject4).a(locale, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject4 = com.tencent.mm.plugin.finder.loader.t.dJh();
      locale = new com.tencent.mm.plugin.finder.loader.e((String)localObject2);
      localImageView = this.zmB;
      p.j(localImageView, "battleStartOtherUserAvatar");
      localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject4).a(locale, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      localObject4 = this.zmz;
      p.j(localObject4, "battleStartSelfUserNickname");
      ((TextView)localObject4).setText((CharSequence)localObject3);
      localObject4 = this.zmC;
      p.j(localObject4, "battleStartOtherUserNickname");
      ((TextView)localObject4).setText((CharSequence)str);
      Log.i(this.TAG, "selfAvatar:" + (String)localObject1 + " otherAvatarUrl:" + (String)localObject2 + " selfNickname:" + (String)localObject3 + " otherNickname:" + str);
      AppMethodBeat.o(271560);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label68;
    }
  }
  
  private static com.tencent.mm.live.core.core.trtc.a dHQ()
  {
    AppMethodBeat.i(271567);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      localObject = ah.yhC;
      localObject = (com.tencent.mm.live.core.core.trtc.a)ah.dzB();
      AppMethodBeat.o(271567);
      return localObject;
    }
    localObject = ah.yhC;
    localObject = (com.tencent.mm.live.core.core.trtc.a)ah.dzA();
    AppMethodBeat.o(271567);
    return localObject;
  }
  
  private final String dHS()
  {
    AppMethodBeat.i(271569);
    Object localObject = ((f)this.xYq.business(f.class)).zhz;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((com.tencent.mm.plugin.finder.live.model.h)localObject).yex);
      if (localObject != null) {
        break label66;
      }
      label39:
      if (localObject != null) {
        break label106;
      }
      label43:
      if (localObject != null) {
        break label146;
      }
      label47:
      if (localObject != null) {
        break label186;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(271569);
      return "";
      localObject = null;
      break;
      label66:
      if (((Integer)localObject).intValue() != 2) {
        break label39;
      }
      if (LocaleUtil.isChineseAppLang())
      {
        localObject = this.zmm;
        AppMethodBeat.o(271569);
        return localObject;
      }
      localObject = this.zmn;
      AppMethodBeat.o(271569);
      return localObject;
      label106:
      if (((Integer)localObject).intValue() != 1) {
        break label43;
      }
      if (LocaleUtil.isChineseAppLang())
      {
        localObject = this.zmm;
        AppMethodBeat.o(271569);
        return localObject;
      }
      localObject = this.zmn;
      AppMethodBeat.o(271569);
      return localObject;
      label146:
      if (((Integer)localObject).intValue() != 3) {
        break label47;
      }
      if (LocaleUtil.isChineseAppLang())
      {
        localObject = this.zmo;
        AppMethodBeat.o(271569);
        return localObject;
      }
      localObject = this.zmp;
      AppMethodBeat.o(271569);
      return localObject;
      label186:
      ((Integer)localObject).intValue();
    }
  }
  
  final void a(final com.tencent.mm.plugin.finder.live.viewmodel.data.e parame1, final com.tencent.mm.plugin.finder.live.viewmodel.data.e parame2)
  {
    AppMethodBeat.i(271570);
    this.zmu.post((Runnable)new c(this, parame1, parame2));
    AppMethodBeat.o(271570);
  }
  
  public final void dHR()
  {
    int j = 0;
    AppMethodBeat.i(271568);
    Object localObject1 = ((f)this.xYq.business(f.class)).zhz;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.finder.live.model.h)localObject1).yex);
      if (localObject1 != null) {
        break label69;
      }
      label46:
      if (localObject1 != null) {
        break label288;
      }
    }
    label69:
    Object localObject2;
    for (;;)
    {
      label896:
      if (localObject1 == null)
      {
        AppMethodBeat.o(271568);
        return;
        localObject1 = null;
        break;
        if (((Integer)localObject1).intValue() != 2) {
          break label46;
        }
        this.zmt.setVisibility(0);
        if (!(this.zmt.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          break label1083;
        }
        localObject2 = this.zmt.getLayoutParams();
        localObject1 = localObject2;
        if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
          localObject1 = null;
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (localObject1 != null) {
          ((RelativeLayout.LayoutParams)localObject1).setMarginStart(ax.au(this.xYq.kiF.getContext()).x / 2);
        }
        if (this.zmN)
        {
          localObject2 = this.zmt.getLayoutParams();
          localObject1 = localObject2;
          if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
            localObject1 = null;
          }
          localObject1 = (RelativeLayout.LayoutParams)localObject1;
          if (localObject1 != null) {
            ((RelativeLayout.LayoutParams)localObject1).topMargin = aw.fromDPToPix(this.kiF.getContext(), 24);
          }
        }
        for (;;)
        {
          this.zmt.requestLayout();
          AppMethodBeat.o(271568);
          return;
          localObject2 = this.zmt.getLayoutParams();
          localObject1 = localObject2;
          if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
            localObject1 = null;
          }
          localObject1 = (RelativeLayout.LayoutParams)localObject1;
          if (localObject1 != null) {
            ((RelativeLayout.LayoutParams)localObject1).topMargin = aw.fromDPToPix(this.kiF.getContext(), 8);
          }
        }
        label288:
        if (((Integer)localObject1).intValue() == 1)
        {
          this.zmt.setVisibility(0);
          if (!(this.zmt.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            break label1083;
          }
          localObject2 = this.zmt.getLayoutParams();
          localObject1 = localObject2;
          if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
            localObject1 = null;
          }
          localObject1 = (RelativeLayout.LayoutParams)localObject1;
          if (localObject1 != null) {
            ((RelativeLayout.LayoutParams)localObject1).setMarginStart(0);
          }
          localObject1 = dHQ();
          int k;
          int m;
          RelativeLayout.LayoutParams localLayoutParams;
          int i;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
            if ((localObject1 != null) && (((com.tencent.mm.live.core.core.model.h)localObject1).aLs() == true))
            {
              localObject2 = this.zmt.getLayoutParams();
              localObject1 = localObject2;
              if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
                localObject1 = null;
              }
              localObject1 = (RelativeLayout.LayoutParams)localObject1;
              if (localObject1 != null) {
                ((RelativeLayout.LayoutParams)localObject1).topMargin = aw.fromDPToPix(this.kiF.getContext(), 24);
              }
              if (this.zmK)
              {
                k = com.tencent.mm.ae.d.cE((View)this.kiF)[1];
                m = aw.fromDPToPix(this.kiF.getContext(), 12);
                localObject2 = this.zmt.getLayoutParams();
                localObject1 = localObject2;
                if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
                  localObject1 = null;
                }
                localLayoutParams = (RelativeLayout.LayoutParams)localObject1;
                if (localLayoutParams != null)
                {
                  localObject2 = this.zmt.getLayoutParams();
                  localObject1 = localObject2;
                  if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
                    localObject1 = null;
                  }
                  localObject1 = (RelativeLayout.LayoutParams)localObject1;
                  if (localObject1 == null) {
                    break label886;
                  }
                  i = ((RelativeLayout.LayoutParams)localObject1).topMargin;
                  label557:
                  localObject2 = this.kCL;
                  localObject1 = localObject2;
                  if (!(localObject2 instanceof com.tencent.mm.plugin.finder.live.view.a)) {
                    localObject1 = null;
                  }
                  localObject1 = (com.tencent.mm.plugin.finder.live.view.a)localObject1;
                  if (localObject1 == null) {
                    break label891;
                  }
                  localObject1 = (bo)((com.tencent.mm.plugin.finder.live.view.a)localObject1).getPlugin(bo.class);
                  if (localObject1 == null) {
                    break label891;
                  }
                  f = ((bo)localObject1).dBZ();
                  label614:
                  localLayoutParams.topMargin = ((int)f + i - (k + m));
                }
              }
              if (this.zmL)
              {
                k = com.tencent.mm.ae.d.cE((View)this.kiF)[1];
                m = aw.fromDPToPix(this.kiF.getContext(), 12);
                localObject2 = this.zmt.getLayoutParams();
                localObject1 = localObject2;
                if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
                  localObject1 = null;
                }
                localLayoutParams = (RelativeLayout.LayoutParams)localObject1;
                if (localLayoutParams != null)
                {
                  localObject2 = this.zmt.getLayoutParams();
                  localObject1 = localObject2;
                  if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
                    localObject1 = null;
                  }
                  localObject1 = (RelativeLayout.LayoutParams)localObject1;
                  i = j;
                  if (localObject1 != null) {
                    i = ((RelativeLayout.LayoutParams)localObject1).topMargin;
                  }
                  localObject2 = this.kCL;
                  localObject1 = localObject2;
                  if (!(localObject2 instanceof com.tencent.mm.plugin.finder.live.view.a)) {
                    localObject1 = null;
                  }
                  localObject1 = (com.tencent.mm.plugin.finder.live.view.a)localObject1;
                  if (localObject1 == null) {
                    break label896;
                  }
                  localObject1 = (bk)((com.tencent.mm.plugin.finder.live.view.a)localObject1).getPlugin(bk.class);
                  if (localObject1 == null) {
                    break label896;
                  }
                }
              }
            }
          }
          for (float f = ((bk)localObject1).dxG();; f = 0.0F)
          {
            localLayoutParams.topMargin = ((int)f + i - (k + m));
            this.zmt.requestLayout();
            AppMethodBeat.o(271568);
            return;
            localObject2 = this.zmt.getLayoutParams();
            localObject1 = localObject2;
            if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
              localObject1 = null;
            }
            localObject1 = (RelativeLayout.LayoutParams)localObject1;
            if (localObject1 == null) {
              break;
            }
            ((RelativeLayout.LayoutParams)localObject1).topMargin = aw.fromDPToPix(this.kiF.getContext(), 8);
            break;
            label886:
            i = 0;
            break label557;
            label891:
            f = 0.0F;
            break label614;
          }
        }
      }
    }
    if (((Integer)localObject1).intValue() == 3)
    {
      this.zmt.setVisibility(0);
      if ((this.zmt.getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        localObject2 = this.zmt.getLayoutParams();
        localObject1 = localObject2;
        if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
          localObject1 = null;
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (localObject1 != null) {
          ((RelativeLayout.LayoutParams)localObject1).setMarginStart(ax.au(this.xYq.kiF.getContext()).x / 2 - aw.fromDPToPix(this.xYq.kiF.getContext(), 104) / 2);
        }
        if (!this.zmN) {
          break label1090;
        }
        localObject2 = this.zmt.getLayoutParams();
        localObject1 = localObject2;
        if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
          localObject1 = null;
        }
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        if (localObject1 != null) {
          ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.zmE.getMeasuredHeight() + aw.fromDPToPix(this.kiF.getContext(), 24));
        }
      }
    }
    for (;;)
    {
      this.zmt.requestLayout();
      label1083:
      AppMethodBeat.o(271568);
      return;
      label1090:
      localObject2 = this.zmt.getLayoutParams();
      localObject1 = localObject2;
      if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
        localObject1 = null;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.zmE.getMeasuredHeight() + aw.fromDPToPix(this.kiF.getContext(), 8));
      }
    }
  }
  
  public final void dHT()
  {
    long l2 = 0L;
    com.tencent.mm.plugin.finder.live.viewmodel.data.e locale = null;
    AppMethodBeat.i(271571);
    Object localObject1 = ((f)this.xYq.business(f.class)).zhz;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).aBZ(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
      localObject2 = ((f)this.xYq.business(f.class)).zhz;
      if (localObject2 != null) {
        locale = ((com.tencent.mm.plugin.finder.live.model.h)localObject2).aBY(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
      }
      Log.i(this.TAG, "selfBattleInfo:" + localObject1 + " otherBattleInfo:" + locale);
      localObject2 = this.zmG;
      if (localObject1 == null) {
        break label220;
      }
    }
    label220:
    for (long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.e)localObject1).zeu;; l1 = 0L)
    {
      ((TextView)localObject2).setText((CharSequence)String.valueOf(l1));
      localObject2 = this.zmH;
      l1 = l2;
      if (locale != null) {
        l1 = locale.zeu;
      }
      ((TextView)localObject2).setText((CharSequence)String.valueOf(l1));
      a((com.tencent.mm.plugin.finder.live.viewmodel.data.e)localObject1, locale);
      AppMethodBeat.o(271571);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void pa(boolean paramBoolean)
  {
    AppMethodBeat.i(271563);
    Log.i(this.TAG, "battleStart withAnim:".concat(String.valueOf(paramBoolean)));
    this.status = this.zmq;
    this.zmt.setVisibility(8);
    this.zmu.setVisibility(8);
    this.zmE.setVisibility(8);
    this.zmM.stopTimer();
    this.zmM.startTimer(1000L, 1000L);
    Object localObject1 = this.zmF;
    Object localObject2 = com.tencent.mm.live.b.r.kvH;
    localObject2 = ((f)this.xYq.business(f.class)).zhz;
    if (localObject2 != null) {}
    for (int i = ((com.tencent.mm.plugin.finder.live.model.h)localObject2).yew;; i = 0)
    {
      ((TextView)localObject1).setText((CharSequence)r.a.H(i, ":"));
      if (!paramBoolean) {
        break;
      }
      dHP();
      this.zms.setVisibility(0);
      this.zms.stop();
      this.zms.play();
      AppMethodBeat.o(271563);
      return;
    }
    localObject1 = this.zmw;
    p.j(localObject1, "battleStartUserGroup");
    ((View)localObject1).setVisibility(8);
    this.zms.setVisibility(8);
    this.zmu.setVisibility(0);
    this.zmE.setVisibility(0);
    AppMethodBeat.o(271563);
  }
  
  public final void pb(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(271566);
    Log.i(this.TAG, "battleEnd curBattle:" + ((f)this.xYq.business(f.class)).zhz);
    Object localObject1 = this.zmF;
    Object localObject2 = com.tencent.mm.live.b.r.kvH;
    ((TextView)localObject1).setText((CharSequence)r.a.H(0, ":"));
    this.zmM.stopTimer();
    label199:
    boolean bool;
    if (((f)this.xYq.business(f.class)).zhz != null)
    {
      this.status = this.zmr;
      localObject1 = (bo)this.xYq.getPlugin(bo.class);
      if (localObject1 == null) {
        break label455;
      }
      localObject1 = ((bo)localObject1).yui;
      if (localObject1 == null) {
        break label455;
      }
      localObject1 = (bo.b)((androidx.lifecycle.r)localObject1).getValue();
      if (localObject1 != bo.b.yul)
      {
        localObject1 = (bo)this.xYq.getPlugin(bo.class);
        if (localObject1 == null) {
          break label461;
        }
        localObject1 = ((bo)localObject1).yui;
        if (localObject1 == null) {
          break label461;
        }
        localObject1 = (bo.b)((androidx.lifecycle.r)localObject1).getValue();
        if (localObject1 != bo.b.yum) {
          break label467;
        }
      }
      bool = true;
      label210:
      this.zmK = bool;
      localObject1 = (bk)this.xYq.getPlugin(bk.class);
      if (localObject1 == null) {
        break label473;
      }
      localObject1 = ((bk)localObject1).ytM;
      if (localObject1 == null) {
        break label473;
      }
      localObject1 = (bk.b)((androidx.lifecycle.r)localObject1).getValue();
      label258:
      if (localObject1 != bk.b.ytT)
      {
        localObject1 = (bk)this.xYq.getPlugin(bk.class);
        if (localObject1 == null) {
          break label479;
        }
        localObject1 = ((bk)localObject1).ytM;
        if (localObject1 == null) {
          break label479;
        }
        localObject1 = (bk.b)((androidx.lifecycle.r)localObject1).getValue();
        label308:
        if (localObject1 != bk.b.ytU) {
          break label485;
        }
      }
      bool = true;
      label319:
      this.zmL = bool;
      if (!paramBoolean) {
        this.zmu.setVisibility(0);
      }
      dHR();
      localObject1 = dHS();
      Log.i(this.TAG, "battleEnd pagRes:".concat(String.valueOf(localObject1)));
      localObject2 = (CharSequence)localObject1;
      i = j;
      if (localObject2 != null) {
        if (((CharSequence)localObject2).length() != 0) {
          break label491;
        }
      }
    }
    label455:
    label461:
    label467:
    label473:
    label479:
    label485:
    label491:
    for (int i = j;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = this.zmt;
        Context localContext = this.kiF.getContext();
        p.j(localContext, "root.context");
        ((PAGView)localObject2).setFile(PAGFile.Load(localContext.getAssets(), (String)localObject1));
        this.zmt.setVisibility(0);
        this.zmt.play();
      }
      AppMethodBeat.o(271566);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label199;
      bool = false;
      break label210;
      localObject1 = null;
      break label258;
      localObject1 = null;
      break label308;
      bool = false;
      break label319;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(271561);
    this.status = this.zmq;
    this.zms.stop();
    this.zmt.stop();
    tU(8);
    this.zmM.stopTimer();
    AppMethodBeat.o(271561);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(271562);
    this.kiF.setVisibility(paramInt);
    AppMethodBeat.o(271562);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    a(l paraml) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(289077);
      Object localObject1 = ((f)this.zmP.xYq.business(f.class)).zhz;
      if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.model.h)localObject1).yey != 2))
      {
        AppMethodBeat.o(289077);
        return false;
      }
      localObject1 = ((f)this.zmP.xYq.business(f.class)).zhz;
      int i;
      if (localObject1 != null) {
        i = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yew;
      }
      while (i > 0)
      {
        localObject1 = this.zmP;
        Log.i(((l)localObject1).TAG, "coundDown");
        Object localObject2 = ((f)((l)localObject1).xYq.business(f.class)).zhz;
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.finder.live.model.h)localObject2).yew -= 1;
          if (((com.tencent.mm.plugin.finder.live.model.h)localObject2).yew < 10)
          {
            ((l)localObject1).zmF.setText((CharSequence)("0" + ((com.tencent.mm.plugin.finder.live.model.h)localObject2).yew));
            ((l)localObject1).zmF.setScaleX(1.5F);
            ((l)localObject1).zmF.setScaleY(1.5F);
            ((l)localObject1).zmF.animate().scaleX(1.0F).scaleY(1.0F).start();
          }
        }
        else
        {
          AppMethodBeat.o(289077);
          return true;
          i = 0;
          continue;
        }
        localObject2 = ((l)localObject1).zmF;
        r.a locala = com.tencent.mm.live.b.r.kvH;
        localObject1 = ((f)((l)localObject1).xYq.business(f.class)).zhz;
        if (localObject1 != null) {}
        for (i = ((com.tencent.mm.plugin.finder.live.model.h)localObject1).yew;; i = 0)
        {
          ((TextView)localObject2).setText((CharSequence)r.a.H(i, ":"));
          break;
        }
      }
      AppMethodBeat.o(289077);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(268270);
      this.zmP.zmw.animate().alpha(0.0F).setDuration(500L).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(273130);
          paramAnonymousAnimator = this.zmQ.zmP.zmw;
          p.j(paramAnonymousAnimator, "battleStartUserGroup");
          paramAnonymousAnimator.setVisibility(8);
          AppMethodBeat.o(273130);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(273128);
          paramAnonymousAnimator = this.zmQ.zmP.zmw;
          p.j(paramAnonymousAnimator, "battleStartUserGroup");
          paramAnonymousAnimator.setVisibility(8);
          AppMethodBeat.o(273128);
        }
      }).start();
      AppMethodBeat.o(268270);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(l paraml, com.tencent.mm.plugin.finder.live.viewmodel.data.e parame1, com.tencent.mm.plugin.finder.live.viewmodel.data.e parame2) {}
    
    public final void run()
    {
      AppMethodBeat.i(270904);
      Object localObject = parame1;
      com.tencent.mm.plugin.finder.live.viewmodel.data.e locale = parame2;
      int j;
      int k;
      int m;
      int n;
      long l;
      int i;
      if ((localObject != null) && (locale != null))
      {
        j = this.zmP.zmJ.getRight();
        k = aw.fromDPToPix(this.zmP.kiF.getContext(), 16);
        m = this.zmP.zmI.getLeft();
        n = aw.fromDPToPix(this.zmP.kiF.getContext(), 16);
        l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.e)localObject).zeu + locale.zeu;
        if (this.zmP.zmD.getMeasuredWidth() <= 0) {
          i = com.tencent.mm.ci.a.fromDPToPix(this.zmP.kiF.getContext(), 9.6F);
        }
        while (l == 0L)
        {
          localObject = this.zmP.zmD.getLayoutParams();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(270904);
            throw ((Throwable)localObject);
            i = this.zmP.zmD.getMeasuredWidth();
          }
          else
          {
            ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(ax.au(this.zmP.kiF.getContext()).x / 2 - i / 2);
            localObject = this.zmP.zmv.getLayoutParams();
            if (localObject == null)
            {
              localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(270904);
              throw ((Throwable)localObject);
            }
            ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(ax.au(this.zmP.kiF.getContext()).x / 2);
          }
        }
      }
      for (;;)
      {
        this.zmP.zmu.requestLayout();
        AppMethodBeat.o(270904);
        return;
        float f = kotlin.k.i.aQ(kotlin.k.i.aP((float)((com.tencent.mm.plugin.finder.live.viewmodel.data.e)localObject).zeu / (float)l * ax.au(this.zmP.kiF.getContext()).x, k + j), m - n);
        localObject = this.zmP.zmD.getLayoutParams();
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(270904);
          throw ((Throwable)localObject);
        }
        ((ViewGroup.MarginLayoutParams)localObject).setMarginStart((int)f - i / 2);
        localObject = this.zmP.zmv.getLayoutParams();
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(270904);
          throw ((Throwable)localObject);
        }
        ((ViewGroup.MarginLayoutParams)localObject).setMarginStart((int)f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.l
 * JD-Core Version:    0.7.0.1
 */