package com.tencent.mm.openim.room.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;

public final class a$2
  implements au.a
{
  public a$2(LinkedList paramLinkedList, c paramc, bj parambj) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(151312);
    if (this.fsz.size() < 25) {}
    for (int i = this.fsz.size();; i = 25)
    {
      ac.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.fsz.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.ioT != null) {
        this.ioT.qh(2);
      }
      ac.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done loopCount is 0");
      AppMethodBeat.o(151312);
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = g.agR().ghG.vE(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      Pair localPair = (Pair)this.fsz.poll();
      this.fsA.c((String)localPair.first, (ai)localPair.second);
      j += 1;
    }
    g.agR().ghG.qL(l2);
    ac.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.fsz.isEmpty())
    {
      if (this.ioT != null) {
        this.ioT.qh(2);
      }
      ac.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done updateList is empty");
      AppMethodBeat.o(151312);
      return false;
    }
    AppMethodBeat.o(151312);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a.2
 * JD-Core Version:    0.7.0.1
 */