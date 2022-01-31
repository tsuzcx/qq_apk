package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class p
  extends bh<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(135881);
    ab.i("MicroMsg.JsApiOpenGameRegion", "invoke");
    MMActivity localMMActivity = (MMActivity)((f)parama.byE).mContext;
    localMMActivity.mmSetOnActivityResultCallback(new p.1(this, parama, localMMActivity));
    d.a(localMMActivity, "game", ".ui.GameRegionSelectUI", null, hashCode() & 0xFFFF, false);
    AppMethodBeat.o(135881);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "openGameRegion";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.p
 * JD-Core Version:    0.7.0.1
 */