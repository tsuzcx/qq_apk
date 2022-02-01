package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class j$p
  extends StandardMessageCodec
{
  public static final p ahis;
  
  static
  {
    AppMethodBeat.i(229273);
    ahis = new p();
    AppMethodBeat.o(229273);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(229287);
    Object localObject;
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229287);
      return paramByteBuffer;
    case -128: 
      localObject = (Map)readValue(paramByteBuffer);
      j.i locali = new j.i();
      paramByteBuffer = ((Map)localObject).get("feedId");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = null;
        locali.hJU = paramByteBuffer;
        locali.nonceId = ((String)((Map)localObject).get("nonceId"));
        AppMethodBeat.o(229287);
        return locali;
      }
      if ((paramByteBuffer instanceof Integer)) {}
      for (long l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
    case -127: 
      paramByteBuffer = j.j.dk((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229287);
      return paramByteBuffer;
    case -126: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new j.q();
      ((j.q)localObject).username = ((String)paramByteBuffer.get("username"));
      ((j.q)localObject).hHB = ((String)paramByteBuffer.get("localId"));
      AppMethodBeat.o(229287);
      return localObject;
    case -125: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new j.t();
      ((j.t)localObject).username = ((String)paramByteBuffer.get("username"));
      AppMethodBeat.o(229287);
      return localObject;
    case -124: 
      paramByteBuffer = j.u.dl((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229287);
      return paramByteBuffer;
    }
    paramByteBuffer = j.u.dl((Map)readValue(paramByteBuffer));
    AppMethodBeat.o(229287);
    return paramByteBuffer;
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229297);
    for (;;)
    {
      Object localObject;
      if ((paramObject instanceof j.i))
      {
        paramByteArrayOutputStream.write(128);
        localObject = (j.i)paramObject;
        paramObject = new HashMap();
        paramObject.put("feedId", ((j.i)localObject).hJU);
        paramObject.put("nonceId", ((j.i)localObject).nonceId);
      }
      else if ((paramObject instanceof j.j))
      {
        paramByteArrayOutputStream.write(129);
        paramObject = ((j.j)paramObject).jRw();
      }
      else if ((paramObject instanceof j.q))
      {
        paramByteArrayOutputStream.write(130);
        localObject = (j.q)paramObject;
        paramObject = new HashMap();
        paramObject.put("username", ((j.q)localObject).username);
        paramObject.put("localId", ((j.q)localObject).hHB);
      }
      else if ((paramObject instanceof j.t))
      {
        paramByteArrayOutputStream.write(131);
        localObject = (j.t)paramObject;
        paramObject = new HashMap();
        paramObject.put("username", ((j.t)localObject).username);
      }
      else if ((paramObject instanceof j.u))
      {
        paramByteArrayOutputStream.write(132);
        paramObject = ((j.u)paramObject).jRw();
      }
      else
      {
        if (!(paramObject instanceof j.u)) {
          break;
        }
        paramByteArrayOutputStream.write(133);
        paramObject = ((j.u)paramObject).jRw();
      }
    }
    super.writeValue(paramByteArrayOutputStream, paramObject);
    AppMethodBeat.o(229297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.c.j.p
 * JD-Core Version:    0.7.0.1
 */