package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public abstract class DowngradeableSafeParcel
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  private static final Object zzsj = new Object();
  private static ClassLoader zzsk = null;
  private static Integer zzsl = null;
  private boolean zzsm = false;
  
  protected static boolean canUnparcelSafely(String paramString)
  {
    ClassLoader localClassLoader = getUnparcelClassLoader();
    if (localClassLoader == null) {
      return true;
    }
    try
    {
      boolean bool = zza(localClassLoader.loadClass(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  static Bundle getExtras(Intent paramIntent, Context paramContext, Integer paramInteger)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        zza(paramContext.getClassLoader(), paramInteger);
        if (paramIntent.getExtras() != null)
        {
          paramContext = new Bundle();
          paramContext.putAll(paramIntent.getExtras());
          paramIntent = paramContext;
          return paramIntent;
        }
      }
      finally
      {
        zza(null, null);
      }
      paramIntent = null;
    }
  }
  
  static <T extends Parcelable> T getParcelable(Intent paramIntent, String paramString, Context paramContext, Integer paramInteger)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        zza(paramContext.getClassLoader(), paramInteger);
        paramIntent = paramIntent.getParcelableExtra(paramString);
        return paramIntent;
      }
      finally
      {
        zza(null, null);
      }
      paramIntent = null;
    }
  }
  
  static <T extends Parcelable> T getParcelable(Bundle paramBundle, String paramString, Context paramContext, Integer paramInteger)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        zza(paramContext.getClassLoader(), paramInteger);
        paramBundle = paramBundle.getParcelable(paramString);
        return paramBundle;
      }
      finally
      {
        zza(null, null);
      }
      paramBundle = null;
    }
  }
  
  protected static ClassLoader getUnparcelClassLoader()
  {
    synchronized (zzsj)
    {
      ClassLoader localClassLoader = zzsk;
      return localClassLoader;
    }
  }
  
  protected static Integer getUnparcelClientVersion()
  {
    synchronized (zzsj)
    {
      Integer localInteger = zzsl;
      return localInteger;
    }
  }
  
  static boolean putParcelable(Bundle paramBundle, String paramString, DowngradeableSafeParcel paramDowngradeableSafeParcel, Context paramContext, Integer paramInteger)
  {
    if ((paramContext == null) && (paramInteger == null)) {}
    while (!paramDowngradeableSafeParcel.zza(paramContext, paramInteger)) {
      return false;
    }
    paramBundle.putParcelable(paramString, paramDowngradeableSafeParcel);
    return true;
  }
  
  private static void zza(ClassLoader paramClassLoader, Integer paramInteger)
  {
    synchronized (zzsj)
    {
      zzsk = paramClassLoader;
      zzsl = paramInteger;
      return;
    }
  }
  
  private final boolean zza(Context paramContext, Integer paramInteger)
  {
    if (paramInteger != null) {
      return prepareForClientVersion(paramInteger.intValue());
    }
    for (;;)
    {
      try
      {
        if (!zza(paramContext.getClassLoader().loadClass(getClass().getCanonicalName())))
        {
          bool = true;
          setShouldDowngrade(bool);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
      boolean bool = false;
    }
  }
  
  private static boolean zza(Class<?> paramClass)
  {
    try
    {
      boolean bool = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
      return bool;
    }
    catch (IllegalAccessException paramClass)
    {
      return false;
    }
    catch (NoSuchFieldException paramClass) {}
    return false;
  }
  
  protected abstract boolean prepareForClientVersion(int paramInt);
  
  public void setShouldDowngrade(boolean paramBoolean)
  {
    this.zzsm = paramBoolean;
  }
  
  protected boolean shouldDowngrade()
  {
    return this.zzsm;
  }
  
  public static final class DowngradeableSafeParcelHelper
  {
    public static Bundle getExtras(Intent paramIntent, Context paramContext, Integer paramInteger)
    {
      AppMethodBeat.i(4614);
      synchronized (DowngradeableSafeParcel.zzcs())
      {
        paramIntent = DowngradeableSafeParcel.getExtras(paramIntent, paramContext, paramInteger);
        AppMethodBeat.o(4614);
        return paramIntent;
      }
    }
    
    public static <T extends Parcelable> T getParcelable(Intent paramIntent, String paramString, Context paramContext, Integer paramInteger)
    {
      AppMethodBeat.i(4612);
      synchronized (DowngradeableSafeParcel.zzcs())
      {
        paramIntent = DowngradeableSafeParcel.getParcelable(paramIntent, paramString, paramContext, paramInteger);
        AppMethodBeat.o(4612);
        return paramIntent;
      }
    }
    
    public static <T extends Parcelable> T getParcelable(Bundle paramBundle, String paramString, Context paramContext, Integer paramInteger)
    {
      AppMethodBeat.i(4615);
      synchronized (DowngradeableSafeParcel.zzcs())
      {
        paramBundle = DowngradeableSafeParcel.getParcelable(paramBundle, paramString, paramContext, paramInteger);
        AppMethodBeat.o(4615);
        return paramBundle;
      }
    }
    
    public static boolean putParcelable(Bundle paramBundle, String paramString, DowngradeableSafeParcel paramDowngradeableSafeParcel, Context paramContext, Integer paramInteger)
    {
      AppMethodBeat.i(4613);
      boolean bool = DowngradeableSafeParcel.putParcelable(paramBundle, paramString, paramDowngradeableSafeParcel, paramContext, paramInteger);
      AppMethodBeat.o(4613);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.DowngradeableSafeParcel
 * JD-Core Version:    0.7.0.1
 */