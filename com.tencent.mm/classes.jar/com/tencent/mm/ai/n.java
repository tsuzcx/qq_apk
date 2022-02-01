package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public String hCR;
  public int hCS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116409);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hCR != null) {
        paramVarArgs.d(1, this.hCR);
      }
      paramVarArgs.aS(2, this.hCS);
      AppMethodBeat.o(116409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hCR == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.hCR) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.hCS);
      AppMethodBeat.o(116409);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116409);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116409);
          return -1;
        case 1: 
          localn.hCR = locala.NPN.readString();
          AppMethodBeat.o(116409);
          return 0;
        }
        localn.hCS = locala.NPN.zc();
        AppMethodBeat.o(116409);
        return 0;
      }
      AppMethodBeat.o(116409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.n
 * JD-Core Version:    0.7.0.1
 */