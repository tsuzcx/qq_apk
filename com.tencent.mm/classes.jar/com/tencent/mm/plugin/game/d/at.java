package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class at
  extends com.tencent.mm.bv.a
{
  public String npR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111589);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npR != null) {
        paramVarArgs.e(1, this.npR);
      }
      AppMethodBeat.o(111589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npR == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = e.a.a.b.b.a.f(1, this.npR) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(111589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111589);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        at localat = (at)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111589);
          return -1;
        }
        localat.npR = locala.CLY.readString();
        AppMethodBeat.o(111589);
        return 0;
      }
      AppMethodBeat.o(111589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.at
 * JD-Core Version:    0.7.0.1
 */