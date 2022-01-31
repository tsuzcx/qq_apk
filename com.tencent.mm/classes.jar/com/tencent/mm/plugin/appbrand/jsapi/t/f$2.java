package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.report.model.o;
import com.tencent.mm.ui.widget.MMWebView;

final class f$2
  implements e.a
{
  f$2(f paramf, a parama) {}
  
  public final boolean qc()
  {
    a locala = this.gGM;
    if (locala.getWebView().canGoBack())
    {
      locala.getReporter().a(locala.gGb, true);
      locala.getWebView().goBack();
      locala.gGg = true;
      return true;
    }
    locala.getReporter().a(locala.gGb, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.f.2
 * JD-Core Version:    0.7.0.1
 */