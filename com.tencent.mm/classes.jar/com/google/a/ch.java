package com.google.a;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class ch
{
  private static final Unsafe UNSAFE;
  private static final boolean bNy;
  private static final b cae;
  private static final boolean caf;
  static final long cag;
  private static final long cah;
  private static final long cai;
  private static final long caj;
  private static final long cak;
  private static final long cal;
  private static final long cam;
  private static final long can;
  private static final long cao;
  private static final long cap;
  private static final long caq;
  private static final long car;
  private static final long cas;
  private static final long cat;
  private static final int cau;
  static final boolean cav;
  private static final Logger logger = Logger.getLogger(ch.class.getName());
  
  static
  {
    Object localObject = HU();
    UNSAFE = (Unsafe)localObject;
    long l;
    if (localObject == null)
    {
      localObject = null;
      cae = (b)localObject;
      caf = HW();
      bNy = HV();
      cag = K([B.class);
      cah = K([Z.class);
      cai = L([Z.class);
      caj = K([I.class);
      cak = L([I.class);
      cal = K([J.class);
      cam = L([J.class);
      can = K([F.class);
      cao = L([F.class);
      cap = K([D.class);
      caq = L([D.class);
      car = K([Ljava.lang.Object.class);
      cas = L([Ljava.lang.Object.class);
      localObject = HX();
      if ((localObject != null) && (cae != null)) {
        break label221;
      }
      l = -1L;
      label176:
      cat = l;
      cau = (int)(cag & 0x7);
      if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
        break label232;
      }
    }
    label221:
    label232:
    for (boolean bool = true;; bool = false)
    {
      cav = bool;
      return;
      localObject = new a(UNSAFE);
      break;
      l = cae.a((Field)localObject);
      break label176;
    }
  }
  
  static boolean HS()
  {
    return bNy;
  }
  
  static boolean HT()
  {
    return caf;
  }
  
  static Unsafe HU()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new PrivilegedExceptionAction() {});
      return localUnsafe;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private static boolean HV()
  {
    if (UNSAFE == null) {
      return false;
    }
    try
    {
      Class localClass = UNSAFE.getClass();
      localClass.getMethod("objectFieldOffset", new Class[] { Field.class });
      localClass.getMethod("arrayBaseOffset", new Class[] { Class.class });
      localClass.getMethod("arrayIndexScale", new Class[] { Class.class });
      localClass.getMethod("getInt", new Class[] { Object.class, Long.TYPE });
      localClass.getMethod("putInt", new Class[] { Object.class, Long.TYPE, Integer.TYPE });
      localClass.getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      localClass.getMethod("putLong", new Class[] { Object.class, Long.TYPE, Long.TYPE });
      localClass.getMethod("getObject", new Class[] { Object.class, Long.TYPE });
      localClass.getMethod("putObject", new Class[] { Object.class, Long.TYPE, Object.class });
      localClass.getMethod("getByte", new Class[] { Object.class, Long.TYPE });
      localClass.getMethod("putByte", new Class[] { Object.class, Long.TYPE, Byte.TYPE });
      localClass.getMethod("getBoolean", new Class[] { Object.class, Long.TYPE });
      localClass.getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE });
      localClass.getMethod("getFloat", new Class[] { Object.class, Long.TYPE });
      localClass.getMethod("putFloat", new Class[] { Object.class, Long.TYPE, Float.TYPE });
      localClass.getMethod("getDouble", new Class[] { Object.class, Long.TYPE });
      localClass.getMethod("putDouble", new Class[] { Object.class, Long.TYPE, Double.TYPE });
      return true;
    }
    catch (Throwable localThrowable)
    {
      logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: ".concat(String.valueOf(localThrowable)));
    }
    return false;
  }
  
  private static boolean HW()
  {
    if (UNSAFE == null) {}
    for (;;)
    {
      return false;
      try
      {
        Class localClass = UNSAFE.getClass();
        localClass.getMethod("objectFieldOffset", new Class[] { Field.class });
        localClass.getMethod("getLong", new Class[] { Object.class, Long.TYPE });
        if (HX() != null)
        {
          localClass.getMethod("getByte", new Class[] { Long.TYPE });
          localClass.getMethod("putByte", new Class[] { Long.TYPE, Byte.TYPE });
          localClass.getMethod("getInt", new Class[] { Long.TYPE });
          localClass.getMethod("putInt", new Class[] { Long.TYPE, Integer.TYPE });
          localClass.getMethod("getLong", new Class[] { Long.TYPE });
          localClass.getMethod("putLong", new Class[] { Long.TYPE, Long.TYPE });
          localClass.getMethod("copyMemory", new Class[] { Long.TYPE, Long.TYPE, Long.TYPE });
          localClass.getMethod("copyMemory", new Class[] { Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE });
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: ".concat(String.valueOf(localThrowable)));
      }
    }
    return false;
  }
  
  private static Field HX()
  {
    Field localField = a(Buffer.class, "address");
    if ((localField != null) && (localField.getType() == Long.TYPE)) {
      return localField;
    }
    return null;
  }
  
  static <T> T J(Class<T> paramClass)
  {
    try
    {
      paramClass = UNSAFE.allocateInstance(paramClass);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalStateException(paramClass);
    }
  }
  
  private static int K(Class<?> paramClass)
  {
    if (bNy) {
      return cae.caw.arrayBaseOffset(paramClass);
    }
    return -1;
  }
  
  private static int L(Class<?> paramClass)
  {
    if (bNy) {
      return cae.caw.arrayIndexScale(paramClass);
    }
    return -1;
  }
  
  static long a(Field paramField)
  {
    return cae.a(paramField);
  }
  
  private static Field a(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      return paramClass;
    }
    catch (Throwable paramClass) {}
    return null;
  }
  
  static void a(Object paramObject, long paramLong, double paramDouble)
  {
    cae.a(paramObject, paramLong, paramDouble);
  }
  
  static void a(Object paramObject, long paramLong, float paramFloat)
  {
    cae.a(paramObject, paramLong, paramFloat);
  }
  
  static void a(Object paramObject, long paramLong, int paramInt)
  {
    cae.caw.putInt(paramObject, paramLong, paramInt);
  }
  
  static void a(Object paramObject, long paramLong1, long paramLong2)
  {
    cae.caw.putLong(paramObject, paramLong1, paramLong2);
  }
  
  static void a(Object paramObject1, long paramLong, Object paramObject2)
  {
    cae.caw.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static void a(Object paramObject, long paramLong, boolean paramBoolean)
  {
    cae.a(paramObject, paramLong, paramBoolean);
  }
  
  static void a(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    cae.a(paramArrayOfByte, cag + paramLong, paramByte);
  }
  
  static Object b(Field paramField)
  {
    return cae.b(paramField);
  }
  
  static byte c(byte[] paramArrayOfByte, long paramLong)
  {
    return cae.l(paramArrayOfByte, cag + paramLong);
  }
  
  static int f(Object paramObject, long paramLong)
  {
    return cae.caw.getInt(paramObject, paramLong);
  }
  
  static long g(Object paramObject, long paramLong)
  {
    return cae.caw.getLong(paramObject, paramLong);
  }
  
  static boolean h(Object paramObject, long paramLong)
  {
    return cae.h(paramObject, paramLong);
  }
  
  static float i(Object paramObject, long paramLong)
  {
    return cae.i(paramObject, paramLong);
  }
  
  static double j(Object paramObject, long paramLong)
  {
    return cae.j(paramObject, paramLong);
  }
  
  static Object k(Object paramObject, long paramLong)
  {
    return cae.k(paramObject, paramLong);
  }
  
  static final class a
    extends ch.b
  {
    a(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void a(Object paramObject, long paramLong, byte paramByte)
    {
      this.caw.putByte(paramObject, paramLong, paramByte);
    }
    
    public final void a(Object paramObject, long paramLong, double paramDouble)
    {
      this.caw.putDouble(paramObject, paramLong, paramDouble);
    }
    
    public final void a(Object paramObject, long paramLong, float paramFloat)
    {
      this.caw.putFloat(paramObject, paramLong, paramFloat);
    }
    
    public final void a(Object paramObject, long paramLong, boolean paramBoolean)
    {
      this.caw.putBoolean(paramObject, paramLong, paramBoolean);
    }
    
    public final Object b(Field paramField)
    {
      return k(this.caw.staticFieldBase(paramField), this.caw.staticFieldOffset(paramField));
    }
    
    public final boolean h(Object paramObject, long paramLong)
    {
      return this.caw.getBoolean(paramObject, paramLong);
    }
    
    public final float i(Object paramObject, long paramLong)
    {
      return this.caw.getFloat(paramObject, paramLong);
    }
    
    public final double j(Object paramObject, long paramLong)
    {
      return this.caw.getDouble(paramObject, paramLong);
    }
    
    public final byte l(Object paramObject, long paramLong)
    {
      return this.caw.getByte(paramObject, paramLong);
    }
  }
  
  static abstract class b
  {
    Unsafe caw;
    
    b(Unsafe paramUnsafe)
    {
      this.caw = paramUnsafe;
    }
    
    public final long a(Field paramField)
    {
      return this.caw.objectFieldOffset(paramField);
    }
    
    public abstract void a(Object paramObject, long paramLong, byte paramByte);
    
    public abstract void a(Object paramObject, long paramLong, double paramDouble);
    
    public abstract void a(Object paramObject, long paramLong, float paramFloat);
    
    public abstract void a(Object paramObject, long paramLong, boolean paramBoolean);
    
    public abstract Object b(Field paramField);
    
    public abstract boolean h(Object paramObject, long paramLong);
    
    public abstract float i(Object paramObject, long paramLong);
    
    public abstract double j(Object paramObject, long paramLong);
    
    public final Object k(Object paramObject, long paramLong)
    {
      return this.caw.getObject(paramObject, paramLong);
    }
    
    public abstract byte l(Object paramObject, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.ch
 * JD-Core Version:    0.7.0.1
 */