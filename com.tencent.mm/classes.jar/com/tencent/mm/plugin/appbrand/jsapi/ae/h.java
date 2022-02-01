package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends c
{
  private static final int CTRL_INDEX = 851;
  private static final String NAME = "checkIsOpenAccessibility";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(326054);
    paramJSONObject = b.eT(paramf.getContext());
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(326054);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("open", paramJSONObject);
    paramf.callback(paramInt, m("ok", localHashMap));
    AppMethodBeat.o(326054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.h
 * JD-Core Version:    0.7.0.1
 */