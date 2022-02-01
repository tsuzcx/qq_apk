package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.b;
import com.tencent.mm.plugin.appbrand.page.b.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONObject;

public abstract class g
  extends a<c>
{
  private static c.a jBS;
  private aa cdz = null;
  
  abstract void a(c paramc, JSONObject paramJSONObject, int paramInt);
  
  public final void fP(final boolean paramBoolean)
  {
    try
    {
      if (!aq.isMainThread())
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46692);
            g.this.fP(paramBoolean);
            AppMethodBeat.o(46692);
          }
        });
        return;
      }
      if ((this.cdz != null) && (this.cdz.getRuntime() != null))
      {
        if (jBS != null)
        {
          jBS.dismiss();
          jBS = null;
        }
        if (paramBoolean)
        {
          jBS = b.ai(this.cdz.getRuntime()).a(b.a.kXD);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "setSubTitle error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.g
 * JD-Core Version:    0.7.0.1
 */