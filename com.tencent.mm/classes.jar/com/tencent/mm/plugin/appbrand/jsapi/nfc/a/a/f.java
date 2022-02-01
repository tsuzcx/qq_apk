package com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g;
import d.g.a.b;
import d.g.b.u;
import d.g.b.w;
import d.y;
import java.util.Arrays;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NfcALogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "emptyByteArray", "", "getEmptyByteArray", "()[B", "emptyByteArray$delegate", "Lkotlin/Lazy;", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getAtqa", "nfcA", "Landroid/nfc/tech/NfcA;", "getNfcA", "getSak", "", "luggage-commons-jsapi-nfc-ext_release"})
public final class f
  implements a
{
  private static final d.f kDM;
  public static final f kDN;
  
  static
  {
    AppMethodBeat.i(200909);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(f.class), "emptyByteArray", "getEmptyByteArray()[B")) };
    kDN = new f();
    kDM = g.a(d.k.KTe, (d.g.a.a)a.kDO);
    AppMethodBeat.o(200909);
  }
  
  public final void a(Tag paramTag, String paramString, b<? super e<Object>, y> paramb)
  {
    AppMethodBeat.i(200910);
    d.g.b.k.h(paramTag, "tag");
    d.g.b.k.h(paramString, "function");
    d.g.b.k.h(paramb, "callback");
    ac.d("MicroMsg.AppBrand.NfcALogic", "execAsync, function: ".concat(String.valueOf(paramString)));
    paramTag = NfcA.get(paramTag);
    if (paramTag == null)
    {
      paramb.ay(new e.a(13015, "unavailable tech"));
      AppMethodBeat.o(200910);
      return;
    }
    switch (paramString.hashCode())
    {
    default: 
      paramTag = (e)new e.a(13024, "function not support");
    }
    for (;;)
    {
      paramb.ay(paramTag);
      AppMethodBeat.o(200910);
      return;
      if (!paramString.equals("getAtqa")) {
        break;
      }
      paramString = paramTag.getAtqa();
      paramTag = paramString;
      if (paramString == null) {
        paramTag = (byte[])kDM.getValue();
      }
      paramString = new StringBuilder("atqa: ");
      String str = Arrays.toString(paramTag);
      d.g.b.k.g(str, "java.util.Arrays.toString(this)");
      ac.d("MicroMsg.AppBrand.NfcALogic", str);
      paramTag = (e)new e.b(paramTag);
      continue;
      if (!paramString.equals("getSak")) {
        break;
      }
      paramTag = (e)new e.b(Short.valueOf(paramTag.getSak()));
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<byte[]>
  {
    public static final a kDO;
    
    static
    {
      AppMethodBeat.i(200908);
      kDO = new a();
      AppMethodBeat.o(200908);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.f
 * JD-Core Version:    0.7.0.1
 */