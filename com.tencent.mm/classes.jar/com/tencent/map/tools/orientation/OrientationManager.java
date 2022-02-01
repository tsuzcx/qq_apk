package com.tencent.map.tools.orientation;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrientationManager
  extends OrientationEventListener
  implements SensorEventListener
{
  private Context contextObj;
  private float mLastAngle;
  private List<OrientationListener> mListeners;
  private int mOrientation;
  
  public OrientationManager(Context paramContext)
  {
    super(paramContext, 3);
    AppMethodBeat.i(180942);
    this.mListeners = new ArrayList();
    this.contextObj = null;
    this.contextObj = paramContext;
    AppMethodBeat.o(180942);
  }
  
  public void addOrientationListener(OrientationListener paramOrientationListener)
  {
    AppMethodBeat.i(180944);
    if (!this.mListeners.contains(paramOrientationListener))
    {
      this.mListeners.add(paramOrientationListener);
      if (this.mListeners.size() == 1) {
        try
        {
          enable();
          paramOrientationListener = (SensorManager)this.contextObj.getSystemService("sensor");
          List localList = paramOrientationListener.getSensorList(3);
          if (!localList.isEmpty()) {
            paramOrientationListener.registerListener(this, (Sensor)localList.get(0), 2);
          }
          AppMethodBeat.o(180944);
          return;
        }
        catch (Exception paramOrientationListener) {}
      }
    }
    AppMethodBeat.o(180944);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(180943);
    this.mListeners.clear();
    try
    {
      disable();
      SensorManager localSensorManager = (SensorManager)this.contextObj.getSystemService("sensor");
      if (!localSensorManager.getSensorList(3).isEmpty()) {
        localSensorManager.unregisterListener(this);
      }
      label49:
      this.contextObj = null;
      AppMethodBeat.o(180943);
      return;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt >= 0) {
      this.mOrientation = paramInt;
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = 0;
    AppMethodBeat.i(180946);
    float f1;
    float f2;
    float f3;
    if (paramSensorEvent.sensor.getType() == 3)
    {
      f1 = paramSensorEvent.values[0];
      f2 = paramSensorEvent.values[1];
      f3 = paramSensorEvent.values[2];
      if (f1 == 0.0F)
      {
        AppMethodBeat.o(180946);
        return;
      }
      if (Math.abs(this.mLastAngle - f1) > 30.0F)
      {
        this.mLastAngle = f1;
        AppMethodBeat.o(180946);
        return;
      }
      f1 = (f1 + this.mLastAngle) / 2.0F;
      this.mLastAngle = f1;
    }
    try
    {
      j = this.contextObj.getResources().getConfiguration().orientation;
      if (j == 2) {
        i = 1;
      }
    }
    catch (Exception paramSensorEvent)
    {
      for (;;)
      {
        int j;
      }
    }
    j = this.mOrientation;
    if (i == 1)
    {
      if ((j > 45) && (j <= 135)) {
        f1 = (270.0F + f1) % 360.0F;
      }
      try
      {
        paramSensorEvent = new ArrayList();
        paramSensorEvent.addAll(this.mListeners);
        paramSensorEvent = paramSensorEvent.iterator();
        while (paramSensorEvent.hasNext())
        {
          OrientationListener localOrientationListener = (OrientationListener)paramSensorEvent.next();
          if (localOrientationListener != null) {
            localOrientationListener.onOrientationChanged(f1, f2, f3);
          }
        }
      }
      catch (OutOfMemoryError paramSensorEvent)
      {
        for (;;)
        {
          AppMethodBeat.o(180946);
          return;
          if ((j > 135) && (j <= 225))
          {
            f1 = (180.0F + f1) % 360.0F;
          }
          else
          {
            if ((j <= 225) || (j >= 315)) {
              break;
            }
            f1 = (90.0F + f1) % 360.0F;
          }
        }
        AppMethodBeat.o(180946);
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramSensorEvent) {}
      AppMethodBeat.o(180946);
      return;
    }
  }
  
  public void removeOrientationListener(OrientationListener paramOrientationListener)
  {
    AppMethodBeat.i(180945);
    if (this.mListeners.contains(paramOrientationListener))
    {
      this.mListeners.remove(paramOrientationListener);
      if (this.mListeners.isEmpty()) {
        try
        {
          disable();
          paramOrientationListener = (SensorManager)this.contextObj.getSystemService("sensor");
          if (!paramOrientationListener.getSensorList(3).isEmpty()) {
            paramOrientationListener.unregisterListener(this);
          }
          AppMethodBeat.o(180945);
          return;
        }
        catch (Exception paramOrientationListener) {}
      }
    }
    AppMethodBeat.o(180945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.tools.orientation.OrientationManager
 * JD-Core Version:    0.7.0.1
 */