package com.tencent.mm.plugin.lite.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends a
{
  public void invoke(final String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(205719);
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("openId")) {
          break label185;
        }
        paramString = paramJSONObject.getString("openId");
        if (!paramJSONObject.has("userName")) {
          break label180;
        }
        paramJSONObject = paramJSONObject.getString("userName");
        if (paramJSONObject != null)
        {
          paramString = new Intent();
          paramString.putExtra("Contact_User", paramJSONObject);
          paramString.putExtra("Contact_Scene", 3);
          com.tencent.mm.br.d.b(ai.getContext(), "profile", ".ui.ContactInfoUI", paramString);
          this.mInvokeCallback.af(null);
          AppMethodBeat.o(205719);
          return;
        }
      }
      catch (JSONException paramString)
      {
        ac.printErrStackTrace("LiteAppJsApiOpenProfileWithOpenId", paramString, "get openId", new Object[0]);
        this.mInvokeCallback.Vc("get openId exception");
        AppMethodBeat.o(205719);
        return;
      }
      if (paramString == null)
      {
        this.mInvokeCallback.Vc("openId or userName is required");
        AppMethodBeat.o(205719);
        return;
      }
      paramString = new com.tencent.mm.plugin.topstory.a.c.d(paramString);
      com.tencent.mm.kernel.g.agi().a(paramString.getType(), new com.tencent.mm.ak.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(205718);
          com.tencent.mm.kernel.g.agi().b(paramString.getType(), this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            b.a(b.this).Vc("goUserProfile failed");
            ac.e("LiteAppJsApiOpenProfileWithOpenId", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(205718);
            return;
          }
          paramAnonymousString = ((com.tencent.mm.plugin.topstory.a.c.d)paramAnonymousn).ecF().username;
          paramAnonymousn = new Intent();
          paramAnonymousn.putExtra("Contact_User", paramAnonymousString);
          paramAnonymousn.putExtra("Contact_Scene", 3);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0))
          {
            com.tencent.mm.br.d.b(ai.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousn);
            b.b(b.this).af(null);
          }
          AppMethodBeat.o(205718);
        }
      });
      com.tencent.mm.kernel.g.agi().a(paramString, 0);
      AppMethodBeat.o(205719);
      return;
      label180:
      paramJSONObject = null;
      continue;
      label185:
      paramString = null;
    }
  }
  
  public int runModel()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.e.b
 * JD-Core Version:    0.7.0.1
 */