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
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blankArea", "Landroid/view/View;", "cancelBtn", "Landroid/widget/Button;", "dialogGroup", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "okBtn", "previewLayout", "Landroid/widget/RelativeLayout;", "previewView", "Landroid/view/SurfaceView;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setStatusMonitor", "(Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "switchCameraBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCameraSurface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "hide", "", "cancel", "", "onBackPress", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class bc
  extends a
{
  private final Button gAJ;
  private final Button gCY;
  private View gCi;
  private final WeImageView gDA;
  private SurfaceView gDB;
  public com.tencent.mm.live.core.core.trtc.a gDm;
  private ViewGroup gDy;
  private RelativeLayout gDz;
  b gzb;
  
  public bc(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190329);
    this.gzb = paramb;
    paramb = paramViewGroup.findViewById(2131307826);
    k.g(paramb, "root.findViewById(R.id.l…eo_mic_dialog_blank_area)");
    this.gCi = paramb;
    paramb = paramViewGroup.findViewById(2131307828);
    k.g(paramb, "root.findViewById(R.id.l…mic_dialog_content_group)");
    this.gDy = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(2131307854);
    k.g(paramb, "root.findViewById(R.id.local_camera_view)");
    this.gDz = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(2131307830);
    k.g(paramb, "root.findViewById(R.id.l…_video_mic_dialog_ok_btn)");
    this.gAJ = ((Button)paramb);
    paramb = paramViewGroup.findViewById(2131307827);
    k.g(paramb, "root.findViewById(R.id.l…eo_mic_dialog_cancel_btn)");
    this.gCY = ((Button)paramb);
    this.gDA = ((WeImageView)paramViewGroup.findViewById(2131307831));
    paramb = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496353, null);
    if (paramb == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.view.SurfaceView");
      AppMethodBeat.o(190329);
      throw paramViewGroup;
    }
    this.gDB = ((SurfaceView)paramb);
    this.gAJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190319);
        b.b.a(this.gDC.gzb, b.c.gyq);
        this.gDC.dT(false);
        AppMethodBeat.o(190319);
      }
    });
    this.gCY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190320);
        this.gDC.dT(true);
        paramAnonymousView = this.gDC.gDm;
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.goL;
          if (paramAnonymousView != null)
          {
            if (!paramAnonymousView.aiS()) {
              c.amL();
            }
            AppMethodBeat.o(190320);
            return;
          }
        }
        AppMethodBeat.o(190320);
      }
    });
    this.gCi.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190321);
        this.gDC.dT(true);
        paramAnonymousView = this.gDC.gDm;
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.goL;
          if (paramAnonymousView != null)
          {
            if (!paramAnonymousView.aiS()) {
              c.amL();
            }
            AppMethodBeat.o(190321);
            return;
          }
        }
        AppMethodBeat.o(190321);
      }
    });
    this.gDA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool2 = true;
        AppMethodBeat.i(190322);
        b.b.a(this.gDC.gzb, b.c.gxM);
        paramAnonymousView = g.guG;
        paramAnonymousView = g.akJ();
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.gnS;
          if (paramAnonymousView != null)
          {
            Object localObject = g.guG;
            localObject = g.akJ();
            if (localObject != null)
            {
              localObject = ((d)localObject).gnS;
              if (localObject != null)
              {
                bool1 = ((com.tencent.mm.live.core.core.b.b)localObject).gnL;
                if (bool1) {
                  break label96;
                }
              }
            }
            label96:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              paramAnonymousView.gnL = bool1;
              AppMethodBeat.o(190322);
              return;
              bool1 = true;
              break;
            }
          }
        }
        AppMethodBeat.o(190322);
      }
    });
    this.gDy.setTranslationY(ap.cl(paramViewGroup.getContext()).y);
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -1);
      if (!aly()) {
        paramb.bottomMargin = ap.ej(paramViewGroup.getContext());
      }
      paramb.width = ap.cl(paramViewGroup.getContext()).y;
      paramb.addRule(14);
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      k.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(190329);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190327);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (bd.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190327);
      return;
      nj(0);
      paramc = this.gDB.getParent();
      if (paramc != null)
      {
        if (paramc == null)
        {
          paramc = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(190327);
          throw paramc;
        }
        ((ViewGroup)paramc).removeView((View)this.gDB);
      }
      this.gDz.addView((View)this.gDB);
      this.gDA.bringToFront();
      this.gDy.animate().translationY(0.0F).setListener(null).start();
      AppMethodBeat.o(190327);
      return;
      paramc = g.guG;
      g.dO(true);
      AppMethodBeat.o(190327);
      return;
      paramc = this.gDm;
      if (paramc != null)
      {
        paramc = paramc.goL;
        if (paramc != null)
        {
          if (paramc.aiS() != true) {
            continue;
          }
          c.amR();
          AppMethodBeat.o(190327);
          return;
        }
      }
      AppMethodBeat.o(190327);
      return;
      paramc = this.gDm;
      if (paramc != null)
      {
        paramc = paramc.goL;
        if (paramc != null)
        {
          if (paramc.aiS() != true) {
            continue;
          }
          c.amQ();
          AppMethodBeat.o(190327);
          return;
        }
      }
      AppMethodBeat.o(190327);
      return;
      paramc = this.gDm;
      if (paramc != null)
      {
        paramc = paramc.goL;
        if ((paramc != null) && (paramc.aiS() == true))
        {
          c.amN();
          AppMethodBeat.o(190327);
          return;
        }
      }
      c.amM();
    }
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(190328);
    if (this.gnb.getVisibility() == 0)
    {
      dT(true);
      AppMethodBeat.o(190328);
      return true;
    }
    boolean bool = super.alO();
    AppMethodBeat.o(190328);
    return bool;
  }
  
  public final j aml()
  {
    AppMethodBeat.i(190326);
    j localj = new j(this.gDB.getHolder());
    AppMethodBeat.o(190326);
    return localj;
  }
  
  public final void dT(boolean paramBoolean)
  {
    AppMethodBeat.i(190325);
    this.gDy.animate().translationY(ap.cl(this.gnb.getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
    if (paramBoolean) {
      b.b.a(this.gzb, b.c.gyp);
    }
    this.gDz.removeView((View)this.gDB);
    AppMethodBeat.o(190325);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveVideoMicPlugin$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(190324);
      this.gDC.nj(8);
      AppMethodBeat.o(190324);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bc
 * JD-Core Version:    0.7.0.1
 */