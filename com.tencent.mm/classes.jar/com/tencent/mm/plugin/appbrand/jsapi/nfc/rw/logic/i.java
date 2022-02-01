package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NfcALogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "emptyByteArray", "", "getEmptyByteArray", "()[B", "emptyByteArray$delegate", "Lkotlin/Lazy;", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getAtqa", "nfcA", "Landroid/nfc/tech/NfcA;", "getNfcA", "getSak", "", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements c
{
  public static final i smw;
  private static final j smx;
  
  static
  {
    AppMethodBeat.i(328082);
    smw = new i();
    smx = k.a(o.aiuH, (a)i.a.smy);
    AppMethodBeat.o(328082);
  }
  
  public final void a(Tag paramTag, String paramString, b<? super h<Object>, ah> paramb)
  {
    AppMethodBeat.i(328090);
    s.u(paramTag, "tag");
    s.u(paramString, "function");
    s.u(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NfcALogic", s.X("execAsync, function: ", paramString));
    paramTag = NfcA.get(paramTag);
    if (paramTag == null)
    {
      paramb.invoke(new h.a(13015, "unavailable tech"));
      AppMethodBeat.o(328090);
      return;
    }
    if (s.p(paramString, "getAtqa"))
    {
      paramString = paramTag.getAtqa();
      paramTag = paramString;
      if (paramString == null) {
        paramTag = (byte[])smx.getValue();
      }
      paramString = Arrays.toString(paramTag);
      s.s(paramString, "java.util.Arrays.toString(this)");
      Log.d("MicroMsg.AppBrand.NfcALogic", s.X("atqa: ", paramString));
      paramTag = (h)new h.b(paramTag);
    }
    for (;;)
    {
      paramb.invoke(paramTag);
      AppMethodBeat.o(328090);
      return;
      if (s.p(paramString, "getSak")) {
        paramTag = (h)new h.b(Short.valueOf(paramTag.getSak()));
      } else {
        paramTag = (h)new h.a(13024, "function not support");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.i
 * JD-Core Version:    0.7.0.1
 */