package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bw.a
{
  public int dYn;
  public int jgU;
  public int jgV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150799);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.dYn);
      paramVarArgs.aM(2, this.jgU);
      paramVarArgs.aM(3, this.jgV);
      AppMethodBeat.o(150799);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.dYn);
      int i = g.a.a.b.b.a.bu(2, this.jgU);
      int j = g.a.a.b.b.a.bu(3, this.jgV);
      AppMethodBeat.o(150799);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(150799);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(150799);
        return -1;
      case 1: 
        localh.dYn = locala.UbS.zi();
        AppMethodBeat.o(150799);
        return 0;
      case 2: 
        localh.jgU = locala.UbS.zi();
        AppMethodBeat.o(150799);
        return 0;
      }
      localh.jgV = locala.UbS.zi();
      AppMethodBeat.o(150799);
      return 0;
    }
    AppMethodBeat.o(150799);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bb.h
 * JD-Core Version:    0.7.0.1
 */