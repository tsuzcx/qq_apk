package com.tencent.mm.chatroom.d;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class a
  implements bx.a
{
  public final void a(e.a parama)
  {
    cd localcd = parama.dBs;
    String str1;
    String str2;
    bi localbi;
    if (localcd.kSW == 10002)
    {
      str1 = aa.a(localcd.svH);
      if (bk.bl(str1))
      {
        y.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
        return;
      }
      str2 = aa.a(localcd.svF);
      localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().O(str2, localcd.ndp);
      if (localbi.field_msgId <= 0L) {
        break label226;
      }
    }
    label226:
    for (int i = 1;; i = 0)
    {
      localbi.bf(localcd.ndp);
      localbi.bg(bd.o(str2, localcd.mPL));
      localbi.setType(10002);
      localbi.setContent(str1);
      localbi.fA(0);
      localbi.ec(str2);
      localbi.cY(localcd.svK);
      localbi.ff(localbi.czq & 0xFFFFFF7F);
      bd.a(localbi, parama);
      if (i == 0)
      {
        bd.h(localbi);
        return;
      }
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().b(localcd.ndp, localbi);
      return;
      y.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[] { Integer.valueOf(localcd.kSW) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.a
 * JD-Core Version:    0.7.0.1
 */