package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.o;

final class h$1
  implements c.c
{
  h$1(h paramh, g paramg, int paramInt) {}
  
  public final void s(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(147183);
    if (paramBoolean)
    {
      paramString = "ok";
      this.ovS.j(this.cuf, this.pcU.h(paramString, null));
      AppMethodBeat.o(147183);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("fail");
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = " ".concat(String.valueOf(paramString)))
    {
      paramString = paramString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h.1
 * JD-Core Version:    0.7.0.1
 */