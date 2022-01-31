package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class b$4
  implements View.OnClickListener
{
  private long jbu = 0L;
  
  b$4(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(141715);
    if (System.currentTimeMillis() - this.jbu < 250L)
    {
      paramView = b.b(this.jbs).iterator();
      while (paramView.hasNext()) {
        ((a)paramView.next()).aGp();
      }
      this.jbu = 0L;
    }
    this.jbu = System.currentTimeMillis();
    AppMethodBeat.o(141715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.4
 * JD-Core Version:    0.7.0.1
 */