package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public int nCU;
  public com.tencent.mm.bx.b nCV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22102);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nCU);
      if (this.nCV != null) {
        paramVarArgs.c(2, this.nCV);
      }
      AppMethodBeat.o(22102);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nCU) + 0;
      paramInt = i;
      if (this.nCV != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.nCV);
      }
      AppMethodBeat.o(22102);
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
      AppMethodBeat.o(22102);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22102);
        return -1;
      case 1: 
        localb.nCU = locala.NPN.zc();
        AppMethodBeat.o(22102);
        return 0;
      }
      localb.nCV = locala.NPN.gxI();
      AppMethodBeat.o(22102);
      return 0;
    }
    AppMethodBeat.o(22102);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.b
 * JD-Core Version:    0.7.0.1
 */