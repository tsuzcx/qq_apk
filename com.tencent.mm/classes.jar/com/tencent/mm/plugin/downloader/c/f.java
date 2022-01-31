package com.tencent.mm.plugin.downloader.c;

import com.tencent.mm.c.l;
import com.tencent.mm.sdk.platformtools.y;
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
  private static final l iOM = new l(38650);
  Properties iON = new Properties();
  byte[] iOO;
  
  public final byte[] ss()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      localByteArrayOutputStream.write(iOM.getBytes());
      Iterator localIterator = this.iON.keySet().iterator();
      Object localObject2;
      for (Object localObject1 = ""; localIterator.hasNext(); localObject1 = (String)localObject1 + localObject2 + "=" + this.iON.getProperty((String)localObject2) + "\r\n") {
        localObject2 = localIterator.next();
      }
      localObject1 = ((String)localObject1).getBytes("UTF-8");
      localByteArrayOutputStream.write(new l(localObject1.length).getBytes());
      localByteArrayOutputStream.write((byte[])localObject1);
      if (this.iOO != null) {
        localByteArrayOutputStream.write(this.iOO);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.Channel.GameComment", "encode, error: %s", new Object[] { localIOException.getMessage() });
      }
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GameComment [p=").append(this.iON).append(", otherData=");
    if (this.iOO == null) {}
    for (String str = "";; str = new String(this.iOO)) {
      return str + "]";
    }
  }
  
  public final void u(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      y.w("MicroMsg.Channel.GameComment", "decode, data is null");
    }
    for (;;)
    {
      return;
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
      iOM.getBytes();
      byte[] arrayOfByte = new byte[2];
      localByteBuffer.get(arrayOfByte);
      if (!iOM.equals(new l(arrayOfByte))) {
        y.e("MicroMsg.Channel.GameComment", "decode, unknow protocol");
      }
      if (paramArrayOfByte.length - 2 <= 2)
      {
        y.e("MicroMsg.Channel.GameComment", "decode, data.length - headLength <= 2");
        return;
      }
      arrayOfByte = new byte[2];
      localByteBuffer.get(arrayOfByte);
      int i = new l(arrayOfByte).value;
      if (paramArrayOfByte.length - 2 - 2 < i)
      {
        y.e("MicroMsg.Channel.GameComment", "decode, cooment content is empty");
        return;
      }
      arrayOfByte = new byte[i];
      localByteBuffer.get(arrayOfByte);
      try
      {
        this.iON.load(new InputStreamReader(new ByteArrayInputStream(arrayOfByte), "UTF-8"));
        label157:
        i = paramArrayOfByte.length - 2 - i - 2;
        if (i <= 0) {
          continue;
        }
        this.iOO = new byte[i];
        localByteBuffer.get(this.iOO);
        return;
      }
      catch (IOException localIOException)
      {
        break label157;
      }
    }
  }
  
  public final void w(Map<String, String> paramMap)
  {
    this.iON.putAll(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.f
 * JD-Core Version:    0.7.0.1
 */