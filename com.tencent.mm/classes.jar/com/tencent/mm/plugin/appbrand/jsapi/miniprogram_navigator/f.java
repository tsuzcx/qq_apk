package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import org.json.JSONObject;

public class f
  extends a<h>
{
  public static final int CTRL_INDEX = 252;
  public static final String NAME = "navigateBackMiniProgram";
  
  public void a(final h paramh, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(147181);
    paramh.M(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147180);
        paramh.getRuntime().R(MiniProgramNavigationBackResult.a(this.kVX, this.kVY));
        paramh.h(paramInt, f.this.e("ok", null));
        AppMethodBeat.o(147180);
      }
    });
    AppMethodBeat.o(147181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f
 * JD-Core Version:    0.7.0.1
 */