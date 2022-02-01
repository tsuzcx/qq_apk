package com.google.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class be<MessageType extends be<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>>
  extends b<MessageType, BuilderType>
{
  private static Map<Object, be<?, ?>> dRK = new ConcurrentHashMap();
  protected do dRI = do.ajM();
  protected int dRJ = -1;
  
  static <T extends be<?, ?>> T M(Class<T> paramClass)
  {
    Object localObject2 = (be)dRK.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
      localObject1 = (be)dRK.get(paramClass);
      localObject2 = localObject1;
      if (localObject1 != null) {
        return localObject2;
      }
      localObject2 = ((be)ds.Q(paramClass)).ahW();
      if (localObject2 == null) {
        throw new IllegalStateException();
      }
    }
    catch (ClassNotFoundException paramClass)
    {
      throw new IllegalStateException("Class initialization cannot fail.", paramClass);
    }
    dRK.put(paramClass, localObject2);
    return localObject2;
  }
  
  private MessageType ahW()
  {
    be.c localc = be.c.dRR;
    return (be)ahX();
  }
  
  static Object invokeOrDie(Method paramMethod, Object paramObject, Object... paramVarArgs)
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
  
  protected abstract Object ahX();
  
  protected final Object ahY()
  {
    return ahX();
  }
  
  final Object ahZ()
  {
    be.c localc = be.c.dRO;
    return ahX();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!ahW().getClass().isInstance(paramObject)) {
      return false;
    }
    return cv.aja().bK(this).equals(this, (be)paramObject);
  }
  
  public int hashCode()
  {
    if (this.memoizedHashCode != 0) {
      return this.memoizedHashCode;
    }
    this.memoizedHashCode = cv.aja().bK(this).hashCode(this);
    return this.memoizedHashCode;
  }
  
  public String toString()
  {
    String str = super.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ").append(str);
    cg.a(this, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  public static abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>>
    extends be<MessageType, BuilderType>
    implements bf<MessageType, BuilderType>
  {
    protected az<Object> dRL = az.ahR();
    
    final az<Object> aia()
    {
      if (this.dRL.bRu) {
        this.dRL = this.dRL.ahS();
      }
      return this.dRL;
    }
  }
  
  public static final class b<ContainingType extends ce, Type>
    extends aq<ContainingType, Type>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.be
 * JD-Core Version:    0.7.0.1
 */