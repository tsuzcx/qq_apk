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
    AppMethodBeat.i(18218);
    UNDEFINED = new YogaValue((0.0F / 0.0F), YogaUnit.UNDEFINED);
    ZERO = new YogaValue(0.0F, YogaUnit.POINT);
    AUTO = new YogaValue((0.0F / 0.0F), YogaUnit.AUTO);
    AppMethodBeat.o(18218);
  }
  
  YogaValue(float paramFloat, int paramInt)
  {
    this(paramFloat, YogaUnit.fromInt(paramInt));
    AppMethodBeat.i(18213);
    AppMethodBeat.o(18213);
  }
  
  public YogaValue(float paramFloat, YogaUnit paramYogaUnit)
  {
    this.value = paramFloat;
    this.unit = paramYogaUnit;
  }
  
  public static YogaValue parse(String paramString)
  {
    AppMethodBeat.i(18217);
    if (paramString == null)
    {
      AppMethodBeat.o(18217);
      return null;
    }
    if ("undefined".equals(paramString))
    {
      paramString = UNDEFINED;
      AppMethodBeat.o(18217);
      return paramString;
    }
    if ("auto".equals(paramString))
    {
      paramString = AUTO;
      AppMethodBeat.o(18217);
      return paramString;
    }
    if (paramString.endsWith("%"))
    {
      paramString = new YogaValue(Float.parseFloat(paramString.substring(0, paramString.length() - 1)), YogaUnit.PERCENT);
      AppMethodBeat.o(18217);
      return paramString;
    }
    paramString = new YogaValue(Float.parseFloat(paramString), YogaUnit.POINT);
    AppMethodBeat.o(18217);
    return paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(18214);
    if ((paramObject instanceof YogaValue))
    {
      paramObject = (YogaValue)paramObject;
      if (this.unit == paramObject.unit)
      {
        if ((this.unit == YogaUnit.UNDEFINED) || (this.unit == YogaUnit.AUTO) || (Float.compare(this.value, paramObject.value) == 0))
        {
          AppMethodBeat.o(18214);
          return true;
        }
        AppMethodBeat.o(18214);
        return false;
      }
    }
    AppMethodBeat.o(18214);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(18215);
    int i = Float.floatToIntBits(this.value);
    int j = this.unit.intValue();
    AppMethodBeat.o(18215);
    return i + j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(18216);
    Object localObject;
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.unit.ordinal()])
    {
    default: 
      localObject = new IllegalStateException();
      AppMethodBeat.o(18216);
      throw ((Throwable)localObject);
    case 1: 
      AppMethodBeat.o(18216);
      return "undefined";
    case 2: 
      localObject = Float.toString(this.value);
      AppMethodBeat.o(18216);
      return localObject;
    case 3: 
      localObject = this.value + "%";
      AppMethodBeat.o(18216);
      return localObject;
    }
    AppMethodBeat.o(18216);
    return "auto";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaValue
 * JD-Core Version:    0.7.0.1
 */