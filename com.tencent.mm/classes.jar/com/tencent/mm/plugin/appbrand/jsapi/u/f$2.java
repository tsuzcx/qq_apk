package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.report.model.o;
import com.tencent.mm.ui.widget.MMWebView;

final class f$2
  implements f.a
{
  f$2(f paramf, a parama) {}
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(131670);
    a locala = this.ihu;
    if (locala.getWebView().canGoBack())
    {
      locala.getReporter().a(locala.hzR, true);
      locala.getWebView().goBack();
      locala.igK = true;
      AppMethodBeat.o(131670);
      return true;
    }
    locala.getReporter().a(locala.hzR, false);
    AppMethodBeat.o(131670);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.f.2
 * JD-Core Version:    0.7.0.1
 */