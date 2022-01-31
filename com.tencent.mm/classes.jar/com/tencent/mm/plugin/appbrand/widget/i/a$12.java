package com.tencent.mm.plugin.appbrand.widget.i;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class a$12
  implements Runnable
{
  a$12(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(87541);
    int i = 0;
    while (i < this.jwQ.jwI.size())
    {
      this.jwQ.a(this.jwQ.jwD.getChildAt(i), (a.a)this.jwQ.jwI.get(i));
      i += 1;
    }
    AppMethodBeat.o(87541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.a.12
 * JD-Core Version:    0.7.0.1
 */