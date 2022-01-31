package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PeriodicTask
  extends Task
{
  public static final Parcelable.Creator<PeriodicTask> CREATOR;
  protected long mFlexInSeconds;
  protected long mIntervalInSeconds;
  
  static
  {
    AppMethodBeat.i(70013);
    CREATOR = new zzk();
    AppMethodBeat.o(70013);
  }
  
  @Deprecated
  private PeriodicTask(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(70009);
    this.mIntervalInSeconds = -1L;
    this.mFlexInSeconds = -1L;
    this.mIntervalInSeconds = paramParcel.readLong();
    this.mFlexInSeconds = Math.min(paramParcel.readLong(), this.mIntervalInSeconds);
    AppMethodBeat.o(70009);
  }
  
  private PeriodicTask(PeriodicTask.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(70008);
    this.mIntervalInSeconds = -1L;
    this.mFlexInSeconds = -1L;
    this.mIntervalInSeconds = PeriodicTask.Builder.zzd(paramBuilder);
    this.mFlexInSeconds = Math.min(PeriodicTask.Builder.zze(paramBuilder), this.mIntervalInSeconds);
    AppMethodBeat.o(70008);
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
    AppMethodBeat.i(70010);
    super.toBundle(paramBundle);
    paramBundle.putLong("period", this.mIntervalInSeconds);
    paramBundle.putLong("period_flex", this.mFlexInSeconds);
    AppMethodBeat.o(70010);
  }
  
  public String toString()
  {
    AppMethodBeat.i(70012);
    String str = super.toString();
    long l1 = getPeriod();
    long l2 = getFlex();
    str = String.valueOf(str).length() + 54 + str + " period=" + l1 + " flex=" + l2;
    AppMethodBeat.o(70012);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70011);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mIntervalInSeconds);
    paramParcel.writeLong(this.mFlexInSeconds);
    AppMethodBeat.o(70011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.gcm.PeriodicTask
 * JD-Core Version:    0.7.0.1
 */