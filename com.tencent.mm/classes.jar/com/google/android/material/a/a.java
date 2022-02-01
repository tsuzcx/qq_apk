package com.google.android.material.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.g.a.a.b;
import androidx.g.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final TimeInterpolator dnq;
  public static final TimeInterpolator dnr;
  public static final TimeInterpolator dns;
  public static final TimeInterpolator dnt;
  public static final TimeInterpolator dnu;
  
  static
  {
    AppMethodBeat.i(209180);
    dnq = new LinearInterpolator();
    dnr = new b();
    dns = new androidx.g.a.a.a();
    dnt = new c();
    dnu = new DecelerateInterpolator();
    AppMethodBeat.o(209180);
  }
  
  public static int d(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(209175);
    paramInt2 = Math.round((paramInt2 - paramInt1) * paramFloat);
    AppMethodBeat.o(209175);
    return paramInt2 + paramInt1;
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.a.a
 * JD-Core Version:    0.7.0.1
 */