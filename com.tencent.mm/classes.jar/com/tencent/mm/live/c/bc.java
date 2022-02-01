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
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.d.c;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blankArea", "Landroid/view/View;", "cancelBtn", "Landroid/widget/Button;", "dialogGroup", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "okBtn", "previewLayout", "Landroid/widget/RelativeLayout;", "previewView", "Landroid/view/SurfaceView;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setStatusMonitor", "(Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "switchCameraBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCameraSurface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "hide", "", "cancel", "", "onBackPress", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class bc
  extends a
{
  b gVv;
  private final Button gXc;
  private View gYC;
  public com.tencent.mm.live.core.core.trtc.a gZJ;
  private ViewGroup gZU;
  private RelativeLayout gZV;
  private final WeImageView gZW;
  private SurfaceView gZX;
  private final Button gZv;
  
  public bc(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216245);
    this.gVv = paramb;
    paramb = paramViewGroup.findViewById(2131307826);
    p.g(paramb, "root.findViewById(R.id.l…eo_mic_dialog_blank_area)");
    this.gYC = paramb;
    paramb = paramViewGroup.findViewById(2131307828);
    p.g(paramb, "root.findViewById(R.id.l…mic_dialog_content_group)");
    this.gZU = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(2131307854);
    p.g(paramb, "root.findViewById(R.id.local_camera_view)");
    this.gZV = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307830);
    p.g(paramb, "root.findViewById(R.id.l…_video_mic_dialog_ok_btn)");
    this.gXc = ((Button)paramb);
    paramb = paramViewGroup.findViewById(2131307827);
    p.g(paramb, "root.findViewById(R.id.l…eo_mic_dialog_cancel_btn)");
    this.gZv = ((Button)paramb);
    this.gZW = ((WeImageView)paramViewGroup.findViewById(2131307831));
    paramb = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496353, null);
    if (paramb == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.view.SurfaceView");
      AppMethodBeat.o(216245);
      throw paramViewGroup;
    }
    this.gZX = ((SurfaceView)paramb);
    this.gXc.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216235);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.b.a(this.gZY.gVv, b.c.gUJ);
        this.gZY.dX(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216235);
      }
    });
    this.gZv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216236);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.gZY.dX(true);
        paramAnonymousView = this.gZY.gZJ;
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.gLc;
          if ((paramAnonymousView != null) && (!paramAnonymousView.alT())) {
            c.apM();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216236);
      }
    });
    this.gYC.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216237);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.gZY.dX(true);
        paramAnonymousView = this.gZY.gZJ;
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.gLc;
          if ((paramAnonymousView != null) && (!paramAnonymousView.alT())) {
            c.apM();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216237);
      }
    });
    this.gZW.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216238);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        b.b.a(this.gZY.gVv, b.c.gUf);
        paramAnonymousView = g.gQZ;
        paramAnonymousView = g.anL();
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.gKk;
          if (paramAnonymousView != null)
          {
            localObject = g.gQZ;
            localObject = g.anL();
            if (localObject == null) {
              break label123;
            }
            localObject = ((d)localObject).gKk;
            if (localObject == null) {
              break label123;
            }
            bool = ((com.tencent.mm.live.core.core.b.b)localObject).gKd;
            if (bool) {
              break label128;
            }
          }
        }
        label128:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.gKd = bool;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216238);
          return;
          label123:
          bool = true;
          break;
        }
      }
    });
    this.gZU.setTranslationY(ar.ck(paramViewGroup.getContext()).y);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -1);
      if (!aoA()) {
        paramb.bottomMargin = ar.en(paramViewGroup.getContext());
      }
      paramb.width = ar.ck(paramViewGroup.getContext()).y;
      paramb.addRule(14);
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      p.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(216245);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216243);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (bd.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216243);
      return;
      nL(0);
      paramc = this.gZX.getParent();
      if (paramc != null)
      {
        if (paramc == null)
        {
          paramc = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(216243);
          throw paramc;
        }
        ((ViewGroup)paramc).removeView((View)this.gZX);
      }
      this.gZV.addView((View)this.gZX);
      this.gZW.bringToFront();
      this.gZU.animate().translationY(0.0F).setListener(null).start();
      AppMethodBeat.o(216243);
      return;
      paramc = g.gQZ;
      g.dR(true);
      AppMethodBeat.o(216243);
      return;
      paramc = this.gZJ;
      if (paramc != null)
      {
        paramc = paramc.gLc;
        if (paramc != null)
        {
          if (paramc.alT() != true) {
            continue;
          }
          c.apS();
          AppMethodBeat.o(216243);
          return;
        }
      }
      AppMethodBeat.o(216243);
      return;
      paramc = this.gZJ;
      if (paramc != null)
      {
        paramc = paramc.gLc;
        if (paramc != null)
        {
          if (paramc.alT() != true) {
            continue;
          }
          c.apR();
          AppMethodBeat.o(216243);
          return;
        }
      }
      AppMethodBeat.o(216243);
      return;
      paramc = this.gZJ;
      if (paramc != null)
      {
        paramc = paramc.gLc;
        if ((paramc != null) && (paramc.alT() == true))
        {
          c.apO();
          AppMethodBeat.o(216243);
          return;
        }
      }
      c.apN();
    }
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(216244);
    if (this.gJt.getVisibility() == 0)
    {
      dX(true);
      AppMethodBeat.o(216244);
      return true;
    }
    boolean bool = super.aoQ();
    AppMethodBeat.o(216244);
    return bool;
  }
  
  public final j apm()
  {
    AppMethodBeat.i(216242);
    j localj = new j(this.gZX.getHolder());
    AppMethodBeat.o(216242);
    return localj;
  }
  
  public final void dX(boolean paramBoolean)
  {
    AppMethodBeat.i(216241);
    this.gZU.animate().translationY(ar.ck(this.gJt.getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
    if (paramBoolean) {
      b.b.a(this.gVv, b.c.gUI);
    }
    this.gZV.removeView((View)this.gZX);
    AppMethodBeat.o(216241);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveVideoMicPlugin$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(216240);
      this.gZY.nL(8);
      AppMethodBeat.o(216240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.bc
 * JD-Core Version:    0.7.0.1
 */