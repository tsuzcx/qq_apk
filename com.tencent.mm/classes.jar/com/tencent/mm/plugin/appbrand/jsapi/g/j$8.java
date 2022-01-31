package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.q;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class j$8
  implements b.q
{
  JSONObject gmI = new JSONObject();
  AtomicBoolean gtr = new AtomicBoolean(false);
  float gts;
  j.e gtt = new j.e();
  
  j$8(j paramj, int paramInt, e parame) {}
  
  public final void a(b.a parama)
  {
    if (this.gtr.compareAndSet(false, true)) {}
    try
    {
      this.gmI.remove("mapId");
      this.gmI.put("mapId", this.gkY);
      this.gmI.remove("type");
      this.gmI.put("type", "begin");
      this.gmI.remove("causedBy");
      this.gtt.tM(this.gmI.toString());
      this.gtq.b(this.gtt);
      this.gts = parama.zoom;
      y.v("MicroMsg.JsApiInsertMap", "onCameraChange begin");
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
  
  public final void a(b.a parama, boolean paramBoolean)
  {
    if (this.gtr.compareAndSet(true, false)) {}
    for (;;)
    {
      try
      {
        this.gmI.remove("mapId");
        this.gmI.put("mapId", this.gkY);
        this.gmI.remove("type");
        this.gmI.put("type", "end");
        this.gmI.remove("causedBy");
        if (parama.zoom == this.gts) {
          continue;
        }
        i = 1;
        if (!paramBoolean) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        this.gmI.put("causedBy", "scale");
      }
      catch (JSONException parama)
      {
        int i;
        y.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { parama });
        continue;
        this.gmI.put("causedBy", "update");
        continue;
      }
      this.gtt.tM(this.gmI.toString());
      this.gtq.b(this.gtt);
      y.v("MicroMsg.JsApiInsertMap", "onCameraChange finish, result:%s", new Object[] { this.gmI.toString() });
      return;
      i = 0;
      continue;
      this.gmI.put("causedBy", "drag");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.j.8
 * JD-Core Version:    0.7.0.1
 */