package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.ae.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import java.util.HashMap;

final class b
  extends az
  implements c.b
{
  private static final int CTRL_INDEX = 678;
  public static final String NAME = "onImageViewLoad";
  private final ad.b oPO;
  private final g oPP;
  
  b(int paramInt, ad.b paramb, g paramg)
  {
    AppMethodBeat.i(205910);
    o("viewId", Integer.valueOf(paramInt));
    this.oPO = paramb;
    this.oPP = paramg;
    AppMethodBeat.o(205910);
  }
  
  public final void c(final BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(205911);
    if (paramOptions != null)
    {
      o("errMsg", "ok");
      o("size", new HashMap() {});
    }
    while ((this.oPO != null) && ("webview".equals(this.oPO.getString("sendTo", null))))
    {
      this.oPP.a(this);
      AppMethodBeat.o(205911);
      return;
      o("errMsg", "fail");
    }
    this.oPP.a(this, null);
    AppMethodBeat.o(205911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.b
 * JD-Core Version:    0.7.0.1
 */