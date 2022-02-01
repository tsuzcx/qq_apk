package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class UidVerifier
{
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(5297);
    if (!uidHasPackageName(paramContext, paramInt, "com.google.android.gms"))
    {
      AppMethodBeat.o(5297);
      return false;
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.gms", 64);
      boolean bool = GoogleSignatureVerifier.getInstance(paramContext).isGooglePublicSignedPackage((PackageInfo)localObject);
      AppMethodBeat.o(5297);
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.isLoggable("UidVerifier", 3);
      AppMethodBeat.o(5297);
    }
    return false;
  }
  
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(5298);
    boolean bool = Wrappers.packageManager(paramContext).uidHasPackageName(paramInt, paramString);
    AppMethodBeat.o(5298);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.UidVerifier
 * JD-Core Version:    0.7.0.1
 */