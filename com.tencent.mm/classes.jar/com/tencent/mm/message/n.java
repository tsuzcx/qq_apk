package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public String nUq;
  public int nUr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116409);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nUq != null) {
        paramVarArgs.g(1, this.nUq);
      }
      paramVarArgs.bS(2, this.nUr);
      AppMethodBeat.o(116409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nUq == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.nUq) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.nUr);
      AppMethodBeat.o(116409);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116409);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116409);
          return -1;
        case 1: 
          localn.nUq = locala.ajGk.readString();
          AppMethodBeat.o(116409);
          return 0;
        }
        localn.nUr = locala.ajGk.aar();
        AppMethodBeat.o(116409);
        return 0;
      }
      AppMethodBeat.o(116409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.message.n
 * JD-Core Version:    0.7.0.1
 */