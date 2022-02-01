package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;

final class h$1
  implements c.c
{
  h$1(h paramh, d paramd, int paramInt) {}
  
  public final void o(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(147183);
    if (paramBoolean)
    {
      paramString = "ok";
      this.lAB.i(this.cvP, this.meY.h(paramString, null));
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