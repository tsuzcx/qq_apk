package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class b
  extends aa<e>
  implements h
{
  public a pei = new a();
  
  public final String a(e parame, JSONObject paramJSONObject)
  {
    if (BuildInfo.DEBUG) {
      throw new RuntimeException("Should call 3 params version!");
    }
    return a(parame, paramJSONObject, parame.getJsRuntime());
  }
  
  public final String a(final e parame, final JSONObject paramJSONObject, o paramo)
  {
    final String str = bsL();
    HashMap localHashMap = new HashMap();
    localHashMap.put(aBF(), str);
    this.pei.b(str, paramo);
    parame.getAsyncHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144184);
        b.this.a(parame, paramJSONObject, str);
        AppMethodBeat.o(144184);
      }
    });
    return m("ok", localHashMap);
  }
  
  public final boolean bPG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b
 * JD-Core Version:    0.7.0.1
 */