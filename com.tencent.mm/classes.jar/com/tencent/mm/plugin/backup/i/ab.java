package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class ab
  extends com.tencent.mm.bv.a
{
  public long jJR;
  public int jJg;
  public b jJh;
  public int jKH;
  public int jKI;
  public long jKJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18077);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jJg);
      if (this.jJh != null) {
        paramVarArgs.c(2, this.jJh);
      }
      paramVarArgs.aO(3, this.jKH);
      paramVarArgs.aO(4, this.jKI);
      paramVarArgs.am(5, this.jKJ);
      paramVarArgs.am(6, this.jJR);
      AppMethodBeat.o(18077);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.jJg) + 0;
      paramInt = i;
      if (this.jJh != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.jJh);
      }
      i = e.a.a.b.b.a.bl(3, this.jKH);
      int j = e.a.a.b.b.a.bl(4, this.jKI);
      int k = e.a.a.b.b.a.p(5, this.jKJ);
      int m = e.a.a.b.b.a.p(6, this.jJR);
      AppMethodBeat.o(18077);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(18077);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ab localab = (ab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(18077);
        return -1;
      case 1: 
        localab.jJg = locala.CLY.sl();
        AppMethodBeat.o(18077);
        return 0;
      case 2: 
        localab.jJh = locala.CLY.eqS();
        AppMethodBeat.o(18077);
        return 0;
      case 3: 
        localab.jKH = locala.CLY.sl();
        AppMethodBeat.o(18077);
        return 0;
      case 4: 
        localab.jKI = locala.CLY.sl();
        AppMethodBeat.o(18077);
        return 0;
      case 5: 
        localab.jKJ = locala.CLY.sm();
        AppMethodBeat.o(18077);
        return 0;
      }
      localab.jJR = locala.CLY.sm();
      AppMethodBeat.o(18077);
      return 0;
    }
    AppMethodBeat.o(18077);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ab
 * JD-Core Version:    0.7.0.1
 */