package com.tencent.mm.openim.room.a;

import android.util.Pair;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

public final class a$2
  implements am.a
{
  public a$2(LinkedList paramLinkedList, c paramc, bd parambd) {}
  
  public final boolean tC()
  {
    if (this.dnc.size() < 25) {}
    for (int i = this.dnc.size();; i = 25)
    {
      y.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.dnc.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.eQx != null) {
        this.eQx.jI(2);
      }
      y.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done loopCount is 0");
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = g.DP().dKu.eV(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      Pair localPair = (Pair)this.dnc.poll();
      this.dnd.a((String)localPair.first, (ad)localPair.second);
      j += 1;
    }
    g.DP().dKu.hI(l2);
    y.d("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.dnc.isEmpty())
    {
      if (this.eQx != null) {
        this.eQx.jI(2);
      }
      y.i("OpenIMChatRoomContactLogic", "updateMemberDetail update ctg done updateList is empty");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a.2
 * JD-Core Version:    0.7.0.1
 */