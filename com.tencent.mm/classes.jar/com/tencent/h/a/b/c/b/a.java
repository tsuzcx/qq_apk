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
  public Sensor GxY;
  public boolean HQh;
  private long PQ;
  public int ZSX;
  private long ZSY;
  public b ZSZ;
  public List<g> ZTa;
  public long ZTb;
  
  public a(Sensor paramSensor, int paramInt)
  {
    AppMethodBeat.i(208644);
    this.ZSY = 0L;
    this.PQ = this.ZSY;
    this.ZSZ = null;
    this.ZTa = new ArrayList();
    this.HQh = false;
    this.GxY = paramSensor;
    int i = paramInt;
    if (paramInt > 0) {
      i = 1000 / paramInt;
    }
    this.ZSX = i;
    i.i("sensor_EventController", "[method: SCMode ] mFrequencyInterval : " + this.ZSX);
    AppMethodBeat.o(208644);
  }
  
  public static b a(SensorEvent paramSensorEvent, b paramb)
  {
    if ((paramSensorEvent == null) || (paramb == null)) {
      return null;
    }
    if ((paramSensorEvent.values != null) && (paramSensorEvent.values.length > 0)) {
      paramb.fkN[0] = paramSensorEvent.values[0];
    }
    if ((paramSensorEvent.values != null) && (paramSensorEvent.values.length > 1)) {
      paramb.fkN[1] = paramSensorEvent.values[1];
    }
    if ((paramSensorEvent.values != null) && (paramSensorEvent.values.length > 2)) {
      paramb.fkN[2] = paramSensorEvent.values[2];
    }
    paramb.timestamp = paramSensorEvent.timestamp;
    return paramb;
  }
  
  private void clearBuffer()
  {
    AppMethodBeat.i(208650);
    this.ZTa.clear();
    AppMethodBeat.o(208650);
  }
  
  public final long WZ(long paramLong)
  {
    AppMethodBeat.i(208645);
    long l1 = paramLong / 1000000L;
    long l2 = SystemClock.uptimeMillis();
    long l3 = l1 - l2 - this.PQ;
    if ((this.PQ == this.ZSY) || (l3 >= 1000L))
    {
      this.PQ = (l1 - l2);
      i.i("sensor_EventController", "[method: calculateTimestamp ] timestamp : " + paramLong + ", mDeltaTime : " + this.PQ + "curt : " + l2 + ", deltaInterval : " + l3);
    }
    paramLong = this.PQ;
    AppMethodBeat.o(208645);
    return l1 - paramLong;
  }
  
  public final b iub()
  {
    AppMethodBeat.i(208646);
    if (this.ZSZ == null) {
      this.ZSZ = new b();
    }
    b localb = this.ZSZ;
    AppMethodBeat.o(208646);
    return localb;
  }
  
  public final List<g> iuc()
  {
    AppMethodBeat.i(208647);
    if ((this.ZTa == null) || (this.ZTa.size() <= 0))
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(208647);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList(this.ZTa);
    clearBuffer();
    AppMethodBeat.o(208647);
    return localArrayList;
  }
  
  public final int iud()
  {
    AppMethodBeat.i(208649);
    int i = this.ZTa.size();
    AppMethodBeat.o(208649);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.b.c.b.a
 * JD-Core Version:    0.7.0.1
 */