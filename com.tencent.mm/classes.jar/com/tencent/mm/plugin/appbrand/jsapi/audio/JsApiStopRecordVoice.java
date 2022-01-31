package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.bk;

public final class JsApiStopRecordVoice
  extends com.tencent.mm.plugin.appbrand.jsapi.a<o>
{
  public static final int CTRL_INDEX = 32;
  public static final String NAME = "stopRecord";
  
  static void e(o paramo)
  {
    if (bk.bl(JsApiStartRecordVoice.gjt)) {
      return;
    }
    com.tencent.mm.plugin.appbrand.page.a.t(paramo.getRuntime()).lX(m.qH(paramo.mAppId).fzw);
    AppBrandMainProcessService.a(new JsApiStopRecordVoice.StopRecordVoice((byte)0));
    JsApiStartRecordVoice.gjt = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice
 * JD-Core Version:    0.7.0.1
 */