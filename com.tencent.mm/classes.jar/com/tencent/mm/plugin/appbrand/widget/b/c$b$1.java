package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$b$1
  implements View.OnClickListener
{
  c$b$1(c.b paramb, c.c paramc, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(102352);
    if (this.jjf.state == 2)
    {
      this.jjg.setImageResource(2130839323);
      this.jjf.state = 1;
      AppMethodBeat.o(102352);
      return;
    }
    if (this.jjf.state == 1)
    {
      this.jjg.setImageResource(2130839321);
      this.jjf.state = 2;
    }
    AppMethodBeat.o(102352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.c.b.1
 * JD-Core Version:    0.7.0.1
 */