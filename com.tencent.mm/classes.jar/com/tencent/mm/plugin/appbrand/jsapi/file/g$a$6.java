package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.d;
import java.nio.ByteBuffer;

final class g$a$6
  implements g
{
  public final ByteBuffer BZ(String paramString)
  {
    AppMethodBeat.i(102771);
    paramString = ByteBuffer.wrap(paramString.getBytes(UTF_8));
    AppMethodBeat.o(102771);
    return paramString;
  }
  
  public final String k(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(102770);
    paramByteBuffer = new String(d.m(paramByteBuffer), UTF_8);
    AppMethodBeat.o(102770);
    return paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g.a.6
 * JD-Core Version:    0.7.0.1
 */