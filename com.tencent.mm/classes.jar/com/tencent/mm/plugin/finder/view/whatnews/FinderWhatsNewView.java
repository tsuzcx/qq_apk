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
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "detachFinish", "Lkotlin/Function0;", "", "getDetachFinish", "()Lkotlin/jvm/functions/Function0;", "setDetachFinish", "(Lkotlin/jvm/functions/Function0;)V", "withEnterAnim", "", "getWithEnterAnim", "()Z", "setWithEnterAnim", "(Z)V", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnimation", "Companion", "plugin-finder_release"})
public final class FinderWhatsNewView
  extends FrameLayout
{
  public static final FinderWhatsNewView.a sYU;
  private d.g.a.a<z> sYS;
  private boolean sYT;
  
  static
  {
    AppMethodBeat.i(168565);
    sYU = new FinderWhatsNewView.a((byte)0);
    AppMethodBeat.o(168565);
  }
  
  public FinderWhatsNewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168563);
    setId(2131300080);
    paramContext = a.sYQ;
    paramContext = a.sYQ;
    LayoutInflater.from(getContext()).inflate(2131494127, (ViewGroup)this, true);
    this.sYS = ((d.g.a.a)FinderWhatsNewView.b.sYV);
    AppMethodBeat.o(168563);
  }
  
  public FinderWhatsNewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168564);
    setId(2131300080);
    paramContext = a.sYQ;
    paramContext = a.sYQ;
    LayoutInflater.from(getContext()).inflate(2131494127, (ViewGroup)this, true);
    this.sYS = ((d.g.a.a)FinderWhatsNewView.b.sYV);
    AppMethodBeat.o(168564);
  }
  
  public final d.g.a.a<z> getDetachFinish()
  {
    return this.sYS;
  }
  
  public final boolean getWithEnterAnim()
  {
    return this.sYT;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(168562);
    super.onAttachedToWindow();
    Button localButton = (Button)findViewById(2131299497);
    Object localObject = a.sYQ;
    localObject = a.sYQ;
    p.g(localButton, "it");
    localObject = getContext();
    p.g(localObject, "context");
    localButton.setText((CharSequence)((Context)localObject).getResources().getString(2131759395));
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
  
  public final void setDetachFinish(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(168561);
    p.h(parama, "<set-?>");
    this.sYS = parama;
    AppMethodBeat.o(168561);
  }
  
  public final void setWithEnterAnim(boolean paramBoolean)
  {
    this.sYT = paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderWhatsNewView paramFinderWhatsNewView) {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(168557);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sYW.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(221576);
          paramAnonymousAnimator = this.sYX.sYW.getParent();
          if (paramAnonymousAnimator == null)
          {
            paramAnonymousAnimator = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(221576);
            throw paramAnonymousAnimator;
          }
          ((ViewGroup)paramAnonymousAnimator).removeView(paramView);
          this.sYX.sYW.getDetachFinish().invoke();
          AppMethodBeat.o(221576);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168557);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderWhatsNewView paramFinderWhatsNewView) {}
    
    public final void run()
    {
      AppMethodBeat.i(168558);
      Object localObject = a.sYQ;
      localObject = com.tencent.mm.kernel.g.ajC();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).ajl().set(al.a.IHP, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.g.yhR.n(1305L, 0L, 1L);
      FinderWhatsNewView.a(this.sYW);
      AppMethodBeat.o(168558);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$startAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221577);
      this.sYW.setTranslationX(0.0F);
      AppMethodBeat.o(221577);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.whatnews.FinderWhatsNewView
 * JD-Core Version:    0.7.0.1
 */