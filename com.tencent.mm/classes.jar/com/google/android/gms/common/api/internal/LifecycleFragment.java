package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

public abstract interface LifecycleFragment
{
  public abstract void addCallback(String paramString, LifecycleCallback paramLifecycleCallback);
  
  public abstract <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass);
  
  public abstract Activity getLifecycleActivity();
  
  public abstract boolean isCreated();
  
  public abstract boolean isStarted();
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.LifecycleFragment
 * JD-Core Version:    0.7.0.1
 */