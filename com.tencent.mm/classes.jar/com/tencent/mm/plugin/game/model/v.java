package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;

public final class v
{
  public static v kQk;
  
  public static v aZw()
  {
    if (kQk == null) {
      kQk = new v();
    }
    return kQk;
  }
  
  static void c(Map<String, String> paramMap, o paramo)
  {
    paramo.kPi.clear();
    int i = 0;
    if (i == 0) {}
    for (String str1 = ".sysmsg.gamecenter.jump_info.jump";; str1 = ".sysmsg.gamecenter.jump_info.jump" + i)
    {
      if (!paramMap.containsKey(str1)) {
        return;
      }
      String str2 = (String)paramMap.get(str1 + ".$id");
      o.d locald = new o.d();
      locald.kPV = bk.getInt((String)paramMap.get(str1 + ".jump_type"), 0);
      locald.jCY = bk.aM((String)paramMap.get(str1 + ".jump_url"), "");
      if (!bk.bl(str2)) {
        paramo.kPi.put(str2, locald);
      }
      i += 1;
      break;
    }
  }
  
  public static void d(Map<String, String> paramMap, o paramo)
  {
    paramo.kPM = bk.getInt((String)paramMap.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
    paramo.kPN = bk.aM((String)paramMap.get(".sysmsg.gamecenter.report.noticeid"), "");
  }
  
  public static void e(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    paramo.kPu.url = bk.aM((String)paramMap.get(".sysmsg.gamecenter.float_layer.open_url"), "");
    o.a locala = paramo.kPu;
    if (bk.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.kOO = bool1;
      paramo.kPu.orientation = bk.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
      paramo = paramo.kPu;
      if (bk.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.kPR = bool1;
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.v
 * JD-Core Version:    0.7.0.1
 */