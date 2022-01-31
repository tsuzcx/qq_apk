package com.google.android.gms.gcm;

import android.os.Bundle;

public class PeriodicTask$Builder
  extends Task.Builder
{
  private long zzbgP = -1L;
  private long zzbgQ = -1L;
  
  public PeriodicTask$Builder()
  {
    this.isPersisted = true;
  }
  
  public PeriodicTask build()
  {
    checkConditions();
    return new PeriodicTask(this, null);
  }
  
  protected void checkConditions()
  {
    super.checkConditions();
    if (this.zzbgP == -1L) {
      throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
    }
    if (this.zzbgP <= 0L)
    {
      long l = this.zzbgP;
      throw new IllegalArgumentException(66 + "Period set cannot be less than or equal to 0: " + l);
    }
    if (this.zzbgQ == -1L) {
      this.zzbgQ = (((float)this.zzbgP * 0.1F));
    }
    while (this.zzbgQ <= this.zzbgP) {
      return;
    }
    this.zzbgQ = this.zzbgP;
  }
  
  public Builder setExtras(Bundle paramBundle)
  {
    this.extras = paramBundle;
    return this;
  }
  
  public Builder setFlex(long paramLong)
  {
    this.zzbgQ = paramLong;
    return this;
  }
  
  public Builder setPeriod(long paramLong)
  {
    this.zzbgP = paramLong;
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
    this.gcmTaskService = paramClass.getName();
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