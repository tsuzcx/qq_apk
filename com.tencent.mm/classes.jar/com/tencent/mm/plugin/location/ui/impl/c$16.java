package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.MMLoadMoreListView;

final class c$16
  implements View.OnClickListener
{
  c$16(c paramc) {}
  
  public final void onClick(View paramView)
  {
    if (!c.q(this.lJp)) {
      c.u(this.lJp);
    }
    c.v(this.lJp).clean();
    c.w(this.lJp).setAdapter(c.v(this.lJp));
    c.v(this.lJp).notifyDataSetChanged();
    c.x(this.lJp).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.16
 * JD-Core Version:    0.7.0.1
 */