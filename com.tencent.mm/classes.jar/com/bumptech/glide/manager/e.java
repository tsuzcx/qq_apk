package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  implements c
{
  final c.a aMw;
  boolean aMx;
  private boolean aMy;
  private final BroadcastReceiver aMz;
  private final Context context;
  
  e(Context paramContext, c.a parama)
  {
    AppMethodBeat.i(77548);
    this.aMz = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(77547);
        boolean bool = e.this.aMx;
        e.this.aMx = e.isConnected(paramAnonymousContext);
        if (bool != e.this.aMx)
        {
          if (Log.isLoggable("ConnectivityMonitor", 3)) {
            new StringBuilder("connectivity changed, isConnected: ").append(e.this.aMx);
          }
          e.this.aMw.aG(e.this.aMx);
        }
        AppMethodBeat.o(77547);
      }
    };
    this.context = paramContext.getApplicationContext();
    this.aMw = parama;
    AppMethodBeat.o(77548);
  }
  
  @SuppressLint({"MissingPermission"})
  static boolean isConnected(Context paramContext)
  {
    AppMethodBeat.i(77549);
    paramContext = (ConnectivityManager)i.checkNotNull((ConnectivityManager)paramContext.getSystemService("connectivity"), "Argument must not be null");
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()))
      {
        AppMethodBeat.o(77549);
        return true;
      }
    }
    catch (RuntimeException paramContext)
    {
      Log.isLoggable("ConnectivityMonitor", 5);
      AppMethodBeat.o(77549);
      return true;
    }
    AppMethodBeat.o(77549);
    return false;
  }
  
  public final void onDestroy() {}
  
  public final void onStart()
  {
    AppMethodBeat.i(77550);
    if (!this.aMy)
    {
      this.aMx = isConnected(this.context);
      try
      {
        this.context.registerReceiver(this.aMz, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.aMy = true;
        AppMethodBeat.o(77550);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        Log.isLoggable("ConnectivityMonitor", 5);
      }
    }
    AppMethodBeat.o(77550);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(77551);
    if (this.aMy)
    {
      this.context.unregisterReceiver(this.aMz);
      this.aMy = false;
    }
    AppMethodBeat.o(77551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.manager.e
 * JD-Core Version:    0.7.0.1
 */