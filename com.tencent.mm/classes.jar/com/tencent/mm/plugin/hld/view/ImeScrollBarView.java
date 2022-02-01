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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeScrollBarView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "contentLayoutAnim", "Landroid/animation/ObjectAnimator;", "scrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getFadeAnimation", "Companion", "plugin-hld_release"})
public final class ImeScrollBarView
  extends View
{
  public static final a DIS;
  private ObjectAnimator DIQ;
  private final RecyclerView.l DIR;
  
  static
  {
    AppMethodBeat.i(211356);
    DIS = new a((byte)0);
    AppMethodBeat.o(211356);
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
    AppMethodBeat.i(211355);
    this.DIR = ((RecyclerView.l)new c(this));
    AppMethodBeat.o(211355);
  }
  
  private final ObjectAnimator getFadeAnimation()
  {
    AppMethodBeat.i(211353);
    if (this.DIQ == null)
    {
      this.DIQ = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator = this.DIQ;
      if (localObjectAnimator == null) {
        p.iCn();
      }
      localObjectAnimator.setStartDelay(300L);
      localObjectAnimator = this.DIQ;
      if (localObjectAnimator == null) {
        p.iCn();
      }
      localObjectAnimator.setDuration(250L);
      localObjectAnimator = this.DIQ;
      if (localObjectAnimator == null) {
        p.iCn();
      }
      localObjectAnimator.addListener((Animator.AnimatorListener)new b(this));
    }
    ObjectAnimator localObjectAnimator = this.DIQ;
    if (localObjectAnimator == null) {
      p.iCn();
    }
    AppMethodBeat.o(211353);
    return localObjectAnimator;
  }
  
  public final RecyclerView.l getScrollListener()
  {
    return this.DIR;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeScrollBarView$Companion;", "", "()V", "SCROLL_BAR_DEFAULT_DELAY", "", "SCROLL_BAR_FADE_DURATION", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/view/ImeScrollBarView$getFadeAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "isCancel", "", "()Z", "setCancel", "(Z)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-hld_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    private boolean kUn;
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(210573);
      Log.d("WxIme.ImeScrollBarView", "onAnimationCancel");
      this.DIT.setVisibility(0);
      this.DIT.setAlpha(1.0F);
      this.kUn = true;
      AppMethodBeat.o(210573);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(210572);
      Log.d("WxIme.ImeScrollBarView", "onAnimationEnd");
      if (!this.kUn)
      {
        this.DIT.setVisibility(8);
        this.DIT.setAlpha(1.0F);
        AppMethodBeat.o(210572);
        return;
      }
      this.kUn = false;
      AppMethodBeat.o(210572);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(210571);
      Log.d("WxIme.ImeScrollBarView", "onAnimationStart");
      this.DIT.setVisibility(0);
      this.DIT.setAlpha(1.0F);
      AppMethodBeat.o(210571);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/view/ImeScrollBarView$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-hld_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(209488);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      a.c("com/tencent/mm/plugin/hld/view/ImeScrollBarView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      paramRecyclerView = new StringBuilder("onScrollStateChanged stop:");
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        Log.d("WxIme.ImeScrollBarView", bool + " running:" + ImeScrollBarView.a(this.DIT).isRunning());
        if (paramInt != 0) {
          break label139;
        }
        ImeScrollBarView.a(this.DIT).start();
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/hld/view/ImeScrollBarView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(209488);
        return;
        bool = false;
        break;
        label139:
        if (ImeScrollBarView.a(this.DIT).isRunning())
        {
          ImeScrollBarView.a(this.DIT).cancel();
        }
        else
        {
          this.DIT.setVisibility(0);
          this.DIT.setAlpha(1.0F);
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209486);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      a.c("com/tencent/mm/plugin/hld/view/ImeScrollBarView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramInt1 = paramRecyclerView.computeVerticalScrollRange();
      paramInt2 = paramRecyclerView.computeVerticalScrollExtent();
      int i = paramRecyclerView.computeVerticalScrollOffset();
      int j = this.DIT.getHeight();
      this.DIT.setY((paramInt2 - j) * 1.0F / (paramInt1 - paramInt2) * i);
      a.a(this, "com/tencent/mm/plugin/hld/view/ImeScrollBarView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(209486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeScrollBarView
 * JD-Core Version:    0.7.0.1
 */