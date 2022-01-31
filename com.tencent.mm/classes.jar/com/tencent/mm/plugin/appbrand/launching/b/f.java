package com.tencent.mm.plugin.appbrand.launching.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class f
  extends a
{
  final void a(String paramString, Uri paramUri, a.a parama)
  {
    int j = 1;
    AppMethodBeat.i(132040);
    if (paramUri == null) {}
    for (paramString = "";; paramString = paramUri.getQueryParameter("appid")) {
      switch (f.1.inv[parama.ordinal()])
      {
      default: 
        AppBrand404PageUI.show(2131296631);
        AppMethodBeat.o(132040);
        return;
      }
    }
    if ((paramUri != null) && (paramUri.getBooleanQueryParameter("debug", false)))
    {
      i = 1;
      AppBrand404PageUI.show(2131296844);
      if (i == 0) {
        break label125;
      }
    }
    label125:
    for (int i = j;; i = 0)
    {
      e.U(paramString, 2, i + 1);
      AppMethodBeat.o(132040);
      return;
      i = 0;
      break;
    }
    AppBrand404PageUI.show(2131296812);
    e.U("", 3, 2);
    AppMethodBeat.o(132040);
    return;
    AppBrand404PageUI.show(2131296813);
    e.U("", 4, 2);
    AppMethodBeat.o(132040);
    return;
    AppMethodBeat.o(132040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.f
 * JD-Core Version:    0.7.0.1
 */