package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onGlobalLayout"})
final class b$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  b$1(b paramb) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(149735);
    Object localObject = b.f(this.iDz).getParent();
    if (localObject != null)
    {
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(149735);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup)localObject;
      int i = b.h(this.iDz);
      if ((i == 1) || (i == 3))
      {
        if (b.f(this.iDz).getLayoutParams().height != -2)
        {
          b.f(this.iDz).getLayoutParams().height = -2;
          b.f(this.iDz).requestLayout();
          AppMethodBeat.o(149735);
        }
      }
      else
      {
        i = ((ViewGroup)localObject).getHeight() - a.fromDPToPix(aj.getContext(), 60);
        if (b.f(this.iDz).getHeight() > i)
        {
          b.f(this.iDz).getLayoutParams().height = Math.min(i, b.f(this.iDz).getHeight());
          b.f(this.iDz).requestLayout();
        }
      }
      AppMethodBeat.o(149735);
      return;
    }
    AppMethodBeat.o(149735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b.1
 * JD-Core Version:    0.7.0.1
 */