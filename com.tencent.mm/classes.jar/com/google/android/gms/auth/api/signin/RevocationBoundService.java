package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzx;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RevocationBoundService
  extends Service
{
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(88293);
    if (("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(paramIntent.getAction())) || ("com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(paramIntent.getAction())))
    {
      if (Log.isLoggable("RevocationService", 2))
      {
        paramIntent = String.valueOf(paramIntent.getAction());
        if (paramIntent.length() == 0) {
          break label76;
        }
        "RevocationBoundService handling ".concat(paramIntent);
      }
      for (;;)
      {
        paramIntent = new zzx(this);
        AppMethodBeat.o(88293);
        return paramIntent;
        label76:
        new String("RevocationBoundService handling ");
      }
    }
    paramIntent = String.valueOf(paramIntent.getAction());
    if (paramIntent.length() != 0) {
      "Unknown action sent to RevocationBoundService: ".concat(paramIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(88293);
      return null;
      new String("Unknown action sent to RevocationBoundService: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.RevocationBoundService
 * JD-Core Version:    0.7.0.1
 */