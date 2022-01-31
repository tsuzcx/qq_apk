package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

final class j$1
  extends g.b
{
  j$1(j paramj, String paramString, o paramo, int paramInt) {}
  
  public final void a(g.c paramc)
  {
    y.i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", new Object[] { this.val$appId });
    paramc = new JSONObject();
    try
    {
      paramc.put("operationType", "pause");
      if (j.a(this.giV) == null) {
        j.a(this.giV, new j.b(this.giV, this.gcp, this.dIS));
      }
      j.a(this.giV).giZ = paramc.toString();
      j.a(this.giV).appId = this.val$appId;
      j.a(this.giV).action = -1;
      j.a(this.giV).ahU();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", localJSONException, "", new Object[0]);
      }
    }
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", new Object[] { this.val$appId });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("operationType", "stop");
      if (j.a(this.giV) == null) {
        j.a(this.giV, new j.b(this.giV, this.gcp, this.dIS));
      }
      j.a(this.giV).giZ = localJSONObject.toString();
      j.a(this.giV).appId = this.val$appId;
      j.a(this.giV).action = -1;
      j.a(this.giV).ahV();
      g.b(this.val$appId, this);
      j.ahZ().remove(this.val$appId);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", localJSONException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.j.1
 * JD-Core Version:    0.7.0.1
 */