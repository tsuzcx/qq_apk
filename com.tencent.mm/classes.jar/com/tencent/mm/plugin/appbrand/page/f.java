package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.j.g;
import com.tencent.luggage.j.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class f
  extends l
{
  private static final int CTRL_INDEX = 50;
  private static final String NAME = "onAppEnterForeground";
  
  public final void a(i parami, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = parami.ZA().fPr.aei();
    if (localObject != null) {
      localHashMap.put("referrerInfo", localObject);
    }
    localHashMap.put("relaunch", Boolean.valueOf(paramBoolean));
    localHashMap.put("reLaunch", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      localObject = parami.ZF();
      localHashMap.put("rawPath", localObject);
      localHashMap.put("path", g.bi((String)localObject));
      localHashMap.put("query", g.bj((String)localObject));
    }
    for (;;)
    {
      y.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[] { localHashMap.get("path"), localHashMap.get("query"), localHashMap.get("relaunch"), localObject });
      h.c(localHashMap);
      o(localHashMap).d(parami.Zy()).dispatch();
      return;
      localObject = parami.Zz().getCurrentUrl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f
 * JD-Core Version:    0.7.0.1
 */