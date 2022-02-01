package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager;", "", "()V", "PHONE_ITEMS", "", "TAG", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "addPhone", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getPhoneNumbers", "", "process", "phoneItems", "oldPhoneItems", "removePhone", "delPhoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savePhoneNumbers", "selectPhone", "updatePhoneItem", "luggage-wechat-full-sdk_release"})
public final class r
{
  private static final aw lKc;
  public static final r lKd;
  
  static
  {
    AppMethodBeat.i(148084);
    lKd = new r();
    lKc = aw.eVA();
    AppMethodBeat.o(148084);
  }
  
  public static void b(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148081);
    List localList = bss();
    if (paramPhoneItem != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((PhoneItem)localIterator.next()).lKa = false;
      }
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)localIterator.next();
        if (k.g(paramPhoneItem.dnz, localPhoneItem.dnz)) {
          localPhoneItem.lKa = true;
        }
      }
    }
    bz(localList);
    ac.v("MicroMsg.PhoneItemsManager", "uninit phoneItems:%s", new Object[] { localList });
    AppMethodBeat.o(148081);
  }
  
  public static List<PhoneItem> bss()
  {
    AppMethodBeat.i(148079);
    Object localObject1 = lKc.getString("PhoneItemsManager#PhoneItems", "{}");
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
          Object localObject3 = PhoneItem.lKb;
          localObject3 = ((JSONArray)localObject1).getString(i);
          k.g(localObject3, "jsonArray.getString(i)");
          localObject3 = PhoneItem.a.Qq((String)localObject3);
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
        ac.e("MicroMsg.PhoneItemsManager", "e:%s", new Object[] { localException });
        localObject2 = null;
      }
      ac.d("MicroMsg.PhoneItemsManager", "get %s", new Object[] { String.valueOf(localObject2) });
      Object localObject2 = (List)localArrayList;
      AppMethodBeat.o(148079);
      return localObject2;
    }
  }
  
  public static void bz(List<PhoneItem> paramList)
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
      localJSONObject.put("mobile", ((PhoneItem)localObject).dnz);
      localJSONObject.put("show_mobile", ((PhoneItem)localObject).lJU);
      localJSONObject.put("need_auth", ((PhoneItem)localObject).lJX);
      localJSONObject.put("allow_send_sms", ((PhoneItem)localObject).lJY);
      localJSONObject.put("encryptedData", ((PhoneItem)localObject).lJV);
      localJSONObject.put("iv", ((PhoneItem)localObject).bno);
      localJSONObject.put("cloud_id", ((PhoneItem)localObject).lJW);
      localJSONObject.put("is_wechat", ((PhoneItem)localObject).lJZ);
      localJSONObject.put("is_check", ((PhoneItem)localObject).lKa);
      localObject = localJSONObject.toString();
      k.g(localObject, "jsonObject.toString()");
      localJSONArray.put(localObject);
    }
    paramList = lKc;
    if (paramList != null) {
      paramList.putString("PhoneItemsManager#PhoneItems", localJSONArray.toString());
    }
    paramList = lKc;
    if (paramList != null)
    {
      paramList.commit();
      AppMethodBeat.o(148080);
      return;
    }
    AppMethodBeat.o(148080);
  }
  
  public static void c(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(148082);
    k.h(paramPhoneItem, "phoneItem");
    ArrayList localArrayList = (ArrayList)bss();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((PhoneItem)localIterator.next()).lKa = false;
    }
    if (localArrayList.contains(paramPhoneItem)) {
      localArrayList.set(localArrayList.indexOf(paramPhoneItem), paramPhoneItem);
    }
    for (;;)
    {
      bz((List)localArrayList);
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
        if (localPhoneItem1.lKa)
        {
          localIterator = paramList1.iterator();
          while (localIterator.hasNext())
          {
            PhoneItem localPhoneItem2 = (PhoneItem)localIterator.next();
            if (k.g(localPhoneItem1.dnz, localPhoneItem2.dnz))
            {
              localPhoneItem2.lKa = true;
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (paramList1.size() > 0)) {
        ((PhoneItem)paramList1.get(0)).lKa = true;
      }
      ac.v("MicroMsg.PhoneItemsManager", "init oldphoneItems:%s", new Object[] { paramList2 });
      ac.v("MicroMsg.PhoneItemsManager", "init phoneItems:%s", new Object[] { paramList1 });
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
        ac.w("MicroMsg.PhoneItemsManager", "delPhoneItems is null");
        AppMethodBeat.o(148083);
        return;
      }
      localArrayList = (ArrayList)bss();
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
    } while (!((PhoneItem)paramArrayList.next()).lKa);
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (localArrayList.size() > 0)) {
        ((PhoneItem)localArrayList.get(0)).lKa = true;
      }
      ac.v("MicroMsg.PhoneItemsManager", "remove phoneItems:%s", new Object[] { localArrayList });
      bz((List)localArrayList);
      AppMethodBeat.o(148083);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.r
 * JD-Core Version:    0.7.0.1
 */