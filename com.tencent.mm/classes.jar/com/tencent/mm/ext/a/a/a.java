package com.tencent.mm.ext.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class a<T>
{
  private Field bKF;
  private String jva;
  private boolean jvb;
  private String jvc;
  private Object obj;
  
  public a(Object paramObject, String paramString)
  {
    AppMethodBeat.i(258871);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("obj cannot be null");
      AppMethodBeat.o(258871);
      throw paramObject;
    }
    this.obj = paramObject;
    this.jva = paramString;
    this.jvc = null;
    AppMethodBeat.o(258871);
  }
  
  private void prepare()
  {
    AppMethodBeat.i(258872);
    if (this.jvb)
    {
      AppMethodBeat.o(258872);
      return;
    }
    this.jvb = true;
    Class localClass = this.obj.getClass();
    while (localClass != null) {
      try
      {
        Field localField1 = localClass.getDeclaredField(this.jva);
        localField1.setAccessible(true);
        this.bKF = localField1;
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if ((this.jvc != null) && (!this.jvc.equals("")))
            {
              Field[] arrayOfField = localClass.getDeclaredFields();
              int j = arrayOfField.length;
              i = 0;
              if (i < j)
              {
                Field localField2 = arrayOfField[i];
                if (!localField2.getType().getName().equals(this.jvc)) {
                  continue;
                }
                localField2.setAccessible(true);
                this.bKF = localField2;
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
        AppMethodBeat.o(258872);
      }
    }
    AppMethodBeat.o(258872);
  }
  
  public final boolean avs()
  {
    AppMethodBeat.i(258875);
    prepare();
    if (this.bKF != null)
    {
      AppMethodBeat.o(258875);
      return true;
    }
    AppMethodBeat.o(258875);
    return false;
  }
  
  public final T get()
  {
    AppMethodBeat.i(258873);
    prepare();
    Object localObject;
    if (this.bKF == null)
    {
      localObject = new NoSuchFieldException();
      AppMethodBeat.o(258873);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.bKF.get(this.obj);
      AppMethodBeat.o(258873);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("unable to cast object");
      AppMethodBeat.o(258873);
      throw localIllegalArgumentException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ext.a.a.a
 * JD-Core Version:    0.7.0.1
 */