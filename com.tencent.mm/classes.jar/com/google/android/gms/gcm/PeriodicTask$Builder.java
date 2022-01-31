package com.google.android.gms.gcm;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PeriodicTask$Builder
  extends Task.Builder
{
  private long zzam = -1L;
  private long zzan = -1L;
  
  public PeriodicTask$Builder()
  {
    this.isPersisted = true;
  }
  
  public PeriodicTask build()
  {
    AppMethodBeat.i(69998);
    checkConditions();
    PeriodicTask localPeriodicTask = new PeriodicTask(this, null);
    AppMethodBeat.o(69998);
    return localPeriodicTask;
  }
  
  protected void checkConditions()
  {
    AppMethodBeat.i(69999);
    super.checkConditions();
    IllegalArgumentException localIllegalArgumentException;
    if (this.zzam == -1L)
    {
      localIllegalArgumentException = new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
      AppMethodBeat.o(69999);
      throw localIllegalArgumentException;
    }
    if (this.zzam <= 0L)
    {
      long l = this.zzam;
      localIllegalArgumentException = new IllegalArgumentException(66 + "Period set cannot be less than or equal to 0: " + l);
      AppMethodBeat.o(69999);
      throw localIllegalArgumentException;
    }
    if (this.zzan == -1L)
    {
      this.zzan = (((float)this.zzam * 0.1F));
      AppMethodBeat.o(69999);
      return;
    }
    if (this.zzan > this.zzam) {
      this.zzan = this.zzam;
    }
    AppMethodBeat.o(69999);
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
    AppMethodBeat.i(69997);
    this.gcmTaskService = paramClass.getName();
    AppMethodBeat.o(69997);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.gcm.PeriodicTask.Builder
 * JD-Core Version:    0.7.0.1
 */