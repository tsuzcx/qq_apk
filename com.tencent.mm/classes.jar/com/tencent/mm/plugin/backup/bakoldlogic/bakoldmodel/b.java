package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.mm.a.n;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public final class b
{
  public static String U(byte[] paramArrayOfByte)
  {
    String str = "";
    int i;
    if (paramArrayOfByte.length > 100) {
      i = paramArrayOfByte.length - 100;
    }
    while (i < paramArrayOfByte.length)
    {
      str = str + Integer.toHexString(paramArrayOfByte[i] & 0xFF) + " ";
      i += 1;
      continue;
      i = 0;
    }
    y.e("MicroMsg.BakOldPacker", "dump errBuf: %s", new Object[] { str });
    return str;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, short paramShort1, short paramShort2, int paramInt2, byte[] paramArrayOfByte2)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localByteArrayOutputStream.write(paramArrayOfByte1);
      localByteArrayOutputStream.write(n.eg(paramInt1));
      localByteArrayOutputStream.write(new byte[] { (byte)(paramShort1 >> 8 & 0xFF), (byte)(paramShort1 & 0xFF) });
      localByteArrayOutputStream.write(new byte[] { (byte)(paramShort2 >> 8 & 0xFF), (byte)(paramShort2 & 0xFF) });
      localByteArrayOutputStream.write(n.eg(paramInt2));
      localByteArrayOutputStream.write(n.eg(0));
      localByteArrayOutputStream.write(paramArrayOfByte2);
      paramArrayOfByte1 = new CRC32();
      paramArrayOfByte1.update(localByteArrayOutputStream.toByteArray());
      long l = paramArrayOfByte1.getValue();
      return (int)l;
    }
    catch (IOException paramArrayOfByte1)
    {
      y.printErrStackTrace("MicroMsg.BakOldPacker", paramArrayOfByte1, "", new Object[0]);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b
 * JD-Core Version:    0.7.0.1
 */