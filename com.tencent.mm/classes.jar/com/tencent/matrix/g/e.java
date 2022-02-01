package com.tencent.matrix.g;

import java.lang.reflect.Field;

public final class e<Type>
{
  private Class<?> cOF;
  private String cOG;
  private Field mField;
  private boolean mInit;
  
  public e(Class<?> paramClass, String paramString)
  {
    if ((paramClass == null) || (paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
    }
    this.cOF = paramClass;
    this.cOG = paramString;
  }
  
  private Type aH(Object paramObject)
  {
    try
    {
      prepare();
      if (this.mField == null) {
        throw new NoSuchFieldException();
      }
    }
    finally {}
    try
    {
      paramObject = this.mField.get(paramObject);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw new IllegalArgumentException("unable to cast object");
    }
  }
  
  private void prepare()
  {
    try
    {
      boolean bool = this.mInit;
      if (!bool) {
        break label14;
      }
    }
    finally
    {
      try
      {
        label14:
        Class localClass1;
        Field localField = localClass1.getDeclaredField(this.cOG);
        localField.setAccessible(true);
        this.mField = localField;
        this.mInit = true;
      }
      catch (Exception localException)
      {
        Class localClass2 = localObject.getSuperclass();
      }
      localObject = finally;
    }
    return;
    localClass1 = this.cOF;
    for (;;)
    {
      if (localClass1 == null) {}
    }
  }
  
  public final Type get(Object paramObject)
  {
    try
    {
      paramObject = aH(paramObject);
      return paramObject;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.g.e
 * JD-Core Version:    0.7.0.1
 */