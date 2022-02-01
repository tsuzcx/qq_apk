package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.q;

public final class g
  extends d
{
  public g(String paramString, c paramc, q paramq)
  {
    super(paramString, paramc, paramq);
  }
  
  public final void bBJ()
  {
    AppMethodBeat.i(135546);
    if (this.mPt != null) {
      b.aAS().a(new b.k()
      {
        public final String Ap()
        {
          return g.this.mPt;
        }
        
        public final void E(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(135544);
          g.this.R(paramAnonymousBitmap);
          AppMethodBeat.o(135544);
        }
        
        public final void aBa() {}
        
        public final void of()
        {
          AppMethodBeat.i(135545);
          g.this.mPu.a("Failed to load icon via network", g.this);
          AppMethodBeat.o(135545);
        }
      }, this.mPt, null);
    }
    AppMethodBeat.o(135546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.g
 * JD-Core Version:    0.7.0.1
 */