package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.i;
import java.nio.ByteBuffer;

public final class h
{
  private static final int[] axG = { 1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8 };
  private static final int[] axH = { -1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1 };
  private static final int[] axI = { 64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680 };
  
  public static Format a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    paramArrayOfByte = new i(paramArrayOfByte);
    paramArrayOfByte.dy(60);
    int i = paramArrayOfByte.dz(6);
    int k = axG[i];
    i = paramArrayOfByte.dz(4);
    int m = axH[i];
    i = paramArrayOfByte.dz(5);
    if (i >= axI.length)
    {
      i = -1;
      paramArrayOfByte.dy(10);
      if (paramArrayOfByte.dz(2) <= 0) {
        break label109;
      }
    }
    label109:
    for (int j = 1;; j = 0)
    {
      return Format.a(paramString1, "audio/vnd.dts", i, -1, k + j, m, null, null, paramString2);
      i = axI[i] * 1000 / 2;
      break;
    }
  }
  
  public static int d(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.get(i + 4);
    return (((paramByteBuffer.get(i + 5) & 0xFC) >> 2 | (j & 0x1) << 6) + 1) * 32;
  }
  
  public static int g(byte[] paramArrayOfByte)
  {
    return (((paramArrayOfByte[4] & 0x1) << 6 | (paramArrayOfByte[5] & 0xFC) >> 2) + 1) * 32;
  }
  
  public static int h(byte[] paramArrayOfByte)
  {
    return ((paramArrayOfByte[5] & 0x2) << 12 | (paramArrayOfByte[6] & 0xFF) << 4 | (paramArrayOfByte[7] & 0xF0) >> 4) + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.h
 * JD-Core Version:    0.7.0.1
 */