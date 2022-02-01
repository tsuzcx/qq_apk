package com.tencent.mm.plugin.appbrand.jsapi.aa.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.g.q.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$6
  implements b.u
{
  AtomicBoolean jTr;
  float jTs;
  q.h jTt;
  JSONObject jsonObject;
  
  public b$6(b paramb, int paramInt, c paramc, com.tencent.mm.plugin.appbrand.jsapi.g.a.b paramb1)
  {
    AppMethodBeat.i(195104);
    this.jTr = new AtomicBoolean(false);
    this.jsonObject = new JSONObject();
    this.jTt = new q.h();
    AppMethodBeat.o(195104);
  }
  
  public final void a(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(139549);
    if (this.jTr.compareAndSet(false, true)) {}
    for (;;)
    {
      try
      {
        this.jsonObject.remove("mapId");
        this.jsonObject.put("mapId", this.jTj);
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
        ad.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { localJSONException });
        continue;
      }
      this.jTt.HK(this.jsonObject.toString());
      this.jza.b(this.jTt);
      this.jTs = parama.zoom;
      ad.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange begin");
      AppMethodBeat.o(139549);
      return;
      this.jsonObject.put("causedBy", "update");
    }
  }
  
  public final void b(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(139550);
    if (this.jTr.compareAndSet(true, false)) {}
    for (;;)
    {
      try
      {
        this.jsonObject.remove("mapId");
        this.jsonObject.put("mapId", this.jTj);
        this.jsonObject.remove("type");
        this.jsonObject.put("type", "end");
        this.jsonObject.remove("causedBy");
        if (parama.zoom == this.jTs) {
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
        ad.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { parama });
        continue;
        this.jsonObject.put("causedBy", "update");
        continue;
      }
      this.jsonObject.remove("rotate");
      this.jsonObject.put("rotate", parama.jUQ);
      this.jsonObject.remove("skew");
      this.jsonObject.put("skew", parama.skew);
      this.jsonObject.remove("scale");
      this.jsonObject.put("scale", this.jTo.getZoom());
      a.a(this.jTo, this.jsonObject);
      a.b(this.jTo, this.jsonObject);
      this.jTt.HK(this.jsonObject.toString());
      this.jza.b(this.jTt);
      ad.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange finish, result:%s", new Object[] { this.jsonObject.toString() });
      AppMethodBeat.o(139550);
      return;
      i = 0;
      continue;
      this.jsonObject.put("causedBy", "drag");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d.a.b.6
 * JD-Core Version:    0.7.0.1
 */