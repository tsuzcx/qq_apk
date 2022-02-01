package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public final class bo
  implements SensorEventListener
{
  private static bo e;
  private final SensorManager a;
  private final boolean b;
  private boolean c;
  private double d;
  
  private bo(Context paramContext)
  {
    this.a = ((SensorManager)paramContext.getSystemService("sensor"));
    if (this.a != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      return;
    }
  }
  
  public static bo a(Context paramContext)
  {
    if (e == null) {
      e = new bo(paramContext);
    }
    return e;
  }
  
  public final void a()
  {
    if (!this.b) {}
    Sensor localSensor;
    do
    {
      do
      {
        return;
      } while (this.c);
      localSensor = this.a.getDefaultSensor(3);
    } while (localSensor == null);
    this.a.registerListener(this, localSensor, 3);
    this.c = true;
  }
  
  public final void b()
  {
    if (!this.b) {}
    while (!this.c) {
      return;
    }
    this.c = false;
    this.d = (0.0D / 0.0D);
    this.a.unregisterListener(this);
  }
  
  public final double c()
  {
    if (this.c) {
      try
      {
        double d1 = this.d;
        return d1;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    return (0.0D / 0.0D);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    double d1 = paramSensorEvent.values[0];
    try
    {
      this.d = d1;
      return;
    }
    finally
    {
      paramSensorEvent = finally;
      throw paramSensorEvent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bo
 * JD-Core Version:    0.7.0.1
 */