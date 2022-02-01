package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v4.app.a.a;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends d
{
  public static final int CTRL_INDEX = 414;
  public static final String NAME = "searchContacts";
  
  private static List<String[]> dO(Context paramContext)
  {
    AppMethodBeat.i(137503);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = paramContext.getContentResolver();
    try
    {
      paramContext = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "sort_key_alt");
      if (paramContext == null)
      {
        Log.e("MicroMsg.JsApiSearchContacts", "getMobileInfo: mobile is null");
        AppMethodBeat.o(137503);
        return localLinkedList;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiSearchContacts", paramContext, "", new Object[0]);
        Log.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo(), [%s]", new Object[] { paramContext.getMessage() });
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
          Log.printErrStackTrace("MicroMsg.JsApiSearchContacts", localException, "", new Object[0]);
          Log.e("MicroMsg.JsApiSearchContacts", "exception in getMoblieOrderInfo()2, [%s]", new Object[] { localException.getMessage() });
          paramContext.close();
        }
      }
      finally
      {
        paramContext.close();
        AppMethodBeat.o(137503);
      }
      AppMethodBeat.o(137503);
      return localLinkedList;
    }
  }
  
  private static boolean dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137502);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.JsApiSearchContacts", "phoneNumber or targetPhoneNumber is null, return false");
      AppMethodBeat.o(137502);
      return false;
    }
    int m = paramString1.length();
    int i = paramString2.length();
    if (m < 8)
    {
      Log.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, return false", new Object[] { Integer.valueOf(paramString1.length()) });
      AppMethodBeat.o(137502);
      return false;
    }
    if (m > i)
    {
      Log.d("MicroMsg.JsApiSearchContacts", "phoneNumberSize:%d, targetPhoneNumberSize:%d return false", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
      AppMethodBeat.o(137502);
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
      AppMethodBeat.o(137502);
      return true;
    }
    AppMethodBeat.o(137502);
    return false;
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137501);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSearchContacts", "data is null, err");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(137501);
      return;
    }
    Log.i("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
    Log.d("MicroMsg.JsApiSearchContacts", "data:%s", new Object[] { paramJSONObject });
    Object localObject1 = paramf.getContext();
    if ((localObject1 == null) || (!(localObject1 instanceof Activity)))
    {
      Log.e("MicroMsg.JsApiSearchContacts", "getPageContext failed, appid is %s", new Object[] { paramf.getAppId() });
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(137501);
      return;
    }
    r.b(paramf.getAppId(), new a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(137500);
        if (paramAnonymousInt != 48)
        {
          AppMethodBeat.o(137500);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          g.this.a(paramf, paramJSONObject, paramInt);
          AppMethodBeat.o(137500);
          return;
        }
        paramf.i(paramInt, g.this.h("fail:system permission denied", null));
        AppMethodBeat.o(137500);
      }
    });
    Object localObject2 = paramf.getContext();
    int i;
    if ((localObject2 == null) || (!(localObject2 instanceof Activity)))
    {
      paramf.i(paramInt, h("fail", null));
      i = 0;
    }
    while (i == 0)
    {
      Log.i("MicroMsg.JsApiSearchContacts", "check permission");
      AppMethodBeat.o(137501);
      return;
      boolean bool = i.a((Activity)localObject2, "android.permission.READ_CONTACTS", 48, "", "");
      i = bool;
      if (bool)
      {
        r.aeq(paramf.getAppId());
        i = bool;
      }
    }
    localObject2 = paramJSONObject.optString("phoneNumber");
    if (((String)localObject2).length() < 8)
    {
      Log.e("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
      paramJSONObject = new HashMap();
      paramJSONObject.put("result", "");
      paramf.i(paramInt, n("ok", paramJSONObject));
      AppMethodBeat.o(137501);
      return;
    }
    paramJSONObject = dO((Context)localObject1);
    JSONArray localJSONArray = new JSONArray();
    if (!paramJSONObject.isEmpty())
    {
      Iterator localIterator = paramJSONObject.iterator();
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
            localObject1 = Util.nullAs(localObject3[1], "");
            if ((Util.isNullOrNil(paramJSONObject)) || (!dq((String)localObject2, paramJSONObject))) {
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
              Log.printErrStackTrace("MicroMsg.JsApiSearchContacts", paramJSONObject, "", new Object[0]);
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
    Log.d("MicroMsg.JsApiSearchContacts", "resultArray:%s", new Object[] { localJSONArray.toString() });
    paramJSONObject = new HashMap();
    paramJSONObject.put("result", localJSONArray);
    paramf.i(paramInt, n("ok", paramJSONObject));
    AppMethodBeat.o(137501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.g
 * JD-Core Version:    0.7.0.1
 */