package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.f;

public final class u
{
  public static u uoA;
  
  public static void A(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(195656);
    paramo.unA.uoe = bu.bI((String)paramMap.get(".sysmsg.gamecenter.tab_info.default_key"), "");
    paramo.unA.uof = bu.bI((String)paramMap.get(".sysmsg.gamecenter.tab_info.red_dot.key"), "");
    if (!bu.isNullOrNil(paramo.unA.uof)) {
      paramo.unA.uog = (paramo.field_createTime + bu.getLong((String)paramMap.get(".sysmsg.gamecenter.tab_info.red_dot.expire_time"), 86400L));
    }
    AppMethodBeat.o(195656);
  }
  
  public static void B(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(195657);
    paramo.unB.unM = f.bfs(bu.bI((String)paramMap.get(".sysmsg.gamecenter.extra_data.preload"), ""));
    if ((!bu.isNullOrNil(paramo.unB.unM)) && (paramo.unB.unM.getBytes().length > 204800)) {
      paramo.unB.unM = "";
    }
    AppMethodBeat.o(195657);
  }
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(41504);
    if (bu.isNullOrNil(paramo.field_rawXML))
    {
      ae.e("MicroMsg.GameNewMessageParser", "msg content is null");
      AppMethodBeat.o(41504);
      return;
    }
    Map localMap = bx.M(paramo.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ae.e("MicroMsg.GameNewMessageParser", "Parse failed");
      AppMethodBeat.o(41504);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ae.e("MicroMsg.GameNewMessageParser", "Type not matched");
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
    paramo.umZ = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41516);
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41505);
    paramo.unm = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
    paramo.unn = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
    paramo.uno = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
    paramo.uns.mContent = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
    paramo.uns.unP = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
    paramo.uns.unQ = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
    paramo.unp = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
    paramo.unq = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
    r(paramMap, paramo);
    h(paramMap, paramo);
    t(paramMap, paramo);
    AppMethodBeat.o(41505);
  }
  
  public static u dbV()
  {
    AppMethodBeat.i(41503);
    if (uoA == null) {
      uoA = new u();
    }
    u localu = uoA;
    AppMethodBeat.o(41503);
    return localu;
  }
  
  private static void f(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41510);
    paramo.umQ.unP = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
    paramo.umQ.mDesc = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
    paramo.umQ.unQ = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
    AppMethodBeat.o(41510);
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41508);
    paramo.umM.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.msg_center.userinfo";; str = ".sysmsg.gamecenter.msg_center.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label278;
      }
      o.k localk = new o.k();
      localk.userName = bu.bI((String)paramMap.get(str + ".username"), "");
      localk.bVF = bu.bI((String)paramMap.get(str + ".nickname"), "");
      localk.unY = bu.bI((String)paramMap.get(str + ".usericon"), "");
      localk.uoa = bu.bI((String)paramMap.get(str + ".badge_icon"), "");
      localk.uob = bu.bI((String)paramMap.get(str + ".$jump_id"), "");
      paramo.umM.add(localk);
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
    paramo.umO.unR = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
    paramo.umO.unP = bu.bI((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
    paramo.umO.mText = bu.bI((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
    paramo.umO.mIconWidth = (bu.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2);
    paramo.umO.mIconHeight = (bu.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2);
    o.f localf = paramo.umO;
    if (bu.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_rounded_corner"), 0) == 1)
    {
      bool1 = true;
      localf.unS = bool1;
      paramo.umO.unT = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.basic_type"), -1);
      paramo = paramo.umO;
      if (bu.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.ignore_local_control"), 0) != 1) {
        break label232;
      }
    }
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.unU = bool1;
      AppMethodBeat.o(41514);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void q(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41506);
    paramo.umR.clear();
    int i = 0;
    if (i == 0) {}
    for (String str1 = ".sysmsg.gamecenter.jump_info.jump";; str1 = ".sysmsg.gamecenter.jump_info.jump" + i)
    {
      if (!paramMap.containsKey(str1)) {
        break label201;
      }
      String str2 = (String)paramMap.get(str1 + ".$id");
      o.g localg = new o.g();
      localg.mJumpType = bu.getInt((String)paramMap.get(str1 + ".jump_type"), 0);
      localg.qqC = bu.bI((String)paramMap.get(str1 + ".jump_url"), "");
      if (!bu.isNullOrNil(str2)) {
        paramo.umR.put(str2, localg);
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
      paramo.unr = new o.i();
      paramo.unr.unV = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
      paramo.unr.unW = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
      paramo.unr.unX = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
      paramo.unr.unQ = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
    }
    AppMethodBeat.o(41507);
  }
  
  public static void s(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41509);
    paramo.unD = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
    paramo.unE = bu.bI((String)paramMap.get(".sysmsg.gamecenter.report.noticeid"), "");
    paramo.unF = bu.bI((String)paramMap.get(".sysmsg.gamecenter.report.ext_data"), "");
    paramo.unG = bu.bI((String)paramMap.get(".sysmsg.gamecenter.report.business_data"), "");
    AppMethodBeat.o(41509);
  }
  
  private static void t(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41511);
    paramo.unt.mName = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
    o.j localj = paramo.unt;
    if (bu.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localj.mClickable = bool;
      paramo.unt.unQ = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
      AppMethodBeat.o(41511);
      return;
    }
  }
  
  public static void u(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41512);
    paramo.une.url = bu.bI((String)paramMap.get(".sysmsg.gamecenter.float_layer.open_url"), "");
    o.a locala = paramo.une;
    if (bu.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.uea = bool1;
      paramo.une.orientation = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
      locala = paramo.une;
      if (bu.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.unK = bool1;
      paramo.une.unL.clear();
      paramo.une.unL.addAll(z(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", paramMap));
      AppMethodBeat.o(41512);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void v(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41515);
    paramo.unu.uoc = bu.bI((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
    paramo.unu.oJB = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
    paramo.unu.uod = bu.getLong((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
    AppMethodBeat.o(41515);
  }
  
  public static void w(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(195654);
    paramo.una = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.device_flag"), 0);
    AppMethodBeat.o(195654);
  }
  
  public static void x(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41517);
    paramo.unv.unO = bu.bI((String)paramMap.get(".sysmsg.gamecenter.banner.$banner_id"), "");
    paramo.unv.unL.clear();
    paramo.unv.unL.addAll(z(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", paramMap));
    AppMethodBeat.o(41517);
  }
  
  public static void y(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(183868);
    paramo.uny.uoh = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.$jump_id"), "");
    paramo.uny.uoi = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.show_type"), 0);
    paramo.uny.uoj = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.not_in_msg_center"), 0);
    paramo.uny.uok = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_icon"), "");
    paramo.uny.uol = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_name"), "");
    paramo.uny.uom = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.$jump_id"), "");
    paramo.uny.uon = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.content_pic"), "");
    paramo.uny.uoo = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.first_line_text"), "");
    paramo.uny.uop = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.second_line_text"), "");
    paramo.uny.uoq = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_id"), "");
    paramo.uny.uor = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_count"), 0);
    paramo.uny.uos = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.body_text"), "");
    paramo.uny.uot = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_pic"), "");
    paramo.uny.uou = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_text"), "");
    paramo.uny.uov = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.source_name"), "");
    AppMethodBeat.o(183868);
  }
  
  private static List<String> z(String paramString, Map<String, String> paramMap)
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
      if (bu.isNullOrNil(str)) {
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
  
  public static void z(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(195655);
    o.c localc = paramo.unz;
    if (bu.getInt((String)paramMap.get(".sysmsg.gamecenter.gamelife.replace_notice"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localc.dEO = bool;
      if (paramMap.get(".sysmsg.gamecenter.gamelife.chatmsg") == null) {
        break;
      }
      paramo.unz.unN = true;
      AppMethodBeat.o(195655);
      return;
    }
    paramo.unz.unN = false;
    AppMethodBeat.o(195655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.u
 * JD-Core Version:    0.7.0.1
 */