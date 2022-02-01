package com.tencent.mm.plugin.downloader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Properties;

public final class c
{
  private static final k xmH;
  Properties xmI;
  byte[] xmJ;
  
  static
  {
    AppMethodBeat.i(88868);
    xmH = new k(38650);
    AppMethodBeat.o(88868);
  }
  
  public c()
  {
    AppMethodBeat.i(88863);
    this.xmI = new Properties();
    AppMethodBeat.o(88863);
  }
  
  public final void ad(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88865);
    if (paramArrayOfByte == null)
    {
      Log.w("MicroMsg.Channel.GameComment", "decode, data is null");
      AppMethodBeat.o(88865);
      return;
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    int i = xmH.getBytes().length;
    byte[] arrayOfByte = new byte[i];
    localByteBuffer.get(arrayOfByte);
    if (!xmH.equals(new k(arrayOfByte))) {
      Log.e("MicroMsg.Channel.GameComment", "decode, unknow protocol");
    }
    if (paramArrayOfByte.length - i <= 2)
    {
      Log.e("MicroMsg.Channel.GameComment", "decode, data.length - headLength <= 2");
      AppMethodBeat.o(88865);
      return;
    }
    arrayOfByte = new byte[2];
    localByteBuffer.get(arrayOfByte);
    int j = new k(arrayOfByte).value;
    if (paramArrayOfByte.length - i - 2 < j)
    {
      Log.e("MicroMsg.Channel.GameComment", "decode, cooment content is empty");
      AppMethodBeat.o(88865);
      return;
    }
    arrayOfByte = new byte[j];
    localByteBuffer.get(arrayOfByte);
    try
    {
      this.xmI.load(new InputStreamReader(new ByteArrayInputStream(arrayOfByte), "UTF-8"));
      label182:
      i = paramArrayOfByte.length - i - j - 2;
      if (i > 0)
      {
        this.xmJ = new byte[i];
        localByteBuffer.get(this.xmJ);
      }
      AppMethodBeat.o(88865);
      return;
    }
    catch (IOException localIOException)
    {
      break label182;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(88867);
    StringBuilder localStringBuilder = new StringBuilder("GameComment [p=").append(this.xmI).append(", otherData=");
    if (this.xmJ == null) {}
    for (String str = "";; str = new String(this.xmJ))
    {
      str = str + "]";
      AppMethodBeat.o(88867);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.c
 * JD-Core Version:    0.7.0.1
 */