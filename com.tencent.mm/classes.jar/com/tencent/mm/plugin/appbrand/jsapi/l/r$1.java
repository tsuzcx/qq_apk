package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.i.d;
import com.tencent.mm.plugin.appbrand.widget.i.e;

final class r$1
  extends e
{
  r$1(r paramr, v paramv) {}
  
  public final void a(Bitmap paramBitmap, d paramd)
  {
    AppMethodBeat.i(140849);
    super.a(paramBitmap, paramd);
    if (this.hVQ.isRunning()) {
      this.hVQ.getActionBar().a(paramBitmap, new r.1.1(this));
    }
    AppMethodBeat.o(140849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.r.1
 * JD-Core Version:    0.7.0.1
 */