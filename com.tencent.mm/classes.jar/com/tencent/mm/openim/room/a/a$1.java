package com.tencent.mm.openim.room.a;

import com.tencent.mm.ag.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class a$1
  implements am.a
{
  public a$1(LinkedList paramLinkedList, c paramc, i parami) {}
  
  public final boolean tC()
  {
    if (this.dmZ.size() < 25) {}
    for (int i = this.dmZ.size();; i = 25)
    {
      y.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.dmZ.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      if (this.eQx != null) {
        this.eQx.jI(1);
      }
      y.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done loopCount is 0");
      return false;
    }
    if (this.dmZ.isEmpty())
    {
      if (this.eQx != null) {
        this.eQx.jI(1);
      }
      y.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = g.DP().dKu.eV(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      com.tencent.mm.ag.h localh = (com.tencent.mm.ag.h)this.dmZ.poll();
      if (localh == null) {
        break;
      }
      this.dna.a(localh);
      j += 1;
    }
    g.DP().dKu.hI(l2);
    y.d("OpenIMChatRoomContactLogic", "updateMemberDetail update img loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.dmZ.isEmpty())
    {
      if (this.eQx != null) {
        this.eQx.jI(1);
      }
      y.i("OpenIMChatRoomContactLogic", "updateMemberDetail update img done newImgFlagList is empty");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.a.1
 * JD-Core Version:    0.7.0.1
 */