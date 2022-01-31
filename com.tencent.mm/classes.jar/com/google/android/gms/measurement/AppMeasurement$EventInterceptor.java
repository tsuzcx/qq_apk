package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract interface AppMeasurement$EventInterceptor
{
  @KeepForSdk
  public abstract void interceptEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurement.EventInterceptor
 * JD-Core Version:    0.7.0.1
 */