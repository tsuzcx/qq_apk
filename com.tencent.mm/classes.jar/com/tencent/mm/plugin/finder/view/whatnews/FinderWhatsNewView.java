package com.tencent.mm.plugin.finder.view.whatnews;

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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "detachFinish", "Lkotlin/Function0;", "", "getDetachFinish", "()Lkotlin/jvm/functions/Function0;", "setDetachFinish", "(Lkotlin/jvm/functions/Function0;)V", "withEnterAnim", "", "getWithEnterAnim", "()Z", "setWithEnterAnim", "(Z)V", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnimation", "Companion", "plugin-finder_release"})
public final class FinderWhatsNewView
  extends FrameLayout
{
  public static final a qZB;
  private boolean qZA;
  private d.g.a.a<y> qZz;
  
  static
  {
    AppMethodBeat.i(168565);
    qZB = new a((byte)0);
    AppMethodBeat.o(168565);
  }
  
  public FinderWhatsNewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168563);
    setId(2131300080);
    paramContext = a.qZx;
    paramContext = a.qZx;
    LayoutInflater.from(getContext()).inflate(2131494127, (ViewGroup)this, true);
    this.qZz = ((d.g.a.a)FinderWhatsNewView.b.qZC);
    AppMethodBeat.o(168563);
  }
  
  public FinderWhatsNewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168564);
    setId(2131300080);
    paramContext = a.qZx;
    paramContext = a.qZx;
    LayoutInflater.from(getContext()).inflate(2131494127, (ViewGroup)this, true);
    this.qZz = ((d.g.a.a)FinderWhatsNewView.b.qZC);
    AppMethodBeat.o(168564);
  }
  
  public final d.g.a.a<y> getDetachFinish()
  {
    return this.qZz;
  }
  
  public final boolean getWithEnterAnim()
  {
    return this.qZA;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(168562);
    super.onAttachedToWindow();
    Button localButton = (Button)findViewById(2131299497);
    Object localObject = a.qZx;
    localObject = a.qZx;
    k.g(localButton, "it");
    localObject = getContext();
    k.g(localObject, "context");
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
  
  public final void setDetachFinish(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(168561);
    k.h(parama, "<set-?>");
    this.qZz = parama;
    AppMethodBeat.o(168561);
  }
  
  public final void setWithEnterAnim(boolean paramBoolean)
  {
    this.qZA = paramBoolean;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$Companion;", "", "()V", "attachToWindow", "Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "window", "Landroid/view/Window;", "withEnterAnim", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView$onAttachedToWindow$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderWhatsNewView paramFinderWhatsNewView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168557);
      this.qZD.animate().alpha(0.0F).setDuration(300L).withEndAction((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(168556);
          Object localObject = this.qZE.qZD.getParent();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(168556);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView((View)this.qZE.qZD);
          this.qZE.qZD.getDetachFinish().invoke();
          AppMethodBeat.o(168556);
        }
      }).start();
      AppMethodBeat.o(168557);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderWhatsNewView paramFinderWhatsNewView) {}
    
    public final void run()
    {
      AppMethodBeat.i(168558);
      Object localObject = a.qZx;
      localObject = g.afB();
      k.g(localObject, "MMKernel.storage()");
      ((e)localObject).afk().set(ae.a.FwR, Boolean.TRUE);
      h.vKh.m(1305L, 0L, 1L);
      FinderWhatsNewView.a(this.qZD);
      AppMethodBeat.o(168558);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(FinderWhatsNewView paramFinderWhatsNewView) {}
    
    public final void run()
    {
      AppMethodBeat.i(168559);
      this.qZD.setTranslationX(0.0F);
      AppMethodBeat.o(168559);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.whatnews.FinderWhatsNewView
 * JD-Core Version:    0.7.0.1
 */