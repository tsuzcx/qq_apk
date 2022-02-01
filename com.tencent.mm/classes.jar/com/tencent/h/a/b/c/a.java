package com.tencent.h.a.b.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.g.c.i;
import com.tencent.h.a.a.d;
import com.tencent.h.a.b.c.a.e;
import com.tencent.h.a.c.b.g;
import com.tencent.h.a.j;
import com.tencent.h.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a
  extends com.tencent.h.a.b.c.a.a
  implements SensorEventListener
{
  private com.tencent.h.a.b.c.a.c ahXo;
  private com.tencent.h.a.a.a ahXp;
  private final SparseArray<com.tencent.h.a.b.c.b.a> ahXq;
  private final Object mLock;
  private SensorManager mSensorManager;
  
  public a(com.tencent.h.a.a.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(212147);
    this.ahXq = new SparseArray();
    this.mLock = new Object();
    AppMethodBeat.o(212147);
  }
  
  private void ox(List<g> paramList)
  {
    AppMethodBeat.i(212157);
    synchronized (this.mLock)
    {
      if ((this.ahXo != null) && (paramList != null) && (!paramList.isEmpty())) {
        this.ahXo.ow(paramList);
      }
      AppMethodBeat.o(212157);
      return;
    }
  }
  
  public final void a(e parame)
  {
    this.ahXo = ((com.tencent.h.a.b.c.a.c)parame);
  }
  
  public final int getTaskId()
  {
    return 0;
  }
  
  public final boolean kdu()
  {
    AppMethodBeat.i(212179);
    int[] arrayOfInt = d.ahWV;
    if (arrayOfInt.length <= 0) {
      arrayOfInt = d.ahWU;
    }
    for (;;)
    {
      int m = kdg().ahWO.kda().ahWy;
      if (this.mSensorManager == null) {
        this.mSensorManager = ((SensorManager)kdg().mAppContext.getSystemService("sensor"));
      }
      if ((this.ahXp == null) || (!this.ahXp.isAlive()))
      {
        i.i("sensor_SensorTask", "[method: registerSensor ] build AsyncWork");
        this.ahXp = new com.tencent.h.a.a.a("sensor_task") {};
      }
      this.ahXq.clear();
      i.i("sensor_SensorTask", "[method: registerSensor ] begin register sensor");
      int n = arrayOfInt.length;
      int j = 0;
      int i1;
      if (j < n)
      {
        i1 = arrayOfInt[j];
        if ((Build.VERSION.SDK_INT >= 9) || (i1 != 9)) {
          break label295;
        }
      }
      label275:
      label295:
      for (int i = 1;; i = 0)
      {
        int k = i;
        if (Build.VERSION.SDK_INT < 19)
        {
          k = i;
          if (i1 == 19) {
            k = 1;
          }
        }
        Sensor localSensor;
        Object localObject;
        if (k == 0)
        {
          localSensor = this.mSensorManager.getDefaultSensor(i1);
          localObject = new StringBuilder("[method: registerSensor ] sensor is null ? ");
          if (localSensor != null) {
            break label275;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          i.i("sensor_SensorTask", bool);
          if (localSensor != null)
          {
            localObject = new com.tencent.h.a.b.c.b.a(localSensor, m);
            this.ahXq.put(i1, localObject);
            this.mSensorManager.registerListener(this, localSensor, 0, this.ahXp.ahWL);
          }
          j += 1;
          break;
        }
        i.i("sensor_SensorTask", "[method: registerSensor ] register completed");
        AppMethodBeat.o(212179);
        return true;
      }
    }
  }
  
  public final boolean kdv()
  {
    AppMethodBeat.i(212188);
    if (this.ahXq.size() <= 0)
    {
      AppMethodBeat.o(212188);
      return true;
    }
    int i = 0;
    while (i < this.ahXq.size())
    {
      Object localObject = (com.tencent.h.a.b.c.b.a)this.ahXq.valueAt(i);
      if (localObject != null)
      {
        localObject = ((com.tencent.h.a.b.c.b.a)localObject).kdy();
        i.i("sensor_SensorTask", "[method: notifyTaskDataPush ] controller getPointerSize : " + ((List)localObject).size());
        ox((List)localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(212188);
    return true;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(212233);
    int k;
    Object localObject;
    try
    {
      k = paramSensorEvent.sensor.getType();
      locala = (com.tencent.h.a.b.c.b.a)this.ahXq.get(k);
      if (locala == null)
      {
        AppMethodBeat.o(212233);
        return;
      }
      if (paramSensorEvent == null)
      {
        i.i("sensor_EventController", "[method: isFilterEvent ] ");
        i = 1;
        break label809;
        if (localObject != null)
        {
          ((g)localObject).ahuN = locala.Bm(paramSensorEvent.timestamp);
          if (localObject != null)
          {
            locala.ahXA.add(localObject);
            locala.ahXB = ((g)localObject).ahuN;
          }
          if (locala.kdz() >= 5) {
            ox(locala.kdy());
          }
        }
        if (paramSensorEvent != null)
        {
          paramSensorEvent.hpa[0] = (0.0F / 0.0F);
          paramSensorEvent.hpa[1] = (0.0F / 0.0F);
          paramSensorEvent.hpa[2] = (0.0F / 0.0F);
          paramSensorEvent.timestamp = 0L;
        }
        label156:
        AppMethodBeat.o(212233);
      }
      else
      {
        if ((paramSensorEvent.timestamp > 0L) && (locala.NMQ)) {
          break label895;
        }
        locala.NMQ = true;
        i.i("sensor_EventController", "[method: isFilterEvent ] " + paramSensorEvent.timestamp);
        i = 1;
      }
    }
    finally
    {
      com.tencent.h.a.b.c.b.a locala;
      label214:
      label224:
      long l1;
      long l2;
      label285:
      kdg().ahWQ.b(paramSensorEvent, "onSensorChanged");
      AppMethodBeat.o(212233);
      return;
    }
    if (locala.ahXx <= 0)
    {
      i = 1;
      if (i != 0)
      {
        paramSensorEvent = com.tencent.h.a.b.c.b.a.a(paramSensorEvent, locala.kdx());
      }
      else
      {
        l1 = locala.Bm(paramSensorEvent.timestamp);
        l2 = l1 - locala.ahXB;
        i = 0;
        if (l2 >= locala.ahXx - 5L) {
          break label905;
        }
        i = 1;
        break label905;
        if (locala.ahXx != l2) {
          break label914;
        }
      }
    }
    label898:
    label905:
    label912:
    label914:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramSensorEvent = com.tencent.h.a.b.c.b.a.a(paramSensorEvent, locala.kdx());
      }
      else
      {
        int j = 0;
        i = j;
        if (locala.ahXz != null)
        {
          i = j;
          if (locala.ahXz.timestamp != 0L) {
            i = 1;
          }
        }
        if (i != 0)
        {
          l2 = locala.ahXB + locala.ahXx;
          if (Math.abs(l2 - locala.Bm(locala.kdx().timestamp)) < Math.abs(l2 - l1)) {
            paramSensorEvent = locala.kdx();
          } else {
            paramSensorEvent = com.tencent.h.a.b.c.b.a.a(paramSensorEvent, locala.kdx());
          }
        }
        else
        {
          i = 0;
          if (l2 > locala.ahXx + 5L) {
            i = 1;
          }
          if (i != 0)
          {
            paramSensorEvent = com.tencent.h.a.b.c.b.a.a(paramSensorEvent, locala.kdx());
          }
          else
          {
            com.tencent.h.a.b.c.b.a.a(paramSensorEvent, locala.kdx());
            paramSensorEvent = null;
            break label815;
            localObject = new g();
            ((g)localObject).ahuv = 0;
            ((g)localObject).QWn = (paramSensorEvent.hpa[0] / 9.8F);
            ((g)localObject).QWo = (paramSensorEvent.hpa[1] / 9.8F);
            ((g)localObject).QWp = (paramSensorEvent.hpa[2] / 9.8F);
            break;
            localObject = new g();
            ((g)localObject).ahuv = 1;
            ((g)localObject).QWn = paramSensorEvent.hpa[0];
            break;
            localObject = new g();
            ((g)localObject).ahuv = 2;
            ((g)localObject).QWn = paramSensorEvent.hpa[0];
            ((g)localObject).QWo = paramSensorEvent.hpa[1];
            ((g)localObject).QWp = paramSensorEvent.hpa[2];
            break;
            localObject = new g();
            ((g)localObject).ahuv = 3;
            ((g)localObject).QWn = paramSensorEvent.hpa[0];
            break;
            localObject = new g();
            ((g)localObject).ahuv = 4;
            ((g)localObject).QWn = (paramSensorEvent.hpa[0] / 9.8F);
            ((g)localObject).QWo = (paramSensorEvent.hpa[1] / 9.8F);
            ((g)localObject).QWp = (-paramSensorEvent.hpa[2] / 9.8F);
            break;
            localObject = new g();
            ((g)localObject).ahuv = 5;
            ((g)localObject).QWn = paramSensorEvent.hpa[0];
            ((g)localObject).QWo = paramSensorEvent.hpa[1];
            ((g)localObject).QWp = paramSensorEvent.hpa[2];
            break;
            localObject = new g();
            ((g)localObject).ahuv = 6;
            ((g)localObject).QWn = paramSensorEvent.hpa[0];
            break;
            label809:
            if (i == 0) {
              break label898;
            }
          }
        }
      }
      for (paramSensorEvent = null;; paramSensorEvent = null)
      {
        label815:
        if (paramSensorEvent == null) {
          break label912;
        }
        localObject = null;
        switch (k)
        {
        }
        break;
        label895:
        i = 0;
        break label809;
        break label214;
        i = 0;
        break label224;
        if (i == 0) {
          break label285;
        }
      }
      break label156;
    }
  }
  
  public final boolean stop()
  {
    AppMethodBeat.i(212205);
    synchronized (this.mLock)
    {
      this.ahXo = null;
      i.i("sensor_SensorTask", "[method: unregisterSensor ] unregister sensor: " + Thread.currentThread().getName());
      if ((this.mSensorManager == null) || (this.ahXq.size() <= 0))
      {
        AppMethodBeat.o(212205);
        return true;
      }
    }
    int i = 0;
    while (i < this.ahXq.size())
    {
      ??? = (com.tencent.h.a.b.c.b.a)this.ahXq.valueAt(i);
      if ((??? != null) && (((com.tencent.h.a.b.c.b.a)???).Mug != null))
      {
        i.i("sensor_SensorTask", "[method: stop ] controller getPointerSize : " + ((com.tencent.h.a.b.c.b.a)???).kdz());
        this.mSensorManager.unregisterListener(this, ((com.tencent.h.a.b.c.b.a)???).Mug);
      }
      i += 1;
    }
    if (this.ahXp != null)
    {
      i.i("sensor_SensorTask", "[method: unregisterSensor ] unregister sensor: stop asyncWorker");
      this.ahXp.kdd();
      this.ahXp = null;
    }
    this.ahXq.clear();
    AppMethodBeat.o(212205);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */