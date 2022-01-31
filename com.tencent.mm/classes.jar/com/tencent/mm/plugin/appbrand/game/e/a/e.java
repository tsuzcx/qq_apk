package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends b
{
  public static final int CTRL_INDEX = 666;
  public static final String NAME = "operateGameRecorder";
  a htu;
  c.a htv;
  String htw;
  
  public e()
  {
    AppMethodBeat.i(143169);
    this.htu = new a();
    this.htv = null;
    this.htw = null;
    AppMethodBeat.o(143169);
  }
  
  private void a(r paramr, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(143170);
    Object localObject = String.format("fail: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("errCode", Integer.valueOf(paramInt3));
    paramr.h(paramInt1, j((String)localObject, localHashMap));
    localObject = this.htu;
    ((a)localObject).i(paramr);
    ab.i("MicroMsg.OnGameRecorderStateChangeEvent", "hy: dispatch error: %d, %s", new Object[] { Integer.valueOf(paramInt3), paramString });
    paramr = new HashMap(3);
    paramr.put("state", "error");
    paramr.put("errCode", Integer.valueOf(paramInt3));
    paramr.put("errMsg", paramString);
    ((a)localObject).w(paramr).aBz();
    AppMethodBeat.o(143170);
  }
  
  final void a(r paramr, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(143171);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("errCode", Integer.valueOf(0));
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    paramr.h(paramInt, j("ok", localHashMap));
    AppMethodBeat.o(143171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.e
 * JD-Core Version:    0.7.0.1
 */