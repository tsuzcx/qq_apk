package com.tencent.mm.plugin.hld.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeScrollBarView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "contentLayoutAnim", "Landroid/animation/ObjectAnimator;", "scrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getFadeAnimation", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeScrollBarView
  extends View
{
  public static final ImeScrollBarView.a JzS;
  private ObjectAnimator JzT;
  private final RecyclerView.l JzU;
  
  static
  {
    AppMethodBeat.i(312600);
    JzS = new ImeScrollBarView.a((byte)0);
    AppMethodBeat.o(312600);
  }
  
  public ImeScrollBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeScrollBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeScrollBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(312576);
    this.JzU = ((RecyclerView.l)new c(this));
    AppMethodBeat.o(312576);
  }
  
  private final ObjectAnimator getFadeAnimation()
  {
    AppMethodBeat.i(312584);
    if (this.JzT == null)
    {
      this.JzT = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator = this.JzT;
      s.checkNotNull(localObjectAnimator);
      localObjectAnimator.setStartDelay(300L);
      localObjectAnimator = this.JzT;
      s.checkNotNull(localObjectAnimator);
      localObjectAnimator.setDuration(250L);
      localObjectAnimator = this.JzT;
      s.checkNotNull(localObjectAnimator);
      localObjectAnimator.addListener((Animator.AnimatorListener)new b(this));
    }
    ObjectAnimator localObjectAnimator = this.JzT;
    s.checkNotNull(localObjectAnimator);
    AppMethodBeat.o(312584);
    return localObjectAnimator;
  }
  
  public final RecyclerView.l getScrollListener()
  {
    return this.JzU;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/view/ImeScrollBarView$getFadeAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "isCancel", "", "()Z", "setCancel", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    private boolean nzW;
    
    b(ImeScrollBarView paramImeScrollBarView) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(312610);
      Log.d("WxIme.ImeScrollBarView", "onAnimationCancel");
      this.JzV.setVisibility(0);
      this.JzV.setAlpha(1.0F);
      this.nzW = true;
      AppMethodBeat.o(312610);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(312603);
      Log.d("WxIme.ImeScrollBarView", "onAnimationEnd");
      if (!this.nzW)
      {
        this.JzV.setVisibility(8);
        this.JzV.setAlpha(1.0F);
        AppMethodBeat.o(312603);
        return;
      }
      this.nzW = false;
      AppMethodBeat.o(312603);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(312594);
      Log.d("WxIme.ImeScrollBarView", "onAnimationStart");
      this.JzV.setVisibility(0);
      this.JzV.setAlpha(1.0F);
      AppMethodBeat.o(312594);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/view/ImeScrollBarView$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    c(ImeScrollBarView paramImeScrollBarView) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(312631);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      a.c("com/tencent/mm/plugin/hld/view/ImeScrollBarView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      paramRecyclerView = new StringBuilder("onScrollStateChanged stop:");
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        Log.d("WxIme.ImeScrollBarView", bool + " running:" + ImeScrollBarView.a(this.JzV).isRunning());
        if (paramInt != 0) {
          break label139;
        }
        ImeScrollBarView.a(this.JzV).start();
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/hld/view/ImeScrollBarView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(312631);
        return;
        bool = false;
        break;
        label139:
        if (ImeScrollBarView.a(this.JzV).isRunning())
        {
          ImeScrollBarView.a(this.JzV).cancel();
        }
        else
        {
          this.JzV.setVisibility(0);
          this.JzV.setAlpha(1.0F);
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(312620);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      a.c("com/tencent/mm/plugin/hld/view/ImeScrollBarView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramInt1 = paramRecyclerView.computeVerticalScrollRange();
      paramInt2 = paramRecyclerView.computeVerticalScrollExtent();
      int i = paramRecyclerView.computeVerticalScrollOffset();
      int j = this.JzV.getHeight();
      this.JzV.setY((paramInt2 - j) * 1.0F / (paramInt1 - paramInt2) * i);
      a.a(this, "com/tencent/mm/plugin/hld/view/ImeScrollBarView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(312620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeScrollBarView
 * JD-Core Version:    0.7.0.1
 */