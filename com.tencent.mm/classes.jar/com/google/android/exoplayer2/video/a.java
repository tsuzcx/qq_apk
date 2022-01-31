package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.h.b;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.o;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public final int aBL;
  public final float aSt;
  public final List<byte[]> auu;
  public final int height;
  public final int width;
  
  private a(List<byte[]> paramList, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.auu = paramList;
    this.aBL = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.aSt = paramFloat;
  }
  
  public static a m(j paramj)
  {
    int j = 0;
    int k;
    try
    {
      paramj.dB(4);
      k = (paramj.readUnsignedByte() & 0x3) + 1;
      if (k == 3) {
        throw new IllegalStateException();
      }
    }
    catch (ArrayIndexOutOfBoundsException paramj)
    {
      throw new o("Error parsing AVC config", paramj);
    }
    ArrayList localArrayList = new ArrayList();
    int m = paramj.readUnsignedByte() & 0x1F;
    int i = 0;
    while (i < m)
    {
      localArrayList.add(n(paramj));
      i += 1;
    }
    int n = paramj.readUnsignedByte();
    i = j;
    while (i < n)
    {
      localArrayList.add(n(paramj));
      i += 1;
    }
    float f = 1.0F;
    if (m > 0)
    {
      paramj = (byte[])localArrayList.get(0);
      paramj = h.j((byte[])localArrayList.get(0), k, paramj.length);
      i = paramj.width;
      j = paramj.height;
      f = paramj.aSt;
    }
    for (;;)
    {
      paramj = new a(localArrayList, k, i, j, f);
      return paramj;
      i = -1;
      j = -1;
    }
  }
  
  private static byte[] n(j paramj)
  {
    int i = paramj.readUnsignedShort();
    int j = paramj.position;
    paramj.dB(i);
    return c.i(paramj.data, j, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.video.a
 * JD-Core Version:    0.7.0.1
 */