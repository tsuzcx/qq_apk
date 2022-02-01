package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class a
  implements cd.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(12501);
    cv localcv = parama.gqE;
    String str1;
    String str2;
    bu localbu;
    if (localcv.ugm == 10002)
    {
      str1 = z.a(localcv.Fvk);
      if (bt.isNullOrNil(str1))
      {
        ad.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(12501);
        return;
      }
      str2 = z.a(localcv.Fvi);
      localbu = ((l)g.ab(l.class)).dlK().aI(str2, localcv.xbt);
      if (localbu.field_msgId <= 0L) {
        break label247;
      }
    }
    label247:
    for (int i = 1;; i = 0)
    {
      localbu.qz(localcv.xbt);
      localbu.qA(bj.B(str2, localcv.CreateTime));
      localbu.setType(10002);
      localbu.setContent(str1);
      localbu.kr(0);
      localbu.tN(str2);
      localbu.sP(localcv.Fvn);
      localbu.fsg();
      bj.a(localbu, parama);
      if (i == 0)
      {
        bj.v(localbu);
        AppMethodBeat.o(12501);
        return;
      }
      ((l)g.ab(l.class)).dlK().b(localcv.xbt, localbu);
      AppMethodBeat.o(12501);
      return;
      ad.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(localcv.ugm) });
      AppMethodBeat.o(12501);
      return;
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.a
 * JD-Core Version:    0.7.0.1
 */