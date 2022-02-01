package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public String dQx;
  public int pTI;
  public boolean pTt;
  public String qGB;
  public String yUK;
  public String yUL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200184);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.pTt);
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.qGB != null) {
        paramVarArgs.e(3, this.qGB);
      }
      paramVarArgs.aM(4, this.pTI);
      if (this.yUK != null) {
        paramVarArgs.e(5, this.yUK);
      }
      if (this.yUL != null) {
        paramVarArgs.e(6, this.yUL);
      }
      AppMethodBeat.o(200184);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.qGB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qGB);
      }
      i += g.a.a.b.b.a.bu(4, this.pTI);
      paramInt = i;
      if (this.yUK != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.yUK);
      }
      i = paramInt;
      if (this.yUL != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.yUL);
      }
      AppMethodBeat.o(200184);
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
      AppMethodBeat.o(200184);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(200184);
        return -1;
      case 1: 
        locall.pTt = locala.UbS.yZ();
        AppMethodBeat.o(200184);
        return 0;
      case 2: 
        locall.dQx = locala.UbS.readString();
        AppMethodBeat.o(200184);
        return 0;
      case 3: 
        locall.qGB = locala.UbS.readString();
        AppMethodBeat.o(200184);
        return 0;
      case 4: 
        locall.pTI = locala.UbS.zi();
        AppMethodBeat.o(200184);
        return 0;
      case 5: 
        locall.yUK = locala.UbS.readString();
        AppMethodBeat.o(200184);
        return 0;
      }
      locall.yUL = locala.UbS.readString();
      AppMethodBeat.o(200184);
      return 0;
    }
    AppMethodBeat.o(200184);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l
 * JD-Core Version:    0.7.0.1
 */