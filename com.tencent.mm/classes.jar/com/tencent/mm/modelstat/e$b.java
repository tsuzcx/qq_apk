package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class e$b
{
  long dXA = 0L;
  long eDc = 0L;
  e.a eDd = null;
  e.a eDe = null;
  e.a eDf = null;
  private Long eDg = null;
  ArrayList<Long> eDh = new ArrayList();
  ArrayList<e.a> eDi = new ArrayList();
  ArrayList<e.a> eDj = new ArrayList();
  ArrayList<e.a> eDk = new ArrayList();
  ArrayList<float[]> eDl = new ArrayList();
  private SensorEventListener eDm = new e.b.1(this);
  private HandlerThread handlerThread = null;
  private SensorManager sensorManager;
  
  e$b(e parame) {}
  
  private static String a(e.a parama)
  {
    try
    {
      new String();
      parama = String.format("%d;%.3f;%.3f;%.3f;", new Object[] { Integer.valueOf(parama.accuracy), Float.valueOf(parama.values[0]), Float.valueOf(parama.values[1]), Float.valueOf(parama.values[2]) });
      return parama;
    }
    catch (Exception parama) {}
    return "0;0;0;0;";
  }
  
  public final String Rr()
  {
    try
    {
      if (this.sensorManager != null)
      {
        this.sensorManager.unregisterListener(this.eDm);
        this.sensorManager = null;
      }
      try
      {
        label23:
        if (this.handlerThread != null)
        {
          this.handlerThread.quit();
          this.handlerThread = null;
        }
        label43:
        y.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", new Object[] { Integer.valueOf(this.eDh.size()) });
        String str = this.eDg + ";" + this.eDh.size() + ";#";
        int i = 0;
        while (i < this.eDh.size())
        {
          str = str + (((Long)this.eDh.get(i)).longValue() - this.eDg.longValue()) + ";";
          str = str + a((e.a)this.eDi.get(i));
          y.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e.a)this.eDi.get(i)).accuracy), Float.valueOf(((e.a)this.eDi.get(i)).values[0]), Float.valueOf(((e.a)this.eDi.get(i)).values[1]), Float.valueOf(((e.a)this.eDi.get(i)).values[2]), a((e.a)this.eDi.get(i)) });
          str = str + a((e.a)this.eDk.get(i));
          str = str + a((e.a)this.eDj.get(i));
          str = str + String.format("%.3f;%.3f;%.3f;#", new Object[] { Float.valueOf(((float[])this.eDl.get(i))[0]), Float.valueOf(((float[])this.eDl.get(i))[1]), Float.valueOf(((float[])this.eDl.get(i))[2]) });
          i += 1;
        }
        y.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", new Object[] { Integer.valueOf(str.length()), str });
        return str;
      }
      catch (Exception localException1)
      {
        break label43;
      }
    }
    catch (Exception localException2)
    {
      break label23;
    }
  }
  
  public final boolean w(Context paramContext, int paramInt)
  {
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
      }
      if (this.handlerThread == null)
      {
        this.handlerThread = com.tencent.mm.sdk.f.e.ds("MicroMsg.IndoorReporter", 1);
        this.handlerThread.start();
      }
      paramContext = new Handler(this.handlerThread.getLooper());
      bool1 = this.sensorManager.registerListener(this.eDm, this.sensorManager.getDefaultSensor(1), 3, paramContext);
      boolean bool2 = this.sensorManager.registerListener(this.eDm, this.sensorManager.getDefaultSensor(4), 3, paramContext);
      boolean bool3 = this.sensorManager.registerListener(this.eDm, this.sensorManager.getDefaultSensor(2), 3, paramContext);
      if ((!bool1) || (!bool2) || (!bool3)) {
        break label208;
      }
      bool1 = true;
    }
    catch (Exception paramContext)
    {
      try
      {
        for (;;)
        {
          boolean bool1;
          if (this.sensorManager == null) {
            break label170;
          }
          this.sensorManager.unregisterListener(this.eDm);
          this.sensorManager = null;
          try
          {
            label170:
            if (this.handlerThread == null) {
              break label190;
            }
            this.handlerThread.quit();
            this.handlerThread = null;
            label190:
            this.eDc = paramInt;
            this.eDg = Long.valueOf(bk.UY());
            return bool1;
            label208:
            bool1 = false;
            continue;
            paramContext = paramContext;
            y.e("MicroMsg.IndoorReporter", "start except:%s", new Object[] { paramContext.getMessage() });
            bool1 = false;
          }
          catch (Exception paramContext)
          {
            break label190;
          }
        }
      }
      catch (Exception paramContext)
      {
        break label170;
      }
    }
    if (bool1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.e.b
 * JD-Core Version:    0.7.0.1
 */