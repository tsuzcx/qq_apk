package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.zzg;

public abstract class zzf<T>
{
  private final String zzaRL;
  private T zzaRM;
  
  public zzf(String paramString)
  {
    this.zzaRL = paramString;
  }
  
  public final T zzbl(Context paramContext)
  {
    if (this.zzaRM == null)
    {
      zzac.zzw(paramContext);
      paramContext = zzg.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new zzf.zza("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.zzaRM = zzc((IBinder)paramContext.loadClass(this.zzaRL).newInstance());
      return this.zzaRM;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new zzf.zza("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new zzf.zza("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new zzf.zza("Could not access creator.", paramContext);
    }
  }
  
  public abstract T zzc(IBinder paramIBinder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzf
 * JD-Core Version:    0.7.0.1
 */