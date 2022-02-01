package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 1039;
  public static final String NAME = "getGameLivePermission";
  
  private void a(com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt1, d.a parama, int paramInt2)
  {
    AppMethodBeat.i(282505);
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", Integer.valueOf(paramInt1));
    localHashMap.put("errCode", Integer.valueOf(parama.oTG));
    paramc.j(paramInt2, m("ok", localHashMap));
    AppMethodBeat.o(282505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.d
 * JD-Core Version:    0.7.0.1
 */