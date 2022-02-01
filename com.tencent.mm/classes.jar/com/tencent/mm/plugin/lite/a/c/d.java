package com.tencent.mm.plugin.lite.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271611);
    Log.d("LiteAppJsApiGetUin", "Invoke getUin");
    paramString = new HashMap();
    h.baC();
    paramString.put("uin", b.aZs());
    paramString = new JSONObject(paramString);
    this.JZj.bq(paramString);
    AppMethodBeat.o(271611);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.d
 * JD-Core Version:    0.7.0.1
 */