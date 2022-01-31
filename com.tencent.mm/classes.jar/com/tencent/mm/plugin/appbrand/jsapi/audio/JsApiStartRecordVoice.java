package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.record.a.a;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.b.a;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class JsApiStartRecordVoice
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.r>
{
  public static final int CTRL_INDEX = 31;
  public static final String NAME = "startRecord";
  static volatile String hCM = null;
  private JsApiStartRecordVoice.StartRecordVoice hCN;
  private v hCn;
  private c.a hCo;
  
  private void ec(boolean paramBoolean)
  {
    AppMethodBeat.i(130801);
    if (this.hCn == null)
    {
      AppMethodBeat.o(130801);
      return;
    }
    if (!al.isMainThread())
    {
      al.d(new JsApiStartRecordVoice.3(this, paramBoolean));
      AppMethodBeat.o(130801);
      return;
    }
    if (paramBoolean)
    {
      this.hCo = com.tencent.mm.plugin.appbrand.page.b.E(this.hCn.getRuntime()).a(b.a.iuY);
      com.tencent.mm.plugin.appbrand.n.yd(this.hCn.getAppId()).gQY = this.hCo;
      AppMethodBeat.o(130801);
      return;
    }
    if (this.hCo != null)
    {
      this.hCo.dismiss();
      this.hCo = null;
    }
    AppMethodBeat.o(130801);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.r paramr, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(130800);
    com.tencent.mm.plugin.appbrand.permission.n.a(paramr.getAppId(), new JsApiStartRecordVoice.4(this, paramr, paramJSONObject, paramInt));
    int k;
    if ((paramr.getContext() instanceof Activity))
    {
      localObject = (Activity)paramr.getContext();
      if (localObject != null) {
        break label91;
      }
      paramr.h(paramInt, j("fail", null));
      k = 0;
    }
    for (;;)
    {
      if (k != 0) {
        break label129;
      }
      paramr.h(paramInt, j("fail", null));
      AppMethodBeat.o(130800);
      return;
      localObject = null;
      break;
      label91:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      k = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.n.EA(paramr.getAppId());
        k = bool;
      }
    }
    label129:
    Object localObject = paramr.getRuntime().atj();
    if ((((com.tencent.mm.plugin.appbrand.page.r)localObject).getCurrentPage() == null) || (((com.tencent.mm.plugin.appbrand.page.r)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramr.h(paramInt, j("fail", null));
      AppMethodBeat.o(130800);
      return;
    }
    if (hCM != null)
    {
      paramr.h(paramInt, j("fail:audio is recording, don't start record again", null));
      AppMethodBeat.o(130800);
      return;
    }
    this.hCn = ((com.tencent.mm.plugin.appbrand.page.r)localObject).getCurrentPage().getCurrentPageView();
    int j = paramJSONObject.optInt("duration", 60);
    int i = j;
    if (j <= 0)
    {
      ab.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
      i = 60;
    }
    j = i;
    if (i > 600)
    {
      ab.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", new Object[] { Integer.valueOf(600) });
      j = 600;
    }
    this.hCn.a(new JsApiStartRecordVoice.1(this, paramr));
    this.hCn.a(new f.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(130785);
        JsApiStopRecordVoice.m(paramr);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(130785);
      }
    });
    this.hCN = new JsApiStartRecordVoice.StartRecordVoice(this, paramr, j, paramInt);
    hCM = JsApiStartRecordVoice.StartRecordVoice.a(this.hCN);
    AppBrandMainProcessService.a(this.hCN);
    ec(true);
    AppMethodBeat.o(130800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice
 * JD-Core Version:    0.7.0.1
 */