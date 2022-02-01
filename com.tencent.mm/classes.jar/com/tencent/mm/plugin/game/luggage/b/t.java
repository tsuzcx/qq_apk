package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class t
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(195144);
    JSONObject localJSONObject = b.LK(paramString);
    if (localJSONObject == null)
    {
      parama.f("invalid_data", null);
      AppMethodBeat.o(195144);
      return;
    }
    paramString = new Bundle();
    try
    {
      paramString.putString("appId", localJSONObject.getString("appId"));
      paramString.putString("data", localJSONObject.toString());
      label61:
      ((com.tencent.mm.plugin.lite.a.a)g.ab(com.tencent.mm.plugin.lite.a.a.class)).a(paramContext, paramString, new a.a()
      {
        public final void cOF()
        {
          AppMethodBeat.i(195142);
          parama.f("success", null);
          AppMethodBeat.o(195142);
        }
        
        public final void cOG()
        {
          AppMethodBeat.i(195143);
          parama.f("fail", null);
          AppMethodBeat.o(195143);
        }
      });
      AppMethodBeat.o(195144);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label61;
    }
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bYk()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openLiteApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.t
 * JD-Core Version:    0.7.0.1
 */