package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.y;

public final class g
  extends d
{
  public g(String paramString, c paramc, y paramy)
  {
    super(paramString, paramc, paramy);
  }
  
  public final void cSY()
  {
    AppMethodBeat.i(135546);
    if (this.uSe != null) {
      b.bEY().a(new b.k()
      {
        public final void bFg() {}
        
        public final void bFh()
        {
          AppMethodBeat.i(135545);
          g.this.uSf.a("Failed to load icon via network", g.this);
          AppMethodBeat.o(135545);
        }
        
        public final String key()
        {
          return g.this.uSe;
        }
        
        public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(135544);
          g.this.ae(paramAnonymousBitmap);
          AppMethodBeat.o(135544);
        }
      }, this.uSe, null);
    }
    AppMethodBeat.o(135546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.g
 * JD-Core Version:    0.7.0.1
 */