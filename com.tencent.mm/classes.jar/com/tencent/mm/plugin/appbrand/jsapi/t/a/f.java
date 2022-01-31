package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 469;
  public static final String NAME = "getAvailableAudioSources";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145949);
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "")
    {
      ab.i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources data:%s", new Object[] { paramJSONObject });
      localObject = new ArrayList();
      ((List)localObject).add(e.a.ify.ifF);
      ((List)localObject).add(e.a.ifz.ifF);
      ((List)localObject).add(e.a.ifA.ifF);
      ((List)localObject).add(e.a.ifB.ifF);
      ((List)localObject).add(e.a.ifC.ifF);
      if (d.fv(24)) {
        ((List)localObject).add(e.a.ifD.ifF);
      }
      paramJSONObject = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramJSONObject.put((String)((Iterator)localObject).next());
      }
    }
    Object localObject = new HashMap(1);
    ((HashMap)localObject).put("audioSources", paramJSONObject);
    ab.i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources ret:%s", new Object[] { ((HashMap)localObject).toString() });
    paramc.h(paramInt, j("ok", (Map)localObject));
    AppMethodBeat.o(145949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.f
 * JD-Core Version:    0.7.0.1
 */