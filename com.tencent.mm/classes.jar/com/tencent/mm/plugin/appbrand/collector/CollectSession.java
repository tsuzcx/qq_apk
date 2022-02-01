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
  public final Bundle dlO;
  String groupId;
  String id;
  TimePoint jaG;
  TimePoint jaH;
  final Map<String, TimePoint> jaI;
  String jaJ;
  
  static
  {
    AppMethodBeat.i(146084);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146084);
  }
  
  CollectSession()
  {
    AppMethodBeat.i(146079);
    this.jaI = new HashMap();
    this.dlO = new Bundle();
    AppMethodBeat.o(146079);
  }
  
  public CollectSession(String paramString)
  {
    AppMethodBeat.i(146080);
    this.jaI = new HashMap();
    this.dlO = new Bundle();
    this.id = paramString;
    AppMethodBeat.o(146080);
  }
  
  public final void Fw(String paramString)
  {
    AppMethodBeat.i(146082);
    Assert.assertNotNull(this.jaH);
    long l = System.nanoTime();
    TimePoint localTimePoint = (TimePoint)this.jaI.get(paramString);
    if (localTimePoint == null)
    {
      localTimePoint = new TimePoint(paramString, l);
      localTimePoint.jaR.set(1);
      this.jaI.put(paramString, localTimePoint);
      this.jaH.jaT.set(localTimePoint);
      this.jaH = localTimePoint;
      AppMethodBeat.o(146082);
      return;
    }
    localTimePoint.jaS.set((l + localTimePoint.jaS.get() * localTimePoint.jaR.get()) / (localTimePoint.jaR.get() + 1));
    localTimePoint.jaR.incrementAndGet();
    AppMethodBeat.o(146082);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void pP(String paramString)
  {
    AppMethodBeat.i(146081);
    Assert.assertNull(this.jaG);
    this.jaG = new TimePoint(paramString, System.nanoTime());
    this.jaH = this.jaG;
    this.jaG.jaR.set(1);
    this.jaI.put(paramString, this.jaG);
    AppMethodBeat.o(146081);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146083);
    paramParcel.writeString(this.groupId);
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.jaG, paramInt);
    paramParcel.writeString(this.jaJ);
    paramParcel.writeBundle(this.dlO);
    AppMethodBeat.o(146083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.CollectSession
 * JD-Core Version:    0.7.0.1
 */