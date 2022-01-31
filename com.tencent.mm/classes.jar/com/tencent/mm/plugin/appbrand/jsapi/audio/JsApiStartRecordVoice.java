package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.a.a;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class JsApiStartRecordVoice
  extends com.tencent.mm.plugin.appbrand.jsapi.a<o>
{
  public static final int CTRL_INDEX = 31;
  public static final String NAME = "startRecord";
  static volatile String gjt = null;
  private q giT;
  private int giU;
  private JsApiStartRecordVoice.StartRecordVoice gju;
  
  private void cY(boolean paramBoolean)
  {
    if (this.giT == null) {
      return;
    }
    if (!ai.isMainThread())
    {
      ai.d(new JsApiStartRecordVoice.3(this, paramBoolean));
      return;
    }
    if (paramBoolean)
    {
      this.giU = com.tencent.mm.plugin.appbrand.page.a.t(this.giT.getRuntime()).a(a.a.gSe);
      m.qI(this.giT.mAppId).fzw = this.giU;
      return;
    }
    com.tencent.mm.plugin.appbrand.page.a.t(this.giT.getRuntime()).lX(this.giU);
  }
  
  public final void a(final o paramo, JSONObject paramJSONObject, int paramInt)
  {
    e.a(paramo.mAppId, new JsApiStartRecordVoice.4(this, paramo, paramJSONObject, paramInt));
    int k;
    if ((paramo.getContext() instanceof Activity))
    {
      localObject = (Activity)paramo.getContext();
      if (localObject != null) {
        break label81;
      }
      paramo.C(paramInt, h("fail", null));
      k = 0;
    }
    for (;;)
    {
      if (k != 0) {
        break label119;
      }
      paramo.C(paramInt, h("fail", null));
      return;
      localObject = null;
      break;
      label81:
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      k = bool;
      if (bool)
      {
        e.vX(paramo.mAppId);
        k = bool;
      }
    }
    label119:
    Object localObject = paramo.getRuntime().Zz();
    if ((((n)localObject).getCurrentPage() == null) || (((n)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramo.C(paramInt, h("fail", null));
      return;
    }
    this.giT = ((n)localObject).getCurrentPage().getCurrentPageView();
    int j = paramJSONObject.optInt("duration", 60);
    int i = j;
    if (j <= 0)
    {
      y.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
      i = 60;
    }
    j = i;
    if (i > 600)
    {
      y.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", new Object[] { Integer.valueOf(600) });
      j = 600;
    }
    this.giT.a(new JsApiStartRecordVoice.1(this, paramo));
    this.giT.a(new e.c()
    {
      public final void onDestroy()
      {
        JsApiStopRecordVoice.e(paramo);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
      }
    });
    this.gju = new JsApiStartRecordVoice.StartRecordVoice(this, paramo, j, paramInt);
    gjt = JsApiStartRecordVoice.StartRecordVoice.a(this.gju);
    AppBrandMainProcessService.a(this.gju);
    cY(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice
 * JD-Core Version:    0.7.0.1
 */