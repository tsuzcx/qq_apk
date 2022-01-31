package com.tencent.mm.modelstat;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class e$b$1
  implements SensorEventListener
{
  e$b$1(e.b paramb) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent == null) {
      return;
    }
    long l1 = bk.UY();
    if (paramSensorEvent.sensor.getType() == 1) {
      this.eDn.eDd = new e.a(paramSensorEvent);
    }
    for (;;)
    {
      long l2 = l1 - this.eDn.dXA;
      if ((this.eDn.eDd == null) || (this.eDn.eDe == null) || (this.eDn.eDf == null) || ((l2 <= this.eDn.eDc) && (l2 >= 0L))) {
        break;
      }
      paramSensorEvent = new float[9];
      SensorManager.getRotationMatrix(paramSensorEvent, null, this.eDn.eDd.values, this.eDn.eDe.values);
      float[] arrayOfFloat = new float[3];
      SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
      this.eDn.dXA = l1;
      this.eDn.eDh.add(Long.valueOf(l1));
      this.eDn.eDi.add(this.eDn.eDd);
      this.eDn.eDj.add(this.eDn.eDe);
      this.eDn.eDk.add(this.eDn.eDf);
      this.eDn.eDl.add(arrayOfFloat);
      int i = this.eDn.eDi.size() - 1;
      y.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", new Object[] { Integer.valueOf(this.eDn.eDi.size()), Integer.valueOf(((e.a)this.eDn.eDi.get(i)).accuracy), Float.valueOf(((e.a)this.eDn.eDi.get(i)).values[0]), Float.valueOf(((e.a)this.eDn.eDi.get(i)).values[1]), Float.valueOf(((e.a)this.eDn.eDi.get(i)).values[2]) });
      y.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", new Object[] { Long.valueOf(l2), Integer.valueOf(this.eDn.eDd.accuracy), Float.valueOf(this.eDn.eDd.values[0]), Float.valueOf(this.eDn.eDd.values[1]), Float.valueOf(this.eDn.eDd.values[2]), Integer.valueOf(this.eDn.eDe.accuracy), Float.valueOf(this.eDn.eDe.values[0]), Float.valueOf(this.eDn.eDe.values[1]), Float.valueOf(this.eDn.eDe.values[2]), Integer.valueOf(this.eDn.eDf.accuracy), Float.valueOf(this.eDn.eDf.values[0]), Float.valueOf(this.eDn.eDf.values[1]), Float.valueOf(this.eDn.eDf.values[2]), Float.valueOf(arrayOfFloat[0]), Float.valueOf(arrayOfFloat[1]), Float.valueOf(arrayOfFloat[2]) });
      return;
      if (paramSensorEvent.sensor.getType() == 2) {
        this.eDn.eDe = new e.a(paramSensorEvent);
      } else if (paramSensorEvent.sensor.getType() == 4) {
        this.eDn.eDf = new e.a(paramSensorEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.b.1
 * JD-Core Version:    0.7.0.1
 */