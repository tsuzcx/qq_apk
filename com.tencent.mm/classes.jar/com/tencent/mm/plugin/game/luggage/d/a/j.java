package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.ba;
import com.tencent.mm.protocal.protobuf.byv;
import org.json.JSONObject;

public final class j
  extends a
{
  public j()
  {
    super(3);
  }
  
  public final void a(Context paramContext, g paramg, byv parambyv)
  {
    AppMethodBeat.i(83115);
    ba.WJ(0);
    paramg.chX.a(new d()
    {
      public final JSONObject BO()
      {
        return null;
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.j
 * JD-Core Version:    0.7.0.1
 */