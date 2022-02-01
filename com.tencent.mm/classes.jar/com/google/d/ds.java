package com.google.d;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class ds
{
  private static final Unsafe UNSAFE;
  private static final boolean dJm;
  private static final b dWi;
  private static final boolean dWj;
  static final long dWk;
  private static final long dWl;
  private static final long dWm;
  private static final long dWn;
  private static final long dWo;
  private static final long dWp;
  private static final long dWq;
  private static final long dWr;
  private static final long dWs;
  private static final long dWt;
  private static final long dWu;
  private static final long dWv;
  private static final long dWw;
  private static final long dWx;
  private static final int dWy;
  static final boolean dWz;
  private static final Logger logger = Logger.getLogger(ds.class.getName());
  
  static
  {
    Object localObject = ajQ();
    UNSAFE = (Unsafe)localObject;
    long l;
    if (localObject == null)
    {
      localObject = null;
      dWi = (b)localObject;
      dWj = ajS();
      dJm = ajR();
      dWk = R([B.class);
      dWl = R([Z.class);
      dWm = S([Z.class);
      dWn = R([I.class);
      dWo = S([I.class);
      dWp = R([J.class);
      dWq = S([J.class);
      dWr = R([F.class);
      dWs = S([F.class);
      dWt = R([D.class);
      dWu = S([D.class);
      dWv = R([Ljava.lang.Object.class);
      dWw = S([Ljava.lang.Object.class);
      localObject = ajT();
      if ((localObject != null) && (dWi != null)) {
        break label221;
      }
      l = -1L;
      label176:
      dWx = l;
      dWy = (int)(dWk & 0x7);
      if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
        break label232;
      }
    }
    label221:
    label232:
    for (boolean bool = true;; bool = false)
    {
      dWz = bool;
      return;
      localObject = new a(UNSAFE);
      break;
      l = dWi.d((Field)localObject);
      break label176;
    }
  }
  
  static <T> T Q(Class<T> paramClass)
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
  
  private static int R(Class<?> paramClass)
  {
    if (dJm) {
      return dWi.dWA.arrayBaseOffset(paramClass);
    }
    return -1;
  }
  
  private static int S(Class<?> paramClass)
  {
    if (dJm) {
      return dWi.dWA.arrayIndexScale(paramClass);
    }
    return -1;
  }
  
  private static Field a(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      return paramClass;
    }
    finally {}
    return null;
  }
  
  static void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    dWi.a(paramLong1, paramArrayOfByte, paramLong2);
  }
  
  static void a(Object paramObject, long paramLong, double paramDouble)
  {
    dWi.a(paramObject, paramLong, paramDouble);
  }
  
  static void a(Object paramObject, long paramLong, float paramFloat)
  {
    dWi.a(paramObject, paramLong, paramFloat);
  }
  
  static void a(Object paramObject, long paramLong, int paramInt)
  {
    dWi.dWA.putInt(paramObject, paramLong, paramInt);
  }
  
  static void a(Object paramObject, long paramLong1, long paramLong2)
  {
    dWi.dWA.putLong(paramObject, paramLong1, paramLong2);
  }
  
  static void a(Object paramObject1, long paramLong, Object paramObject2)
  {
    dWi.dWA.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static void a(Object paramObject, long paramLong, boolean paramBoolean)
  {
    dWi.a(paramObject, paramLong, paramBoolean);
  }
  
  static void a(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    dWi.a(paramArrayOfByte, dWk + paramLong, paramByte);
  }
  
  static boolean ajO()
  {
    return dJm;
  }
  
  static boolean ajP()
  {
    return dWj;
  }
  
  static Unsafe ajQ()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new ds.1());
      return localUnsafe;
    }
    finally {}
    return null;
  }
  
  private static boolean ajR()
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
    finally
    {
      logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: ".concat(String.valueOf(localObject)));
    }
    return false;
  }
  
  private static boolean ajS()
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
        if (ajT() != null)
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
      finally
      {
        logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: ".concat(String.valueOf(localObject)));
      }
    }
    return false;
  }
  
  private static Field ajT()
  {
    Field localField = a(Buffer.class, "address");
    if ((localField != null) && (localField.getType() == Long.TYPE)) {
      return localField;
    }
    return null;
  }
  
  static byte d(byte[] paramArrayOfByte, long paramLong)
  {
    return dWi.p(paramArrayOfByte, dWk + paramLong);
  }
  
  static long d(Field paramField)
  {
    return dWi.d(paramField);
  }
  
  static byte de(long paramLong)
  {
    return dWi.de(paramLong);
  }
  
  static long df(long paramLong)
  {
    return dWi.df(paramLong);
  }
  
  static Object e(Field paramField)
  {
    return dWi.e(paramField);
  }
  
  static int j(Object paramObject, long paramLong)
  {
    return dWi.dWA.getInt(paramObject, paramLong);
  }
  
  static long j(ByteBuffer paramByteBuffer)
  {
    return dWi.k(paramByteBuffer, dWx);
  }
  
  static long k(Object paramObject, long paramLong)
  {
    return dWi.k(paramObject, paramLong);
  }
  
  static boolean l(Object paramObject, long paramLong)
  {
    return dWi.l(paramObject, paramLong);
  }
  
  static float m(Object paramObject, long paramLong)
  {
    return dWi.m(paramObject, paramLong);
  }
  
  static double n(Object paramObject, long paramLong)
  {
    return dWi.n(paramObject, paramLong);
  }
  
  static Object o(Object paramObject, long paramLong)
  {
    return dWi.o(paramObject, paramLong);
  }
  
  static final class a
    extends ds.b
  {
    a(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
    {
      this.dWA.copyMemory(null, paramLong1, paramArrayOfByte, 0L + ds.dWk, paramLong2);
    }
    
    public final void a(Object paramObject, long paramLong, byte paramByte)
    {
      this.dWA.putByte(paramObject, paramLong, paramByte);
    }
    
    public final void a(Object paramObject, long paramLong, double paramDouble)
    {
      this.dWA.putDouble(paramObject, paramLong, paramDouble);
    }
    
    public final void a(Object paramObject, long paramLong, float paramFloat)
    {
      this.dWA.putFloat(paramObject, paramLong, paramFloat);
    }
    
    public final void a(Object paramObject, long paramLong, boolean paramBoolean)
    {
      this.dWA.putBoolean(paramObject, paramLong, paramBoolean);
    }
    
    public final byte de(long paramLong)
    {
      return this.dWA.getByte(paramLong);
    }
    
    public final long df(long paramLong)
    {
      return this.dWA.getLong(paramLong);
    }
    
    public final Object e(Field paramField)
    {
      return o(this.dWA.staticFieldBase(paramField), this.dWA.staticFieldOffset(paramField));
    }
    
    public final boolean l(Object paramObject, long paramLong)
    {
      return this.dWA.getBoolean(paramObject, paramLong);
    }
    
    public final float m(Object paramObject, long paramLong)
    {
      return this.dWA.getFloat(paramObject, paramLong);
    }
    
    public final double n(Object paramObject, long paramLong)
    {
      return this.dWA.getDouble(paramObject, paramLong);
    }
    
    public final byte p(Object paramObject, long paramLong)
    {
      return this.dWA.getByte(paramObject, paramLong);
    }
  }
  
  static abstract class b
  {
    Unsafe dWA;
    
    b(Unsafe paramUnsafe)
    {
      this.dWA = paramUnsafe;
    }
    
    public abstract void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
    
    public abstract void a(Object paramObject, long paramLong, byte paramByte);
    
    public abstract void a(Object paramObject, long paramLong, double paramDouble);
    
    public abstract void a(Object paramObject, long paramLong, float paramFloat);
    
    public abstract void a(Object paramObject, long paramLong, boolean paramBoolean);
    
    public final long d(Field paramField)
    {
      return this.dWA.objectFieldOffset(paramField);
    }
    
    public abstract byte de(long paramLong);
    
    public abstract long df(long paramLong);
    
    public abstract Object e(Field paramField);
    
    public final long k(Object paramObject, long paramLong)
    {
      return this.dWA.getLong(paramObject, paramLong);
    }
    
    public abstract boolean l(Object paramObject, long paramLong);
    
    public abstract float m(Object paramObject, long paramLong);
    
    public abstract double n(Object paramObject, long paramLong);
    
    public final Object o(Object paramObject, long paramLong)
    {
      return this.dWA.getObject(paramObject, paramLong);
    }
    
    public abstract byte p(Object paramObject, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.ds
 * JD-Core Version:    0.7.0.1
 */