package a.l;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"screenFloatValue", "T", "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib"}, eaR=1)
public class s
  extends r
{
  public static final Float azs(String paramString)
  {
    AppMethodBeat.i(56346);
    j.q(paramString, "receiver$0");
    for (;;)
    {
      try
      {
        if (!l.CGX.ao((CharSequence)paramString)) {
          continue;
        }
        float f = Float.parseFloat(paramString);
        paramString = Float.valueOf(f);
      }
      catch (NumberFormatException paramString)
      {
        paramString = null;
        continue;
      }
      AppMethodBeat.o(56346);
      return paramString;
      paramString = null;
    }
  }
  
  public static final Double azt(String paramString)
  {
    AppMethodBeat.i(56347);
    j.q(paramString, "receiver$0");
    for (;;)
    {
      try
      {
        if (!l.CGX.ao((CharSequence)paramString)) {
          continue;
        }
        double d = Double.parseDouble(paramString);
        paramString = Double.valueOf(d);
      }
      catch (NumberFormatException paramString)
      {
        paramString = null;
        continue;
      }
      AppMethodBeat.o(56347);
      return paramString;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.l.s
 * JD-Core Version:    0.7.0.1
 */