package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import org.json.JSONArray;

final class b$4
  implements Runnable
{
  b$4(b paramb, JSONArray paramJSONArray, a.a parama) {}
  
  public final void run()
  {
    this.fLj.fLh = true;
    if (this.fLj.fKQ == null) {
      this.fLj.fKQ = this.fLk;
    }
    for (;;)
    {
      this.fLj.fKP = true;
      if (this.fLl != null) {
        this.fLl.a(null);
      }
      return;
      int i = 0;
      while (i < this.fLk.length())
      {
        this.fLj.fKQ.put(this.fLk.opt(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.4
 * JD-Core Version:    0.7.0.1
 */