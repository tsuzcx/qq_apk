package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public int dvJ;
  public int hpi;
  public int hpj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150799);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dvJ);
      paramVarArgs.aR(2, this.hpi);
      paramVarArgs.aR(3, this.hpj);
      AppMethodBeat.o(150799);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.dvJ);
      int i = f.a.a.b.b.a.bA(2, this.hpi);
      int j = f.a.a.b.b.a.bA(3, this.hpj);
      AppMethodBeat.o(150799);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(150799);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(150799);
        return -1;
      case 1: 
        localg.dvJ = locala.KhF.xS();
        AppMethodBeat.o(150799);
        return 0;
      case 2: 
        localg.hpi = locala.KhF.xS();
        AppMethodBeat.o(150799);
        return 0;
      }
      localg.hpj = locala.KhF.xS();
      AppMethodBeat.o(150799);
      return 0;
    }
    AppMethodBeat.o(150799);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.g
 * JD-Core Version:    0.7.0.1
 */