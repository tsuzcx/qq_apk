package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.LinkedList;
import java.util.Map;

public final class q
{
  public static void a(o paramo)
  {
    AppMethodBeat.i(41463);
    if (bs.isNullOrNil(paramo.field_rawXML))
    {
      ac.e("MicroMsg.GameMessageParser", "msg content is null");
      AppMethodBeat.o(41463);
      return;
    }
    Map localMap = bv.L(paramo.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ac.e("MicroMsg.GameMessageParser", "Parse failed");
      AppMethodBeat.o(41463);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ac.e("MicroMsg.GameMessageParser", "Type not matched");
      AppMethodBeat.o(41463);
      return;
    }
    c(localMap, paramo);
    d(localMap, paramo);
    g(localMap, paramo);
    h(localMap, paramo);
    i(localMap, paramo);
    j(localMap, paramo);
    k(localMap, paramo);
    m(localMap, paramo);
    f(localMap, paramo);
    p(localMap, paramo);
    e(localMap, paramo);
    a(localMap, paramo);
    AppMethodBeat.o(41463);
  }
  
  public static void a(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(199226);
    if ((paramo == null) || (paramMap == null))
    {
      AppMethodBeat.o(199226);
      return;
    }
    if (paramo.teI == 0) {
      paramo.teI = paramo.field_msgType;
    }
    b(paramMap, paramo);
    AppMethodBeat.o(199226);
  }
  
  public static String aa(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41464);
    paramMap = bs.bG((String)paramMap.get(".sysmsg.gamecenter.formatcontent"), "");
    AppMethodBeat.o(41464);
    return paramMap;
  }
  
  public static long ab(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41472);
    long l = bs.getLong((String)paramMap.get(".sysmsg.game_control_info.control_flag"), 0L);
    AppMethodBeat.o(41472);
    return l;
  }
  
  public static void b(o paramo)
  {
    AppMethodBeat.i(199225);
    if (bs.isNullOrNil(paramo.field_rawXML))
    {
      ac.e("MicroMsg.GameMessageParser", "msg content is null");
      AppMethodBeat.o(199225);
      return;
    }
    Map localMap = bv.L(paramo.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ac.e("MicroMsg.GameMessageParser", "Parse failed");
      AppMethodBeat.o(199225);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ac.e("MicroMsg.GameMessageParser", "Type not matched");
      AppMethodBeat.o(199225);
      return;
    }
    a(localMap, paramo);
    AppMethodBeat.o(199225);
  }
  
  private static void b(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(199227);
    paramo.teF.hqo = bs.bG((String)paramMap.get(".sysmsg.report_rule.$report_id"), "");
    paramo.teF.tfy = bs.getInt((String)paramMap.get(".sysmsg.report_rule.report_mode"), 0);
    AppMethodBeat.o(199227);
  }
  
  private static void c(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41465);
    paramo.teh = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41465);
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41466);
    paramo.pey = aa(paramMap);
    paramo.tdM = bs.bG((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    paramo.tea = bs.bG((String)paramMap.get(".sysmsg.gamecenter.msg_picture_url"), "");
    paramo.tdN = bs.bG((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
    if (bs.isNullOrNil(paramo.tdN)) {
      paramo.tdN = bs.bG((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    }
    paramo.teH = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.notify_type"), 0);
    AppMethodBeat.o(41466);
  }
  
  private static void e(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41467);
    switch (paramo.field_msgType)
    {
    case 3: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      ac.e("MicroMsg.GameMessageParser", "error gamecenter type: " + paramo.field_msgType);
      AppMethodBeat.o(41467);
      return;
    case 10: 
    case 11: 
      AppMethodBeat.o(41467);
      return;
    case 2: 
      l(paramMap, paramo);
      ac.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", new Object[] { paramo.field_appId });
      AppMethodBeat.o(41467);
      return;
    case 4: 
      AppMethodBeat.o(41467);
      return;
    case 5: 
      n(paramMap, paramo);
      AppMethodBeat.o(41467);
      return;
    }
    o(paramMap, paramo);
    AppMethodBeat.o(41467);
  }
  
  private static void f(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41468);
    paramo.teb = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
    paramo.tdY.teS = bs.bG((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
    paramo.tdY.mDesc = bs.bG((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
    AppMethodBeat.o(41468);
  }
  
  private static void g(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41469);
    paramo.mAppName = bs.bG((String)paramMap.get(".sysmsg.gamecenter.appinfo.appname2"), "");
    if (bs.isNullOrNil(paramo.mAppName)) {
      paramo.mAppName = bs.bG((String)paramMap.get(".sysmsg.gamecenter.appinfo.appname"), "");
    }
    if (paramo.field_msgType == 6)
    {
      paramo.tdS = bs.bG((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupname"), "");
      paramo.tdT = bs.bG((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
    }
    for (;;)
    {
      paramo.tdO = bs.bG((String)paramMap.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
      paramo.tdP = bs.bG((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
      paramo.tdQ = bs.bG((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
      paramo.tdR = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
      AppMethodBeat.o(41469);
      return;
      paramo.tdS = paramo.mAppName;
    }
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41470);
    paramo.tdU.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.userinfo";; str = ".sysmsg.gamecenter.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label278;
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
    label278:
    AppMethodBeat.o(41470);
  }
  
  private static void i(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41471);
    paramo.teJ = bs.bG((String)paramMap.get(".sysmsg.gamecenter.noticeid"), "");
    AppMethodBeat.o(41471);
  }
  
  private static void j(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41473);
    paramo.tej = ab(paramMap);
    AppMethodBeat.o(41473);
  }
  
  private static void k(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41474);
    paramo.tdW.teU = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.badge_display_type"), 0);
    paramo.tdW.teS = bs.bG((String)paramMap.get(".sysmsg.gamecenter.showiconurl"), "");
    paramo.tdW.mText = bs.bG((String)paramMap.get(".sysmsg.gamecenter.entrancetext"), "");
    AppMethodBeat.o(41474);
  }
  
  private static void l(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41475);
    paramo.tec = bs.getInt((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
    paramo.ted = bs.getInt((String)paramMap.get(".sysmsg.game_control_info.display_name_type"), 1);
    paramo.tee = bs.bG((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
    paramo.tef = bs.bG((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
    paramo.teg = bs.bG((String)paramMap.get(".sysmsg.gameshare.share_message_info.media_url"), "");
    paramo.tea = bs.bG((String)paramMap.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
    AppMethodBeat.o(41475);
  }
  
  public static void m(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41476);
    paramo.tem.url = bs.bG((String)paramMap.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
    o.a locala = paramo.tem;
    if (bs.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.sWB = bool1;
      paramo.tem.orientation = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
      paramo = paramo.tem;
      if (bs.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
        break label133;
      }
    }
    label133:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.teP = bool1;
      AppMethodBeat.o(41476);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void n(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41477);
    paramo.ter = bs.bG((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
    paramo.tes = bs.bG((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
    paramo.tet = bs.bG((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
    AppMethodBeat.o(41477);
  }
  
  private static void o(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41478);
    paramo.ten = bs.bG((String)paramMap.get(".sysmsg.gamecenter.topic.reply_content"), "");
    paramo.teo = bs.bG((String)paramMap.get(".sysmsg.gamecenter.topic.replied_content"), "");
    paramo.teq = bs.bG((String)paramMap.get(".sysmsg.gamecenter.topic.topic_title"), "");
    paramo.tep = bs.bG((String)paramMap.get(".sysmsg.gamecenter.topic.topic_url"), "");
    AppMethodBeat.o(41478);
  }
  
  private static void p(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41479);
    paramo.teM = bs.getInt((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
    paramo.teN = bs.bG((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
    AppMethodBeat.o(41479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.q
 * JD-Core Version:    0.7.0.1
 */