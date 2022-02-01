package com.tencent.mm.ext.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class b<T>
{
  private Field dEn;
  private String lYr;
  private boolean lYs;
  private String lYt;
  private Object obj;
  
  public b(Object paramObject, String paramString)
  {
    AppMethodBeat.i(235315);
    if (paramObject == null)
    {
      paramObject = new IllegalArgumentException("obj cannot be null");
      AppMethodBeat.o(235315);
      throw paramObject;
    }
    this.obj = paramObject;
    this.lYr = paramString;
    this.lYt = null;
    AppMethodBeat.o(235315);
  }
  
  private void prepare()
  {
    AppMethodBeat.i(235317);
    if (this.lYs)
    {
      AppMethodBeat.o(235317);
      return;
    }
    this.lYs = true;
    Class localClass = this.obj.getClass();
    while (localClass != null) {
      try
      {
        Field localField1 = localClass.getDeclaredField(this.lYr);
        localField1.setAccessible(true);
        this.dEn = localField1;
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if ((this.lYt != null) && (!this.lYt.equals("")))
            {
              Field[] arrayOfField = localClass.getDeclaredFields();
              int j = arrayOfField.length;
              i = 0;
              if (i < j)
              {
                Field localField2 = arrayOfField[i];
                if (!localField2.getType().getName().equals(this.lYt)) {
                  continue;
                }
                localField2.setAccessible(true);
                this.dEn = localField2;
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
        AppMethodBeat.o(235317);
      }
    }
    AppMethodBeat.o(235317);
  }
  
  public final boolean aPM()
  {
    AppMethodBeat.i(235328);
    prepare();
    if (this.dEn != null)
    {
      AppMethodBeat.o(235328);
      return true;
    }
    AppMethodBeat.o(235328);
    return false;
  }
  
  public final T get()
  {
    AppMethodBeat.i(235324);
    prepare();
    Object localObject;
    if (this.dEn == null)
    {
      localObject = new NoSuchFieldException();
      AppMethodBeat.o(235324);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = this.dEn.get(this.obj);
      AppMethodBeat.o(235324);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("unable to cast object");
      AppMethodBeat.o(235324);
      throw localIllegalArgumentException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ext.a.a.b
 * JD-Core Version:    0.7.0.1
 */