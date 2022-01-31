package com.tencent.mm.plugin.forcenotify.b;

import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.storage.bi;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyReport;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyReport;", "()V", "_16505", "", "forcePushId", "", "clickType", "", "clickTime", "", "sessionId", "_16506", "toUsername", "_16507", "noticeState", "receiveTime", "plugin-force-notify_release"})
public final class b
  implements com.tencent.mm.plugin.forcenotify.a.a
{
  public static final b mHq;
  
  static
  {
    AppMethodBeat.i(51035);
    mHq = new b();
    AppMethodBeat.o(51035);
  }
  
  public final void b(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(51031);
    a.f.b.j.q(paramString2, "sessionId");
    if (paramString1 == null) {
      a.f.b.j.ebi();
    }
    String str = m.h(paramString1, "@wxcontact", "", false);
    paramString1 = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(paramString1, "MMKernel.service(IMessengerStorage::class.java)");
    bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramString1).bPQ().Tm(str);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    long l;
    int i;
    if (localbi != null)
    {
      paramString1 = Long.valueOf(localbi.HC());
      if (paramString1 == null) {
        a.f.b.j.ebi();
      }
      l = paramString1.longValue() / 1000L;
      if ((!localbi.isSystem()) && (!localbi.dxQ())) {
        break label178;
      }
      i = 0;
    }
    for (;;)
    {
      localh.e(16505, new Object[] { str, Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(i), paramString2, Long.valueOf(paramLong) });
      AppMethodBeat.o(51031);
      return;
      paramString1 = null;
      break;
      label178:
      if ((localbi != null) && (localbi.HB() == 1)) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final void f(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(51034);
    com.tencent.mm.plugin.report.service.h.qsU.e(16507, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(51034);
  }
  
  public final void g(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(51033);
    com.tencent.mm.plugin.report.service.h.qsU.e(16506, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(51033);
  }
  
  public final void h(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(51032);
    d locald = new d();
    locald.field_ForcePushId = paramString;
    if (com.tencent.mm.plugin.forcenotify.d.a.mHw.get((c)locald, new String[0])) {
      b(paramString, String.valueOf(locald.field_CreateTime / 1000L) + locald.field_UserName, paramInt, paramLong);
    }
    AppMethodBeat.o(51032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.b
 * JD-Core Version:    0.7.0.1
 */