package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;
import java.util.ArrayList;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 226;
  public static final String NAME = "addPhoneContact";
  private a hKh;
  
  private static void a(ArrayList<ContentValues> paramArrayList, a.a parama, int paramInt)
  {
    AppMethodBeat.i(126266);
    if ((parama != null) && (parama.aCR().length() > 0))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
      localContentValues.put("data1", parama.aCR());
      localContentValues.put("data9", parama.hKg);
      localContentValues.put("data2", Integer.valueOf(paramInt));
      paramArrayList.add(localContentValues);
    }
    AppMethodBeat.o(126266);
  }
  
  private static void a(ArrayList<ContentValues> paramArrayList, String paramString, int paramInt)
  {
    AppMethodBeat.i(126267);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
    localContentValues.put("data1", paramString);
    localContentValues.put("data2", Integer.valueOf(paramInt));
    paramArrayList.add(localContentValues);
    AppMethodBeat.o(126267);
  }
  
  private static a.a e(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(126265);
    paramJSONObject = new a.a(paramJSONObject.optString(paramString + "Country"), paramJSONObject.optString(paramString + "State"), paramJSONObject.optString(paramString + "City"), paramJSONObject.optString(paramString + "Street"), paramJSONObject.optString(paramString + "PostalCode"));
    AppMethodBeat.o(126265);
    return paramJSONObject;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126264);
    ab.d("MicroMsg.JsApiAddPhoneContact", "addPhoneContact!");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data is null", null));
      ab.e("MicroMsg.JsApiAddPhoneContact", "data is null");
      AppMethodBeat.o(126264);
      return;
    }
    if (bo.isNullOrNil(paramJSONObject.optString("firstName")))
    {
      paramc.h(paramInt, j("fail:firstName is null", null));
      ab.e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
      AppMethodBeat.o(126264);
      return;
    }
    Object localObject1 = paramc.getContext();
    if ((localObject1 == null) || (!(localObject1 instanceof Activity)))
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiAddPhoneContact", "activity is null, invoke fail!");
      AppMethodBeat.o(126264);
      return;
    }
    this.hKh = new a();
    this.hKh.hJS = paramJSONObject.optString("photoFilePath");
    this.hKh.blZ = paramJSONObject.optString("nickName");
    Object localObject2 = new a.b(paramJSONObject.optString("firstName"), paramJSONObject.optString("middleName"), paramJSONObject.optString("lastName"));
    this.hKh.hJR = ((a.b)localObject2);
    this.hKh.hKa = paramJSONObject.optString("remark");
    this.hKh.hJW = paramJSONObject.optString("mobilePhoneNumber");
    this.hKh.hKe = paramJSONObject.optString("weChatNumber");
    this.hKh.hJV = e(paramJSONObject, "address");
    this.hKh.hKb = paramJSONObject.optString("organization");
    this.hKh.title = paramJSONObject.optString("title");
    this.hKh.hKc = paramJSONObject.optString("workFaxNumber");
    this.hKh.hJZ = paramJSONObject.optString("workPhoneNumber");
    this.hKh.hJY = paramJSONObject.optString("hostNumber");
    this.hKh.dqF = paramJSONObject.optString("email");
    this.hKh.url = paramJSONObject.optString("url");
    this.hKh.hJU = e(paramJSONObject, "workAddress");
    this.hKh.hKd = paramJSONObject.optString("homeFaxNumber");
    this.hKh.hJX = paramJSONObject.optString("homePhoneNumber");
    this.hKh.hJT = e(paramJSONObject, "homeAddress");
    paramJSONObject = (Activity)localObject1;
    localObject1 = paramJSONObject.getString(2131301374);
    localObject2 = paramJSONObject.getString(2131301373);
    d locald = new d(paramJSONObject, 1, false);
    locald.sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(126260);
        paramAnonymousl.e(0, this.hKi[0]);
        paramAnonymousl.e(1, this.hKi[1]);
        AppMethodBeat.o(126260);
      }
    };
    locald.sap = new b.2(this, paramJSONObject, paramc, paramc, paramInt);
    locald.crd();
    AppMethodBeat.o(126264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b
 * JD-Core Version:    0.7.0.1
 */