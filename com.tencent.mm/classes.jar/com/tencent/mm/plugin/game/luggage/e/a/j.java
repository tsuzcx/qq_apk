package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bb;
import com.tencent.mm.protocal.protobuf.cxc;
import org.json.JSONObject;

public final class j
  extends a
{
  public j()
  {
    super(3);
  }
  
  public final void a(Context paramContext, g paramg, cxc paramcxc)
  {
    AppMethodBeat.i(83115);
    bb.anM(0);
    paramg.crX.a(new d()
    {
      public final JSONObject NU()
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