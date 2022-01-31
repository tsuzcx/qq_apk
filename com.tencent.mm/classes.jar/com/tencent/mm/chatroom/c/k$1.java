package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.LinkedList;

final class k$1
  implements ap.a
{
  k$1(k paramk, LinkedList paramLinkedList, i parami) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(103931);
    if (this.eeA.size() < 25) {}
    for (int i = this.eeA.size();; i = 25)
    {
      ab.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.eeA.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      k.a(this.eeC, 1);
      ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done loopCount is 0");
      AppMethodBeat.o(103931);
      return false;
    }
    if (this.eeA.isEmpty())
    {
      k.a(this.eeC, 1);
      ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
      AppMethodBeat.o(103931);
      return false;
    }
    long l1 = System.currentTimeMillis();
    long l2 = g.RL().eHS.kr(Thread.currentThread().getId());
    int j = 0;
    while (j < i)
    {
      com.tencent.mm.ah.h localh = (com.tencent.mm.ah.h)this.eeA.poll();
      if (localh == null) {
        break;
      }
      this.eeB.b(localh);
      j += 1;
    }
    g.RL().eHS.nY(l2);
    ab.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.eeA.isEmpty())
    {
      k.a(this.eeC, 1);
      ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
      AppMethodBeat.o(103931);
      return false;
    }
    AppMethodBeat.o(103931);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.k.1
 * JD-Core Version:    0.7.0.1
 */