package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask
  extends Task
{
  public static final Parcelable.Creator<OneoffTask> CREATOR = new OneoffTask.1();
  private final long zzbgL;
  private final long zzbgM;
  
  @Deprecated
  private OneoffTask(Parcel paramParcel)
  {
    super(paramParcel);
    this.zzbgL = paramParcel.readLong();
    this.zzbgM = paramParcel.readLong();
  }
  
  private OneoffTask(OneoffTask.Builder paramBuilder)
  {
    super(paramBuilder);
    this.zzbgL = OneoffTask.Builder.zza(paramBuilder);
    this.zzbgM = OneoffTask.Builder.zzb(paramBuilder);
  }
  
  public long getWindowEnd()
  {
    return this.zzbgM;
  }
  
  public long getWindowStart()
  {
    return this.zzbgL;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putLong("window_start", this.zzbgL);
    paramBundle.putLong("window_end", this.zzbgM);
  }
  
  public String toString()
  {
    String str = String.valueOf(super.toString());
    long l1 = getWindowStart();
    long l2 = getWindowEnd();
    return String.valueOf(str).length() + 64 + str + " windowStart=" + l1 + " windowEnd=" + l2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.zzbgL);
    paramParcel.writeLong(this.zzbgM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.gcm.OneoffTask
 * JD-Core Version:    0.7.0.1
 */