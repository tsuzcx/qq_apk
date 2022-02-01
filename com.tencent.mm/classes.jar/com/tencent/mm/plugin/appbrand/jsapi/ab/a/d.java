package com.tencent.mm.plugin.appbrand.jsapi.ab.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 469;
  public static final String NAME = "getAvailableAudioSources";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137903);
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "")
    {
      ae.i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources data:%s", new Object[] { paramJSONObject });
      localObject = new ArrayList();
      ((List)localObject).add(c.a.lyF.lyM);
      ((List)localObject).add(c.a.lyG.lyM);
      ((List)localObject).add(c.a.lyH.lyM);
      ((List)localObject).add(c.a.lyI.lyM);
      ((List)localObject).add(c.a.lyJ.lyM);
      if (com.tencent.mm.compatible.util.d.lA(24)) {
        ((List)localObject).add(c.a.lyK.lyM);
      }
      paramJSONObject = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramJSONObject.put((String)((Iterator)localObject).next());
      }
    }
    Object localObject = new HashMap(1);
    ((HashMap)localObject).put("audioSources", paramJSONObject);
    ae.i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources ret:%s", new Object[] { ((HashMap)localObject).toString() });
    paramc.h(paramInt, n("ok", (Map)localObject));
    AppMethodBeat.o(137903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a.d
 * JD-Core Version:    0.7.0.1
 */