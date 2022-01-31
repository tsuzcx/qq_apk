package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.luggage.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.b;
import com.tencent.mm.plugin.appbrand.page.b.a;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public abstract class g
  extends a<c>
{
  private static c.a hCo;
  private v bBK = null;
  
  abstract void a(c paramc, JSONObject paramJSONObject, int paramInt);
  
  public final void ec(boolean paramBoolean)
  {
    try
    {
      if (!al.isMainThread())
      {
        al.d(new g.1(this, paramBoolean));
        return;
      }
      if ((this.bBK != null) && (this.bBK.getRuntime() != null))
      {
        if (hCo != null)
        {
          hCo.dismiss();
          hCo = null;
        }
        if (paramBoolean)
        {
          hCo = b.E(this.bBK.getRuntime()).a(b.a.iuY);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      d.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "setSubTitle error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.g
 * JD-Core Version:    0.7.0.1
 */