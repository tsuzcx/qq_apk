package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.w.a;
import com.tencent.mm.plugin.appbrand.page.w.b;
import com.tencent.mm.plugin.appbrand.page.w.d;
import java.util.concurrent.Callable;

final class f$5
  implements w.b
{
  f$5(f paramf) {}
  
  public final w.a a(w.a parama)
  {
    AppMethodBeat.i(219541);
    Object localObject = parama;
    if (parama == null) {
      localObject = new w.a()
      {
        public final boolean MX()
        {
          return false;
        }
        
        public final ac a(w paramAnonymousw)
        {
          return null;
        }
        
        public final t a(String paramAnonymousString, bx paramAnonymousbx, w paramAnonymousw, Callable<t> paramAnonymousCallable)
        {
          AppMethodBeat.i(219536);
          if (f.5.a(f.5.this, paramAnonymousString, paramAnonymousbx))
          {
            paramAnonymousString = f.5.this.nDA.nDj;
            AppMethodBeat.o(219536);
            return paramAnonymousString;
          }
          AppMethodBeat.o(219536);
          return null;
        }
        
        public final boolean a(String paramAnonymousString, bx paramAnonymousbx, w paramAnonymousw, w.d paramAnonymousd)
        {
          return false;
        }
      };
    }
    parama = new w.a()
    {
      public final boolean MX()
      {
        AppMethodBeat.i(219540);
        boolean bool = this.nDH.MX();
        AppMethodBeat.o(219540);
        return bool;
      }
      
      public final ac a(w paramAnonymousw)
      {
        AppMethodBeat.i(219538);
        paramAnonymousw = this.nDH.a(paramAnonymousw);
        AppMethodBeat.o(219538);
        return paramAnonymousw;
      }
      
      public final t a(String paramAnonymousString, bx paramAnonymousbx, w paramAnonymousw, Callable<t> paramAnonymousCallable)
      {
        AppMethodBeat.i(219537);
        if (f.5.a(f.5.this, paramAnonymousString, paramAnonymousbx))
        {
          paramAnonymousString = f.5.this.nDA.nDj;
          AppMethodBeat.o(219537);
          return paramAnonymousString;
        }
        paramAnonymousString = this.nDH.a(paramAnonymousString, paramAnonymousbx, paramAnonymousw, paramAnonymousCallable);
        AppMethodBeat.o(219537);
        return paramAnonymousString;
      }
      
      public final boolean a(String paramAnonymousString, bx paramAnonymousbx, w paramAnonymousw, w.d paramAnonymousd)
      {
        AppMethodBeat.i(219539);
        boolean bool = this.nDH.a(paramAnonymousString, paramAnonymousbx, paramAnonymousw, paramAnonymousd);
        AppMethodBeat.o(219539);
        return bool;
      }
    };
    AppMethodBeat.o(219541);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f.5
 * JD-Core Version:    0.7.0.1
 */