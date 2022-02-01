package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ClientLibraryUtils
{
  public static final int GMS_CLIENT_VERSION_UNKNOWN = -1;
  
  public static int getClientVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(5064);
    int i = getClientVersion(getPackageInfo(paramContext, paramString));
    AppMethodBeat.o(5064);
    return i;
  }
  
  public static int getClientVersion(PackageInfo paramPackageInfo)
  {
    AppMethodBeat.i(5065);
    if ((paramPackageInfo == null) || (paramPackageInfo.applicationInfo == null))
    {
      AppMethodBeat.o(5065);
      return -1;
    }
    paramPackageInfo = paramPackageInfo.applicationInfo.metaData;
    if (paramPackageInfo == null)
    {
      AppMethodBeat.o(5065);
      return -1;
    }
    int i = paramPackageInfo.getInt("com.google.android.gms.version", -1);
    AppMethodBeat.o(5065);
    return i;
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(5066);
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 128);
      AppMethodBeat.o(5066);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(5066);
    }
    return null;
  }
  
  public static boolean isPackageSide()
  {
    return false;
  }
  
  public static boolean isPackageStopped(Context paramContext, String paramString)
  {
    AppMethodBeat.i(5067);
    "com.google.android.gms".equals(paramString);
    try
    {
      if ((Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0).flags & 0x200000) != 0)
      {
        AppMethodBeat.o(5067);
        return true;
      }
      AppMethodBeat.o(5067);
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(5067);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.ClientLibraryUtils
 * JD-Core Version:    0.7.0.1
 */