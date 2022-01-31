package a.g;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"absoluteValue", "", "absoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "sign$annotations", "getSign", "(J)I", "ulp", "ulp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, eaR=1)
public class c
  extends b
{
  public static final long H(double paramDouble)
  {
    AppMethodBeat.i(155814);
    if (Double.isNaN(paramDouble))
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Cannot round NaN value.");
      AppMethodBeat.o(155814);
      throw localThrowable;
    }
    long l = Math.round(paramDouble);
    AppMethodBeat.o(155814);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.g.c
 * JD-Core Version:    0.7.0.1
 */