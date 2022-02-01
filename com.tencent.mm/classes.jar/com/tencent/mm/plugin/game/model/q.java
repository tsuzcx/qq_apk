package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.LinkedList;
import java.util.Map;

public final class q
{
  public static void a(o paramo)
  {
    AppMethodBeat.i(41463);
    if (bu.isNullOrNil(paramo.field_rawXML))
    {
      ae.e("MicroMsg.GameMessageParser", "msg content is null");
      AppMethodBeat.o(41463);
      return;
    }
    Map localMap = bx.M(paramo.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ae.e("MicroMsg.GameMessageParser", "Parse failed");
      AppMethodBeat.o(41463);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ae.e("MicroMsg.GameMessageParser", "Type not matched");
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
    AppMethodBeat.i(195646);
    if ((paramo == null) || (paramMap == null))
    {
      AppMethodBeat.o(195646);
      return;
    }
    if (paramo.unD == 0) {
      paramo.unD = paramo.field_msgType;
    }
    b(paramMap, paramo);
    AppMethodBeat.o(195646);
  }
  
  public static String ak(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41464);
    paramMap = bu.bI((String)paramMap.get(".sysmsg.gamecenter.formatcontent"), "");
    AppMethodBeat.o(41464);
    return paramMap;
  }
  
  public static long al(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41472);
    long l = bu.getLong((String)paramMap.get(".sysmsg.game_control_info.control_flag"), 0L);
    AppMethodBeat.o(41472);
    return l;
  }
  
  public static void b(o paramo)
  {
    AppMethodBeat.i(195645);
    if (bu.isNullOrNil(paramo.field_rawXML))
    {
      ae.e("MicroMsg.GameMessageParser", "msg content is null");
      AppMethodBeat.o(195645);
      return;
    }
    Map localMap = bx.M(paramo.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ae.e("MicroMsg.GameMessageParser", "Parse failed");
      AppMethodBeat.o(195645);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ae.e("MicroMsg.GameMessageParser", "Type not matched");
      AppMethodBeat.o(195645);
      return;
    }
    a(localMap, paramo);
    AppMethodBeat.o(195645);
  }
  
  private static void b(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(195647);
    paramo.unx.hLz = bu.bI((String)paramMap.get(".sysmsg.report_rule.$report_id"), "");
    paramo.unx.uow = bu.getInt((String)paramMap.get(".sysmsg.report_rule.report_mode"), 0);
    AppMethodBeat.o(195647);
  }
  
  private static void c(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41465);
    paramo.umZ = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41465);
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41466);
    paramo.pOE = ak(paramMap);
    paramo.umE = bu.bI((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    paramo.umS = bu.bI((String)paramMap.get(".sysmsg.gamecenter.msg_picture_url"), "");
    paramo.umF = bu.bI((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
    if (bu.isNullOrNil(paramo.umF)) {
      paramo.umF = bu.bI((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    }
    paramo.unC = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.notify_type"), 0);
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
      ae.e("MicroMsg.GameMessageParser", "error gamecenter type: " + paramo.field_msgType);
      AppMethodBeat.o(41467);
      return;
    case 10: 
    case 11: 
      AppMethodBeat.o(41467);
      return;
    case 2: 
      l(paramMap, paramo);
      ae.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", new Object[] { paramo.field_appId });
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
    paramo.umT = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
    paramo.umQ.unP = bu.bI((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
    paramo.umQ.mDesc = bu.bI((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
    AppMethodBeat.o(41468);
  }
  
  private static void g(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41469);
    paramo.mAppName = bu.bI((String)paramMap.get(".sysmsg.gamecenter.appinfo.appname2"), "");
    if (bu.isNullOrNil(paramo.mAppName)) {
      paramo.mAppName = bu.bI((String)paramMap.get(".sysmsg.gamecenter.appinfo.appname"), "");
    }
    if (paramo.field_msgType == 6)
    {
      paramo.umK = bu.bI((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupname"), "");
      paramo.umL = bu.bI((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
    }
    for (;;)
    {
      paramo.umG = bu.bI((String)paramMap.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
      paramo.umH = bu.bI((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
      paramo.umI = bu.bI((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
      paramo.umJ = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
      AppMethodBeat.o(41469);
      return;
      paramo.umK = paramo.mAppName;
    }
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41470);
    paramo.umM.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.userinfo";; str = ".sysmsg.gamecenter.userinfo" + i)
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
    AppMethodBeat.o(41470);
  }
  
  private static void i(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41471);
    paramo.unE = bu.bI((String)paramMap.get(".sysmsg.gamecenter.noticeid"), "");
    AppMethodBeat.o(41471);
  }
  
  private static void j(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41473);
    paramo.unb = al(paramMap);
    AppMethodBeat.o(41473);
  }
  
  private static void k(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41474);
    paramo.umO.unR = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.badge_display_type"), 0);
    paramo.umO.unP = bu.bI((String)paramMap.get(".sysmsg.gamecenter.showiconurl"), "");
    paramo.umO.mText = bu.bI((String)paramMap.get(".sysmsg.gamecenter.entrancetext"), "");
    AppMethodBeat.o(41474);
  }
  
  private static void l(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41475);
    paramo.umU = bu.getInt((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
    paramo.umV = bu.getInt((String)paramMap.get(".sysmsg.game_control_info.display_name_type"), 1);
    paramo.umW = bu.bI((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
    paramo.umX = bu.bI((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
    paramo.umY = bu.bI((String)paramMap.get(".sysmsg.gameshare.share_message_info.media_url"), "");
    paramo.umS = bu.bI((String)paramMap.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
    AppMethodBeat.o(41475);
  }
  
  public static void m(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41476);
    paramo.une.url = bu.bI((String)paramMap.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
    o.a locala = paramo.une;
    if (bu.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.uea = bool1;
      paramo.une.orientation = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
      paramo = paramo.une;
      if (bu.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
        break label133;
      }
    }
    label133:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.unK = bool1;
      AppMethodBeat.o(41476);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void n(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41477);
    paramo.unj = bu.bI((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
    paramo.unk = bu.bI((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
    paramo.unl = bu.bI((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
    AppMethodBeat.o(41477);
  }
  
  private static void o(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41478);
    paramo.unf = bu.bI((String)paramMap.get(".sysmsg.gamecenter.topic.reply_content"), "");
    paramo.ung = bu.bI((String)paramMap.get(".sysmsg.gamecenter.topic.replied_content"), "");
    paramo.uni = bu.bI((String)paramMap.get(".sysmsg.gamecenter.topic.topic_title"), "");
    paramo.unh = bu.bI((String)paramMap.get(".sysmsg.gamecenter.topic.topic_url"), "");
    AppMethodBeat.o(41478);
  }
  
  private static void p(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41479);
    paramo.unH = bu.getInt((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
    paramo.unI = bu.bI((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
    AppMethodBeat.o(41479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.q
 * JD-Core Version:    0.7.0.1
 */