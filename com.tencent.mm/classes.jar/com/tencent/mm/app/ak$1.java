package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.xwebutil.c;
import java.util.Iterator;
import java.util.List;

final class ak$1
  implements MTimerHandler.CallBack
{
  ak$1(ak paramak) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19480);
    Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired");
    label126:
    long l;
    try
    {
      i = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().hx("clicfg_tools_and_mp_release_use_delegate", "1"), 1);
      if (i == 1)
      {
        if (!AppForegroundDelegate.heY.eLx) {
          break label126;
        }
        Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, AppForeground");
        AppMethodBeat.o(19480);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "get clicfg_tools_and_mp_release_use_delegate error!");
        Log.printErrStackTrace("MicroMsg.TempAppForegroundNotifyDeprecated", localException, "", new Object[0]);
        i = 1;
      }
      localObject = Util.getTopActivityName(MMApplicationContext.getContext());
      if ((localObject != null) && (((String)localObject).toLowerCase().startsWith(MMApplicationContext.getSourcePackageName())))
      {
        Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, top activity belongs to mm, skip kill tools");
        AppMethodBeat.o(19480);
        return false;
      }
      l = System.currentTimeMillis();
      localObject = ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class)).getTaskInfoByType(2);
      if (localObject == null) {
        break label440;
      }
    }
    Object localObject = ((List)localObject).iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((MultiTaskInfo)((Iterator)localObject).next()).field_createTime - l > 1800000L);
    label440:
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "ToolsProfile.ToolsProcessLocker.isLockedUsedByOtherProcess():" + ToolsProfile.a.aDn());
      boolean bool = ToolsProfile.a.aDn();
      if ((!bool) && (i == 0))
      {
        Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, kill tools process");
        c.bFh("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        ak.a(this.hiO);
        ak.b(this.hiO);
        Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "sameLevelReleaseCnt:%d    lastReleaseTime:%d    level:%d", new Object[] { Integer.valueOf(ak.c(this.hiO)), Long.valueOf(ak.d(this.hiO)), Integer.valueOf(ak.e(this.hiO)) });
        if ((l - ak.d(this.hiO) <= 2L * ak.f(this.hiO)) && (ak.c(this.hiO) >= 2))
        {
          ak.g(this.hiO);
          ak.h(this.hiO);
          Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "level up, now:%d", new Object[] { Integer.valueOf(ak.e(this.hiO)) });
        }
        ak.a(this.hiO, l);
      }
      for (;;)
      {
        AppMethodBeat.o(19480);
        return false;
        if (bool) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1686L, 13L, 1L, false);
        }
        if (i != 0) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1686L, 12L, 1L, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.ak.1
 * JD-Core Version:    0.7.0.1
 */