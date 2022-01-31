package com.google.android.gms.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.internal.zzac;

public class zzabd
{
  private final Object zzaCQ;
  
  public zzabd(Activity paramActivity)
  {
    zzac.zzb(paramActivity, "Activity must not be null");
    this.zzaCQ = paramActivity;
  }
  
  public boolean zzwS()
  {
    return this.zzaCQ instanceof FragmentActivity;
  }
  
  public Activity zzwT()
  {
    return (Activity)this.zzaCQ;
  }
  
  public FragmentActivity zzwU()
  {
    return (FragmentActivity)this.zzaCQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzabd
 * JD-Core Version:    0.7.0.1
 */