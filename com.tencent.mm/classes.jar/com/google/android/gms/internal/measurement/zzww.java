package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzww
  extends zzws<Long>
{
  zzww(zzxc paramzzxc, String paramString, Long paramLong)
  {
    super(paramzzxc, paramString, paramLong, null);
  }
  
  private final Long zzez(String paramString)
  {
    AppMethodBeat.i(2287);
    try
    {
      long l = Long.parseLong(paramString);
      AppMethodBeat.o(2287);
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str = this.zzbnh;
      new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(paramString).length()).append("Invalid long value for ").append(str).append(": ").append(paramString);
      AppMethodBeat.o(2287);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzww
 * JD-Core Version:    0.7.0.1
 */