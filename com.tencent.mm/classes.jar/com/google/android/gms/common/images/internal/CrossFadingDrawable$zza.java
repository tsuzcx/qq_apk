package com.google.android.gms.common.images.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CrossFadingDrawable$zza
  extends Drawable
{
  private static final zza zzqj;
  private static final zzb zzqk;
  
  static
  {
    AppMethodBeat.i(61259);
    zzqj = new zza();
    zzqk = new zzb(null);
    AppMethodBeat.o(61259);
  }
  
  public final void draw(Canvas paramCanvas) {}
  
  public final Drawable.ConstantState getConstantState()
  {
    return zzqk;
  }
  
  public final int getOpacity()
  {
    return -2;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.images.internal.CrossFadingDrawable.zza
 * JD-Core Version:    0.7.0.1
 */