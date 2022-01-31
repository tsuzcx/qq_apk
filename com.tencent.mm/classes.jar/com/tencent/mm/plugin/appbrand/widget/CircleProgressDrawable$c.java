package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Path;
import android.support.v4.view.b.f;
import android.view.animation.Interpolator;

public final class CircleProgressDrawable$c
{
  public static final Interpolator hof = f.c(hoh);
  private static final Path hoh;
  
  static
  {
    Path localPath = new Path();
    hoh = localPath;
    localPath.lineTo(0.5F, 0.0F);
    hoh.cubicTo(0.7F, 0.0F, 0.6F, 1.0F, 1.0F, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.c
 * JD-Core Version:    0.7.0.1
 */