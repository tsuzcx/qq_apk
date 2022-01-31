package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class a
  implements bz.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(103956);
    cm localcm = parama.eyJ;
    String str1;
    String str2;
    bi localbi;
    if (localcm.nqW == 10002)
    {
      str1 = aa.a(localcm.woR);
      if (bo.isNullOrNil(str1))
      {
        ab.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(103956);
        return;
      }
      str2 = aa.a(localcm.woP);
      localbi = ((j)g.E(j.class)).bPQ().ag(str2, localcm.pIG);
      if (localbi.field_msgId <= 0L) {
        break label242;
      }
    }
    label242:
    for (int i = 1;; i = 0)
    {
      localbi.fP(localcm.pIG);
      localbi.fQ(bf.x(str2, localcm.CreateTime));
      localbi.setType(10002);
      localbi.setContent(str1);
      localbi.hL(0);
      localbi.kj(str2);
      localbi.jl(localcm.woU);
      localbi.dym();
      bf.a(localbi, parama);
      if (i == 0)
      {
        bf.l(localbi);
        AppMethodBeat.o(103956);
        return;
      }
      ((j)g.E(j.class)).bPQ().b(localcm.pIG, localbi);
      AppMethodBeat.o(103956);
      return;
      ab.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(localcm.nqW) });
      AppMethodBeat.o(103956);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.a
 * JD-Core Version:    0.7.0.1
 */