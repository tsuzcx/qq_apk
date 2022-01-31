package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.pluginsdk.ui.applet.e.a;

final class a$6
  implements e.a
{
  a$6(a parama, c.e parame) {}
  
  public final void onFinish()
  {
    this.ifm.igb.ifL.setVisibility(0);
    this.ifm.igb.ifJ.setTextColor(a.a(this.ifl).getResources().getColor(b.a.white));
    this.ifm.igb.hic.setBackgroundResource(b.g.chatting_item_biz_pic_icon);
    a.g(this.ifl).aog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.6
 * JD-Core Version:    0.7.0.1
 */