package com.tencent.mm.plugin.ipcall.ui;

import android.annotation.TargetApi;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallContactUI$11
  implements AbsListView.OnScrollListener
{
  private int lCk = 0;
  
  IPCallContactUI$11(IPCallContactUI paramIPCallContactUI) {}
  
  @TargetApi(11)
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(22086);
    if (IPCallContactUI.i(this.nSm) == -1)
    {
      IPCallContactUI.a(this.nSm, paramInt1);
      AppMethodBeat.o(22086);
      return;
    }
    if (IPCallContactUI.j(this.nSm) == -1) {
      IPCallContactUI.b(this.nSm, paramInt1);
    }
    AppMethodBeat.o(22086);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(22085);
    this.lCk = paramInt;
    this.nSm.hideVKB();
    AppMethodBeat.o(22085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.11
 * JD-Core Version:    0.7.0.1
 */