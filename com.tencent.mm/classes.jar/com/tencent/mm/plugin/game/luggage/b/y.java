package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bj;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class y
  extends bv<a>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(277126);
    Log.i("MicroMsg.JsApiOpenFinderPostView", "invokeInMM");
    paramContext = c.ZL(paramString);
    if (paramContext == null)
    {
      parama.j("invalid_params", null);
      AppMethodBeat.o(277126);
      return;
    }
    try
    {
      ((cn)h.az(cn.class)).enterFinderPostUI(MMApplicationContext.getContext(), paramContext.toString(), 1, new bj()
      {
        public final void callback(int paramAnonymousInt, String paramAnonymousString) {}
      });
      parama.j("post successful", null);
      AppMethodBeat.o(277126);
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.JsApiOpenFinderPostView", paramContext, "OpenFinderPostViewTask exception", new Object[0]);
      parama.j("post cancel", null);
      AppMethodBeat.o(277126);
    }
  }
  
  public final void b(b<a>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "openFinderPostView";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.y
 * JD-Core Version:    0.7.0.1
 */