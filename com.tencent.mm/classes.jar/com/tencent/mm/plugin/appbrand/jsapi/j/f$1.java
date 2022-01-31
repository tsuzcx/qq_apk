package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.m.k.a;
import com.tencent.mm.plugin.appbrand.t.q;
import com.tencent.mm.plugin.appbrand.t.q.a;
import com.tencent.mm.plugin.appbrand.t.q.b;
import com.tencent.mm.plugin.appbrand.t.r;
import com.tencent.mm.plugin.appbrand.u.e.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class f$1
  implements d.a
{
  boolean hTY = false;
  
  f$1(f paramf, c paramc, String paramString) {}
  
  public final void AM(String paramString)
  {
    AppMethodBeat.i(108038);
    if (this.hTY)
    {
      ab.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
      AppMethodBeat.o(108038);
      return;
    }
    this.hTY = true;
    HashMap localHashMap = new HashMap();
    localHashMap.put("socketTaskId", this.hwk);
    localHashMap.put("state", "error");
    localHashMap.put("errMsg", paramString);
    paramString = new JSONObject(localHashMap).toString();
    new f.a().j(this.hxW).BN(paramString).aBz();
    if ((f.a(this.hTZ)) || (f.b(this.hTZ)))
    {
      ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 2L, 1L, false);
      AppMethodBeat.o(108038);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.o.a)e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 1L, 1L, false);
    AppMethodBeat.o(108038);
  }
  
  public final void AN(String paramString)
  {
    AppMethodBeat.i(108042);
    f.b(this.hxW, this.hwk, paramString);
    AppMethodBeat.o(108042);
  }
  
  public final void CD(String paramString)
  {
    AppMethodBeat.i(108039);
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", r.Fq(paramString));
    localHashMap.put("isBuffer", Boolean.FALSE);
    localHashMap.put("socketTaskId", this.hwk);
    localHashMap.put("state", "message");
    paramString = new JSONObject(localHashMap).toString();
    new f.a().j(this.hxW).BN(paramString).aBz();
    AppMethodBeat.o(108039);
  }
  
  public final void N(int paramInt, String paramString)
  {
    AppMethodBeat.i(108041);
    if (f.aDT() != null) {
      f.aDT().e(this.hxW, this.hwk);
    }
    HashMap localHashMap = new HashMap();
    if (j.b(this.hxW.asW())) {
      localHashMap.put("reason", "interrupted");
    }
    for (;;)
    {
      localHashMap.put("code", Integer.valueOf(paramInt));
      localHashMap.put("socketTaskId", this.hwk);
      localHashMap.put("state", "close");
      paramString = new JSONObject(localHashMap).toString();
      new f.a().j(this.hxW).BN(paramString).aBz();
      AppMethodBeat.o(108041);
      return;
      if (!bo.isNullOrNil(paramString)) {
        localHashMap.put("reason", paramString);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.u.e.a parama)
  {
    AppMethodBeat.i(108037);
    if ((parama == null) || (!((com.tencent.mm.plugin.appbrand.m.a)this.hxW.U(com.tencent.mm.plugin.appbrand.m.a.class)).bCW))
    {
      AppMethodBeat.o(108037);
      return;
    }
    m localm = new m();
    localm.cmz.cmA = "socket";
    localm.cmz.cmC = f.b(parama);
    localm.cmz.cmB = this.hwk;
    com.tencent.mm.sdk.b.a.ymk.l(localm);
    AppMethodBeat.o(108037);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(108036);
    if (f.aDT() != null) {
      f.aDT().d(this.hxW, this.hwk);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("socketTaskId", this.hwk);
    localHashMap.put("state", "open");
    localHashMap.put("header", f.b(paramh));
    paramh = new JSONObject(localHashMap).toString();
    new f.a().j(this.hxW).BN(paramh).aBz();
    AppMethodBeat.o(108036);
  }
  
  public final void h(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(108040);
    HashMap localHashMap = new HashMap();
    localHashMap.put("socketTaskId", this.hwk);
    localHashMap.put("data", paramByteBuffer);
    localHashMap.put("isBuffer", Boolean.TRUE);
    localHashMap.put("state", "message");
    paramByteBuffer = (q.a)this.hxW.U(q.a.class);
    paramByteBuffer = q.a(this.hxW.aAO(), localHashMap, paramByteBuffer);
    if (paramByteBuffer == q.b.iXY)
    {
      paramByteBuffer = new JSONObject(localHashMap).toString();
      new f.a().j(this.hxW).BN(paramByteBuffer).aBz();
      AppMethodBeat.o(108040);
      return;
    }
    if (paramByteBuffer == q.b.iXZ) {
      q.l(this.hxW, "onSocketTaskStateChange");
    }
    AppMethodBeat.o(108040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.f.1
 * JD-Core Version:    0.7.0.1
 */