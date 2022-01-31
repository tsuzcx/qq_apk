package com.tencent.mm.plugin.location.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class i$b
  implements SensorEventListener
{
  private float gvf = 0.0F;
  private long timestamp = 200L;
  
  protected i$b(i parami) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = 0;
    if (paramSensorEvent.sensor.getType() == 3)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.timestamp;
      float f1 = paramSensorEvent.values[0];
      float f2;
      if (f1 > 0.0F)
      {
        f1 %= 360.0F;
        if ((l1 - l2 <= 200L) || (Math.abs(f1 - this.gvf) <= 3.0F)) {
          return;
        }
        paramSensorEvent = this.lDi;
        f2 = this.gvf;
        paramSensorEvent.lDg = f1;
        if (paramSensorEvent.lDb != null) {
          break label221;
        }
      }
      for (;;)
      {
        y.d("MicroMsg.OrientationSensorMgr", "onOrientationChanged %f %f, mListenerList.size = %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(i) });
        if (paramSensorEvent.lDb == null) {
          break label233;
        }
        Iterator localIterator = paramSensorEvent.lDb.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference != null) && (localWeakReference.get() != null)) {
            ((i.a)localWeakReference.get()).u(paramSensorEvent.bdQ());
          }
        }
        f1 = (f1 + ((int)f1 * -1 / 360 + 1) * 360) % 360.0F;
        break;
        label221:
        i = paramSensorEvent.lDb.size();
      }
      label233:
      this.gvf = f1;
      this.timestamp = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.i.b
 * JD-Core Version:    0.7.0.1
 */