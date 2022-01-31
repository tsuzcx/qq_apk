package com.google.android.gms.dynamic;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class zzd<T>
  extends IObjectWrapper.zza
{
  private final T mWrappedObject;
  
  private zzd(T paramT)
  {
    this.mWrappedObject = paramT;
  }
  
  public static <T> IObjectWrapper zzA(T paramT)
  {
    return new zzd(paramT);
  }
  
  public static <T> T zzF(IObjectWrapper paramIObjectWrapper)
  {
    if ((paramIObjectWrapper instanceof zzd)) {
      return ((zzd)paramIObjectWrapper).mWrappedObject;
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
        break label169;
      }
      j += 1;
      paramIObjectWrapper = localField;
    }
    label169:
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
            return paramIObjectWrapper;
          }
          catch (NullPointerException paramIObjectWrapper)
          {
            throw new IllegalArgumentException("Binder object is null.", paramIObjectWrapper);
          }
          catch (IllegalAccessException paramIObjectWrapper)
          {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramIObjectWrapper);
          }
        }
        throw new IllegalArgumentException("IObjectWrapper declared field not private!");
      }
      i = arrayOfField.length;
      throw new IllegalArgumentException(64 + "Unexpected number of IObjectWrapper declared fields: " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzd
 * JD-Core Version:    0.7.0.1
 */