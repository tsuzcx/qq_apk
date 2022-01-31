package com.google.b.c.a;

import com.google.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class k
{
  static final k[] bjy;
  private static k[] bjz;
  private final boolean bjA;
  final int bjB;
  final int bjC;
  public final int bjD;
  public final int bjE;
  private final int bjF;
  private final int bjG;
  final int bjH;
  
  static
  {
    AppMethodBeat.i(57312);
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
    bjy = arrayOfk;
    bjz = arrayOfk;
    AppMethodBeat.o(57312);
  }
  
  private k(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt1, paramInt2);
  }
  
  k(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.bjA = paramBoolean;
    this.bjB = paramInt1;
    this.bjC = paramInt2;
    this.bjD = paramInt3;
    this.bjE = paramInt4;
    this.bjF = paramInt5;
    this.bjG = paramInt6;
    this.bjH = paramInt7;
  }
  
  public static k a(int paramInt, l paraml, b paramb1, b paramb2)
  {
    AppMethodBeat.i(57304);
    k[] arrayOfk = bjz;
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      k localk = arrayOfk[i];
      if (((paraml != l.bjJ) || (!localk.bjA)) && ((paraml != l.bjK) || (localk.bjA)) && ((paramb1 == null) || ((localk.sO() >= paramb1.width) && (localk.sP() >= paramb1.height))) && ((paramb2 == null) || ((localk.sO() <= paramb2.width) && (localk.sP() <= paramb2.height))) && (paramInt <= localk.bjB))
      {
        AppMethodBeat.o(57304);
        return localk;
      }
      i += 1;
    }
    paraml = new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(57304);
    throw paraml;
  }
  
  private int sK()
  {
    AppMethodBeat.i(57305);
    switch (this.bjF)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot handle this number of data regions");
      AppMethodBeat.o(57305);
      throw localIllegalStateException;
    case 1: 
      AppMethodBeat.o(57305);
      return 1;
    case 2: 
    case 4: 
      AppMethodBeat.o(57305);
      return 2;
    case 16: 
      AppMethodBeat.o(57305);
      return 4;
    }
    AppMethodBeat.o(57305);
    return 6;
  }
  
  private int sL()
  {
    AppMethodBeat.i(57306);
    switch (this.bjF)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot handle this number of data regions");
      AppMethodBeat.o(57306);
      throw localIllegalStateException;
    case 1: 
    case 2: 
      AppMethodBeat.o(57306);
      return 1;
    case 4: 
      AppMethodBeat.o(57306);
      return 2;
    case 16: 
      AppMethodBeat.o(57306);
      return 4;
    }
    AppMethodBeat.o(57306);
    return 6;
  }
  
  public int ff(int paramInt)
  {
    return this.bjG;
  }
  
  public int sD()
  {
    return this.bjB / this.bjG;
  }
  
  public final int sM()
  {
    AppMethodBeat.i(57307);
    int i = sK();
    int j = this.bjD;
    AppMethodBeat.o(57307);
    return i * j;
  }
  
  public final int sN()
  {
    AppMethodBeat.i(57308);
    int i = sL();
    int j = this.bjE;
    AppMethodBeat.o(57308);
    return i * j;
  }
  
  public final int sO()
  {
    AppMethodBeat.i(57309);
    int i = sM();
    int j = sK();
    AppMethodBeat.o(57309);
    return i + (j << 1);
  }
  
  public final int sP()
  {
    AppMethodBeat.i(57310);
    int i = sN();
    int j = sL();
    AppMethodBeat.o(57310);
    return i + (j << 1);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57311);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.bjA) {}
    for (String str = "Rectangular Symbol:";; str = "Square Symbol:")
    {
      str = str + " data region " + this.bjD + 'x' + this.bjE + ", symbol size " + sO() + 'x' + sP() + ", symbol data size " + sM() + 'x' + sN() + ", codewords " + this.bjB + '+' + this.bjC;
      AppMethodBeat.o(57311);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.b.c.a.k
 * JD-Core Version:    0.7.0.1
 */