package com.tencent.mm.plugin.lite.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends a
{
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(final String paramString, JSONObject paramJSONObject)
  {
    String str = null;
    AppMethodBeat.i(217819);
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("openId")) {
          break label181;
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
          com.tencent.mm.br.d.b(ak.getContext(), "profile", ".ui.ContactInfoUI", paramString);
          this.vko.cZN();
          AppMethodBeat.o(217819);
          return;
        }
      }
      catch (JSONException paramString)
      {
        ae.printErrStackTrace("LiteAppJsApiOpenProfileWithOpenId", paramString, "get openId", new Object[0]);
        this.vko.ZC("get openId exception");
        AppMethodBeat.o(217819);
        return;
      }
      if (paramString == null)
      {
        this.vko.ZC("openId or userName is required");
        AppMethodBeat.o(217819);
        return;
      }
      paramString = new com.tencent.mm.plugin.topstory.a.c.d(paramString);
      g.ajj().a(paramString.getType(), new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(217818);
          g.ajj().b(paramString.getType(), this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            b.a(b.this).ZC("goUserProfile failed");
            ae.e("LiteAppJsApiOpenProfileWithOpenId", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(217818);
            return;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.topstory.a.c.d)paramAnonymousn).esD().username;
          paramAnonymousn = new Intent();
          paramAnonymousn.putExtra("Contact_User", paramAnonymousString);
          paramAnonymousn.putExtra("Contact_Scene", 3);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0))
          {
            com.tencent.mm.br.d.b(ak.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousn);
            b.b(b.this).cZN();
          }
          AppMethodBeat.o(217818);
        }
      });
      g.ajj().a(paramString, 0);
      AppMethodBeat.o(217819);
      return;
      label181:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.e.b
 * JD-Core Version:    0.7.0.1
 */