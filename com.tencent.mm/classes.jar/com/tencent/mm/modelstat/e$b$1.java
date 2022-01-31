package com.tencent.mm.modelstat;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class e$b$1
  implements SensorEventListener
{
  e$b$1(e.b paramb) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(78718);
    if (paramSensorEvent == null)
    {
      AppMethodBeat.o(78718);
      return;
    }
    long l1 = bo.aoy();
    if (paramSensorEvent.sensor.getType() == 1) {
      this.fTe.fSU = new e.a(paramSensorEvent);
    }
    for (;;)
    {
      long l2 = l1 - this.fTe.ePF;
      if ((this.fTe.fSU != null) && (this.fTe.fSV != null) && (this.fTe.fSW != null) && ((l2 > this.fTe.fST) || (l2 < 0L)))
      {
        paramSensorEvent = new float[9];
        SensorManager.getRotationMatrix(paramSensorEvent, null, this.fTe.fSU.values, this.fTe.fSV.values);
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        this.fTe.ePF = l1;
        this.fTe.fSY.add(Long.valueOf(l1));
        this.fTe.fSZ.add(this.fTe.fSU);
        this.fTe.fTa.add(this.fTe.fSV);
        this.fTe.fTb.add(this.fTe.fSW);
        this.fTe.fTc.add(arrayOfFloat);
        int i = this.fTe.fSZ.size() - 1;
        ab.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", new Object[] { Integer.valueOf(this.fTe.fSZ.size()), Integer.valueOf(((e.a)this.fTe.fSZ.get(i)).accuracy), Float.valueOf(((e.a)this.fTe.fSZ.get(i)).values[0]), Float.valueOf(((e.a)this.fTe.fSZ.get(i)).values[1]), Float.valueOf(((e.a)this.fTe.fSZ.get(i)).values[2]) });
        ab.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", new Object[] { Long.valueOf(l2), Integer.valueOf(this.fTe.fSU.accuracy), Float.valueOf(this.fTe.fSU.values[0]), Float.valueOf(this.fTe.fSU.values[1]), Float.valueOf(this.fTe.fSU.values[2]), Integer.valueOf(this.fTe.fSV.accuracy), Float.valueOf(this.fTe.fSV.values[0]), Float.valueOf(this.fTe.fSV.values[1]), Float.valueOf(this.fTe.fSV.values[2]), Integer.valueOf(this.fTe.fSW.accuracy), Float.valueOf(this.fTe.fSW.values[0]), Float.valueOf(this.fTe.fSW.values[1]), Float.valueOf(this.fTe.fSW.values[2]), Float.valueOf(arrayOfFloat[0]), Float.valueOf(arrayOfFloat[1]), Float.valueOf(arrayOfFloat[2]) });
      }
      AppMethodBeat.o(78718);
      return;
      if (paramSensorEvent.sensor.getType() == 2) {
        this.fTe.fSV = new e.a(paramSensorEvent);
      } else if (paramSensorEvent.sensor.getType() == 4) {
        this.fTe.fSW = new e.a(paramSensorEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.b.1
 * JD-Core Version:    0.7.0.1
 */