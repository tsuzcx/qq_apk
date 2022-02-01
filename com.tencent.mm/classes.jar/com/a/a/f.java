package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static final f aPI;
  public static final f aPJ;
  public static final f aPK;
  public static final f aPL;
  public static final f aPM;
  public static final f aPN;
  public static final f aPO;
  public static final f aPP;
  public static final f aPQ;
  a aPG;
  b aPH;
  
  static
  {
    AppMethodBeat.i(214745);
    aPI = new f(null, null);
    aPJ = new f(a.aPR, null);
    aPK = new f(a.aPW, b.aQc);
    aPL = new f(a.aPS, b.aQc);
    aPM = new f(a.aQa, b.aQc);
    aPN = new f(a.aPT, b.aQc);
    aPO = new f(a.aPZ, b.aQc);
    aPP = new f(a.aPW, b.aQd);
    aPQ = new f(a.aPS, b.aQd);
    AppMethodBeat.o(214745);
  }
  
  f(a parama, b paramb)
  {
    this.aPG = parama;
    this.aPH = paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(214743);
    if (this == paramObject)
    {
      AppMethodBeat.o(214743);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(214743);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(214743);
      return false;
    }
    paramObject = (f)paramObject;
    if ((this.aPG == paramObject.aPG) && (this.aPH == paramObject.aPH))
    {
      AppMethodBeat.o(214743);
      return true;
    }
    AppMethodBeat.o(214743);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(214744);
    String str = this.aPG + " " + this.aPH;
    AppMethodBeat.o(214744);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(214739);
      aPR = new a("none", 0);
      aPS = new a("xMinYMin", 1);
      aPT = new a("xMidYMin", 2);
      aPU = new a("xMaxYMin", 3);
      aPV = new a("xMinYMid", 4);
      aPW = new a("xMidYMid", 5);
      aPX = new a("xMaxYMid", 6);
      aPY = new a("xMinYMax", 7);
      aPZ = new a("xMidYMax", 8);
      aQa = new a("xMaxYMax", 9);
      aQb = new a[] { aPR, aPS, aPT, aPU, aPV, aPW, aPX, aPY, aPZ, aQa };
      AppMethodBeat.o(214739);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(214742);
      aQc = new b("meet", 0);
      aQd = new b("slice", 1);
      aQe = new b[] { aQc, aQd };
      AppMethodBeat.o(214742);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.a.a.f
 * JD-Core Version:    0.7.0.1
 */