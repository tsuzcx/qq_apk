package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ab
  extends com.tencent.mm.bv.a
{
  public String nrf;
  public String nrg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111566);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nrf != null) {
        paramVarArgs.e(1, this.nrf);
      }
      if (this.nrg != null) {
        paramVarArgs.e(2, this.nrg);
      }
      AppMethodBeat.o(111566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nrf == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.nrf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nrg != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.nrg);
      }
      AppMethodBeat.o(111566);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111566);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ab localab = (ab)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111566);
          return -1;
        case 1: 
          localab.nrf = locala.CLY.readString();
          AppMethodBeat.o(111566);
          return 0;
        }
        localab.nrg = locala.CLY.readString();
        AppMethodBeat.o(111566);
        return 0;
      }
      AppMethodBeat.o(111566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ab
 * JD-Core Version:    0.7.0.1
 */