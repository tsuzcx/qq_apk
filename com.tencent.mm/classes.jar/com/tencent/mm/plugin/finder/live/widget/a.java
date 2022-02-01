package com.tencent.mm.plugin.finder.live.widget;

import android.animation.IntEvaluator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/BulletFlyEvalutor;", "Landroid/animation/IntEvaluator;", "flyDuration", "", "stayDuration", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "fraction", "", "flying", "", "(IILkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "flyAcceFactor", "flyFraction", "evaluate", "startValue", "endValue", "(FII)Ljava/lang/Integer;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends IntEvaluator
{
  private final int Elu;
  private final float Elv;
  private m<? super Float, ? super Boolean, ah> mgM;
  
  public a(int paramInt, m<? super Float, ? super Boolean, ah> paramm)
  {
    AppMethodBeat.i(361002);
    this.mgM = paramm;
    this.Elu = ((paramInt + 500) / 500);
    this.Elv = (1.0F / this.Elu);
    AppMethodBeat.o(361002);
  }
  
  private Integer d(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(361010);
    m localm;
    if (paramFloat < this.Elv)
    {
      localm = this.mgM;
      if (localm != null) {
        localm.invoke(Float.valueOf(paramFloat), Boolean.TRUE);
      }
      paramInt1 = (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat * this.Elu);
    }
    for (;;)
    {
      AppMethodBeat.o(361010);
      return Integer.valueOf(paramInt1);
      localm = this.mgM;
      paramInt1 = paramInt2;
      if (localm != null)
      {
        localm.invoke(Float.valueOf(paramFloat), Boolean.FALSE);
        paramInt1 = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.a
 * JD-Core Version:    0.7.0.1
 */