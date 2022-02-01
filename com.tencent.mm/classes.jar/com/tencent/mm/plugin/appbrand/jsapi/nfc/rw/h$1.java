package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "it"}, k=3, mv={1, 5, 1}, xi=48)
final class h$1
  extends u
  implements b<Object, Object>
{
  public static final 1 slC;
  
  static
  {
    AppMethodBeat.i(328111);
    slC = new 1();
    AppMethodBeat.o(328111);
  }
  
  h$1()
  {
    super(1);
  }
  
  public final Object invoke(Object paramObject)
  {
    AppMethodBeat.i(328117);
    if ((paramObject != null) && ((paramObject instanceof byte[])))
    {
      paramObject = Base64.encode((byte[])paramObject, 2);
      s.s(paramObject, "encode(it, Base64.NO_WRAP)");
      Charset localCharset = StandardCharsets.UTF_8;
      s.s(localCharset, "UTF_8");
      paramObject = new String(paramObject, localCharset);
      AppMethodBeat.o(328117);
      return paramObject;
    }
    AppMethodBeat.o(328117);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.h.1
 * JD-Core Version:    0.7.0.1
 */