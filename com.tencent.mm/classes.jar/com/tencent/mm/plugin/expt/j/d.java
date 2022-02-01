package com.tencent.mm.plugin.expt.j;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;

public final class d
  implements b
{
  private final String TAG = "MicroMsg.TargetStartServiceSingleton";
  
  public final void axE()
  {
    AppMethodBeat.i(220649);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYh, -1);
    Object localObject1;
    Object localObject2;
    if (!Util.isEqual(i, 0)) {
      if (Util.isEqual(i, 2))
      {
        localObject1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYl, "");
        Log.i("MicroMsg.TargetStartServiceSingleton", "manufacturers:%s", new Object[] { Util.nullAs((String)localObject1, "null") });
        if (Util.isNullOrNil((String)localObject1))
        {
          c.dg(true);
          i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYn, 0);
          if ((!com.tencent.mm.compatible.util.d.oD(26)) || (!Util.isEqual(i, 0)) || (!Huawei.ifHUAWEI())) {
            break label459;
          }
          localObject2 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYo, "");
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
            c.nP(1);
            i = 1;
            if (i == 0) {
              c.nP(0);
            }
            AppMethodBeat.o(220649);
            return;
            localObject1 = ((String)localObject1).split(",");
            i = 0;
            if (i >= localObject1.length) {
              break label479;
            }
            if (String.valueOf(localObject1[i]).equalsIgnoreCase(Build.MANUFACTURER))
            {
              c.dg(false);
              i = 1;
              if (i != 0) {
                break;
              }
              c.dg(true);
              break;
            }
            i += 1;
            continue;
            if (!Util.isEqual(i, 1)) {
              break;
            }
            localObject1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYi, "");
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
                c.dg(true);
                i = 1;
                if (i != 0) {
                  break;
                }
                c.dg(false);
                break;
              }
              i += 1;
              continue;
            }
            c.dg(false);
            break;
          }
          i += 1;
          continue;
        }
        c.nP(0);
        AppMethodBeat.o(220649);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.TargetStartServiceSingleton", "startServiceHuaweiInfo Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        c.nP(0);
        AppMethodBeat.o(220649);
        return;
      }
      label459:
      c.nP(1);
      AppMethodBeat.o(220649);
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
 * Qualified Name:     com.tencent.mm.plugin.expt.j.d
 * JD-Core Version:    0.7.0.1
 */