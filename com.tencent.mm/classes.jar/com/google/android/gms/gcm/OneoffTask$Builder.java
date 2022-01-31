package com.google.android.gms.gcm;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class OneoffTask$Builder
  extends Task.Builder
{
  private long zzaj = -1L;
  private long zzak = -1L;
  
  public OneoffTask$Builder()
  {
    this.isPersisted = false;
  }
  
  public OneoffTask build()
  {
    AppMethodBeat.i(69979);
    checkConditions();
    OneoffTask localOneoffTask = new OneoffTask(this, null);
    AppMethodBeat.o(69979);
    return localOneoffTask;
  }
  
  protected void checkConditions()
  {
    AppMethodBeat.i(69978);
    super.checkConditions();
    IllegalArgumentException localIllegalArgumentException;
    if ((this.zzaj == -1L) || (this.zzak == -1L))
    {
      localIllegalArgumentException = new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
      AppMethodBeat.o(69978);
      throw localIllegalArgumentException;
    }
    if (this.zzaj >= this.zzak)
    {
      localIllegalArgumentException = new IllegalArgumentException("Window start must be shorter than window end.");
      AppMethodBeat.o(69978);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(69978);
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
    AppMethodBeat.i(69977);
    this.gcmTaskService = paramClass.getName();
    AppMethodBeat.o(69977);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.gcm.OneoffTask.Builder
 * JD-Core Version:    0.7.0.1
 */