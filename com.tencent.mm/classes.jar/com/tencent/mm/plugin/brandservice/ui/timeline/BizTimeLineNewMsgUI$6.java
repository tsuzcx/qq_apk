package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.h;

final class BizTimeLineNewMsgUI$6
  implements View.OnClickListener
{
  BizTimeLineNewMsgUI$6(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final void onClick(View paramView)
  {
    BizTimeLineNewMsgUI.f(this.igE).setOnClickListener(null);
    BizTimeLineNewMsgUI.a(this.igE).igv = true;
    BizTimeLineNewMsgUI.a(this.igE).oz(BizTimeLineNewMsgUI.a(this.igE).getCount() - 1);
    BizTimeLineNewMsgUI.g(this.igE).setVisibility(0);
    BizTimeLineNewMsgUI.h(this.igE).setText(this.igE.getString(b.h.biz_time_line_loading_more_tips));
    BizTimeLineNewMsgUI.f(this.igE).setBackgroundColor(this.igE.getResources().getColor(b.a.biz_timeline_bg));
    BizTimeLineNewMsgUI.i(this.igE).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.6
 * JD-Core Version:    0.7.0.1
 */