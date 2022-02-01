package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public String hiq;
  public boolean hir;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190329);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hiq != null) {
        paramVarArgs.e(1, this.hiq);
      }
      paramVarArgs.bb(2, this.seq);
      paramVarArgs.cc(3, this.hir);
      AppMethodBeat.o(190329);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hiq == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = g.a.a.b.b.a.f(1, this.hiq) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.seq);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(190329);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(190329);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(190329);
          return -1;
        case 1: 
          localg.hiq = locala.UbS.readString();
          AppMethodBeat.o(190329);
          return 0;
        case 2: 
          localg.seq = locala.UbS.zl();
          AppMethodBeat.o(190329);
          return 0;
        }
        localg.hir = locala.UbS.yZ();
        AppMethodBeat.o(190329);
        return 0;
      }
      AppMethodBeat.o(190329);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.report.c.g
 * JD-Core Version:    0.7.0.1
 */