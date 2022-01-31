package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState
  extends a<c>
{
  public static final int CTRL_INDEX = 46;
  public static final String NAME = "getMusicPlayerState";
  private JsApiGetMusicPlayerState.GetMusicPlayerState hBN;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137744);
    this.hBN = new JsApiGetMusicPlayerState.GetMusicPlayerState(this, paramc, paramInt);
    this.hBN.mAppid = paramc.getAppId();
    AppBrandMainProcessService.a(this.hBN);
    AppMethodBeat.o(137744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState
 * JD-Core Version:    0.7.0.1
 */