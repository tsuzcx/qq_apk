package com.google.b;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class df
{
  private static final Unsafe UNSAFE;
  private static final boolean bPx;
  private static final b cbH;
  private static final boolean cbI;
  static final long cbJ;
  private static final long cbK;
  private static final long cbL;
  private static final long cbM;
  private static final long cbN;
  private static final long cbO;
  private static final long cbP;
  private static final long cbQ;
  private static final long cbR;
  private static final long cbS;
  private static final long cbT;
  private static final long cbU;
  private static final long cbV;
  private static final long cbW;
  private static final int cbX;
  static final boolean cbY;
  private static final Logger logger = Logger.getLogger(df.class.getName());
  
  static
  {
    Object localObject = Ju();
    UNSAFE = (Unsafe)localObject;
    long l;
    if (localObject == null)
    {
      localObject = null;
      cbH = (b)localObject;
      cbI = Jw();
      bPx = Jv();
      cbJ = I([B.class);
      cbK = I([Z.class);
      cbL = J([Z.class);
      cbM = I([I.class);
      cbN = J([I.class);
      cbO = I([J.class);
      cbP = J([J.class);
      cbQ = I([F.class);
      cbR = J([F.class);
      cbS = I([D.class);
      cbT = J([D.class);
      cbU = I([Ljava.lang.Object.class);
      cbV = J([Ljava.lang.Object.class);
      localObject = Jx();
      if ((localObject != null) && (cbH != null)) {
        break label221;
      }
      l = -1L;
      label176:
      cbW = l;
      cbX = (int)(cbJ & 0x7);
      if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
        break label232;
      }
    }
    label221:
    label232:
    for (boolean bool = true;; bool = false)
    {
      cbY = bool;
      return;
      localObject = new a(UNSAFE);
      break;
      l = cbH.c((Field)localObject);
      break label176;
    }
  }
  
  static <T> T H(Class<T> paramClass)
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
  
  private static int I(Class<?> paramClass)
  {
    if (bPx) {
      return cbH.cbZ.arrayBaseOffset(paramClass);
    }
    return -1;
  }
  
  private static int J(Class<?> paramClass)
  {
    if (bPx) {
      return cbH.cbZ.arrayIndexScale(paramClass);
    }
    return -1;
  }
  
  static boolean Js()
  {
    return bPx;
  }
  
  static boolean Jt()
  {
    return cbI;
  }
  
  static Unsafe Ju()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new df.1());
      return localUnsafe;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private static boolean Jv()
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
  
  private static boolean Jw()
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
        if (Jx() != null)
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
  
  private static Field Jx()
  {
    Field localField = a(Buffer.class, "address");
    if ((localField != null) && (localField.getType() == Long.TYPE)) {
      return localField;
    }
    return null;
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
  
  static void a(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    cbH.a(paramArrayOfByte, cbJ + paramLong, paramByte);
  }
  
  static int c(Object paramObject, long paramLong)
  {
    return cbH.cbZ.getInt(paramObject, paramLong);
  }
  
  static long c(Field paramField)
  {
    return cbH.c(paramField);
  }
  
  static byte d(byte[] paramArrayOfByte, long paramLong)
  {
    return cbH.i(paramArrayOfByte, cbJ + paramLong);
  }
  
  static long d(Object paramObject, long paramLong)
  {
    return cbH.cbZ.getLong(paramObject, paramLong);
  }
  
  static Object d(Field paramField)
  {
    return cbH.d(paramField);
  }
  
  static boolean e(Object paramObject, long paramLong)
  {
    return cbH.e(paramObject, paramLong);
  }
  
  static float f(Object paramObject, long paramLong)
  {
    return cbH.f(paramObject, paramLong);
  }
  
  static double g(Object paramObject, long paramLong)
  {
    return cbH.g(paramObject, paramLong);
  }
  
  static Object h(Object paramObject, long paramLong)
  {
    return cbH.h(paramObject, paramLong);
  }
  
  static final class a
    extends df.b
  {
    a(Unsafe paramUnsafe)
    {
      super();
    }
    
    public final void a(Object paramObject, long paramLong, byte paramByte)
    {
      this.cbZ.putByte(paramObject, paramLong, paramByte);
    }
    
    public final Object d(Field paramField)
    {
      return h(this.cbZ.staticFieldBase(paramField), this.cbZ.staticFieldOffset(paramField));
    }
    
    public final boolean e(Object paramObject, long paramLong)
    {
      return this.cbZ.getBoolean(paramObject, paramLong);
    }
    
    public final float f(Object paramObject, long paramLong)
    {
      return this.cbZ.getFloat(paramObject, paramLong);
    }
    
    public final double g(Object paramObject, long paramLong)
    {
      return this.cbZ.getDouble(paramObject, paramLong);
    }
    
    public final byte i(Object paramObject, long paramLong)
    {
      return this.cbZ.getByte(paramObject, paramLong);
    }
  }
  
  static abstract class b
  {
    Unsafe cbZ;
    
    b(Unsafe paramUnsafe)
    {
      this.cbZ = paramUnsafe;
    }
    
    public abstract void a(Object paramObject, long paramLong, byte paramByte);
    
    public final long c(Field paramField)
    {
      return this.cbZ.objectFieldOffset(paramField);
    }
    
    public abstract Object d(Field paramField);
    
    public abstract boolean e(Object paramObject, long paramLong);
    
    public abstract float f(Object paramObject, long paramLong);
    
    public abstract double g(Object paramObject, long paramLong);
    
    public final Object h(Object paramObject, long paramLong)
    {
      return this.cbZ.getObject(paramObject, paramLong);
    }
    
    public abstract byte i(Object paramObject, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.df
 * JD-Core Version:    0.7.0.1
 */