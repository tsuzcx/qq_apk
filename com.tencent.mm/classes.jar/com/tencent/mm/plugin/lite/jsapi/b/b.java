package com.tencent.mm.plugin.lite.jsapi.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.plugin.topstory.a.c.d;
import com.tencent.mm.protocal.protobuf.cfa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.lite.jsapi.b
{
  public final void a(final String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(234266);
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("openId")) {
          break label185;
        }
        paramString = paramJSONObject.getString("openId");
        if (paramJSONObject.has("userName")) {
          str = paramJSONObject.getString("userName");
        }
        if (str != null)
        {
          paramString = new Intent();
          paramString.putExtra("Contact_User", str);
          paramString.putExtra("Contact_Scene", 3);
          c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", paramString);
          this.Ega.eLC();
          AppMethodBeat.o(234266);
          return;
        }
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("LiteAppJsApiOpenProfileWithOpenId", paramString, "get openId", new Object[0]);
        this.Ega.aNa("get openId exception");
        AppMethodBeat.o(234266);
        return;
      }
      if (paramString == null)
      {
        this.Ega.aNa("openId or userName is required");
        AppMethodBeat.o(234266);
        return;
      }
      paramString = new d(paramString);
      h.aGY().a(paramString.getType(), new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(233770);
          h.aGY().b(paramString.getType(), this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            b.a(b.this).aNa("goUserProfile failed");
            Log.e("LiteAppJsApiOpenProfileWithOpenId", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(233770);
            return;
          }
          paramAnonymousString = ((d)paramAnonymousq).gpW().username;
          paramAnonymousq = new Intent();
          paramAnonymousq.putExtra("Contact_User", paramAnonymousString);
          paramAnonymousq.putExtra("Contact_Scene", 3);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0))
          {
            c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousq);
            b.b(b.this).eLC();
          }
          AppMethodBeat.o(233770);
        }
      });
      h.aGY().a(paramString, 0);
      AppMethodBeat.o(234266);
      return;
      label185:
      paramString = null;
    }
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.b.b
 * JD-Core Version:    0.7.0.1
 */