package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class a
  implements cj.a
{
  public final void a(h.a parama)
  {
    AppMethodBeat.i(12501);
    de localde = parama.heO;
    String str1;
    String str2;
    ca localca;
    if (localde.xKb == 10002)
    {
      str1 = z.a(localde.KHn);
      if (Util.isNullOrNil(str1))
      {
        Log.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(12501);
        return;
      }
      str2 = z.a(localde.KHl);
      localca = ((l)g.af(l.class)).eiy().aJ(str2, localde.Brn);
      if (localca.field_msgId <= 0L) {
        break label247;
      }
    }
    label247:
    for (int i = 1;; i = 0)
    {
      localca.yF(localde.Brn);
      localca.setCreateTime(bp.C(str2, localde.CreateTime));
      localca.setType(10002);
      localca.setContent(str1);
      localca.nv(0);
      localca.Cy(str2);
      localca.BB(localde.KHq);
      localca.gDN();
      bp.a(localca, parama);
      if (i == 0)
      {
        bp.x(localca);
        AppMethodBeat.o(12501);
        return;
      }
      ((l)g.af(l.class)).eiy().b(localde.Brn, localca);
      AppMethodBeat.o(12501);
      return;
      Log.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(localde.xKb) });
      AppMethodBeat.o(12501);
      return;
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.a
 * JD-Core Version:    0.7.0.1
 */