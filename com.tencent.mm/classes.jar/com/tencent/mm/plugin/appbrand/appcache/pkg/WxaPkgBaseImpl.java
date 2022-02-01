package com.tencent.mm.plugin.appbrand.appcache.pkg;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class WxaPkgBaseImpl
  implements a
{
  public static int q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
    if (paramInt2 == 4) {
      return paramArrayOfByte.getInt();
    }
    byte[] arrayOfByte = new byte[paramInt2];
    paramArrayOfByte.get(arrayOfByte);
    int i = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      i |= arrayOfByte[paramInt1] << (paramInt2 - paramInt1 - 1) * 8;
      paramInt1 += 1;
    }
    return i;
  }
  
  public static class Info
    extends WxaPkg.Info
  {
    public Info(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      super(paramString2, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.pkg.WxaPkgBaseImpl
 * JD-Core Version:    0.7.0.1
 */