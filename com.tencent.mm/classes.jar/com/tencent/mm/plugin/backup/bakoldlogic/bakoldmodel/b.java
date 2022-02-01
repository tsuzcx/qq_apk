package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public final class b
{
  public static int a(byte[] paramArrayOfByte1, int paramInt1, short paramShort1, short paramShort2, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21809);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localByteArrayOutputStream.write(paramArrayOfByte1);
      localByteArrayOutputStream.write(o.hr(paramInt1));
      localByteArrayOutputStream.write(new byte[] { (byte)(paramShort1 >> 8 & 0xFF), (byte)(paramShort1 & 0xFF) });
      localByteArrayOutputStream.write(new byte[] { (byte)(paramShort2 >> 8 & 0xFF), (byte)(paramShort2 & 0xFF) });
      localByteArrayOutputStream.write(o.hr(paramInt2));
      localByteArrayOutputStream.write(o.hr(0));
      localByteArrayOutputStream.write(paramArrayOfByte2);
      paramArrayOfByte1 = new CRC32();
      paramArrayOfByte1.update(localByteArrayOutputStream.toByteArray());
      long l = paramArrayOfByte1.getValue();
      paramInt1 = (int)l;
      AppMethodBeat.o(21809);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte1)
    {
      ad.printErrStackTrace("MicroMsg.BakOldPacker", paramArrayOfByte1, "", new Object[0]);
      AppMethodBeat.o(21809);
    }
    return 0;
  }
  
  public static String aD(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21810);
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
    ad.e("MicroMsg.BakOldPacker", "dump errBuf: %s", new Object[] { str });
    AppMethodBeat.o(21810);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b
 * JD-Core Version:    0.7.0.1
 */