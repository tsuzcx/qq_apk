package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallMsgUI$5
  implements AbsListView.OnScrollListener
{
  IPCallMsgUI$5(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(22190);
    if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
    {
      paramAbsListView = IPCallMsgUI.b(this.nTV);
      if (paramAbsListView.bem()) {
        if (IPCallMsgUI.d(paramAbsListView.nTV).getParent() != null) {
          IPCallMsgUI.a(paramAbsListView.nTV).removeFooterView(IPCallMsgUI.d(paramAbsListView.nTV));
        }
      }
      for (;;)
      {
        IPCallMsgUI.b(this.nTV).a(null, null);
        AppMethodBeat.o(22190);
        return;
        paramAbsListView.kxm += 10;
        if (paramAbsListView.kxm > paramAbsListView.eke) {
          paramAbsListView.kxm = paramAbsListView.eke;
        }
      }
    }
    AppMethodBeat.o(22190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.5
 * JD-Core Version:    0.7.0.1
 */