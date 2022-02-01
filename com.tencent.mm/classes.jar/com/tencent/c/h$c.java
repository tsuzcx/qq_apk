package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class h$c
  extends StandardMessageCodec
{
  public static final c ahhM;
  
  static
  {
    AppMethodBeat.i(229113);
    ahhM = new c();
    AppMethodBeat.o(229113);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(229123);
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229123);
      return paramByteBuffer;
    }
    paramByteBuffer = (Map)readValue(paramByteBuffer);
    h.a locala = new h.a();
    locala.buffer = ((byte[])paramByteBuffer.get("buffer"));
    AppMethodBeat.o(229123);
    return locala;
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229129);
    while ((paramObject instanceof h.a))
    {
      paramByteArrayOutputStream.write(128);
      h.a locala = (h.a)paramObject;
      paramObject = new HashMap();
      paramObject.put("buffer", locala.buffer);
    }
    super.writeValue(paramByteArrayOutputStream, paramObject);
    AppMethodBeat.o(229129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.c.h.c
 * JD-Core Version:    0.7.0.1
 */