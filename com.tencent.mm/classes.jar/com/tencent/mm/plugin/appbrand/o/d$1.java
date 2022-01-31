package com.tencent.mm.plugin.appbrand.o;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.v.n;
import com.tencent.mm.plugin.appbrand.v.n.a;
import com.tencent.mm.plugin.appbrand.v.n.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

final class d$1
  implements Runnable
{
  d$1(d paramd, c paramc, JSONObject paramJSONObject, d.a parama, int paramInt, Map paramMap, ArrayList paramArrayList, String paramString1, String paramString2) {}
  
  public final void run()
  {
    if (n.a(this.ggH.ahK(), this.gQU, (n.a)this.ggH.D(n.a.class)) == n.b.hlG)
    {
      this.gQV.ut("convert native buffer parameter fail. native buffer exceed size limit.");
      return;
    }
    String str = this.gQU.optString("url");
    Object localObject7 = this.gQU.opt("data");
    Object localObject1 = this.gQU.optString("method");
    Object localObject4 = localObject1;
    if (bk.bl((String)localObject1)) {
      localObject4 = "GET";
    }
    if (TextUtils.isEmpty(str))
    {
      this.gQV.ut("url is null");
      return;
    }
    if ((!URLUtil.isHttpsUrl(str)) && (!URLUtil.isHttpUrl(str)))
    {
      this.gQV.ut("request protocol must be http or https");
      return;
    }
    ??? = new byte[0];
    localObject1 = ???;
    if (localObject7 != null)
    {
      localObject1 = ???;
      if (d.vt((String)localObject4))
      {
        if (!(localObject7 instanceof String)) {
          break label238;
        }
        localObject1 = ((String)localObject7).getBytes(Charset.forName("UTF-8"));
      }
    }
    for (;;)
    {
      synchronized (this.gRa.gQS)
      {
        if (this.gRa.gQS.size() < this.gRa.gQT) {
          break;
        }
        this.gQV.ut("max connected");
        y.i("MicroMsg.AppBrandNetworkRequest", "max connected");
        return;
      }
      label238:
      ??? = ???;
      if ((localObject7 instanceof ByteBuffer)) {
        ??? = com.tencent.mm.plugin.appbrand.u.d.k((ByteBuffer)localObject7);
      }
    }
    y.i("MicroMsg.AppBrandNetworkRequest", "method %s ,url %s timeout %s", new Object[] { localObject4, str, Integer.valueOf(this.gQW) });
    localObject4 = new e(str, (byte[])???, this.gQW, this.gQV, (String)localObject4);
    ((e)localObject4).gRe = this.gQX;
    ((e)localObject4).gRf = this.gQY;
    ((e)localObject4).gRj = this.gQZ;
    ((e)localObject4).gRh = this.gQU.optString("responseType", "text");
    synchronized (this.gRa.gQS)
    {
      this.gRa.gQS.add(localObject4);
      ((e)localObject4).gep = this.gek;
      d.a(this.gRa, (e)localObject4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.d.1
 * JD-Core Version:    0.7.0.1
 */