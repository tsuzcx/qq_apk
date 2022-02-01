package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager;", "", "()V", "PHONE_ITEMS", "", "TAG", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "addPhone", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getPhoneNumbers", "", "process", "phoneItems", "oldPhoneItems", "removePhone", "delPhoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savePhoneNumbers", "selectPhone", "updatePhoneItem", "luggage-wechat-full-sdk_release"})
public final class r
{
  private static final ax mjS;
  public static final r mjT;
  
  static
  {
    AppMethodBeat.i(148084);
    mjT = new r();
    mjS = ax.flh();
    AppMethodBeat.o(148084);
  }
  
  public static void b(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148081);
    List localList = bwx();
    if (paramPhoneItem != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((PhoneItem)localIterator.next()).mjQ = false;
      }
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)localIterator.next();
        if (p.i(paramPhoneItem.dzn, localPhoneItem.dzn)) {
          localPhoneItem.mjQ = true;
        }
      }
    }
    bB(localList);
    ad.v("MicroMsg.PhoneItemsManager", "uninit phoneItems:%s", new Object[] { localList });
    AppMethodBeat.o(148081);
  }
  
  public static void bB(List<PhoneItem> paramList)
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
      localJSONObject.put("mobile", ((PhoneItem)localObject).dzn);
      localJSONObject.put("show_mobile", ((PhoneItem)localObject).mjK);
      localJSONObject.put("need_auth", ((PhoneItem)localObject).mjN);
      localJSONObject.put("allow_send_sms", ((PhoneItem)localObject).mjO);
      localJSONObject.put("encryptedData", ((PhoneItem)localObject).mjL);
      localJSONObject.put("iv", ((PhoneItem)localObject).bxJ);
      localJSONObject.put("cloud_id", ((PhoneItem)localObject).mjM);
      localJSONObject.put("is_wechat", ((PhoneItem)localObject).mjP);
      localJSONObject.put("is_check", ((PhoneItem)localObject).mjQ);
      localObject = localJSONObject.toString();
      p.g(localObject, "jsonObject.toString()");
      localJSONArray.put(localObject);
    }
    paramList = mjS;
    if (paramList != null) {
      paramList.putString("PhoneItemsManager#PhoneItems", localJSONArray.toString());
    }
    paramList = mjS;
    if (paramList != null)
    {
      paramList.commit();
      AppMethodBeat.o(148080);
      return;
    }
    AppMethodBeat.o(148080);
  }
  
  public static List<PhoneItem> bwx()
  {
    AppMethodBeat.i(148079);
    Object localObject1 = mjS.getString("PhoneItemsManager#PhoneItems", "{}");
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
          Object localObject3 = PhoneItem.mjR;
          localObject3 = ((JSONArray)localObject1).getString(i);
          p.g(localObject3, "jsonArray.getString(i)");
          localObject3 = PhoneItem.a.TV((String)localObject3);
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
        ad.e("MicroMsg.PhoneItemsManager", "e:%s", new Object[] { localException });
        localObject2 = null;
      }
      ad.d("MicroMsg.PhoneItemsManager", "get %s", new Object[] { String.valueOf(localObject2) });
      Object localObject2 = (List)localArrayList;
      AppMethodBeat.o(148079);
      return localObject2;
    }
  }
  
  public static void c(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148082);
    p.h(paramPhoneItem, "phoneItem");
    ArrayList localArrayList = (ArrayList)bwx();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((PhoneItem)localIterator.next()).mjQ = false;
    }
    if (localArrayList.contains(paramPhoneItem)) {
      localArrayList.set(localArrayList.indexOf(paramPhoneItem), paramPhoneItem);
    }
    for (;;)
    {
      bB((List)localArrayList);
      AppMethodBeat.o(148082);
      return;
      localArrayList.add(paramPhoneItem);
    }
  }
  
  public static List<PhoneItem> i(List<PhoneItem> paramList1, List<PhoneItem> paramList2)
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
        if (localPhoneItem1.mjQ)
        {
          localIterator = paramList1.iterator();
          while (localIterator.hasNext())
          {
            PhoneItem localPhoneItem2 = (PhoneItem)localIterator.next();
            if (p.i(localPhoneItem1.dzn, localPhoneItem2.dzn))
            {
              localPhoneItem2.mjQ = true;
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (paramList1.size() > 0)) {
        ((PhoneItem)paramList1.get(0)).mjQ = true;
      }
      ad.v("MicroMsg.PhoneItemsManager", "init oldphoneItems:%s", new Object[] { paramList2 });
      ad.v("MicroMsg.PhoneItemsManager", "init phoneItems:%s", new Object[] { paramList1 });
      AppMethodBeat.o(148078);
      return paramList1;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final void E(ArrayList<PhoneItem> paramArrayList)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(148083);
      if (paramArrayList == null)
      {
        ad.w("MicroMsg.PhoneItemsManager", "delPhoneItems is null");
        AppMethodBeat.o(148083);
        return;
      }
      localArrayList = (ArrayList)bwx();
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
    } while (!((PhoneItem)paramArrayList.next()).mjQ);
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (localArrayList.size() > 0)) {
        ((PhoneItem)localArrayList.get(0)).mjQ = true;
      }
      ad.v("MicroMsg.PhoneItemsManager", "remove phoneItems:%s", new Object[] { localArrayList });
      bB((List)localArrayList);
      AppMethodBeat.o(148083);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.r
 * JD-Core Version:    0.7.0.1
 */