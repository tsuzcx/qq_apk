package com.tencent.mm.plugin.appbrand.launching.b;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.y.j;

final class d
  extends a
{
  final void a(String paramString, Uri paramUri, a.a parama)
  {
    switch (d.1.gMe[parama.ordinal()])
    {
    default: 
      AppBrand404PageUI.show(y.j.app_brand_error);
    case 4: 
      return;
    case 1: 
      AppBrand404PageUI.show(y.j.app_brand_barcode_parameter_error);
      return;
    case 2: 
      AppBrand404PageUI.show(y.j.app_brand_barcode_result_dev_code_exipred);
      return;
    }
    AppBrand404PageUI.show(y.j.app_brand_qrcode_result_uin_invalid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.d
 * JD-Core Version:    0.7.0.1
 */