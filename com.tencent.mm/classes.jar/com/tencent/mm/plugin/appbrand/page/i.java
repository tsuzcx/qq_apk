package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.HashMap;

public class i
  extends p
{
  private static final int CTRL_INDEX = 49;
  private static final String NAME = "onAppEnterBackground";
  
  public final void F(com.tencent.mm.plugin.appbrand.i parami)
  {
    AppMethodBeat.i(87064);
    HashMap localHashMap = new HashMap(1);
    e.d locald = e.xX(parami.mAppId);
    String str = "hide";
    switch (i.1.gYU[locald.ordinal()])
    {
    }
    for (;;)
    {
      localHashMap.put("mode", str);
      w(localHashMap).i(parami.ws()).aBz();
      AppMethodBeat.o(87064);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.i
 * JD-Core Version:    0.7.0.1
 */