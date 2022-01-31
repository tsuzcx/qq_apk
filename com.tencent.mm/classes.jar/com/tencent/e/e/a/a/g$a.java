package com.tencent.e.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g$a
  implements SensorEventListener
{
  long BkM;
  final AtomicBoolean BkX;
  int BkY;
  long BkZ;
  
  g$a(g paramg)
  {
    AppMethodBeat.i(114555);
    this.BkX = new AtomicBoolean(false);
    this.BkM = 0L;
    this.BkY = 0;
    this.BkZ = 0L;
    AppMethodBeat.o(114555);
  }
  
  public final long dUK()
  {
    synchronized (this.BkX)
    {
      long l = this.BkM;
      return l;
    }
  }
  
  public final long dUL()
  {
    synchronized (this.BkX)
    {
      long l = this.BkZ;
      return l;
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent arg1)
  {
    AppMethodBeat.i(114556);
    synchronized (this.BkX)
    {
      if (!this.BkX.get())
      {
        AppMethodBeat.o(114556);
        return;
      }
      if ((??? == null) || (???.sensor == null))
      {
        AppMethodBeat.o(114556);
        return;
      }
    }
    j localj = new j(???, System.currentTimeMillis());
    int j;
    int i;
    synchronized (this.BkX)
    {
      long l = localj.timestamp - this.BkM;
      if (l < 0L)
      {
        AppMethodBeat.o(114556);
        return;
      }
      j = localj.Ble;
      i = (int)(l / f.BkQ);
    }
    for (;;)
    {
      synchronized (g.a(this.Bla))
      {
        ??? = (i)g.a(this.Bla).get(j);
        if (??? == null)
        {
          ??? = new i(j, f.BkR, this.BkY);
          g.a(this.Bla).put(j, ???);
          if ((i < ???.mCapacity) && (i > ???.Sl))
          {
            j = i / ???.ATU;
            List localList = (List)???.EX[j];
            ??? = localList;
            if (localList == null)
            {
              ??? = new ArrayList();
              ???.EX[j] = ???;
            }
            ((List)???).add(localj);
            ???.Sl = i;
          }
          AppMethodBeat.o(114556);
          return;
          localObject2 = finally;
          AppMethodBeat.o(114556);
          throw localObject2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.e.e.a.a.g.a
 * JD-Core Version:    0.7.0.1
 */