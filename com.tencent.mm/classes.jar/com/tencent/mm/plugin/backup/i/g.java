package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class g
  extends com.tencent.mm.bv.a
{
  public String jJs;
  public int jJt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18050);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJs == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(18050);
        throw paramVarArgs;
      }
      if (this.jJs != null) {
        paramVarArgs.e(1, this.jJs);
      }
      paramVarArgs.aO(2, this.jJt);
      AppMethodBeat.o(18050);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJs == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJs) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.jJt);
      AppMethodBeat.o(18050);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jJs == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(18050);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18050);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(18050);
          return -1;
        case 1: 
          localg.jJs = locala.CLY.readString();
          AppMethodBeat.o(18050);
          return 0;
        }
        localg.jJt = locala.CLY.sl();
        AppMethodBeat.o(18050);
        return 0;
      }
      AppMethodBeat.o(18050);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.g
 * JD-Core Version:    0.7.0.1
 */