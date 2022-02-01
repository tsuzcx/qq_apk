package com.tencent.mm.plugin.finder.live.olympic.certificate;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/GyroscopeSensorController;", "Landroid/hardware/SensorEventListener;", "context", "Landroid/content/Context;", "sensorChangeListener", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/GyroscopeSensorController$SensorChangeListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/olympic/certificate/GyroscopeSensorController$SensorChangeListener;)V", "angle", "", "gyroscope", "Landroid/hardware/Sensor;", "preAngle", "getSensorChangeListener", "()Lcom/tencent/mm/plugin/finder/live/olympic/certificate/GyroscopeSensorController$SensorChangeListener;", "sensorManager", "Landroid/hardware/SensorManager;", "timestamp", "", "isEnableGyroscope", "", "onAccuracyChanged", "", "sensor", "accuracy", "", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "registerGyroscopeListener", "unregisterGyroscopeListener", "Companion", "SensorChangeListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements SensorEventListener
{
  public static final a.a CPd;
  private final a.b CPe;
  private Sensor CPf;
  private final float[] CPg;
  private final float[] CPh;
  private SensorManager sensorManager;
  private long timestamp;
  
  static
  {
    AppMethodBeat.i(360834);
    CPd = new a.a((byte)0);
    AppMethodBeat.o(360834);
  }
  
  public a(Context paramContext, a.b paramb)
  {
    AppMethodBeat.i(360828);
    this.CPe = paramb;
    paramContext = paramContext.getSystemService("sensor");
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
      AppMethodBeat.o(360828);
      throw paramContext;
    }
    this.sensorManager = ((SensorManager)paramContext);
    this.CPf = this.sensorManager.getDefaultSensor(4);
    this.CPg = new float[3];
    this.CPh = new float[3];
    AppMethodBeat.o(360828);
  }
  
  public final void enN()
  {
    AppMethodBeat.i(360841);
    Sensor localSensor = this.CPf;
    if (localSensor != null) {
      this.sensorManager.registerListener((SensorEventListener)this, localSensor, 1);
    }
    AppMethodBeat.o(360841);
  }
  
  public final void enO()
  {
    AppMethodBeat.i(360847);
    if (this.CPf != null) {
      this.sensorManager.unregisterListener((SensorEventListener)this, this.CPf);
    }
    AppMethodBeat.o(360847);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(360850);
    s.u(paramSensorEvent, "event");
    if (paramSensorEvent.sensor.getType() == 4)
    {
      if (this.timestamp != 0L)
      {
        float f1 = (float)(paramSensorEvent.timestamp - this.timestamp) * 1.0E-009F;
        float[] arrayOfFloat = this.CPg;
        arrayOfFloat[0] += paramSensorEvent.values[0] * f1;
        arrayOfFloat = this.CPg;
        arrayOfFloat[1] += paramSensorEvent.values[1] * f1;
        arrayOfFloat = this.CPg;
        float f2 = arrayOfFloat[2];
        arrayOfFloat[2] = (f1 * paramSensorEvent.values[2] + f2);
        Math.toDegrees(this.CPg[0] - this.CPh[0]);
        f1 = (float)Math.toDegrees(this.CPg[1] - this.CPh[1]);
        Math.toDegrees(this.CPg[2] - this.CPh[2]);
        this.CPe.ck(f1 * 1.0F);
        this.CPh[0] = this.CPg[0];
        this.CPh[1] = this.CPg[1];
        this.CPh[2] = this.CPg[2];
      }
      this.timestamp = paramSensorEvent.timestamp;
    }
    AppMethodBeat.o(360850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.a
 * JD-Core Version:    0.7.0.1
 */