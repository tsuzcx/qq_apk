package com.tencent.mm.plugin.appbrand.o;

import com.tencent.mm.plugin.appbrand.o.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONObject;

public final class b$1
  implements a
{
  public b$1(b paramb, String paramString, b.a parama) {}
  
  public final void D(String paramString1, String paramString2, String paramString3)
  {
    y.e("MicroMsg.AppBrandNetworkDownload", "download error! filename %s, url %s", new Object[] { paramString1, paramString2 });
    this.gQO.us(paramString3);
    b.a(this.gQP, this.gek);
  }
  
  public final void bW(String paramString1, String paramString2)
  {
    y.i("MicroMsg.AppBrandNetworkDownload", "download start! filename %s, url %s", new Object[] { paramString1, paramString2 });
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    b.a(this.gQP, this.gek);
    this.gQO.c(b.SUCCESS, paramString2, paramString1, paramInt);
    y.i("MicroMsg.AppBrandNetworkDownload", "download success! filename %s, url %s", new Object[] { paramString1, paramString3 });
  }
  
  public final void f(int paramInt, long paramLong1, long paramLong2)
  {
    this.gQO.e(paramInt, paramLong1, paramLong2);
  }
  
  public final void vr(String paramString)
  {
    this.gQP.gQL.remove(paramString);
  }
  
  public final void y(JSONObject paramJSONObject)
  {
    this.gQO.y(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.b.1
 * JD-Core Version:    0.7.0.1
 */