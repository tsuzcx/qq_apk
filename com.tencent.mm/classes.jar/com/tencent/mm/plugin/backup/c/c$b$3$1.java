package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.g.l.a;
import com.tencent.mm.sdk.g.d;
import java.util.LinkedList;

final class c$b$3$1
  implements l.a
{
  c$b$3$1(c.b.3 param3) {}
  
  public final void D(LinkedList<Long> paramLinkedList)
  {
    AppMethodBeat.i(17181);
    d.h(new c.b.3.1.1(this, paramLinkedList), "AddBigFileToQueue").start();
    AppMethodBeat.o(17181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c.b.3.1
 * JD-Core Version:    0.7.0.1
 */