package com.google.android.gms.stats;

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
import com.tencent.mm.hellhoundlib.b.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WakeLock
{
  private static ScheduledExecutorService zzaeg;
  private static Configuration zzaeh;
  private byte _hellAccFlag_;
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
    AppMethodBeat.i(73473);
    zzaeh = new zza();
    AppMethodBeat.o(73473);
  }
  
  public WakeLock(Context paramContext, int paramInt, String paramString) {}
  
  public WakeLock(Context paramContext, int paramInt, String paramString1, String paramString2) {}
  
  public WakeLock(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, paramInt, paramString1, paramString2, paramString3, null);
  }
  
  public WakeLock(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(73449);
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
      AppMethodBeat.o(73449);
      return;
      paramString2 = new String(paramString2);
      break;
      this.zzadz = paramString1;
      break label117;
    }
  }
  
  public static void setConfiguration(Configuration paramConfiguration)
  {
    zzaeh = paramConfiguration;
  }
  
  private final void zza(WorkSource paramWorkSource)
  {
    AppMethodBeat.i(73468);
    try
    {
      this.zzadv.setWorkSource(paramWorkSource);
      AppMethodBeat.o(73468);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramWorkSource)
    {
      Log.wtf("WakeLock", paramWorkSource.toString());
      AppMethodBeat.o(73468);
      return;
    }
    catch (IllegalArgumentException paramWorkSource)
    {
      label20:
      break label20;
    }
  }
  
  private final void zza(String paramString, long paramLong)
  {
    AppMethodBeat.i(73455);
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
            break label350;
          }
        }
        else
        {
          if ((!this.zzaec) && (this.zzaee == 0))
          {
            WakeLockTracker.getInstance().registerEvent(this.zzjp, StatsUtils.getEventKey(this.zzadv, paramString), 7, this.zzadz, paramString, this.zzaeb, this.zzady, zzdo(), paramLong);
            this.zzaee += 1;
          }
          paramString = this.zzadv;
          com.tencent.mm.hellhoundlib.a.a.b(paramString, "com/google/android/gms/stats/WakeLock", "zza", "(Ljava/lang/String;J)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
          paramString.acquire();
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/google/android/gms/stats/WakeLock", "zza", "(Ljava/lang/String;J)V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
          if (paramLong > 0L)
          {
            zzaeg.schedule(new zzb(this), paramLong, TimeUnit.MILLISECONDS);
            if ((!PlatformVersion.isAtLeastIceCreamSandwich()) && (this.zzaec))
            {
              paramString = String.valueOf(this.zzadz);
              if (paramString.length() == 0) {
                break label336;
              }
              paramString = "Do not acquire with timeout on reference counted wakeLocks before ICS. wakelock: ".concat(paramString);
              Log.wtf("WakeLock", paramString);
            }
          }
          AppMethodBeat.o(73455);
          return;
        }
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        i = 0;
      }
      finally
      {
        AppMethodBeat.o(73455);
      }
      label336:
      paramString = new String("Do not acquire with timeout on reference counted wakeLocks before ICS. wakelock: ");
      continue;
      label350:
      if (i != 0) {}
    }
  }
  
  private final void zzb(String paramString, int paramInt)
  {
    AppMethodBeat.i(73461);
    this.zzaef.decrementAndGet();
    zzc(paramString, paramInt);
    AppMethodBeat.o(73461);
  }
  
  private final void zzc(String paramString, int paramInt)
  {
    AppMethodBeat.i(73462);
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
          AppMethodBeat.o(73462);
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
        AppMethodBeat.o(73462);
      }
      label181:
      if (i != 0) {}
    }
  }
  
  private final List<String> zzdo()
  {
    AppMethodBeat.i(73450);
    Object localObject = WorkSourceUtil.getNames(this.zzadw);
    if (this.zzadx == null)
    {
      AppMethodBeat.o(73450);
      return localObject;
    }
    localObject = new ArrayList((Collection)localObject);
    ((List)localObject).add(this.zzadx);
    AppMethodBeat.o(73450);
    return localObject;
  }
  
  private final String zzn(String paramString)
  {
    AppMethodBeat.i(73464);
    if (this.zzaec)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(73464);
        return paramString;
      }
      paramString = this.zzaea;
      AppMethodBeat.o(73464);
      return paramString;
    }
    paramString = this.zzaea;
    AppMethodBeat.o(73464);
    return paramString;
  }
  
  private final void zzn(int paramInt)
  {
    AppMethodBeat.i(73463);
    if (this.zzadv.isHeld()) {
      try
      {
        if ((Build.VERSION.SDK_INT >= 21) && (paramInt > 0))
        {
          localWakeLock = this.zzadv;
          com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, locala.aYi(), "com/google/android/gms/stats/WakeLock", "zzn", "(I)V", "android/os/PowerManager$WakeLock_EXEC_", "release", "(I)V");
          localWakeLock.release(((Integer)locala.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/google/android/gms/stats/WakeLock", "zzn", "(I)V", "android/os/PowerManager$WakeLock_EXEC_", "release", "(I)V");
          AppMethodBeat.o(73463);
          return;
        }
        PowerManager.WakeLock localWakeLock = this.zzadv;
        com.tencent.mm.hellhoundlib.a.a.b(localWakeLock, "com/google/android/gms/stats/WakeLock", "zzn", "(I)V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        localWakeLock.release();
        com.tencent.mm.hellhoundlib.a.a.c(localWakeLock, "com/google/android/gms/stats/WakeLock", "zzn", "(I)V", "android/os/PowerManager$WakeLock_EXEC_", "release", "()V");
        AppMethodBeat.o(73463);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        if (localRuntimeException.getClass().equals(RuntimeException.class))
        {
          String.valueOf(this.zzadz).concat(" was already released!");
          AppMethodBeat.o(73463);
          return;
        }
        AppMethodBeat.o(73463);
        throw localRuntimeException;
      }
    }
    AppMethodBeat.o(73463);
  }
  
  public void acquire()
  {
    AppMethodBeat.i(73451);
    this.zzaef.incrementAndGet();
    zza(null, 0L);
    AppMethodBeat.o(73451);
  }
  
  public void acquire(long paramLong)
  {
    AppMethodBeat.i(73452);
    this.zzaef.incrementAndGet();
    zza(null, paramLong);
    AppMethodBeat.o(73452);
  }
  
  public void acquire(String paramString)
  {
    AppMethodBeat.i(73453);
    this.zzaef.incrementAndGet();
    zza(paramString, 0L);
    AppMethodBeat.o(73453);
  }
  
  public void acquire(String paramString, long paramLong)
  {
    AppMethodBeat.i(73454);
    this.zzaef.incrementAndGet();
    zza(paramString, paramLong);
    AppMethodBeat.o(73454);
  }
  
  public HeldLock acquireLock(long paramLong, String paramString)
  {
    AppMethodBeat.i(73456);
    paramLong = Math.min(paramLong, zzaeh.getMaximumTimeout(this.zzadz, paramString));
    HeldLock localHeldLock = new HeldLock(paramString, null);
    zza(paramString, 0L);
    paramString = new WeakReference(localHeldLock);
    HeldLock.zza(localHeldLock, zzaeg.schedule(new zzc(paramString), paramLong, TimeUnit.MILLISECONDS));
    AppMethodBeat.o(73456);
    return localHeldLock;
  }
  
  public void addWorkSource(WorkSource paramWorkSource)
  {
    AppMethodBeat.i(73467);
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
      AppMethodBeat.o(73467);
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
    AppMethodBeat.i(73466);
    boolean bool = this.zzadv.isHeld();
    AppMethodBeat.o(73466);
    return bool;
  }
  
  public void release()
  {
    AppMethodBeat.i(73457);
    zzb(null, 0);
    AppMethodBeat.o(73457);
  }
  
  public void release(int paramInt)
  {
    AppMethodBeat.i(73458);
    zzb(null, paramInt);
    AppMethodBeat.o(73458);
  }
  
  public void release(String paramString)
  {
    AppMethodBeat.i(73459);
    zzb(paramString, 0);
    AppMethodBeat.o(73459);
  }
  
  public void release(String paramString, int paramInt)
  {
    AppMethodBeat.i(73460);
    zzb(paramString, paramInt);
    AppMethodBeat.o(73460);
  }
  
  public void removeWorkSource(WorkSource paramWorkSource)
  {
    AppMethodBeat.i(73469);
    if ((paramWorkSource != null) && (WorkSourceUtil.hasWorkSourcePermission(this.zzjp))) {
      try
      {
        if (this.zzadw != null) {
          this.zzadw.remove(paramWorkSource);
        }
        zza(this.zzadw);
        AppMethodBeat.o(73469);
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramWorkSource) {}
    }
    AppMethodBeat.o(73469);
  }
  
  public void setReferenceCounted(boolean paramBoolean)
  {
    AppMethodBeat.i(73465);
    this.zzadv.setReferenceCounted(paramBoolean);
    this.zzaec = paramBoolean;
    AppMethodBeat.o(73465);
  }
  
  public void setWorkSource(WorkSource paramWorkSource)
  {
    AppMethodBeat.i(73470);
    if (WorkSourceUtil.hasWorkSourcePermission(this.zzjp))
    {
      zza(paramWorkSource);
      this.zzadw = paramWorkSource;
      this.zzadx = null;
    }
    AppMethodBeat.o(73470);
  }
  
  public static abstract interface Configuration
  {
    public abstract long getMaximumTimeout(String paramString1, String paramString2);
    
    public abstract boolean isWorkChainsEnabled();
  }
  
  public class HeldLock
  {
    private boolean zzaek = true;
    private Future zzael;
    private final String zzaem;
    
    private HeldLock(String paramString)
    {
      this.zzaem = paramString;
    }
    
    public void finalize()
    {
      AppMethodBeat.i(73446);
      if (this.zzaek)
      {
        String str = String.valueOf(this.zzaem);
        if (str.length() == 0) {
          break label45;
        }
        "HeldLock finalized while still holding the WakeLock! Reason: ".concat(str);
      }
      for (;;)
      {
        release(0);
        AppMethodBeat.o(73446);
        return;
        label45:
        new String("HeldLock finalized while still holding the WakeLock! Reason: ");
      }
    }
    
    public void release()
    {
      AppMethodBeat.i(73444);
      release(0);
      AppMethodBeat.o(73444);
    }
    
    /* Error */
    public void release(int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 69
      //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 24	com/google/android/gms/stats/WakeLock$HeldLock:zzaek	Z
      //   11: ifne +11 -> 22
      //   14: ldc 69
      //   16: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: aload_0
      //   23: iconst_0
      //   24: putfield 24	com/google/android/gms/stats/WakeLock$HeldLock:zzaek	Z
      //   27: aload_0
      //   28: getfield 34	com/google/android/gms/stats/WakeLock$HeldLock:zzael	Ljava/util/concurrent/Future;
      //   31: ifnull +19 -> 50
      //   34: aload_0
      //   35: getfield 34	com/google/android/gms/stats/WakeLock$HeldLock:zzael	Ljava/util/concurrent/Future;
      //   38: iconst_0
      //   39: invokeinterface 75 2 0
      //   44: pop
      //   45: aload_0
      //   46: aconst_null
      //   47: putfield 34	com/google/android/gms/stats/WakeLock$HeldLock:zzael	Ljava/util/concurrent/Future;
      //   50: aload_0
      //   51: getfield 19	com/google/android/gms/stats/WakeLock$HeldLock:zzaei	Lcom/google/android/gms/stats/WakeLock;
      //   54: aload_0
      //   55: getfield 26	com/google/android/gms/stats/WakeLock$HeldLock:zzaem	Ljava/lang/String;
      //   58: iload_1
      //   59: invokestatic 78	com/google/android/gms/stats/WakeLock:zza	(Lcom/google/android/gms/stats/WakeLock;Ljava/lang/String;I)V
      //   62: ldc 69
      //   64: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   67: goto -48 -> 19
      //   70: astore_2
      //   71: aload_0
      //   72: monitorexit
      //   73: aload_2
      //   74: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	HeldLock
      //   0	75	1	paramInt	int
      //   70	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	70	finally
      //   22	50	70	finally
      //   50	67	70	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.stats.WakeLock
 * JD-Core Version:    0.7.0.1
 */