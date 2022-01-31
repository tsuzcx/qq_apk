package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;

class c$a
  extends c.c
{
  LinearLayout ify;
  LinearLayout ifz;
  
  public final void axT()
  {
    if (this.ifA == null) {
      return;
    }
    this.doU = ((ImageView)this.ifA.findViewById(b.d.avatar_iv));
    this.ifO = ((TextView)this.ifA.findViewById(b.d.nick_name_tv));
    this.dsz = ((TextView)this.ifA.findViewById(b.d.time_tv));
    this.ifN = this.ifA.findViewById(b.d.biz_avatar_layout);
    this.ify = ((LinearLayout)this.ifA.findViewById(b.d.biz_time_line_new_tips_layout));
    this.ifz = ((LinearLayout)this.ifA.findViewById(b.d.biz_time_line_item_top));
  }
  
  public final void cC(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.a
 * JD-Core Version:    0.7.0.1
 */