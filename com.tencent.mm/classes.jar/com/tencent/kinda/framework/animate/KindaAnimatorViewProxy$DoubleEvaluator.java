package com.tencent.kinda.framework.animate;

import android.animation.TypeEvaluator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KindaAnimatorViewProxy$DoubleEvaluator
  implements TypeEvaluator<Number>
{
  public Number evaluate(float paramFloat, Number paramNumber1, Number paramNumber2)
  {
    AppMethodBeat.i(144272);
    double d1 = paramNumber1.doubleValue();
    double d2 = paramFloat;
    double d3 = paramNumber2.doubleValue();
    AppMethodBeat.o(144272);
    return Double.valueOf(d1 + d2 * (d3 - d1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimatorViewProxy.DoubleEvaluator
 * JD-Core Version:    0.7.0.1
 */