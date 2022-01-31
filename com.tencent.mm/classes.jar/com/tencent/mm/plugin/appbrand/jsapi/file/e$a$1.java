package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.u.d;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class e$a$1
  implements e
{
  private final Charset oB = Charset.forName("US-ASCII");
  
  public final String j(ByteBuffer paramByteBuffer)
  {
    return new String(d.k(paramByteBuffer), this.oB);
  }
  
  public final ByteBuffer ua(String paramString)
  {
    return ByteBuffer.wrap(paramString.getBytes(this.oB));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e.a.1
 * JD-Core Version:    0.7.0.1
 */