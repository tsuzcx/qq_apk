package com.tencent.h.a.b.c.b;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.SystemClock;
import com.tencent.g.c.i;
import com.tencent.h.a.c.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public Sensor Mug;
  public boolean NMQ;
  public List<g> ahXA;
  public long ahXB;
  public int ahXx;
  private long ahXy;
  public b ahXz;
  private long bwi;
  
  public a(Sensor paramSensor, int paramInt)
  {
    AppMethodBeat.i(212137);
    this.ahXy = 0L;
    this.bwi = this.ahXy;
    this.ahXz = null;
    this.ahXA = new ArrayList();
    this.NMQ = false;
    this.Mug = paramSensor;
    int i = paramInt;
    if (paramInt > 0) {
      i = 1000 / paramInt;
    }
    this.ahXx = i;
    i.i("sensor_EventController", "[method: SCMode ] mFrequencyInterval : " + this.ahXx);
    AppMethodBeat.o(212137);
  }
  
  public static b a(SensorEvent paramSensorEvent, b paramb)
  {
    if ((paramSensorEvent == null) || (paramb == null)) {
      return null;
    }
    if ((paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0)) {
      paramb.hpa[0] = paramSensorEvent.values[0];
    }
    if ((paramSensorEvent.values != null) && (paramSensorEvent.values.length > 1)) {
      paramb.hpa[1] = paramSensorEvent.values[1];
    }
    if ((paramSensorEvent.values != null) && (paramSensorEvent.values.length > 2)) {
      paramb.hpa[2] = paramSensorEvent.values[2];
    }
    paramb.timestamp = paramSensorEvent.timestamp;
    return paramb;
  }
  
  private void clearBuffer()
  {
    AppMethodBeat.i(212146);
    this.ahXA.clear();
    AppMethodBeat.o(212146);
  }
  
  public final long Bm(long paramLong)
  {
    AppMethodBeat.i(212153);
    long l1 = paramLong / 1000000L;
    long l2 = SystemClock.uptimeMillis();
    long l3 = l1 - l2 - this.bwi;
    if ((this.bwi == this.ahXy) || (l3 >= 1000L))
    {
      this.bwi = (l1 - l2);
      i.i("sensor_EventController", "[method: calculateTimestamp ] timestamp : " + paramLong + ", mDeltaTime : " + this.bwi + "curt : " + l2 + ", deltaInterval : " + l3);
    }
    paramLong = this.bwi;
    AppMethodBeat.o(212153);
    return l1 - paramLong;
  }
  
  public final b kdx()
  {
    AppMethodBeat.i(212159);
    if (this.ahXz == null) {
      this.ahXz = new b();
    }
    b localb = this.ahXz;
    AppMethodBeat.o(212159);
    return localb;
  }
  
  public final List<g> kdy()
  {
    AppMethodBeat.i(212167);
    if ((this.ahXA == null) || (this.ahXA.size() <= 0))
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(212167);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList(this.ahXA);
    clearBuffer();
    AppMethodBeat.o(212167);
    return localArrayList;
  }
  
  public final int kdz()
  {
    AppMethodBeat.i(212170);
    int i = this.ahXA.size();
    AppMethodBeat.o(212170);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.b.c.b.a
 * JD-Core Version:    0.7.0.1
 */