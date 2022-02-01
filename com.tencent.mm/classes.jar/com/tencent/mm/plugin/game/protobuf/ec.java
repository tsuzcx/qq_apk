package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ec
  extends com.tencent.mm.cd.a
{
  public String CNA;
  public int CNC;
  public int CRE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207288);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CRE);
      paramVarArgs.aY(2, this.CNC);
      if (this.CNA != null) {
        paramVarArgs.f(3, this.CNA);
      }
      AppMethodBeat.o(207288);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CRE) + 0 + g.a.a.b.b.a.bM(2, this.CNC);
      paramInt = i;
      if (this.CNA != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CNA);
      }
      AppMethodBeat.o(207288);
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
      AppMethodBeat.o(207288);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ec localec = (ec)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207288);
        return -1;
      case 1: 
        localec.CRE = locala.abFh.AK();
        AppMethodBeat.o(207288);
        return 0;
      case 2: 
        localec.CNC = locala.abFh.AK();
        AppMethodBeat.o(207288);
        return 0;
      }
      localec.CNA = locala.abFh.readString();
      AppMethodBeat.o(207288);
      return 0;
    }
    AppMethodBeat.o(207288);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ec
 * JD-Core Version:    0.7.0.1
 */