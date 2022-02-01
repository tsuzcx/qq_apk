package com.tencent.mm.plugin.appbrand.page;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class AppBrandMenuHeader$3
  implements l.a
{
  AppBrandMenuHeader$3(AppBrandMenuHeader paramAppBrandMenuHeader, TextView paramTextView) {}
  
  public final void aex(String paramString)
  {
    AppMethodBeat.i(47773);
    if (Util.isNullOrNil(paramString))
    {
      this.tua.setVisibility(8);
      AppMethodBeat.o(47773);
      return;
    }
    this.tua.setText(paramString);
    this.tua.setVisibility(0);
    AppMethodBeat.o(47773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandMenuHeader.3
 * JD-Core Version:    0.7.0.1
 */