package com.tencent.mm.plugin.appbrand.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$b$1
  implements Runnable
{
  c$b$1(c.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(132945);
    if (c.k(this.iMy.iMp).getVisibility() == 0)
    {
      c.k(this.iMy.iMp).setText(String.format("%d%%", new Object[] { Integer.valueOf(c.b.a(this.iMy)) }));
      if (c.b.a(this.iMy) == 100)
      {
        c.o(this.iMy.iMp);
        if (c.p(this.iMy.iMp) != null)
        {
          c.p(this.iMy.iMp).run();
          c.a(this.iMy.iMp, null);
        }
      }
    }
    AppMethodBeat.o(132945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.b.1
 * JD-Core Version:    0.7.0.1
 */