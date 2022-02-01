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
  public static u uds;
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(41504);
    if (bt.isNullOrNil(paramo.field_rawXML))
    {
      ad.e("MicroMsg.GameNewMessageParser", "msg content is null");
      AppMethodBeat.o(41504);
      return;
    }
    Map localMap = bw.M(paramo.field_rawXML, "sysmsg");
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
    z(localMap, paramo);
    AppMethodBeat.o(41504);
  }
  
  private static void c(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41516);
    paramo.ubX = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41516);
  }
  
  public static u cZk()
  {
    AppMethodBeat.i(41503);
    if (uds == null) {
      uds = new u();
    }
    u localu = uds;
    AppMethodBeat.o(41503);
    return localu;
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41505);
    paramo.uck = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
    paramo.ucl = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
    paramo.ucm = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
    paramo.ucq.mContent = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
    paramo.ucq.ucK = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
    paramo.ucq.ucL = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
    paramo.ucn = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
    paramo.uco = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
    r(paramMap, paramo);
    h(paramMap, paramo);
    t(paramMap, paramo);
    AppMethodBeat.o(41505);
  }
  
  private static void f(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41510);
    paramo.ubO.ucK = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
    paramo.ubO.mDesc = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
    paramo.ubO.ucL = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
    AppMethodBeat.o(41510);
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41508);
    paramo.ubK.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.msg_center.userinfo";; str = ".sysmsg.gamecenter.msg_center.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label272;
      }
      o.j localj = new o.j();
      localj.userName = bt.bI((String)paramMap.get(str + ".username"), "");
      localj.bVF = bt.bI((String)paramMap.get(str + ".nickname"), "");
      localj.ucT = bt.bI((String)paramMap.get(str + ".usericon"), "");
      localj.ucV = bt.bI((String)paramMap.get(str + ".badge_icon"), "");
      localj.ucW = bt.bI((String)paramMap.get(str + ".$jump_id"), "");
      paramo.ubK.add(localj);
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
    paramo.ubM.ucM = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
    paramo.ubM.ucK = bt.bI((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
    paramo.ubM.mText = bt.bI((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
    paramo.ubM.mIconWidth = (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2);
    paramo.ubM.mIconHeight = (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2);
    o.e locale = paramo.ubM;
    if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_rounded_corner"), 0) == 1)
    {
      bool1 = true;
      locale.ucN = bool1;
      paramo.ubM.ucO = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.basic_type"), -1);
      paramo = paramo.ubM;
      if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.ignore_local_control"), 0) != 1) {
        break label232;
      }
    }
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.ucP = bool1;
      AppMethodBeat.o(41514);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void q(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41506);
    paramo.ubP.clear();
    int i = 0;
    if (i == 0) {}
    for (String str1 = ".sysmsg.gamecenter.jump_info.jump";; str1 = ".sysmsg.gamecenter.jump_info.jump" + i)
    {
      if (!paramMap.containsKey(str1)) {
        break label201;
      }
      String str2 = (String)paramMap.get(str1 + ".$id");
      o.f localf = new o.f();
      localf.mJumpType = bt.getInt((String)paramMap.get(str1 + ".jump_type"), 0);
      localf.qjX = bt.bI((String)paramMap.get(str1 + ".jump_url"), "");
      if (!bt.isNullOrNil(str2)) {
        paramo.ubP.put(str2, localf);
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
      paramo.ucp = new o.h();
      paramo.ucp.ucQ = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
      paramo.ucp.ucR = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
      paramo.ucp.ucS = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
      paramo.ucp.ucL = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
    }
    AppMethodBeat.o(41507);
  }
  
  public static void s(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41509);
    paramo.ucz = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
    paramo.ucA = bt.bI((String)paramMap.get(".sysmsg.gamecenter.report.noticeid"), "");
    paramo.ucB = bt.bI((String)paramMap.get(".sysmsg.gamecenter.report.ext_data"), "");
    paramo.ucC = bt.bI((String)paramMap.get(".sysmsg.gamecenter.report.business_data"), "");
    AppMethodBeat.o(41509);
  }
  
  private static void t(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41511);
    paramo.ucr.mName = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
    o.i locali = paramo.ucr;
    if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      locali.mClickable = bool;
      paramo.ucr.ucL = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
      AppMethodBeat.o(41511);
      return;
    }
  }
  
  public static void u(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41512);
    paramo.ucc.url = bt.bI((String)paramMap.get(".sysmsg.gamecenter.float_layer.open_url"), "");
    o.a locala = paramo.ucc;
    if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.tTj = bool1;
      paramo.ucc.orientation = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
      locala = paramo.ucc;
      if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.ucG = bool1;
      paramo.ucc.ucH.clear();
      paramo.ucc.ucH.addAll(y(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", paramMap));
      AppMethodBeat.o(41512);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void v(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41515);
    paramo.ucs.ucX = bt.bI((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
    paramo.ucs.oCZ = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
    paramo.ucs.ucY = bt.getLong((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
    AppMethodBeat.o(41515);
  }
  
  public static void w(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(206834);
    paramo.ubY = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.device_flag"), 0);
    AppMethodBeat.o(206834);
  }
  
  public static void x(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41517);
    paramo.uct.ucJ = bt.bI((String)paramMap.get(".sysmsg.gamecenter.banner.$banner_id"), "");
    paramo.uct.ucH.clear();
    paramo.uct.ucH.addAll(y(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", paramMap));
    AppMethodBeat.o(41517);
  }
  
  private static List<String> y(String paramString, Map<String, String> paramMap)
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
  
  public static void y(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(183868);
    paramo.ucw.ucZ = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.$jump_id"), "");
    paramo.ucw.uda = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.show_type"), 0);
    paramo.ucw.udb = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.not_in_msg_center"), 0);
    paramo.ucw.udc = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_icon"), "");
    paramo.ucw.udd = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_name"), "");
    paramo.ucw.ude = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.$jump_id"), "");
    paramo.ucw.udf = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.content_pic"), "");
    paramo.ucw.udg = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.first_line_text"), "");
    paramo.ucw.udh = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.second_line_text"), "");
    paramo.ucw.udi = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_id"), "");
    paramo.ucw.udj = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_count"), 0);
    paramo.ucw.udk = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.body_text"), "");
    paramo.ucw.udl = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_pic"), "");
    paramo.ucw.udm = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_text"), "");
    paramo.ucw.udn = bt.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.source_name"), "");
    AppMethodBeat.o(183868);
  }
  
  public static void z(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(206835);
    o.b localb = paramo.ucx;
    if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.gamelife.replace_notice"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.dDJ = bool;
      if (paramMap.get(".sysmsg.gamecenter.gamelife.chatmsg") == null) {
        break;
      }
      paramo.ucx.ucI = true;
      AppMethodBeat.o(206835);
      return;
    }
    paramo.ucx.ucI = false;
    AppMethodBeat.o(206835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.u
 * JD-Core Version:    0.7.0.1
 */