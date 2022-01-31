package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.u.d;
import java.nio.ByteBuffer;

final class e$a$6
  implements e
{
  public final String j(ByteBuffer paramByteBuffer)
  {
    return new String(d.k(paramByteBuffer), UTF_8);
  }
  
  public final ByteBuffer ua(String paramString)
  {
    return ByteBuffer.wrap(paramString.getBytes(UTF_8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e.a.6
 * JD-Core Version:    0.7.0.1
 */