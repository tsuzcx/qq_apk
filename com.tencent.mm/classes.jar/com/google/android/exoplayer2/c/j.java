package com.google.android.exoplayer2.c;

public final class j
{
  private static final String[] aBC = { "audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg" };
  private static final int[] aBD = { 44100, 48000, 32000 };
  private static final int[] aBE = { 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448 };
  private static final int[] aBF = { 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256 };
  private static final int[] aBG = { 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384 };
  private static final int[] aBH = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320 };
  private static final int[] aBI = { 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 };
  public int aBJ;
  public int ayg;
  public int bitrate;
  public int channels;
  public String mimeType;
  public int sampleRate;
  public int version;
  
  public static boolean a(int paramInt, j paramj)
  {
    if ((paramInt & 0xFFE00000) != -2097152) {
      return false;
    }
    int i1 = paramInt >>> 19 & 0x3;
    if (i1 == 1) {
      return false;
    }
    int i2 = paramInt >>> 17 & 0x3;
    if (i2 == 0) {
      return false;
    }
    int i = paramInt >>> 12 & 0xF;
    if ((i == 0) || (i == 15)) {
      return false;
    }
    int j = paramInt >>> 10 & 0x3;
    if (j == 3) {
      return false;
    }
    j = aBD[j];
    if (i1 == 2) {
      j /= 2;
    }
    label270:
    label335:
    label343:
    for (;;)
    {
      int n = paramInt >>> 9 & 0x1;
      int m;
      int k;
      if (i2 == 3)
      {
        if (i1 == 3) {}
        for (i = aBE[(i - 1)];; i = aBF[(i - 1)])
        {
          m = (i * 12000 / j + n) * 4;
          n = 384;
          k = i;
          i = n;
          String str = aBC[(3 - i2)];
          if ((paramInt >> 6 & 0x3) != 3) {
            break label335;
          }
          paramInt = 1;
          paramj.version = i1;
          paramj.mimeType = str;
          paramj.ayg = m;
          paramj.sampleRate = j;
          paramj.channels = paramInt;
          paramj.bitrate = (k * 1000);
          paramj.aBJ = i;
          return true;
          if (i1 != 0) {
            break label343;
          }
          j /= 4;
          break;
        }
      }
      if (i1 == 3) {
        if (i2 == 2)
        {
          i = aBG[(i - 1)];
          label255:
          m = 1152;
          k = i;
          i = m;
        }
      }
      for (;;)
      {
        m = 144000;
        m = m * k / j + n;
        break;
        i = aBH[(i - 1)];
        break label255;
        k = aBI[(i - 1)];
        if (i2 == 1) {
          i = 576;
        }
        for (;;)
        {
          if (i2 == 1)
          {
            m = 72000;
            break label270;
            i = 1152;
            continue;
            paramInt = 2;
            break;
          }
        }
      }
    }
  }
  
  public static int dn(int paramInt)
  {
    if ((paramInt & 0xFFE00000) != -2097152) {}
    int j;
    int k;
    int n;
    do
    {
      do
      {
        do
        {
          do
          {
            return -1;
            j = paramInt >>> 19 & 0x3;
          } while (j == 1);
          k = paramInt >>> 17 & 0x3;
        } while (k == 0);
        n = paramInt >>> 12 & 0xF;
      } while ((n == 0) || (n == 15));
      i = paramInt >>> 10 & 0x3;
    } while (i == 3);
    int i = aBD[i];
    if (j == 2) {
      i /= 2;
    }
    label226:
    for (;;)
    {
      int m = paramInt >>> 9 & 0x1;
      if (k == 3)
      {
        if (j == 3) {}
        for (paramInt = aBE[(n - 1)];; paramInt = aBF[(n - 1)])
        {
          return (paramInt * 12000 / i + m) * 4;
          if (j != 0) {
            break label226;
          }
          i /= 4;
          break;
        }
      }
      if (j == 3) {
        if (k == 2) {
          paramInt = aBG[(n - 1)];
        }
      }
      while (j == 3)
      {
        return 144000 * paramInt / i + m;
        paramInt = aBH[(n - 1)];
        continue;
        paramInt = aBI[(n - 1)];
      }
      if (k == 1) {}
      for (j = 72000;; j = 144000) {
        return j * paramInt / i + m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.c.j
 * JD-Core Version:    0.7.0.1
 */