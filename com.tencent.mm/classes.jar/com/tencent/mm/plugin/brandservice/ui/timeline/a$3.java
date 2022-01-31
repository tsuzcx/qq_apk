package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class a$3
  implements e.a
{
  a$3(a parama, c.e parame, int paramInt) {}
  
  public final void onFinish()
  {
    this.ifm.ifZ.ifS.setTextColor(a.a(this.ifl).getResources().getColor(b.a.white));
    this.ifm.ifZ.ifJ.setTextColor(-436207617);
    if (this.dAU == 1) {
      this.ifm.ifZ.igk.setBackgroundResource(b.c.biz_time_line_cover_bottom_round_gradient_mask);
    }
    for (;;)
    {
      a.g(this.ifl).aog();
      return;
      this.ifm.ifZ.igk.setBackgroundResource(b.c.biz_msg_cover_gradient_mask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.3
 * JD-Core Version:    0.7.0.1
 */