package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.bt;

public final class JsApiStopRecordVoice
  extends a<q>
{
  public static final int CTRL_INDEX = 32;
  public static final String NAME = "stopRecord";
  
  static void m(q paramq)
  {
    AppMethodBeat.i(46003);
    if (bt.isNullOrNil(JsApiStartRecordVoice.kxm))
    {
      AppMethodBeat.o(46003);
      return;
    }
    paramq = n.KE(paramq.getAppId()).jyW;
    if (paramq != null) {
      paramq.dismiss();
    }
    AppBrandMainProcessService.a(new JsApiStopRecordVoice.StopRecordVoice((byte)0));
    JsApiStartRecordVoice.kxm = null;
    AppMethodBeat.o(46003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice
 * JD-Core Version:    0.7.0.1
 */