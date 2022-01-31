package com.tencent.mm.chatroom.c;

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

final class k$2
  implements ap.a
{
  k$2(k paramk, LinkedList paramLinkedList, bd parambd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(103932);
    if (this.eeD.size() < 25) {}
    for (int i = this.eeD.size();; i = 25)
    {
      ab.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.eeD.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      k.a(this.eeC, 2);
      ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done loopCount is 0");
      AppMethodBeat.o(103932);
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
    ab.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.eeD.isEmpty())
    {
      k.a(this.eeC, 2);
      ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done updateList is empty");
      AppMethodBeat.o(103932);
      return false;
    }
    AppMethodBeat.o(103932);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.k.2
 * JD-Core Version:    0.7.0.1
 */