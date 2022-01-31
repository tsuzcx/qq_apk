package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.widget.input.v.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class e$6
  implements v.e
{
  e$6(e parame, WAGamePanelInputEditText paramWAGamePanelInputEditText, p paramp, com.tencent.mm.plugin.appbrand.game.widget.input.a parama, float paramFloat, int paramInt) {}
  
  public final void kT(int paramInt)
  {
    if (2 == paramInt)
    {
      localObject = this.gcl.gce;
      String str = this.gcm.getEditableText().toString();
      p localp = this.gbW;
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("errMsg", "ok");
      localHashMap.put("value", str);
      ((a)localObject).o(localHashMap).d(localp).dispatch();
      return;
    }
    paramInt = this.gcn.getHeight();
    y.i("MicroMsg.WAGameJsApiShowKeyboard", "onVisibilityChanged inputPanelHeight(%d),density(%f).", new Object[] { Integer.valueOf(paramInt), Float.valueOf(this.gco) });
    Object localObject = new HashMap(1);
    ((Map)localObject).put("height", Float.valueOf(paramInt / this.gco));
    this.gbW.C(this.dIS, this.gcl.h("ok", (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a.e.6
 * JD-Core Version:    0.7.0.1
 */