package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public final class f
{
  private static final l kXD;
  Properties kXE;
  byte[] kXF;
  
  static
  {
    AppMethodBeat.i(2320);
    kXD = new l(38650);
    AppMethodBeat.o(2320);
  }
  
  public f()
  {
    AppMethodBeat.i(2315);
    this.kXE = new Properties();
    AppMethodBeat.o(2315);
  }
  
  public final byte[] AJ()
  {
    AppMethodBeat.i(2318);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      localByteArrayOutputStream.write(kXD.getBytes());
      Iterator localIterator = this.kXE.keySet().iterator();
      Object localObject2;
      for (localObject1 = ""; localIterator.hasNext(); localObject1 = (String)localObject1 + localObject2 + "=" + this.kXE.getProperty((String)localObject2) + "\r\n") {
        localObject2 = localIterator.next();
      }
      localObject1 = ((String)localObject1).getBytes("UTF-8");
      localByteArrayOutputStream.write(new l(localObject1.length).getBytes());
      localByteArrayOutputStream.write((byte[])localObject1);
      if (this.kXF != null) {
        localByteArrayOutputStream.write(this.kXF);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject1;
        ab.e("MicroMsg.Channel.GameComment", "encode, error: %s", new Object[] { localIOException.getMessage() });
      }
    }
    localObject1 = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(2318);
    return localObject1;
  }
  
  public final void D(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2317);
    if (paramArrayOfByte == null)
    {
      ab.w("MicroMsg.Channel.GameComment", "decode, data is null");
      AppMethodBeat.o(2317);
      return;
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    byte[] arrayOfByte = new byte[2];
    localByteBuffer.get(arrayOfByte);
    if (!kXD.equals(new l(arrayOfByte))) {
      ab.e("MicroMsg.Channel.GameComment", "decode, unknow protocol");
    }
    if (paramArrayOfByte.length - 2 <= 2)
    {
      ab.e("MicroMsg.Channel.GameComment", "decode, data.length - headLength <= 2");
      AppMethodBeat.o(2317);
      return;
    }
    arrayOfByte = new byte[2];
    localByteBuffer.get(arrayOfByte);
    int i = new l(arrayOfByte).value;
    if (paramArrayOfByte.length - 2 - 2 < i)
    {
      ab.e("MicroMsg.Channel.GameComment", "decode, cooment content is empty");
      AppMethodBeat.o(2317);
      return;
    }
    arrayOfByte = new byte[i];
    localByteBuffer.get(arrayOfByte);
    try
    {
      this.kXE.load(new InputStreamReader(new ByteArrayInputStream(arrayOfByte), "UTF-8"));
      label174:
      i = paramArrayOfByte.length - 2 - i - 2;
      if (i > 0)
      {
        this.kXF = new byte[i];
        localByteBuffer.get(this.kXF);
      }
      AppMethodBeat.o(2317);
      return;
    }
    catch (IOException localIOException)
    {
      break label174;
    }
  }
  
  public final void G(Map<String, String> paramMap)
  {
    AppMethodBeat.i(2316);
    this.kXE.putAll(paramMap);
    AppMethodBeat.o(2316);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2319);
    StringBuilder localStringBuilder = new StringBuilder("GameComment [p=").append(this.kXE).append(", otherData=");
    if (this.kXF == null) {}
    for (String str = "";; str = new String(this.kXF))
    {
      str = str + "]";
      AppMethodBeat.o(2319);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.f
 * JD-Core Version:    0.7.0.1
 */