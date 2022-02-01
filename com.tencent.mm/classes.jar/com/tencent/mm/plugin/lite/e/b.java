package com.tencent.mm.plugin.lite.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends a
{
  public final int cXg()
  {
    return 1;
  }
  
  public final void j(final String paramString, JSONObject paramJSONObject)
  {
    String str = null;
    AppMethodBeat.i(217198);
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
          com.tencent.mm.bs.d.b(aj.getContext(), "profile", ".ui.ContactInfoUI", paramString);
          this.uYz.cXe();
          AppMethodBeat.o(217198);
          return;
        }
      }
      catch (JSONException paramString)
      {
        ad.printErrStackTrace("LiteAppJsApiOpenProfileWithOpenId", paramString, "get openId", new Object[0]);
        this.uYz.YL("get openId exception");
        AppMethodBeat.o(217198);
        return;
      }
      if (paramString == null)
      {
        this.uYz.YL("openId or userName is required");
        AppMethodBeat.o(217198);
        return;
      }
      paramString = new com.tencent.mm.plugin.topstory.a.c.d(paramString);
      g.aiU().a(paramString.getType(), new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(217197);
          g.aiU().b(paramString.getType(), this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            b.a(b.this).YL("goUserProfile failed");
            ad.e("LiteAppJsApiOpenProfileWithOpenId", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(217197);
            return;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.topstory.a.c.d)paramAnonymousn).eoW().username;
          paramAnonymousn = new Intent();
          paramAnonymousn.putExtra("Contact_User", paramAnonymousString);
          paramAnonymousn.putExtra("Contact_Scene", 3);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0))
          {
            com.tencent.mm.bs.d.b(aj.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousn);
            b.b(b.this).cXe();
          }
          AppMethodBeat.o(217197);
        }
      });
      g.aiU().a(paramString, 0);
      AppMethodBeat.o(217198);
      return;
      label181:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.e.b
 * JD-Core Version:    0.7.0.1
 */