package com.google.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;

public final class f
  extends Number
{
  private final String value;
  
  public f(String paramString)
  {
    this.value = paramString;
  }
  
  private Object writeReplace()
  {
    AppMethodBeat.i(107920);
    BigDecimal localBigDecimal = new BigDecimal(this.value);
    AppMethodBeat.o(107920);
    return localBigDecimal;
  }
  
  public final double doubleValue()
  {
    AppMethodBeat.i(107919);
    double d = Double.parseDouble(this.value);
    AppMethodBeat.o(107919);
    return d;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(107922);
    if (this == paramObject)
    {
      AppMethodBeat.o(107922);
      return true;
    }
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      if ((this.value == paramObject.value) || (this.value.equals(paramObject.value)))
      {
        AppMethodBeat.o(107922);
        return true;
      }
      AppMethodBeat.o(107922);
      return false;
    }
    AppMethodBeat.o(107922);
    return false;
  }
  
  public final float floatValue()
  {
    AppMethodBeat.i(107918);
    float f = Float.parseFloat(this.value);
    AppMethodBeat.o(107918);
    return f;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(107921);
    int i = this.value.hashCode();
    AppMethodBeat.o(107921);
    return i;
  }
  
  public final int intValue()
  {
    AppMethodBeat.i(107916);
    int i;
    try
    {
      i = Integer.parseInt(this.value);
      AppMethodBeat.o(107916);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        long l = Long.parseLong(this.value);
        i = (int)l;
        AppMethodBeat.o(107916);
        return i;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        i = new BigDecimal(this.value).intValue();
        AppMethodBeat.o(107916);
      }
    }
    return i;
  }
  
  public final long longValue()
  {
    AppMethodBeat.i(107917);
    long l;
    try
    {
      l = Long.parseLong(this.value);
      AppMethodBeat.o(107917);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      l = new BigDecimal(this.value).longValue();
      AppMethodBeat.o(107917);
    }
    return l;
  }
  
  public final String toString()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.b.f
 * JD-Core Version:    0.7.0.1
 */