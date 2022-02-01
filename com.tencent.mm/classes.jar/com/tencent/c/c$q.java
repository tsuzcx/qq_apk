package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class c$q
  extends StandardMessageCodec
{
  public static final q ahhC;
  
  static
  {
    AppMethodBeat.i(229177);
    ahhC = new q();
    AppMethodBeat.o(229177);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(229188);
    Object localObject;
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229188);
      return paramByteBuffer;
    case -128: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new c.i();
      ((c.i)localObject).username = ((String)paramByteBuffer.get("username"));
      ((c.i)localObject).Tly = ((String)paramByteBuffer.get("statusId"));
      ((c.i)localObject).url = ((String)paramByteBuffer.get("url"));
      AppMethodBeat.o(229188);
      return localObject;
    case -127: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new c.j();
      ((c.j)localObject).path = ((String)paramByteBuffer.get("path"));
      AppMethodBeat.o(229188);
      return localObject;
    case -126: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new c.k();
      ((c.k)localObject).username = ((String)paramByteBuffer.get("username"));
      paramByteBuffer = paramByteBuffer.get("timeLimit");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = null;
        ((c.k)localObject).ahhz = paramByteBuffer;
        AppMethodBeat.o(229188);
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
    AppMethodBeat.o(229188);
    return paramByteBuffer;
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229195);
    for (;;)
    {
      Object localObject;
      if ((paramObject instanceof c.i))
      {
        paramByteArrayOutputStream.write(128);
        localObject = (c.i)paramObject;
        paramObject = new HashMap();
        paramObject.put("username", ((c.i)localObject).username);
        paramObject.put("statusId", ((c.i)localObject).Tly);
        paramObject.put("url", ((c.i)localObject).url);
      }
      else if ((paramObject instanceof c.j))
      {
        paramByteArrayOutputStream.write(129);
        localObject = (c.j)paramObject;
        paramObject = new HashMap();
        paramObject.put("path", ((c.j)localObject).path);
      }
      else if ((paramObject instanceof c.k))
      {
        paramByteArrayOutputStream.write(130);
        localObject = (c.k)paramObject;
        paramObject = new HashMap();
        paramObject.put("username", ((c.k)localObject).username);
        paramObject.put("timeLimit", ((c.k)localObject).ahhz);
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
    AppMethodBeat.o(229195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.c.c.q
 * JD-Core Version:    0.7.0.1
 */