package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.storage.q;

final class a$10
  implements View.OnLongClickListener
{
  a$10(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    a.a(this.ifl, (q)paramView.getTag());
    a.a(this.ifl, 0);
    a.k(this.ifl).a(paramView, this.ifl, a.h(this.ifl), a.i(this.ifl), a.j(this.ifl));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.10
 * JD-Core Version:    0.7.0.1
 */