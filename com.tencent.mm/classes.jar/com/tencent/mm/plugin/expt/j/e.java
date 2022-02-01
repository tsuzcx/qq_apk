package com.tencent.mm.plugin.expt.j;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;

public final class e
  implements b
{
  private final String TAG = "MicroMsg.TargetStartServiceSingleton";
  
  public final void aEW()
  {
    AppMethodBeat.i(256619);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEX, -1);
    Object localObject1;
    Object localObject2;
    if (!Util.isEqual(i, 0)) {
      if (Util.isEqual(i, 2))
      {
        localObject1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFe, "");
        Log.i("MicroMsg.TargetStartServiceSingleton", "manufacturers:%s", new Object[] { Util.nullAs((String)localObject1, "null") });
        if (Util.isNullOrNil((String)localObject1))
        {
          c.dG(true);
          i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFg, 0);
          if ((!d.qV(26)) || (!Util.isEqual(i, 0)) || (!Huawei.ifOnlyHUAWEI())) {
            break label459;
          }
          localObject2 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFh, "");
          localObject1 = Build.MODEL.toLowerCase();
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
            c.qe(1);
            i = 1;
            if (i == 0) {
              c.qe(0);
            }
            AppMethodBeat.o(256619);
            return;
            localObject1 = ((String)localObject1).split(",");
            i = 0;
            if (i >= localObject1.length) {
              break label479;
            }
            if (String.valueOf(localObject1[i]).equalsIgnoreCase(Build.MANUFACTURER))
            {
              c.dG(false);
              i = 1;
              if (i != 0) {
                break;
              }
              c.dG(true);
              break;
            }
            i += 1;
            continue;
            if (!Util.isEqual(i, 1)) {
              break;
            }
            localObject1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEY, "");
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
                c.dG(true);
                i = 1;
                if (i != 0) {
                  break;
                }
                c.dG(false);
                break;
              }
              i += 1;
              continue;
            }
            c.dG(false);
            break;
          }
          i += 1;
          continue;
        }
        c.qe(0);
        AppMethodBeat.o(256619);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.TargetStartServiceSingleton", "startServiceHuaweiInfo Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        c.qe(0);
        AppMethodBeat.o(256619);
        return;
      }
      label459:
      c.qe(1);
      AppMethodBeat.o(256619);
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
 * Qualified Name:     com.tencent.mm.plugin.expt.j.e
 * JD-Core Version:    0.7.0.1
 */