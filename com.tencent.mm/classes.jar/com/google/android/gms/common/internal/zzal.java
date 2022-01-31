package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.Api.zzg;

public class zzal<T extends IInterface>
  extends zzl<T>
{
  private final Api.zzg<T> zzaGJ;
  
  protected String zzeA()
  {
    return this.zzaGJ.zzeA();
  }
  
  protected String zzez()
  {
    return this.zzaGJ.zzez();
  }
  
  protected T zzh(IBinder paramIBinder)
  {
    return this.zzaGJ.zzh(paramIBinder);
  }
  
  public Api.zzg<T> zzyn()
  {
    return this.zzaGJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzal
 * JD-Core Version:    0.7.0.1
 */