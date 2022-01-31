package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

final class g$a$4
  implements g
{
  g$a$4(Charset paramCharset) {}
  
  public final ByteBuffer BZ(String paramString)
  {
    AppMethodBeat.i(102767);
    paramString = ByteBuffer.wrap(paramString.getBytes(this.hLU)).order(ByteOrder.LITTLE_ENDIAN);
    AppMethodBeat.o(102767);
    return paramString;
  }
  
  public final String k(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(102766);
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramByteBuffer = new String(d.m(paramByteBuffer), this.hLU);
    AppMethodBeat.o(102766);
    return paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g.a.4
 * JD-Core Version:    0.7.0.1
 */