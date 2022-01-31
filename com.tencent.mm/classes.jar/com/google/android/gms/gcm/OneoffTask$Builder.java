package com.google.android.gms.gcm;

import android.os.Bundle;

public class OneoffTask$Builder
  extends Task.Builder
{
  private long zzbgN = -1L;
  private long zzbgO = -1L;
  
  public OneoffTask$Builder()
  {
    this.isPersisted = false;
  }
  
  public OneoffTask build()
  {
    checkConditions();
    return new OneoffTask(this, null);
  }
  
  protected void checkConditions()
  {
    super.checkConditions();
    if ((this.zzbgN == -1L) || (this.zzbgO == -1L)) {
      throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
    }
    if (this.zzbgN >= this.zzbgO) {
      throw new IllegalArgumentException("Window start must be shorter than window end.");
    }
  }
  
  public Builder setExecutionWindow(long paramLong1, long paramLong2)
  {
    this.zzbgN = paramLong1;
    this.zzbgO = paramLong2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.gcm.OneoffTask.Builder
 * JD-Core Version:    0.7.0.1
 */