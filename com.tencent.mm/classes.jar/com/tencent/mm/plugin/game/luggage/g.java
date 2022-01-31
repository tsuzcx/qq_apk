package com.tencent.mm.plugin.game.luggage;

import com.tencent.mm.ab.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
{
  public static i EH(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    try
    {
      paramString = new i(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.Game.LuggageUtil", paramString.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g
 * JD-Core Version:    0.7.0.1
 */