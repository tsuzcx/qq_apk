package com.tencent.mm.cf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bx.a
{
  public int IjN = -1;
  public int IjO;
  public int dfG;
  public int nhS;
  public int nhT;
  public int nhU;
  public int size;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nhS);
      paramVarArgs.aS(2, this.nhT);
      paramVarArgs.aS(3, this.nhU);
      paramVarArgs.aS(41, this.IjN);
      paramVarArgs.aS(5, this.IjO);
      paramVarArgs.aS(6, this.dfG);
      paramVarArgs.aS(7, this.size);
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.nhS);
      int i = f.a.a.b.b.a.bz(2, this.nhT);
      int j = f.a.a.b.b.a.bz(3, this.nhU);
      int k = f.a.a.b.b.a.bz(41, this.IjN);
      int m = f.a.a.b.b.a.bz(5, this.IjO);
      int n = f.a.a.b.b.a.bz(6, this.dfG);
      int i1 = f.a.a.b.b.a.bz(7, this.size);
      AppMethodBeat.o(104918);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104918);
        return -1;
      case 1: 
        localc.nhS = locala.NPN.zc();
        AppMethodBeat.o(104918);
        return 0;
      case 2: 
        localc.nhT = locala.NPN.zc();
        AppMethodBeat.o(104918);
        return 0;
      case 3: 
        localc.nhU = locala.NPN.zc();
        AppMethodBeat.o(104918);
        return 0;
      case 41: 
        localc.IjN = locala.NPN.zc();
        AppMethodBeat.o(104918);
        return 0;
      case 5: 
        localc.IjO = locala.NPN.zc();
        AppMethodBeat.o(104918);
        return 0;
      case 6: 
        localc.dfG = locala.NPN.zc();
        AppMethodBeat.o(104918);
        return 0;
      }
      localc.size = locala.NPN.zc();
      AppMethodBeat.o(104918);
      return 0;
    }
    AppMethodBeat.o(104918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cf.c
 * JD-Core Version:    0.7.0.1
 */