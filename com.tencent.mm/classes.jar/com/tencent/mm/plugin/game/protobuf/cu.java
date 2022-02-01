package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cu
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public int CNg;
  public int CQK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207140);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CQK);
      paramVarArgs.aY(2, this.CNg);
      if (this.CMD != null) {
        paramVarArgs.f(3, this.CMD);
      }
      AppMethodBeat.o(207140);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CQK) + 0 + g.a.a.b.b.a.bM(2, this.CNg);
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CMD);
      }
      AppMethodBeat.o(207140);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207140);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cu localcu = (cu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207140);
        return -1;
      case 1: 
        localcu.CQK = locala.abFh.AK();
        AppMethodBeat.o(207140);
        return 0;
      case 2: 
        localcu.CNg = locala.abFh.AK();
        AppMethodBeat.o(207140);
        return 0;
      }
      localcu.CMD = locala.abFh.readString();
      AppMethodBeat.o(207140);
      return 0;
    }
    AppMethodBeat.o(207140);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cu
 * JD-Core Version:    0.7.0.1
 */