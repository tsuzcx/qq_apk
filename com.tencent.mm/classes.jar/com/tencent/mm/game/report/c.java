package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.net.URLEncoder;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/game/report/Kv20488;", "", "()V", "Companion", "report-api_release"})
public final class c
{
  public static final a grV;
  
  static
  {
    AppMethodBeat.i(217420);
    grV = new a((byte)0);
    AppMethodBeat.o(217420);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/game/report/Kv20488$Companion;", "", "()V", "ACCOUNT_TYPE_GAME", "", "ACCOUNT_TYPE_WECHAT_GAME", "ACTION_CLICK", "ACTION_CLICK_CANCEL", "ACTION_CONFIRM_ADD_BLACKLIST", "ACTION_CONFIRM_REMOVE_BLACKLIST", "ACTION_DELETE", "ACTION_DIALOG_CANCEL", "ACTION_EXPOSURE", "ACTION_JUMP_APPBRAND", "ACTION_JUMP_H5", "ACTION_JUMP_NATIVE", "ACTION_JUMP_URL", "ACTION_LEFT_SLIDE_OR_LONG_PRESS", "ACTION_SEND_SUCCESS", "ATTACH_ITEM_GIFT", "ATTACH_ITEM_LOCATION", "ATTACH_ITEM_PHOTO", "ATTACH_ITEM_VIDEO", "RED_DOT_TYPE_AVATAR", "", "RED_DOT_TYPE_AVATAR_AND_DOT", "RED_DOT_TYPE_EMPTY", "RED_DOT_TYPE_ICON", "RED_DOT_TYPE_NEW", "RED_DOT_TYPE_NORMAL", "RED_DOT_TYPE_NUMBER_DOT", "SCENEID_BOTTOM_TAB", "SCENEID_CHATTING", "SCENEID_CHATTING_DETAIL", "SCENEID_CONVERSATION_LIST", "TAG", "", "UIAREA_BOTTOM_TAB", "UIAREA_CHATTING", "UIAREA_CHATTING_DETAIL", "UIAREA_CHATTING_PANEL", "UIAREA_CONVERSATION_FUNCTION_BAR", "UIAREA_CONVERSATION_LIST", "UIAREA_EXPOSURE", "createReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/GameLifeSessionStruct;", "sceneId", "uiArea", "positionId", "actionId", "sourceId", "reportAttachItemClick", "", "sessionId", "fromAccountType", "fromUsername", "toAccountType", "toUsername", "serName", "reportAttachItemJump", "reportChattingDetailUIItem", "pos", "actionStatus", "roleType", "(IJLjava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "reportChattingItem", "reportConversationItem", "totalNum", "sessionType", "reportConversationLoadInitial", "reportConversationUIExposure", "reportEnterChattingDetailUI", "reportEnterGameTabHome", "defaultTab", "reportGameTabItemClicked", "tabKey", "redDotType", "reportGameTabItemExposure", "reportGameWeappTabClicked", "reportSelfProfileClick", "report-api_release"})
  public static final class a
  {
    public static cf a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      AppMethodBeat.i(217419);
      cf localcf = new cf();
      localcf.hR(paramLong1);
      localcf.hS(paramLong2);
      localcf.hT(paramLong3);
      localcf.hU(paramLong4);
      localcf.hV(paramLong5);
      AppMethodBeat.o(217419);
      return localcf;
    }
    
    public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(217414);
      p.h(paramString, "tabKey");
      cf localcf = a(1L, 101L, paramInt1, 1L, paramLong);
      localcf.hY(paramInt2);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("red_dot", paramInt3);
      localJSONObject.put("tab_key", paramString);
      localcf.lI(URLEncoder.encode(localJSONObject.toString()));
      localcf.aLk();
      AppMethodBeat.o(217414);
    }
    
    public static void a(int paramInt1, long paramLong1, int paramInt2, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, long paramLong4, long paramLong5, String paramString4)
    {
      AppMethodBeat.i(217415);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "fromUsername");
      p.h(paramString3, "toUsername");
      cf localcf = a(2L, 202L, paramInt1, paramLong1, paramLong5);
      localcf.hY(paramInt2);
      localcf.lH(paramString1);
      localcf.hW(paramLong2);
      localcf.lF(paramString2);
      localcf.hX(paramLong3);
      localcf.lG(paramString3);
      localcf.lE(paramString4);
      paramString1 = new JSONObject();
      paramString1.put("session_type", paramLong4);
      localcf.lI(URLEncoder.encode(paramString1.toString()));
      ad.d("Report.Kv20488", "vir:" + localcf.RE());
      localcf.aLk();
      AppMethodBeat.o(217415);
    }
    
    public static void a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, String paramString4)
    {
      AppMethodBeat.i(217418);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "fromUsername");
      p.h(paramString3, "toUsername");
      cf localcf = a(3L, 301L, paramInt, paramLong1, 301L);
      localcf.lH(paramString1);
      localcf.hW(paramLong2);
      localcf.lF(paramString2);
      localcf.hX(paramLong3);
      localcf.lG(paramString3);
      localcf.lE(paramString4);
      localcf.aLk();
      AppMethodBeat.o(217418);
    }
    
    public static void a(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, long paramLong3)
    {
      AppMethodBeat.i(217417);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "fromUsername");
      p.h(paramString3, "toUsername");
      cf localcf = a(3L, 302L, 3L, paramLong3, 301L);
      localcf.lH(paramString1);
      localcf.hW(paramLong1);
      localcf.lF(paramString2);
      localcf.hX(paramLong2);
      localcf.lG(paramString3);
      paramString1 = new JSONObject();
      paramString1.put("ser_name", 4L);
      localcf.lI(URLEncoder.encode(paramString1.toString()));
      localcf.aLk();
      AppMethodBeat.o(217417);
    }
    
    public static void s(String paramString, long paramLong)
    {
      AppMethodBeat.i(217413);
      p.h(paramString, "defaultTab");
      cf localcf = a(1L, 101L, 0L, 1L, paramLong);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("default_tab", paramString);
      localcf.lI(URLEncoder.encode(localJSONObject.toString()));
      localcf.aLk();
      AppMethodBeat.o(217413);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.game.report.c
 * JD-Core Version:    0.7.0.1
 */