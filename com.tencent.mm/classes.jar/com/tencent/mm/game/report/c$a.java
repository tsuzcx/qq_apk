package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.fq;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/game/report/Kv20488$Companion;", "", "()V", "ACCOUNT_TYPE_GAME", "", "ACCOUNT_TYPE_WECHAT_GAME", "ACTION_CLICK", "ACTION_CLICK_CANCEL", "ACTION_CONFIRM_ADD_BLACKLIST", "ACTION_CONFIRM_REMOVE_BLACKLIST", "ACTION_DELETE", "ACTION_DIALOG_CANCEL", "ACTION_EXPOSURE", "ACTION_JUMP_APPBRAND", "ACTION_JUMP_H5", "ACTION_JUMP_NATIVE", "ACTION_JUMP_URL", "ACTION_LEFT_SLIDE_OR_LONG_PRESS", "ACTION_SEND_SUCCESS", "ATTACH_ITEM_GIFT", "ATTACH_ITEM_LOCATION", "ATTACH_ITEM_PHOTO", "ATTACH_ITEM_VIDEO", "RED_DOT_TYPE_AVATAR", "", "RED_DOT_TYPE_AVATAR_AND_DOT", "RED_DOT_TYPE_EMPTY", "RED_DOT_TYPE_ICON", "RED_DOT_TYPE_NEW", "RED_DOT_TYPE_NORMAL", "RED_DOT_TYPE_NUMBER_DOT", "SCENEID_BOTTOM_TAB", "SCENEID_CHATTING", "SCENEID_CHATTING_DETAIL", "SCENEID_CONVERSATION_LIST", "TAG", "", "UIAREA_BOTTOM_TAB", "UIAREA_CHATTING", "UIAREA_CHATTING_DETAIL", "UIAREA_CHATTING_PANEL", "UIAREA_CONVERSATION_FUNCTION_BAR", "UIAREA_CONVERSATION_LIST", "UIAREA_EXPOSURE", "createReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/GameLifeSessionStruct;", "sceneId", "uiArea", "positionId", "actionId", "sourceId", "reportAttachItemClick", "", "sessionId", "fromAccountType", "fromUsername", "toAccountType", "toUsername", "serName", "reportAttachItemJump", "reportChattingDetailUIItem", "pos", "actionStatus", "roleType", "(IJLjava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "reportChattingItem", "reportConversationItem", "totalNum", "sessionType", "reportConversationLoadInitial", "reportConversationUIExposure", "reportEnterChattingDetailUI", "reportEnterGameTabHome", "defaultTab", "reportGameTabItemClicked", "tabKey", "redDotType", "reportGameTabItemExposure", "reportGameWeappTabClicked", "reportSelfProfileClick", "report-api_release"})
public final class c$a
{
  public static void Fp(long paramLong)
  {
    AppMethodBeat.i(199096);
    a(2L, 201L, 0L, 7L, paramLong).bpa();
    AppMethodBeat.o(199096);
  }
  
  public static fq a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    AppMethodBeat.i(199104);
    fq localfq = new fq();
    localfq.oy(paramLong1);
    localfq.oz(paramLong2);
    localfq.oA(paramLong3);
    localfq.oB(paramLong4);
    localfq.oC(paramLong5);
    AppMethodBeat.o(199104);
    return localfq;
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(199095);
    p.k(paramString, "tabKey");
    fq localfq = a(1L, 101L, paramInt1, 1L, paramLong);
    localfq.oF(paramInt2);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("red_dot", paramInt3);
    localJSONObject.put("tab_key", paramString);
    localfq.ve(URLEncoder.encode(localJSONObject.toString()));
    localfq.bpa();
    AppMethodBeat.o(199095);
  }
  
  public static void a(int paramInt1, long paramLong1, int paramInt2, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, long paramLong4, long paramLong5, String paramString4)
  {
    AppMethodBeat.i(199097);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "fromUsername");
    p.k(paramString3, "toUsername");
    fq localfq = a(2L, 202L, paramInt1, paramLong1, paramLong5);
    localfq.oF(paramInt2);
    localfq.vd(paramString1);
    localfq.oD(paramLong2);
    localfq.vb(paramString2);
    localfq.oE(paramLong3);
    localfq.vc(paramString3);
    localfq.va(paramString4);
    paramString1 = new JSONObject();
    paramString1.put("session_type", paramLong4);
    localfq.ve(URLEncoder.encode(paramString1.toString()));
    Log.d("Report.Kv20488", "vir:" + localfq.agI());
    localfq.bpa();
    AppMethodBeat.o(199097);
  }
  
  public static void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(199100);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "fromUsername");
    p.k(paramString3, "toUsername");
    fq localfq = a(3L, 301L, paramInt, paramLong1, 301L);
    localfq.vd(paramString1);
    localfq.oD(paramLong2);
    localfq.vb(paramString2);
    localfq.oE(paramLong3);
    localfq.vc(paramString3);
    localfq.va(paramString4);
    localfq.bpa();
    AppMethodBeat.o(199100);
  }
  
  public static void a(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, long paramLong3)
  {
    AppMethodBeat.i(199099);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "fromUsername");
    p.k(paramString3, "toUsername");
    fq localfq = a(3L, 302L, 3L, paramLong3, 301L);
    localfq.vd(paramString1);
    localfq.oD(paramLong1);
    localfq.vb(paramString2);
    localfq.oE(paramLong2);
    localfq.vc(paramString3);
    paramString1 = new JSONObject();
    paramString1.put("ser_name", 4L);
    localfq.ve(URLEncoder.encode(paramString1.toString()));
    localfq.bpa();
    AppMethodBeat.o(199099);
  }
  
  public static void q(String paramString, long paramLong)
  {
    AppMethodBeat.i(199090);
    p.k(paramString, "defaultTab");
    fq localfq = a(1L, 101L, 0L, 1L, paramLong);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("default_tab", paramString);
    localfq.ve(URLEncoder.encode(localJSONObject.toString()));
    localfq.bpa();
    AppMethodBeat.o(199090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.game.report.c.a
 * JD-Core Version:    0.7.0.1
 */