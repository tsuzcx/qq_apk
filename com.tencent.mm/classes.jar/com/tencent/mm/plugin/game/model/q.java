package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.LinkedList;
import java.util.Map;

public final class q
{
  public static String Z(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41464);
    paramMap = bt.by((String)paramMap.get(".sysmsg.gamecenter.formatcontent"), "");
    AppMethodBeat.o(41464);
    return paramMap;
  }
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(41463);
    if (bt.isNullOrNil(paramo.field_rawXML))
    {
      ad.e("MicroMsg.GameMessageParser", "msg content is null");
      AppMethodBeat.o(41463);
      return;
    }
    Map localMap = bw.K(paramo.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ad.e("MicroMsg.GameMessageParser", "Parse failed");
      AppMethodBeat.o(41463);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ad.e("MicroMsg.GameMessageParser", "Type not matched");
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
    AppMethodBeat.i(196756);
    if ((paramo == null) || (paramMap == null))
    {
      AppMethodBeat.o(196756);
      return;
    }
    if (paramo.rWQ == 0) {
      paramo.rWQ = paramo.field_msgType;
    }
    b(paramMap, paramo);
    AppMethodBeat.o(196756);
  }
  
  public static long aa(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41472);
    long l = bt.getLong((String)paramMap.get(".sysmsg.game_control_info.control_flag"), 0L);
    AppMethodBeat.o(41472);
    return l;
  }
  
  public static void b(o paramo)
  {
    AppMethodBeat.i(196755);
    if (bt.isNullOrNil(paramo.field_rawXML))
    {
      ad.e("MicroMsg.GameMessageParser", "msg content is null");
      AppMethodBeat.o(196755);
      return;
    }
    Map localMap = bw.K(paramo.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ad.e("MicroMsg.GameMessageParser", "Parse failed");
      AppMethodBeat.o(196755);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ad.e("MicroMsg.GameMessageParser", "Type not matched");
      AppMethodBeat.o(196755);
      return;
    }
    a(localMap, paramo);
    AppMethodBeat.o(196755);
  }
  
  private static void b(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(196757);
    paramo.rWN.gPO = bt.by((String)paramMap.get(".sysmsg.report_rule.$report_id"), "");
    paramo.rWN.rXG = bt.getInt((String)paramMap.get(".sysmsg.report_rule.report_mode"), 0);
    AppMethodBeat.o(196757);
  }
  
  private static void c(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41465);
    paramo.rWp = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41465);
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41466);
    paramo.oAY = Z(paramMap);
    paramo.rVU = bt.by((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    paramo.rWi = bt.by((String)paramMap.get(".sysmsg.gamecenter.msg_picture_url"), "");
    paramo.rVV = bt.by((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
    if (bt.isNullOrNil(paramo.rVV)) {
      paramo.rVV = bt.by((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    }
    paramo.rWP = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.notify_type"), 0);
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
      ad.e("MicroMsg.GameMessageParser", "error gamecenter type: " + paramo.field_msgType);
      AppMethodBeat.o(41467);
      return;
    case 10: 
    case 11: 
      AppMethodBeat.o(41467);
      return;
    case 2: 
      l(paramMap, paramo);
      ad.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", new Object[] { paramo.field_appId });
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
    paramo.rWj = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
    paramo.rWg.rXa = bt.by((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
    paramo.rWg.mDesc = bt.by((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
    AppMethodBeat.o(41468);
  }
  
  private static void g(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41469);
    paramo.mAppName = bt.by((String)paramMap.get(".sysmsg.gamecenter.appinfo.appname2"), "");
    if (bt.isNullOrNil(paramo.mAppName)) {
      paramo.mAppName = bt.by((String)paramMap.get(".sysmsg.gamecenter.appinfo.appname"), "");
    }
    if (paramo.field_msgType == 6)
    {
      paramo.rWa = bt.by((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupname"), "");
      paramo.rWb = bt.by((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
    }
    for (;;)
    {
      paramo.rVW = bt.by((String)paramMap.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
      paramo.rVX = bt.by((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
      paramo.rVY = bt.by((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
      paramo.rVZ = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
      AppMethodBeat.o(41469);
      return;
      paramo.rWa = paramo.mAppName;
    }
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41470);
    paramo.rWc.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.userinfo";; str = ".sysmsg.gamecenter.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label278;
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
    label278:
    AppMethodBeat.o(41470);
  }
  
  private static void i(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41471);
    paramo.rWR = bt.by((String)paramMap.get(".sysmsg.gamecenter.noticeid"), "");
    AppMethodBeat.o(41471);
  }
  
  private static void j(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41473);
    paramo.rWr = aa(paramMap);
    AppMethodBeat.o(41473);
  }
  
  private static void k(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41474);
    paramo.rWe.rXc = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.badge_display_type"), 0);
    paramo.rWe.rXa = bt.by((String)paramMap.get(".sysmsg.gamecenter.showiconurl"), "");
    paramo.rWe.mText = bt.by((String)paramMap.get(".sysmsg.gamecenter.entrancetext"), "");
    AppMethodBeat.o(41474);
  }
  
  private static void l(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41475);
    paramo.rWk = bt.getInt((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
    paramo.rWl = bt.getInt((String)paramMap.get(".sysmsg.game_control_info.display_name_type"), 1);
    paramo.rWm = bt.by((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
    paramo.rWn = bt.by((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
    paramo.rWo = bt.by((String)paramMap.get(".sysmsg.gameshare.share_message_info.media_url"), "");
    paramo.rWi = bt.by((String)paramMap.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
    AppMethodBeat.o(41475);
  }
  
  public static void m(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41476);
    paramo.rWu.url = bt.by((String)paramMap.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
    o.a locala = paramo.rWu;
    if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.rOL = bool1;
      paramo.rWu.orientation = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
      paramo = paramo.rWu;
      if (bt.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
        break label133;
      }
    }
    label133:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.rWX = bool1;
      AppMethodBeat.o(41476);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void n(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41477);
    paramo.rWz = bt.by((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
    paramo.rWA = bt.by((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
    paramo.rWB = bt.by((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
    AppMethodBeat.o(41477);
  }
  
  private static void o(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41478);
    paramo.rWv = bt.by((String)paramMap.get(".sysmsg.gamecenter.topic.reply_content"), "");
    paramo.rWw = bt.by((String)paramMap.get(".sysmsg.gamecenter.topic.replied_content"), "");
    paramo.rWy = bt.by((String)paramMap.get(".sysmsg.gamecenter.topic.topic_title"), "");
    paramo.rWx = bt.by((String)paramMap.get(".sysmsg.gamecenter.topic.topic_url"), "");
    AppMethodBeat.o(41478);
  }
  
  private static void p(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41479);
    paramo.rWU = bt.getInt((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
    paramo.rWV = bt.by((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
    AppMethodBeat.o(41479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.q
 * JD-Core Version:    0.7.0.1
 */