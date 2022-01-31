package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

final class IPCallMsgUI$5
  implements AbsListView.OnScrollListener
{
  IPCallMsgUI$5(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
    {
      paramAbsListView = IPCallMsgUI.b(this.lwI);
      if (!paramAbsListView.aCc()) {
        break label72;
      }
      if (IPCallMsgUI.d(paramAbsListView.lwI).getParent() != null) {
        IPCallMsgUI.a(paramAbsListView.lwI).removeFooterView(IPCallMsgUI.d(paramAbsListView.lwI));
      }
    }
    for (;;)
    {
      IPCallMsgUI.b(this.lwI).a(null, null);
      return;
      label72:
      paramAbsListView.iwi += 10;
      if (paramAbsListView.iwi > paramAbsListView.dsw) {
        paramAbsListView.iwi = paramAbsListView.dsw;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.5
 * JD-Core Version:    0.7.0.1
 */