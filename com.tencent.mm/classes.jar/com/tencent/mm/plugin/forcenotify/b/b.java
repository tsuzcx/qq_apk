package com.tencent.mm.plugin.forcenotify.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import d.g.b.p;
import d.n.n;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyReport;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyReport;", "()V", "TAG", "", "_16505", "", "forcePushId", "clickType", "", "clickTime", "", "sessionId", "_16506", "toUsername", "_16507", "noticeState", "receiveTime", "plugin-force-notify_release"})
public final class b
  implements com.tencent.mm.plugin.forcenotify.a.a
{
  public static final b tjP;
  
  static
  {
    AppMethodBeat.i(149158);
    tjP = new b();
    AppMethodBeat.o(149158);
  }
  
  public final void C(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149157);
    com.tencent.mm.plugin.report.service.g.yhR.f(16507, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(149157);
  }
  
  public final void D(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149156);
    com.tencent.mm.plugin.report.service.g.yhR.f(16506, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(149156);
  }
  
  public final void E(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149155);
    d locald = new d();
    locald.field_ForcePushId = paramString;
    if (com.tencent.mm.plugin.forcenotify.d.a.tjV.get((c)locald, new String[0])) {
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
        p.gfZ();
        paramString1 = n.h(paramString1, "@wxcontact", "", false);
        Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).dlK().apX(paramString1);
        com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
        p.g(localObject, "msgInfo");
        long l = ((bu)localObject).getCreateTime() / 1000L;
        if (!((bu)localObject).isSystem()) {
          if (((bu)localObject).frD())
          {
            break label206;
            localg.f(16505, new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(i), paramString2, Long.valueOf(paramLong) });
            AppMethodBeat.o(149154);
          }
          else
          {
            i = ((bu)localObject).VR();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.b.b
 * JD-Core Version:    0.7.0.1
 */