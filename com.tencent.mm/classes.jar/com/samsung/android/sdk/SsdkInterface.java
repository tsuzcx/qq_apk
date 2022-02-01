package com.samsung.android.sdk;

import android.content.Context;

public abstract interface SsdkInterface
{
  public abstract int getVersionCode();
  
  public abstract String getVersionName();
  
  public abstract void initialize(Context paramContext);
  
  public abstract boolean isFeatureEnabled(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.samsung.android.sdk.SsdkInterface
 * JD-Core Version:    0.7.0.1
 */