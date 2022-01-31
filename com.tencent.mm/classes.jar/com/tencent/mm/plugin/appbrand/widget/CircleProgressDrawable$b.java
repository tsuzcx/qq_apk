package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Path;
import android.support.v4.view.b.f;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CircleProgressDrawable$b
{
  public static final Interpolator jay;
  private static final Path jaz;
  
  static
  {
    AppMethodBeat.i(77386);
    Path localPath = new Path();
    jaz = localPath;
    localPath.cubicTo(0.2F, 0.0F, 0.1F, 1.0F, 0.5F, 1.0F);
    jaz.lineTo(1.0F, 1.0F);
    jay = f.c(jaz);
    AppMethodBeat.o(77386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.b
 * JD-Core Version:    0.7.0.1
 */