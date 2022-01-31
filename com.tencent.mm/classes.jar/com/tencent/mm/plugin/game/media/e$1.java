package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.c;
import java.util.HashMap;
import java.util.LinkedList;

final class e$1
  implements Runnable
{
  e$1(e parame, d paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    AppMethodBeat.i(151808);
    LinkedList localLinkedList = c.QC(this.nkX.field_localIdList);
    g localg = new g(this.nkX.field_taskId, this.nkY, localLinkedList, this.caa, this.nkZ);
    localg.nlj = new e.1.1(this, localLinkedList);
    localg.bFI();
    e.a(this.nla).put(this.nkX.field_taskId, localg);
    AppMethodBeat.o(151808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.e.1
 * JD-Core Version:    0.7.0.1
 */