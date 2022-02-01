package com.tencent.mm.plugin.forcenotify.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyReport;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyReport;", "()V", "TAG", "", "_16505", "", "forcePushId", "clickType", "", "clickTime", "", "sessionId", "_16506", "toUsername", "_16507", "noticeState", "receiveTime", "plugin-force-notify_release"})
public final class b
  implements com.tencent.mm.plugin.forcenotify.a.a
{
  public static final b res;
  
  static
  {
    AppMethodBeat.i(149158);
    res = new b();
    AppMethodBeat.o(149158);
  }
  
  public final void b(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149154);
    d.g.b.k.h(paramString2, "sessionId");
    if (paramString1 == null) {}
    label206:
    for (;;)
    {
      try
      {
        d.g.b.k.fvU();
        paramString1 = n.h(paramString1, "@wxcontact", "", false);
        Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).cOI().agq(paramString1);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
        d.g.b.k.g(localObject, "msgInfo");
        long l = ((bl)localObject).getCreateTime() / 1000L;
        if (!((bl)localObject).isSystem()) {
          if (((bl)localObject).eLW())
          {
            break label206;
            localh.f(16505, new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(i), paramString2, Long.valueOf(paramLong) });
            AppMethodBeat.o(149154);
          }
          else
          {
            i = ((bl)localObject).SH();
            if (i == 1)
            {
              i = 1;
              continue;
            }
            i = 2;
            continue;
          }
        }
        int i = 0;
      }
      catch (Exception paramString1)
      {
        ad.e("ForceNotifyReport", "[_16505] ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(149154);
        return;
      }
    }
  }
  
  public final void g(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149157);
    com.tencent.mm.plugin.report.service.h.vKh.f(16507, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(149157);
  }
  
  public final void h(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149156);
    com.tencent.mm.plugin.report.service.h.vKh.f(16506, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(149156);
  }
  
  public final void i(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149155);
    d locald = new d();
    locald.field_ForcePushId = paramString;
    if (com.tencent.mm.plugin.forcenotify.d.a.rez.get((c)locald, new String[0])) {
      b(paramString, String.valueOf(locald.field_CreateTime / 1000L) + locald.field_UserName, paramInt, paramLong);
    }
    AppMethodBeat.o(149155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.b
 * JD-Core Version:    0.7.0.1
 */