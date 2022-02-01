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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "detachFinish", "Lkotlin/Function0;", "", "getDetachFinish", "()Lkotlin/jvm/functions/Function0;", "setDetachFinish", "(Lkotlin/jvm/functions/Function0;)V", "withEnterAnim", "", "getWithEnterAnim", "()Z", "setWithEnterAnim", "(Z)V", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnimation", "Companion", "plugin-finder_release"})
public final class FinderWhatsNewView
  extends FrameLayout
{
  public static final FinderWhatsNewView.a wtK;
  private kotlin.g.a.a<x> wtI;
  private boolean wtJ;
  
  static
  {
    AppMethodBeat.i(168565);
    wtK = new FinderWhatsNewView.a((byte)0);
    AppMethodBeat.o(168565);
  }
  
  public FinderWhatsNewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168563);
    setId(2131301507);
    paramContext = a.wtG;
    paramContext = a.wtG;
    LayoutInflater.from(getContext()).inflate(2131494676, (ViewGroup)this, true);
    this.wtI = ((kotlin.g.a.a)FinderWhatsNewView.b.wtL);
    AppMethodBeat.o(168563);
  }
  
  public FinderWhatsNewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168564);
    setId(2131301507);
    paramContext = a.wtG;
    paramContext = a.wtG;
    LayoutInflater.from(getContext()).inflate(2131494676, (ViewGroup)this, true);
    this.wtI = ((kotlin.g.a.a)FinderWhatsNewView.b.wtL);
    AppMethodBeat.o(168564);
  }
  
  public final kotlin.g.a.a<x> getDetachFinish()
  {
    return this.wtI;
  }
  
  public final boolean getWithEnterAnim()
  {
    return this.wtJ;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(168562);
    super.onAttachedToWindow();
    Button localButton = (Button)findViewById(2131300133);
    Object localObject = a.wtG;
    localObject = a.wtG;
    p.g(localButton, "it");
    localObject = getContext();
    p.g(localObject, "context");
    localButton.setText((CharSequence)((Context)localObject).getResources().getString(2131760678));
    localButton.setOnClickListener((View.OnClickListener)new c(this));
    post((Runnable)new FinderWhatsNewView.d(this));
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
    p.h(parama, "<set-?>");
    this.wtI = parama;
    AppMethodBeat.o(168561);
  }
  
  public final void setWithEnterAnim(boolean paramBoolean)
  {
    this.wtJ = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderWhatsNewView paramFinderWhatsNewView) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(168557);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.wtM.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(255313);
          paramAnonymousAnimator = this.wtN.wtM.getParent();
          if (paramAnonymousAnimator == null)
          {
            paramAnonymousAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(255313);
            throw paramAnonymousAnimator;
          }
          ((ViewGroup)paramAnonymousAnimator).removeView(paramView);
          this.wtN.wtM.getDetachFinish().invoke();
          AppMethodBeat.o(255313);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168557);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$startAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(255314);
      this.wtM.setTranslationX(0.0F);
      AppMethodBeat.o(255314);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.whatnews.FinderWhatsNewView
 * JD-Core Version:    0.7.0.1
 */