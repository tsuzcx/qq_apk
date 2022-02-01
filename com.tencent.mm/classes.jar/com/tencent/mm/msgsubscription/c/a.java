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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter;", "", "()V", "TAG", "", "TYPE_APP_BRAND", "", "TYPE_BIZ_SERVICE_BRAND", "lastShowReportTimestamp", "mInfoButtonClickCountList", "", "mInfoButtonClickIndexList", "mTemplateCount", "sessionId", "", "addInfoButtonClick", "", "index", "buildInfoButtonClickInfoString", "Lkotlin/Pair;", "buildTemplateItemsJson", "subscribeMsgTmpItemList", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "createSession", "templateCount", "getUid", "bizUsername", "timestamp", "reportSubscribeAuthInBrandChat", "showType", "content", "reportSubscribeMsgDialogOp", "opType", "reportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "reportSubscribeMsgListOfProfile", "switchOpen", "", "reportSubscribeMsgOpInNotifyMessage", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgReportInfo;", "reportSubscribeMsgRequestDialogOp", "accType", "operationType", "reportSubscribeMsgSettingOp", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "reportSubscribeStatusOpInNotifyMessage", "templateId", "status", "templateName", "type", "ShowType", "SubscribeDialogReportInfo", "SubscribeMsgReportInfo", "SubscribeMsgSettingReportInfo", "SubscribeResultReportShowType", "plugin-comm_release"})
public final class a
{
  private static List<Integer> mpV;
  private static List<Integer> mpW;
  private static int mpX;
  private static int mpY;
  public static final a mpZ;
  private static long sessionId;
  
  static
  {
    AppMethodBeat.i(149597);
    mpZ = new a();
    sessionId = -1L;
    mpV = (List)new ArrayList();
    mpW = (List)new ArrayList();
    AppMethodBeat.o(149597);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(197722);
    p.k(parama, "reportInfo");
    if (paramInt != 5)
    {
      h.IzE.a(21802, new Object[] { parama.fOX, parama.sessionId, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), j.a((Iterable)parama.mpy, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)parama.mqa, (CharSequence)"#", null, null, 0, null, null, 62), Integer.valueOf(parama.mqb), parama.mpE, Integer.valueOf(1) });
      AppMethodBeat.o(197722);
      return;
    }
    h.IzE.a(21802, new Object[] { parama.fOX, parama.sessionId, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), "", "", Integer.valueOf(0), parama.mpE });
    AppMethodBeat.o(197722);
  }
  
  public static final void a(int paramInt, a.b paramb)
  {
    AppMethodBeat.i(197726);
    p.k(paramb, "reportInfo");
    Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgOpInNotifyMessage opType: %s, username: %s, jumpType: %s, jumpInfo: %s", new Object[] { Integer.valueOf(paramInt), paramb.username, Integer.valueOf(paramb.jumpType), paramb.mqd });
    if ((paramInt == 1) && (mpY != 0) && (System.currentTimeMillis() - mpY <= 1000L))
    {
      AppMethodBeat.o(197726);
      return;
    }
    h.IzE.a(21811, new Object[] { paramb.username, paramb.lnb, Integer.valueOf(paramb.mod), paramb.mqc, paramb.fQs, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramb.jumpType), paramb.mqd, Integer.valueOf(paramb.type) });
    AppMethodBeat.o(197726);
  }
  
  public static final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(197730);
    p.k(paramc, "reportInfo");
    h localh = h.IzE;
    String str = paramc.fOX;
    long l1 = paramc.sessionId;
    long l2 = System.currentTimeMillis();
    if (paramc.mqe) {}
    for (int i = 1;; i = 0)
    {
      localh.a(21814, new Object[] { str, Long.valueOf(l1), Integer.valueOf(paramInt), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(paramc.mqf), j.a((Iterable)paramc.mpy, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)paramc.mqa, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)paramc.mqh, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)paramc.mqg, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)paramc.mqi, (CharSequence)"#", null, null, 0, null, null, 62), Integer.valueOf(paramc.enterScene) });
      AppMethodBeat.o(197730);
      return;
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(149595);
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "content");
    paramString1 = z.bcZ() + "#" + paramString1 + "#" + String.valueOf(paramLong);
    h.IzE.a(17639, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(149595);
  }
  
  public static void b(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(149594);
    p.k(paramString1, "bizUsername");
    p.k(paramString2, "templateId");
    p.k(paramString3, "templateName");
    Log.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeStatusOpInNotifyMessage bizUsername: %s, showType: %d, templateId: %s, status: %d, templateName: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString3 });
    h.IzE.a(17638, new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString3, Integer.valueOf(1) });
    AppMethodBeat.o(149594);
  }
  
  public static void b(String paramString, boolean paramBoolean, List<SubscribeMsgTmpItem> paramList)
  {
    int i = 0;
    AppMethodBeat.i(149593);
    p.k(paramString, "bizUsername");
    p.k(paramList, "subscribeMsgTmpItemList");
    Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile bizUsername: %s, switchOpen: %b, size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(paramList.size()) });
    JSONArray localJSONArray = new JSONArray();
    paramList = ((Iterable)paramList).iterator();
    if (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scopeID", localSubscribeMsgTmpItem.lnb);
      localJSONObject.put("scopeName", localSubscribeMsgTmpItem.title);
      if (localSubscribeMsgTmpItem.mof == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localJSONObject.put("selected", bool);
        localJSONArray.put(localJSONObject);
        break;
      }
    }
    Log.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile json: %s", new Object[] { localJSONArray.toString() });
    paramList = h.IzE;
    if (paramBoolean) {
      i = 1;
    }
    paramList.a(17637, new Object[] { paramString, Integer.valueOf(i), localJSONArray.toString() });
    AppMethodBeat.o(149593);
  }
  
  public static void xr(int paramInt)
  {
    AppMethodBeat.i(149589);
    Log.i("MicroMsg.SubscribeMsgReporter", "alvinluo createSession templateCount: %d", new Object[] { Integer.valueOf(paramInt) });
    sessionId = System.currentTimeMillis();
    mpX = paramInt;
    mpV.clear();
    mpW.clear();
    if (paramInt > 0)
    {
      ArrayList localArrayList = new ArrayList(paramInt);
      int i = 0;
      while (i < paramInt)
      {
        localArrayList.add(Integer.valueOf(0));
        i += 1;
      }
      mpW = (List)localArrayList;
    }
    AppMethodBeat.o(149589);
  }
  
  public static void xs(int paramInt)
  {
    AppMethodBeat.i(149590);
    if (paramInt < mpX)
    {
      List localList = mpW;
      localList.set(paramInt, Integer.valueOf(((Number)localList.get(paramInt)).intValue() + 1));
    }
    AppMethodBeat.o(149590);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "bizUsername", "getBizUsername", "setBizUsername", "keepSelected", "", "getKeepSelected", "()I", "setKeepSelected", "(I)V", "sessionId", "getSessionId", "setSessionId", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIdList", "()Ljava/util/ArrayList;", "setTemplateIdList", "(Ljava/util/ArrayList;)V", "templateOriginStatusList", "getTemplateOriginStatusList", "setTemplateOriginStatusList", "SubscribeDialogOpType", "plugin-comm_release"})
  public static final class a
  {
    String fOX;
    String mpE;
    public ArrayList<String> mpy;
    public ArrayList<Integer> mqa;
    public int mqb;
    String sessionId;
    
    public a()
    {
      AppMethodBeat.i(213372);
      this.fOX = "";
      this.mpE = "";
      this.sessionId = "";
      this.mpy = new ArrayList();
      this.mqa = new ArrayList();
      AppMethodBeat.o(213372);
    }
    
    public final void YU(String paramString)
    {
      AppMethodBeat.i(213364);
      p.k(paramString, "<set-?>");
      this.fOX = paramString;
      AppMethodBeat.o(213364);
    }
    
    public final void YV(String paramString)
    {
      AppMethodBeat.i(213367);
      p.k(paramString, "<set-?>");
      this.mpE = paramString;
      AppMethodBeat.o(213367);
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(213369);
      p.k(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(213369);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "", "()V", "bizUsername", "", "getBizUsername", "()Ljava/lang/String;", "setBizUsername", "(Ljava/lang/String;)V", "enterScene", "", "getEnterScene", "()I", "setEnterScene", "(I)V", "sessionId", "", "getSessionId", "()J", "setSessionId", "(J)V", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIdList", "()Ljava/util/ArrayList;", "setTemplateIdList", "(Ljava/util/ArrayList;)V", "templateOriginStatusList", "getTemplateOriginStatusList", "setTemplateOriginStatusList", "templateSelectedStatusList", "getTemplateSelectedStatusList", "setTemplateSelectedStatusList", "templateSize", "getTemplateSize", "setTemplateSize", "templateTitleList", "getTemplateTitleList", "setTemplateTitleList", "templateTypeList", "getTemplateTypeList", "setTemplateTypeList", "totalSwitch", "", "getTotalSwitch", "()Z", "setTotalSwitch", "(Z)V", "SubscribeMsgSettingOpType", "plugin-comm_release"})
  public static final class c
  {
    public int enterScene;
    String fOX;
    public ArrayList<String> mpy;
    public ArrayList<Integer> mqa;
    public boolean mqe;
    public int mqf;
    public ArrayList<Integer> mqg;
    public ArrayList<String> mqh;
    public ArrayList<Integer> mqi;
    public long sessionId;
    
    public c()
    {
      AppMethodBeat.i(231014);
      this.fOX = "";
      this.mpy = new ArrayList();
      this.mqg = new ArrayList();
      this.mqh = new ArrayList();
      this.mqa = new ArrayList();
      this.mqi = new ArrayList();
      AppMethodBeat.o(231014);
    }
    
    public final void YU(String paramString)
    {
      AppMethodBeat.i(231013);
      p.k(paramString, "<set-?>");
      this.fOX = paramString;
      AppMethodBeat.o(231013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.c.a
 * JD-Core Version:    0.7.0.1
 */