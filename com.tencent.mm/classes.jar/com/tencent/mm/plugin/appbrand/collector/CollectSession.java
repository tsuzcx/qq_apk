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
  public final Bundle fHg;
  String groupId;
  String id;
  TimePoint nVm;
  TimePoint nVn;
  final Map<String, TimePoint> nVo;
  String nVp;
  
  static
  {
    AppMethodBeat.i(146084);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146084);
  }
  
  CollectSession()
  {
    AppMethodBeat.i(146079);
    this.nVo = new HashMap();
    this.fHg = new Bundle();
    AppMethodBeat.o(146079);
  }
  
  public CollectSession(String paramString)
  {
    AppMethodBeat.i(146080);
    this.nVo = new HashMap();
    this.fHg = new Bundle();
    this.id = paramString;
    AppMethodBeat.o(146080);
  }
  
  public final void aet(String paramString)
  {
    AppMethodBeat.i(146081);
    Assert.assertNull(this.nVm);
    this.nVm = new TimePoint(paramString, System.nanoTime());
    this.nVn = this.nVm;
    this.nVm.nVx.set(1);
    this.nVo.put(paramString, this.nVm);
    AppMethodBeat.o(146081);
  }
  
  public final void aeu(String paramString)
  {
    AppMethodBeat.i(146082);
    Assert.assertNotNull(this.nVn);
    long l = System.nanoTime();
    TimePoint localTimePoint = (TimePoint)this.nVo.get(paramString);
    if (localTimePoint == null)
    {
      localTimePoint = new TimePoint(paramString, l);
      localTimePoint.nVx.set(1);
      this.nVo.put(paramString, localTimePoint);
      this.nVn.nVz.set(localTimePoint);
      this.nVn = localTimePoint;
      AppMethodBeat.o(146082);
      return;
    }
    localTimePoint.nVy.set((l + localTimePoint.nVy.get() * localTimePoint.nVx.get()) / (localTimePoint.nVx.get() + 1));
    localTimePoint.nVx.incrementAndGet();
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
    paramParcel.writeParcelable(this.nVm, paramInt);
    paramParcel.writeString(this.nVp);
    paramParcel.writeBundle(this.fHg);
    AppMethodBeat.o(146083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.CollectSession
 * JD-Core Version:    0.7.0.1
 */