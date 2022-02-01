package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ab
  extends com.tencent.mm.bw.a
{
  public long oTV;
  public int oTl;
  public b oTm;
  public int oUK;
  public int oUL;
  public long oUM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22134);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oTl);
      if (this.oTm != null) {
        paramVarArgs.c(2, this.oTm);
      }
      paramVarArgs.aM(3, this.oUK);
      paramVarArgs.aM(4, this.oUL);
      paramVarArgs.bb(5, this.oUM);
      paramVarArgs.bb(6, this.oTV);
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oTl) + 0;
      paramInt = i;
      if (this.oTm != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.oTm);
      }
      i = g.a.a.b.b.a.bu(3, this.oUK);
      int j = g.a.a.b.b.a.bu(4, this.oUL);
      int k = g.a.a.b.b.a.r(5, this.oUM);
      int m = g.a.a.b.b.a.r(6, this.oTV);
      AppMethodBeat.o(22134);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
        localab.oTl = locala.UbS.zi();
        AppMethodBeat.o(22134);
        return 0;
      case 2: 
        localab.oTm = locala.UbS.hPo();
        AppMethodBeat.o(22134);
        return 0;
      case 3: 
        localab.oUK = locala.UbS.zi();
        AppMethodBeat.o(22134);
        return 0;
      case 4: 
        localab.oUL = locala.UbS.zi();
        AppMethodBeat.o(22134);
        return 0;
      case 5: 
        localab.oUM = locala.UbS.zl();
        AppMethodBeat.o(22134);
        return 0;
      }
      localab.oTV = locala.UbS.zl();
      AppMethodBeat.o(22134);
      return 0;
    }
    AppMethodBeat.o(22134);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ab
 * JD-Core Version:    0.7.0.1
 */