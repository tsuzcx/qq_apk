package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.v;

public final class g
  extends d
{
  public g(String paramString, c paramc, v paramv)
  {
    super(paramString, paramc, paramv);
  }
  
  public final void cqr()
  {
    AppMethodBeat.i(135546);
    if (this.rGO != null) {
      b.bhh().a(new b.k()
      {
        public final void G(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(135544);
          g.this.V(paramAnonymousBitmap);
          AppMethodBeat.o(135544);
        }
        
        public final void bhq() {}
        
        public final void bhr()
        {
          AppMethodBeat.i(135545);
          g.this.rGP.a("Failed to load icon via network", g.this);
          AppMethodBeat.o(135545);
        }
        
        public final String key()
        {
          return g.this.rGO;
        }
      }, this.rGO, null);
    }
    AppMethodBeat.o(135546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.g
 * JD-Core Version:    0.7.0.1
 */