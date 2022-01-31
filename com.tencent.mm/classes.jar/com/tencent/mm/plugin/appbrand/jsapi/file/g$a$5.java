package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

final class g$a$5
  implements g
{
  g$a$5(Charset paramCharset) {}
  
  public final ByteBuffer BZ(String paramString)
  {
    AppMethodBeat.i(102769);
    paramString = ByteBuffer.wrap(paramString.getBytes(this.hLV)).order(ByteOrder.LITTLE_ENDIAN);
    AppMethodBeat.o(102769);
    return paramString;
  }
  
  public final String k(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(102768);
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramByteBuffer = new String(d.m(paramByteBuffer), this.hLV);
    AppMethodBeat.o(102768);
    return paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g.a.5
 * JD-Core Version:    0.7.0.1
 */