package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class d$b
  extends StandardMessageCodec
{
  public static final b ahhD;
  
  static
  {
    AppMethodBeat.i(229065);
    ahhD = new b();
    AppMethodBeat.o(229065);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(229068);
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229068);
      return paramByteBuffer;
    case -128: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new d.c();
      ((d.c)localObject).key = ((String)paramByteBuffer.get("key"));
      AppMethodBeat.o(229068);
      return localObject;
    }
    paramByteBuffer = (Map)readValue(paramByteBuffer);
    Object localObject = new d.d();
    ((d.d)localObject).result = ((String)paramByteBuffer.get("result"));
    AppMethodBeat.o(229068);
    return localObject;
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229072);
    for (;;)
    {
      Object localObject;
      if ((paramObject instanceof d.c))
      {
        paramByteArrayOutputStream.write(128);
        localObject = (d.c)paramObject;
        paramObject = new HashMap();
        paramObject.put("key", ((d.c)localObject).key);
      }
      else
      {
        if (!(paramObject instanceof d.d)) {
          break;
        }
        paramByteArrayOutputStream.write(129);
        localObject = (d.d)paramObject;
        paramObject = new HashMap();
        paramObject.put("result", ((d.d)localObject).result);
      }
    }
    super.writeValue(paramByteArrayOutputStream, paramObject);
    AppMethodBeat.o(229072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.c.d.b
 * JD-Core Version:    0.7.0.1
 */