package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "currentShowingView", "Landroid/view/View;", "isAttached", "", "isForeground", "lifecycleObserver", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "tabType", "", "targetAnimMinWidth", "videoFinishListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$videoFinishListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$videoFinishListener$1;", "attach", "", "rv", "getCurrentColor", "fraction", "", "startColor", "endColor", "startAppearAnim", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "startDisappearAnim", "Companion", "plugin-finder_release"})
public final class FinderFeedMegaVideoBtnAnimUIC
  extends UIComponent
{
  public static final a wwf;
  private final ValueAnimator animator;
  private boolean cQp;
  private int dLS;
  private RecyclerView hak;
  private boolean iuM;
  private View wwb;
  private int wwc;
  private final d wwd;
  private final lifecycleObserver.1 wwe;
  
  static
  {
    AppMethodBeat.i(255512);
    wwf = new a((byte)0);
    AppMethodBeat.o(255512);
  }
  
  public FinderFeedMegaVideoBtnAnimUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255511);
    paramFragment = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramFragment, "it");
    paramFragment.setDuration(300L);
    paramFragment.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.animator = paramFragment;
    this.cQp = true;
    this.wwd = new d(this);
    this.wwe = new LifecycleObserver()
    {
      @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
      public final void onDestroy()
      {
        AppMethodBeat.i(255500);
        FinderFeedMegaVideoBtnAnimUIC.h(this.wwg).dead();
        this.wwg.getActivity().getLifecycle().removeObserver((LifecycleObserver)this);
        AppMethodBeat.o(255500);
      }
      
      @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
      public final void onPause()
      {
        AppMethodBeat.i(255499);
        FinderFeedMegaVideoBtnAnimUIC.h(this.wwg).dead();
        FinderFeedMegaVideoBtnAnimUIC.a(this.wwg, false);
        AppMethodBeat.o(255499);
      }
      
      @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
      public final void onResume()
      {
        AppMethodBeat.i(255498);
        FinderFeedMegaVideoBtnAnimUIC.h(this.wwg).alive();
        FinderFeedMegaVideoBtnAnimUIC.a(this.wwg, true);
        AppMethodBeat.o(255498);
      }
    };
    AppMethodBeat.o(255511);
  }
  
  public FinderFeedMegaVideoBtnAnimUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255510);
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramAppCompatActivity, "it");
    paramAppCompatActivity.setDuration(300L);
    paramAppCompatActivity.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.animator = paramAppCompatActivity;
    this.cQp = true;
    this.wwd = new d(this);
    this.wwe = new LifecycleObserver()
    {
      @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
      public final void onDestroy()
      {
        AppMethodBeat.i(255500);
        FinderFeedMegaVideoBtnAnimUIC.h(this.wwg).dead();
        this.wwg.getActivity().getLifecycle().removeObserver((LifecycleObserver)this);
        AppMethodBeat.o(255500);
      }
      
      @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
      public final void onPause()
      {
        AppMethodBeat.i(255499);
        FinderFeedMegaVideoBtnAnimUIC.h(this.wwg).dead();
        FinderFeedMegaVideoBtnAnimUIC.a(this.wwg, false);
        AppMethodBeat.o(255499);
      }
      
      @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
      public final void onResume()
      {
        AppMethodBeat.i(255498);
        FinderFeedMegaVideoBtnAnimUIC.h(this.wwg).alive();
        FinderFeedMegaVideoBtnAnimUIC.a(this.wwg, true);
        AppMethodBeat.o(255498);
      }
    };
    AppMethodBeat.o(255510);
  }
  
  public final void t(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(255509);
    p.h(paramRecyclerView, "rv");
    this.hak = paramRecyclerView;
    if (!this.iuM) {
      this.wwd.alive();
    }
    this.iuM = true;
    getActivity().getLifecycle().addObserver((LifecycleObserver)this.wwe);
    AppMethodBeat.o(255509);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(FinderFeedMegaVideoBtnAnimUIC paramFinderFeedMegaVideoBtnAnimUIC, h paramh)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$3"})
    static final class b
      implements ValueAnimator.AnimatorUpdateListener
    {
      b(View paramView1, View paramView2, int paramInt1, int paramInt2, FinderFeedMegaVideoBtnAnimUIC.b paramb) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(255502);
        p.g(paramValueAnimator, "anim");
        float f1 = paramValueAnimator.getAnimatedFraction();
        float f2 = FinderFeedMegaVideoBtnAnimUIC.c(this.wwh.wwg);
        float f3 = this.tzy.getWidth() - FinderFeedMegaVideoBtnAnimUIC.c(this.wwh.wwg);
        paramValueAnimator = this.wwi;
        p.g(paramValueAnimator, "bgView");
        paramValueAnimator.getLayoutParams().width = ((int)(f2 + f3 * f1));
        this.wwi.requestLayout();
        this.wwi.setBackgroundColor(FinderFeedMegaVideoBtnAnimUIC.e(f1, this.wwj, this.wwk));
        if (f1 > 0.5F)
        {
          paramValueAnimator = this.tzy.findViewById(2131303837);
          p.g(paramValueAnimator, "it.findViewById<TextView>(R.id.long_video_tips)");
          ((TextView)paramValueAnimator).setAlpha((f1 - 0.5F) * 2.0F);
        }
        AppMethodBeat.o(255502);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$5"})
    static final class c
      extends q
      implements a<x>
    {
      c(FinderFeedMegaVideoBtnAnimUIC.b paramb)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startAppearAnim$1$2$4", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class d
      extends AnimatorListenerAdapter
    {
      d(View paramView) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        Object localObject1 = null;
        AppMethodBeat.i(255504);
        paramAnimator = new StringBuilder("onAnimationEnd: check bg status, width = ");
        Object localObject2 = this.wwi;
        p.g(localObject2, "bgView");
        StringBuilder localStringBuilder = paramAnimator.append(((View)localObject2).getWidth()).append(", color = ");
        paramAnimator = this.wwi;
        p.g(paramAnimator, "bgView");
        localObject2 = paramAnimator.getBackground();
        paramAnimator = (Animator)localObject2;
        if (!(localObject2 instanceof ColorDrawable)) {
          paramAnimator = null;
        }
        paramAnimator = (ColorDrawable)paramAnimator;
        if (paramAnimator != null) {}
        for (paramAnimator = Integer.toHexString(paramAnimator.getColor());; paramAnimator = localObject1)
        {
          Log.i("FinderFeedMegaVideoBtnAnimUIC", paramAnimator);
          AppMethodBeat.o(255504);
          return;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(FinderFeedMegaVideoBtnAnimUIC paramFinderFeedMegaVideoBtnAnimUIC)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$startDisappearAnim$1$2$1"})
    static final class a
      implements ValueAnimator.AnimatorUpdateListener
    {
      a(View paramView1, View paramView2, int paramInt1, int paramInt2, FinderFeedMegaVideoBtnAnimUIC.c paramc) {}
      
      public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppMethodBeat.i(255506);
        p.g(paramValueAnimator, "anim");
        float f1 = paramValueAnimator.getAnimatedFraction();
        float f2 = this.tzy.getWidth();
        float f3 = this.tzy.getWidth() - FinderFeedMegaVideoBtnAnimUIC.c(this.wwl.wwg);
        paramValueAnimator = this.wwi;
        p.g(paramValueAnimator, "bgView");
        paramValueAnimator.getLayoutParams().width = ((int)(f2 - f3 * f1));
        this.wwi.requestLayout();
        this.wwi.setBackgroundColor(FinderFeedMegaVideoBtnAnimUIC.e(f1, this.wwj, this.wwk));
        if (f1 >= 1.0F) {
          this.tzy.setVisibility(8);
        }
        AppMethodBeat.o(255506);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$videoFinishListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedMegaVideoAnimPlayEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<hj>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC
 * JD-Core Version:    0.7.0.1
 */