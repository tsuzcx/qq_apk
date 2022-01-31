package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bv.a
{
  public String kVV;
  public String kVW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35515);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kVV != null) {
        paramVarArgs.e(1, this.kVV);
      }
      if (this.kVW != null) {
        paramVarArgs.e(2, this.kVW);
      }
      AppMethodBeat.o(35515);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kVV == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.kVV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kVW != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.kVW);
      }
      AppMethodBeat.o(35515);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(35515);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(35515);
          return -1;
        case 1: 
          localg.kVV = locala.CLY.readString();
          AppMethodBeat.o(35515);
          return 0;
        }
        localg.kVW = locala.CLY.readString();
        AppMethodBeat.o(35515);
        return 0;
      }
      AppMethodBeat.o(35515);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */