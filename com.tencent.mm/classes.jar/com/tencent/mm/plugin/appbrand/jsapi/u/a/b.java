package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements g
{
  com.tencent.mm.plugin.appbrand.jsapi.c fLx;
  private am gEO;
  com.tencent.mm.plugin.appbrand.jsapi.u.a.b.c gHr;
  int gHx;
  private String gHy;
  
  public b(com.tencent.mm.plugin.appbrand.jsapi.u.a.b.c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1)
  {
    this.fLx = paramc1;
    this.gHr = paramc;
  }
  
  private void akV()
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
    if (this.gEO != null) {
      this.gEO.stopTimer();
    }
  }
  
  public final void G(String paramString, int paramInt1, int paramInt2)
  {
    akV();
    try
    {
      JSONObject localJSONObject = akU();
      localJSONObject.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      a(new b.b((byte)0), localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", new Object[] { paramString });
    }
  }
  
  final void a(ac paramac, JSONObject paramJSONObject)
  {
    if ((!(paramac instanceof g)) && (!(paramac instanceof b.f))) {
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", new Object[] { paramac.getName(), paramJSONObject.toString() });
    }
    paramac = paramac.tM(paramJSONObject.toString());
    if (this.fLx != null)
    {
      if (!(this.fLx instanceof o)) {
        break label95;
      }
      paramJSONObject = (o)this.fLx;
      paramJSONObject.b(paramac);
      paramJSONObject = paramJSONObject.E(q.class);
      if (paramJSONObject != null) {
        paramJSONObject.b(paramac);
      }
    }
    label95:
    do
    {
      return;
      if (!(this.fLx instanceof q)) {
        break;
      }
      paramJSONObject = (q)this.fLx;
      paramJSONObject.b(paramac);
      paramJSONObject = paramJSONObject.Zy();
    } while (paramJSONObject == null);
    paramJSONObject.b(paramac);
    return;
    this.fLx.b(paramac);
  }
  
  final JSONObject akU()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.gHy);
    return localJSONObject;
  }
  
  public final void alt()
  {
    try
    {
      a(new b.a((byte)0), akU());
      akV();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void lL(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = akU();
      localJSONObject.put("buffered", paramInt);
      a(new b.f((byte)0), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
    }
  }
  
  public final void onVideoPause()
  {
    try
    {
      a(new b.d((byte)0), akU());
      akV();
      ai.d(new b.3(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onVideoPlay()
  {
    try
    {
      this.gHx = 0;
      JSONObject localJSONObject = akU();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new b.e((byte)0), localJSONObject);
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "start video update timer");
      if (this.gEO == null)
      {
        y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
        this.gEO = new am(new b.1(this), true);
      }
      this.gEO.S(250L, 250L);
      ai.d(new b.2(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", new Object[] { localJSONException });
    }
  }
  
  public final void onVideoWaiting()
  {
    try
    {
      JSONObject localJSONObject = akU();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      a(new b.h((byte)0), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", new Object[] { localJSONException });
    }
  }
  
  public final void uP(String paramString)
  {
    this.gHy = paramString;
  }
  
  public final void z(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = akU();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      localJSONObject.put("duration", paramInt3 * 1.0D / 1000.0D);
      a(new b.c((byte)0), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", new Object[] { localJSONException });
    }
  }
  
  private static final class g
    extends ac
  {
    private static final int CTRL_INDEX = 544;
    private static final String NAME = "onXWebVideoTimeUpdate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b
 * JD-Core Version:    0.7.0.1
 */