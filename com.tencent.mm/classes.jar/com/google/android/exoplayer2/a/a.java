package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class a
{
  private static final int[] aya = { 1, 2, 3, 6 };
  private static final int[] ayb = { 48000, 44100, 32000 };
  private static final int[] ayc = { 24000, 22050, 16000 };
  private static final int[] ayd = { 2, 1, 2, 3, 3, 4, 4, 5 };
  private static final int[] aye = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
  private static final int[] ayf = { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };
  
  public static Format a(m paramm, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(94638);
    int i = paramm.readUnsignedByte();
    int k = ayb[((i & 0xC0) >> 6)];
    int m = paramm.readUnsignedByte();
    int j = ayd[((m & 0x38) >> 3)];
    i = j;
    if ((m & 0x4) != 0) {
      i = j + 1;
    }
    paramm = Format.a(paramString1, "audio/ac3", -1, -1, i, k, null, paramDrmInitData, paramString2);
    AppMethodBeat.o(94638);
    return paramm;
  }
  
  public static a.a a(l paraml)
  {
    int n = 1;
    AppMethodBeat.i(94640);
    int j = paraml.aJn;
    int k = paraml.aJo;
    paraml.dE(40);
    int i;
    label92:
    int i1;
    String str;
    if (paraml.dD(5) == 16)
    {
      i = 1;
      paraml.setPosition(k + j * 8);
      if (i == 0) {
        break label191;
      }
      paraml.dE(21);
      m = (paraml.dD(11) + 1) * 2;
      i = paraml.dD(2);
      if (i != 3) {
        break label170;
      }
      i = ayc[paraml.dD(2)];
      j = 6;
      k = j * 256;
      i1 = paraml.dD(3);
      str = "audio/eac3";
      j = m;
      m = i1;
      label116:
      boolean bool = paraml.oj();
      i1 = ayd[m];
      if (!bool) {
        break label285;
      }
    }
    label285:
    for (int m = n;; m = 0)
    {
      paraml = new a.a(str, m + i1, i, j, k, (byte)0);
      AppMethodBeat.o(94640);
      return paraml;
      i = 0;
      break;
      label170:
      j = paraml.dD(2);
      j = aya[j];
      i = ayb[i];
      break label92;
      label191:
      paraml.dE(32);
      i = paraml.dD(2);
      j = aV(i, paraml.dD(6));
      paraml.dE(8);
      m = paraml.dD(3);
      if (((m & 0x1) != 0) && (m != 1)) {
        paraml.dE(2);
      }
      if ((m & 0x4) != 0) {
        paraml.dE(2);
      }
      if (m == 2) {
        paraml.dE(2);
      }
      i = ayb[i];
      k = 1536;
      str = "audio/ac3";
      break label116;
    }
  }
  
  private static int aV(int paramInt1, int paramInt2)
  {
    int i = paramInt2 / 2;
    if ((paramInt1 < 0) || (paramInt1 >= ayb.length) || (paramInt2 < 0) || (i >= ayf.length)) {
      return -1;
    }
    paramInt1 = ayb[paramInt1];
    if (paramInt1 == 44100) {
      return (ayf[i] + paramInt2 % 2) * 2;
    }
    paramInt2 = aye[i];
    if (paramInt1 == 32000) {
      return paramInt2 * 6;
    }
    return paramInt2 * 4;
  }
  
  public static int b(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(94642);
    if ((paramByteBuffer.get(paramByteBuffer.position() + 4) & 0xC0) >> 6 == 3) {}
    for (int i = 6;; i = aya[((paramByteBuffer.get(paramByteBuffer.position() + 4) & 0x30) >> 4)])
    {
      AppMethodBeat.o(94642);
      return i * 256;
    }
  }
  
  public static Format b(m paramm, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(94639);
    paramm.en(2);
    int i = paramm.readUnsignedByte();
    int k = ayb[((i & 0xC0) >> 6)];
    int m = paramm.readUnsignedByte();
    int j = ayd[((m & 0xE) >> 1)];
    i = j;
    if ((m & 0x1) != 0) {
      i = j + 1;
    }
    paramm = Format.a(paramString1, "audio/eac3", -1, -1, i, k, null, paramDrmInitData, paramString2);
    AppMethodBeat.o(94639);
    return paramm;
  }
  
  public static int i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94641);
    if (paramArrayOfByte.length < 5)
    {
      AppMethodBeat.o(94641);
      return -1;
    }
    int i = aV((paramArrayOfByte[4] & 0xC0) >> 6, paramArrayOfByte[4] & 0x3F);
    AppMethodBeat.o(94641);
    return i;
  }
  
  public static int nh()
  {
    return 1536;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.a
 * JD-Core Version:    0.7.0.1
 */