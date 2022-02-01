package com.tencent.mm.plugin.finder.view.tabcomp;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.g.a.a.a;
import androidx.g.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static final TimeInterpolator dnq;
  public static final TimeInterpolator dnr;
  public static final TimeInterpolator dns;
  public static final TimeInterpolator dnt;
  public static final TimeInterpolator dnu;
  
  static
  {
    AppMethodBeat.i(345539);
    dnq = new LinearInterpolator();
    dnr = new b();
    dns = new a();
    dnt = new androidx.g.a.a.c();
    dnu = new DecelerateInterpolator();
    AppMethodBeat.o(345539);
  }
  
  public static int d(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(345531);
    paramInt2 = Math.round((paramInt2 - paramInt1) * paramFloat);
    AppMethodBeat.o(345531);
    return paramInt2 + paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.c
 * JD-Core Version:    0.7.0.1
 */