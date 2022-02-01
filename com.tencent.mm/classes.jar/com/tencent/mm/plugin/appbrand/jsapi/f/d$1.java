package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.c;
import com.tencent.mm.plugin.appbrand.z.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class d$1
  implements i.c
{
  d$1(d paramd, i parami) {}
  
  public final void dR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136258);
    int i = this.kNV.ndw;
    Object localObject = y.aBq().AF("AppBrandJsInput@".concat(String.valueOf(i)));
    if (localObject == null) {
      localObject = null;
    }
    while ((localObject == null) || (!((aa)localObject).isRunning()))
    {
      AppMethodBeat.o(136258);
      return;
      localObject = (WeakReference)((y.b)localObject).get("webview_reference", null);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (aa)((WeakReference)localObject).get();
      }
    }
    d.a locala = new d.a((byte)0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("height", Integer.valueOf(g.vI(paramInt2)));
    localHashMap.put("lineCount", Integer.valueOf(paramInt1));
    localHashMap.put("inputId", Integer.valueOf(i));
    locala.g((c)localObject).A(localHashMap).bir();
    AppMethodBeat.o(136258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.d.1
 * JD-Core Version:    0.7.0.1
 */