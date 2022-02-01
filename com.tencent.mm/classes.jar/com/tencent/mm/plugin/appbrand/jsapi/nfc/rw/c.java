package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "dispatch", "", "id", "", "techs", "", "", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setContext", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends bc
{
  public static final int CTRL_INDEX = 790;
  public static final String NAME = "onNFCDiscovered";
  public static final c.a sls;
  
  static
  {
    AppMethodBeat.i(183645);
    sls = new c.a((byte)0);
    AppMethodBeat.o(183645);
  }
  
  public final c A(f paramf)
  {
    AppMethodBeat.i(183643);
    paramf = super.i(paramf);
    if (paramf == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.JsApiEventOnNFCDiscovered");
      AppMethodBeat.o(183643);
      throw paramf;
    }
    paramf = (c)paramf;
    AppMethodBeat.o(183643);
    return paramf;
  }
  
  public final void a(byte[] paramArrayOfByte, List<String> paramList, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(328052);
    s.u(paramList, "techs");
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      localObject = new byte[0];
    }
    paramArrayOfByte = Base64.encode((byte[])localObject, 2);
    s.s(paramArrayOfByte, "encode(id ?: ByteArray(0), Base64.NO_WRAP)");
    localObject = StandardCharsets.UTF_8;
    s.s(localObject, "UTF_8");
    localObject = new String(paramArrayOfByte, (Charset)localObject);
    if (paramHashMap == null)
    {
      paramArrayOfByte = null;
      if (paramArrayOfByte != null) {
        break label137;
      }
    }
    label137:
    for (paramArrayOfByte = ak.e(new r[] { v.Y("id", localObject), v.Y("techs", paramList) });; paramArrayOfByte = (Map)paramArrayOfByte)
    {
      L(paramArrayOfByte).cpV();
      AppMethodBeat.o(328052);
      return;
      paramHashMap.put("id", localObject);
      paramHashMap.put("techs", paramList);
      paramArrayOfByte = ah.aiuX;
      paramArrayOfByte = paramHashMap;
      break;
    }
  }
  
  public final void cpV()
  {
    AppMethodBeat.i(183642);
    Log.d("MicroMsg.AppBrand.JsApiEventOnNFCDiscovered", s.X("dispatch, data: ", getData()));
    super.cpV();
    AppMethodBeat.o(183642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.c
 * JD-Core Version:    0.7.0.1
 */