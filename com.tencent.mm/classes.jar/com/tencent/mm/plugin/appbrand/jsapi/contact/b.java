package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.e;
import java.util.ArrayList;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 226;
  public static final String NAME = "addPhoneContact";
  
  private static Bitmap O(Bitmap paramBitmap)
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
    if ((parama != null) && (parama.bkb().length() > 0))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
      localContentValues.put("data1", parama.bkb());
      localContentValues.put("data9", parama.kJJ);
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
  
  private static a.a d(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(137493);
    paramJSONObject = new a.a(paramJSONObject.optString(paramString + "Country"), paramJSONObject.optString(paramString + "State"), paramJSONObject.optString(paramString + "City"), paramJSONObject.optString(paramString + "Street"), paramJSONObject.optString(paramString + "PostalCode"));
    AppMethodBeat.o(137493);
    return paramJSONObject;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137492);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ad.e("MicroMsg.JsApiAddPhoneContact", "data is null");
      AppMethodBeat.o(137492);
      return;
    }
    if (bt.isNullOrNil(paramJSONObject.optString("firstName")))
    {
      paramc.h(paramInt, e("fail:firstName is null", null));
      ad.e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
      AppMethodBeat.o(137492);
      return;
    }
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, e("fail", null));
      ad.e("MicroMsg.JsApiAddPhoneContact", "activity is null, invoke fail!");
      AppMethodBeat.o(137492);
      return;
    }
    a locala = new a();
    locala.kJw = paramJSONObject.optString("photoFilePath");
    locala.bVF = paramJSONObject.optString("nickName");
    locala.kJv = new a.b(paramJSONObject.optString("firstName"), paramJSONObject.optString("middleName"), paramJSONObject.optString("lastName"));
    locala.iTM = paramJSONObject.optString("remark");
    locala.kJA = paramJSONObject.optString("mobilePhoneNumber");
    locala.kJH = paramJSONObject.optString("weChatNumber");
    locala.kJz = d(paramJSONObject, "address");
    locala.kJE = paramJSONObject.optString("organization");
    locala.title = paramJSONObject.optString("title");
    locala.kJF = paramJSONObject.optString("workFaxNumber");
    locala.kJD = paramJSONObject.optString("workPhoneNumber");
    locala.kJC = paramJSONObject.optString("hostNumber");
    locala.ePn = paramJSONObject.optString("email");
    locala.url = paramJSONObject.optString("url");
    locala.kJy = d(paramJSONObject, "workAddress");
    locala.kJG = paramJSONObject.optString("homeFaxNumber");
    locala.kJB = paramJSONObject.optString("homePhoneNumber");
    locala.kJx = d(paramJSONObject, "homeAddress");
    paramc.M(new b.1(this, localContext, locala, paramc, paramInt));
    AppMethodBeat.o(137492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b
 * JD-Core Version:    0.7.0.1
 */