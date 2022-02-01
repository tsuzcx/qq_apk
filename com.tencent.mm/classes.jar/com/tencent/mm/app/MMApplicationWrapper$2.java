package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.c.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class MMApplicationWrapper$2
  implements c.a
{
  MMApplicationWrapper$2(MMApplicationWrapper paramMMApplicationWrapper) {}
  
  public final void aCy()
  {
    AppMethodBeat.i(239089);
    com.tencent.mm.bv.a.lJ(MMApplicationContext.getContext());
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/app/MMApplicationWrapper$2", "onDensityChange", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/app/MMApplicationWrapper$2", "onDensityChange", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(239089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationWrapper.2
 * JD-Core Version:    0.7.0.1
 */