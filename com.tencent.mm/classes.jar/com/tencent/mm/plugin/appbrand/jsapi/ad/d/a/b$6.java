package com.tencent.mm.plugin.appbrand.jsapi.ad.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.w;
import com.tencent.mm.plugin.appbrand.jsapi.i.t.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$6
  implements b.w
{
  JSONObject jsonObject;
  AtomicBoolean kTj;
  float kTk;
  t.h kTl;
  
  public b$6(b paramb, int paramInt, c paramc, com.tencent.mm.plugin.appbrand.jsapi.i.a.b paramb1)
  {
    AppMethodBeat.i(220633);
    this.kTj = new AtomicBoolean(false);
    this.jsonObject = new JSONObject();
    this.kTl = new t.h();
    AppMethodBeat.o(220633);
  }
  
  public final void a(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(139549);
    if (this.kTj.compareAndSet(false, true)) {}
    for (;;)
    {
      try
      {
        this.jsonObject.remove("mapId");
        this.jsonObject.put("mapId", this.kSZ);
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
        ae.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { localJSONException });
        continue;
      }
      this.kTl.PQ(this.jsonObject.toString());
      this.kxj.b(this.kTl);
      this.kTk = parama.zoom;
      ae.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange begin");
      AppMethodBeat.o(139549);
      return;
      this.jsonObject.put("causedBy", "update");
    }
  }
  
  public final void b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(139550);
    if (this.kTj.compareAndSet(true, false)) {}
    for (;;)
    {
      try
      {
        this.jsonObject.remove("mapId");
        this.jsonObject.put("mapId", this.kSZ);
        this.jsonObject.remove("type");
        this.jsonObject.put("type", "end");
        this.jsonObject.remove("causedBy");
        if (parama.zoom == this.kTk) {
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
        ae.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { parama });
        continue;
        this.jsonObject.put("causedBy", "update");
        continue;
      }
      this.jsonObject.remove("rotate");
      this.jsonObject.put("rotate", parama.kVl);
      this.jsonObject.remove("skew");
      this.jsonObject.put("skew", parama.skew);
      this.jsonObject.remove("scale");
      this.jsonObject.put("scale", this.kTg.getZoom());
      a.a(this.kTg, this.jsonObject);
      a.b(this.kTg, this.jsonObject);
      this.kTl.PQ(this.jsonObject.toString());
      this.kxj.b(this.kTl);
      ae.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange finish, result:%s", new Object[] { this.jsonObject.toString() });
      AppMethodBeat.o(139550);
      return;
      i = 0;
      continue;
      this.jsonObject.put("causedBy", "drag");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.d.a.b.6
 * JD-Core Version:    0.7.0.1
 */