package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GooglePlayServicesUpdatedReceiver
  extends BroadcastReceiver
{
  private Context mContext;
  private final Callback zzkt;
  
  public GooglePlayServicesUpdatedReceiver(Callback paramCallback)
  {
    this.zzkt = paramCallback;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(11129);
    paramIntent = paramIntent.getData();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.getSchemeSpecificPart();
    }
    if ("com.google.android.gms".equals(paramContext))
    {
      this.zzkt.zzv();
      unregister();
    }
    AppMethodBeat.o(11129);
  }
  
  public final void unregister()
  {
    try
    {
      AppMethodBeat.i(11128);
      if (this.mContext != null) {
        this.mContext.unregisterReceiver(this);
      }
      this.mContext = null;
      AppMethodBeat.o(11128);
      return;
    }
    finally {}
  }
  
  public final void zzc(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static abstract class Callback
  {
    public abstract void zzv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver
 * JD-Core Version:    0.7.0.1
 */