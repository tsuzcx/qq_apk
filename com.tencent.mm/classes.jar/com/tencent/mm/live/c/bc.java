package com.tencent.mm.live.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.core.b.n;
import com.tencent.mm.live.core.core.model.e;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.d.c;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blankArea", "Landroid/view/View;", "cancelBtn", "Landroid/widget/Button;", "dialogGroup", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "okBtn", "previewLayout", "Landroid/widget/RelativeLayout;", "previewView", "Landroid/view/SurfaceView;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setStatusMonitor", "(Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "switchCameraBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCameraSurface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "hide", "", "cancel", "", "onBackPress", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class bc
  extends a
{
  b kCL;
  private final Button kEt;
  private View kFU;
  private final Button kGN;
  private ViewGroup kHl;
  private RelativeLayout kHm;
  private final WeImageView kHn;
  private SurfaceView kHo;
  public com.tencent.mm.live.core.core.trtc.a kHp;
  
  public bc(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(193650);
    this.kCL = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_video_mic_dialog_blank_area);
    p.j(paramb, "root.findViewById(R.id.l…eo_mic_dialog_blank_area)");
    this.kFU = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_video_mic_dialog_content_group);
    p.j(paramb, "root.findViewById(R.id.l…mic_dialog_content_group)");
    this.kHl = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(b.e.local_camera_view);
    p.j(paramb, "root.findViewById(R.id.local_camera_view)");
    this.kHm = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_video_mic_dialog_ok_btn);
    p.j(paramb, "root.findViewById(R.id.l…_video_mic_dialog_ok_btn)");
    this.kEt = ((Button)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_video_mic_dialog_cancel_btn);
    p.j(paramb, "root.findViewById(R.id.l…eo_mic_dialog_cancel_btn)");
    this.kGN = ((Button)paramb);
    this.kHn = ((WeImageView)paramViewGroup.findViewById(b.e.live_video_mic_dialog_switch_camera_btn));
    paramb = LayoutInflater.from(paramViewGroup.getContext()).inflate(b.f.live_visitor_local_camera_layout, null);
    if (paramb == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.SurfaceView");
      AppMethodBeat.o(193650);
      throw paramViewGroup;
    }
    this.kHo = ((SurfaceView)paramb);
    this.kEt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196982);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVideoMicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        b.b.a(this.kHq.kCL, b.c.kzD);
        this.kHq.fv(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196982);
      }
    });
    this.kGN.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188653);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVideoMicPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        bc.a(this.kHq);
        paramAnonymousView = bc.b(this.kHq);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.knA;
          if ((paramAnonymousView != null) && (!paramAnonymousView.aLo())) {
            c.aQj();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(188653);
      }
    });
    this.kFU.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(197584);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVideoMicPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        bc.a(this.kHq);
        paramAnonymousView = bc.b(this.kHq);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.knA;
          if ((paramAnonymousView != null) && (!paramAnonymousView.aLo())) {
            c.aQj();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(197584);
      }
    });
    this.kHn.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191098);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVideoMicPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        b.b.a(this.kHq.kCL, b.c.kyX);
        paramAnonymousView = u.kwz;
        paramAnonymousView = u.aOv();
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.kmp;
          if (paramAnonymousView != null)
          {
            localObject = u.kwz;
            localObject = u.aOv();
            if (localObject == null) {
              break label123;
            }
            localObject = ((g)localObject).kmp;
            if (localObject == null) {
              break label123;
            }
            bool = ((e)localObject).kme;
            if (bool) {
              break label128;
            }
          }
        }
        label128:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.kme = bool;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(191098);
          return;
          label123:
          bool = true;
          break;
        }
      }
    });
    this.kHl.setTranslationY(ax.au(paramViewGroup.getContext()).y);
    if (paramViewGroup.findViewById(b.e.content_root_view) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -1);
      if (!isLandscape()) {
        paramb.bottomMargin = ax.aB(paramViewGroup.getContext());
      }
      paramb.width = ax.au(paramViewGroup.getContext()).y;
      paramb.addRule(14);
      paramViewGroup = paramViewGroup.findViewById(b.e.content_root_view);
      p.j(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(193650);
  }
  
  public final n aPJ()
  {
    AppMethodBeat.i(193641);
    n localn = new n(this.kHo.getHolder());
    AppMethodBeat.o(193641);
    return localn;
  }
  
  public final void fv(boolean paramBoolean)
  {
    AppMethodBeat.i(193637);
    this.kHl.animate().translationY(ax.au(this.kiF.getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
    if (paramBoolean) {
      b.b.a(this.kCL, b.c.kzC);
    }
    this.kHm.removeView((View)this.kHo);
    AppMethodBeat.o(193637);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(193648);
    if (this.kiF.getVisibility() == 0)
    {
      fv(true);
      AppMethodBeat.o(193648);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(193648);
    return bool;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(193646);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (bd.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(193646);
      return;
      tU(0);
      paramc = this.kHo.getParent();
      if (paramc != null)
      {
        if (paramc == null)
        {
          paramc = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(193646);
          throw paramc;
        }
        ((ViewGroup)paramc).removeView((View)this.kHo);
      }
      this.kHm.addView((View)this.kHo);
      this.kHn.bringToFront();
      this.kHl.animate().translationY(0.0F).setListener(null).start();
      AppMethodBeat.o(193646);
      return;
      paramc = u.kwz;
      u.ft(true);
      AppMethodBeat.o(193646);
      return;
      paramc = this.kHp;
      if (paramc != null)
      {
        paramc = paramc.knA;
        if (paramc != null)
        {
          if (paramc.aLo() != true) {
            continue;
          }
          c.aQp();
          AppMethodBeat.o(193646);
          return;
        }
      }
      AppMethodBeat.o(193646);
      return;
      paramc = this.kHp;
      if (paramc != null)
      {
        paramc = paramc.knA;
        if (paramc != null)
        {
          if (paramc.aLo() != true) {
            continue;
          }
          c.aQo();
          AppMethodBeat.o(193646);
          return;
        }
      }
      AppMethodBeat.o(193646);
      return;
      paramc = this.kHp;
      if (paramc != null)
      {
        paramc = paramc.knA;
        if ((paramc != null) && (paramc.aLo() == true))
        {
          c.aQl();
          AppMethodBeat.o(193646);
          return;
        }
      }
      c.aQk();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveVideoMicPlugin$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(191272);
      this.kHq.tU(8);
      AppMethodBeat.o(191272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bc
 * JD-Core Version:    0.7.0.1
 */