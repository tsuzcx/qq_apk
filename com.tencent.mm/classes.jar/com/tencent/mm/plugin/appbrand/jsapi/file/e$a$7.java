package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.u.d;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class e$a$7
  implements e
{
  private final Charset gqK = Charset.forName("ISO-8859-1");
  
  public final String j(ByteBuffer paramByteBuffer)
  {
    return new String(d.k(paramByteBuffer), this.gqK);
  }
  
  public final ByteBuffer ua(String paramString)
  {
    return ByteBuffer.wrap(paramString.getBytes(this.gqK));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e.a.7
 * JD-Core Version:    0.7.0.1
 */