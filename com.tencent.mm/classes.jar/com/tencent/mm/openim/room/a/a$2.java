package com.tencent.mm.openim.room.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;

public final class a$2
  implements aw.a
{
  public a$2(LinkedList paramLinkedList, c paramc, bq parambq) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(151312);
    if (this.fNd.size() < 25) {}
    for (int i = this.fNd.size();; i = 25)
    {
      ae.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.fNd.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.iLj != null) {
        this.iLj.qM(2);
      }
      ae.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done loopCount is 0");
      AppMethodBeat.o(151312);
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = g.ajR().gDX.yi(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      Pair localPair = (Pair)this.fNd.poll();
      this.fNe.c((String)localPair.first, (an)localPair.second);
      j += 1;
    }
    g.ajR().gDX.sW(l2);
    ae.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.fNd.isEmpty())
    {
      if (this.iLj != null) {
        this.iLj.qM(2);
      }
      ae.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done updateList is empty");
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