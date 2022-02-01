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
  f.b aPH;
  
  static
  {
    AppMethodBeat.i(212976);
    aPI = new f(null, null);
    aPJ = new f(a.aPR, null);
    aPK = new f(a.aPW, f.b.aQc);
    aPL = new f(a.aPS, f.b.aQc);
    aPM = new f(a.aQa, f.b.aQc);
    aPN = new f(a.aPT, f.b.aQc);
    aPO = new f(a.aPZ, f.b.aQc);
    aPP = new f(a.aPW, f.b.aQd);
    aPQ = new f(a.aPS, f.b.aQd);
    AppMethodBeat.o(212976);
  }
  
  f(a parama, f.b paramb)
  {
    this.aPG = parama;
    this.aPH = paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(212974);
    if (this == paramObject)
    {
      AppMethodBeat.o(212974);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(212974);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(212974);
      return false;
    }
    paramObject = (f)paramObject;
    if ((this.aPG == paramObject.aPG) && (this.aPH == paramObject.aPH))
    {
      AppMethodBeat.o(212974);
      return true;
    }
    AppMethodBeat.o(212974);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212975);
    String str = this.aPG + " " + this.aPH;
    AppMethodBeat.o(212975);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(212970);
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
      AppMethodBeat.o(212970);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.a.a.f
 * JD-Core Version:    0.7.0.1
 */