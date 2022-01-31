package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 277;
  public static final String NAME = "startSoterAuthentication";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(3225);
    ab.i("MicroMsg.JsApiStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
    if ((paramc.getContext() instanceof MMActivity)) {}
    for (MMActivity localMMActivity = (MMActivity)paramc.getContext(); localMMActivity == null; localMMActivity = null)
    {
      ab.e("MicroMsg.JsApiStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", new Object[] { paramc.getAppId() });
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(3225);
      return;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("requestAuthModes");
    String str = paramJSONObject.optString("challenge");
    paramJSONObject = paramJSONObject.optString("authContent");
    Intent localIntent = new Intent(localMMActivity, SoterAuthenticationUIWC.class);
    localIntent.putExtra("auth_mode", a.n(localJSONArray));
    localIntent.putExtra("challenge", str);
    localIntent.putExtra("auth_content", paramJSONObject);
    localIntent.putExtra("key_soter_fp_mp_scene", 0);
    localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        c localc = null;
        Object localObject2 = null;
        Object localObject1 = null;
        AppMethodBeat.i(3224);
        if (paramAnonymousInt1 == 1000)
        {
          if (paramAnonymousInt2 == -1)
          {
            ab.i("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth ok");
            localc = c.this;
            localObject2 = paramc;
            paramAnonymousInt1 = paramInt;
            if (paramAnonymousIntent != null) {
              localObject1 = paramAnonymousIntent.getExtras();
            }
            c.a(localc, (com.tencent.mm.plugin.appbrand.jsapi.c)localObject2, paramAnonymousInt1, (Bundle)localObject1, "ok");
            AppMethodBeat.o(3224);
            return;
          }
          if (paramAnonymousInt2 == 1)
          {
            ab.w("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth failed");
            localObject2 = c.this;
            localc1 = paramc;
            paramAnonymousInt1 = paramInt;
            localObject1 = localc;
            if (paramAnonymousIntent != null) {
              localObject1 = paramAnonymousIntent.getExtras();
            }
            c.a((c)localObject2, localc1, paramAnonymousInt1, (Bundle)localObject1, "fail");
            AppMethodBeat.o(3224);
            return;
          }
          ab.e("MicroMsg.JsApiStartSoterAuthentication", "hy: soter user cancelled");
          localc = c.this;
          com.tencent.mm.plugin.appbrand.jsapi.c localc1 = paramc;
          paramAnonymousInt1 = paramInt;
          localObject1 = localObject2;
          if (paramAnonymousIntent != null) {
            localObject1 = paramAnonymousIntent.getExtras();
          }
          c.a(localc, localc1, paramAnonymousInt1, (Bundle)localObject1, "cancel");
        }
        AppMethodBeat.o(3224);
      }
    });
    localMMActivity.startActivityForResult(localIntent, 1000);
    AppMethodBeat.o(3225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.c
 * JD-Core Version:    0.7.0.1
 */