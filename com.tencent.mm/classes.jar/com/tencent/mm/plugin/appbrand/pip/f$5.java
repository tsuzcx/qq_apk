package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.br;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.t.a;
import com.tencent.mm.plugin.appbrand.page.t.b;
import com.tencent.mm.plugin.appbrand.page.t.d;
import com.tencent.mm.plugin.appbrand.page.z;
import java.util.concurrent.Callable;

final class f$5
  implements t.b
{
  f$5(f paramf) {}
  
  public final t.a a(t.a parama)
  {
    AppMethodBeat.i(207939);
    Object localObject = parama;
    if (parama == null) {
      localObject = new t.a()
      {
        public final boolean DA()
        {
          return false;
        }
        
        public final q a(String paramAnonymousString, br paramAnonymousbr, t paramAnonymoust, Callable<q> paramAnonymousCallable)
        {
          AppMethodBeat.i(207934);
          if (f.5.a(f.5.this, paramAnonymousString, paramAnonymousbr))
          {
            paramAnonymousString = f.5.this.msR.msz;
            AppMethodBeat.o(207934);
            return paramAnonymousString;
          }
          AppMethodBeat.o(207934);
          return null;
        }
        
        public final z a(t paramAnonymoust)
        {
          return null;
        }
        
        public final boolean a(String paramAnonymousString, br paramAnonymousbr, t paramAnonymoust, t.d paramAnonymousd)
        {
          return false;
        }
      };
    }
    parama = new t.a()
    {
      public final boolean DA()
      {
        AppMethodBeat.i(207938);
        boolean bool = this.msZ.DA();
        AppMethodBeat.o(207938);
        return bool;
      }
      
      public final q a(String paramAnonymousString, br paramAnonymousbr, t paramAnonymoust, Callable<q> paramAnonymousCallable)
      {
        AppMethodBeat.i(207935);
        if (f.5.a(f.5.this, paramAnonymousString, paramAnonymousbr))
        {
          paramAnonymousString = f.5.this.msR.msz;
          AppMethodBeat.o(207935);
          return paramAnonymousString;
        }
        paramAnonymousString = this.msZ.a(paramAnonymousString, paramAnonymousbr, paramAnonymoust, paramAnonymousCallable);
        AppMethodBeat.o(207935);
        return paramAnonymousString;
      }
      
      public final z a(t paramAnonymoust)
      {
        AppMethodBeat.i(207936);
        paramAnonymoust = this.msZ.a(paramAnonymoust);
        AppMethodBeat.o(207936);
        return paramAnonymoust;
      }
      
      public final boolean a(String paramAnonymousString, br paramAnonymousbr, t paramAnonymoust, t.d paramAnonymousd)
      {
        AppMethodBeat.i(207937);
        boolean bool = this.msZ.a(paramAnonymousString, paramAnonymousbr, paramAnonymoust, paramAnonymousd);
        AppMethodBeat.o(207937);
        return bool;
      }
    };
    AppMethodBeat.o(207939);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f.5
 * JD-Core Version:    0.7.0.1
 */