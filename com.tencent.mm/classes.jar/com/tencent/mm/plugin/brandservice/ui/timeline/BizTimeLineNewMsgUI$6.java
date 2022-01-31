package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizTimeLineNewMsgUI$6
  implements View.OnClickListener
{
  BizTimeLineNewMsgUI$6(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(14161);
    BizTimeLineNewMsgUI.f(this.jWx).setOnClickListener(null);
    BizTimeLineNewMsgUI.a(this.jWx).jWm = true;
    BizTimeLineNewMsgUI.a(this.jWx).sf(BizTimeLineNewMsgUI.a(this.jWx).getCount() - 1);
    BizTimeLineNewMsgUI.g(this.jWx).setVisibility(0);
    BizTimeLineNewMsgUI.h(this.jWx).setText(this.jWx.getString(2131297709));
    BizTimeLineNewMsgUI.f(this.jWx).setBackgroundColor(this.jWx.getResources().getColor(2131689748));
    BizTimeLineNewMsgUI.i(this.jWx).setVisibility(8);
    AppMethodBeat.o(14161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.6
 * JD-Core Version:    0.7.0.1
 */