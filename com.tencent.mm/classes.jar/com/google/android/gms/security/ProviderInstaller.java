package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.zzg;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static final zze zzbEg = ;
  private static Method zzbEh = null;
  private static final Object zztX = new Object();
  
  public static void installIfNeeded(Context arg0)
  {
    zzac.zzb(???, "Context must not be null");
    zzbEg.zzaE(???);
    Context localContext = zzg.getRemoteContext(???);
    if (localContext == null) {
      throw new GooglePlayServicesNotAvailableException(8);
    }
    for (;;)
    {
      synchronized (zztX)
      {
        String str;
        try
        {
          if (zzbEh == null) {
            zzbR(localContext);
          }
          zzbEh.invoke(null, new Object[] { localContext });
          return;
        }
        catch (Exception localException)
        {
          str = String.valueOf(localException.getMessage());
          if (str.length() == 0) {
            break label106;
          }
        }
        "Failed to install provider: ".concat(str);
        throw new GooglePlayServicesNotAvailableException(8);
      }
      label106:
      new String("Failed to install provider: ");
    }
  }
  
  public static void installIfNeededAsync(Context paramContext, final ProviderInstaller.ProviderInstallListener paramProviderInstallListener)
  {
    zzac.zzb(paramContext, "Context must not be null");
    zzac.zzb(paramProviderInstallListener, "Listener must not be null");
    zzac.zzdj("Must be called on the UI thread");
    new AsyncTask()
    {
      protected final Integer zzb(Void... paramAnonymousVarArgs)
      {
        try
        {
          ProviderInstaller.installIfNeeded(ProviderInstaller.this);
          return Integer.valueOf(0);
        }
        catch (GooglePlayServicesRepairableException paramAnonymousVarArgs)
        {
          return Integer.valueOf(paramAnonymousVarArgs.getConnectionStatusCode());
        }
        catch (GooglePlayServicesNotAvailableException paramAnonymousVarArgs) {}
        return Integer.valueOf(paramAnonymousVarArgs.errorCode);
      }
      
      protected final void zzg(Integer paramAnonymousInteger)
      {
        if (paramAnonymousInteger.intValue() == 0)
        {
          paramProviderInstallListener.onProviderInstalled();
          return;
        }
        Intent localIntent = ProviderInstaller.zzPG().zzb(ProviderInstaller.this, paramAnonymousInteger.intValue(), "pi");
        paramProviderInstallListener.onProviderInstallFailed(paramAnonymousInteger.intValue(), localIntent);
      }
    }.execute(new Void[0]);
  }
  
  private static void zzbR(Context paramContext)
  {
    zzbEh = paramContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.security.ProviderInstaller
 * JD-Core Version:    0.7.0.1
 */