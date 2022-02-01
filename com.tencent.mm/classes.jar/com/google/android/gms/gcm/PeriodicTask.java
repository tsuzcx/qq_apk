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
    AppMethodBeat.i(3689);
    CREATOR = new zzk();
    AppMethodBeat.o(3689);
  }
  
  @Deprecated
  private PeriodicTask(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(3685);
    this.mIntervalInSeconds = -1L;
    this.mFlexInSeconds = -1L;
    this.mIntervalInSeconds = paramParcel.readLong();
    this.mFlexInSeconds = Math.min(paramParcel.readLong(), this.mIntervalInSeconds);
    AppMethodBeat.o(3685);
  }
  
  private PeriodicTask(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(3684);
    this.mIntervalInSeconds = -1L;
    this.mFlexInSeconds = -1L;
    this.mIntervalInSeconds = Builder.zzd(paramBuilder);
    this.mFlexInSeconds = Math.min(Builder.zze(paramBuilder), this.mIntervalInSeconds);
    AppMethodBeat.o(3684);
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
    AppMethodBeat.i(3686);
    super.toBundle(paramBundle);
    paramBundle.putLong("period", this.mIntervalInSeconds);
    paramBundle.putLong("period_flex", this.mFlexInSeconds);
    AppMethodBeat.o(3686);
  }
  
  public String toString()
  {
    AppMethodBeat.i(3688);
    String str = super.toString();
    long l1 = getPeriod();
    long l2 = getFlex();
    str = String.valueOf(str).length() + 54 + str + " period=" + l1 + " flex=" + l2;
    AppMethodBeat.o(3688);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(3687);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mIntervalInSeconds);
    paramParcel.writeLong(this.mFlexInSeconds);
    AppMethodBeat.o(3687);
  }
  
  public static class Builder
    extends Task.Builder
  {
    private long zzam = -1L;
    private long zzan = -1L;
    
    public Builder()
    {
      this.isPersisted = true;
    }
    
    public PeriodicTask build()
    {
      AppMethodBeat.i(3674);
      checkConditions();
      PeriodicTask localPeriodicTask = new PeriodicTask(this, null);
      AppMethodBeat.o(3674);
      return localPeriodicTask;
    }
    
    protected void checkConditions()
    {
      AppMethodBeat.i(3675);
      super.checkConditions();
      IllegalArgumentException localIllegalArgumentException;
      if (this.zzam == -1L)
      {
        localIllegalArgumentException = new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
        AppMethodBeat.o(3675);
        throw localIllegalArgumentException;
      }
      if (this.zzam <= 0L)
      {
        long l = this.zzam;
        localIllegalArgumentException = new IllegalArgumentException(66 + "Period set cannot be less than or equal to 0: " + l);
        AppMethodBeat.o(3675);
        throw localIllegalArgumentException;
      }
      if (this.zzan == -1L)
      {
        this.zzan = (((float)this.zzam * 0.1F));
        AppMethodBeat.o(3675);
        return;
      }
      if (this.zzan > this.zzam) {
        this.zzan = this.zzam;
      }
      AppMethodBeat.o(3675);
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.extras = paramBundle;
      return this;
    }
    
    public Builder setFlex(long paramLong)
    {
      this.zzan = paramLong;
      return this;
    }
    
    public Builder setPeriod(long paramLong)
    {
      this.zzam = paramLong;
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
      AppMethodBeat.i(3673);
      this.gcmTaskService = paramClass.getName();
      AppMethodBeat.o(3673);
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
 * Qualified Name:     com.google.android.gms.gcm.PeriodicTask
 * JD-Core Version:    0.7.0.1
 */