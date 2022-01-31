package com.tencent.mm.compatible.loader;

import java.lang.reflect.Field;

public final class c<T>
{
  private String classname;
  private boolean dyX;
  private Field dyY;
  private String fieldName;
  private Object obj;
  
  public c(Object paramObject, String paramString1, String paramString2)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("obj cannot be null");
    }
    this.obj = paramObject;
    this.fieldName = paramString1;
    this.classname = paramString2;
  }
  
  private void prepare()
  {
    if (this.dyX) {
      return;
    }
    this.dyX = true;
    Class localClass = this.obj.getClass();
    while (localClass != null) {
      try
      {
        Field localField1 = localClass.getDeclaredField(this.fieldName);
        localField1.setAccessible(true);
        this.dyY = localField1;
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if ((this.classname != null) && (!this.classname.equals("")))
            {
              Field[] arrayOfField = localClass.getDeclaredFields();
              int j = arrayOfField.length;
              i = 0;
              if (i < j)
              {
                Field localField2 = arrayOfField[i];
                if (!localField2.getType().getName().equals(this.classname)) {
                  continue;
                }
                localField2.setAccessible(true);
                this.dyY = localField2;
              }
            }
          }
          catch (Exception localException2)
          {
            int i;
            continue;
          }
          localClass = localClass.getSuperclass();
          break;
          i += 1;
        }
      }
      finally
      {
        localClass.getSuperclass();
      }
    }
  }
  
  public final T get()
  {
    prepare();
    if (this.dyY == null) {
      throw new NoSuchFieldException();
    }
    try
    {
      Object localObject = this.dyY.get(this.obj);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalArgumentException("unable to cast object");
    }
  }
  
  public final void set(T paramT)
  {
    prepare();
    if (this.dyY == null) {
      throw new NoSuchFieldException();
    }
    this.dyY.set(this.obj, paramT);
  }
  
  public final boolean zy()
  {
    prepare();
    return this.dyY != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.c
 * JD-Core Version:    0.7.0.1
 */