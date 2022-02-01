package com.tencent.mm.openim.room.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.LinkedList;

public final class a$2
  implements MTimerHandler.CallBack
{
  public a$2(LinkedList paramLinkedList, c paramc, bx parambx) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(151312);
    if (this.lyD.size() < 25) {}
    for (int i = this.lyD.size();; i = 25)
    {
      Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.lyD.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.ptR != null) {
        this.ptR.xK(2);
      }
      Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done loopCount is 0");
      AppMethodBeat.o(151312);
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      Pair localPair = (Pair)this.lyD.poll();
      this.lyE.d((String)localPair.first, (au)localPair.second);
      j += 1;
    }
    com.tencent.mm.kernel.h.baE().mCN.endTransaction(l2);
    Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.lyD.isEmpty())
    {
      if (this.ptR != null) {
        this.ptR.xK(2);
      }
      Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done updateList is empty");
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