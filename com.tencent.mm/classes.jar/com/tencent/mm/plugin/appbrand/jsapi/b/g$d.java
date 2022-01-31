package com.tencent.mm.plugin.appbrand.jsapi.b;

import a.f.b.j;
import a.l;
import com.tencent.luggage.g.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MagicBrushView;
import com.tencent.magicbrush.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onForeground"})
final class g$d
  implements f.d
{
  g$d(MBRuntime paramMBRuntime, MagicBrushView paramMagicBrushView) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(134667);
    d.i("JsApiInsertHTMLCanvasElement", "foreground");
    g localg = this.hJN.getMBRuntimeView();
    if ((localg != null) && (j.e(localg, this.hJO.getTextureView())))
    {
      d.i("JsApiInsertHTMLCanvasElement", "foreground, really");
      this.hJO.notifyForeground();
    }
    AppMethodBeat.o(134667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.g.d
 * JD-Core Version:    0.7.0.1
 */