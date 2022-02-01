package com.google.android.gms.common.config;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.stable.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public abstract class GservicesValue<T>
{
  private static final Object sLock = new Object();
  private static zza zzmu = null;
  private static int zzmv = 0;
  private static Context zzmw;
  private static String zzmx = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  @GuardedBy("sLock")
  private static HashSet<String> zzmy;
  protected final T mDefaultValue;
  protected final String mKey;
  private T zzmz = null;
  
  protected GservicesValue(String paramString, T paramT)
  {
    this.mKey = paramString;
    this.mDefaultValue = paramT;
  }
  
  @Deprecated
  @VisibleForTesting
  public static void forceInit(Context paramContext)
  {
    forceInit(paramContext, new HashSet());
  }
  
  @VisibleForTesting
  public static void forceInit(Context paramContext, HashSet<String> paramHashSet)
  {
    zza(paramContext, new zzd(paramContext.getContentResolver()), paramHashSet);
  }
  
  @TargetApi(24)
  public static SharedPreferences getDirectBootCache(Context paramContext)
  {
    return paramContext.getApplicationContext().createDeviceProtectedStorageContext().getSharedPreferences("gservices-direboot-cache", 0);
  }
  
  public static int getSharedUserId()
  {
    return zzmv;
  }
  
  @Deprecated
  public static void init(Context paramContext)
  {
    if (zzd(paramContext)) {}
    for (HashSet localHashSet = new HashSet();; localHashSet = null)
    {
      init(paramContext, localHashSet);
      return;
    }
  }
  
  public static void init(Context paramContext, HashSet<String> paramHashSet)
  {
    synchronized (sLock)
    {
      if (zzmu == null) {
        zza(paramContext, new zzd(paramContext.getContentResolver()), paramHashSet);
      }
      int i = zzmv;
      if (i != 0) {}
    }
    try
    {
      zzmv = paramContext.getPackageManager().getApplicationInfo("com.google.android.gms", 0).uid;
      label52:
      return;
      paramContext = finally;
      throw paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      break label52;
    }
  }
  
  @Deprecated
  @VisibleForTesting
  public static void initForTests()
  {
    zza(null, new zzb(null), new HashSet());
  }
  
  @VisibleForTesting
  public static void initForTests(Context paramContext, HashSet<String> paramHashSet)
  {
    zza(paramContext, new zzb(null), paramHashSet);
  }
  
  @Deprecated
  @VisibleForTesting
  public static void initForTests(String paramString, Object paramObject)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put(paramString, paramObject);
    initForTests(localHashMap);
  }
  
  @Deprecated
  @VisibleForTesting
  public static void initForTests(Map<String, ?> paramMap)
  {
    synchronized (sLock)
    {
      zzmu = new zzc(paramMap);
      return;
    }
  }
  
  public static boolean isInitialized()
  {
    for (;;)
    {
      synchronized (sLock)
      {
        if (zzmu != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static GservicesValue<String> partnerSetting(String paramString1, String paramString2)
  {
    return new zzg(paramString1, paramString2);
  }
  
  @VisibleForTesting
  public static void resetAllOverrides()
  {
    synchronized (sLock)
    {
      if (!zzcg()) {
        break label58;
      }
      Iterator localIterator = zzb.zzci().iterator();
      if (localIterator.hasNext()) {
        ((GservicesValue)localIterator.next()).resetOverride();
      }
    }
    zzb.zzci().clear();
    label58:
  }
  
  public static GservicesValue<Double> value(String paramString, Double paramDouble)
  {
    return new zzd(paramString, paramDouble);
  }
  
  public static GservicesValue<Float> value(String paramString, Float paramFloat)
  {
    return new zze(paramString, paramFloat);
  }
  
  public static GservicesValue<Integer> value(String paramString, Integer paramInteger)
  {
    return new zzc(paramString, paramInteger);
  }
  
  public static GservicesValue<Long> value(String paramString, Long paramLong)
  {
    return new zzb(paramString, paramLong);
  }
  
  public static GservicesValue<String> value(String paramString1, String paramString2)
  {
    return new zzf(paramString1, paramString2);
  }
  
  public static GservicesValue<Boolean> value(String paramString, boolean paramBoolean)
  {
    return new zza(paramString, Boolean.valueOf(paramBoolean));
  }
  
  @TargetApi(24)
  private static void zza(Context paramContext, zza paramzza, HashSet<String> paramHashSet)
  {
    synchronized (sLock)
    {
      zzmu = paramzza;
      zzmy = null;
      zzmw = null;
      if ((paramContext != null) && (zzd(paramContext)))
      {
        zzmy = paramHashSet;
        zzmw = paramContext.getApplicationContext().createDeviceProtectedStorageContext();
      }
      return;
    }
  }
  
  private static boolean zzcg()
  {
    for (;;)
    {
      synchronized (sLock)
      {
        if (!(zzmu instanceof zzb))
        {
          if (!(zzmu instanceof zzc)) {
            break label41;
          }
          break label36;
          return bool;
        }
      }
      label36:
      boolean bool = true;
      continue;
      label41:
      bool = false;
    }
  }
  
  @TargetApi(24)
  private static boolean zzd(Context paramContext)
  {
    if (!PlatformVersion.isAtLeastN()) {
      return false;
    }
    paramContext = (UserManager)paramContext.getSystemService(UserManager.class);
    if (paramContext.isUserUnlocked()) {
      return false;
    }
    return !paramContext.isUserRunning(Process.myUserHandle());
  }
  
  public final T get()
  {
    if (this.zzmz != null) {
      return this.zzmz;
    }
    Object localObject1 = StrictMode.allowThreadDiskReads();
    Context localContext;
    for (;;)
    {
      synchronized (sLock)
      {
        int i;
        if ((zzmw != null) && (zzd(zzmw)))
        {
          i = 1;
          HashSet localHashSet = zzmy;
          localContext = zzmw;
          if (i == 0) {
            break label199;
          }
          if (Log.isLoggable("GservicesValue", 3))
          {
            localObject1 = String.valueOf(this.mKey);
            if (((String)localObject1).length() != 0) {
              "Gservice value accessed during directboot: ".concat((String)localObject1);
            }
          }
          else
          {
            if ((localHashSet == null) || (localHashSet.contains(this.mKey))) {
              break;
            }
            localObject1 = String.valueOf(this.mKey);
            if (((String)localObject1).length() == 0) {
              break label170;
            }
            "Gservices key not whitelisted for directboot access: ".concat((String)localObject1);
            return this.mDefaultValue;
          }
        }
        else
        {
          i = 0;
        }
      }
      new String("Gservice value accessed during directboot: ");
      continue;
      label170:
      new String("Gservices key not whitelisted for directboot access: ");
    }
    return retrieveFromDirectBootCache(localContext, this.mKey, this.mDefaultValue);
    synchronized (sLock)
    {
      label199:
      zzmy = null;
      zzmw = null;
    }
  }
  
  @Deprecated
  public final T getBinderSafe()
  {
    return get();
  }
  
  public String getKey()
  {
    return this.mKey;
  }
  
  @VisibleForTesting
  public void override(T arg1)
  {
    this.zzmz = ???;
    synchronized (sLock)
    {
      if (zzcg()) {
        zzb.zzci().add(this);
      }
      return;
    }
  }
  
  @VisibleForTesting
  public void resetOverride()
  {
    this.zzmz = null;
  }
  
  protected abstract T retrieve(String paramString);
  
  @TargetApi(24)
  protected T retrieveFromDirectBootCache(Context paramContext, String paramString, T paramT)
  {
    throw new UnsupportedOperationException("The Gservices classes used does not support direct-boot");
  }
  
  static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);
    
    public abstract String getString(String paramString1, String paramString2);
    
    public abstract Boolean zza(String paramString, Boolean paramBoolean);
    
    public abstract Double zza(String paramString, Double paramDouble);
    
    public abstract Float zza(String paramString, Float paramFloat);
    
    public abstract Integer zza(String paramString, Integer paramInteger);
    
    public abstract String zzb(String paramString1, String paramString2);
  }
  
  static final class zzb
    implements GservicesValue.zza
  {
    private static final Collection<GservicesValue<?>> zzna;
    
    static
    {
      AppMethodBeat.i(4542);
      zzna = new HashSet();
      AppMethodBeat.o(4542);
    }
    
    public final Long getLong(String paramString, Long paramLong)
    {
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      return paramString2;
    }
    
    public final Boolean zza(String paramString, Boolean paramBoolean)
    {
      return paramBoolean;
    }
    
    public final Double zza(String paramString, Double paramDouble)
    {
      return paramDouble;
    }
    
    public final Float zza(String paramString, Float paramFloat)
    {
      return paramFloat;
    }
    
    public final Integer zza(String paramString, Integer paramInteger)
    {
      return paramInteger;
    }
    
    public final String zzb(String paramString1, String paramString2)
    {
      return paramString2;
    }
  }
  
  @Deprecated
  static final class zzc
    implements GservicesValue.zza
  {
    private final Map<String, ?> values;
    
    public zzc(Map<String, ?> paramMap)
    {
      this.values = paramMap;
    }
    
    private final <T> T zza(String paramString, T paramT)
    {
      AppMethodBeat.i(4550);
      if (this.values.containsKey(paramString))
      {
        paramString = this.values.get(paramString);
        AppMethodBeat.o(4550);
        return paramString;
      }
      AppMethodBeat.o(4550);
      return paramT;
    }
    
    public final Long getLong(String paramString, Long paramLong)
    {
      AppMethodBeat.i(4547);
      paramString = (Long)zza(paramString, paramLong);
      AppMethodBeat.o(4547);
      return paramString;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(4548);
      paramString1 = (String)zza(paramString1, paramString2);
      AppMethodBeat.o(4548);
      return paramString1;
    }
    
    public final Boolean zza(String paramString, Boolean paramBoolean)
    {
      AppMethodBeat.i(4543);
      paramString = (Boolean)zza(paramString, paramBoolean);
      AppMethodBeat.o(4543);
      return paramString;
    }
    
    public final Double zza(String paramString, Double paramDouble)
    {
      AppMethodBeat.i(4545);
      paramString = (Double)zza(paramString, paramDouble);
      AppMethodBeat.o(4545);
      return paramString;
    }
    
    public final Float zza(String paramString, Float paramFloat)
    {
      AppMethodBeat.i(4546);
      paramString = (Float)zza(paramString, paramFloat);
      AppMethodBeat.o(4546);
      return paramString;
    }
    
    public final Integer zza(String paramString, Integer paramInteger)
    {
      AppMethodBeat.i(4544);
      paramString = (Integer)zza(paramString, paramInteger);
      AppMethodBeat.o(4544);
      return paramString;
    }
    
    public final String zzb(String paramString1, String paramString2)
    {
      AppMethodBeat.i(4549);
      paramString1 = (String)zza(paramString1, paramString2);
      AppMethodBeat.o(4549);
      return paramString1;
    }
  }
  
  static final class zzd
    implements GservicesValue.zza
  {
    private final ContentResolver mContentResolver;
    
    public zzd(ContentResolver paramContentResolver)
    {
      this.mContentResolver = paramContentResolver;
    }
    
    public final Long getLong(String paramString, Long paramLong)
    {
      AppMethodBeat.i(4555);
      long l = zzi.getLong(this.mContentResolver, paramString, paramLong.longValue());
      AppMethodBeat.o(4555);
      return Long.valueOf(l);
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(4556);
      paramString1 = zzi.zza(this.mContentResolver, paramString1, paramString2);
      AppMethodBeat.o(4556);
      return paramString1;
    }
    
    public final Boolean zza(String paramString, Boolean paramBoolean)
    {
      AppMethodBeat.i(4551);
      boolean bool = zzi.zza(this.mContentResolver, paramString, paramBoolean.booleanValue());
      AppMethodBeat.o(4551);
      return Boolean.valueOf(bool);
    }
    
    public final Double zza(String paramString, Double paramDouble)
    {
      AppMethodBeat.i(4553);
      paramString = zzi.zza(this.mContentResolver, paramString, null);
      if (paramString != null) {
        try
        {
          double d = Double.parseDouble(paramString);
          AppMethodBeat.o(4553);
          return Double.valueOf(d);
        }
        catch (NumberFormatException paramString) {}
      }
      AppMethodBeat.o(4553);
      return paramDouble;
    }
    
    public final Float zza(String paramString, Float paramFloat)
    {
      AppMethodBeat.i(4554);
      paramString = zzi.zza(this.mContentResolver, paramString, null);
      if (paramString != null) {
        try
        {
          float f = Float.parseFloat(paramString);
          AppMethodBeat.o(4554);
          return Float.valueOf(f);
        }
        catch (NumberFormatException paramString) {}
      }
      AppMethodBeat.o(4554);
      return paramFloat;
    }
    
    public final Integer zza(String paramString, Integer paramInteger)
    {
      AppMethodBeat.i(4552);
      int i = zzi.getInt(this.mContentResolver, paramString, paramInteger.intValue());
      AppMethodBeat.o(4552);
      return Integer.valueOf(i);
    }
    
    public final String zzb(String paramString1, String paramString2)
    {
      AppMethodBeat.i(4557);
      paramString1 = com.google.android.gms.internal.stable.zzg.zza(this.mContentResolver, paramString1, paramString2);
      AppMethodBeat.o(4557);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.config.GservicesValue
 * JD-Core Version:    0.7.0.1
 */