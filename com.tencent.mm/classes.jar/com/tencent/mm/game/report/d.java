package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.lf;
import com.tencent.mm.autogen.a.lf.a;
import com.tencent.mm.autogen.mmdata.rpt.hk;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/game/report/Kv23070;", "", "()V", "Companion", "report-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static String mtA;
  private static String mtB;
  public static final a mty;
  private static String mtz;
  
  static
  {
    AppMethodBeat.i(240740);
    mty = new a((byte)0);
    mtz = "";
    mtA = "";
    mtB = "";
    AppMethodBeat.o(240740);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/game/report/Kv23070$Companion;", "", "()V", "ACTION_CLICK", "", "ACTION_EXPOSURE", "ACTION_JUMP_APPBRAND", "ACTION_JUMP_H5", "ACTION_JUMP_NATIVE", "ACTION_LONG_PRESS", "ACTION_STAY_TIME", "SCENEID_CHATROOM", "SCENEID_CHAT_TAB_HOME", "SCENEID_FIND_MORE_CHATROOM", "TAG", "", "UIAREA_CHATROOM_BOTTOM", "UIAREA_CHATROOM_JOIN_ALERT", "UIAREA_CHATROOM_JOIN_CONFIRM", "UIAREA_CHATROOM_MENTION_USER_LIST", "UIAREA_CHATROOM_MSG_LIST", "UIAREA_CHATROOM_MULTI_CHANNEL", "UIAREA_CHATROOM_MULTI_TASK_SELECT", "UIAREA_CHATROOM_NOTIFICATION", "UIAREA_CHATROOM_START_TEAM", "UIAREA_CHATROOM_STAY_TIME", "UIAREA_CHATROOM_TOP", "UIAREA_CHATROOM_USER_LIST", "UIAREA_CHAT_TAB_HOME_INVITE_DIALOG", "UIAREA_CHAT_TAB_HOME_MY_CHATROOM", "UIAREA_CHAT_TAB_HOME_RECOMMEND_CHATROOM", "UIAREA_CHAT_TAB_HOME_ROOM_TAB_BOTTOM", "UIAREA_CHAT_TAB_HOME_STAY_TIME", "UIAREA_EXPOSURE", "UIAREA_FIND_MORE_CHATROOM_FIND_MORE", "UIAREA_FIND_MORE_CHATROOM_STAY_TIME", "value_chatRoomId", "getValue_chatRoomId", "()Ljava/lang/String;", "setValue_chatRoomId", "(Ljava/lang/String;)V", "value_gameId", "getValue_gameId", "setValue_gameId", "value_noticeid", "getValue_noticeid", "setValue_noticeid", "createReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/GameChatRoomReportStruct;", "sceneId", "uiArea", "positionId", "actionId", "actionStatus", "ssid", "sourceId", "reportChatRoomBottom", "", "reportChatRoomBottomRight", "teamsCount", "", "reportChatRoomExposure", "reportChatRoomMentionUser", "userName", "reportChatRoomMsg", "gameId", "messageId", "externInfo", "selectedChannelId", "currentPageChannelId", "reportJsonStr", "reportChatRoomPageStayTime", "stayTime", "reportChatRoomTabExposure", "reportChatRoomTabItem", "chatRoomId", "reportChatRoomUserList", "reportFindMoreChatRoom", "reportFindMoreRoomTabItem", "reportJoinChatRoomView", "reportMultiChannel", "reportMultiTaskSelectCard", "report-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static hk a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
    {
      AppMethodBeat.i(240812);
      hk localhk = new hk();
      localhk.iOg = paramLong1;
      localhk.iOh = paramLong2;
      localhk.iOi = paramLong3;
      localhk.iOj = paramLong4;
      localhk.iLO = paramLong5;
      localhk.iOk = paramLong6;
      localhk.iOl = paramLong7;
      a locala = d.mty;
      localhk.iOt = Util.getLong(d.aXE(), 0L);
      AppMethodBeat.o(240812);
      return localhk;
    }
    
    private static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, String paramString1, long paramLong7, String paramString2, String paramString3, int paramInt)
    {
      AppMethodBeat.i(240802);
      hk localhk = a(13L, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6);
      localhk.rs(paramString1);
      paramString1 = d.mty;
      localhk.rt(d.aXC());
      localhk.iOo = paramLong7;
      localhk.ru(paramString2);
      localhk.rv(paramString3);
      localhk.iOu = paramInt;
      localhk.bMH();
      AppMethodBeat.o(240802);
    }
    
    public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(240760);
      hk localhk = a(10L, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6);
      localhk.rs(paramString1);
      localhk.rt(paramString2);
      if (paramString3 == null) {}
      for (paramString1 = null;; paramString1 = URLEncoder.encode(paramString3))
      {
        localhk.rv(paramString1);
        localhk.bMH();
        AppMethodBeat.o(240760);
        return;
      }
    }
    
    public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString)
    {
      AppMethodBeat.i(240791);
      lf locallf = new lf();
      locallf.publish();
      String str = d.aXD();
      if (paramString == null) {}
      for (paramString = null;; paramString = URLEncoder.encode(paramString))
      {
        a(1311L, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, str, 0L, "", paramString, locallf.hMX.channelId);
        AppMethodBeat.o(240791);
        return;
      }
    }
    
    public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, long paramLong6, int paramInt, String paramString2)
    {
      AppMethodBeat.i(240783);
      s.u(paramString2, "reportJsonStr");
      lf locallf = new lf();
      locallf.publish();
      try
      {
        paramString2 = new JSONObject(paramString2);
        paramString2.put("belongingtab", paramInt);
        a(1304L, paramLong1, paramLong2, paramLong6, paramLong3, paramLong4, d.aXD(), paramLong5, paramString1, URLEncoder.encode(paramString2.toString()), locallf.hMX.channelId);
        AppMethodBeat.o(240783);
        return;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString2 = new JSONObject();
        }
      }
    }
    
    public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(240767);
      hk localhk = a(11L, 1102L, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5);
      localhk.rs(paramString1);
      localhk.rt(paramString2);
      if (paramString3 == null) {}
      for (paramString1 = null;; paramString1 = URLEncoder.encode(paramString3))
      {
        localhk.rv(paramString1);
        localhk.bMH();
        AppMethodBeat.o(240767);
        return;
      }
    }
    
    public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(240764);
      hk localhk = a(11L, paramLong1, 0L, 1L, 0L, paramLong2, paramLong3);
      localhk.rs(paramString1);
      localhk.rt(paramString2);
      localhk.rv(URLEncoder.encode(paramString3));
      localhk.bMH();
      AppMethodBeat.o(240764);
    }
    
    public static void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      AppMethodBeat.i(240796);
      a(1323L, paramLong1, paramLong2, 0L, paramLong3, paramLong4, d.aXD(), 0L, "", "", 0);
      AppMethodBeat.o(240796);
    }
    
    public static void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
    {
      AppMethodBeat.i(240809);
      hk localhk = a(13L, 1308L, paramLong1, paramLong2, 0L, paramLong3, paramLong4);
      a locala = d.mty;
      localhk.rs(d.aXD());
      locala = d.mty;
      localhk.rt(d.aXC());
      localhk.ru(paramString);
      localhk.rv(localhk.iOs);
      localhk.bMH();
      AppMethodBeat.o(240809);
    }
    
    public static void f(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(240774);
      hk localhk = a(13L, paramLong1, 0L, 1L, 0L, paramLong2, paramLong3);
      a locala = d.mty;
      localhk.rt(d.aXC());
      locala = d.mty;
      localhk.rs(d.aXD());
      localhk.bMH();
      AppMethodBeat.o(240774);
    }
    
    public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      AppMethodBeat.i(240819);
      b(1305L, paramLong1, paramLong2, paramLong3, paramLong4, d.aXD(), "", "");
      AppMethodBeat.o(240819);
    }
    
    public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
    {
      AppMethodBeat.i(240815);
      String str = d.aXD();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("belongingtab", paramInt);
      b(1318L, paramLong1, paramLong2, paramLong3, paramLong4, str, "", URLEncoder.encode(localJSONObject.toString()));
      AppMethodBeat.o(240815);
    }
    
    public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt)
    {
      AppMethodBeat.i(240821);
      a(this, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString, paramInt);
      AppMethodBeat.o(240821);
    }
    
    public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
    {
      AppMethodBeat.i(240817);
      b(1302L, paramLong1, paramLong2, paramLong3, paramLong4, d.aXD(), paramString, "");
      AppMethodBeat.o(240817);
    }
    
    public final void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      AppMethodBeat.i(240823);
      a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, "{}");
      AppMethodBeat.o(240823);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.report.d
 * JD-Core Version:    0.7.0.1
 */