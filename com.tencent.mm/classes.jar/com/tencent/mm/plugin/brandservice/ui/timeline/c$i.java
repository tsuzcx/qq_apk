package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class c$i
  extends c.c
{
  ImageView ifG;
  MMNeatTextView ifS;
  View igk;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(b.d.viewstub_top_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(b.d.topSlot);
    this.ifK = paramView.findViewById(b.d.topSlot_click_view);
    axU();
    this.ifG = ((ImageView)this.ifA.findViewById(b.d.cover_iv));
    this.ifS = ((MMNeatTextView)this.ifA.findViewById(b.d.title_tv));
    this.ifL = ((ImageView)this.ifA.findViewById(b.d.cover_mask_iv));
    this.ifM = ((ImageView)this.ifA.findViewById(b.d.press_mask_iv));
    this.igk = this.ifA.findViewById(b.d.biz_time_line_top_title_layout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.i
 * JD-Core Version:    0.7.0.1
 */