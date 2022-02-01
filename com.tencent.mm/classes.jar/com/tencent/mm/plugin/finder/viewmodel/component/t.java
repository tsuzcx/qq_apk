package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.p;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "currentShowingView", "Landroid/view/View;", "isAttached", "", "isForeground", "lifecycleObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tabType", "", "targetAnimMinWidth", "videoFinishListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$videoFinishListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$videoFinishListener$1;", "attach", "", "rv", "getCurrentColor", "fraction", "", "startColor", "endColor", "startAppearAnim", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "startDisappearAnim", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends UIComponent
{
  public static final t.a GPr;
  private View GPs;
  private int GPt;
  private final FinderFeedMegaVideoBtnAnimUIC.videoFinishListener.1 GPu;
  private final FinderFeedMegaVideoBtnAnimUIC.lifecycleObserver.1 GPv;
  private final ValueAnimator animator;
  private boolean ffv;
  private int hJx;
  private RecyclerView mkw;
  private boolean nOG;
  
  static
  {
    AppMethodBeat.i(337786);
    GPr = new t.a((byte)0);
    AppMethodBeat.o(337786);
  }
  
  public t(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337679);
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramAppCompatActivity.setDuration(300L);
    paramAppCompatActivity.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.animator = paramAppCompatActivity;
    this.ffv = true;
    this.GPu = new FinderFeedMegaVideoBtnAnimUIC.videoFinishListener.1(this, f.hfK);
    this.GPv = new FinderFeedMegaVideoBtnAnimUIC.lifecycleObserver.1(this);
    AppMethodBeat.o(337679);
  }
  
  public t(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(337689);
    paramFragment = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramFragment.setDuration(300L);
    paramFragment.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.animator = paramFragment;
    this.ffv = true;
    this.GPu = new FinderFeedMegaVideoBtnAnimUIC.videoFinishListener.1(this, f.hfK);
    this.GPv = new FinderFeedMegaVideoBtnAnimUIC.lifecycleObserver.1(this);
    AppMethodBeat.o(337689);
  }
  
  public final void E(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(337792);
    s.u(paramRecyclerView, "rv");
    this.mkw = paramRecyclerView;
    if (!this.nOG) {
      this.GPu.alive();
    }
    this.nOG = true;
    getActivity().getLifecycle().addObserver((p)this.GPv);
    AppMethodBeat.o(337792);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(com.tencent.mm.view.recyclerview.j paramj, t paramt)
    {
      super();
    }
    
    private static final void a(t paramt, View paramView1, View paramView2, int paramInt1, int paramInt2, ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(337617);
      s.u(paramt, "this$0");
      s.u(paramView1, "$it");
      float f1 = paramValueAnimator.getAnimatedFraction();
      float f2 = t.a(paramt);
      float f3 = paramView1.getWidth() - t.a(paramt);
      paramView2.getLayoutParams().width = ((int)(f2 + f3 * f1));
      paramView2.requestLayout();
      paramView2.setBackgroundColor(t.f(f1, paramInt1, paramInt2));
      if (f1 > 0.5F) {
        ((TextView)paramView1.findViewById(e.e.long_video_tips)).setAlpha((f1 - 0.5F) * 2.0F);
      }
      AppMethodBeat.o(337617);
    }
    
    private static final void k(com.tencent.mm.view.recyclerview.j paramj, View paramView)
    {
      AppMethodBeat.i(337612);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramj);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramj, "$holder");
      paramj.UH(e.e.long_video_button).performClick();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(337612);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(t paramt)
    {
      super();
    }
    
    private static final void a(View paramView1, t paramt, View paramView2, int paramInt1, int paramInt2, ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(337611);
      s.u(paramView1, "$it");
      s.u(paramt, "this$0");
      float f1 = paramValueAnimator.getAnimatedFraction();
      float f2 = paramView1.getWidth();
      float f3 = paramView1.getWidth() - t.a(paramt);
      paramView2.getLayoutParams().width = ((int)(f2 - f3 * f1));
      paramView2.requestLayout();
      paramView2.setBackgroundColor(t.f(f1, paramInt1, paramInt2));
      if (f1 >= 1.0F) {
        paramView1.setVisibility(8);
      }
      AppMethodBeat.o(337611);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.t
 * JD-Core Version:    0.7.0.1
 */