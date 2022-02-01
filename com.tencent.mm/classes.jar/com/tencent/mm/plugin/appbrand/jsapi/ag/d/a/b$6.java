package com.tencent.mm.plugin.appbrand.jsapi.ag.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.w;
import com.tencent.mm.plugin.appbrand.jsapi.k.t.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$6
  implements b.w
{
  JSONObject jsonObject;
  AtomicBoolean lYo;
  float lYp;
  t.h lYq;
  
  public b$6(b paramb, int paramInt, f paramf, com.tencent.mm.plugin.appbrand.jsapi.k.a.b paramb1)
  {
    AppMethodBeat.i(215882);
    this.lYo = new AtomicBoolean(false);
    this.jsonObject = new JSONObject();
    this.lYq = new t.h();
    AppMethodBeat.o(215882);
  }
  
  public final void a(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(139549);
    if (this.lYo.compareAndSet(false, true)) {}
    for (;;)
    {
      try
      {
        this.jsonObject.remove("mapId");
        this.jsonObject.put("mapId", this.lYe);
        this.jsonObject.remove("type");
        this.jsonObject.put("type", "begin");
        if (!paramBoolean) {
          continue;
        }
        this.jsonObject.put("causedBy", "gesture");
        this.jsonObject.remove("rotate");
        this.jsonObject.remove("skew");
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { localJSONException });
        continue;
      }
      this.lYq.Zh(this.jsonObject.toString());
      this.lBw.a(this.lYq, null);
      this.lYp = parama.zoom;
      Log.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange begin");
      AppMethodBeat.o(139549);
      return;
      this.jsonObject.put("causedBy", "update");
    }
  }
  
  public final void b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(139550);
    if (this.lYo.compareAndSet(true, false)) {}
    for (;;)
    {
      try
      {
        this.jsonObject.remove("mapId");
        this.jsonObject.put("mapId", this.lYe);
        this.jsonObject.remove("type");
        this.jsonObject.put("type", "end");
        this.jsonObject.remove("causedBy");
        if (parama.zoom == this.lYp) {
          continue;
        }
        i = 1;
        if (!paramBoolean) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        this.jsonObject.put("causedBy", "scale");
      }
      catch (JSONException parama)
      {
        int i;
        Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { parama });
        continue;
        this.jsonObject.put("causedBy", "update");
        continue;
      }
      this.jsonObject.remove("rotate");
      this.jsonObject.put("rotate", parama.mat);
      this.jsonObject.remove("skew");
      this.jsonObject.put("skew", parama.skew);
      this.jsonObject.remove("scale");
      this.jsonObject.put("scale", this.lYl.getZoom());
      a.a(this.lYl, this.jsonObject);
      a.b(this.lYl, this.jsonObject);
      this.lYq.Zh(this.jsonObject.toString());
      this.lBw.a(this.lYq, null);
      Log.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange finish, result:%s", new Object[] { this.jsonObject.toString() });
      AppMethodBeat.o(139550);
      return;
      i = 0;
      continue;
      this.jsonObject.put("causedBy", "drag");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.6
 * JD-Core Version:    0.7.0.1
 */