package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.protocal.protobuf.bpp;
import org.json.JSONObject;

public final class j
  extends a
{
  public j()
  {
    super(3);
  }
  
  public final void a(Context paramContext, f paramf, bpp parambpp)
  {
    AppMethodBeat.i(83115);
    ax.SL(0);
    paramf.caI.a(new c()
    {
      public final JSONObject AM()
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.j
 * JD-Core Version:    0.7.0.1
 */