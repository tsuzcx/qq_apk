package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter;", "", "()V", "TAG", "", "TYPE_APP_BRAND", "", "TYPE_BIZ_SERVICE_BRAND", "lastShowReportTimestamp", "mInfoButtonClickCountList", "", "mInfoButtonClickIndexList", "mTemplateCount", "sessionId", "", "addInfoButtonClick", "", "index", "buildInfoButtonClickInfoString", "Lkotlin/Pair;", "buildTemplateItemsJson", "subscribeMsgTmpItemList", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "createSession", "templateCount", "getUid", "bizUsername", "timestamp", "reportSubscribeAuthInBrandChat", "showType", "content", "reportSubscribeMsgDialogOp", "opType", "reportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "reportSubscribeMsgListOfProfile", "switchOpen", "", "reportSubscribeMsgOpInNotifyMessage", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgReportInfo;", "reportSubscribeMsgRequestDialogOp", "accType", "operationType", "reportSubscribeMsgSettingOp", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "reportSubscribeStatusOpInNotifyMessage", "templateId", "status", "templateName", "type", "ShowType", "SubscribeDialogReportInfo", "SubscribeMsgReportInfo", "SubscribeMsgSettingReportInfo", "SubscribeResultReportShowType", "plugin-comm_release"})
public final class a
{
  private static List<Integer> jAn;
  private static List<Integer> jAo;
  private static int jAp;
  private static int jAq;
  public static final a jAr;
  private static long sessionId;
  
  static
  {
    AppMethodBeat.i(149597);
    jAr = new a();
    sessionId = -1L;
    jAn = (List)new ArrayList();
    jAo = (List)new ArrayList();
    AppMethodBeat.o(149597);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(223336);
    p.h(parama, "reportInfo");
    if (paramInt != 5)
    {
      h.CyF.a(21802, new Object[] { parama.dVu, parama.sessionId, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), j.a((Iterable)parama.jzS, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)parama.jAs, (CharSequence)"#", null, null, 0, null, null, 62), Integer.valueOf(parama.jAt), parama.jzY, Integer.valueOf(1) });
      AppMethodBeat.o(223336);
      return;
    }
    h.CyF.a(21802, new Object[] { parama.dVu, parama.sessionId, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), "", "", Integer.valueOf(0), parama.jzY });
    AppMethodBeat.o(223336);
  }
  
  public static final void a(int paramInt, a.b paramb)
  {
    AppMethodBeat.i(223337);
    p.h(paramb, "reportInfo");
    Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgOpInNotifyMessage opType: %s, username: %s, jumpType: %s, jumpInfo: %s", new Object[] { Integer.valueOf(paramInt), paramb.username, Integer.valueOf(paramb.jumpType), paramb.jAv });
    if ((paramInt == 1) && (jAq != 0) && (System.currentTimeMillis() - jAq <= 1000L))
    {
      AppMethodBeat.o(223337);
      return;
    }
    h.CyF.a(21811, new Object[] { paramb.username, paramb.ixM, Integer.valueOf(paramb.jyz), paramb.jAu, paramb.dWG, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramb.jumpType), paramb.jAv, Integer.valueOf(paramb.type) });
    AppMethodBeat.o(223337);
  }
  
  public static final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(223338);
    p.h(paramc, "reportInfo");
    h localh = h.CyF;
    String str = paramc.dVu;
    long l1 = paramc.sessionId;
    long l2 = System.currentTimeMillis();
    if (paramc.jAw) {}
    for (int i = 1;; i = 0)
    {
      localh.a(21814, new Object[] { str, Long.valueOf(l1), Integer.valueOf(paramInt), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramc.jAx), j.a((Iterable)paramc.jzS, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)paramc.jAs, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)paramc.jAz, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)paramc.jAy, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)paramc.jAA, (CharSequence)"#", null, null, 0, null, null, 62), Integer.valueOf(paramc.enterScene) });
      AppMethodBeat.o(223338);
      return;
    }
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(149594);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    p.h(paramString3, "templateName");
    Log.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeStatusOpInNotifyMessage bizUsername: %s, showType: %d, templateId: %s, status: %d, templateName: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString3 });
    h.CyF.a(17638, new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString3, Integer.valueOf(1) });
    AppMethodBeat.o(149594);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(149595);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "content");
    paramString1 = z.aTY() + "#" + paramString1 + "#" + String.valueOf(paramLong);
    h.CyF.a(17639, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(149595);
  }
  
  public static void b(String paramString, boolean paramBoolean, List<SubscribeMsgTmpItem> paramList)
  {
    int i = 0;
    AppMethodBeat.i(149593);
    p.h(paramString, "bizUsername");
    p.h(paramList, "subscribeMsgTmpItemList");
    Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile bizUsername: %s, switchOpen: %b, size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(paramList.size()) });
    JSONArray localJSONArray = new JSONArray();
    paramList = ((Iterable)paramList).iterator();
    if (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scopeID", localSubscribeMsgTmpItem.ixM);
      localJSONObject.put("scopeName", localSubscribeMsgTmpItem.title);
      if (localSubscribeMsgTmpItem.jyB == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localJSONObject.put("selected", bool);
        localJSONArray.put(localJSONObject);
        break;
      }
    }
    Log.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile json: %s", new Object[] { localJSONArray.toString() });
    paramList = h.CyF;
    if (paramBoolean) {
      i = 1;
    }
    paramList.a(17637, new Object[] { paramString, Integer.valueOf(i), localJSONArray.toString() });
    AppMethodBeat.o(149593);
  }
  
  public static void uq(int paramInt)
  {
    AppMethodBeat.i(149589);
    Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo createSession templateCount: %d", new Object[] { Integer.valueOf(paramInt) });
    sessionId = System.currentTimeMillis();
    jAp = paramInt;
    jAn.clear();
    jAo.clear();
    if (paramInt > 0)
    {
      ArrayList localArrayList = new ArrayList(paramInt);
      int i = 0;
      while (i < paramInt)
      {
        localArrayList.add(Integer.valueOf(0));
        i += 1;
      }
      jAo = (List)localArrayList;
    }
    AppMethodBeat.o(149589);
  }
  
  public static void ur(int paramInt)
  {
    AppMethodBeat.i(149590);
    if (paramInt < jAp)
    {
      List localList = jAo;
      localList.set(paramInt, Integer.valueOf(((Number)localList.get(paramInt)).intValue() + 1));
    }
    AppMethodBeat.o(149590);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "bizUsername", "getBizUsername", "setBizUsername", "keepSelected", "", "getKeepSelected", "()I", "setKeepSelected", "(I)V", "sessionId", "getSessionId", "setSessionId", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIdList", "()Ljava/util/ArrayList;", "setTemplateIdList", "(Ljava/util/ArrayList;)V", "templateOriginStatusList", "getTemplateOriginStatusList", "setTemplateOriginStatusList", "SubscribeDialogOpType", "plugin-comm_release"})
  public static final class a
  {
    String dVu;
    public ArrayList<Integer> jAs;
    public int jAt;
    public ArrayList<String> jzS;
    String jzY;
    String sessionId;
    
    public a()
    {
      AppMethodBeat.i(223332);
      this.dVu = "";
      this.jzY = "";
      this.sessionId = "";
      this.jzS = new ArrayList();
      this.jAs = new ArrayList();
      AppMethodBeat.o(223332);
    }
    
    public final void Rx(String paramString)
    {
      AppMethodBeat.i(223329);
      p.h(paramString, "<set-?>");
      this.dVu = paramString;
      AppMethodBeat.o(223329);
    }
    
    public final void Ry(String paramString)
    {
      AppMethodBeat.i(223330);
      p.h(paramString, "<set-?>");
      this.jzY = paramString;
      AppMethodBeat.o(223330);
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(223331);
      p.h(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(223331);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "", "()V", "bizUsername", "", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", "(Ljava/lang/String;)V", "enterScene", "", "getEnterScene", "()I", "setEnterScene", "(I)V", "sessionId", "", "getSessionId", "()J", "setSessionId", "(J)V", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIdList", "()Ljava/util/ArrayList;", "setTemplateIdList", "(Ljava/util/ArrayList;)V", "templateOriginStatusList", "getTemplateOriginStatusList", "setTemplateOriginStatusList", "templateSelectedStatusList", "getTemplateSelectedStatusList", "setTemplateSelectedStatusList", "templateSize", "getTemplateSize", "setTemplateSize", "templateTitleList", "getTemplateTitleList", "setTemplateTitleList", "templateTypeList", "getTemplateTypeList", "setTemplateTypeList", "totalSwitch", "", "getTotalSwitch", "()Z", "setTotalSwitch", "(Z)V", "SubscribeMsgSettingOpType", "plugin-comm_release"})
  public static final class c
  {
    String dVu;
    public int enterScene;
    public ArrayList<Integer> jAA;
    public ArrayList<Integer> jAs;
    public boolean jAw;
    public int jAx;
    public ArrayList<Integer> jAy;
    public ArrayList<String> jAz;
    public ArrayList<String> jzS;
    public long sessionId;
    
    public c()
    {
      AppMethodBeat.i(223335);
      this.dVu = "";
      this.jzS = new ArrayList();
      this.jAy = new ArrayList();
      this.jAz = new ArrayList();
      this.jAs = new ArrayList();
      this.jAA = new ArrayList();
      AppMethodBeat.o(223335);
    }
    
    public final void Rx(String paramString)
    {
      AppMethodBeat.i(223334);
      p.h(paramString, "<set-?>");
      this.dVu = paramString;
      AppMethodBeat.o(223334);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.a
 * JD-Core Version:    0.7.0.1
 */