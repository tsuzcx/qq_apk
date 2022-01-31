package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.az.a;

final class c$a$1
  implements Runnable
{
  c$a$1(c.a parama, az.a parama1) {}
  
  public final void run()
  {
    AppMethodBeat.i(21225);
    if (this.ncF.acS()) {
      this.ncF.acT();
    }
    c.c(this.ncG.ncE);
    c.d(this.ncG.ncE);
    AppMethodBeat.o(21225);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(21226);
    String str = super.toString() + "|QueueWorkerThreadForGallery";
    AppMethodBeat.o(21226);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c.a.1
 * JD-Core Version:    0.7.0.1
 */