package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.c;
import org.json.JSONObject;

final class WelcomeActivity$11
  implements al.a
{
  JSONObject gDr = null;
  
  WelcomeActivity$11(WelcomeActivity paramWelcomeActivity) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(125648);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("fields", "name,picture.type(large)");
    try
    {
      localObject = WelcomeActivity.e(this.gKy).q("me", (Bundle)localObject);
      ab.i("MicroMsg.WelcomeActivity", "result json %s", new Object[] { localObject });
      this.gDr = new JSONObject((String)localObject);
      AppMethodBeat.o(125648);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WelcomeActivity", localException, "get name and picture error!", new Object[0]);
        h.b(this.gKy, "Retrieve Failed, Error Format!", "", true);
      }
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(125649);
    if (this.gDr != null) {}
    try
    {
      Intent localIntent = new Intent(this.gKy, RegByMobileRegAIOUI.class);
      localIntent.putExtra("third_app_token", WelcomeActivity.e(this.gKy).gsH.toString());
      localIntent.putExtra("reg_3d_app_type", 1);
      localIntent.putExtra("register_title", this.gKy.getString(2131298865));
      localIntent.putExtra("register_nick_name", this.gDr.getString("name"));
      localIntent.putExtra("register_avatar", ((JSONObject)this.gDr.get("picture")).getJSONObject("data").getString("url"));
      this.gKy.startActivity(localIntent);
      WelcomeActivity.a(this.gKy).cXw = 1L;
      WelcomeActivity.a(this.gKy).cRH = 3L;
      WelcomeActivity.a(this.gKy).ake();
      AppMethodBeat.o(125649);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WelcomeActivity", localException, "parse json error!", new Object[0]);
        h.b(this.gKy, "Retrieve Failed, Error Format!", "", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.11
 * JD-Core Version:    0.7.0.1
 */