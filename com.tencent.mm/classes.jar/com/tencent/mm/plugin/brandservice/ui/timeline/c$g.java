package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class c$g
  extends c.c
{
  ImageView ifG;
  ImageView ifH;
  MMNeatTextView ifS;
  TextView igh;
  ImageView igi;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(b.d.viewstub_top_music_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(b.d.chatting_item_biz_music);
    this.ifK = paramView.findViewById(b.d.chatting_item_biz_music_click_view);
    axU();
    this.ifG = ((ImageView)this.ifA.findViewById(b.d.cover));
    this.ifS = ((MMNeatTextView)this.ifA.findViewById(b.d.title_tv));
    this.igh = ((TextView)this.ifA.findViewById(b.d.player_tv));
    this.ifH = ((ImageView)this.ifA.findViewById(b.d.play_icon));
    this.igi = ((ImageView)this.ifA.findViewById(b.d.watermark_iv));
    this.ifL = ((ImageView)this.ifA.findViewById(b.d.cover_mask_iv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.g
 * JD-Core Version:    0.7.0.1
 */