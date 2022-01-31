package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class zzhp
{
  private static zzhp zzfs;
  @VisibleForTesting
  private static final byte[] zzfu;
  @VisibleForTesting
  private static final byte[] zzfv;
  private final Context zzft;
  
  static
  {
    AppMethodBeat.i(71442);
    zzfu = zzd("");
    zzfv = zzd("");
    AppMethodBeat.o(71442);
  }
  
  @VisibleForTesting
  private zzhp(Context paramContext)
  {
    AppMethodBeat.i(71435);
    this.zzft = paramContext.getApplicationContext();
    AppMethodBeat.o(71435);
  }
  
  public static zzhp zza(Context paramContext)
  {
    AppMethodBeat.i(71436);
    Preconditions.checkNotNull(paramContext);
    try
    {
      if (zzfs == null) {
        zzfs = new zzhp(paramContext);
      }
      paramContext = zzfs;
      AppMethodBeat.o(71436);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(71436);
    }
  }
  
  @VisibleForTesting
  private static boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(71440);
    if (paramPackageInfo.signatures.length != 1)
    {
      AppMethodBeat.o(71440);
      return false;
    }
    paramPackageInfo.signatures[0].toByteArray();
    if (paramBoolean) {}
    for (paramBoolean = zza(paramPackageInfo, new byte[][] { zzfu, zzfv });; paramBoolean = zza(paramPackageInfo, new byte[][] { zzfu }))
    {
      AppMethodBeat.o(71440);
      return paramBoolean;
    }
  }
  
  private static boolean zza(PackageInfo paramPackageInfo, byte[]... paramVarArgs)
  {
    AppMethodBeat.i(71441);
    if (paramPackageInfo.signatures == null)
    {
      AppMethodBeat.o(71441);
      return false;
    }
    if (paramPackageInfo.signatures.length != 1)
    {
      AppMethodBeat.o(71441);
      return false;
    }
    paramPackageInfo = paramPackageInfo.signatures[0].toByteArray();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (Arrays.equals(paramVarArgs[i], paramPackageInfo))
      {
        AppMethodBeat.o(71441);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(71441);
    return false;
  }
  
  private static byte[] zzd(String paramString)
  {
    AppMethodBeat.i(71437);
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      AppMethodBeat.o(71437);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new AssertionError(paramString);
      AppMethodBeat.o(71437);
      throw paramString;
    }
  }
  
  private final PackageInfo zzf(String paramString)
  {
    AppMethodBeat.i(71439);
    try
    {
      paramString = Wrappers.packageManager(this.zzft).getPackageInfo(paramString, 64);
      AppMethodBeat.o(71439);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      AppMethodBeat.o(71439);
    }
    return null;
  }
  
  public final boolean zze(String paramString)
  {
    AppMethodBeat.i(71438);
    paramString = zzf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(71438);
      return false;
    }
    if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzft))
    {
      bool = zza(paramString, true);
      AppMethodBeat.o(71438);
      return bool;
    }
    boolean bool = zza(paramString, false);
    if (!bool) {
      zza(paramString, true);
    }
    AppMethodBeat.o(71438);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhp
 * JD-Core Version:    0.7.0.1
 */