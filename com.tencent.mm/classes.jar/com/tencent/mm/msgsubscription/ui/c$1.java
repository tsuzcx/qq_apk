package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onGlobalLayout"})
final class c$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  c$1(c paramc) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(149735);
    Object localObject = c.f(this.msv).getParent();
    if (localObject != null)
    {
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(149735);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup)localObject;
      int i = c.i(this.msv);
      if ((i == 1) || (i == 3))
      {
        if (c.f(this.msv).getLayoutParams().height != -2)
        {
          c.f(this.msv).getLayoutParams().height = -2;
          c.f(this.msv).requestLayout();
          AppMethodBeat.o(149735);
        }
      }
      else
      {
        i = ((ViewGroup)localObject).getHeight() - a.fromDPToPix(MMApplicationContext.getContext(), 60);
        if (c.f(this.msv).getHeight() > i)
        {
          c.f(this.msv).getLayoutParams().height = Math.min(i, c.f(this.msv).getHeight());
          c.f(this.msv).requestLayout();
        }
      }
      AppMethodBeat.o(149735);
      return;
    }
    AppMethodBeat.o(149735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c.1
 * JD-Core Version:    0.7.0.1
 */