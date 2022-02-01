package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class u
{
  public static u tfC;
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(41504);
    if (bs.isNullOrNil(paramo.field_rawXML))
    {
      ac.e("MicroMsg.GameNewMessageParser", "msg content is null");
      AppMethodBeat.o(41504);
      return;
    }
    Map localMap = bv.L(paramo.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ac.e("MicroMsg.GameNewMessageParser", "Parse failed");
      AppMethodBeat.o(41504);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ac.e("MicroMsg.GameNewMessageParser", "Type not matched");
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
    paramo.teh = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41516);
  }
  
  public static u cQE()
  {
    AppMethodBeat.i(41503);
    if (tfC == null) {
      tfC = new u();
    }
    u localu = tfC;
    AppMethodBeat.o(41503);
    return localu;
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41505);
    paramo.teu = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
    paramo.tev = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
    paramo.tew = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
    paramo.teA.mContent = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
    paramo.teA.teS = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
    paramo.teA.teT = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
    paramo.tex = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
    paramo.tey = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
    r(paramMap, paramo);
    h(paramMap, paramo);
    t(paramMap, paramo);
    AppMethodBeat.o(41505);
  }
  
  private static void f(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41510);
    paramo.tdY.teS = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
    paramo.tdY.mDesc = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
    paramo.tdY.teT = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
    AppMethodBeat.o(41510);
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41508);
    paramo.tdU.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.msg_center.userinfo";; str = ".sysmsg.gamecenter.msg_center.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label272;
      }
      o.i locali = new o.i();
      locali.userName = bs.bG((String)paramMap.get(str + ".username"), "");
      locali.bLs = bs.bG((String)paramMap.get(str + ".nickname"), "");
      locali.tfd = bs.bG((String)paramMap.get(str + ".usericon"), "");
      locali.tff = bs.bG((String)paramMap.get(str + ".badge_icon"), "");
      locali.tfg = bs.bG((String)paramMap.get(str + ".$jump_id"), "");
      paramo.tdU.add(locali);
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
    paramo.tdW.teU = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
    paramo.tdW.teS = bs.bG((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
    paramo.tdW.mText = bs.bG((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
    paramo.tdW.teV = (bs.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2);
    paramo.tdW.teW = (bs.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2);
    o.d locald = paramo.tdW;
    if (bs.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_rounded_corner"), 0) == 1)
    {
      bool1 = true;
      locald.teX = bool1;
      paramo.tdW.teY = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.basic_type"), -1);
      paramo = paramo.tdW;
      if (bs.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_show_control.ignore_local_control"), 0) != 1) {
        break label232;
      }
    }
    label232:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.teZ = bool1;
      AppMethodBeat.o(41514);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void q(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41506);
    paramo.tdZ.clear();
    int i = 0;
    if (i == 0) {}
    for (String str1 = ".sysmsg.gamecenter.jump_info.jump";; str1 = ".sysmsg.gamecenter.jump_info.jump" + i)
    {
      if (!paramMap.containsKey(str1)) {
        break label201;
      }
      String str2 = (String)paramMap.get(str1 + ".$id");
      o.e locale = new o.e();
      locale.mJumpType = bs.getInt((String)paramMap.get(str1 + ".jump_type"), 0);
      locale.pGs = bs.bG((String)paramMap.get(str1 + ".jump_url"), "");
      if (!bs.isNullOrNil(str2)) {
        paramo.tdZ.put(str2, locale);
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
      paramo.tez = new o.g();
      paramo.tez.tfa = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
      paramo.tez.tfb = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
      paramo.tez.tfc = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
      paramo.tez.teT = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
    }
    AppMethodBeat.o(41507);
  }
  
  public static void s(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41509);
    paramo.teI = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
    paramo.teJ = bs.bG((String)paramMap.get(".sysmsg.gamecenter.report.noticeid"), "");
    paramo.teK = bs.bG((String)paramMap.get(".sysmsg.gamecenter.report.ext_data"), "");
    paramo.teL = bs.bG((String)paramMap.get(".sysmsg.gamecenter.report.business_data"), "");
    AppMethodBeat.o(41509);
  }
  
  private static void t(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41511);
    paramo.teB.mName = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
    o.h localh = paramo.teB;
    if (bs.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localh.mClickable = bool;
      paramo.teB.teT = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
      AppMethodBeat.o(41511);
      return;
    }
  }
  
  public static void u(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41512);
    paramo.tem.url = bs.bG((String)paramMap.get(".sysmsg.gamecenter.float_layer.open_url"), "");
    o.a locala = paramo.tem;
    if (bs.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.sWB = bool1;
      paramo.tem.orientation = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
      locala = paramo.tem;
      if (bs.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.teP = bool1;
      paramo.tem.teQ.clear();
      paramo.tem.teQ.addAll(w(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", paramMap));
      AppMethodBeat.o(41512);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void v(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41515);
    paramo.teC.tfh = bs.bG((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
    paramo.teC.nZF = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
    paramo.teC.tfi = bs.getLong((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
    AppMethodBeat.o(41515);
  }
  
  private static List<String> w(String paramString, Map<String, String> paramMap)
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
      if (bs.isNullOrNil(str)) {
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
  
  public static void w(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(199229);
    paramo.tei = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.device_flag"), 0);
    AppMethodBeat.o(199229);
  }
  
  public static void x(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41517);
    paramo.teD.teR = bs.bG((String)paramMap.get(".sysmsg.gamecenter.banner.$banner_id"), "");
    paramo.teD.teQ.clear();
    paramo.teD.teQ.addAll(w(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", paramMap));
    AppMethodBeat.o(41517);
  }
  
  public static void y(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(183868);
    paramo.teG.tfj = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.$jump_id"), "");
    paramo.teG.tfk = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.show_type"), 0);
    paramo.teG.tfl = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.not_in_msg_center"), 0);
    paramo.teG.tfm = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_icon"), "");
    paramo.teG.tfn = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.sender_name"), "");
    paramo.teG.tfo = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.msg_sender.$jump_id"), "");
    paramo.teG.tfp = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.content_pic"), "");
    paramo.teG.tfq = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.first_line_text"), "");
    paramo.teG.tfr = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.notify_msg_content.second_line_text"), "");
    paramo.teG.tfs = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_id"), "");
    paramo.teG.tft = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.merge_count"), 0);
    paramo.teG.tfu = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.body_text"), "");
    paramo.teG.tfv = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_pic"), "");
    paramo.teG.tfw = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.right_text"), "");
    paramo.teG.tfx = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_center_v2.interactive_msg_content.source_name"), "");
    AppMethodBeat.o(183868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.u
 * JD-Core Version:    0.7.0.1
 */