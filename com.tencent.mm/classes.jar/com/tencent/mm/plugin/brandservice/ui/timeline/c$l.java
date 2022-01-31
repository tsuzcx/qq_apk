package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class c$l
  extends c.c
{
  ImageView ifH;
  MMNeatTextView ifS;
  TextView igo;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(b.d.viewstub_top_voice_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(b.d.chatting_item_biz_voice);
    this.ifK = paramView.findViewById(b.d.chatting_item_biz_voice_click_view);
    axU();
    this.ifS = ((MMNeatTextView)this.ifA.findViewById(b.d.title_tv));
    this.igo = ((TextView)this.ifA.findViewById(b.d.play_time_tv));
    this.ifH = ((ImageView)this.ifA.findViewById(b.d.big_play_icon));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.l
 * JD-Core Version:    0.7.0.1
 */