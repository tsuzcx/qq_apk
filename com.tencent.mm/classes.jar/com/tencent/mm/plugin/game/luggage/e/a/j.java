package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bb;
import com.tencent.mm.protocal.protobuf.coq;
import org.json.JSONObject;

public final class j
  extends a
{
  public j()
  {
    super(3);
  }
  
  public final void a(Context paramContext, g paramg, coq paramcoq)
  {
    AppMethodBeat.i(83115);
    bb.afY(0);
    paramg.ctS.a(new d()
    {
      public final JSONObject Ld()
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.j
 * JD-Core Version:    0.7.0.1
 */