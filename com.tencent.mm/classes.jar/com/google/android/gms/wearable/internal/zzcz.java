package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.zzg;
import com.google.android.gms.internal.zzadf;
import com.google.android.gms.internal.zzadg;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class zzcz
{
  private static zzcz zzbVt;
  static final byte[] zzbVu = zzdc("");
  static final byte[] zzbVv = zzdc("");
  private final Context mContext;
  
  zzcz(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  private boolean zza(PackageInfo paramPackageInfo, byte[]... paramVarArgs)
  {
    if (paramPackageInfo.signatures == null) {}
    for (;;)
    {
      return false;
      if (paramPackageInfo.signatures.length == 1)
      {
        paramPackageInfo = paramPackageInfo.signatures[0].toByteArray();
        int i = 0;
        while (i < paramVarArgs.length)
        {
          if (Arrays.equals(paramVarArgs[i], paramPackageInfo)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static zzcz zzck(Context paramContext)
  {
    zzac.zzw(paramContext);
    try
    {
      if (zzbVt == null) {
        zzbVt = new zzcz(paramContext);
      }
      return zzbVt;
    }
    finally {}
  }
  
  private static byte[] zzdc(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  private PackageInfo zzir(String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = zzadg.zzbi(this.mContext).getPackageInfo(paramString, 64);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {
        break label38;
      }
    }
    "No package ".concat(paramString);
    for (;;)
    {
      return null;
      label38:
      new String("No package ");
    }
  }
  
  boolean zzc(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if (paramPackageInfo.signatures.length != 1) {
      return false;
    }
    paramPackageInfo.signatures[0].toByteArray();
    if (paramBoolean) {
      return zza(paramPackageInfo, new byte[][] { zzbVu, zzbVv });
    }
    return zza(paramPackageInfo, new byte[][] { zzbVu });
  }
  
  public boolean zziq(String paramString)
  {
    boolean bool1 = false;
    paramString = zzir(paramString);
    if (paramString == null) {}
    boolean bool2;
    do
    {
      return bool1;
      if (zzg.zzaJ(this.mContext)) {
        return zzc(paramString, true);
      }
      bool2 = zzc(paramString, false);
      bool1 = bool2;
    } while (bool2);
    zzc(paramString, true);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcz
 * JD-Core Version:    0.7.0.1
 */