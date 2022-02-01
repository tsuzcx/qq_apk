package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.l;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Properties;

public final class c
{
  private static final l plp;
  Properties plq;
  byte[] plr;
  
  static
  {
    AppMethodBeat.i(88868);
    plp = new l(38650);
    AppMethodBeat.o(88868);
  }
  
  public c()
  {
    AppMethodBeat.i(88863);
    this.plq = new Properties();
    AppMethodBeat.o(88863);
  }
  
  public final void I(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88865);
    if (paramArrayOfByte == null)
    {
      ad.w("MicroMsg.Channel.GameComment", "decode, data is null");
      AppMethodBeat.o(88865);
      return;
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    byte[] arrayOfByte = new byte[2];
    localByteBuffer.get(arrayOfByte);
    if (!plp.equals(new l(arrayOfByte))) {
      ad.e("MicroMsg.Channel.GameComment", "decode, unknow protocol");
    }
    if (paramArrayOfByte.length - 2 <= 2)
    {
      ad.e("MicroMsg.Channel.GameComment", "decode, data.length - headLength <= 2");
      AppMethodBeat.o(88865);
      return;
    }
    arrayOfByte = new byte[2];
    localByteBuffer.get(arrayOfByte);
    int i = new l(arrayOfByte).value;
    if (paramArrayOfByte.length - 2 - 2 < i)
    {
      ad.e("MicroMsg.Channel.GameComment", "decode, cooment content is empty");
      AppMethodBeat.o(88865);
      return;
    }
    arrayOfByte = new byte[i];
    localByteBuffer.get(arrayOfByte);
    try
    {
      this.plq.load(new InputStreamReader(new ByteArrayInputStream(arrayOfByte), "UTF-8"));
      label170:
      i = paramArrayOfByte.length - 2 - i - 2;
      if (i > 0)
      {
        this.plr = new byte[i];
        localByteBuffer.get(this.plr);
      }
      AppMethodBeat.o(88865);
      return;
    }
    catch (IOException localIOException)
    {
      break label170;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(88867);
    StringBuilder localStringBuilder = new StringBuilder("GameComment [p=").append(this.plq).append(", otherData=");
    if (this.plr == null) {}
    for (String str = "";; str = new String(this.plr))
    {
      str = str + "]";
      AppMethodBeat.o(88867);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.c
 * JD-Core Version:    0.7.0.1
 */