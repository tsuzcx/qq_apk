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
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.d.c;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blankArea", "Landroid/view/View;", "cancelBtn", "Landroid/widget/Button;", "dialogGroup", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "okBtn", "previewLayout", "Landroid/widget/RelativeLayout;", "previewView", "Landroid/view/SurfaceView;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setStatusMonitor", "(Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "switchCameraBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCameraSurface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "hide", "", "cancel", "", "onBackPress", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class bc
  extends a
{
  b hOp;
  private final Button hPX;
  private View hRx;
  private ViewGroup hSO;
  private RelativeLayout hSP;
  private final WeImageView hSQ;
  private SurfaceView hSR;
  public com.tencent.mm.live.core.core.trtc.a hSS;
  private final Button hSq;
  
  public bc(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208206);
    this.hOp = paramb;
    paramb = paramViewGroup.findViewById(2131303614);
    p.g(paramb, "root.findViewById(R.id.l…eo_mic_dialog_blank_area)");
    this.hRx = paramb;
    paramb = paramViewGroup.findViewById(2131303616);
    p.g(paramb, "root.findViewById(R.id.l…mic_dialog_content_group)");
    this.hSO = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(2131303722);
    p.g(paramb, "root.findViewById(R.id.local_camera_view)");
    this.hSP = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131303618);
    p.g(paramb, "root.findViewById(R.id.l…_video_mic_dialog_ok_btn)");
    this.hPX = ((Button)paramb);
    paramb = paramViewGroup.findViewById(2131303615);
    p.g(paramb, "root.findViewById(R.id.l…eo_mic_dialog_cancel_btn)");
    this.hSq = ((Button)paramb);
    this.hSQ = ((WeImageView)paramViewGroup.findViewById(2131303619));
    paramb = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495293, null);
    if (paramb == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.SurfaceView");
      AppMethodBeat.o(208206);
      throw paramViewGroup;
    }
    this.hSR = ((SurfaceView)paramb);
    this.hPX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208196);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b.a(this.hST.hOp, b.c.hMi);
        this.hST.eQ(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208196);
      }
    });
    this.hSq.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208197);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.hST.eQ(true);
        paramAnonymousView = this.hST.hSS;
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.hAz;
          if ((paramAnonymousView != null) && (!paramAnonymousView.aDt())) {
            c.aIl();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208197);
      }
    });
    this.hRx.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208198);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.hST.eQ(true);
        paramAnonymousView = this.hST.hSS;
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.hAz;
          if ((paramAnonymousView != null) && (!paramAnonymousView.aDt())) {
            c.aIl();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208198);
      }
    });
    this.hSQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208199);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        b.b.a(this.hST.hOp, b.c.hLE);
        paramAnonymousView = x.hJf;
        paramAnonymousView = x.aGv();
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.hzt;
          if (paramAnonymousView != null)
          {
            localObject = x.hJf;
            localObject = x.aGv();
            if (localObject == null) {
              break label123;
            }
            localObject = ((f)localObject).hzt;
            if (localObject == null) {
              break label123;
            }
            bool = ((d)localObject).hzh;
            if (bool) {
              break label128;
            }
          }
        }
        label128:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.hzh = bool;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208199);
          return;
          label123:
          bool = true;
          break;
        }
      }
    });
    this.hSO.setTranslationY(au.az(paramViewGroup.getContext()).y);
    if (paramViewGroup.findViewById(2131299216) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -1);
      if (!isLandscape()) {
        paramb.bottomMargin = au.aD(paramViewGroup.getContext());
      }
      paramb.width = au.az(paramViewGroup.getContext()).y;
      paramb.addRule(14);
      paramViewGroup = paramViewGroup.findViewById(2131299216);
      p.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(208206);
  }
  
  public final com.tencent.mm.live.core.b.l aHL()
  {
    AppMethodBeat.i(208203);
    com.tencent.mm.live.core.b.l locall = new com.tencent.mm.live.core.b.l(this.hSR.getHolder());
    AppMethodBeat.o(208203);
    return locall;
  }
  
  public final void eQ(boolean paramBoolean)
  {
    AppMethodBeat.i(208202);
    this.hSO.animate().translationY(au.az(this.hwr.getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
    if (paramBoolean) {
      b.b.a(this.hOp, b.c.hMh);
    }
    this.hSP.removeView((View)this.hSR);
    AppMethodBeat.o(208202);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(208205);
    if (this.hwr.getVisibility() == 0)
    {
      eQ(true);
      AppMethodBeat.o(208205);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(208205);
    return bool;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208204);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (bd.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208204);
      return;
      rg(0);
      paramc = this.hSR.getParent();
      if (paramc != null)
      {
        if (paramc == null)
        {
          paramc = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(208204);
          throw paramc;
        }
        ((ViewGroup)paramc).removeView((View)this.hSR);
      }
      this.hSP.addView((View)this.hSR);
      this.hSQ.bringToFront();
      this.hSO.animate().translationY(0.0F).setListener(null).start();
      AppMethodBeat.o(208204);
      return;
      paramc = x.hJf;
      x.eN(true);
      AppMethodBeat.o(208204);
      return;
      paramc = this.hSS;
      if (paramc != null)
      {
        paramc = paramc.hAz;
        if (paramc != null)
        {
          if (paramc.aDt() != true) {
            continue;
          }
          c.aIr();
          AppMethodBeat.o(208204);
          return;
        }
      }
      AppMethodBeat.o(208204);
      return;
      paramc = this.hSS;
      if (paramc != null)
      {
        paramc = paramc.hAz;
        if (paramc != null)
        {
          if (paramc.aDt() != true) {
            continue;
          }
          c.aIq();
          AppMethodBeat.o(208204);
          return;
        }
      }
      AppMethodBeat.o(208204);
      return;
      paramc = this.hSS;
      if (paramc != null)
      {
        paramc = paramc.hAz;
        if ((paramc != null) && (paramc.aDt() == true))
        {
          c.aIn();
          AppMethodBeat.o(208204);
          return;
        }
      }
      c.aIm();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveVideoMicPlugin$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(208201);
      this.hST.rg(8);
      AppMethodBeat.o(208201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.bc
 * JD-Core Version:    0.7.0.1
 */