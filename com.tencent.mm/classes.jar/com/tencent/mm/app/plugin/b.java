package com.tencent.mm.app.plugin;

import com.tencent.mm.br.d;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.bk;

public final class b
{
  public static boolean tx()
  {
    if (!d.SP("translate")) {}
    String str;
    do
    {
      return false;
      str = g.AA().getValue("TranslateMsgOff");
      if (bk.bl(str)) {
        return true;
      }
    } while (bk.ZR(str) != 0);
    return true;
  }
  
  public static boolean ty()
  {
    if (!d.SP("translate")) {}
    String str;
    do
    {
      return false;
      str = g.AA().getValue("ReTranslateSwitch");
      if (bk.bl(str)) {
        return true;
      }
    } while (bk.ZR(str) != 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.b
 * JD-Core Version:    0.7.0.1
 */