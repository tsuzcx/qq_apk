package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizTimeLineUI$1
  implements View.OnClickListener
{
  BizTimeLineUI$1(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(14183);
    paramView = new Intent(this.jXh.getContext(), BizTimeLineNewMsgUI.class);
    paramView.putExtra("biz_time_line_line_enter_scene", 1);
    this.jXh.startActivity(paramView);
    AppMethodBeat.o(14183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.1
 * JD-Core Version:    0.7.0.1
 */