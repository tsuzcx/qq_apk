package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class c$o
  extends StandardMessageCodec
{
  public static final o ahhB;
  
  static
  {
    AppMethodBeat.i(229165);
    ahhB = new o();
    AppMethodBeat.o(229165);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(229168);
    Object localObject;
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229168);
      return paramByteBuffer;
    case -128: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new c.f();
      ((c.f)localObject).hHB = ((String)paramByteBuffer.get("localId"));
      ((c.f)localObject).hQX = ((String)paramByteBuffer.get("snsId"));
      ((c.f)localObject).mediaId = ((String)paramByteBuffer.get("mediaId"));
      ((c.f)localObject).ahhA = ((Boolean)paramByteBuffer.get("requestThumb"));
      AppMethodBeat.o(229168);
      return localObject;
    case -127: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new c.g();
      ((c.g)localObject).path = ((String)paramByteBuffer.get("path"));
      AppMethodBeat.o(229168);
      return localObject;
    case -126: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new c.h();
      ((c.h)localObject).username = ((String)paramByteBuffer.get("username"));
      paramByteBuffer = paramByteBuffer.get("timeLimit");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = null;
        ((c.h)localObject).ahhz = paramByteBuffer;
        AppMethodBeat.o(229168);
        return localObject;
      }
      if ((paramByteBuffer instanceof Integer)) {}
      for (long l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
    }
    paramByteBuffer = c.l.cY((Map)readValue(paramByteBuffer));
    AppMethodBeat.o(229168);
    return paramByteBuffer;
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229174);
    for (;;)
    {
      Object localObject;
      if ((paramObject instanceof c.f))
      {
        paramByteArrayOutputStream.write(128);
        localObject = (c.f)paramObject;
        paramObject = new HashMap();
        paramObject.put("localId", ((c.f)localObject).hHB);
        paramObject.put("snsId", ((c.f)localObject).hQX);
        paramObject.put("mediaId", ((c.f)localObject).mediaId);
        paramObject.put("requestThumb", ((c.f)localObject).ahhA);
      }
      else if ((paramObject instanceof c.g))
      {
        paramByteArrayOutputStream.write(129);
        localObject = (c.g)paramObject;
        paramObject = new HashMap();
        paramObject.put("path", ((c.g)localObject).path);
      }
      else if ((paramObject instanceof c.h))
      {
        paramByteArrayOutputStream.write(130);
        localObject = (c.h)paramObject;
        paramObject = new HashMap();
        paramObject.put("username", ((c.h)localObject).username);
        paramObject.put("timeLimit", ((c.h)localObject).ahhz);
      }
      else
      {
        if (!(paramObject instanceof c.l)) {
          break;
        }
        paramByteArrayOutputStream.write(131);
        paramObject = ((c.l)paramObject).jRw();
      }
    }
    super.writeValue(paramByteArrayOutputStream, paramObject);
    AppMethodBeat.o(229174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.c.c.o
 * JD-Core Version:    0.7.0.1
 */