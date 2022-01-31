package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class zzacb$zza
  extends Drawable
{
  private static final zza zzaEQ = new zza();
  private static final zza zzaER = new zza(null);
  
  public final void draw(Canvas paramCanvas) {}
  
  public final Drawable.ConstantState getConstantState()
  {
    return zzaER;
  }
  
  public final int getOpacity()
  {
    return -2;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  private static final class zza
    extends Drawable.ConstantState
  {
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      return zzacb.zza.zzxt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzacb.zza
 * JD-Core Version:    0.7.0.1
 */