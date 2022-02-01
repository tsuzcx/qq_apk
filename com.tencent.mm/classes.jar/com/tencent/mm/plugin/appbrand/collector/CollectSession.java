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
  public final Bundle dvj;
  String groupId;
  String id;
  TimePoint jUO;
  TimePoint jUP;
  final Map<String, TimePoint> jUQ;
  String jUR;
  
  static
  {
    AppMethodBeat.i(146084);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146084);
  }
  
  CollectSession()
  {
    AppMethodBeat.i(146079);
    this.jUQ = new HashMap();
    this.dvj = new Bundle();
    AppMethodBeat.o(146079);
  }
  
  public CollectSession(String paramString)
  {
    AppMethodBeat.i(146080);
    this.jUQ = new HashMap();
    this.dvj = new Bundle();
    this.id = paramString;
    AppMethodBeat.o(146080);
  }
  
  public final void MT(String paramString)
  {
    AppMethodBeat.i(146082);
    Assert.assertNotNull(this.jUP);
    long l = System.nanoTime();
    TimePoint localTimePoint = (TimePoint)this.jUQ.get(paramString);
    if (localTimePoint == null)
    {
      localTimePoint = new TimePoint(paramString, l);
      localTimePoint.jUZ.set(1);
      this.jUQ.put(paramString, localTimePoint);
      this.jUP.jVb.set(localTimePoint);
      this.jUP = localTimePoint;
      AppMethodBeat.o(146082);
      return;
    }
    localTimePoint.jVa.set((l + localTimePoint.jVa.get() * localTimePoint.jUZ.get()) / (localTimePoint.jUZ.get() + 1));
    localTimePoint.jUZ.incrementAndGet();
    AppMethodBeat.o(146082);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void vP(String paramString)
  {
    AppMethodBeat.i(146081);
    Assert.assertNull(this.jUO);
    this.jUO = new TimePoint(paramString, System.nanoTime());
    this.jUP = this.jUO;
    this.jUO.jUZ.set(1);
    this.jUQ.put(paramString, this.jUO);
    AppMethodBeat.o(146081);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146083);
    paramParcel.writeString(this.groupId);
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.jUO, paramInt);
    paramParcel.writeString(this.jUR);
    paramParcel.writeBundle(this.dvj);
    AppMethodBeat.o(146083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.CollectSession
 * JD-Core Version:    0.7.0.1
 */