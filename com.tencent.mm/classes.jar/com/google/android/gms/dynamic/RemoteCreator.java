package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

public abstract class RemoteCreator<T>
{
  private final String zzabo;
  private T zzabp;
  
  protected RemoteCreator(String paramString)
  {
    this.zzabo = paramString;
  }
  
  protected abstract T getRemoteCreator(IBinder paramIBinder);
  
  protected final T getRemoteCreatorInstance(Context paramContext)
  {
    if (this.zzabp == null)
    {
      Preconditions.checkNotNull(paramContext);
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new RemoteCreatorException("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.zzabp = getRemoteCreator((IBinder)paramContext.loadClass(this.zzabo).newInstance());
      return this.zzabp;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new RemoteCreatorException("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new RemoteCreatorException("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new RemoteCreatorException("Could not access creator.", paramContext);
    }
  }
  
  public static class RemoteCreatorException
    extends Exception
  {
    public RemoteCreatorException(String paramString)
    {
      super();
    }
    
    public RemoteCreatorException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.dynamic.RemoteCreator
 * JD-Core Version:    0.7.0.1
 */