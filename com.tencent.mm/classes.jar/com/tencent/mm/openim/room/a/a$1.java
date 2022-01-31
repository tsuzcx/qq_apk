package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.LinkedList;

public final class a$1
  implements ap.a
{
  public a$1(LinkedList paramLinkedList, c paramc, i parami) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(78967);
    if (this.eeA.size() < 25) {}
    for (int i = this.eeA.size();; i = 25)
    {
      ab.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.eeA.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.ggA != null) {
        this.ggA.mE(1);
      }
      ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done loopCount is 0");
      AppMethodBeat.o(78967);
      return false;
    }
    if (this.eeA.isEmpty())
    {
      if (this.ggA != null) {
        this.ggA.mE(1);
      }
      ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
      AppMethodBeat.o(78967);
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = g.RL().eHS.kr(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      com.tencent.mm.ah.h localh = (com.tencent.mm.ah.h)this.eeA.poll();
      if (localh == null) {
        break;
      }
      this.eeB.b(localh);
      j += 1;
    }
    g.RL().eHS.nY(l2);
    ab.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.eeA.isEmpty())
    {
      if (this.ggA != null) {
        this.ggA.mE(1);
      }
      ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
      AppMethodBeat.o(78967);
      return false;
    }
    AppMethodBeat.o(78967);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a.1
 * JD-Core Version:    0.7.0.1
 */