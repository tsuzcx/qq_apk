package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter;", "", "()V", "TAG", "", "TYPE_APP_BRAND", "", "TYPE_BIZ_SERVICE_BRAND", "mInfoButtonClickCountList", "", "mInfoButtonClickIndexList", "mTemplateCount", "sessionId", "", "addInfoButtonClick", "", "index", "buildInfoButtonClickInfoString", "Lkotlin/Pair;", "buildTemplateItemsJson", "subscribeMsgTmpItemList", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "createSession", "templateCount", "getUid", "bizUsername", "timestamp", "reportSubscribeAuthInBrandChat", "showType", "content", "reportSubscribeMsgListOfProfile", "switchOpen", "", "reportSubscribeMsgRequestDialogOp", "accType", "operationType", "reportSubscribeStatusOpInNotifyMessage", "templateId", "status", "templateName", "type", "ShowType", "plugin-comm_release"})
public final class a
{
  private static List<Integer> ihJ;
  private static List<Integer> ihK;
  private static int ihL;
  public static final a ihM;
  private static long sessionId;
  
  static
  {
    AppMethodBeat.i(149597);
    ihM = new a();
    sessionId = -1L;
    ihJ = (List)new ArrayList();
    ihK = (List)new ArrayList();
    AppMethodBeat.o(149597);
  }
  
  private static String E(String paramString, long paramLong)
  {
    AppMethodBeat.i(149596);
    paramString = u.axw() + "#" + paramString + "#" + String.valueOf(paramLong);
    AppMethodBeat.o(149596);
    return paramString;
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(149594);
    k.h(paramString1, "bizUsername");
    k.h(paramString2, "templateId");
    k.h(paramString3, "templateName");
    ac.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeStatusOpInNotifyMessage bizUsername: %s, showType: %d, templateId: %s, status: %d, templateName: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString3 });
    h.wUl.f(17638, new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString3, Integer.valueOf(1) });
    AppMethodBeat.o(149594);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(149595);
    k.h(paramString1, "bizUsername");
    k.h(paramString2, "content");
    paramString1 = E(paramString1, paramLong);
    h.wUl.f(17639, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(149595);
  }
  
  public static void a(String paramString, int paramInt, List<SubscribeMsgTmpItem> paramList, long paramLong)
  {
    AppMethodBeat.i(149591);
    k.h(paramString, "bizUsername");
    k.h(paramList, "subscribeMsgTmpItemList");
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = (List)new ArrayList();
    Object localObject3 = (Iterable)ihK;
    int i = 0;
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (i < 0) {
        j.fOc();
      }
      int j = ((Number)localObject4).intValue();
      if (j > 0)
      {
        ((List)localObject1).add(Integer.valueOf(i));
        ((List)localObject2).add(Integer.valueOf(j));
      }
      i += 1;
    }
    localObject1 = new o(j.a((Iterable)localObject1, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)localObject2, (CharSequence)"#", null, null, 0, null, null, 62));
    paramList = az(paramList);
    localObject2 = E(paramString, paramLong);
    ac.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgRequestDialogOp templateJson: %s, bizUsername: %s, operationType: %d", new Object[] { paramList, paramString, Integer.valueOf(paramInt) });
    h.wUl.f(17524, new Object[] { Integer.valueOf(0), paramList, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString, "", ((o)localObject1).first, ((o)localObject1).second, Integer.valueOf(2), localObject2 });
    AppMethodBeat.o(149591);
  }
  
  private static String az(List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(149592);
    JSONArray localJSONArray = new JSONArray();
    paramList = ((Iterable)paramList).iterator();
    if (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("templateId", localSubscribeMsgTmpItem.hiK);
      localJSONObject.put("templateType", localSubscribeMsgTmpItem.igW);
      if (localSubscribeMsgTmpItem.igB == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localJSONObject.put("selected", bool);
        localJSONArray.put(localJSONObject);
        break;
      }
    }
    paramList = localJSONArray.toString();
    k.g(paramList, "jsonArray.toString()");
    AppMethodBeat.o(149592);
    return paramList;
  }
  
  public static void b(String paramString, boolean paramBoolean, List<SubscribeMsgTmpItem> paramList)
  {
    int i = 0;
    AppMethodBeat.i(149593);
    k.h(paramString, "bizUsername");
    k.h(paramList, "subscribeMsgTmpItemList");
    ac.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile bizUsername: %s, switchOpen: %b, size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(paramList.size()) });
    JSONArray localJSONArray = new JSONArray();
    paramList = ((Iterable)paramList).iterator();
    if (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scopeID", localSubscribeMsgTmpItem.hiK);
      localJSONObject.put("scopeName", localSubscribeMsgTmpItem.title);
      if (localSubscribeMsgTmpItem.igY == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localJSONObject.put("selected", bool);
        localJSONArray.put(localJSONObject);
        break;
      }
    }
    ac.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile json: %s", new Object[] { localJSONArray.toString() });
    paramList = h.wUl;
    if (paramBoolean) {
      i = 1;
    }
    paramList.f(17637, new Object[] { paramString, Integer.valueOf(i), localJSONArray.toString() });
    AppMethodBeat.o(149593);
  }
  
  public static void pT(int paramInt)
  {
    AppMethodBeat.i(149589);
    ac.i("MicroMsg.SubscribeMsgReporter", "alvinluo createSession templateCount: %d", new Object[] { Integer.valueOf(paramInt) });
    sessionId = System.currentTimeMillis();
    ihL = paramInt;
    ihJ.clear();
    ihK.clear();
    if (paramInt > 0)
    {
      ArrayList localArrayList = new ArrayList(paramInt);
      int i = 0;
      while (i < paramInt)
      {
        localArrayList.add(Integer.valueOf(0));
        i += 1;
      }
      ihK = (List)localArrayList;
    }
    AppMethodBeat.o(149589);
  }
  
  public static void pU(int paramInt)
  {
    AppMethodBeat.i(149590);
    if (paramInt < ihL)
    {
      List localList = ihK;
      localList.set(paramInt, Integer.valueOf(((Number)localList.get(paramInt)).intValue() + 1));
    }
    AppMethodBeat.o(149590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a
 * JD-Core Version:    0.7.0.1
 */