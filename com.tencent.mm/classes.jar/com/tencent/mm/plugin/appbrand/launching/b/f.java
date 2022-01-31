package com.tencent.mm.plugin.appbrand.launching.b;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.y.j;

final class f
  extends a
{
  final void a(String paramString, Uri paramUri, a.a parama)
  {
    int j = 1;
    if (paramUri == null) {}
    for (paramString = "";; paramString = paramUri.getQueryParameter("appid")) {
      switch (f.1.gMe[parama.ordinal()])
      {
      default: 
        AppBrand404PageUI.show(y.j.app_brand_error);
      case 4: 
        return;
      }
    }
    if ((paramUri != null) && (paramUri.getBooleanQueryParameter("debug", false)))
    {
      i = 1;
      AppBrand404PageUI.show(y.j.app_brand_scan_qrcode_parameter_error);
      if (i == 0) {
        break label113;
      }
    }
    label113:
    for (int i = j;; i = 0)
    {
      c.H(paramString, 2, i + 1);
      return;
      i = 0;
      break;
    }
    AppBrand404PageUI.show(y.j.app_brand_qrcode_result_dev_qrcode_expired);
    c.H("", 3, 2);
    return;
    AppBrand404PageUI.show(y.j.app_brand_qrcode_result_uin_invalid);
    c.H("", 4, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.f
 * JD-Core Version:    0.7.0.1
 */