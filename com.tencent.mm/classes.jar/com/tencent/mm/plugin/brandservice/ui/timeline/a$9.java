package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ai.z;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;

final class a$9
  implements View.OnClickListener
{
  a$9(a parama) {}
  
  public final void onClick(View paramView)
  {
    paramView = (q)paramView.getTag();
    paramView.field_isExpand = true;
    z.ME().h(paramView);
    a.d(this.ifl).c(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.9
 * JD-Core Version:    0.7.0.1
 */