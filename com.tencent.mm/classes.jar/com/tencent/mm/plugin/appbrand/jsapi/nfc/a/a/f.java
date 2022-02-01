package com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g;
import d.g.a.b;
import d.g.b.u;
import d.g.b.w;
import d.y;
import java.util.Arrays;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NfcALogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "emptyByteArray", "", "getEmptyByteArray", "()[B", "emptyByteArray$delegate", "Lkotlin/Lazy;", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getAtqa", "nfcA", "Landroid/nfc/tech/NfcA;", "getNfcA", "getSak", "", "luggage-commons-jsapi-nfc-ext_release"})
public final class f
  implements a
{
  private static final d.f kcZ;
  public static final f kda;
  
  static
  {
    AppMethodBeat.i(194634);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(f.class), "emptyByteArray", "getEmptyByteArray()[B")) };
    kda = new f();
    kcZ = g.a(d.k.JfK, (d.g.a.a)a.kdb);
    AppMethodBeat.o(194634);
  }
  
  public final void a(Tag paramTag, String paramString, b<? super e<Object>, y> paramb)
  {
    AppMethodBeat.i(194635);
    d.g.b.k.h(paramTag, "tag");
    d.g.b.k.h(paramString, "function");
    d.g.b.k.h(paramb, "callback");
    ad.d("MicroMsg.AppBrand.NfcALogic", "execAsync, function: ".concat(String.valueOf(paramString)));
    paramTag = NfcA.get(paramTag);
    if (paramTag == null)
    {
      paramb.aA(new e.a(13015, "unavailable tech"));
      AppMethodBeat.o(194635);
      return;
    }
    switch (paramString.hashCode())
    {
    default: 
      paramTag = (e)new e.a(13024, "function not support");
    }
    for (;;)
    {
      paramb.aA(paramTag);
      AppMethodBeat.o(194635);
      return;
      if (!paramString.equals("getAtqa")) {
        break;
      }
      paramString = paramTag.getAtqa();
      paramTag = paramString;
      if (paramString == null) {
        paramTag = (byte[])kcZ.getValue();
      }
      paramString = new StringBuilder("atqa: ");
      String str = Arrays.toString(paramTag);
      d.g.b.k.g(str, "java.util.Arrays.toString(this)");
      ad.d("MicroMsg.AppBrand.NfcALogic", str);
      paramTag = (e)new e.b(paramTag);
      continue;
      if (!paramString.equals("getSak")) {
        break;
      }
      paramTag = (e)new e.b(Short.valueOf(paramTag.getSak()));
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<byte[]>
  {
    public static final a kdb;
    
    static
    {
      AppMethodBeat.i(194633);
      kdb = new a();
      AppMethodBeat.o(194633);
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