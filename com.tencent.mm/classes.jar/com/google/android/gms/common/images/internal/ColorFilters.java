package com.google.android.gms.common.images.internal;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ColorFilters
{
  public static final ColorFilter COLOR_FILTER_BW;
  private static final ColorMatrix zzpv;
  
  static
  {
    AppMethodBeat.i(11750);
    ColorMatrix localColorMatrix = new ColorMatrix();
    zzpv = localColorMatrix;
    localColorMatrix.setSaturation(0.0F);
    COLOR_FILTER_BW = new ColorMatrixColorFilter(zzpv);
    AppMethodBeat.o(11750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.images.internal.ColorFilters
 * JD-Core Version:    0.7.0.1
 */