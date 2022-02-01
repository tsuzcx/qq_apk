package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.s;

public final class g
  extends d
{
  public g(String paramString, c paramc, s params)
  {
    super(paramString, paramc, params);
  }
  
  public final void cdf()
  {
    AppMethodBeat.i(135546);
    if (this.oFe != null) {
      b.aXY().a(new b.k()
      {
        public final void I(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(135544);
          g.this.X(paramAnonymousBitmap);
          AppMethodBeat.o(135544);
        }
        
        public final String Lb()
        {
          return g.this.oFe;
        }
        
        public final void aYg() {}
        
        public final void oD()
        {
          AppMethodBeat.i(135545);
          g.this.oFf.a("Failed to load icon via network", g.this);
          AppMethodBeat.o(135545);
        }
      }, this.oFe, null);
    }
    AppMethodBeat.o(135546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.g
 * JD-Core Version:    0.7.0.1
 */