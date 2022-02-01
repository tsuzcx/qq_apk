package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class d$1
  implements i.c
{
  d$1(d paramd, i parami) {}
  
  public final void ed(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136258);
    int i = this.lWz.osn;
    Object localObject = ad.aVe().JV("AppBrandJsInput@".concat(String.valueOf(i)));
    if (localObject == null) {
      localObject = null;
    }
    while ((localObject == null) || (!((ac)localObject).isRunning()))
    {
      AppMethodBeat.o(136258);
      return;
      localObject = (WeakReference)((ad.b)localObject).get("webview_reference", null);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (ac)((WeakReference)localObject).get();
      }
    }
    d.a locala = new d.a((byte)0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(g.zC(paramInt2)));
    localHashMap.put("lineCount", Integer.valueOf(paramInt1));
    localHashMap.put("inputId", Integer.valueOf(i));
    locala.g((f)localObject).K(localHashMap).bEo();
    AppMethodBeat.o(136258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.d.1
 * JD-Core Version:    0.7.0.1
 */