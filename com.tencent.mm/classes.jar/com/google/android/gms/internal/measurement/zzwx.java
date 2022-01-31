package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzwx
  extends zzws<Integer>
{
  zzwx(zzxc paramzzxc, String paramString, Integer paramInteger)
  {
    super(paramzzxc, paramString, paramInteger, null);
  }
  
  private final Integer zzfa(String paramString)
  {
    AppMethodBeat.i(69766);
    try
    {
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(69766);
      return Integer.valueOf(i);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str = this.zzbnh;
      new StringBuilder(String.valueOf(str).length() + 28 + String.valueOf(paramString).length()).append("Invalid integer value for ").append(str).append(": ").append(paramString);
      AppMethodBeat.o(69766);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzwx
 * JD-Core Version:    0.7.0.1
 */