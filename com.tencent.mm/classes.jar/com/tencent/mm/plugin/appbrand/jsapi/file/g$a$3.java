package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.d;
import java.math.BigInteger;
import java.nio.ByteBuffer;

final class g$a$3
  implements g
{
  public final ByteBuffer BZ(String paramString)
  {
    AppMethodBeat.i(102765);
    paramString = ByteBuffer.wrap(new BigInteger(paramString, 16).toByteArray());
    AppMethodBeat.o(102765);
    return paramString;
  }
  
  public final String k(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(102764);
    paramByteBuffer = new BigInteger(1, d.m(paramByteBuffer)).toString(16);
    AppMethodBeat.o(102764);
    return paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g.a.3
 * JD-Core Version:    0.7.0.1
 */