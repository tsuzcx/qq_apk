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
  public final Bundle dNV;
  String groupId;
  String id;
  TimePoint lbd;
  TimePoint lbe;
  final Map<String, TimePoint> lbf;
  String lbg;
  
  static
  {
    AppMethodBeat.i(146084);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146084);
  }
  
  CollectSession()
  {
    AppMethodBeat.i(146079);
    this.lbf = new HashMap();
    this.dNV = new Bundle();
    AppMethodBeat.o(146079);
  }
  
  public CollectSession(String paramString)
  {
    AppMethodBeat.i(146080);
    this.lbf = new HashMap();
    this.dNV = new Bundle();
    this.id = paramString;
    AppMethodBeat.o(146080);
  }
  
  public final void EL(String paramString)
  {
    AppMethodBeat.i(146081);
    Assert.assertNull(this.lbd);
    this.lbd = new TimePoint(paramString, System.nanoTime());
    this.lbe = this.lbd;
    this.lbd.lbo.set(1);
    this.lbf.put(paramString, this.lbd);
    AppMethodBeat.o(146081);
  }
  
  public final void WI(String paramString)
  {
    AppMethodBeat.i(146082);
    Assert.assertNotNull(this.lbe);
    long l = System.nanoTime();
    TimePoint localTimePoint = (TimePoint)this.lbf.get(paramString);
    if (localTimePoint == null)
    {
      localTimePoint = new TimePoint(paramString, l);
      localTimePoint.lbo.set(1);
      this.lbf.put(paramString, localTimePoint);
      this.lbe.lbq.set(localTimePoint);
      this.lbe = localTimePoint;
      AppMethodBeat.o(146082);
      return;
    }
    localTimePoint.lbp.set((l + localTimePoint.lbp.get() * localTimePoint.lbo.get()) / (localTimePoint.lbo.get() + 1));
    localTimePoint.lbo.incrementAndGet();
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
    paramParcel.writeParcelable(this.lbd, paramInt);
    paramParcel.writeString(this.lbg);
    paramParcel.writeBundle(this.dNV);
    AppMethodBeat.o(146083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.CollectSession
 * JD-Core Version:    0.7.0.1
 */