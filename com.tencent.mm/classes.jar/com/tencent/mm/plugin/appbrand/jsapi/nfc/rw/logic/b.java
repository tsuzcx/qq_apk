package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/IsoDepLogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getHistoricalBytes", "", "isoDep", "Landroid/nfc/tech/IsoDep;", "getIsoDep", "luggage-commons-jsapi-nfc-ext_release"})
public final class b
  implements a
{
  public static final b pgA;
  
  static
  {
    AppMethodBeat.i(241805);
    pgA = new b();
    AppMethodBeat.o(241805);
  }
  
  public final void a(Tag paramTag, String paramString, kotlin.g.a.b<? super e<Object>, x> paramb)
  {
    AppMethodBeat.i(241803);
    p.k(paramTag, "tag");
    p.k(paramString, "function");
    p.k(paramb, "callback");
    Log.d("MicroMsg.AppBrand.IsoDepLogic", "execAsync, function: ".concat(String.valueOf(paramString)));
    paramTag = IsoDep.get(paramTag);
    if (paramTag == null)
    {
      paramb.invoke(new e.a(13015, "unavailable tech"));
      AppMethodBeat.o(241803);
      return;
    }
    switch (paramString.hashCode())
    {
    }
    do
    {
      paramTag = (e)new e.a(13024, "function not support");
      paramb.invoke(paramTag);
      AppMethodBeat.o(241803);
      return;
    } while (!paramString.equals("getHistoricalBytes"));
    paramTag = paramTag.getHistoricalBytes();
    if (paramTag != null)
    {
      paramString = new StringBuilder("historicalBytes: ");
      String str = Arrays.toString(paramTag);
      p.j(str, "java.util.Arrays.toString(this)");
      Log.d("MicroMsg.AppBrand.IsoDepLogic", str);
    }
    for (;;)
    {
      paramTag = (e)new e.b(paramTag);
      break;
      paramTag = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.b
 * JD-Core Version:    0.7.0.1
 */