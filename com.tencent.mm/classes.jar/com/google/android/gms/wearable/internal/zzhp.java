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
    AppMethodBeat.i(101425);
    zzfu = zzd("");
    zzfv = zzd("");
    AppMethodBeat.o(101425);
  }
  
  @VisibleForTesting
  private zzhp(Context paramContext)
  {
    AppMethodBeat.i(101418);
    this.zzft = paramContext.getApplicationContext();
    AppMethodBeat.o(101418);
  }
  
  public static zzhp zza(Context paramContext)
  {
    AppMethodBeat.i(101419);
    Preconditions.checkNotNull(paramContext);
    try
    {
      if (zzfs == null) {
        zzfs = new zzhp(paramContext);
      }
      paramContext = zzfs;
      AppMethodBeat.o(101419);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(101419);
    }
  }
  
  @VisibleForTesting
  private static boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(101423);
    if (paramPackageInfo.signatures.length != 1)
    {
      AppMethodBeat.o(101423);
      return false;
    }
    paramPackageInfo.signatures[0].toByteArray();
    if (paramBoolean) {}
    for (paramBoolean = zza(paramPackageInfo, new byte[][] { zzfu, zzfv });; paramBoolean = zza(paramPackageInfo, new byte[][] { zzfu }))
    {
      AppMethodBeat.o(101423);
      return paramBoolean;
    }
  }
  
  private static boolean zza(PackageInfo paramPackageInfo, byte[]... paramVarArgs)
  {
    AppMethodBeat.i(101424);
    if (paramPackageInfo.signatures == null)
    {
      AppMethodBeat.o(101424);
      return false;
    }
    if (paramPackageInfo.signatures.length != 1)
    {
      AppMethodBeat.o(101424);
      return false;
    }
    paramPackageInfo = paramPackageInfo.signatures[0].toByteArray();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (Arrays.equals(paramVarArgs[i], paramPackageInfo))
      {
        AppMethodBeat.o(101424);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(101424);
    return false;
  }
  
  private static byte[] zzd(String paramString)
  {
    AppMethodBeat.i(101420);
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      AppMethodBeat.o(101420);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new AssertionError(paramString);
      AppMethodBeat.o(101420);
      throw paramString;
    }
  }
  
  private final PackageInfo zzf(String paramString)
  {
    AppMethodBeat.i(101422);
    try
    {
      paramString = Wrappers.packageManager(this.zzft).getPackageInfo(paramString, 64);
      AppMethodBeat.o(101422);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      AppMethodBeat.o(101422);
    }
    return null;
  }
  
  public final boolean zze(String paramString)
  {
    AppMethodBeat.i(101421);
    paramString = zzf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(101421);
      return false;
    }
    if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzft))
    {
      bool = zza(paramString, true);
      AppMethodBeat.o(101421);
      return bool;
    }
    boolean bool = zza(paramString, false);
    if (!bool) {
      zza(paramString, true);
    }
    AppMethodBeat.o(101421);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhp
 * JD-Core Version:    0.7.0.1
 */