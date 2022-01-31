package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Stack;

final class c$3
  implements ap.a
{
  private long frA = 0L;
  
  c$3(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(77853);
    long l = System.currentTimeMillis();
    if ((this.fry.frp) && (l - this.frA > 60000L))
    {
      ab.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", new Object[] { Long.valueOf(l - this.frA) });
      this.fry.frp = false;
    }
    if (this.fry.frp)
    {
      this.fry.frx.ag(1000L, 1000L);
      AppMethodBeat.o(77853);
      return false;
    }
    this.frA = l;
    this.fry.frp = true;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while ((i < 5) && (this.fry.frs.size() > 0))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 42L, 1L, true);
      localLinkedList.add(new bwc().aoF(bo.nullAsNil(((h)this.fry.frs.pop()).getUsername())));
      i += 1;
    }
    g.Rc().a(new j(localLinkedList), 0);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(138L, 44L, 1L, true);
    AppMethodBeat.o(77853);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ah.c.3
 * JD-Core Version:    0.7.0.1
 */