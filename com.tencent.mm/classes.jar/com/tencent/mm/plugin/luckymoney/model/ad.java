package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad
  extends com.tencent.mm.bw.a
{
  public String userName;
  public String yVk;
  public String yWD;
  public String yWE;
  public String yWF;
  public String yWG;
  public String yWH;
  public String yWI;
  public long yWo;
  public String yWp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91258);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.yWD != null) {
        paramVarArgs.e(1, this.yWD);
      }
      if (this.yWE != null) {
        paramVarArgs.e(2, this.yWE);
      }
      paramVarArgs.bb(3, this.yWo);
      if (this.yWp != null) {
        paramVarArgs.e(4, this.yWp);
      }
      if (this.yWF != null) {
        paramVarArgs.e(5, this.yWF);
      }
      if (this.yVk != null) {
        paramVarArgs.e(6, this.yVk);
      }
      if (this.yWG != null) {
        paramVarArgs.e(7, this.yWG);
      }
      if (this.userName != null) {
        paramVarArgs.e(8, this.userName);
      }
      if (this.yWH != null) {
        paramVarArgs.e(9, this.yWH);
      }
      if (this.yWI != null) {
        paramVarArgs.e(10, this.yWI);
      }
      AppMethodBeat.o(91258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yWD == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = g.a.a.b.b.a.f(1, this.yWD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yWE != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.yWE);
      }
      i += g.a.a.b.b.a.r(3, this.yWo);
      paramInt = i;
      if (this.yWp != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.yWp);
      }
      i = paramInt;
      if (this.yWF != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.yWF);
      }
      paramInt = i;
      if (this.yVk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.yVk);
      }
      i = paramInt;
      if (this.yWG != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.yWG);
      }
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.userName);
      }
      i = paramInt;
      if (this.yWH != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.yWH);
      }
      paramInt = i;
      if (this.yWI != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.yWI);
      }
      AppMethodBeat.o(91258);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91258);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91258);
          return -1;
        case 1: 
          localad.yWD = locala.UbS.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 2: 
          localad.yWE = locala.UbS.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 3: 
          localad.yWo = locala.UbS.zl();
          AppMethodBeat.o(91258);
          return 0;
        case 4: 
          localad.yWp = locala.UbS.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 5: 
          localad.yWF = locala.UbS.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 6: 
          localad.yVk = locala.UbS.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 7: 
          localad.yWG = locala.UbS.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 8: 
          localad.userName = locala.UbS.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 9: 
          localad.yWH = locala.UbS.readString();
          AppMethodBeat.o(91258);
          return 0;
        }
        localad.yWI = locala.UbS.readString();
        AppMethodBeat.o(91258);
        return 0;
      }
      AppMethodBeat.o(91258);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ad
 * JD-Core Version:    0.7.0.1
 */