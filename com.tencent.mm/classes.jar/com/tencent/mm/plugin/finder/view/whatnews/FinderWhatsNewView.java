package com.tencent.mm.plugin.finder.view.whatnews;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "detachFinish", "Lkotlin/Function0;", "", "getDetachFinish", "()Lkotlin/jvm/functions/Function0;", "setDetachFinish", "(Lkotlin/jvm/functions/Function0;)V", "withEnterAnim", "", "getWithEnterAnim", "()Z", "setWithEnterAnim", "(Z)V", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnimation", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderWhatsNewView
  extends FrameLayout
{
  public static final FinderWhatsNewView.a GJO;
  private kotlin.g.a.a<ah> GJP;
  private boolean GJQ;
  
  static
  {
    AppMethodBeat.i(168565);
    GJO = new FinderWhatsNewView.a((byte)0);
    AppMethodBeat.o(168565);
  }
  
  public FinderWhatsNewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168563);
    setId(e.e.finder_whats_new_view);
    paramContext = a.GJL;
    if (a.TY() != 1)
    {
      paramContext = a.GJL;
      if (a.TY() != 3) {
        break label81;
      }
    }
    label81:
    for (int i = e.f.finder_whats_new_layout;; i = e.f.finder_whats_new_layout2)
    {
      LayoutInflater.from(getContext()).inflate(i, (ViewGroup)this, true);
      this.GJP = ((kotlin.g.a.a)FinderWhatsNewView.b.GJR);
      AppMethodBeat.o(168563);
      return;
    }
  }
  
  public FinderWhatsNewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168564);
    setId(e.e.finder_whats_new_view);
    paramContext = a.GJL;
    if (a.TY() != 1)
    {
      paramContext = a.GJL;
      if (a.TY() != 3) {
        break label82;
      }
    }
    label82:
    for (paramInt = e.f.finder_whats_new_layout;; paramInt = e.f.finder_whats_new_layout2)
    {
      LayoutInflater.from(getContext()).inflate(paramInt, (ViewGroup)this, true);
      this.GJP = ((kotlin.g.a.a)FinderWhatsNewView.b.GJR);
      AppMethodBeat.o(168564);
      return;
    }
  }
  
  private static final void a(FinderWhatsNewView paramFinderWhatsNewView)
  {
    AppMethodBeat.i(345703);
    s.u(paramFinderWhatsNewView, "this$0");
    a locala = a.GJL;
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adcG, Boolean.TRUE);
    com.tencent.mm.plugin.report.service.h.OAn.p(1305L, 0L, 1L);
    switch (a.TY())
    {
    }
    for (;;)
    {
      if (paramFinderWhatsNewView.GJQ)
      {
        paramFinderWhatsNewView.setTranslationX(paramFinderWhatsNewView.getHeight());
        paramFinderWhatsNewView.animate().translationY(0.0F).setDuration(200L).setListener((Animator.AnimatorListener)new d(paramFinderWhatsNewView)).start();
      }
      AppMethodBeat.o(345703);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(1305L, 1L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(1305L, 2L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(1305L, 3L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(1305L, 4L, 1L);
    }
  }
  
  private static final void a(FinderWhatsNewView paramFinderWhatsNewView, final View paramView)
  {
    AppMethodBeat.i(345696);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderWhatsNewView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderWhatsNewView, "this$0");
    paramFinderWhatsNewView.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new c(paramFinderWhatsNewView, paramView)).start();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(345696);
  }
  
  public final kotlin.g.a.a<ah> getDetachFinish()
  {
    return this.GJP;
  }
  
  public final boolean getWithEnterAnim()
  {
    return this.GJQ;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(168562);
    super.onAttachedToWindow();
    Button localButton = (Button)findViewById(e.e.enter_btn);
    a locala = a.GJL;
    if (a.TY() != 1)
    {
      locala = a.GJL;
      if (a.TY() != 2) {}
    }
    else
    {
      localButton.setText((CharSequence)getContext().getResources().getString(e.h.finder_whats_new_enter_finder));
    }
    for (;;)
    {
      localButton.setOnClickListener(new FinderWhatsNewView..ExternalSyntheticLambda0(this));
      post(new FinderWhatsNewView..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(168562);
      return;
      localButton.setText((CharSequence)getContext().getResources().getString(e.h.finder_whats_new_enter));
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168560);
    super.onMeasure(paramInt1, paramInt2);
    requestLayout();
    AppMethodBeat.o(168560);
  }
  
  public final void setDetachFinish(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(168561);
    s.u(parama, "<set-?>");
    this.GJP = parama;
    AppMethodBeat.o(168561);
  }
  
  public final void setWithEnterAnim(boolean paramBoolean)
  {
    this.GJQ = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$1$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(FinderWhatsNewView paramFinderWhatsNewView, View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(345698);
      paramAnimator = this.GJS.getParent();
      if (paramAnimator == null)
      {
        paramAnimator = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(345698);
        throw paramAnimator;
      }
      ((ViewGroup)paramAnimator).removeView(paramView);
      this.GJS.getDetachFinish().invoke();
      AppMethodBeat.o(345698);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$startAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(FinderWhatsNewView paramFinderWhatsNewView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(345699);
      this.GJS.setTranslationX(0.0F);
      AppMethodBeat.o(345699);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.whatnews.FinderWhatsNewView
 * JD-Core Version:    0.7.0.1
 */