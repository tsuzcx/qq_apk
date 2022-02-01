package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public final class a
  implements cc.a
{
  public final void a(f.a parama)
  {
    AppMethodBeat.i(12501);
    cu localcu = parama.fXi;
    String str1;
    String str2;
    bo localbo;
    if (localcu.tit == 10002)
    {
      str1 = z.a(localcu.DPV);
      if (bs.isNullOrNil(str1))
      {
        ac.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(12501);
        return;
      }
      str2 = z.a(localcu.DPT);
      localbo = ((k)g.ab(k.class)).dcr().aF(str2, localcu.vTQ);
      if (localbo.field_msgId <= 0L) {
        break label247;
      }
    }
    label247:
    for (int i = 1;; i = 0)
    {
      localbo.oz(localcu.vTQ);
      localbo.oA(bi.z(str2, localcu.CreateTime));
      localbo.setType(10002);
      localbo.setContent(str1);
      localbo.jT(0);
      localbo.re(str2);
      localbo.qf(localcu.DPY);
      localbo.fcd();
      bi.a(localbo, parama);
      if (i == 0)
      {
        bi.u(localbo);
        AppMethodBeat.o(12501);
        return;
      }
      ((k)g.ab(k.class)).dcr().b(localcu.vTQ, localbo);
      AppMethodBeat.o(12501);
      return;
      ac.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(localcu.tit) });
      AppMethodBeat.o(12501);
      return;
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.a
 * JD-Core Version:    0.7.0.1
 */