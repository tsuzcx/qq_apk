package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public class e
  extends aw<d>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiGetLocalWePkgInfo", "invokeInMM");
    ai.d(new e.1(this, parama));
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(a<d>.a parama) {}
  
  public final String name()
  {
    return "getLocalWePkgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.e
 * JD-Core Version:    0.7.0.1
 */