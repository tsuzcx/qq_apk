package com.tencent.mm.plugin.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String fuD;
  public String title;
  public String type;
  public int ynP;
  public String ynQ;
  public String ynR;
  public String ynS;
  public String ynT;
  public String ynU;
  public String ynV;
  public String ynW;
  public String ynX;
  public String ynY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(25280);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.ynP);
      if (this.type != null) {
        paramVarArgs.e(2, this.type);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.ynQ != null) {
        paramVarArgs.e(4, this.ynQ);
      }
      if (this.ynR != null) {
        paramVarArgs.e(5, this.ynR);
      }
      if (this.ynS != null) {
        paramVarArgs.e(6, this.ynS);
      }
      if (this.ynT != null) {
        paramVarArgs.e(7, this.ynT);
      }
      if (this.ynU != null) {
        paramVarArgs.e(8, this.ynU);
      }
      if (this.ynV != null) {
        paramVarArgs.e(9, this.ynV);
      }
      if (this.ynW != null) {
        paramVarArgs.e(10, this.ynW);
      }
      if (this.fuD != null) {
        paramVarArgs.e(11, this.fuD);
      }
      if (this.ynX != null) {
        paramVarArgs.e(12, this.ynX);
      }
      if (this.ynY != null) {
        paramVarArgs.e(13, this.ynY);
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.ynP) + 0;
      paramInt = i;
      if (this.type != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.type);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.title);
      }
      paramInt = i;
      if (this.ynQ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.ynQ);
      }
      i = paramInt;
      if (this.ynR != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.ynR);
      }
      paramInt = i;
      if (this.ynS != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.ynS);
      }
      i = paramInt;
      if (this.ynT != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.ynT);
      }
      paramInt = i;
      if (this.ynU != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.ynU);
      }
      i = paramInt;
      if (this.ynV != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.ynV);
      }
      paramInt = i;
      if (this.ynW != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.ynW);
      }
      i = paramInt;
      if (this.fuD != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.fuD);
      }
      paramInt = i;
      if (this.ynX != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.ynX);
      }
      i = paramInt;
      if (this.ynY != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.ynY);
      }
      AppMethodBeat.o(25280);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(25280);
        return -1;
      case 1: 
        localb.ynP = locala.UbS.zi();
        AppMethodBeat.o(25280);
        return 0;
      case 2: 
        localb.type = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 3: 
        localb.title = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 4: 
        localb.ynQ = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 5: 
        localb.ynR = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 6: 
        localb.ynS = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 7: 
        localb.ynT = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 8: 
        localb.ynU = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 9: 
        localb.ynV = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 10: 
        localb.ynW = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 11: 
        localb.fuD = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 12: 
        localb.ynX = locala.UbS.readString();
        AppMethodBeat.o(25280);
        return 0;
      }
      localb.ynY = locala.UbS.readString();
      AppMethodBeat.o(25280);
      return 0;
    }
    AppMethodBeat.o(25280);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.j.a.b
 * JD-Core Version:    0.7.0.1
 */