package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.cd.a
{
  public boolean CNJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207199);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).co(1, this.CNJ);
      AppMethodBeat.o(207199);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      AppMethodBeat.o(207199);
      return paramInt + 1 + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207199);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      q localq = (q)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207199);
        return -1;
      }
      localq.CNJ = locala.abFh.AB();
      AppMethodBeat.o(207199);
      return 0;
    }
    AppMethodBeat.o(207199);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.q
 * JD-Core Version:    0.7.0.1
 */