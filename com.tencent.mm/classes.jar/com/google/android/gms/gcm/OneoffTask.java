package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class OneoffTask
  extends Task
{
  public static final Parcelable.Creator<OneoffTask> CREATOR;
  private final long zzaj;
  private final long zzak;
  
  static
  {
    AppMethodBeat.i(69993);
    CREATOR = new zzi();
    AppMethodBeat.o(69993);
  }
  
  @Deprecated
  private OneoffTask(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(69989);
    this.zzaj = paramParcel.readLong();
    this.zzak = paramParcel.readLong();
    AppMethodBeat.o(69989);
  }
  
  private OneoffTask(OneoffTask.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(69988);
    this.zzaj = OneoffTask.Builder.zzd(paramBuilder);
    this.zzak = OneoffTask.Builder.zze(paramBuilder);
    AppMethodBeat.o(69988);
  }
  
  public long getWindowEnd()
  {
    return this.zzak;
  }
  
  public long getWindowStart()
  {
    return this.zzaj;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(69990);
    super.toBundle(paramBundle);
    paramBundle.putLong("window_start", this.zzaj);
    paramBundle.putLong("window_end", this.zzak);
    AppMethodBeat.o(69990);
  }
  
  public String toString()
  {
    AppMethodBeat.i(69992);
    String str = super.toString();
    long l1 = getWindowStart();
    long l2 = getWindowEnd();
    str = String.valueOf(str).length() + 64 + str + " windowStart=" + l1 + " windowEnd=" + l2;
    AppMethodBeat.o(69992);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(69991);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.zzaj);
    paramParcel.writeLong(this.zzak);
    AppMethodBeat.o(69991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.gcm.OneoffTask
 * JD-Core Version:    0.7.0.1
 */