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
  public static u CKW;
  
  public static void A(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(190542);
    paramo.CJT.CKy = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.tab_info.default_key"), "");
    paramo.CJT.CKz = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.tab_info.red_dot.key"), "");
    if (!Util.isNullOrNil(paramo.CJT.CKz)) {
      paramo.CJT.CKA = (paramo.field_createTime + Util.getLong((String)paramMap.get(".sysmsg.gamecenter.tab_info.red_dot.expire_time"), 86400L));
    }
    AppMethodBeat.o(190542);
  }
  
  public static void B(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(190549);
    paramo.CJU.CKf = f.bIm(Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.extra_data.preload"), ""));
    if ((!Util.isNullOrNil(paramo.CJU.CKf)) && (paramo.CJU.CKf.getBytes().length > 204800)) {
      paramo.CJU.CKf = "";
    }
    AppMethodBeat.o(190549);
  }
  
  private static List<String> G(String paramString, Map<String, String> paramMap)
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
    paramo.CJs = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41516);
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41505);
    paramo.CJF = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
    paramo.CJG = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
    paramo.CJH = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
    paramo.CJL.mContent = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
    paramo.CJL.CKj = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
    paramo.CJL.CKk = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
    paramo.CJI = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
    paramo.CJJ = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
    r(paramMap, paramo);
    h(paramMap, paramo);
    t(paramMap, paramo);
    AppMethodBeat.o(41505);
  }
  
  public static u eyK()
  {
    AppMethodBeat.i(41503);
    if (CKW == null) {
      CKW = new u();
    }
    u localu = CKW;
    AppMethodBeat.o(41503);
    return localu;
  }
  
  private static void f(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41510);
    paramo.CJj.CKj = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
    paramo.CJj.mDesc = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
    paramo.CJj.CKk = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
    AppMethodBeat.o(41510);
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41508);
    paramo.CJf.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.msg_center.userinfo";; str = ".sysmsg.gamecenter.msg_center.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label278;
      }
      o.l locall = new o.l();
      locall.userName = Util.nullAs((String)paramMap.get(str + ".username"), "");
      locall.nickName = Util.nullAs((String)paramMap.get(str + ".nickname"), "");
      locall.CKs = Util.nullAs((String)paramMap.get(str + ".usericon"), "");
      locall.CKu = Util.nullAs((String)paramMap.get(str + ".badge_icon"), "");
      locall.CKv = Util.nullAs((String)paramMap.get(str + ".$jump_id"), "");
      paramo.CJf.add(locall);
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
    paramo.CJh.CKl = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
    paramo.CJh.CKj = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
    paramo.CJh.mText = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
    paramo.CJh.mIconWidth = (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2);
    paramo.CJh.mIconHeight = (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2);
    o.g localg = paramo.CJh;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_rounded_corner"), 0) == 1)
    {
      bool1 = true;
      localg.CKm = bool1;
      paramo.CJh.CKn = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.basic_type"), -1);
      paramo = paramo.CJh;
      if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.ignore_local_control"), 0) != 1) {
        break label232;
      }
    }
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.CKo = bool1;
      AppMethodBeat.o(41514);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void q(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41506);
    paramo.CJk.clear();
    int i = 0;
    if (i == 0) {}
    for (String str1 = ".sysmsg.gamecenter.jump_info.jump";; str1 = ".sysmsg.gamecenter.jump_info.jump" + i)
    {
      if (!paramMap.containsKey(str1)) {
        break label201;
      }
      String str2 = (String)paramMap.get(str1 + ".$id");
      o.h localh = new o.h();
      localh.mJumpType = Util.getInt((String)paramMap.get(str1 + ".jump_type"), 0);
      localh.vnr = Util.nullAs((String)paramMap.get(str1 + ".jump_url"), "");
      if (!Util.isNullOrNil(str2)) {
        paramo.CJk.put(str2, localh);
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
      paramo.CJK = new o.j();
      paramo.CJK.CKp = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
      paramo.CJK.CKq = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
      paramo.CJK.CKr = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
      paramo.CJK.CKk = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
    }
    AppMethodBeat.o(41507);
  }
  
  public static void s(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41509);
    paramo.CJW = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
    paramo.CJX = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.report.noticeid"), "");
    paramo.CJY = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.report.ext_data"), "");
    paramo.CJZ = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.report.business_data"), "");
    AppMethodBeat.o(41509);
  }
  
  private static void t(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41511);
    paramo.CJM.mName = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
    o.k localk = paramo.CJM;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localk.mClickable = bool;
      paramo.CJM.CKk = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
      AppMethodBeat.o(41511);
      return;
    }
  }
  
  public static void u(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41512);
    paramo.CJx.url = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.float_layer.open_url"), "");
    o.b localb = paramo.CJx;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1)
    {
      bool1 = true;
      localb.CzQ = bool1;
      paramo.CJx.FO = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
      localb = paramo.CJx;
      if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localb.cpf = bool1;
      paramo.CJx.CKe.clear();
      paramo.CJx.CKe.addAll(G(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", paramMap));
      AppMethodBeat.o(41512);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void v(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41515);
    paramo.CJN.CKw = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
    paramo.CJN.ttm = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
    paramo.CJN.CKx = Util.getLong((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
    AppMethodBeat.o(41515);
  }
  
  public static void w(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(190519);
    paramo.CJt = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.device_flag"), 0);
    AppMethodBeat.o(190519);
  }
  
  public static void x(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41517);
    paramo.CJO.CKi = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.banner.$banner_id"), "");
    paramo.CJO.CKe.clear();
    paramo.CJO.CKe.addAll(G(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", paramMap));
    AppMethodBeat.o(41517);
  }
  
  public static void y(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(183868);
    paramo.CJR.CKB = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.$jump_id"), "");
    paramo.CJR.CKC = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.show_type"), 0);
    paramo.CJR.CKD = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.not_in_msg_center"), 0);
    paramo.CJR.CKE = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_icon"), "");
    paramo.CJR.CKF = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_name"), "");
    paramo.CJR.CKG = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.$jump_id"), "");
    paramo.CJR.CKH = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.content_pic"), "");
    paramo.CJR.CKI = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.first_line_text"), "");
    paramo.CJR.CKJ = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.second_line_text"), "");
    paramo.CJR.CKK = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_id"), "");
    paramo.CJR.CKL = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_count"), 0);
    paramo.CJR.CKM = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.body_text"), "");
    paramo.CJR.CKN = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_pic"), "");
    paramo.CJR.CKO = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_text"), "");
    paramo.CJR.CKP = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.source_name"), "");
    paramo.CJR.CKQ = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.related_id"), "");
    AppMethodBeat.o(183868);
  }
  
  public static void z(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(190537);
    o.d locald = paramo.CJS;
    boolean bool;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.gamelife.replace_notice"), 0) == 1)
    {
      bool = true;
      locald.fQf = bool;
      if (paramMap.get(".sysmsg.gamecenter.gamelife.chatmsg") == null) {
        break label97;
      }
    }
    label97:
    for (paramo.CJS.CKg = true;; paramo.CJS.CKg = false)
    {
      paramo.CJS.CKh.CKd = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.gamelife.chatroom.top_chatroom_name"), "");
      AppMethodBeat.o(190537);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.u
 * JD-Core Version:    0.7.0.1
 */