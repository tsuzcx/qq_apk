package com.tencent.i.a.b.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.h.c.h;
import com.tencent.i.a.a.d;
import com.tencent.i.a.b.c.a.e;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.j;
import com.tencent.i.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a
  extends com.tencent.i.a.b.c.a.a
  implements SensorEventListener
{
  private com.tencent.i.a.b.c.a.c Srl;
  private com.tencent.i.a.a.a Srm;
  private final SparseArray<com.tencent.i.a.b.c.b.a> Srn;
  private final Object mLock;
  private SensorManager mSensorManager;
  
  public a(com.tencent.i.a.a.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(214703);
    this.Srm = new com.tencent.i.a.a.a("sensor_task") {};
    this.Srn = new SparseArray();
    this.mLock = new Object();
    AppMethodBeat.o(214703);
  }
  
  private void kg(List<g> paramList)
  {
    AppMethodBeat.i(214708);
    synchronized (this.mLock)
    {
      if ((this.Srl != null) && (paramList != null) && (!paramList.isEmpty())) {
        this.Srl.kf(paramList);
      }
      AppMethodBeat.o(214708);
      return;
    }
  }
  
  public final boolean Qt()
  {
    AppMethodBeat.i(214706);
    synchronized (this.mLock)
    {
      this.Srl = null;
      h.i("sensor_SensorTask", "[method: unregisterSensor ] unregister sensor: " + Thread.currentThread().getName());
      if ((this.mSensorManager == null) || (this.Srn.size() <= 0))
      {
        AppMethodBeat.o(214706);
        return true;
      }
    }
    int i = 0;
    while (i < this.Srn.size())
    {
      ??? = (com.tencent.i.a.b.c.b.a)this.Srn.valueAt(i);
      if ((??? != null) && (((com.tencent.i.a.b.c.b.a)???).pKK != null))
      {
        h.i("sensor_SensorTask", "[method: stop ] controller getPointerSize : " + ((com.tencent.i.a.b.c.b.a)???).hqu());
        this.mSensorManager.unregisterListener(this, ((com.tencent.i.a.b.c.b.a)???).pKK);
      }
      i += 1;
    }
    this.Srn.clear();
    AppMethodBeat.o(214706);
    return true;
  }
  
  public final void a(e parame)
  {
    this.Srl = ((com.tencent.i.a.b.c.a.c)parame);
  }
  
  public final int getTaskId()
  {
    return 0;
  }
  
  public final boolean hqp()
  {
    AppMethodBeat.i(214704);
    int[] arrayOfInt = d.SqU;
    if (arrayOfInt.length <= 0) {
      arrayOfInt = d.SqT;
    }
    for (;;)
    {
      int m = this.SqM.SqN.hqa().Sqy;
      if (this.mSensorManager == null) {
        this.mSensorManager = ((SensorManager)this.SqM.mAppContext.getSystemService("sensor"));
      }
      this.Srn.clear();
      h.i("sensor_SensorTask", "[method: registerSensor ] begin register sensor");
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
          h.i("sensor_SensorTask", bool);
          if (localSensor != null)
          {
            localObject = new com.tencent.i.a.b.c.b.a(localSensor, m);
            this.Srn.put(i1, localObject);
            this.mSensorManager.registerListener(this, localSensor, 0, this.Srm.Son);
          }
          j += 1;
          break;
        }
        h.i("sensor_SensorTask", "[method: registerSensor ] register completed");
        AppMethodBeat.o(214704);
        return true;
      }
    }
  }
  
  public final boolean hqq()
  {
    AppMethodBeat.i(214705);
    if (this.Srn.size() <= 0)
    {
      AppMethodBeat.o(214705);
      return true;
    }
    int i = 0;
    while (i < this.Srn.size())
    {
      Object localObject = (com.tencent.i.a.b.c.b.a)this.Srn.valueAt(i);
      if (localObject != null)
      {
        localObject = ((com.tencent.i.a.b.c.b.a)localObject).hqt();
        h.i("sensor_SensorTask", "[method: notifyTaskDataPush ] controller getPointerSize : " + ((List)localObject).size());
        kg((List)localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(214705);
    return true;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(214707);
    int k;
    Object localObject;
    try
    {
      k = paramSensorEvent.sensor.getType();
      locala = (com.tencent.i.a.b.c.b.a)this.Srn.get(k);
      if (locala == null)
      {
        AppMethodBeat.o(214707);
        return;
      }
      if (paramSensorEvent == null)
      {
        h.i("sensor_EventController", "[method: isFilterEvent ] ");
        i = 1;
        break label809;
        if (localObject != null)
        {
          ((g)localObject).RNA = locala.OJ(paramSensorEvent.timestamp);
          if (localObject != null)
          {
            locala.Srx.add(localObject);
            locala.Sry = ((g)localObject).RNA;
          }
          if (locala.hqu() >= 5) {
            kg(locala.hqt());
          }
        }
        if (paramSensorEvent != null)
        {
          paramSensorEvent.values[0] = (0.0F / 0.0F);
          paramSensorEvent.values[1] = (0.0F / 0.0F);
          paramSensorEvent.values[2] = (0.0F / 0.0F);
          paramSensorEvent.timestamp = 0L;
        }
        label156:
        AppMethodBeat.o(214707);
      }
      else
      {
        if ((paramSensorEvent.timestamp > 0L) && (locala.BTt)) {
          break label895;
        }
        locala.BTt = true;
        h.i("sensor_EventController", "[method: isFilterEvent ] " + paramSensorEvent.timestamp);
        i = 1;
      }
    }
    catch (Throwable paramSensorEvent)
    {
      com.tencent.i.a.b.c.b.a locala;
      label214:
      label224:
      long l1;
      long l2;
      label285:
      this.SqM.SqP.b(paramSensorEvent, "onSensorChanged");
      AppMethodBeat.o(214707);
      return;
    }
    if (locala.Sru <= 0)
    {
      i = 1;
      if (i != 0)
      {
        paramSensorEvent = com.tencent.i.a.b.c.b.a.a(paramSensorEvent, locala.hqs());
      }
      else
      {
        l1 = locala.OJ(paramSensorEvent.timestamp);
        l2 = l1 - locala.Sry;
        i = 0;
        if (l2 >= locala.Sru - 5L) {
          break label905;
        }
        i = 1;
        break label905;
        if (locala.Sru != l2) {
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
        paramSensorEvent = com.tencent.i.a.b.c.b.a.a(paramSensorEvent, locala.hqs());
      }
      else
      {
        int j = 0;
        i = j;
        if (locala.Srw != null)
        {
          i = j;
          if (locala.Srw.timestamp != 0L) {
            i = 1;
          }
        }
        if (i != 0)
        {
          l2 = locala.Sry + locala.Sru;
          if (Math.abs(l2 - locala.OJ(locala.hqs().timestamp)) < Math.abs(l2 - l1)) {
            paramSensorEvent = locala.hqs();
          } else {
            paramSensorEvent = com.tencent.i.a.b.c.b.a.a(paramSensorEvent, locala.hqs());
          }
        }
        else
        {
          i = 0;
          if (l2 > locala.Sru + 5L) {
            i = 1;
          }
          if (i != 0)
          {
            paramSensorEvent = com.tencent.i.a.b.c.b.a.a(paramSensorEvent, locala.hqs());
          }
          else
          {
            com.tencent.i.a.b.c.b.a.a(paramSensorEvent, locala.hqs());
            paramSensorEvent = null;
            break label815;
            localObject = new g();
            ((g)localObject).RNh = 0;
            ((g)localObject).Ekw = (paramSensorEvent.values[0] / 9.8F);
            ((g)localObject).Ekx = (paramSensorEvent.values[1] / 9.8F);
            ((g)localObject).Eky = (paramSensorEvent.values[2] / 9.8F);
            break;
            localObject = new g();
            ((g)localObject).RNh = 1;
            ((g)localObject).Ekw = paramSensorEvent.values[0];
            break;
            localObject = new g();
            ((g)localObject).RNh = 2;
            ((g)localObject).Ekw = paramSensorEvent.values[0];
            ((g)localObject).Ekx = paramSensorEvent.values[1];
            ((g)localObject).Eky = paramSensorEvent.values[2];
            break;
            localObject = new g();
            ((g)localObject).RNh = 3;
            ((g)localObject).Ekw = paramSensorEvent.values[0];
            break;
            localObject = new g();
            ((g)localObject).RNh = 4;
            ((g)localObject).Ekw = (paramSensorEvent.values[0] / 9.8F);
            ((g)localObject).Ekx = (paramSensorEvent.values[1] / 9.8F);
            ((g)localObject).Eky = (-paramSensorEvent.values[2] / 9.8F);
            break;
            localObject = new g();
            ((g)localObject).RNh = 5;
            ((g)localObject).Ekw = paramSensorEvent.values[0];
            ((g)localObject).Ekx = paramSensorEvent.values[1];
            ((g)localObject).Eky = paramSensorEvent.values[2];
            break;
            localObject = new g();
            ((g)localObject).RNh = 6;
            ((g)localObject).Ekw = paramSensorEvent.values[0];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */