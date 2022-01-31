package com.tencent.mm.plugin.appbrand.launching.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class d
  extends a
{
  final void a(String paramString, Uri paramUri, a.a parama)
  {
    AppMethodBeat.i(132038);
    switch (d.1.inv[parama.ordinal()])
    {
    default: 
      AppBrand404PageUI.show(2131296631);
      AppMethodBeat.o(132038);
      return;
    case 1: 
      AppBrand404PageUI.show(2131296588);
      AppMethodBeat.o(132038);
      return;
    case 2: 
      AppBrand404PageUI.show(2131296589);
      AppMethodBeat.o(132038);
      return;
    case 3: 
      AppBrand404PageUI.show(2131296813);
      AppMethodBeat.o(132038);
      return;
    }
    AppMethodBeat.o(132038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.d
 * JD-Core Version:    0.7.0.1
 */