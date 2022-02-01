package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bx.a
{
  public int hCT;
  public int hCU;
  public String hCV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.hCT);
      paramVarArgs.aS(2, this.hCU);
      if (this.hCV != null) {
        paramVarArgs.d(3, this.hCV);
      }
      AppMethodBeat.o(116410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.hCT) + 0 + f.a.a.b.b.a.bz(2, this.hCU);
      paramInt = i;
      if (this.hCV != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.hCV);
      }
      AppMethodBeat.o(116410);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(116410);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116410);
        return -1;
      case 1: 
        localo.hCT = locala.NPN.zc();
        AppMethodBeat.o(116410);
        return 0;
      case 2: 
        localo.hCU = locala.NPN.zc();
        AppMethodBeat.o(116410);
        return 0;
      }
      localo.hCV = locala.NPN.readString();
      AppMethodBeat.o(116410);
      return 0;
    }
    AppMethodBeat.o(116410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.o
 * JD-Core Version:    0.7.0.1
 */