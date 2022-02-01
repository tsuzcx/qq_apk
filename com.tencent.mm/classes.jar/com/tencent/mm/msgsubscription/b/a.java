package com.tencent.mm.msgsubscription.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter;", "", "()V", "TAG", "", "TYPE_APP_BRAND", "", "TYPE_BIZ_SERVICE_BRAND", "mInfoButtonClickCountList", "", "mInfoButtonClickIndexList", "mTemplateCount", "sessionId", "", "addInfoButtonClick", "", "index", "buildInfoButtonClickInfoString", "Lkotlin/Pair;", "buildTemplateItemsJson", "subscribeMsgTmpItemList", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "createSession", "templateCount", "getUid", "bizUsername", "timestamp", "reportSubscribeAuthInBrandChat", "showType", "content", "reportSubscribeMsgListOfProfile", "switchOpen", "", "reportSubscribeMsgRequestDialogOp", "accType", "operationType", "reportSubscribeStatusOpInNotifyMessage", "templateId", "status", "templateName", "type", "ShowType", "plugin-comm_release"})
public final class a
{
  private static List<Integer> iDW;
  private static List<Integer> iDX;
  private static int iDY;
  public static final a iDZ;
  private static long sessionId;
  
  static
  {
    AppMethodBeat.i(149597);
    iDZ = new a();
    sessionId = -1L;
    iDW = (List)new ArrayList();
    iDX = (List)new ArrayList();
    AppMethodBeat.o(149597);
  }
  
  private static String J(String paramString, long paramLong)
  {
    AppMethodBeat.i(149596);
    paramString = v.aAC() + "#" + paramString + "#" + String.valueOf(paramLong);
    AppMethodBeat.o(149596);
    return paramString;
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(149594);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "templateId");
    p.h(paramString3, "templateName");
    ae.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeStatusOpInNotifyMessage bizUsername: %s, showType: %d, templateId: %s, status: %d, templateName: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString3 });
    g.yxI.f(17638, new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), paramString3, Integer.valueOf(1) });
    AppMethodBeat.o(149594);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(149595);
    p.h(paramString1, "bizUsername");
    p.h(paramString2, "content");
    paramString1 = J(paramString1, paramLong);
    g.yxI.f(17639, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    AppMethodBeat.o(149595);
  }
  
  public static void a(String paramString, int paramInt, List<SubscribeMsgTmpItem> paramList, long paramLong)
  {
    AppMethodBeat.i(149591);
    p.h(paramString, "bizUsername");
    p.h(paramList, "subscribeMsgTmpItemList");
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = (List)new ArrayList();
    Object localObject3 = (Iterable)iDX;
    int i = 0;
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (i < 0) {
        j.gkd();
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
    paramList = aA(paramList);
    localObject2 = J(paramString, paramLong);
    ae.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgRequestDialogOp templateJson: %s, bizUsername: %s, operationType: %d", new Object[] { paramList, paramString, Integer.valueOf(paramInt) });
    g.yxI.f(17524, new Object[] { Integer.valueOf(0), paramList, Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString, "", ((o)localObject1).first, ((o)localObject1).second, Integer.valueOf(2), localObject2 });
    AppMethodBeat.o(149591);
  }
  
  private static String aA(List<SubscribeMsgTmpItem> paramList)
  {
    AppMethodBeat.i(149592);
    JSONArray localJSONArray = new JSONArray();
    paramList = ((Iterable)paramList).iterator();
    if (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("templateId", localSubscribeMsgTmpItem.hDH);
      localJSONObject.put("templateType", localSubscribeMsgTmpItem.iDj);
      if (localSubscribeMsgTmpItem.iCO == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localJSONObject.put("selected", bool);
        localJSONArray.put(localJSONObject);
        break;
      }
    }
    paramList = localJSONArray.toString();
    p.g(paramList, "jsonArray.toString()");
    AppMethodBeat.o(149592);
    return paramList;
  }
  
  public static void b(String paramString, boolean paramBoolean, List<SubscribeMsgTmpItem> paramList)
  {
    int i = 0;
    AppMethodBeat.i(149593);
    p.h(paramString, "bizUsername");
    p.h(paramList, "subscribeMsgTmpItemList");
    ae.i("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile bizUsername: %s, switchOpen: %b, size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Integer.valueOf(paramList.size()) });
    JSONArray localJSONArray = new JSONArray();
    paramList = ((Iterable)paramList).iterator();
    if (paramList.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scopeID", localSubscribeMsgTmpItem.hDH);
      localJSONObject.put("scopeName", localSubscribeMsgTmpItem.title);
      if (localSubscribeMsgTmpItem.iDl == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localJSONObject.put("selected", bool);
        localJSONArray.put(localJSONObject);
        break;
      }
    }
    ae.v("MicroMsg.SubscribeMsgReporter", "alvinluo reportSubscribeMsgListOfProfile json: %s", new Object[] { localJSONArray.toString() });
    paramList = g.yxI;
    if (paramBoolean) {
      i = 1;
    }
    paramList.f(17637, new Object[] { paramString, Integer.valueOf(i), localJSONArray.toString() });
    AppMethodBeat.o(149593);
  }
  
  public static void qy(int paramInt)
  {
    AppMethodBeat.i(149589);
    ae.i("MicroMsg.SubscribeMsgReporter", "alvinluo createSession templateCount: %d", new Object[] { Integer.valueOf(paramInt) });
    sessionId = System.currentTimeMillis();
    iDY = paramInt;
    iDW.clear();
    iDX.clear();
    if (paramInt > 0)
    {
      ArrayList localArrayList = new ArrayList(paramInt);
      int i = 0;
      while (i < paramInt)
      {
        localArrayList.add(Integer.valueOf(0));
        i += 1;
      }
      iDX = (List)localArrayList;
    }
    AppMethodBeat.o(149589);
  }
  
  public static void qz(int paramInt)
  {
    AppMethodBeat.i(149590);
    if (paramInt < iDY)
    {
      List localList = iDX;
      localList.set(paramInt, Integer.valueOf(((Number)localList.get(paramInt)).intValue() + 1));
    }
    AppMethodBeat.o(149590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a
 * JD-Core Version:    0.7.0.1
 */