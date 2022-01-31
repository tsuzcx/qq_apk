package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class j$2
  implements am.a
{
  j$2(j paramj) {}
  
  public final boolean tC()
  {
    int i;
    j localj;
    if (this.gER.gEM != null)
    {
      i = this.gER.gEM.getCacheTimeSec();
      int j = this.gER.gEM.getDuration();
      if (j != 0)
      {
        i = (int)(i * 100.0F / j);
        if (i != this.gER.gEQ)
        {
          this.gER.gEQ = i;
          localj = this.gER;
        }
      }
    }
    try
    {
      y.i("MicroMsg.JsApiVideoCallback", "onVideoCacheUpdate, percent:%d", new Object[] { Integer.valueOf(i) });
      JSONObject localJSONObject = localj.akU();
      localJSONObject.put("buffered", i);
      localj.a(new j.h((byte)0), localJSONObject);
      return true;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.JsApiVideoCallback", "onVideoCacheUpdate e=%s", new Object[] { localJSONException });
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.j.2
 * JD-Core Version:    0.7.0.1
 */