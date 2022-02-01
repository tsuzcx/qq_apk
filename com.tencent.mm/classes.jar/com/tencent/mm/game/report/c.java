package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.net.URLEncoder;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/game/report/Kv20488;", "", "()V", "Companion", "report-api_release"})
public final class c
{
  public static final a guw;
  
  static
  {
    AppMethodBeat.i(214281);
    guw = new a((byte)0);
    AppMethodBeat.o(214281);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/game/report/Kv20488$Companion;", "", "()V", "ACCOUNT_TYPE_GAME", "", "ACCOUNT_TYPE_WECHAT_GAME", "ACTION_CLICK", "ACTION_CLICK_CANCEL", "ACTION_CONFIRM_ADD_BLACKLIST", "ACTION_CONFIRM_REMOVE_BLACKLIST", "ACTION_DELETE", "ACTION_DIALOG_CANCEL", "ACTION_EXPOSURE", "ACTION_JUMP_APPBRAND", "ACTION_JUMP_H5", "ACTION_JUMP_NATIVE", "ACTION_JUMP_URL", "ACTION_LEFT_SLIDE_OR_LONG_PRESS", "ACTION_SEND_SUCCESS", "ATTACH_ITEM_GIFT", "ATTACH_ITEM_LOCATION", "ATTACH_ITEM_PHOTO", "ATTACH_ITEM_VIDEO", "RED_DOT_TYPE_AVATAR", "", "RED_DOT_TYPE_AVATAR_AND_DOT", "RED_DOT_TYPE_EMPTY", "RED_DOT_TYPE_ICON", "RED_DOT_TYPE_NEW", "RED_DOT_TYPE_NORMAL", "RED_DOT_TYPE_NUMBER_DOT", "SCENEID_BOTTOM_TAB", "SCENEID_CHATTING", "SCENEID_CHATTING_DETAIL", "SCENEID_CONVERSATION_LIST", "TAG", "", "UIAREA_BOTTOM_TAB", "UIAREA_CHATTING", "UIAREA_CHATTING_DETAIL", "UIAREA_CHATTING_PANEL", "UIAREA_CONVERSATION_FUNCTION_BAR", "UIAREA_CONVERSATION_LIST", "UIAREA_EXPOSURE", "createReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/GameLifeSessionStruct;", "sceneId", "uiArea", "positionId", "actionId", "sourceId", "reportAttachItemClick", "", "sessionId", "fromAccountType", "fromUsername", "toAccountType", "toUsername", "serName", "reportAttachItemJump", "reportChattingDetailUIItem", "pos", "actionStatus", "roleType", "(IJLjava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "reportChattingItem", "reportConversationItem", "totalNum", "sessionType", "reportConversationLoadInitial", "reportConversationUIExposure", "reportEnterChattingDetailUI", "reportEnterGameTabHome", "defaultTab", "reportGameTabItemClicked", "tabKey", "redDotType", "reportGameTabItemExposure", "reportGameWeappTabClicked", "reportSelfProfileClick", "report-api_release"})
  public static final class a
  {
    public static cf a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      AppMethodBeat.i(214280);
      cf localcf = new cf();
      localcf.hW(paramLong1);
      localcf.hX(paramLong2);
      localcf.hY(paramLong3);
      localcf.hZ(paramLong4);
      localcf.ia(paramLong5);
      AppMethodBeat.o(214280);
      return localcf;
    }
    
    public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(214275);
      p.h(paramString, "tabKey");
      cf localcf = a(1L, 101L, paramInt1, 1L, paramLong);
      localcf.id(paramInt2);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("red_dot", paramInt3);
      localJSONObject.put("tab_key", paramString);
      localcf.lZ(URLEncoder.encode(localJSONObject.toString()));
      localcf.aLH();
      AppMethodBeat.o(214275);
    }
    
    public static void a(int paramInt1, long paramLong1, int paramInt2, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, long paramLong4, long paramLong5, String paramString4)
    {
      AppMethodBeat.i(214276);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "fromUsername");
      p.h(paramString3, "toUsername");
      cf localcf = a(2L, 202L, paramInt1, paramLong1, paramLong5);
      localcf.id(paramInt2);
      localcf.lY(paramString1);
      localcf.ib(paramLong2);
      localcf.lW(paramString2);
      localcf.ic(paramLong3);
      localcf.lX(paramString3);
      localcf.lV(paramString4);
      paramString1 = new JSONObject();
      paramString1.put("session_type", paramLong4);
      localcf.lZ(URLEncoder.encode(paramString1.toString()));
      ae.d("Report.Kv20488", "vir:" + localcf.RD());
      localcf.aLH();
      AppMethodBeat.o(214276);
    }
    
    public static void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, String paramString4)
    {
      AppMethodBeat.i(214279);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "fromUsername");
      p.h(paramString3, "toUsername");
      cf localcf = a(3L, 301L, paramInt, paramLong1, 301L);
      localcf.lY(paramString1);
      localcf.ib(paramLong2);
      localcf.lW(paramString2);
      localcf.ic(paramLong3);
      localcf.lX(paramString3);
      localcf.lV(paramString4);
      localcf.aLH();
      AppMethodBeat.o(214279);
    }
    
    public static void a(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, long paramLong3)
    {
      AppMethodBeat.i(214278);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "fromUsername");
      p.h(paramString3, "toUsername");
      cf localcf = a(3L, 302L, 3L, paramLong3, 301L);
      localcf.lY(paramString1);
      localcf.ib(paramLong1);
      localcf.lW(paramString2);
      localcf.ic(paramLong2);
      localcf.lX(paramString3);
      paramString1 = new JSONObject();
      paramString1.put("ser_name", 4L);
      localcf.lZ(URLEncoder.encode(paramString1.toString()));
      localcf.aLH();
      AppMethodBeat.o(214278);
    }
    
    public static void s(String paramString, long paramLong)
    {
      AppMethodBeat.i(214274);
      p.h(paramString, "defaultTab");
      cf localcf = a(1L, 101L, 0L, 1L, paramLong);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("default_tab", paramString);
      localcf.lZ(URLEncoder.encode(localJSONObject.toString()));
      localcf.aLH();
      AppMethodBeat.o(214274);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.game.report.c
 * JD-Core Version:    0.7.0.1
 */