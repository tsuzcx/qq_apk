package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.tencent.mm.sdk.platformtools.ah;

final class AutoFillListPopupWindowBase$d
  implements AbsListView.OnScrollListener
{
  private AutoFillListPopupWindowBase$d(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((AutoFillListPopupWindowBase.a(this.hxk) != null) && (AutoFillListPopupWindowBase.e(this.hxk) != null) && (AutoFillListPopupWindowBase.f(this.hxk) != null) && (AutoFillListPopupWindowBase.a(this.hxk) != null))
    {
      if ((AutoFillListPopupWindowBase.a(this.hxk).getLastVisiblePosition() == AutoFillListPopupWindowBase.f(this.hxk).getCount() - 1) && (AutoFillListPopupWindowBase.a(this.hxk).getChildAt(AutoFillListPopupWindowBase.a(this.hxk).getChildCount() - 1) != null) && (AutoFillListPopupWindowBase.a(this.hxk).getChildAt(AutoFillListPopupWindowBase.a(this.hxk).getChildCount() - 1).getBottom() <= AutoFillListPopupWindowBase.a(this.hxk).getHeight())) {
        AutoFillListPopupWindowBase.e(this.hxk).setVisibility(8);
      }
    }
    else {
      return;
    }
    AutoFillListPopupWindowBase.e(this.hxk).setVisibility(0);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 1) && (!this.hxk.isInputMethodNotNeeded()) && (AutoFillListPopupWindowBase.b(this.hxk).getContentView() != null))
    {
      AutoFillListPopupWindowBase.d(this.hxk).removeCallbacks(AutoFillListPopupWindowBase.c(this.hxk));
      AutoFillListPopupWindowBase.c(this.hxk).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.d
 * JD-Core Version:    0.7.0.1
 */