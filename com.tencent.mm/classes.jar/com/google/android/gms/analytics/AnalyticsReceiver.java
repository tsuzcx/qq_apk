package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.zzth;

public final class AnalyticsReceiver
  extends BroadcastReceiver
{
  private zzth zzabp;
  
  private zzth zzmp()
  {
    if (this.zzabp == null) {
      this.zzabp = new zzth();
    }
    return this.zzabp;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    zzmp().onReceive(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.analytics.AnalyticsReceiver
 * JD-Core Version:    0.7.0.1
 */