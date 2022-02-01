package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public final class a
  implements cf.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(12501);
    cv localcv = parama.gte;
    String str1;
    String str2;
    bv localbv;
    if (localcv.urJ == 10002)
    {
      str1 = z.a(localcv.FNI);
      if (bu.isNullOrNil(str1))
      {
        ae.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(12501);
        return;
      }
      str2 = z.a(localcv.FNG);
      localbv = ((l)g.ab(l.class)).doJ().aJ(str2, localcv.xrk);
      if (localbv.field_msgId <= 0L) {
        break label247;
      }
    }
    label247:
    for (int i = 1;; i = 0)
    {
      localbv.qM(localcv.xrk);
      localbv.qN(bl.B(str2, localcv.CreateTime));
      localbv.setType(10002);
      localbv.setContent(str1);
      localbv.kt(0);
      localbv.ui(str2);
      localbv.tk(localcv.FNL);
      localbv.fwh();
      bl.a(localbv, parama);
      if (i == 0)
      {
        bl.v(localbv);
        AppMethodBeat.o(12501);
        return;
      }
      ((l)g.ab(l.class)).doJ().b(localcv.xrk, localbv);
      AppMethodBeat.o(12501);
      return;
      ae.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(localcv.urJ) });
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