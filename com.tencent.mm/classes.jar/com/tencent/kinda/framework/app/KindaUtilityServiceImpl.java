package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KUtilityService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tenpay.ndk.Encrypt;

public class KindaUtilityServiceImpl
  implements KUtilityService
{
  public String get3DesEncryptResult(String paramString)
  {
    AppMethodBeat.i(263972);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(263972);
      return "";
    }
    paramString = new Encrypt().desedeEncode(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(263972);
      return "";
    }
    AppMethodBeat.o(263972);
    return paramString;
  }
  
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
      Log.e("KindaUtilityServiceImpl", "IndexOutOfBoundsException error");
      AppMethodBeat.o(18529);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaUtilityServiceImpl
 * JD-Core Version:    0.7.0.1
 */