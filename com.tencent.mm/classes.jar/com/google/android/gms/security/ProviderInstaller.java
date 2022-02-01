package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static final Object sLock;
  private static final GoogleApiAvailabilityLight zzacw;
  private static Method zzacx;
  
  static
  {
    AppMethodBeat.i(5526);
    zzacw = GoogleApiAvailabilityLight.getInstance();
    sLock = new Object();
    zzacx = null;
    AppMethodBeat.o(5526);
  }
  
  public static void installIfNeeded(Context paramContext)
  {
    AppMethodBeat.i(5524);
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    zzacw.verifyGooglePlayServicesIsAvailable(paramContext, 11925000);
    try
    {
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext == null)
      {
        Log.isLoggable("ProviderInstaller", 6);
        paramContext = new GooglePlayServicesNotAvailableException(8);
        AppMethodBeat.o(5524);
        throw paramContext;
      }
    }
    catch (Resources.NotFoundException paramContext)
    {
      Log.isLoggable("ProviderInstaller", 6);
      paramContext = new GooglePlayServicesNotAvailableException(8);
      AppMethodBeat.o(5524);
      throw paramContext;
    }
    for (;;)
    {
      Throwable localThrowable;
      synchronized (sLock)
      {
        try
        {
          if (zzacx == null) {
            zzacx = paramContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class });
          }
          zzacx.invoke(null, new Object[] { paramContext });
          AppMethodBeat.o(5524);
          return;
        }
        catch (Exception paramContext)
        {
          localThrowable = paramContext.getCause();
          if (!Log.isLoggable("ProviderInstaller", 6)) {
            continue;
          }
        }
        if (localThrowable == null)
        {
          paramContext = paramContext.getMessage();
          paramContext = String.valueOf(paramContext);
          if (paramContext.length() == 0) {
            break label228;
          }
          "Failed to install provider: ".concat(paramContext);
          paramContext = new GooglePlayServicesNotAvailableException(8);
          AppMethodBeat.o(5524);
          throw paramContext;
        }
      }
      paramContext = localThrowable.getMessage();
      continue;
      label228:
      new String("Failed to install provider: ");
    }
  }
  
  public static void installIfNeededAsync(Context paramContext, ProviderInstallListener paramProviderInstallListener)
  {
    AppMethodBeat.i(5525);
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    Preconditions.checkNotNull(paramProviderInstallListener, "Listener must not be null");
    Preconditions.checkMainThread("Must be called on the UI thread");
    new zza(paramContext, paramProviderInstallListener).execute(new Void[0]);
    AppMethodBeat.o(5525);
  }
  
  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);
    
    public abstract void onProviderInstalled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.security.ProviderInstaller
 * JD-Core Version:    0.7.0.1
 */