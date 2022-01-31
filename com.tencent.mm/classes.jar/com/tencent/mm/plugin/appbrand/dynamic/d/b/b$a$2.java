package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;

final class b$a$2
  implements a.a
{
  b$a$2(b.a parama, String paramString1, String paramString2, int paramInt) {}
  
  public final void a(DrawCanvasArg paramDrawCanvasArg)
  {
    if (com.tencent.mm.ipcinvoker.e.fE(this.fWc)) {
      a.aJ(this.fVX, this.fVY).w(new b.a.2.1(this, paramDrawCanvasArg));
    }
    while (paramDrawCanvasArg == null) {
      return;
    }
    paramDrawCanvasArg.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.2
 * JD-Core Version:    0.7.0.1
 */