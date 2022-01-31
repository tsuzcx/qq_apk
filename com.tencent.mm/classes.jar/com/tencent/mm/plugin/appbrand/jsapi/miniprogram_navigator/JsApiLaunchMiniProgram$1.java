package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Intent;
import com.tencent.luggage.g.e.a;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bo;

final class JsApiLaunchMiniProgram$1
  implements e.a
{
  JsApiLaunchMiniProgram$1(JsApiLaunchMiniProgram paramJsApiLaunchMiniProgram, c paramc, int paramInt) {}
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(154328);
    switch (paramInt)
    {
    default: 
      if (paramIntent != null) {
        break;
      }
    }
    for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("KEY_PRECONDITION_ERR_REASON"))
    {
      this.hSU.h(this.bAX, this.hSV.j("fail " + bo.nullAsNil(paramIntent), null));
      AppMethodBeat.o(154328);
      return;
      this.hSU.h(this.bAX, this.hSV.j("ok", null));
      AppMethodBeat.o(154328);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram.1
 * JD-Core Version:    0.7.0.1
 */