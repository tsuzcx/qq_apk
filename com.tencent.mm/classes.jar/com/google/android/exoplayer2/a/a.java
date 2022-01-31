package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import java.nio.ByteBuffer;

public final class a
{
  private static final int[] avK = { 1, 2, 3, 6 };
  private static final int[] avL = { 48000, 44100, 32000 };
  private static final int[] avM = { 24000, 22050, 16000 };
  private static final int[] avN = { 2, 1, 2, 3, 3, 4, 4, 5 };
  private static final int[] avO = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
  private static final int[] avP = { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };
  
  public static Format a(j paramj, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    int i = paramj.readUnsignedByte();
    int k = avL[((i & 0xC0) >> 6)];
    int m = paramj.readUnsignedByte();
    int j = avN[((m & 0x38) >> 3)];
    i = j;
    if ((m & 0x4) != 0) {
      i = j + 1;
    }
    return Format.a(paramString1, "audio/ac3", -1, -1, i, k, null, paramDrmInitData, paramString2);
  }
  
  public static a.a a(i parami)
  {
    int n = 1;
    int j = parami.aSA;
    int k = parami.aSB;
    parami.dy(40);
    int i;
    int i1;
    label87:
    String str;
    if (parami.dz(5) == 16)
    {
      i = 1;
      parami.setPosition(k + j * 8);
      if (i == 0) {
        break label175;
      }
      parami.dy(21);
      i1 = (parami.dz(11) + 1) * 2;
      i = parami.dz(2);
      if (i != 3) {
        break label154;
      }
      i = avM[parami.dz(2)];
      j = 6;
      k = j * 256;
      m = parami.dz(3);
      str = "audio/eac3";
      j = i1;
      boolean bool = parami.ob();
      i1 = avN[m];
      if (!bool) {
        break label360;
      }
    }
    label154:
    label175:
    label360:
    for (int m = n;; m = 0)
    {
      return new a.a(str, m + i1, i, j, k, (byte)0);
      i = 0;
      break;
      j = parami.dz(2);
      j = avK[j];
      i = avL[i];
      break label87;
      parami.dy(32);
      j = parami.dz(2);
      k = parami.dz(6);
      m = k / 2;
      if ((j < 0) || (j >= avL.length) || (k < 0) || (m >= avP.length)) {
        i = -1;
      }
      for (;;)
      {
        parami.dy(8);
        m = parami.dz(3);
        if (((m & 0x1) != 0) && (m != 1)) {
          parami.dy(2);
        }
        if ((m & 0x4) != 0) {
          parami.dy(2);
        }
        if (m == 2) {
          parami.dy(2);
        }
        i1 = avL[j];
        k = 1536;
        j = i;
        str = "audio/ac3";
        i = i1;
        break;
        i = avL[j];
        if (i == 44100)
        {
          i = (k % 2 + avP[m]) * 2;
        }
        else
        {
          k = avO[m];
          if (i == 32000) {
            i = k * 6;
          } else {
            i = k * 4;
          }
        }
      }
    }
  }
  
  public static int b(ByteBuffer paramByteBuffer)
  {
    if ((paramByteBuffer.get(paramByteBuffer.position() + 4) & 0xC0) >> 6 == 3) {}
    for (int i = 6;; i = avK[((paramByteBuffer.get(paramByteBuffer.position() + 4) & 0x30) >> 4)]) {
      return i * 256;
    }
  }
  
  public static Format b(j paramj, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    paramj.dB(2);
    int i = paramj.readUnsignedByte();
    int k = avL[((i & 0xC0) >> 6)];
    int m = paramj.readUnsignedByte();
    int j = avN[((m & 0xE) >> 1)];
    i = j;
    if ((m & 0x1) != 0) {
      i = j + 1;
    }
    return Format.a(paramString1, "audio/eac3", -1, -1, i, k, null, paramDrmInitData, paramString2);
  }
  
  public static int kY()
  {
    return 1536;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.a
 * JD-Core Version:    0.7.0.1
 */