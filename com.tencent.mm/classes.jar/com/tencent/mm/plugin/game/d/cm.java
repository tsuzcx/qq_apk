package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cm
  extends com.tencent.mm.bv.a
{
  public String npU;
  public String ntK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111650);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ntK != null) {
        paramVarArgs.e(1, this.ntK);
      }
      if (this.npU != null) {
        paramVarArgs.e(2, this.npU);
      }
      AppMethodBeat.o(111650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ntK == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.ntK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.npU != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.npU);
      }
      AppMethodBeat.o(111650);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111650);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cm localcm = (cm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111650);
          return -1;
        case 1: 
          localcm.ntK = locala.CLY.readString();
          AppMethodBeat.o(111650);
          return 0;
        }
        localcm.npU = locala.CLY.readString();
        AppMethodBeat.o(111650);
        return 0;
      }
      AppMethodBeat.o(111650);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cm
 * JD-Core Version:    0.7.0.1
 */