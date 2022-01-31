package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class JsApiStopRecordVoice
  extends a<r>
{
  public static final int CTRL_INDEX = 32;
  public static final String NAME = "stopRecord";
  
  static void m(r paramr)
  {
    AppMethodBeat.i(130814);
    if (bo.isNullOrNil(JsApiStartRecordVoice.hCM))
    {
      AppMethodBeat.o(130814);
      return;
    }
    paramr = n.yc(paramr.getAppId()).gQY;
    if (paramr != null) {
      paramr.dismiss();
    }
    AppBrandMainProcessService.a(new StopRecordVoice((byte)0));
    JsApiStartRecordVoice.hCM = null;
    AppMethodBeat.o(130814);
  }
  
  static class StopRecordVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StopRecordVoice> CREATOR;
    
    static
    {
      AppMethodBeat.i(130813);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(130813);
    }
    
    public final void ata()
    {
      AppMethodBeat.i(130812);
      m.aNS().ac(new JsApiStopRecordVoice.StopRecordVoice.1(this));
      AppMethodBeat.o(130812);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice
 * JD-Core Version:    0.7.0.1
 */