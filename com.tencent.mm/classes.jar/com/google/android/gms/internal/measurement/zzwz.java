package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzwz
  extends zzws<Double>
{
  zzwz(zzxc paramzzxc, String paramString, Double paramDouble)
  {
    super(paramzzxc, paramString, paramDouble, null);
  }
  
  private final Double zzfb(String paramString)
  {
    AppMethodBeat.i(2292);
    try
    {
      double d = Double.parseDouble(paramString);
      AppMethodBeat.o(2292);
      return Double.valueOf(d);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str = this.zzbnh;
      new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(paramString).length()).append("Invalid double value for ").append(str).append(": ").append(paramString);
      AppMethodBeat.o(2292);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwz
 * JD-Core Version:    0.7.0.1
 */