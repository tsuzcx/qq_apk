package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Stack;

final class e$4
  implements MTimerHandler.CallBack
{
  private long lAr = 0L;
  
  e$4(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(292877);
    long l = System.currentTimeMillis();
    if ((e.c(this.lAp)) && (l - this.lAr > 60000L))
    {
      Log.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", new Object[] { Long.valueOf(l - this.lAr) });
      e.a(this.lAp, false);
    }
    if (e.c(this.lAp))
    {
      e.d(this.lAp).startTimer(1000L);
      AppMethodBeat.o(292877);
      return false;
    }
    this.lAr = l;
    e.a(this.lAp, true);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while ((i < 5) && (e.e(this.lAp).size() > 0))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(138L, 42L, 1L, true);
      localLinkedList.add(new eaf().btQ(Util.nullAsNil(((j)e.e(this.lAp).pop()).getUsername())));
      i += 1;
    }
    com.tencent.mm.kernel.h.aGY().a(new l(localLinkedList), 0);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(138L, 44L, 1L, true);
    AppMethodBeat.o(292877);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.am.e.4
 * JD-Core Version:    0.7.0.1
 */