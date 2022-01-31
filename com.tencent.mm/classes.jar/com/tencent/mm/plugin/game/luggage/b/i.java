package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public class i
  extends aw<com.tencent.mm.plugin.game.luggage.d>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<com.tencent.mm.plugin.game.luggage.d>.a parama)
  {
    y.i("MicroMsg.JsApiOpenGameRegion", "invoke");
    MMActivity localMMActivity = (MMActivity)((com.tencent.mm.plugin.game.luggage.d)parama.big).mContext;
    localMMActivity.gJb = new i.1(this, parama, localMMActivity);
    com.tencent.mm.br.d.a(localMMActivity, "game", ".ui.GameRegionSelectUI", null, hashCode() & 0xFFFF, false);
  }
  
  public final String name()
  {
    return "openGameRegion";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.i
 * JD-Core Version:    0.7.0.1
 */