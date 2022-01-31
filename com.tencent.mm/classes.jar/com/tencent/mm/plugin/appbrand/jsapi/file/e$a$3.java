package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.u.d;
import java.math.BigInteger;
import java.nio.ByteBuffer;

final class e$a$3
  implements e
{
  public final String j(ByteBuffer paramByteBuffer)
  {
    return new BigInteger(1, d.k(paramByteBuffer)).toString(16);
  }
  
  public final ByteBuffer ua(String paramString)
  {
    return ByteBuffer.wrap(new BigInteger(paramString, 16).toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e.a.3
 * JD-Core Version:    0.7.0.1
 */