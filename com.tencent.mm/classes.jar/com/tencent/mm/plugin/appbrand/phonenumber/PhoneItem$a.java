package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "TAG", "", "parseFromJson", "jsonStr", "plugin-appbrand-integration_release"})
public final class PhoneItem$a
{
  public static PhoneItem EB(String paramString)
  {
    AppMethodBeat.i(134799);
    j.q(paramString, "jsonStr");
    try
    {
      Object localObject = new JSONObject(paramString);
      String str1 = ((JSONObject)localObject).optString("mobile");
      String str2 = ((JSONObject)localObject).optString("show_mobile");
      boolean bool1 = ((JSONObject)localObject).optBoolean("need_auth", true);
      boolean bool2 = ((JSONObject)localObject).optBoolean("allow_send_sms", true);
      String str3 = ((JSONObject)localObject).optString("encryptedData");
      String str4 = ((JSONObject)localObject).optString("iv");
      boolean bool3 = ((JSONObject)localObject).optBoolean("is_wechat", false);
      boolean bool4 = ((JSONObject)localObject).optBoolean("is_check", false);
      j.p(str1, "mobile");
      j.p(str2, "showMobile");
      j.p(str3, "encryptedData");
      j.p(str4, "iv");
      localObject = new PhoneItem(str1, str2, str3, str4, bool1, bool2, bool3, bool4);
      AppMethodBeat.o(134799);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      d.e("MicroMsg.PhoneItem", "jsonStr:%s", new Object[] { paramString });
      AppMethodBeat.o(134799);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem.a
 * JD-Core Version:    0.7.0.1
 */