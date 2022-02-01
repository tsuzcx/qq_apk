package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.ah.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import java.util.HashMap;

final class b
  extends bc
  implements c.b
{
  private static final int CTRL_INDEX = 678;
  public static final String NAME = "onImageViewLoad";
  private final ad.b rTC;
  private final h rTD;
  
  b(int paramInt, ad.b paramb, h paramh)
  {
    AppMethodBeat.i(327337);
    w("viewId", Integer.valueOf(paramInt));
    this.rTC = paramb;
    this.rTD = paramh;
    AppMethodBeat.o(327337);
  }
  
  public final void c(final BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(327340);
    if (paramOptions != null)
    {
      w("errMsg", "ok");
      w("size", new HashMap() {});
    }
    while ((this.rTC != null) && ("webview".equals(this.rTC.getString("sendTo", null))))
    {
      this.rTD.a(this);
      AppMethodBeat.o(327340);
      return;
      w("errMsg", "fail");
    }
    this.rTD.a(this, null);
    AppMethodBeat.o(327340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.b
 * JD-Core Version:    0.7.0.1
 */