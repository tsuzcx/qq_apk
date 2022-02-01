package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;

final class n$1
  implements av.a
{
  n$1(n paramn, LinkedList paramLinkedList, j paramj) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(12476);
    if (this.foW.size() < 25) {}
    for (int i = this.foW.size();; i = 25)
    {
      ad.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.foW.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      n.a(this.foY, 1);
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done loopCount is 0");
      AppMethodBeat.o(12476);
      return false;
    }
    if (this.foW.isEmpty())
    {
      n.a(this.foY, 1);
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
      AppMethodBeat.o(12476);
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
    ad.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.foW.isEmpty())
    {
      n.a(this.foY, 1);
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
      AppMethodBeat.o(12476);
      return false;
    }
    AppMethodBeat.o(12476);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.n.1
 * JD-Core Version:    0.7.0.1
 */