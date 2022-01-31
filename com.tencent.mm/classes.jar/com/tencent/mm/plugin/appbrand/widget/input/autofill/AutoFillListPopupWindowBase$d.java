package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class AutoFillListPopupWindowBase$d
  implements AbsListView.OnScrollListener
{
  private AutoFillListPopupWindowBase$d(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(123918);
    if ((AutoFillListPopupWindowBase.a(this.jpu) != null) && (AutoFillListPopupWindowBase.e(this.jpu) != null) && (AutoFillListPopupWindowBase.f(this.jpu) != null) && (AutoFillListPopupWindowBase.a(this.jpu) != null))
    {
      if ((AutoFillListPopupWindowBase.a(this.jpu).getLastVisiblePosition() == AutoFillListPopupWindowBase.f(this.jpu).getCount() - 1) && (AutoFillListPopupWindowBase.a(this.jpu).getChildAt(AutoFillListPopupWindowBase.a(this.jpu).getChildCount() - 1) != null) && (AutoFillListPopupWindowBase.a(this.jpu).getChildAt(AutoFillListPopupWindowBase.a(this.jpu).getChildCount() - 1).getBottom() <= AutoFillListPopupWindowBase.a(this.jpu).getHeight()))
      {
        AutoFillListPopupWindowBase.e(this.jpu).setVisibility(8);
        AppMethodBeat.o(123918);
        return;
      }
      AutoFillListPopupWindowBase.e(this.jpu).setVisibility(0);
    }
    AppMethodBeat.o(123918);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(123919);
    if ((paramInt == 1) && (!this.jpu.isInputMethodNotNeeded()) && (AutoFillListPopupWindowBase.b(this.jpu).getContentView() != null))
    {
      AutoFillListPopupWindowBase.d(this.jpu).removeCallbacks(AutoFillListPopupWindowBase.c(this.jpu));
      AutoFillListPopupWindowBase.c(this.jpu).run();
    }
    AppMethodBeat.o(123919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.d
 * JD-Core Version:    0.7.0.1
 */