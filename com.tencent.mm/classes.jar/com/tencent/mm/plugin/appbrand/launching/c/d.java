package com.tencent.mm.plugin.appbrand.launching.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class d
  extends a
{
  final void a(String paramString, Uri paramUri, a.a parama)
  {
    AppMethodBeat.i(47413);
    switch (1.pYQ[parama.ordinal()])
    {
    default: 
      AppBrand404PageUI.CR(au.i.app_brand_error);
      AppMethodBeat.o(47413);
      return;
    case 1: 
      AppBrand404PageUI.CR(au.i.app_brand_barcode_parameter_error);
      AppMethodBeat.o(47413);
      return;
    case 2: 
      AppBrand404PageUI.CR(au.i.app_brand_barcode_result_dev_code_exipred);
      AppMethodBeat.o(47413);
      return;
    case 3: 
      AppBrand404PageUI.CR(au.i.app_brand_qrcode_result_uin_invalid);
      AppMethodBeat.o(47413);
      return;
    }
    AppMethodBeat.o(47413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.d
 * JD-Core Version:    0.7.0.1
 */