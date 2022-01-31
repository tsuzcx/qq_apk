package com.google.android.gms.common.images.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb
  extends Drawable.ConstantState
{
  public final int getChangingConfigurations()
  {
    return 0;
  }
  
  public final Drawable newDrawable()
  {
    AppMethodBeat.i(61297);
    CrossFadingDrawable.zza localzza = CrossFadingDrawable.zza.zzcp();
    AppMethodBeat.o(61297);
    return localzza;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.images.internal.zzb
 * JD-Core Version:    0.7.0.1
 */