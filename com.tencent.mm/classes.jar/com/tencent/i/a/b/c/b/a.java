package com.tencent.i.a.b.c.b;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.SystemClock;
import com.tencent.h.c.h;
import com.tencent.i.a.c.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public boolean BTt;
  public int Sru;
  private long Srv;
  public b Srw;
  public List<g> Srx;
  public long Sry;
  private long Sx;
  public Sensor pKK;
  
  public a(Sensor paramSensor, int paramInt)
  {
    AppMethodBeat.i(214714);
    this.Srv = 0L;
    this.Sx = this.Srv;
    this.Srw = null;
    this.Srx = new ArrayList();
    this.BTt = false;
    this.pKK = paramSensor;
    int i = paramInt;
    if (paramInt > 0) {
      i = 1000 / paramInt;
    }
    this.Sru = i;
    h.i("sensor_EventController", "[method: SCMode ] mFrequencyInterval : " + this.Sru);
    AppMethodBeat.o(214714);
  }
  
  public static b a(SensorEvent paramSensorEvent, b paramb)
  {
    if ((paramSensorEvent == null) || (paramb == null)) {
      return null;
    }
    if ((paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0)) {
      paramb.values[0] = paramSensorEvent.values[0];
    }
    if ((paramSensorEvent.values != null) && (paramSensorEvent.values.length > 1)) {
      paramb.values[1] = paramSensorEvent.values[1];
    }
    if ((paramSensorEvent.values != null) && (paramSensorEvent.values.length > 2)) {
      paramb.values[2] = paramSensorEvent.values[2];
    }
    paramb.timestamp = paramSensorEvent.timestamp;
    return paramb;
  }
  
  private void clearBuffer()
  {
    AppMethodBeat.i(214719);
    this.Srx.clear();
    AppMethodBeat.o(214719);
  }
  
  public final long OJ(long paramLong)
  {
    AppMethodBeat.i(214715);
    long l1 = paramLong / 1000000L;
    long l2 = SystemClock.uptimeMillis();
    long l3 = l1 - l2 - this.Sx;
    if ((this.Sx == this.Srv) || (l3 >= 1000L))
    {
      this.Sx = (l1 - l2);
      h.i("sensor_EventController", "[method: calculateTimestamp ] timestamp : " + paramLong + ", mDeltaTime : " + this.Sx + "curt : " + l2 + ", deltaInterval : " + l3);
    }
    paramLong = this.Sx;
    AppMethodBeat.o(214715);
    return l1 - paramLong;
  }
  
  public final b hqs()
  {
    AppMethodBeat.i(214716);
    if (this.Srw == null) {
      this.Srw = new b();
    }
    b localb = this.Srw;
    AppMethodBeat.o(214716);
    return localb;
  }
  
  public final List<g> hqt()
  {
    AppMethodBeat.i(214717);
    if ((this.Srx == null) || (this.Srx.size() <= 0))
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(214717);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList(this.Srx);
    clearBuffer();
    AppMethodBeat.o(214717);
    return localArrayList;
  }
  
  public final int hqu()
  {
    AppMethodBeat.i(214718);
    int i = this.Srx.size();
    AppMethodBeat.o(214718);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.b.c.b.a
 * JD-Core Version:    0.7.0.1
 */