package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze
  implements TextFilterable.StringFilter
{
  public final boolean matches(String paramString1, String paramString2)
  {
    AppMethodBeat.i(61202);
    if (!paramString1.startsWith(paramString2))
    {
      paramString2 = String.valueOf(paramString2);
      if (paramString2.length() == 0) {
        break label47;
      }
    }
    label47:
    for (paramString2 = " ".concat(paramString2); paramString1.contains(paramString2); paramString2 = new String(" "))
    {
      AppMethodBeat.o(61202);
      return true;
    }
    AppMethodBeat.o(61202);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.data.zze
 * JD-Core Version:    0.7.0.1
 */