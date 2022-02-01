package com.tencent.mm.msgsubscription.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter;", "", "()V", "TAG", "", "TYPE_APP_BRAND", "", "TYPE_BIZ_SERVICE_BRAND", "lastShowReportTimestamp", "mInfoButtonClickCountList", "", "mInfoButtonClickIndexList", "mTemplateCount", "sessionId", "", "addInfoButtonClick", "", "index", "buildInfoButtonClickInfoString", "Lkotlin/Pair;", "buildTemplateItemsJson", "subscribeMsgTmpItemList", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "createSession", "templateCount", "getUid", "bizUsername", "timestamp", "reportSubscribeAuthInBrandChat", "showType", "content", "reportSubscribeMsgDialogOp", "opType", "reportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "reportSubscribeMsgListOfProfile", "switchOpen", "", "reportSubscribeMsgOpInNotifyMessage", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgReportInfo;", "reportSubscribeMsgRequestDialogOp", "accType", "operationType", "reportSubscribeMsgSettingOp", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "reportSubscribeStatusOpInNotifyMessage", "templateId", "status", "templateName", "type", "ShowType", "SubscribeDialogReportInfo", "SubscribeMsgReportInfo", "SubscribeMsgSettingReportInfo", "SubscribeResultReportShowType", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a pjH;
  private static List<Integer> pjI;
  private static List<Integer> pjJ;
  private static int pjK;
  private static int pjL;
  private static long sessionId;
  
  static
  {
    AppMethodBeat.i(149597);
    pjH = new a();
    sessionId = -1L;
    pjI = (List)new ArrayList();
    pjJ = (List)new ArrayList();
    AppMethodBeat.o(149597);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(236279);
    s.u(parama, "reportInfo");
    if (paramInt != 5)
    {
      h.OAn.b(21802, new Object[] { parama.hUQ, parama.sessionId, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), p.a((Iterable)parama.pjo, (CharSequence)"#", null, null, 0, null, null, 62), p.a((Iterable)parama.pjM, (CharSequence)"#", null, null, 0, null, null, 62), Integer.valueOf(parama.pjN), parama.pjl, Integer.valueOf(1) });
      AppMethodBeat.o(236279);
      return;
    }
    h.OAn.b(21802, new Object[] { parama.hUQ, parama.sessionId, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), "", "", Integer.valueOf(0), parama.pjl });
    AppMethodBeat.o(236279);
  }
  
  public static final void a(int paramInt, a.b paramb)
  {
    AppMethodBeat.i(236287);
    s.u(paramb, "reportInfo");
    Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgOpInNotifyMessage opType: %s, username: %s, jumpType: %s, jumpInfo: %s", new Object[] { Integer.valueOf(paramInt), paramb.username, Integer.valueOf(paramb.jumpType), paramb.pjP });
    if ((paramInt == 1) && (pjL != 0) && (System.currentTimeMillis() - pjL <= 1000L))
    {
      AppMethodBeat.o(236287);
      return;
    }
    h.OAn.b(21811, new Object[] { paramb.username, paramb.nSg, Integer.valueOf(paramb.phR), paramb.pjO, paramb.hWn, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramb.jumpType), paramb.pjP, Integer.valueOf(paramb.type) });
    AppMethodBeat.o(236287);
  }
  
  public static final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(236292);
    s.u(paramc, "reportInfo");
    h localh = h.OAn;
    String str = paramc.hUQ;
    long l1 = paramc.sessionId;
    long l2 = System.currentTimeMillis();
    if (paramc.pjQ) {}
    for (int i = 1;; i = 0)
    {
      localh.b(21814, new Object[] { str, Long.valueOf(l1), Integer.valueOf(paramInt), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramc.pjR), p.a((Iterable)paramc.pjo, (CharSequence)"#", null, null, 0, null, null, 62), p.a((Iterable)paramc.pjM, (CharSequence)"#", null, null, 0, null, null, 62), p.a((Iterable)paramc.pjT, (CharSequence)"#", null, null, 0, null, null, 62), p.a((Iterable)paramc.pjS, (CharSequence)"#", null, null, 0, null, null, 62), p.a((Iterable)paramc.pjU, (CharSequence)"#", null, null, 0, null, null, 62), Integer.valueOf(paramc.enterScene) });
      AppMethodBeat.o(236292);
      return;
    }
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(236271);
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "templateId");
    s.u(paramString3, "templateName");
    Log.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeStatusOpInNotifyMessage bizUsername: %s, showType: %d, templateId: %s, status: %d, templateName: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString3 });
    h.OAn.b(17638, new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString3, Integer.valueOf(paramInt3) });
    AppMethodBeat.o(236271);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(149595);
    s.u(paramString1, "bizUsername");
    s.u(paramString2, "content");
    paramString1 = z.bAM() + '#' + paramString1 + '#' + paramLong;
    h.OAn.b(17639, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(149595);
  }
  
  public static void b(String paramString, boolean paramBoolean, List<SubscribeMsgTmpItem> paramList)
  {
    int i = 0;
    AppMethodBeat.i(149593);
    s.u(paramString, "bizUsername");
    s.u(paramList, "subscribeMsgTmpItemList");
    Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile bizUsername: %s, switchOpen: %b, size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(paramList.size()) });
    JSONArray localJSONArray = new JSONArray();
    paramList = ((Iterable)paramList).iterator();
    if (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scopeID", localSubscribeMsgTmpItem.nSg);
      localJSONObject.put("scopeName", localSubscribeMsgTmpItem.title);
      if (localSubscribeMsgTmpItem.phT == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localJSONObject.put("selected", bool);
        localJSONArray.put(localJSONObject);
        break;
      }
    }
    Log.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile json: %s", new Object[] { localJSONArray.toString() });
    paramList = h.OAn;
    if (paramBoolean) {
      i = 1;
    }
    paramList.b(17637, new Object[] { paramString, Integer.valueOf(i), localJSONArray.toString() });
    AppMethodBeat.o(149593);
  }
  
  public static void xr(int paramInt)
  {
    AppMethodBeat.i(149589);
    Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo createSession templateCount: %d", new Object[] { Integer.valueOf(paramInt) });
    sessionId = System.currentTimeMillis();
    pjK = paramInt;
    pjI.clear();
    pjJ.clear();
    if (paramInt > 0)
    {
      ArrayList localArrayList = new ArrayList(paramInt);
      int i = 0;
      while (i < paramInt)
      {
        localArrayList.add(Integer.valueOf(0));
        i += 1;
      }
      pjJ = (List)localArrayList;
    }
    AppMethodBeat.o(149589);
  }
  
  public static void xs(int paramInt)
  {
    AppMethodBeat.i(149590);
    if (paramInt < pjK)
    {
      List localList = pjJ;
      localList.set(paramInt, Integer.valueOf(((Number)localList.get(paramInt)).intValue() + 1));
    }
    AppMethodBeat.o(149590);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "bizUsername", "getBizUsername", "setBizUsername", "keepSelected", "", "getKeepSelected", "()I", "setKeepSelected", "(I)V", "sessionId", "getSessionId", "setSessionId", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIdList", "()Ljava/util/ArrayList;", "setTemplateIdList", "(Ljava/util/ArrayList;)V", "templateOriginStatusList", "getTemplateOriginStatusList", "setTemplateOriginStatusList", "SubscribeDialogOpType", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    String hUQ;
    public ArrayList<Integer> pjM;
    public int pjN;
    String pjl;
    public ArrayList<String> pjo;
    String sessionId;
    
    public a()
    {
      AppMethodBeat.i(236251);
      this.hUQ = "";
      this.pjl = "";
      this.sessionId = "";
      this.pjo = new ArrayList();
      this.pjM = new ArrayList();
      AppMethodBeat.o(236251);
    }
    
    public final void QZ(String paramString)
    {
      AppMethodBeat.i(236252);
      s.u(paramString, "<set-?>");
      this.hUQ = paramString;
      AppMethodBeat.o(236252);
    }
    
    public final void Ra(String paramString)
    {
      AppMethodBeat.i(236256);
      s.u(paramString, "<set-?>");
      this.pjl = paramString;
      AppMethodBeat.o(236256);
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(236259);
      s.u(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(236259);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "", "()V", "bizUsername", "", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", "(Ljava/lang/String;)V", "enterScene", "", "getEnterScene", "()I", "setEnterScene", "(I)V", "sessionId", "", "getSessionId", "()J", "setSessionId", "(J)V", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIdList", "()Ljava/util/ArrayList;", "setTemplateIdList", "(Ljava/util/ArrayList;)V", "templateOriginStatusList", "getTemplateOriginStatusList", "setTemplateOriginStatusList", "templateSelectedStatusList", "getTemplateSelectedStatusList", "setTemplateSelectedStatusList", "templateSize", "getTemplateSize", "setTemplateSize", "templateTitleList", "getTemplateTitleList", "setTemplateTitleList", "templateTypeList", "getTemplateTypeList", "setTemplateTypeList", "totalSwitch", "", "getTotalSwitch", "()Z", "setTotalSwitch", "(Z)V", "SubscribeMsgSettingOpType", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public int enterScene;
    String hUQ;
    public ArrayList<Integer> pjM;
    public boolean pjQ;
    public int pjR;
    public ArrayList<Integer> pjS;
    public ArrayList<String> pjT;
    public ArrayList<Integer> pjU;
    public ArrayList<String> pjo;
    public long sessionId;
    
    public c()
    {
      AppMethodBeat.i(236254);
      this.hUQ = "";
      this.pjo = new ArrayList();
      this.pjS = new ArrayList();
      this.pjT = new ArrayList();
      this.pjM = new ArrayList();
      this.pjU = new ArrayList();
      AppMethodBeat.o(236254);
    }
    
    public final void QZ(String paramString)
    {
      AppMethodBeat.i(236258);
      s.u(paramString, "<set-?>");
      this.hUQ = paramString;
      AppMethodBeat.o(236258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.a
 * JD-Core Version:    0.7.0.1
 */