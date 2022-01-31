package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.d;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class g$a$7
  implements g
{
  private final Charset hLW;
  
  g$a$7()
  {
    AppMethodBeat.i(102772);
    this.hLW = Charset.forName("ISO-8859-1");
    AppMethodBeat.o(102772);
  }
  
  public final ByteBuffer BZ(String paramString)
  {
    AppMethodBeat.i(102774);
    paramString = ByteBuffer.wrap(paramString.getBytes(this.hLW));
    AppMethodBeat.o(102774);
    return paramString;
  }
  
  public final String k(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(102773);
    paramByteBuffer = new String(d.m(paramByteBuffer), this.hLW);
    AppMethodBeat.o(102773);
    return paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g.a.7
 * JD-Core Version:    0.7.0.1
 */