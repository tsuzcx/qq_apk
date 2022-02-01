package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static final f aPB;
  public static final f aPC;
  public static final f aPD;
  public static final f aPE;
  public static final f aPF;
  public static final f aPG;
  public static final f aPH;
  public static final f aPI;
  public static final f aPJ;
  f.b aPA;
  a aPz;
  
  static
  {
    AppMethodBeat.i(206472);
    aPB = new f(null, null);
    aPC = new f(a.aPK, null);
    aPD = new f(a.aPP, f.b.aPV);
    aPE = new f(a.aPL, f.b.aPV);
    aPF = new f(a.aPT, f.b.aPV);
    aPG = new f(a.aPM, f.b.aPV);
    aPH = new f(a.aPS, f.b.aPV);
    aPI = new f(a.aPP, f.b.aPW);
    aPJ = new f(a.aPL, f.b.aPW);
    AppMethodBeat.o(206472);
  }
  
  f(a parama, f.b paramb)
  {
    this.aPz = parama;
    this.aPA = paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206470);
    if (this == paramObject)
    {
      AppMethodBeat.o(206470);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(206470);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(206470);
      return false;
    }
    paramObject = (f)paramObject;
    if ((this.aPz == paramObject.aPz) && (this.aPA == paramObject.aPA))
    {
      AppMethodBeat.o(206470);
      return true;
    }
    AppMethodBeat.o(206470);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206471);
    String str = this.aPz + " " + this.aPA;
    AppMethodBeat.o(206471);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(206466);
      aPK = new a("none", 0);
      aPL = new a("xMinYMin", 1);
      aPM = new a("xMidYMin", 2);
      aPN = new a("xMaxYMin", 3);
      aPO = new a("xMinYMid", 4);
      aPP = new a("xMidYMid", 5);
      aPQ = new a("xMaxYMid", 6);
      aPR = new a("xMinYMax", 7);
      aPS = new a("xMidYMax", 8);
      aPT = new a("xMaxYMax", 9);
      aPU = new a[] { aPK, aPL, aPM, aPN, aPO, aPP, aPQ, aPR, aPS, aPT };
      AppMethodBeat.o(206466);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.a.a.f
 * JD-Core Version:    0.7.0.1
 */