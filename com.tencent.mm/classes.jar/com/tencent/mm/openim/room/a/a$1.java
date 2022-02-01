package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;

public final class a$1
  implements av.a
{
  public a$1(LinkedList paramLinkedList, c paramc, j paramj) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(151311);
    if (this.foW.size() < 25) {}
    for (int i = this.foW.size();; i = 25)
    {
      ad.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.foW.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.hOx != null) {
        this.hOx.pt(1);
      }
      ad.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done loopCount is 0");
      AppMethodBeat.o(151311);
      return false;
    }
    if (this.foW.isEmpty())
    {
      if (this.hOx != null) {
        this.hOx.pt(1);
      }
      ad.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
      AppMethodBeat.o(151311);
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = g.afB().gda.rb(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      i locali = (i)this.foW.poll();
      if (locali == null) {
        break;
      }
      this.foX.b(locali);
      j += 1;
    }
    g.afB().gda.mX(l2);
    ad.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.foW.isEmpty())
    {
      if (this.hOx != null) {
        this.hOx.pt(1);
      }
      ad.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
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