package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.bzp;
import org.json.JSONObject;

public final class e
  extends a
{
  public e()
  {
    super(10);
  }
  
  public final void a(Context paramContext, g paramg, final bzp parambzp)
  {
    AppMethodBeat.i(83108);
    paramg.chX.a(new d()
    {
      public final JSONObject BP()
      {
        AppMethodBeat.i(83107);
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("itemId", parambzp.Hnz);
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.e
 * JD-Core Version:    0.7.0.1
 */