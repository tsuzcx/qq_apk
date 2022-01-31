package com.tencent.mm.plugin.appbrand.jsapi.b;

import a.f.b.j;
import a.l;
import com.tencent.luggage.g.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MagicBrushView;
import com.tencent.magicbrush.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onViewWillDisappear"})
final class g$f
  implements f.f
{
  g$f(MBRuntime paramMBRuntime, MagicBrushView paramMagicBrushView) {}
  
  public final void aBv()
  {
    AppMethodBeat.i(134669);
    d.i("JsApiInsertHTMLCanvasElement", "disappear");
    g localg = this.hJN.getMBRuntimeView();
    if ((localg != null) && (j.e(localg, this.hJO.getTextureView())))
    {
      d.i("JsApiInsertHTMLCanvasElement", "disappear, really");
      this.hJN.setMBRuntimeView(null);
      this.hJN.resetScreenCanvasFlag();
    }
    AppMethodBeat.o(134669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.g.f
 * JD-Core Version:    0.7.0.1
 */