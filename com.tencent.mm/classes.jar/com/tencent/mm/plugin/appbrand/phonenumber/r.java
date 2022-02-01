package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager;", "", "()V", "PHONE_ITEMS", "", "TAG", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "addPhone", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getPhoneNumbers", "", "process", "phoneItems", "oldPhoneItems", "removePhone", "delPhoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savePhoneNumbers", "selectPhone", "updatePhoneItem", "luggage-wechat-full-sdk_release"})
public final class r
{
  private static final MultiProcessMMKV qBM;
  public static final r qBN;
  
  static
  {
    AppMethodBeat.i(148084);
    qBN = new r();
    qBM = MultiProcessMMKV.getMMKV("MicroMsg.PhoneItemsManager");
    AppMethodBeat.o(148084);
  }
  
  public static void b(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148081);
    List localList = cgD();
    if (paramPhoneItem != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((PhoneItem)localIterator.next()).qBK = false;
      }
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)localIterator.next();
        if (p.h(paramPhoneItem.fLC, localPhoneItem.fLC)) {
          localPhoneItem.qBK = true;
        }
      }
    }
    bO(localList);
    Log.v("MicroMsg.PhoneItemsManager", "uninit phoneItems:%s", new Object[] { localList });
    AppMethodBeat.o(148081);
  }
  
  public static void bO(List<PhoneItem> paramList)
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
      localJSONObject.put("mobile", ((PhoneItem)localObject).fLC);
      localJSONObject.put("show_mobile", ((PhoneItem)localObject).qBE);
      localJSONObject.put("need_auth", ((PhoneItem)localObject).qBH);
      localJSONObject.put("allow_send_sms", ((PhoneItem)localObject).qBI);
      localJSONObject.put("encryptedData", ((PhoneItem)localObject).qBF);
      localJSONObject.put("iv", ((PhoneItem)localObject).bhm);
      localJSONObject.put("cloud_id", ((PhoneItem)localObject).qBG);
      localJSONObject.put("is_wechat", ((PhoneItem)localObject).qBJ);
      localJSONObject.put("is_check", ((PhoneItem)localObject).qBK);
      localObject = localJSONObject.toString();
      p.j(localObject, "jsonObject.toString()");
      localJSONArray.put(localObject);
    }
    qBM.putString("PhoneItemsManager#PhoneItems", localJSONArray.toString());
    qBM.commit();
    Log.d("MicroMsg.PhoneItemsManager", "savePhoneNumbers %s", new Object[] { localJSONArray.toString() });
    AppMethodBeat.o(148080);
  }
  
  public static void c(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148082);
    p.k(paramPhoneItem, "phoneItem");
    ArrayList localArrayList = (ArrayList)cgD();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((PhoneItem)localIterator.next()).qBK = false;
    }
    if (localArrayList.contains(paramPhoneItem)) {
      localArrayList.set(localArrayList.indexOf(paramPhoneItem), paramPhoneItem);
    }
    for (;;)
    {
      bO((List)localArrayList);
      AppMethodBeat.o(148082);
      return;
      localArrayList.add(paramPhoneItem);
    }
  }
  
  public static List<PhoneItem> cgD()
  {
    AppMethodBeat.i(148079);
    Object localObject1 = qBM.getString("PhoneItemsManager#PhoneItems", "{}");
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      localArrayList = new ArrayList();
      if (localObject1 != null)
      {
        int j = ((JSONArray)localObject1).length();
        int i = 0;
        while (i < j)
        {
          Object localObject3 = PhoneItem.qBL;
          localObject3 = ((JSONArray)localObject1).getString(i);
          p.j(localObject3, "jsonArray.getString(i)");
          localObject3 = PhoneItem.a.amn((String)localObject3);
          if (localObject3 != null) {
            localArrayList.add(localObject3);
          }
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      ArrayList localArrayList;
      for (;;)
      {
        Log.e("MicroMsg.PhoneItemsManager", "e:%s", new Object[] { localException });
        localObject2 = null;
      }
      Log.d("MicroMsg.PhoneItemsManager", "get %s", new Object[] { String.valueOf(localObject2) });
      Object localObject2 = (List)localArrayList;
      AppMethodBeat.o(148079);
      return localObject2;
    }
  }
  
  public static List<PhoneItem> l(List<PhoneItem> paramList1, List<PhoneItem> paramList2)
  {
    AppMethodBeat.i(148078);
    if (paramList1 == null)
    {
      AppMethodBeat.o(148078);
      return null;
    }
    int i;
    if (paramList2 != null)
    {
      Iterator localIterator = paramList2.iterator();
      while (localIterator.hasNext())
      {
        PhoneItem localPhoneItem1 = (PhoneItem)localIterator.next();
        if (localPhoneItem1.qBK)
        {
          localIterator = paramList1.iterator();
          while (localIterator.hasNext())
          {
            PhoneItem localPhoneItem2 = (PhoneItem)localIterator.next();
            if (p.h(localPhoneItem1.fLC, localPhoneItem2.fLC))
            {
              localPhoneItem2.qBK = true;
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (paramList1.size() > 0)) {
        ((PhoneItem)paramList1.get(0)).qBK = true;
      }
      Log.v("MicroMsg.PhoneItemsManager", "init oldphoneItems:%s", new Object[] { paramList2 });
      Log.v("MicroMsg.PhoneItemsManager", "init phoneItems:%s", new Object[] { paramList1 });
      AppMethodBeat.o(148078);
      return paramList1;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final void L(ArrayList<PhoneItem> paramArrayList)
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
      localArrayList = (ArrayList)cgD();
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
    } while (!((PhoneItem)paramArrayList.next()).qBK);
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (localArrayList.size() > 0)) {
        ((PhoneItem)localArrayList.get(0)).qBK = true;
      }
      Log.v("MicroMsg.PhoneItemsManager", "remove phoneItems:%s", new Object[] { localArrayList });
      bO((List)localArrayList);
      AppMethodBeat.o(148083);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.r
 * JD-Core Version:    0.7.0.1
 */