package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class s$8$2
  implements Runnable
{
  s$8$2(s.8 param8) {}
  
  public final void run()
  {
    AppMethodBeat.i(155935);
    if ((this.iwZ.iwY) && (s.b(this.iwZ.iwT) != null))
    {
      s.b(this.iwZ.iwT).cancel();
      s.a(this.iwZ.iwT, null);
    }
    this.iwZ.iwW.cancel();
    AppMethodBeat.o(155935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s.8.2
 * JD-Core Version:    0.7.0.1
 */