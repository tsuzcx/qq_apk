package com.tencent.mm.plugin.finder.view.whatnews;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "detachFinish", "Lkotlin/Function0;", "", "getDetachFinish", "()Lkotlin/jvm/functions/Function0;", "setDetachFinish", "(Lkotlin/jvm/functions/Function0;)V", "withEnterAnim", "", "getWithEnterAnim", "()Z", "setWithEnterAnim", "(Z)V", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnimation", "Companion", "plugin-finder_release"})
public final class FinderWhatsNewView
  extends FrameLayout
{
  public static final a Bgb;
  private kotlin.g.a.a<x> BfZ;
  private boolean Bga;
  
  static
  {
    AppMethodBeat.i(168565);
    Bgb = new a((byte)0);
    AppMethodBeat.o(168565);
  }
  
  public FinderWhatsNewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168563);
    setId(b.f.finder_whats_new_view);
    paramContext = a.BfX;
    paramContext = a.BfX;
    int i = b.g.finder_whats_new_layout2;
    LayoutInflater.from(getContext()).inflate(i, (ViewGroup)this, true);
    this.BfZ = ((kotlin.g.a.a)FinderWhatsNewView.b.Bgc);
    AppMethodBeat.o(168563);
  }
  
  public FinderWhatsNewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168564);
    setId(b.f.finder_whats_new_view);
    paramContext = a.BfX;
    paramContext = a.BfX;
    paramInt = b.g.finder_whats_new_layout2;
    LayoutInflater.from(getContext()).inflate(paramInt, (ViewGroup)this, true);
    this.BfZ = ((kotlin.g.a.a)FinderWhatsNewView.b.Bgc);
    AppMethodBeat.o(168564);
  }
  
  public final kotlin.g.a.a<x> getDetachFinish()
  {
    return this.BfZ;
  }
  
  public final boolean getWithEnterAnim()
  {
    return this.Bga;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(168562);
    super.onAttachedToWindow();
    Button localButton = (Button)findViewById(b.f.enter_btn);
    Object localObject = a.BfX;
    localObject = a.BfX;
    p.j(localButton, "it");
    localObject = getContext();
    p.j(localObject, "context");
    localButton.setText((CharSequence)((Context)localObject).getResources().getString(b.j.finder_whats_new_enter));
    localButton.setOnClickListener((View.OnClickListener)new c(this));
    post((Runnable)new d(this));
    AppMethodBeat.o(168562);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168560);
    super.onMeasure(paramInt1, paramInt2);
    requestLayout();
    AppMethodBeat.o(168560);
  }
  
  public final void setDetachFinish(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(168561);
    p.k(parama, "<set-?>");
    this.BfZ = parama;
    AppMethodBeat.o(168561);
  }
  
  public final void setWithEnterAnim(boolean paramBoolean)
  {
    this.Bga = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$Companion;", "", "()V", "attachToWindow", "Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "window", "Landroid/view/Window;", "withEnterAnim", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderWhatsNewView paramFinderWhatsNewView) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(168557);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Bgd.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(224749);
          paramAnonymousAnimator = this.Bge.Bgd.getParent();
          if (paramAnonymousAnimator == null)
          {
            paramAnonymousAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(224749);
            throw paramAnonymousAnimator;
          }
          ((ViewGroup)paramAnonymousAnimator).removeView(paramView);
          this.Bge.Bgd.getDetachFinish().invoke();
          AppMethodBeat.o(224749);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168557);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderWhatsNewView paramFinderWhatsNewView) {}
    
    public final void run()
    {
      AppMethodBeat.i(168558);
      Object localObject = a.BfX;
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((f)localObject).aHp().set(ar.a.VAp, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.IzE.p(1305L, 0L, 1L);
      FinderWhatsNewView.a(this.Bgd);
      AppMethodBeat.o(168558);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$startAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(280995);
      this.Bgd.setTranslationX(0.0F);
      AppMethodBeat.o(280995);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.whatnews.FinderWhatsNewView
 * JD-Core Version:    0.7.0.1
 */