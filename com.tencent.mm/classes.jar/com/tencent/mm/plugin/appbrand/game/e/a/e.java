package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.game.g.b.b;
import com.tencent.mm.plugin.appbrand.game.g.b.f;
import com.tencent.mm.plugin.appbrand.game.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends b
{
  public static final int CTRL_INDEX = 666;
  public static final String NAME = "operateGameRecorder";
  a rrq;
  c.a rrr;
  String rrs;
  
  public e()
  {
    AppMethodBeat.i(45155);
    this.rrq = new a();
    this.rrr = null;
    this.rrs = null;
    AppMethodBeat.o(45155);
  }
  
  private void a(y paramy, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(45156);
    String str = String.format("fail: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("errCode", Integer.valueOf(paramInt3));
    paramy.callback(paramInt1, m(str, localHashMap));
    this.rrq.a(paramy, paramInt3, paramString);
    AppMethodBeat.o(45156);
  }
  
  final void a(y paramy, int paramInt, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(45157);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("errCode", Integer.valueOf(0));
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    paramy.callback(paramInt, m("ok", localHashMap));
    AppMethodBeat.o(45157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.e
 * JD-Core Version:    0.7.0.1
 */