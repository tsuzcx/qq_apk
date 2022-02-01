package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hl;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/game/report/Kv20488;", "", "()V", "Companion", "report-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a mtx;
  
  static
  {
    AppMethodBeat.i(240727);
    mtx = new a((byte)0);
    AppMethodBeat.o(240727);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/game/report/Kv20488$Companion;", "", "()V", "ACCOUNT_TYPE_GAME", "", "ACCOUNT_TYPE_WECHAT_GAME", "ACTION_CLICK", "ACTION_CLICK_CANCEL", "ACTION_CONFIRM_ADD_BLACKLIST", "ACTION_CONFIRM_REMOVE_BLACKLIST", "ACTION_DELETE", "ACTION_DIALOG_CANCEL", "ACTION_EXPOSURE", "ACTION_JUMP_APPBRAND", "ACTION_JUMP_H5", "ACTION_JUMP_NATIVE", "ACTION_JUMP_URL", "ACTION_LEFT_SLIDE_OR_LONG_PRESS", "ACTION_SEND_SUCCESS", "ATTACH_ITEM_GIFT", "ATTACH_ITEM_LOCATION", "ATTACH_ITEM_PHOTO", "ATTACH_ITEM_VIDEO", "RED_DOT_TYPE_AVATAR", "", "RED_DOT_TYPE_AVATAR_AND_DOT", "RED_DOT_TYPE_EMPTY", "RED_DOT_TYPE_ICON", "RED_DOT_TYPE_NEW", "RED_DOT_TYPE_NORMAL", "RED_DOT_TYPE_NUMBER_DOT", "SCENEID_BOTTOM_TAB", "SCENEID_CHATTING", "SCENEID_CHATTING_DETAIL", "SCENEID_CONVERSATION_LIST", "TAG", "", "UIAREA_BOTTOM_TAB", "UIAREA_CHATTING", "UIAREA_CHATTING_DETAIL", "UIAREA_CHATTING_PANEL", "UIAREA_CONVERSATION_FUNCTION_BAR", "UIAREA_CONVERSATION_LIST", "UIAREA_EXPOSURE", "createReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/GameLifeSessionStruct;", "sceneId", "uiArea", "positionId", "actionId", "sourceId", "reportAttachItemClick", "", "sessionId", "fromAccountType", "fromUsername", "toAccountType", "toUsername", "serName", "reportAttachItemJump", "reportChattingDetailUIItem", "pos", "actionStatus", "roleType", "(IJLjava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "reportChattingItem", "reportConversationItem", "totalNum", "sessionType", "unReadNum", "(IJILjava/lang/String;JLjava/lang/String;JLjava/lang/String;JJLjava/lang/String;Ljava/lang/Integer;)V", "reportConversationLoadInitial", "reportConversationUIExposure", "reportEnterChattingDetailUI", "reportEnterGameTabHome", "defaultTab", "reportGameTabItemClicked", "tabKey", "redDotType", "reportGameTabItemExposure", "reportGameWeappTabClicked", "reportSelfProfileClick", "report-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static hl a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      AppMethodBeat.i(240801);
      hl localhl = new hl();
      localhl.iOg = paramLong1;
      localhl.iOh = paramLong2;
      localhl.iOi = paramLong3;
      localhl.iOj = paramLong4;
      localhl.iOl = paramLong5;
      AppMethodBeat.o(240801);
      return localhl;
    }
    
    public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(240757);
      s.u(paramString, "tabKey");
      hl localhl = a(1L, 101L, paramInt1, 1L, paramLong);
      localhl.iOD = paramInt2;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("red_dot", paramInt3);
      localJSONObject.put("tab_key", paramString);
      localhl.rA(URLEncoder.encode(localJSONObject.toString()));
      localhl.bMH();
      AppMethodBeat.o(240757);
    }
    
    public static void a(int paramInt1, long paramLong1, int paramInt2, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, long paramLong4, long paramLong5, String paramString4)
    {
      AppMethodBeat.i(240771);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "fromUsername");
      s.u(paramString3, "toUsername");
      a(paramInt1, paramLong1, paramInt2, paramString1, paramLong2, paramString2, paramLong3, paramString3, paramLong4, paramLong5, paramString4, null);
      AppMethodBeat.o(240771);
    }
    
    public static void a(int paramInt1, long paramLong1, int paramInt2, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, long paramLong4, long paramLong5, String paramString4, Integer paramInteger)
    {
      AppMethodBeat.i(240784);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "fromUsername");
      s.u(paramString3, "toUsername");
      hl localhl = a(2L, 202L, paramInt1, paramLong1, paramLong5);
      localhl.iOD = paramInt2;
      localhl.rz(paramString1);
      localhl.iOy = paramLong2;
      localhl.rx(paramString2);
      localhl.iOA = paramLong3;
      localhl.ry(paramString3);
      localhl.rw(paramString4);
      paramString1 = new JSONObject();
      paramString1.put("session_type", paramLong4);
      if (paramInteger != null) {
        paramString1.put("unreadnum", paramInteger.intValue());
      }
      localhl.rA(URLEncoder.encode(paramString1.toString()));
      Log.d("Report.Kv20488", s.X("vir:", localhl.aIF()));
      localhl.bMH();
      AppMethodBeat.o(240784);
    }
    
    public static void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, String paramString4)
    {
      AppMethodBeat.i(240794);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "fromUsername");
      s.u(paramString3, "toUsername");
      hl localhl = a(3L, 301L, paramInt, paramLong1, 301L);
      localhl.rz(paramString1);
      localhl.iOy = paramLong2;
      localhl.rx(paramString2);
      localhl.iOA = paramLong3;
      localhl.ry(paramString3);
      localhl.rw(paramString4);
      localhl.bMH();
      AppMethodBeat.o(240794);
    }
    
    public static void a(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, long paramLong3)
    {
      AppMethodBeat.i(240789);
      s.u(paramString1, "sessionId");
      s.u(paramString2, "fromUsername");
      s.u(paramString3, "toUsername");
      hl localhl = a(3L, 302L, 3L, paramLong3, 301L);
      localhl.rz(paramString1);
      localhl.iOy = paramLong1;
      localhl.rx(paramString2);
      localhl.iOA = paramLong2;
      localhl.ry(paramString3);
      paramString1 = new JSONObject();
      paramString1.put("ser_name", 4L);
      localhl.rA(URLEncoder.encode(paramString1.toString()));
      localhl.bMH();
      AppMethodBeat.o(240789);
    }
    
    public static void hx(long paramLong)
    {
      AppMethodBeat.i(240761);
      a(2L, 201L, 0L, 7L, paramLong).bMH();
      AppMethodBeat.o(240761);
    }
    
    public static void r(String paramString, long paramLong)
    {
      AppMethodBeat.i(240754);
      s.u(paramString, "defaultTab");
      hl localhl = a(1L, 101L, 0L, 1L, paramLong);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("default_tab", paramString);
      localhl.rA(URLEncoder.encode(localJSONObject.toString()));
      localhl.bMH();
      AppMethodBeat.o(240754);
    }
    
    public static void y(int paramInt, long paramLong)
    {
      AppMethodBeat.i(240766);
      hl localhl = a(2L, 202L, 0L, 1L, paramLong);
      localhl.iOD = paramInt;
      JSONObject localJSONObject = new JSONObject();
      if (paramInt == 0) {}
      for (paramInt = 2;; paramInt = 1)
      {
        localJSONObject.put("list_state", paramInt);
        localhl.rA(URLEncoder.encode(localJSONObject.toString()));
        localhl.bMH();
        AppMethodBeat.o(240766);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.report.c
 * JD-Core Version:    0.7.0.1
 */