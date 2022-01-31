package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bt
  extends com.tencent.mm.bv.a
{
  public long ePF;
  public String fnF;
  public int key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72614);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.key);
      if (this.fnF != null) {
        paramVarArgs.e(2, this.fnF);
      }
      paramVarArgs.am(3, this.ePF);
      AppMethodBeat.o(72614);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.key) + 0;
      paramInt = i;
      if (this.fnF != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fnF);
      }
      i = e.a.a.b.b.a.p(3, this.ePF);
      AppMethodBeat.o(72614);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72614);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bt localbt = (bt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72614);
        return -1;
      case 1: 
        localbt.key = locala.CLY.sl();
        AppMethodBeat.o(72614);
        return 0;
      case 2: 
        localbt.fnF = locala.CLY.readString();
        AppMethodBeat.o(72614);
        return 0;
      }
      localbt.ePF = locala.CLY.sm();
      AppMethodBeat.o(72614);
      return 0;
    }
    AppMethodBeat.o(72614);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.bt
 * JD-Core Version:    0.7.0.1
 */