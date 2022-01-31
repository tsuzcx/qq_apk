package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    if ((c.a(this.kjA) == 1) || (c.a(this.kjA) == 3))
    {
      y.i("MicroMsg.FavHeaderView", "click clear fav item");
      if (c.b(this.kjA) != null) {
        c.b(this.kjA).aRt();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c.1
 * JD-Core Version:    0.7.0.1
 */