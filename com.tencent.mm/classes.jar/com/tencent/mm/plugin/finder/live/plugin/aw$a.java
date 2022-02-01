package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.FloatEvaluator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftQueuePlugin$BulletFadeInEvaluator;", "Landroid/animation/FloatEvaluator;", "fadeDuration", "", "stayDuration", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "fraction", "", "flying", "", "(IILkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "fadeFraction", "evaluate", "startValue", "", "endValue", "(FLjava/lang/Number;Ljava/lang/Number;)Ljava/lang/Float;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
final class aw$a
  extends FloatEvaluator
{
  private final float Dbr;
  private m<? super Float, ? super Boolean, ah> mgM;
  
  public aw$a(int paramInt, m<? super Float, ? super Boolean, ah> paramm)
  {
    AppMethodBeat.i(353608);
    this.mgM = paramm;
    this.Dbr = (500.0F / (paramInt + 500));
    AppMethodBeat.o(353608);
  }
  
  public final Float evaluate(float paramFloat, Number paramNumber1, Number paramNumber2)
  {
    AppMethodBeat.i(353618);
    if (paramFloat < this.Dbr)
    {
      m localm = this.mgM;
      if (localm != null) {
        localm.invoke(Float.valueOf(paramFloat), Boolean.TRUE);
      }
      if ((paramNumber1 == null) || (paramNumber2 == null))
      {
        AppMethodBeat.o(353618);
        return Float.valueOf(0.0F);
      }
      paramFloat = paramNumber1.floatValue() + (paramNumber2.floatValue() - paramNumber1.floatValue()) * paramFloat / this.Dbr;
    }
    for (;;)
    {
      AppMethodBeat.o(353618);
      return Float.valueOf(paramFloat);
      paramNumber1 = this.mgM;
      if (paramNumber1 != null) {
        paramNumber1.invoke(Float.valueOf(paramFloat), Boolean.FALSE);
      }
      if ((paramNumber2 instanceof Float)) {}
      for (paramNumber1 = (Float)paramNumber2;; paramNumber1 = null)
      {
        if (paramNumber1 != null) {
          break label139;
        }
        paramFloat = 1.0F;
        break;
      }
      label139:
      paramFloat = paramNumber1.floatValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aw.a
 * JD-Core Version:    0.7.0.1
 */