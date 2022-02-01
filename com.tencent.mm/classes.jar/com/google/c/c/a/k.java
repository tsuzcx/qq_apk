package com.google.c.c.a;

import com.google.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class k
{
  static final k[] bLs;
  private static k[] bLt;
  private final int bLA;
  final int bLB;
  private final boolean bLu;
  final int bLv;
  final int bLw;
  public final int bLx;
  public final int bLy;
  private final int bLz;
  
  static
  {
    AppMethodBeat.i(12377);
    k[] arrayOfk = new k[30];
    arrayOfk[0] = new k(false, 3, 5, 8, 8, 1);
    arrayOfk[1] = new k(false, 5, 7, 10, 10, 1);
    arrayOfk[2] = new k(true, 5, 7, 16, 6, 1);
    arrayOfk[3] = new k(false, 8, 10, 12, 12, 1);
    arrayOfk[4] = new k(true, 10, 11, 14, 6, 2);
    arrayOfk[5] = new k(false, 12, 12, 14, 14, 1);
    arrayOfk[6] = new k(true, 16, 14, 24, 10, 1);
    arrayOfk[7] = new k(false, 18, 14, 16, 16, 1);
    arrayOfk[8] = new k(false, 22, 18, 18, 18, 1);
    arrayOfk[9] = new k(true, 22, 18, 16, 10, 2);
    arrayOfk[10] = new k(false, 30, 20, 20, 20, 1);
    arrayOfk[11] = new k(true, 32, 24, 16, 14, 2);
    arrayOfk[12] = new k(false, 36, 24, 22, 22, 1);
    arrayOfk[13] = new k(false, 44, 28, 24, 24, 1);
    arrayOfk[14] = new k(true, 49, 28, 22, 14, 2);
    arrayOfk[15] = new k(false, 62, 36, 14, 14, 4);
    arrayOfk[16] = new k(false, 86, 42, 16, 16, 4);
    arrayOfk[17] = new k(false, 114, 48, 18, 18, 4);
    arrayOfk[18] = new k(false, 144, 56, 20, 20, 4);
    arrayOfk[19] = new k(false, 174, 68, 22, 22, 4);
    arrayOfk[20] = new k(false, 204, 84, 24, 24, 4, 102, 42);
    arrayOfk[21] = new k(false, 280, 112, 14, 14, 16, 140, 56);
    arrayOfk[22] = new k(false, 368, 144, 16, 16, 16, 92, 36);
    arrayOfk[23] = new k(false, 456, 192, 18, 18, 16, 114, 48);
    arrayOfk[24] = new k(false, 576, 224, 20, 20, 16, 144, 56);
    arrayOfk[25] = new k(false, 696, 272, 22, 22, 16, 174, 68);
    arrayOfk[26] = new k(false, 816, 336, 24, 24, 16, 136, 56);
    arrayOfk[27] = new k(false, 1050, 408, 18, 18, 36, 175, 68);
    arrayOfk[28] = new k(false, 1304, 496, 20, 20, 36, 163, 62);
    arrayOfk[29] = new d();
    bLs = arrayOfk;
    bLt = arrayOfk;
    AppMethodBeat.o(12377);
  }
  
  private k(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt1, paramInt2);
  }
  
  k(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.bLu = paramBoolean;
    this.bLv = paramInt1;
    this.bLw = paramInt2;
    this.bLx = paramInt3;
    this.bLy = paramInt4;
    this.bLz = paramInt5;
    this.bLA = paramInt6;
    this.bLB = paramInt7;
  }
  
  public static k a(int paramInt, l paraml, b paramb1, b paramb2)
  {
    AppMethodBeat.i(12369);
    k[] arrayOfk = bLt;
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      k localk = arrayOfk[i];
      if (((paraml != l.bLD) || (!localk.bLu)) && ((paraml != l.bLE) || (localk.bLu)) && ((paramb1 == null) || ((localk.yv() >= paramb1.width) && (localk.yw() >= paramb1.height))) && ((paramb2 == null) || ((localk.yv() <= paramb2.width) && (localk.yw() <= paramb2.height))) && (paramInt <= localk.bLv))
      {
        AppMethodBeat.o(12369);
        return localk;
      }
      i += 1;
    }
    paraml = new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(12369);
    throw paraml;
  }
  
  private int yr()
  {
    AppMethodBeat.i(12370);
    switch (this.bLz)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot handle this number of data regions");
      AppMethodBeat.o(12370);
      throw localIllegalStateException;
    case 1: 
      AppMethodBeat.o(12370);
      return 1;
    case 2: 
    case 4: 
      AppMethodBeat.o(12370);
      return 2;
    case 16: 
      AppMethodBeat.o(12370);
      return 4;
    }
    AppMethodBeat.o(12370);
    return 6;
  }
  
  private int ys()
  {
    AppMethodBeat.i(12371);
    switch (this.bLz)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot handle this number of data regions");
      AppMethodBeat.o(12371);
      throw localIllegalStateException;
    case 1: 
    case 2: 
      AppMethodBeat.o(12371);
      return 1;
    case 4: 
      AppMethodBeat.o(12371);
      return 2;
    case 16: 
      AppMethodBeat.o(12371);
      return 4;
    }
    AppMethodBeat.o(12371);
    return 6;
  }
  
  public int gh(int paramInt)
  {
    return this.bLA;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12376);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.bLu) {}
    for (String str = "Rectangular Symbol:";; str = "Square Symbol:")
    {
      str = str + " data region " + this.bLx + 'x' + this.bLy + ", symbol size " + yv() + 'x' + yw() + ", symbol data size " + yt() + 'x' + yu() + ", codewords " + this.bLv + '+' + this.bLw;
      AppMethodBeat.o(12376);
      return str;
    }
  }
  
  public int yk()
  {
    return this.bLv / this.bLA;
  }
  
  public final int yt()
  {
    AppMethodBeat.i(12372);
    int i = yr();
    int j = this.bLx;
    AppMethodBeat.o(12372);
    return i * j;
  }
  
  public final int yu()
  {
    AppMethodBeat.i(12373);
    int i = ys();
    int j = this.bLy;
    AppMethodBeat.o(12373);
    return i * j;
  }
  
  public final int yv()
  {
    AppMethodBeat.i(12374);
    int i = yt();
    int j = yr();
    AppMethodBeat.o(12374);
    return i + (j << 1);
  }
  
  public final int yw()
  {
    AppMethodBeat.i(12375);
    int i = yu();
    int j = ys();
    AppMethodBeat.o(12375);
    return i + (j << 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.c.a.k
 * JD-Core Version:    0.7.0.1
 */