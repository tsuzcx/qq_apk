package com.tencent.mm.plugin.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String exO;
  public int tGO;
  public String tGP;
  public String tGQ;
  public String tGR;
  public String tGS;
  public String tGT;
  public String tGU;
  public String tGV;
  public String tGW;
  public String tGX;
  public String title;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(25280);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.tGO);
      if (this.type != null) {
        paramVarArgs.d(2, this.type);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.tGP != null) {
        paramVarArgs.d(4, this.tGP);
      }
      if (this.tGQ != null) {
        paramVarArgs.d(5, this.tGQ);
      }
      if (this.tGR != null) {
        paramVarArgs.d(6, this.tGR);
      }
      if (this.tGS != null) {
        paramVarArgs.d(7, this.tGS);
      }
      if (this.tGT != null) {
        paramVarArgs.d(8, this.tGT);
      }
      if (this.tGU != null) {
        paramVarArgs.d(9, this.tGU);
      }
      if (this.tGV != null) {
        paramVarArgs.d(10, this.tGV);
      }
      if (this.exO != null) {
        paramVarArgs.d(11, this.exO);
      }
      if (this.tGW != null) {
        paramVarArgs.d(12, this.tGW);
      }
      if (this.tGX != null) {
        paramVarArgs.d(13, this.tGX);
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.tGO) + 0;
      paramInt = i;
      if (this.type != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.type);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.tGP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tGP);
      }
      i = paramInt;
      if (this.tGQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tGQ);
      }
      paramInt = i;
      if (this.tGR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tGR);
      }
      i = paramInt;
      if (this.tGS != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.tGS);
      }
      paramInt = i;
      if (this.tGT != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.tGT);
      }
      i = paramInt;
      if (this.tGU != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.tGU);
      }
      paramInt = i;
      if (this.tGV != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.tGV);
      }
      i = paramInt;
      if (this.exO != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.exO);
      }
      paramInt = i;
      if (this.tGW != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.tGW);
      }
      i = paramInt;
      if (this.tGX != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.tGX);
      }
      AppMethodBeat.o(25280);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localb.tGO = locala.LVo.xF();
        AppMethodBeat.o(25280);
        return 0;
      case 2: 
        localb.type = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 3: 
        localb.title = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 4: 
        localb.tGP = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 5: 
        localb.tGQ = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 6: 
        localb.tGR = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 7: 
        localb.tGS = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 8: 
        localb.tGT = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 9: 
        localb.tGU = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 10: 
        localb.tGV = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 11: 
        localb.exO = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 12: 
        localb.tGW = locala.LVo.readString();
        AppMethodBeat.o(25280);
        return 0;
      }
      localb.tGX = locala.LVo.readString();
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