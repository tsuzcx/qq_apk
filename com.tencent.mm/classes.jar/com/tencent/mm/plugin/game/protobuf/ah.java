package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String CNM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41726);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNM != null) {
        paramVarArgs.f(1, this.CNM);
      }
      if (this.CMP != null) {
        paramVarArgs.f(2, this.CMP);
      }
      AppMethodBeat.o(41726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNM == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.CNM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CMP != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CMP);
      }
      AppMethodBeat.o(41726);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41726);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ah localah = (ah)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41726);
          return -1;
        case 1: 
          localah.CNM = locala.abFh.readString();
          AppMethodBeat.o(41726);
          return 0;
        }
        localah.CMP = locala.abFh.readString();
        AppMethodBeat.o(41726);
        return 0;
      }
      AppMethodBeat.o(41726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ah
 * JD-Core Version:    0.7.0.1
 */