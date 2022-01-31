package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import junit.framework.Assert;

public class CollectSession
  implements Parcelable
{
  public static final Parcelable.Creator<CollectSession> CREATOR;
  public final Bundle cwp;
  String groupId;
  TimePoint hgv;
  TimePoint hgw;
  final Map<String, TimePoint> hgx;
  String hgy;
  String id;
  
  static
  {
    AppMethodBeat.i(57019);
    CREATOR = new CollectSession.1();
    AppMethodBeat.o(57019);
  }
  
  CollectSession()
  {
    AppMethodBeat.i(57014);
    this.hgx = new HashMap();
    this.cwp = new Bundle();
    AppMethodBeat.o(57014);
  }
  
  public CollectSession(String paramString)
  {
    AppMethodBeat.i(57015);
    this.hgx = new HashMap();
    this.cwp = new Bundle();
    this.id = paramString;
    AppMethodBeat.o(57015);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(57018);
    paramParcel.writeString(this.groupId);
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.hgv, paramInt);
    paramParcel.writeString(this.hgy);
    paramParcel.writeBundle(this.cwp);
    AppMethodBeat.o(57018);
  }
  
  public final void zH(String paramString)
  {
    AppMethodBeat.i(57016);
    Assert.assertNull(this.hgv);
    this.hgv = new TimePoint(paramString, System.nanoTime());
    this.hgw = this.hgv;
    this.hgv.hgG.set(1);
    this.hgx.put(paramString, this.hgv);
    AppMethodBeat.o(57016);
  }
  
  public final void zI(String paramString)
  {
    AppMethodBeat.i(57017);
    Assert.assertNotNull(this.hgw);
    long l = System.nanoTime();
    TimePoint localTimePoint = (TimePoint)this.hgx.get(paramString);
    if (localTimePoint == null)
    {
      localTimePoint = new TimePoint(paramString, l);
      localTimePoint.hgG.set(1);
      this.hgx.put(paramString, localTimePoint);
      this.hgw.hgI.set(localTimePoint);
      this.hgw = localTimePoint;
      AppMethodBeat.o(57017);
      return;
    }
    localTimePoint.hgH.set((l + localTimePoint.hgH.get() * localTimePoint.hgG.get()) / (localTimePoint.hgG.get() + 1));
    localTimePoint.hgG.incrementAndGet();
    AppMethodBeat.o(57017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.CollectSession
 * JD-Core Version:    0.7.0.1
 */