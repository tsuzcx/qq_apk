package com.tencent.e.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class b
{
  private Class<?> dji;
  private String hi;
  private boolean mInit;
  private Method mMethod;
  private Class[] mParameterTypes;
  
  public b(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(183491);
    if (paramString.length() == 0)
    {
      paramClass = new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
      AppMethodBeat.o(183491);
      throw paramClass;
    }
    this.dji = paramClass;
    this.hi = paramString;
    this.mParameterTypes = paramVarArgs;
    AppMethodBeat.o(183491);
  }
  
  private <T> T b(Object paramObject, Object... paramVarArgs)
  {
    try
    {
      AppMethodBeat.i(183494);
      prepare();
      if (this.mMethod == null)
      {
        paramObject = new NoSuchFieldException("Method " + this.hi + " is not exists.");
        AppMethodBeat.o(183494);
        throw paramObject;
      }
    }
    finally {}
    paramObject = this.mMethod.invoke(paramObject, paramVarArgs);
    AppMethodBeat.o(183494);
    return paramObject;
  }
  
  private void prepare()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(183492);
        if (this.mInit)
        {
          AppMethodBeat.o(183492);
          return;
        }
        localClass1 = this.dji;
        if (localClass1 == null) {}
      }
      finally
      {
        try
        {
          Class localClass1;
          Method localMethod = localClass1.getDeclaredMethod(this.hi, this.mParameterTypes);
          localMethod.setAccessible(true);
          this.mMethod = localMethod;
          this.mInit = true;
          AppMethodBeat.o(183492);
        }
        catch (Exception localException)
        {
          Class localClass2 = localObject.getSuperclass();
        }
        localObject = finally;
      }
    }
  }
  
  public final <T> T a(Object paramObject, Object... paramVarArgs)
  {
    try
    {
      AppMethodBeat.i(183493);
      paramObject = b(paramObject, paramVarArgs);
      AppMethodBeat.o(183493);
      return paramObject;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.l.b
 * JD-Core Version:    0.7.0.1
 */