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

final class FacebookLoginUI$5
  implements d.a
{
  FacebookLoginUI$5(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void o(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(124836);
    ab.i("MicroMsg.FacebookLoginUI", "facebook-android get name and picture completed!");
    if (paramJSONObject != null) {}
    try
    {
      Intent localIntent = new Intent(this.gDq, RegByMobileRegAIOUI.class);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (FacebookLoginUI.a(this.gDq).AnY != null)
      {
        localObject1 = localObject2;
        if (FacebookLoginUI.a(this.gDq).AnY.getToken() != null) {
          localObject1 = FacebookLoginUI.a(this.gDq).AnY.getToken().toString();
        }
      }
      localIntent.putExtra("third_app_token", (String)localObject1);
      localIntent.putExtra("register_title", this.gDq.getString(2131298865));
      if (paramJSONObject.has("name"))
      {
        localIntent.putExtra("register_nick_name", paramJSONObject.getString("name"));
        ab.i("MicroMsg.FacebookLoginUI", "name %s", new Object[] { paramJSONObject.getString("name") });
      }
      if (paramJSONObject.has("picture"))
      {
        ab.i("MicroMsg.FacebookLoginUI", "picture %s", new Object[] { paramJSONObject.get("picture") });
        localIntent.putExtra("register_avatar", ((JSONObject)paramJSONObject.get("picture")).getJSONObject("data").getString("url"));
      }
      this.gDq.startActivity(localIntent);
      this.gDq.finish();
      FacebookLoginUI.c(this.gDq).cXw = 1L;
      FacebookLoginUI.c(this.gDq).cRH = 4L;
      FacebookLoginUI.c(this.gDq).ake();
      AppMethodBeat.o(124836);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.FacebookLoginUI", paramJSONObject, "parse json error!", new Object[0]);
      h.b(this.gDq, "Retrieve Failed, Error Format!", "", true);
      AppMethodBeat.o(124836);
    }
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(124837);
    ab.i("MicroMsg.FacebookLoginUI", "facebook-android get name and picture error! %s", new Object[] { paramString });
    h.b(this.gDq, this.gDq.getString(2131299621), "", true);
    AppMethodBeat.o(124837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.5
 * JD-Core Version:    0.7.0.1
 */