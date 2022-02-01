package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;

public final class a
  implements cc.a
{
  public final void a(f.a parama)
  {
    AppMethodBeat.i(12501);
    cs localcs = parama.fTo;
    String str1;
    String str2;
    bl localbl;
    if (localcs.saz == 10002)
    {
      str1 = z.a(localcs.Cxz);
      if (bt.isNullOrNil(str1))
      {
        ad.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(12501);
        return;
      }
      str2 = z.a(localcs.Cxx);
      localbl = ((k)g.ab(k.class)).cOI().aD(str2, localcs.uKZ);
      if (localbl.field_msgId <= 0L) {
        break label247;
      }
    }
    label247:
    for (int i = 1;; i = 0)
    {
      localbl.kX(localcs.uKZ);
      localbl.kY(bi.y(str2, localcs.CreateTime));
      localbl.setType(10002);
      localbl.setContent(str1);
      localbl.jV(0);
      localbl.nY(str2);
      localbl.mZ(localcs.CxC);
      localbl.eMy();
      bi.a(localbl, parama);
      if (i == 0)
      {
        bi.u(localbl);
        AppMethodBeat.o(12501);
        return;
      }
      ((k)g.ab(k.class)).cOI().b(localcs.uKZ, localbl);
      AppMethodBeat.o(12501);
      return;
      ad.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(localcs.saz) });
      AppMethodBeat.o(12501);
      return;
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.a
 * JD-Core Version:    0.7.0.1
 */