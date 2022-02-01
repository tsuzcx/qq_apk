package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/game/report/Kv20488;", "", "()V", "Companion", "report-api_release"})
public final class c
{
  public static final a hhl;
  
  static
  {
    AppMethodBeat.i(190337);
    hhl = new a((byte)0);
    AppMethodBeat.o(190337);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/game/report/Kv20488$Companion;", "", "()V", "ACCOUNT_TYPE_GAME", "", "ACCOUNT_TYPE_WECHAT_GAME", "ACTION_CLICK", "ACTION_CLICK_CANCEL", "ACTION_CONFIRM_ADD_BLACKLIST", "ACTION_CONFIRM_REMOVE_BLACKLIST", "ACTION_DELETE", "ACTION_DIALOG_CANCEL", "ACTION_EXPOSURE", "ACTION_JUMP_APPBRAND", "ACTION_JUMP_H5", "ACTION_JUMP_NATIVE", "ACTION_JUMP_URL", "ACTION_LEFT_SLIDE_OR_LONG_PRESS", "ACTION_SEND_SUCCESS", "ATTACH_ITEM_GIFT", "ATTACH_ITEM_LOCATION", "ATTACH_ITEM_PHOTO", "ATTACH_ITEM_VIDEO", "RED_DOT_TYPE_AVATAR", "", "RED_DOT_TYPE_AVATAR_AND_DOT", "RED_DOT_TYPE_EMPTY", "RED_DOT_TYPE_ICON", "RED_DOT_TYPE_NEW", "RED_DOT_TYPE_NORMAL", "RED_DOT_TYPE_NUMBER_DOT", "SCENEID_BOTTOM_TAB", "SCENEID_CHATTING", "SCENEID_CHATTING_DETAIL", "SCENEID_CONVERSATION_LIST", "TAG", "", "UIAREA_BOTTOM_TAB", "UIAREA_CHATTING", "UIAREA_CHATTING_DETAIL", "UIAREA_CHATTING_PANEL", "UIAREA_CONVERSATION_FUNCTION_BAR", "UIAREA_CONVERSATION_LIST", "UIAREA_EXPOSURE", "createReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/GameLifeSessionStruct;", "sceneId", "uiArea", "positionId", "actionId", "sourceId", "reportAttachItemClick", "", "sessionId", "fromAccountType", "fromUsername", "toAccountType", "toUsername", "serName", "reportAttachItemJump", "reportChattingDetailUIItem", "pos", "actionStatus", "roleType", "(IJLjava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "reportChattingItem", "reportConversationItem", "totalNum", "sessionType", "reportConversationLoadInitial", "reportConversationUIExposure", "reportEnterChattingDetailUI", "reportEnterGameTabHome", "defaultTab", "reportGameTabItemClicked", "tabKey", "redDotType", "reportGameTabItemExposure", "reportGameWeappTabClicked", "reportSelfProfileClick", "report-api_release"})
  public static final class a
  {
    public static eq a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      AppMethodBeat.i(190336);
      eq localeq = new eq();
      localeq.mS(paramLong1);
      localeq.mT(paramLong2);
      localeq.mU(paramLong3);
      localeq.mV(paramLong4);
      localeq.mW(paramLong5);
      AppMethodBeat.o(190336);
      return localeq;
    }
    
    public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(190331);
      p.h(paramString, "tabKey");
      eq localeq = a(1L, 101L, paramInt1, 1L, paramLong);
      localeq.mZ(paramInt2);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("red_dot", paramInt3);
      localJSONObject.put("tab_key", paramString);
      localeq.rQ(URLEncoder.encode(localJSONObject.toString()));
      localeq.bfK();
      AppMethodBeat.o(190331);
    }
    
    public static void a(int paramInt1, long paramLong1, int paramInt2, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, long paramLong4, long paramLong5, String paramString4)
    {
      AppMethodBeat.i(190332);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "fromUsername");
      p.h(paramString3, "toUsername");
      eq localeq = a(2L, 202L, paramInt1, paramLong1, paramLong5);
      localeq.mZ(paramInt2);
      localeq.rP(paramString1);
      localeq.mX(paramLong2);
      localeq.rN(paramString2);
      localeq.mY(paramLong3);
      localeq.rO(paramString3);
      localeq.rM(paramString4);
      paramString1 = new JSONObject();
      paramString1.put("session_type", paramLong4);
      localeq.rQ(URLEncoder.encode(paramString1.toString()));
      Log.d("Report.Kv20488", "vir:" + localeq.abW());
      localeq.bfK();
      AppMethodBeat.o(190332);
    }
    
    public static void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, String paramString4)
    {
      AppMethodBeat.i(190335);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "fromUsername");
      p.h(paramString3, "toUsername");
      eq localeq = a(3L, 301L, paramInt, paramLong1, 301L);
      localeq.rP(paramString1);
      localeq.mX(paramLong2);
      localeq.rN(paramString2);
      localeq.mY(paramLong3);
      localeq.rO(paramString3);
      localeq.rM(paramString4);
      localeq.bfK();
      AppMethodBeat.o(190335);
    }
    
    public static void a(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, long paramLong3)
    {
      AppMethodBeat.i(190334);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "fromUsername");
      p.h(paramString3, "toUsername");
      eq localeq = a(3L, 302L, 3L, paramLong3, 301L);
      localeq.rP(paramString1);
      localeq.mX(paramLong1);
      localeq.rN(paramString2);
      localeq.mY(paramLong2);
      localeq.rO(paramString3);
      paramString1 = new JSONObject();
      paramString1.put("ser_name", 4L);
      localeq.rQ(URLEncoder.encode(paramString1.toString()));
      localeq.bfK();
      AppMethodBeat.o(190334);
    }
    
    public static void t(String paramString, long paramLong)
    {
      AppMethodBeat.i(190330);
      p.h(paramString, "defaultTab");
      eq localeq = a(1L, 101L, 0L, 1L, paramLong);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("default_tab", paramString);
      localeq.rQ(URLEncoder.encode(localJSONObject.toString()));
      localeq.bfK();
      AppMethodBeat.o(190330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.report.c
 * JD-Core Version:    0.7.0.1
 */