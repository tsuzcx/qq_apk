package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Path;
import android.support.v4.view.b.f;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CircleProgressDrawable$c
{
  private static final Path jaA;
  public static final Interpolator jay;
  
  static
  {
    AppMethodBeat.i(77387);
    Path localPath = new Path();
    jaA = localPath;
    localPath.lineTo(0.5F, 0.0F);
    jaA.cubicTo(0.7F, 0.0F, 0.6F, 1.0F, 1.0F, 1.0F);
    jay = f.c(jaA);
    AppMethodBeat.o(77387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.c
 * JD-Core Version:    0.7.0.1
 */