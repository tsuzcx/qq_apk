package com.tencent.luggage.game.e.b;

import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.input.w.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class e$6
  implements w.e
{
  e$6(e parame, WAGamePanelInputEditText paramWAGamePanelInputEditText, r paramr, com.tencent.luggage.game.widget.input.a parama, float paramFloat, int paramInt) {}
  
  public final void fq(int paramInt)
  {
    AppMethodBeat.i(140478);
    if (2 == paramInt)
    {
      localObject = this.bBC.bBv;
      String str = this.bBD.getEditableText().toString();
      r localr = this.bAW;
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("errMsg", "ok");
      localHashMap.put("value", str);
      ((a)localObject).w(localHashMap).i(localr).aBz();
      AppMethodBeat.o(140478);
      return;
    }
    paramInt = this.bBE.getHeight();
    ab.i("MicroMsg.WAGameJsApiShowKeyboard", "onVisibilityChanged inputPanelHeight(%d),density(%f).", new Object[] { Integer.valueOf(paramInt), Float.valueOf(this.bBF) });
    Object localObject = new HashMap(1);
    ((Map)localObject).put("height", Float.valueOf(paramInt / this.bBF));
    this.bAW.h(this.bAX, this.bBC.j("ok", (Map)localObject));
    AppMethodBeat.o(140478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.e.b.e.6
 * JD-Core Version:    0.7.0.1
 */