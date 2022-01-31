package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.net.nsd.NsdManager;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.m.p;
import com.tencent.mm.plugin.appbrand.m.p.1;
import com.tencent.mm.plugin.appbrand.m.p.b;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class i
  extends a<c>
{
  public static final int CTRL_INDEX = 529;
  public static final String NAME = "operateLocalServicesScan";
  final Map<String, i.a> gRJ;
  
  public i()
  {
    AppMethodBeat.i(108072);
    this.gRJ = new ConcurrentHashMap();
    AppMethodBeat.o(108072);
  }
  
  static String k(c paramc, String paramString)
  {
    AppMethodBeat.i(108074);
    paramc = paramc.getAppId() + "#" + paramString;
    AppMethodBeat.o(108074);
    return paramc;
  }
  
  public final void a(c paramc, JSONObject arg2, int paramInt)
  {
    AppMethodBeat.i(108073);
    ??? = ???.optString("action");
    d.i("MicroMsg.JsApiOperateLocalServicesScan", "action = ".concat(String.valueOf(???)));
    Object localObject2;
    if (TextUtils.equals("start", (CharSequence)???))
    {
      ??? = ???.optString("serviceType");
      if (TextUtils.isEmpty(???))
      {
        paramc.h(paramInt, j("fail:invalid param", null));
        AppMethodBeat.o(108073);
        return;
      }
      synchronized (this.gRJ)
      {
        localObject2 = this.gRJ.keySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((String)((Iterator)localObject2).next()).contains(paramc.getAppId()))
          {
            paramc.h(paramInt, j("fail:scan task already exist", null));
            AppMethodBeat.o(108073);
            return;
          }
        }
        ??? = new i.a(this, paramc);
        ((i.a)???).hUg.set(paramInt);
        this.gRJ.put(k(paramc, ???), ???);
        localObject2 = p.itw;
        NsdManager localNsdManager = p.aIu();
        p.1 local1 = new p.1((p)localObject2, (p.b)???);
        ((p)localObject2).itx.put(???, local1);
        localNsdManager.discoverServices(???, 1, local1);
        al.p(new i.1(this, paramc, ???, (i.a)???), 30000L);
        AppMethodBeat.o(108073);
        return;
      }
    }
    if (TextUtils.equals("stop", (CharSequence)???)) {
      synchronized (this.gRJ)
      {
        ??? = this.gRJ.values().iterator();
        for (int i = 1; ((Iterator)???).hasNext(); i = 0)
        {
          localObject2 = (i.a)((Iterator)???).next();
          ((i.a)localObject2).hUh.set(paramInt);
          p.itw.a((p.b)localObject2);
        }
        if (i != 0) {
          paramc.h(paramInt, j("fail:task not found", null));
        }
        this.gRJ.clear();
        AppMethodBeat.o(108073);
        return;
      }
    }
    paramc.h(paramInt, j("fail:invalid param", null));
    AppMethodBeat.o(108073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.i
 * JD-Core Version:    0.7.0.1
 */