package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends com.tencent.mm.cd.a
{
  public String CNP;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207279);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.vhq != null) {
        paramVarArgs.f(1, this.vhq);
      }
      if (this.CNP != null) {
        paramVarArgs.f(2, this.CNP);
      }
      AppMethodBeat.o(207279);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhq == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.vhq) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CNP != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CNP);
      }
      AppMethodBeat.o(207279);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207279);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207279);
          return -1;
        case 1: 
          localv.vhq = locala.abFh.readString();
          AppMethodBeat.o(207279);
          return 0;
        }
        localv.CNP = locala.abFh.readString();
        AppMethodBeat.o(207279);
        return 0;
      }
      AppMethodBeat.o(207279);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.v
 * JD-Core Version:    0.7.0.1
 */