package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask
  extends Task
{
  public static final Parcelable.Creator<PeriodicTask> CREATOR = new PeriodicTask.1();
  protected long mFlexInSeconds = -1L;
  protected long mIntervalInSeconds = -1L;
  
  @Deprecated
  private PeriodicTask(Parcel paramParcel)
  {
    super(paramParcel);
    this.mIntervalInSeconds = paramParcel.readLong();
    this.mFlexInSeconds = Math.min(paramParcel.readLong(), this.mIntervalInSeconds);
  }
  
  private PeriodicTask(PeriodicTask.Builder paramBuilder)
  {
    super(paramBuilder);
    this.mIntervalInSeconds = PeriodicTask.Builder.zza(paramBuilder);
    this.mFlexInSeconds = Math.min(PeriodicTask.Builder.zzb(paramBuilder), this.mIntervalInSeconds);
  }
  
  public long getFlex()
  {
    return this.mFlexInSeconds;
  }
  
  public long getPeriod()
  {
    return this.mIntervalInSeconds;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putLong("period", this.mIntervalInSeconds);
    paramBundle.putLong("period_flex", this.mFlexInSeconds);
  }
  
  public String toString()
  {
    String str = String.valueOf(super.toString());
    long l1 = getPeriod();
    long l2 = getFlex();
    return String.valueOf(str).length() + 54 + str + " period=" + l1 + " flex=" + l2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mIntervalInSeconds);
    paramParcel.writeLong(this.mFlexInSeconds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.gcm.PeriodicTask
 * JD-Core Version:    0.7.0.1
 */