package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class b$b
  extends StandardMessageCodec
{
  public static final b ahhu;
  
  static
  {
    AppMethodBeat.i(229130);
    ahhu = new b();
    AppMethodBeat.o(229130);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    Map localMap = null;
    AppMethodBeat.i(229135);
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229135);
      return paramByteBuffer;
    case -128: 
      localMap = (Map)readValue(paramByteBuffer);
      localObject = new b.c();
      paramByteBuffer = localMap.get("funcId");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = null;
        ((b.c)localObject).ahhv = paramByteBuffer;
        ((b.c)localObject).uri = ((String)localMap.get("uri"));
        ((b.c)localObject).data = ((byte[])localMap.get("data"));
        AppMethodBeat.o(229135);
        return localObject;
      }
      if ((paramByteBuffer instanceof Integer)) {}
      for (l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
    }
    Object localObject = (Map)readValue(paramByteBuffer);
    b.d locald = new b.d();
    paramByteBuffer = ((Map)localObject).get("errorType");
    if (paramByteBuffer == null)
    {
      paramByteBuffer = null;
      locald.ahhw = paramByteBuffer;
      paramByteBuffer = ((Map)localObject).get("errorCode");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = localMap;
        locald.ahhx = paramByteBuffer;
        locald.data = ((byte[])((Map)localObject).get("data"));
        AppMethodBeat.o(229135);
        return locald;
      }
    }
    else
    {
      if ((paramByteBuffer instanceof Integer)) {}
      for (l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
    }
    if ((paramByteBuffer instanceof Integer)) {}
    for (long l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
    {
      paramByteBuffer = Long.valueOf(l);
      break;
    }
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229141);
    for (;;)
    {
      Object localObject;
      if ((paramObject instanceof b.c))
      {
        paramByteArrayOutputStream.write(128);
        localObject = (b.c)paramObject;
        paramObject = new HashMap();
        paramObject.put("funcId", ((b.c)localObject).ahhv);
        paramObject.put("uri", ((b.c)localObject).uri);
        paramObject.put("data", ((b.c)localObject).data);
      }
      else
      {
        if (!(paramObject instanceof b.d)) {
          break;
        }
        paramByteArrayOutputStream.write(129);
        localObject = (b.d)paramObject;
        paramObject = new HashMap();
        paramObject.put("errorType", ((b.d)localObject).ahhw);
        paramObject.put("errorCode", ((b.d)localObject).ahhx);
        paramObject.put("data", ((b.d)localObject).data);
      }
    }
    super.writeValue(paramByteArrayOutputStream, paramObject);
    AppMethodBeat.o(229141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.c.b.b
 * JD-Core Version:    0.7.0.1
 */