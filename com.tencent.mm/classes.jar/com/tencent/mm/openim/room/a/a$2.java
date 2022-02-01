package com.tencent.mm.openim.room.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;

public final class a$2
  implements av.a
{
  public a$2(LinkedList paramLinkedList, c paramc, bg parambg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(151312);
    if (this.foZ.size() < 25) {}
    for (int i = this.foZ.size();; i = 25)
    {
      ad.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.foZ.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.hOx != null) {
        this.hOx.pt(2);
      }
      ad.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done loopCount is 0");
      AppMethodBeat.o(151312);
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = g.afB().gda.rb(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      Pair localPair = (Pair)this.foZ.poll();
      this.fpa.c((String)localPair.first, (af)localPair.second);
      j += 1;
    }
    g.afB().gda.mX(l2);
    ad.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.foZ.isEmpty())
    {
      if (this.hOx != null) {
        this.hOx.pt(2);
      }
      ad.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done updateList is empty");
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