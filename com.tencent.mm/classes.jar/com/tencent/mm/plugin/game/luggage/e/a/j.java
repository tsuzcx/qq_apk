package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bf;
import com.tencent.mm.protocal.protobuf.doh;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  extends a
{
  public j()
  {
    super(3);
  }
  
  public final void a(Context paramContext, g paramg, doh paramdoh)
  {
    AppMethodBeat.i(83115);
    bf.atG(0);
    paramg.ejR.a(new d()
    {
      public final JSONObject aoe()
      {
        AppMethodBeat.i(277002);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("scene", "friend");
          label22:
          AppMethodBeat.o(277002);
          return localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          break label22;
        }
      }
      
      public final String name()
      {
        return "menu:share:appmessage";
      }
    });
    AppMethodBeat.o(83115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.j
 * JD-Core Version:    0.7.0.1
 */