package com.tencent.mm.plugin.expt.trigger;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;

public final class f
  implements b
{
  private final String TAG = "MicroMsg.TargetStartServiceSingleton";
  
  public final void aXY()
  {
    AppMethodBeat.i(299421);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUu, -1);
    Object localObject1;
    Object localObject2;
    if (!Util.isEqual(i, 0)) {
      if (Util.isEqual(i, 2))
      {
        localObject1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUC, "");
        Log.i("MicroMsg.TargetStartServiceSingleton", "manufacturers:%s", new Object[] { Util.nullAs((String)localObject1, "null") });
        if (Util.isNullOrNil((String)localObject1))
        {
          com.tencent.mm.booter.c.es(true);
          i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUE, 0);
          if ((!d.rb(26)) || (!Util.isEqual(i, 0)) || (!Huawei.ifOnlyHUAWEI())) {
            break label459;
          }
          localObject2 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUF, "");
          localObject1 = q.aPo().toLowerCase();
          Log.i("MicroMsg.TargetStartServiceSingleton", "model:%s startServiceHuaweiInfo:%s", new Object[] { localObject1, Util.nullAs((String)localObject2, "null") });
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject2 = ((String)localObject2).split(",");
          i = 0;
          if (i >= localObject2.length) {
            break label469;
          }
          if (((String)localObject1).startsWith(localObject2[i].toLowerCase()))
          {
            com.tencent.mm.booter.c.qe(1);
            i = 1;
            if (i == 0) {
              com.tencent.mm.booter.c.qe(0);
            }
            AppMethodBeat.o(299421);
            return;
            localObject1 = ((String)localObject1).split(",");
            i = 0;
            if (i >= localObject1.length) {
              break label479;
            }
            if (String.valueOf(localObject1[i]).equalsIgnoreCase(Build.MANUFACTURER))
            {
              com.tencent.mm.booter.c.es(false);
              i = 1;
              if (i != 0) {
                break;
              }
              com.tencent.mm.booter.c.es(true);
              break;
            }
            i += 1;
            continue;
            if (!Util.isEqual(i, 1)) {
              break;
            }
            localObject1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUv, "");
            Log.i("MicroMsg.TargetStartServiceSingleton", "manufacturers:%s", new Object[] { Util.nullAs((String)localObject1, "null") });
            if (!Util.isNullOrNil((String)localObject1))
            {
              localObject1 = ((String)localObject1).split(",");
              i = 0;
              if (i >= localObject1.length) {
                break label474;
              }
              if (String.valueOf(localObject1[i]).equalsIgnoreCase(Build.MANUFACTURER))
              {
                com.tencent.mm.booter.c.es(true);
                i = 1;
                if (i != 0) {
                  break;
                }
                com.tencent.mm.booter.c.es(false);
                break;
              }
              i += 1;
              continue;
            }
            com.tencent.mm.booter.c.es(false);
            break;
          }
          i += 1;
          continue;
        }
        com.tencent.mm.booter.c.qe(0);
        AppMethodBeat.o(299421);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.TargetStartServiceSingleton", "startServiceHuaweiInfo Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        com.tencent.mm.booter.c.qe(0);
        AppMethodBeat.o(299421);
        return;
      }
      label459:
      com.tencent.mm.booter.c.qe(1);
      AppMethodBeat.o(299421);
      return;
      label469:
      i = 0;
      continue;
      label474:
      i = 0;
      continue;
      label479:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.trigger.f
 * JD-Core Version:    0.7.0.1
 */