package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.f.b;
import java.util.LinkedList;

public final class b$3
  implements Runnable
{
  public b$3(b paramb, b.b paramb1, LinkedList paramLinkedList, f.b paramb2, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(21227);
    if ((!this.rLy.rLv) && (this.rLz != null)) {
      this.rLz.a(this.rLA, this.rLB, this.rLC);
    }
    AppMethodBeat.o(21227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.b.3
 * JD-Core Version:    0.7.0.1
 */