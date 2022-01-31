package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaConstants
{
  public static final float UNDEFINED = 1.0E+021F;
  public static boolean shouldUseFastMath = false;
  
  public static boolean isUndefined(float paramFloat)
  {
    AppMethodBeat.i(144040);
    if ((Float.compare(paramFloat, 1.0E+009F) >= 0) || (Float.compare(paramFloat, -1.0E+009F) <= 0))
    {
      AppMethodBeat.o(144040);
      return true;
    }
    AppMethodBeat.o(144040);
    return false;
  }
  
  public static boolean isUndefined(YogaValue paramYogaValue)
  {
    return paramYogaValue.unit == YogaUnit.UNDEFINED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.yoga.YogaConstants
 * JD-Core Version:    0.7.0.1
 */