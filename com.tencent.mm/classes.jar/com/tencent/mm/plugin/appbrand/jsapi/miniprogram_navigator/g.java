package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import org.json.JSONObject;

public class g
  extends c<k>
{
  public static final int CTRL_INDEX = 252;
  public static final String NAME = "navigateBackMiniProgram";
  
  public void a(final k paramk, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(147181);
    paramk.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147180);
        paramk.getRuntime().b(MiniProgramNavigationBackResult.a(this.sie, this.sif), null);
        paramk.callback(paramInt, g.this.ZP("ok"));
        AppMethodBeat.o(147180);
      }
    });
    AppMethodBeat.o(147181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g
 * JD-Core Version:    0.7.0.1
 */