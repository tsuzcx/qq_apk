package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 72;
  public static final String NAME = "chooseContact";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof MMActivity)))
    {
      y.e("MicroMsg.JsApiChooseContact", "getPageContext failed, appid is %s", new Object[] { paramc.getAppId() });
      paramc.C(paramInt, h("fail", null));
      return;
    }
    e.b(paramc.getAppId(), new b.2(this, paramc, paramJSONObject, paramInt));
    paramJSONObject = paramc.getContext();
    int i;
    if ((paramJSONObject == null) || (!(paramJSONObject instanceof Activity)))
    {
      paramc.C(paramInt, h("fail", null));
      i = 0;
    }
    while (i == 0)
    {
      y.i("MicroMsg.JsApiChooseContact", "check permission");
      return;
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)paramJSONObject, "android.permission.READ_CONTACTS", 48, "", "");
      i = bool;
      if (bool)
      {
        e.vX(paramc.getAppId());
        i = bool;
      }
    }
    paramc = new b.1(this, paramc, paramInt, localContext);
    ((MMActivity)localContext).gJb = paramc;
    paramc = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    ((MMActivity)localContext).startActivityForResult(paramc, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b
 * JD-Core Version:    0.7.0.1
 */