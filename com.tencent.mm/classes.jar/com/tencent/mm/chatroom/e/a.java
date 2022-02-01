package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

public final class a
  implements cl.a
{
  public final void a(g.a parama)
  {
    AppMethodBeat.i(12501);
    dl localdl = parama.mpN;
    String str1;
    String str2;
    cc localcc;
    if (localdl.IIs == 10002)
    {
      str1 = w.a(localdl.YFG);
      if (Util.isNullOrNil(str1))
      {
        Log.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(12501);
        return;
      }
      str2 = w.a(localdl.YFE);
      localcc = ((n)h.ax(n.class)).gaZ().aU(str2, localdl.Njv);
      if (localcc.field_msgId <= 0L) {
        break label247;
      }
    }
    label247:
    for (int i = 1;; i = 0)
    {
      localcc.gX(localdl.Njv);
      localcc.setCreateTime(br.D(str2, localdl.CreateTime));
      localcc.setType(10002);
      localcc.setContent(str1);
      localcc.pI(0);
      localcc.BS(str2);
      localcc.AU(localdl.YFJ);
      localcc.jcf();
      br.a(localcc, parama);
      if (i == 0)
      {
        br.B(localcc);
        AppMethodBeat.o(12501);
        return;
      }
      ((n)h.ax(n.class)).gaZ().b(localdl.Njv, localcc);
      AppMethodBeat.o(12501);
      return;
      Log.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(localdl.IIs) });
      AppMethodBeat.o(12501);
      return;
    }
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.a
 * JD-Core Version:    0.7.0.1
 */