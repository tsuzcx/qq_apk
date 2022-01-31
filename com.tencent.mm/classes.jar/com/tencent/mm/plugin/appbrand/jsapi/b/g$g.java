package com.tencent.mm.plugin.appbrand.jsapi.b;

import a.f.b.j;
import a.l;
import com.tencent.luggage.g.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MagicBrushView;
import com.tencent.magicbrush.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onDestroy"})
final class g$g
  implements f.c
{
  g$g(MBRuntime paramMBRuntime, MagicBrushView paramMagicBrushView) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(134670);
    d.i("JsApiInsertHTMLCanvasElement", "destroy");
    g localg = this.hJN.getMBRuntimeView();
    if ((localg != null) && (j.e(localg, this.hJO.getTextureView())))
    {
      d.i("JsApiInsertHTMLCanvasElement", "destroy, really");
      this.hJN.setMBRuntimeView(null);
      this.hJN.resetScreenCanvasFlag();
    }
    AppMethodBeat.o(134670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.g.g
 * JD-Core Version:    0.7.0.1
 */