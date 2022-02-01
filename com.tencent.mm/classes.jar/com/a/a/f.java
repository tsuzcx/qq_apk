package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static final f ctJ;
  public static final f ctK;
  public static final f ctL;
  public static final f ctM;
  public static final f ctN;
  public static final f ctO;
  public static final f ctP;
  public static final f ctQ;
  public static final f ctR;
  a ctH;
  f.b ctI;
  
  static
  {
    AppMethodBeat.i(207767);
    ctJ = new f(null, null);
    ctK = new f(a.ctS, null);
    ctL = new f(a.ctX, f.b.cud);
    ctM = new f(a.ctT, f.b.cud);
    ctN = new f(a.cub, f.b.cud);
    ctO = new f(a.ctU, f.b.cud);
    ctP = new f(a.cua, f.b.cud);
    ctQ = new f(a.ctX, f.b.cue);
    ctR = new f(a.ctT, f.b.cue);
    AppMethodBeat.o(207767);
  }
  
  f(a parama, f.b paramb)
  {
    this.ctH = parama;
    this.ctI = paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207778);
    if (this == paramObject)
    {
      AppMethodBeat.o(207778);
      return true;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(207778);
      return false;
    }
    if (getClass() != paramObject.getClass())
    {
      AppMethodBeat.o(207778);
      return false;
    }
    paramObject = (f)paramObject;
    if ((this.ctH == paramObject.ctH) && (this.ctI == paramObject.ctI))
    {
      AppMethodBeat.o(207778);
      return true;
    }
    AppMethodBeat.o(207778);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207788);
    String str = this.ctH + " " + this.ctI;
    AppMethodBeat.o(207788);
    return str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(207683);
      ctS = new a("none", 0);
      ctT = new a("xMinYMin", 1);
      ctU = new a("xMidYMin", 2);
      ctV = new a("xMaxYMin", 3);
      ctW = new a("xMinYMid", 4);
      ctX = new a("xMidYMid", 5);
      ctY = new a("xMaxYMid", 6);
      ctZ = new a("xMinYMax", 7);
      cua = new a("xMidYMax", 8);
      cub = new a("xMaxYMax", 9);
      cuc = new a[] { ctS, ctT, ctU, ctV, ctW, ctX, ctY, ctZ, cua, cub };
      AppMethodBeat.o(207683);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.a.a.f
 * JD-Core Version:    0.7.0.1
 */