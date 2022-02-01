package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.ae;
import com.tencent.mm.plugin.finder.live.report.q.af;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleContract$ViewCallback;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleContract$Presenter;", "setRootVisibleFunction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleContract$Presenter;Lkotlin/jvm/functions/Function1;)V", "onBubbleClick", "Lkotlin/Function0;", "getOnBubbleClick", "()Lkotlin/jvm/functions/Function0;", "setOnBubbleClick", "(Lkotlin/jvm/functions/Function0;)V", "smallAnim", "Lorg/libpag/PAGView;", "getSmallAnim", "()Lorg/libpag/PAGView;", "setSmallAnim", "(Lorg/libpag/PAGView;)V", "smallAnimContainer", "Landroid/widget/FrameLayout;", "getSmallAnimContainer", "()Landroid/widget/FrameLayout;", "setSmallAnimContainer", "(Landroid/widget/FrameLayout;)V", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "hideBubbleView", "initSmallAnim", "showBubbleView", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a.b
{
  public static final c.a Cwf;
  private final a.a Cwg;
  private final kotlin.g.a.b<Integer, ah> Cwh;
  private FrameLayout Cwi;
  PAGView Cwj;
  private kotlin.g.a.a<ah> Cwk;
  private final MMActivity activity;
  private final View lBX;
  
  static
  {
    AppMethodBeat.i(352572);
    Cwf = new c.a((byte)0);
    AppMethodBeat.o(352572);
  }
  
  public c(View paramView, MMActivity paramMMActivity, a.a parama, kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(352548);
    this.lBX = paramView;
    this.activity = paramMMActivity;
    this.Cwg = parama;
    this.Cwh = paramb;
    this.lBX.setOnClickListener(new c..ExternalSyntheticLambda0(this));
    this.Cwi = ((FrameLayout)this.lBX.findViewById(p.e.BBr));
    if (this.Cwj == null)
    {
      Log.i("FinderLiveAllowanceGiftBubbleViewCallback", "#initSmallAnim create smallAnim!");
      paramView = this.Cwi;
      if (paramView != null) {
        paramView.removeAllViews();
      }
      this.Cwj = new PAGView(this.lBX.getContext());
      paramView = new FrameLayout.LayoutParams(com.tencent.mm.live.core.view.c.dip2px((Context)this.activity, 72.0F), com.tencent.mm.live.core.view.c.dip2px((Context)this.activity, 172.0F));
      paramMMActivity = this.Cwj;
      if (paramMMActivity != null) {
        paramMMActivity.setLayoutParams((ViewGroup.LayoutParams)paramView);
      }
      paramView = this.Cwj;
      if (paramView != null) {
        paramView.setScaleMode(1);
      }
      paramView = this.Cwi;
      if (paramView != null) {
        paramView.addView((View)this.Cwj);
      }
    }
    this.Cwh.invoke(Integer.valueOf(8));
    AppMethodBeat.o(352548);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(352560);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc = paramc.Cwk;
    if (paramc != null) {
      paramc.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352560);
  }
  
  public final void aU(kotlin.g.a.a<ah> parama)
  {
    this.Cwk = parama;
  }
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final void ehs()
  {
    AppMethodBeat.i(352591);
    Log.i("FinderLiveAllowanceGiftBubbleViewCallback", "#showBubbleView");
    if (this.lBX.isShown())
    {
      AppMethodBeat.o(352591);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
      j.Dob.a(q.c.DrP, String.valueOf(q.ae.DxU.action));
    }
    for (;;)
    {
      this.Cwh.invoke(Integer.valueOf(0));
      localObject = this.Cwj;
      if (localObject != null) {
        ((PAGView)localObject).stop();
      }
      localObject = this.Cwj;
      if (localObject != null) {
        ((PAGView)localObject).setFile(PAGFile.Load(this.activity.getAssets(), "finder_live_allowance_gift_bubble_icon.pag"));
      }
      localObject = this.Cwj;
      if (localObject != null) {
        ((PAGView)localObject).setRepeatCount(1);
      }
      localObject = this.Cwj;
      if (localObject != null) {
        ((PAGView)localObject).setProgress(0.0D);
      }
      localObject = this.Cwj;
      if (localObject != null) {
        ((PAGView)localObject).play();
      }
      localObject = this.Cwj;
      if (localObject != null) {
        ((PAGView)localObject).flush();
      }
      localObject = this.Cwj;
      if (localObject != null) {
        ((PAGView)localObject).addListener((PAGView.PAGViewListener)new b(this));
      }
      AppMethodBeat.o(352591);
      return;
      k.a(k.Doi, q.af.DxX);
    }
  }
  
  public final void eht()
  {
    AppMethodBeat.i(352597);
    Log.i("FinderLiveAllowanceGiftBubbleViewCallback", "#hideBubbleView");
    this.Cwh.invoke(Integer.valueOf(8));
    AppMethodBeat.o(352597);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftBubbleViewCallback$showBubbleView$1", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "p0", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements PAGView.PAGViewListener
  {
    b(c paramc) {}
    
    public final void onAnimationCancel(PAGView paramPAGView) {}
    
    public final void onAnimationEnd(PAGView paramPAGView)
    {
      AppMethodBeat.i(353339);
      paramPAGView = this.Cwl.Cwj;
      if (paramPAGView != null) {
        paramPAGView.stop();
      }
      paramPAGView = this.Cwl.Cwj;
      if (paramPAGView != null) {
        paramPAGView.setFile(PAGFile.Load(c.a(this.Cwl).getAssets(), "finder_live_allowance_gift_bubble_icon_2.pag"));
      }
      paramPAGView = this.Cwl.Cwj;
      if (paramPAGView != null) {
        paramPAGView.setRepeatCount(0);
      }
      paramPAGView = this.Cwl.Cwj;
      if (paramPAGView != null) {
        paramPAGView.setProgress(0.0D);
      }
      paramPAGView = this.Cwl.Cwj;
      if (paramPAGView != null) {
        paramPAGView.play();
      }
      paramPAGView = this.Cwl.Cwj;
      if (paramPAGView != null) {
        paramPAGView.flush();
      }
      paramPAGView = this.Cwl.Cwj;
      if (paramPAGView != null) {
        paramPAGView.removeListener((PAGView.PAGViewListener)this);
      }
      AppMethodBeat.o(353339);
    }
    
    public final void onAnimationRepeat(PAGView paramPAGView) {}
    
    public final void onAnimationStart(PAGView paramPAGView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.c
 * JD-Core Version:    0.7.0.1
 */