package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Path;
import android.support.v4.view.b.f;
import android.view.animation.Interpolator;

public final class CircleProgressDrawable$b
{
  public static final Interpolator hof = f.c(hog);
  private static final Path hog;
  
  static
  {
    Path localPath = new Path();
    hog = localPath;
    localPath.cubicTo(0.2F, 0.0F, 0.1F, 1.0F, 0.5F, 1.0F);
    hog.lineTo(1.0F, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.b
 * JD-Core Version:    0.7.0.1
 */