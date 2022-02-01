package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a
{
  private static final int[] cHZ = { 1, 2, 3, 6 };
  private static final int[] cIa = { 48000, 44100, 32000 };
  private static final int[] cIb = { 24000, 22050, 16000 };
  private static final int[] cIc = { 2, 1, 2, 3, 3, 4, 4, 5 };
  private static final int[] cId = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
  private static final int[] cIe = { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };
  
  public static int QZ()
  {
    return 1536;
  }
  
  public static Format a(m paramm, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(91748);
    int i = paramm.readUnsignedByte();
    int k = cIa[((i & 0xC0) >> 6)];
    int m = paramm.readUnsignedByte();
    int j = cIc[((m & 0x38) >> 3)];
    i = j;
    if ((m & 0x4) != 0) {
      i = j + 1;
    }
    paramm = Format.a(paramString1, "audio/ac3", -1, -1, i, k, null, paramDrmInitData, paramString2);
    AppMethodBeat.o(91748);
    return paramm;
  }
  
  public static a a(l paraml)
  {
    int n = 1;
    AppMethodBeat.i(91750);
    int j = paraml.cTf;
    int k = paraml.cTg;
    paraml.hR(40);
    int i;
    label92:
    int i1;
    String str;
    if (paraml.hQ(5) == 16)
    {
      i = 1;
      paraml.setPosition(k + j * 8);
      if (i == 0) {
        break label191;
      }
      paraml.hR(21);
      m = (paraml.hQ(11) + 1) * 2;
      i = paraml.hQ(2);
      if (i != 3) {
        break label170;
      }
      i = cIb[paraml.hQ(2)];
      j = 6;
      k = j * 256;
      i1 = paraml.hQ(3);
      str = "audio/eac3";
      j = m;
      m = i1;
      label116:
      boolean bool = paraml.Sg();
      i1 = cIc[m];
      if (!bool) {
        break label285;
      }
    }
    label285:
    for (int m = n;; m = 0)
    {
      paraml = new a(str, m + i1, i, j, k, (byte)0);
      AppMethodBeat.o(91750);
      return paraml;
      i = 0;
      break;
      label170:
      j = paraml.hQ(2);
      j = cHZ[j];
      i = cIa[i];
      break label92;
      label191:
      paraml.hR(32);
      i = paraml.hQ(2);
      j = cd(i, paraml.hQ(6));
      paraml.hR(8);
      m = paraml.hQ(3);
      if (((m & 0x1) != 0) && (m != 1)) {
        paraml.hR(2);
      }
      if ((m & 0x4) != 0) {
        paraml.hR(2);
      }
      if (m == 2) {
        paraml.hR(2);
      }
      i = cIa[i];
      k = 1536;
      str = "audio/ac3";
      break label116;
    }
  }
  
  public static Format b(m paramm, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(91749);
    paramm.iH(2);
    int i = paramm.readUnsignedByte();
    int k = cIa[((i & 0xC0) >> 6)];
    int m = paramm.readUnsignedByte();
    int j = cIc[((m & 0xE) >> 1)];
    i = j;
    if ((m & 0x1) != 0) {
      i = j + 1;
    }
    paramm = Format.a(paramString1, "audio/eac3", -1, -1, i, k, null, paramDrmInitData, paramString2);
    AppMethodBeat.o(91749);
    return paramm;
  }
  
  public static int c(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(91752);
    if ((paramByteBuffer.get(paramByteBuffer.position() + 4) & 0xC0) >> 6 == 3) {}
    for (int i = 6;; i = cHZ[((paramByteBuffer.get(paramByteBuffer.position() + 4) & 0x30) >> 4)])
    {
      AppMethodBeat.o(91752);
      return i * 256;
    }
  }
  
  private static int cd(int paramInt1, int paramInt2)
  {
    int i = paramInt2 / 2;
    if ((paramInt1 < 0) || (paramInt1 >= cIa.length) || (paramInt2 < 0) || (i >= cIe.length)) {
      return -1;
    }
    paramInt1 = cIa[paramInt1];
    if (paramInt1 == 44100) {
      return (cIe[i] + paramInt2 % 2) * 2;
    }
    paramInt2 = cId[i];
    if (paramInt1 == 32000) {
      return paramInt2 * 6;
    }
    return paramInt2 * 4;
  }
  
  public static int r(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(91751);
    if (paramArrayOfByte.length < 5)
    {
      AppMethodBeat.o(91751);
      return -1;
    }
    int i = cd((paramArrayOfByte[4] & 0xC0) >> 6, paramArrayOfByte[4] & 0x3F);
    AppMethodBeat.o(91751);
    return i;
  }
  
  public static final class a
  {
    public final int cIf;
    public final int channelCount;
    public final String mimeType;
    public final int sampleCount;
    public final int sampleRate;
    
    private a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.mimeType = paramString;
      this.channelCount = paramInt1;
      this.sampleRate = paramInt2;
      this.cIf = paramInt3;
      this.sampleCount = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.a
 * JD-Core Version:    0.7.0.1
 */