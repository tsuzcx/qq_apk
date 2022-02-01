package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public String gvB;
  public boolean gvC;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214273);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gvB != null) {
        paramVarArgs.d(1, this.gvB);
      }
      paramVarArgs.aZ(2, this.seq);
      paramVarArgs.bC(3, this.gvC);
      AppMethodBeat.o(214273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gvB == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = f.a.a.b.b.a.e(1, this.gvB) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.seq);
      int j = f.a.a.b.b.a.amF(3);
      AppMethodBeat.o(214273);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(214273);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(214273);
          return -1;
        case 1: 
          localg.gvB = locala.OmT.readString();
          AppMethodBeat.o(214273);
          return 0;
        case 2: 
          localg.seq = locala.OmT.zd();
          AppMethodBeat.o(214273);
          return 0;
        }
        localg.gvC = locala.OmT.gvY();
        AppMethodBeat.o(214273);
        return 0;
      }
      AppMethodBeat.o(214273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.game.report.c.g
 * JD-Core Version:    0.7.0.1
 */