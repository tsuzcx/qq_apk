package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$applyRotation$6", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
public final class b$h
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(174567);
    b.f(this.iDz).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    b.a(this.iDz, b.g(this.iDz));
    AppMethodBeat.o(174567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b.h
 * JD-Core Version:    0.7.0.1
 */