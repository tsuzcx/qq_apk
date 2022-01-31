package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.ViewStub;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class c$j
  extends c.c
{
  MMNeatTextView ifS;
  View igl;
  
  public final void cC(View paramView)
  {
    if (this.ifA != null) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)paramView.findViewById(b.d.viewstub_top_text_slot);
    } while (localViewStub == null);
    localViewStub.inflate();
    this.ifA = paramView.findViewById(b.d.chatting_item_biz_text);
    this.ifK = paramView.findViewById(b.d.chatting_item_biz_text_click_view);
    axU();
    this.igl = paramView.findViewById(b.d.bottom);
    this.ifS = ((MMNeatTextView)this.ifA.findViewById(b.d.title_tv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.j
 * JD-Core Version:    0.7.0.1
 */