package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaValue
{
  static final YogaValue AUTO;
  static final YogaValue UNDEFINED;
  static final YogaValue ZERO;
  public final YogaUnit unit;
  public final float value;
  
  static
  {
    AppMethodBeat.i(144195);
    UNDEFINED = new YogaValue(1.0E+021F, YogaUnit.UNDEFINED);
    ZERO = new YogaValue(0.0F, YogaUnit.POINT);
    AUTO = new YogaValue(1.0E+021F, YogaUnit.AUTO);
    AppMethodBeat.o(144195);
  }
  
  YogaValue(float paramFloat, int paramInt)
  {
    this(paramFloat, YogaUnit.fromInt(paramInt));
    AppMethodBeat.i(144190);
    AppMethodBeat.o(144190);
  }
  
  public YogaValue(float paramFloat, YogaUnit paramYogaUnit)
  {
    this.value = paramFloat;
    this.unit = paramYogaUnit;
  }
  
  public static YogaValue parse(String paramString)
  {
    AppMethodBeat.i(144194);
    if (paramString == null)
    {
      AppMethodBeat.o(144194);
      return null;
    }
    if ("undefined".equals(paramString))
    {
      paramString = UNDEFINED;
      AppMethodBeat.o(144194);
      return paramString;
    }
    if ("auto".equals(paramString))
    {
      paramString = AUTO;
      AppMethodBeat.o(144194);
      return paramString;
    }
    if (paramString.endsWith("%"))
    {
      paramString = new YogaValue(Float.parseFloat(paramString.substring(0, paramString.length() - 1)), YogaUnit.PERCENT);
      AppMethodBeat.o(144194);
      return paramString;
    }
    paramString = new YogaValue(Float.parseFloat(paramString), YogaUnit.POINT);
    AppMethodBeat.o(144194);
    return paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(144191);
    if ((paramObject instanceof YogaValue))
    {
      paramObject = (YogaValue)paramObject;
      if (this.unit == paramObject.unit)
      {
        if ((this.unit == YogaUnit.UNDEFINED) || (Float.compare(this.value, paramObject.value) == 0))
        {
          AppMethodBeat.o(144191);
          return true;
        }
        AppMethodBeat.o(144191);
        return false;
      }
    }
    AppMethodBeat.o(144191);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(144192);
    int i = Float.floatToIntBits(this.value);
    int j = this.unit.intValue();
    AppMethodBeat.o(144192);
    return i + j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(144193);
    Object localObject;
    switch (YogaValue.1.$SwitchMap$com$facebook$yoga$YogaUnit[this.unit.ordinal()])
    {
    default: 
      localObject = new IllegalStateException();
      AppMethodBeat.o(144193);
      throw ((Throwable)localObject);
    case 1: 
      AppMethodBeat.o(144193);
      return "undefined";
    case 2: 
      localObject = Float.toString(this.value);
      AppMethodBeat.o(144193);
      return localObject;
    case 3: 
      localObject = this.value + "%";
      AppMethodBeat.o(144193);
      return localObject;
    }
    AppMethodBeat.o(144193);
    return "auto";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.yoga.YogaValue
 * JD-Core Version:    0.7.0.1
 */