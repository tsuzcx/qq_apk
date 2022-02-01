package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NfcALogic;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "()V", "TAG", "", "emptyByteArray", "", "getEmptyByteArray", "()[B", "emptyByteArray$delegate", "Lkotlin/Lazy;", "exec", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "tag", "Landroid/nfc/Tag;", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execAsync", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "getAtqa", "nfcA", "Landroid/nfc/tech/NfcA;", "getNfcA", "getSak", "", "luggage-commons-jsapi-nfc-ext_release"})
public final class f
  implements a
{
  private static final kotlin.f pgZ;
  public static final f pha;
  
  static
  {
    AppMethodBeat.i(242147);
    pha = new f();
    pgZ = g.a(k.aazD, (kotlin.g.a.a)a.phb);
    AppMethodBeat.o(242147);
  }
  
  public final void a(Tag paramTag, String paramString, b<? super e<Object>, x> paramb)
  {
    AppMethodBeat.i(242145);
    p.k(paramTag, "tag");
    p.k(paramString, "function");
    p.k(paramb, "callback");
    Log.d("MicroMsg.AppBrand.NfcALogic", "execAsync, function: ".concat(String.valueOf(paramString)));
    paramTag = NfcA.get(paramTag);
    if (paramTag == null)
    {
      paramb.invoke(new e.a(13015, "unavailable tech"));
      AppMethodBeat.o(242145);
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
      AppMethodBeat.o(242145);
      return;
      if (!paramString.equals("getAtqa")) {
        break;
      }
      paramString = paramTag.getAtqa();
      paramTag = paramString;
      if (paramString == null) {
        paramTag = (byte[])pgZ.getValue();
      }
      paramString = new StringBuilder("atqa: ");
      String str = Arrays.toString(paramTag);
      p.j(str, "java.util.Arrays.toString(this)");
      Log.d("MicroMsg.AppBrand.NfcALogic", str);
      paramTag = (e)new e.b(paramTag);
      continue;
      if (!paramString.equals("getSak")) {
        break;
      }
      paramTag = (e)new e.b(Short.valueOf(paramTag.getSak()));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<byte[]>
  {
    public static final a phb;
    
    static
    {
      AppMethodBeat.i(241772);
      phb = new a();
      AppMethodBeat.o(241772);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.f
 * JD-Core Version:    0.7.0.1
 */