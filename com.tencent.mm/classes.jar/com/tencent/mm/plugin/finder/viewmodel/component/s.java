package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "currentShowingView", "Landroid/view/View;", "isAttached", "", "isForeground", "lifecycleObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tabType", "", "targetAnimMinWidth", "videoFinishListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$videoFinishListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$videoFinishListener$1;", "attach", "", "rv", "getCurrentColor", "fraction", "", "startColor", "endColor", "startAppearAnim", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "startDisappearAnim", "Companion", "plugin-finder_release"})
public final class s
  extends UIComponent
{
  public static final s.a BjX;
  private View BjT;
  private int BjU;
  private final s.d BjV;
  private final FinderFeedMegaVideoBtnAnimUIC.lifecycleObserver.1 BjW;
  private final ValueAnimator animator;
  private boolean dgo;
  private int fEH;
  private RecyclerView jLl;
  private boolean ljV;
  
  static
  {
    AppMethodBeat.i(265878);
    BjX = new s.a((byte)0);
    AppMethodBeat.o(265878);
  }
  
  public s(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(265876);
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.j(paramAppCompatActivity, "it");
    paramAppCompatActivity.setDuration(300L);
    paramAppCompatActivity.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.animator = paramAppCompatActivity;
    this.dgo = true;
    this.BjV = new s.d(this);
    this.BjW = new FinderFeedMegaVideoBtnAnimUIC.lifecycleObserver.1(this);
    AppMethodBeat.o(265876);
  }
  
  public s(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(265877);
    paramFragment = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.j(paramFragment, "it");
    paramFragment.setDuration(300L);
    paramFragment.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.animator = paramFragment;
    this.dgo = true;
    this.BjV = new s.d(this);
    this.BjW = new FinderFeedMegaVideoBtnAnimUIC.lifecycleObserver.1(this);
    AppMethodBeat.o(265877);
  }
  
  public final void u(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(265875);
    p.k(paramRecyclerView, "rv");
    this.jLl = paramRecyclerView;
    if (!this.ljV) {
      this.BjV.alive();
    }
    this.ljV = true;
    getActivity().getLifecycle().a((k)this.BjW);
    AppMethodBeat.o(265875);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(s params, i parami)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$3"})
    static final class b
      implements ValueAnimator.AnimatorUpdateListener
    {
      b(View paramView1, View paramView2, int paramInt1, int paramInt2, s.b paramb) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(281293);
        p.j(paramValueAnimator, "anim");
        float f1 = paramValueAnimator.getAnimatedFraction();
        float f2 = s.c(this.BjZ.BjY);
        float f3 = this.kJS.getWidth() - s.c(this.BjZ.BjY);
        paramValueAnimator = this.Bka;
        p.j(paramValueAnimator, "bgView");
        paramValueAnimator.getLayoutParams().width = ((int)(f2 + f3 * f1));
        this.Bka.requestLayout();
        this.Bka.setBackgroundColor(s.e(f1, this.Bkb, this.Bkc));
        if (f1 > 0.5F)
        {
          paramValueAnimator = this.kJS.findViewById(b.f.long_video_tips);
          p.j(paramValueAnimator, "it.findViewById<TextView>(R.id.long_video_tips)");
          ((TextView)paramValueAnimator).setAlpha((f1 - 0.5F) * 2.0F);
        }
        AppMethodBeat.o(281293);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$5"})
    static final class c
      extends q
      implements a<x>
    {
      c(s.b paramb)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(s params)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startDisappearAnim$1$2$1"})
    static final class a
      implements ValueAnimator.AnimatorUpdateListener
    {
      a(View paramView1, View paramView2, int paramInt1, int paramInt2, s.c paramc) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(286004);
        p.j(paramValueAnimator, "anim");
        float f1 = paramValueAnimator.getAnimatedFraction();
        float f2 = this.kJS.getWidth();
        float f3 = this.kJS.getWidth() - s.c(this.Bkd.BjY);
        paramValueAnimator = this.Bka;
        p.j(paramValueAnimator, "bgView");
        paramValueAnimator.getLayoutParams().width = ((int)(f2 - f3 * f1));
        this.Bka.requestLayout();
        this.Bka.setBackgroundColor(s.e(f1, this.Bkb, this.Bkc));
        if (f1 >= 1.0F) {
          this.kJS.setVisibility(8);
        }
        AppMethodBeat.o(286004);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.s
 * JD-Core Version:    0.7.0.1
 */