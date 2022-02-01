package com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/IsoDepLogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getHistoricalBytes", "", "isoDep", "Landroid/nfc/tech/IsoDep;", "getIsoDep", "luggage-commons-jsapi-nfc-ext_release"})
public final class b
  implements a
{
  public static final b kZx;
  
  static
  {
    AppMethodBeat.i(199696);
    kZx = new b();
    AppMethodBeat.o(199696);
  }
  
  public final void a(Tag paramTag, String paramString, d.g.a.b<? super e<Object>, z> paramb)
  {
    AppMethodBeat.i(199695);
    p.h(paramTag, "tag");
    p.h(paramString, "function");
    p.h(paramb, "callback");
    ad.d("MicroMsg.AppBrand.IsoDepLogic", "execAsync, function: ".concat(String.valueOf(paramString)));
    paramTag = IsoDep.get(paramTag);
    if (paramTag == null)
    {
      paramb.invoke(new e.a(13015, "unavailable tech"));
      AppMethodBeat.o(199695);
      return;
    }
    switch (paramString.hashCode())
    {
    }
    do
    {
      paramTag = (e)new e.a(13024, "function not support");
      paramb.invoke(paramTag);
      AppMethodBeat.o(199695);
      return;
    } while (!paramString.equals("getHistoricalBytes"));
    paramTag = paramTag.getHistoricalBytes();
    if (paramTag != null)
    {
      paramString = new StringBuilder("historicalBytes: ");
      String str = Arrays.toString(paramTag);
      p.g(str, "java.util.Arrays.toString(this)");
      ad.d("MicroMsg.AppBrand.IsoDepLogic", str);
    }
    for (;;)
    {
      paramTag = (e)new e.b(paramTag);
      break;
      paramTag = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.b
 * JD-Core Version:    0.7.0.1
 */