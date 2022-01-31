package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class d$1
  implements i.c
{
  d$1(d paramd, i parami) {}
  
  public final void dh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123528);
    int i = this.hMD.jlk;
    Object localObject = com.tencent.mm.model.v.aae().oO("AppBrandJsInput@".concat(String.valueOf(i)));
    if (localObject == null) {
      localObject = null;
    }
    while ((localObject == null) || (!((com.tencent.mm.plugin.appbrand.page.v)localObject).isRunning()))
    {
      AppMethodBeat.o(123528);
      return;
      localObject = (WeakReference)((v.b)localObject).get("webview_reference", null);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (com.tencent.mm.plugin.appbrand.page.v)((WeakReference)localObject).get();
      }
    }
    d.a locala = new d.a((byte)0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(g.pN(paramInt2)));
    localHashMap.put("lineCount", Integer.valueOf(paramInt1));
    localHashMap.put("inputId", Integer.valueOf(i));
    locala.i((c)localObject).w(localHashMap).aBz();
    AppMethodBeat.o(123528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.d.1
 * JD-Core Version:    0.7.0.1
 */