package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class g$b
  extends StandardMessageCodec
{
  public static final b ahhK;
  
  static
  {
    AppMethodBeat.i(229179);
    ahhK = new b();
    AppMethodBeat.o(229179);
  }
  
  public final Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(229186);
    switch (paramByte)
    {
    default: 
      paramByteBuffer = super.readValueOfType(paramByte, paramByteBuffer);
      AppMethodBeat.o(229186);
      return paramByteBuffer;
    case -128: 
      paramByteBuffer = (Map)readValue(paramByteBuffer);
      localObject = new g.c();
      ((g.c)localObject).musicId = ((String)paramByteBuffer.get("musicId"));
      ((g.c)localObject).songName = ((String)paramByteBuffer.get("songName"));
      ((g.c)localObject).rDl = ((String)paramByteBuffer.get("singer"));
      ((g.c)localObject).nRx = ((String)paramByteBuffer.get("dataUrl"));
      ((g.c)localObject).appid = ((String)paramByteBuffer.get("appid"));
      ((g.c)localObject).rDm = ((String)paramByteBuffer.get("webUrl"));
      ((g.c)localObject).coverUrl = ((String)paramByteBuffer.get("coverUrl"));
      ((g.c)localObject).oOZ = ((String)paramByteBuffer.get("mid"));
      ((g.c)localObject).Mcq = ((String)paramByteBuffer.get("lyric"));
      paramByteBuffer = paramByteBuffer.get("requestCode");
      if (paramByteBuffer == null)
      {
        paramByteBuffer = null;
        ((g.c)localObject).ahhL = paramByteBuffer;
        AppMethodBeat.o(229186);
        return localObject;
      }
      if ((paramByteBuffer instanceof Integer)) {}
      for (long l = ((Integer)paramByteBuffer).intValue();; l = ((Long)paramByteBuffer).longValue())
      {
        paramByteBuffer = Long.valueOf(l);
        break;
      }
    }
    paramByteBuffer = (Map)readValue(paramByteBuffer);
    Object localObject = new g.d();
    ((g.d)localObject).userName = ((String)paramByteBuffer.get("userName"));
    AppMethodBeat.o(229186);
    return localObject;
  }
  
  public final void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    AppMethodBeat.i(229192);
    for (;;)
    {
      Object localObject;
      if ((paramObject instanceof g.c))
      {
        paramByteArrayOutputStream.write(128);
        localObject = (g.c)paramObject;
        paramObject = new HashMap();
        paramObject.put("musicId", ((g.c)localObject).musicId);
        paramObject.put("songName", ((g.c)localObject).songName);
        paramObject.put("singer", ((g.c)localObject).rDl);
        paramObject.put("dataUrl", ((g.c)localObject).nRx);
        paramObject.put("appid", ((g.c)localObject).appid);
        paramObject.put("webUrl", ((g.c)localObject).rDm);
        paramObject.put("coverUrl", ((g.c)localObject).coverUrl);
        paramObject.put("mid", ((g.c)localObject).oOZ);
        paramObject.put("lyric", ((g.c)localObject).Mcq);
        paramObject.put("requestCode", ((g.c)localObject).ahhL);
      }
      else
      {
        if (!(paramObject instanceof g.d)) {
          break;
        }
        paramByteArrayOutputStream.write(129);
        localObject = (g.d)paramObject;
        paramObject = new HashMap();
        paramObject.put("userName", ((g.d)localObject).userName);
      }
    }
    super.writeValue(paramByteArrayOutputStream, paramObject);
    AppMethodBeat.o(229192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.c.g.b
 * JD-Core Version:    0.7.0.1
 */