package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class c$b
  extends StandardMessageCodec
{
  public static final b ahhy;
  
  static
  {
    AppMethodBeat.i(229208);
    ahhy = new b();
    AppMethodBeat.o(229208);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(229215);
    Object localObject;
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229215);
      return paramByteBuffer;
    case -128: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new c.c();
      ((c.c)localObject).username = ((String)paramByteBuffer.get("username"));
      ((c.c)localObject).url = ((String)paramByteBuffer.get("url"));
      ((c.c)localObject).msf = ((String)paramByteBuffer.get("urlToken"));
      ((c.c)localObject).decodeKey = ((String)paramByteBuffer.get("decodeKey"));
      AppMethodBeat.o(229215);
      return localObject;
    case -127: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new c.d();
      ((c.d)localObject).path = ((String)paramByteBuffer.get("path"));
      AppMethodBeat.o(229215);
      return localObject;
    case -126: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new c.e();
      ((c.e)localObject).username = ((String)paramByteBuffer.get("username"));
      paramByteBuffer = paramByteBuffer.get("timeLimit");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = null;
        ((c.e)localObject).ahhz = paramByteBuffer;
        AppMethodBeat.o(229215);
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
    AppMethodBeat.o(229215);
    return paramByteBuffer;
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229220);
    for (;;)
    {
      Object localObject;
      if ((paramObject instanceof c.c))
      {
        paramByteArrayOutputStream.write(128);
        localObject = (c.c)paramObject;
        paramObject = new HashMap();
        paramObject.put("username", ((c.c)localObject).username);
        paramObject.put("url", ((c.c)localObject).url);
        paramObject.put("urlToken", ((c.c)localObject).msf);
        paramObject.put("decodeKey", ((c.c)localObject).decodeKey);
      }
      else if ((paramObject instanceof c.d))
      {
        paramByteArrayOutputStream.write(129);
        localObject = (c.d)paramObject;
        paramObject = new HashMap();
        paramObject.put("path", ((c.d)localObject).path);
      }
      else if ((paramObject instanceof c.e))
      {
        paramByteArrayOutputStream.write(130);
        localObject = (c.e)paramObject;
        paramObject = new HashMap();
        paramObject.put("username", ((c.e)localObject).username);
        paramObject.put("timeLimit", ((c.e)localObject).ahhz);
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
    AppMethodBeat.o(229220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.c.c.b
 * JD-Core Version:    0.7.0.1
 */