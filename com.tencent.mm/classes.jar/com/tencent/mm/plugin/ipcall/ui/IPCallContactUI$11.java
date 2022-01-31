package com.tencent.mm.plugin.ipcall.ui;

import android.annotation.TargetApi;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class IPCallContactUI$11
  implements AbsListView.OnScrollListener
{
  private int luV = 0;
  
  IPCallContactUI$11(IPCallContactUI paramIPCallContactUI) {}
  
  @TargetApi(11)
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (IPCallContactUI.i(this.luU) == -1) {
      IPCallContactUI.a(this.luU, paramInt1);
    }
    while (IPCallContactUI.j(this.luU) != -1) {
      return;
    }
    IPCallContactUI.b(this.luU, paramInt1);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.luV = paramInt;
    this.luU.XM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.11
 * JD-Core Version:    0.7.0.1
 */