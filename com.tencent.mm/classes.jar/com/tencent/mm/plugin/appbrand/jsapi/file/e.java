package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.u.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

abstract interface e
{
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public abstract String j(ByteBuffer paramByteBuffer);
  
  public abstract ByteBuffer ua(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e
 * JD-Core Version:    0.7.0.1
 */