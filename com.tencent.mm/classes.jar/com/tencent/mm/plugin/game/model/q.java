package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public final class q
{
  public static void a(o paramo)
  {
    AppMethodBeat.i(41463);
    if (Util.isNullOrNil(paramo.field_rawXML))
    {
      Log.e("MicroMsg.GameMessageParser", "msg content is null");
      AppMethodBeat.o(41463);
      return;
    }
    Map localMap = XmlParser.parseXml(paramo.field_rawXML, "sysmsg", null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      Log.e("MicroMsg.GameMessageParser", "Parse failed");
      AppMethodBeat.o(41463);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      Log.e("MicroMsg.GameMessageParser", "Type not matched");
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
    AppMethodBeat.i(204165);
    if ((paramo == null) || (paramMap == null))
    {
      AppMethodBeat.o(204165);
      return;
    }
    if (paramo.xFV == 0) {
      paramo.xFV = paramo.field_msgType;
    }
    b(paramMap, paramo);
    AppMethodBeat.o(204165);
  }
  
  public static String al(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41464);
    paramMap = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.formatcontent"), "");
    AppMethodBeat.o(41464);
    return paramMap;
  }
  
  public static long am(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41472);
    long l = Util.getLong((String)paramMap.get(".sysmsg.game_control_info.control_flag"), 0L);
    AppMethodBeat.o(41472);
    return l;
  }
  
  public static void b(o paramo)
  {
    AppMethodBeat.i(204164);
    if (Util.isNullOrNil(paramo.field_rawXML))
    {
      Log.e("MicroMsg.GameMessageParser", "msg content is null");
      AppMethodBeat.o(204164);
      return;
    }
    Map localMap = XmlParser.parseXml(paramo.field_rawXML, "sysmsg", null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      Log.e("MicroMsg.GameMessageParser", "Parse failed");
      AppMethodBeat.o(204164);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      Log.e("MicroMsg.GameMessageParser", "Type not matched");
      AppMethodBeat.o(204164);
      return;
    }
    a(localMap, paramo);
    AppMethodBeat.o(204164);
  }
  
  private static void b(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(204166);
    paramo.xFP.iGB = Util.nullAs((String)paramMap.get(".sysmsg.report_rule.$report_id"), "");
    paramo.xFP.xGO = Util.getInt((String)paramMap.get(".sysmsg.report_rule.report_mode"), 0);
    paramo.xFP.xGP = Util.getInt((String)paramMap.get(".sysmsg.report_rule.report_sample"), 0);
    if (paramo.xFP.eay == null) {
      switch (paramo.xFP.xGO)
      {
      }
    }
    for (;;)
    {
      if (paramo.xFP.eay == null) {
        paramo.xFP.eay = Boolean.FALSE;
      }
      paramo.field_needReport = Util.nullAs(paramo.xFP.eay, false);
      Log.i("MicroMsg.GameMessageParser", "gameMessageId:%s, needReport:%b", new Object[] { paramo.field_gameMsgId, Boolean.valueOf(paramo.field_needReport) });
      AppMethodBeat.o(204166);
      return;
      paramo.xFP.eay = Boolean.TRUE;
      continue;
      paramo.xFP.eay = Boolean.FALSE;
      continue;
      paramMap = ((f)g.af(f.class)).dSK().GJ(paramo.field_msgId);
      if (paramMap != null) {
        paramo.xFP.eay = Boolean.valueOf(paramMap.field_needReport);
      } else {
        try
        {
          g.aAi();
          g.aAf();
          i = new Random(a.getUin() ^ System.nanoTime()).nextInt(10001);
          Log.i("MicroMsg.GameMessageParser", "randomValue:%d, reportSample:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramo.xFP.xGP) });
          if (i < paramo.xFP.xGP) {
            paramo.xFP.eay = Boolean.TRUE;
          }
        }
        catch (Exception paramMap)
        {
          for (;;)
          {
            int i = Util.getIntRandom(10000, 0);
          }
          paramo.xFP.eay = Boolean.FALSE;
        }
      }
    }
  }
  
  private static void c(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41465);
    paramo.xFr = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41465);
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41466);
    paramo.rfc = al(paramMap);
    paramo.xEW = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    paramo.xFk = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_picture_url"), "");
    paramo.xEX = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
    if (Util.isNullOrNil(paramo.xEX)) {
      paramo.xEX = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    }
    paramo.xFU = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.notify_type"), 0);
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
      Log.e("MicroMsg.GameMessageParser", "error gamecenter type: " + paramo.field_msgType);
      AppMethodBeat.o(41467);
      return;
    case 10: 
    case 11: 
      AppMethodBeat.o(41467);
      return;
    case 2: 
      l(paramMap, paramo);
      Log.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", new Object[] { paramo.field_appId });
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
    paramo.xFl = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
    paramo.xFi.xGg = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
    paramo.xFi.mDesc = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
    AppMethodBeat.o(41468);
  }
  
  private static void g(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41469);
    paramo.mAppName = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.appname2"), "");
    if (Util.isNullOrNil(paramo.mAppName)) {
      paramo.mAppName = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.appname"), "");
    }
    if (paramo.field_msgType == 6)
    {
      paramo.xFc = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupname"), "");
      paramo.xFd = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
    }
    for (;;)
    {
      paramo.xEY = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
      paramo.xEZ = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
      paramo.xFa = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
      paramo.xFb = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
      AppMethodBeat.o(41469);
      return;
      paramo.xFc = paramo.mAppName;
    }
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41470);
    paramo.xFe.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.userinfo";; str = ".sysmsg.gamecenter.userinfo" + i)
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
    AppMethodBeat.o(41470);
  }
  
  private static void i(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41471);
    paramo.xFW = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.noticeid"), "");
    AppMethodBeat.o(41471);
  }
  
  private static void j(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41473);
    paramo.xFt = am(paramMap);
    AppMethodBeat.o(41473);
  }
  
  private static void k(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41474);
    paramo.xFg.xGi = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.badge_display_type"), 0);
    paramo.xFg.xGg = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.showiconurl"), "");
    paramo.xFg.mText = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.entrancetext"), "");
    AppMethodBeat.o(41474);
  }
  
  private static void l(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41475);
    paramo.xFm = Util.getInt((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
    paramo.xFn = Util.getInt((String)paramMap.get(".sysmsg.game_control_info.display_name_type"), 1);
    paramo.xFo = Util.nullAs((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
    paramo.xFp = Util.nullAs((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
    paramo.xFq = Util.nullAs((String)paramMap.get(".sysmsg.gameshare.share_message_info.media_url"), "");
    paramo.xFk = Util.nullAs((String)paramMap.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
    AppMethodBeat.o(41475);
  }
  
  public static void m(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41476);
    paramo.xFw.url = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
    o.a locala = paramo.xFw;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.xvW = bool1;
      paramo.xFw.orientation = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
      paramo = paramo.xFw;
      if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
        break label133;
      }
    }
    label133:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.crp = bool1;
      AppMethodBeat.o(41476);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void n(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41477);
    paramo.xFB = Util.nullAs((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
    paramo.xFC = Util.nullAs((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
    paramo.xFD = Util.nullAs((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
    AppMethodBeat.o(41477);
  }
  
  private static void o(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41478);
    paramo.xFx = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.topic.reply_content"), "");
    paramo.xFy = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.topic.replied_content"), "");
    paramo.xFA = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.topic.topic_title"), "");
    paramo.xFz = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.topic.topic_url"), "");
    AppMethodBeat.o(41478);
  }
  
  private static void p(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41479);
    paramo.xFZ = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
    paramo.xGa = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
    AppMethodBeat.o(41479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.q
 * JD-Core Version:    0.7.0.1
 */