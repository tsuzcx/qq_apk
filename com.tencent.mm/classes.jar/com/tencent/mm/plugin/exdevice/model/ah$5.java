package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ah$5
  implements Runnable
{
  ah$5(ah paramah) {}
  
  public final void run()
  {
    AppMethodBeat.i(274591);
    boolean bool1 = MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
    boolean bool2 = MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
    if ((bool1) && (bool2)) {
      h.OAn.b(11891, "3", true, true);
    }
    for (;;)
    {
      Log.i("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] deviceFeatures stepCounter %s, stepDetector %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(274591);
      return;
      if (bool1) {
        h.OAn.b(11891, "1", true, true);
      } else if (bool2) {
        h.OAn.b(11891, "2", true, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ah.5
 * JD-Core Version:    0.7.0.1
 */