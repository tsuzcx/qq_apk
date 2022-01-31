package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.LinkedList;
import java.util.Map;

public final class p
{
  public static String K(Map<String, String> paramMap)
  {
    AppMethodBeat.i(111301);
    paramMap = bo.bf((String)paramMap.get(".sysmsg.gamecenter.formatcontent"), "");
    AppMethodBeat.o(111301);
    return paramMap;
  }
  
  public static long L(Map<String, String> paramMap)
  {
    AppMethodBeat.i(111309);
    long l = bo.getLong((String)paramMap.get(".sysmsg.game_control_info.control_flag"), 0L);
    AppMethodBeat.o(111309);
    return l;
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(111300);
    if (bo.isNullOrNil(paramn.field_rawXML))
    {
      ab.e("MicroMsg.GameMessageParser", "msg content is null");
      AppMethodBeat.o(111300);
      return;
    }
    Map localMap = br.F(paramn.field_rawXML, "sysmsg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ab.e("MicroMsg.GameMessageParser", "Parse failed");
      AppMethodBeat.o(111300);
      return;
    }
    if (!"gamecenter".equalsIgnoreCase((String)localMap.get(".sysmsg.$type")))
    {
      ab.e("MicroMsg.GameMessageParser", "Type not matched");
      AppMethodBeat.o(111300);
      return;
    }
    a(localMap, paramn);
    b(localMap, paramn);
    e(localMap, paramn);
    f(localMap, paramn);
    g(localMap, paramn);
    h(localMap, paramn);
    i(localMap, paramn);
    k(localMap, paramn);
    d(localMap, paramn);
    n(localMap, paramn);
    c(localMap, paramn);
    AppMethodBeat.o(111300);
  }
  
  private static void a(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111302);
    paramn.nnm = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.wifi_flag"), 0);
    AppMethodBeat.o(111302);
  }
  
  private static void b(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111303);
    paramn.lkK = K(paramMap);
    paramn.nmR = bo.bf((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    paramn.nnf = bo.bf((String)paramMap.get(".sysmsg.gamecenter.msg_picture_url"), "");
    paramn.nmS = bo.bf((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
    if (bo.isNullOrNil(paramn.nmS)) {
      paramn.nmS = bo.bf((String)paramMap.get(".sysmsg.gamecenter.url"), "");
    }
    paramn.nnK = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.notify_type"), 0);
    AppMethodBeat.o(111303);
  }
  
  private static void c(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111304);
    switch (paramn.field_msgType)
    {
    case 3: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      ab.e("MicroMsg.GameMessageParser", "error gamecenter type: " + paramn.field_msgType);
      AppMethodBeat.o(111304);
      return;
    case 10: 
    case 11: 
      AppMethodBeat.o(111304);
      return;
    case 2: 
      j(paramMap, paramn);
      ab.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", new Object[] { paramn.field_appId });
      AppMethodBeat.o(111304);
      return;
    case 4: 
      AppMethodBeat.o(111304);
      return;
    case 5: 
      l(paramMap, paramn);
      AppMethodBeat.o(111304);
      return;
    }
    m(paramMap, paramn);
    AppMethodBeat.o(111304);
  }
  
  private static void d(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111305);
    paramn.nng = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
    paramn.nnd.nnT = bo.bf((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
    paramn.nnd.mDesc = bo.bf((String)paramMap.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
    AppMethodBeat.o(111305);
  }
  
  private static void e(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111306);
    paramn.mAppName = bo.bf((String)paramMap.get(".sysmsg.gamecenter.appinfo.appname2"), "");
    if (bo.isNullOrNil(paramn.mAppName)) {
      paramn.mAppName = bo.bf((String)paramMap.get(".sysmsg.gamecenter.appinfo.appname"), "");
    }
    if (paramn.field_msgType == 6)
    {
      paramn.nmX = bo.bf((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupname"), "");
      paramn.nmY = bo.bf((String)paramMap.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
    }
    for (;;)
    {
      paramn.nmT = bo.bf((String)paramMap.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
      paramn.nmU = bo.bf((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
      paramn.nmV = bo.bf((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
      paramn.nmW = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
      AppMethodBeat.o(111306);
      return;
      paramn.nmX = paramn.mAppName;
    }
  }
  
  private static void f(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111307);
    paramn.nmZ.clear();
    int i = 0;
    if (i == 0) {}
    for (String str = ".sysmsg.gamecenter.userinfo";; str = ".sysmsg.gamecenter.userinfo" + i)
    {
      if (!paramMap.containsKey(str)) {
        break label278;
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
    label278:
    AppMethodBeat.o(111307);
  }
  
  private static void g(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111308);
    paramn.nnM = bo.bf((String)paramMap.get(".sysmsg.gamecenter.noticeid"), "");
    AppMethodBeat.o(111308);
  }
  
  private static void h(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111310);
    paramn.nnn = L(paramMap);
    AppMethodBeat.o(111310);
  }
  
  private static void i(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111311);
    paramn.nnb.nnV = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.badge_display_type"), 0);
    paramn.nnb.nnT = bo.bf((String)paramMap.get(".sysmsg.gamecenter.showiconurl"), "");
    paramn.nnb.mText = bo.bf((String)paramMap.get(".sysmsg.gamecenter.entrancetext"), "");
    AppMethodBeat.o(111311);
  }
  
  private static void j(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111312);
    paramn.nnh = bo.getInt((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
    paramn.nni = bo.getInt((String)paramMap.get(".sysmsg.game_control_info.display_name_type"), 1);
    paramn.nnj = bo.bf((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
    paramn.nnk = bo.bf((String)paramMap.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
    paramn.nnl = bo.bf((String)paramMap.get(".sysmsg.gameshare.share_message_info.media_url"), "");
    paramn.nnf = bo.bf((String)paramMap.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
    AppMethodBeat.o(111312);
  }
  
  public static void k(Map<String, String> paramMap, n paramn)
  {
    boolean bool2 = true;
    AppMethodBeat.i(111313);
    paramn.nnq.url = bo.bf((String)paramMap.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
    n.a locala = paramn.nnq;
    if (bo.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1)
    {
      bool1 = true;
      locala.njd = bool1;
      paramn.nnq.orientation = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
      paramn = paramn.nnq;
      if (bo.getInt((String)paramMap.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
        break label133;
      }
    }
    label133:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramn.nnQ = bool1;
      AppMethodBeat.o(111313);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void l(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111314);
    paramn.nnv = bo.bf((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
    paramn.nnw = bo.bf((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
    paramn.nnx = bo.bf((String)paramMap.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
    AppMethodBeat.o(111314);
  }
  
  private static void m(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111315);
    paramn.nnr = bo.bf((String)paramMap.get(".sysmsg.gamecenter.topic.reply_content"), "");
    paramn.nns = bo.bf((String)paramMap.get(".sysmsg.gamecenter.topic.replied_content"), "");
    paramn.nnu = bo.bf((String)paramMap.get(".sysmsg.gamecenter.topic.topic_title"), "");
    paramn.nnt = bo.bf((String)paramMap.get(".sysmsg.gamecenter.topic.topic_url"), "");
    AppMethodBeat.o(111315);
  }
  
  private static void n(Map<String, String> paramMap, n paramn)
  {
    AppMethodBeat.i(111316);
    paramn.nnN = bo.getInt((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
    paramn.nnO = bo.bf((String)paramMap.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
    AppMethodBeat.o(111316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.p
 * JD-Core Version:    0.7.0.1
 */