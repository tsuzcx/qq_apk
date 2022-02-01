package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;

final class JsApiNavigateToDevMiniProgram$1
  implements c.c
{
  JsApiNavigateToDevMiniProgram$1(JsApiNavigateToDevMiniProgram paramJsApiNavigateToDevMiniProgram, d paramd, int paramInt) {}
  
  public final void o(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(46622);
    if (paramBoolean)
    {
      paramString = "ok";
      this.kww.h(this.cjS, this.kZI.e(paramString, null));
      AppMethodBeat.o(46622);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram.1
 * JD-Core Version:    0.7.0.1
 */