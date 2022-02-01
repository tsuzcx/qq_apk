package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.IntEvaluator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/BulletFlyEvalutor;", "Landroid/animation/IntEvaluator;", "flyDuration", "", "stayDuration", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "fraction", "", "flying", "", "(IILkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "flyAcceFactor", "flyFraction", "evaluate", "startValue", "endValue", "(FII)Ljava/lang/Integer;", "plugin-finder_release"})
public final class c
  extends IntEvaluator
{
  private m<? super Float, ? super Boolean, x> jHk;
  private final int ykW;
  private final float ykX;
  
  public c(int paramInt, m<? super Float, ? super Boolean, x> paramm)
  {
    AppMethodBeat.i(231839);
    this.jHk = paramm;
    this.ykW = ((paramInt + 500) / 500);
    this.ykX = (1.0F / this.ykW);
    AppMethodBeat.o(231839);
  }
  
  private Integer c(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231832);
    m localm;
    if (paramFloat < this.ykX)
    {
      localm = this.jHk;
      if (localm != null) {
        localm.invoke(Float.valueOf(paramFloat), Boolean.TRUE);
      }
      paramInt1 = (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat * this.ykW);
    }
    for (;;)
    {
      AppMethodBeat.o(231832);
      return Integer.valueOf(paramInt1);
      localm = this.jHk;
      paramInt1 = paramInt2;
      if (localm != null)
      {
        localm.invoke(Float.valueOf(paramFloat), Boolean.FALSE);
        paramInt1 = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.c
 * JD-Core Version:    0.7.0.1
 */