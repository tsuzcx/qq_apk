package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.plugin.appbrand.widget.input.c.c;
import com.tencent.mm.plugin.appbrand.widget.input.y;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class h$3
  implements c
{
  h$3(h paramh, com.tencent.mm.plugin.appbrand.widget.input.i parami, String paramString, v paramv) {}
  
  public final void bg(String paramString, int paramInt)
  {
    AppMethodBeat.i(123547);
    int i = this.hMD.jlk;
    if (this.hMD.jll == null)
    {
      ab.e("MicroMsg.JsApiShowKeyboard", "dispatchKBValue(%s), but get NULL inputWidget", new Object[] { this.val$appId });
      AppMethodBeat.o(123547);
      return;
    }
    h.a locala = new h.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("value", e.Fq(paramString));
    localHashMap.put("data", h.ob(i));
    localHashMap.put("cursor", Integer.valueOf(paramInt));
    localHashMap.put("inputId", Integer.valueOf(i));
    localHashMap.put("keyCode", Integer.valueOf(this.hMD.jll.getLastKeyPressed()));
    locala.a(this.hEe.getRuntime().ws(), this.hEe.hashCode()).w(localHashMap).aBz();
    AppMethodBeat.o(123547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.h.3
 * JD-Core Version:    0.7.0.1
 */