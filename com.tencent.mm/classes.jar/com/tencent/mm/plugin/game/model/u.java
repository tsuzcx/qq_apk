package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.f;

public final class u
{
  public static u xGT;
  
  public static void A(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(204176);
    paramo.xFS.xGv = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.tab_info.default_key"), "");
    paramo.xFS.xGw = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.tab_info.red_dot.key"), "");
    if (!Util.isNullOrNil(paramo.xFS.xGw)) {
      paramo.xFS.xGx = (paramo.field_createTime + Util.getLong((String)paramMap.get(".sysmsg.gamecenter.tab_info.red_dot.expire_time"), 86400L));
    }
    AppMethodBeat.o(204176);
  }
  
  public static void B(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(204177);
    paramo.xFT.xGd = f.bvi(Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.extra_data.preload"), ""));
    if ((!Util.isNullOrNil(paramo.xFT.xGd)) && (paramo.xFT.xGd.getBytes().length > 204800)) {
      paramo.xFT.xGd = "";
    }
    AppMethodBeat.o(204177);
  }
  
  private static List<String> E(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(41513);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i == 0) {}
    for (String str = paramString;; str = paramString + i)
    {
      if (!paramMap.containsKey(str)) {
        break label117;
      }
      int j = i + 1;
      str = (String)paramMap.get(str + ".$pkg_id");
      i = j;
      if (Util.isNullOrNil(str)) {
        break;
      }
      localArrayList.add(str);
      i = j;
      break;
    }
    label117:
    AppMethodBeat.o(41513);
    return localArrayList;
  }
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(41504);
    if (Util.isNullOrNil(paramo.field_rawXML))
    {
      Log.e("MicroMsg.GameNewMessageParser", "msg content is null");
      AppMethodBeat.o(41504);
      return;
    }
    Map localMap = XmlParser.parseXml(paramo.field_rawXML, "sysmsg", null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      Log.e("MicroMsg.GameNewMessageParser", "Parse failed");
      AppMethodBeat.o(41504);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      Log.e("MicroMsg.GameNewMessageParser", "Type not matched");
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
    z(localMap, paramo);
    A(localMap, paramo);
    B(localMap, paramo);
    AppMethodBeat.o(41504);
  }
  
  private static void c(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41516);
    paramo.xFr = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41516);
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41505);
    paramo.xFE = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
    paramo.xFF = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
    paramo.xFG = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
    paramo.xFK.mContent = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
    paramo.xFK.xGg = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
    paramo.xFK.xGh = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
    paramo.xFH = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
    paramo.xFI = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
    r(paramMap, paramo);
    h(paramMap, paramo);
    t(paramMap, paramo);
    AppMethodBeat.o(41505);
  }
  
  public static u dVC()
  {
    AppMethodBeat.i(41503);
    if (xGT == null) {
      xGT = new u();
    }
    u localu = xGT;
    AppMethodBeat.o(41503);
    return localu;
  }
  
  private static void f(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41510);
    paramo.xFi.xGg = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
    paramo.xFi.mDesc = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
    paramo.xFi.xGh = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
    AppMethodBeat.o(41510);
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41508);
    paramo.xFe.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.msg_center.userinfo";; str = ".sysmsg.gamecenter.msg_center.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label278;
      }
      o.k localk = new o.k();
      localk.userName = Util.nullAs((String)paramMap.get(str + ".username"), "");
      localk.nickName = Util.nullAs((String)paramMap.get(str + ".nickname"), "");
      localk.xGp = Util.nullAs((String)paramMap.get(str + ".usericon"), "");
      localk.xGr = Util.nullAs((String)paramMap.get(str + ".badge_icon"), "");
      localk.xGs = Util.nullAs((String)paramMap.get(str + ".$jump_id"), "");
      paramo.xFe.add(localk);
      i += 1;
      break;
    }
    label278:
    AppMethodBeat.o(41508);
  }
  
  public static void k(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41514);
    paramo.xFg.xGi = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
    paramo.xFg.xGg = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
    paramo.xFg.mText = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
    paramo.xFg.mIconWidth = (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2);
    paramo.xFg.mIconHeight = (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2);
    o.f localf = paramo.xFg;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_rounded_corner"), 0) == 1)
    {
      bool1 = true;
      localf.xGj = bool1;
      paramo.xFg.xGk = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.basic_type"), -1);
      paramo = paramo.xFg;
      if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.ignore_local_control"), 0) != 1) {
        break label232;
      }
    }
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.xGl = bool1;
      AppMethodBeat.o(41514);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void q(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41506);
    paramo.xFj.clear();
    int i = 0;
    if (i == 0) {}
    for (String str1 = ".sysmsg.gamecenter.jump_info.jump";; str1 = ".sysmsg.gamecenter.jump_info.jump" + i)
    {
      if (!paramMap.containsKey(str1)) {
        break label201;
      }
      String str2 = (String)paramMap.get(str1 + ".$id");
      o.g localg = new o.g();
      localg.mJumpType = Util.getInt((String)paramMap.get(str1 + ".jump_type"), 0);
      localg.rHJ = Util.nullAs((String)paramMap.get(str1 + ".jump_url"), "");
      if (!Util.isNullOrNil(str2)) {
        paramo.xFj.put(str2, localg);
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
      paramo.xFJ = new o.i();
      paramo.xFJ.xGm = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
      paramo.xFJ.xGn = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
      paramo.xFJ.xGo = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
      paramo.xFJ.xGh = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
    }
    AppMethodBeat.o(41507);
  }
  
  public static void s(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41509);
    paramo.xFV = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
    paramo.xFW = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.report.noticeid"), "");
    paramo.xFX = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.report.ext_data"), "");
    paramo.xFY = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.report.business_data"), "");
    AppMethodBeat.o(41509);
  }
  
  private static void t(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41511);
    paramo.xFL.mName = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
    o.j localj = paramo.xFL;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localj.mClickable = bool;
      paramo.xFL.xGh = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
      AppMethodBeat.o(41511);
      return;
    }
  }
  
  public static void u(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41512);
    paramo.xFw.url = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.float_layer.open_url"), "");
    o.a locala = paramo.xFw;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.xvW = bool1;
      paramo.xFw.orientation = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
      locala = paramo.xFw;
      if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.crp = bool1;
      paramo.xFw.xGc.clear();
      paramo.xFw.xGc.addAll(E(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", paramMap));
      AppMethodBeat.o(41512);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void v(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41515);
    paramo.xFM.xGt = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
    paramo.xFM.pXp = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
    paramo.xFM.xGu = Util.getLong((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
    AppMethodBeat.o(41515);
  }
  
  public static void w(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(204174);
    paramo.xFs = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.device_flag"), 0);
    AppMethodBeat.o(204174);
  }
  
  public static void x(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41517);
    paramo.xFN.xGf = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.banner.$banner_id"), "");
    paramo.xFN.xGc.clear();
    paramo.xFN.xGc.addAll(E(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", paramMap));
    AppMethodBeat.o(41517);
  }
  
  public static void y(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(183868);
    paramo.xFQ.xGy = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.$jump_id"), "");
    paramo.xFQ.xGz = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.show_type"), 0);
    paramo.xFQ.xGA = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.not_in_msg_center"), 0);
    paramo.xFQ.xGB = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_icon"), "");
    paramo.xFQ.xGC = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_name"), "");
    paramo.xFQ.xGD = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.$jump_id"), "");
    paramo.xFQ.xGE = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.content_pic"), "");
    paramo.xFQ.xGF = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.first_line_text"), "");
    paramo.xFQ.xGG = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.second_line_text"), "");
    paramo.xFQ.xGH = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_id"), "");
    paramo.xFQ.xGI = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_count"), 0);
    paramo.xFQ.xGJ = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.body_text"), "");
    paramo.xFQ.xGK = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_pic"), "");
    paramo.xFQ.xGL = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_text"), "");
    paramo.xFQ.xGM = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.source_name"), "");
    paramo.xFQ.xGN = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.related_id"), "");
    AppMethodBeat.o(183868);
  }
  
  public static void z(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(204175);
    o.c localc = paramo.xFR;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.gamelife.replace_notice"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localc.dWA = bool;
      if (paramMap.get(".sysmsg.gamecenter.gamelife.chatmsg") == null) {
        break;
      }
      paramo.xFR.xGe = true;
      AppMethodBeat.o(204175);
      return;
    }
    paramo.xFR.xGe = false;
    AppMethodBeat.o(204175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.u
 * JD-Core Version:    0.7.0.1
 */