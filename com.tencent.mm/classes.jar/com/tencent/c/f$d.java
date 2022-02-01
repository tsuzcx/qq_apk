package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Map;

final class f$d
  extends StandardMessageCodec
{
  public static final d ahhI;
  
  static
  {
    AppMethodBeat.i(229070);
    ahhI = new d();
    AppMethodBeat.o(229070);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(229075);
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229075);
      return paramByteBuffer;
    case -128: 
      paramByteBuffer = f.a.dc((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229075);
      return paramByteBuffer;
    case -127: 
      paramByteBuffer = f.b.dd((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229075);
      return paramByteBuffer;
    case -126: 
      paramByteBuffer = f.b.dd((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229075);
      return paramByteBuffer;
    }
    paramByteBuffer = f.b.dd((Map)readValue(paramByteBuffer));
    AppMethodBeat.o(229075);
    return paramByteBuffer;
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229082);
    for (;;)
    {
      if ((paramObject instanceof f.a))
      {
        paramByteArrayOutputStream.write(128);
        paramObject = ((f.a)paramObject).jRw();
      }
      else if ((paramObject instanceof f.b))
      {
        paramByteArrayOutputStream.write(129);
        paramObject = ((f.b)paramObject).jRw();
      }
      else if ((paramObject instanceof f.b))
      {
        paramByteArrayOutputStream.write(130);
        paramObject = ((f.b)paramObject).jRw();
      }
      else
      {
        if (!(paramObject instanceof f.b)) {
          break;
        }
        paramByteArrayOutputStream.write(131);
        paramObject = ((f.b)paramObject).jRw();
      }
    }
    super.writeValue(paramByteArrayOutputStream, paramObject);
    AppMethodBeat.o(229082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.c.f.d
 * JD-Core Version:    0.7.0.1
 */