package com.tencent.e.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class a<Type>
{
  private Class<?> cNV;
  private String cNW;
  private Field mField;
  private boolean mInit;
  
  public a(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(183484);
    if ((paramClass == null) || (paramString == null) || (paramString.length() == 0))
    {
      paramClass = new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
      AppMethodBeat.o(183484);
      throw paramClass;
    }
    this.cNV = paramClass;
    this.cNW = paramString;
    AppMethodBeat.o(183484);
  }
  
  private boolean P(Object paramObject, Type paramType)
  {
    try
    {
      AppMethodBeat.i(183489);
      prepare();
      if (this.mField == null)
      {
        paramObject = new NoSuchFieldException("Method " + this.cNW + " is not exists.");
        AppMethodBeat.o(183489);
        throw paramObject;
      }
    }
    finally {}
    this.mField.set(paramObject, paramType);
    AppMethodBeat.o(183489);
    return true;
  }
  
  private Type ahG()
  {
    try
    {
      AppMethodBeat.i(183487);
      prepare();
      if (this.mField == null)
      {
        NoSuchFieldException localNoSuchFieldException = new NoSuchFieldException();
        AppMethodBeat.o(183487);
        throw localNoSuchFieldException;
      }
    }
    finally {}
    try
    {
      Object localObject2 = this.mField.get(null);
      AppMethodBeat.o(183487);
      return localObject2;
    }
    catch (ClassCastException localClassCastException)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("unable to cast object");
      AppMethodBeat.o(183487);
      throw localIllegalArgumentException;
    }
  }
  
  private void prepare()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(183485);
        if (this.mInit)
        {
          AppMethodBeat.o(183485);
          return;
        }
        localClass1 = this.cNV;
        if (localClass1 == null) {}
      }
      finally
      {
        try
        {
          Class localClass1;
          Field localField = localClass1.getDeclaredField(this.cNW);
          localField.setAccessible(true);
          this.mField = localField;
          this.mInit = true;
          AppMethodBeat.o(183485);
        }
        catch (Exception localException)
        {
          Class localClass2 = localObject.getSuperclass();
        }
        localObject = finally;
      }
    }
  }
  
  public final boolean ex(Object paramObject)
  {
    try
    {
      AppMethodBeat.i(183488);
      boolean bool = P(paramObject, null);
      AppMethodBeat.o(183488);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public final boolean ey(Type paramType)
  {
    try
    {
      AppMethodBeat.i(183490);
      boolean bool = P(null, paramType);
      AppMethodBeat.o(183490);
      return bool;
    }
    finally
    {
      paramType = finally;
      throw paramType;
    }
  }
  
  public final Type get()
  {
    try
    {
      AppMethodBeat.i(183486);
      Object localObject1 = ahG();
      AppMethodBeat.o(183486);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.k.a
 * JD-Core Version:    0.7.0.1
 */