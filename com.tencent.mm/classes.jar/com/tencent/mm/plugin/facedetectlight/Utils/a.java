package com.tencent.mm.plugin.facedetectlight.Utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  private SensorManager bmB;
  private a.a mru;
  private boolean mrv = false;
  
  public final void bvJ()
  {
    AppMethodBeat.i(141845);
    if (this.mrv)
    {
      AppMethodBeat.o(141845);
      return;
    }
    this.mrv = true;
    new StringBuilder("lightSensor has started:").append(this.mrv);
    this.bmB = ((SensorManager)ah.getContext().getSystemService("sensor"));
    Sensor localSensor = this.bmB.getDefaultSensor(5);
    if (localSensor != null)
    {
      this.mru = new a.a(this, (byte)0);
      this.bmB.registerListener(this.mru, localSensor, 3);
    }
    AppMethodBeat.o(141845);
  }
  
  public final float bvK()
  {
    AppMethodBeat.i(752);
    if (this.mru != null)
    {
      new StringBuilder("Light lux: ").append(a.a.a(this.mru));
      float f = a.a.a(this.mru);
      AppMethodBeat.o(752);
      return f;
    }
    AppMethodBeat.o(752);
    return -1.0F;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(753);
    if ((!this.mrv) || (this.bmB == null))
    {
      AppMethodBeat.o(753);
      return;
    }
    this.mrv = false;
    this.bmB.unregisterListener(this.mru);
    AppMethodBeat.o(753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.Utils.a
 * JD-Core Version:    0.7.0.1
 */