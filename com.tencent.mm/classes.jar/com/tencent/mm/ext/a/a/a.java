package com.tencent.mm.ext.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class a<T>
{
  private Field bUo;
  private String classname;
  private String fieldName;
  private boolean gKM;
  private Object obj;
  
  public a(Object paramObject, String paramString)
  {
    AppMethodBeat.i(197814);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("obj cannot be null");
      AppMethodBeat.o(197814);
      throw paramObject;
    }
    this.obj = paramObject;
    this.fieldName = paramString;
    this.classname = null;
    AppMethodBeat.o(197814);
  }
  
  private void prepare()
  {
    AppMethodBeat.i(197815);
    if (this.gKM)
    {
      AppMethodBeat.o(197815);
      return;
    }
    this.gKM = true;
    Class localClass = this.obj.getClass();
    while (localClass != null) {
      try
      {
        Field localField1 = localClass.getDeclaredField(this.fieldName);
        localField1.setAccessible(true);
        this.bUo = localField1;
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
                this.bUo = localField2;
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
        AppMethodBeat.o(197815);
      }
    }
    AppMethodBeat.o(197815);
  }
  
  public final boolean apg()
  {
    AppMethodBeat.i(197817);
    prepare();
    if (this.bUo != null)
    {
      AppMethodBeat.o(197817);
      return true;
    }
    AppMethodBeat.o(197817);
    return false;
  }
  
  public final T get()
  {
    AppMethodBeat.i(197816);
    prepare();
    Object localObject;
    if (this.bUo == null)
    {
      localObject = new NoSuchFieldException();
      AppMethodBeat.o(197816);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.bUo.get(this.obj);
      AppMethodBeat.o(197816);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("unable to cast object");
      AppMethodBeat.o(197816);
      throw localIllegalArgumentException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ext.a.a.a
 * JD-Core Version:    0.7.0.1
 */