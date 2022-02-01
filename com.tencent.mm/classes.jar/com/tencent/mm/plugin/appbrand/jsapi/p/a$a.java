package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a$a
  extends s
{
  public static final int CTRL_INDEX = 468;
  public static final String NAME = "onLoadSubPackageTaskStateChange";
  
  static void a(f paramf, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(139891);
    a(paramf, paramString1, paramString2, paramString3, -1, -1L, -1L);
    AppMethodBeat.o(139891);
  }
  
  static void a(f paramf, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139892);
    Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: formatEventCallback taskId: %s, state: %s, progress: %d, currentWritten: %d, totalWritten: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("taskId", paramString1);
    localHashMap.put("state", paramString2);
    localHashMap.put("moduleName", paramString3);
    if (paramInt >= 0) {
      localHashMap.put("progress", Integer.valueOf(paramInt));
    }
    if (paramLong1 >= 0L) {
      localHashMap.put("totalBytesWritten", Long.valueOf(paramLong1));
    }
    if (paramLong2 >= 0L) {
      localHashMap.put("totalBytesExpectedToWrite", Long.valueOf(paramLong2));
    }
    paramString1 = new JSONObject(localHashMap).toString();
    new a().h(paramf).ZQ(paramString1).cpV();
    AppMethodBeat.o(139892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a.a
 * JD-Core Version:    0.7.0.1
 */