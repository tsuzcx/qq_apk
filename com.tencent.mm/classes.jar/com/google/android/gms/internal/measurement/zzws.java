package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build.VERSION;
import androidx.core.content.c;

public abstract class zzws<T>
{
  private static final Object zzbnc = new Object();
  private static boolean zzbnd = false;
  private static volatile Boolean zzbne = null;
  private static volatile Boolean zzbnf = null;
  private static Context zzqx = null;
  private final zzxc zzbng;
  final String zzbnh;
  private final String zzbni;
  private final T zzbnj;
  private T zzbnk = null;
  private volatile zzwp zzbnl = null;
  private volatile SharedPreferences zzbnm = null;
  
  private zzws(zzxc paramzzxc, String paramString, T paramT)
  {
    if (zzxc.zza(paramzzxc) == null) {
      throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }
    this.zzbng = paramzzxc;
    String str1 = String.valueOf(zzxc.zzb(paramzzxc));
    String str2 = String.valueOf(paramString);
    if (str2.length() != 0)
    {
      str1 = str1.concat(str2);
      this.zzbni = str1;
      paramzzxc = String.valueOf(zzxc.zzc(paramzzxc));
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {
        break label130;
      }
    }
    label130:
    for (paramzzxc = paramzzxc.concat(paramString);; paramzzxc = new String(paramzzxc))
    {
      this.zzbnh = paramzzxc;
      this.zzbnj = paramT;
      return;
      str1 = new String(str1);
      break;
    }
  }
  
  public static void init(Context paramContext)
  {
    synchronized (zzbnc)
    {
      if ((Build.VERSION.SDK_INT >= 24) && (paramContext.isDeviceProtectedStorage())) {}
      Context localContext;
      do
      {
        if (zzqx != paramContext) {
          zzbne = null;
        }
        zzqx = paramContext;
        zzbnd = false;
        return;
        localContext = paramContext.getApplicationContext();
      } while (localContext == null);
      paramContext = localContext;
    }
  }
  
  private static zzws<Double> zza(zzxc paramzzxc, String paramString, double paramDouble)
  {
    return new zzwz(paramzzxc, paramString, Double.valueOf(paramDouble));
  }
  
  private static zzws<Integer> zza(zzxc paramzzxc, String paramString, int paramInt)
  {
    return new zzwx(paramzzxc, paramString, Integer.valueOf(paramInt));
  }
  
  private static zzws<Long> zza(zzxc paramzzxc, String paramString, long paramLong)
  {
    return new zzww(paramzzxc, paramString, Long.valueOf(paramLong));
  }
  
  private static zzws<String> zza(zzxc paramzzxc, String paramString1, String paramString2)
  {
    return new zzxa(paramzzxc, paramString1, paramString2);
  }
  
  private static zzws<Boolean> zza(zzxc paramzzxc, String paramString, boolean paramBoolean)
  {
    return new zzwy(paramzzxc, paramString, Boolean.valueOf(paramBoolean));
  }
  
  private static <V> V zza(zzxb<V> paramzzxb)
  {
    try
    {
      Object localObject = paramzzxb.zzsc();
      return localObject;
    }
    catch (SecurityException localSecurityException)
    {
      long l = Binder.clearCallingIdentity();
      try
      {
        paramzzxb = paramzzxb.zzsc();
        return paramzzxb;
      }
      finally
      {
        Binder.restoreCallingIdentity(l);
      }
    }
  }
  
  static boolean zzd(String paramString, boolean paramBoolean)
  {
    try
    {
      if (zzsa())
      {
        paramBoolean = ((Boolean)zza(new zzwv(paramString, false))).booleanValue();
        return paramBoolean;
      }
      return false;
    }
    catch (SecurityException paramString) {}
    return false;
  }
  
  private final T zzry()
  {
    String str;
    if (!zzd("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false))
    {
      if (zzxc.zza(this.zzbng) != null)
      {
        if (this.zzbnl == null) {
          this.zzbnl = zzwp.zza(zzqx.getContentResolver(), zzxc.zza(this.zzbng));
        }
        str = (String)zza(new zzwt(this, this.zzbnl));
        if (str != null) {
          return zzey(str);
        }
      }
    }
    else
    {
      str = String.valueOf(this.zzbnh);
      if (str.length() == 0) {
        break label99;
      }
      "Bypass reading Phenotype values for flag: ".concat(str);
    }
    for (;;)
    {
      return null;
      label99:
      new String("Bypass reading Phenotype values for flag: ");
    }
  }
  
  private final T zzrz()
  {
    if (zzsa())
    {
      String str;
      try
      {
        Object localObject = (String)zza(new zzwu(this));
        if (localObject == null) {
          break label57;
        }
        localObject = zzey((String)localObject);
        return localObject;
      }
      catch (SecurityException localSecurityException)
      {
        str = String.valueOf(this.zzbnh);
        if (str.length() == 0) {
          break label59;
        }
      }
      "Unable to read GServices for flag: ".concat(str);
    }
    for (;;)
    {
      label57:
      return null;
      label59:
      new String("Unable to read GServices for flag: ");
    }
  }
  
  private static boolean zzsa()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (zzbne == null)
    {
      if (zzqx != null)
      {
        bool1 = bool2;
        if (c.h(zzqx, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
          bool1 = true;
        }
        zzbne = Boolean.valueOf(bool1);
      }
    }
    else {
      bool1 = zzbne.booleanValue();
    }
    return bool1;
  }
  
  public final T get()
  {
    if (zzqx == null) {
      throw new IllegalStateException("Must call PhenotypeFlag.init() first");
    }
    Object localObject1 = zzry();
    if (localObject1 != null) {}
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = zzrz();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return this.zzbnj;
  }
  
  protected abstract T zzey(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzws
 * JD-Core Version:    0.7.0.1
 */