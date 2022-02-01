package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KUtilityService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class KindaUtilityServiceImpl
  implements KUtilityService
{
  public String qmfCardStrLimitLen(String paramString, int paramInt)
  {
    AppMethodBeat.i(18529);
    if (paramInt < 0)
    {
      AppMethodBeat.o(18529);
      return paramString;
    }
    try
    {
      String str = paramString.substring(0, paramString.offsetByCodePoints(0, paramInt));
      str = str + "...";
      AppMethodBeat.o(18529);
      return str;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      ac.e("KindaUtilityServiceImpl", "IndexOutOfBoundsException error");
      AppMethodBeat.o(18529);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaUtilityServiceImpl
 * JD-Core Version:    0.7.0.1
 */