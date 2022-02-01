package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.cd.a
{
  public int CMM;
  public int CMN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149405);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CMM);
      paramVarArgs.aY(2, this.CMN);
      AppMethodBeat.o(149405);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.CMM);
      int i = g.a.a.b.b.a.bM(2, this.CMN);
      AppMethodBeat.o(149405);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(149405);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149405);
        return -1;
      case 1: 
        localf.CMM = locala.abFh.AK();
        AppMethodBeat.o(149405);
        return 0;
      }
      localf.CMN = locala.abFh.AK();
      AppMethodBeat.o(149405);
      return 0;
    }
    AppMethodBeat.o(149405);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.f
 * JD-Core Version:    0.7.0.1
 */