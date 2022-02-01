package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class u
{
  public static u rXK;
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(41504);
    if (bt.isNullOrNil(paramo.field_rawXML))
    {
      ad.e("MicroMsg.GameNewMessageParser", "msg content is null");
      AppMethodBeat.o(41504);
      return;
    }
    Map localMap = bw.K(paramo.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ad.e("MicroMsg.GameNewMessageParser", "Parse failed");
      AppMethodBeat.o(41504);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ad.e("MicroMsg.GameNewMessageParser", "Type not matched");
      AppMethodBeat.o(41504);
      return;
    }
    d(localMap, paramo);
    q(localMap, paramo);
    s(localMap, paramo);
    f(localMap, paramo);
    u(localMap, paramo);
    k(localMap, paramo);
    v(localMap, paramo);
    c(localMap, paramo);
    w(localMap, paramo);
    x(localMap, paramo);
    y(localMap, paramo);
    AppMethodBeat.o(41504);
  }
  
  private static void c(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41516);
    paramo.rWp = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41516);
  }
  
  public static u cDu()
  {
    AppMethodBeat.i(41503);
    if (rXK == null) {
      rXK = new u();
    }
    u localu = rXK;
    AppMethodBeat.o(41503);
    return localu;
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41505);
    paramo.rWC = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
    paramo.rWD = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
    paramo.rWE = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
    paramo.rWI.mContent = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
    paramo.rWI.rXa = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
    paramo.rWI.rXb = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
    paramo.rWF = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
    paramo.rWG = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
    r(paramMap, paramo);
    h(paramMap, paramo);
    t(paramMap, paramo);
    AppMethodBeat.o(41505);
  }
  
  private static void f(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41510);
    paramo.rWg.rXa = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
    paramo.rWg.mDesc = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
    paramo.rWg.rXb = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
    AppMethodBeat.o(41510);
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41508);
    paramo.rWc.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.msg_center.userinfo";; str = ".sysmsg.gamecenter.msg_center.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label272;
      }
      o.i locali = new o.i();
      locali.userName = bt.by((String)paramMap.get(str + ".username"), "");
      locali.bNK = bt.by((String)paramMap.get(str + ".nickname"), "");
      locali.rXl = bt.by((String)paramMap.get(str + ".usericon"), "");
      locali.rXn = bt.by((String)paramMap.get(str + ".badge_icon"), "");
      locali.rXo = bt.by((String)paramMap.get(str + ".$jump_id"), "");
      paramo.rWc.add(locali);
      i += 1;
      break;
    }
    label272:
    AppMethodBeat.o(41508);
  }
  
  public static void k(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41514);
    paramo.rWe.rXc = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
    paramo.rWe.rXa = bt.by((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
    paramo.rWe.mText = bt.by((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
    paramo.rWe.rXd = (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2);
    paramo.rWe.rXe = (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2);
    o.d locald = paramo.rWe;
    if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_rounded_corner"), 0) == 1)
    {
      bool1 = true;
      locald.rXf = bool1;
      paramo.rWe.rXg = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.basic_type"), -1);
      paramo = paramo.rWe;
      if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.ignore_local_control"), 0) != 1) {
        break label232;
      }
    }
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.rXh = bool1;
      AppMethodBeat.o(41514);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void q(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41506);
    paramo.rWh.clear();
    int i = 0;
    if (i == 0) {}
    for (String str1 = ".sysmsg.gamecenter.jump_info.jump";; str1 = ".sysmsg.gamecenter.jump_info.jump" + i)
    {
      if (!paramMap.containsKey(str1)) {
        break label201;
      }
      String str2 = (String)paramMap.get(str1 + ".$id");
      o.e locale = new o.e();
      locale.mJumpType = bt.getInt((String)paramMap.get(str1 + ".jump_type"), 0);
      locale.pdh = bt.by((String)paramMap.get(str1 + ".jump_url"), "");
      if (!bt.isNullOrNil(str2)) {
        paramo.rWh.put(str2, locale);
      }
      i += 1;
      break;
    }
    label201:
    AppMethodBeat.o(41506);
  }
  
  private static void r(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41507);
    if (paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender") != null)
    {
      paramo.rWH = new o.g();
      paramo.rWH.rXi = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
      paramo.rWH.rXj = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
      paramo.rWH.rXk = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
      paramo.rWH.rXb = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
    }
    AppMethodBeat.o(41507);
  }
  
  public static void s(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41509);
    paramo.rWQ = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
    paramo.rWR = bt.by((String)paramMap.get(".sysmsg.gamecenter.report.noticeid"), "");
    paramo.rWS = bt.by((String)paramMap.get(".sysmsg.gamecenter.report.ext_data"), "");
    paramo.rWT = bt.by((String)paramMap.get(".sysmsg.gamecenter.report.business_data"), "");
    AppMethodBeat.o(41509);
  }
  
  private static void t(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41511);
    paramo.rWJ.mName = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
    o.h localh = paramo.rWJ;
    if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localh.mClickable = bool;
      paramo.rWJ.rXb = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
      AppMethodBeat.o(41511);
      return;
    }
  }
  
  public static void u(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41512);
    paramo.rWu.url = bt.by((String)paramMap.get(".sysmsg.gamecenter.float_layer.open_url"), "");
    o.a locala = paramo.rWu;
    if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.rOL = bool1;
      paramo.rWu.orientation = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
      locala = paramo.rWu;
      if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.rWX = bool1;
      paramo.rWu.rWY.clear();
      paramo.rWu.rWY.addAll(v(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", paramMap));
      AppMethodBeat.o(41512);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static List<String> v(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(41513);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i == 0) {}
    for (String str = paramString;; str = paramString + i)
    {
      if (!paramMap.containsKey(str)) {
        break label119;
      }
      int j = i + 1;
      str = (String)paramMap.get(str + ".$pkg_id");
      i = j;
      if (bt.isNullOrNil(str)) {
        break;
      }
      localArrayList.add(str);
      i = j;
      break;
    }
    label119:
    AppMethodBeat.o(41513);
    return localArrayList;
  }
  
  private static void v(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41515);
    paramo.rWK.rXp = bt.by((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
    paramo.rWK.nwF = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
    paramo.rWK.rXq = bt.getLong((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
    AppMethodBeat.o(41515);
  }
  
  public static void w(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(196759);
    paramo.rWq = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.device_flag"), 0);
    AppMethodBeat.o(196759);
  }
  
  public static void x(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41517);
    paramo.rWL.rWZ = bt.by((String)paramMap.get(".sysmsg.gamecenter.banner.$banner_id"), "");
    paramo.rWL.rWY.clear();
    paramo.rWL.rWY.addAll(v(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", paramMap));
    AppMethodBeat.o(41517);
  }
  
  public static void y(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(183868);
    paramo.rWO.rXr = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.$jump_id"), "");
    paramo.rWO.rXs = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.show_type"), 0);
    paramo.rWO.rXt = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.not_in_msg_center"), 0);
    paramo.rWO.rXu = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_icon"), "");
    paramo.rWO.rXv = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_name"), "");
    paramo.rWO.rXw = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.$jump_id"), "");
    paramo.rWO.rXx = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.content_pic"), "");
    paramo.rWO.rXy = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.first_line_text"), "");
    paramo.rWO.rXz = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.second_line_text"), "");
    paramo.rWO.rXA = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_id"), "");
    paramo.rWO.rXB = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_count"), 0);
    paramo.rWO.rXC = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.body_text"), "");
    paramo.rWO.rXD = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_pic"), "");
    paramo.rWO.rXE = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_text"), "");
    paramo.rWO.rXF = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.source_name"), "");
    AppMethodBeat.o(183868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.u
 * JD-Core Version:    0.7.0.1
 */