package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class u
{
  public static u noo;
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(111339);
    if (bo.isNullOrNil(paramn.field_rawXML))
    {
      ab.e("MicroMsg.GameNewMessageParser", "msg content is null");
      AppMethodBeat.o(111339);
      return;
    }
    Map localMap = br.F(paramn.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ab.e("MicroMsg.GameNewMessageParser", "Parse failed");
      AppMethodBeat.o(111339);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ab.e("MicroMsg.GameNewMessageParser", "Type not matched");
      AppMethodBeat.o(111339);
      return;
    }
    b(localMap, paramn);
    o(localMap, paramn);
    q(localMap, paramn);
    d(localMap, paramn);
    s(localMap, paramn);
    i(localMap, paramn);
    t(localMap, paramn);
    a(localMap, paramn);
    u(localMap, paramn);
    AppMethodBeat.o(111339);
  }
  
  private static void a(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111351);
    paramn.nnm = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(111351);
  }
  
  private static void b(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111340);
    paramn.nny = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
    paramn.nnz = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
    paramn.nnA = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
    paramn.nnE.mContent = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
    paramn.nnE.nnT = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
    paramn.nnE.nnU = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
    paramn.nnB = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
    paramn.nnC = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
    p(paramMap, paramn);
    f(paramMap, paramn);
    r(paramMap, paramn);
    AppMethodBeat.o(111340);
  }
  
  public static u bGy()
  {
    AppMethodBeat.i(111338);
    if (noo == null) {
      noo = new u();
    }
    u localu = noo;
    AppMethodBeat.o(111338);
    return localu;
  }
  
  private static void d(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111345);
    paramn.nnd.nnT = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
    paramn.nnd.mDesc = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
    paramn.nnd.nnU = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
    AppMethodBeat.o(111345);
  }
  
  private static void f(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111343);
    paramn.nmZ.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.msg_center.userinfo";; str = ".sysmsg.gamecenter.msg_center.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label270;
      }
      n.i locali = new n.i();
      locali.userName = bo.bf((String)paramMap.get(str + ".username"), "");
      locali.blZ = bo.bf((String)paramMap.get(str + ".nickname"), "");
      locali.noc = bo.bf((String)paramMap.get(str + ".usericon"), "");
      locali.noe = bo.bf((String)paramMap.get(str + ".badge_icon"), "");
      locali.nof = bo.bf((String)paramMap.get(str + ".$jump_id"), "");
      paramn.nmZ.add(locali);
      i += 1;
      break;
    }
    label270:
    AppMethodBeat.o(111343);
  }
  
  public static void i(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111349);
    paramn.nnb.nnV = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
    paramn.nnb.nnT = bo.bf((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
    paramn.nnb.mText = bo.bf((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
    paramn.nnb.nnW = (bo.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2);
    paramn.nnb.nnX = (bo.getInt((String)paramMap.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2);
    AppMethodBeat.o(111349);
  }
  
  private static void o(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111341);
    paramn.nne.clear();
    int i = 0;
    if (i == 0) {}
    for (String str1 = ".sysmsg.gamecenter.jump_info.jump";; str1 = ".sysmsg.gamecenter.jump_info.jump" + i)
    {
      if (!paramMap.containsKey(str1)) {
        break label201;
      }
      String str2 = (String)paramMap.get(str1 + ".$id");
      n.e locale = new n.e();
      locale.mJumpType = bo.getInt((String)paramMap.get(str1 + ".jump_type"), 0);
      locale.lMw = bo.bf((String)paramMap.get(str1 + ".jump_url"), "");
      if (!bo.isNullOrNil(str2)) {
        paramn.nne.put(str2, locale);
      }
      i += 1;
      break;
    }
    label201:
    AppMethodBeat.o(111341);
  }
  
  private static void p(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111342);
    if (paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender") != null)
    {
      paramn.nnD = new n.g();
      paramn.nnD.nnY = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
      paramn.nnD.nnZ = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
      paramn.nnD.noa = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
      paramn.nnD.nnU = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
    }
    AppMethodBeat.o(111342);
  }
  
  private static List<String> q(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(111348);
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
      if (bo.isNullOrNil(str)) {
        break;
      }
      localArrayList.add(str);
      i = j;
      break;
    }
    label119:
    AppMethodBeat.o(111348);
    return localArrayList;
  }
  
  public static void q(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111344);
    paramn.nnL = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
    paramn.nnM = bo.bf((String)paramMap.get(".sysmsg.gamecenter.report.noticeid"), "");
    AppMethodBeat.o(111344);
  }
  
  private static void r(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111346);
    paramn.nnF.mName = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
    n.h localh = paramn.nnF;
    if (bo.getInt((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localh.nob = bool;
      paramn.nnF.nnU = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
      AppMethodBeat.o(111346);
      return;
    }
  }
  
  public static void s(Map<String, String> paramMap, n paramn)
  {
    boolean bool2 = true;
    AppMethodBeat.i(111347);
    paramn.nnq.url = bo.bf((String)paramMap.get(".sysmsg.gamecenter.float_layer.open_url"), "");
    n.a locala = paramn.nnq;
    if (bo.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.njd = bool1;
      paramn.nnq.orientation = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
      locala = paramn.nnq;
      if (bo.getInt((String)paramMap.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
        break label167;
      }
    }
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.nnQ = bool1;
      paramn.nnq.nnR.clear();
      paramn.nnq.nnR.addAll(q(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", paramMap));
      AppMethodBeat.o(111347);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void t(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111350);
    paramn.nnG.nog = bo.bf((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
    paramn.nnG.krm = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
    paramn.nnG.noh = bo.getLong((String)paramMap.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0L);
    AppMethodBeat.o(111350);
  }
  
  public static void u(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111352);
    paramn.nnH.nnS = bo.bf((String)paramMap.get(".sysmsg.gamecenter.banner.$banner_id"), "");
    paramn.nnH.nnR.clear();
    paramn.nnH.nnR.addAll(q(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", paramMap));
    AppMethodBeat.o(111352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.u
 * JD-Core Version:    0.7.0.1
 */