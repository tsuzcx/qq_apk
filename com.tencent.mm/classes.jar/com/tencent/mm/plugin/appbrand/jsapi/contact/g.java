package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends a
{
  public static final int CTRL_INDEX = 414;
  public static final String NAME = "searchContacts";
  private List<String[]> hKT;
  
  private static List<String[]> cL(Context paramContext)
  {
    AppMethodBeat.i(126275);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!com.tencent.luggage.g.g.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.JsApiSearchContacts", "no contact permission");
      AppMethodBeat.o(126275);
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
      if (paramContext == null)
      {
        ab.e("MicroMsg.JsApiSearchContacts", "getMobileInfo: mobile is null");
        AppMethodBeat.o(126275);
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiSearchContacts", paramContext, "", new Object[0]);
        ab.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo(), [%s]", new Object[] { paramContext.getMessage() });
        paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
      }
      try
      {
        if ((paramContext.getCount() > 0) && (paramContext.moveToFirst()))
        {
          boolean bool;
          do
          {
            localObject2 = paramContext.getString(paramContext.getColumnIndex("display_name"));
            localLinkedList.add(new String[] { paramContext.getString(paramContext.getColumnIndex("contact_id")), localObject2, paramContext.getString(paramContext.getColumnIndex("data1")), paramContext.getString(paramContext.getColumnIndex("raw_contact_id")) });
            bool = paramContext.moveToNext();
          } while (bool);
        }
        paramContext.close();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.JsApiSearchContacts", localException, "", new Object[0]);
          ab.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo()2, [%s]", new Object[] { localException.getMessage() });
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
        AppMethodBeat.o(126275);
      }
      AppMethodBeat.o(126275);
      return localLinkedList;
    }
  }
  
  private static boolean ce(String paramString1, String paramString2)
  {
    AppMethodBeat.i(126274);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.JsApiSearchContacts", "phoneNumber or targetPhoneNumber is null, return false");
      AppMethodBeat.o(126274);
      return false;
    }
    int m = paramString1.length();
    int i = paramString2.length();
    if (m < 8)
    {
      ab.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, return false", new Object[] { Integer.valueOf(paramString1.length()) });
      AppMethodBeat.o(126274);
      return false;
    }
    if (m > i)
    {
      ab.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, targetPhoneNumberSize:%d return false", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
      AppMethodBeat.o(126274);
      return false;
    }
    int j = 0;
    int k;
    for (i = 0;; i = k)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (paramString1.charAt(j) != paramString2.charAt(j))
      {
        i += 1;
        k = i;
        if (i > 3) {
          break;
        }
        k = i;
      }
      j += 1;
    }
    if (k <= 3)
    {
      AppMethodBeat.o(126274);
      return true;
    }
    AppMethodBeat.o(126274);
    return false;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126273);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiSearchContacts", "data is null, err");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(126273);
      return;
    }
    ab.i("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
    ab.d("MicroMsg.JsApiSearchContacts", "data:%s", new Object[] { paramJSONObject });
    Object localObject1 = paramc.getContext();
    if ((localObject1 == null) || (!(localObject1 instanceof Activity)))
    {
      ab.e("MicroMsg.JsApiSearchContacts", "getPageContext failed, appid is %s", new Object[] { paramc.getAppId() });
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(126273);
      return;
    }
    n.b(paramc.getAppId(), new g.1(this, paramc, paramJSONObject, paramInt));
    Object localObject2 = paramc.getContext();
    int i;
    if ((localObject2 == null) || (!(localObject2 instanceof Activity)))
    {
      paramc.h(paramInt, j("fail", null));
      i = 0;
    }
    while (i == 0)
    {
      ab.i("MicroMsg.JsApiSearchContacts", "check permission");
      AppMethodBeat.o(126273);
      return;
      boolean bool = com.tencent.luggage.g.g.a((Activity)localObject2, "android.permission.READ_CONTACTS", 48, "", "");
      i = bool;
      if (bool)
      {
        n.EA(paramc.getAppId());
        i = bool;
      }
    }
    localObject2 = paramJSONObject.optString("phoneNumber");
    if (((String)localObject2).length() < 8)
    {
      ab.e("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
      paramJSONObject = new HashMap();
      paramJSONObject.put("result", "");
      paramc.h(paramInt, j("ok", paramJSONObject));
      AppMethodBeat.o(126273);
      return;
    }
    if (this.hKT == null) {
      this.hKT = cL((Context)localObject1);
    }
    if (this.hKT == null)
    {
      ab.e("MicroMsg.JsApiSearchContacts", "addressList is null, err");
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(126273);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    if ((this.hKT != null) && (!this.hKT.isEmpty()))
    {
      Iterator localIterator = this.hKT.iterator();
      if (localIterator.hasNext())
      {
        Object localObject3 = (String[])localIterator.next();
        paramJSONObject = localObject3[2];
        if (paramJSONObject == null) {
          paramJSONObject = null;
        }
        for (;;)
        {
          for (;;)
          {
            localObject1 = bo.bf(localObject3[1], "");
            if ((bo.isNullOrNil(paramJSONObject)) || (!ce((String)localObject2, paramJSONObject))) {
              break;
            }
            try
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("phoneNumber", paramJSONObject);
              ((JSONObject)localObject3).put("name", localObject1);
              localJSONArray.put(localObject3);
            }
            catch (JSONException paramJSONObject)
            {
              ab.printErrStackTrace("MicroMsg.JsApiSearchContacts", paramJSONObject, "", new Object[0]);
            }
          }
          break;
          localObject1 = paramJSONObject.replaceAll("\\D", "");
          paramJSONObject = (JSONObject)localObject1;
          if (((String)localObject1).startsWith("86")) {
            paramJSONObject = ((String)localObject1).substring(2);
          }
        }
      }
    }
    ab.d("MicroMsg.JsApiSearchContacts", "resultArray:%s", new Object[] { localJSONArray.toString() });
    paramJSONObject = new HashMap();
    paramJSONObject.put("result", localJSONArray.toString());
    paramc.h(paramInt, j("ok", paramJSONObject));
    AppMethodBeat.o(126273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.g
 * JD-Core Version:    0.7.0.1
 */