package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import java.util.HashMap;

public class n
  extends s
{
  private static final int CTRL_INDEX = 49;
  public static final String NAME = "onAppEnterBackground";
  
  public final void ae(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134999);
    HashMap localHashMap = new HashMap(1);
    h.d locald = h.Uc(paramAppBrandRuntime.mAppId);
    String str = "hide";
    switch (1.kRE[locald.ordinal()])
    {
    }
    for (;;)
    {
      localHashMap.put("mode", str);
      K(localHashMap).g(paramAppBrandRuntime.NY()).bEo();
      AppMethodBeat.o(134999);
      return;
      str = "close";
      continue;
      str = "back";
      continue;
      str = "hide";
      continue;
      str = "hang";
      continue;
      str = "launchMiniProgram";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.n
 * JD-Core Version:    0.7.0.1
 */