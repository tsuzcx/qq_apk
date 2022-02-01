package com.tencent.mm.plugin.forcenotify.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyReport;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyReport;", "()V", "TAG", "", "_16505", "", "forcePushId", "clickType", "", "clickTime", "", "sessionId", "_16506", "toUsername", "_16507", "noticeState", "msgType", "isFullscreen", "", "_22430", "actType", "username", "msgCount", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  public static final b Hob;
  
  static
  {
    AppMethodBeat.i(149158);
    Hob = new b();
    AppMethodBeat.o(149158);
  }
  
  public final void D(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149156);
    com.tencent.mm.plugin.report.service.h.OAn.b(16506, new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(149156);
  }
  
  public final void E(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149155);
    com.tencent.mm.plugin.forcenotify.c.h localh = new com.tencent.mm.plugin.forcenotify.c.h();
    localh.field_ForcePushId = paramString;
    if (com.tencent.mm.plugin.forcenotify.d.b.Hoz.get((IAutoDBItem)localh, new String[0])) {
      f(paramString, localh.field_CreateTime / 1000L + localh.field_UserName, paramInt, paramLong);
    }
    AppMethodBeat.o(149155);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(274918);
    s.u(paramString2, "forcePushId");
    int i;
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      long l = cn.bDv() / 1000L;
      Log.i("ForceNotifyReport", "report16507 toUsername=" + paramString1 + ", noticeState=" + paramInt1 + ", receiveTime=" + l + ", msgType=" + paramInt2 + ", forcePushId=" + paramString2 + ", receiveState=" + i);
      com.tencent.mm.plugin.report.service.h.OAn.b(16507, new Object[] { paramString1, Integer.valueOf(paramInt1), Long.valueOf(l), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(i) });
      AppMethodBeat.o(274918);
      return;
      if (!AppForegroundDelegate.heY.eLx) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public final void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(274925);
    s.u(paramString1, "username");
    s.u(paramString2, "forcePushId");
    long l = cn.bDv() / 1000L;
    Log.i("ForceNotifyReport", "report22430 actionTimeMs=" + l + " actType=1 msgType=" + paramInt1 + " username=" + paramString1 + " msgCount=" + paramInt2 + " forcePushId=" + paramString2);
    com.tencent.mm.plugin.report.service.h.OAn.b(22430, new Object[] { Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), paramString2 });
    AppMethodBeat.o(274925);
  }
  
  public final void f(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149154);
    s.u(paramString2, "sessionId");
    label182:
    for (;;)
    {
      try
      {
        s.checkNotNull(paramString1);
        paramString1 = kotlin.n.n.m(paramString1, "@wxcontact", "", false);
        cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLG(paramString1);
        com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
        long l = localcc.getCreateTime() / 1000L;
        if (!localcc.jbD()) {
          if (localcc.jbA())
          {
            break label182;
            localh.b(16505, new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(l), Integer.valueOf(i), paramString2, Long.valueOf(paramLong) });
            AppMethodBeat.o(149154);
          }
          else
          {
            i = localcc.field_isSend;
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
        Log.e("ForceNotifyReport", s.X("[_16505] ", paramString1));
        AppMethodBeat.o(149154);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.core.b
 * JD-Core Version:    0.7.0.1
 */