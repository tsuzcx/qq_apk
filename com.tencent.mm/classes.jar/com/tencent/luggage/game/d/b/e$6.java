package com.tencent.luggage.game.d.b;

import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.input.w.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

final class e$6
  implements w.e
{
  e$6(e parame, WAGamePanelInputEditText paramWAGamePanelInputEditText, r paramr, com.tencent.luggage.game.widget.input.a parama, float paramFloat, int paramInt) {}
  
  public final void gv(int paramInt)
  {
    AppMethodBeat.i(130616);
    if (2 == paramInt)
    {
      localObject = this.ckG.ckz;
      String str = this.ckH.getEditableText().toString();
      r localr = this.cjR;
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("errMsg", "ok");
      localHashMap.put("value", str);
      ((a)localObject).H(localHashMap).g(localr).bja();
      AppMethodBeat.o(130616);
      return;
    }
    paramInt = this.ckI.getHeight();
    ae.i("MicroMsg.WAGameJsApiShowKeyboard", "onVisibilityChanged inputPanelHeight(%d),density(%f).", new Object[] { Integer.valueOf(paramInt), Float.valueOf(this.ckJ) });
    Object localObject = new HashMap(1);
    ((Map)localObject).put("height", Float.valueOf(paramInt / this.ckJ));
    this.cjR.h(this.cjS, this.ckG.n("ok", (Map)localObject));
    AppMethodBeat.o(130616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.e.6
 * JD-Core Version:    0.7.0.1
 */