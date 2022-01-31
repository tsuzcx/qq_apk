package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory;
import com.google.android.gms.common.stats.StatsUtils;
import com.google.android.gms.common.stats.WakeLockTracker;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class WakeLock
{
  private static ScheduledExecutorService zzaeg;
  private static WakeLock.Configuration zzaeh;
  private final PowerManager.WakeLock zzadv;
  private WorkSource zzadw;
  private String zzadx;
  private final int zzady;
  private final String zzadz;
  private final String zzaea;
  private final String zzaeb;
  private boolean zzaec;
  private final Map<String, Integer[]> zzaed;
  private int zzaee;
  private AtomicInteger zzaef;
  private final Context zzjp;
  
  static
  {
    AppMethodBeat.i(113975);
    zzaeh = new zza();
    AppMethodBeat.o(113975);
  }
  
  public WakeLock(Context paramContext, int paramInt, @Nonnull String paramString) {}
  
  public WakeLock(Context paramContext, int paramInt, @Nonnull String paramString1, @Nullable String paramString2) {}
  
  @SuppressLint({"UnwrappedWakeLock"})
  public WakeLock(Context paramContext, int paramInt, @Nonnull String paramString1, @Nullable String paramString2, @Nonnull String paramString3)
  {
    this(paramContext, paramInt, paramString1, paramString2, paramString3, null);
  }
  
  @SuppressLint({"UnwrappedWakeLock"})
  public WakeLock(Context paramContext, int paramInt, @Nonnull String paramString1, @Nullable String paramString2, @Nonnull String paramString3, @Nullable String paramString4)
  {
    AppMethodBeat.i(113951);
    this.zzaec = true;
    this.zzaed = new HashMap();
    this.zzaef = new AtomicInteger(0);
    Preconditions.checkNotEmpty(paramString1, "Wake lock name can NOT be empty");
    this.zzady = paramInt;
    this.zzaea = paramString2;
    this.zzaeb = paramString4;
    this.zzjp = paramContext.getApplicationContext();
    if (!"com.google.android.gms".equals(paramContext.getPackageName()))
    {
      paramString2 = String.valueOf("*gcore*:");
      String str = String.valueOf(paramString1);
      if (str.length() != 0)
      {
        paramString2 = paramString2.concat(str);
        this.zzadz = paramString2;
        label117:
        this.zzadv = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, paramString1);
        if (WorkSourceUtil.hasWorkSourcePermission(paramContext))
        {
          paramString1 = paramString3;
          if (Strings.isEmptyOrWhitespace(paramString3)) {
            paramString1 = paramContext.getPackageName();
          }
          if ((!zzaeh.isWorkChainsEnabled()) || (paramString1 == null) || (paramString4 == null)) {
            break label293;
          }
          new StringBuilder(String.valueOf(paramString1).length() + 42 + String.valueOf(paramString4).length()).append("Using experimental Pi WorkSource chains: ").append(paramString1).append(",").append(paramString4);
          this.zzadx = paramString1;
        }
      }
    }
    label293:
    for (this.zzadw = WorkSourceUtil.fromPackageAndModuleExperimentalPi(paramContext, paramString1, paramString4);; this.zzadw = WorkSourceUtil.fromPackage(paramContext, paramString1))
    {
      addWorkSource(this.zzadw);
      if (zzaeg == null) {
        zzaeg = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
      }
      AppMethodBeat.o(113951);
      return;
      paramString2 = new String(paramString2);
      break;
      this.zzadz = paramString1;
      break label117;
    }
  }
  
  public static void setConfiguration(WakeLock.Configuration paramConfiguration)
  {
    zzaeh = paramConfiguration;
  }
  
  private final void zza(WorkSource paramWorkSource)
  {
    AppMethodBeat.i(113970);
    try
    {
      this.zzadv.setWorkSource(paramWorkSource);
      AppMethodBeat.o(113970);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramWorkSource)
    {
      Log.wtf("WakeLock", paramWorkSource.toString());
      AppMethodBeat.o(113970);
      return;
    }
    catch (IllegalArgumentException paramWorkSource)
    {
      label20:
      break label20;
    }
  }
  
  @SuppressLint({"WakelockTimeout"})
  private final void zza(String paramString, long paramLong)
  {
    AppMethodBeat.i(113957);
    paramString = zzn(paramString);
    for (;;)
    {
      int i;
      try
      {
        if (((!this.zzaed.isEmpty()) || (this.zzaee > 0)) && (!this.zzadv.isHeld()))
        {
          this.zzaed.clear();
          this.zzaee = 0;
        }
        Integer[] arrayOfInteger;
        if (this.zzaec)
        {
          arrayOfInteger = (Integer[])this.zzaed.get(paramString);
          if (arrayOfInteger == null)
          {
            this.zzaed.put(paramString, new Integer[] { Integer.valueOf(1) });
            i = 1;
            break label304;
          }
        }
        else
        {
          if ((!this.zzaec) && (this.zzaee == 0))
          {
            WakeLockTracker.getInstance().registerEvent(this.zzjp, StatsUtils.getEventKey(this.zzadv, paramString), 7, this.zzadz, paramString, this.zzaeb, this.zzady, zzdo(), paramLong);
            this.zzaee += 1;
          }
          this.zzadv.acquire();
          if (paramLong > 0L)
          {
            zzaeg.schedule(new zzb(this), paramLong, TimeUnit.MILLISECONDS);
            if ((!PlatformVersion.isAtLeastIceCreamSandwich()) && (this.zzaec))
            {
              paramString = String.valueOf(this.zzadz);
              if (paramString.length() == 0) {
                break label290;
              }
              paramString = "Do not acquire with timeout on reference counted wakeLocks before ICS. wakelock: ".concat(paramString);
              Log.wtf("WakeLock", paramString);
            }
          }
          AppMethodBeat.o(113957);
          return;
        }
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        i = 0;
      }
      finally
      {
        AppMethodBeat.o(113957);
      }
      label290:
      paramString = new String("Do not acquire with timeout on reference counted wakeLocks before ICS. wakelock: ");
      continue;
      label304:
      if (i != 0) {}
    }
  }
  
  private final void zzb(String paramString, int paramInt)
  {
    AppMethodBeat.i(113963);
    this.zzaef.decrementAndGet();
    zzc(paramString, paramInt);
    AppMethodBeat.o(113963);
  }
  
  private final void zzc(String paramString, int paramInt)
  {
    AppMethodBeat.i(113964);
    paramString = zzn(paramString);
    for (;;)
    {
      int i;
      try
      {
        Integer[] arrayOfInteger;
        if (this.zzaec)
        {
          arrayOfInteger = (Integer[])this.zzaed.get(paramString);
          if (arrayOfInteger == null)
          {
            i = 0;
            break label181;
          }
        }
        else
        {
          if ((!this.zzaec) && (this.zzaee == 1))
          {
            WakeLockTracker.getInstance().registerEvent(this.zzjp, StatsUtils.getEventKey(this.zzadv, paramString), 8, this.zzadz, paramString, this.zzaeb, this.zzady, zzdo());
            this.zzaee -= 1;
          }
          zzn(paramInt);
          AppMethodBeat.o(113964);
          return;
        }
        if (arrayOfInteger[0].intValue() == 1)
        {
          this.zzaed.remove(paramString);
          i = 1;
        }
        else
        {
          arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() - 1);
          i = 0;
        }
      }
      finally
      {
        AppMethodBeat.o(113964);
      }
      label181:
      if (i != 0) {}
    }
  }
  
  private final List<String> zzdo()
  {
    AppMethodBeat.i(113952);
    Object localObject = WorkSourceUtil.getNames(this.zzadw);
    if (this.zzadx == null)
    {
      AppMethodBeat.o(113952);
      return localObject;
    }
    localObject = new ArrayList((Collection)localObject);
    ((List)localObject).add(this.zzadx);
    AppMethodBeat.o(113952);
    return localObject;
  }
  
  private final String zzn(String paramString)
  {
    AppMethodBeat.i(113966);
    if (this.zzaec)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(113966);
        return paramString;
      }
      paramString = this.zzaea;
      AppMethodBeat.o(113966);
      return paramString;
    }
    paramString = this.zzaea;
    AppMethodBeat.o(113966);
    return paramString;
  }
  
  private final void zzn(int paramInt)
  {
    AppMethodBeat.i(113965);
    if (this.zzadv.isHeld()) {
      try
      {
        if ((Build.VERSION.SDK_INT >= 21) && (paramInt > 0))
        {
          this.zzadv.release(paramInt);
          AppMethodBeat.o(113965);
          return;
        }
        this.zzadv.release();
        AppMethodBeat.o(113965);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        if (localRuntimeException.getClass().equals(RuntimeException.class))
        {
          String.valueOf(this.zzadz).concat(" was already released!");
          AppMethodBeat.o(113965);
          return;
        }
        AppMethodBeat.o(113965);
        throw localRuntimeException;
      }
    }
    AppMethodBeat.o(113965);
  }
  
  public void acquire()
  {
    AppMethodBeat.i(113953);
    this.zzaef.incrementAndGet();
    zza(null, 0L);
    AppMethodBeat.o(113953);
  }
  
  public void acquire(long paramLong)
  {
    AppMethodBeat.i(113954);
    this.zzaef.incrementAndGet();
    zza(null, paramLong);
    AppMethodBeat.o(113954);
  }
  
  public void acquire(String paramString)
  {
    AppMethodBeat.i(113955);
    this.zzaef.incrementAndGet();
    zza(paramString, 0L);
    AppMethodBeat.o(113955);
  }
  
  public void acquire(String paramString, long paramLong)
  {
    AppMethodBeat.i(113956);
    this.zzaef.incrementAndGet();
    zza(paramString, paramLong);
    AppMethodBeat.o(113956);
  }
  
  public WakeLock.HeldLock acquireLock(long paramLong, String paramString)
  {
    AppMethodBeat.i(113958);
    paramLong = Math.min(paramLong, zzaeh.getMaximumTimeout(this.zzadz, paramString));
    WakeLock.HeldLock localHeldLock = new WakeLock.HeldLock(this, paramString, null);
    zza(paramString, 0L);
    paramString = new WeakReference(localHeldLock);
    WakeLock.HeldLock.zza(localHeldLock, zzaeg.schedule(new zzc(paramString), paramLong, TimeUnit.MILLISECONDS));
    AppMethodBeat.o(113958);
    return localHeldLock;
  }
  
  public void addWorkSource(WorkSource paramWorkSource)
  {
    AppMethodBeat.i(113969);
    if ((paramWorkSource != null) && (WorkSourceUtil.hasWorkSourcePermission(this.zzjp)))
    {
      if (this.zzadw == null) {
        break label51;
      }
      this.zzadw.add(paramWorkSource);
    }
    for (;;)
    {
      zza(this.zzadw);
      AppMethodBeat.o(113969);
      return;
      label51:
      this.zzadw = paramWorkSource;
    }
  }
  
  public PowerManager.WakeLock getWakeLock()
  {
    return this.zzadv;
  }
  
  public boolean isHeld()
  {
    AppMethodBeat.i(113968);
    boolean bool = this.zzadv.isHeld();
    AppMethodBeat.o(113968);
    return bool;
  }
  
  public void release()
  {
    AppMethodBeat.i(113959);
    zzb(null, 0);
    AppMethodBeat.o(113959);
  }
  
  public void release(int paramInt)
  {
    AppMethodBeat.i(113960);
    zzb(null, paramInt);
    AppMethodBeat.o(113960);
  }
  
  public void release(String paramString)
  {
    AppMethodBeat.i(113961);
    zzb(paramString, 0);
    AppMethodBeat.o(113961);
  }
  
  public void release(String paramString, int paramInt)
  {
    AppMethodBeat.i(113962);
    zzb(paramString, paramInt);
    AppMethodBeat.o(113962);
  }
  
  public void removeWorkSource(WorkSource paramWorkSource)
  {
    AppMethodBeat.i(113971);
    if ((paramWorkSource != null) && (WorkSourceUtil.hasWorkSourcePermission(this.zzjp))) {
      try
      {
        if (this.zzadw != null) {
          this.zzadw.remove(paramWorkSource);
        }
        zza(this.zzadw);
        AppMethodBeat.o(113971);
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramWorkSource) {}
    }
    AppMethodBeat.o(113971);
  }
  
  public void setReferenceCounted(boolean paramBoolean)
  {
    AppMethodBeat.i(113967);
    this.zzadv.setReferenceCounted(paramBoolean);
    this.zzaec = paramBoolean;
    AppMethodBeat.o(113967);
  }
  
  public void setWorkSource(WorkSource paramWorkSource)
  {
    AppMethodBeat.i(113972);
    if (WorkSourceUtil.hasWorkSourcePermission(this.zzjp))
    {
      zza(paramWorkSource);
      this.zzadw = paramWorkSource;
      this.zzadx = null;
    }
    AppMethodBeat.o(113972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.stats.WakeLock
 * JD-Core Version:    0.7.0.1
 */