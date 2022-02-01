package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;

final class e$b
{
  private HandlerThread handlerThread;
  long hiI;
  ArrayList<e.a> isA;
  ArrayList<e.a> isB;
  ArrayList<float[]> isC;
  private SensorEventListener isD;
  long ist;
  e.a isu;
  e.a isv;
  e.a isw;
  private Long isx;
  ArrayList<Long> isy;
  ArrayList<e.a> isz;
  private SensorManager sensorManager;
  
  e$b(e parame)
  {
    AppMethodBeat.i(151063);
    this.ist = 0L;
    this.handlerThread = null;
    this.isu = null;
    this.isv = null;
    this.isw = null;
    this.isx = null;
    this.hiI = 0L;
    this.isy = new ArrayList();
    this.isz = new ArrayList();
    this.isA = new ArrayList();
    this.isB = new ArrayList();
    this.isC = new ArrayList();
    this.isD = new SensorEventListener()
    {
      public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
      
      public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
      {
        AppMethodBeat.i(151062);
        if (paramAnonymousSensorEvent == null)
        {
          AppMethodBeat.o(151062);
          return;
        }
        long l1 = bu.fpO();
        if (paramAnonymousSensorEvent.sensor.getType() == 1) {
          e.b.this.isu = new e.a(paramAnonymousSensorEvent);
        }
        for (;;)
        {
          long l2 = l1 - e.b.this.hiI;
          if ((e.b.this.isu != null) && (e.b.this.isv != null) && (e.b.this.isw != null) && ((l2 > e.b.this.ist) || (l2 < 0L)))
          {
            paramAnonymousSensorEvent = new float[9];
            SensorManager.getRotationMatrix(paramAnonymousSensorEvent, null, e.b.this.isu.values, e.b.this.isv.values);
            float[] arrayOfFloat = new float[3];
            SensorManager.getOrientation(paramAnonymousSensorEvent, arrayOfFloat);
            e.b.this.hiI = l1;
            e.b.this.isy.add(Long.valueOf(l1));
            e.b.this.isz.add(e.b.this.isu);
            e.b.this.isA.add(e.b.this.isv);
            e.b.this.isB.add(e.b.this.isw);
            e.b.this.isC.add(arrayOfFloat);
            int i = e.b.this.isz.size() - 1;
            ae.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", new Object[] { Integer.valueOf(e.b.this.isz.size()), Integer.valueOf(((e.a)e.b.this.isz.get(i)).accuracy), Float.valueOf(((e.a)e.b.this.isz.get(i)).values[0]), Float.valueOf(((e.a)e.b.this.isz.get(i)).values[1]), Float.valueOf(((e.a)e.b.this.isz.get(i)).values[2]) });
            ae.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", new Object[] { Long.valueOf(l2), Integer.valueOf(e.b.this.isu.accuracy), Float.valueOf(e.b.this.isu.values[0]), Float.valueOf(e.b.this.isu.values[1]), Float.valueOf(e.b.this.isu.values[2]), Integer.valueOf(e.b.this.isv.accuracy), Float.valueOf(e.b.this.isv.values[0]), Float.valueOf(e.b.this.isv.values[1]), Float.valueOf(e.b.this.isv.values[2]), Integer.valueOf(e.b.this.isw.accuracy), Float.valueOf(e.b.this.isw.values[0]), Float.valueOf(e.b.this.isw.values[1]), Float.valueOf(e.b.this.isw.values[2]), Float.valueOf(arrayOfFloat[0]), Float.valueOf(arrayOfFloat[1]), Float.valueOf(arrayOfFloat[2]) });
          }
          AppMethodBeat.o(151062);
          return;
          if (paramAnonymousSensorEvent.sensor.getType() == 2) {
            e.b.this.isv = new e.a(paramAnonymousSensorEvent);
          } else if (paramAnonymousSensorEvent.sensor.getType() == 4) {
            e.b.this.isw = new e.a(paramAnonymousSensorEvent);
          }
        }
      }
    };
    AppMethodBeat.o(151063);
  }
  
  private static String a(e.a parama)
  {
    AppMethodBeat.i(151066);
    try
    {
      new String();
      parama = String.format("%d;%.3f;%.3f;%.3f;", new Object[] { Integer.valueOf(parama.accuracy), Float.valueOf(parama.values[0]), Float.valueOf(parama.values[1]), Float.valueOf(parama.values[2]) });
      AppMethodBeat.o(151066);
      return parama;
    }
    catch (Exception parama)
    {
      AppMethodBeat.o(151066);
    }
    return "0;0;0;0;";
  }
  
  public final String aMc()
  {
    AppMethodBeat.i(151065);
    try
    {
      if (this.sensorManager != null)
      {
        this.sensorManager.unregisterListener(this.isD);
        this.sensorManager = null;
      }
      try
      {
        label28:
        if (this.handlerThread != null)
        {
          this.handlerThread.quit();
          this.handlerThread = null;
        }
        label48:
        ae.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", new Object[] { Integer.valueOf(this.isy.size()) });
        String str = this.isx + ";" + this.isy.size() + ";#";
        int i = 0;
        while (i < this.isy.size())
        {
          str = str + (((Long)this.isy.get(i)).longValue() - this.isx.longValue()) + ";";
          str = str + a((e.a)this.isz.get(i));
          ae.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e.a)this.isz.get(i)).accuracy), Float.valueOf(((e.a)this.isz.get(i)).values[0]), Float.valueOf(((e.a)this.isz.get(i)).values[1]), Float.valueOf(((e.a)this.isz.get(i)).values[2]), a((e.a)this.isz.get(i)) });
          str = str + a((e.a)this.isB.get(i));
          str = str + a((e.a)this.isA.get(i));
          str = str + String.format("%.3f;%.3f;%.3f;#", new Object[] { Float.valueOf(((float[])this.isC.get(i))[0]), Float.valueOf(((float[])this.isC.get(i))[1]), Float.valueOf(((float[])this.isC.get(i))[2]) });
          i += 1;
        }
        ae.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", new Object[] { Integer.valueOf(str.length()), str });
        AppMethodBeat.o(151065);
        return str;
      }
      catch (Exception localException1)
      {
        break label48;
      }
    }
    catch (Exception localException2)
    {
      break label28;
    }
  }
  
  public final boolean qd(int paramInt)
  {
    AppMethodBeat.i(151064);
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
      }
      if (this.handlerThread == null)
      {
        this.handlerThread = d.hj("MicroMsg.IndoorReporter", 1);
        this.handlerThread.start();
      }
      Handler localHandler = new Handler(this.handlerThread.getLooper());
      bool1 = this.sensorManager.registerListener(this.isD, this.sensorManager.getDefaultSensor(1), 3, localHandler);
      boolean bool2 = this.sensorManager.registerListener(this.isD, this.sensorManager.getDefaultSensor(4), 3, localHandler);
      boolean bool3 = this.sensorManager.registerListener(this.isD, this.sensorManager.getDefaultSensor(2), 3, localHandler);
      if ((!bool1) || (!bool2) || (!bool3)) {
        break label222;
      }
      bool1 = true;
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          boolean bool1;
          if (this.sensorManager == null) {
            break label179;
          }
          this.sensorManager.unregisterListener(this.isD);
          this.sensorManager = null;
          try
          {
            if (this.handlerThread == null) {
              break label199;
            }
            this.handlerThread.quit();
            this.handlerThread = null;
            this.ist = paramInt;
            this.isx = Long.valueOf(bu.fpO());
            AppMethodBeat.o(151064);
            return bool1;
            bool1 = false;
            continue;
            localException1 = localException1;
            ae.e("MicroMsg.IndoorReporter", "start except:%s", new Object[] { localException1.getMessage() });
            bool1 = false;
          }
          catch (Exception localException2)
          {
            break label199;
          }
        }
      }
      catch (Exception localException3)
      {
        break label179;
      }
    }
    if (bool1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.b
 * JD-Core Version:    0.7.0.1
 */