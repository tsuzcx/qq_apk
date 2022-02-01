package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class a
  implements ck.a
{
  public final void a(h.a parama)
  {
    AppMethodBeat.i(12501);
    db localdb = parama.jQG;
    String str1;
    String str2;
    ca localca;
    if (localdb.COi == 10002)
    {
      str1 = z.a(localdb.RIF);
      if (Util.isNullOrNil(str1))
      {
        Log.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(12501);
        return;
      }
      str2 = z.a(localdb.RID);
      localca = ((n)h.ae(n.class)).eSe().aL(str2, localdb.HlH);
      if (localca.field_msgId <= 0L) {
        break label247;
      }
    }
    label247:
    for (int i = 1;; i = 0)
    {
      localca.EG(localdb.HlH);
      localca.setCreateTime(bq.z(str2, localdb.CreateTime));
      localca.setType(10002);
      localca.setContent(str1);
      localca.pJ(0);
      localca.Jm(str2);
      localca.Ip(localdb.RII);
      localca.hAb();
      bq.a(localca, parama);
      if (i == 0)
      {
        bq.z(localca);
        AppMethodBeat.o(12501);
        return;
      }
      ((n)h.ae(n.class)).eSe().b(localdb.HlH, localca);
      AppMethodBeat.o(12501);
      return;
      Log.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(localdb.COi) });
      AppMethodBeat.o(12501);
      return;
    }
  }
  
  public final void a(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.e.a
 * JD-Core Version:    0.7.0.1
 */