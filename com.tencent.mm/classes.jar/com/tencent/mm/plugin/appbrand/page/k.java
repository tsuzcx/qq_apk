package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.HashMap;

public class k
  extends p
{
  private static final int CTRL_INDEX = 49;
  private static final String NAME = "onAppEnterBackground";
  
  public final void ak(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134999);
    HashMap localHashMap = new HashMap(1);
    g.d locald = g.Dd(paramAppBrandRuntime.mAppId);
    String str = "hide";
    switch (k.1.iRF[locald.ordinal()])
    {
    }
    for (;;)
    {
      localHashMap.put("mode", str);
      B(localHashMap).g(paramAppBrandRuntime.Du()).aXQ();
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.k
 * JD-Core Version:    0.7.0.1
 */