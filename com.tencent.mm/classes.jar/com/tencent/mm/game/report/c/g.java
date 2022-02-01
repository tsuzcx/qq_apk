package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public String muG;
  public boolean muH;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(240734);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.muG != null) {
        paramVarArgs.g(1, this.muG);
      }
      paramVarArgs.bv(2, this.seq);
      paramVarArgs.di(3, this.muH);
      AppMethodBeat.o(240734);
      return 0;
    }
    if (paramInt == 1) {
      if (this.muG == null) {
        break label298;
      }
    }
    label298:
    for (paramInt = i.a.a.b.b.a.h(1, this.muG) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.seq);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(240734);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(240734);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(240734);
          return -1;
        case 1: 
          localg.muG = locala.ajGk.readString();
          AppMethodBeat.o(240734);
          return 0;
        case 2: 
          localg.seq = locala.ajGk.aaw();
          AppMethodBeat.o(240734);
          return 0;
        }
        localg.muH = locala.ajGk.aai();
        AppMethodBeat.o(240734);
        return 0;
      }
      AppMethodBeat.o(240734);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.report.c.g
 * JD-Core Version:    0.7.0.1
 */