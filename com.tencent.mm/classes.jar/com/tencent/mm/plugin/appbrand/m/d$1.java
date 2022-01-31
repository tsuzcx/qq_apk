package com.tencent.mm.plugin.appbrand.m;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.t.q;
import com.tencent.mm.plugin.appbrand.t.q.a;
import com.tencent.mm.plugin.appbrand.t.q.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

final class d$1
  implements Runnable
{
  d$1(d paramd, c paramc, JSONObject paramJSONObject, d.a parama, String paramString1, int paramInt, Map paramMap, ArrayList paramArrayList, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(108148);
    if (q.a(this.hxW.aAO(), this.isJ, (q.a)this.hxW.U(q.a.class)) == q.b.iXZ)
    {
      this.isK.CC("convert native buffer parameter fail. native buffer exceed size limit.");
      AppMethodBeat.o(108148);
      return;
    }
    String str = j.DY(this.isJ.optString("url"));
    Object localObject6 = this.isJ.opt("data");
    ??? = this.isJ.optString("method");
    Object localObject3 = ???;
    if (bo.isNullOrNil((String)???)) {
      localObject3 = "GET";
    }
    if (TextUtils.isEmpty(str))
    {
      this.isK.CC("url is null");
      AppMethodBeat.o(108148);
      return;
    }
    if ((!URLUtil.isHttpsUrl(str)) && (!URLUtil.isHttpUrl(str)))
    {
      this.isK.CC("request protocol must be http or https");
      AppMethodBeat.o(108148);
      return;
    }
    ??? = new byte[0];
    ??? = ???;
    if (localObject6 != null)
    {
      ??? = ???;
      if (d.DQ((String)localObject3))
      {
        if (!(localObject6 instanceof String)) {
          break label294;
        }
        ??? = ((String)localObject6).getBytes(Charset.forName("UTF-8"));
      }
    }
    synchronized (this.isP.isH)
    {
      while (this.isP.isH.size() >= this.isP.isI)
      {
        this.isK.CC("max connected");
        ab.i("MicroMsg.AppBrandNetworkRequest", "max connected mRequestTaskList.size():%d,mMaxRequestConcurrent:%d", new Object[] { Integer.valueOf(this.isP.isH.size()), Integer.valueOf(this.isP.isI) });
        AppMethodBeat.o(108148);
        return;
        label294:
        ??? = ???;
        if ((localObject6 instanceof ByteBuffer)) {
          ??? = com.tencent.mm.plugin.appbrand.s.d.m((ByteBuffer)localObject6);
        }
      }
      ab.i("MicroMsg.AppBrandNetworkRequest", "request taskId %s, method %s ,url %s timeout %s", new Object[] { this.hwk, localObject3, str, Integer.valueOf(this.isL) });
      localObject3 = new e(str, (byte[])???, this.isL, this.isK, (String)localObject3);
      ((e)localObject3).isT = this.isM;
      ((e)localObject3).isU = this.isN;
      ((e)localObject3).isY = this.isO;
      ((e)localObject3).isW = this.isJ.optString("responseType", "text");
    }
    synchronized (this.isP.isH)
    {
      this.isP.isH.add(localObject3);
      ((e)localObject3).hwp = this.hwk;
      d.a(this.isP, (e)localObject3);
      AppMethodBeat.o(108148);
      return;
      localObject2 = finally;
      AppMethodBeat.o(108148);
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.d.1
 * JD-Core Version:    0.7.0.1
 */