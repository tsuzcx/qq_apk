package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class j$y
  extends StandardMessageCodec
{
  public static final y ahiz;
  
  static
  {
    AppMethodBeat.i(229293);
    ahiz = new y();
    AppMethodBeat.o(229293);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    Object localObject = null;
    AppMethodBeat.i(229300);
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -128: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new j.a();
      ((j.a)localObject).ahif = ((Boolean)paramByteBuffer.get("needSwitchToVoice"));
      AppMethodBeat.o(229300);
      return localObject;
    case -127: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -126: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -125: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -124: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -123: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -122: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -121: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -120: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -119: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -118: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -117: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -116: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -115: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -114: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -113: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -112: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -111: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -110: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -109: 
      paramByteBuffer = j.c.dh((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -108: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new j.d();
      ((j.d)localObject).ahih = ((Double)paramByteBuffer.get("value"));
      AppMethodBeat.o(229300);
      return localObject;
    case -107: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -106: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -105: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -104: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -103: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -102: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -101: 
      paramByteBuffer = j.e.di((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -100: 
      paramByteBuffer = j.g.dj((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -99: 
      paramByteBuffer = j.g.dj((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -98: 
      paramByteBuffer = j.g.dj((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -97: 
      paramByteBuffer = j.j.dk((Map)readValue(paramByteBuffer));
      AppMethodBeat.o(229300);
      return paramByteBuffer;
    case -96: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new j.k();
      ((j.k)localObject).ahip = ((Double)paramByteBuffer.get("slowFrameRate"));
      AppMethodBeat.o(229300);
      return localObject;
    case -95: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new j.l();
      ((j.l)localObject).ahiq = ((Boolean)paramByteBuffer.get("showAlertIfNoPermission"));
      ((j.l)localObject).ahir = ((Boolean)paramByteBuffer.get("needPop"));
      AppMethodBeat.o(229300);
      return localObject;
    case -94: 
      Map localMap = (Map)readValue(paramByteBuffer);
      j.r localr = new j.r();
      paramByteBuffer = localMap.get("textureId");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = null;
        localr.ahik = paramByteBuffer;
        paramByteBuffer = localMap.get("width");
        if (paramByteBuffer == null)
        {
          paramByteBuffer = null;
          localr.ahhP = paramByteBuffer;
          paramByteBuffer = localMap.get("height");
          if (paramByteBuffer != null) {
            break label1100;
          }
          paramByteBuffer = (ByteBuffer)localObject;
          localr.ahhQ = paramByteBuffer;
          AppMethodBeat.o(229300);
          return localr;
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
      label1100:
      if ((paramByteBuffer instanceof Integer)) {}
      for (l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
    }
    paramByteBuffer = (Map)readValue(paramByteBuffer);
    localObject = new j.s();
    ((j.s)localObject).username = ((String)paramByteBuffer.get("username"));
    ((j.s)localObject).AmC = ((String)paramByteBuffer.get("avatarPath"));
    ((j.s)localObject).displayName = ((String)paramByteBuffer.get("displayName"));
    ((j.s)localObject).ahit = ((String)paramByteBuffer.get("gender"));
    ((j.s)localObject).ahiu = ((Boolean)paramByteBuffer.get("isOpenIM"));
    ((j.s)localObject).ahiv = ((String)paramByteBuffer.get("subName"));
    AppMethodBeat.o(229300);
    return localObject;
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229305);
    for (;;)
    {
      Object localObject;
      if ((paramObject instanceof j.a))
      {
        paramByteArrayOutputStream.write(128);
        localObject = (j.a)paramObject;
        paramObject = new HashMap();
        paramObject.put("needSwitchToVoice", ((j.a)localObject).ahif);
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
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(132);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(133);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(134);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(135);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(136);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(137);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(138);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(139);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(140);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(141);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(142);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(143);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(144);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(145);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(146);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.c))
      {
        paramByteArrayOutputStream.write(147);
        paramObject = ((j.c)paramObject).jRw();
      }
      else if ((paramObject instanceof j.d))
      {
        paramByteArrayOutputStream.write(148);
        localObject = (j.d)paramObject;
        paramObject = new HashMap();
        paramObject.put("value", ((j.d)localObject).ahih);
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(149);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(150);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(151);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(152);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(153);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(154);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.e))
      {
        paramByteArrayOutputStream.write(155);
        paramObject = ((j.e)paramObject).jRw();
      }
      else if ((paramObject instanceof j.g))
      {
        paramByteArrayOutputStream.write(156);
        paramObject = ((j.g)paramObject).jRw();
      }
      else if ((paramObject instanceof j.g))
      {
        paramByteArrayOutputStream.write(157);
        paramObject = ((j.g)paramObject).jRw();
      }
      else if ((paramObject instanceof j.g))
      {
        paramByteArrayOutputStream.write(158);
        paramObject = ((j.g)paramObject).jRw();
      }
      else if ((paramObject instanceof j.j))
      {
        paramByteArrayOutputStream.write(159);
        paramObject = ((j.j)paramObject).jRw();
      }
      else if ((paramObject instanceof j.k))
      {
        paramByteArrayOutputStream.write(160);
        localObject = (j.k)paramObject;
        paramObject = new HashMap();
        paramObject.put("slowFrameRate", ((j.k)localObject).ahip);
      }
      else if ((paramObject instanceof j.l))
      {
        paramByteArrayOutputStream.write(161);
        localObject = (j.l)paramObject;
        paramObject = new HashMap();
        paramObject.put("showAlertIfNoPermission", ((j.l)localObject).ahiq);
        paramObject.put("needPop", ((j.l)localObject).ahir);
      }
      else if ((paramObject instanceof j.r))
      {
        paramByteArrayOutputStream.write(162);
        localObject = (j.r)paramObject;
        paramObject = new HashMap();
        paramObject.put("textureId", ((j.r)localObject).ahik);
        paramObject.put("width", ((j.r)localObject).ahhP);
        paramObject.put("height", ((j.r)localObject).ahhQ);
      }
      else
      {
        if (!(paramObject instanceof j.s)) {
          break;
        }
        paramByteArrayOutputStream.write(163);
        localObject = (j.s)paramObject;
        paramObject = new HashMap();
        paramObject.put("username", ((j.s)localObject).username);
        paramObject.put("avatarPath", ((j.s)localObject).AmC);
        paramObject.put("displayName", ((j.s)localObject).displayName);
        paramObject.put("gender", ((j.s)localObject).ahit);
        paramObject.put("isOpenIM", ((j.s)localObject).ahiu);
        paramObject.put("subName", ((j.s)localObject).ahiv);
      }
    }
    super.writeValue(paramByteArrayOutputStream, paramObject);
    AppMethodBeat.o(229305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.c.j.y
 * JD-Core Version:    0.7.0.1
 */