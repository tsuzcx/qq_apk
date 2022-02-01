package com.tencent.mm.chatroom.d;

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

final class n$2
  implements av.a
{
  n$2(n paramn, LinkedList paramLinkedList, bg parambg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(12477);
    if (this.foZ.size() < 25) {}
    for (int i = this.foZ.size();; i = 25)
    {
      ad.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg list size:%d, loopCount:%d", new Object[] { Integer.valueOf(this.foZ.size()), Integer.valueOf(i) });
      if (i != 0) {
        break;
      }
      n.a(this.foY, 2);
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done loopCount is 0");
      AppMethodBeat.o(12477);
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
    ad.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg loopCount:%d, take time:%d(ms)", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1) });
    if (this.foZ.isEmpty())
    {
      n.a(this.foY, 2);
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done updateList is empty");
      AppMethodBeat.o(12477);
      return false;
    }
    AppMethodBeat.o(12477);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.n.2
 * JD-Core Version:    0.7.0.1
 */