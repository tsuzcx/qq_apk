package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzl;

public final class RevocationBoundService
  extends Service
{
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(paramIntent.getAction()))
    {
      Log.isLoggable("RevocationService", 2);
      return new zzl(this);
    }
    paramIntent = String.valueOf(paramIntent.getAction());
    if (paramIntent.length() != 0) {
      "Unknown action sent to RevocationBoundService: ".concat(paramIntent);
    }
    for (;;)
    {
      return null;
      new String("Unknown action sent to RevocationBoundService: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.RevocationBoundService
 * JD-Core Version:    0.7.0.1
 */