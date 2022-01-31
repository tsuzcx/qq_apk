package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
  extends a<com.tencent.mm.plugin.appbrand.r>
{
  public static final int CTRL_INDEX = 295;
  public static final String NAME = "operateRecorder";
  private static Vector<String> hBD;
  private e.c bCv;
  private i.b hCm;
  private v hCn;
  private c.a hCo;
  
  static
  {
    AppMethodBeat.i(130755);
    hBD = new Vector();
    AppMethodBeat.o(130755);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.r paramr, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(130752);
    n.a(paramr.getAppId(), new i.3(this, paramr, paramJSONObject, paramInt));
    int i;
    if ((paramr.getContext() instanceof Activity))
    {
      localObject = (Activity)paramr.getContext();
      if (localObject != null) {
        break label105;
      }
      ab.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
      paramr.h(paramInt, j("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label143;
      }
      ab.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
      paramr.h(paramInt, j("fail:system permission denied", null));
      AppMethodBeat.o(130752);
      return;
      localObject = null;
      break;
      label105:
      boolean bool = b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      i = bool;
      if (bool)
      {
        n.EA(paramr.getAppId());
        i = bool;
      }
    }
    label143:
    Object localObject = paramr.getRuntime().atj();
    if ((((com.tencent.mm.plugin.appbrand.page.r)localObject).getCurrentPage() == null) || (((com.tencent.mm.plugin.appbrand.page.r)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramr.h(paramInt, j("fail", null));
      AppMethodBeat.o(130752);
      return;
    }
    this.hCn = ((com.tencent.mm.plugin.appbrand.page.r)localObject).getCurrentPage().getCurrentPageView();
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
      paramr.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(130752);
      return;
    }
    localObject = paramr.getAppId();
    ab.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", new Object[] { localObject, paramJSONObject.toString() });
    if (this.hCm == null) {
      this.hCm = new i.b(this, paramr, paramInt);
    }
    this.hCm.hry = paramInt;
    this.hCm.appId = ((String)localObject);
    this.hCm.hCt = paramJSONObject.toString();
    this.hCm.processName = ah.getProcessName();
    if (this.bCv == null) {
      this.bCv = new e.c()
      {
        public final void a(e.d paramAnonymousd)
        {
          AppMethodBeat.i(130741);
          ab.i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", new Object[] { this.val$appId });
          paramAnonymousd = new JSONObject();
          try
          {
            paramAnonymousd.put("operationType", "pause");
            if (i.a(i.this) == null) {
              i.a(i.this, new i.b(i.this, paramr, paramInt));
            }
            i.a(i.this).hCt = paramAnonymousd.toString();
            i.a(i.this).appId = this.val$appId;
            i.a(i.this).action = -1;
            i.a(i.this).aBL();
            AppMethodBeat.o(130741);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", localJSONException, "", new Object[0]);
            }
          }
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(130742);
          ab.i("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", new Object[] { this.val$appId });
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("operationType", "stop");
            if (i.a(i.this) == null) {
              i.a(i.this, new i.b(i.this, paramr, paramInt));
            }
            i.a(i.this).hCt = localJSONObject.toString();
            i.a(i.this).appId = this.val$appId;
            i.a(i.this).action = -1;
            i.a(i.this).aBM();
            e.b(this.val$appId, this);
            i.aBP().remove(this.val$appId);
            AppMethodBeat.o(130742);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", localJSONException, "", new Object[0]);
            }
          }
        }
      };
    }
    this.hCm.bCv = this.bCv;
    this.hCm.aBL();
    AppMethodBeat.o(130752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.i
 * JD-Core Version:    0.7.0.1
 */