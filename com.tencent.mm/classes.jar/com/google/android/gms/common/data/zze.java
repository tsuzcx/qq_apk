package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze
  implements TextFilterable.StringFilter
{
  public final boolean matches(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11694);
    if (!paramString1.startsWith(paramString2))
    {
      paramString2 = String.valueOf(paramString2);
      if (paramString2.length() == 0) {
        break label49;
      }
    }
    label49:
    for (paramString2 = " ".concat(paramString2); paramString1.contains(paramString2); paramString2 = new String(" "))
    {
      AppMethodBeat.o(11694);
      return true;
    }
    AppMethodBeat.o(11694);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.zze
 * JD-Core Version:    0.7.0.1
 */