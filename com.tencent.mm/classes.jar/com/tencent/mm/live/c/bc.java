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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blankArea", "Landroid/view/View;", "cancelBtn", "Landroid/widget/Button;", "dialogGroup", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "okBtn", "previewLayout", "Landroid/widget/RelativeLayout;", "previewView", "Landroid/view/SurfaceView;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setStatusMonitor", "(Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "switchCameraBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCameraSurface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "hide", "", "cancel", "", "onBackPress", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class bc
  extends a
{
  b gSM;
  private final Button gUt;
  private View gVS;
  private final Button gWI;
  public com.tencent.mm.live.core.core.trtc.a gWW;
  private ViewGroup gXi;
  private RelativeLayout gXj;
  private final WeImageView gXk;
  private SurfaceView gXl;
  
  public bc(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212619);
    this.gSM = paramb;
    paramb = paramViewGroup.findViewById(2131307826);
    p.g(paramb, "root.findViewById(R.id.l…eo_mic_dialog_blank_area)");
    this.gVS = paramb;
    paramb = paramViewGroup.findViewById(2131307828);
    p.g(paramb, "root.findViewById(R.id.l…mic_dialog_content_group)");
    this.gXi = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(2131307854);
    p.g(paramb, "root.findViewById(R.id.local_camera_view)");
    this.gXj = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307830);
    p.g(paramb, "root.findViewById(R.id.l…_video_mic_dialog_ok_btn)");
    this.gUt = ((Button)paramb);
    paramb = paramViewGroup.findViewById(2131307827);
    p.g(paramb, "root.findViewById(R.id.l…eo_mic_dialog_cancel_btn)");
    this.gWI = ((Button)paramb);
    this.gXk = ((WeImageView)paramViewGroup.findViewById(2131307831));
    paramb = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496353, null);
    if (paramb == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.view.SurfaceView");
      AppMethodBeat.o(212619);
      throw paramViewGroup;
    }
    this.gXl = ((SurfaceView)paramb);
    this.gUt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212609);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.b.a(this.gXm.gSM, b.c.gSb);
        this.gXm.dV(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212609);
      }
    });
    this.gWI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212610);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.gXm.dV(true);
        paramAnonymousView = this.gXm.gWW;
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.gIt;
          if ((paramAnonymousView != null) && (!paramAnonymousView.alE())) {
            c.apy();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212610);
      }
    });
    this.gVS.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212611);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.gXm.dV(true);
        paramAnonymousView = this.gXm.gWW;
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.gIt;
          if ((paramAnonymousView != null) && (!paramAnonymousView.alE())) {
            c.apy();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212611);
      }
    });
    this.gXk.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212612);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        b.b.a(this.gXm.gSM, b.c.gRx);
        paramAnonymousView = g.gOr;
        paramAnonymousView = g.anw();
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.gHB;
          if (paramAnonymousView != null)
          {
            localObject = g.gOr;
            localObject = g.anw();
            if (localObject == null) {
              break label123;
            }
            localObject = ((d)localObject).gHB;
            if (localObject == null) {
              break label123;
            }
            bool = ((com.tencent.mm.live.core.core.b.b)localObject).gHu;
            if (bool) {
              break label128;
            }
          }
        }
        label128:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.gHu = bool;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212612);
          return;
          label123:
          bool = true;
          break;
        }
      }
    });
    this.gXi.setTranslationY(ar.ci(paramViewGroup.getContext()).y);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -1);
      if (!aol()) {
        paramb.bottomMargin = ar.ej(paramViewGroup.getContext());
      }
      paramb.width = ar.ci(paramViewGroup.getContext()).y;
      paramb.addRule(14);
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      p.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(212619);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212617);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (bd.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212617);
      return;
      nI(0);
      paramc = this.gXl.getParent();
      if (paramc != null)
      {
        if (paramc == null)
        {
          paramc = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(212617);
          throw paramc;
        }
        ((ViewGroup)paramc).removeView((View)this.gXl);
      }
      this.gXj.addView((View)this.gXl);
      this.gXk.bringToFront();
      this.gXi.animate().translationY(0.0F).setListener(null).start();
      AppMethodBeat.o(212617);
      return;
      paramc = g.gOr;
      g.dQ(true);
      AppMethodBeat.o(212617);
      return;
      paramc = this.gWW;
      if (paramc != null)
      {
        paramc = paramc.gIt;
        if (paramc != null)
        {
          if (paramc.alE() != true) {
            continue;
          }
          c.apE();
          AppMethodBeat.o(212617);
          return;
        }
      }
      AppMethodBeat.o(212617);
      return;
      paramc = this.gWW;
      if (paramc != null)
      {
        paramc = paramc.gIt;
        if (paramc != null)
        {
          if (paramc.alE() != true) {
            continue;
          }
          c.apD();
          AppMethodBeat.o(212617);
          return;
        }
      }
      AppMethodBeat.o(212617);
      return;
      paramc = this.gWW;
      if (paramc != null)
      {
        paramc = paramc.gIt;
        if ((paramc != null) && (paramc.alE() == true))
        {
          c.apA();
          AppMethodBeat.o(212617);
          return;
        }
      }
      c.apz();
    }
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(212618);
    if (this.gGK.getVisibility() == 0)
    {
      dV(true);
      AppMethodBeat.o(212618);
      return true;
    }
    boolean bool = super.aoB();
    AppMethodBeat.o(212618);
    return bool;
  }
  
  public final j aoY()
  {
    AppMethodBeat.i(212616);
    j localj = new j(this.gXl.getHolder());
    AppMethodBeat.o(212616);
    return localj;
  }
  
  public final void dV(boolean paramBoolean)
  {
    AppMethodBeat.i(212615);
    this.gXi.animate().translationY(ar.ci(this.gGK.getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
    if (paramBoolean) {
      b.b.a(this.gSM, b.c.gSa);
    }
    this.gXj.removeView((View)this.gXl);
    AppMethodBeat.o(212615);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveVideoMicPlugin$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(212614);
      this.gXm.nI(8);
      AppMethodBeat.o(212614);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bc
 * JD-Core Version:    0.7.0.1
 */