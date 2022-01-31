package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.u.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

final class e$a$5
  implements e
{
  e$a$5(Charset paramCharset) {}
  
  public final String j(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return new String(d.k(paramByteBuffer), this.gqJ);
  }
  
  public final ByteBuffer ua(String paramString)
  {
    return ByteBuffer.wrap(paramString.getBytes(this.gqJ)).order(ByteOrder.LITTLE_ENDIAN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e.a.5
 * JD-Core Version:    0.7.0.1
 */