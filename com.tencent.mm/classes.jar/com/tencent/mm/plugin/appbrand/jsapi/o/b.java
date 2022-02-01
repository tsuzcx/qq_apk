package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class b
  extends ab<f>
  implements h
{
  protected a mgb = new a();
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    if (BuildInfo.DEBUG) {
      throw new RuntimeException("Should call 3 params version!");
    }
    return a(paramf, paramJSONObject, paramf.getJsRuntime());
  }
  
  public final String a(final f paramf, final JSONObject paramJSONObject, o paramo)
  {
    final String str = bjl();
    HashMap localHashMap = new HashMap();
    localHashMap.put(auJ(), str);
    this.mgb.a(str, paramo);
    paramf.getAsyncHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144184);
        b.this.a(paramf, paramJSONObject, str);
        AppMethodBeat.o(144184);
      }
    });
    return n("ok", localHashMap);
  }
  
  public final boolean bEi()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b
 * JD-Core Version:    0.7.0.1
 */