package com.tencent.mm.plugin.facedetectlight.Utils;

import android.content.Context;
import android.hardware.SensorManager;

public final class a
{
  private SensorManager aVT;
  public a.a jXd;
  private boolean jXe = false;
  
  public final void de(Context paramContext)
  {
    if (this.jXe) {}
    do
    {
      return;
      this.jXe = true;
      new StringBuilder("lightSensor has started:").append(this.jXe);
      this.aVT = ((SensorManager)paramContext.getApplicationContext().getSystemService("sensor"));
      paramContext = this.aVT.getDefaultSensor(5);
    } while (paramContext == null);
    this.jXd = new a.a(this, (byte)0);
    this.aVT.registerListener(this.jXd, paramContext, 3);
  }
  
  public final void stop()
  {
    if ((!this.jXe) || (this.aVT == null)) {
      return;
    }
    this.jXe = false;
    this.aVT.unregisterListener(this.jXd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.Utils.a
 * JD-Core Version:    0.7.0.1
 */