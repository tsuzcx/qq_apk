package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.game.g.b.b;
import com.tencent.mm.plugin.appbrand.game.g.b.f;
import com.tencent.mm.plugin.appbrand.game.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends b
{
  public static final int CTRL_INDEX = 666;
  public static final String NAME = "operateGameRecorder";
  a jRx;
  c.a jRy;
  String jRz;
  
  public e()
  {
    AppMethodBeat.i(45155);
    this.jRx = new a();
    this.jRy = null;
    this.jRz = null;
    AppMethodBeat.o(45155);
  }
  
  private void a(q paramq, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(45156);
    Object localObject = String.format("fail: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("errCode", Integer.valueOf(paramInt3));
    paramq.h(paramInt1, k((String)localObject, localHashMap));
    localObject = this.jRx;
    ((a)localObject).g(paramq);
    ac.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch error: %d, %s", new Object[] { Integer.valueOf(paramInt3), paramString });
    paramq = new HashMap(3);
    paramq.put("state", "error");
    paramq.put("errCode", Integer.valueOf(paramInt3));
    paramq.put("errMsg", paramString);
    ((a)localObject).A(paramq).beN();
    AppMethodBeat.o(45156);
  }
  
  final void a(q paramq, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(45157);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("errCode", Integer.valueOf(0));
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    paramq.h(paramInt, k("ok", localHashMap));
    AppMethodBeat.o(45157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.e
 * JD-Core Version:    0.7.0.1
 */