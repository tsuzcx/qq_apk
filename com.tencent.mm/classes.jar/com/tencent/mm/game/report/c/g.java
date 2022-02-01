package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.cd.a
{
  public String jUo;
  public boolean jUp;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199116);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jUo != null) {
        paramVarArgs.f(1, this.jUo);
      }
      paramVarArgs.bm(2, this.seq);
      paramVarArgs.co(3, this.jUp);
      AppMethodBeat.o(199116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jUo == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = g.a.a.b.b.a.g(1, this.jUo) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.seq);
      int j = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(199116);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199116);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199116);
          return -1;
        case 1: 
          localg.jUo = locala.abFh.readString();
          AppMethodBeat.o(199116);
          return 0;
        case 2: 
          localg.seq = locala.abFh.AN();
          AppMethodBeat.o(199116);
          return 0;
        }
        localg.jUp = locala.abFh.AB();
        AppMethodBeat.o(199116);
        return 0;
      }
      AppMethodBeat.o(199116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.game.report.c.g
 * JD-Core Version:    0.7.0.1
 */