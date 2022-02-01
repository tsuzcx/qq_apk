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
  public final Bundle djw;
  String groupId;
  String id;
  TimePoint jAT;
  TimePoint jAU;
  final Map<String, TimePoint> jAV;
  String jAW;
  
  static
  {
    AppMethodBeat.i(146084);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146084);
  }
  
  CollectSession()
  {
    AppMethodBeat.i(146079);
    this.jAV = new HashMap();
    this.djw = new Bundle();
    AppMethodBeat.o(146079);
  }
  
  public CollectSession(String paramString)
  {
    AppMethodBeat.i(146080);
    this.jAV = new HashMap();
    this.djw = new Bundle();
    this.id = paramString;
    AppMethodBeat.o(146080);
  }
  
  public final void JA(String paramString)
  {
    AppMethodBeat.i(146082);
    Assert.assertNotNull(this.jAU);
    long l = System.nanoTime();
    TimePoint localTimePoint = (TimePoint)this.jAV.get(paramString);
    if (localTimePoint == null)
    {
      localTimePoint = new TimePoint(paramString, l);
      localTimePoint.jBe.set(1);
      this.jAV.put(paramString, localTimePoint);
      this.jAU.jBg.set(localTimePoint);
      this.jAU = localTimePoint;
      AppMethodBeat.o(146082);
      return;
    }
    localTimePoint.jBf.set((l + localTimePoint.jBf.get() * localTimePoint.jBe.get()) / (localTimePoint.jBe.get() + 1));
    localTimePoint.jBe.incrementAndGet();
    AppMethodBeat.o(146082);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void ta(String paramString)
  {
    AppMethodBeat.i(146081);
    Assert.assertNull(this.jAT);
    this.jAT = new TimePoint(paramString, System.nanoTime());
    this.jAU = this.jAT;
    this.jAT.jBe.set(1);
    this.jAV.put(paramString, this.jAT);
    AppMethodBeat.o(146081);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146083);
    paramParcel.writeString(this.groupId);
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.jAT, paramInt);
    paramParcel.writeString(this.jAW);
    paramParcel.writeBundle(this.djw);
    AppMethodBeat.o(146083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.CollectSession
 * JD-Core Version:    0.7.0.1
 */