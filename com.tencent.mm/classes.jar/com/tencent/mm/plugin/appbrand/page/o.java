package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import java.util.HashMap;

public class o
  extends r
{
  private static final int CTRL_INDEX = 49;
  public static final String NAME = "onAppEnterBackground";
  
  public final void ae(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134999);
    HashMap localHashMap = new HashMap(1);
    k.d locald = k.abM(paramAppBrandRuntime.mAppId);
    String str = "hide";
    switch (1.nLM[locald.ordinal()])
    {
    }
    for (;;)
    {
      localHashMap.put("mode", str);
      D(localHashMap).i(paramAppBrandRuntime.QW()).bPO();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o
 * JD-Core Version:    0.7.0.1
 */