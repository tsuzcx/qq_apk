package com.tencent.mm.chatroom.c;

import android.util.Pair;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

final class k$2
  implements am.a
{
  k$2(k paramk, LinkedList paramLinkedList, bd parambd) {}
  
  public final boolean tC()
  {
    if (this.dnc.size() < 25) {}
    for (int i = this.dnc.size();; i = 25)
    {
      y.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.dnc.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      k.a(this.dnb, 2);
      y.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done loopCount is 0");
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
    y.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.dnc.isEmpty())
    {
      k.a(this.dnb, 2);
      y.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done updateList is empty");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.k.2
 * JD-Core Version:    0.7.0.1
 */