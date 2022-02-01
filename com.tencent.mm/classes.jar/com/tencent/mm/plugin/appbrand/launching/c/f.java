package com.tencent.mm.plugin.appbrand.launching.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.report.j;
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
      switch (1.tdD[parama.ordinal()])
      {
      default: 
        AppBrand404PageUI.Dk(ba.i.app_brand_error);
        AppMethodBeat.o(47415);
        return;
      }
    }
    if ((paramUri != null) && (paramUri.getBooleanQueryParameter("debug", false)))
    {
      i = 1;
      AppBrand404PageUI.Dk(ba.i.app_brand_scan_qrcode_parameter_error);
      if (i == 0) {
        break label127;
      }
    }
    label127:
    for (int i = j;; i = 0)
    {
      j.Z(paramString, 2, i + 1);
      AppMethodBeat.o(47415);
      return;
      i = 0;
      break;
    }
    AppBrand404PageUI.Dk(ba.i.app_brand_qrcode_result_dev_qrcode_expired);
    j.Z("", 3, 2);
    AppMethodBeat.o(47415);
    return;
    AppBrand404PageUI.Dk(ba.i.app_brand_qrcode_result_uin_invalid);
    j.Z("", 4, 2);
    AppMethodBeat.o(47415);
    return;
    AppMethodBeat.o(47415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c.f
 * JD-Core Version:    0.7.0.1
 */