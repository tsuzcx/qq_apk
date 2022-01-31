package com.tencent.mm.plugin.forcenotify.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class a$a$1
  implements Runnable
{
  a$a$1(a.a parama, String paramString) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(51024);
    a locala = this.mHl.mHj;
    String str = this.mHm;
    j.p(str, "fromUser");
    if (a.b(this.mHl.mHj).size() == 1) {}
    for (;;)
    {
      locala.aP(str, bool);
      AppMethodBeat.o(51024);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */