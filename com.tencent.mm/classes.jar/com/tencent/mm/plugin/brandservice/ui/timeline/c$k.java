package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class c$k
  extends c.c
{
  ImageView hic;
  ImageView ifG;
  MMNeatTextView ifS;
  View igj;
  TextView igm;
  View ign;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(b.d.viewstub_top_video_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(b.d.chatting_item_biz_video);
    this.ifK = paramView.findViewById(b.d.chatting_item_biz_video_click_view);
    axU();
    this.ifG = ((ImageView)this.ifA.findViewById(b.d.cover));
    this.ifL = ((ImageView)this.ifA.findViewById(b.d.cover_mask_iv));
    this.hic = ((ImageView)this.ifA.findViewById(b.d.video_icon));
    this.ifS = ((MMNeatTextView)this.ifA.findViewById(b.d.title_tv));
    this.igm = ((TextView)this.ifA.findViewById(b.d.play_time_tv));
    this.igj = this.ifA.findViewById(b.d.chatting_video_cover_ll);
    this.ifM = ((ImageView)this.ifA.findViewById(b.d.press_mask_iv));
    this.ign = this.ifA.findViewById(b.d.video_icon_container);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.k
 * JD-Core Version:    0.7.0.1
 */