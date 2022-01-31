package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzabm
{
  private static final Logger logger;
  private static final Class<?> zzbqv;
  private static final Unsafe zzbtj;
  private static final boolean zzbun;
  private static final boolean zzbuo;
  private static final zzabm.zzd zzbup;
  private static final boolean zzbuq;
  private static final boolean zzbur;
  private static final long zzbus;
  private static final long zzbut;
  private static final long zzbuu;
  private static final long zzbuv;
  private static final long zzbuw;
  private static final long zzbux;
  private static final long zzbuy;
  private static final long zzbuz;
  private static final long zzbva;
  private static final long zzbvb;
  private static final long zzbvc;
  private static final long zzbvd;
  private static final long zzbve;
  private static final long zzbvf;
  private static final long zzbvg;
  private static final boolean zzbvh;
  
  static
  {
    Object localObject2 = null;
    AppMethodBeat.i(3424);
    logger = Logger.getLogger(zzabm.class.getName());
    zzbtj = zzur();
    zzbqv = zzyv.zzsw();
    zzbun = zzk(Long.TYPE);
    zzbuo = zzk(Integer.TYPE);
    Object localObject1;
    if (zzbtj == null)
    {
      localObject1 = null;
      zzbup = (zzabm.zzd)localObject1;
      zzbuq = zzut();
      zzbur = zzus();
      zzbus = zzi([B.class);
      zzbut = zzi([Z.class);
      zzbuu = zzj([Z.class);
      zzbuv = zzi([I.class);
      zzbuw = zzj([I.class);
      zzbux = zzi([J.class);
      zzbuy = zzj([J.class);
      zzbuz = zzi([F.class);
      zzbva = zzj([F.class);
      zzbvb = zzi([D.class);
      zzbvc = zzj([D.class);
      zzbvd = zzi([Ljava.lang.Object.class);
      zzbve = zzj([Ljava.lang.Object.class);
      zzbvf = zza(zzuu());
      Field localField = zza(String.class, "value");
      localObject1 = localObject2;
      if (localField != null)
      {
        localObject1 = localObject2;
        if (localField.getType() == [C.class) {
          localObject1 = localField;
        }
      }
      zzbvg = zza((Field)localObject1);
      if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
        break label320;
      }
    }
    label320:
    for (boolean bool = true;; bool = false)
    {
      zzbvh = bool;
      AppMethodBeat.o(3424);
      return;
      if (zzyv.zzsv())
      {
        if (zzbun)
        {
          localObject1 = new zzabm.zzb(zzbtj);
          break;
        }
        if (zzbuo)
        {
          localObject1 = new zzabm.zza(zzbtj);
          break;
        }
        localObject1 = null;
        break;
      }
      localObject1 = new zzabm.zzc(zzbtj);
      break;
    }
  }
  
  private static long zza(Field paramField)
  {
    AppMethodBeat.i(3422);
    if ((paramField == null) || (zzbup == null))
    {
      AppMethodBeat.o(3422);
      return -1L;
    }
    long l = zzbup.zzbvi.objectFieldOffset(paramField);
    AppMethodBeat.o(3422);
    return l;
  }
  
  private static Field zza(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(3423);
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      AppMethodBeat.o(3423);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
    }
  }
  
  private static int zzi(Class<?> paramClass)
  {
    AppMethodBeat.i(3415);
    if (zzbur)
    {
      int i = zzbup.zzbvi.arrayBaseOffset(paramClass);
      AppMethodBeat.o(3415);
      return i;
    }
    AppMethodBeat.o(3415);
    return -1;
  }
  
  private static int zzj(Class<?> paramClass)
  {
    AppMethodBeat.i(3416);
    if (zzbur)
    {
      int i = zzbup.zzbvi.arrayIndexScale(paramClass);
      AppMethodBeat.o(3416);
      return i;
    }
    AppMethodBeat.o(3416);
    return -1;
  }
  
  private static boolean zzk(Class<?> paramClass)
  {
    AppMethodBeat.i(3420);
    if (!zzyv.zzsv())
    {
      AppMethodBeat.o(3420);
      return false;
    }
    try
    {
      Class localClass = zzbqv;
      localClass.getMethod("peekLong", new Class[] { paramClass, Boolean.TYPE });
      localClass.getMethod("pokeLong", new Class[] { paramClass, Long.TYPE, Boolean.TYPE });
      localClass.getMethod("pokeInt", new Class[] { paramClass, Integer.TYPE, Boolean.TYPE });
      localClass.getMethod("peekInt", new Class[] { paramClass, Boolean.TYPE });
      localClass.getMethod("pokeByte", new Class[] { paramClass, Byte.TYPE });
      localClass.getMethod("peekByte", new Class[] { paramClass });
      localClass.getMethod("pokeByteArray", new Class[] { paramClass, [B.class, Integer.TYPE, Integer.TYPE });
      localClass.getMethod("peekByteArray", new Class[] { paramClass, [B.class, Integer.TYPE, Integer.TYPE });
      AppMethodBeat.o(3420);
      return true;
    }
    catch (Throwable paramClass)
    {
      AppMethodBeat.o(3420);
    }
    return false;
  }
  
  static Unsafe zzur()
  {
    AppMethodBeat.i(3417);
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new zzabn());
      AppMethodBeat.o(3417);
      return localUnsafe;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private static boolean zzus()
  {
    AppMethodBeat.i(3418);
    if (zzbtj == null)
    {
      AppMethodBeat.o(3418);
      return false;
    }
    try
    {
      localObject = zzbtj.getClass();
      ((Class)localObject).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject).getMethod("arrayBaseOffset", new Class[] { Class.class });
      ((Class)localObject).getMethod("arrayIndexScale", new Class[] { Class.class });
      ((Class)localObject).getMethod("getInt", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putInt", new Class[] { Object.class, Long.TYPE, Integer.TYPE });
      ((Class)localObject).getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putLong", new Class[] { Object.class, Long.TYPE, Long.TYPE });
      ((Class)localObject).getMethod("getObject", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putObject", new Class[] { Object.class, Long.TYPE, Object.class });
      boolean bool = zzyv.zzsv();
      if (bool)
      {
        AppMethodBeat.o(3418);
        return true;
      }
      ((Class)localObject).getMethod("getByte", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putByte", new Class[] { Object.class, Long.TYPE, Byte.TYPE });
      ((Class)localObject).getMethod("getBoolean", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE });
      ((Class)localObject).getMethod("getFloat", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putFloat", new Class[] { Object.class, Long.TYPE, Float.TYPE });
      ((Class)localObject).getMethod("getDouble", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putDouble", new Class[] { Object.class, Long.TYPE, Double.TYPE });
      AppMethodBeat.o(3418);
      return true;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = logger;
      Level localLevel = Level.WARNING;
      String str = String.valueOf(localThrowable);
      ((Logger)localObject).logp(localLevel, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", String.valueOf(str).length() + 71 + "platform method missing - proto runtime falling back to safer methods: " + str);
      AppMethodBeat.o(3418);
    }
    return false;
  }
  
  private static boolean zzut()
  {
    AppMethodBeat.i(3419);
    if (zzbtj == null)
    {
      AppMethodBeat.o(3419);
      return false;
    }
    try
    {
      localObject1 = zzbtj.getClass();
      ((Class)localObject1).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject1).getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      localObject2 = zzuu();
      if (localObject2 == null)
      {
        AppMethodBeat.o(3419);
        return false;
      }
      boolean bool = zzyv.zzsv();
      if (bool)
      {
        AppMethodBeat.o(3419);
        return true;
      }
      ((Class)localObject1).getMethod("getByte", new Class[] { Long.TYPE });
      ((Class)localObject1).getMethod("putByte", new Class[] { Long.TYPE, Byte.TYPE });
      ((Class)localObject1).getMethod("getInt", new Class[] { Long.TYPE });
      ((Class)localObject1).getMethod("putInt", new Class[] { Long.TYPE, Integer.TYPE });
      ((Class)localObject1).getMethod("getLong", new Class[] { Long.TYPE });
      ((Class)localObject1).getMethod("putLong", new Class[] { Long.TYPE, Long.TYPE });
      ((Class)localObject1).getMethod("copyMemory", new Class[] { Long.TYPE, Long.TYPE, Long.TYPE });
      ((Class)localObject1).getMethod("copyMemory", new Class[] { Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE });
      AppMethodBeat.o(3419);
      return true;
    }
    catch (Throwable localThrowable)
    {
      Object localObject1 = logger;
      Object localObject2 = Level.WARNING;
      String str = String.valueOf(localThrowable);
      ((Logger)localObject1).logp((Level)localObject2, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", String.valueOf(str).length() + 71 + "platform method missing - proto runtime falling back to safer methods: " + str);
      AppMethodBeat.o(3419);
    }
    return false;
  }
  
  private static Field zzuu()
  {
    AppMethodBeat.i(3421);
    if (zzyv.zzsv())
    {
      localField = zza(Buffer.class, "effectiveDirectAddress");
      if (localField != null)
      {
        AppMethodBeat.o(3421);
        return localField;
      }
    }
    Field localField = zza(Buffer.class, "address");
    if ((localField != null) && (localField.getType() == Long.TYPE))
    {
      AppMethodBeat.o(3421);
      return localField;
    }
    AppMethodBeat.o(3421);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabm
 * JD-Core Version:    0.7.0.1
 */