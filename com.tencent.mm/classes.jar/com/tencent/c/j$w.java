package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class j$w
  extends StandardMessageCodec
{
  public static final w ahiy;
  
  static
  {
    AppMethodBeat.i(229261);
    ahiy = new w();
    AppMethodBeat.o(229261);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(229268);
    long l;
    Object localObject3;
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229268);
      return paramByteBuffer;
    case -128: 
      localObject1 = (Map)readValue(paramByteBuffer);
      localObject2 = new j.b();
      paramByteBuffer = ((Map)localObject1).get("type");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = null;
        ((j.b)localObject2).ahig = paramByteBuffer;
        ((j.b)localObject2).message = ((String)((Map)localObject1).get("message"));
        AppMethodBeat.o(229268);
        return localObject2;
      }
      if ((paramByteBuffer instanceof Integer)) {}
      for (l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
    case -127: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229268);
      return paramByteBuffer;
    case -126: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229268);
      return paramByteBuffer;
    case -125: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229268);
      return paramByteBuffer;
    case -124: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229268);
      return paramByteBuffer;
    case -123: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229268);
      return paramByteBuffer;
    case -122: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229268);
      return paramByteBuffer;
    case -121: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229268);
      return paramByteBuffer;
    case -120: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229268);
      return paramByteBuffer;
    case -119: 
      localObject3 = (Map)readValue(paramByteBuffer);
      localObject1 = new j.f();
      paramByteBuffer = ((Map)localObject3).get("roomId");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = null;
        ((j.f)localObject1).ahii = paramByteBuffer;
        paramByteBuffer = ((Map)localObject3).get("roomKey");
        if (paramByteBuffer == null)
        {
          paramByteBuffer = (ByteBuffer)localObject2;
          ((j.f)localObject1).ahij = paramByteBuffer;
          AppMethodBeat.o(229268);
          return localObject1;
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
      for (l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
    case -118: 
      localObject2 = (Map)readValue(paramByteBuffer);
      localObject3 = new j.h();
      paramByteBuffer = ((Map)localObject2).get("textureId");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = null;
        ((j.h)localObject3).ahik = paramByteBuffer;
        paramByteBuffer = ((Map)localObject2).get("width");
        if (paramByteBuffer == null)
        {
          paramByteBuffer = null;
          ((j.h)localObject3).ahhP = paramByteBuffer;
          paramByteBuffer = ((Map)localObject2).get("height");
          if (paramByteBuffer != null) {
            break label688;
          }
          paramByteBuffer = null;
          ((j.h)localObject3).ahhQ = paramByteBuffer;
          paramByteBuffer = ((Map)localObject2).get("quarterTurns");
          if (paramByteBuffer != null) {
            break label723;
          }
          paramByteBuffer = (ByteBuffer)localObject1;
          ((j.h)localObject3).ahil = paramByteBuffer;
          ((j.h)localObject3).ahim = ((Boolean)((Map)localObject2).get("mirror"));
          AppMethodBeat.o(229268);
          return localObject3;
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
      for (l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
      label688:
      if ((paramByteBuffer instanceof Integer)) {}
      for (l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
      label723:
      if ((paramByteBuffer instanceof Integer)) {}
      for (l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
    }
    paramByteBuffer = (Map)readValue(paramByteBuffer);
    localObject1 = new j.n();
    ((j.n)localObject1).nUM = ((String)paramByteBuffer.get("cover"));
    ((j.n)localObject1).title = ((String)paramByteBuffer.get("title"));
    ((j.n)localObject1).singerName = ((String)paramByteBuffer.get("singerName"));
    ((j.n)localObject1).vendor = ((String)paramByteBuffer.get("vendor"));
    AppMethodBeat.o(229268);
    return localObject1;
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229280);
    for (;;)
    {
      Object localObject;
      if ((paramObject instanceof j.b))
      {
        paramByteArrayOutputStream.write(128);
        localObject = (j.b)paramObject;
        paramObject = new HashMap();
        paramObject.put("type", ((j.b)localObject).ahig);
        paramObject.put("message", ((j.b)localObject).message);
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(129);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(130);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(131);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(132);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(133);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(134);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(135);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(136);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.f))
      {
        paramByteArrayOutputStream.write(137);
        localObject = (j.f)paramObject;
        paramObject = new HashMap();
        paramObject.put("roomId", ((j.f)localObject).ahii);
        paramObject.put("roomKey", ((j.f)localObject).ahij);
      }
      else if ((paramObject instanceof j.h))
      {
        paramByteArrayOutputStream.write(138);
        localObject = (j.h)paramObject;
        paramObject = new HashMap();
        paramObject.put("textureId", ((j.h)localObject).ahik);
        paramObject.put("width", ((j.h)localObject).ahhP);
        paramObject.put("height", ((j.h)localObject).ahhQ);
        paramObject.put("quarterTurns", ((j.h)localObject).ahil);
        paramObject.put("mirror", ((j.h)localObject).ahim);
      }
      else
      {
        if (!(paramObject instanceof j.n)) {
          break;
        }
        paramByteArrayOutputStream.write(139);
        localObject = (j.n)paramObject;
        paramObject = new HashMap();
        paramObject.put("cover", ((j.n)localObject).nUM);
        paramObject.put("title", ((j.n)localObject).title);
        paramObject.put("singerName", ((j.n)localObject).singerName);
        paramObject.put("vendor", ((j.n)localObject).vendor);
      }
    }
    super.writeValue(paramByteArrayOutputStream, paramObject);
    AppMethodBeat.o(229280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.c.j.w
 * JD-Core Version:    0.7.0.1
 */