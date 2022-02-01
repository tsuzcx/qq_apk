package com.tencent.mm.plugin.lite.jsapi.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.plugin.topstory.a.c.d;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.lite.jsapi.b
{
  public final void a(final String paramString, JSONObject paramJSONObject)
  {
    String str = null;
    AppMethodBeat.i(198849);
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
          c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", paramString);
          this.yEn.ecz();
          AppMethodBeat.o(198849);
          return;
        }
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("LiteAppJsApiOpenProfileWithOpenId", paramString, "get openId", new Object[0]);
        this.yEn.aCS("get openId exception");
        AppMethodBeat.o(198849);
        return;
      }
      if (paramString == null)
      {
        this.yEn.aCS("openId or userName is required");
        AppMethodBeat.o(198849);
        return;
      }
      paramString = new d(paramString);
      g.azz().a(paramString.getType(), new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(198848);
          g.azz().b(paramString.getType(), this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            b.a(b.this).aCS("goUserProfile failed");
            Log.e("LiteAppJsApiOpenProfileWithOpenId", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(198848);
            return;
          }
          paramAnonymousString = ((d)paramAnonymousq).fyb().username;
          paramAnonymousq = new Intent();
          paramAnonymousq.putExtra("Contact_User", paramAnonymousString);
          paramAnonymousq.putExtra("Contact_Scene", 3);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0))
          {
            c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousq);
            b.b(b.this).ecz();
          }
          AppMethodBeat.o(198848);
        }
      });
      g.azz().a(paramString, 0);
      AppMethodBeat.o(198849);
      return;
      label181:
      paramString = null;
    }
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.b.b
 * JD-Core Version:    0.7.0.1
 */