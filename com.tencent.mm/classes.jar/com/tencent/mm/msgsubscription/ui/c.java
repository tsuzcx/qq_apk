package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"getAppropriateLargeScreenRequestDialogWidth", "", "context", "Landroid/content/Context;", "dialogMeasuredWidth", "dp2Px", "dp", "isLargeScreenEnv", "", "onPreDrawOnce", "", "Landroid/view/View;", "block", "Lkotlin/Function0;", "postRequestLayout", "wxbiz-msgsubscription-sdk_release"})
public final class c
{
  static final void a(View paramView, final d.g.a.a<y> parama)
  {
    AppMethodBeat.i(174572);
    ViewTreeObserver localViewTreeObserver = paramView.getViewTreeObserver();
    k.g(localViewTreeObserver, "this.viewTreeObserver");
    if (!localViewTreeObserver.isAlive())
    {
      AppMethodBeat.o(174572);
      return;
    }
    paramView.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a(paramView, parama));
    AppMethodBeat.o(174572);
  }
  
  static final int cP(Context paramContext)
  {
    AppMethodBeat.i(174570);
    paramContext = paramContext.getResources();
    k.g(paramContext, "this.resources");
    int i = d.h.a.cj(paramContext.getDisplayMetrics().density * 375.0F);
    AppMethodBeat.o(174570);
    return i;
  }
  
  static final boolean cQ(Context paramContext)
  {
    AppMethodBeat.i(174571);
    paramContext = paramContext.getResources();
    k.g(paramContext, "this.resources");
    if ((paramContext.getConfiguration().screenLayout & 0xF) >= 3)
    {
      AppMethodBeat.o(174571);
      return true;
    }
    AppMethodBeat.o(174571);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialogKt$onPreDrawOnce$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a(View paramView, d.g.a.a parama) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(174568);
      ViewTreeObserver localViewTreeObserver = this.ikv.getViewTreeObserver();
      k.g(localViewTreeObserver, "this@onPreDrawOnce.viewTreeObserver");
      if (localViewTreeObserver.isAlive()) {
        this.ikv.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      }
      parama.invoke();
      AppMethodBeat.o(174568);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c
 * JD-Core Version:    0.7.0.1
 */