package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class ad$2
  implements Runnable
{
  ad$2(ad paramad) {}
  
  public final void run()
  {
    boolean bool1 = ae.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
    boolean bool2 = ae.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
    if ((bool1) && (bool2)) {
      h.nFQ.a(11891, "3", true, true);
    }
    for (;;)
    {
      y.i("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] deviceFeatures stepCounter %s, stepDetector %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      return;
      if (bool1) {
        h.nFQ.a(11891, "1", true, true);
      } else if (bool2) {
        h.nFQ.a(11891, "2", true, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad.2
 * JD-Core Version:    0.7.0.1
 */