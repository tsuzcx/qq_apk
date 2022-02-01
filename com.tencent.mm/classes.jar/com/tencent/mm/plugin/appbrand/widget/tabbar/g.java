package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.r;

public final class g
  extends d
{
  public g(String paramString, c paramc, r paramr)
  {
    super(paramString, paramc, paramr);
  }
  
  public final void bGG()
  {
    AppMethodBeat.i(135546);
    if (this.nva != null) {
      b.aEl().a(new b.k()
      {
        public final String BN()
        {
          return g.this.nva;
        }
        
        public final void F(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(135544);
          g.this.S(paramAnonymousBitmap);
          AppMethodBeat.o(135544);
        }
        
        public final void aEt() {}
        
        public final void ox()
        {
          AppMethodBeat.i(135545);
          g.this.nvb.a("Failed to load icon via network", g.this);
          AppMethodBeat.o(135545);
        }
      }, this.nva, null);
    }
    AppMethodBeat.o(135546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.g
 * JD-Core Version:    0.7.0.1
 */