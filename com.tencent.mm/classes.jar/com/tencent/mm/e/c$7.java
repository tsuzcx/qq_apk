package com.tencent.mm.e;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.a;
import com.tencent.mm.view.b.a.b;

public final class c$7
  implements a.b
{
  public c$7(c paramc) {}
  
  public final void CO()
  {
    AppMethodBeat.i(116160);
    this.cdH.getMainMatrix().set(((a)this.cdH.CB()).ecs);
    this.cdH.CJ();
    c.a(this.cdH, 300L, false, false);
    AppMethodBeat.o(116160);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(116161);
    c.a(this.cdH, false);
    AppMethodBeat.o(116161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.c.7
 * JD-Core Version:    0.7.0.1
 */