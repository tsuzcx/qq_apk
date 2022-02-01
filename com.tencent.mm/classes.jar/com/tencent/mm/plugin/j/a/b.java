package com.tencent.mm.plugin.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public String ePn;
  public String title;
  public String type;
  public int uJB;
  public String uJC;
  public String uJD;
  public String uJE;
  public String uJF;
  public String uJG;
  public String uJH;
  public String uJI;
  public String uJJ;
  public String uJK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(25280);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uJB);
      if (this.type != null) {
        paramVarArgs.d(2, this.type);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.uJC != null) {
        paramVarArgs.d(4, this.uJC);
      }
      if (this.uJD != null) {
        paramVarArgs.d(5, this.uJD);
      }
      if (this.uJE != null) {
        paramVarArgs.d(6, this.uJE);
      }
      if (this.uJF != null) {
        paramVarArgs.d(7, this.uJF);
      }
      if (this.uJG != null) {
        paramVarArgs.d(8, this.uJG);
      }
      if (this.uJH != null) {
        paramVarArgs.d(9, this.uJH);
      }
      if (this.uJI != null) {
        paramVarArgs.d(10, this.uJI);
      }
      if (this.ePn != null) {
        paramVarArgs.d(11, this.ePn);
      }
      if (this.uJJ != null) {
        paramVarArgs.d(12, this.uJJ);
      }
      if (this.uJK != null) {
        paramVarArgs.d(13, this.uJK);
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uJB) + 0;
      paramInt = i;
      if (this.type != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.type);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.uJC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uJC);
      }
      i = paramInt;
      if (this.uJD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uJD);
      }
      paramInt = i;
      if (this.uJE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uJE);
      }
      i = paramInt;
      if (this.uJF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.uJF);
      }
      paramInt = i;
      if (this.uJG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.uJG);
      }
      i = paramInt;
      if (this.uJH != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.uJH);
      }
      paramInt = i;
      if (this.uJI != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.uJI);
      }
      i = paramInt;
      if (this.ePn != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ePn);
      }
      paramInt = i;
      if (this.uJJ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uJJ);
      }
      i = paramInt;
      if (this.uJK != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.uJK);
      }
      AppMethodBeat.o(25280);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(25280);
        return -1;
      case 1: 
        localb.uJB = locala.NPN.zc();
        AppMethodBeat.o(25280);
        return 0;
      case 2: 
        localb.type = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 3: 
        localb.title = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 4: 
        localb.uJC = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 5: 
        localb.uJD = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 6: 
        localb.uJE = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 7: 
        localb.uJF = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 8: 
        localb.uJG = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 9: 
        localb.uJH = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 10: 
        localb.uJI = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 11: 
        localb.ePn = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 12: 
        localb.uJJ = locala.NPN.readString();
        AppMethodBeat.o(25280);
        return 0;
      }
      localb.uJK = locala.NPN.readString();
      AppMethodBeat.o(25280);
      return 0;
    }
    AppMethodBeat.o(25280);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.j.a.b
 * JD-Core Version:    0.7.0.1
 */