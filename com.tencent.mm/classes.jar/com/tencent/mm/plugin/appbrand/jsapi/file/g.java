package com.tencent.mm.plugin.appbrand.jsapi.file;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

abstract interface g
{
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public abstract ByteBuffer BZ(String paramString);
  
  public abstract String k(ByteBuffer paramByteBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.g
 * JD-Core Version:    0.7.0.1
 */