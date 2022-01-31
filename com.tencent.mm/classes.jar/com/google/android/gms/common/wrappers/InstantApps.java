package com.google.android.gms.common.wrappers;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InstantApps
{
  private static Context zzaay;
  private static Boolean zzaaz;
  
  public static boolean isInstantApp(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(90306);
        Context localContext = paramContext.getApplicationContext();
        boolean bool;
        if ((zzaay != null) && (zzaaz != null) && (zzaay == localContext))
        {
          bool = zzaaz.booleanValue();
          AppMethodBeat.o(90306);
          return bool;
        }
        zzaaz = null;
        if (PlatformVersion.isAtLeastO())
        {
          zzaaz = Boolean.valueOf(localContext.getPackageManager().isInstantApp());
          zzaay = localContext;
          bool = zzaaz.booleanValue();
          AppMethodBeat.o(90306);
        }
        else
        {
          try
          {
            paramContext.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
            zzaaz = Boolean.TRUE;
          }
          catch (ClassNotFoundException paramContext)
          {
            zzaaz = Boolean.FALSE;
          }
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.wrappers.InstantApps
 * JD-Core Version:    0.7.0.1
 */