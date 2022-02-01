package com.tencent.mm.plugin.forcenotify.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyReport;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyReport;", "()V", "TAG", "", "_16505", "", "forcePushId", "clickType", "", "clickTime", "", "sessionId", "_16506", "toUsername", "_16507", "noticeState", "receiveTime", "plugin-force-notify_release"})
public final class b
  implements com.tencent.mm.plugin.forcenotify.a.a
{
  public static final b wLO;
  
  static
  {
    AppMethodBeat.i(149158);
    wLO = new b();
    AppMethodBeat.o(149158);
  }
  
  public final void A(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149157);
    h.CyF.a(16507, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(149157);
  }
  
  public final void B(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149156);
    h.CyF.a(16506, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(149156);
  }
  
  public final void C(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149155);
    d locald = new d();
    locald.field_ForcePushId = paramString;
    if (com.tencent.mm.plugin.forcenotify.d.a.wLU.get((IAutoDBItem)locald, new String[0])) {
      f(paramString, String.valueOf(locald.field_CreateTime / 1000L) + locald.field_UserName, paramInt, paramLong);
    }
    AppMethodBeat.o(149155);
  }
  
  public final void f(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149154);
    p.h(paramString2, "sessionId");
    if (paramString1 == null) {}
    label206:
    for (;;)
    {
      try
      {
        p.hyc();
        paramString1 = n.j(paramString1, "@wxcontact", "", false);
        Object localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).eiy().aEx(paramString1);
        h localh = h.CyF;
        p.g(localObject, "msgInfo");
        long l = ((ca)localObject).getCreateTime() / 1000L;
        if (!((ca)localObject).isSystem()) {
          if (((ca)localObject).gDk())
          {
            break label206;
            localh.a(16505, new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(i), paramString2, Long.valueOf(paramLong) });
            AppMethodBeat.o(149154);
          }
          else
          {
            i = ((ca)localObject).ajN();
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
        Log.e("ForceNotifyReport", "[_16505] ".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(149154);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.b
 * JD-Core Version:    0.7.0.1
 */