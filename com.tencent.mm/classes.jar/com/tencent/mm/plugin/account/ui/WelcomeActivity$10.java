package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.facebook.AccessToken;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.d;
import com.tencent.mm.ui.g.a.d.a;
import org.json.JSONObject;

final class WelcomeActivity$10
  implements d.a
{
  WelcomeActivity$10(WelcomeActivity paramWelcomeActivity) {}
  
  public final void o(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(125646);
    ab.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture completed!");
    if (paramJSONObject != null) {}
    try
    {
      Intent localIntent = new Intent(this.gKy, RegByMobileRegAIOUI.class);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (WelcomeActivity.d(this.gKy).AnY != null)
      {
        localObject1 = localObject2;
        if (WelcomeActivity.d(this.gKy).AnY.getToken() != null) {
          localObject1 = WelcomeActivity.d(this.gKy).AnY.getToken().toString();
        }
      }
      localIntent.putExtra("third_app_token", (String)localObject1);
      localIntent.putExtra("reg_3d_app_type", 1);
      localIntent.putExtra("register_title", this.gKy.getString(2131298865));
      if (paramJSONObject.has("name"))
      {
        localIntent.putExtra("register_nick_name", paramJSONObject.getString("name"));
        ab.i("MicroMsg.WelcomeActivity", "name %s", new Object[] { paramJSONObject.getString("name") });
      }
      if (paramJSONObject.has("picture"))
      {
        ab.i("MicroMsg.WelcomeActivity", "picture %s", new Object[] { paramJSONObject.get("picture") });
        localIntent.putExtra("register_avatar", ((JSONObject)paramJSONObject.get("picture")).getJSONObject("data").getString("url"));
      }
      this.gKy.startActivity(localIntent);
      WelcomeActivity.a(this.gKy).cXw = 1L;
      WelcomeActivity.a(this.gKy).cRH = 3L;
      WelcomeActivity.a(this.gKy).ake();
      AppMethodBeat.o(125646);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.WelcomeActivity", paramJSONObject, "parse json error!", new Object[0]);
      h.b(this.gKy, "Retrieve Failed, Error Format!", "", true);
      AppMethodBeat.o(125646);
    }
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(125647);
    ab.i("MicroMsg.WelcomeActivity", "facebook-android get name and picture error! %s", new Object[] { paramString });
    h.b(this.gKy, this.gKy.getString(2131299621), "", true);
    AppMethodBeat.o(125647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.10
 * JD-Core Version:    0.7.0.1
 */