package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class LifecycleActivity
{
  private final Object zzkz;
  
  public LifecycleActivity(Activity paramActivity)
  {
    AppMethodBeat.i(89480);
    Preconditions.checkNotNull(paramActivity, "Activity must not be null");
    this.zzkz = paramActivity;
    AppMethodBeat.o(89480);
  }
  
  public final boolean zzbv()
  {
    return this.zzkz instanceof FragmentActivity;
  }
  
  public final boolean zzbw()
  {
    return this.zzkz instanceof Activity;
  }
  
  public final Activity zzbx()
  {
    return (Activity)this.zzkz;
  }
  
  public final FragmentActivity zzby()
  {
    return (FragmentActivity)this.zzkz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.LifecycleActivity
 * JD-Core Version:    0.7.0.1
 */