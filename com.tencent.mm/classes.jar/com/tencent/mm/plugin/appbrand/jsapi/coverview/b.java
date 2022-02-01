package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;

final class b
  extends bc
  implements c.b
{
  private static final int CTRL_INDEX = 678;
  public static final String NAME = "onImageViewLoad";
  private final ad.b lTf;
  private final h lTg;
  
  b(int paramInt, ad.b paramb, h paramh)
  {
    AppMethodBeat.i(193662);
    p("viewId", Integer.valueOf(paramInt));
    this.lTf = paramb;
    this.lTg = paramh;
    AppMethodBeat.o(193662);
  }
  
  public final void f(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(193663);
    if (paramOptions != null)
    {
      p("errMsg", "ok");
      p("size", new b.1(this, paramOptions));
    }
    while ((this.lTf != null) && ("webview".equals(this.lTf.getString("sendTo", null))))
    {
      this.lTg.a(this);
      AppMethodBeat.o(193663);
      return;
      p("errMsg", "fail");
    }
    this.lTg.a(this, null);
    AppMethodBeat.o(193663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.b
 * JD-Core Version:    0.7.0.1
 */