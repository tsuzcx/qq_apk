package com.tencent.mm.modelrecovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.recoveryv2.h.c;
import com.tencent.mm.recoveryv2.i;
import com.tencent.mm.recoveryv2.l.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.File;

final class PluginRecovery$1
  implements Runnable
{
  PluginRecovery$1(PluginRecovery paramPluginRecovery, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(193120);
    Object localObject = this.cTI.ca;
    ad.i("MicroMsg.recovery.reporter", "do recovery report");
    localObject = i.hR((Context)localObject);
    if (((i)localObject).HUs)
    {
      ad.i("MicroMsg.recovery.reporter", "not thing to report");
      h.c localc = h.c.hQ(this.cTI.ca);
      localc.fhj();
      String str = localc.fhk();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "nothing";
      }
      ad.i("MicroMsg.recovery.reporter", ">>>>>>>>>> dump recovery internal log: <<<<<<<<<<");
      ad.i("MicroMsg.recovery.reporter", "\n".concat(String.valueOf(localObject)));
      ad.i("MicroMsg.recovery.reporter", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<");
      l.b.L(new File(localc.HUn));
      AppMethodBeat.o(193120);
      return;
    }
    int i = ((i)localObject).HTW;
    ad.i("MicroMsg.recovery.reporter", "report crash count = ".concat(String.valueOf(i)));
    label203:
    label359:
    long l;
    if ((i > 0) && (i <= 20))
    {
      e.ygI.idkeyStat(1341L, i + 200, 1L, false);
      if (i >= 5) {
        e.ygI.idkeyStat(1341L, i + 220, 1L, false);
      }
      boolean bool = ((i)localObject).HUo;
      ad.i("MicroMsg.recovery.reporter", "report recovery ui launch, result = ".concat(String.valueOf(bool)));
      if (bool) {
        e.ygI.idkeyStat(1341L, 100L, 1L, false);
      }
      bool = ((i)localObject).HUp;
      ad.i("MicroMsg.recovery.reporter", "report recovery ui launch real, result = ".concat(String.valueOf(bool)));
      if (bool) {
        e.ygI.idkeyStat(1341L, 102L, 1L, false);
      }
      bool = ((i)localObject).HUq;
      ad.i("MicroMsg.recovery.reporter", "report if recover from crash, result = ".concat(String.valueOf(bool)));
      if (bool) {
        e.ygI.idkeyStat(1341L, 101L, 1L, false);
      }
      i = ((i)localObject).HUr;
      ad.i("MicroMsg.recovery.reporter", "recovery status = ".concat(String.valueOf(i)));
      if (i >= 0)
      {
        if (i != 0) {
          break label601;
        }
        e.ygI.idkeyStat(1341L, 103L, 1L, false);
      }
      i = ((i)localObject).mFrom;
      ad.i("MicroMsg.recovery.reporter", "recovery from = ".concat(String.valueOf(i)));
      if ((i >= 0) && (i < 10)) {
        e.ygI.idkeyStat(1341L, i + 140, 1L, false);
      }
      i = ((i)localObject).HUt;
      ad.i("MicroMsg.recovery.reporter", "recovery internalStatus = ".concat(String.valueOf(i)));
      if ((i >= 0) && (i < 10)) {
        e.ygI.idkeyStat(1341L, i + 150, 1L, false);
      }
      l = ((i)localObject).HUu;
      if (l <= 0L) {
        break label782;
      }
      if (l > 10000L) {
        break label634;
      }
      i = 0;
    }
    for (;;)
    {
      if (i >= 0) {
        e.ygI.idkeyStat(1341L, i + 160, 1L, false);
      }
      ((i)localObject).HTW = 0;
      ((i)localObject).HUo = false;
      ((i)localObject).HUp = false;
      ((i)localObject).HUq = false;
      ((i)localObject).HUr = -1;
      ((i)localObject).mFrom = 0;
      ((i)localObject).HUt = 0;
      ((i)localObject).HUu = 0L;
      ((i)localObject).HUs = false;
      ((i)localObject).HUs = true;
      ((i)localObject).save();
      break;
      if (i <= 20) {
        break label203;
      }
      ad.w("MicroMsg.recovery.reporter", "abnormal crash count found, num = ".concat(String.valueOf(i)));
      e.ygI.idkeyStat(1341L, 105L, 1L, false);
      break label203;
      label601:
      e.ygI.idkeyStat(1341L, 104L, 1L, false);
      e.ygI.idkeyStat(1341L, i + 110, 1L, false);
      break label359;
      label634:
      if (l <= 60000L)
      {
        l /= 10000L;
        if ((l >= 1L) && (l <= 6L)) {
          i = (int)(l + 0L);
        }
      }
      else if (l <= 600000L)
      {
        l /= 60000L;
        if ((l >= 1L) && (l <= 10L)) {
          i = (int)(l + 6L);
        }
      }
      else if (l <= 3600000L)
      {
        l /= 600000L;
        if ((l >= 1L) && (l <= 6L)) {
          i = (int)(l + 16L);
        }
      }
      else
      {
        l /= 3600000L;
        if (l >= 1L)
        {
          if (l <= 6L)
          {
            i = (int)(l + 22L);
            continue;
          }
          i = 29;
          continue;
        }
      }
      label782:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.1
 * JD-Core Version:    0.7.0.1
 */