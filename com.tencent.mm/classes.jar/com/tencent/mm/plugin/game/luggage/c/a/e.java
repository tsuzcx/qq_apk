package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.protocal.protobuf.bpp;
import org.json.JSONObject;

public final class e
  extends a
{
  public e()
  {
    super(10);
  }
  
  public final void a(Context paramContext, f paramf, final bpp parambpp)
  {
    AppMethodBeat.i(83108);
    paramf.caI.a(new c()
    {
      public final JSONObject AM()
      {
        AppMethodBeat.i(83107);
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("itemId", parambpp.DNZ);
          AppMethodBeat.o(83107);
          return localJSONObject;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(83107);
        }
        return null;
      }
      
      public final String name()
      {
        return "onCustomGameMenuClicked";
      }
    });
    AppMethodBeat.o(83108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.e
 * JD-Core Version:    0.7.0.1
 */