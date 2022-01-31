package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import junit.framework.Assert;

public class CollectSession
  implements Parcelable
{
  public static final Parcelable.Creator<CollectSession> CREATOR = new CollectSession.1();
  public final Bundle bOY = new Bundle();
  TimePoint fNl;
  TimePoint fNm;
  final Map<String, TimePoint> fNn = new HashMap();
  String fNo;
  String groupId;
  String id;
  
  CollectSession() {}
  
  public CollectSession(String paramString)
  {
    this.id = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void rR(String paramString)
  {
    Assert.assertNull(this.fNl);
    this.fNl = new TimePoint(paramString, System.nanoTime());
    this.fNm = this.fNl;
    this.fNl.fNw.set(1);
    this.fNn.put(paramString, this.fNl);
  }
  
  public final void rS(String paramString)
  {
    Assert.assertNotNull(this.fNm);
    long l = System.nanoTime();
    TimePoint localTimePoint = (TimePoint)this.fNn.get(paramString);
    if (localTimePoint == null)
    {
      localTimePoint = new TimePoint(paramString, l);
      localTimePoint.fNw.set(1);
      this.fNn.put(paramString, localTimePoint);
      this.fNm.fNy.set(localTimePoint);
      this.fNm = localTimePoint;
      return;
    }
    localTimePoint.fNx.set((l + localTimePoint.fNx.get() * localTimePoint.fNw.get()) / (localTimePoint.fNw.get() + 1));
    localTimePoint.fNw.incrementAndGet();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.groupId);
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.fNl, paramInt);
    paramParcel.writeString(this.fNo);
    paramParcel.writeBundle(this.bOY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.CollectSession
 * JD-Core Version:    0.7.0.1
 */