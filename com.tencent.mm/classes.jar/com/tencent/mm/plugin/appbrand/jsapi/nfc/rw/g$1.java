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
final class g$1
  extends u
  implements b<Object, Object>
{
  public static final 1 slA;
  
  static
  {
    AppMethodBeat.i(328057);
    slA = new 1();
    AppMethodBeat.o(328057);
  }
  
  g$1()
  {
    super(1);
  }
  
  public final Object invoke(Object paramObject)
  {
    AppMethodBeat.i(328062);
    if ((paramObject != null) && ((paramObject instanceof byte[]))) {}
    for (paramObject = (byte[])paramObject;; paramObject = new byte[0])
    {
      paramObject = Base64.encode(paramObject, 2);
      s.s(paramObject, "encode(byteArray, Base64.NO_WRAP)");
      Charset localCharset = StandardCharsets.UTF_8;
      s.s(localCharset, "UTF_8");
      paramObject = new String(paramObject, localCharset);
      AppMethodBeat.o(328062);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.g.1
 * JD-Core Version:    0.7.0.1
 */