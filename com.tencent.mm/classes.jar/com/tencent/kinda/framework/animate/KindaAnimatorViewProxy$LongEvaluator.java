package com.tencent.kinda.framework.animate;

import android.animation.TypeEvaluator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KindaAnimatorViewProxy$LongEvaluator
  implements TypeEvaluator<Number>
{
  public Number evaluate(float paramFloat, Number paramNumber1, Number paramNumber2)
  {
    AppMethodBeat.i(18309);
    long l = paramNumber1.longValue();
    float f = (float)l;
    l = ((float)(paramNumber2.longValue() - l) * paramFloat + f);
    AppMethodBeat.o(18309);
    return Long.valueOf(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.LongEvaluator
 * JD-Core Version:    0.7.0.1
 */