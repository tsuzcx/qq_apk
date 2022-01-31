package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.ContentValues;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.d.a;
import com.tencent.mm.plugin.appbrand.appstorage.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 226;
  public static final String NAME = "addPhoneContact";
  private d gpC;
  
  private static void a(ArrayList<ContentValues> paramArrayList, d.a parama, int paramInt)
  {
    if ((parama != null) && (parama.acH().length() > 0))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
      localContentValues.put("data1", parama.acH());
      localContentValues.put("data9", parama.fGQ);
      localContentValues.put("data2", Integer.valueOf(paramInt));
      paramArrayList.add(localContentValues);
    }
  }
  
  private static void a(ArrayList<ContentValues> paramArrayList, String paramString, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
    localContentValues.put("data1", paramString);
    localContentValues.put("data2", Integer.valueOf(paramInt));
    paramArrayList.add(localContentValues);
  }
  
  private static d.a g(JSONObject paramJSONObject, String paramString)
  {
    return new d.a(paramJSONObject.optString(paramString + "Country"), paramJSONObject.optString(paramString + "State"), paramJSONObject.optString(paramString + "City"), paramJSONObject.optString(paramString + "Street"), paramJSONObject.optString(paramString + "PostalCode"));
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.d("MicroMsg.JsApiAddPhoneContact", "addPhoneContact!");
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null", null));
      y.e("MicroMsg.JsApiAddPhoneContact", "data is null");
      return;
    }
    if (bk.bl(paramJSONObject.optString("firstName")))
    {
      paramc.C(paramInt, h("fail:firstName is null", null));
      y.e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
      return;
    }
    Object localObject1 = paramc.getContext();
    if ((localObject1 == null) || (!(localObject1 instanceof MMActivity)))
    {
      paramc.C(paramInt, h("fail", null));
      y.e("MicroMsg.JsApiAddPhoneContact", "mmActivity is null, invoke fail!");
      return;
    }
    this.gpC = new d();
    this.gpC.fGC = paramJSONObject.optString("photoFilePath");
    this.gpC.aVr = paramJSONObject.optString("nickName");
    Object localObject2 = new d.b(paramJSONObject.optString("firstName"), paramJSONObject.optString("middleName"), paramJSONObject.optString("lastName"));
    this.gpC.fGB = ((d.b)localObject2);
    this.gpC.fGK = paramJSONObject.optString("remark");
    this.gpC.fGG = paramJSONObject.optString("mobilePhoneNumber");
    this.gpC.fGO = paramJSONObject.optString("weChatNumber");
    this.gpC.fGF = g(paramJSONObject, "address");
    this.gpC.fGL = paramJSONObject.optString("organization");
    this.gpC.title = paramJSONObject.optString("title");
    this.gpC.fGM = paramJSONObject.optString("workFaxNumber");
    this.gpC.fGJ = paramJSONObject.optString("workPhoneNumber");
    this.gpC.fGI = paramJSONObject.optString("hostNumber");
    this.gpC.cCt = paramJSONObject.optString("email");
    this.gpC.url = paramJSONObject.optString("url");
    this.gpC.fGE = g(paramJSONObject, "workAddress");
    this.gpC.fGN = paramJSONObject.optString("homeFaxNumber");
    this.gpC.fGH = paramJSONObject.optString("homePhoneNumber");
    this.gpC.fGD = g(paramJSONObject, "homeAddress");
    ((MMActivity)localObject1).gJb = new a.2(this, paramc, paramInt);
    paramJSONObject = (MMActivity)localObject1;
    localObject1 = paramJSONObject.getString(y.j.app_brand_phone_contact_add_new_contact);
    localObject2 = paramJSONObject.getString(y.j.app_brand_phone_contact_add_exist_contact);
    paramc = new a.1(this, paramJSONObject, paramc);
    h.a(paramJSONObject, "", new String[] { localObject1, localObject2 }, "", paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.a
 * JD-Core Version:    0.7.0.1
 */