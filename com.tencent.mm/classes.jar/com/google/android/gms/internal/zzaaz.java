package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzaaz
  extends BroadcastReceiver
{
  protected Context mContext;
  private final zzaaz.zza zzaCL;
  
  public zzaaz(zzaaz.zza paramzza)
  {
    this.zzaCL = paramzza;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.getSchemeSpecificPart();
    }
    if ("com.google.android.gms".equals(paramContext))
    {
      this.zzaCL.zzvE();
      unregister();
    }
  }
  
  public final void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void unregister()
  {
    try
    {
      if (this.mContext != null) {
        this.mContext.unregisterReceiver(this);
      }
      this.mContext = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzaaz
 * JD-Core Version:    0.7.0.1
 */