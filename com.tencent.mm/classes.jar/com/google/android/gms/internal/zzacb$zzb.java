package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class zzacb$zzb
  extends Drawable.ConstantState
{
  int mChangingConfigurations;
  int zzaES;
  
  zzacb$zzb(zzb paramzzb)
  {
    if (paramzzb != null)
    {
      this.mChangingConfigurations = paramzzb.mChangingConfigurations;
      this.zzaES = paramzzb.zzaES;
    }
  }
  
  public final int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
  
  public final Drawable newDrawable()
  {
    return new zzacb(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzacb.zzb
 * JD-Core Version:    0.7.0.1
 */