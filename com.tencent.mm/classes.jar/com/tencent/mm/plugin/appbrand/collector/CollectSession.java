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
  String groupId;
  public final Bundle hMD;
  String id;
  TimePoint qUW;
  TimePoint qUX;
  final Map<String, TimePoint> qUY;
  String qUZ;
  
  static
  {
    AppMethodBeat.i(146084);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146084);
  }
  
  CollectSession()
  {
    AppMethodBeat.i(146079);
    this.qUY = new HashMap();
    this.hMD = new Bundle();
    AppMethodBeat.o(146079);
  }
  
  public CollectSession(String paramString)
  {
    AppMethodBeat.i(146080);
    this.qUY = new HashMap();
    this.hMD = new Bundle();
    this.id = paramString;
    AppMethodBeat.o(146080);
  }
  
  public final void WW(String paramString)
  {
    AppMethodBeat.i(146081);
    Assert.assertNull(this.qUW);
    this.qUW = new TimePoint(paramString, System.nanoTime());
    this.qUX = this.qUW;
    this.qUW.qVh.set(1);
    this.qUY.put(paramString, this.qUW);
    AppMethodBeat.o(146081);
  }
  
  public final void WX(String paramString)
  {
    AppMethodBeat.i(146082);
    Assert.assertNotNull(this.qUX);
    long l = System.nanoTime();
    TimePoint localTimePoint = (TimePoint)this.qUY.get(paramString);
    if (localTimePoint == null)
    {
      localTimePoint = new TimePoint(paramString, l);
      localTimePoint.qVh.set(1);
      this.qUY.put(paramString, localTimePoint);
      this.qUX.qVj.set(localTimePoint);
      this.qUX = localTimePoint;
      AppMethodBeat.o(146082);
      return;
    }
    localTimePoint.qVi.set((l + localTimePoint.qVi.get() * localTimePoint.qVh.get()) / (localTimePoint.qVh.get() + 1));
    localTimePoint.qVh.incrementAndGet();
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
    paramParcel.writeParcelable(this.qUW, paramInt);
    paramParcel.writeString(this.qUZ);
    paramParcel.writeBundle(this.hMD);
    AppMethodBeat.o(146083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.CollectSession
 * JD-Core Version:    0.7.0.1
 */