package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.Map;

public final class q
{
  public static long A(Map<String, String> paramMap)
  {
    return bk.getLong((String)paramMap.get(".sysmsg.game_control_info.control_flag"), 0L);
  }
  
  static void a(Map<String, String> paramMap, o paramo)
  {
    paramo.kPd.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.userinfo";; str = ".sysmsg.gamecenter.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        return;
      }
      o.h localh = new o.h();
      localh.userName = bk.aM((String)paramMap.get(str + ".username"), "");
      localh.aVr = bk.aM((String)paramMap.get(str + ".nickname"), "");
      localh.kQb = bk.aM((String)paramMap.get(str + ".usericon"), "");
      localh.kQd = bk.aM((String)paramMap.get(str + ".badge_icon"), "");
      localh.kQe = bk.aM((String)paramMap.get(str + ".$jump_id"), "");
      paramo.kPd.add(localh);
      i += 1;
      break;
    }
  }
  
  public static void b(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    paramo.kPu.url = bk.aM((String)paramMap.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
    o.a locala = paramo.kPu;
    if (bk.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.kOO = bool1;
      paramo.kPu.orientation = bk.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
      paramo = paramo.kPu;
      if (bk.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
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
  
  public static String z(Map<String, String> paramMap)
  {
    return bk.aM((String)paramMap.get(".sysmsg.gamecenter.formatcontent"), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.q
 * JD-Core Version:    0.7.0.1
 */