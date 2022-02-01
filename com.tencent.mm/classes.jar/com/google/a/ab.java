package com.google.a;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ab<MessageType extends ab<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
  extends b<MessageType, BuilderType>
{
  private static Map<Object, ab<?, ?>> bVZ = new ConcurrentHashMap();
  protected cd bVX = cd.HR();
  protected int bVY = -1;
  
  static <T extends ab<?, ?>> T F(Class<T> paramClass)
  {
    Object localObject2 = (ab)bVZ.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
      localObject1 = (ab)bVZ.get(paramClass);
      localObject2 = localObject1;
      if (localObject1 != null) {
        return localObject2;
      }
      localObject2 = ((ab)ch.J(paramClass)).Gm();
      if (localObject2 == null) {
        throw new IllegalStateException();
      }
    }
    catch (ClassNotFoundException paramClass)
    {
      throw new IllegalStateException("Class initialization cannot fail.", paramClass);
    }
    bVZ.put(paramClass, localObject2);
    return localObject2;
  }
  
  private MessageType Gm()
  {
    ab.e locale = ab.e.bWm;
    return (ab)Go();
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
  
  public final BuilderType Gn()
  {
    ab.e locale = ab.e.bWl;
    return (a)Go();
  }
  
  protected abstract Object Go();
  
  protected final Object Gp()
  {
    return Go();
  }
  
  final Object Gq()
  {
    ab.e locale = ab.e.bWj;
    return Go();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!Gm().getClass().isInstance(paramObject)) {
      return false;
    }
    return bm.Hl().av(this).equals(this, (ab)paramObject);
  }
  
  public int hashCode()
  {
    if (this.bNb != 0) {
      return this.bNb;
    }
    this.bNb = bm.Hl().av(this).hashCode(this);
    return this.bNb;
  }
  
  public String toString()
  {
    String str = super.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ").append(str);
    ay.a(this, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  public static abstract class a<MessageType extends ab<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
    extends b.a<MessageType, BuilderType>
  {
    private final MessageType bWa;
    protected MessageType bWb;
    protected boolean bWc;
    
    private static void a(MessageType paramMessageType1, MessageType paramMessageType2)
    {
      bm.Hl().av(paramMessageType1).n(paramMessageType1, paramMessageType2);
    }
    
    public final BuilderType a(MessageType paramMessageType)
    {
      if (this.bWc)
      {
        ab localab = this.bWb;
        ab.e locale = ab.e.bWk;
        localab = (ab)localab.Gp();
        a(localab, this.bWb);
        this.bWb = localab;
        this.bWc = false;
      }
      a(this.bWb, paramMessageType);
      return this;
    }
  }
  
  public static abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>>
    extends ab<MessageType, BuilderType>
    implements ab.c<MessageType, BuilderType>
  {
    protected x<ab.d> bWd = x.Gj();
    
    final x<ab.d> Gr()
    {
      if (this.bWd.bUC) {
        this.bWd = this.bWd.Gk();
      }
      return this.bWd;
    }
  }
  
  public static abstract interface c
    extends ax
  {}
  
  static final class d
    implements x.a<d>
  {
    final cj.a bWe;
    final boolean bWf;
    final boolean bWg;
    final int number;
    
    public final cj.b FD()
    {
      return this.bWe.caU;
    }
    
    public final cj.a FE()
    {
      return this.bWe;
    }
    
    public final boolean FJ()
    {
      return this.bWf;
    }
    
    public final boolean FK()
    {
      return this.bWg;
    }
    
    public final aw.a a(aw.a parama, aw paramaw)
    {
      return ((ab.a)parama).a((ab)paramaw);
    }
    
    public final int getNumber()
    {
      return this.number;
    }
  }
  
  protected static final class f
    implements Serializable
  {
    private final Class<?> bUq;
    private final String bWp;
    private final byte[] bWq;
    
    f(aw paramaw)
    {
      this.bUq = paramaw.getClass();
      this.bWp = this.bUq.getName();
      this.bWq = paramaw.toByteArray();
    }
    
    @Deprecated
    private Object Gs()
    {
      try
      {
        Object localObject = Gt().getDeclaredField("defaultInstance");
        ((Field)localObject).setAccessible(true);
        localObject = ((aw)((Field)localObject).get(null)).AO().x(this.bWq).Bo();
        return localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new RuntimeException("Unable to find proto buffer class: " + this.bWp, localClassNotFoundException);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        throw new RuntimeException("Unable to find defaultInstance in " + this.bWp, localNoSuchFieldException);
      }
      catch (SecurityException localSecurityException)
      {
        throw new RuntimeException("Unable to call defaultInstance in " + this.bWp, localSecurityException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call parsePartialFrom", localIllegalAccessException);
      }
      catch (af localaf)
      {
        throw new RuntimeException("Unable to understand proto buffer", localaf);
      }
    }
    
    private Class<?> Gt()
    {
      if (this.bUq != null) {
        return this.bUq;
      }
      return Class.forName(this.bWp);
    }
    
    protected final Object readResolve()
    {
      try
      {
        Object localObject = Gt().getDeclaredField("DEFAULT_INSTANCE");
        ((Field)localObject).setAccessible(true);
        localObject = ((aw)((Field)localObject).get(null)).AO().x(this.bWq).Bo();
        return localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new RuntimeException("Unable to find proto buffer class: " + this.bWp, localClassNotFoundException);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        return Gs();
      }
      catch (SecurityException localSecurityException)
      {
        throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.bWp, localSecurityException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call parsePartialFrom", localIllegalAccessException);
      }
      catch (af localaf)
      {
        throw new RuntimeException("Unable to understand proto buffer", localaf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.ab
 * JD-Core Version:    0.7.0.1
 */