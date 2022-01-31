package com.tencent.d.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g$a
  implements SensorEventListener
{
  long wNA = 0L;
  long wNn = 0L;
  final AtomicBoolean wNy = new AtomicBoolean(false);
  int wNz = 0;
  
  g$a(g paramg) {}
  
  public final long cOU()
  {
    synchronized (this.wNy)
    {
      long l = this.wNn;
      return l;
    }
  }
  
  public final long cOV()
  {
    synchronized (this.wNy)
    {
      long l = this.wNA;
      return l;
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent arg1)
  {
    j localj;
    long l;
    synchronized (this.wNy)
    {
      if (!this.wNy.get()) {
        return;
      }
      if ((??? == null) || (???.sensor == null)) {
        return;
      }
      localj = new j(???, System.currentTimeMillis());
      synchronized (this.wNy)
      {
        l = localj.timestamp - this.wNn;
        if (l < 0L) {
          return;
        }
      }
    }
    int j = localj.wNF;
    int i = (int)(l / f.wNr);
    for (;;)
    {
      synchronized (g.a(this.wNB))
      {
        ??? = (i)g.a(this.wNB).get(j);
        if (??? == null)
        {
          ??? = new i(j, f.wNs, this.wNz);
          g.a(this.wNB).put(j, ???);
          if ((i < ???.dNA) && (i > ???.jVi))
          {
            j = i / ???.wyC;
            List localList = (List)???.Eh[j];
            Object localObject2 = localList;
            if (localList == null)
            {
              localObject2 = new ArrayList();
              ???.Eh[j] = localObject2;
            }
            ((List)localObject2).add(localj);
            ???.jVi = i;
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.e.a.a.g.a
 * JD-Core Version:    0.7.0.1
 */