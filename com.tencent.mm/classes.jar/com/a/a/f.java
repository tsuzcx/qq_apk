package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static final f axU;
  public static final f axV;
  public static final f axW;
  public static final f axX;
  public static final f axY;
  public static final f axZ;
  public static final f aya;
  public static final f ayb;
  public static final f ayc;
  a axS;
  f.b axT;
  
  static
  {
    AppMethodBeat.i(201797);
    axU = new f(null, null);
    axV = new f(a.ayd, null);
    axW = new f(a.ayi, f.b.ayo);
    axX = new f(a.aye, f.b.ayo);
    axY = new f(a.aym, f.b.ayo);
    axZ = new f(a.ayf, f.b.ayo);
    aya = new f(a.ayl, f.b.ayo);
    ayb = new f(a.ayi, f.b.ayp);
    ayc = new f(a.aye, f.b.ayp);
    AppMethodBeat.o(201797);
  }
  
  f(a parama, f.b paramb)
  {
    this.axS = parama;
    this.axT = paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201792);
    if (this == paramObject)
    {
      AppMethodBeat.o(201792);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(201792);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(201792);
      return false;
    }
    paramObject = (f)paramObject;
    if ((this.axS == paramObject.axS) && (this.axT == paramObject.axT))
    {
      AppMethodBeat.o(201792);
      return true;
    }
    AppMethodBeat.o(201792);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201793);
    String str = this.axS + " " + this.axT;
    AppMethodBeat.o(201793);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(201781);
      ayd = new a("none", 0);
      aye = new a("xMinYMin", 1);
      ayf = new a("xMidYMin", 2);
      ayg = new a("xMaxYMin", 3);
      ayh = new a("xMinYMid", 4);
      ayi = new a("xMidYMid", 5);
      ayj = new a("xMaxYMid", 6);
      ayk = new a("xMinYMax", 7);
      ayl = new a("xMidYMax", 8);
      aym = new a("xMaxYMax", 9);
      ayn = new a[] { ayd, aye, ayf, ayg, ayh, ayi, ayj, ayk, ayl, aym };
      AppMethodBeat.o(201781);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.a.a.f
 * JD-Core Version:    0.7.0.1
 */