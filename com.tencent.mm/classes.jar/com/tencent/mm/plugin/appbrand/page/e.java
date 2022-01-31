package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import java.util.HashMap;

public class e
  extends l
{
  private static final int CTRL_INDEX = 49;
  private static final String NAME = "onAppEnterBackground";
  
  public final void u(i parami)
  {
    HashMap localHashMap = new HashMap(1);
    g.c localc = g.qB(parami.mAppId);
    String str = "hide";
    switch (e.1.fGn[localc.ordinal()])
    {
    }
    for (;;)
    {
      localHashMap.put("mode", str);
      o(localHashMap).d(parami.Zy()).dispatch();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.e
 * JD-Core Version:    0.7.0.1
 */