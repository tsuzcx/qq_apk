package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.t.q;
import com.tencent.mm.plugin.appbrand.t.q.a;
import com.tencent.mm.plugin.appbrand.t.q.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

final class g$2
  implements e.c
{
  g$2(g paramg, c paramc) {}
  
  public final void S(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145954);
    ab.i("MicroMsg.JsApiOperateRecorder", "onStop tempFilePath:%s duration:%d fileSize:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
    if (this.hKB.wX().a(new File(paramString), g.cP(paramString), true, localj) == com.tencent.mm.plugin.appbrand.appstorage.j.gZA)
    {
      ab.i("MicroMsg.JsApiOperateRecorder", "realFilePath:%s", new Object[] { localj.value });
      paramString = new HashMap();
      paramString.put("state", e.e.ifO.state);
      paramString.put("tempFilePath", localj.value);
      paramString.put("duration", Integer.valueOf(paramInt1));
      paramString.put("fileSize", Integer.valueOf(paramInt2));
      d.a(this.hKB, paramString);
      AppMethodBeat.o(145954);
      return;
    }
    ab.e("MicroMsg.JsApiOperateRecorder", "create file fail");
    paramString = new HashMap();
    paramString.put("state", e.e.ifP.state);
    paramString.put("errCode", Integer.valueOf(-1));
    paramString.put("errMsg", "create file fail");
    d.a(this.hKB, paramString);
    AppMethodBeat.o(145954);
  }
  
  public final void b(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(145957);
    ab.i("MicroMsg.JsApiOperateRecorder", "onFrameRecorded isLastFrame:%b length:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramArrayOfByte.length) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", e.e.ifQ.state);
    localHashMap.put("isLastFrame", Boolean.valueOf(paramBoolean));
    localHashMap.put("frameBuffer", q.ak(paramArrayOfByte));
    paramArrayOfByte = q.a(this.hKB.aAO(), localHashMap, (q.a)this.hKB.U(q.a.class));
    if ((paramArrayOfByte != q.b.iXY) && (paramArrayOfByte == q.b.iXZ))
    {
      q.l(this.hKB, "onRecorderStateChange");
      AppMethodBeat.o(145957);
      return;
    }
    d.a(this.hKB, localHashMap);
    AppMethodBeat.o(145957);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(145955);
    ab.i("MicroMsg.JsApiOperateRecorder", "onPause");
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", e.e.ifN.state);
    d.a(this.hKB, localHashMap);
    AppMethodBeat.o(145955);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145956);
    ab.i("MicroMsg.JsApiOperateRecorder", "onResume");
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", e.e.ifM.state);
    d.a(this.hKB, localHashMap);
    AppMethodBeat.o(145956);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(145953);
    ab.i("MicroMsg.JsApiOperateRecorder", "onStart");
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", e.e.ifM.state);
    d.a(this.hKB, localHashMap);
    AppMethodBeat.o(145953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.g.2
 * JD-Core Version:    0.7.0.1
 */