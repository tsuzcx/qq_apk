package com.tencent.mm.plugin.appbrand.jsapi.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 469;
  public static final String NAME = "getAvailableAudioSources";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137903);
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "")
    {
      Log.i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources data:%s", new Object[] { paramJSONObject });
      localObject = new ArrayList();
      ((List)localObject).add(c.a.mFH.mFO);
      ((List)localObject).add(c.a.mFI.mFO);
      ((List)localObject).add(c.a.mFJ.mFO);
      ((List)localObject).add(c.a.mFK.mFO);
      ((List)localObject).add(c.a.mFL.mFO);
      if (com.tencent.mm.compatible.util.d.oD(24)) {
        ((List)localObject).add(c.a.mFM.mFO);
      }
      paramJSONObject = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramJSONObject.put((String)((Iterator)localObject).next());
      }
    }
    Object localObject = new HashMap(1);
    ((HashMap)localObject).put("audioSources", paramJSONObject);
    Log.i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources ret:%s", new Object[] { ((HashMap)localObject).toString() });
    paramf.i(paramInt, n("ok", (Map)localObject));
    AppMethodBeat.o(137903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a.d
 * JD-Core Version:    0.7.0.1
 */