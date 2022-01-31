package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.mm.plugin.brandservice.b.d;

final class c$h
  extends c.c
{
  ImageView hic;
  ImageView ifG;
  View igj;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(b.d.viewstub_top_pic_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(b.d.chatting_item_biz_pic);
    this.ifK = paramView.findViewById(b.d.chatting_item_biz_pic_click_view);
    axU();
    this.ifG = ((ImageView)this.ifA.findViewById(b.d.cover));
    this.ifL = ((ImageView)this.ifA.findViewById(b.d.cover_mask_iv));
    this.hic = ((ImageView)this.ifA.findViewById(b.d.pic_icon));
    this.igj = this.ifA.findViewById(b.d.chatting_pic_cover_ll);
    this.ifM = ((ImageView)this.ifA.findViewById(b.d.press_mask_iv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.h
 * JD-Core Version:    0.7.0.1
 */