package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public String gKi;
  public int gKj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116409);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gKi != null) {
        paramVarArgs.d(1, this.gKi);
      }
      paramVarArgs.aR(2, this.gKj);
      AppMethodBeat.o(116409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gKi == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.gKi) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.gKj);
      AppMethodBeat.o(116409);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          localn.gKi = locala.KhF.readString();
          AppMethodBeat.o(116409);
          return 0;
        }
        localn.gKj = locala.KhF.xS();
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