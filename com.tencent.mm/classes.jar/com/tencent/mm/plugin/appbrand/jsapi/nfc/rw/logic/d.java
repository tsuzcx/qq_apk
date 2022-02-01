package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/IsoDepLogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getHistoricalBytes", "", "isoDep", "Landroid/nfc/tech/IsoDep;", "getIsoDep", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements c
{
  public static final d smg;
  
  static
  {
    AppMethodBeat.i(328083);
    smg = new d();
    AppMethodBeat.o(328083);
  }
  
  public final void a(Tag paramTag, String paramString, b<? super h<Object>, ah> paramb)
  {
    AppMethodBeat.i(328092);
    s.u(paramTag, "tag");
    s.u(paramString, "function");
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.IsoDepLogic", s.X("execAsync, function: ", paramString));
    paramTag = IsoDep.get(paramTag);
    if (paramTag == null)
    {
      paramb.invoke(new h.a(13015, "unavailable tech"));
      AppMethodBeat.o(328092);
      return;
    }
    if (s.p(paramString, "getHistoricalBytes"))
    {
      paramTag = paramTag.getHistoricalBytes();
      if (paramTag == null) {
        paramTag = null;
      }
    }
    for (paramTag = (h)new h.b(paramTag);; paramTag = (h)new h.a(13024, "function not support"))
    {
      paramb.invoke(paramTag);
      AppMethodBeat.o(328092);
      return;
      paramString = Arrays.toString(paramTag);
      s.s(paramString, "java.util.Arrays.toString(this)");
      Log.d("MicroMsg.AppBrand.IsoDepLogic", s.X("historicalBytes: ", paramString));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.d
 * JD-Core Version:    0.7.0.1
 */