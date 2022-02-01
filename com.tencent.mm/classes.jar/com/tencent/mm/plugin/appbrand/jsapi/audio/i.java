package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 290;
  public static final String NAME = "destroyAudioInstance";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145708);
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
    AppMethodBeat.o(145708);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    AppMethodBeat.i(327782);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(327782);
      return;
    }
    Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", new Object[] { paramJSONObject.toString() });
    paramJSONObject = paramJSONObject.optString("audioId");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
      paramf.callback(paramInt, ZP("fail:audioId is empty"));
      AppMethodBeat.o(327782);
      return;
    }
    paramo = new a(this, paramf, paramInt);
    paramo.appId = paramf.getAppId();
    paramo.hqQ = paramJSONObject;
    paramo.bQt();
    c.rDb.ZX(paramf.getAppId()).remove(paramJSONObject);
    AppMethodBeat.o(327782);
  }
  
  public final boolean cpN()
  {
    return true;
  }
  
  static final class a
    extends a
  {
    public String appId = "";
    public boolean error = false;
    public String hqQ = "";
    public int ror;
    private p rzh;
    public f rzi;
    
    public a(p paramp, f paramf, int paramInt)
    {
      this.rzh = paramp;
      this.rzi = paramf;
      this.ror = paramInt;
    }
    
    public final void aFi()
    {
      AppMethodBeat.i(145706);
      Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
      this.error = com.tencent.mm.al.c.Lp(this.hqQ);
      callback();
      AppMethodBeat.o(145706);
    }
    
    public final void callback()
    {
      AppMethodBeat.i(145707);
      super.callback();
      Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
      if (this.rzi == null)
      {
        Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
        AppMethodBeat.o(145707);
        return;
      }
      if (this.error)
      {
        this.rzi.callback(this.ror, this.rzh.ZP("fail"));
        AppMethodBeat.o(145707);
        return;
      }
      this.rzi.callback(this.ror, this.rzh.ZP("ok"));
      AppMethodBeat.o(145707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i
 * JD-Core Version:    0.7.0.1
 */