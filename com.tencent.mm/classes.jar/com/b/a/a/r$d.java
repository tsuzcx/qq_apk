package com.b.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$d
  extends r.a
{
  private boolean bpB;
  
  private r$d(r paramr)
  {
    super(paramr, (byte)0);
  }
  
  public final void run()
  {
    AppMethodBeat.i(55542);
    for (;;)
    {
      try
      {
        r.a(tv());
        localf = r.b(tv());
      }
      catch (Exception localException1)
      {
        f localf;
        Object localObject;
        continue;
      }
      try
      {
        localf.bmF = Build.MODEL;
        localf.bmG = Build.VERSION.RELEASE;
        localf.versionName = localf.bmD.versionName;
        localObject = localf.mContext.getApplicationInfo().loadLabel(localf.bmC);
        if (localObject == null) {
          continue;
        }
        localObject = ((CharSequence)localObject).toString();
        localf.bmE = ((String)localObject);
        if (localf.bmB != null)
        {
          localObject = localf.bmB.getDefaultSensor(1);
          Sensor localSensor1 = localf.bmB.getDefaultSensor(4);
          Sensor localSensor2 = localf.bmB.getDefaultSensor(2);
          Sensor localSensor3 = localf.bmB.getDefaultSensor(11);
          if (localObject != null) {
            localf.bmJ = 1;
          }
          if (localSensor1 != null) {
            localf.bmK = 1;
          }
          if (localSensor2 != null) {
            localf.bmL = 1;
          }
          if (localSensor3 != null) {
            localf.bmM = 1;
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
      this.bpB = false;
      AppMethodBeat.o(55542);
      return;
      localObject = "unknown";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.b.a.a.r.d
 * JD-Core Version:    0.7.0.1
 */