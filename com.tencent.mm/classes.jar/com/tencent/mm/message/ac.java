package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac
  extends com.tencent.mm.bx.a
{
  public int style;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(233931);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).bS(1, this.style);
      AppMethodBeat.o(233931);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.style);
      AppMethodBeat.o(233931);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(233931);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(233931);
        return -1;
      }
      localac.style = locala.ajGk.aar();
      AppMethodBeat.o(233931);
      return 0;
    }
    AppMethodBeat.o(233931);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.message.ac
 * JD-Core Version:    0.7.0.1
 */