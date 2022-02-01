package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
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
    AppMethodBeat.i(275417);
    if ((paramo == null) || (paramMap == null))
    {
      AppMethodBeat.o(275417);
      return;
    }
    if (paramo.IEh == 0) {
      paramo.IEh = paramo.field_msgType;
    }
    b(paramMap, paramo);
    AppMethodBeat.o(275417);
  }
  
  public static String as(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41464);
    paramMap = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.formatcontent"), "");
    AppMethodBeat.o(41464);
    return paramMap;
  }
  
  public static long at(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41472);
    long l = Util.getLong((String)paramMap.get(".sysmsg.game_control_info.control_flag"), 0L);
    AppMethodBeat.o(41472);
    return l;
  }
  
  public static void b(o paramo)
  {
    AppMethodBeat.i(275414);
    if (Util.isNullOrNil(paramo.field_rawXML))
    {
      Log.e("MicroMsg.GameMessageParser", "msg content is null");
      AppMethodBeat.o(275414);
      return;
    }
    Map localMap = XmlParser.parseXml(paramo.field_rawXML, "sysmsg", null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      Log.e("MicroMsg.GameMessageParser", "Parse failed");
      AppMethodBeat.o(275414);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      Log.e("MicroMsg.GameMessageParser", "Type not matched");
      AppMethodBeat.o(275414);
      return;
    }
    a(localMap, paramo);
    AppMethodBeat.o(275414);
  }
  
  private static void b(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(275418);
    paramo.IEb.ooc = Util.nullAs((String)paramMap.get(".sysmsg.report_rule.$report_id"), "");
    paramo.IEb.IEZ = Util.getInt((String)paramMap.get(".sysmsg.report_rule.report_mode"), 0);
    paramo.IEb.IFa = Util.getInt((String)paramMap.get(".sysmsg.report_rule.report_sample"), 0);
    if (paramo.IEb.ias == null) {
      switch (paramo.IEb.IEZ)
      {
      }
    }
    for (;;)
    {
      if (paramo.IEb.ias == null) {
        paramo.IEb.ias = Boolean.FALSE;
      }
      paramo.field_needReport = Util.nullAs(paramo.IEb.ias, false);
      Log.i("MicroMsg.GameMessageParser", "gameMessageId:%s, needReport:%b", new Object[] { paramo.field_gameMsgId, Boolean.valueOf(paramo.field_needReport) });
      AppMethodBeat.o(275418);
      return;
      paramo.IEb.ias = Boolean.TRUE;
      continue;
      paramo.IEb.ias = Boolean.FALSE;
      continue;
      paramMap = ((f)h.ax(f.class)).fCh().rG(paramo.field_msgId);
      if (paramMap != null) {
        paramo.IEb.ias = Boolean.valueOf(paramMap.field_needReport);
      } else {
        try
        {
          h.baF();
          h.baC();
          i = new Random(b.getUin() ^ System.nanoTime()).nextInt(10001);
          Log.i("MicroMsg.GameMessageParser", "randomValue:%d, reportSample:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramo.IEb.IFa) });
          if (i < paramo.IEb.IFa) {
            paramo.IEb.ias = Boolean.TRUE;
          }
        }
        catch (Exception paramMap)
        {
          for (;;)
          {
            int i = Util.getIntRandom(10000, 0);
          }
          paramo.IEb.ias = Boolean.FALSE;
        }
      }
    }
  }
  
  private static void c(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41465);
    paramo.IDD = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(41465);
  }
  
  private static void d(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41466);
    paramo.xQX = as(paramMap);
    paramo.IDi = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    paramo.IDw = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.msg_picture_url"), "");
    paramo.IDj = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
    if (Util.isNullOrNil(paramo.IDj)) {
      paramo.IDj = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    }
    paramo.IEg = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.notify_type"), 0);
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
    paramo.IDx = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
    paramo.IDu.IEu = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
    paramo.IDu.mDesc = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
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
      paramo.IDo = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupname"), "");
      paramo.IDp = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
    }
    for (;;)
    {
      paramo.IDk = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
      paramo.IDl = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
      paramo.IDm = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
      paramo.IDn = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
      AppMethodBeat.o(41469);
      return;
      paramo.IDo = paramo.mAppName;
    }
  }
  
  private static void h(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41470);
    paramo.IDq.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.userinfo";; str = ".sysmsg.gamecenter.userinfo" + i)
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
    AppMethodBeat.o(41470);
  }
  
  private static void i(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41471);
    paramo.mNoticeId = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.noticeid"), "");
    AppMethodBeat.o(41471);
  }
  
  private static void j(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41473);
    paramo.IDF = at(paramMap);
    AppMethodBeat.o(41473);
  }
  
  private static void k(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41474);
    paramo.IDs.IEw = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.badge_display_type"), 0);
    paramo.IDs.IEu = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.showiconurl"), "");
    paramo.IDs.mText = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.entrancetext"), "");
    AppMethodBeat.o(41474);
  }
  
  private static void l(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41475);
    paramo.IDy = Util.getInt((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
    paramo.IDz = Util.getInt((String)paramMap.get(".sysmsg.game_control_info.display_name_type"), 1);
    paramo.IDA = Util.nullAs((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
    paramo.IDB = Util.nullAs((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
    paramo.IDC = Util.nullAs((String)paramMap.get(".sysmsg.gameshare.share_message_info.media_url"), "");
    paramo.IDw = Util.nullAs((String)paramMap.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
    AppMethodBeat.o(41475);
  }
  
  public static void m(Map<String, String> paramMap, o paramo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(41476);
    paramo.IDI.url = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
    o.b localb = paramo.IDI;
    if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1)
    {
      bool1 = true;
      localb.ItB = bool1;
      paramo.IDI.orientation = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
      paramo = paramo.IDI;
      if (Util.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
        break label133;
      }
    }
    label133:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramo.egT = bool1;
      AppMethodBeat.o(41476);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void n(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41477);
    paramo.IDN = Util.nullAs((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
    paramo.IDO = Util.nullAs((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
    paramo.IDP = Util.nullAs((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
    AppMethodBeat.o(41477);
  }
  
  private static void o(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41478);
    paramo.IDJ = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.topic.reply_content"), "");
    paramo.IDK = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.topic.replied_content"), "");
    paramo.IDM = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.topic.topic_title"), "");
    paramo.IDL = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.topic.topic_url"), "");
    AppMethodBeat.o(41478);
  }
  
  private static void p(Map<String, String> paramMap, o paramo)
  {
    AppMethodBeat.i(41479);
    paramo.IEk = Util.getInt((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
    paramo.IEl = Util.nullAs((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
    AppMethodBeat.o(41479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.q
 * JD-Core Version:    0.7.0.1
 */