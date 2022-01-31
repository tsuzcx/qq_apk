package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class d
  extends s
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstance";
  private static Vector<String> gim = new Vector();
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    paramc = paramc.getAppId();
    Object localObject = com.tencent.mm.plugin.music.b.d.blW();
    paramJSONObject = new HashMap();
    paramJSONObject.put("audioId", localObject);
    y.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[] { paramc, localObject });
    d.a locala = new d.a();
    locala.bFM = ((String)localObject);
    locala.bcw = 0;
    locala.appId = paramc;
    locala.ahU();
    localObject = new d.1(this, paramc);
    if (!gim.contains(paramc))
    {
      g.a(paramc, (g.b)localObject);
      gim.add(paramc);
    }
    return h("ok", paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.d
 * JD-Core Version:    0.7.0.1
 */