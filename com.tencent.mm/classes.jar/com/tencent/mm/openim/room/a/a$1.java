package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;

public final class a$1
  implements au.a
{
  public a$1(LinkedList paramLinkedList, c paramc, j paramj) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(151311);
    if (this.fsv.size() < 25) {}
    for (int i = this.fsv.size();; i = 25)
    {
      ac.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.fsv.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.ioT != null) {
        this.ioT.qh(1);
      }
      ac.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done loopCount is 0");
      AppMethodBeat.o(151311);
      return false;
    }
    if (this.fsv.isEmpty())
    {
      if (this.ioT != null) {
        this.ioT.qh(1);
      }
      ac.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
      AppMethodBeat.o(151311);
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = g.agR().ghG.vE(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      i locali = (i)this.fsv.poll();
      if (locali == null) {
        break;
      }
      this.fsw.b(locali);
      j += 1;
    }
    g.agR().ghG.qL(l2);
    ac.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.fsv.isEmpty())
    {
      if (this.ioT != null) {
        this.ioT.qh(1);
      }
      ac.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
      AppMethodBeat.o(151311);
      return false;
    }
    AppMethodBeat.o(151311);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a.1
 * JD-Core Version:    0.7.0.1
 */