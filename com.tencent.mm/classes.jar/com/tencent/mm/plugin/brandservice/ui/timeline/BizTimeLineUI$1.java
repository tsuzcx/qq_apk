package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class BizTimeLineUI$1
  implements View.OnClickListener
{
  BizTimeLineUI$1(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.ihl.mController.uMN, BizTimeLineNewMsgUI.class);
    paramView.putExtra("biz_time_line_line_enter_scene", 1);
    this.ihl.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.1
 * JD-Core Version:    0.7.0.1
 */