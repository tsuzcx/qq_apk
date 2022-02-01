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
    AppMethodBeat.i(3669);
    CREATOR = new zzi();
    AppMethodBeat.o(3669);
  }
  
  @Deprecated
  private OneoffTask(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(3665);
    this.zzaj = paramParcel.readLong();
    this.zzak = paramParcel.readLong();
    AppMethodBeat.o(3665);
  }
  
  private OneoffTask(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(3664);
    this.zzaj = Builder.zzd(paramBuilder);
    this.zzak = Builder.zze(paramBuilder);
    AppMethodBeat.o(3664);
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
    AppMethodBeat.i(3666);
    super.toBundle(paramBundle);
    paramBundle.putLong("window_start", this.zzaj);
    paramBundle.putLong("window_end", this.zzak);
    AppMethodBeat.o(3666);
  }
  
  public String toString()
  {
    AppMethodBeat.i(3668);
    String str = super.toString();
    long l1 = getWindowStart();
    long l2 = getWindowEnd();
    str = String.valueOf(str).length() + 64 + str + " windowStart=" + l1 + " windowEnd=" + l2;
    AppMethodBeat.o(3668);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(3667);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.zzaj);
    paramParcel.writeLong(this.zzak);
    AppMethodBeat.o(3667);
  }
  
  public static class Builder
    extends Task.Builder
  {
    private long zzaj = -1L;
    private long zzak = -1L;
    
    public Builder()
    {
      this.isPersisted = false;
    }
    
    public OneoffTask build()
    {
      AppMethodBeat.i(3655);
      checkConditions();
      OneoffTask localOneoffTask = new OneoffTask(this, null);
      AppMethodBeat.o(3655);
      return localOneoffTask;
    }
    
    protected void checkConditions()
    {
      AppMethodBeat.i(3654);
      super.checkConditions();
      IllegalArgumentException localIllegalArgumentException;
      if ((this.zzaj == -1L) || (this.zzak == -1L))
      {
        localIllegalArgumentException = new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
        AppMethodBeat.o(3654);
        throw localIllegalArgumentException;
      }
      if (this.zzaj >= this.zzak)
      {
        localIllegalArgumentException = new IllegalArgumentException("Window start must be shorter than window end.");
        AppMethodBeat.o(3654);
        throw localIllegalArgumentException;
      }
      AppMethodBeat.o(3654);
    }
    
    public Builder setExecutionWindow(long paramLong1, long paramLong2)
    {
      this.zzaj = paramLong1;
      this.zzak = paramLong2;
      return this;
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.extras = paramBundle;
      return this;
    }
    
    public Builder setPersisted(boolean paramBoolean)
    {
      this.isPersisted = paramBoolean;
      return this;
    }
    
    public Builder setRequiredNetwork(int paramInt)
    {
      this.requiredNetworkState = paramInt;
      return this;
    }
    
    public Builder setRequiresCharging(boolean paramBoolean)
    {
      this.requiresCharging = paramBoolean;
      return this;
    }
    
    public Builder setService(Class<? extends GcmTaskService> paramClass)
    {
      AppMethodBeat.i(3653);
      this.gcmTaskService = paramClass.getName();
      AppMethodBeat.o(3653);
      return this;
    }
    
    public Builder setTag(String paramString)
    {
      this.tag = paramString;
      return this;
    }
    
    public Builder setUpdateCurrent(boolean paramBoolean)
    {
      this.updateCurrent = paramBoolean;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.gcm.OneoffTask
 * JD-Core Version:    0.7.0.1
 */