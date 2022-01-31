package com.tencent.mm.plugin.emojicapture.model.b;

import a.l;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$c
  implements Runnable
{
  c$c(c paramc, a.f.a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(2666);
    long l = bo.yB();
    boolean bool = c.a(this.lur).bHJ();
    ab.i(c.b(this.lur), "finishEncode used " + bo.av(l) + ", ret:" + bool + ", totally used " + bo.av(c.c(this.lur)) + "ms");
    c.d(this.lur).quit();
    a.f.a.a locala = this.luu;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(2666);
      return;
    }
    AppMethodBeat.o(2666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.c.c
 * JD-Core Version:    0.7.0.1
 */