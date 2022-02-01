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
import org.apache.commons.c.h;

public final class u
{
  public static u IFe;
  
  public static void A(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(275433);
    paramo.IEe.IEI = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.tab_info.default_key"), "");
    paramo.IEe.IEJ = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.tab_info.red_dot.key"), "");
    if (!Util.isNullOrNil(paramo.IEe.IEJ)) {
      paramo.IEe.IEK = (paramo.field_createTime + Util.getLong((String)paramMap.get(".sysmsg.gamecenter.tab_info.red_dot.expire_time"), 86400L));
    }
    AppMethodBeat.o(275433);
  }
  
  public static void B(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(275434);
    paramo.IEf.IEq = h.bLg(Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.extra_data.preload"), ""));
    if ((!Util.isNullOrNil(paramo.IEf.IEq)) && (paramo.IEf.IEq.getBytes().length > 204800)) {
      paramo.IEf.IEq = "";
    }
    AppMethodBeat.o(275434);
  }
  
  private static List<String> O(String paramString, Map<String, String> paramMap)
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
    paramo.IDD = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41516);
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41505);
    paramo.IDQ = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
    paramo.IDR = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
    paramo.IDS = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
    paramo.IDW.mContent = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
    paramo.IDW.IEu = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
    paramo.IDW.IEv = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
    paramo.IDT = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
    paramo.IDU = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
    r(paramMap, paramo);
    h(paramMap, paramo);
    t(paramMap, paramo);
    AppMethodBeat.o(41505);
  }
  
  private static void f(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41510);
    paramo.IDu.IEu = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
    paramo.IDu.mDesc = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
    paramo.IDu.IEv = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
    AppMethodBeat.o(41510);
  }
  
  public static u fGG()
  {
    AppMethodBeat.i(41503);
    if (IFe == null) {
      IFe = new u();
    }
    u localu = IFe;
    AppMethodBeat.o(41503);
    return localu;
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41508);
    paramo.IDq.clear();
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
      locall.IED = Util.nullAs((String)paramMap.get(str + ".usericon"), "");
      locall.IEF = Util.nullAs((String)paramMap.get(str + ".badge_icon"), "");
      locall.DUN = Util.nullAs((String)paramMap.get(str + ".$jump_id"), "");
      paramo.IDq.add(locall);
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
    paramo.IDs.IEw = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
    paramo.IDs.IEu = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
    paramo.IDs.mText = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
    paramo.IDs.mIconWidth = (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2);
    paramo.IDs.mIconHeight = (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2);
    o.g localg = paramo.IDs;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_rounded_corner"), 0) == 1)
    {
      bool1 = true;
      localg.IEx = bool1;
      paramo.IDs.IEy = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.basic_type"), -1);
      paramo = paramo.IDs;
      if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.ignore_local_control"), 0) != 1) {
        break label232;
      }
    }
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.IEz = bool1;
      AppMethodBeat.o(41514);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void q(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41506);
    paramo.IDv.clear();
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
      localh.mJumpUrl = Util.nullAs((String)paramMap.get(str1 + ".jump_url"), "");
      if (!Util.isNullOrNil(str2)) {
        paramo.IDv.put(str2, localh);
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
      paramo.IDV = new o.j();
      paramo.IDV.IEA = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
      paramo.IDV.IEB = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
      paramo.IDV.IEC = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
      paramo.IDV.IEv = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
    }
    AppMethodBeat.o(41507);
  }
  
  public static void s(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41509);
    paramo.IEh = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
    paramo.mNoticeId = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.report.noticeid"), "");
    paramo.IEi = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.report.ext_data"), "");
    paramo.IEj = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.report.business_data"), "");
    AppMethodBeat.o(41509);
  }
  
  private static void t(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41511);
    paramo.IDX.mName = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
    o.k localk = paramo.IDX;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localk.mClickable = bool;
      paramo.IDX.IEv = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
      AppMethodBeat.o(41511);
      return;
    }
  }
  
  public static void u(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41512);
    paramo.IDI.url = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.float_layer.open_url"), "");
    o.b localb = paramo.IDI;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1)
    {
      bool1 = true;
      localb.ItB = bool1;
      paramo.IDI.orientation = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
      localb = paramo.IDI;
      if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localb.egT = bool1;
      paramo.IDI.IEp.clear();
      paramo.IDI.IEp.addAll(O(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", paramMap));
      AppMethodBeat.o(41512);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void v(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41515);
    paramo.IDY.IEG = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
    paramo.IDY.wxJ = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
    paramo.IDY.IEH = Util.getLong((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
    AppMethodBeat.o(41515);
  }
  
  public static void w(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(275429);
    paramo.IDE = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.device_flag"), 0);
    AppMethodBeat.o(275429);
  }
  
  public static void x(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41517);
    paramo.IDZ.IEt = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.banner.$banner_id"), "");
    paramo.IDZ.IEp.clear();
    paramo.IDZ.IEp.addAll(O(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", paramMap));
    AppMethodBeat.o(41517);
  }
  
  public static void y(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(183868);
    paramo.IEc.jump_id = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.$jump_id"), "");
    paramo.IEc.show_type = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.show_type"), 0);
    paramo.IEc.IEL = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.not_in_msg_center"), 0);
    paramo.IEc.IEM = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_icon"), "");
    paramo.IEc.IEN = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_name"), "");
    paramo.IEc.IEO = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.$jump_id"), "");
    paramo.IEc.IEP = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.content_pic"), "");
    paramo.IEc.IEQ = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.first_line_text"), "");
    paramo.IEc.IER = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.second_line_text"), "");
    paramo.IEc.IES = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_id"), "");
    paramo.IEc.IET = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_count"), 0);
    paramo.IEc.IEU = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.body_text"), "");
    paramo.IEc.IEV = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_pic"), "");
    paramo.IEc.IEW = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_text"), "");
    paramo.IEc.IEX = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.source_name"), "");
    paramo.IEc.IEY = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.related_id"), "");
    AppMethodBeat.o(183868);
  }
  
  public static void z(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(275432);
    o.d locald = paramo.IEd;
    boolean bool;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.gamelife.replace_notice"), 0) == 1)
    {
      bool = true;
      locald.hWa = bool;
      if (paramMap.get(".sysmsg.gamecenter.gamelife.chatmsg") == null) {
        break label124;
      }
    }
    label124:
    for (paramo.IEd.IEr = true;; paramo.IEd.IEr = false)
    {
      paramo.IEd.IEs.IEn = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.gamelife.chatroom.top_chatroom_name"), "");
      paramo.IEd.IEs.IEo = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.gamelife.chatroom.entrance_open_chatroom_name"), "");
      AppMethodBeat.o(275432);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.u
 * JD-Core Version:    0.7.0.1
 */