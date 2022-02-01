package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.r.a;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.b.a.a;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.ax;
import com.tencent.mm.plugin.finder.live.report.s.bk;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "anchorMuteAnimator", "Landroid/animation/AnimatorSet;", "anchorMuteIn", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "anchorMuteOut", "anchorMuteTipIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "audioModeGroup", "audioModeIcon", "Lorg/libpag/PAGView;", "audioModeTip", "Landroid/widget/TextView;", "commonInfoEmptyTimesCheckIndex", "", "curNetStatus", "duration", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "filterVisitorResetOnlineValue", "", "getFilterVisitorResetOnlineValue", "()Z", "setFilterVisitorResetOnlineValue", "(Z)V", "isAnchor", "likeGroup", "likeIcon", "likeTv", "memberIcon", "membersGroup", "membersIcon", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "pkAudioModeGroup", "pkAudioModeIcon", "pkAudioModeTip", "tipBarStatus", "tipGroup", "canClearScreen", "canVisitorGotoMemberList", "checkDuration", "", "createTime", "checkNetwork", "checkPkAnchorAudioTip", "checkPkAnchorAudioVolume", "getNetStatusIcon", "resId", "notifyAnchorVolumeChange", "isTalking", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "prepareMuteTipAnimator", "refreshByTipStatus", "refreshViews", "resetCommonInfoEmptyTimesCheckIndex", "setupConfig", "start", "startMuteTipAnim", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "stopMuteTipAnim", "unMount", "Companion", "plugin-finder_release"})
public final class at
  extends d
{
  private static boolean DEBUG;
  private static int ypJ;
  private static int ypK;
  private static int ypL;
  private static int ypM;
  public static final c ypN;
  private final String TAG;
  private long duration;
  private boolean fFE;
  private final com.tencent.mm.live.c.b kCL;
  private final TextView kEa;
  private final TextView kEb;
  private final TextView kEc;
  private final View kEd;
  private final View kEe;
  private final View kEf;
  private final ImageView kEg;
  private final ImageView kEh;
  private final Drawable kEi;
  private final Drawable kEj;
  private final Drawable kEk;
  private int kEl;
  private String kEm;
  private final ImageView vsK;
  private final TextView ypA;
  private final PAGView ypB;
  private final ViewGroup ypC;
  private final WeImageView ypD;
  private AnimatorSet ypE;
  private ValueAnimator ypF;
  private ValueAnimator ypG;
  private int ypH;
  public int ypI;
  boolean ypu;
  private final WeImageView ypv;
  private final ViewGroup ypw;
  private final TextView ypx;
  private final PAGView ypy;
  private final ViewGroup ypz;
  
  static
  {
    AppMethodBeat.i(282848);
    ypN = new c((byte)0);
    ypJ = 20;
    ypK = 1;
    ypL = 2;
    ypM = 4;
    AppMethodBeat.o(282848);
  }
  
  public at(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(282847);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveCommonInfoPlugin";
    paramb = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilX().aSr()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ypu = bool;
      paramb = paramViewGroup.findViewById(b.f.live_common_info_members_tv);
      p.j(paramb, "root.findViewById(R.id.l…e_common_info_members_tv)");
      this.kEa = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(b.f.live_common_info_duration_tv);
      p.j(paramb, "root.findViewById(R.id.l…_common_info_duration_tv)");
      this.kEb = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(b.f.live_common_info_like_tv);
      p.j(paramb, "root.findViewById(R.id.live_common_info_like_tv)");
      this.kEc = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(b.f.live_common_info_members_group);
      p.j(paramb, "root.findViewById(R.id.l…ommon_info_members_group)");
      this.kEd = paramb;
      paramb = paramViewGroup.findViewById(b.f.live_common_info_duration_group);
      p.j(paramb, "root.findViewById(R.id.l…mmon_info_duration_group)");
      this.kEe = paramb;
      paramb = paramViewGroup.findViewById(b.f.live_common_info_like_group);
      p.j(paramb, "root.findViewById(R.id.l…e_common_info_like_group)");
      this.kEf = paramb;
      paramb = paramViewGroup.findViewById(b.f.live_common_info_duration_icon);
      p.j(paramb, "root.findViewById(R.id.l…ommon_info_duration_icon)");
      this.kEg = ((ImageView)paramb);
      paramb = paramViewGroup.findViewById(b.f.live_common_info_arrow_icon);
      p.j(paramb, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
      this.kEh = ((ImageView)paramb);
      paramb = paramViewGroup.findViewById(b.f.live_common_info_like_icon);
      p.j(paramb, "root.findViewById(R.id.live_common_info_like_icon)");
      this.vsK = ((ImageView)paramb);
      paramb = paramViewGroup.findViewById(b.f.live_common_info_members_icon);
      p.j(paramb, "root.findViewById(R.id.l…common_info_members_icon)");
      this.ypv = ((WeImageView)paramb);
      paramb = paramViewGroup.findViewById(b.f.finder_live_common_info_audio_mode_group);
      p.j(paramb, "root.findViewById(R.id.f…on_info_audio_mode_group)");
      this.ypw = ((ViewGroup)paramb);
      paramb = paramViewGroup.findViewById(b.f.finder_live_common_info_audio_mode_tv);
      p.j(paramb, "root.findViewById(R.id.f…ommon_info_audio_mode_tv)");
      this.ypx = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(b.f.finder_live_common_info_audio_mode_icon);
      p.j(paramb, "root.findViewById(R.id.f…mon_info_audio_mode_icon)");
      this.ypy = ((PAGView)paramb);
      paramb = paramViewGroup.findViewById(b.f.finder_live_common_info_audio_mode_pk_group);
      p.j(paramb, "root.findViewById(R.id.f…info_audio_mode_pk_group)");
      this.ypz = ((ViewGroup)paramb);
      paramb = paramViewGroup.findViewById(b.f.finder_live_common_info_audio_mode_pk_tv);
      p.j(paramb, "root.findViewById(R.id.f…on_info_audio_mode_pk_tv)");
      this.ypA = ((TextView)paramb);
      paramb = paramViewGroup.findViewById(b.f.finder_live_common_info_audio_mode_pk_icon);
      p.j(paramb, "root.findViewById(R.id.f…_info_audio_mode_pk_icon)");
      this.ypB = ((PAGView)paramb);
      paramb = paramViewGroup.findViewById(b.f.finder_live_audio_mode_tip_group);
      p.j(paramb, "root.findViewById(R.id.f…ive_audio_mode_tip_group)");
      this.ypC = ((ViewGroup)paramb);
      paramb = paramViewGroup.findViewById(b.f.finder_live_common_info_mute_tip);
      p.j(paramb, "root.findViewById(R.id.f…ive_common_info_mute_tip)");
      this.ypD = ((WeImageView)paramb);
      paramb = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.1F }).setDuration(800L);
      paramb.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this));
      this.ypF = paramb;
      paramb = ObjectAnimator.ofFloat(new float[] { 0.1F, 1.0F }).setDuration(800L);
      paramb.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this));
      this.ypG = paramb;
      this.kEi = tV(b.i.live_net_good_icon);
      this.kEj = tV(b.i.live_net_normal_icon);
      this.kEk = tV(b.i.live_net_bad_icon);
      paramb = e.m.kkI;
      this.kEl = e.m.aKG();
      this.kEm = "00:00:00";
      this.ypI = 1;
      this.vsK.setImageDrawable(au.o(paramViewGroup.getContext(), b.i.icons_outlined_cheer, -1));
      this.kEd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(281424);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
          {
            paramAnonymousView = com.tencent.mm.plugin.finder.live.report.k.yBj;
            com.tencent.mm.plugin.finder.live.report.k.a(s.c.yEB, String.valueOf(s.ax.yKm.action));
          }
          for (;;)
          {
            com.tencent.mm.live.c.b.b.a(at.r(this.ypO), b.c.kAj);
            do
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(281424);
              return;
            } while (!at.x(this.ypO));
            if (at.r(this.ypO).getLiveRole() == 0)
            {
              paramAnonymousView = m.yCt;
              m.a(s.bk.yMn, "", 0);
            }
          }
        }
      });
      paramb = aj.AGc;
      if (aj.eej()) {
        this.kEd.setOnLongClickListener((View.OnLongClickListener)2.ypP);
      }
      paramb = this.ypy;
      Context localContext = paramViewGroup.getContext();
      p.j(localContext, "root.context");
      paramb.setFile(PAGFile.Load(localContext.getAssets(), "finder_live_link_mic_wave.pag"));
      this.ypy.setRepeatCount(-1);
      paramb = this.ypB;
      paramViewGroup = paramViewGroup.getContext();
      p.j(paramViewGroup, "root.context");
      paramb.setFile(PAGFile.Load(paramViewGroup.getAssets(), "finder_live_link_mic_wave.pag"));
      this.ypB.setRepeatCount(-1);
      this.ypv.setVisibility(8);
      this.ypD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(273582);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.live.c.b.b.a(at.r(this.ypO), b.c.kAE);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(273582);
        }
      });
      paramViewGroup = new AnimatorSet();
      paramViewGroup.playSequentially(new Animator[] { (Animator)this.ypF, (Animator)this.ypG });
      paramViewGroup.addListener((Animator.AnimatorListener)new g(this));
      this.ypE = paramViewGroup;
      Log.i(this.TAG, "filterVisitorResetValue:" + this.ypu);
      AppMethodBeat.o(282847);
      return;
    }
  }
  
  private final void dBm()
  {
    AppMethodBeat.i(282832);
    AnimatorSet localAnimatorSet = this.ypE;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.start();
      AppMethodBeat.o(282832);
      return;
    }
    AppMethodBeat.o(282832);
  }
  
  private final void dBn()
  {
    int j = 1;
    AppMethodBeat.i(282833);
    int i;
    if ((com.tencent.mm.ae.d.dr(this.ypH, ypK)) || (com.tencent.mm.ae.d.dr(this.ypH, ypM)))
    {
      this.ypw.setVisibility(0);
      if (com.tencent.mm.ae.d.dr(this.ypH, ypK))
      {
        this.ypx.setVisibility(0);
        if (!com.tencent.mm.ae.d.dr(this.ypH, ypM)) {
          break label174;
        }
        this.ypD.setVisibility(0);
        dBm();
        this.ypy.setVisibility(4);
        this.ypy.stop();
        i = 1;
        label105:
        if (!com.tencent.mm.ae.d.dr(this.ypH, ypL)) {
          break label219;
        }
        this.ypz.setVisibility(0);
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label246;
      }
      this.ypC.setVisibility(0);
      AppMethodBeat.o(282833);
      return;
      this.ypx.setVisibility(8);
      this.ypy.setVisibility(4);
      this.ypy.stop();
      break;
      label174:
      this.ypD.setVisibility(4);
      AnimatorSet localAnimatorSet = this.ypE;
      if (localAnimatorSet != null)
      {
        localAnimatorSet.cancel();
        i = 1;
        break label105;
      }
      i = 1;
      break label105;
      this.ypw.setVisibility(8);
      i = 0;
      break label105;
      label219:
      this.ypz.setVisibility(8);
      this.ypB.setVisibility(4);
      this.ypB.stop();
    }
    label246:
    this.ypC.setVisibility(8);
    AppMethodBeat.o(282833);
  }
  
  private final Drawable tV(int paramInt)
  {
    AppMethodBeat.i(282842);
    Object localObject = this.kiF.getContext();
    p.j(localObject, "root.context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt);
    p.j(localObject, "root.context.resources.getDrawable(resId)");
    AppMethodBeat.o(282842);
    return localObject;
  }
  
  public final void Ny(int paramInt)
  {
    AppMethodBeat.i(282836);
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      int i = cm.bfF();
      r.a locala = r.kvH;
      this.kEm = r.a.a(i - paramInt, ":", false, false, false, 28);
      paramInt = i - paramInt;
      if (paramInt <= 0) {
        break label65;
      }
    }
    label65:
    for (long l = paramInt;; l = 0L)
    {
      this.duration = l;
      AppMethodBeat.o(282836);
      return;
    }
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(282845);
    p.k(paramLinkedHashMap, "micUserMap");
    if (paramLinkedHashMap.size() <= 1)
    {
      this.ypH &= (ypL ^ 0xFFFFFFFF);
      dBn();
    }
    AppMethodBeat.o(282845);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void dBo()
  {
    AppMethodBeat.i(282834);
    this.kiF.post((Runnable)new h(this));
    AppMethodBeat.o(282834);
  }
  
  public final void dBp()
  {
    AppMethodBeat.i(282837);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (!com.tencent.mm.plugin.finder.live.utils.a.k(getBuContext()))
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.l(getBuContext())) {}
    }
    else
    {
      localObject = com.tencent.mm.live.core.core.b.a.knj;
      this.kEl = a.a.aLu().knA.kmJ;
      AppMethodBeat.o(282837);
      return;
    }
    localObject = com.tencent.mm.live.core.core.a.b.klq;
    if (com.tencent.mm.live.core.core.a.b.b.aLi())
    {
      localObject = com.tencent.mm.live.core.core.a.b.klq;
      this.kEl = com.tencent.mm.live.core.core.a.b.b.aLh().knA.kmJ;
    }
    AppMethodBeat.o(282837);
  }
  
  public final void dBq()
  {
    AppMethodBeat.i(282840);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(282840);
  }
  
  public final void dBr()
  {
    AppMethodBeat.i(282841);
    Log.i(this.TAG, "checkPkAnchorAudioVolume business(LiveLinkMicSlice::class.java).curLinkMicUser:" + ((f)business(f.class)).zhl);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(282841);
  }
  
  public final void dBs()
  {
    AppMethodBeat.i(282843);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    this.fFE = com.tencent.mm.plugin.finder.live.utils.a.dEy();
    AppMethodBeat.o(282843);
  }
  
  public final void pd(final boolean paramBoolean)
  {
    AppMethodBeat.i(282838);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramBoolean));
    AppMethodBeat.o(282838);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(282846);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (au.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        AppMethodBeat.o(282846);
        return;
        tU(8);
        AppMethodBeat.o(282846);
        return;
        if (paramBundle != null) {
          bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", false);
        }
        if (bool) {}
        for (this.ypH |= ypK;; this.ypH &= (ypK ^ 0xFFFFFFFF))
        {
          dBn();
          AppMethodBeat.o(282846);
          return;
        }
        paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      } while (!com.tencent.mm.plugin.finder.live.utils.a.dEA());
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_IS_MUTE_MIC", false);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgs = bool;
        if (!bool) {
          break label206;
        }
      }
      label206:
      for (this.ypH |= ypM;; this.ypH &= (ypM ^ 0xFFFFFFFF))
      {
        dBn();
        AppMethodBeat.o(282846);
        return;
        bool = false;
        break;
      }
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgs) {}
    for (this.ypH |= ypM;; this.ypH &= (ypM ^ 0xFFFFFFFF))
    {
      dBn();
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(282844);
    super.unMount();
    AppMethodBeat.o(282844);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$anchorMuteIn$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(at paramat) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(275991);
      WeImageView localWeImageView = at.a(this.ypO);
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(275991);
        throw paramValueAnimator;
      }
      localWeImageView.setAlpha(((Float)paramValueAnimator).floatValue());
      AppMethodBeat.o(275991);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$anchorMuteOut$1$1"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(at paramat) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(270126);
      WeImageView localWeImageView = at.a(this.ypO);
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(270126);
        throw paramValueAnimator;
      }
      localWeImageView.setAlpha(((Float)paramValueAnimator).floatValue());
      AppMethodBeat.o(270126);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "DEBUG_CNT", "", "getDEBUG_CNT", "()I", "setDEBUG_CNT", "(I)V", "EMPTY_TIMES_CHECK_THRESHPLD", "TIP_BAR_STATUS_ANCHOR_AUDIO", "getTIP_BAR_STATUS_ANCHOR_AUDIO", "setTIP_BAR_STATUS_ANCHOR_AUDIO", "TIP_BAR_STATUS_ANCHOR_MUTE", "getTIP_BAR_STATUS_ANCHOR_MUTE", "setTIP_BAR_STATUS_ANCHOR_MUTE", "TIP_BAR_STATUS_PK_ANCHOR_AUDIO", "getTIP_BAR_STATUS_PK_ANCHOR_AUDIO", "setTIP_BAR_STATUS_PK_ANCHOR_AUDIO", "plugin-finder_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(at paramat)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(at paramat)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(at paramat, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommonInfoPlugin$prepareMuteTipAnimator$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class g
    extends AnimatorListenerAdapter
  {
    g(at paramat) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(276874);
      if (at.a(this.ypO).getVisibility() == 0) {
        at.b(this.ypO);
      }
      AppMethodBeat.o(276874);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(at paramat) {}
    
    public final void run()
    {
      AppMethodBeat.i(273570);
      int i = at.c(this.ypO);
      Object localObject1 = e.m.kkI;
      if (i == e.m.aKG())
      {
        at.d(this.ypO).setImageDrawable(at.e(this.ypO));
        localObject1 = (bq)this.ypO.getPlugin(bq.class);
        if ((localObject1 == null) || (((com.tencent.mm.live.c.a)localObject1).kiF.getVisibility() != 0)) {
          break label160;
        }
      }
      label160:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label165;
        }
        Log.i(at.h(this.ypO), "memberListShowing refreshViews frozenRefresh!");
        AppMethodBeat.o(273570);
        return;
        localObject1 = e.m.kkI;
        if (i == e.m.aKH())
        {
          at.d(this.ypO).setImageDrawable(at.f(this.ypO));
          break;
        }
        localObject1 = e.m.kkI;
        if (i != e.m.aKI()) {
          break;
        }
        at.d(this.ypO).setImageDrawable(at.g(this.ypO));
        break;
      }
      label165:
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject1 = at.h(this.ypO);
      Object localObject2 = new StringBuilder("totalCnt:");
      Object localObject3 = aj.AGc;
      localObject2 = ((StringBuilder)localObject2).append(aj.Rh(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ypO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfq)).append(',').append("onlineCnt:");
      localObject3 = aj.AGc;
      localObject2 = ((StringBuilder)localObject2).append(aj.Rh(((c)this.ypO.business(c.class)).liveInfo.yYz)).append(',').append("heatAmount:");
      localObject3 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.ha((String)localObject1, com.tencent.mm.plugin.finder.live.utils.a.a(((c)this.ypO.business(c.class)).liveInfo) + ',' + "commonInfoEmptyTimesCheckIndex:" + at.i(this.ypO));
      localObject1 = af.aaBG;
      localObject1 = this.ypO.kiF.getContext().getString(b.j.finder_live_members_total_tip);
      p.j(localObject1, "root.context.getString(R…r_live_members_total_tip)");
      localObject2 = aj.AGc;
      localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { aj.Rh(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ypO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfq) }, 1));
      p.j(localObject1, "java.lang.String.format(format, *args)");
      localObject1 = new StringBuilder(String.valueOf(localObject1));
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      aj localaj;
      if ((com.tencent.mm.plugin.finder.live.utils.a.dEy()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.ypO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziV))
      {
        localObject2 = new StringBuilder(" · ");
        localObject3 = af.aaBG;
        localObject3 = this.ypO.kiF.getContext().getString(b.j.finder_live_members_tip);
        p.j(localObject3, "root.context.getString(R….finder_live_members_tip)");
        localaj = aj.AGc;
        localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { aj.Rh(((c)this.ypO.business(c.class)).liveInfo.yYz) }, 1));
        p.j(localObject3, "java.lang.String.format(format, *args)");
        ((StringBuilder)localObject1).append((String)localObject3);
      }
      for (i = 1;; i = 0)
      {
        long l;
        if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ypO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfH) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ypO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGF()))
        {
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.a(((c)this.ypO.business(c.class)).liveInfo);
          if (localObject2 != null)
          {
            l = ((Long)localObject2).longValue();
            localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            if ((!com.tencent.mm.plugin.finder.live.utils.a.dEy()) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.ypO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziV) && (l <= 0L)) {
              break label1181;
            }
            localObject2 = new StringBuilder(" · ");
            localObject3 = af.aaBG;
            localObject3 = this.ypO.kiF.getContext().getString(b.j.finder_live_wecoin_amount_in_hot);
            p.j(localObject3, "root.context.getString(R…ive_wecoin_amount_in_hot)");
            localaj = aj.AGc;
            localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { aj.Rg((int)l) }, 1));
            p.j(localObject3, "java.lang.String.format(format, *args)");
            ((StringBuilder)localObject1).append((String)localObject3);
          }
        }
        label1181:
        for (int j = 1;; j = 0)
        {
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if ((!com.tencent.mm.plugin.finder.live.utils.a.dEy()) && (this.ypO.ypu) && (i == 0) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ypO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfq == 0) && (at.i(this.ypO) % 5 != 0))
          {
            localObject1 = this.ypO;
            at.a((at)localObject1, at.i((at)localObject1) + 1);
            at.i((at)localObject1);
            AppMethodBeat.o(273570);
            return;
            l = 0L;
            break;
          }
          at.j(this.ypO).setText((CharSequence)((StringBuilder)localObject1).toString());
          localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
          {
            at.k(this.ypO).setVisibility(8);
            at.l(this.ypO).setVisibility(0);
            at.m(this.ypO).setVisibility(0);
            at.n(this.ypO).setText((CharSequence)String.valueOf(at.o(this.ypO)));
            localObject1 = at.p(this.ypO);
            localObject2 = aj.AGc;
            ((TextView)localObject1).setText((CharSequence)aj.Ni(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ypO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfk));
            at.q(this.ypO).setVisibility(0);
            if (at.r(this.ypO).getLiveRole() == 1)
            {
              localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
              com.tencent.mm.plugin.finder.live.report.k.dDm().yDu = ((c)this.ypO.business(c.class)).liveInfo.yYz;
              localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
              com.tencent.mm.plugin.finder.live.report.k.dDm().yDv = (at.s(this.ypO) * 1000L);
              localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
              com.tencent.mm.plugin.finder.live.report.k.dDm().yDt = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ypO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfk;
              AppMethodBeat.o(273570);
            }
          }
          else
          {
            at.k(this.ypO).setVisibility(8);
            at.l(this.ypO).setVisibility(8);
            at.m(this.ypO).setVisibility(0);
            if ((j != 0) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.ypO.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).ziV))
            {
              at.q(this.ypO).setVisibility(0);
              AppMethodBeat.o(273570);
              return;
            }
            at.q(this.ypO).setVisibility(8);
          }
          AppMethodBeat.o(273570);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.at
 * JD-Core Version:    0.7.0.1
 */