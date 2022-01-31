package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class d
  extends u
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstance";
  private static Vector<String> hBD;
  
  static
  {
    AppMethodBeat.i(137722);
    hBD = new Vector();
    AppMethodBeat.o(137722);
  }
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137721);
    paramc = paramc.getAppId();
    Object localObject = com.tencent.mm.plugin.music.b.e.bTX();
    paramJSONObject = new HashMap();
    paramJSONObject.put("audioId", localObject);
    ab.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[] { paramc, localObject });
    d.a locala = new d.a();
    locala.ceu = ((String)localObject);
    locala.bsY = 0;
    locala.appId = paramc;
    locala.aBL();
    localObject = new d.1(this, paramc);
    if (!hBD.contains(paramc))
    {
      com.tencent.mm.plugin.appbrand.e.a(paramc, (e.c)localObject);
      hBD.add(paramc);
    }
    paramc = j("ok", paramJSONObject);
    AppMethodBeat.o(137721);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.d
 * JD-Core Version:    0.7.0.1
 */