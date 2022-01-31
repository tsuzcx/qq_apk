package com.tencent.mm.plugin.appbrand.launching.b;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.y.j;

public final class c
  extends a
{
  final void a(String paramString, Uri paramUri, a.a parama)
  {
    switch (c.1.gMe[parama.ordinal()])
    {
    default: 
      AppBrand404PageUI.show(y.j.app_brand_error);
    case 4: 
      return;
    case 1: 
      AppBrand404PageUI.show(y.j.app_brand_error);
      return;
    case 2: 
      AppBrand404PageUI.show(y.j.app_brand_error);
      return;
    }
    AppBrand404PageUI.show(y.j.app_brand_error);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.c
 * JD-Core Version:    0.7.0.1
 */