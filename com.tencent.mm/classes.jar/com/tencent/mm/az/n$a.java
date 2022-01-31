package com.tencent.mm.az;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;
import java.util.List;

final class n$a
  extends ap
{
  public n$a(n paramn, List<j.b> paramList, LinkedList<Integer> paramLinkedList, LinkedList<bjn> paramLinkedList1)
  {
    super(g.RO().oNc.getLooper(), new n.a.1(paramn, paramLinkedList, paramLinkedList1, localLinkedList, paramList), true);
    AppMethodBeat.i(996);
    AppMethodBeat.o(996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.n.a
 * JD-Core Version:    0.7.0.1
 */