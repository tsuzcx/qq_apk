package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class ab
  extends com.tencent.mm.cd.a
{
  public long rVT;
  public int rVj;
  public b rVk;
  public int rWJ;
  public int rWK;
  public long rWL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22134);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rVj);
      if (this.rVk != null) {
        paramVarArgs.c(2, this.rVk);
      }
      paramVarArgs.aY(3, this.rWJ);
      paramVarArgs.aY(4, this.rWK);
      paramVarArgs.bm(5, this.rWL);
      paramVarArgs.bm(6, this.rVT);
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.rVj) + 0;
      paramInt = i;
      if (this.rVk != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.rVk);
      }
      i = g.a.a.b.b.a.bM(3, this.rWJ);
      int j = g.a.a.b.b.a.bM(4, this.rWK);
      int k = g.a.a.b.b.a.p(5, this.rWL);
      int m = g.a.a.b.b.a.p(6, this.rVT);
      AppMethodBeat.o(22134);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ab localab = (ab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22134);
        return -1;
      case 1: 
        localab.rVj = locala.abFh.AK();
        AppMethodBeat.o(22134);
        return 0;
      case 2: 
        localab.rVk = locala.abFh.iUw();
        AppMethodBeat.o(22134);
        return 0;
      case 3: 
        localab.rWJ = locala.abFh.AK();
        AppMethodBeat.o(22134);
        return 0;
      case 4: 
        localab.rWK = locala.abFh.AK();
        AppMethodBeat.o(22134);
        return 0;
      case 5: 
        localab.rWL = locala.abFh.AN();
        AppMethodBeat.o(22134);
        return 0;
      }
      localab.rVT = locala.abFh.AN();
      AppMethodBeat.o(22134);
      return 0;
    }
    AppMethodBeat.o(22134);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ab
 * JD-Core Version:    0.7.0.1
 */