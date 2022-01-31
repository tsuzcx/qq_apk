package com.tencent.mm.memory.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(115475);
    ab.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", new Object[] { this.feW.tag });
    this.feW.invalidateSelf();
    AppMethodBeat.o(115475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.b.a.1
 * JD-Core Version:    0.7.0.1
 */