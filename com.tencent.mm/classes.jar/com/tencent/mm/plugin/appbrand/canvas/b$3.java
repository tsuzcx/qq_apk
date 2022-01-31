package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import org.json.JSONArray;

final class b$3
  implements Runnable
{
  b$3(b paramb, JSONArray paramJSONArray, a.a parama) {}
  
  public final void run()
  {
    DrawCanvasArg localDrawCanvasArg = this.fLj.fKR;
    this.fLj.fKR = null;
    this.fLj.fKQ = this.fLk;
    this.fLj.fLh = true;
    this.fLj.fKP = true;
    if (this.fLl != null) {
      this.fLl.a(localDrawCanvasArg);
    }
    b.a(this.fLj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.3
 * JD-Core Version:    0.7.0.1
 */