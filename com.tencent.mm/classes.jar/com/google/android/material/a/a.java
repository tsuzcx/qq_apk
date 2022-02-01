package com.google.android.material.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.f.a.a.b;
import androidx.f.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final TimeInterpolator bum;
  public static final TimeInterpolator bun;
  public static final TimeInterpolator buo;
  public static final TimeInterpolator bup;
  public static final TimeInterpolator buq;
  
  static
  {
    AppMethodBeat.i(234193);
    bum = new LinearInterpolator();
    bun = new b();
    buo = new androidx.f.a.a.a();
    bup = new c();
    buq = new DecelerateInterpolator();
    AppMethodBeat.o(234193);
  }
  
  public static int c(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(234191);
    paramInt2 = Math.round((paramInt2 - paramInt1) * paramFloat);
    AppMethodBeat.o(234191);
    return paramInt2 + paramInt1;
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.a.a
 * JD-Core Version:    0.7.0.1
 */