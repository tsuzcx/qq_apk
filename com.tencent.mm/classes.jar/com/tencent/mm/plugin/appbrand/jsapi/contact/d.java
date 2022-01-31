package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 414;
  public static final String NAME = "searchContacts";
  private List<String[]> gqb;
  
  private static boolean by(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      y.e("MicroMsg.JsApiSearchContacts", "phoneNumber or targetPhoneNumber is null, return false");
      return false;
    }
    int m = paramString1.length();
    int i = paramString2.length();
    if (m < 8)
    {
      y.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, return false", new Object[] { Integer.valueOf(paramString1.length()) });
      return false;
    }
    if (m > i)
    {
      y.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, targetPhoneNumberSize:%d return false", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
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
    return k <= 3;
  }
  
  private static List<String[]> ck(Context paramContext)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    if (!com.tencent.mm.pluginsdk.permission.a.j(paramContext, "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.JsApiSearchContacts", "no contact permission");
      return localLinkedList;
    }
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
      if (paramContext == null)
      {
        y.e("MicroMsg.JsApiSearchContacts", "getMobileInfo: mobile is null");
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.JsApiSearchContacts", paramContext, "", new Object[0]);
        y.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo(), [%s]", new Object[] { paramContext.getMessage() });
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
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.JsApiSearchContacts", localException, "", new Object[0]);
          y.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo()2, [%s]", new Object[] { localException.getMessage() });
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
      }
      return localLinkedList;
    }
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiSearchContacts", "data is null, err");
      paramc.C(paramInt, h("fail:invalid data", null));
      return;
    }
    y.i("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
    y.d("MicroMsg.JsApiSearchContacts", "data:%s", new Object[] { paramJSONObject });
    Object localObject1 = paramc.getContext();
    if ((localObject1 == null) || (!(localObject1 instanceof Activity)))
    {
      y.e("MicroMsg.JsApiSearchContacts", "getPageContext failed, appid is %s", new Object[] { paramc.getAppId() });
      paramc.C(paramInt, h("fail", null));
      return;
    }
    e.b(paramc.getAppId(), new d.1(this, paramc, paramJSONObject, paramInt));
    Object localObject2 = paramc.getContext();
    int i;
    if ((localObject2 == null) || (!(localObject2 instanceof Activity)))
    {
      paramc.C(paramInt, h("fail", null));
      i = 0;
    }
    while (i == 0)
    {
      y.i("MicroMsg.JsApiSearchContacts", "check permission");
      return;
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)localObject2, "android.permission.READ_CONTACTS", 48, "", "");
      i = bool;
      if (bool)
      {
        e.vX(paramc.getAppId());
        i = bool;
      }
    }
    localObject2 = paramJSONObject.optString("phoneNumber");
    if (((String)localObject2).length() < 8)
    {
      y.e("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
      paramJSONObject = new HashMap();
      paramJSONObject.put("result", "");
      paramc.C(paramInt, h("ok", paramJSONObject));
      return;
    }
    if (this.gqb == null) {
      this.gqb = ck((Context)localObject1);
    }
    if (this.gqb == null)
    {
      y.e("MicroMsg.JsApiSearchContacts", "addressList is null, err");
      paramc.C(paramInt, h("fail", null));
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    if ((this.gqb != null) && (!this.gqb.isEmpty()))
    {
      Iterator localIterator = this.gqb.iterator();
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
            localObject1 = bk.aM(localObject3[1], "");
            if ((bk.bl(paramJSONObject)) || (!by((String)localObject2, paramJSONObject))) {
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
              y.printErrStackTrace("MicroMsg.JsApiSearchContacts", paramJSONObject, "", new Object[0]);
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
    y.d("MicroMsg.JsApiSearchContacts", "resultArray:%s", new Object[] { localJSONArray.toString() });
    paramJSONObject = new HashMap();
    paramJSONObject.put("result", localJSONArray.toString());
    paramc.C(paramInt, h("ok", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.d
 * JD-Core Version:    0.7.0.1
 */