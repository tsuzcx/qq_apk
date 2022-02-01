package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 290;
  public static final String NAME = "destroyAudioInstance";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145708);
    a(parame, paramJSONObject, paramInt, parame.getJsRuntime());
    AppMethodBeat.o(145708);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt, com.tencent.mm.plugin.appbrand.m.o paramo)
  {
    AppMethodBeat.i(225911);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
      parame.j(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(225911);
      return;
    }
    Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", new Object[] { paramJSONObject.toString() });
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
      parame.j(paramInt, h("fail:audioId is empty", null));
      AppMethodBeat.o(225911);
      return;
    }
    paramo = new a(this, parame, paramInt);
    paramo.appId = parame.getAppId();
    paramo.fmF = paramJSONObject;
    paramo.bsM();
    c.ozj.agZ(parame.getAppId()).remove(paramJSONObject);
    AppMethodBeat.o(225911);
  }
  
  public final boolean bPG()
  {
    return true;
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public boolean error = false;
    public String fmF = "";
    public int okO;
    private com.tencent.mm.plugin.appbrand.jsapi.o ovN;
    public e ovO;
    
    public a(com.tencent.mm.plugin.appbrand.jsapi.o paramo, e parame, int paramInt)
    {
      this.ovN = paramo;
      this.ovO = parame;
      this.okO = paramInt;
    }
    
    public final void adj()
    {
      AppMethodBeat.i(145706);
      Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
      this.error = com.tencent.mm.al.c.Tn(this.fmF);
      callback();
      AppMethodBeat.o(145706);
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145707);
      super.callback();
      Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
      if (this.ovO == null)
      {
        Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
        AppMethodBeat.o(145707);
        return;
      }
      if (this.error)
      {
        this.ovO.j(this.okO, this.ovN.h("fail", null));
        AppMethodBeat.o(145707);
        return;
      }
      this.ovO.j(this.okO, this.ovN.h("ok", null));
      AppMethodBeat.o(145707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g
 * JD-Core Version:    0.7.0.1
 */