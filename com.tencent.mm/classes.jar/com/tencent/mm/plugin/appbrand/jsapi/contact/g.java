package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import androidx.core.app.a.a;
import androidx.core.content.a;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
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
  extends c
{
  public static final int CTRL_INDEX = 414;
  public static final String NAME = "searchContacts";
  
  private static String Tu(String paramString)
  {
    AppMethodBeat.i(327797);
    if (paramString == null)
    {
      AppMethodBeat.o(327797);
      return null;
    }
    String str = paramString.replaceAll("\\D", "");
    paramString = str;
    if (str.startsWith("86")) {
      paramString = str.substring(2);
    }
    AppMethodBeat.o(327797);
    return paramString;
  }
  
  private boolean c(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(327801);
    if (a.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.READ_CONTACTS") == 0)
    {
      AppMethodBeat.o(327801);
      return true;
    }
    paramf.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(327793);
        s.a(paramf.getAppId(), new a.a()
        {
          public final void onRequestPermissionsResult(int paramAnonymous2Int, String[] paramAnonymous2ArrayOfString, int[] paramAnonymous2ArrayOfInt)
          {
            AppMethodBeat.i(327806);
            if (paramAnonymous2Int != 48)
            {
              AppMethodBeat.o(327806);
              return;
            }
            if ((paramAnonymous2ArrayOfInt != null) && (paramAnonymous2ArrayOfInt.length > 0) && (paramAnonymous2ArrayOfInt[0] == 0))
            {
              g.this.a(g.1.this.erj, g.1.this.ejE, g.1.this.elZ, true);
              AppMethodBeat.o(327806);
              return;
            }
            g.1.this.erj.callback(g.1.this.elZ, g.this.a(null, a.e.rVw, null));
            AppMethodBeat.o(327806);
          }
        });
        Context localContext = paramf.getContext();
        if ((localContext == null) || (!(localContext instanceof Activity)))
        {
          paramf.callback(paramInt, g.this.ZP("fail:internal error invalid android context"));
          AppMethodBeat.o(327793);
          return;
        }
        if (i.a((Activity)localContext, paramf, "android.permission.READ_CONTACTS", 48, "", "")) {
          s.afs(paramf.getAppId());
        }
        AppMethodBeat.o(327793);
      }
    });
    AppMethodBeat.o(327801);
    return false;
  }
  
  private static boolean dS(String paramString1, String paramString2)
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
  
  private static List<String[]> eI(Context paramContext)
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
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137501);
    a(paramf, paramJSONObject, paramInt, false);
    AppMethodBeat.o(137501);
  }
  
  final void a(f paramf, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(327808);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSearchContacts", "data is null, err");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(327808);
      return;
    }
    Log.i("MicroMsg.JsApiSearchContacts", "JsApiSearchContacts invoke");
    Log.d("MicroMsg.JsApiSearchContacts", "data:%s", new Object[] { paramJSONObject });
    if ((!paramBoolean) && (!c(paramf, paramJSONObject, paramInt)))
    {
      Log.i("MicroMsg.JsApiSearchContacts", "check permission");
      AppMethodBeat.o(327808);
      return;
    }
    Object localObject1 = paramJSONObject.optString("phoneNumber");
    if (((String)localObject1).length() < 8)
    {
      Log.e("MicroMsg.JsApiSearchContacts", "phoneNumber is short");
      paramJSONObject = new HashMap();
      paramJSONObject.put("result", "");
      paramf.callback(paramInt, m("ok", paramJSONObject));
      AppMethodBeat.o(327808);
      return;
    }
    Object localObject2 = eI(MMApplicationContext.getContext());
    if (localObject2 == null)
    {
      Log.e("MicroMsg.JsApiSearchContacts", "addressList is null, err");
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(327808);
      return;
    }
    paramJSONObject = new JSONArray();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (String[])((Iterator)localObject2).next();
        String str = Tu(localObject3[2]);
        localObject3 = Util.nullAs(localObject3[1], "");
        if ((!Util.isNullOrNil(str)) && (dS((String)localObject1, str))) {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("phoneNumber", str);
            localJSONObject.put("name", localObject3);
            paramJSONObject.put(localJSONObject);
          }
          catch (JSONException localJSONException)
          {
            Log.printErrStackTrace("MicroMsg.JsApiSearchContacts", localJSONException, "", new Object[0]);
          }
        }
      }
    }
    Log.d("MicroMsg.JsApiSearchContacts", "resultArray:%s", new Object[] { paramJSONObject.toString() });
    localObject1 = new HashMap();
    ((Map)localObject1).put("result", paramJSONObject);
    paramf.callback(paramInt, m("ok", (Map)localObject1));
    AppMethodBeat.o(327808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.g
 * JD-Core Version:    0.7.0.1
 */