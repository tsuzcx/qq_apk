package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class h
{
  private static final int[] bgw = { 1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8 };
  private static final int[] bgx = { -1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1 };
  private static final int[] bgy = { 64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680 };
  
  public static Format a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    AppMethodBeat.i(91805);
    paramArrayOfByte = new l(paramArrayOfByte);
    paramArrayOfByte.et(60);
    int i = paramArrayOfByte.es(6);
    int k = bgw[i];
    i = paramArrayOfByte.es(4);
    int m = bgx[i];
    i = paramArrayOfByte.es(5);
    if (i >= bgy.length)
    {
      i = -1;
      paramArrayOfByte.et(10);
      if (paramArrayOfByte.es(2) <= 0) {
        break label121;
      }
    }
    label121:
    for (int j = 1;; j = 0)
    {
      paramArrayOfByte = Format.a(paramString1, "audio/vnd.dts", i, -1, k + j, m, null, null, paramString2);
      AppMethodBeat.o(91805);
      return paramArrayOfByte;
      i = bgy[i] * 1000 / 2;
      break;
    }
  }
  
  public static int g(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(91806);
    int j = paramByteBuffer.position();
    int i = paramByteBuffer.get(j + 4);
    j = paramByteBuffer.get(j + 5);
    AppMethodBeat.o(91806);
    return (((j & 0xFC) >> 2 | (i & 0x1) << 6) + 1) * 32;
  }
  
  public static int o(byte[] paramArrayOfByte)
  {
    return (((paramArrayOfByte[4] & 0x1) << 6 | (paramArrayOfByte[5] & 0xFC) >> 2) + 1) * 32;
  }
  
  public static int p(byte[] paramArrayOfByte)
  {
    return ((paramArrayOfByte[5] & 0x2) << 12 | (paramArrayOfByte[6] & 0xFF) << 4 | (paramArrayOfByte[7] & 0xF0) >> 4) + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.h
 * JD-Core Version:    0.7.0.1
 */