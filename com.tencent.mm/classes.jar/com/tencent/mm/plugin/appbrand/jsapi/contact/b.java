package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import com.tencent.luggage.b.a.a.g;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;
import org.json.JSONObject;

public final class b
  extends c
{
  public static final int CTRL_INDEX = 226;
  public static final String NAME = "addPhoneContact";
  
  private static Bitmap Q(Bitmap paramBitmap)
  {
    AppMethodBeat.i(176172);
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap.getByteCount() <= 819200)
    {
      AppMethodBeat.o(176172);
      return paramBitmap;
    }
    for (;;)
    {
      localBitmap = paramBitmap;
      paramBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2, false);
      try
      {
        localBitmap.recycle();
        label47:
        if ((paramBitmap != null) && (paramBitmap.getByteCount() > 819200)) {
          continue;
        }
        AppMethodBeat.o(176172);
        return paramBitmap;
      }
      catch (Throwable localThrowable)
      {
        break label47;
      }
    }
  }
  
  private static void a(ArrayList<ContentValues> paramArrayList, a.a parama, int paramInt)
  {
    AppMethodBeat.i(137494);
    if ((parama != null) && (parama.bRQ().length() > 0))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
      localContentValues.put("data1", parama.bRQ());
      localContentValues.put("data9", parama.oOv);
      localContentValues.put("data2", Integer.valueOf(paramInt));
      paramArrayList.add(localContentValues);
    }
    AppMethodBeat.o(137494);
  }
  
  private static void a(ArrayList<ContentValues> paramArrayList, String paramString, int paramInt)
  {
    AppMethodBeat.i(137495);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
    localContentValues.put("data1", paramString);
    localContentValues.put("data2", Integer.valueOf(paramInt));
    paramArrayList.add(localContentValues);
    AppMethodBeat.o(137495);
  }
  
  private static a.a f(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(137493);
    paramJSONObject = new a.a(paramJSONObject.optString(paramString + "Country"), paramJSONObject.optString(paramString + "State"), paramJSONObject.optString(paramString + "City"), paramJSONObject.optString(paramString + "Street"), paramJSONObject.optString(paramString + "PostalCode"));
    AppMethodBeat.o(137493);
    return paramJSONObject;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(137492);
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiAddPhoneContact", "data is null");
      AppMethodBeat.o(137492);
      return;
    }
    if (Util.isNullOrNil(paramJSONObject.optString("firstName")))
    {
      parame.j(paramInt, h("fail:firstName is null", null));
      Log.e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
      AppMethodBeat.o(137492);
      return;
    }
    final Context localContext = parame.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      parame.j(paramInt, h("fail", null));
      Log.e("MicroMsg.JsApiAddPhoneContact", "activity is null, invoke fail!");
      AppMethodBeat.o(137492);
      return;
    }
    final a locala = new a();
    locala.oOi = paramJSONObject.optString("photoFilePath");
    locala.nickName = paramJSONObject.optString("nickName");
    locala.oOh = new a.b(paramJSONObject.optString("firstName"), paramJSONObject.optString("middleName"), paramJSONObject.optString("lastName"));
    locala.remark = paramJSONObject.optString("remark");
    locala.oOm = paramJSONObject.optString("mobilePhoneNumber");
    locala.oOt = paramJSONObject.optString("weChatNumber");
    locala.oOl = f(paramJSONObject, "address");
    locala.oOq = paramJSONObject.optString("organization");
    locala.title = paramJSONObject.optString("title");
    locala.oOr = paramJSONObject.optString("workFaxNumber");
    locala.oOp = paramJSONObject.optString("workPhoneNumber");
    locala.oOo = paramJSONObject.optString("hostNumber");
    locala.hDf = paramJSONObject.optString("email");
    locala.url = paramJSONObject.optString("url");
    locala.oOk = f(paramJSONObject, "workAddress");
    locala.oOs = paramJSONObject.optString("homeFaxNumber");
    locala.oOn = paramJSONObject.optString("homePhoneNumber");
    locala.oOj = f(paramJSONObject, "homeAddress");
    parame.P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186004);
        b localb = b.this;
        Activity localActivity = (Activity)localContext;
        a locala = locala;
        com.tencent.mm.plugin.appbrand.jsapi.e locale = parame;
        int i = paramInt;
        String str1 = localActivity.getString(a.g.luggage_phone_contact_add_new_contact);
        String str2 = localActivity.getString(a.g.luggage_phone_contact_add_exist_contact);
        com.tencent.mm.ui.widget.a.e locale1 = new com.tencent.mm.ui.widget.a.e(localActivity, 1, false);
        locale1.ODT = new b.2(localb, new String[] { str1, str2 });
        locale1.ODU = new b.3(localb, locala, localActivity, locale, i);
        locale1.eik();
        AppMethodBeat.o(186004);
      }
    });
    AppMethodBeat.o(137492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b
 * JD-Core Version:    0.7.0.1
 */