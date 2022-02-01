package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.LinkedList;

public final class a$1
  implements MTimerHandler.CallBack
{
  public a$1(LinkedList paramLinkedList, c paramc, k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(151311);
    if (this.lyx.size() < 25) {}
    for (int i = this.lyx.size();; i = 25)
    {
      Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.lyx.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.ptR != null) {
        this.ptR.xK(1);
      }
      Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done loopCount is 0");
      AppMethodBeat.o(151311);
      return false;
    }
    if (this.lyx.isEmpty())
    {
      if (this.ptR != null) {
        this.ptR.xK(1);
      }
      Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
      AppMethodBeat.o(151311);
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      j localj = (j)this.lyx.poll();
      if (localj == null) {
        break;
      }
      this.lyy.b(localj);
      j += 1;
    }
    com.tencent.mm.kernel.h.baE().mCN.endTransaction(l2);
    Log.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.lyx.isEmpty())
    {
      if (this.ptR != null) {
        this.ptR.xK(1);
      }
      Log.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
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