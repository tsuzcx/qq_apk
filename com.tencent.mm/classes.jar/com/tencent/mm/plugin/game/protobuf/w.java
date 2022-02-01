package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.cd.a
{
  public String CNQ;
  public String CNR;
  public String CNS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41720);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNQ != null) {
        paramVarArgs.f(1, this.CNQ);
      }
      if (this.CNR != null) {
        paramVarArgs.f(2, this.CNR);
      }
      if (this.CNS != null) {
        paramVarArgs.f(3, this.CNS);
      }
      AppMethodBeat.o(41720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNQ == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.CNQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNR != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CNR);
      }
      i = paramInt;
      if (this.CNS != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CNS);
      }
      AppMethodBeat.o(41720);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41720);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41720);
          return -1;
        case 1: 
          localw.CNQ = locala.abFh.readString();
          AppMethodBeat.o(41720);
          return 0;
        case 2: 
          localw.CNR = locala.abFh.readString();
          AppMethodBeat.o(41720);
          return 0;
        }
        localw.CNS = locala.abFh.readString();
        AppMethodBeat.o(41720);
        return 0;
      }
      AppMethodBeat.o(41720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.w
 * JD-Core Version:    0.7.0.1
 */