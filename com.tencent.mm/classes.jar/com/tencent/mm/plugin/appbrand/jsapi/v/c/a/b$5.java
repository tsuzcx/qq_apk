package com.tencent.mm.plugin.appbrand.jsapi.v.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.g.o.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$5
  implements b.s
{
  AtomicBoolean hOa;
  float hOb;
  o.f hOc;
  JSONObject jsonObject;
  
  public b$5(b paramb, int paramInt, c paramc)
  {
    AppMethodBeat.i(155146);
    this.hOa = new AtomicBoolean(false);
    this.jsonObject = new JSONObject();
    this.hOc = new o.f();
    AppMethodBeat.o(155146);
  }
  
  public final void a(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(155147);
    if (this.hOa.compareAndSet(false, true)) {}
    for (;;)
    {
      try
      {
        this.jsonObject.remove("mapId");
        this.jsonObject.put("mapId", this.hNS);
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
        ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { localJSONException });
        continue;
      }
      this.hOc.BN(this.jsonObject.toString());
      this.hza.b(this.hOc);
      this.hOb = parama.zoom;
      ab.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange begin");
      AppMethodBeat.o(155147);
      return;
      this.jsonObject.put("causedBy", "update");
    }
  }
  
  public final void b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(155148);
    if (this.hOa.compareAndSet(true, false)) {}
    for (;;)
    {
      try
      {
        this.jsonObject.remove("mapId");
        this.jsonObject.put("mapId", this.hNS);
        this.jsonObject.remove("type");
        this.jsonObject.put("type", "end");
        this.jsonObject.remove("causedBy");
        if (parama.zoom == this.hOb) {
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
        ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { parama });
        continue;
        this.jsonObject.put("causedBy", "update");
        continue;
      }
      this.jsonObject.remove("rotate");
      this.jsonObject.put("rotate", parama.rotate);
      this.jsonObject.remove("skew");
      this.jsonObject.put("skew", parama.skew);
      this.hOc.BN(this.jsonObject.toString());
      this.hza.b(this.hOc);
      ab.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange finish, result:%s", new Object[] { this.jsonObject.toString() });
      AppMethodBeat.o(155148);
      return;
      i = 0;
      continue;
      this.jsonObject.put("causedBy", "drag");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b.5
 * JD-Core Version:    0.7.0.1
 */