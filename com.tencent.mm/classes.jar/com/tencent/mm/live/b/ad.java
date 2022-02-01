package com.tencent.mm.live.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.c.c;
import com.tencent.mm.live.core.b.k;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.live.model.u;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blankArea", "Landroid/view/View;", "cancelBtn", "Landroid/widget/Button;", "dialogGroup", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "okBtn", "previewLayout", "Landroid/widget/RelativeLayout;", "previewView", "Landroid/view/SurfaceView;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setStatusMonitor", "(Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "switchCameraBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCameraSurface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "hide", "", "cancel", "", "onBackPress", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends a
{
  private b nfT;
  private final Button nhC;
  private View niW;
  private final Button njI;
  private ViewGroup nkc;
  private RelativeLayout nkd;
  private final WeImageView nke;
  private SurfaceView nkf;
  public com.tencent.mm.live.core.core.trtc.a nkg;
  
  public ad(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247381);
    this.nfT = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_video_mic_dialog_blank_area);
    s.s(paramb, "root.findViewById(R.id.l…eo_mic_dialog_blank_area)");
    this.niW = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_video_mic_dialog_content_group);
    s.s(paramb, "root.findViewById(R.id.l…mic_dialog_content_group)");
    this.nkc = ((ViewGroup)paramb);
    paramb = paramViewGroup.findViewById(b.e.local_camera_view);
    s.s(paramb, "root.findViewById(R.id.local_camera_view)");
    this.nkd = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_video_mic_dialog_ok_btn);
    s.s(paramb, "root.findViewById(R.id.l…_video_mic_dialog_ok_btn)");
    this.nhC = ((Button)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_video_mic_dialog_cancel_btn);
    s.s(paramb, "root.findViewById(R.id.l…eo_mic_dialog_cancel_btn)");
    this.njI = ((Button)paramb);
    this.nke = ((WeImageView)paramViewGroup.findViewById(b.e.live_video_mic_dialog_switch_camera_btn));
    paramb = LayoutInflater.from(paramViewGroup.getContext()).inflate(b.f.live_visitor_local_camera_layout, null);
    if (paramb == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
      AppMethodBeat.o(247381);
      throw paramViewGroup;
    }
    this.nkf = ((SurfaceView)paramb);
    this.nhC.setOnClickListener(new ad..ExternalSyntheticLambda0(this));
    this.njI.setOnClickListener(new ad..ExternalSyntheticLambda1(this));
    this.niW.setOnClickListener(new ad..ExternalSyntheticLambda2(this));
    this.nke.setOnClickListener(new ad..ExternalSyntheticLambda3(this));
    this.nkc.setTranslationY(bf.bf(paramViewGroup.getContext()).y);
    if (paramViewGroup.findViewById(b.e.content_root_view) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -1);
      if (!isLandscape()) {
        paramb.bottomMargin = bf.bk(paramViewGroup.getContext());
      }
      paramb.width = bf.bf(paramViewGroup.getContext()).y;
      paramb.addRule(14);
      ((RelativeLayout)paramViewGroup.findViewById(b.e.content_root_view)).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    AppMethodBeat.o(247381);
  }
  
  private static final void a(ad paramad, View paramView)
  {
    AppMethodBeat.i(247398);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramad);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVideoMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramad, "this$0");
    b.b.a(paramad.nfT, b.c.ncT);
    paramad.gc(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVideoMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247398);
  }
  
  private static final void b(ad paramad, View paramView)
  {
    AppMethodBeat.i(247408);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramad);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVideoMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramad, "this$0");
    paramad.gc(true);
    paramad = paramad.nkg;
    if (paramad != null)
    {
      paramad = paramad.mRB;
      if ((paramad == null) || (paramad.bet())) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        c.bjW();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVideoMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247408);
      return;
    }
  }
  
  private static final void c(ad paramad, View paramView)
  {
    AppMethodBeat.i(247418);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramad);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVideoMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramad, "this$0");
    paramad.gc(true);
    paramad = paramad.nkg;
    if (paramad != null)
    {
      paramad = paramad.mRB;
      if ((paramad == null) || (paramad.bet())) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        c.bjW();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVideoMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247418);
      return;
    }
  }
  
  private static final void d(ad paramad, View paramView)
  {
    AppMethodBeat.i(247425);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramad);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVideoMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramad, "this$0");
    b.b.a(paramad.nfT, b.c.ncm);
    paramad = u.mZl;
    paramad = u.bii();
    if (paramad == null)
    {
      paramad = null;
      if (paramad != null)
      {
        paramView = u.mZl;
        paramView = u.bii();
        if (paramView != null) {
          break label153;
        }
        bool = true;
        label105:
        if (bool) {
          break label175;
        }
      }
    }
    label153:
    label175:
    for (boolean bool = true;; bool = false)
    {
      paramad.mNj = bool;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVideoMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247425);
      return;
      paramad = paramad.mNB;
      break;
      paramView = paramView.mNB;
      if (paramView == null)
      {
        bool = true;
        break label105;
      }
      bool = paramView.mNj;
      break label105;
    }
  }
  
  private void gc(boolean paramBoolean)
  {
    AppMethodBeat.i(247391);
    this.nkc.animate().translationY(bf.bf(this.mJe.getContext()).y).setListener((Animator.AnimatorListener)new b(this)).start();
    if (paramBoolean) {
      b.b.a(this.nfT, b.c.ncS);
    }
    this.nkd.removeView((View)this.nkf);
    AppMethodBeat.o(247391);
  }
  
  public final k bjx()
  {
    AppMethodBeat.i(247457);
    k localk = new k(this.nkf.getHolder());
    AppMethodBeat.o(247457);
    return localk;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(247474);
    if (this.mJe.getVisibility() == 0)
    {
      gc(true);
      AppMethodBeat.o(247474);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(247474);
    return bool;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int j = 1;
    int k = 1;
    int i = 1;
    AppMethodBeat.i(247464);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ad.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247464);
      return;
      tO(0);
      paramc = this.nkf.getParent();
      if (paramc != null) {
        ((ViewGroup)paramc).removeView((View)this.nkf);
      }
      this.nkd.addView((View)this.nkf);
      this.nke.bringToFront();
      this.nkc.animate().translationY(0.0F).setListener(null).start();
      AppMethodBeat.o(247464);
      return;
      paramc = u.mZl;
      u.ga(true);
      AppMethodBeat.o(247464);
      return;
      paramc = this.nkg;
      if (paramc != null)
      {
        paramc = paramc.mRB;
        if ((paramc == null) || (paramc.bet() != true)) {}
      }
      while (i != 0)
      {
        c.bkc();
        AppMethodBeat.o(247464);
        return;
        i = 0;
      }
      paramc = this.nkg;
      if (paramc != null)
      {
        paramc = paramc.mRB;
        if ((paramc == null) || (paramc.bet() != true)) {}
      }
      for (i = j; i != 0; i = 0)
      {
        c.bkb();
        AppMethodBeat.o(247464);
        return;
      }
      paramc = this.nkg;
      if (paramc != null)
      {
        paramc = paramc.mRB;
        if ((paramc == null) || (paramc.bet() != true)) {}
      }
      for (i = k; i != 0; i = 0)
      {
        c.bjY();
        AppMethodBeat.o(247464);
        return;
      }
      c.bjX();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveVideoMicPlugin$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(ad paramad) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(247424);
      this.nkh.tO(8);
      AppMethodBeat.o(247424);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.ad
 * JD-Core Version:    0.7.0.1
 */