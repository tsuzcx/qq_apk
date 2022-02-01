package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LifecycleActivity
{
  private final Object zzkz;
  
  public LifecycleActivity(Activity paramActivity)
  {
    AppMethodBeat.i(4502);
    Preconditions.checkNotNull(paramActivity, "Activity must not be null");
    this.zzkz = paramActivity;
    AppMethodBeat.o(4502);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.LifecycleActivity
 * JD-Core Version:    0.7.0.1
 */