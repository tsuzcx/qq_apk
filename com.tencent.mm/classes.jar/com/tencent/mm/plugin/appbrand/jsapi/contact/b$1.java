package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Map;

final class b$1
  implements MMActivity.a
{
  b$1(b paramb, c paramc, int paramInt, Context paramContext) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (100 != paramInt1)
    {
      y.e("MicroMsg.JsApiChooseContact", "requestcode not equal, requestCode = %d", new Object[] { Integer.valueOf(paramInt1) });
      this.ggH.C(this.dIS, this.gpI.h("fail", null));
    }
    do
    {
      return;
      if ((paramInt2 == 0) || (paramInt2 == 1))
      {
        this.ggH.C(this.dIS, this.gpI.h("cancel", null));
        return;
      }
    } while (paramInt2 != -1);
    paramIntent = paramIntent.getData();
    if (paramIntent == null)
    {
      y.e("MicroMsg.JsApiChooseContact", "onActivityResult, uri == null");
      this.ggH.C(this.dIS, this.gpI.h("fail", null));
      return;
    }
    if (!a.j(this.gpH, "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.JsApiChooseContact", "onActivityResult, no contact permission");
      this.ggH.C(this.dIS, this.gpI.h("fail:system permission denied", null));
      return;
    }
    Cursor localCursor1;
    Cursor localCursor2;
    try
    {
      localCursor1 = this.gpH.getContentResolver().query(paramIntent, null, null, null, null);
      if ((localCursor1 == null) || (localCursor1.getCount() <= 0)) {
        break label811;
      }
      localCursor1.moveToFirst();
      paramInt1 = localCursor1.getColumnIndex("has_phone_number");
      if ((paramInt1 > 0) && (localCursor1.getInt(paramInt1) <= 0)) {
        break label811;
      }
      paramIntent = localCursor1.getString(localCursor1.getColumnIndex("_id"));
      localCursor2 = this.gpH.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + paramIntent, null, null);
      y.i("MicroMsg.JsApiChooseContact", "onActivityResult, queried cursor = %s", new Object[] { localCursor1 });
      if (localCursor2 == null)
      {
        this.ggH.C(this.dIS, this.gpI.h("fail", null));
        return;
      }
    }
    catch (SecurityException paramIntent)
    {
      y.e("MicroMsg.JsApiChooseContact", "onActivityResult, permission denied: %s", new Object[] { paramIntent.toString() });
      h.b(this.gpH, ae.getResources().getString(y.j.app_brand_read_contact_error), "", true);
      this.ggH.C(this.dIS, this.gpI.h("fail:system permission denied", null));
      return;
    }
    Object localObject1;
    Object localObject2;
    if (localCursor2.moveToFirst())
    {
      localObject1 = null;
      paramIntent = null;
      if (!localCursor2.isAfterLast())
      {
        paramInt1 = localCursor2.getColumnIndex("data1");
        paramInt2 = localCursor2.getColumnIndex("display_name");
        localObject1 = localCursor2.getString(paramInt1);
        localObject2 = localCursor2.getString(paramInt2);
        y.d("MicroMsg.JsApiChooseContact", "onActivityResult, username : " + (String)localObject2);
        if (localObject1 != null)
        {
          y.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : " + (String)localObject1);
          if (localObject1 == null) {
            localObject1 = null;
          }
          for (;;)
          {
            y.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : " + (String)localObject1);
            if ((!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject1)) || (((String)localObject1).length() != 11)) {
              break label791;
            }
            y.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneResult : " + (String)localObject1);
            label577:
            localCursor2.moveToNext();
            paramIntent = (Intent)localObject1;
            localObject1 = localObject2;
            break;
            String str = ((String)localObject1).replaceAll("\\D", "");
            localObject1 = str;
            if (str.startsWith("86")) {
              localObject1 = str.substring(2);
            }
          }
        }
      }
      else
      {
        localObject2 = localObject1;
        localObject1 = paramIntent;
        paramIntent = (Intent)localObject2;
      }
    }
    for (;;)
    {
      try
      {
        localCursor2.close();
        if ((localCursor1 != null) && (!localCursor1.isClosed())) {
          localCursor1.close();
        }
        if (!bk.bl((String)localObject1))
        {
          localObject2 = new HashMap(1);
          ((Map)localObject2).put("phoneNumber", localObject1);
          localObject1 = paramIntent;
          if (paramIntent == null) {
            localObject1 = "";
          }
          ((Map)localObject2).put("displayName", localObject1);
          this.ggH.C(this.dIS, this.gpI.h("ok", (Map)localObject2));
          return;
        }
        this.ggH.C(this.dIS, this.gpI.h("fail", null));
        Toast.makeText(this.gpH, y.j.app_brand_pick_contact_error, 0).show();
        return;
      }
      catch (Exception localException)
      {
        continue;
      }
      label791:
      localObject1 = paramIntent;
      break;
      localObject1 = paramIntent;
      break label577;
      paramIntent = null;
      localObject1 = null;
      continue;
      label811:
      paramIntent = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b.1
 * JD-Core Version:    0.7.0.1
 */