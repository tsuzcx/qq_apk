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
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.d.c;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blankArea", "Landroid/view/View;", "cancelBtn", "Landroid/widget/Button;", "dialogGroup", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "okBtn", "previewLayout", "Landroid/widget/RelativeLayout;", "previewView", "Landroid/view/SurfaceView;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setStatusMonitor", "(Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "switchCameraBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCameraSurface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "hide", "", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class bd
  extends a
{
  b IIs;
  public com.tencent.mm.live.core.core.trtc.a KwS;
  private ViewGroup Kxc;
  private RelativeLayout Kxd;
  private final WeImageView Kxe;
  private SurfaceView Kxf;
  private final Button hJg;
  private final Button hJh;
  private View yqI;
  
  public bd(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(203091);
    this.IIs = paramb;
    paramb = paramViewGroup.findViewById(2131307745);
    k.g(paramb, "root.findViewById(R.id.l…eo_mic_dialog_blank_area)");
    this.yqI = paramb;
    paramb = paramViewGroup.findViewById(2131307747);
    k.g(paramb, "root.findViewById(R.id.l…mic_dialog_content_group)");
    this.Kxc = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(2131307775);
    k.g(paramb, "root.findViewById(R.id.local_camera_view)");
    this.Kxd = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307749);
    k.g(paramb, "root.findViewById(R.id.l…_video_mic_dialog_ok_btn)");
    this.hJh = ((Button)paramb);
    paramb = paramViewGroup.findViewById(2131307746);
    k.g(paramb, "root.findViewById(R.id.l…eo_mic_dialog_cancel_btn)");
    this.hJg = ((Button)paramb);
    this.Kxe = ((WeImageView)paramViewGroup.findViewById(2131307750));
    paramb = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496344, null);
    if (paramb == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.view.SurfaceView");
      AppMethodBeat.o(203091);
      throw paramViewGroup;
    }
    this.Kxf = ((SurfaceView)paramb);
    this.hJh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203082);
        b.b.a(this.Kxg.IIs, b.c.HRF);
        this.Kxg.hide();
        AppMethodBeat.o(203082);
      }
    });
    this.hJg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203083);
        this.Kxg.hide();
        paramAnonymousView = this.Kxg.KwS;
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.qEd;
          if (paramAnonymousView != null)
          {
            if (!paramAnonymousView.cnw()) {
              c.fPz();
            }
            AppMethodBeat.o(203083);
            return;
          }
        }
        AppMethodBeat.o(203083);
      }
    });
    this.yqI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203084);
        this.Kxg.hide();
        paramAnonymousView = this.Kxg.KwS;
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.qEd;
          if (paramAnonymousView != null)
          {
            if (!paramAnonymousView.cnw()) {
              c.fPz();
            }
            AppMethodBeat.o(203084);
            return;
          }
        }
        AppMethodBeat.o(203084);
      }
    });
    this.Kxe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203085);
        b.b.a(this.Kxg.IIs, b.c.FAY);
        AppMethodBeat.o(203085);
      }
    });
    this.Kxc.setTranslationY(ap.cf(paramViewGroup.getContext()).y);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-1, -1);
      paramb.bottomMargin = ap.eb(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      k.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(203091);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(203090);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (be.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203090);
      return;
      paramc = f.rGw;
      f.lj(true);
      agK(0);
      paramc = this.Kxf.getParent();
      if (paramc != null)
      {
        if (paramc == null)
        {
          paramc = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(203090);
          throw paramc;
        }
        ((ViewGroup)paramc).removeView((View)this.Kxf);
      }
      this.Kxd.addView((View)this.Kxf);
      this.Kxe.bringToFront();
      this.Kxc.animate().translationY(0.0F).setListener(null).start();
      AppMethodBeat.o(203090);
      return;
      paramc = this.KwS;
      if (paramc != null)
      {
        paramc = paramc.qEd;
        if (paramc != null)
        {
          if (paramc.cnw() != true) {
            continue;
          }
          c.fPF();
          AppMethodBeat.o(203090);
          return;
        }
      }
      AppMethodBeat.o(203090);
      return;
      paramc = this.KwS;
      if (paramc != null)
      {
        paramc = paramc.qEd;
        if (paramc != null)
        {
          if (paramc.cnw() != true) {
            continue;
          }
          c.fPE();
          AppMethodBeat.o(203090);
          return;
        }
      }
      AppMethodBeat.o(203090);
      return;
      paramc = this.KwS;
      if (paramc != null)
      {
        paramc = paramc.qEd;
        if ((paramc != null) && (paramc.cnw() == true))
        {
          c.fPB();
          AppMethodBeat.o(203090);
          return;
        }
      }
      c.fPA();
    }
  }
  
  public final j fPa()
  {
    AppMethodBeat.i(203089);
    j localj = new j(this.Kxf.getHolder());
    AppMethodBeat.o(203089);
    return localj;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(203088);
    this.Kxc.animate().translationY(ap.cf(this.pTc.getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
    this.Kxd.removeView((View)this.Kxf);
    AppMethodBeat.o(203088);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveVideoMicPlugin$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(203087);
      this.Kxg.agK(8);
      AppMethodBeat.o(203087);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.bd
 * JD-Core Version:    0.7.0.1
 */