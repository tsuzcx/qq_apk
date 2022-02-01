package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.d;
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
    if ((parama != null) && (parama.aZF().length() > 0))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
      localContentValues.put("data1", parama.aZF());
      localContentValues.put("data9", parama.jOi);
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
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
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
    final Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, e("fail", null));
      ad.e("MicroMsg.JsApiAddPhoneContact", "activity is null, invoke fail!");
      AppMethodBeat.o(137492);
      return;
    }
    final a locala = new a();
    locala.jNV = paramJSONObject.optString("photoFilePath");
    locala.bNK = paramJSONObject.optString("nickName");
    locala.jNU = new a.b(paramJSONObject.optString("firstName"), paramJSONObject.optString("middleName"), paramJSONObject.optString("lastName"));
    locala.iaz = paramJSONObject.optString("remark");
    locala.jNZ = paramJSONObject.optString("mobilePhoneNumber");
    locala.jOg = paramJSONObject.optString("weChatNumber");
    locala.jNY = d(paramJSONObject, "address");
    locala.jOd = paramJSONObject.optString("organization");
    locala.title = paramJSONObject.optString("title");
    locala.jOe = paramJSONObject.optString("workFaxNumber");
    locala.jOc = paramJSONObject.optString("workPhoneNumber");
    locala.jOb = paramJSONObject.optString("hostNumber");
    locala.evs = paramJSONObject.optString("email");
    locala.url = paramJSONObject.optString("url");
    locala.jNX = d(paramJSONObject, "workAddress");
    locala.jOf = paramJSONObject.optString("homeFaxNumber");
    locala.jOa = paramJSONObject.optString("homePhoneNumber");
    locala.jNW = d(paramJSONObject, "homeAddress");
    paramc.L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186004);
        b localb = b.this;
        Activity localActivity = (Activity)localContext;
        a locala = locala;
        c localc = paramc;
        int i = paramInt;
        String str1 = localActivity.getString(2131761019);
        String str2 = localActivity.getString(2131761018);
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(localActivity, 1, false);
        locale.HrX = new b.2(localb, new String[] { str1, str2 });
        locale.HrY = new b.3(localb, locala, localActivity, localc, i);
        locale.csG();
        AppMethodBeat.o(186004);
      }
    });
    AppMethodBeat.o(137492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b
 * JD-Core Version:    0.7.0.1
 */