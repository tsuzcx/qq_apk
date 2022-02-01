package com.tencent.mm.plugin.lite.a.f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.topstory.a.c.d;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends e
{
  public final void a(final String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(271507);
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
          this.JZj.fTW();
          AppMethodBeat.o(271507);
          return;
        }
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("LiteAppJsApiOpenProfileWithOpenId", paramString, "get openId", new Object[0]);
        this.JZj.aJV("get openId exception");
        AppMethodBeat.o(271507);
        return;
      }
      if (paramString == null)
      {
        this.JZj.aJV("openId or userName is required");
        AppMethodBeat.o(271507);
        return;
      }
      paramString = new d(paramString);
      com.tencent.mm.kernel.h.aZW().a(paramString.getType(), new com.tencent.mm.am.h()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(271494);
          com.tencent.mm.kernel.h.aZW().b(paramString.getType(), this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            b.a(b.this).aJV("goUserProfile failed");
            Log.e("LiteAppJsApiOpenProfileWithOpenId", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(271494);
            return;
          }
          paramAnonymousString = ((d)paramAnonymousp).hMS().username;
          paramAnonymousp = new Intent();
          paramAnonymousp.putExtra("Contact_User", paramAnonymousString);
          paramAnonymousp.putExtra("Contact_Scene", 3);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0))
          {
            c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousp);
            b.b(b.this).fTW();
          }
          AppMethodBeat.o(271494);
        }
      });
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      AppMethodBeat.o(271507);
      return;
      label185:
      paramString = null;
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.f.b
 * JD-Core Version:    0.7.0.1
 */