package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

public class MetadataValueReader
{
  public static final String KEY_METADATA_APP_ID = "com.google.app.id";
  private static Object sLock;
  @GuardedBy("sLock")
  private static boolean zzui;
  private static String zzuj;
  private static int zzuk;
  
  static
  {
    AppMethodBeat.i(89682);
    sLock = new Object();
    AppMethodBeat.o(89682);
  }
  
  public static String getGoogleAppId(Context paramContext)
  {
    AppMethodBeat.i(89679);
    zze(paramContext);
    paramContext = zzuj;
    AppMethodBeat.o(89679);
    return paramContext;
  }
  
  public static int getGooglePlayServicesVersion(Context paramContext)
  {
    AppMethodBeat.i(89680);
    zze(paramContext);
    int i = zzuk;
    AppMethodBeat.o(89680);
    return i;
  }
  
  @VisibleForTesting
  public static void resetForTesting()
  {
    synchronized (sLock)
    {
      zzui = false;
      return;
    }
  }
  
  @VisibleForTesting
  public static void setValuesForTesting(String paramString, int paramInt)
  {
    synchronized (sLock)
    {
      zzuj = paramString;
      zzuk = paramInt;
      zzui = true;
      return;
    }
  }
  
  private static void zze(Context paramContext)
  {
    AppMethodBeat.i(89681);
    synchronized (sLock)
    {
      if (zzui)
      {
        AppMethodBeat.o(89681);
        return;
      }
      zzui = true;
      String str = paramContext.getPackageName();
      paramContext = Wrappers.packageManager(paramContext);
      try
      {
        paramContext = paramContext.getApplicationInfo(str, 128).metaData;
        if (paramContext == null)
        {
          AppMethodBeat.o(89681);
          return;
        }
        zzuj = paramContext.getString("com.google.app.id");
        zzuk = paramContext.getInt("com.google.android.gms.version");
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          Log.wtf("MetadataValueReader", "This should never happen.", paramContext);
        }
      }
      AppMethodBeat.o(89681);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.MetadataValueReader
 * JD-Core Version:    0.7.0.1
 */