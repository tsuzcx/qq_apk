package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import android.os.Parcelable;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItemsManager;", "", "()V", "PHONE_ITEMS", "", "TAG", "addPhone", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getPhoneNumbers", "", "process", "phoneItems", "oldPhoneItems", "removePhone", "delPhoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "savePhoneNumbers", "selectPhone", "updatePhoneItem", "IPCInvoke_GetCommonDataValue", "IPCInvoke_SetCommonDataValue", "plugin-appbrand-integration_release"})
public final class k
{
  public static final k iDv;
  
  static
  {
    AppMethodBeat.i(134813);
    iDv = new k();
    AppMethodBeat.o(134813);
  }
  
  public static void a(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(143944);
    List localList = aKP();
    if (paramPhoneItem != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ((PhoneItem)localIterator.next()).iDt = false;
      }
      localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneItem localPhoneItem = (PhoneItem)localIterator.next();
        if (j.e(paramPhoneItem.czF, localPhoneItem.czF)) {
          localPhoneItem.iDt = true;
        }
      }
    }
    aK(localList);
    d.v("MicroMsg.PhoneItemsManager", "uninit phoneItems:%s", new Object[] { localList });
    AppMethodBeat.o(143944);
  }
  
  public static void aK(List<PhoneItem> paramList)
  {
    AppMethodBeat.i(143943);
    if (paramList == null)
    {
      AppMethodBeat.o(143943);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (PhoneItem)paramList.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mobile", ((PhoneItem)localObject).czF);
      localJSONObject.put("show_mobile", ((PhoneItem)localObject).iDo);
      localJSONObject.put("need_auth", ((PhoneItem)localObject).iDq);
      localJSONObject.put("allow_send_sms", ((PhoneItem)localObject).iDr);
      localJSONObject.put("encryptedData", ((PhoneItem)localObject).iDp);
      localJSONObject.put("iv", ((PhoneItem)localObject).aRj);
      localJSONObject.put("is_wechat", ((PhoneItem)localObject).iDs);
      localJSONObject.put("is_check", ((PhoneItem)localObject).iDt);
      localObject = localJSONObject.toString();
      j.p(localObject, "jsonObject.toString()");
      localJSONArray.put(localObject);
    }
    f.a("com.tencent.mm", (Parcelable)new IPCString(localJSONArray.toString()), k.b.class);
    AppMethodBeat.o(143943);
  }
  
  public static List<PhoneItem> aKP()
  {
    AppMethodBeat.i(143942);
    Object localObject1 = (IPCString)f.a("com.tencent.mm", (Parcelable)new IPCString("PhoneItemsManager#PhoneItems"), k.a.class);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((IPCString)localObject1).value;
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "{}";
    }
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      localObject3 = new ArrayList();
      if (localObject1 != null)
      {
        int j = ((JSONArray)localObject1).length() - 1;
        if (j >= 0)
        {
          int i = 0;
          for (;;)
          {
            Object localObject4 = PhoneItem.iDu;
            localObject4 = ((JSONArray)localObject1).getString(i);
            j.p(localObject4, "jsonArray.getString(i)");
            localObject4 = PhoneItem.a.EB((String)localObject4);
            if (localObject4 != null) {
              ((ArrayList)localObject3).add(localObject4);
            }
            if (i == j) {
              break;
            }
            i += 1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d.e("MicroMsg.PhoneItemsManager", "e:%s", new Object[] { localException });
        localObject2 = null;
      }
      d.d("MicroMsg.PhoneItemsManager", "get %s", new Object[] { String.valueOf(localObject2) });
      Object localObject2 = (List)localObject3;
      AppMethodBeat.o(143942);
      return localObject2;
    }
  }
  
  public static void b(PhoneItem paramPhoneItem)
  {
    AppMethodBeat.i(143945);
    j.q(paramPhoneItem, "phoneItem");
    ArrayList localArrayList = (ArrayList)aKP();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((PhoneItem)localIterator.next()).iDt = false;
    }
    if (localArrayList.contains(paramPhoneItem)) {
      localArrayList.set(localArrayList.indexOf(paramPhoneItem), paramPhoneItem);
    }
    for (;;)
    {
      aK((List)localArrayList);
      AppMethodBeat.o(143945);
      return;
      localArrayList.add(paramPhoneItem);
    }
  }
  
  public static List<PhoneItem> f(List<PhoneItem> paramList1, List<PhoneItem> paramList2)
  {
    AppMethodBeat.i(143941);
    if (paramList1 == null)
    {
      AppMethodBeat.o(143941);
      return null;
    }
    int i;
    if (paramList2 != null)
    {
      Iterator localIterator = paramList2.iterator();
      while (localIterator.hasNext())
      {
        PhoneItem localPhoneItem1 = (PhoneItem)localIterator.next();
        if (localPhoneItem1.iDt)
        {
          localIterator = paramList1.iterator();
          while (localIterator.hasNext())
          {
            PhoneItem localPhoneItem2 = (PhoneItem)localIterator.next();
            if (j.e(localPhoneItem1.czF, localPhoneItem2.czF))
            {
              localPhoneItem2.iDt = true;
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (paramList1.size() > 0)) {
        ((PhoneItem)paramList1.get(0)).iDt = true;
      }
      d.v("MicroMsg.PhoneItemsManager", "init oldphoneItems:%s", new Object[] { paramList2 });
      d.v("MicroMsg.PhoneItemsManager", "init phoneItems:%s", new Object[] { paramList1 });
      AppMethodBeat.o(143941);
      return paramList1;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final void o(ArrayList<PhoneItem> paramArrayList)
  {
    ArrayList localArrayList;
    try
    {
      AppMethodBeat.i(143946);
      if (paramArrayList == null)
      {
        d.w("MicroMsg.PhoneItemsManager", "delPhoneItems is null");
        AppMethodBeat.o(143946);
        return;
      }
      localArrayList = (ArrayList)aKP();
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
    } while (!((PhoneItem)paramArrayList.next()).iDt);
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (localArrayList.size() > 0)) {
        ((PhoneItem)localArrayList.get(0)).iDt = true;
      }
      d.v("MicroMsg.PhoneItemsManager", "remove phoneItems:%s", new Object[] { localArrayList });
      aK((List)localArrayList);
      AppMethodBeat.o(143946);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.k
 * JD-Core Version:    0.7.0.1
 */