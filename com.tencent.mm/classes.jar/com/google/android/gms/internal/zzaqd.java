package com.google.android.gms.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface zzaqd
  extends IInterface
{
  public abstract boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract int getIntFlagValue(String paramString, int paramInt1, int paramInt2);
  
  public abstract long getLongFlagValue(String paramString, long paramLong, int paramInt);
  
  public abstract String getStringFlagValue(String paramString1, String paramString2, int paramInt);
  
  public abstract void init(IObjectWrapper paramIObjectWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqd
 * JD-Core Version:    0.7.0.1
 */