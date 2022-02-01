package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.plugin.forcenotify.d.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyReport;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyReport;", "()V", "TAG", "", "_16505", "", "forcePushId", "clickType", "", "clickTime", "", "sessionId", "_16506", "toUsername", "_16507", "noticeState", "msgType", "isFullscreen", "", "_22430", "actType", "username", "msgCount", "plugin-force-notify_release"})
public final class b
  implements a
{
  public static final b BDL;
  
  static
  {
    AppMethodBeat.i(149158);
    BDL = new b();
    AppMethodBeat.o(149158);
  }
  
  public final void C(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149156);
    com.tencent.mm.plugin.report.service.h.IzE.a(16506, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(149156);
  }
  
  public final void D(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149155);
    d locald = new d();
    locald.field_ForcePushId = paramString;
    if (com.tencent.mm.plugin.forcenotify.e.b.BEa.get((IAutoDBItem)locald, new String[0])) {
      f(paramString, String.valueOf(locald.field_CreateTime / 1000L) + locald.field_UserName, paramInt, paramLong);
    }
    AppMethodBeat.o(149155);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(253179);
    p.k(paramString1, "username");
    p.k(paramString2, "forcePushId");
    long l = cm.bfD() / 1000L;
    Log.i("ForceNotifyReport", "report22430 actionTimeMs=" + l + " actType=" + paramInt1 + " msgType=" + paramInt2 + " username=" + paramString1 + " msgCount=" + paramInt3 + " forcePushId=" + paramString2);
    com.tencent.mm.plugin.report.service.h.IzE.a(22430, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), paramString2 });
    AppMethodBeat.o(253179);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(253178);
    p.k(paramString2, "forcePushId");
    int i;
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      long l = cm.bfD() / 1000L;
      Log.i("ForceNotifyReport", "report16507 toUsername=" + paramString1 + ", noticeState=" + paramInt1 + ", receiveTime=" + l + ", msgType=" + paramInt2 + ", forcePushId=" + paramString2 + ", receiveState=" + i);
      com.tencent.mm.plugin.report.service.h.IzE.a(16507, new Object[] { paramString1, Integer.valueOf(paramInt1), Long.valueOf(l), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(i) });
      AppMethodBeat.o(253178);
      return;
      if (!AppForegroundDelegate.fby.aax()) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public final void f(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149154);
    p.k(paramString2, "sessionId");
    if (paramString1 == null) {}
    label206:
    for (;;)
    {
      try
      {
        p.iCn();
        paramString1 = kotlin.n.n.l(paramString1, "@wxcontact", "", false);
        Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
        p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).eSe().aOH(paramString1);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
        p.j(localObject, "msgInfo");
        long l = ((ca)localObject).getCreateTime() / 1000L;
        if (!((ca)localObject).hzz()) {
          if (((ca)localObject).hzx())
          {
            break label206;
            localh.a(16505, new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(i), paramString2, Long.valueOf(paramLong) });
            AppMethodBeat.o(149154);
          }
          else
          {
            i = ((ca)localObject).apA();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.b
 * JD-Core Version:    0.7.0.1
 */