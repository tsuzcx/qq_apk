package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cf
  extends com.tencent.mm.bx.a
{
  public int key;
  public long mJI;
  public String onf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143730);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.key);
      if (this.onf != null) {
        paramVarArgs.g(2, this.onf);
      }
      paramVarArgs.bv(3, this.mJI);
      AppMethodBeat.o(143730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.key) + 0;
      paramInt = i;
      if (this.onf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.onf);
      }
      i = i.a.a.b.b.a.q(3, this.mJI);
      AppMethodBeat.o(143730);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143730);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cf localcf = (cf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143730);
        return -1;
      case 1: 
        localcf.key = locala.ajGk.aar();
        AppMethodBeat.o(143730);
        return 0;
      case 2: 
        localcf.onf = locala.ajGk.readString();
        AppMethodBeat.o(143730);
        return 0;
      }
      localcf.mJI = locala.ajGk.aaw();
      AppMethodBeat.o(143730);
      return 0;
    }
    AppMethodBeat.o(143730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.cf
 * JD-Core Version:    0.7.0.1
 */