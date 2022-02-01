package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.fp;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/game/report/Kv23070;", "", "()V", "Companion", "report-api_release"})
public final class d
{
  private static String jTg;
  private static String jTh;
  private static String jTi;
  public static final a jTj;
  
  static
  {
    AppMethodBeat.i(199106);
    jTj = new a((byte)0);
    jTg = "";
    jTh = "";
    jTi = "";
    AppMethodBeat.o(199106);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/game/report/Kv23070$Companion;", "", "()V", "ACTION_CLICK", "", "ACTION_EXPOSURE", "ACTION_JUMP_APPBRAND", "ACTION_JUMP_H5", "ACTION_JUMP_NATIVE", "ACTION_LONG_PRESS", "ACTION_STAY_TIME", "SCENEID_CHATROOM", "SCENEID_CHAT_TAB_HOME", "SCENEID_FIND_MORE_CHATROOM", "TAG", "", "UIAREA_CHATROOM_BOTTOM", "UIAREA_CHATROOM_JOIN_ALERT", "UIAREA_CHATROOM_JOIN_CONFIRM", "UIAREA_CHATROOM_MSG_LIST", "UIAREA_CHATROOM_NOTIFICATION", "UIAREA_CHATROOM_START_TEAM", "UIAREA_CHATROOM_STAY_TIME", "UIAREA_CHATROOM_TOP", "UIAREA_CHATROOM_USER_LIST", "UIAREA_CHAT_TAB_HOME_INVITE_DIALOG", "UIAREA_CHAT_TAB_HOME_MY_CHATROOM", "UIAREA_CHAT_TAB_HOME_RECOMMEND_CHATROOM", "UIAREA_CHAT_TAB_HOME_ROOM_TAB_BOTTOM", "UIAREA_CHAT_TAB_HOME_STAY_TIME", "UIAREA_EXPOSURE", "UIAREA_FIND_MORE_CHATROOM_FIND_MORE", "UIAREA_FIND_MORE_CHATROOM_STAY_TIME", "value_chatRoomId", "getValue_chatRoomId", "()Ljava/lang/String;", "setValue_chatRoomId", "(Ljava/lang/String;)V", "value_gameId", "getValue_gameId", "setValue_gameId", "value_noticeid", "getValue_noticeid", "setValue_noticeid", "createReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/GameChatRoomReportStruct;", "sceneId", "uiArea", "positionId", "actionId", "actionStatus", "ssid", "sourceId", "reportChatRoomBottom", "", "reportChatRoomExposure", "reportChatRoomMsg", "gameId", "messageId", "userName", "externInfo", "reportChatRoomPageStayTime", "stayTime", "reportChatRoomTabExposure", "reportChatRoomTabItem", "chatRoomId", "reportFindMoreChatRoom", "reportFindMoreRoomTabItem", "reportJoinChatRoomView", "report-api_release"})
  public static final class a
  {
    public static fp a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
    {
      AppMethodBeat.i(199028);
      fp localfp = new fp();
      localfp.op(paramLong1);
      localfp.oq(paramLong2);
      localfp.or(paramLong3);
      localfp.os(paramLong4);
      localfp.ot(paramLong5);
      localfp.ou(paramLong6);
      localfp.ov(paramLong7);
      a locala = d.jTj;
      localfp.ox(Util.getLong(d.aEA(), 0L));
      AppMethodBeat.o(199028);
      return localfp;
    }
    
    public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      AppMethodBeat.i(199021);
      a(1305L, paramLong1, paramLong2, 0L, paramLong3, paramLong4, d.aEz(), 0L, "", "");
      AppMethodBeat.o(199021);
    }
    
    private static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, String paramString1, long paramLong7, String paramString2, String paramString3)
    {
      AppMethodBeat.i(199025);
      fp localfp = a(13L, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6);
      localfp.uW(paramString1);
      paramString1 = d.jTj;
      localfp.uX(d.aEy());
      localfp.ow(paramLong7);
      localfp.uY(paramString2);
      localfp.uZ(paramString3);
      localfp.bpa();
      AppMethodBeat.o(199025);
    }
    
    public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(199009);
      fp localfp = a(10L, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6);
      localfp.uW(paramString1);
      localfp.uX(paramString2);
      localfp.uZ(paramString3);
      localfp.bpa();
      AppMethodBeat.o(199009);
    }
    
    public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString)
    {
      AppMethodBeat.i(199019);
      a(1304L, paramLong1, paramLong2, 0L, paramLong3, paramLong4, d.aEz(), paramLong5, paramString, "");
      AppMethodBeat.o(199019);
    }
    
    public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(199015);
      fp localfp = a(11L, 1102L, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5);
      localfp.uW(paramString1);
      localfp.uX(paramString2);
      localfp.uZ(paramString3);
      localfp.bpa();
      AppMethodBeat.o(199015);
    }
    
    public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(199011);
      fp localfp = a(11L, paramLong1, 0L, 1L, 0L, paramLong2, paramLong3);
      localfp.uW(paramString1);
      localfp.uX(paramString2);
      localfp.uZ(paramString3);
      localfp.bpa();
      AppMethodBeat.o(199011);
    }
    
    public static void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      AppMethodBeat.i(199022);
      a(1311L, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, d.aEz(), 0L, "", "");
      AppMethodBeat.o(199022);
    }
    
    public static void e(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(199017);
      fp localfp = a(13L, paramLong1, 0L, 1L, 0L, paramLong2, paramLong3);
      a locala = d.jTj;
      localfp.uX(d.aEy());
      locala = d.jTj;
      localfp.uW(d.aEz());
      localfp.bpa();
      AppMethodBeat.o(199017);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.game.report.d
 * JD-Core Version:    0.7.0.1
 */