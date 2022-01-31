package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class j
  extends p
{
  private static final int CTRL_INDEX = 50;
  private static final String NAME = "onAppEnterForeground";
  
  public final void b(com.tencent.mm.plugin.appbrand.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(87065);
    HashMap localHashMap = new HashMap();
    Object localObject = parami.wZ().hiz.ayx();
    if (localObject != null) {
      localHashMap.put("referrerInfo", localObject);
    }
    localHashMap.put("relaunch", Boolean.valueOf(paramBoolean));
    localHashMap.put("reLaunch", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      localObject = parami.ato();
      localHashMap.put("rawPath", localObject);
      localHashMap.put("path", h.cg((String)localObject));
      localHashMap.put("query", h.ch((String)localObject));
    }
    for (;;)
    {
      ab.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[] { localHashMap.get("path"), localHashMap.get("query"), localHashMap.get("relaunch"), localObject });
      com.tencent.luggage.g.i.d(localHashMap);
      w(localHashMap).i(parami.ws()).aBz();
      AppMethodBeat.o(87065);
      return;
      localObject = parami.atj().getCurrentUrl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j
 * JD-Core Version:    0.7.0.1
 */