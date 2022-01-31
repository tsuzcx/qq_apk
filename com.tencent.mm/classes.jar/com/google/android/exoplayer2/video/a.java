package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.i.d;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.k.b;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public final int aCh;
  public final List<byte[]> awM;
  public final float baX;
  public final int height;
  public final int width;
  
  private a(List<byte[]> paramList, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.awM = paramList;
    this.aCh = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.baX = paramFloat;
  }
  
  public static a K(m paramm)
  {
    int j = 0;
    AppMethodBeat.i(95979);
    int k;
    try
    {
      paramm.en(4);
      k = (paramm.readUnsignedByte() & 0x3) + 1;
      if (k == 3)
      {
        paramm = new IllegalStateException();
        AppMethodBeat.o(95979);
        throw paramm;
      }
    }
    catch (ArrayIndexOutOfBoundsException paramm)
    {
      paramm = new o("Error parsing AVC config", paramm);
      AppMethodBeat.o(95979);
      throw paramm;
    }
    ArrayList localArrayList = new ArrayList();
    int m = paramm.readUnsignedByte() & 0x1F;
    int i = 0;
    while (i < m)
    {
      localArrayList.add(L(paramm));
      i += 1;
    }
    int n = paramm.readUnsignedByte();
    i = j;
    while (i < n)
    {
      localArrayList.add(L(paramm));
      i += 1;
    }
    float f = 1.0F;
    if (m > 0)
    {
      paramm = (byte[])localArrayList.get(0);
      paramm = k.k((byte[])localArrayList.get(0), k, paramm.length);
      i = paramm.width;
      j = paramm.height;
      f = paramm.baX;
    }
    for (;;)
    {
      paramm = new a(localArrayList, k, i, j, f);
      AppMethodBeat.o(95979);
      return paramm;
      i = -1;
      j = -1;
    }
  }
  
  private static byte[] L(m paramm)
  {
    AppMethodBeat.i(95980);
    int i = paramm.readUnsignedShort();
    int j = paramm.position;
    paramm.en(i);
    paramm = d.j(paramm.data, j, i);
    AppMethodBeat.o(95980);
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.video.a
 * JD-Core Version:    0.7.0.1
 */