package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import com.tencent.luggage.h.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;
import org.json.JSONObject;

public final class b
  extends d
{
  public static final int CTRL_INDEX = 226;
  public static final String NAME = "addPhoneContact";
  
  private static Bitmap S(Bitmap paramBitmap)
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
    if ((parama != null) && (parama.bGg().length() > 0))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
      localContentValues.put("data1", parama.bGg());
      localContentValues.put("data9", parama.lRQ);
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
  
  private static a.a e(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(137493);
    paramJSONObject = new a.a(paramJSONObject.optString(paramString + "Country"), paramJSONObject.optString(paramString + "State"), paramJSONObject.optString(paramString + "City"), paramJSONObject.optString(paramString + "Street"), paramJSONObject.optString(paramString + "PostalCode"));
    AppMethodBeat.o(137493);
    return paramJSONObject;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137492);
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiAddPhoneContact", "data is null");
      AppMethodBeat.o(137492);
      return;
    }
    if (Util.isNullOrNil(paramJSONObject.optString("firstName")))
    {
      paramf.i(paramInt, h("fail:firstName is null", null));
      Log.e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
      AppMethodBeat.o(137492);
      return;
    }
    Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramf.i(paramInt, h("fail", null));
      Log.e("MicroMsg.JsApiAddPhoneContact", "activity is null, invoke fail!");
      AppMethodBeat.o(137492);
      return;
    }
    a locala = new a();
    locala.lRD = paramJSONObject.optString("photoFilePath");
    locala.nickName = paramJSONObject.optString("nickName");
    locala.lRC = new a.b(paramJSONObject.optString("firstName"), paramJSONObject.optString("middleName"), paramJSONObject.optString("lastName"));
    locala.remark = paramJSONObject.optString("remark");
    locala.lRH = paramJSONObject.optString("mobilePhoneNumber");
    locala.lRO = paramJSONObject.optString("weChatNumber");
    locala.lRG = e(paramJSONObject, "address");
    locala.lRL = paramJSONObject.optString("organization");
    locala.title = paramJSONObject.optString("title");
    locala.lRM = paramJSONObject.optString("workFaxNumber");
    locala.lRK = paramJSONObject.optString("workPhoneNumber");
    locala.lRJ = paramJSONObject.optString("hostNumber");
    locala.fuD = paramJSONObject.optString("email");
    locala.url = paramJSONObject.optString("url");
    locala.lRF = e(paramJSONObject, "workAddress");
    locala.lRN = paramJSONObject.optString("homeFaxNumber");
    locala.lRI = paramJSONObject.optString("homePhoneNumber");
    locala.lRE = e(paramJSONObject, "homeAddress");
    paramf.P(new b.1(this, localContext, locala, paramf, paramInt));
    AppMethodBeat.o(137492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b
 * JD-Core Version:    0.7.0.1
 */