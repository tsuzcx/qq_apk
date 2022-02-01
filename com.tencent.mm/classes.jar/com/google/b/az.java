package com.google.b;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class az<MessageType extends az<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>>
  extends b<MessageType, BuilderType>
{
  private static Map<Object, az<?, ?>> bXX = new ConcurrentHashMap();
  protected db bXV = db.Jr();
  protected int bXW = -1;
  
  static <T extends az<?, ?>> T D(Class<T> paramClass)
  {
    Object localObject2 = (az)bXX.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
      localObject1 = (az)bXX.get(paramClass);
      localObject2 = localObject1;
      if (localObject1 != null) {
        return localObject2;
      }
      localObject2 = ((az)df.H(paramClass)).HS();
      if (localObject2 == null) {
        throw new IllegalStateException();
      }
    }
    catch (ClassNotFoundException paramClass)
    {
      throw new IllegalStateException("Class initialization cannot fail.", paramClass);
    }
    bXX.put(paramClass, localObject2);
    return localObject2;
  }
  
  private MessageType HS()
  {
    az.b localb = az.b.bYe;
    return (az)HT();
  }
  
  static Object a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if ((paramMethod instanceof RuntimeException)) {
        throw ((RuntimeException)paramMethod);
      }
      if ((paramMethod instanceof Error)) {
        throw ((Error)paramMethod);
      }
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
    }
  }
  
  protected abstract Object HT();
  
  final Object HU()
  {
    az.b localb = az.b.bYb;
    return HT();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!HS().getClass().isInstance(paramObject)) {
      return false;
    }
    return ck.IM().ar(this).equals(this, (az)paramObject);
  }
  
  public int hashCode()
  {
    if (this.bPa != 0) {
      return this.bPa;
    }
    this.bPa = ck.IM().ar(this).hashCode(this);
    return this.bPa;
  }
  
  public String toString()
  {
    String str = super.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ").append(str);
    by.a(this, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  public static abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>>
    extends az<MessageType, BuilderType>
    implements ba<MessageType, BuilderType>
  {
    protected av<Object> bXY = av.HP();
  }
  
  protected static final class c
    implements Serializable
  {
    private final Class<?> bWn;
    private final String bYh;
    private final byte[] bYi;
    
    c(bw parambw)
    {
      this.bWn = parambw.getClass();
      this.bYh = this.bWn.getName();
      this.bYi = parambw.toByteArray();
    }
    
    @Deprecated
    private Object HV()
    {
      try
      {
        Object localObject = HW().getDeclaredField("defaultInstance");
        ((Field)localObject).setAccessible(true);
        localObject = ((bw)((Field)localObject).get(null)).Cr().v(this.bYi).CR();
        return localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new RuntimeException("Unable to find proto buffer class: " + this.bYh, localClassNotFoundException);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        throw new RuntimeException("Unable to find defaultInstance in " + this.bYh, localNoSuchFieldException);
      }
      catch (SecurityException localSecurityException)
      {
        throw new RuntimeException("Unable to call defaultInstance in " + this.bYh, localSecurityException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call parsePartialFrom", localIllegalAccessException);
      }
      catch (bf localbf)
      {
        throw new RuntimeException("Unable to understand proto buffer", localbf);
      }
    }
    
    private Class<?> HW()
    {
      if (this.bWn != null) {
        return this.bWn;
      }
      return Class.forName(this.bYh);
    }
    
    protected final Object readResolve()
    {
      try
      {
        Object localObject = HW().getDeclaredField("DEFAULT_INSTANCE");
        ((Field)localObject).setAccessible(true);
        localObject = ((bw)((Field)localObject).get(null)).Cr().v(this.bYi).CR();
        return localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new RuntimeException("Unable to find proto buffer class: " + this.bYh, localClassNotFoundException);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        return HV();
      }
      catch (SecurityException localSecurityException)
      {
        throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.bYh, localSecurityException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call parsePartialFrom", localIllegalAccessException);
      }
      catch (bf localbf)
      {
        throw new RuntimeException("Unable to understand proto buffer", localbf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.az
 * JD-Core Version:    0.7.0.1
 */