package com.d.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;

final class r$d
  extends r.a
{
  private boolean aYV;
  
  private r$d(r paramr)
  {
    super(paramr, (byte)0);
  }
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        r.a(pp());
        localf = r.b(pp());
      }
      catch (Exception localException1)
      {
        f localf;
        Object localObject;
        continue;
      }
      try
      {
        localf.aVX = Build.MODEL;
        localf.aVY = Build.VERSION.RELEASE;
        localf.versionName = localf.aVV.versionName;
        localObject = localf.mContext.getApplicationInfo().loadLabel(localf.aVU);
        if (localObject == null) {
          continue;
        }
        localObject = ((CharSequence)localObject).toString();
        localf.aVW = ((String)localObject);
        if (localf.aVT != null)
        {
          localObject = localf.aVT.getDefaultSensor(1);
          Sensor localSensor1 = localf.aVT.getDefaultSensor(4);
          Sensor localSensor2 = localf.aVT.getDefaultSensor(2);
          Sensor localSensor3 = localf.aVT.getDefaultSensor(11);
          if (localObject != null) {
            localf.aWb = 1;
          }
          if (localSensor1 != null) {
            localf.aWc = 1;
          }
          if (localSensor2 != null) {
            localf.aWd = 1;
          }
          if (localSensor3 != null) {
            localf.aWe = 1;
          }
        }
      }
      catch (Error localError)
      {
        continue;
      }
      catch (Exception localException2)
      {
        continue;
      }
      this.aYV = false;
      return;
      localObject = "unknown";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.r.d
 * JD-Core Version:    0.7.0.1
 */