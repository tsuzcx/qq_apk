package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.game.g.b.b;
import com.tencent.mm.plugin.appbrand.game.g.b.f;
import com.tencent.mm.plugin.appbrand.game.g.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends b
{
  public static final int CTRL_INDEX = 666;
  public static final String NAME = "operateGameRecorder";
  a lsK;
  c.a lsL;
  String lsM;
  
  public e()
  {
    AppMethodBeat.i(45155);
    this.lsK = new a();
    this.lsL = null;
    this.lsM = null;
    AppMethodBeat.o(45155);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.s params, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(45156);
    Object localObject = String.format("fail: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("errCode", Integer.valueOf(paramInt3));
    params.i(paramInt1, n((String)localObject, localHashMap));
    localObject = this.lsK;
    ((a)localObject).g(params);
    Log.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch error: %d, %s", new Object[] { Integer.valueOf(paramInt3), paramString });
    params = new HashMap(3);
    params.put("state", "error");
    params.put("errCode", Integer.valueOf(paramInt3));
    params.put("errMsg", paramString);
    ((a)localObject).K(params).bEo();
    AppMethodBeat.o(45156);
  }
  
  final void a(com.tencent.mm.plugin.appbrand.s params, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(45157);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("errCode", Integer.valueOf(0));
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    params.i(paramInt, n("ok", localHashMap));
    AppMethodBeat.o(45157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.e
 * JD-Core Version:    0.7.0.1
 */