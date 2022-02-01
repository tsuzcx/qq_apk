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
  private com.tencent.h.a.b.c.a.c ZSO;
  private com.tencent.h.a.a.a ZSP;
  private final SparseArray<com.tencent.h.a.b.c.b.a> ZSQ;
  private final Object mLock;
  private SensorManager mSensorManager;
  
  public a(com.tencent.h.a.a.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(207489);
    this.ZSP = new com.tencent.h.a.a.a("sensor_task") {};
    this.ZSQ = new SparseArray();
    this.mLock = new Object();
    AppMethodBeat.o(207489);
  }
  
  private void la(List<g> paramList)
  {
    AppMethodBeat.i(207507);
    synchronized (this.mLock)
    {
      if ((this.ZSO != null) && (paramList != null) && (!paramList.isEmpty())) {
        this.ZSO.kZ(paramList);
      }
      AppMethodBeat.o(207507);
      return;
    }
  }
  
  public final boolean TV()
  {
    AppMethodBeat.i(207501);
    synchronized (this.mLock)
    {
      this.ZSO = null;
      i.i("sensor_SensorTask", "[method: unregisterSensor ] unregister sensor: " + Thread.currentThread().getName());
      if ((this.mSensorManager == null) || (this.ZSQ.size() <= 0))
      {
        AppMethodBeat.o(207501);
        return true;
      }
    }
    int i = 0;
    while (i < this.ZSQ.size())
    {
      ??? = (com.tencent.h.a.b.c.b.a)this.ZSQ.valueAt(i);
      if ((??? != null) && (((com.tencent.h.a.b.c.b.a)???).GxY != null))
      {
        i.i("sensor_SensorTask", "[method: stop ] controller getPointerSize : " + ((com.tencent.h.a.b.c.b.a)???).iud());
        this.mSensorManager.unregisterListener(this, ((com.tencent.h.a.b.c.b.a)???).GxY);
      }
      i += 1;
    }
    this.ZSQ.clear();
    AppMethodBeat.o(207501);
    return true;
  }
  
  public final void a(e parame)
  {
    this.ZSO = ((com.tencent.h.a.b.c.a.c)parame);
  }
  
  public final int getTaskId()
  {
    return 0;
  }
  
  public final boolean itY()
  {
    AppMethodBeat.i(207497);
    int[] arrayOfInt = d.ZSx;
    if (arrayOfInt.length <= 0) {
      arrayOfInt = d.ZSw;
    }
    for (;;)
    {
      int m = itK().ZSq.itF().ZSb;
      if (this.mSensorManager == null) {
        this.mSensorManager = ((SensorManager)itK().mAppContext.getSystemService("sensor"));
      }
      this.ZSQ.clear();
      i.i("sensor_SensorTask", "[method: registerSensor ] begin register sensor");
      int n = arrayOfInt.length;
      int j = 0;
      int i1;
      if (j < n)
      {
        i1 = arrayOfInt[j];
        if ((Build.VERSION.SDK_INT >= 9) || (i1 != 9)) {
          break label257;
        }
      }
      label257:
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
            break label237;
          }
        }
        label237:
        for (boolean bool = true;; bool = false)
        {
          i.i("sensor_SensorTask", bool);
          if (localSensor != null)
          {
            localObject = new com.tencent.h.a.b.c.b.a(localSensor, m);
            this.ZSQ.put(i1, localObject);
            this.mSensorManager.registerListener(this, localSensor, 0, this.ZSP.ZQg);
          }
          j += 1;
          break;
        }
        i.i("sensor_SensorTask", "[method: registerSensor ] register completed");
        AppMethodBeat.o(207497);
        return true;
      }
    }
  }
  
  public final boolean itZ()
  {
    AppMethodBeat.i(207499);
    if (this.ZSQ.size() <= 0)
    {
      AppMethodBeat.o(207499);
      return true;
    }
    int i = 0;
    while (i < this.ZSQ.size())
    {
      Object localObject = (com.tencent.h.a.b.c.b.a)this.ZSQ.valueAt(i);
      if (localObject != null)
      {
        localObject = ((com.tencent.h.a.b.c.b.a)localObject).iuc();
        i.i("sensor_SensorTask", "[method: notifyTaskDataPush ] controller getPointerSize : " + ((List)localObject).size());
        la((List)localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(207499);
    return true;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(207505);
    int k;
    Object localObject;
    try
    {
      k = paramSensorEvent.sensor.getType();
      locala = (com.tencent.h.a.b.c.b.a)this.ZSQ.get(k);
      if (locala == null)
      {
        AppMethodBeat.o(207505);
        return;
      }
      if (paramSensorEvent == null)
      {
        i.i("sensor_EventController", "[method: isFilterEvent ] ");
        i = 1;
        break label809;
        if (localObject != null)
        {
          ((g)localObject).Zqg = locala.WZ(paramSensorEvent.timestamp);
          if (localObject != null)
          {
            locala.ZTa.add(localObject);
            locala.ZTb = ((g)localObject).Zqg;
          }
          if (locala.iud() >= 5) {
            la(locala.iuc());
          }
        }
        if (paramSensorEvent != null)
        {
          paramSensorEvent.fkN[0] = (0.0F / 0.0F);
          paramSensorEvent.fkN[1] = (0.0F / 0.0F);
          paramSensorEvent.fkN[2] = (0.0F / 0.0F);
          paramSensorEvent.timestamp = 0L;
        }
        label156:
        AppMethodBeat.o(207505);
      }
      else
      {
        if ((paramSensorEvent.timestamp > 0L) && (locala.HQh)) {
          break label895;
        }
        locala.HQh = true;
        i.i("sensor_EventController", "[method: isFilterEvent ] " + paramSensorEvent.timestamp);
        i = 1;
      }
    }
    catch (Throwable paramSensorEvent)
    {
      com.tencent.h.a.b.c.b.a locala;
      label214:
      label224:
      long l1;
      long l2;
      label285:
      itK().ZSs.b(paramSensorEvent, "onSensorChanged");
      AppMethodBeat.o(207505);
      return;
    }
    if (locala.ZSX <= 0)
    {
      i = 1;
      if (i != 0)
      {
        paramSensorEvent = com.tencent.h.a.b.c.b.a.a(paramSensorEvent, locala.iub());
      }
      else
      {
        l1 = locala.WZ(paramSensorEvent.timestamp);
        l2 = l1 - locala.ZTb;
        i = 0;
        if (l2 >= locala.ZSX - 5L) {
          break label905;
        }
        i = 1;
        break label905;
        if (locala.ZSX != l2) {
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
        paramSensorEvent = com.tencent.h.a.b.c.b.a.a(paramSensorEvent, locala.iub());
      }
      else
      {
        int j = 0;
        i = j;
        if (locala.ZSZ != null)
        {
          i = j;
          if (locala.ZSZ.timestamp != 0L) {
            i = 1;
          }
        }
        if (i != 0)
        {
          l2 = locala.ZTb + locala.ZSX;
          if (Math.abs(l2 - locala.WZ(locala.iub().timestamp)) < Math.abs(l2 - l1)) {
            paramSensorEvent = locala.iub();
          } else {
            paramSensorEvent = com.tencent.h.a.b.c.b.a.a(paramSensorEvent, locala.iub());
          }
        }
        else
        {
          i = 0;
          if (l2 > locala.ZSX + 5L) {
            i = 1;
          }
          if (i != 0)
          {
            paramSensorEvent = com.tencent.h.a.b.c.b.a.a(paramSensorEvent, locala.iub());
          }
          else
          {
            com.tencent.h.a.b.c.b.a.a(paramSensorEvent, locala.iub());
            paramSensorEvent = null;
            break label815;
            localObject = new g();
            ((g)localObject).ZpN = 0;
            ((g)localObject).KxF = (paramSensorEvent.fkN[0] / 9.8F);
            ((g)localObject).KxG = (paramSensorEvent.fkN[1] / 9.8F);
            ((g)localObject).KxH = (paramSensorEvent.fkN[2] / 9.8F);
            break;
            localObject = new g();
            ((g)localObject).ZpN = 1;
            ((g)localObject).KxF = paramSensorEvent.fkN[0];
            break;
            localObject = new g();
            ((g)localObject).ZpN = 2;
            ((g)localObject).KxF = paramSensorEvent.fkN[0];
            ((g)localObject).KxG = paramSensorEvent.fkN[1];
            ((g)localObject).KxH = paramSensorEvent.fkN[2];
            break;
            localObject = new g();
            ((g)localObject).ZpN = 3;
            ((g)localObject).KxF = paramSensorEvent.fkN[0];
            break;
            localObject = new g();
            ((g)localObject).ZpN = 4;
            ((g)localObject).KxF = (paramSensorEvent.fkN[0] / 9.8F);
            ((g)localObject).KxG = (paramSensorEvent.fkN[1] / 9.8F);
            ((g)localObject).KxH = (-paramSensorEvent.fkN[2] / 9.8F);
            break;
            localObject = new g();
            ((g)localObject).ZpN = 5;
            ((g)localObject).KxF = paramSensorEvent.fkN[0];
            ((g)localObject).KxG = paramSensorEvent.fkN[1];
            ((g)localObject).KxH = paramSensorEvent.fkN[2];
            break;
            localObject = new g();
            ((g)localObject).ZpN = 6;
            ((g)localObject).KxF = paramSensorEvent.fkN[0];
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */