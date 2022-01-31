package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;

class c$c
{
  ImageView doU;
  TextView dsz;
  View ifA;
  View ifI;
  TextView ifJ;
  View ifK;
  ImageView ifL;
  ImageView ifM;
  View ifN;
  TextView ifO;
  
  public void axT()
  {
    if (this.ifA == null) {
      return;
    }
    this.doU = ((ImageView)this.ifA.findViewById(b.d.avatar_iv));
    this.ifO = ((TextView)this.ifA.findViewById(b.d.nick_name_tv));
    this.dsz = ((TextView)this.ifA.findViewById(b.d.time_tv));
    this.ifN = this.ifA.findViewById(b.d.biz_avatar_layout);
  }
  
  public final void axU()
  {
    if (this.ifA == null) {
      return;
    }
    this.ifI = this.ifA.findViewById(b.d.stat_layout);
    this.ifJ = ((TextView)this.ifA.findViewById(b.d.friends_read_tv));
  }
  
  public void cC(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.c
 * JD-Core Version:    0.7.0.1
 */