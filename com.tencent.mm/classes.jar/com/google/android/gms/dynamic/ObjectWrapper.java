package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class ObjectWrapper<T>
  extends IObjectWrapper.Stub
{
  private final T zzabn;
  
  private ObjectWrapper(T paramT)
  {
    this.zzabn = paramT;
  }
  
  public static <T> T unwrap(IObjectWrapper paramIObjectWrapper)
  {
    AppMethodBeat.i(5418);
    if ((paramIObjectWrapper instanceof ObjectWrapper))
    {
      paramIObjectWrapper = ((ObjectWrapper)paramIObjectWrapper).zzabn;
      AppMethodBeat.o(5418);
      return paramIObjectWrapper;
    }
    IBinder localIBinder = paramIObjectWrapper.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    paramIObjectWrapper = null;
    int k = arrayOfField.length;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      Field localField = arrayOfField[i];
      if (localField.isSynthetic()) {
        break label221;
      }
      j += 1;
      paramIObjectWrapper = localField;
    }
    label221:
    for (;;)
    {
      i += 1;
      break;
      if (j == 1)
      {
        if (!paramIObjectWrapper.isAccessible())
        {
          paramIObjectWrapper.setAccessible(true);
          try
          {
            paramIObjectWrapper = paramIObjectWrapper.get(localIBinder);
            AppMethodBeat.o(5418);
            return paramIObjectWrapper;
          }
          catch (NullPointerException paramIObjectWrapper)
          {
            paramIObjectWrapper = new IllegalArgumentException("Binder object is null.", paramIObjectWrapper);
            AppMethodBeat.o(5418);
            throw paramIObjectWrapper;
          }
          catch (IllegalAccessException paramIObjectWrapper)
          {
            paramIObjectWrapper = new IllegalArgumentException("Could not access the field in remoteBinder.", paramIObjectWrapper);
            AppMethodBeat.o(5418);
            throw paramIObjectWrapper;
          }
        }
        paramIObjectWrapper = new IllegalArgumentException("IObjectWrapper declared field not private!");
        AppMethodBeat.o(5418);
        throw paramIObjectWrapper;
      }
      i = arrayOfField.length;
      paramIObjectWrapper = new IllegalArgumentException(64 + "Unexpected number of IObjectWrapper declared fields: " + i);
      AppMethodBeat.o(5418);
      throw paramIObjectWrapper;
    }
  }
  
  public static <T> IObjectWrapper wrap(T paramT)
  {
    AppMethodBeat.i(5417);
    paramT = new ObjectWrapper(paramT);
    AppMethodBeat.o(5417);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.dynamic.ObjectWrapper
 * JD-Core Version:    0.7.0.1
 */