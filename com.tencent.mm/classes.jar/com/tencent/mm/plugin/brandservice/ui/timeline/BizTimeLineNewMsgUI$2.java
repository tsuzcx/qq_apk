package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.q;

final class BizTimeLineNewMsgUI$2
  implements AbsListView.OnScrollListener
{
  BizTimeLineNewMsgUI$2(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(5917);
    q.aIJ().cp(paramInt);
    AppMethodBeat.o(5917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.2
 * JD-Core Version:    0.7.0.1
 */