package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.d.a;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.ui.widget.MMWebView;

final class f$1
  implements Runnable
{
  f$1(f paramf, z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(131669);
    com.tencent.mm.plugin.appbrand.page.b.d locald = (com.tencent.mm.plugin.appbrand.page.b.d)this.hKE.x(com.tencent.mm.plugin.appbrand.page.b.d.class);
    if (locald != null)
    {
      locald.eF(true);
      locald.eE(false);
      locald.a(d.a.iAu, this.hKE.getContext().getResources().getColor(2131690695));
    }
    for (;;)
    {
      this.hKE.aJq();
      this.hKE.getActionBar().a(new com.tencent.mm.plugin.appbrand.widget.actionbar.a()
      {
        public final void aGp()
        {
          AppMethodBeat.i(131668);
          a locala = f.1.this.hKE.aJz();
          if (locala != null) {
            locala.foJ.getView().scrollTo(locala.foJ.getWebScrollX(), 0);
          }
          AppMethodBeat.o(131668);
        }
      });
      AppMethodBeat.o(131669);
      return;
      if (this.hKE.gPS) {
        locald.eF(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.f.1
 * JD-Core Version:    0.7.0.1
 */