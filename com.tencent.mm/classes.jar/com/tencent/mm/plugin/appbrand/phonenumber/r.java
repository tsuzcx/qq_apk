package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager;", "", "()V", "PHONE_ITEMS", "", "TAG", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "addPhone", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getPhoneNumbers", "", "process", "phoneItems", "oldPhoneItems", "removePhone", "delPhoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savePhoneNumbers", "selectPhone", "updatePhoneItem", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r tGQ;
  private static final MultiProcessMMKV tGR;
  
  static
  {
    AppMethodBeat.i(148084);
    tGQ = new r();
    tGR = MultiProcessMMKV.getMMKV("MicroMsg.PhoneItemsManager");
    AppMethodBeat.o(148084);
  }
  
  public static void c(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148081);
    List localList = cHA();
    if (paramPhoneItem != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((PhoneItem)localIterator.next()).tGP = false;
      }
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)localIterator.next();
        if (s.p(paramPhoneItem.hRk, localPhoneItem.hRk)) {
          localPhoneItem.tGP = true;
        }
      }
    }
    dB(localList);
    Log.v("MicroMsg.PhoneItemsManager", "uninit phoneItems:%s", new Object[] { localList });
    AppMethodBeat.o(148081);
  }
  
  public static List<PhoneItem> cHA()
  {
    AppMethodBeat.i(148079);
    Object localObject1 = tGR.getString("PhoneItemsManager#PhoneItems", "{}");
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      ArrayList localArrayList = new ArrayList();
      if (localObject1 != null)
      {
        int k = ((JSONArray)localObject1).length();
        if (k > 0)
        {
          i = 0;
          j = i + 1;
          Object localObject3 = PhoneItem.tGI;
          localObject3 = ((JSONArray)localObject1).getString(i);
          s.s(localObject3, "jsonArray.getString(i)");
          localObject3 = PhoneItem.a.afx((String)localObject3);
          if (localObject3 != null) {
            localArrayList.add(localObject3);
          }
          if (j < k) {
            break label149;
          }
        }
      }
      Log.d("MicroMsg.PhoneItemsManager", "get %s", new Object[] { String.valueOf(localObject1) });
      localObject1 = (List)localArrayList;
      AppMethodBeat.o(148079);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j;
        Log.e("MicroMsg.PhoneItemsManager", "e:%s", new Object[] { localException });
        Object localObject2 = null;
        continue;
        label149:
        int i = j;
      }
    }
  }
  
  public static void d(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148082);
    s.u(paramPhoneItem, "phoneItem");
    ArrayList localArrayList = (ArrayList)cHA();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((PhoneItem)localIterator.next()).tGP = false;
    }
    if (localArrayList.contains(paramPhoneItem)) {
      localArrayList.set(localArrayList.indexOf(paramPhoneItem), paramPhoneItem);
    }
    for (;;)
    {
      dB((List)localArrayList);
      AppMethodBeat.o(148082);
      return;
      localArrayList.add(paramPhoneItem);
    }
  }
  
  public static void dB(List<PhoneItem> paramList)
  {
    AppMethodBeat.i(148080);
    if (paramList == null)
    {
      AppMethodBeat.o(148080);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (PhoneItem)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mobile", ((PhoneItem)localObject).hRk);
      localJSONObject.put("show_mobile", ((PhoneItem)localObject).tGJ);
      localJSONObject.put("need_auth", ((PhoneItem)localObject).tGM);
      localJSONObject.put("allow_send_sms", ((PhoneItem)localObject).tGN);
      localJSONObject.put("encryptedData", ((PhoneItem)localObject).tGK);
      localJSONObject.put("iv", ((PhoneItem)localObject).dbg);
      localJSONObject.put("cloud_id", ((PhoneItem)localObject).tGL);
      localJSONObject.put("is_wechat", ((PhoneItem)localObject).tGO);
      localJSONObject.put("is_check", ((PhoneItem)localObject).tGP);
      localJSONObject.put("data", ((PhoneItem)localObject).data);
      localObject = localJSONObject.toString();
      s.s(localObject, "jsonObject.toString()");
      localJSONArray.put(localObject);
    }
    tGR.putString("PhoneItemsManager#PhoneItems", localJSONArray.toString());
    tGR.commit();
    Log.d("MicroMsg.PhoneItemsManager", "savePhoneNumbers %s", new Object[] { localJSONArray.toString() });
    AppMethodBeat.o(148080);
  }
  
  public static List<PhoneItem> p(List<PhoneItem> paramList1, List<PhoneItem> paramList2)
  {
    AppMethodBeat.i(148078);
    if (paramList1 == null)
    {
      AppMethodBeat.o(148078);
      return null;
    }
    if (paramList2 != null)
    {
      Iterator localIterator = paramList2.iterator();
      while (localIterator.hasNext())
      {
        PhoneItem localPhoneItem1 = (PhoneItem)localIterator.next();
        if (localPhoneItem1.tGP)
        {
          localIterator = paramList1.iterator();
          while (localIterator.hasNext())
          {
            PhoneItem localPhoneItem2 = (PhoneItem)localIterator.next();
            if (s.p(localPhoneItem1.hRk, localPhoneItem2.hRk)) {
              localPhoneItem2.tGP = true;
            }
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramList1.size() > 0)) {
        ((PhoneItem)paramList1.get(0)).tGP = true;
      }
      Log.v("MicroMsg.PhoneItemsManager", "init oldphoneItems:%s", new Object[] { paramList2 });
      Log.v("MicroMsg.PhoneItemsManager", "init phoneItems:%s", new Object[] { paramList1 });
      AppMethodBeat.o(148078);
      return paramList1;
    }
  }
  
  public final void P(ArrayList<PhoneItem> paramArrayList)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(148083);
      if (paramArrayList == null)
      {
        Log.w("MicroMsg.PhoneItemsManager", "delPhoneItems is null");
        AppMethodBeat.o(148083);
        return;
      }
      localArrayList = (ArrayList)cHA();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localArrayList.remove((PhoneItem)paramArrayList.next());
      }
      paramArrayList = localArrayList.iterator();
    }
    finally {}
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
    } while (!((PhoneItem)paramArrayList.next()).tGP);
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (localArrayList.size() > 0)) {
        ((PhoneItem)localArrayList.get(0)).tGP = true;
      }
      Log.v("MicroMsg.PhoneItemsManager", "remove phoneItems:%s", new Object[] { localArrayList });
      dB((List)localArrayList);
      AppMethodBeat.o(148083);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.r
 * JD-Core Version:    0.7.0.1
 */