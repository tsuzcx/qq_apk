package com.tencent.mm.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bx.a
{
  public long lPP;
  public long lPQ;
  public long lPR;
  public long lPS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42663);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.lPP);
      paramVarArgs.bv(2, this.lPQ);
      paramVarArgs.bv(3, this.lPR);
      paramVarArgs.bv(4, this.lPS);
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.lPP);
      int i = i.a.a.b.b.a.q(2, this.lPQ);
      int j = i.a.a.b.b.a.q(3, this.lPR);
      int k = i.a.a.b.b.a.q(4, this.lPS);
      AppMethodBeat.o(42663);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(42663);
        return -1;
      case 1: 
        localc.lPP = locala.ajGk.aaw();
        AppMethodBeat.o(42663);
        return 0;
      case 2: 
        localc.lPQ = locala.ajGk.aaw();
        AppMethodBeat.o(42663);
        return 0;
      case 3: 
        localc.lPR = locala.ajGk.aaw();
        AppMethodBeat.o(42663);
        return 0;
      }
      localc.lPS = locala.ajGk.aaw();
      AppMethodBeat.o(42663);
      return 0;
    }
    AppMethodBeat.o(42663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.a.a.c
 * JD-Core Version:    0.7.0.1
 */