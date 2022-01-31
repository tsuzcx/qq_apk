package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract interface AppMeasurement$OnEventListener
{
  @KeepForSdk
  public abstract void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurement.OnEventListener
 * JD-Core Version:    0.7.0.1
 */