package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public int dFx;
  public int iiY;
  public int iiZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150799);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dFx);
      paramVarArgs.aS(2, this.iiY);
      paramVarArgs.aS(3, this.iiZ);
      AppMethodBeat.o(150799);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.dFx);
      int i = f.a.a.b.b.a.bz(2, this.iiY);
      int j = f.a.a.b.b.a.bz(3, this.iiZ);
      AppMethodBeat.o(150799);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        localg.dFx = locala.NPN.zc();
        AppMethodBeat.o(150799);
        return 0;
      case 2: 
        localg.iiY = locala.NPN.zc();
        AppMethodBeat.o(150799);
        return 0;
      }
      localg.iiZ = locala.NPN.zc();
      AppMethodBeat.o(150799);
      return 0;
    }
    AppMethodBeat.o(150799);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.g
 * JD-Core Version:    0.7.0.1
 */