package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class g
  extends com.tencent.mm.bv.a
{
  public String nqr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116992);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqr == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppStoreUrl");
        AppMethodBeat.o(116992);
        throw paramVarArgs;
      }
      if (this.nqr != null) {
        paramVarArgs.e(1, this.nqr);
      }
      AppMethodBeat.o(116992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqr == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = e.a.a.b.b.a.f(1, this.nqr) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(116992);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nqr == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppStoreUrl");
          AppMethodBeat.o(116992);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116992);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116992);
          return -1;
        }
        localg.nqr = locala.CLY.readString();
        AppMethodBeat.o(116992);
        return 0;
      }
      AppMethodBeat.o(116992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.g
 * JD-Core Version:    0.7.0.1
 */