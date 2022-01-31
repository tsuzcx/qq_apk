package com.tencent.mm.openim.room.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

public final class a$2
  implements ap.a
{
  public a$2(LinkedList paramLinkedList, c paramc, bd parambd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(78968);
    if (this.eeD.size() < 25) {}
    for (int i = this.eeD.size();; i = 25)
    {
      ab.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.eeD.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.ggA != null) {
        this.ggA.mE(2);
      }
      ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done loopCount is 0");
      AppMethodBeat.o(78968);
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = g.RL().eHS.kr(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      Pair localPair = (Pair)this.eeD.poll();
      this.eeE.b((String)localPair.first, (ad)localPair.second);
      j += 1;
    }
    g.RL().eHS.nY(l2);
    ab.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.eeD.isEmpty())
    {
      if (this.ggA != null) {
        this.ggA.mE(2);
      }
      ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done updateList is empty");
      AppMethodBeat.o(78968);
      return false;
    }
    AppMethodBeat.o(78968);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a.2
 * JD-Core Version:    0.7.0.1
 */