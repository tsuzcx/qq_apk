package com.tencent.mm.chatroom.c;

import com.tencent.mm.ag.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class k$1
  implements am.a
{
  k$1(k paramk, LinkedList paramLinkedList, i parami) {}
  
  public final boolean tC()
  {
    if (this.dmZ.size() < 25) {}
    for (int i = this.dmZ.size();; i = 25)
    {
      y.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.dmZ.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      k.a(this.dnb, 1);
      y.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done loopCount is 0");
      return false;
    }
    if (this.dmZ.isEmpty())
    {
      k.a(this.dnb, 1);
      y.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
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
    y.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.dmZ.isEmpty())
    {
      k.a(this.dnb, 1);
      y.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.k.1
 * JD-Core Version:    0.7.0.1
 */