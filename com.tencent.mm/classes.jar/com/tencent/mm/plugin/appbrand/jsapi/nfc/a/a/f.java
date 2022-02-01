package com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g;
import d.g.a.b;
import d.g.b.p;
import d.k;
import d.l;
import d.z;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NfcALogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "emptyByteArray", "", "getEmptyByteArray", "()[B", "emptyByteArray$delegate", "Lkotlin/Lazy;", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getAtqa", "nfcA", "Landroid/nfc/tech/NfcA;", "getNfcA", "getSak", "", "luggage-commons-jsapi-nfc-ext_release"})
public final class f
  implements a
{
  private static final d.f kZV;
  public static final f kZW;
  
  static
  {
    AppMethodBeat.i(199712);
    kZW = new f();
    kZV = g.a(k.MKc, (d.g.a.a)f.a.kZX);
    AppMethodBeat.o(199712);
  }
  
  public final void a(Tag paramTag, String paramString, b<? super e<Object>, z> paramb)
  {
    AppMethodBeat.i(199711);
    p.h(paramTag, "tag");
    p.h(paramString, "function");
    p.h(paramb, "callback");
    ad.d("MicroMsg.AppBrand.NfcALogic", "execAsync, function: ".concat(String.valueOf(paramString)));
    paramTag = NfcA.get(paramTag);
    if (paramTag == null)
    {
      paramb.invoke(new e.a(13015, "unavailable tech"));
      AppMethodBeat.o(199711);
      return;
    }
    switch (paramString.hashCode())
    {
    default: 
      paramTag = (e)new e.a(13024, "function not support");
    }
    for (;;)
    {
      paramb.invoke(paramTag);
      AppMethodBeat.o(199711);
      return;
      if (!paramString.equals("getAtqa")) {
        break;
      }
      paramString = paramTag.getAtqa();
      paramTag = paramString;
      if (paramString == null) {
        paramTag = (byte[])kZV.getValue();
      }
      paramString = new StringBuilder("atqa: ");
      String str = Arrays.toString(paramTag);
      p.g(str, "java.util.Arrays.toString(this)");
      ad.d("MicroMsg.AppBrand.NfcALogic", str);
      paramTag = (e)new e.b(paramTag);
      continue;
      if (!paramString.equals("getSak")) {
        break;
      }
      paramTag = (e)new e.b(Short.valueOf(paramTag.getSak()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.f
 * JD-Core Version:    0.7.0.1
 */