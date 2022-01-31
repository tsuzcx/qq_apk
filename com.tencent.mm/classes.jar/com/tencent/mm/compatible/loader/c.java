package com.tencent.mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class c<T>
{
  private String classname;
  private Field erN;
  private String fieldName;
  private boolean inited;
  private Object obj;
  
  public c(Object paramObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(51926);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("obj cannot be null");
      AppMethodBeat.o(51926);
      throw paramObject;
    }
    this.obj = paramObject;
    this.fieldName = paramString1;
    this.classname = paramString2;
    AppMethodBeat.o(51926);
  }
  
  private void prepare()
  {
    AppMethodBeat.i(51927);
    if (this.inited)
    {
      AppMethodBeat.o(51927);
      return;
    }
    this.inited = true;
    Class localClass = this.obj.getClass();
    while (localClass != null) {
      try
      {
        Field localField1 = localClass.getDeclaredField(this.fieldName);
        localField1.setAccessible(true);
        this.erN = localField1;
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
                this.erN = localField2;
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
        AppMethodBeat.o(51927);
      }
    }
    AppMethodBeat.o(51927);
  }
  
  public final boolean Mb()
  {
    AppMethodBeat.i(51930);
    prepare();
    if (this.erN != null)
    {
      AppMethodBeat.o(51930);
      return true;
    }
    AppMethodBeat.o(51930);
    return false;
  }
  
  public final T get()
  {
    AppMethodBeat.i(51928);
    prepare();
    Object localObject;
    if (this.erN == null)
    {
      localObject = new NoSuchFieldException();
      AppMethodBeat.o(51928);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.erN.get(this.obj);
      AppMethodBeat.o(51928);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("unable to cast object");
      AppMethodBeat.o(51928);
      throw localIllegalArgumentException;
    }
  }
  
  public final void set(T paramT)
  {
    AppMethodBeat.i(51929);
    prepare();
    if (this.erN == null)
    {
      paramT = new NoSuchFieldException();
      AppMethodBeat.o(51929);
      throw paramT;
    }
    this.erN.set(this.obj, paramT);
    AppMethodBeat.o(51929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.c
 * JD-Core Version:    0.7.0.1
 */