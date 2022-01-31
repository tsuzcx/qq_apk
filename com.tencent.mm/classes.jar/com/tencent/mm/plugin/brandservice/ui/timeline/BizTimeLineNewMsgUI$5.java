package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.c.a;

final class BizTimeLineNewMsgUI$5
  implements AdapterView.OnItemLongClickListener
{
  BizTimeLineNewMsgUI$5(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(14160);
    BizTimeLineNewMsgUI.a(this.jWx, BizTimeLineNewMsgUI.a(this.jWx).se(paramInt));
    BizTimeLineNewMsgUI.e(this.jWx).a(paramView, paramInt, paramLong, this.jWx, BizTimeLineNewMsgUI.b(this.jWx), BizTimeLineNewMsgUI.c(this.jWx), BizTimeLineNewMsgUI.d(this.jWx));
    AppMethodBeat.o(14160);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.5
 * JD-Core Version:    0.7.0.1
 */