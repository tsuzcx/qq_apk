package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class a$12
  implements View.OnClickListener
{
  a$12(a parama, q paramq, c.f paramf) {}
  
  public final void onClick(View paramView)
  {
    if (!this.hSM.field_isExpand)
    {
      this.ifq.ifS.setMaxLines(2147483647);
      this.hSM.field_isExpand = true;
      this.ifq.igf.setText(b.h.biz_time_line_item_show_all_text_collapse);
      return;
    }
    this.ifq.ifS.setMaxLines(5);
    this.hSM.field_isExpand = false;
    this.ifq.igf.setText(b.h.biz_time_line_item_show_all_text);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.12
 * JD-Core Version:    0.7.0.1
 */