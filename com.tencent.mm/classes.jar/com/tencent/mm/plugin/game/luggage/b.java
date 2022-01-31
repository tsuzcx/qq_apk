package com.tencent.mm.plugin.game.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class b
{
  public static long Dt;
  public static Map<String, String> mHeaders;
  public static String nji;
  public static boolean njj;
  
  public static boolean bFl()
  {
    AppMethodBeat.i(135808);
    if (bo.isNullOrNil(nji))
    {
      ab.i("MicroMsg.LuggageGameUinKeyHolder", "fullUrl is null");
      AppMethodBeat.o(135808);
      return false;
    }
    if (a.bFh() <= 0)
    {
      AppMethodBeat.o(135808);
      return false;
    }
    if (System.currentTimeMillis() / 1000L - Dt > a.bFh())
    {
      ab.i("MicroMsg.LuggageGameUinKeyHolder", "updateTime bigger that one hour");
      AppMethodBeat.o(135808);
      return false;
    }
    ab.d("MicroMsg.LuggageGameUinKeyHolder", "hasValidCache");
    AppMethodBeat.o(135808);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b
 * JD-Core Version:    0.7.0.1
 */