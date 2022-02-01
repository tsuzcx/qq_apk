package com.tencent.mm.plugin.appbrand.launching.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class f
  extends a
{
  final void a(String paramString, Uri paramUri, a.a parama)
  {
    int j = 1;
    AppMethodBeat.i(47415);
    if (paramUri == null) {}
    for (paramString = "";; paramString = paramUri.getQueryParameter("appid")) {
      switch (1.lRi[parama.ordinal()])
      {
      default: 
        AppBrand404PageUI.show(2131755402);
        AppMethodBeat.o(47415);
        return;
      }
    }
    if ((paramUri != null) && (paramUri.getBooleanQueryParameter("debug", false)))
    {
      i = 1;
      AppBrand404PageUI.show(2131755644);
      if (i == 0) {
        break label125;
      }
    }
    label125:
    for (int i = j;; i = 0)
    {
      h.S(paramString, 2, i + 1);
      AppMethodBeat.o(47415);
      return;
      i = 0;
      break;
    }
    AppBrand404PageUI.show(2131755605);
    h.S("", 3, 2);
    AppMethodBeat.o(47415);
    return;
    AppBrand404PageUI.show(2131755606);
    h.S("", 4, 2);
    AppMethodBeat.o(47415);
    return;
    AppMethodBeat.o(47415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.f
 * JD-Core Version:    0.7.0.1
 */