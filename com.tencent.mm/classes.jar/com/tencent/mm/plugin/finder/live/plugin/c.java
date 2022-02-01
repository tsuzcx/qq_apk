package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.IntEvaluator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/BulletFlyEvalutor;", "Landroid/animation/IntEvaluator;", "flyDuration", "", "stayDuration", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "fraction", "", "flying", "", "(IILkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "flyAcceFactor", "flyFraction", "evaluate", "startValue", "endValue", "(FII)Ljava/lang/Integer;", "plugin-finder_release"})
public final class c
  extends IntEvaluator
{
  private m<? super Float, ? super Boolean, x> gWp;
  private final int ulT;
  private final float ulU;
  
  public c(int paramInt1, int paramInt2, m<? super Float, ? super Boolean, x> paramm)
  {
    AppMethodBeat.i(246385);
    this.gWp = paramm;
    this.ulT = ((paramInt2 + paramInt1) / paramInt1);
    this.ulU = (1.0F / this.ulT);
    AppMethodBeat.o(246385);
  }
  
  private Integer c(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246382);
    m localm;
    if (paramFloat < this.ulU)
    {
      localm = this.gWp;
      if (localm != null) {
        localm.invoke(Float.valueOf(paramFloat), Boolean.TRUE);
      }
      paramInt1 = (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat * this.ulT);
    }
    for (;;)
    {
      AppMethodBeat.o(246382);
      return Integer.valueOf(paramInt1);
      localm = this.gWp;
      paramInt1 = paramInt2;
      if (localm != null)
      {
        localm.invoke(Float.valueOf(paramFloat), Boolean.FALSE);
        paramInt1 = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.c
 * JD-Core Version:    0.7.0.1
 */