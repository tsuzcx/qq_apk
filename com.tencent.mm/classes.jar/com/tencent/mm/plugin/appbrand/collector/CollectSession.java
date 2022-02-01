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
  public final Bundle dwo;
  String groupId;
  String id;
  TimePoint jYf;
  TimePoint jYg;
  final Map<String, TimePoint> jYh;
  String jYi;
  
  static
  {
    AppMethodBeat.i(146084);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146084);
  }
  
  CollectSession()
  {
    AppMethodBeat.i(146079);
    this.jYh = new HashMap();
    this.dwo = new Bundle();
    AppMethodBeat.o(146079);
  }
  
  public CollectSession(String paramString)
  {
    AppMethodBeat.i(146080);
    this.jYh = new HashMap();
    this.dwo = new Bundle();
    this.id = paramString;
    AppMethodBeat.o(146080);
  }
  
  public final void NA(String paramString)
  {
    AppMethodBeat.i(146082);
    Assert.assertNotNull(this.jYg);
    long l = System.nanoTime();
    TimePoint localTimePoint = (TimePoint)this.jYh.get(paramString);
    if (localTimePoint == null)
    {
      localTimePoint = new TimePoint(paramString, l);
      localTimePoint.jYq.set(1);
      this.jYh.put(paramString, localTimePoint);
      this.jYg.jYs.set(localTimePoint);
      this.jYg = localTimePoint;
      AppMethodBeat.o(146082);
      return;
    }
    localTimePoint.jYr.set((l + localTimePoint.jYr.get() * localTimePoint.jYq.get()) / (localTimePoint.jYq.get() + 1));
    localTimePoint.jYq.incrementAndGet();
    AppMethodBeat.o(146082);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146083);
    paramParcel.writeString(this.groupId);
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.jYf, paramInt);
    paramParcel.writeString(this.jYi);
    paramParcel.writeBundle(this.dwo);
    AppMethodBeat.o(146083);
  }
  
  public final void ww(String paramString)
  {
    AppMethodBeat.i(146081);
    Assert.assertNull(this.jYf);
    this.jYf = new TimePoint(paramString, System.nanoTime());
    this.jYg = this.jYf;
    this.jYf.jYq.set(1);
    this.jYh.put(paramString, this.jYf);
    AppMethodBeat.o(146081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.CollectSession
 * JD-Core Version:    0.7.0.1
 */